package com.brcc.business.util;

import com.fasterxml.jackson.databind.JavaType;
import java.util.List;

public class JSON
{
  private static JsonMapper mapper = new JsonMapper();

  public static String toJson(Object object) {
    return mapper.toJson(object);
  }

  public static <T> T parseObject(String jsonString, Class<T> clazz) {
    return mapper.fromJson(jsonString, clazz);
  }

  public static <T> List<T> parseArray(String jsonString, Class<T> clazz) {
    JavaType jt = mapper.createCollectionType(List.class, new Class[] { clazz });
    return (List)mapper.fromJson(jsonString, jt);
  }
}