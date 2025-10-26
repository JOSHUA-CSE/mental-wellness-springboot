package com.mentalwellness.MentalWellness.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mentalwellness.MentalWellness.model.Recomendation;

public interface RecomendationRepository extends JpaRepository<Recomendation,Long>{

	@Query("SELECT r FROM Recomendation r WHERE r.user.user_id = :userId")
	List<Recomendation> findByUserId(@Param("userId") Long userId);
    
}
