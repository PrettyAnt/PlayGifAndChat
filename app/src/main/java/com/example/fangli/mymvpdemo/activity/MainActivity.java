package com.example.fangli.mymvpdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.fangli.mymvpdemo.R;
import com.example.fangli.mymvpdemo.widget.ZbGifView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_tuanzi;
    private Button btn_show;
    private RelativeLayout rl_anim;
    private Button btn_pause, btn_destroy,btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }


    private void initView() {
        iv_tuanzi = (ImageView) findViewById(R.id.iv_tuanzi);
        btn_show = (Button) findViewById(R.id.btn_show);
        btn_pause = (Button) findViewById(R.id.btn_pause);
        btn_destroy = (Button) findViewById(R.id.btn_destroy);
        btn_next = (Button) findViewById(R.id.btn_next);
        rl_anim = (RelativeLayout) findViewById(R.id.rl_anim);
    }

    private void initEvent() {
        btn_show.setOnClickListener(this);
        btn_pause.setOnClickListener(this);
        btn_destroy.setOnClickListener(this);
        btn_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show:
                showGifAnim("", R.drawable.tianan);
                break;
            case R.id.btn_pause:
                boolean flag = pause;
                ivGif.setPaused(flag);
                pause = !flag;
                break;
            case R.id.btn_destroy:
                rl_anim.removeView(ivGif);
                ivGif = null;
                break;
            case R.id.btn_next:
                Intent intent = new Intent(this,ChatActivity.class);
                startActivity(intent);
                break;
        }
    }

    private static boolean pause = true;


    private static ZbGifView ivGif;

    public void showGifAnim(String gifPath, int drawableId) {
        if (ivGif == null) {
            ivGif = new ZbGifView(this);
            ivGif.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            rl_anim.addView(ivGif);
            ivGif.setMovieResource(drawableId);
//            ivGif.setMoviePath(gifPath);
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    rl_anim.removeView(ivGif);
//                    ivGif = null;
//                }
//            }, ivGif.getDuration());
        }
    }
}
