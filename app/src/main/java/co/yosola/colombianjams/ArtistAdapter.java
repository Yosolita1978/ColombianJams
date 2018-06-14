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

public class ArtistAdapter extends ArrayAdapter {

    public ArtistAdapter(Context context, ArrayList<String> artist) {
        super(context, 0, artist);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_options, parent, false);
        }

        //Start the allSong list
        AllSongsList songsOfColombia = AllSongsList.getAllSongs(getContext());
        Song currentSong = songsOfColombia.getSongbyIndex(position);

        String[] artist = new String[songsOfColombia.getTotalSongs()];

        for(int i = 0; i < artist.length; i++) {
            TextView artistnameTextView = (TextView) listItemView.findViewById(R.id.text_list_options);
            artistnameTextView.setText(currentSong.getSongArtist().toString());
        }

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_list_options);
        // Set the ImageView to the image resource specified in the current Word
        imageView.setImageDrawable(currentSong.getImageResource());

        return listItemView;
    }
}

