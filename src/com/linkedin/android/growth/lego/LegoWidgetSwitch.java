package com.linkedin.android.growth.lego;

import android.os.Bundle;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;

public abstract class LegoWidgetSwitch
{
  public abstract LegoWidget detectLegoWidget(WidgetContent paramWidgetContent, Bundle paramBundle);
  
  public final LegoWidget getLegoWidget(WidgetContent paramWidgetContent, Bundle paramBundle)
  {
    LegoWidget localLegoWidget = detectLegoWidget(paramWidgetContent, paramBundle);
    if (localLegoWidget != null)
    {
      paramBundle = localLegoWidget.getArguments();
      if (paramBundle == null) {
        break label39;
      }
      paramBundle.putString("tracking_token", trackingToken);
    }
    label39:
    for (paramWidgetContent = paramBundle;; paramWidgetContent = new LegoBundleBuilder(trackingToken).build())
    {
      localLegoWidget.setArguments(paramWidgetContent);
      return localLegoWidget;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoWidgetSwitch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */