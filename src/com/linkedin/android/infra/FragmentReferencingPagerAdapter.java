package com.linkedin.android.infra;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.SparseArrayCompat;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.Set;

public abstract class FragmentReferencingPagerAdapter
  extends FragmentPagerAdapter
  implements ItemReferencingAdapter
{
  private final FragmentManager fragmentManager;
  private final SparseArrayCompat<Fragment> fragmentTags;
  
  public FragmentReferencingPagerAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    fragmentManager = paramFragmentManager;
    fragmentTags = new SparseArrayCompat();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    fragmentTags.remove(paramInt);
    super.destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  public final Object getItemAtPosition(int paramInt)
  {
    return fragmentTags.get(paramInt);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (Fragment)super.instantiateItem(paramViewGroup, paramInt);
    fragmentTags.put(paramInt, paramViewGroup);
    return paramViewGroup;
  }
  
  public final void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    paramParcelable = (Bundle)paramParcelable;
    if (paramParcelable != null)
    {
      super.restoreState(paramParcelable.getParcelable("STATE_SUPERCLASS"), paramClassLoader);
      paramClassLoader = paramParcelable.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        Object localObject = (String)paramClassLoader.next();
        try
        {
          int i = Integer.parseInt((String)localObject);
          localObject = paramParcelable.getString((String)localObject);
          localObject = fragmentManager.findFragmentByTag((String)localObject);
          if (localObject != null) {
            fragmentTags.put(i, localObject);
          }
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
  }
  
  public final Parcelable saveState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("STATE_SUPERCLASS", super.saveState());
    int i = 0;
    while (i < fragmentTags.size())
    {
      localBundle.putString(Integer.toString(fragmentTags.keyAt(i)), ((Fragment)fragmentTags.valueAt(i)).getTag());
      i += 1;
    }
    return localBundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.FragmentReferencingPagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */