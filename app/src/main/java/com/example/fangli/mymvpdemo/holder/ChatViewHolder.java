package com.example.fangli.mymvpdemo.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fangli.mymvpdemo.R;

/**
 * Created by chenyu.
 * Created on 上午11:47 2018/4/8.
 * Author'github https://github.com/PrettyAnt
 */

public class ChatViewHolder extends RecyclerView.ViewHolder {

    public TextView tv_name_a;
    public TextView tv_name_b;
    public TextView tv_content_a;
    public TextView tv_content_b;
    public RelativeLayout rl_commit_a;
    public RelativeLayout rl_commit_b;

    public ChatViewHolder(View itemView) {
        super(itemView);
        tv_name_a = itemView.findViewById(R.id.tv_name_a);
        tv_name_b = itemView.findViewById(R.id.tv_name_b);
        tv_content_a = itemView.findViewById(R.id.tv_content_a);
        tv_content_b = itemView.findViewById(R.id.tv_content_b);
        rl_commit_a = itemView.findViewById(R.id.rl_commit_a);
        rl_commit_b = itemView.findViewById(R.id.rl_commit_b);
    }
}
