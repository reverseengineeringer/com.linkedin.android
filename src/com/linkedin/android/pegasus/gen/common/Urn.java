package com.linkedin.android.pegasus.gen.common;

import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Urn
{
  private static final Pattern PATTERN = Pattern.compile("urn:([a-z]{1}[a-z0-9\\-]{1,31}):([a-z]{1}\\w*)(?::(.+))?");
  public final TupleKey entityKey;
  public final String entityType;
  private final String namespace;
  private final String rawUrnString;
  
  public Urn(String paramString)
    throws URISyntaxException
  {
    rawUrnString = paramString;
    Matcher localMatcher = PATTERN.matcher(paramString);
    if (localMatcher.matches())
    {
      namespace = localMatcher.group(1);
      entityType = localMatcher.group(2);
      paramString = localMatcher.group(3);
      if (paramString != null)
      {
        entityKey = TupleKey.fromString(paramString);
        return;
      }
      entityKey = new TupleKey(new String[0]);
      return;
    }
    throw new URISyntaxException(paramString, "Invalid Urn");
  }
  
  private Urn(String paramString, TupleKey paramTupleKey)
  {
    this("li", paramString, paramTupleKey);
  }
  
  private Urn(String paramString1, String paramString2)
    throws URISyntaxException
  {
    this("li", paramString1, TupleKey.fromString(paramString2));
  }
  
  private Urn(String paramString1, String paramString2, TupleKey paramTupleKey)
  {
    namespace = paramString1;
    entityType = paramString2;
    entityKey = paramTupleKey;
    rawUrnString = ("urn:" + paramString1 + ":" + getNSS());
  }
  
  public static Urn createFromString(String paramString)
    throws URISyntaxException
  {
    return new Urn(paramString);
  }
  
  public static Urn createFromTuple(String paramString, Object... paramVarArgs)
  {
    return new Urn(paramString, TupleKey.create(paramVarArgs));
  }
  
  public static Urn createFromTupleWithNamespace(String paramString1, String paramString2, Object... paramVarArgs)
  {
    return new Urn(paramString1, paramString2, TupleKey.create(paramVarArgs));
  }
  
  public static Urn createFromTypeSpecificString(String paramString1, String paramString2)
    throws URISyntaxException
  {
    return new Urn(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!Urn.class.isAssignableFrom(paramObject.getClass()))) {}
    do
    {
      return false;
      paramObject = (Urn)paramObject;
    } while ((!entityType.equals(entityType)) || (!entityKey.equals(entityKey)) || (!namespace.equals(namespace)));
    return true;
  }
  
  public final String getId()
  {
    return entityKey.get(0);
  }
  
  public final String getLastId()
  {
    return entityKey.get(entityKey.size() - 1);
  }
  
  public final String getNSS()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(entityType);
    if (entityKey.size() > 0) {}
    for (String str = ":" + entityKey.toString();; str = "") {
      return str;
    }
  }
  
  public int hashCode()
  {
    return entityType.hashCode() * 31 + entityKey.hashCode();
  }
  
  public String toString()
  {
    return rawUrnString;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.Urn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */