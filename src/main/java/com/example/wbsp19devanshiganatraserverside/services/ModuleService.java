package com.example.wbsp19devanshiganatraserverside.services;

import com.example.wbsp19devanshiganatraserverside.model.Lesson;
import com.example.wbsp19devanshiganatraserverside.model.Module;
import com.example.wbsp19devanshiganatraserverside.model.Topic;
import com.example.wbsp19devanshiganatraserverside.model.Widget;
import org.springframework.web.bind.annotation.*;

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

    Module module1 = new Module(101, "Module1", lessons);

    List<Module> modules = new ArrayList<Module>(){{
        modules.add(module1);
    }};

    @PostMapping("/api/courses/{cid}/modules")
    public Module createModule(
            @PathVariable("cid") Integer mid  , @RequestBody Module module) {
        modules.add(module);
        return module;
    }


    @GetMapping("api/course/{cid}/modules")
    public List<Module> findAllModules(
            @PathVariable("cid") Integer cid) {

        return modules;
    }

    @GetMapping("api/modules/{mid}")
    public Module findModuleById(@PathVariable("mid") Integer id) {
        for (Module module : modules) {
            if (id == module.getId().intValue())
                return module;
        }
        return null;
    }

    @PutMapping("/api/modules/{mid}")
    public void updateModule(@RequestBody Module module) {
        for (int i = 0; i < modules.size(); i++) {
            if (module.getId() == modules.get(i).getId().intValue()){
                modules.get(i).setId(module.getId());
                modules.get(i).setTitle(module.getTitle());
                modules.get(i).setLessons(module.getLessons());
                break;
            }
        }

    }

    @DeleteMapping("/api/modules/{mid}")
    public void deleteModule(@PathVariable("mid") Integer id) {
        for (int i = 0; i < modules.size(); i++) {
            if (id == modules.get(i).getId().intValue()) {
                modules.remove(i);
            }
        }

    }



}