package com.yield.designpattern.adapter;

import java.util.Objects;

/**
 * Created by yezid on 2018/5/7.
 */
public class AudioPlayer implements MediaPlayer {

    // 适配器类
    MediaAdapter ma;

    @Override
    public void play(String mediaType) {
        if(Objects.equals(mediaType, "mp3")) {
            System.out.println("音频播放ing....");
        } else {
            ma = new MediaAdapter(mediaType);
            ma.play(mediaType);
        }
    }
}
