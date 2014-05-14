package com.orm;

/**
 * Created by billminter on 5/13/14.
 */
public class Playlist extends SugarRecord<Playlist> {

    public String playlistName;
    public int trackID;

    public Playlist() {
    }
    public Playlist(String playlistName, int trackID) {
        this.playlistName = playlistName;
        this.trackID = trackID;
    }


}
