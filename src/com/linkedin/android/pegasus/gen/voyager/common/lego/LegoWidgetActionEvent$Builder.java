package com.linkedin.android.pegasus.gen.voyager.common.lego;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class LegoWidgetActionEvent$Builder
  implements RecordTemplateBuilder<LegoWidgetActionEvent>
{
  private ActionCategory actionCategory = null;
  private int actionCount = 0;
  private boolean hasActionCategory = false;
  private boolean hasActionCount = false;
  public boolean hasTrackingId = false;
  private boolean hasTrackingToken = false;
  public String trackingId = null;
  private String trackingToken = null;
  
  public final LegoWidgetActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (LegoWidgetActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new LegoWidgetActionEvent(trackingToken, trackingId, actionCategory, actionCount, hasTrackingToken, hasTrackingId, hasActionCategory, hasActionCount);
      if (!hasActionCount) {
        actionCount = 1;
      }
      if (!hasTrackingToken) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetActionEvent", "trackingToken");
      }
    } while (hasActionCategory);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetActionEvent", "actionCategory");
  }
  
  public final Builder setActionCategory(ActionCategory paramActionCategory)
  {
    if (paramActionCategory == null)
    {
      hasActionCategory = false;
      actionCategory = null;
      return this;
    }
    hasActionCategory = true;
    actionCategory = paramActionCategory;
    return this;
  }
  
  public final Builder setActionCount(Integer paramInteger)
  {
    if ((paramInteger == null) || (paramInteger.intValue() == 1))
    {
      hasActionCount = false;
      actionCount = 1;
      return this;
    }
    hasActionCount = true;
    actionCount = paramInteger.intValue();
    return this;
  }
  
  public final Builder setTrackingToken(String paramString)
  {
    if (paramString == null)
    {
      hasTrackingToken = false;
      trackingToken = null;
      return this;
    }
    hasTrackingToken = true;
    trackingToken = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */