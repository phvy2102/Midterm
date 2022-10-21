package com.example.midterm_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CataAdapter extends RecyclerView.Adapter<CataAdapter.CataViewHolder>{
    private Context nContext;
    private List<Cata> nListCata;

    public CataAdapter(Context nContext) {
        this.nContext = nContext;
    }
    public void setData(List<Cata> list){
        this.nListCata = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cata, parent, false);
        return new CataViewHolder(view) ;
    }


    @Override
    public void onBindViewHolder(@NonNull CataViewHolder holder, int position) {
        Cata cata = nListCata.get(position);
        if(cata ==null){
            return;
        }
        holder.tvNameCata.setText((cata.getNameCata()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(nContext, RecyclerView.HORIZONTAL, false);
        holder.rcvSenda.setLayoutManager(linearLayoutManager);
        SendaAdapter sendaAdapter = new SendaAdapter(nContext);
        sendaAdapter.setData(cata.getSendas());
        holder.rcvSenda.setAdapter(sendaAdapter);
    }

    @Override
    public int getItemCount() {
        if(nListCata != null){
            return nListCata.size();
        }
        return 0;
    }

    public class CataViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNameCata;
        private RecyclerView rcvSenda;
        public CataViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameCata = itemView.findViewById(R.id.tv_name_cata);
            rcvSenda = itemView.findViewById(R.id.rcv_senda);
        }
    }
}
