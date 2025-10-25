package com.mentalwellness.MentalWellness.Service;

import  java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentalwellness.MentalWellness.Repository.CheckInRepository;
import com.mentalwellness.MentalWellness.model.CheckIn;

@Service
public class CheckInService {
    @Autowired
    private CheckInRepository checkIn_repo;

    public Optional<CheckIn> getAllCheckIns(Long id) {
        return checkIn_repo.findById(id);
    }

    public CheckIn createCheckIn(CheckIn user) {
        return checkIn_repo.save(user);
    }
}
