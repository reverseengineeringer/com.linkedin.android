package com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class TreasuryMedia$Builder
  implements RecordTemplateBuilder<TreasuryMedia>
{
  private String customDescription = null;
  private String customTitle = null;
  public TreasuryMedia.Data data = null;
  private String description = null;
  private Urn entityUrn = null;
  private boolean hasCustomDescription = false;
  private boolean hasCustomTitle = false;
  public boolean hasData = false;
  private boolean hasDescription = false;
  private boolean hasEntityUrn = false;
  private boolean hasTitle = false;
  private String title = null;
  
  public TreasuryMedia$Builder() {}
  
  public TreasuryMedia$Builder(TreasuryMedia paramTreasuryMedia)
  {
    entityUrn = entityUrn;
    customTitle = customTitle;
    customDescription = customDescription;
    title = title;
    description = description;
    data = data;
    hasEntityUrn = hasEntityUrn;
    hasCustomTitle = hasCustomTitle;
    hasCustomDescription = hasCustomDescription;
    hasTitle = hasTitle;
    hasDescription = hasDescription;
    hasData = hasData;
  }
  
  public final TreasuryMedia build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (TreasuryMedia.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new TreasuryMedia(entityUrn, customTitle, customDescription, title, description, data, hasEntityUrn, hasCustomTitle, hasCustomDescription, hasTitle, hasDescription, hasData);
      if (!hasEntityUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia", "entityUrn");
      }
    } while (hasData);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia", "data");
  }
  
  public final Builder setCustomDescription(String paramString)
  {
    if (paramString == null)
    {
      hasCustomDescription = false;
      customDescription = null;
      return this;
    }
    hasCustomDescription = true;
    customDescription = paramString;
    return this;
  }
  
  public final Builder setCustomTitle(String paramString)
  {
    if (paramString == null)
    {
      hasCustomTitle = false;
      customTitle = null;
      return this;
    }
    hasCustomTitle = true;
    customTitle = paramString;
    return this;
  }
  
  public final Builder setEntityUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasEntityUrn = false;
      entityUrn = null;
      return this;
    }
    hasEntityUrn = true;
    entityUrn = paramUrn;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */