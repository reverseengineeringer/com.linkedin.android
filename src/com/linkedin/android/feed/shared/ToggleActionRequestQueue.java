package com.linkedin.android.feed.shared;

import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import java.util.Map;

public abstract class ToggleActionRequestQueue
{
  public final FlagshipApplication app;
  private boolean dead;
  public boolean networkPending;
  public boolean networkState;
  private boolean uiState;
  
  public ToggleActionRequestQueue(FlagshipApplication paramFlagshipApplication)
  {
    this(paramFlagshipApplication, false);
  }
  
  public ToggleActionRequestQueue(FlagshipApplication paramFlagshipApplication, boolean paramBoolean)
  {
    app = paramFlagshipApplication;
    uiState = paramBoolean;
    networkState = uiState;
  }
  
  private void updateNetworkState(Map<String, String> paramMap)
  {
    networkPending = true;
    if (uiState)
    {
      toggleNetworkOn(paramMap);
      return;
    }
    toggleNetworkOff(paramMap);
  }
  
  public final void die(String paramString, RuntimeException paramRuntimeException)
  {
    dead = true;
    String str = tag();
    paramString = new RuntimeException("ToggleActionRequestQueue(" + str + ") died because: " + paramString, paramRuntimeException);
    Util.safeThrow$7a8b4789(paramString);
    CrashReporter.reportNonFatal(paramString);
  }
  
  public void onErrorState(int paramInt)
  {
    Log.e(tag(), "Toggle request failed with status code [" + paramInt + "], but nobody was listening… The UI state probably doesn't match the server state anymore.");
  }
  
  public void onStableState() {}
  
  public final void overrideState(boolean paramBoolean)
  {
    if (dead) {}
    while (networkPending) {
      return;
    }
    uiState = paramBoolean;
    networkState = paramBoolean;
  }
  
  public final void requestFinished(boolean paramBoolean, int paramInt, Map<String, String> paramMap)
  {
    boolean bool = false;
    if (dead) {
      return;
    }
    networkPending = false;
    if (paramBoolean)
    {
      paramBoolean = bool;
      if (!networkState) {
        paramBoolean = true;
      }
      networkState = paramBoolean;
      if (uiState != networkState)
      {
        updateNetworkState(paramMap);
        return;
      }
      onStableState();
      return;
    }
    onErrorState(paramInt);
  }
  
  public final void setState(boolean paramBoolean, Map<String, String> paramMap)
  {
    if (dead) {}
    for (;;)
    {
      return;
      uiState = paramBoolean;
      if (uiState) {
        toggleUiOn();
      }
      while ((!networkPending) && (uiState != networkState))
      {
        updateNetworkState(paramMap);
        return;
        toggleUiOff();
      }
    }
  }
  
  public abstract String tag();
  
  public final void toggle(Map<String, String> paramMap)
  {
    if (!uiState) {}
    for (boolean bool = true;; bool = false)
    {
      setState(bool, paramMap);
      return;
    }
  }
  
  public abstract void toggleNetworkOff(Map<String, String> paramMap);
  
  public abstract void toggleNetworkOn(Map<String, String> paramMap);
  
  public abstract void toggleUiOff();
  
  public abstract void toggleUiOn();
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.ToggleActionRequestQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */