package com.example.aplicacaonave.ui.historico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacaonave.R;

import java.util.ArrayList;

import domain.Carro;
import domain.RecyclerViewClickInterface;

public class CAR_Adapter extends RecyclerView.Adapter<CAR_Adapter.MyViewHolder> {
    private final RecyclerViewClickInterface recyclerViewClickInterface;
    Context context;
    ArrayList<Carro> carros;

    public CAR_Adapter(RecyclerViewClickInterface recyclerViewClickInterface, Context context, ArrayList<Carro> carros) {
        this.recyclerViewClickInterface = recyclerViewClickInterface;
        this.context = context;
        this.carros = carros;
    }

    @NonNull
    @Override
    public CAR_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item in the RecyclerView
        // LayoutInflater inflater = LayoutInflater.from(context);
        // View view = inflater.inflate(R.layout.rv_row, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row, parent, false);
        return new CAR_Adapter.MyViewHolder(view, recyclerViewClickInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Bind data to the ViewHolder
        holder.tvCarro.setText(carros.get(position).getNomeCarro());
        holder.tvPreco.setText(carros.get(position).getStringPrecoAluguel(context));
        holder.tvData.setText(carros.get(position).getMarcaCarro());
        holder.imgView.setImageResource(carros.get(position).getImagem());
    }

    @Override
    public int getItemCount() {
        // Return the number of items in the data source
        return carros.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView;
        TextView tvCarro, tvPreco, tvData;

        public MyViewHolder(@NonNull View itemView, RecyclerViewClickInterface recyclerViewClickInterface) {
            super(itemView);

            // Find and initialize views in the item layout
            imgView = itemView.findViewById(R.id.histImageView);
            tvCarro = itemView.findViewById(R.id.carroTextView);
            tvPreco = itemView.findViewById(R.id.precoTextView);
            tvData = itemView.findViewById(R.id.dataTextView);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (recyclerViewClickInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION)
                            recyclerViewClickInterface.onItemClick(pos);

                    }
                }
            });
        }

    }

}


