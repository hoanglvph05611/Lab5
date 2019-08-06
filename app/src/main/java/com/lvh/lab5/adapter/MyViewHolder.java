package com.lvh.lab5.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lvh.lab5.R;
import com.rockerhieu.emojicon.EmojiconTextView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public EmojiconTextView tvMSGMy;
    public TextView tvNameM;

    MyViewHolder(@NonNull View itemView) {
        super(itemView);
        tvNameM = itemView.findViewById(R.id.tvNameMy);
        tvMSGMy = itemView.findViewById(R.id.tvSMyMSG);
    }
}