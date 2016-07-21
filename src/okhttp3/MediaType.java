package okhttp3;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaType
{
  private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  private final String charset;
  private final String mediaType;
  private final String subtype;
  final String type;
  
  private MediaType(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    mediaType = paramString1;
    type = paramString2;
    subtype = paramString3;
    charset = paramString4;
  }
  
  public static MediaType parse(String paramString)
  {
    Object localObject1 = TYPE_SUBTYPE.matcher(paramString);
    if (!((Matcher)localObject1).lookingAt()) {
      return null;
    }
    String str1 = ((Matcher)localObject1).group(1).toLowerCase(Locale.US);
    String str2 = ((Matcher)localObject1).group(2).toLowerCase(Locale.US);
    Object localObject2 = null;
    Matcher localMatcher = PARAMETER.matcher(paramString);
    int i = ((Matcher)localObject1).end();
    for (;;)
    {
      if (i >= paramString.length()) {
        break label186;
      }
      localMatcher.region(i, paramString.length());
      if (!localMatcher.lookingAt()) {
        break;
      }
      String str3 = localMatcher.group(1);
      localObject1 = localObject2;
      if (str3 != null)
      {
        localObject1 = localObject2;
        if (str3.equalsIgnoreCase("charset"))
        {
          if (localMatcher.group(2) != null) {}
          for (localObject1 = localMatcher.group(2); (localObject2 != null) && (!((String)localObject1).equalsIgnoreCase((String)localObject2)); localObject1 = localMatcher.group(3)) {
            throw new IllegalArgumentException("Multiple different charsets: " + paramString);
          }
        }
      }
      i = localMatcher.end();
      localObject2 = localObject1;
    }
    label186:
    return new MediaType(paramString, str1, str2, (String)localObject2);
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof MediaType)) && (mediaType.equals(mediaType));
  }
  
  public final int hashCode()
  {
    return mediaType.hashCode();
  }
  
  public final String toString()
  {
    return mediaType;
  }
}

/* Location:
 * Qualified Name:     okhttp3.MediaType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */