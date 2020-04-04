package com.industry_buying.industry_buying.repository;

import com.industry_buying.industry_buying.model.Cunique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuniqueRepository extends JpaRepository<Cunique, Integer> {

    @Query(value = "select * from cunique where message like %?1%",nativeQuery = true)
    List<Cunique> getAllResultsWithMessage(String query);
}
