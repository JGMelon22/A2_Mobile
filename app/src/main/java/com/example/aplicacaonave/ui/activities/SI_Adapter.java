package com.example.aplicacaonave.ui.activities;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacaonave.R;

import java.util.ArrayList;

import domain.AdapterCallback;
import domain.Carro;

public class SI_Adapter extends RecyclerView.Adapter<SI_Adapter.MyViewHolder> {

    Context context;
    ArrayList<Carro> carros;
    private SparseBooleanArray selectedItems;
    private AdapterCallback adapterCallback;
    private int adapterIndex;

    private int selectedItemPosition = RecyclerView.NO_POSITION;


    public SI_Adapter(Context context, ArrayList<Carro> carros, AdapterCallback adapterCallback,int index) {
        this.adapterCallback = adapterCallback;
        this.context = context;
        this.carros = carros;
        this.selectedItems = new SparseBooleanArray();
        this.adapterIndex = index;
    }

    @NonNull
    @Override
    public SI_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item in the RecyclerView
        // LayoutInflater inflater = LayoutInflater.from(context);
        // View view = inflater.inflate(R.layout.rv_row, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_horizontal, parent, false);
        return new SI_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Bind data to the ViewHolder
        Carro carro = carros.get(position);
        holder.tvCarro.setText(carros.get(position).getNomeCarro());
        holder.tvPreco.setText(carros.get(position).getStringPrecoAluguel(context));
        holder.tvData.setText(carros.get(position).getMarcaCarro());
        holder.imgView.setImageResource(carros.get(position).getImagem());
        holder.radioButton.setChecked(position == selectedItemPosition);
    }

    @Override
    public int getItemCount() {
        // Return the number of items in the data source
        return carros.size();
    }

    public void setSelectedItem(int position) {
        int previousSelected = getSelectedItem();

        if (position != RecyclerView.NO_POSITION) {
            selectedItems.put(position, true);
        } else {
            selectedItems.clear();
        }

        if (adapterCallback != null) {
            if (previousSelected != RecyclerView.NO_POSITION) {
                adapterCallback.onItemDeselected(previousSelected);
            }
            if (position != RecyclerView.NO_POSITION) {
                adapterCallback.onItemSelected(position);
            }
        }

        notifyDataSetChanged();
    }

    public int getSelectedItem() {
        if (selectedItems.size() == 0) {
            return RecyclerView.NO_POSITION;
        }
        return selectedItems.keyAt(0);
    }

    public void clearSelection() {
        selectedItemPosition = RecyclerView.NO_POSITION;
        notifyDataSetChanged();
    }

    public void setSelectedItemPosition(int position) {
        selectedItemPosition = position;
        notifyDataSetChanged();
    }

    public int getSelectedItemPosition() {
        return selectedItemPosition;
    }

    public boolean isItemAvailable(int position) {
        Carro carro = carros.get(position);
        return carro.isDisponivel();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView;
        TextView tvCarro, tvPreco, tvData;
        RadioButton radioButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // Find and initialize views in the item layout
            imgView = itemView.findViewById(R.id.histImageView);
            tvCarro = itemView.findViewById(R.id.carroTextView);
            tvPreco = itemView.findViewById(R.id.precoTextView);
            tvData = itemView.findViewById(R.id.dataTextView);
            radioButton = itemView.findViewById(R.id.radioButtonUniv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (adapterCallback != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            adapterCallback.onItemClick(pos, adapterIndex);
                            notifyDataSetChanged(); // Update the UI
                        }
                    }
                }
            });

            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (adapterCallback != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            adapterCallback.onItemClick(pos, adapterIndex);
                            notifyDataSetChanged(); // Update the UI
                        }
                    }
                }
            });

        }

    }

}


