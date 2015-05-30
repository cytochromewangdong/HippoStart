package com.dt.hippo.business.common;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;

public class JSCompatibleIdGenerator extends ObjectIdGenerator<String>
{
	
    protected final Class<?> _scope;

    protected JSCompatibleIdGenerator(Class<?> scope) {
        _scope = scope;
    }

    @Override
    public final Class<?> getScope() {
        return _scope;
    }
    
    @Override
    public boolean canUseFor(ObjectIdGenerator<?> gen) {
        return (gen.getClass() == getClass()) && (gen.getScope() == _scope);
    }
    private static final long serialVersionUID = 1L;

    protected transient int _nextValue;

    public JSCompatibleIdGenerator() { this(Object.class, -1); }
    public JSCompatibleIdGenerator(Class<?> scope, int fv) {
        this(scope);
        _nextValue = fv;
    }

    protected int initialValue() { return 1; }
    
    @Override
    public ObjectIdGenerator<String> forScope(Class<?> scope) {
        return (_scope == scope) ? this : new JSCompatibleIdGenerator(scope, _nextValue);
    }
    
    @Override
    public ObjectIdGenerator<String> newForSerialization(Object context) {
        return new JSCompatibleIdGenerator(_scope, initialValue());
    }

    @Override
    public IdKey key(Object key) {
        return new IdKey(getClass(), _scope, key);
    }
    
    @Override
    public String generateId(Object forPojo) {
        int id = _nextValue;
        ++_nextValue;
        return "@$"+id;
    }
}