package com.twu.newbucketlist;

import android.util.Log;

import java.io.Serializable;


public class BucketItem implements Comparable<BucketItem>, Serializable{

    private String mTitle;
    private boolean mChecked;
    private String mDescription;


    public BucketItem(String title, boolean checked, String description) {
        this.mTitle = title.trim();
        this.mChecked = checked;
        this.mDescription = description.trim();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public boolean isChecked() {
        return mChecked;
    }

    public void setChecked(boolean checked) {
        this.mChecked = checked;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }


    @Override
    public int compareTo(BucketItem that) {
        if (this.mChecked && !that.isChecked()) {
            return 1;
        }
        else if (!this.mChecked && that.isChecked()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}


