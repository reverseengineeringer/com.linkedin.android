package android.support.design.widget;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class Snackbar$Callback
{
  public static final int DISMISS_EVENT_ACTION = 1;
  public static final int DISMISS_EVENT_CONSECUTIVE = 4;
  public static final int DISMISS_EVENT_MANUAL = 3;
  public static final int DISMISS_EVENT_SWIPE = 0;
  public static final int DISMISS_EVENT_TIMEOUT = 2;
  
  public void onDismissed(Snackbar paramSnackbar, int paramInt) {}
  
  public void onShown(Snackbar paramSnackbar) {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DismissEvent {}
}

/* Location:
 * Qualified Name:     android.support.design.widget.Snackbar.Callback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */