package com.nathan.softechtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nathan.softechtest.model.Doctor;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Doctor> mList;

    public Adapter() {
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Doctor item = mList.get(position);
        ItemVH vh = ((ItemVH) holder);
        if (vh != null) {
            Glide
                    .with(vh.imageView)
                    .load(R.drawable.doctor_sample)
                    .centerCrop()
                    //.placeholder(R.drawable.loading_spinner)
                    .into(vh.imageView);
            ((ItemVH) holder).name.setText(item.name);
            ((ItemVH) holder).specialisation.setText(item.specialisation);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateContent(List<Doctor> items) {
        if (items != null) {
            mList.clear();
            mList.addAll(items);
            notifyDataSetChanged();
        }
    }

    private static final class ItemVH extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView specialisation;

        ItemVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            specialisation = itemView.findViewById(R.id.specialization);
        }
    }
}
