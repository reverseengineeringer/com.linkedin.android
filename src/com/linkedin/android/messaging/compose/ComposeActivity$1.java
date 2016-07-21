package com.linkedin.android.messaging.compose;

import android.support.v7.app.ActionBar;
import com.linkedin.messengerlib.ui.compose.ComposeFragment.TitleChangeListener;

final class ComposeActivity$1
  implements ComposeFragment.TitleChangeListener
{
  ComposeActivity$1(ComposeActivity paramComposeActivity) {}
  
  public final void onTitleChange(String paramString)
  {
    ActionBar localActionBar = this$0.getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setTitle(paramString);
    }
  }
  
  public final void onTitleChangeDefault()
  {
    ActionBar localActionBar = this$0.getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setTitle(ComposeActivity.access$000(this$0));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.compose.ComposeActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */