package com.linkedin.android.messaging.compose;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.linkedin.messengerlib.ui.compose.ComposeFragment.ComposeProgressListener;
import com.linkedin.messengerlib.ui.compose.ToolbarProgressBar;

final class ComposeActivity$2
  implements ComposeFragment.ComposeProgressListener
{
  ComposeActivity$2(ComposeActivity paramComposeActivity) {}
  
  public final void onComposeFinished()
  {
    if (ComposeActivity.access$100(this$0) != null) {
      ComposeActivity.access$100(this$0).setVisibility(8);
    }
  }
  
  public final void onComposeProgress(int paramInt)
  {
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    if (ComposeActivity.access$100(this$0) == null)
    {
      localObject = ComposeActivity.access$200(this$0);
      if (localObject != null)
      {
        ComposeActivity.access$102(this$0, (ToolbarProgressBar)LayoutInflater.from(this$0).inflate(2130969107, (ViewGroup)localObject, false));
        localLayoutParams = ComposeActivity.access$100(this$0).getLayoutParams();
        height = this$0.toolbar.getHeight();
        ComposeActivity.access$100(this$0).setLayoutParams(localLayoutParams);
        ((ViewGroup)localObject).addView(ComposeActivity.access$100(this$0));
      }
    }
    if (ComposeActivity.access$100(this$0) != null)
    {
      ComposeActivity.access$100(this$0).setVisibility(0);
      localObject = ComposeActivity.access$100(this$0);
      int i = this$0.toolbar.getWidth();
      localLayoutParams = progressBar.getLayoutParams();
      float f = paramInt / 100.0F;
      width = ((int)(i * f));
      progressBar.setLayoutParams(localLayoutParams);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.compose.ComposeActivity.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */