package com.linkedin.android.feed.endor.ui.component.basictext;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.TextView;
import com.linkedin.android.artdeco.ArtDeco;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;

public class FeedBasicTextLayout
  extends FeedComponentLayout<FeedBasicTextViewHolder>
{
  public final Resources res;
  private final int textAppearance;
  
  public FeedBasicTextLayout(Resources paramResources, int paramInt)
  {
    res = paramResources;
    textAppearance = paramInt;
  }
  
  public void apply(FeedBasicTextViewHolder paramFeedBasicTextViewHolder)
  {
    super.apply(paramFeedBasicTextViewHolder);
    textView.setText("");
    textView.setOnClickListener(null);
    textView.setContentDescription(null);
    textView.setClickable(true);
    textView.setTag(2131755018, null);
    itemView.setAlpha(1.0F);
    if (textAppearance != -1)
    {
      TextView localTextView = textView;
      Context localContext = itemView.getContext();
      ArtDeco.setTextViewAppearance(localTextView, textAppearance, localContext);
    }
    int i = res.getDimensionPixelSize(2131492991);
    int j = res.getDimensionPixelOffset(2131492987);
    int k = res.getDimensionPixelSize(2131492989);
    ViewCompat.setPaddingRelative(textView, i, j, i, k);
    textView.setGravity(8388659);
    JellyBeanMr1Utils.setTextAlignment(textView, 5);
    textView.setCompoundDrawables(null, null, null, null);
    textView.setCompoundDrawablePadding(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */