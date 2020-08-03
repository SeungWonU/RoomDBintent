package org.techtown.roomdatabaseprac;

import androidx.room.Database;
import androidx.room.RoomDatabase;
//import android.arch.persistence.room.Database;
//import android.arch.persistence.room.RoomDatabase;

@Database(entities={MyDataList.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}