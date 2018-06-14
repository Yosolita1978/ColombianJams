package co.yosola.colombianjams;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        final Context context = this;


        //Set the text of the navigation text.
        TextView artistNavigation = (TextView) findViewById(R.id.text_navigation);
        String artistString = getResources().getString(R.string.artist);
        artistNavigation.setText(artistString);

        // Find navigation arrow
        ImageView backNavigation = (ImageView) findViewById(R.id.navigation_arrow);
        backNavigation.setImageResource(R.drawable.ic_arrow_back_black_24dp);
        backNavigation.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the All Songs View is clicked on.
            @Override
            public void onClick(View view) {
                Intent backtoMainIntent = new Intent(ArtistsActivity.this, MainActivity.class);
                startActivity(backtoMainIntent);
            }
        });

        //Start the allSong list
        AllSongsList songsOfColombia = AllSongsList.getAllSongs(context);

        //Start the Array of Strings with all the artist in the AllsongList

        ArrayList<String> artists = new ArrayList<String>(songsOfColombia.getTotalSongs());
        artists.add(songsOfColombia.getSongbyIndex(0).getSongArtist());
        artists.add(songsOfColombia.getSongbyIndex(1).getSongArtist());
        artists.add(songsOfColombia.getSongbyIndex(2).getSongArtist());
        artists.add(songsOfColombia.getSongbyIndex(3).getSongArtist());
        artists.add(songsOfColombia.getSongbyIndex(4).getSongArtist());


        //Start the Genre Adapter

        ArtistAdapter artistadapter = new ArtistAdapter(this, artists);

        ListView listView = findViewById(R.id.list_options);

        listView.setAdapter(artistadapter);
    }
}