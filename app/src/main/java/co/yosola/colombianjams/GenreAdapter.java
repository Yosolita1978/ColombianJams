package co.yosola.colombianjams;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cristina on 6/12/18.
 */

public class GenreAdapter extends ArrayAdapter {


    public GenreAdapter(Context context, ArrayList<String> genres) {
        super(context, 0, genres);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_options, parent, false);
        }

        //Start the allSong list
        AllSongsList songsOfColombia = AllSongsList.getAllSongs(getContext());
        Song currentSong = songsOfColombia.getSongbyIndex(position);

        //Create the Array of Strings for the genres of all the songs. TO-DO: Create a method that check if there are repited genres
        String[] genres = new String[songsOfColombia.getTotalSongs()];

        for (int i = 0; i < genres.length; i++) {
            TextView genreTextView = (TextView) listItemView.findViewById(R.id.text_list_options);
            genreTextView.setText(currentSong.getSongGenre().toString());
        }

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_list_options);
        // Set the ImageView to the image resource specified in the current Word
        imageView.setImageDrawable(currentSong.getImageResource());

        return listItemView;
    }
}
