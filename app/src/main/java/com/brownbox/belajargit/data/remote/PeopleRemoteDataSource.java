package com.brownbox.belajargit.data.remote;

import com.brownbox.belajargit.data.PeopleDataSource;
import com.brownbox.belajargit.model.People;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleRemoteDataSource implements PeopleDataSource {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListPeoples(final GetPeoplesCallback callback) {
        Call<People> call = apiInterface.getAllPeoples();
        call.enqueue(new Callback<People>() {
            @Override
            public void onResponse(Call<People> call, Response<People> response) {
                callback.onPeopleLoaded(response.body());
            }

            @Override
            public void onFailure(Call<People> call, Throwable t) {
                callback.onDataNotAvailable(t.toString());
            }
        });
    }
}
