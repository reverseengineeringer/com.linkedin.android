package com.linkedin.messengerlib.ui;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import com.linkedin.messengerlib.ui.common.BackButtonKeyboardAwareBehavior;
import com.linkedin.messengerlib.ui.common.KeyboardAwareEditText.KeyboardAwareEditTextHost;
import com.linkedin.messengerlib.viewmodel.ViewModel;
import com.tokenautocomplete.TokenCompleteTextView;

public class PeopleSearchCompletionView
  extends TokenCompleteTextView<ViewModel>
{
  private KeyboardAwareEditText.KeyboardAwareEditTextHost keyboardAwareEditTextHost;
  
  public PeopleSearchCompletionView(Context paramContext)
  {
    super(paramContext);
    allowCollapse = false;
  }
  
  public PeopleSearchCompletionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    allowCollapse = false;
  }
  
  public PeopleSearchCompletionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    allowCollapse = false;
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
    if (keyboardAwareEditTextHost == null) {
      return super.dispatchKeyEventPreIme(paramKeyEvent);
    }
    if (paramKeyEvent.getKeyCode() != 4) {
      return super.dispatchKeyEventPreIme(paramKeyEvent);
    }
    if (localDispatcherState == null) {
      return super.dispatchKeyEventPreIme(paramKeyEvent);
    }
    return BackButtonKeyboardAwareBehavior.dispatchKeyEventPreIme(this, paramKeyEvent, localDispatcherState, keyboardAwareEditTextHost);
  }
  
  public void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (!paramBoolean)
    {
      int i = getText().toString().lastIndexOf(", ");
      if (i == -1) {
        break label55;
      }
      getText().delete(i + 2, getText().length());
    }
    for (;;)
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      return;
      label55:
      getText().delete(0, getText().length());
    }
  }
  
  public void setEditTextHost(KeyboardAwareEditText.KeyboardAwareEditTextHost paramKeyboardAwareEditTextHost)
  {
    keyboardAwareEditTextHost = paramKeyboardAwareEditTextHost;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.PeopleSearchCompletionView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */