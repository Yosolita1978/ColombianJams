package co.yosola.colombianjams;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaySingleSongActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playsong);

        final Context context = this;

        //Start the allSong list
        final AllSongsList songsOfColombia = AllSongsList.getAllSongs(context);

        //Grab the position of the current song with the intent
        int value = getIntent().getExtras().getInt("indexSongSelected");

        //Start the current Song
        Song currentSong = songsOfColombia.getSongbyIndex(value);

        //SetUp the name of the current song
        TextView currentSongName = findViewById(R.id.song_name_text);
        currentSongName.setText(currentSong.getSongName());

        //SetUp the name of the current song
        TextView currentArtistName = findViewById(R.id.artist_name_text);
        currentArtistName.setText(currentSong.getSongArtist());

        //SetUp the image of the current song
        ImageView currentImage = findViewById(R.id.song_image);
        currentImage.setImageDrawable(currentSong.getImageResource());

        //Set the text of the navigation text.
        TextView singleSongNavigation = (TextView) findViewById(R.id.text_navigation);
        String singleSongString = getResources().getString(R.string.playsong);
        singleSongNavigation.setText(singleSongString);

        // Find back navigation arrow
        ImageView backNavigation = (ImageView) findViewById(R.id.navigation_arrow);
        backNavigation.setImageResource(R.drawable.ic_arrow_back_black_24dp);
        backNavigation.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the All Songs View is clicked on.
            @Override
            public void onClick(View view) {
                Intent backtoMainIntent = new Intent(PlaySingleSongActivity.this, MainActivity.class);
                startActivity(backtoMainIntent);
            }
        });

        // Find forward navigation arrow
        ImageView forwardNavigation = (ImageView) findViewById(R.id.navigation_forward_arrow);
        forwardNavigation.setImageResource(R.drawable.ic_arrow_forward_black_24dp);
        forwardNavigation.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the View is clicked on.
            @Override
            public void onClick(View view) {
                //Set if there is a next Song
                Song nextSong = songsOfColombia.getNextSong();
                Intent nextIntent;
                if (nextSong == null) {
                    nextIntent = new Intent(PlaySingleSongActivity.this, MainActivity.class);

                } else {
                    nextIntent = new Intent(PlaySingleSongActivity.this, PlaySingleSongActivity.class);
                    nextIntent.putExtra("indexSongSelected", songsOfColombia.getSongIndex(nextSong));
                }
                startActivity(nextIntent);
            }
        });

        //SetUp the Play image of the current song
        final ImageView currentPlay = findViewById(R.id.play_current_song);
        currentPlay.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the All Songs View is clicked on.
            @Override
            public void onClick(View view) {
                currentPlay.setImageResource(R.drawable.ic_pause_black_24dp);
            }
        });

    }
}