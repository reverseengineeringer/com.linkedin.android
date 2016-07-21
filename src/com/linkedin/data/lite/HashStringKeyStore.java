package com.linkedin.data.lite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class HashStringKeyStore
  implements JsonKeyStore
{
  private final Map<Integer, List<String>> bucketOfStrings = new HashMap();
  
  public final String get(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      j = j * 31 + paramArrayOfChar[i];
      i += 1;
    }
    Object localObject = (List)bucketOfStrings.get(Integer.valueOf(j));
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (paramInt2 != str.length()) {
          i = 0;
        }
        while (i != 0)
        {
          return str;
          j = paramInt1;
          i = 0;
          for (;;)
          {
            if (j >= paramInt1 + paramInt2) {
              break label159;
            }
            if (paramArrayOfChar[j] != str.charAt(i))
            {
              i = 0;
              break;
            }
            j += 1;
            i += 1;
          }
          label159:
          i = 1;
        }
      }
    }
    return null;
  }
  
  public final void put(String paramString)
  {
    Integer localInteger = Integer.valueOf(paramString.hashCode());
    List localList = (List)bucketOfStrings.get(localInteger);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      bucketOfStrings.put(localInteger, localObject);
    }
    ((List)localObject).add(paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.HashStringKeyStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */