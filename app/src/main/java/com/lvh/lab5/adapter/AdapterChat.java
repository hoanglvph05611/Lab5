package com.lvh.lab5.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lvh.lab5.model.Message;

import java.util.List;

public class AdapterChat extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int VIEW_MY_MSG = 1;
    private static final int VIEW_OTHERS_MSG = 2;
    private static final int VIEW_LOAD_MORE = 3;
    private static final String TAG = AdapterChat.class.toString();
    private List<Message> modelMessageList;
    boolean isLoading = false, isMoreDataAvailable = true;

    AdapterChat(List<Message> modelMessageList) {
        this.modelMessageList = modelMessageList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}



