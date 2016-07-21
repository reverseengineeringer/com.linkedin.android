package okhttp3;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.Util;
import okio.Buffer;

public final class HttpUrl
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final String fragment;
  public final String host;
  private final String password;
  private final List<String> pathSegments;
  public final int port;
  public final List<String> queryNamesAndValues;
  public final String scheme;
  private final String url;
  private final String username;
  
  private HttpUrl(HttpUrl.Builder paramBuilder)
  {
    scheme = scheme;
    username = percentDecode(encodedUsername, false);
    password = percentDecode(encodedPassword, false);
    host = host;
    port = paramBuilder.effectivePort();
    pathSegments = percentDecode(encodedPathSegments, false);
    if (encodedQueryNamesAndValues != null) {}
    for (Object localObject1 = percentDecode(encodedQueryNamesAndValues, true);; localObject1 = null)
    {
      queryNamesAndValues = ((List)localObject1);
      localObject1 = localObject2;
      if (encodedFragment != null) {
        localObject1 = percentDecode(encodedFragment, false);
      }
      fragment = ((String)localObject1);
      url = paramBuilder.toString();
      return;
    }
  }
  
  static String canonicalize(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int i = paramInt1;
    while (i < paramInt2)
    {
      int j = paramString1.codePointAt(i);
      if ((j < 32) || (j == 127) || ((j >= 128) && (paramBoolean4)) || (paramString2.indexOf(j) != -1) || ((j == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!percentEncoded(paramString1, i, paramInt2))))) || ((j == 43) && (paramBoolean3)))
      {
        Buffer localBuffer = new Buffer();
        localBuffer.writeUtf8(paramString1, paramInt1, i);
        Object localObject1 = null;
        if (i < paramInt2)
        {
          paramInt1 = paramString1.codePointAt(i);
          Object localObject3;
          Object localObject2;
          if (paramBoolean1)
          {
            localObject3 = localObject1;
            if (paramInt1 != 9)
            {
              localObject3 = localObject1;
              if (paramInt1 != 10)
              {
                localObject3 = localObject1;
                if (paramInt1 != 12)
                {
                  localObject3 = localObject1;
                  if (paramInt1 == 13) {}
                }
              }
            }
          }
          else
          {
            if ((paramInt1 != 43) || (!paramBoolean3)) {
              break label228;
            }
            if (!paramBoolean1) {
              break label221;
            }
            localObject2 = "+";
            label193:
            localBuffer.writeUtf8((String)localObject2);
            localObject3 = localObject1;
          }
          for (;;)
          {
            i += Character.charCount(paramInt1);
            localObject1 = localObject3;
            break;
            label221:
            localObject2 = "%2B";
            break label193;
            label228:
            if ((paramInt1 < 32) || (paramInt1 == 127) || ((paramInt1 >= 128) && (paramBoolean4)) || (paramString2.indexOf(paramInt1) != -1) || ((paramInt1 == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!percentEncoded(paramString1, i, paramInt2))))))
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new Buffer();
              }
              ((Buffer)localObject2).writeUtf8CodePoint(paramInt1);
              for (;;)
              {
                localObject3 = localObject2;
                if (((Buffer)localObject2).exhausted()) {
                  break;
                }
                j = ((Buffer)localObject2).readByte() & 0xFF;
                localBuffer.writeByte(37);
                localBuffer.writeByte(HEX_DIGITS[(j >> 4 & 0xF)]);
                localBuffer.writeByte(HEX_DIGITS[(j & 0xF)]);
              }
            }
            localBuffer.writeUtf8CodePoint(paramInt1);
            localObject3 = localObject1;
          }
        }
        return localBuffer.readUtf8();
      }
      i += Character.charCount(j);
    }
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String canonicalize$6fb45537(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return canonicalize(paramString1, 0, paramString1.length(), paramString2, true, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  static int decodeHexDigit(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    return -1;
  }
  
  public static int defaultPort(String paramString)
  {
    if (paramString.equals("http")) {
      return 80;
    }
    if (paramString.equals("https")) {
      return 443;
    }
    return -1;
  }
  
  public static void namesAndValuesToQueryString(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      String str1 = (String)paramList.get(i);
      String str2 = (String)paramList.get(i + 1);
      if (i > 0) {
        paramStringBuilder.append('&');
      }
      paramStringBuilder.append(str1);
      if (str2 != null)
      {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      }
      i += 2;
    }
  }
  
  public static HttpUrl parse(String paramString)
  {
    HttpUrl localHttpUrl = null;
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    if (localBuilder.parse(null, paramString) == HttpUrl.Builder.ParseResult.SUCCESS) {
      localHttpUrl = localBuilder.build();
    }
    return localHttpUrl;
  }
  
  static void pathSegmentsToString(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      paramStringBuilder.append('/');
      paramStringBuilder.append((String)paramList.get(i));
      i += 1;
    }
  }
  
  static String percentDecode(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt1;
    while (i < paramInt2)
    {
      int j = paramString.charAt(i);
      if ((j == 37) || ((j == 43) && (paramBoolean)))
      {
        Buffer localBuffer = new Buffer();
        localBuffer.writeUtf8(paramString, paramInt1, i);
        paramInt1 = i;
        if (paramInt1 < paramInt2)
        {
          i = paramString.codePointAt(paramInt1);
          if ((i == 37) && (paramInt1 + 2 < paramInt2))
          {
            j = decodeHexDigit(paramString.charAt(paramInt1 + 1));
            int k = decodeHexDigit(paramString.charAt(paramInt1 + 2));
            if ((j == -1) || (k == -1)) {
              break label169;
            }
            localBuffer.writeByte((j << 4) + k);
            paramInt1 += 2;
          }
          for (;;)
          {
            paramInt1 += Character.charCount(i);
            break;
            if ((i == 43) && (paramBoolean)) {
              localBuffer.writeByte(32);
            } else {
              label169:
              localBuffer.writeUtf8CodePoint(i);
            }
          }
        }
        return localBuffer.readUtf8();
      }
      i += 1;
    }
    return paramString.substring(paramInt1, paramInt2);
  }
  
  private static String percentDecode(String paramString, boolean paramBoolean)
  {
    return percentDecode(paramString, 0, paramString.length(), paramBoolean);
  }
  
  private static List<String> percentDecode(List<String> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      if (paramList != null) {}
      for (paramList = percentDecode(paramList, paramBoolean);; paramList = null)
      {
        localArrayList.add(paramList);
        break;
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  private static boolean percentEncoded(String paramString, int paramInt1, int paramInt2)
  {
    return (paramInt1 + 2 < paramInt2) && (paramString.charAt(paramInt1) == '%') && (decodeHexDigit(paramString.charAt(paramInt1 + 1)) != -1) && (decodeHexDigit(paramString.charAt(paramInt1 + 2)) != -1);
  }
  
  static List<String> queryStringToNamesAndValues(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i <= paramString.length())
    {
      int k = paramString.indexOf('&', i);
      int j = k;
      if (k == -1) {
        j = paramString.length();
      }
      k = paramString.indexOf('=', i);
      if ((k == -1) || (k > j))
      {
        localArrayList.add(paramString.substring(i, j));
        localArrayList.add(null);
      }
      for (;;)
      {
        i = j + 1;
        break;
        localArrayList.add(paramString.substring(i, k));
        localArrayList.add(paramString.substring(k + 1, j));
      }
    }
    return localArrayList;
  }
  
  public final String encodedPassword()
  {
    if (password.isEmpty()) {
      return "";
    }
    int i = url.indexOf(':', scheme.length() + 3);
    int j = url.indexOf('@');
    return url.substring(i + 1, j);
  }
  
  public final String encodedPath()
  {
    int i = url.indexOf('/', scheme.length() + 3);
    int j = Util.delimiterOffset(url, i, url.length(), "?#");
    return url.substring(i, j);
  }
  
  public final List<String> encodedPathSegments()
  {
    int i = url.indexOf('/', scheme.length() + 3);
    int j = Util.delimiterOffset(url, i, url.length(), "?#");
    ArrayList localArrayList = new ArrayList();
    while (i < j)
    {
      int k = i + 1;
      i = Util.delimiterOffset(url, k, j, '/');
      localArrayList.add(url.substring(k, i));
    }
    return localArrayList;
  }
  
  public final String encodedQuery()
  {
    if (queryNamesAndValues == null) {
      return null;
    }
    int i = url.indexOf('?') + 1;
    int j = Util.delimiterOffset(url, i + 1, url.length(), '#');
    return url.substring(i, j);
  }
  
  public final String encodedUsername()
  {
    if (username.isEmpty()) {
      return "";
    }
    int i = scheme.length() + 3;
    int j = Util.delimiterOffset(url, i, url.length(), ":@");
    return url.substring(i, j);
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof HttpUrl)) && (url.equals(url));
  }
  
  public final int hashCode()
  {
    return url.hashCode();
  }
  
  public final boolean isHttps()
  {
    return scheme.equals("https");
  }
  
  public final HttpUrl.Builder newBuilder()
  {
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    scheme = scheme;
    encodedUsername = encodedUsername();
    encodedPassword = encodedPassword();
    host = host;
    int i;
    if (port != defaultPort(scheme))
    {
      i = port;
      port = i;
      encodedPathSegments.clear();
      encodedPathSegments.addAll(encodedPathSegments());
      localBuilder.encodedQuery(encodedQuery());
      if (fragment != null) {
        break label117;
      }
    }
    for (String str = null;; str = url.substring(i + 1))
    {
      encodedFragment = str;
      return localBuilder;
      i = -1;
      break;
      label117:
      i = url.indexOf('#');
    }
  }
  
  public final HttpUrl resolve(String paramString)
  {
    HttpUrl localHttpUrl = null;
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    if (localBuilder.parse(this, paramString) == HttpUrl.Builder.ParseResult.SUCCESS) {}
    for (paramString = localBuilder;; paramString = null)
    {
      if (paramString != null) {
        localHttpUrl = paramString.build();
      }
      return localHttpUrl;
    }
  }
  
  public final String toString()
  {
    return url;
  }
  
  public final URI uri()
  {
    Object localObject1 = newBuilder();
    int j = encodedPathSegments.size();
    int i = 0;
    while (i < j)
    {
      localObject2 = (String)encodedPathSegments.get(i);
      encodedPathSegments.set(i, canonicalize$6fb45537((String)localObject2, "[]", true, false, true));
      i += 1;
    }
    if (encodedQueryNamesAndValues != null)
    {
      j = encodedQueryNamesAndValues.size();
      i = 0;
      while (i < j)
      {
        localObject2 = (String)encodedQueryNamesAndValues.get(i);
        if (localObject2 != null) {
          encodedQueryNamesAndValues.set(i, canonicalize$6fb45537((String)localObject2, "\\^`{|}", true, true, true));
        }
        i += 1;
      }
    }
    if (encodedFragment != null) {
      encodedFragment = canonicalize$6fb45537(encodedFragment, " \"#<>\\^`{|}", true, false, false);
    }
    Object localObject2 = ((HttpUrl.Builder)localObject1).toString();
    try
    {
      localObject1 = new URI((String)localObject2);
      return (URI)localObject1;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      try
      {
        localObject2 = URI.create(((String)localObject2).replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
        return (URI)localObject2;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localURISyntaxException);
      }
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.HttpUrl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */