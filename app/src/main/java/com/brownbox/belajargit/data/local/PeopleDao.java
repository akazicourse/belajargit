package com.brownbox.belajargit.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.brownbox.belajargit.model.PeopleDetail;

import java.util.List;

@Dao
public interface PeopleDao {
    @Query("SELECT * FROM people")
    List<PeopleDetail> getPeoples();

    @Insert
    void insertPeople(List<PeopleDetail> people);


}
