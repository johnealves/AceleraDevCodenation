package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {
    @Query(value = "SELECT * FROM acceleration AS ac "
            + "INNER JOIN candidate AS ca "
            + "ON ac.id = ca.acceleration_id "
            + "WHERE ca.company_id = ?1", nativeQuery = true)
    List<Acceleration> findByCompanyId(Long CompanyId);
}
