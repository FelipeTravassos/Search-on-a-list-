package com.fstravassos.question4.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainModel {

    private MutableLiveData<List<String>> mListLiveData = new MutableLiveData<>();
    private List<String> mList = new ArrayList<>();

    public MainModel() {
        mockList();
    }

    public LiveData<List<String>> getListLiveData() {
        return mListLiveData;
    }

    public void filter(String str) {
        List<String> result = new ArrayList<>();

        str = str.toLowerCase();
        for (String item : mList) {
            item = item.toLowerCase();
            if (item.contains(str) || FilterUtils.checkTypos(item, str)
                    || FilterUtils.isPartialPermutation(item, str)) {
                result.add(item);
            }
        }

        mListLiveData.postValue(result);
    }

    private void mockList() {
        mList.add("Felipe");
        mList.add("Mirlene");
        mList.add("Raquel");
        mList.add("Thiago");
        mList.add("Humberto");
        mList.add("Ozenete");
        mList.add("Victor");
        mList.add("Pedro");
        mList.add("Leticia");
        mList.add("Jura");
        mList.add("Adriana");
        mList.add("Jocemir");
        mList.add("Deborah");
        mList.add("Livia");
        mList.add("Virginia");
        mList.add("Mario");
        mList.add("Marcio");
        mList.add("Marcia");
        mList.add("Lenilda");
        mList.add("Olivia");

        mListLiveData.postValue(mList);
    }
}
