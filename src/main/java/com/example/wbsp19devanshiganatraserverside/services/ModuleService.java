package com.example.wbsp19devanshiganatraserverside.services;

import com.example.wbsp19devanshiganatraserverside.model.Lesson;
import com.example.wbsp19devanshiganatraserverside.model.Module;
import com.example.wbsp19devanshiganatraserverside.model.Topic;
import com.example.wbsp19devanshiganatraserverside.model.Widget;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ModuleService {

    Widget widget1 = new Widget(101, "Heading", "Heading Widget" );

    List<Widget> widgets = new ArrayList<Widget>(){{
        widgets.add(widget1);
    }};

    Topic topic1 = new Topic(101, "Topic1", widgets);

    List<Topic> topics = new ArrayList<Topic>(){{
        topics.add(topic1);
    }};

    Lesson lesson1 = new Lesson(101, "Lesson1", topics);

    List<Lesson> lessons = new ArrayList<Lesson>(){{
        lessons.add(lesson1);
    }};

    Module module1= new Module(1, "Module1", lessons);



}