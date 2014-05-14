package com.sugardemo.glucose;

import android.app.Activity;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.orm.Database;
import com.orm.Playlist;
import com.orm.SugarApp;
import com.orm.Track;
import com.orm.query.Select;

import java.util.List;


public class SugarActivity extends Activity {

    private void initDB() {
        loadDB();
        readDB();
    }

    private void loadDB() {

        Track t = new Track("run away", "sarah jarosz", 14);
        t.save();
        t = new Track("ring them bells", "sarah jarosz", 15);
        t.save();
        t = new Track("pretend", "sierra hull", 10);
        t.save();
        t = new Track("daybreak", "sierra hull", 127, 2011);
        t.save();

        t = new Track("Dancing With the Moon", "balkan beat box", 7);
        t.save();

        Playlist p = new Playlist("MyFolk", 14);
        p.save();
        p = new Playlist("MyFolk", 15);
        p.save();
        p = new Playlist("MyFolk", 10);
        p.save();
        p = new Playlist("MyFolk", 127);
        p.save();
        p = new Playlist("DanceMusic", 7);
        p.save();

    }

    private void readDB() {
        List<Track> temp = (Select.from(Track.class).list());
        System.out.println("Found: ");


        for(Track t: temp) {
            System.out.println(t.toString());
        }

        SQLiteDatabase database = SugarApp.getSugarContext().getDatabase().getDB();
        Cursor c = database.rawQuery("Select * FROM TRACK NATURAL JOIN PLAYLIST WHERE PLAYLIST.playlist_name = ?",new String[]{"MyFolk"});
        System.out.println("cursor stuff");
        System.out.println(DatabaseUtils.dumpCursorToString(c));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDB();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
