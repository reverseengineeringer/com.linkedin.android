package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

final class AppCompatDelegateImplV23
  extends AppCompatDelegateImplV14
{
  private final UiModeManager mUiModeManager;
  
  AppCompatDelegateImplV23(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
    mUiModeManager = ((UiModeManager)paramContext.getSystemService("uimode"));
  }
  
  final int mapNightMode(int paramInt)
  {
    if ((paramInt == 0) && (mUiModeManager.getNightMode() == 0)) {
      return -1;
    }
    return super.mapNightMode(paramInt);
  }
  
  final Window.Callback wrapWindowCallback(Window.Callback paramCallback)
  {
    return new AppCompatWindowCallbackV23(paramCallback);
  }
  
  final class AppCompatWindowCallbackV23
    extends AppCompatDelegateImplV14.AppCompatWindowCallbackV14
  {
    AppCompatWindowCallbackV23(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      return null;
    }
    
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if (mHandleNativeActionModes) {}
      switch (paramInt)
      {
      default: 
        return super.onWindowStartingActionMode(paramCallback, paramInt);
      }
      return startAsSupportActionMode(paramCallback);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */