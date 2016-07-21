package okhttp3;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.http.HeaderParser;

public final class CacheControl
{
  public static final CacheControl FORCE_CACHE;
  public static final CacheControl FORCE_NETWORK;
  String headerValue;
  public final boolean isPrivate;
  public final boolean isPublic;
  public final int maxAgeSeconds;
  public final int maxStaleSeconds;
  public final int minFreshSeconds;
  public final boolean mustRevalidate;
  public final boolean noCache;
  public final boolean noStore;
  private final boolean noTransform;
  public final boolean onlyIfCached;
  private final int sMaxAgeSeconds;
  
  static
  {
    Builder localBuilder = new Builder();
    noCache = true;
    FORCE_NETWORK = localBuilder.build();
    localBuilder = new Builder();
    onlyIfCached = true;
    long l = TimeUnit.SECONDS.toSeconds(2147483647L);
    if (l > 2147483647L) {}
    for (int i = Integer.MAX_VALUE;; i = (int)l)
    {
      maxStaleSeconds = i;
      FORCE_CACHE = localBuilder.build();
      return;
    }
  }
  
  private CacheControl(Builder paramBuilder)
  {
    noCache = noCache;
    noStore = noStore;
    maxAgeSeconds = maxAgeSeconds;
    sMaxAgeSeconds = -1;
    isPrivate = false;
    isPublic = false;
    mustRevalidate = false;
    maxStaleSeconds = maxStaleSeconds;
    minFreshSeconds = minFreshSeconds;
    onlyIfCached = onlyIfCached;
    noTransform = noTransform;
  }
  
  private CacheControl(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, String paramString)
  {
    noCache = paramBoolean1;
    noStore = paramBoolean2;
    maxAgeSeconds = paramInt1;
    sMaxAgeSeconds = paramInt2;
    isPrivate = paramBoolean3;
    isPublic = paramBoolean4;
    mustRevalidate = paramBoolean5;
    maxStaleSeconds = paramInt3;
    minFreshSeconds = paramInt4;
    onlyIfCached = paramBoolean6;
    noTransform = paramBoolean7;
    headerValue = paramString;
  }
  
  public static CacheControl parse(Headers paramHeaders)
  {
    boolean bool7 = false;
    boolean bool6 = false;
    int i1 = -1;
    int n = -1;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    int m = -1;
    int k = -1;
    boolean bool2 = false;
    boolean bool1 = false;
    int i = 1;
    Object localObject1 = null;
    int i2 = 0;
    int i8 = namesAndValues.length / 2;
    while (i2 < i8)
    {
      String str2 = paramHeaders.name(i2);
      String str1 = paramHeaders.value(i2);
      int i3;
      if (str2.equalsIgnoreCase("Cache-Control")) {
        if (localObject1 != null)
        {
          i = 0;
          i3 = 0;
        }
      }
      label92:
      boolean bool8;
      boolean bool9;
      int j;
      int i4;
      boolean bool10;
      boolean bool11;
      boolean bool12;
      int i5;
      int i6;
      boolean bool13;
      boolean bool14;
      Object localObject2;
      int i7;
      for (;;)
      {
        bool8 = bool7;
        bool9 = bool6;
        j = i1;
        i4 = n;
        bool10 = bool5;
        bool11 = bool4;
        bool12 = bool3;
        i5 = m;
        i6 = k;
        bool13 = bool2;
        bool14 = bool1;
        localObject2 = localObject1;
        i7 = i;
        if (i3 >= str1.length()) {
          break label638;
        }
        j = HeaderParser.skipUntil(str1, i3, "=,;");
        str2 = str1.substring(i3, j).trim();
        if ((j == str1.length()) || (str1.charAt(j) == ',') || (str1.charAt(j) == ';'))
        {
          j += 1;
          localObject2 = null;
        }
        for (;;)
        {
          if (!"no-cache".equalsIgnoreCase(str2)) {
            break label425;
          }
          bool7 = true;
          i3 = j;
          break label92;
          localObject1 = str1;
          break;
          bool8 = bool7;
          bool9 = bool6;
          j = i1;
          i4 = n;
          bool10 = bool5;
          bool11 = bool4;
          bool12 = bool3;
          i5 = m;
          i6 = k;
          bool13 = bool2;
          bool14 = bool1;
          localObject2 = localObject1;
          i7 = i;
          if (!str2.equalsIgnoreCase("Pragma")) {
            break label638;
          }
          i = 0;
          break;
          j += 1;
          while (j < str1.length())
          {
            i3 = str1.charAt(j);
            if ((i3 != 32) && (i3 != 9)) {
              break;
            }
            j += 1;
          }
          if ((j < str1.length()) && (str1.charAt(j) == '"'))
          {
            j += 1;
            i3 = HeaderParser.skipUntil(str1, j, "\"");
            localObject2 = str1.substring(j, i3);
            j = i3 + 1;
          }
          else
          {
            i3 = HeaderParser.skipUntil(str1, j, ",;");
            localObject2 = str1.substring(j, i3).trim();
            j = i3;
          }
        }
        label425:
        if ("no-store".equalsIgnoreCase(str2))
        {
          bool6 = true;
          i3 = j;
        }
        else if ("max-age".equalsIgnoreCase(str2))
        {
          i1 = HeaderParser.parseSeconds((String)localObject2, -1);
          i3 = j;
        }
        else if ("s-maxage".equalsIgnoreCase(str2))
        {
          n = HeaderParser.parseSeconds((String)localObject2, -1);
          i3 = j;
        }
        else if ("private".equalsIgnoreCase(str2))
        {
          bool5 = true;
          i3 = j;
        }
        else if ("public".equalsIgnoreCase(str2))
        {
          bool4 = true;
          i3 = j;
        }
        else if ("must-revalidate".equalsIgnoreCase(str2))
        {
          bool3 = true;
          i3 = j;
        }
        else if ("max-stale".equalsIgnoreCase(str2))
        {
          m = HeaderParser.parseSeconds((String)localObject2, Integer.MAX_VALUE);
          i3 = j;
        }
        else if ("min-fresh".equalsIgnoreCase(str2))
        {
          k = HeaderParser.parseSeconds((String)localObject2, -1);
          i3 = j;
        }
        else if ("only-if-cached".equalsIgnoreCase(str2))
        {
          bool2 = true;
          i3 = j;
        }
        else
        {
          i3 = j;
          if ("no-transform".equalsIgnoreCase(str2))
          {
            bool1 = true;
            i3 = j;
          }
        }
      }
      label638:
      i2 += 1;
      bool7 = bool8;
      bool6 = bool9;
      i1 = j;
      n = i4;
      bool5 = bool10;
      bool4 = bool11;
      bool3 = bool12;
      m = i5;
      k = i6;
      bool2 = bool13;
      bool1 = bool14;
      localObject1 = localObject2;
      i = i7;
    }
    if (i == 0) {
      localObject1 = null;
    }
    return new CacheControl(bool7, bool6, i1, n, bool5, bool4, bool3, m, k, bool2, bool1, (String)localObject1);
  }
  
  public final String toString()
  {
    Object localObject = headerValue;
    if (localObject != null) {
      return (String)localObject;
    }
    localObject = new StringBuilder();
    if (noCache) {
      ((StringBuilder)localObject).append("no-cache, ");
    }
    if (noStore) {
      ((StringBuilder)localObject).append("no-store, ");
    }
    if (maxAgeSeconds != -1) {
      ((StringBuilder)localObject).append("max-age=").append(maxAgeSeconds).append(", ");
    }
    if (sMaxAgeSeconds != -1) {
      ((StringBuilder)localObject).append("s-maxage=").append(sMaxAgeSeconds).append(", ");
    }
    if (isPrivate) {
      ((StringBuilder)localObject).append("private, ");
    }
    if (isPublic) {
      ((StringBuilder)localObject).append("public, ");
    }
    if (mustRevalidate) {
      ((StringBuilder)localObject).append("must-revalidate, ");
    }
    if (maxStaleSeconds != -1) {
      ((StringBuilder)localObject).append("max-stale=").append(maxStaleSeconds).append(", ");
    }
    if (minFreshSeconds != -1) {
      ((StringBuilder)localObject).append("min-fresh=").append(minFreshSeconds).append(", ");
    }
    if (onlyIfCached) {
      ((StringBuilder)localObject).append("only-if-cached, ");
    }
    if (noTransform) {
      ((StringBuilder)localObject).append("no-transform, ");
    }
    if (((StringBuilder)localObject).length() == 0) {}
    for (localObject = "";; localObject = ((StringBuilder)localObject).toString())
    {
      headerValue = ((String)localObject);
      return (String)localObject;
      ((StringBuilder)localObject).delete(((StringBuilder)localObject).length() - 2, ((StringBuilder)localObject).length());
    }
  }
  
  public static final class Builder
  {
    int maxAgeSeconds = -1;
    int maxStaleSeconds = -1;
    int minFreshSeconds = -1;
    boolean noCache;
    public boolean noStore;
    boolean noTransform;
    boolean onlyIfCached;
    
    public final CacheControl build()
    {
      return new CacheControl(this, (byte)0);
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.CacheControl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */