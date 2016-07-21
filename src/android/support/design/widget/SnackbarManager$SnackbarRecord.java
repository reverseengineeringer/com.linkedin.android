package android.support.design.widget;

import java.lang.ref.WeakReference;

class SnackbarManager$SnackbarRecord
{
  private final WeakReference<SnackbarManager.Callback> callback;
  private int duration;
  
  SnackbarManager$SnackbarRecord(int paramInt, SnackbarManager.Callback paramCallback)
  {
    callback = new WeakReference(paramCallback);
    duration = paramInt;
  }
  
  boolean isSnackbar(SnackbarManager.Callback paramCallback)
  {
    return (paramCallback != null) && (callback.get() == paramCallback);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.SnackbarManager.SnackbarRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */