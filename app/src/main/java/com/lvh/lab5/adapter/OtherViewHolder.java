package com.lvh.lab5.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lvh.lab5.R;
import com.rockerhieu.emojicon.EmojiconTextView;

public class OtherViewHolder extends RecyclerView.ViewHolder {

    public EmojiconTextView tvMSGOther;
    public TextView tvNameO;

    OtherViewHolder(@NonNull View itemView) {
        super(itemView);
        tvNameO = itemView.findViewById(R.id.tvNameOther);
        tvMSGOther = itemView.findViewById(R.id.tvOMsg);
    }

}