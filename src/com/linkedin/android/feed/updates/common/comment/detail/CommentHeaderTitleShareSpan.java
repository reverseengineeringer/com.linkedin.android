package com.linkedin.android.feed.updates.common.comment.detail;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.linkedin.android.feed.events.FeedCommentHeaderShareClickEvent;
import com.linkedin.android.infra.events.Bus;

public final class CommentHeaderTitleShareSpan
  extends ClickableSpan
{
  private Typeface boldTypeface;
  private Bus bus;
  private int textColor;
  
  public CommentHeaderTitleShareSpan(Context paramContext, Bus paramBus)
  {
    bus = paramBus;
    textColor = ContextCompat.getColor(paramContext, 2131623958);
  }
  
  public final void onClick(View paramView)
  {
    Bus.publish(new FeedCommentHeaderShareClickEvent());
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    if (boldTypeface == null) {
      boldTypeface = Typeface.create(paramTextPaint.getTypeface(), 1);
    }
    if (boldTypeface.isBold()) {
      paramTextPaint.setTypeface(boldTypeface);
    }
    for (;;)
    {
      paramTextPaint.setColor(textColor);
      paramTextPaint.setUnderlineText(false);
      return;
      paramTextPaint.setFakeBoldText(true);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentHeaderTitleShareSpan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */