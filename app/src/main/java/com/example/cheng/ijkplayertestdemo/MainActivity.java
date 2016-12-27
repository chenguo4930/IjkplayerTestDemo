package com.example.cheng.ijkplayertestdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.cheng.ijkplayertestdemo.ijkplayer.IjkVideoView;

import tv.danmaku.ijk.media.player.IMediaPlayer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private IjkVideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();
    }

    private void initView() {
        mVideoView = (IjkVideoView) findViewById(R.id.ijk_video_view);
    }

    private void initData() {
        mVideoView.setEncrypt(0,"qxueyou");
        mVideoView.requestFocus();
//        mVideoView.setVideoPath("rtmp://v56d7ba27.live.126.net/live/011edd9c0aeb410e9520c8880e2ed57f");
        mVideoView.setVideoPath("http://live.qxueyou.com/qxueyou/test1.flv?auth_key=1485748793-0-0-5b9858be1a708558d1616b86868b3240");
//        mVideoView.setVideoPath("rtmp://live.qxueyou.com.w.alikunlun.net/qlive/test1?vhost=live.qxueyou.com&auth_key=1482773439-0-0-523e0d7f3b1a89f5b23d68bbdd7f177f");
//        mVideoView.setVideoPath("http://v.qxueyou.com/video/297ebe0e51a076170151a3a57ab4275a/979ca0cbee3b451e90ddf30ee4211818_mp4_ld.MP4?Expires=1482732707&OSSAccessKeyId=STS.ECWGxcssbjXc9KVta6yVCx5rJ&Signature=VsyQHg3uCD8bloEHROkLeGNN6ZU%3D&security-token=CAIStgJ1q6Ft5B2yfSjIpIDiDMLXnqxD3ZqIO23nkGFjddlvl/DZqDz2IH1Jf3dqAu4fsf8%2BmWFR7/0ZlqdIV4R7RFfFccxq1JNT/FsftWRnQI/ng4YfgbiJREJ/YnyShb3FAYjQSNfaZY2QCTTtnTNyxr3XbCirW0ffX7SClZ9gaKZCPGy/diEUK9pKDBZpq8IGVx7WLu3/HRP2pWDSAUF02G97kngt0bmj5cee5xHC7jvh1vRHjp/qP52pVc5oMe0IMbGP0fdxa7DK3QNJ9hFO790WtqFf/irdtdzvaDs4oTf%2BarCNr4U1cVEgP/FlQfUc8sKRz6Mo5rbh8K3s0AtIMO1vVCDSeZut2sOsGpnya4tiK%2BygZS2SiYHSZ8Cs6Fg%2BB2kHLx1LYNs9LWVqDhghWothi0g8MaygGoABdLjrs2Ab%2Bj4DWJiDOYUokHWz/uRJexi5q2GFduZhPHOlZCybzAQxRcWRcMSFvdZma0MkqEaA/rtOa4MrHG6S9psMM42y4wQf4lDIYiveEAPkNyy0VDf0LnSRyRkHnZW0goLeyRA4WvcwUQtT6KLNRIBaTozUo2H3t8lpphMQKR0%3D");



        mVideoView.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                //隐藏加载进度条
                Log.e(TAG,"--------onPrepared-------");
                mVideoView.start();
            }
        });

        mVideoView.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(IMediaPlayer iMediaPlayer) {

                Log.e(TAG,"-------onCompletion---------");
            }
        });

        mVideoView.setOnErrorListener(new IMediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
                Log.e(TAG,"--------OnErrorListener--------i=" + i + "-----i1=---" + i1);
                return false;
            }
        });

        mVideoView.setOnInfoListener(new IMediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
                if (i == IMediaPlayer.MEDIA_INFO_BUFFERING_START) {

                } else if (i == IMediaPlayer.MEDIA_INFO_BUFFERING_END || i == IMediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {

                }
                Log.e(TAG," --------OnInfoListener-----i=" + i);
                return false;
            }
        });

    }
}
