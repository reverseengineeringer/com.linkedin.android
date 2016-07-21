package com.linkedin.android.feed.events;

public final class LoadMoreEvent
{
  public final int eventType;
  public final int usage = 1;
  
  private LoadMoreEvent(int paramInt)
  {
    eventType = paramInt;
  }
  
  public static LoadMoreEvent comments(int paramInt)
  {
    return new LoadMoreEvent(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.events.LoadMoreEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */