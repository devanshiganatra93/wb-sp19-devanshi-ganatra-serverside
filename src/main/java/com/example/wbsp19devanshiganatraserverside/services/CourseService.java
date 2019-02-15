package com.example.wbsp19devanshiganatraserverside.services;

import com.example.wbsp19devanshiganatraserverside.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseService {

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

    List<Module> modules = new ArrayList<Module>(){{
        modules.add(module1);
    }};

    Course course1 = new Course(1, "Course1", modules);

    List<Course> courses = new ArrayList<Course>(){{
        courses.add(course1);
    }};

    @PostMapping("/api/courses")
    public Course createCourse(
            @RequestBody Course course) {
        courses.add(course);
        return course;
    }


    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {

        return courses;
    }

    @GetMapping("/api/courses/{cid}")
    public Course findCourseById(@PathVariable("cid") Integer id) {
        for (Course course : courses) {
            if (id == course.getId().intValue())
                return course;
        }
        return null;
    }

    @PutMapping("/api/courses/{cid}")
    public void updateCourse(@RequestBody Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (course.getId() == courses.get(i).getId().intValue()){
                courses.get(i).setId(course.getId());
                courses.get(i).setTitle(course.getTitle());
                courses.get(i).setModules(course.getModules());
                break;
            }
        }

    }

    @DeleteMapping("/api/courses/{cid}")
    public void deleteModule(@PathVariable("cid") Integer id) {
        for (int i = 0; i < courses.size(); i++) {
            if (id == courses.get(i).getId().intValue()) {
                courses.remove(i);
            }
        }

    }

}