package com.example.aplicacaonave.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import service.TextosAdicionaisService;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GalleryViewModel() {
        // Instancia a classe com stringbuilder contendo o texto sobre a empresa
        TextosAdicionaisService sobre = new TextosAdicionaisService();
        mText = new MutableLiveData<>();
        mText.setValue(sobre.montaTextoSobre().toString());
    }

    public LiveData<String> getText() {
        return mText;
    }
}