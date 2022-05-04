package com.example.demo.controllers;

import com.example.demo.model.dtos.ActivityDto;
import com.example.demo.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @GetMapping("/activity")
    public ActivityDto getActivity(){
        return activityService.getActivity();
    }
}
