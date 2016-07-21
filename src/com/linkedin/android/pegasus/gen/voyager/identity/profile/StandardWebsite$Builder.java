package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class StandardWebsite$Builder
  implements RecordTemplateBuilder<StandardWebsite>
{
  private WebsiteCategory category = null;
  private boolean hasCategory = false;
  
  public final StandardWebsite build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (StandardWebsite.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new StandardWebsite(category, hasCategory);
    } while (hasCategory);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.StandardWebsite", "category");
  }
  
  public final Builder setCategory(WebsiteCategory paramWebsiteCategory)
  {
    if (paramWebsiteCategory == null)
    {
      hasCategory = false;
      category = null;
      return this;
    }
    hasCategory = true;
    category = paramWebsiteCategory;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.StandardWebsite.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */