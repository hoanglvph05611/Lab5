package com.lvh.lab5.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lvh.lab5.MainActivity;
import com.lvh.lab5.R;
import com.lvh.lab5.model.Message;
import com.rockerhieu.emojicon.EmojiconTextView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ORTHER_LAYOUT = 1;
    public static final int MY_LAYOUT = 2;
    private List<Message> chatList;
    private Context context;
    public static String name;


    public ChatAdapter(List<Message> chatList, Context context) {
        this.chatList = chatList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(chatList.get(position).getName())) {
            return ORTHER_LAYOUT;

        } else {
            return MY_LAYOUT;
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == ORTHER_LAYOUT) { // for call layout
            view = LayoutInflater.from(context).inflate(R.layout.other_chat_msg, parent, false);
            return new OtherViewHolder(view);

        } else { // for email layout
            view = LayoutInflater.from(context).inflate(R.layout.single_my_msg, parent, false);
            return new MyViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof OtherViewHolder){
            Message chat = chatList.get(position);
            name = chat.getName();


            ((OtherViewHolder) viewHolder).tvMSGOther.setText(chat.message);

        }else if (viewHolder instanceof  MyViewHolder){
            Message chat1 = chatList.get(position);


            ((MyViewHolder) viewHolder).tvMSGMy.setText(chat1.message);

        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public final EmojiconTextView tvMSGOther, tvMSGMy;
        public TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMSGMy = itemView.findViewById(R.id.tvSMyMSG);
            tvMSGOther = itemView.findViewById(R.id.tvOMsg);

        }
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

}
