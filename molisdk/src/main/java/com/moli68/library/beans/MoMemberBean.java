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
}
