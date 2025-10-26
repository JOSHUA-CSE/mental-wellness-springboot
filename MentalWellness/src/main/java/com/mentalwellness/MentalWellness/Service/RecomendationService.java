package com.mentalwellness.MentalWellness.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentalwellness.MentalWellness.Repository.RecomendationRepository;
import com.mentalwellness.MentalWellness.model.Recomendation;

@Service
public class RecomendationService {
    @Autowired
    private RecomendationRepository rec_repo;

    public List<Recomendation> getAllRecomendations(Long id) {
        return rec_repo.findByUserId(id);
    }

    public List<Recomendation> getAllRecomendations() {
        return rec_repo.findAll();
    }

    public Recomendation createRecomendation(Recomendation user) {
        return rec_repo.save(user);
    }
}
