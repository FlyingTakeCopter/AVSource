package com.lqk.avsource;

import com.lqk.avsource.type.Response;
import com.lqk.avsource.type.TypeToken;

import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
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

        int a = 0;
        Integer b = 0;
        System.out.println(a == b);

        Integer c = 100;
        Integer d = 100;
        System.out.println(c == d);
        System.out.println(c.equals(d));

        c = 200;
        d = 200;
        System.out.println(c == d);
        System.out.println(c.equals(d));

//        Integer.valueOf();
//        Long.valueOf();
//        Double.valueOf();
//        String.valueOf()

//        ParameterizedType parameterizedType = (ParameterizedType) type;
//        if (parameterizedType != null){
//            Type[] actualType = parameterizedType.getActualTypeArguments();
//            for (Type t : actualType){
//                System.out.println(t.toString());
//            }
//        }

        Sum sum = (x, y) -> x + y;
        setSum((x, y) -> x - y);
    }

    private void setSum(Sum sum){

    }

    interface Sum {
        int add(int x, int y);
    }
}