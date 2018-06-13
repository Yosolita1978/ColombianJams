package co.yosola.colombianjams;

/**
 * Created by cristina on 6/12/18.
 */

public class Song {

    private String mSongName;

    private String mSongArtist;

    private int mImageResourceId;

    private String mSongGenre;

    // There is two tips of the songs, with or without image

    public Song(String SongName, String SongArtist, String SongGenre){
        mSongName = SongName;
        mSongArtist = SongArtist;
        mSongGenre = SongGenre;
    }

    public Song(String SongName, String SongArtist, String SongGenre, int ImageSongId){
        mSongName = SongName;
        mSongArtist = SongArtist;
        mSongGenre = SongGenre;
        mImageResourceId = ImageSongId;
    }


    public String getSongName(){
        return mSongName;
    }

    public String getSongArtist(){
        return mSongArtist;
    }

    public String getSongGenre(){
        return mSongGenre;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
