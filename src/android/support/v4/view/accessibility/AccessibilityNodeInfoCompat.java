package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public final class AccessibilityNodeInfoCompat
{
  public static final AccessibilityNodeInfoImpl IMPL = new AccessibilityNodeInfoStubImpl();
  public final Object mInfo;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22)
    {
      IMPL = new AccessibilityNodeInfoApi22Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      IMPL = new AccessibilityNodeInfoApi21Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new AccessibilityNodeInfoKitKatImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new AccessibilityNodeInfoJellybeanMr2Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      IMPL = new AccessibilityNodeInfoJellybeanMr1Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new AccessibilityNodeInfoJellybeanImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new AccessibilityNodeInfoIcsImpl();
      return;
    }
  }
  
  public AccessibilityNodeInfoCompat(Object paramObject)
  {
    mInfo = paramObject;
  }
  
  public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    paramAccessibilityNodeInfoCompat = IMPL.obtain(mInfo);
    if (paramAccessibilityNodeInfoCompat != null) {
      return new AccessibilityNodeInfoCompat(paramAccessibilityNodeInfoCompat);
    }
    return null;
  }
  
  public final void addAction(int paramInt)
  {
    IMPL.addAction(mInfo, paramInt);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (AccessibilityNodeInfoCompat)paramObject;
        if (mInfo != null) {
          break;
        }
      } while (mInfo == null);
      return false;
    } while (mInfo.equals(mInfo));
    return false;
  }
  
  public final int getActions()
  {
    return IMPL.getActions(mInfo);
  }
  
  public final void getBoundsInParent(Rect paramRect)
  {
    IMPL.getBoundsInParent(mInfo, paramRect);
  }
  
  public final void getBoundsInScreen(Rect paramRect)
  {
    IMPL.getBoundsInScreen(mInfo, paramRect);
  }
  
  public final CharSequence getClassName()
  {
    return IMPL.getClassName(mInfo);
  }
  
  public final CharSequence getContentDescription()
  {
    return IMPL.getContentDescription(mInfo);
  }
  
  public final CharSequence getPackageName()
  {
    return IMPL.getPackageName(mInfo);
  }
  
  public final int hashCode()
  {
    if (mInfo == null) {
      return 0;
    }
    return mInfo.hashCode();
  }
  
  public final boolean isClickable()
  {
    return IMPL.isClickable(mInfo);
  }
  
  public final boolean isEnabled()
  {
    return IMPL.isEnabled(mInfo);
  }
  
  public final boolean isFocusable()
  {
    return IMPL.isFocusable(mInfo);
  }
  
  public final boolean isFocused()
  {
    return IMPL.isFocused(mInfo);
  }
  
  public final boolean isLongClickable()
  {
    return IMPL.isLongClickable(mInfo);
  }
  
  public final boolean isSelected()
  {
    return IMPL.isSelected(mInfo);
  }
  
  public final boolean removeAction(AccessibilityActionCompat paramAccessibilityActionCompat)
  {
    return IMPL.removeAction(mInfo, mAction);
  }
  
  public final void setClassName(CharSequence paramCharSequence)
  {
    IMPL.setClassName(mInfo, paramCharSequence);
  }
  
  public final void setCollectionItemInfo(Object paramObject)
  {
    IMPL.setCollectionItemInfo(mInfo, mInfo);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    IMPL.setFocusable(mInfo, paramBoolean);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    IMPL.setFocused(mInfo, paramBoolean);
  }
  
  public final void setParent(View paramView)
  {
    IMPL.setParent(mInfo, paramView);
  }
  
  public final void setScrollable(boolean paramBoolean)
  {
    IMPL.setScrollable(mInfo, paramBoolean);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Object localObject = new Rect();
    getBoundsInParent((Rect)localObject);
    localStringBuilder.append("; boundsInParent: " + localObject);
    getBoundsInScreen((Rect)localObject);
    localStringBuilder.append("; boundsInScreen: " + localObject);
    localStringBuilder.append("; packageName: ").append(getPackageName());
    localStringBuilder.append("; className: ").append(getClassName());
    localStringBuilder.append("; text: ").append(IMPL.getText(mInfo));
    localStringBuilder.append("; contentDescription: ").append(getContentDescription());
    localStringBuilder.append("; viewId: ").append(IMPL.getViewIdResourceName(mInfo));
    localStringBuilder.append("; checkable: ").append(IMPL.isCheckable(mInfo));
    localStringBuilder.append("; checked: ").append(IMPL.isChecked(mInfo));
    localStringBuilder.append("; focusable: ").append(isFocusable());
    localStringBuilder.append("; focused: ").append(isFocused());
    localStringBuilder.append("; selected: ").append(isSelected());
    localStringBuilder.append("; clickable: ").append(isClickable());
    localStringBuilder.append("; longClickable: ").append(isLongClickable());
    localStringBuilder.append("; enabled: ").append(isEnabled());
    localStringBuilder.append("; password: ").append(IMPL.isPassword(mInfo));
    localStringBuilder.append("; scrollable: " + IMPL.isScrollable(mInfo));
    localStringBuilder.append("; [");
    int i = getActions();
    if (i != 0)
    {
      int k = 1 << Integer.numberOfTrailingZeros(i);
      int j = i & (k ^ 0xFFFFFFFF);
      switch (k)
      {
      default: 
        localObject = "ACTION_UNKNOWN";
      }
      for (;;)
      {
        localStringBuilder.append((String)localObject);
        i = j;
        if (j == 0) {
          break;
        }
        localStringBuilder.append(", ");
        i = j;
        break;
        localObject = "ACTION_FOCUS";
        continue;
        localObject = "ACTION_CLEAR_FOCUS";
        continue;
        localObject = "ACTION_SELECT";
        continue;
        localObject = "ACTION_CLEAR_SELECTION";
        continue;
        localObject = "ACTION_CLICK";
        continue;
        localObject = "ACTION_LONG_CLICK";
        continue;
        localObject = "ACTION_ACCESSIBILITY_FOCUS";
        continue;
        localObject = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        continue;
        localObject = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        continue;
        localObject = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        continue;
        localObject = "ACTION_NEXT_HTML_ELEMENT";
        continue;
        localObject = "ACTION_PREVIOUS_HTML_ELEMENT";
        continue;
        localObject = "ACTION_SCROLL_FORWARD";
        continue;
        localObject = "ACTION_SCROLL_BACKWARD";
        continue;
        localObject = "ACTION_CUT";
        continue;
        localObject = "ACTION_COPY";
        continue;
        localObject = "ACTION_PASTE";
        continue;
        localObject = "ACTION_SET_SELECTION";
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static final class AccessibilityActionCompat
  {
    public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
    public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
    public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS;
    public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
    public static final AccessibilityActionCompat ACTION_CLICK;
    public static final AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityActionCompat(524288);
    public static final AccessibilityActionCompat ACTION_COPY;
    public static final AccessibilityActionCompat ACTION_CUT;
    public static final AccessibilityActionCompat ACTION_DISMISS = new AccessibilityActionCompat(1048576);
    public static final AccessibilityActionCompat ACTION_EXPAND;
    public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1);
    public static final AccessibilityActionCompat ACTION_LONG_CLICK;
    public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
    public static final AccessibilityActionCompat ACTION_PASTE;
    public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
    public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
    public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
    public static final AccessibilityActionCompat ACTION_SELECT;
    public static final AccessibilityActionCompat ACTION_SET_SELECTION;
    public static final AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityActionCompat(2097152);
    private final Object mAction;
    
    static
    {
      ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2);
      ACTION_SELECT = new AccessibilityActionCompat(4);
      ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8);
      ACTION_CLICK = new AccessibilityActionCompat(16);
      ACTION_LONG_CLICK = new AccessibilityActionCompat(32);
      ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64);
      ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128);
      ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256);
      ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512);
      ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024);
      ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048);
      ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096);
      ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192);
      ACTION_COPY = new AccessibilityActionCompat(16384);
      ACTION_PASTE = new AccessibilityActionCompat(32768);
      ACTION_CUT = new AccessibilityActionCompat(65536);
      ACTION_SET_SELECTION = new AccessibilityActionCompat(131072);
      ACTION_EXPAND = new AccessibilityActionCompat(262144);
    }
    
    private AccessibilityActionCompat(int paramInt)
    {
      this(AccessibilityNodeInfoCompat.access$000().newAccessibilityAction$442b94a0(paramInt));
    }
    
    private AccessibilityActionCompat(Object paramObject)
    {
      mAction = paramObject;
    }
  }
  
  static class AccessibilityNodeInfoApi21Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoKitKatImpl
  {
    public final Object newAccessibilityAction$442b94a0(int paramInt)
    {
      return new AccessibilityNodeInfo.AccessibilityAction(paramInt, null);
    }
    
    public final Object obtainCollectionInfo$50cb9c52(int paramInt1, int paramInt2)
    {
      return AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, false, 0);
    }
    
    public final Object obtainCollectionItemInfo$771e0323(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      return AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, false);
    }
    
    public final boolean removeAction(Object paramObject1, Object paramObject2)
    {
      return ((AccessibilityNodeInfo)paramObject1).removeAction((AccessibilityNodeInfo.AccessibilityAction)paramObject2);
    }
    
    public final void setError(Object paramObject, CharSequence paramCharSequence)
    {
      ((AccessibilityNodeInfo)paramObject).setError(paramCharSequence);
    }
  }
  
  static final class AccessibilityNodeInfoApi22Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi21Impl
  {}
  
  static class AccessibilityNodeInfoIcsImpl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl
  {
    public final void addAction(Object paramObject, int paramInt)
    {
      ((AccessibilityNodeInfo)paramObject).addAction(paramInt);
    }
    
    public final void addChild(Object paramObject, View paramView)
    {
      ((AccessibilityNodeInfo)paramObject).addChild(paramView);
    }
    
    public final int getActions(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).getActions();
    }
    
    public final void getBoundsInParent(Object paramObject, Rect paramRect)
    {
      ((AccessibilityNodeInfo)paramObject).getBoundsInParent(paramRect);
    }
    
    public final void getBoundsInScreen(Object paramObject, Rect paramRect)
    {
      ((AccessibilityNodeInfo)paramObject).getBoundsInScreen(paramRect);
    }
    
    public final CharSequence getClassName(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).getClassName();
    }
    
    public final CharSequence getContentDescription(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).getContentDescription();
    }
    
    public final CharSequence getPackageName(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).getPackageName();
    }
    
    public final CharSequence getText(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).getText();
    }
    
    public final boolean isCheckable(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isCheckable();
    }
    
    public final boolean isChecked(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isChecked();
    }
    
    public final boolean isClickable(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isClickable();
    }
    
    public final boolean isEnabled(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isEnabled();
    }
    
    public final boolean isFocusable(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isFocusable();
    }
    
    public final boolean isFocused(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isFocused();
    }
    
    public final boolean isLongClickable(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isLongClickable();
    }
    
    public final boolean isPassword(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isPassword();
    }
    
    public final boolean isScrollable(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isScrollable();
    }
    
    public final boolean isSelected(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isSelected();
    }
    
    public final Object obtain(Object paramObject)
    {
      return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)paramObject);
    }
    
    public final void recycle(Object paramObject)
    {
      ((AccessibilityNodeInfo)paramObject).recycle();
    }
    
    public final void setBoundsInParent(Object paramObject, Rect paramRect)
    {
      ((AccessibilityNodeInfo)paramObject).setBoundsInParent(paramRect);
    }
    
    public final void setBoundsInScreen(Object paramObject, Rect paramRect)
    {
      ((AccessibilityNodeInfo)paramObject).setBoundsInScreen(paramRect);
    }
    
    public final void setClassName(Object paramObject, CharSequence paramCharSequence)
    {
      ((AccessibilityNodeInfo)paramObject).setClassName(paramCharSequence);
    }
    
    public final void setClickable(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setClickable(paramBoolean);
    }
    
    public final void setContentDescription(Object paramObject, CharSequence paramCharSequence)
    {
      ((AccessibilityNodeInfo)paramObject).setContentDescription(paramCharSequence);
    }
    
    public final void setEnabled(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setEnabled(paramBoolean);
    }
    
    public final void setFocusable(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setFocusable(paramBoolean);
    }
    
    public final void setFocused(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setFocused(paramBoolean);
    }
    
    public final void setLongClickable(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setLongClickable(paramBoolean);
    }
    
    public final void setPackageName(Object paramObject, CharSequence paramCharSequence)
    {
      ((AccessibilityNodeInfo)paramObject).setPackageName(paramCharSequence);
    }
    
    public final void setParent(Object paramObject, View paramView)
    {
      ((AccessibilityNodeInfo)paramObject).setParent(paramView);
    }
    
    public final void setScrollable(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setScrollable(paramBoolean);
    }
    
    public final void setSelected(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setSelected(paramBoolean);
    }
    
    public final void setSource(Object paramObject, View paramView)
    {
      ((AccessibilityNodeInfo)paramObject).setSource(paramView);
    }
    
    public final void setText(Object paramObject, CharSequence paramCharSequence)
    {
      ((AccessibilityNodeInfo)paramObject).setText(paramCharSequence);
    }
  }
  
  public static abstract interface AccessibilityNodeInfoImpl
  {
    public abstract void addAction(Object paramObject, int paramInt);
    
    public abstract void addChild(Object paramObject, View paramView);
    
    public abstract int getActions(Object paramObject);
    
    public abstract void getBoundsInParent(Object paramObject, Rect paramRect);
    
    public abstract void getBoundsInScreen(Object paramObject, Rect paramRect);
    
    public abstract CharSequence getClassName(Object paramObject);
    
    public abstract CharSequence getContentDescription(Object paramObject);
    
    public abstract CharSequence getPackageName(Object paramObject);
    
    public abstract CharSequence getText(Object paramObject);
    
    public abstract String getViewIdResourceName(Object paramObject);
    
    public abstract boolean isAccessibilityFocused(Object paramObject);
    
    public abstract boolean isCheckable(Object paramObject);
    
    public abstract boolean isChecked(Object paramObject);
    
    public abstract boolean isClickable(Object paramObject);
    
    public abstract boolean isEnabled(Object paramObject);
    
    public abstract boolean isFocusable(Object paramObject);
    
    public abstract boolean isFocused(Object paramObject);
    
    public abstract boolean isLongClickable(Object paramObject);
    
    public abstract boolean isPassword(Object paramObject);
    
    public abstract boolean isScrollable(Object paramObject);
    
    public abstract boolean isSelected(Object paramObject);
    
    public abstract boolean isVisibleToUser(Object paramObject);
    
    public abstract Object newAccessibilityAction$442b94a0(int paramInt);
    
    public abstract Object obtain(Object paramObject);
    
    public abstract Object obtainCollectionInfo$50cb9c52(int paramInt1, int paramInt2);
    
    public abstract Object obtainCollectionItemInfo$771e0323(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
    
    public abstract void recycle(Object paramObject);
    
    public abstract boolean removeAction(Object paramObject1, Object paramObject2);
    
    public abstract void setAccessibilityFocused(Object paramObject, boolean paramBoolean);
    
    public abstract void setBoundsInParent(Object paramObject, Rect paramRect);
    
    public abstract void setBoundsInScreen(Object paramObject, Rect paramRect);
    
    public abstract void setClassName(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setClickable(Object paramObject, boolean paramBoolean);
    
    public abstract void setCollectionInfo(Object paramObject1, Object paramObject2);
    
    public abstract void setCollectionItemInfo(Object paramObject1, Object paramObject2);
    
    public abstract void setContentDescription(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setContentInvalid$4cfd3ce3(Object paramObject);
    
    public abstract void setEnabled(Object paramObject, boolean paramBoolean);
    
    public abstract void setError(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setFocusable(Object paramObject, boolean paramBoolean);
    
    public abstract void setFocused(Object paramObject, boolean paramBoolean);
    
    public abstract void setLabelFor(Object paramObject, View paramView);
    
    public abstract void setLongClickable(Object paramObject, boolean paramBoolean);
    
    public abstract void setPackageName(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setParent(Object paramObject, View paramView);
    
    public abstract void setScrollable(Object paramObject, boolean paramBoolean);
    
    public abstract void setSelected(Object paramObject, boolean paramBoolean);
    
    public abstract void setSource(Object paramObject, View paramView);
    
    public abstract void setText(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setVisibleToUser(Object paramObject, boolean paramBoolean);
  }
  
  static class AccessibilityNodeInfoJellybeanImpl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl
  {
    public final boolean isAccessibilityFocused(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isAccessibilityFocused();
    }
    
    public final boolean isVisibleToUser(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).isVisibleToUser();
    }
    
    public final void setAccessibilityFocused(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setAccessibilityFocused(paramBoolean);
    }
    
    public final void setVisibleToUser(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityNodeInfo)paramObject).setVisibleToUser(paramBoolean);
    }
  }
  
  static class AccessibilityNodeInfoJellybeanMr1Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanImpl
  {
    public final void setLabelFor(Object paramObject, View paramView)
    {
      ((AccessibilityNodeInfo)paramObject).setLabelFor(paramView);
    }
  }
  
  static class AccessibilityNodeInfoJellybeanMr2Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr1Impl
  {
    public final String getViewIdResourceName(Object paramObject)
    {
      return ((AccessibilityNodeInfo)paramObject).getViewIdResourceName();
    }
  }
  
  static class AccessibilityNodeInfoKitKatImpl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr2Impl
  {
    public Object obtainCollectionInfo$50cb9c52(int paramInt1, int paramInt2)
    {
      return AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, false);
    }
    
    public Object obtainCollectionItemInfo$771e0323(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      return AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    }
    
    public final void setCollectionInfo(Object paramObject1, Object paramObject2)
    {
      ((AccessibilityNodeInfo)paramObject1).setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)paramObject2);
    }
    
    public final void setCollectionItemInfo(Object paramObject1, Object paramObject2)
    {
      ((AccessibilityNodeInfo)paramObject1).setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)paramObject2);
    }
    
    public final void setContentInvalid$4cfd3ce3(Object paramObject)
    {
      ((AccessibilityNodeInfo)paramObject).setContentInvalid(true);
    }
  }
  
  static class AccessibilityNodeInfoStubImpl
    implements AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
  {
    public void addAction(Object paramObject, int paramInt) {}
    
    public void addChild(Object paramObject, View paramView) {}
    
    public int getActions(Object paramObject)
    {
      return 0;
    }
    
    public void getBoundsInParent(Object paramObject, Rect paramRect) {}
    
    public void getBoundsInScreen(Object paramObject, Rect paramRect) {}
    
    public CharSequence getClassName(Object paramObject)
    {
      return null;
    }
    
    public CharSequence getContentDescription(Object paramObject)
    {
      return null;
    }
    
    public CharSequence getPackageName(Object paramObject)
    {
      return null;
    }
    
    public CharSequence getText(Object paramObject)
    {
      return null;
    }
    
    public String getViewIdResourceName(Object paramObject)
    {
      return null;
    }
    
    public boolean isAccessibilityFocused(Object paramObject)
    {
      return false;
    }
    
    public boolean isCheckable(Object paramObject)
    {
      return false;
    }
    
    public boolean isChecked(Object paramObject)
    {
      return false;
    }
    
    public boolean isClickable(Object paramObject)
    {
      return false;
    }
    
    public boolean isEnabled(Object paramObject)
    {
      return false;
    }
    
    public boolean isFocusable(Object paramObject)
    {
      return false;
    }
    
    public boolean isFocused(Object paramObject)
    {
      return false;
    }
    
    public boolean isLongClickable(Object paramObject)
    {
      return false;
    }
    
    public boolean isPassword(Object paramObject)
    {
      return false;
    }
    
    public boolean isScrollable(Object paramObject)
    {
      return false;
    }
    
    public boolean isSelected(Object paramObject)
    {
      return false;
    }
    
    public boolean isVisibleToUser(Object paramObject)
    {
      return false;
    }
    
    public Object newAccessibilityAction$442b94a0(int paramInt)
    {
      return null;
    }
    
    public Object obtain(Object paramObject)
    {
      return null;
    }
    
    public Object obtainCollectionInfo$50cb9c52(int paramInt1, int paramInt2)
    {
      return null;
    }
    
    public Object obtainCollectionItemInfo$771e0323(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      return null;
    }
    
    public void recycle(Object paramObject) {}
    
    public boolean removeAction(Object paramObject1, Object paramObject2)
    {
      return false;
    }
    
    public void setAccessibilityFocused(Object paramObject, boolean paramBoolean) {}
    
    public void setBoundsInParent(Object paramObject, Rect paramRect) {}
    
    public void setBoundsInScreen(Object paramObject, Rect paramRect) {}
    
    public void setClassName(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setClickable(Object paramObject, boolean paramBoolean) {}
    
    public void setCollectionInfo(Object paramObject1, Object paramObject2) {}
    
    public void setCollectionItemInfo(Object paramObject1, Object paramObject2) {}
    
    public void setContentDescription(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setContentInvalid$4cfd3ce3(Object paramObject) {}
    
    public void setEnabled(Object paramObject, boolean paramBoolean) {}
    
    public void setError(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setFocusable(Object paramObject, boolean paramBoolean) {}
    
    public void setFocused(Object paramObject, boolean paramBoolean) {}
    
    public void setLabelFor(Object paramObject, View paramView) {}
    
    public void setLongClickable(Object paramObject, boolean paramBoolean) {}
    
    public void setPackageName(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setParent(Object paramObject, View paramView) {}
    
    public void setScrollable(Object paramObject, boolean paramBoolean) {}
    
    public void setSelected(Object paramObject, boolean paramBoolean) {}
    
    public void setSource(Object paramObject, View paramView) {}
    
    public void setText(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setVisibleToUser(Object paramObject, boolean paramBoolean) {}
  }
  
  public static final class CollectionInfoCompat
  {
    public final Object mInfo;
    
    public CollectionInfoCompat(Object paramObject)
    {
      mInfo = paramObject;
    }
  }
  
  public static final class CollectionItemInfoCompat
  {
    final Object mInfo;
    
    private CollectionItemInfoCompat(Object paramObject)
    {
      mInfo = paramObject;
    }
    
    public static CollectionItemInfoCompat obtain$430787b1(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.access$000().obtainCollectionItemInfo$771e0323(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean));
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */