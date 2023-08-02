package com.richard.domain;

import com.richard.infrastructure.clients.ActivityClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ActivityService {

    private final ActivityClient activityClient;
    public Activity getRandomActivity() {
        log.info("getRandomActivity service");
        return activityClient.getRandomActivity();
    }
}
