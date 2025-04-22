package com.main.medula.repositories;

import com.main.medula.models.HighLightsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HighLightsRepository extends JpaRepository<HighLightsModel, Integer> {
    // Custom query methods can be defined here if needed
    // For example, you can add methods to find highlights by user or other criteria
}
