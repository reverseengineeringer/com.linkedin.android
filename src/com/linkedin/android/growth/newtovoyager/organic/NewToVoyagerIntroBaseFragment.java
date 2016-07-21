package com.linkedin.android.growth.newtovoyager.organic;

import android.os.Bundle;
import android.view.View;
import com.linkedin.android.growth.login.prereg.PreRegBaseFragment;
import com.linkedin.android.infra.app.BaseViewHolder;

public abstract class NewToVoyagerIntroBaseFragment<VH extends BaseViewHolder, VM extends NewToVoyagerIntroBaseFragmentViewModel<VH>>
  extends PreRegBaseFragment<VH, VM>
{
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((NewToVoyagerIntroBaseFragmentViewModel)viewModel).resetViews();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroBaseFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */