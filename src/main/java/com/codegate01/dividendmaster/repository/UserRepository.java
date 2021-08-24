package com.codegate01.dividendmaster.repository;

import com.codegate01.dividendmaster.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);
    Optional<User> findByEmail(String email);

    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);

    Optional<User> findUserByUserId(Long id);

    @Transactional
    void deleteUserByUserId(Long id);

    @Transactional
    @Modifying
    @Query("update User u set u.password = :password where u.userId =:id")
    void updateUserPassword(@Param(value = "id") Long id, @Param(value="password") String password);

}
