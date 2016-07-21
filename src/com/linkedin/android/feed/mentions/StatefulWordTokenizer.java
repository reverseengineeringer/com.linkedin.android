package com.linkedin.android.feed.mentions;

import android.text.Spanned;
import android.text.TextUtils;
import com.linkedin.android.spyglass.tokenization.impl.WordTokenizer;
import com.linkedin.android.spyglass.tokenization.impl.WordTokenizerConfig;

public class StatefulWordTokenizer
  extends WordTokenizer
{
  private final WordTokenizerConfig config;
  private boolean isImplicitToken;
  
  public StatefulWordTokenizer(WordTokenizerConfig paramWordTokenizerConfig)
  {
    super(paramWordTokenizerConfig);
    config = paramWordTokenizerConfig;
  }
  
  public final boolean isValidMention(Spanned paramSpanned, int paramInt1, int paramInt2)
  {
    boolean bool3 = false;
    String str = paramSpanned.subSequence(paramInt1, paramInt2).toString();
    if (TextUtils.isEmpty(str))
    {
      isImplicitToken = false;
      return false;
    }
    boolean bool1;
    if ((isImplicitToken) && (str.length() < config.THRESHOLD) && (!isExplicitChar(str.charAt(0))))
    {
      isImplicitToken = onlyLettersOrDigits(str, str.length(), 0);
      bool1 = isImplicitToken;
    }
    for (;;)
    {
      return bool1;
      boolean bool2 = super.isValidMention(paramSpanned, paramInt1, paramInt2);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool3;
        if (!isExplicitChar(str.charAt(0))) {
          bool1 = true;
        }
        isImplicitToken = bool1;
        bool1 = bool2;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.mentions.StatefulWordTokenizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */