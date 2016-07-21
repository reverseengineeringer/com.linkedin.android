package com.linkedin.android.pegasus.gen.common;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class TupleKey
{
  public List<String> tuple;
  
  private TupleKey(List<String> paramList)
  {
    tuple = Collections.unmodifiableList(paramList);
  }
  
  public TupleKey(String... paramVarArgs)
  {
    tuple = Arrays.asList(paramVarArgs);
  }
  
  public static TupleKey create(Object... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramVarArgs[i].toString());
      i += 1;
    }
    return new TupleKey(localArrayList);
  }
  
  public static TupleKey fromString(String paramString)
    throws URISyntaxException
  {
    return new TupleKey(parseKeyParts2(paramString));
  }
  
  private static List<String> parseKeyParts2(String paramString)
    throws URISyntaxException
  {
    Object localObject;
    if (paramString.isEmpty()) {
      localObject = Collections.emptyList();
    }
    int k;
    int i;
    do
    {
      return (List<String>)localObject;
      localObject = new ArrayList();
      int i2 = 0;
      int i1 = paramString.length();
      int n = 0;
      int i3 = 0;
      k = i1;
      i = i2;
      int m = n;
      int j = i3;
      if (paramString.charAt(0) == '(')
      {
        k = i1;
        i = i2;
        m = n;
        j = i3;
        if (paramString.charAt(paramString.length() - 1) == ')')
        {
          i = 1;
          k = i1 - 1;
          j = 1;
          m = n;
        }
      }
      while (i < k)
      {
        i1 = 0;
        StringBuilder localStringBuilder = new StringBuilder(paramString.length());
        n = j;
        j = m;
        m = i;
        i = i1;
        if ((m < k) && (i == 0))
        {
          char c = paramString.charAt(m);
          switch (c)
          {
          case '*': 
          case '+': 
          default: 
            localStringBuilder.append(c);
          }
          for (;;)
          {
            m += 1;
            break;
            localStringBuilder.append(c);
            j += 1;
            n = 1;
            continue;
            if (j == 0) {
              i = 1;
            }
            for (;;)
            {
              j -= 1;
              break;
              localStringBuilder.append(c);
            }
            if ((j == 0) && (n != 0)) {
              i = 1;
            } else {
              localStringBuilder.append(c);
            }
          }
        }
        if (localStringBuilder.length() == 0) {
          throw new URISyntaxException(paramString, "tuple element cannot be empty", m);
        }
        ((List)localObject).add(localStringBuilder.toString());
        i = m;
        m = j;
        j = n;
      }
      if (m != 0) {
        throw new URISyntaxException(paramString, "mismatched nesting", i);
      }
    } while (paramString.charAt(k - 1) != ',');
    throw new URISyntaxException(paramString, "mismatched nesting", i);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass())) {
      return tuple.equals(tuple);
    }
    return false;
  }
  
  public final String get(int paramInt)
  {
    return (String)tuple.get(paramInt);
  }
  
  public final int hashCode()
  {
    return tuple.hashCode();
  }
  
  public final int size()
  {
    return tuple.size();
  }
  
  public final String toString()
  {
    if (tuple.size() == 1) {
      return (String)tuple.get(0);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    int i = 0;
    Iterator localIterator = tuple.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i != 0) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(str);
      i = 1;
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.TupleKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */