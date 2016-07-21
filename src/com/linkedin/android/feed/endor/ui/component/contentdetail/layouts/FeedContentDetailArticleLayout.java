package com.linkedin.android.feed.endor.ui.component.contentdetail.layouts;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders;
import com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailViewHolder;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ui.ExpandableTextView;

public final class FeedContentDetailArticleLayout
  extends FeedContentDetailLayout
{
  private final boolean isSharePreview;
  private final boolean removeBorder;
  private boolean showEllipsisOnly;
  
  public FeedContentDetailArticleLayout(boolean paramBoolean)
  {
    this(paramBoolean, false);
  }
  
  public FeedContentDetailArticleLayout(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramBoolean1, paramBoolean2, false);
  }
  
  public FeedContentDetailArticleLayout(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    removeBorder = paramBoolean1;
    showEllipsisOnly = paramBoolean2;
    isSharePreview = paramBoolean3;
  }
  
  public final void apply(FeedContentDetailViewHolder paramFeedContentDetailViewHolder)
  {
    super.apply(paramFeedContentDetailViewHolder);
    image.setScaleType(ImageView.ScaleType.CENTER_CROP);
    int i = getPixelFromDp(image.getResources(), 72);
    image.getLayoutParams().width = i;
    image.getLayoutParams().height = i;
    Context localContext = itemView.getContext();
    if (showEllipsisOnly)
    {
      bodyText.setIsExpandable(false);
      bodyText.setMaxLines(localContext.getResources().getInteger(2131558454));
      bodyText.setEllipsisText(localContext.getResources().getString(2131232782));
      return;
    }
    bodyText.setIsExpandable(true);
    bodyText.setMaxLines(localContext.getResources().getInteger(2131558457));
    bodyText.setEllipsisText(localContext.getResources().getString(2131232781));
  }
  
  public final FeedComponentLayout.Borders getBorders()
  {
    if (removeBorder) {
      return null;
    }
    if (isSharePreview) {
      return new FeedComponentLayout.Borders(1, 1, 1, 1);
    }
    return super.getBorders();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.contentdetail.layouts.FeedContentDetailArticleLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */