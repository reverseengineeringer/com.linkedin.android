package okhttp3;

import java.util.ArrayList;
import java.util.List;

public final class Headers$Builder
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

/* Location:
 * Qualified Name:     okhttp3.Headers.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */