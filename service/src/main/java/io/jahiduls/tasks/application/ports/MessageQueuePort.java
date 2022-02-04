package io.jahiduls.tasks.application.ports;

import io.cloudevents.CloudEvent;

public interface MessageQueuePort {
    void dispatch(CloudEvent event, String routingKey);
}
