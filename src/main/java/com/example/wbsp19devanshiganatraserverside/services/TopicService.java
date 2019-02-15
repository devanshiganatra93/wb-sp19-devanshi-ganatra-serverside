package com.example.wbsp19devanshiganatraserverside.services;

import com.example.wbsp19devanshiganatraserverside.model.Topic;
import com.example.wbsp19devanshiganatraserverside.model.Widget;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TopicService {

    Widget widget1 = new Widget(101, "Heading", "Heading Widget" );

    List<Widget> widgets = new ArrayList<Widget>(){{
        widgets.add(widget1);
    }};

    List<Topic> topics = new ArrayList<Topic>(){{
        topics.add(topic1);
    }};

    Topic topic1= new Topic(1, "Topic1", widgets);

    @PostMapping("/api/lesson/{lid}/topic")
    public Topic createTopic(
            @PathVariable ("lid") Integer lid  , @RequestBody Topic topic) {
        topics.add(topic);
        return topic;
    }


    @GetMapping("/api/lesson/{lid}/topic/")
    public List<Topic> findAllTopics(
            @PathVariable("lid") Integer lid) {

        return topics;
    }

    @GetMapping("/api/topic/{tid}")
    public Topic findTopicById(@PathVariable("tid") Integer id) {
        for (Topic topic : topics) {
            if (id == topic.getId().intValue())
                return topic;
        }
        return null;
    }

    @PutMapping("/api/topic/{tid}")
    public void updateTopic(@RequestBody Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            if (topic.getId() == topics.get(i).getId().intValue()){

                topics.get(i).setId(topic.getId());
                topics.get(i).setTitle(topic.getTitle());
                topics.get(i).setWidgets(topic.getWidgets());
                break;
            }
        }

    }

    @DeleteMapping("/api/topic/{tid}")
    public void deleteTopic(@PathVariable("tid") Integer id) {
        for (int i = 0; i < topics.size(); i++) {
            if (id == topics.get(i).getId().intValue()) {
                topics.remove(i);
            }
        }

    }



}
