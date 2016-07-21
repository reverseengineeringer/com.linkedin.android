package com.linkedin.messengerlib.ui.compose;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.linkedin.messengerlib.R.id;

public class ToolbarProgressBar
  extends RelativeLayout
{
  public View progressBar;
  
  public ToolbarProgressBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public ToolbarProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ToolbarProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    progressBar = findViewById(R.id.toolbar_progress_bar);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.compose.ToolbarProgressBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */