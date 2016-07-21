package com.linkedin.android.feed.detail;

import android.text.Editable;
import android.widget.Button;
import com.linkedin.android.feed.updates.common.footer.SocialFooterViewHolder;
import com.linkedin.android.infra.simple.SimpleTextWatcher;
import java.lang.ref.WeakReference;

final class BaseSocialFooterManager$2
  extends SimpleTextWatcher
{
  BaseSocialFooterManager$2(BaseSocialFooterManager paramBaseSocialFooterManager) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.toString().trim().length() > 0) && (this$0.memberMiniProfile != null)) {}
    for (boolean bool = true;; bool = false)
    {
      paramEditable = (SocialFooterViewHolder)this$0.socialFooterViewHolder.get();
      if (paramEditable != null) {
        send.setEnabled(bool);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.BaseSocialFooterManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */