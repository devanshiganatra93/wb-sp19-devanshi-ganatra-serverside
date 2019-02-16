package com.example.wbsp19devanshiganatraserverside.services;

import com.example.wbsp19devanshiganatraserverside.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CourseService {

    Widget widget1 = new Widget(111111L, "Heading", "Heading Widget" );

    List<Widget> widgets = new ArrayList<Widget>(){{
        add(widget1);
    }};

    Topic topic1 = new Topic(111111L, "Topic1", widgets);

    List<Topic> topics = new ArrayList<Topic>(){{
        add(topic1);
    }};

    Lesson lesson1 = new Lesson(111111L, "Lesson1", topics);

    List<Lesson> lessons = new ArrayList<Lesson>(){{
        add(lesson1);
    }};

    Module module1= new Module(111111L, "Module1", lessons);

    List<Module> modules = new ArrayList<Module>(){{
        add(module1);
    }};

    Course course1 = new Course(111111L, "Course1", modules);

    List<Course> courses = new ArrayList<Course>(){{
        add(course1);
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
    public Course findCourseById(@PathVariable("cid") Long id) {
        for (Course course : courses) {
            if (id == course.getId().longValue())
                return course;
        }
        return null;
    }

    @PutMapping("/api/courses/{cid}")
    public void updateCourse(@PathVariable("cid") Long id, @RequestBody Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (course.getId() == courses.get(i).getId().longValue()){
                courses.get(i).setId(course.getId());
                courses.get(i).setTitle(course.getTitle());
                courses.get(i).setModules(course.getModules());
                break;
            }
        }

    }

    @DeleteMapping("/api/courses/{cid}")
    public void deleteCourse(@PathVariable("cid") Long id) {
        for (int i = 0; i < courses.size(); i++)
        {
            if (id == courses.get(i).getId().longValue()) {
                courses.remove(i);
            }
        }

    }

}