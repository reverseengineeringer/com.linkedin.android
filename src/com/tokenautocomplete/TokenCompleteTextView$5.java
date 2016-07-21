package com.tokenautocomplete;

import android.text.Editable;

public final class TokenCompleteTextView$5
  implements Runnable
{
  public TokenCompleteTextView$5(TokenCompleteTextView paramTokenCompleteTextView) {}
  
  public final void run()
  {
    int i = 0;
    Editable localEditable = this$0.getText();
    if (localEditable == null) {}
    for (;;)
    {
      return;
      TokenCompleteTextView.TokenImageSpan[] arrayOfTokenImageSpan = (TokenCompleteTextView.TokenImageSpan[])localEditable.getSpans(0, localEditable.length(), TokenCompleteTextView.TokenImageSpan.class);
      int j = arrayOfTokenImageSpan.length;
      while (i < j)
      {
        TokenCompleteTextView.TokenImageSpan localTokenImageSpan = arrayOfTokenImageSpan[i];
        TokenCompleteTextView.access$1100(this$0, localTokenImageSpan);
        TokenCompleteTextView.access$900(this$0).onSpanRemoved(localEditable, localTokenImageSpan, localEditable.getSpanStart(localTokenImageSpan), localEditable.getSpanEnd(localTokenImageSpan));
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.tokenautocomplete.TokenCompleteTextView.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */