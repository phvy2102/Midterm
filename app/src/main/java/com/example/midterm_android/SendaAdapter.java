package com.example.midterm_android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SendaAdapter extends RecyclerView.Adapter<SendaAdapter.SendaviewHolder>{
    private List<Senda> nSendas;
    private Context nContext;

    public SendaAdapter(Context nContext) {
        this.nContext = nContext;
    }

    public void setData(List<Senda> list){
        this.nSendas = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public SendaviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_senda, parent, false);
        return new SendaviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SendaviewHolder holder, int position) {
        Senda senda = nSendas.get(position);
        if(senda == null){
            return;
        }
        holder.imgSenda.setImageResource(senda.getResourceId());
        holder.tvTitle.setText(senda.getTitle());
        holder.cvLayout.setOnClickListener(v -> onClickItem(senda));
    }

    private void onClickItem(Senda senda) {
        Intent intent = new Intent(nContext, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("senda", senda);
        intent.putExtras(bundle);
        nContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(nSendas != null){
            return nSendas.size();
        }
        return 0;
    }

    public class SendaviewHolder extends RecyclerView.ViewHolder{
        private ImageView imgSenda;
        private TextView tvTitle;
        private CardView cvLayout;

        public SendaviewHolder(@NonNull View itemView) {
            super(itemView);
            imgSenda = itemView.findViewById(R.id.img_senda);
            tvTitle = itemView.findViewById(R.id.tv_title);
            cvLayout = itemView.findViewById(R.id.layout_senda);
        }
    }
}