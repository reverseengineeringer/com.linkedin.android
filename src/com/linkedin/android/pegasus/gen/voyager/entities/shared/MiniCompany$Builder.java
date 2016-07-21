package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class MiniCompany$Builder
  implements RecordTemplateBuilder<MiniCompany>
{
  private Urn entityUrn = null;
  private boolean hasEntityUrn = false;
  private boolean hasLogo = false;
  private boolean hasName = false;
  private boolean hasObjectUrn = false;
  private boolean hasShowcase = false;
  private boolean hasTrackingId = false;
  private Image logo = null;
  private String name = null;
  private Urn objectUrn = null;
  private boolean showcase = false;
  private String trackingId = null;
  
  public final MiniCompany build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MiniCompany.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MiniCompany(trackingId, objectUrn, entityUrn, name, logo, showcase, hasTrackingId, hasObjectUrn, hasEntityUrn, hasName, hasLogo, hasShowcase);
      if (!hasEntityUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany", "entityUrn");
      }
    } while (hasName);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany", "name");
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
  
  public final Builder setLogo(Image paramImage)
  {
    if (paramImage == null)
    {
      hasLogo = false;
      logo = null;
      return this;
    }
    hasLogo = true;
    logo = paramImage;
    return this;
  }
  
  public final Builder setName(String paramString)
  {
    if (paramString == null)
    {
      hasName = false;
      name = null;
      return this;
    }
    hasName = true;
    name = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */