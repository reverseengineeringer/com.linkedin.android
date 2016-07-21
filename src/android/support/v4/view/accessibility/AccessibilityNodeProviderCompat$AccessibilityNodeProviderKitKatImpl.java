package android.support.v4.view.accessibility;

import java.util.ArrayList;
import java.util.List;

final class AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl
  extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl
{
  public final Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
  {
    new AccessibilityNodeProviderCompatKitKat.1(new AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge()
    {
      public final Object createAccessibilityNodeInfo$54cf32c4()
      {
        AccessibilityNodeProviderCompat.createAccessibilityNodeInfo$f3a5639();
        return null;
      }
      
      public final List<Object> findAccessibilityNodeInfosByText$2393931d()
      {
        AccessibilityNodeProviderCompat.findAccessibilityNodeInfosByText$2393931d();
        new ArrayList();
        throw new NullPointerException();
      }
      
      public final Object findFocus$54cf32c4()
      {
        AccessibilityNodeProviderCompat.findFocus$f3a5639();
        return null;
      }
      
      public final boolean performAction$5985f823()
      {
        return AccessibilityNodeProviderCompat.performAction$5985f823();
      }
    });
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */