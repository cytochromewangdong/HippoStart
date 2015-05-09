package com.dt.hippo.datajpa.data.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dt.hippo.datajpa.model.jpa.ContactHobbyDetail;
import com.dt.hippo.datajpa.model.jpa.ContactHobbyDetailKey;

/**
 * Repository : ContactHobbyDetail.
 */
public interface ContactHobbyDetailJpaRepository extends JpaRepository<ContactHobbyDetail, ContactHobbyDetailKey> {

}
