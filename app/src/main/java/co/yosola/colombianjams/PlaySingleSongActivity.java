package co.yosola.colombianjams;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class PlaySingleSongActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();

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
        final Song currentSong = songsOfColombia.getSongbyIndex(value);

        //Start the current mediaplayer with the correct song
        mMediaPlayer = MediaPlayer.create(PlaySingleSongActivity.this, currentSong.getAudioResourceId());

        //SetUp the time of the current song
        TextView currentSongTime = findViewById(R.id.time_current_song);
        finalTime = mMediaPlayer.getDuration();
        currentSongTime.setText(String.format(Locale.US, "%d min:%d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                finalTime)))
        );

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
                int index = songsOfColombia.getSongIndex(currentSong);
                Intent previousIntent;
                if (index == 0) {
                    previousIntent = new Intent(PlaySingleSongActivity.this, MainActivity.class);
                } else {
                    index = index - 1;
                    previousIntent = new Intent(PlaySingleSongActivity.this, PlaySingleSongActivity.class);
                    previousIntent.putExtra("indexSongSelected", (index));
                }
                startActivity(previousIntent);
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
        currentPlay.setImageResource(R.drawable.ic_play_arrow_black_24dp);
        currentPlay.setOnClickListener(new View.OnClickListener() {
            boolean isPlaying = false;
            // The code in this method will be executed when the All Songs View is clicked on.
            @Override
            public void onClick(View view) {
                if(isPlaying){
                    isPlaying = false;
                    currentPlay.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    Toast.makeText(PlaySingleSongActivity.this, "You pause the song", Toast.LENGTH_SHORT).show();
                    mMediaPlayer.pause();
                } else {
                    isPlaying = true;
                    currentPlay.setImageResource(R.drawable.ic_pause_black_24dp);
                    Toast.makeText(PlaySingleSongActivity.this, "Playing the song", Toast.LENGTH_SHORT).show();
                    mMediaPlayer.start();
                    myHandler.postDelayed(UpdateSongTime,100);

                }
            }
        });

    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mMediaPlayer.getCurrentPosition();
            TextView playingSongTime = findViewById(R.id.playing_time);
            playingSongTime.setText(String.format(Locale.US,"Playing: %d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            myHandler.postDelayed(this, 100);
        }
    };
}
