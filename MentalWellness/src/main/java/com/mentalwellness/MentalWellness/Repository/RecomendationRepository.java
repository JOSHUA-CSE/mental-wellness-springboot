package com.mentalwellness.MentalWellness.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mentalwellness.MentalWellness.model.Recomendation;
public interface RecomendationRepository extends JpaRepository<Recomendation,Long>{
    
}
