package com.linkedin.android.feed.endor.ui.component.contentdetail;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ui.ExpandableTextView;

public class FeedContentDetailViewHolder$$ViewInjector<T extends FeedContentDetailViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    image = ((LiImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755647, "field 'image'"), 2131755647, "field 'image'"));
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755649, "field 'title'"), 2131755649, "field 'title'"));
    subtitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755650, "field 'subtitle'"), 2131755650, "field 'subtitle'"));
    tertiaryText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755651, "field 'tertiaryText'"), 2131755651, "field 'tertiaryText'"));
    time = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755652, "field 'time'"), 2131755652, "field 'time'"));
    bodyText = ((ExpandableTextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755653, "field 'bodyText'"), 2131755653, "field 'bodyText'"));
  }
  
  public void reset(T paramT)
  {
    image = null;
    title = null;
    subtitle = null;
    tertiaryText = null;
    time = null;
    bodyText = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */