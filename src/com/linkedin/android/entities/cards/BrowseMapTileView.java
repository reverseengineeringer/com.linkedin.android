package com.linkedin.android.entities.cards;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class BrowseMapTileView
  extends LinearLayout
{
  private static int maxTilesPerRow;
  
  public BrowseMapTileView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public BrowseMapTileView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    setShowDividers(0);
    setOrientation(1);
    int i = getContext().getResources().getDimensionPixelSize(2131492989);
    setPadding(i, 0, i, 0);
    maxTilesPerRow = getContext().getResources().getInteger(2131558437);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.cards.BrowseMapTileView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */