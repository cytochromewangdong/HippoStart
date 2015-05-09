package com.dt.hippo.datajpa.data.repository.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dt.hippo.datajpa.model.jpa.Role;

public interface RoleJpaRepository extends JpaRepository<Role, Serializable>
{

}
