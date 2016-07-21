package com.linkedin.android.feed.shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HashtagUtils
{
  private static final Pattern HASHTAG_PATTERN = Pattern.compile("(?<=^|\\s|[^&\\p{L}\\p{M}\\p{Nd}_\\\\u200c\\\\u200d\\\\ua67e\\\\u05be\\\\u05f3\\\\u05f4\\\\uff5e\\\\u301c\\\\u309b\\\\u309c\\\\u30a0\\\\u30fb\\\\u3003\\\\u0f0b\\\\u0f0c\\\\u00b7])[#＃](?![\\p{Nd}]+\\b)([\\p{L}\\p{M}\\p{Nd}\\\\u200c\\\\u200d\\\\ua67e\\\\u05be\\\\u05f3\\\\u05f4\\\\uff5e\\\\u301c\\\\u309b\\\\u309c\\\\u30a0\\\\u30fb\\\\u3003\\\\u0f0b\\\\u0f0c\\\\u00b7_]+)");
  
  public static List<Hashtag> getHashtags(CharSequence paramCharSequence)
  {
    if (paramCharSequence.length() == 0)
    {
      paramCharSequence = Collections.emptyList();
      return paramCharSequence;
    }
    ArrayList localArrayList = new ArrayList();
    Matcher localMatcher = HASHTAG_PATTERN.matcher(paramCharSequence);
    for (;;)
    {
      paramCharSequence = localArrayList;
      if (!localMatcher.find()) {
        break;
      }
      localArrayList.add(new Hashtag(localMatcher.group(0), localMatcher.start(), localMatcher.end()));
    }
  }
  
  public static final class Hashtag
  {
    public final int end;
    public final int start;
    public final String text;
    
    public Hashtag(String paramString, int paramInt1, int paramInt2)
    {
      text = paramString;
      start = paramInt1;
      end = paramInt2;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.HashtagUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */