package com.eason.core.unsafe;

import com.eason.core.unsafe.util.UnsafeUtils;
import sun.misc.Unsafe;

import java.util.Arrays;

/**
 * Created by feng yingsheng on 2/19/2017.
 */
public class UnsafeTest {

    private static Unsafe unsafe = UnsafeUtils.getUnsafe();

    public static void main(String[] args) {
        System.out.println("unsafe is " + unsafe);

        byte[] data = new byte[10];
        System.out.println(Arrays.toString(data));
        int byteArrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
        System.out.println(byteArrayBaseOffset);
        unsafe.putByte(data, (long) byteArrayBaseOffset, (byte)1);
        unsafe.putByte(data, (long)byteArrayBaseOffset + 5, (byte)5);
        System.out.println(Arrays.toString(data));
        byte[] data2 = new byte[10];
        System.out.println(Arrays.toString(data2));
        int byteArrayBaseOffset2 = unsafe.arrayBaseOffset(byte[].class);
        System.out.println(byteArrayBaseOffset2);
        unsafe.putByte(data2, (long) byteArrayBaseOffset2, (byte)1);
        unsafe.putByte(data2, (long)byteArrayBaseOffset2 + 5, (byte)5);
        System.out.println(Arrays.toString(data2));


    }

    private User makeUser() {
        User user = new User();
        user.setId(10);
        user.setUserName("eason");
        user.setPassword("123456");
        return user;
    }
}
