package com.test.notificationservice.services;

import com.google.api.core.ApiFuture;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import org.springframework.stereotype.Component;
import pojo.Notifications;
import utils.JsonParser;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class DataPublisher {

    public void publish(String projectId, String topicId, Notifications notifications)
            throws IOException, ExecutionException, InterruptedException {

        TopicName topicName = TopicName.of(projectId, topicId);
        com.google.cloud.pubsub.v1.Publisher publisher = null;

        try {
            // Create a publisher instance with default settings bound to the topic
            publisher = com.google.cloud.pubsub.v1.Publisher.newBuilder(topicName).build();

            String message = JsonParser.toJson(notifications);
            ByteString data = ByteString.copyFromUtf8(message);
            PubsubMessage pubsubMessage =
                    PubsubMessage.newBuilder()
                            .setData(data)
                            .putAllAttributes(ImmutableMap.of("year", "2020", "author", "unknown"))
                            .build();

            // Once published, returns a server-assigned message id (unique within the topic)
            ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
            String messageId = messageIdFuture.get();
            System.out.println("Published a message with custom attributes: " + messageId);

        } finally {
            if (publisher != null) {
                // When finished with the publisher, shutdown to free up resources.
                publisher.shutdown();
                publisher.awaitTermination(1, TimeUnit.MINUTES);
            }
        }
    }
}