package com.example.midterm_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<Exercise> petsList;

    public ExerciseAdapter(Context context, ArrayList<Exercise> petsList) {
        this.context = context;
        this.petsList = petsList;
    }

    @NonNull
    @Override
    public ExerciseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Gán View
        View view = LayoutInflater.from(context).inflate(R.layout.layout_exercise, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseAdapter.ViewHolder holder, int position) {
        // Gán dữ liệu
        Exercise pet = petsList.get(position);

        holder.tvName.setText(pet.getName());
        holder.tvDay.setText(pet.getDay());
        holder.tvTime.setText(pet.getTime());
        holder.ivAvatar.setImageResource(pet.getImageResourceID());
    }

    @Override
    public int getItemCount() {
        if (petsList != null) {
            return petsList.size();
        } else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDay;
        TextView tvTime;
        ImageView ivAvatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            tvName = itemView.findViewById(R.id.tv_name);
            tvDay = itemView.findViewById(R.id.tv_day);
            tvTime = itemView.findViewById(R.id.tv_time);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
        }
    }
}
