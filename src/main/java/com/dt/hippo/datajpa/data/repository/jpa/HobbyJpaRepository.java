package com.dt.hippo.datajpa.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dt.hippo.datajpa.model.jpa.Hobby;

/**
 * Repository : Hobby.
 */
public interface HobbyJpaRepository extends JpaRepository<Hobby, String> {

}
