package com.linkedin.android.feed.shared.autoresize;

final class AutoResizeTextView$1
  implements Runnable
{
  AutoResizeTextView$1(AutoResizeTextView paramAutoResizeTextView) {}
  
  public final void run()
  {
    if (AutoResizeTextView.access$000(this$0) != null) {
      AutoResizeTextView.access$000(this$0).sizeToFit();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.autoresize.AutoResizeTextView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */