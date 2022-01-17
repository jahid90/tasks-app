package io.jahiduls.tasks.application;

import io.cloudevents.CloudEvent;

public interface MessageQueuePort {
    void dispatch(CloudEvent event, String routingKey);
}
