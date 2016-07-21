package com.linkedin.android.entities.cards;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.linkedin.android.infra.ui.expandableview.ExpandableView;

public class StatisticsView
  extends ExpandableView
{
  public LinearLayout currentRow;
  
  public StatisticsView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StatisticsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.cards.StatisticsView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */