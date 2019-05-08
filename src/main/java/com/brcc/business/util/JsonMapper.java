package com.brcc.business.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonMapper
{
  private static Logger logger = LoggerFactory.getLogger(JsonMapper.class);
  private ObjectMapper mapper;

  public JsonMapper()
  {
    this(null);
  }

  
  public JsonMapper(JsonInclude.Include include) {
    this.mapper = new ObjectMapper();

    if (include != null) {
      //���ò����л�������
      this.mapper.setSerializationInclusion(include);
    }

    this.mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    this.mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
  }

  public static JsonMapper nonEmptyMapper()
  {
	//Include.NON_EMPTY ����Ϊ �գ�""��  ����Ϊ NULL �������л�  
    return new JsonMapper(JsonInclude.Include.NON_EMPTY);
  }

  public static JsonMapper nonNullMapper()
  {
    return new JsonMapper(JsonInclude.Include.NON_NULL);
  }

  public static JsonMapper nonDefaultMapper()
  {
    return new JsonMapper(JsonInclude.Include.NON_DEFAULT);
  }

  public String toJson(Object object)
  {
    try
    {
      // ����ObjectMapper��writeValueAsString����������ת����json����
      return this.mapper.writeValueAsString(object);
    } catch (IOException e) {
      logger.warn("write to json string error:" + object, e);
    }return null;
  }

  public <T> T fromJson(String jsonString, Class<T> clazz)
  {
    if ((jsonString == null) || (jsonString.length() <= 0)) {
      return null;
    }
    try
    {
      return this.mapper.readValue(jsonString, clazz);
    } catch (IOException e) {
      logger.warn("parse json string error:" + jsonString, e);
    }return null;
  }

  public <T> T fromJson(String jsonString, TypeReference<T> typeReference)
  {
    if ((jsonString == null) || (jsonString.length() <= 0)) {
      return null;
    }
    try
    {
      return this.mapper.readValue(jsonString, typeReference);
    } catch (IOException e) {
      logger.warn("parse json string error:" + jsonString, e);
    }return null;
  }

  public <T> T fromJson(String jsonString, JavaType javaType)
  {
    if ((jsonString == null) || (jsonString.length() <= 0)) {
      return null;
    }
    try
    {
      return this.mapper.readValue(jsonString, javaType);
    } catch (IOException e) {
      logger.warn("parse json string error:" + jsonString, e);
    }return null;
  }

  public JavaType createCollectionType(Class<?> collectionClass, Class<?>[] elementClasses)
  {
    return this.mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
  }

  public <T> T update(String jsonString, T object)
  {
    try
    {
      return this.mapper.readerForUpdating(object).readValue(jsonString);
    } catch (JsonProcessingException e) {
      logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
    } catch (IOException e) {
      logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
    }
    return null;
  }

  public String toJsonP(String functionName, Object object)
  {
    return toJson(new JSONPObject(functionName, object));
  }

  public void enableEnumUseToString()
  {
    this.mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    this.mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
  }

  public ObjectMapper getMapper()
  {
    return this.mapper;
  }
}