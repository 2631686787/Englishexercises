package com.example.a26316.yingyulianxi;

public  class data {

    public String zhongwen;
    public String yinwen;

    public String getZhongwen() {
        return zhongwen;
    }

    public void setZhongwen(String zhongwen) {
        this.zhongwen = zhongwen;
    }

    public String getYinwen() {
        return yinwen;
    }

    public void setYinwen(String yinwen) {
        this.yinwen = yinwen;
    }

    @Override
    public String toString() {
        return "data{" +
                "zhongwen='" + zhongwen + '\'' +
                ", yinwen='" + yinwen + '\'' +
                '}';
    }

    public data(String zhongwen, String yinwen) {
        this.zhongwen = zhongwen;
        this.yinwen = yinwen;
    }


}
