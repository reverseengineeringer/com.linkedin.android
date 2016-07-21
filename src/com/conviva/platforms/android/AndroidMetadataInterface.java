package com.conviva.platforms.android;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.conviva.api.Client.DeviceType;
import com.conviva.api.system.IMetadataInterface;

public final class AndroidMetadataInterface
  implements IMetadataInterface
{
  private Context _context = null;
  
  public AndroidMetadataInterface(Context paramContext)
  {
    _context = paramContext;
  }
  
  public final String getAndroidBuildModel()
  {
    return Build.MODEL;
  }
  
  public final String getDeviceBrand()
  {
    return Build.BRAND;
  }
  
  public final String getDeviceManufacturer()
  {
    return Build.MANUFACTURER;
  }
  
  public final Client.DeviceType getDeviceType()
  {
    if ((Build.VERSION.SDK_INT >= 13) && (_context != null))
    {
      UiModeManager localUiModeManager = (UiModeManager)_context.getSystemService("uimode");
      if ((localUiModeManager != null) && (localUiModeManager.getCurrentModeType() == 4)) {
        return Client.DeviceType.SETTOP;
      }
    }
    return Client.DeviceType.UNKNOWN;
  }
  
  public final String getOperatingSystemVersion()
  {
    return Build.VERSION.RELEASE;
  }
}

/* Location:
 * Qualified Name:     com.conviva.platforms.android.AndroidMetadataInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */