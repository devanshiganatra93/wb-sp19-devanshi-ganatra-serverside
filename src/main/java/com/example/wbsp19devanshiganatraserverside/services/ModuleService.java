package com.example.wbsp19devanshiganatraserverside.services;

import com.example.wbsp19devanshiganatraserverside.model.Lesson;
import com.example.wbsp19devanshiganatraserverside.model.Module;
import com.example.wbsp19devanshiganatraserverside.model.Topic;
import com.example.wbsp19devanshiganatraserverside.model.Widget;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ModuleService {

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

    Module module1 = new Module(111111L, "Module1", lessons);

    List<Module> modules = new ArrayList<Module>(){{
        add(module1);
    }};

    @PostMapping("/api/courses/{cid}/modules")
    public Module createModule(
            @PathVariable("cid") Long mid  , @RequestBody Module module) {
        modules.add(module);
        return module;
    }


    @GetMapping("api/course/{cid}/modules")
    public List<Module> findAllModules(
            @PathVariable("cid") Long cid) {

        return modules;
    }

    @GetMapping("api/modules/{mid}")
    public Module findModuleById(@PathVariable("mid") Long id) {
        for (Module module : modules) {
            if (id == module.getId().longValue())
                return module;
        }
        return null;
    }

    @PutMapping("/api/modules/{mid}")
    public void updateModule(@RequestBody Module module) {
        for (int i = 0; i < modules.size(); i++) {
            if (module.getId() == modules.get(i).getId().longValue()){
                modules.get(i).setId(module.getId());
                modules.get(i).setTitle(module.getTitle());
                modules.get(i).setLessons(module.getLessons());
                break;
            }
        }

    }

    @DeleteMapping("/api/modules/{mid}")
    public void deleteModule(@PathVariable("mid") Long id) {
        for (int i = 0; i < modules.size(); i++) {
            if (id == modules.get(i).getId().longValue()) {
                modules.remove(i);
            }
        }

    }



}