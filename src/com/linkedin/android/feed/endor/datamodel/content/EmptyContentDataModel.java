package com.linkedin.android.feed.endor.datamodel.content;

public final class EmptyContentDataModel
  extends ContentDataModel
{
  public static final EmptyContentDataModel DEFAULT = new EmptyContentDataModel();
  
  public final boolean hasNonEmptyText()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.content.EmptyContentDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */