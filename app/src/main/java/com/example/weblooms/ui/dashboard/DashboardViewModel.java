package com.example.weblooms.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<ArrayList<String>> imagesMutableLiveDataArrayList;

    public DashboardViewModel() {
        ArrayList<String> imageArrayList = new ArrayList<String>();
        imageArrayList.add("https://randomuser.me/api/portraits/women/74.jpg");
        imageArrayList.add("https://randomuser.me/api/portraits/women/47.jpg");
        imageArrayList.add("https://randomuser.me/api/portraits/women/5.jpg");
        imageArrayList.add("https://randomuser.me/api/portraits/men/50.jpg");
        imageArrayList.add("https://randomuser.me/api/portraits/men/35.jpg");
        imageArrayList.add("https://randomuser.me/api/portraits/men/64.jpg");
        imageArrayList.add("https://randomuser.me/api/portraits/women/74.jpg");
        imageArrayList.add("https://randomuser.me/api/portraits/women/47.jpg");
        imageArrayList.add("https://randomuser.me/api/portraits/women/5.jpg");
        imageArrayList.add("https://randomuser.me/api/portraits/men/50.jpg");
        imageArrayList.add("https://randomuser.me/api/portraits/men/35.jpg");
        imageArrayList.add("https://randomuser.me/api/portraits/men/64.jpg");

        imagesMutableLiveDataArrayList = new MutableLiveData<>();
        imagesMutableLiveDataArrayList.setValue(imageArrayList);
    }

    public LiveData<ArrayList<String>> getList() {
        return imagesMutableLiveDataArrayList;
    }
}