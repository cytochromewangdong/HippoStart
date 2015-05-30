package com.dt.hippo.business.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.dt.hippo.auto.model.Promotiondetailinfo;
import com.dt.hippo.auto.model.Promotioninfo;

public class PromotionMangerBean
{
	private List<PromotionItem> promotionTable = new LinkedList<PromotionItem>();

	public void register(Promotioninfo promotionbean)
	{
		promotionTable.add(new PromotionItem(promotionbean));
	}

	public void finished()
	{
		Collections.sort(promotionTable,
				new Comparator<PromotionItem>()
				{

					@Override
					public int compare(PromotionItem o1,
							PromotionItem o2)
					{
						return o2.getPriority()
								- o1.getPriority();
					}

				});
	}

	public Promotioninfo getPromotioninfo(String category,
			long specification)
	{
		for (PromotionItem promotionItem : promotionTable)
		{
			if (promotionItem.getPromotioninfo().getType() == 0)
			{
				if(promotionItem.getPromotionMap().contains(category))
				{
					return promotionItem.getPromotioninfo();
				}
			} else
			{
				if(promotionItem.getPromotionMap().contains(specification))
				{
					return promotionItem.getPromotioninfo();
				}
			}
		}
		return null;
	}

	private static class PromotionItem
	{
		Set<Object> promotionMap;

		Promotioninfo promotioninfo;

		public Promotioninfo getPromotioninfo()
		{
			return promotioninfo;
		}

		private PromotionItem(Promotioninfo promotioninfo)
		{
			this.promotionMap = extractPromotionMap(promotioninfo);
			this.priority = calPriority(promotioninfo);
			this.promotioninfo = promotioninfo;
		}

		private int calPriority(Promotioninfo promotionbean)
		{
			// 0，全体定价 1，精确到门店的价格 0，全体门店 1，非全体门店（门店对应表有记录） 0：标准类型，1：群体促销
			return promotionbean.getTargettype() * 100
					+ promotionbean.getApplytoall() * 10
					+ promotionbean.getType();
		}

		private Set<Object> extractPromotionMap(
				Promotioninfo promotionBean)
		{
			Set<Object> promotionMap = new HashSet<Object>();
			// Promotioninfo promotionBean = promotioninfoServiceMapper
			// .mapPromotioninfoEntityToPromotioninfo(promotion);
			// 0：标准类型，1：群体促销
			if (promotionBean.getType() == 1)
			{
				String[] categoryList = promotionBean
						.getTargetcategorylist().split(",");
				for (String category : categoryList)
				{
					if (!StringUtils.isEmpty(category))
					{
						promotionMap
								.add(category);
					}
				}
			} else
			{
				for (Promotiondetailinfo promotiondetail : promotionBean
						.getListOfPromotiondetailinfo())
				{
					promotionMap
							.add(promotiondetail
									.getSpecificationid());
				}
			}

			return promotionMap;
		}

		public Set<Object> getPromotionMap()
		{
			return promotionMap;
		}

		public int getPriority()
		{
			return priority;
		}

		int priority;
	}
}
