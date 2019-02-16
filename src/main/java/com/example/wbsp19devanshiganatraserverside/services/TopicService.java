package com.example.wbsp19devanshiganatraserverside.services;

import com.example.wbsp19devanshiganatraserverside.model.Topic;
import com.example.wbsp19devanshiganatraserverside.model.Widget;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TopicService {

    Widget widget1 = new Widget(111111L, "Heading", "Heading Widget" );

    List<Widget> widgets = new ArrayList<Widget>(){{
        add(widget1);
    }};

    List<Topic> topics = new ArrayList<Topic>(){{
        add(topic1);
    }};

    Topic topic1= new Topic(111111L, "Topic1", widgets);

    @PostMapping("/api/lesson/{lid}/topic")
    public Topic createTopic(
            @PathVariable ("lid") Long lid  , @RequestBody Topic topic) {
        topics.add(topic);
        return topic;
    }


    @GetMapping("/api/lesson/{lid}/topic/")
    public List<Topic> findAllTopics(
            @PathVariable("lid") Long lid) {

        return topics;
    }

    @GetMapping("/api/topic/{tid}")
    public Topic findTopicById(@PathVariable("tid") Long id) {
        for (Topic topic : topics) {
            if (id == topic.getId().longValue())
                return topic;
        }
        return null;
    }

    @PutMapping("/api/topic/{tid}")
    public void updateTopic(@RequestBody Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            if (topic.getId() == topics.get(i).getId().longValue()){

                topics.get(i).setId(topic.getId());
                topics.get(i).setTitle(topic.getTitle());
                topics.get(i).setWidgets(topic.getWidgets());
                break;
            }
        }

    }

    @DeleteMapping("/api/topic/{tid}")
    public void deleteTopic(@PathVariable("tid") Long id) {
        for (int i = 0; i < topics.size(); i++) {
            if (id == topics.get(i).getId().longValue()) {
                topics.remove(i);
            }
        }

    }



}
