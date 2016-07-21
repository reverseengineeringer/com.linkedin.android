package android.support.design.widget;

class TextInputLayout$4
  implements ValueAnimatorCompat.AnimatorUpdateListener
{
  TextInputLayout$4(TextInputLayout paramTextInputLayout) {}
  
  public void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat)
  {
    TextInputLayout.access$500(this$0).setExpansionFraction(paramValueAnimatorCompat.getAnimatedFloatValue());
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.TextInputLayout.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */