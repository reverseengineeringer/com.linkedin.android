package android.support.design.widget;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.widget.TextView;

class TextInputLayout$3
  extends ViewPropertyAnimatorListenerAdapter
{
  TextInputLayout$3(TextInputLayout paramTextInputLayout, CharSequence paramCharSequence) {}
  
  public void onAnimationEnd(View paramView)
  {
    TextInputLayout.access$400(this$0).setText(val$error);
    paramView.setVisibility(4);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.TextInputLayout.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */