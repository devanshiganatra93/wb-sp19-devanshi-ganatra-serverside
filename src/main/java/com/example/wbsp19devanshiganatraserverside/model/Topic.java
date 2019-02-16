package com.example.wbsp19devanshiganatraserverside.model;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private Long id;
    private String title;
    private List<Widget> widgets;

    public Topic () {}

    public Topic(Long id, String title, List<Widget> widgets) {
        this.id = id;
        this.title = title;
        this.widgets = widgets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }

}