package com.linkedin.android.feed.endor.datamodel.content;

import android.content.Context;
import android.text.TextUtils;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;

public final class AttributedTextContentDataModel
  extends ContentDataModel
{
  private AttributedText attributedText;
  
  public final CharSequence getText(Context paramContext)
  {
    return AttributedTextUtils.getAttributedString(attributedText, paramContext);
  }
  
  public final boolean hasNonEmptyText()
  {
    return !TextUtils.isEmpty(attributedText.text);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.content.AttributedTextContentDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */