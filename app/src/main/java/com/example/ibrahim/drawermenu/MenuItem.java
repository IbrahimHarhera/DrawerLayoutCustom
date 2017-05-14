package com.example.ibrahim.drawermenu;

/**
 * Created by Ibrahim on 5/14/2017.
 */

public class MenuItem {
    private int imgId;
    private String title;

    public MenuItem(int imgId, String title) {
        this.imgId = imgId;
        this.title = title;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
