package android.support.design.widget;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import java.util.List;

class TextInputLayout$TextInputAccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  private TextInputLayout$TextInputAccessibilityDelegate(TextInputLayout paramTextInputLayout) {}
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(TextInputLayout.class.getSimpleName());
    paramView = TextInputLayout.access$500(this$0).getText();
    if (!TextUtils.isEmpty(paramView)) {
      AccessibilityNodeInfoCompat.IMPL.setText(mInfo, paramView);
    }
    if (TextInputLayout.access$600(this$0) != null)
    {
      paramView = TextInputLayout.access$600(this$0);
      AccessibilityNodeInfoCompat.IMPL.setLabelFor(mInfo, paramView);
    }
    if (TextInputLayout.access$400(this$0) != null) {}
    for (paramView = TextInputLayout.access$400(this$0).getText();; paramView = null)
    {
      if (!TextUtils.isEmpty(paramView))
      {
        AccessibilityNodeInfoCompat.IMPL.setContentInvalid$4cfd3ce3(mInfo);
        AccessibilityNodeInfoCompat.IMPL.setError(mInfo, paramView);
      }
      return;
    }
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramView = TextInputLayout.access$500(this$0).getText();
    if (!TextUtils.isEmpty(paramView)) {
      paramAccessibilityEvent.getText().add(paramView);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.TextInputLayout.TextInputAccessibilityDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */