package com.linkedin.android.feed;

import android.text.TextUtils;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.tracking.v2.event.PageViewEvent;

public abstract class FeedTrackableFragment
  extends PageFragment
{
  private boolean firstEnter = true;
  
  public void doEnter()
  {
    super.doEnter();
    String str1 = enterPageKey();
    String str2 = enterPageKey();
    if (firstEnter)
    {
      firstEnter = false;
      if (!TextUtils.isEmpty(str1)) {
        new PageViewEvent(tracker, str1, false).send();
      }
    }
    while (TextUtils.isEmpty(str2)) {
      return;
    }
    new PageViewEvent(tracker, str2, false).send();
  }
  
  public abstract String enterPageKey();
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.FeedTrackableFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */