package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {
    @Query(value = "SELECT * FROM candidate "
            + "WHERE user_id = ?1 "
            + "OR company_id = ?2 "
            + "OR acceleration_id = ?3"
            + "LIMIT 1", nativeQuery = true)
    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

    @Query(value = "SELECT * FROM Candidate" +
            "WHERE company_id = ?1", nativeQuery = true)
    List<Candidate> findByCompanyId(Long companyId);

    @Query(value = "SELECT * FROM Candidate" +
            "WHERE acceleration_id = ?1", nativeQuery = true)
    List<Candidate> findByAccelerationId(Long accelerationId);
}
