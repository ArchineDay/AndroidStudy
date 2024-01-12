package com.example.activityjump.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.activityjump.R;
import com.example.activityjump.utils.BlurryBgUtil;
import com.example.activityjump.utils.DialogUtil;

import io.alterac.blurkit.BlurLayout;

public class BlurActivity extends AppCompatActivity implements View.OnClickListener {
    Button fastBlur;
    private ImageView dialogBg;
    private Handler mHandler;

    BlurLayout blurLayout;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur);

        fastBlur = findViewById(R.id.fastBlur);
        fastBlur.setOnClickListener(this);

        blurLayout = findViewById(R.id.blurLayout);

        findViewById(R.id.blur1).setOnClickListener(this);


        //模糊背景
        dialogBg = findViewById(R.id.iv_dialog_bg);

        //创建activity先把对话框背景图设为不可见
        dialogBg.setImageAlpha(0);
        dialogBg.setVisibility(View.GONE);

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    dialogBg.setVisibility(View.GONE);
                }
            }
        };

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fastBlur) {
            DialogUtil.tipDialog(BlurActivity.this, getWindow());
        } else if (v.getId() == R.id.blur1) {
//            BlurryBgUtil.handleBlur(BlurActivity.this,dialogBg,mHandler);
            blurLayout.setVisibility(View.VISIBLE);
//            blurLayout.startBlur();
        }
    }
}