package com.linkedin.android.feed.shared;

import android.text.util.Linkify.MatchFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkUtils
{
  public static String addHttpPrefixIfNecessary(String paramString)
  {
    if (paramString.length() == 0) {
      return paramString;
    }
    String[] arrayOfString = LinkPatterns.URL_PREFIXES;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label52;
      }
      String str = arrayOfString[i];
      if (paramString.regionMatches(true, 0, str, 0, str.length())) {
        break;
      }
      i += 1;
    }
    label52:
    return "http://".concat(paramString);
  }
  
  public static List<Link> getWebLinks(CharSequence paramCharSequence)
  {
    Object localObject;
    if (paramCharSequence.length() == 0)
    {
      localObject = Collections.emptyList();
      return (List<Link>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    Matcher localMatcher = LinkPatterns.WEB_URL.matcher(paramCharSequence);
    for (;;)
    {
      localObject = localArrayList;
      if (!localMatcher.find()) {
        break;
      }
      int i = localMatcher.start();
      int j = localMatcher.end();
      if (LinkPatterns.URL_MATCH_FILTER.acceptMatch(paramCharSequence, i, j)) {
        localArrayList.add(new Link(addHttpPrefixIfNecessary(localMatcher.group(0)), i, j));
      }
    }
  }
  
  public static final class Link
  {
    public final int end;
    public final int start;
    public final String url;
    
    public Link(String paramString, int paramInt1, int paramInt2)
    {
      url = paramString;
      start = paramInt1;
      end = paramInt2;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.LinkUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */