package com.linkedin.android.growth.abi;

import android.os.Bundle;
import com.linkedin.android.growth.abi.m2g.MainAbiM2GEmailLegoWidget;
import com.linkedin.android.growth.abi.m2g.MainAbiM2GSmsLegoWidget;
import com.linkedin.android.growth.abi.m2g.MainAbiM2GUnifiedSmsEmailLegoWidget;
import com.linkedin.android.growth.abi.m2m.MainAbiM2MLegoWidget;
import com.linkedin.android.growth.abi.pymk.AbiPymkLegoWidget;
import com.linkedin.android.growth.abi.splash.MainAbiSplashLegoWidget;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.lego.LegoWidgetSwitch;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;
import javax.inject.Inject;

public final class AbiLegoWidgetSwitch
  extends LegoWidgetSwitch
{
  public final LegoWidget detectLegoWidget(WidgetContent paramWidgetContent, Bundle paramBundle)
  {
    paramWidgetContent = widgetId;
    int i = -1;
    switch (paramWidgetContent.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return null;
        if (paramWidgetContent.equals("voyager_main_abi_splash"))
        {
          i = 0;
          continue;
          if (paramWidgetContent.equals("voyager_main_abi_m2m"))
          {
            i = 1;
            continue;
            if (paramWidgetContent.equals("voyager_main_abi_pymk"))
            {
              i = 2;
              continue;
              if (paramWidgetContent.equals("voyager_main_abi_m2g_email"))
              {
                i = 3;
                continue;
                if (paramWidgetContent.equals("voyager_main_abi_m2g_sms"))
                {
                  i = 4;
                  continue;
                  if (paramWidgetContent.equals("voyager_main_abi_unified_m2g_email_sms")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    paramWidgetContent = new MainAbiSplashLegoWidget();
    paramWidgetContent.setArguments(paramBundle);
    return paramWidgetContent;
    return new MainAbiM2MLegoWidget();
    return new AbiPymkLegoWidget();
    return new MainAbiM2GEmailLegoWidget();
    return new MainAbiM2GSmsLegoWidget();
    return new MainAbiM2GUnifiedSmsEmailLegoWidget();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiLegoWidgetSwitch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */