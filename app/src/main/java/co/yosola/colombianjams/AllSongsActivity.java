package co.yosola.colombianjams;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AllSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allsongs);


        //Set the text of the navigation text.

        TextView allSongs = (TextView)findViewById(R.id.text_navigation);
        String allSongsString = getResources().getString(R.string.allsongs);
        allSongs.setText(allSongsString);

        ArrayList<Song> songsOfColombia = new ArrayList<Song>();


        songsOfColombia.add(new Song("Colombia Caribe", "ChocQuibTown", "Hip Hop",R.drawable.colombiacaribe));


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
