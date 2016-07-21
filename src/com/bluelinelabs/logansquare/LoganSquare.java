package com.bluelinelabs.logansquare;

import com.bluelinelabs.logansquare.typeconverters.DefaultCalendarConverter;
import com.bluelinelabs.logansquare.typeconverters.DefaultDateConverter;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.JsonFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoganSquare
{
  public static final JsonFactory JSON_FACTORY = new JsonFactory();
  private static final Map<Class, JsonMapper> OBJECT_MAPPERS = new ConcurrentHashMap();
  private static final Map<Class, TypeConverter> TYPE_CONVERTERS = new HashMap();
  
  static
  {
    registerTypeConverter(Date.class, new DefaultDateConverter());
    registerTypeConverter(Calendar.class, new DefaultCalendarConverter());
  }
  
  public static <E> JsonMapper<E> mapperFor(Class<E> paramClass)
    throws NoSuchMapperException
  {
    JsonMapper localJsonMapper2 = (JsonMapper)OBJECT_MAPPERS.get(paramClass);
    JsonMapper localJsonMapper1 = localJsonMapper2;
    if (localJsonMapper2 == null) {}
    try
    {
      localJsonMapper1 = (JsonMapper)Class.forName(paramClass.getName() + "$$JsonObjectMapper").newInstance();
      OBJECT_MAPPERS.put(paramClass, localJsonMapper1);
      return localJsonMapper1;
    }
    catch (Exception localException)
    {
      throw new NoSuchMapperException(paramClass, localException);
    }
  }
  
  public static <E> E parse(InputStream paramInputStream, Class<E> paramClass)
    throws IOException
  {
    return (E)mapperFor(paramClass).parse(paramInputStream);
  }
  
  public static <E> E parse(String paramString, Class<E> paramClass)
    throws IOException
  {
    return (E)mapperFor(paramClass).parse(paramString);
  }
  
  public static <E> List<E> parseList(InputStream paramInputStream, Class<E> paramClass)
    throws IOException
  {
    return mapperFor(paramClass).parseList(paramInputStream);
  }
  
  public static <E> List<E> parseList(String paramString, Class<E> paramClass)
    throws IOException
  {
    return mapperFor(paramClass).parseList(paramString);
  }
  
  public static <E> Map<String, E> parseMap(InputStream paramInputStream, Class<E> paramClass)
    throws IOException
  {
    return mapperFor(paramClass).parseMap(paramInputStream);
  }
  
  public static <E> Map<String, E> parseMap(String paramString, Class<E> paramClass)
    throws IOException
  {
    return mapperFor(paramClass).parseMap(paramString);
  }
  
  public static <E> void registerTypeConverter(Class<E> paramClass, TypeConverter<E> paramTypeConverter)
  {
    TYPE_CONVERTERS.put(paramClass, paramTypeConverter);
  }
  
  public static <E> String serialize(E paramE)
    throws IOException
  {
    return mapperFor(paramE.getClass()).serialize(paramE);
  }
  
  public static <E> String serialize(List<E> paramList, Class<E> paramClass)
    throws IOException
  {
    return mapperFor(paramClass).serialize(paramList);
  }
  
  public static <E> String serialize(Map<String, E> paramMap, Class<E> paramClass)
    throws IOException
  {
    return mapperFor(paramClass).serialize(paramMap);
  }
  
  public static <E> void serialize(E paramE, OutputStream paramOutputStream)
    throws IOException
  {
    mapperFor(paramE.getClass()).serialize(paramE, paramOutputStream);
  }
  
  public static <E> void serialize(List<E> paramList, OutputStream paramOutputStream, Class<E> paramClass)
    throws IOException
  {
    mapperFor(paramClass).serialize(paramList, paramOutputStream);
  }
  
  public static <E> void serialize(Map<String, E> paramMap, OutputStream paramOutputStream, Class<E> paramClass)
    throws IOException
  {
    mapperFor(paramClass).serialize(paramMap, paramOutputStream);
  }
  
  public static <E> TypeConverter<E> typeConverterFor(Class<E> paramClass)
    throws NoSuchTypeConverterException
  {
    TypeConverter localTypeConverter = (TypeConverter)TYPE_CONVERTERS.get(paramClass);
    if (localTypeConverter == null) {
      throw new NoSuchTypeConverterException(paramClass);
    }
    return localTypeConverter;
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.LoganSquare
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */