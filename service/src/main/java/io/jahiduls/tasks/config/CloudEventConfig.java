package io.jahiduls.tasks.config;

import io.cloudevents.core.v1.CloudEventBuilder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Configuration
public class CloudEventConfig {

    @Setter
    @Value("${tasks.cloudevent.source}")
    private String CLOUD_EVENT_DEFAULT_SOURCE;

    @Setter
    @Value("${tasks.cloudevent.data.content.type}")
    private String CLOUD_EVENT_DATA_CONTENT_TYPE;

    @Setter
    @Value("${tasks.cloudevent.type}")
    private String CLOUD_EVENT_TYPE;

    @Bean
    public CloudEventBuilder cloudEventBuilder() {
        final CloudEventBuilder builder = new CloudEventBuilder();
        builder.withSource(URI.create(CLOUD_EVENT_DEFAULT_SOURCE))
                .withType(CLOUD_EVENT_TYPE)
                .withDataContentType(CLOUD_EVENT_DATA_CONTENT_TYPE);

        return builder;
    }

}
