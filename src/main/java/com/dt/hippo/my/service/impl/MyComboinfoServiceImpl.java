package com.dt.hippo.my.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.hippo.auto.business.service.impl.ComboinfoServiceImpl;
import com.dt.hippo.auto.data.repository.jpa.CategoryJpaRepository;
import com.dt.hippo.auto.data.repository.jpa.DishinfoJpaRepository;
import com.dt.hippo.auto.model.jpa.CategoryEntityKey;
import com.dt.hippo.auto.model.jpa.ComboinfoEntity;
//import com.dt.hippo.auto.model.jpa.ComboinfoEntity;
import com.dt.hippo.auto.model.jpa.DishinfoEntity;
import com.dt.hippo.auto.model.jpa.DishspecificationinfoEntity;
import com.dt.hippo.my.service.MyComboinfoService;

@Service
@Transactional
public class MyComboinfoServiceImpl extends ComboinfoServiceImpl implements
		MyComboinfoService {
	@Resource
	protected CategoryJpaRepository categoryJpaRepository;

	@Resource
	protected DishinfoJpaRepository dishinfoJpaRepository;

	public void createExampleData() {
		DishinfoEntity dishinfoEntity = new DishinfoEntity();
//
//		CategoryEntityKey categoryKey = new CategoryEntityKey(1l, "C01");
//		CategoryEntity category = categoryJpaRepository.findOne(categoryKey);
		// dishinfoEntity.setCategory(category);
		
		dishinfoEntity.setCategoryid("C01");
		dishinfoEntity.setCorpid(1l);
		dishinfoEntity.setNo("210");
		dishinfoEntity.setDishname("wangdong");
		dishinfoEntity.setPrice(5.8);
		// dishinfoEntity.setType((byte)1);
		dishinfoJpaRepository.save(dishinfoEntity);

//		categoryKey = new CategoryEntityKey(1l, "C02");
//		category = categoryJpaRepository.findOne(categoryKey);
//		dishinfoEntity = new DishinfoEntity();
//		// dishinfoEntity.setCategory(category);
//		dishinfoEntity.setNo("22");
//		dishinfoEntity.setDishname("牛肉汉堡2");
//		dishinfoEntity.setPrice(16.0);
//
//		dishinfoJpaRepository.save(dishinfoEntity);
//
//		categoryKey = new CategoryEntityKey(1l, "C03");
//		category = categoryJpaRepository.findOne(categoryKey);
//		dishinfoEntity = new DishinfoEntity();
//		// dishinfoEntity.setCategory(category);
//		dishinfoEntity.setNo("23");
//		dishinfoEntity.setDishname("薯条2");
//		dishinfoEntity.setPrice(9.0);
//
//		dishinfoJpaRepository.save(dishinfoEntity);
	}

    @PersistenceContext
    private EntityManager em;

    
	public void createComboInfo() {

		// uid BIGINT,
		// childId BIGINT,
		// specificationId BIGINT,
		// placeholder TINYINT,
		// orderInPlaceholder TINYINT,
		// amount INT,
		// priceDifference DOUBLE,

		// uid BIGINT AUTO_INCREMENT,
		// corpId BIGINT,
		// no VARCHAR(10),
		// categoryId VARCHAR(5),
		// dishName VARCHAR(200),
		// dishDescription VARCHAR(300),
		// imageUrl VARCHAR(300),
		// price DOUBLE,
		// type TINYINT DEFAULT 0 ,
		// hasSpecification TINYINT DEFAULT 0 ,
		// startDate INT DEFAULT 0 ,
		// endDate INT DEFAULT 99999999 ,
		// paused TINYINT DEFAULT 0 ,
		// promotionStartTime INT DEFAULT 0 ,
		// promotionEndTime INT DEFAULT 0 ,
		// promotionPrice DOUBLE DEFAULT 0 ,
		// ComboinfoEntity comboinfoEntity = comboinfoJpaRepository.findOne(id);
		//em.find(DishinfoEntity.class, 39l, LockModeType.PESSIMISTIC_WRITE);
		DishinfoEntity dishinfoEntity = dishinfoJpaRepository.findOne(39l);// new
																				// DishinfoEntity();
		// CategoryEntity category = dishinfoEntity.getCategory();

		List<ComboinfoEntity> list2 = dishinfoEntity.getListOfComboinfo();
		CategoryEntityKey categoryKey = new CategoryEntityKey(1l, "C01");

		categoryKey = new CategoryEntityKey(1l, "C04");
		// category = categoryJpaRepository.findOne(categoryKey);
		// List<DishinfoEntity> list = category.getListOfDishinfo();
		// System.out.println(list);
		System.out.println(list2);
		dishinfoEntity = new DishinfoEntity();
		dishinfoEntity.setCategoryid("C01");
		dishinfoEntity.setCorpid(1l);
		// dishinfoEntity.setCategory(category);
		dishinfoEntity.setNo("114");
		dishinfoEntity.setDishname("测试套餐");
		dishinfoEntity.setPrice(18.0);
		dishinfoEntity.setType((byte) 1);

//		dishinfoEntity = dishinfoJpaRepository.save(dishinfoEntity);

		List<ComboinfoEntity> comboList = new ArrayList<ComboinfoEntity>();
		dishinfoEntity.setListOfComboinfo(comboList);
		ComboinfoEntity comboinfoEntity = new ComboinfoEntity();
		// comboinfoEntity.setDishinfo(dishinfoEntity);
//		comboinfoEntity.setUid(dishinfoEntity.getUid());
//		comboinfoEntity.setChildid(7l);
//		comboinfoEntity.setSpecificationid(0L);
		comboinfoEntity.setMainDishinfo(dishinfoEntity);
		comboinfoEntity.setDishinfo(dishinfoJpaRepository.findOne(7l));
		comboinfoEntity.setPlaceholder((byte) 1);
		comboinfoEntity.setOrderinplaceholder((byte) 1);
		comboinfoEntity.setAmount(2);
		comboinfoEntity.setPricedifference(0.0);
		
		DishspecificationinfoEntity  specification = new DishspecificationinfoEntity();
		comboinfoEntity.setDishspecificationinfo(specification);
		comboList.add(comboinfoEntity);
		dishinfoJpaRepository.save(dishinfoEntity);

//		dishinfoEntity.getListOfComboinfo().add(comboinfoEntity);
//		this.comboinfoJpaRepository.save(comboinfoEntity);

//		comboinfoEntity = new ComboinfoEntity();
//		comboinfoEntity.setUid(dishinfoEntity.getUid());
//		// comboinfoEntity.setDishinfo(dishinfoEntity);
//		comboinfoEntity.setChildid(10l);
//		comboinfoEntity.setSpecificationid(0L);
//		comboinfoEntity.setPlaceholder((byte) 1);
//		comboinfoEntity.setAmount(2);
//		comboinfoEntity.setPricedifference(0.0);
//		comboinfoEntity.setOrderinplaceholder((byte) 1);
//		// dishinfoEntity.getListOfComboinfo().add(comboinfoEntity);
//		// this.comboinfoJpaRepository.save(comboinfoEntity);
//		dishinfoJpaRepository.save(dishinfoEntity);
//		if (1 == 1) {
//			return;
//		}

		// comboinfoEntity = new ComboinfoEntity();
		// comboinfoEntity.setUid(0l);
		// comboinfoEntity.setDishinfo(dishinfoEntity);
		// comboinfoEntity.setChildid(8l);
		// comboinfoEntity.setSpecificationid(0L);
		// comboinfoEntity.setPlaceholder((byte)1);
		// comboinfoEntity.setAmount(2);
		// comboinfoEntity.setPricedifference(0.0);
		// dishinfoEntity.getListOfComboinfo().add(comboinfoEntity);
		// this.comboinfoJpaRepository.save(comboinfoEntity);
		//
		//
		//
		// comboinfoEntity = new ComboinfoEntity();
		// comboinfoEntity.setUid(0l);
		// comboinfoEntity.setDishinfo(dishinfoEntity);
		// comboinfoEntity.setChildid(11l);
		// comboinfoEntity.setSpecificationid(0L);
		// comboinfoEntity.setPlaceholder((byte)1);
		// comboinfoEntity.setAmount(2);
		// comboinfoEntity.setPricedifference(0.0);
		// comboinfoEntity.setOrderinplaceholder((byte)1);
		// dishinfoEntity.getListOfComboinfo().add(comboinfoEntity);
		// this.comboinfoJpaRepository.save(comboinfoEntity);
		//
		//
		//
		// comboinfoEntity = new ComboinfoEntity();
		// comboinfoEntity.setUid(0l);
		// comboinfoEntity.setDishinfo(dishinfoEntity);
		// comboinfoEntity.setChildid(9l);
		// comboinfoEntity.setSpecificationid(0L);
		// comboinfoEntity.setPlaceholder((byte)1);
		// comboinfoEntity.setAmount(2);
		// comboinfoEntity.setPricedifference(0.0);
		// dishinfoEntity.getListOfComboinfo().add(comboinfoEntity);
		// this.comboinfoJpaRepository.save(comboinfoEntity);
		//
		//
		//
		// comboinfoEntity = new ComboinfoEntity();
		// comboinfoEntity.setUid(0l);
		// comboinfoEntity.setDishinfo(dishinfoEntity);
		// comboinfoEntity.setChildid(12l);
		// comboinfoEntity.setSpecificationid(0L);
		// comboinfoEntity.setPlaceholder((byte)1);
		// comboinfoEntity.setAmount(2);
		// comboinfoEntity.setPricedifference(0.0);
		// comboinfoEntity.setOrderinplaceholder((byte)1);
		// dishinfoEntity.getListOfComboinfo().add(comboinfoEntity);
		// this.comboinfoJpaRepository.save(comboinfoEntity);

		// dishinfoJpaRepository.save(dishinfoEntity);
		// comboinfoEntity.setPricedifference(0);

	}
}
