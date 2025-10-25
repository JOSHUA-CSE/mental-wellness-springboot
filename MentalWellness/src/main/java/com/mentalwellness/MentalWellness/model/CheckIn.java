package com.mentalwellness.MentalWellness.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

public class CheckIn {
        
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long checkin_id;
    
    @OneToMany
    @JoinColumn(name="user_id")
    private User user;
    
    private int mood_level;
    private int stress_level;
    private float sleep_hours;
    private String notes;
    private String checkin_date;
}
