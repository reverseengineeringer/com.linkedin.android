package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class PagerAdapter
{
  private final DataSetObservable mObservable = new DataSetObservable();
  private DataSetObserver mViewPagerObserver;
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException("Required method destroyItem was not overridden");
  }
  
  public void finishUpdate(ViewGroup paramViewGroup) {}
  
  public abstract int getCount();
  
  public int getItemPosition(Object paramObject)
  {
    return -1;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return null;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
  }
  
  public abstract boolean isViewFromObject(View paramView, Object paramObject);
  
  public final void notifyDataSetChanged()
  {
    try
    {
      if (mViewPagerObserver != null) {
        mViewPagerObserver.onChanged();
      }
      mObservable.notifyChanged();
      return;
    }
    finally {}
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    mObservable.registerObserver(paramDataSetObserver);
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {}
  
  final void setViewPagerObserver(DataSetObserver paramDataSetObserver)
  {
    try
    {
      mViewPagerObserver = paramDataSetObserver;
      return;
    }
    finally {}
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    mObservable.unregisterObserver(paramDataSetObserver);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.PagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */