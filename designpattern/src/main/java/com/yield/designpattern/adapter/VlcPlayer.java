package com.yield.designpattern.adapter;

/**
 * Created by yezid on 2018/5/7.
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void play() {
        System.out.println("Vlc播放ing....");
    }
}
