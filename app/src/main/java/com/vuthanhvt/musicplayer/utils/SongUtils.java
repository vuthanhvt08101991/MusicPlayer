package com.vuthanhvt.musicplayer.utils;

/**
 * Create by FRAMGIA\vu.anh.thanh on 30/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class SongUtils.
 */
public class SongUtils {


    /**
     * Convert duration of song to string(00:00).
     * @param duration int
     * @return String
     */
    public static String convertDurationOfSong(long duration) {
        StringBuilder builder = new StringBuilder();
        long realDuration;
        realDuration = duration / 1000;
        if ((realDuration / 3600) > 0) {
            if ((realDuration / 3600) > 99) {
                builder.append("Too long (> 100h).");
            } else {
                int hours = (int) (realDuration / 3600);
                if (hours < 10) {
                    builder.append("0" + hours + ":");
                } else {
                    builder.append(hours + ":");
                }
                realDuration = realDuration - 3600 * hours;
            }
        }
        if ((realDuration / 60) > 0 ) {
            int mins = (int) (realDuration / 60);
            if (mins < 10 ) {
                builder.append("0" + mins + ":");
            } else {
                builder.append(mins + ":");
            }
            realDuration = realDuration - 60 * mins;
        } else {
            builder.append("00:");
        }
        if (realDuration > 10) {
            builder.append(realDuration);
        } else {
            builder.append("0" + realDuration);
        }
        return builder.toString();
    }
}
