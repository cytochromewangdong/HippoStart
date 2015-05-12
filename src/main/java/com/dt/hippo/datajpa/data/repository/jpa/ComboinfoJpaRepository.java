package com.dt.hippo.datajpa.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dt.hippo.datajpa.model.jpa.Comboinfo;
import com.dt.hippo.datajpa.model.jpa.ComboinfoKey;

/**
 * Repository : Comboinfo.
 */
public interface ComboinfoJpaRepository extends JpaRepository<Comboinfo, ComboinfoKey> {

}
