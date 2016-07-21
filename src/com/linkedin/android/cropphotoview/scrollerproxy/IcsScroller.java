package com.linkedin.android.cropphotoview.scrollerproxy;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

@TargetApi(15)
public final class IcsScroller
  extends ScrollerProxy
{
  protected final OverScroller mScroller;
  
  public IcsScroller(Context paramContext)
  {
    mScroller = new OverScroller(paramContext);
  }
  
  public final boolean computeScrollOffset()
  {
    return mScroller.computeScrollOffset();
  }
  
  public final void forceFinished$1385ff()
  {
    mScroller.forceFinished(true);
  }
  
  public final int getCurrX()
  {
    return mScroller.getCurrX();
  }
  
  public final int getCurrY()
  {
    return mScroller.getCurrY();
  }
  
  public final boolean isFinished()
  {
    return mScroller.isFinished();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.cropphotoview.scrollerproxy.IcsScroller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */