package com.example.aplicacaonave.ui.historico;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aplicacaonave.databinding.FragmentGalleryBinding;
import com.example.aplicacaonave.databinding.FragmentHistoricoBinding;
import com.example.aplicacaonave.ui.gallery.GalleryViewModel;

public class HistoricoFragment extends Fragment {

    private FragmentHistoricoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HistoricoViewModel historicoViewModel =
                new ViewModelProvider(this).get(HistoricoViewModel.class);

        binding = FragmentHistoricoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHistorico;
        historicoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}