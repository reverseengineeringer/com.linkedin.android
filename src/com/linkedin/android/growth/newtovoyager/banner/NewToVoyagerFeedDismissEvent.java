package com.linkedin.android.growth.newtovoyager.banner;

public final class NewToVoyagerFeedDismissEvent
{
  public final boolean shouldOpenRbmf;
  
  public NewToVoyagerFeedDismissEvent(boolean paramBoolean)
  {
    shouldOpenRbmf = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof NewToVoyagerFeedDismissEvent)) && (shouldOpenRbmf == shouldOpenRbmf);
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerFeedDismissEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */