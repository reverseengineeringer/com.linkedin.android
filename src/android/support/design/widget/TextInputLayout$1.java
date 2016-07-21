package android.support.design.widget;

import android.text.Editable;
import android.text.TextWatcher;

class TextInputLayout$1
  implements TextWatcher
{
  TextInputLayout$1(TextInputLayout paramTextInputLayout) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    TextInputLayout.access$100(this$0, true);
    if (TextInputLayout.access$200(this$0)) {
      TextInputLayout.access$300(this$0, paramEditable.length());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     android.support.design.widget.TextInputLayout.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */