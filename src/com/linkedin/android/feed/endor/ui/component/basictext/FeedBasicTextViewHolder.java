package com.linkedin.android.feed.endor.ui.component.basictext;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedBasicTextViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedBasicTextViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968711;
    }
  };
  @InjectView(2131755612)
  public TextView textView;
  
  public FeedBasicTextViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */