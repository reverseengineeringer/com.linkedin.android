package android.support.v7.widget;

final class RecyclerView$2
  implements Runnable
{
  RecyclerView$2(RecyclerView paramRecyclerView) {}
  
  public final void run()
  {
    if (this$0.mItemAnimator != null) {
      this$0.mItemAnimator.runPendingAnimations();
    }
    RecyclerView.access$602$767d6395(this$0);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */