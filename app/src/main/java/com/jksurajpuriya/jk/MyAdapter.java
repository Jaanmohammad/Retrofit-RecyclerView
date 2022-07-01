package com.jksurajpuriya.jk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jksurajpuriya.jk.Api.MyViewModel;
import com.jksurajpuriya.jk.databinding.ItemsBinding;
import com.jksurajpuriya.jk.databinding.RowBinding;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<MyViewModel.Datum> modelList;
    Context context;

    public MyAdapter(List<MyViewModel.Datum> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.binding.itemId.setText(String.valueOf(modelList.get(position).getId()));
        holder.binding.itemEmail.setText(modelList.get(position).getEmail());
        holder.binding.itemFirstName.setText(modelList.get(position).getFirst_name());
        holder.binding.itemLastName.setText(modelList.get(position).getLast_name());

        Glide.with(holder.binding.itemImage.getContext())
                .load(modelList.get(position).getAvatar())
                .into(holder.binding.itemImage);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemsBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ItemsBinding.bind(itemView);
        }
    }
}
