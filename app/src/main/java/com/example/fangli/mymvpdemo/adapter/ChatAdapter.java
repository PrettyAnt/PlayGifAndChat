package com.example.fangli.mymvpdemo.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fangli.mymvpdemo.ChatModel;
import com.example.fangli.mymvpdemo.R;
import com.example.fangli.mymvpdemo.holder.ChatViewHolder;

import java.util.List;

/**
 * Created by chenyu.
 * Created on 上午11:25 2018/4/8.
 * Author'github https://github.com/PrettyAnt
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {

    private Activity activity;
    private List<ChatModel> chatModels;

    public ChatAdapter(Activity activity, List<ChatModel> chatModels) {
        this.activity = activity;
        this.chatModels = chatModels;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ChatViewHolder chatViewHolder = new ChatViewHolder(
                LayoutInflater
                        .from(activity)
                        .inflate(R.layout.item_chat, parent, false)
        );
        return chatViewHolder;
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        switch (chatModels.get(position).getId()) {
            case 1993:
                leftOrRight(true,holder);
                holder.tv_name_a.setText(chatModels.get(position).getName());
                holder.tv_content_a.setText(chatModels.get(position).getChatContent());
                break;
            case 1992:
                leftOrRight(false,holder);
                holder.tv_name_b.setText(chatModels.get(position).getName());
                holder.tv_content_b.setText(chatModels.get(position).getChatContent());
                break;
        }

    }

    private void leftOrRight(boolean isLeft,ChatViewHolder holder) {
        if (isLeft) {
            holder.rl_commit_a.setVisibility(View.VISIBLE);
            holder.rl_commit_b.setVisibility(View.GONE);
        } else {
            holder.rl_commit_a.setVisibility(View.GONE);
            holder.rl_commit_b.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return chatModels.size();
    }
}
