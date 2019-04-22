package com.example.serangga;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListSeranggaAdapter extends RecyclerView.Adapter<ListSeranggaAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Serangga> listSerangga;

    public ListSeranggaAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Serangga> getListSerangga() {
        return listSerangga;
    }

    public void setListSerangga(ArrayList<Serangga> listSerangga) {
        this.listSerangga = listSerangga;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_serangga, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListSerangga().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListSerangga().get(position).getRemarks());
        Glide.with(context)
                .load(getListSerangga().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListSerangga().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
