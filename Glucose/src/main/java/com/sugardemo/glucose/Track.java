package com.sugardemo.glucose;


import com.orm.SugarRecord;

/**
 * Created by billminter on 5/2/14.
 */
public class Track extends SugarRecord<Track> {
    public String trackName;
    public int trackID;
    public String artistName;
    public int releaseYear;
    public int trackPopularity;

    public Track() {
    }
    public Track(String trackName, String artistName, int trackID) {
        this.trackID = trackID;
        this.artistName = artistName;
        this.trackName = trackName;
    }

    public Track(String trackName, String artistName, int trackID, int releaseYear) {
        this.trackID = trackID;
        this.artistName = artistName;
        this.trackName = trackName;
        this.releaseYear = releaseYear;
    }

    public String toString() {
        return (trackName + " " + trackID + " " + artistName + " " + releaseYear);
    }
}
