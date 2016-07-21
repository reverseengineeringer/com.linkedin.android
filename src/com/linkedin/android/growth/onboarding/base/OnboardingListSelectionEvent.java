package com.linkedin.android.growth.onboarding.base;

import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.data.lite.RecordTemplate;

public final class OnboardingListSelectionEvent<M extends RecordTemplate, N extends ViewModel>
{
  public final boolean isSelection;
  public final M model;
  public final N viewModel;
  
  public OnboardingListSelectionEvent(boolean paramBoolean, M paramM, N paramN)
  {
    isSelection = paramBoolean;
    model = paramM;
    viewModel = paramN;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.base.OnboardingListSelectionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */