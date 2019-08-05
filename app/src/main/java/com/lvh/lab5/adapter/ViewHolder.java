package com.lvh.lab5.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lvh.lab5.R;
import com.rockerhieu.emojicon.EmojiconTextView;

class ViewHolder extends RecyclerView.ViewHolder {

    public final EmojiconTextView tvMSGOther,tvMSGMy;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        tvMSGMy = itemView.findViewById(R.id.tvSMyMSG);
        tvMSGOther = itemView.findViewById(R.id.tvOMsg);

    }
}
