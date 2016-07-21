package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

final class AccessibilityEventCompat$AccessibilityEventKitKatImpl
  extends AccessibilityEventCompat.AccessibilityEventIcsImpl
{
  public final int getContentChangeTypes(AccessibilityEvent paramAccessibilityEvent)
  {
    return paramAccessibilityEvent.getContentChangeTypes();
  }
  
  public final void setContentChangeTypes(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    paramAccessibilityEvent.setContentChangeTypes(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventKitKatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */