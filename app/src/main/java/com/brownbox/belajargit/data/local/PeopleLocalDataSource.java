package com.brownbox.belajargit.data.local;

import android.content.Context;

import com.brownbox.belajargit.data.PeopleDataSource;
import com.brownbox.belajargit.model.People;
import com.brownbox.belajargit.model.PeopleDetail;

import java.util.List;

public class PeopleLocalDataSource implements PeopleDataSource {
    private Context context;
    private PeopleDao peopleDao;

    public PeopleLocalDataSource(Context context) {
        this.context = context;
        peopleDao = PeopleDatabase.getInstance(context).peopleDao();
    }

    @Override
    public void getListPeoples(final GetPeoplesCallback callback) {
        //get data from local database
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<PeopleDetail> people = peopleDao.getPeoples();
                if(people.isEmpty()){
                    callback.onDataNotAvailable("Data di database SQLite Kosong");
                }else{
                    People peoples = new People(people);
                    callback.onPeopleLoaded(peoples);
                }
            }
        };
        new Thread(runnable).start();
    }

    public void saveDataPeople(final List<PeopleDetail> peopleDetail){
        //save data from internet to database local
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                peopleDao.insertPeople(peopleDetail);

            }
        };
        new Thread(runnable).start();
    }
}
