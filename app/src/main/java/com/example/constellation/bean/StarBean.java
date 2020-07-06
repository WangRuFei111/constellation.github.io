package com.example.constellation.bean;

import java.io.Serializable;
import java.util.List;

public class StarBean implements Serializable {

    private List<StarinfoBean> starinfo;

    public List<StarinfoBean> getStarinfo() {
        return starinfo;
    }

    public void setStarinfo(List<StarinfoBean> starinfo) {
        this.starinfo = starinfo;
    }

    public static class StarinfoBean implements Serializable{
        /**
         * logoname : baiyang
         * name : 白羊座
         * date : 3月21日-4月19日
         * td : 热情活力
         * gw : 第一宫
         * yy : 阳性
         * tz : 控制
         * zg : 火星
         * ys : 红色
         * zb : 红宝石
         * hm : 5
         * js : 铁
         * info :
         * 白羊座有一种让人看见就觉得开心的感觉，因为总是看起来都是那么地热情、阳光、乐观、坚强，对朋友也慷概大方，性格直来直往，就是有点小脾气。白羊男有大男人主义的性格，而白羊女就是女汉子的形象。
         */

        private String logoname;
        private String name;
        private String date;
        private String td;
        private String gw;
        private String yy;
        private String tz;
        private String zg;
        private String ys;
        private String zb;
        private String hm;
        private String js;
        private String info;

        public String getLogoname() {
            return logoname;
        }

        public void setLogoname(String logoname) {
            this.logoname = logoname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTd() {
            return td;
        }

        public void setTd(String td) {
            this.td = td;
        }

        public String getGw() {
            return gw;
        }

        public void setGw(String gw) {
            this.gw = gw;
        }

        public String getYy() {
            return yy;
        }

        public void setYy(String yy) {
            this.yy = yy;
        }

        public String getTz() {
            return tz;
        }

        public void setTz(String tz) {
            this.tz = tz;
        }

        public String getZg() {
            return zg;
        }

        public void setZg(String zg) {
            this.zg = zg;
        }

        public String getYs() {
            return ys;
        }

        public void setYs(String ys) {
            this.ys = ys;
        }

        public String getZb() {
            return zb;
        }

        public void setZb(String zb) {
            this.zb = zb;
        }

        public String getHm() {
            return hm;
        }

        public void setHm(String hm) {
            this.hm = hm;
        }

        public String getJs() {
            return js;
        }

        public void setJs(String js) {
            this.js = js;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}
