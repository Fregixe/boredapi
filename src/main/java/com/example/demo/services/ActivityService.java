package com.example.demo.services;

import com.example.demo.model.Activity;
import com.example.demo.model.dtos.ActivityDto;
import com.example.demo.repositories.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private static final String BASE_URL = "https://www.boredapi.com/api/";
    private static final RestTemplate restTemplate = new RestTemplate();
    private final ActivityRepository activityRepository;

    public ActivityDto getActivity(){
        Activity activity;
        ResponseEntity<Activity> responseEntity;
        do {
            responseEntity = restTemplate.getForEntity(BASE_URL + "/activity", Activity.class);
            activity = activityRepository.findByKey(responseEntity.getBody().getKey());
        } while (activity != null);
        activity = responseEntity.getBody();
        activityRepository.save(activity);
        return ActivityDto.builder().activity(activity.getActivity()).build();
    }
}
