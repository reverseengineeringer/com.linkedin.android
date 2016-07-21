package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ShareText$Builder
  implements RecordTemplateBuilder<ShareText>
{
  private AttributedText attributedText = null;
  private boolean hasAttributedText = false;
  private boolean hasText = false;
  private AnnotatedText text = null;
  
  public final ShareText build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ShareText.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ShareText(text, attributedText, hasText, hasAttributedText);
    } while (hasText);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareText", "text");
  }
  
  public final Builder setText(AnnotatedText paramAnnotatedText)
  {
    if (paramAnnotatedText == null)
    {
      hasText = false;
      text = null;
      return this;
    }
    hasText = true;
    text = paramAnnotatedText;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareText.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */