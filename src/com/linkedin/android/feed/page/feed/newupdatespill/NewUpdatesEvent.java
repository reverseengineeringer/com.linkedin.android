package com.linkedin.android.feed.page.feed.newupdatespill;

public final class NewUpdatesEvent
{
  public final CheckForNewUpdatesRunnable newUpdatesChecker;
  
  public NewUpdatesEvent(CheckForNewUpdatesRunnable paramCheckForNewUpdatesRunnable)
  {
    newUpdatesChecker = paramCheckForNewUpdatesRunnable;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */