package com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation;

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
  private List<Annotation> annotations = null;
  private boolean hasAnnotations = false;
  private boolean hasText = false;
  private String text = null;
  
  private AnnotatedText build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AnnotatedText.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (annotations != null)
    {
      paramFlavor = annotations.iterator();
      do
      {
        if (!paramFlavor.hasNext()) {
          break;
        }
      } while ((Annotation)paramFlavor.next() != null);
      throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText", "annotations");
      if (!hasText) {
        text = "";
      }
      if (!hasAnnotations) {
        annotations = Collections.emptyList();
      }
    }
    return new AnnotatedText(text, annotations, hasText, hasAnnotations);
  }
  
  public final AnnotatedText build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final Builder setAnnotations(List<Annotation> paramList)
  {
    if (paramList.equals(Collections.emptyList()))
    {
      hasAnnotations = false;
      annotations = Collections.emptyList();
      return this;
    }
    hasAnnotations = true;
    annotations = paramList;
    return this;
  }
  
  public final Builder setText(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      hasText = false;
      text = "";
      return this;
    }
    hasText = true;
    text = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */