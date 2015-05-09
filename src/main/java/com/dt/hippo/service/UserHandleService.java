package com.dt.hippo.service;

import javax.annotation.Resource;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.hippo.core.base.BaseService;

@Service
@Transactional
public class UserHandleService extends BaseService {
	
	@Resource
	private PasswordEncoder passwordEncoder;
	
}
