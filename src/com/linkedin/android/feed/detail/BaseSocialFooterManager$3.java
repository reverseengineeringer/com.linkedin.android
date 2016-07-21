package com.linkedin.android.feed.detail;

import com.linkedin.android.infra.ui.MentionsEditTextWithBackEvents.EditTextImeBackListener;

final class BaseSocialFooterManager$3
  implements MentionsEditTextWithBackEvents.EditTextImeBackListener
{
  BaseSocialFooterManager$3(BaseSocialFooterManager paramBaseSocialFooterManager) {}
  
  public final void onImeBack$621954f1()
  {
    if (this$0.currentState == 1) {
      this$0.setupSocialFooterState(0);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.BaseSocialFooterManager.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */