package com.example.wbsp19devanshiganatraserverside.services;

import com.example.wbsp19devanshiganatraserverside.model.Lesson;
import com.example.wbsp19devanshiganatraserverside.model.Topic;
import com.example.wbsp19devanshiganatraserverside.model.Widget;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LessonService {

    Widget widget1 = new Widget(101, "Heading", "Heading Widget" );

    List<Widget> widgets = new ArrayList<Widget>(){{
        widgets.add(widget1);
    }};

    Topic topic1 = new Topic(101, "Topic1", widgets);

    List<Topic> topics = new ArrayList<Topic>(){{
        topics.add(topic1);
    }};


    Lesson lesson1= new Lesson(1, "Lesson1", topics);

    List<Lesson> lessons = new ArrayList<Lesson>(){{
        lessons.add(lesson1);
    }};


    @PostMapping("/api/module/{mid}/lesson")
    public Lesson createLesson(
            @PathVariable("mid") Integer mid  , @RequestBody Lesson lesson) {
        lessons.add(lesson);
        return lesson;
    }


    @GetMapping("/api/module/{mid}/lesson")
    public List<Lesson> findAllLessons(
            @PathVariable("mid") Integer mid) {

        return lessons;
    }

    @GetMapping("/api/lesson/{lid}")
    public Lesson findLessonById(@PathVariable("lid") Integer id) {
        for (Lesson lesson : lessons) {
            if (id == lesson.getId().intValue())
                return lesson;
        }
        return null;
    }

    @PutMapping("/api/lesson/{lid}")
    public void updateLesson(@RequestBody Lesson lesson) {
        for (int i = 0; i < lessons.size(); i++) {
            if (lesson.getId() == lessons.get(i).getId().intValue()){
                lessons.get(i).setId(lesson.getId());
                lessons.get(i).setTitle(lesson.getTitle());
                lessons.get(i).setTopics(lesson.getTopics());
                break;
            }
        }

    }

    @DeleteMapping("/api/lesson/{lid}")
    public void deleteLesson(@PathVariable("lid") Integer id) {
        for (int i = 0; i < lessons.size(); i++) {
            if (id == lessons.get(i).getId().intValue()) {
                lessons.remove(i);
            }
        }

    }


}