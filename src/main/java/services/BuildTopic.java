package services;


import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import org.springframework.stereotype.Component;
import utils.Configurations;
import utils.JsonParser;

import java.io.IOException;

@Component
public class BuildTopic {


    public Topic createTopic(String projectId, String topicId) throws IOException {
        try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
            TopicName topicName = TopicName.of(projectId, topicId);

            ProjectName projectName = ProjectName.of(projectId);
            Topic  topic = null;

            boolean isPresent = false;
            for (Topic top : topicAdminClient.listTopics(projectName).iterateAll()) {
                if(top != null && top.getName().equals(topicId)){
                    topic = top;
                    isPresent = true;
                    break;
                }
            }

            if(!isPresent){
                topic = topicAdminClient.createTopic(topicName);
            }

            System.out.println("Topic Created, name: " + topic.getName());
            return topic;
        }
    }
}
