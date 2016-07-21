package com.linkedin.android.feed.actions;

import android.view.View.OnClickListener;

public final class PanelDialog$PanelDialogItem
{
  public int iconResId;
  public View.OnClickListener listener;
  public CharSequence subtitle;
  public CharSequence title;
  
  public PanelDialog$PanelDialogItem(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt, View.OnClickListener paramOnClickListener)
  {
    title = paramCharSequence1;
    subtitle = paramCharSequence2;
    iconResId = paramInt;
    listener = paramOnClickListener;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.PanelDialog.PanelDialogItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */