package com.linkedin.android.growth.login.prereg;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.app.ViewPagerFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.MediaCenter;

public abstract class PreRegBaseFragment<VH extends BaseViewHolder, VM extends PreRegBaseFragmentViewModel<VH>>
  extends ViewPagerFragment
{
  private Handler handler = new Handler(Looper.getMainLooper());
  protected MediaCenter mediaCenter;
  private Runnable performAnimationRunnable = new Runnable()
  {
    public final void run()
    {
      viewModel.performAnimations();
    }
  };
  public VM viewModel;
  
  public final void cancelAnimationsAndResetViews()
  {
    viewModel.cancelAnimations();
    viewModel.resetViews();
  }
  
  public abstract ViewHolderCreator<VH> getViewHolderCreator();
  
  public abstract VM getViewModel();
  
  public void onDestroyView()
  {
    super.onDestroyView();
    cancelAnimationsAndResetViews();
    viewModel.removeAllListeners();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    mediaCenter = fragmentComponent.mediaCenter();
    paramView = getViewHolderCreator().createViewHolder(paramView);
    viewModel = getViewModel();
    viewModel.onBindViewHolder(getLayoutInflater(null), mediaCenter, paramView);
  }
  
  public final void performAnimations()
  {
    handler.removeCallbacks(performAnimationRunnable);
    handler.post(performAnimationRunnable);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegBaseFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */