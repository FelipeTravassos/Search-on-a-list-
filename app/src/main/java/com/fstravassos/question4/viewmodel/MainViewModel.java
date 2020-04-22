package com.fstravassos.question4.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.fstravassos.question4.model.MainModel;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private MainModel mModel = new MainModel();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<String>> getList() {
        return mModel.getListLiveData();
    }

    public void filter(String str) {
        mModel.filter(str);
    }
}
