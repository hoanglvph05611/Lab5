package com.lvh.lab5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lvh.lab5.MainActivity;
import com.lvh.lab5.R;
import com.lvh.lab5.model.Message;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ViewHolder> {

    public static final int ORTHER_LAYOUT=0;
    public static final int MY_LAYOUT=1;
    private List<Message> chatList;
    private Context context;

    public ChatAdapter(List<Message> chatList, Context context) {
        this.chatList = chatList;
        this.context = context;
    }


//    @Override
//    public int getItemViewType(int position) {
//        switch (chatList.get(position).)
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.other_chat_msg,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvMSGOther.setText(chatList.get(position).msgOther);
        holder.tvMSGMy.setText(chatList.get(position).msgMy);
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }
}
