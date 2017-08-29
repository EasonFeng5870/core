package com.eason.core.unsafe.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by feng yingsheng on 2/19/2017.
 */
public class UnsafeUtils {

    public static Unsafe getUnsafe() {
        Field f;
        try{
            f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return  (Unsafe) f.get(null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
