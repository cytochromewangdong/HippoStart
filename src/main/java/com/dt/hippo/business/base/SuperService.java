package com.dt.hippo.business.base;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.dt.hippo.business.common.SequenceService;
import com.dt.hippo.business.exception.HippoResultException;
import com.dt.hippo.core.base.BaseBeanCommon;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public abstract class SuperService extends BaseService
{

	protected final PageRequest commonPage = new PageRequest(0,
			200, Direction.ASC, "createdate");

	protected ModelMapper modelMapper;

	/**
	 * Constructor.
	 */
	public SuperService()
	{
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(
				MatchingStrategies.STRICT);
	}

	// public <S, D> D map(S source, Class<S> sourceType, D destination,
	// TypeToken<D> destinationTypeToken, String typeMapName) {
	protected <T extends BaseBeanCommon> List<T> filterStatus(
			Collection<T> targetList)
	{

		return Lists.newArrayList(Collections2.filter(
				targetList, new Predicate<T>()
				{

					@Override
					public boolean apply(T input)
					{
						return isValidBeanWithStatus(input);
					}
				}));
		// Function<T, Integer> getNameFunction = new Function<T, Integer>() {
		// public String apply(T from) {
		// return from.getName();
		// }
		// };
		//
		// Ordering<Fruit> nameOrdering =
		// Ordering.natural().onResultOf(getNameFunction);
		//
		// ImmutableSortedSet<Fruit> sortedFruits =
		// ImmutableSortedSet.orderedBy(
		// nameOrdering).addAll(fruits).build();
	}

	protected <T extends BaseBeanCommon> boolean isValidBean(
			T input)
	{
		return isValidBeanWithStatus(input)
				&& isValidBeanWithinDate(input,
						utils.getCurrentDate());
	}

	protected <T extends BaseBeanCommon> boolean isValidBeanWithStatus(
			T input)
	{
		return input.getStatus() == null
				|| input.getStatus().equals(0);
	}

	protected <T extends BaseBeanCommon> boolean isValidBeanWithinDate(
			T bean, Date date)
	{
		// date = DateUtils.truncate(date, Calendar.DAY_OF_MONTH);
		return (bean.getStartdate() == null || bean
				.getStartdate().compareTo(date) <= 0)
				&& (bean.getEnddate() == null || bean
						.getEnddate().compareTo(date) >= 0);
	}

	protected boolean isValidEndate(Date compareDate)
	{
		return compareDate == null
				|| compareDate.compareTo(this.utils
						.getCurrentDate()) >= 0;
	}

	protected boolean isStrictValidEndate(Date compareDate)
	{
		return compareDate != null
				&& compareDate.compareTo(this.utils
						.getCurrentDate()) >= 0;
	}

	protected boolean isStrictValidDateRange(Date startDate,
			Date endDate)
	{
		return endDate != null
				&& endDate
						.compareTo(this.utils.getCurrentDate()) >= 0
				&& startDate != null
				&& startDate.compareTo(this.utils
						.getCurrentDate()) <= 0;
	}
	
    protected boolean isStrictValidTimeRange(Integer startTime, Integer endTime)
    {
        return endTime != null
                && endTime.compareTo(this.utils.getCurrentTime()) > 0
                && startTime != null
                && startTime.compareTo(this.utils.getCurrentTime()) <= 0;

    }
    
    protected boolean isToday(Date compareDateTime)
    {
        if (compareDateTime == null)
        {
            return false;
        }
        Date compareDate = this.utils.getDateFromDateTime(compareDateTime);
        return compareDate.compareTo(this.utils.getCurrentDate()) == 0;
    }

	protected long calculatePriceWithDiscount(long price,
			long discount)
	{
		return price * discount / 100;
	}

	@Resource
	protected MessageSource messageSource;

	@Resource(name = "businessSequenceService")
	protected SequenceService seqenceServiceProxy;

	protected String getMessage(String key, Object... objects)
	{
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(key, objects, locale);
	}

	protected void RaiseExceptionWithkey(String key,
			Object... objects)
	{
		HippoResultException.RaiseException(this.getMessage(key,
				objects));
	}
	// @Value("voucher.daterangeerrro")
	// protected Message notWithinValidate;
}
