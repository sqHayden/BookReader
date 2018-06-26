package com.idx.reader.subscribe;

/**
 * Created by steve on 17-9-19.
 * 数据对应JavaBean
 */

public class Subscribe {

    private int imageId;
    private String title;
    private String desc;
    private String comment;
    private String type;
    private String time;

    public Subscribe() {
    }

    public Subscribe(int imageId, String title, String desc, String comment, String type, String time) {
        this.imageId = imageId;
        this.title = title;
        this.desc = desc;
        this.comment = comment;
        this.type = type;
        this.time = time;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getComment() {
        return comment;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }
}
