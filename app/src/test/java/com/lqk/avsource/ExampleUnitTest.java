package com.lqk.avsource;

import com.lqk.avsource.type.Response;
import com.lqk.avsource.type.TypeToken;

import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testType() {
        new Response<String>(){
            @Override
            public void test() {
                System.out.println("test innerclass");
            }

            protected void test2() {
                System.out.println("test2 innerclass");
            }

        }.test2();

        Type type = new TypeToken<List<String>>(){}.getType();

        System.out.println(type.toString());
//        ParameterizedType parameterizedType = (ParameterizedType) type;
//        if (parameterizedType != null){
//            Type[] actualType = parameterizedType.getActualTypeArguments();
//            for (Type t : actualType){
//                System.out.println(t.toString());
//            }
//        }

    }
}