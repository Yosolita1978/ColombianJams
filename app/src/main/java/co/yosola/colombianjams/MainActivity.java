package co.yosola.colombianjams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Set the text of the navigation text.

        TextView home = (TextView)findViewById(R.id.text_navigation);
        String homeString = getResources().getString(R.string.home);
        home.setText(homeString);

        // Find the View that shows all the songs
        TextView allsongs = (TextView) findViewById(R.id.allsongs);

        // Set a click listener on that View
        allsongs.setOnClickListener(new View.OnClickListener() {

        // The code in this method will be executed when the All Songs View is clicked on.
            @Override
            public void onClick(View view) {
                Intent allsongsIntent = new Intent(MainActivity.this, AllSongsActivity.class);
                startActivity(allsongsIntent);
            }
        });


        // Find the button in front genre to show all the songs
        ImageView genreImg = (ImageView)findViewById(R.id.allsongs_imag);
        genreImg.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the All Songs View is clicked on.
            @Override
            public void onClick(View view) {
                Intent allsongsIntent = new Intent(MainActivity.this, AllSongsActivity.class);
                startActivity(allsongsIntent);
            }
        });

    }
}
