package com.brownbox.belajargit.data;

import android.support.annotation.Nullable;

import com.brownbox.belajargit.data.local.PeopleLocalDataSource;
import com.brownbox.belajargit.data.remote.PeopleRemoteDataSource;
import com.brownbox.belajargit.model.People;

public class PeopleRepository implements PeopleDataSource {

    private PeopleRemoteDataSource peopleRemoteDataSource;
    private PeopleLocalDataSource peopleLocalDataSource;

    public PeopleRepository(PeopleRemoteDataSource peopleRemoteDataSource,
                            PeopleLocalDataSource peopleLocalDataSource) {
        this.peopleRemoteDataSource = peopleRemoteDataSource;
        this.peopleLocalDataSource = peopleLocalDataSource;
    }


    private void getPeoplesFromRemote(@Nullable final GetPeoplesCallback callback){
        peopleRemoteDataSource.getListPeoples(new GetPeoplesCallback() {
            @Override
            public void onPeopleLoaded(People data) {
                //insert into database
                peopleLocalDataSource.saveDataPeople(data.getPeoples());
                callback.onPeopleLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                callback.onDataNotAvailable(errorMessage);

            }
        });
    }

    @Override
    public void getListPeoples(final GetPeoplesCallback callback) {
        peopleLocalDataSource.getListPeoples(new GetPeoplesCallback() {
            @Override
            public void onPeopleLoaded(People data) {
                callback.onPeopleLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                getPeoplesFromRemote(callback);
            }
        });
    }
}
