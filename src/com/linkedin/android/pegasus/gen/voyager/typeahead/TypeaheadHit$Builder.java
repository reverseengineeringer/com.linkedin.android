package com.linkedin.android.pegasus.gen.voyager.typeahead;

import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class TypeaheadHit$Builder
  implements RecordTemplateBuilder<TypeaheadHit>
{
  private boolean hasHitInfo = false;
  public boolean hasSubtext = false;
  private boolean hasText = false;
  private TypeaheadHit.HitInfo hitInfo = null;
  public String subtext = null;
  private AnnotatedText text = null;
  
  public final TypeaheadHit build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (TypeaheadHit.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new TypeaheadHit(text, subtext, hitInfo, hasText, hasSubtext, hasHitInfo);
    } while (hasText);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit", "text");
  }
  
  public final Builder setHitInfo(TypeaheadHit.HitInfo paramHitInfo)
  {
    if (paramHitInfo == null)
    {
      hasHitInfo = false;
      hitInfo = null;
      return this;
    }
    hasHitInfo = true;
    hitInfo = paramHitInfo;
    return this;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */