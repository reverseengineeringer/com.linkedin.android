package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class MiniGroup$Builder
  implements RecordTemplateBuilder<MiniGroup>
{
  private Urn entityUrn = null;
  private String groupDescription = null;
  public String groupName = null;
  private boolean hasEntityUrn = false;
  private boolean hasGroupDescription = false;
  public boolean hasGroupName = false;
  private boolean hasLogo = false;
  private boolean hasObjectUrn = false;
  private boolean hasRecentActivityCount = false;
  private boolean hasTrackingId = false;
  private Image logo = null;
  private Urn objectUrn = null;
  private int recentActivityCount = 0;
  private String trackingId = null;
  
  public final MiniGroup build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MiniGroup.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MiniGroup(trackingId, objectUrn, entityUrn, groupName, groupDescription, logo, recentActivityCount, hasTrackingId, hasObjectUrn, hasEntityUrn, hasGroupName, hasGroupDescription, hasLogo, hasRecentActivityCount);
      if (!hasEntityUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup", "entityUrn");
      }
    } while (hasGroupName);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup", "groupName");
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */