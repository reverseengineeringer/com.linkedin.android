package com.linkedin.android.pegasus.gen.pemberly.text;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class AttributedText$Builder
  implements RecordTemplateBuilder<AttributedText>
{
  private List<Attribute> attributes = null;
  private boolean hasAttributes = false;
  private boolean hasText = false;
  private String text = null;
  
  public final AttributedText build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final AttributedText build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AttributedText.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (attributes != null)
    {
      paramFlavor = attributes.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((Attribute)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.pemberly.text.AttributedText", "attributes");
            if (!hasAttributes) {
              attributes = Collections.emptyList();
            }
            if (hasText) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.pemberly.text.AttributedText", "text");
          }
        }
      }
    }
    return new AttributedText(text, attributes, hasText, hasAttributes);
  }
  
  public final Builder setAttributes(List<Attribute> paramList)
  {
    if ((paramList == null) || (paramList.equals(Collections.emptyList())))
    {
      hasAttributes = false;
      attributes = Collections.emptyList();
      return this;
    }
    hasAttributes = true;
    attributes = paramList;
    return this;
  }
  
  public final Builder setText(String paramString)
  {
    if (paramString == null)
    {
      hasText = false;
      text = null;
      return this;
    }
    hasText = true;
    text = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.pemberly.text.AttributedText.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */