package com.example.wbsp19devanshiganatraserverside.services;

import com.example.wbsp19devanshiganatraserverside.model.Lesson;
import com.example.wbsp19devanshiganatraserverside.model.Topic;
import com.example.wbsp19devanshiganatraserverside.model.Widget;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LessonService {

    Widget widget1 = new Widget(111111L, "Heading", "Heading Widget" );

    List<Widget> widgets = new ArrayList<Widget>(){{
        add(widget1);
    }};

    Topic topic1 = new Topic(111111L, "Topic1", widgets);

    List<Topic> topics = new ArrayList<Topic>(){{
        add(topic1);
    }};


    Lesson lesson1= new Lesson(111111L, "Lesson1", topics);

    List<Lesson> lessons = new ArrayList<Lesson>(){{
        add(lesson1);
    }};


    @PostMapping("/api/module/{mid}/lesson")
    public Lesson createLesson(
            @PathVariable("mid") Long mid  , @RequestBody Lesson lesson) {
        lessons.add(lesson);
        return lesson;
    }


    @GetMapping("/api/module/{mid}/lesson")
    public List<Lesson> findAllLessons(
            @PathVariable("mid") Long mid) {

        return lessons;
    }

    @GetMapping("/api/lesson/{lid}")
    public Lesson findLessonById(@PathVariable("lid") Long id) {
        for (Lesson lesson : lessons) {
            if (id == lesson.getId().longValue())
                return lesson;
        }
        return null;
    }

    @PutMapping("/api/lesson/{lid}")
    public void updateLesson(@RequestBody Lesson lesson) {
        for (int i = 0; i < lessons.size(); i++) {
            if (lesson.getId() == lessons.get(i).getId().longValue()){
                lessons.get(i).setId(lesson.getId());
                lessons.get(i).setTitle(lesson.getTitle());
                lessons.get(i).setTopics(lesson.getTopics());
                break;
            }
        }

    }

    @DeleteMapping("/api/lesson/{lid}")
    public void deleteLesson(@PathVariable("lid") Long id) {
        for (int i = 0; i < lessons.size(); i++) {
            if (id == lessons.get(i).getId().longValue()) {
                lessons.remove(i);
            }
        }

    }


}