package com.linkedin.android.pegasus.gen.voyager.feed.shared;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class AnnotatedString$Builder
  implements RecordTemplateBuilder<AnnotatedString>
{
  public AnnotatedString.Entity entity = null;
  public boolean hasEntity = false;
  private boolean hasValue = false;
  private String value = null;
  
  public final AnnotatedString build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AnnotatedString.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new AnnotatedString(value, entity, hasValue, hasEntity);
    } while (hasValue);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString", "value");
  }
  
  public final Builder setValue(String paramString)
  {
    if (paramString == null)
    {
      hasValue = false;
      value = null;
      return this;
    }
    hasValue = true;
    value = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */