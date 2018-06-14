package co.yosola.colombianjams;

import android.content.Context;
import android.content.Intent;
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

public class SongAdapter extends ArrayAdapter {

    public SongAdapter(Context context, ArrayList<Song> song) {
        super(context, 0, song);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }

        Song currentSong = (Song) getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.text_view_name);
        nameTextView.setText(currentSong.getSongName());

        TextView artistTextView = listItemView.findViewById(R.id.text_view_artist);
        artistTextView.setText(currentSong.getSongArtist());

        TextView genreTextView = listItemView.findViewById(R.id.text_view_genre);
        genreTextView.setText(currentSong.getSongGenre());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Set the ImageView to the image resource specified in the current Word
        imageView.setImageDrawable(currentSong.getImageResource());

        return listItemView;
    }
}