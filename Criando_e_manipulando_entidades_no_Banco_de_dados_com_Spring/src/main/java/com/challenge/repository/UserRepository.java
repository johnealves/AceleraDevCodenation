package com.challenge.repository;

import com.challenge.entity.Company;
import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT * FROM users AS u "
            + "INNER JOIN candidate AS c "
            + "ON u.id = c.user_id "
            + "INNER JOIN company AS co "
            + "ON co.id = c.company_id "
            + "WHERE co.id = ?1", nativeQuery = true)
    List<User> findByCompanyId(Long id);

    @Query(value = "SELECT * FROM Users AS u "
            + "INNER JOIN Candidate AS c "
            + "ON u.id = c.user_id "
            + "INNER JOIN Acceleration AS a "
            + "ON a.id = c.acceleration_id "
            + "WHERE a.name = ?1", nativeQuery = true)
    List<User> findByAccelerationName(String acceleration);

//    @Query(value = "SELECT * FROM users AS u" +
//            "INNER JOIN Candidate AS c" +
//            "ON u.id = c.user_id" +
//            "INNER JOIN Acceleration AS a" +
//            "ON a.id = c.acceleration_id" +
//            "WHERE a.name = ?1", nativeQuery = true)
//    List<User> findByAccelerationName(String name);
}
