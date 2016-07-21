package com.linkedin.android.pegasus.gen.voyager.feed.shared;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class AnnotatedText$Builder
  implements RecordTemplateBuilder<AnnotatedText>
{
  private boolean hasValues = false;
  private List<AnnotatedString> values = null;
  
  private AnnotatedText build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AnnotatedText.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (values != null)
    {
      paramFlavor = values.iterator();
      do
      {
        if (!paramFlavor.hasNext()) {
          break;
        }
      } while ((AnnotatedString)paramFlavor.next() != null);
      throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText", "values");
      if (!hasValues) {
        values = Collections.emptyList();
      }
    }
    return new AnnotatedText(values, hasValues);
  }
  
  public final AnnotatedText build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final Builder setValues(List<AnnotatedString> paramList)
  {
    if ((paramList == null) || (paramList.equals(Collections.emptyList())))
    {
      hasValues = false;
      values = Collections.emptyList();
      return this;
    }
    hasValues = true;
    values = paramList;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */