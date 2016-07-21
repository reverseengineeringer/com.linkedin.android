package com.linkedin.android.messaging.compose;

import android.support.v7.widget.Toolbar;
import com.linkedin.messengerlib.ui.compose.ComposeFragment.TitleChangeListener;

final class InmailComposeActivity$2
  implements ComposeFragment.TitleChangeListener
{
  InmailComposeActivity$2(InmailComposeActivity paramInmailComposeActivity) {}
  
  public final void onTitleChange(String paramString)
  {
    this$0.toolbar.setTitle(paramString);
  }
  
  public final void onTitleChangeDefault()
  {
    this$0.toolbar.setTitle("");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.compose.InmailComposeActivity.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */