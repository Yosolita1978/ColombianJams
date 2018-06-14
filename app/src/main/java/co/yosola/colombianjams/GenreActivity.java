package co.yosola.colombianjams;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GenreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        final Context context = this;


        //Set the text of the navigation text.
        TextView genreNavigation = (TextView) findViewById(R.id.text_navigation);
        String genreString = getResources().getString(R.string.genre);
        genreNavigation.setText(genreString);

        // Find navigation arrow
        ImageView backNavigation = (ImageView) findViewById(R.id.navigation_arrow);
        backNavigation.setImageResource(R.drawable.ic_arrow_back_black_24dp);
        backNavigation.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the All Songs View is clicked on.
            @Override
            public void onClick(View view) {
                Intent backtoMainIntent = new Intent(GenreActivity.this, MainActivity.class);
                startActivity(backtoMainIntent);
            }
        });

        //Start the allSong list
        AllSongsList songsOfColombia = AllSongsList.getAllSongs(context);

        //Start the Array of Strings with all the genres in the AllsongList

        ArrayList<String> genres = new ArrayList<String>(songsOfColombia.getTotalSongs());
        genres.add(songsOfColombia.getSongbyIndex(0).getSongGenre());
        genres.add(songsOfColombia.getSongbyIndex(1).getSongGenre());
        genres.add(songsOfColombia.getSongbyIndex(2).getSongGenre());
        genres.add(songsOfColombia.getSongbyIndex(3).getSongGenre());
        genres.add(songsOfColombia.getSongbyIndex(4).getSongGenre());

        //Start the Genre Adapter

        GenreAdapter genreadapter = new GenreAdapter(this, genres);

        ListView listView = findViewById(R.id.list_options);

        listView.setAdapter(genreadapter);
    }

}
