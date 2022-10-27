package dev.danvega.newsletter.functions;

import dev.danvega.newsletter.model.Subscriber;
import dev.danvega.newsletter.service.SubscriberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class Subscribers {

    private final SubscriberService subscriberService;

    public Subscribers(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @Bean
    public Consumer<String> create() {
        return (email) -> subscriberService.create(email);
    }

    @Bean
    public Supplier<List<Subscriber>> findAll() {
        return () -> subscriberService.findAll();
    }

}
