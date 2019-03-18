package com.brownbox.belajargit.data;

import com.brownbox.belajargit.model.People;

public interface PeopleDataSource {

    void getListPeoples(GetPeoplesCallback callback);

    interface GetPeoplesCallback {
        void onPeopleLoaded(People data);
        void onDataNotAvailable(String errorMessage);
    }

}
