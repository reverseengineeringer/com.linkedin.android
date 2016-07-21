package com.linkedin.gen.avro2pegasus.events.rbmf;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.Iterator;
import java.util.List;

public final class PackageRecommendationImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<PackageRecommendationImpressionEvent>
{
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasPackages = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private List<ViewedPackage> packages = null;
  private UserRequestHeader requestHeader = null;
  
  private PackageRecommendationImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PackageRecommendationImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (packages != null)
    {
      paramFlavor = packages.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((ViewedPackage)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationImpressionEvent", "packages");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationImpressionEvent", "requestHeader");
            }
            if (hasPackages) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationImpressionEvent", "packages");
          }
        }
      }
    }
    return new PackageRecommendationImpressionEvent(header, requestHeader, mobileHeader, packages, hasHeader, hasRequestHeader, hasMobileHeader, hasPackages);
  }
  
  public final Builder setPackages(List<ViewedPackage> paramList)
  {
    if (paramList == null)
    {
      hasPackages = false;
      packages = null;
      return this;
    }
    hasPackages = true;
    packages = paramList;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */