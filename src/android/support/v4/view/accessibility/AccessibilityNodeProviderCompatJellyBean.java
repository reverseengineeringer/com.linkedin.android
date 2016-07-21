package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class AccessibilityNodeProviderCompatJellyBean
{
  static abstract interface AccessibilityNodeInfoBridge
  {
    public abstract Object createAccessibilityNodeInfo$54cf32c4();
    
    public abstract List<Object> findAccessibilityNodeInfosByText$2393931d();
    
    public abstract boolean performAction$5985f823();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */