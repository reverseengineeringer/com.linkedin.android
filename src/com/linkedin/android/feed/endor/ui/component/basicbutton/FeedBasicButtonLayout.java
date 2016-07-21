package com.linkedin.android.feed.endor.ui.component.basicbutton;

import android.view.View;
import android.widget.Button;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;

public class FeedBasicButtonLayout
  extends FeedComponentLayout<FeedBasicButtonViewHolder>
{
  public void apply(FeedBasicButtonViewHolder paramFeedBasicButtonViewHolder)
  {
    super.apply(paramFeedBasicButtonViewHolder);
    button.setText(null);
    button.setOnClickListener(null);
    topDivider.setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.basicbutton.FeedBasicButtonLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */