package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public final class ChildHelper
{
  final Bucket mBucket;
  final Callback mCallback;
  final List<View> mHiddenViews;
  
  ChildHelper(Callback paramCallback)
  {
    mCallback = paramCallback;
    mBucket = new Bucket();
    mHiddenViews = new ArrayList();
  }
  
  private int getOffset(int paramInt)
  {
    if (paramInt < 0)
    {
      paramInt = -1;
      return paramInt;
    }
    int j = mCallback.getChildCount();
    int i = paramInt;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramInt - (i - mBucket.countOnesBefore(i));
      if (k == 0) {
        for (;;)
        {
          paramInt = i;
          if (!mBucket.get(i)) {
            break;
          }
          i += 1;
        }
      }
      i += k;
    }
    label72:
    return -1;
  }
  
  final void addView(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = mCallback.getChildCount();; paramInt = getOffset(paramInt))
    {
      mBucket.insert(paramInt, paramBoolean);
      if (paramBoolean) {
        hideViewInternal(paramView);
      }
      mCallback.addView(paramView, paramInt);
      return;
    }
  }
  
  final void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {}
    for (paramInt = mCallback.getChildCount();; paramInt = getOffset(paramInt))
    {
      mBucket.insert(paramInt, paramBoolean);
      if (paramBoolean) {
        hideViewInternal(paramView);
      }
      mCallback.attachViewToParent(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  final void detachViewFromParent(int paramInt)
  {
    paramInt = getOffset(paramInt);
    mBucket.remove(paramInt);
    mCallback.detachViewFromParent(paramInt);
  }
  
  public final View getChildAt(int paramInt)
  {
    paramInt = getOffset(paramInt);
    return mCallback.getChildAt(paramInt);
  }
  
  public final int getChildCount()
  {
    return mCallback.getChildCount() - mHiddenViews.size();
  }
  
  public final View getUnfilteredChildAt(int paramInt)
  {
    return mCallback.getChildAt(paramInt);
  }
  
  public final int getUnfilteredChildCount()
  {
    return mCallback.getChildCount();
  }
  
  final void hideViewInternal(View paramView)
  {
    mHiddenViews.add(paramView);
    mCallback.onEnteredHiddenState(paramView);
  }
  
  public final int indexOfChild(View paramView)
  {
    int i = mCallback.indexOfChild(paramView);
    if (i == -1) {}
    while (mBucket.get(i)) {
      return -1;
    }
    return i - mBucket.countOnesBefore(i);
  }
  
  final boolean isHidden(View paramView)
  {
    return mHiddenViews.contains(paramView);
  }
  
  public final void removeViewAt(int paramInt)
  {
    paramInt = getOffset(paramInt);
    View localView = mCallback.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    if (mBucket.remove(paramInt)) {
      unhideViewInternal(localView);
    }
    mCallback.removeViewAt(paramInt);
  }
  
  public final String toString()
  {
    return mBucket.toString() + ", hidden list:" + mHiddenViews.size();
  }
  
  final boolean unhideViewInternal(View paramView)
  {
    if (mHiddenViews.remove(paramView))
    {
      mCallback.onLeftHiddenState(paramView);
      return true;
    }
    return false;
  }
  
  static final class Bucket
  {
    long mData = 0L;
    Bucket next;
    
    private void ensureNext()
    {
      if (next == null) {
        next = new Bucket();
      }
    }
    
    final void clear(int paramInt)
    {
      Bucket localBucket = this;
      while (paramInt >= 64)
      {
        if (next == null) {
          return;
        }
        localBucket = next;
        paramInt -= 64;
      }
      mData &= (1L << paramInt ^ 0xFFFFFFFFFFFFFFFF);
    }
    
    final int countOnesBefore(int paramInt)
    {
      if (next == null)
      {
        if (paramInt >= 64) {
          return Long.bitCount(mData);
        }
        return Long.bitCount(mData & (1L << paramInt) - 1L);
      }
      if (paramInt < 64) {
        return Long.bitCount(mData & (1L << paramInt) - 1L);
      }
      return next.countOnesBefore(paramInt - 64) + Long.bitCount(mData);
    }
    
    final boolean get(int paramInt)
    {
      Bucket localBucket = this;
      while (paramInt >= 64)
      {
        localBucket.ensureNext();
        localBucket = next;
        paramInt -= 64;
      }
      return (mData & 1L << paramInt) != 0L;
    }
    
    final void insert(int paramInt, boolean paramBoolean)
    {
      boolean bool = paramBoolean;
      Bucket localBucket = this;
      while (paramInt >= 64)
      {
        localBucket.ensureNext();
        localBucket = next;
        paramInt -= 64;
      }
      if ((mData & 0x8000000000000000) != 0L)
      {
        paramBoolean = true;
        label47:
        long l = (1L << paramInt) - 1L;
        mData = (mData & l | (mData & (0xFFFFFFFFFFFFFFFF ^ l)) << 1);
        if (!bool) {
          break label128;
        }
        localBucket.set(paramInt);
      }
      for (;;)
      {
        if ((!paramBoolean) && (next == null)) {
          return;
        }
        localBucket.ensureNext();
        localBucket = next;
        paramInt = 0;
        bool = paramBoolean;
        break;
        paramBoolean = false;
        break label47;
        label128:
        localBucket.clear(paramInt);
      }
    }
    
    final boolean remove(int paramInt)
    {
      Bucket localBucket = this;
      while (paramInt >= 64)
      {
        localBucket.ensureNext();
        localBucket = next;
        paramInt -= 64;
      }
      long l = 1L << paramInt;
      if ((mData & l) != 0L) {}
      for (boolean bool = true;; bool = false)
      {
        mData &= (0xFFFFFFFFFFFFFFFF ^ l);
        l -= 1L;
        mData = (mData & l | Long.rotateRight(mData & (0xFFFFFFFFFFFFFFFF ^ l), 1));
        if (next != null)
        {
          if (next.get(0)) {
            localBucket.set(63);
          }
          next.remove(0);
        }
        return bool;
      }
    }
    
    final void set(int paramInt)
    {
      Bucket localBucket = this;
      while (paramInt >= 64)
      {
        localBucket.ensureNext();
        localBucket = next;
        paramInt -= 64;
      }
      mData |= 1L << paramInt;
    }
    
    public final String toString()
    {
      if (next == null) {
        return Long.toBinaryString(mData);
      }
      return next.toString() + "xx" + Long.toBinaryString(mData);
    }
  }
  
  static abstract interface Callback
  {
    public abstract void addView(View paramView, int paramInt);
    
    public abstract void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams);
    
    public abstract void detachViewFromParent(int paramInt);
    
    public abstract View getChildAt(int paramInt);
    
    public abstract int getChildCount();
    
    public abstract RecyclerView.ViewHolder getChildViewHolder(View paramView);
    
    public abstract int indexOfChild(View paramView);
    
    public abstract void onEnteredHiddenState(View paramView);
    
    public abstract void onLeftHiddenState(View paramView);
    
    public abstract void removeAllViews();
    
    public abstract void removeViewAt(int paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ChildHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */