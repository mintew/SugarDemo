package com.sugardemo.glucose;

import com.orm.SugarRecord;

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
