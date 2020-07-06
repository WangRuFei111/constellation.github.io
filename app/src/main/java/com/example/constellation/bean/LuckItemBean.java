package com.example.constellation.bean;

public class LuckItemBean {
    private String title;
    private String content;
    private int colorId;

    public LuckItemBean(String title, String content, int colorId) {
        this.title = title;
        this.content = content;
        this.colorId = colorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }
}
