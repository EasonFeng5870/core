package com.eason.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("test", "tsetsdafsd");
        System.out.println(FastJsonUtil.object2Json(map));
    }
}
