package com.linkedin.android.feed.utils.animations;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.linkedin.android.feed.page.feed.FeedFragment;
import com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateBundle;
import com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateFragment;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.DelayedExecution;
import java.lang.ref.WeakReference;

public final class UnfollowEducateAnimationHelper
{
  WeakReference<FeedFragment> feedUpdatesFragmentWeakReference;
  public FragmentComponent fragmentComponent;
  public ShowUnfollowRunnable showUnfollowRunnable;
  
  public UnfollowEducateAnimationHelper(FeedFragment paramFeedFragment, RecyclerView paramRecyclerView, int paramInt, View paramView)
  {
    feedUpdatesFragmentWeakReference = new WeakReference(paramFeedFragment);
    showUnfollowRunnable = new ShowUnfollowRunnable(paramRecyclerView, paramInt, paramView);
    fragmentComponent = fragmentComponent;
  }
  
  private final class ShowUnfollowRunnable
    implements Runnable
  {
    final RecyclerView recyclerView;
    final int screenHeight;
    final View view;
    
    ShowUnfollowRunnable(RecyclerView paramRecyclerView, int paramInt, View paramView)
    {
      view = paramView;
      recyclerView = paramRecyclerView;
      screenHeight = paramInt;
    }
    
    public final void run()
    {
      Object localObject = fragmentComponent.activity().getResources();
      int i = screenHeight / 2 - ((Resources)localObject).getDimensionPixelSize(2131493151) / 2;
      int j = screenHeight / 2;
      int k = ((Resources)localObject).getDimensionPixelSize(2131493151);
      int m = i / 5;
      localObject = new int[2];
      view.getLocationInWindow((int[])localObject);
      int n = localObject[1];
      localObject = (FeedFragment)feedUpdatesFragmentWeakReference.get();
      if (n > i) {
        if (n - i > m)
        {
          recyclerView.smoothScrollBy(0, m);
          fragmentComponent.delayedExecution().postDelayedExecution(this, 100L);
          if ((localObject != null) && (n < j + k) && (fragmentComponent.activity().applicationComponent.flagshipSharedPreferences().getInsertUnfollowEducateCard()) && (((FeedFragment)localObject).getActivity() != null) && (applicationComponent.flagshipSharedPreferences().getInsertUnfollowEducateCard())) {
            break label237;
          }
        }
      }
      label237:
      UnfollowEducateFragment localUnfollowEducateFragment;
      BaseActivity localBaseActivity;
      do
      {
        return;
        recyclerView.smoothScrollBy(0, n - i);
        if (localObject == null) {
          break;
        }
        isAnimatingScrolling = false;
        break;
        if (localObject == null) {
          break;
        }
        isAnimatingScrolling = false;
        break;
        applicationComponent.flagshipSharedPreferences().setInsertUnfollowEducateCard(false);
        localUnfollowEducateFragment = UnfollowEducateFragment.newInstance(new UnfollowEducateBundle(new Bundle()));
        localBaseActivity = (BaseActivity)((BaseFragment)localObject).getActivity();
      } while ((localBaseActivity == null) || (!localBaseActivity.isSafeToExecuteTransaction()));
      ((FeedFragment)localObject).getActivity().getSupportFragmentManager().beginTransaction().add(16908290, localUnfollowEducateFragment, localUnfollowEducateFragment.pageKey()).commit();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.animations.UnfollowEducateAnimationHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */