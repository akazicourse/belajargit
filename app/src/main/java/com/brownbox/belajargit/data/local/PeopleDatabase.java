package com.brownbox.belajargit.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.brownbox.belajargit.model.PeopleDetail;

@Database(entities = {PeopleDetail.class}, version = 1)
public abstract class PeopleDatabase extends RoomDatabase {

    private static PeopleDatabase INSTANCE;

    public abstract PeopleDao peopleDao();

    private static final Object sLock = new Object();

    public static PeopleDatabase getInstance(Context context){
        synchronized (sLock){
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        PeopleDatabase.class, "People.db")
                        .build();
            }
            return INSTANCE;
        }
    }

}
