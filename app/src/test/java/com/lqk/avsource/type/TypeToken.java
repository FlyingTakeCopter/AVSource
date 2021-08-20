package com.lqk.avsource.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeToken<T> {

    final Type type;

    protected TypeToken() {
        this. type = getSuperClassTypeParameter(getClass());
    }

    private Type getSuperClassTypeParameter(Class<? extends TypeToken> aClass) {
        Type supperClass = aClass.getGenericSuperclass();

        ParameterizedType parameterizedType = (ParameterizedType) supperClass;

        return parameterizedType.getActualTypeArguments()[0];
    }

    public Type getType() {
        return type;
    }
}
