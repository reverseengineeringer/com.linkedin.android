package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class CustomWebsite$Builder
  implements RecordTemplateBuilder<CustomWebsite>
{
  private boolean hasLabel = false;
  private String label = null;
  
  public final CustomWebsite build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    int[] arrayOfInt = CustomWebsite.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
    paramFlavor.ordinal();
    return new CustomWebsite(label, hasLabel);
  }
  
  public final Builder setLabel(String paramString)
  {
    if (paramString == null)
    {
      hasLabel = false;
      label = null;
      return this;
    }
    hasLabel = true;
    label = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.CustomWebsite.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */