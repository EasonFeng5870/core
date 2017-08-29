package com.eason.core;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        System.out.println(list);
        Map<String, String> maps = Maps.newConcurrentMap();
        maps.put("a", "a");
        System.out.println(maps);

        rateLimiter();

    }

    private static void rateLimiter() {

    }


}
