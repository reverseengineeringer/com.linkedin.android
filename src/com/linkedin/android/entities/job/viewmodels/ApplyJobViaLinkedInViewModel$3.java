package com.linkedin.android.entities.job.viewmodels;

import android.support.v4.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.linkedin.android.entities.viewholders.ApplyJobViaLinkedInViewHolder;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class ApplyJobViaLinkedInViewModel$3
  extends TrackingOnClickListener
{
  ApplyJobViaLinkedInViewModel$3(ApplyJobViaLinkedInViewModel paramApplyJobViaLinkedInViewModel, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, ApplyJobViaLinkedInViewHolder paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = val$holder;
    submitApplicationButton.setEnabled(false);
    editProfileButton.setEnabled(false);
    emailInput.setEnabled(false);
    phoneInput.setEnabled(false);
    loadingOverlay.setVisibility(0);
    loadingSpinner.setVisibility(0);
    this$0.onSubmitApplicationClick.apply(new Pair(this$0.email, this$0.phone));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.viewmodels.ApplyJobViaLinkedInViewModel.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */