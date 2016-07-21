package com.linkedin.android.feed.mentions;

import com.linkedin.android.spyglass.tokenization.impl.WordTokenizerConfig.Builder;

public final class MentionsWordTokenizer
  extends StatefulWordTokenizer
{
  public MentionsWordTokenizer()
  {
    super(localBuilder.build());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.mentions.MentionsWordTokenizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */