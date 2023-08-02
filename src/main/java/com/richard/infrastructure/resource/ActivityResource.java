package com.richard.infrastructure.resource;

import com.richard.domain.Activity;
import com.richard.domain.ActivityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/activity")
@RestController
public class ActivityResource {

    private final ActivityService activityService;

    @GetMapping
    public ResponseEntity<Activity> getRandomActivity() {
        log.info("getRandomActivity resource");
        return ResponseEntity.ok(activityService.getRandomActivity());
    }

}
