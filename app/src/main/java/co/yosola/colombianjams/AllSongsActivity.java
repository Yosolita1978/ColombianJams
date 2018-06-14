package co.yosola.colombianjams;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AllSongsActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allsongs);

        final Context context = this;


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

        //Start the allSong list
        AllSongsList songsOfColombia = AllSongsList.getAllSongs(context);

        //Set all the Songs Objects in the ArrayList
        ArrayList<Song> allSongsOfColombia = new ArrayList<Song>();

        allSongsOfColombia.add(songsOfColombia.getSongbyIndex(0));
        allSongsOfColombia.add(songsOfColombia.getSongbyIndex(1));
        allSongsOfColombia.add(songsOfColombia.getSongbyIndex(2));
        allSongsOfColombia.add(songsOfColombia.getSongbyIndex(3));
        allSongsOfColombia.add(songsOfColombia.getSongbyIndex(4));

        SongAdapter adapter = new SongAdapter(this, allSongsOfColombia);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        listView = findViewById(R.id.list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(AllSongsActivity.this, PlaySingleSongActivity.class);
                intent.putExtra("indexSongSelected", position);
                startActivity(intent);
            }
        });

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
    }

}
