package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.http.HttpDate;

public final class Headers
{
  public final String[] namesAndValues;
  
  private Headers(Builder paramBuilder)
  {
    namesAndValues = ((String[])namesAndValues.toArray(new String[namesAndValues.size()]));
  }
  
  private Headers(String[] paramArrayOfString)
  {
    namesAndValues = paramArrayOfString;
  }
  
  public static Headers of(String... paramVarArgs)
  {
    paramVarArgs = (String[])paramVarArgs.clone();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i] == null) {
        throw new IllegalArgumentException("Headers cannot be null");
      }
      paramVarArgs[i] = paramVarArgs[i].trim();
      i += 1;
    }
    i = 0;
    while (i < paramVarArgs.length)
    {
      String str1 = paramVarArgs[i];
      String str2 = paramVarArgs[(i + 1)];
      if ((str1.length() == 0) || (str1.indexOf(0) != -1) || (str2.indexOf(0) != -1)) {
        throw new IllegalArgumentException("Unexpected header: " + str1 + ": " + str2);
      }
      i += 2;
    }
    return new Headers(paramVarArgs);
  }
  
  public final String get(String paramString)
  {
    String[] arrayOfString = namesAndValues;
    int i = arrayOfString.length - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase(arrayOfString[i])) {
        return arrayOfString[(i + 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  public final Date getDate(String paramString)
  {
    paramString = get(paramString);
    if (paramString != null) {
      return HttpDate.parse(paramString);
    }
    return null;
  }
  
  public final String name(int paramInt)
  {
    return namesAndValues[(paramInt * 2)];
  }
  
  public final Builder newBuilder()
  {
    Builder localBuilder = new Builder();
    Collections.addAll(namesAndValues, namesAndValues);
    return localBuilder;
  }
  
  public final Map<String, List<String>> toMultimap()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    int i = 0;
    int j = namesAndValues.length / 2;
    while (i < j)
    {
      String str = name(i);
      List localList = (List)localLinkedHashMap.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList(2);
        localLinkedHashMap.put(str, localObject);
      }
      ((List)localObject).add(value(i));
      i += 1;
    }
    return localLinkedHashMap;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = namesAndValues.length / 2;
    while (i < j)
    {
      localStringBuilder.append(name(i)).append(": ").append(value(i)).append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public final String value(int paramInt)
  {
    return namesAndValues[(paramInt * 2 + 1)];
  }
  
  public final List<String> values(String paramString)
  {
    Object localObject1 = null;
    int i = 0;
    int j = namesAndValues.length / 2;
    while (i < j)
    {
      Object localObject2 = localObject1;
      if (paramString.equalsIgnoreCase(name(i)))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(2);
        }
        ((List)localObject2).add(value(i));
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null) {
      return Collections.unmodifiableList((List)localObject1);
    }
    return Collections.emptyList();
  }
  
  public static final class Builder
  {
    final List<String> namesAndValues = new ArrayList(20);
    
    private Builder addLenient(String paramString1, String paramString2)
    {
      namesAndValues.add(paramString1);
      namesAndValues.add(paramString2.trim());
      return this;
    }
    
    private static void checkNameAndValue(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new IllegalArgumentException("name == null");
      }
      if (paramString1.isEmpty()) {
        throw new IllegalArgumentException("name is empty");
      }
      int i = 0;
      int j = paramString1.length();
      int k;
      while (i < j)
      {
        k = paramString1.charAt(i);
        if ((k <= 31) || (k >= 127)) {
          throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1 }));
        }
        i += 1;
      }
      if (paramString2 == null) {
        throw new IllegalArgumentException("value == null");
      }
      i = 0;
      j = paramString2.length();
      while (i < j)
      {
        k = paramString2.charAt(i);
        if ((k <= 31) || (k >= 127)) {
          throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in %s value: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1, paramString2 }));
        }
        i += 1;
      }
    }
    
    public final Builder add(String paramString1, String paramString2)
    {
      checkNameAndValue(paramString1, paramString2);
      return addLenient(paramString1, paramString2);
    }
    
    final Builder addLenient(String paramString)
    {
      int i = paramString.indexOf(":", 1);
      if (i != -1) {
        return addLenient(paramString.substring(0, i), paramString.substring(i + 1));
      }
      if (paramString.startsWith(":")) {
        return addLenient("", paramString.substring(1));
      }
      return addLenient("", paramString);
    }
    
    public final Headers build()
    {
      return new Headers(this, (byte)0);
    }
    
    public final Builder removeAll(String paramString)
    {
      int j;
      for (int i = 0; i < namesAndValues.size(); i = j + 2)
      {
        j = i;
        if (paramString.equalsIgnoreCase((String)namesAndValues.get(i)))
        {
          namesAndValues.remove(i);
          namesAndValues.remove(i);
          j = i - 2;
        }
      }
      return this;
    }
    
    public final Builder set(String paramString1, String paramString2)
    {
      checkNameAndValue(paramString1, paramString2);
      removeAll(paramString1);
      addLenient(paramString1, paramString2);
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.Headers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */