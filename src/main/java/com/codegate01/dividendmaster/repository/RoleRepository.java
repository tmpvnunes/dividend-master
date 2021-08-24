package com.codegate01.dividendmaster.repository;

import com.codegate01.dividendmaster.model.ERole;
import com.codegate01.dividendmaster.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole role);
}
