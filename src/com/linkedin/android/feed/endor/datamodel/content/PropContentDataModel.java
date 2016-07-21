package com.linkedin.android.feed.endor.datamodel.content;

import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;

public final class PropContentDataModel
  extends ContentDataModel
{
  public AttributedText subtext;
  public AttributedText text;
  
  public PropContentDataModel(AttributedText paramAttributedText1, AttributedText paramAttributedText2)
  {
    text = paramAttributedText1;
    subtext = paramAttributedText2;
  }
  
  public final boolean hasNonEmptyText()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.content.PropContentDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */