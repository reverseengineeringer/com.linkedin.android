package android.support.design.widget;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import java.lang.ref.WeakReference;

public class TabLayout$TabLayoutOnPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private int mPreviousScrollState;
  private int mScrollState;
  private final WeakReference<TabLayout> mTabLayoutRef;
  
  public TabLayout$TabLayoutOnPageChangeListener(TabLayout paramTabLayout)
  {
    mTabLayoutRef = new WeakReference(paramTabLayout);
  }
  
  private void reset()
  {
    mScrollState = 0;
    mPreviousScrollState = 0;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    mPreviousScrollState = mScrollState;
    mScrollState = paramInt;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    TabLayout localTabLayout = (TabLayout)mTabLayoutRef.get();
    boolean bool1;
    if (localTabLayout != null)
    {
      if ((mScrollState == 2) && (mPreviousScrollState != 1)) {
        break label66;
      }
      bool1 = true;
      if ((mScrollState == 2) && (mPreviousScrollState == 0)) {
        break label72;
      }
    }
    label66:
    label72:
    for (boolean bool2 = true;; bool2 = false)
    {
      TabLayout.access$2700(localTabLayout, paramInt1, paramFloat, bool1, bool2);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    TabLayout localTabLayout = (TabLayout)mTabLayoutRef.get();
    if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt)) {
      if ((mScrollState != 0) && ((mScrollState != 2) || (mPreviousScrollState != 0))) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      localTabLayout.selectTab(localTabLayout.getTabAt(paramInt), bool);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */