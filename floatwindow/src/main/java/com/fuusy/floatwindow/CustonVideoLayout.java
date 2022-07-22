package com.fuusy.floatwindow;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;

/**
 * Created by roc on 2022/7/22.
 *
 */
public class CustonVideoLayout extends RelativeLayout {
    private Context mContext;
    private VideoView mVideoView;

    public CustonVideoLayout(Context context) {
        this(context, null);
    }

    public CustonVideoLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustonVideoLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        startVideo();
    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_video_play, null, false);
        mVideoView = view.findViewById(R.id.video_view);
        addView(view);
    }

    private void startVideo() {
        mVideoView.setVideoURI(Uri.parse("android.resource://" + mContext.getPackageName() + "/" + R.raw.test));


        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoView.start();
            }
        });
    }
}
