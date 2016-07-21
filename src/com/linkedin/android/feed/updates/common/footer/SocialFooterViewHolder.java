package com.linkedin.android.feed.updates.common.footer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ui.MentionsEditTextWithBackEvents;

public class SocialFooterViewHolder
  extends BaseFeedViewHolder
{
  @InjectView(2131755866)
  public TextView closeDiscussion;
  @InjectView(2131755868)
  public MentionsEditTextWithBackEvents reply;
  @InjectView(2131755869)
  public Button send;
  @InjectView(2131755867)
  public ViewGroup socialActionsView;
  
  public SocialFooterViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.footer.SocialFooterViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */