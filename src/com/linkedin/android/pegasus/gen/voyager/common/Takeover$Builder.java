package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Takeover$Builder
  implements RecordTemplateBuilder<Takeover>
{
  public String globalLegoTrackingToken = null;
  public boolean hasGlobalLegoTrackingToken = false;
  public boolean hasLegoTrackingToken = false;
  public boolean hasTakeoverType = false;
  public String legoTrackingToken = null;
  public TakeoverType takeoverType = null;
  
  public final Takeover build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Takeover.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Takeover(takeoverType, legoTrackingToken, globalLegoTrackingToken, hasTakeoverType, hasLegoTrackingToken, hasGlobalLegoTrackingToken);
      if (!hasTakeoverType) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Takeover", "takeoverType");
      }
      if (!hasLegoTrackingToken) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Takeover", "legoTrackingToken");
      }
    } while (hasGlobalLegoTrackingToken);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Takeover", "globalLegoTrackingToken");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.Takeover.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */