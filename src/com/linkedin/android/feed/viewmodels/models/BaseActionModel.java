package com.linkedin.android.feed.viewmodels.models;

public abstract class BaseActionModel
{
  public int iconResId;
  public CharSequence subtitle;
  public CharSequence title;
  public int type;
  
  protected BaseActionModel(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt2)
  {
    title = paramCharSequence1;
    subtitle = paramCharSequence2;
    iconResId = paramInt2;
    type = paramInt1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.viewmodels.models.BaseActionModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */