package co.yosola.colombianjams;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AllSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allsongs);


        //Set the text of the navigation text.
        TextView allSongs = (TextView) findViewById(R.id.text_navigation);
        String allSongsString = getResources().getString(R.string.allsongs);
        allSongs.setText(allSongsString);

        // Find navigation arrow
        ImageView backNavigation = (ImageView) findViewById(R.id.navigation_arrow);
        backNavigation.setImageResource(R.drawable.ic_arrow_back_black_24dp);
        backNavigation.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the All Songs View is clicked on.
            @Override
            public void onClick(View view) {
                Intent allsongsIntent = new Intent(AllSongsActivity.this, MainActivity.class);
                startActivity(allsongsIntent);
            }
        });

        //Set all the Songs Objects in the ArrayList
        ArrayList<Song> songsOfColombia = new ArrayList<Song>();

        songsOfColombia.add(new Song("Colombia, Tierra Querida", "Lucho Bermudez y su Orquesta", "Cumbia", R.drawable.cumbialucho));
        songsOfColombia.add(new Song("La rebelion", "Joe Arroyo", "Salsa", R.drawable.joearroyo));
        songsOfColombia.add(new Song("Yo me llamo Cumbia", "Totó La Momposina", "Cumbia", R.drawable.momposina));
        songsOfColombia.add(new Song("Mas Papaya", "sidestepper", "Rock", R.drawable.sidestepper));
        songsOfColombia.add(new Song("Pescao Envenenao", "ChocQuibTown", "Hip Hop", R.drawable.pescao));

        SongAdapter adapter = new SongAdapter(this, songsOfColombia);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);


    }

}
