package com.example.corodinatelayout;

/**
 * Created by wda on 2017/5/18.
 */
public class SelectpictureBeen {
    private int img;
    private String title;
    private int description;

    public SelectpictureBeen(int img, String title, int description){
        this.img=img;
        this.title=title;
        this.description = description;
    }
    public SelectpictureBeen(){};
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }
}
