@FilterDef(name = "GLOBAL_FILTER", parameters = { @ParamDef(name = "status", type = "Number") }, defaultCondition = "sessParam = :sessParam")
@Filter(name="GLOBAL_FILTER")

package com.dt.hippo.auto.model.base;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

