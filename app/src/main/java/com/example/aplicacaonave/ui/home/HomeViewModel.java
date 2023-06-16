package com.example.aplicacaonave.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Boas-vindas\nao\nGRA2MOTORS");
    }

    public LiveData<String> getText() {
        return mText;
    }
}