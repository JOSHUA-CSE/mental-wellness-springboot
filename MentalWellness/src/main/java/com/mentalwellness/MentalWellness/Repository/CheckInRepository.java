package com.mentalwellness.MentalWellness.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mentalwellness.MentalWellness.model.CheckIn;

public interface CheckInRepository extends JpaRepository<CheckIn,Long>{
    
}
