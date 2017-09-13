package com.eason.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;

/**
 * 使用FastJson解析请求参数字符串
 *
 * @author feng yingsheng
 */
public class FastJsonUtil {

    private static SerializerFeature[] features = {SerializerFeature.WriteNullNumberAsZero,
            SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect};

    public static Map<String, String> parseStringToStringMap(String str) {
        return JSON.parseObject(str, Map.class);
    }

    public static Map<String, Object> parseStringToObjectMap(String str) {
        return JSON.parseObject(str, Map.class);
    }

    public static List<Map> parseStringToStringList(String str) {
        return JSON.parseArray(str, Map.class);
    }

    public static Map parseStringToMap(String str) {
        return JSON.parseObject(str, Map.class);
    }

    public static List parseStringToList(String str) {
        return JSON.parseObject(str, List.class);
    }

    public static String object2Json(Object obj) {
        return JSON.toJSONString(obj, features);
    }

    public static <T> T parseStringToObject(String str, Class<T> tClass) {
        return JSON.parseObject(str, tClass);
    }
}
