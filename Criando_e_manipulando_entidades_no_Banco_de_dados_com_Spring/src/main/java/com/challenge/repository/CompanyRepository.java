package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
    @Query(value = "SELECT * FROM Company as co" +
            "INNER JOIN Candidate as ca" +
            "ON co.id = ca.company_id" +
            "INNER JOIN Acceleration as ac" +
            "ON ac.id = ca.acceleration_id" +
            "WHERE ac.id = ?1", nativeQuery = true
    )
    List<Company> findByAccelerationId(Long accelerationId);

    @Query(value = "SELECT * FROM Company as co" +
            "INNER JOIN Candidate as ca" +
            "ON co.id = ca.company_id" +
            "INNER JOIN users as u" +
            "ON u.id = ca.user_id" +
            "WHERE u.id = ?1", nativeQuery = true
    )
    List<Company> findByUserId(Long userId);

}
