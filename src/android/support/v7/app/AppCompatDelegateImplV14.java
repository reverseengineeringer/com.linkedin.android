package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.content.PermissionChecker;
import android.support.v7.view.SupportActionModeWrapper.CallbackWrapper;
import android.util.Log;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;
import java.util.Calendar;

class AppCompatDelegateImplV14
  extends AppCompatDelegateImplV11
{
  private static TwilightManager sTwilightManager;
  private boolean mApplyDayNightCalled;
  boolean mHandleNativeActionModes = true;
  private int mLocalNightMode = -100;
  
  AppCompatDelegateImplV14(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  public final boolean applyDayNight()
  {
    mApplyDayNightCalled = true;
    Resources localResources;
    Configuration localConfiguration;
    int j;
    if (mLocalNightMode == -100)
    {
      i = AppCompatDelegate.sDefaultNightMode;
      i = mapNightMode(i);
      if (i == -1) {
        break label116;
      }
      localResources = mContext.getResources();
      localConfiguration = localResources.getConfiguration();
      j = uiMode;
      if (i != 2) {
        break label108;
      }
    }
    label108:
    for (int i = 32;; i = 16)
    {
      if ((j & 0x30) == i) {
        break label114;
      }
      localConfiguration = new Configuration(localConfiguration);
      uiMode = (i | uiMode & 0xFFFFFFCF);
      localResources.updateConfiguration(localConfiguration, null);
      return true;
      i = mLocalNightMode;
      break;
    }
    label114:
    return false;
    label116:
    return false;
  }
  
  int mapNightMode(int paramInt)
  {
    Location localLocation1 = null;
    Object localObject;
    TwilightManager.TwilightState localTwilightState;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      if (sTwilightManager == null) {
        sTwilightManager = new TwilightManager(mContext.getApplicationContext());
      }
      localObject = sTwilightManager;
      localTwilightState = TwilightManager.sTwilightState;
      if (TwilightManager.isStateValid(localTwilightState))
      {
        bool = isNight;
        if (bool) {
          return 2;
        }
      }
      else
      {
        if (PermissionChecker.checkSelfPermission(mContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
          break label231;
        }
      }
      break;
    }
    label188:
    label231:
    for (Location localLocation2 = ((TwilightManager)localObject).getLastKnownLocationForProvider("network");; localLocation2 = null)
    {
      if (PermissionChecker.checkSelfPermission(mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
        localLocation1 = ((TwilightManager)localObject).getLastKnownLocationForProvider("gps");
      }
      if ((localLocation1 != null) && (localLocation2 != null))
      {
        localObject = localLocation2;
        if (localLocation1.getTime() > localLocation2.getTime()) {
          localObject = localLocation1;
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label188;
        }
        TwilightManager.updateState((Location)localObject);
        bool = isNight;
        break;
        localObject = localLocation2;
        if (localLocation1 != null) {
          localObject = localLocation1;
        }
      }
      Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
      paramInt = Calendar.getInstance().get(11);
      if ((paramInt < 6) || (paramInt >= 22))
      {
        bool = true;
        break;
      }
      bool = false;
      break;
      return 1;
      return -1;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle != null) && (mLocalNightMode == -100)) {
      mLocalNightMode = paramBundle.getInt("appcompat:local_night_mode", -100);
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (mLocalNightMode != -100) {
      paramBundle.putInt("appcompat:local_night_mode", mLocalNightMode);
    }
  }
  
  Window.Callback wrapWindowCallback(Window.Callback paramCallback)
  {
    return new AppCompatWindowCallbackV14(paramCallback);
  }
  
  class AppCompatWindowCallbackV14
    extends AppCompatDelegateImplBase.AppCompatWindowCallbackBase
  {
    AppCompatWindowCallbackV14(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (mHandleNativeActionModes) {
        return startAsSupportActionMode(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
    
    final android.view.ActionMode startAsSupportActionMode(ActionMode.Callback paramCallback)
    {
      paramCallback = new SupportActionModeWrapper.CallbackWrapper(mContext, paramCallback);
      android.support.v7.view.ActionMode localActionMode = startSupportActionMode(paramCallback);
      if (localActionMode != null) {
        return paramCallback.getActionModeWrapper(localActionMode);
      }
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */