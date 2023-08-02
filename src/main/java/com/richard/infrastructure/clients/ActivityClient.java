package com.richard.infrastructure.clients;

import com.richard.domain.Activity;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Slf4j
@RequiredArgsConstructor
@Component
public class ActivityClient {
    private final String BORED_API = "https://www.boredapi.com/api/activity";


    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "randomActivity", fallbackMethod = "fallbackRandomActivity")
    public Activity getRandomActivity() {
        ResponseEntity<Activity> responseEntity = restTemplate.getForEntity(BORED_API, Activity.class);
        Activity activity = responseEntity.getBody();
        log.info("Activity received: " + activity.getActivity());
        return activity;
    }
    public String fallbackRandomActivity(Throwable throwable) {
        return "Watch a video from TechPrimers";
    }

}
