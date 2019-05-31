package com.yield.designpattern.adapter;

/**
 * Created by yezid on 2018/5/7.
 */
public class Test {

    public static void main(String[] args) {
        MediaPlayer ap = new AudioPlayer();
        ap.play("mp3");
        ap.play("vlc");
        ap.play("mp4");
    }


}
