package com.brownbox.belajargit.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "people")
public class PeopleDetail {

    @PrimaryKey(autoGenerate = true)
    public int mId;

    @ColumnInfo(name = "people_name")
    @SerializedName("name")
    public String name;

    @ColumnInfo(name = "people_gender")
    @SerializedName("gender")
    public String gender;

    public int getmId() {
        return mId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public PeopleDetail(int mId, String name, String gender) {
        this.mId = mId;
        this.name = name;
        this.gender = gender;
    }
}
