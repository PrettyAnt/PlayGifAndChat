package com.example.fangli.mymvpdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.fangli.mymvpdemo.ChatModel;
import com.example.fangli.mymvpdemo.R;
import com.example.fangli.mymvpdemo.adapter.ChatAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rv_chat;
    private ChatAdapter chatAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<ChatModel> chatModels = new ArrayList<>();
    private List<ChatModel> currentChatModels = new ArrayList<>();
    /**
     * 目标项是否在最后一个可见项之后
     */
    private boolean mShouldScroll;
    /**
     * 记录目标项位置
     */
    private int mToPosition;

    public static void MoveToPosition(LinearLayoutManager manager, RecyclerView mRecyclerView, int n) {


        int firstItem = manager.findFirstVisibleItemPosition();
        int lastItem = manager.findLastVisibleItemPosition();
        if (n <= firstItem) {
            mRecyclerView.scrollToPosition(n);
        } else if (n <= lastItem) {
            int top = mRecyclerView.getChildAt(n - firstItem).getTop();
            mRecyclerView.scrollBy(0, top);
        } else {
            mRecyclerView.scrollToPosition(n);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initView();
    }

    private void initView() {
        Button btn_add = findViewById(R.id.btn_add);
        Button btn_clear = findViewById(R.id.btn_clear);
        btn_add.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        rv_chat = findViewById(R.id.rv_chat);
        linearLayoutManager = new LinearLayoutManager(this);
        rv_chat.setLayoutManager(linearLayoutManager);
//        rv_chat.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));//分割线
        chatAdapter = new ChatAdapter(this, chatModels);
        rv_chat.setAdapter(chatAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                initData();
                break;
            case R.id.btn_clear:
                chatModels.clear();
                chatAdapter.notifyDataSetChanged();
                break;
        }
    }

    private void initData() {
        for (int i = 0; i < 2; i++) {
            ChatModel chatModel = new ChatModel();
            int v = (int) (Math.random() * 10 + 1);
            if (v % 2 == 0) {
                chatModel.setName("wangbei");
                chatModel.setId(1993);
                chatModel.setChatContent("我是aaaa浦发信用卡浦发信用卡浦发信用卡浦发信用卡浦发信用卡浦发信用卡浦发信用卡浦发信用卡浦发信用卡浦发信用卡浦发信用卡浦发信用卡我是aaaa,我是aaaa,我是aaaa,我是aaaa,我是aaaa,我是aaaa,我是aaaa,我是aaaa,我是aaaa,我是aaaa,我是aaaa,我是aaaa,我是aaaa,我是aaaa,我是aaaa,我是aaaa,");
            } else {
                chatModel.setName("chenyu");
                chatModel.setId(1992);
                chatModel.setChatContent("动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服动漫在线客服");
            }

            chatModels.add(chatModel);
        }

        chatAdapter.notifyDataSetChanged();
        MoveToPosition(linearLayoutManager, rv_chat, chatModels.size() - 1);
    }

    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));

        if (position < firstItem) {
            // 如果跳转位置在第一个可见位置之前，就smoothScrollToPosition可以直接跳转
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 跳转位置在第一个可见项之后，最后一个可见项之前
            // smoothScrollToPosition根本不会动，此时调用smoothScrollBy来滑动到指定位置
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 如果要跳转的位置在最后可见项之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
            // 再通过onScrollStateChanged控制再次调用smoothMoveToPosition，执行上一个判断中的方法
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;
        }
    }

}
