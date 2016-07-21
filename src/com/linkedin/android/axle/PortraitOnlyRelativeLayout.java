package com.linkedin.android.axle;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class PortraitOnlyRelativeLayout
  extends RelativeLayout
{
  private int portraitVisibility = 0;
  
  public PortraitOnlyRelativeLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PortraitOnlyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PortraitOnlyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  @TargetApi(21)
  public PortraitOnlyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init();
  }
  
  private void init()
  {
    portraitVisibility = getVisibility();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((paramConfiguration != null) && (orientation == 1))
    {
      super.setVisibility(portraitVisibility);
      return;
    }
    super.setVisibility(8);
  }
  
  public void setVisibility(int paramInt)
  {
    portraitVisibility = paramInt;
    onConfigurationChanged(getResources().getConfiguration());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.PortraitOnlyRelativeLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */