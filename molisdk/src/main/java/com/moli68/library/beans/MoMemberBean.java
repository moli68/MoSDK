package com.moli68.library.beans;

import java.io.Serializable;

/**
 * 会员信息
 * Created by Administrator on 2018/9/28/0028.
 */

public class MoMemberBean implements Serializable {
    /**
     * count : 0
     * end_time :
     */

    private int count;
    private String end_time;
    private int over;  //会员是否过期  1表示过期了  0没过期

    public int getOver() {
        return over;
    }

    public void setOver(int over) {
        this.over = over;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "MoMemberBean{" +
                "count=" + count +
                ", end_time='" + end_time + '\'' +
                ", over=" + over +
                '}';
    }
}
