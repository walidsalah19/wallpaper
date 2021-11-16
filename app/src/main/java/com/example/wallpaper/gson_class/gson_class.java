package com.example.wallpaper.gson_class;

public class gson_class {
    Urlmodel src;
    String photographer;

    public gson_class(Urlmodel src, String photographer) {
        this.src = src;
        this.photographer = photographer;
    }

    public Urlmodel getSrc() {
        return src;
    }

    public void setSrc(Urlmodel src) {
        this.src = src;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }
}
