package com.linkedin.android.feed.endor.datamodel.content;

import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;

public final class TextContentDataModel
  extends AnnotatedTextContentDataModel
{
  public AnnotatedText text;
  
  public TextContentDataModel(AnnotatedText paramAnnotatedText)
  {
    super(paramAnnotatedText);
    text = paramAnnotatedText;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.content.TextContentDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */