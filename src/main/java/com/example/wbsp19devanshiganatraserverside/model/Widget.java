package com.example.wbsp19devanshiganatraserverside.model;

public class Widget {

    private Integer id;

    private String type;
    private Integer size;
    private String text;
    private String text1;
    private String items;
    private String src;
    private String title;
    private String href;

    public Widget () {}

    public Widget(Integer id, String type, String text1) {
        this.id = id;
        this.type = type;
        this.size = 1;
        this.text = "";
        this.text1 = text1;
        this.items = "List1, list2, list3, list4";
        this.src = "";
        this.title = "";
        this.href = "";
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
