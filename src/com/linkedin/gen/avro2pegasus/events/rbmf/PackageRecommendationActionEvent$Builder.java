package com.linkedin.gen.avro2pegasus.events.rbmf;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class PackageRecommendationActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<PackageRecommendationActionEvent>
{
  public PackageRecommendationUserAction actionName = null;
  public String controlUrn = null;
  public boolean hasActionName = false;
  public boolean hasControlUrn = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  public boolean hasPackageFlowPosition = false;
  public boolean hasPackageId = false;
  public boolean hasRecommendedEntity = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  public int packageFlowPosition = 0;
  public int packageId = 0;
  public RecommendedEntity recommendedEntity = null;
  private UserRequestHeader requestHeader = null;
  
  private PackageRecommendationActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PackageRecommendationActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new PackageRecommendationActionEvent(header, requestHeader, mobileHeader, packageId, packageFlowPosition, controlUrn, recommendedEntity, actionName, hasHeader, hasRequestHeader, hasMobileHeader, hasPackageId, hasPackageFlowPosition, hasControlUrn, hasRecommendedEntity, hasActionName);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "requestHeader");
      }
      if (!hasPackageFlowPosition) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "packageFlowPosition");
      }
      if (!hasControlUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "controlUrn");
      }
      if (!hasRecommendedEntity) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "recommendedEntity");
      }
    } while (hasActionName);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent", "actionName");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */