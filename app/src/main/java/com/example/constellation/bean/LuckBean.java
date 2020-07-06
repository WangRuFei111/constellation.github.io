package com.example.constellation.bean;

import java.util.List;

public class LuckBean {


    /**
     * name : 双鱼座
     * date : 2020年
     * year : 2020
     * mima : {"info":"实现自己的价值","text":["2020年，流年木星摩羯进入双鱼座的第11
     * 宫。对于双鱼而言，最大的影响在人际关系和人生理想上。这一年左右时间里，双鱼可能会碰到一群很不错的朋友，这些朋友对于双鱼可以说是相互成就，或许还能给予双鱼指引，帮助双鱼找到真正的人生理想。当然，善良的双鱼在面对这种人际关系上要小心背叛和欺骗。"]}
     * career :
     * ["事业上，双鱼座在今年会得到不少好朋友的帮助，所以在处理事业问题上即使遇到困难也大多都会迎刃而解。学业上，双鱼座要回归现实，确定一个切合实际的目标，然后心无旁骛地踏实努力。"]
     * love : ["单身的双鱼在2020年会遇到一个懂得珍惜自己的人，这个人和你心意相通，对你也很有好感。有伴的双鱼今年要学会珍惜你的伴侣，不要沉浸在偶像剧般的爱情幻想中无法自拔。"]
     * health : ["双鱼今年要注意自己的心理压力调节问题，遇到压力或者是困难可以向身边亲近的人倾诉，不要自己一个人全部压在心里，这样对身体健康会有较大的影响。"]
     * finance :
     * ["双鱼今年在事业上会小有所成，所以收入也是不错的，可以学习理财和储蓄，让你的收入更加有价值。支出方面，双鱼今年在追星或者是虚拟网络上消费会比较多，建议适度就好，不要沉迷。"]
     * luckeyStone : 青金石
     * future :
     * resultcode : 200
     * error_code : 0
     */

    private String name;
    private String date;
    private int year;
    private MimaBean mima;
    private String luckeyStone;
    private String future;
    private String resultcode;
    private int error_code;
    private List<String> career;
    private List<String> love;
    private List<String> health;
    private List<String> finance;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public MimaBean getMima() {
        return mima;
    }

    public void setMima(MimaBean mima) {
        this.mima = mima;
    }

    public String getLuckeyStone() {
        return luckeyStone;
    }

    public void setLuckeyStone(String luckeyStone) {
        this.luckeyStone = luckeyStone;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<String> getCareer() {
        return career;
    }

    public void setCareer(List<String> career) {
        this.career = career;
    }

    public List<String> getLove() {
        return love;
    }

    public void setLove(List<String> love) {
        this.love = love;
    }

    public List<String> getHealth() {
        return health;
    }

    public void setHealth(List<String> health) {
        this.health = health;
    }

    public List<String> getFinance() {
        return finance;
    }

    public void setFinance(List<String> finance) {
        this.finance = finance;
    }

    public static class MimaBean {
        /**
         * info : 实现自己的价值
         * text : ["2020年，流年木星摩羯进入双鱼座的第11宫。对于双鱼而言，最大的影响在人际关系和人生理想上。这一年左右时间里，双鱼可能会碰到一群很不错的朋友，这些朋友对于双鱼可以说是相互成就，或许还能给予双鱼指引，帮助双鱼找到真正的人生理想。当然，善良的双鱼在面对这种人际关系上要小心背叛和欺骗。"]
         */

        private String info;
        private List<String> text;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public List<String> getText() {
            return text;
        }

        public void setText(List<String> text) {
            this.text = text;
        }
    }
}
