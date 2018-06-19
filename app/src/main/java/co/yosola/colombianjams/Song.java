package co.yosola.colombianjams;

import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cristina on 6/12/18.
 */

public class Song {

    private String mSongName;

    private String mSongArtist;

    private Drawable mImageResource;

    private String mSongGenre;

    /** Audio resource ID for the song */
    private int mAudioResourceId;

    // There is two tips of the songs, with or without image

    public Song(String SongName, String SongArtist, String SongGenre, int audioResourceId) {
        mSongName = SongName;
        mSongArtist = SongArtist;
        mSongGenre = SongGenre;
        mAudioResourceId = audioResourceId;
    }

    public Song(String SongName, String SongArtist, String SongGenre, Drawable ImageSong, int audioResourceId) {
        mSongName = SongName;
        mSongArtist = SongArtist;
        mSongGenre = SongGenre;
        mImageResource = ImageSong;
        mAudioResourceId = audioResourceId;
    }


    public String getSongName() {
        return mSongName;
    }

    public String getSongArtist() {
        return mSongArtist;
    }

    public String getSongGenre() {
        return mSongGenre;
    }

    public Drawable getImageResource() {
        return mImageResource;
    }

    /**
     * Return the audio resource ID of the Song.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

}
