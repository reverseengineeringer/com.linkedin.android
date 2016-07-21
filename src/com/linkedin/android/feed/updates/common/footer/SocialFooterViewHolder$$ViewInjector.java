package com.linkedin.android.feed.updates.common.footer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.MentionsEditTextWithBackEvents;

public class SocialFooterViewHolder$$ViewInjector<T extends SocialFooterViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    reply = ((MentionsEditTextWithBackEvents)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755868, "field 'reply'"), 2131755868, "field 'reply'"));
    send = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755869, "field 'send'"), 2131755869, "field 'send'"));
    closeDiscussion = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755866, "field 'closeDiscussion'"), 2131755866, "field 'closeDiscussion'"));
    socialActionsView = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755867, "field 'socialActionsView'"), 2131755867, "field 'socialActionsView'"));
  }
  
  public void reset(T paramT)
  {
    reply = null;
    send = null;
    closeDiscussion = null;
    socialActionsView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.footer.SocialFooterViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */