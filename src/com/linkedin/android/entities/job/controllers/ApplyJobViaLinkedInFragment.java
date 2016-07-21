package com.linkedin.android.entities.job.controllers;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.entities.job.JobDataProvider.JobState;
import com.linkedin.android.entities.job.transformers.JobTransformer;
import com.linkedin.android.entities.job.viewmodels.ApplyJobViaLinkedInViewModel;
import com.linkedin.android.entities.viewholders.ApplyJobViaLinkedInViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Job;
import java.util.Set;

public final class ApplyJobViaLinkedInFragment
  extends PageFragment
{
  private JobDataProvider dataProvider;
  private ApplyJobViaLinkedInViewHolder viewHolder;
  private ApplyJobViaLinkedInViewModel viewModel;
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    dataProvider = getActivityactivityComponent.jobDataProvider();
    if ((dataProvider.isDataAvailable()) && (dataProvider.state).job().hasApplicant))
    {
      paramBundle = dataProvider.state).job().applicant;
      viewModel = JobTransformer.toLinkedInApplyScreen(fragmentComponent, busSubscriberId, dataProvider, paramBundle);
      paramBundle = viewModel;
      getActivity().getLayoutInflater();
      paramBundle.onBindViewHolder$646df37b(applicationComponent.mediaCenter(), viewHolder);
      return;
    }
    Util.safeThrow(new RuntimeException("ApplyJobViaLinkedInFragment - Job data provider does not have Job Applicant data!!"));
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    fragmentComponent.inject(this);
    paramLayoutInflater = paramLayoutInflater.inflate(ApplyJobViaLinkedInViewHolder.CREATOR.getLayoutId(), paramViewGroup, false);
    viewHolder = ((ApplyJobViaLinkedInViewHolder)ApplyJobViaLinkedInViewHolder.CREATOR.createViewHolder(paramLayoutInflater));
    return paramLayoutInflater;
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    paramType = dataProvider.state).applyJobRoute;
    if ((paramSet != null) && (paramType != null) && (paramSet.contains(paramType)))
    {
      paramType = viewModel;
      paramSet = viewHolder;
      paramType.enableSubmitButton(submitApplicationButton);
      editProfileButton.setEnabled(true);
      emailInput.setEnabled(true);
      phoneInput.setEnabled(true);
      loadingOverlay.setVisibility(8);
      loadingSpinner.setVisibility(8);
    }
  }
  
  public final String pageKey()
  {
    return "job_apply_profile";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.controllers.ApplyJobViaLinkedInFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */