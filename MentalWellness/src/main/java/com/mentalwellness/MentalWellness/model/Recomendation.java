package com.mentalwellness.MentalWellness.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Recomendation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long rec_id;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    private String recomendation;
    Timestamp created_at=new Timestamp(System.currentTimeMillis());
 
}
