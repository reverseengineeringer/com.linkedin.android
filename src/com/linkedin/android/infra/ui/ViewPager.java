package com.linkedin.android.infra.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import com.linkedin.android.infra.ItemReferencingAdapter;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.FeatureLog;
import java.util.ArrayList;
import java.util.List;

public class ViewPager
  extends android.support.v4.view.ViewPager
  implements ScreenElement
{
  private static final String TAG = ViewPager.class.getSimpleName();
  public boolean backSelected;
  private String controlId;
  public List<String> controlIdList = new ArrayList();
  private boolean didEnter;
  private boolean firstLayout = true;
  private final Handler handler = new Handler(Looper.getMainLooper());
  private ViewPager.InteractionOnPageChangeListener interactionOnPageChangeListener;
  private List<ViewPager.OnPageChangeListener> onPageChangeListeners = new ArrayList();
  private ViewPager.PageViewOnPageChangeListener pageViewOnPageChangeListener;
  private int selectedIndex;
  private boolean suppressPageViewOnInit;
  public boolean tapSelected;
  private Tracker tracker;
  
  public ViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.addOnPageChangeListener(new ViewPager.InternalOnPageChangeListener(this));
    interactionOnPageChangeListener = new ViewPager.InteractionOnPageChangeListener(this);
    pageViewOnPageChangeListener = new ViewPager.PageViewOnPageChangeListener(this);
    addOnPageChangeListener(interactionOnPageChangeListener);
    addOnPageChangeListener(pageViewOnPageChangeListener);
    paramContext = paramContext.getApplicationContext();
    if ((paramContext instanceof FlagshipApplication)) {
      ((FlagshipApplication)paramContext).getAppComponent().viewPagerObserver().dispatchCreated(this);
    }
  }
  
  private void onEnterLeave(boolean paramBoolean)
  {
    FeatureLog.d(TAG, "onEnterLeaveRunnable posting", "View Pager");
    handler.post(new ViewPager.1(this, paramBoolean));
  }
  
  public final void addOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    onPageChangeListeners.add(paramOnPageChangeListener);
  }
  
  public final boolean didEnter()
  {
    return didEnter;
  }
  
  public final void enableInteractionTracking(Tracker paramTracker, String paramString)
  {
    FeatureLog.d(TAG, "interaction tracking enabled", "View Pager");
    tracker = paramTracker;
    controlId = paramString;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    firstLayout = true;
  }
  
  public final void onEnter()
  {
    FeatureLog.d(TAG, "onEnter", "View Pager");
    didEnter = true;
    onEnterLeave(true);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((firstLayout) && (!suppressPageViewOnInit))
    {
      firstLayout = false;
      FeatureLog.d(TAG, "first layout, triggering page selected manually!", "View Pager");
      paramInt1 = getCurrentItem();
      pageViewOnPageChangeListener.onPageSelected(paramInt1);
    }
  }
  
  public final void onLeave()
  {
    FeatureLog.d(TAG, "onLeave", "View Pager");
    didEnter = false;
    onEnterLeave(false);
  }
  
  public final void removeOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    onPageChangeListeners.remove(paramOnPageChangeListener);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (!(paramPagerAdapter instanceof ItemReferencingAdapter))
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("LinkedIn ViewPager can only be used with a FragmentReferencingAdapter"));
    }
    super.setAdapter(paramPagerAdapter);
    if (getAdapter() != null) {
      firstLayout = true;
    }
  }
  
  @Deprecated
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    addOnPageChangeListener(paramOnPageChangeListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.ui.ViewPager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */