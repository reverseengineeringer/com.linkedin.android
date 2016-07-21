package com.linkedin.android.feed.shared;

import android.text.util.Linkify.MatchFilter;

final class LinkPatterns$1
  implements Linkify.MatchFilter
{
  public final boolean acceptMatch(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return (paramInt1 == 0) || (paramCharSequence.charAt(paramInt1 - 1) != '@');
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.LinkPatterns.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */