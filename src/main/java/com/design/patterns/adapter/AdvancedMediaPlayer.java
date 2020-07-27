package com.design.patterns.adapter;

/**
 * 为更高级的媒体播放器创建接口
 */
public interface AdvancedMediaPlayer {

    public void playVlc(String fileName);
    public void playMp4(String fileName);
}
