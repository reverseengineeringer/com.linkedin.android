package com.linkedin.android.feed.endor.ui.component.contentdetail.layouts;

import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders;
import com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailViewHolder;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ui.ExpandableTextView;

public abstract class FeedContentDetailLayout
  extends FeedComponentLayout<FeedContentDetailViewHolder>
{
  public static int getPixelFromDp(Resources paramResources, int paramInt)
  {
    paramResources = paramResources.getDisplayMetrics();
    return (int)TypedValue.applyDimension(1, paramInt, paramResources);
  }
  
  public void apply(FeedContentDetailViewHolder paramFeedContentDetailViewHolder)
  {
    super.apply(paramFeedContentDetailViewHolder);
    title.setText("");
    title.setOnClickListener(null);
    title.setClickable(false);
    subtitle.setText("");
    subtitle.setOnClickListener(null);
    subtitle.setClickable(false);
    image.setImageDrawable(null);
    image.setOval(false);
    image.setOnClickListener(null);
    image.setClickable(false);
    image.setScaleType(ImageView.ScaleType.FIT_CENTER);
    int i = getPixelFromDp(image.getResources(), 48);
    image.getLayoutParams().width = i;
    image.getLayoutParams().height = i;
    bodyText.setText("");
    bodyText.setOnClickListener(null);
    bodyText.setVisibility(0);
    tertiaryText.setText("");
    tertiaryText.setOnClickListener(null);
    tertiaryText.setClickable(false);
    tertiaryText.setVisibility(8);
    time.setText(null);
    time.setVisibility(8);
  }
  
  public FeedComponentLayout.Borders getBorders()
  {
    return SMALL_INNER_BORDERS;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.contentdetail.layouts.FeedContentDetailLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */