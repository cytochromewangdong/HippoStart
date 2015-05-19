package com.dt.hippo.business.base;

import java.util.Collection;
import java.util.List;

import com.dt.hippo.core.base.BaseBeanCommon;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public abstract class SuperService
{
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
						return input.getStatus() == null
								|| input.getStatus().equals(0);
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

}
