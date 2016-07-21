package android.support.v7.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class ViewPropertyAnimatorCompatSet
{
  public final ArrayList<ViewPropertyAnimatorCompat> mAnimators = new ArrayList();
  private long mDuration = -1L;
  private Interpolator mInterpolator;
  boolean mIsStarted;
  ViewPropertyAnimatorListener mListener;
  private final ViewPropertyAnimatorListenerAdapter mProxyListener = new ViewPropertyAnimatorListenerAdapter()
  {
    private int mProxyEndCount = 0;
    private boolean mProxyStarted = false;
    
    public final void onAnimationEnd(View paramAnonymousView)
    {
      int i = mProxyEndCount + 1;
      mProxyEndCount = i;
      if (i == mAnimators.size())
      {
        if (mListener != null) {
          mListener.onAnimationEnd(null);
        }
        mProxyEndCount = 0;
        mProxyStarted = false;
        mIsStarted = false;
      }
    }
    
    public final void onAnimationStart(View paramAnonymousView)
    {
      if (mProxyStarted) {}
      do
      {
        return;
        mProxyStarted = true;
      } while (mListener == null);
      mListener.onAnimationStart(null);
    }
  };
  
  public final void cancel()
  {
    if (!mIsStarted) {
      return;
    }
    Iterator localIterator = mAnimators.iterator();
    while (localIterator.hasNext()) {
      ((ViewPropertyAnimatorCompat)localIterator.next()).cancel();
    }
    mIsStarted = false;
  }
  
  public final ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    if (!mIsStarted) {
      mAnimators.add(paramViewPropertyAnimatorCompat);
    }
    return this;
  }
  
  public final ViewPropertyAnimatorCompatSet setDuration$20eda383()
  {
    if (!mIsStarted) {
      mDuration = 250L;
    }
    return this;
  }
  
  public final ViewPropertyAnimatorCompatSet setInterpolator(Interpolator paramInterpolator)
  {
    if (!mIsStarted) {
      mInterpolator = paramInterpolator;
    }
    return this;
  }
  
  public final ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    if (!mIsStarted) {
      mListener = paramViewPropertyAnimatorListener;
    }
    return this;
  }
  
  public final void start()
  {
    if (mIsStarted) {
      return;
    }
    Iterator localIterator = mAnimators.iterator();
    while (localIterator.hasNext())
    {
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat)localIterator.next();
      if (mDuration >= 0L) {
        localViewPropertyAnimatorCompat.setDuration(mDuration);
      }
      if (mInterpolator != null) {
        localViewPropertyAnimatorCompat.setInterpolator(mInterpolator);
      }
      if (mListener != null) {
        localViewPropertyAnimatorCompat.setListener(mProxyListener);
      }
      localViewPropertyAnimatorCompat.start();
    }
    mIsStarted = true;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.ViewPropertyAnimatorCompatSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */