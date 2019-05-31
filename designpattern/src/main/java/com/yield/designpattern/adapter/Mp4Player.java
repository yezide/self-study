package com.yield.designpattern.adapter;

/**
 * Created by yezid on 2018/5/7.
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void play() {
        System.out.println("Mp4播放ing....");
    }
}
