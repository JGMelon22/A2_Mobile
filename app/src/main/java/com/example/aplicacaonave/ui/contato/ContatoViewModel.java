package com.example.aplicacaonave.ui.contato;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContatoViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public ContatoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Celular: (67) 98183-9325\nTelefone: (67) 3891-5823\nE-mail: gra2motors@gmail.com\nSite: gra2motors.com");
    }

    public LiveData<String> getText() {
        return mText;
    }
}