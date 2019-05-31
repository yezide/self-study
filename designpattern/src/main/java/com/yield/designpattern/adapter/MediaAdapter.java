package com.yield.designpattern.adapter;

/**
 * Created by yezid on 2018/5/7.
 */
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer dmp;

    public MediaAdapter(String mediaType) {
        String className = MediaAdapter.class.getPackage().getName() + "." + mediaType.substring(0, 1).toUpperCase() + mediaType.substring(1) + "Player";
        try {
            // 反射初始化
            dmp = (AdvancedMediaPlayer) Class.forName(className).getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void play(String mediaType) {
        dmp.play();
    }
}
