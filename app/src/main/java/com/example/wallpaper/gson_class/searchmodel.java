package com.example.wallpaper.gson_class;

import java.util.ArrayList;

public class searchmodel {
    ArrayList<gson_class> photos;

    public searchmodel(ArrayList<gson_class> photos) {
        this.photos = photos;
    }

    public ArrayList<gson_class> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<gson_class> photos) {
        this.photos = photos;
    }

}
