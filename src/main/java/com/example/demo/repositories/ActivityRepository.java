package com.example.demo.repositories;

import com.example.demo.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Activity findByKey(String key);

}
