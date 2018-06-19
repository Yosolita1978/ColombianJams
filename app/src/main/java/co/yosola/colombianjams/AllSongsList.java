package co.yosola.colombianjams;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class AllSongsList {

    public static AllSongsList allSongs = null;
    private Song[] mSongs;
    private int mCurrentSongIndex = 0;

    private AllSongsList(Context context) {
        mSongs = new Song[5];

        String songOneName = context.getResources().getString(R.string.song_one);
        String songOneArtist = context.getResources().getString(R.string.artist_song_one);
        String songOneGenre = context.getResources().getString(R.string.genre_song_one);
        Drawable sonOneImg = context.getResources().getDrawable(R.drawable.escalona);
        int songAudioOneId = R.raw.atucuerpo_vives;

        Song songOne = new Song(songOneName, songOneArtist, songOneGenre, sonOneImg, songAudioOneId);
        mSongs[0] = songOne;

        String songTwoName = context.getResources().getString(R.string.song_two);
        String songTwoArtist = context.getResources().getString(R.string.artist_song_two);
        String songTwoGenre = context.getResources().getString(R.string.genre_song_two);
        Drawable sonTwoImg = context.getResources().getDrawable(R.drawable.joearroyo);
        int songAudioTwoId = R.raw.eres_fito;

        Song songTwo = new Song(songTwoName, songTwoArtist, songTwoGenre, sonTwoImg, songAudioTwoId);
        mSongs[1] = songTwo;

        String songThreeName = context.getResources().getString(R.string.song_three);
        String songThreeArtist = context.getResources().getString(R.string.artist_song_three);
        String songThreeGenre = context.getResources().getString(R.string.genre_song_three);
        Drawable sonThreeImg = context.getResources().getDrawable(R.drawable.momposina);
        int songAudioThreeId = R.raw.idilio;

        Song songThree = new Song(songThreeName, songThreeArtist, songThreeGenre, sonThreeImg, songAudioThreeId);
        mSongs[2] = songThree;

        String songFourName = context.getResources().getString(R.string.song_four);
        String songFourArtist = context.getResources().getString(R.string.artist_song_four);
        String songFourGenre = context.getResources().getString(R.string.genre_song_four);
        Drawable sonFourImg = context.getResources().getDrawable(R.drawable.sidestepper);
        int songAudioFourId = R.raw.oye_bonita;

        Song songFour = new Song(songFourName, songFourArtist, songFourGenre, sonFourImg, songAudioFourId);
        mSongs[3] = songFour;

        String songFiveName = context.getResources().getString(R.string.song_five);
        String songFiveArtist = context.getResources().getString(R.string.artist_song_five);
        String songFiveGenre = context.getResources().getString(R.string.genre_song_five);
        Drawable sonFiveImg = context.getResources().getDrawable(R.drawable.pescao);
        int songAudioFiveId = R.raw.stone_woman;

        Song songFive = new Song(songFiveName, songFiveArtist, songFiveGenre, sonFiveImg, songAudioFiveId);
        mSongs[4] = songFive;

    }

    public static AllSongsList getAllSongs(Context context) {
        if (allSongs == null) {
            allSongs = new AllSongsList(context);
        }
        return allSongs;
    }

    public Song getNextSong() {
        if (mCurrentSongIndex == mSongs.length - 1) {
            return null;
        } else {
            mCurrentSongIndex += 1;
            return mSongs[mCurrentSongIndex];
        }
    }

    public Song getSongbyIndex(int index){
        return  mSongs[index];
    }

    public int getTotalSongs() {
        return mSongs.length;
    }

    public int getSongIndex(Song song){
        int index = -1;
        for(int i = 0; i < mSongs.length; i++){
            if(mSongs[i] == song){
                index = i;
            }
        }
        return index;

    }

}
