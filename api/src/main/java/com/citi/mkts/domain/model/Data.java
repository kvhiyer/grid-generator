package com.citi.mkts.domain.model;

import com.google.common.base.Suppliers;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.function.Supplier;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public abstract class Data {

    private final transient Supplier<String> toString;

    public Data() {
        toString = Suppliers.memoize(this::getComputeToString);
    }

    @Override
    public String toString() {
        return toString == null ? getComputeToString() : toString.get();
    }

    private String getComputeToString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .setExcludeFieldNames("toString")
                .toString();
    }

    @Override
    public boolean equals(Object that) {
        return reflectionEquals(this, that, "toString");
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this, "toString");
    }
}
