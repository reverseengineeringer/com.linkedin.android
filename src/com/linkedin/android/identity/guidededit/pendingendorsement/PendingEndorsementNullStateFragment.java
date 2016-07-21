package com.linkedin.android.identity.guidededit.pendingendorsement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public final class PendingEndorsementNullStateFragment
  extends PageFragment
{
  public static PendingEndorsementNullStateFragment newInstance(PendingEndorsementBundleBuilder paramPendingEndorsementBundleBuilder)
  {
    PendingEndorsementNullStateFragment localPendingEndorsementNullStateFragment = new PendingEndorsementNullStateFragment();
    localPendingEndorsementNullStateFragment.setArguments(paramPendingEndorsementBundleBuilder.build());
    return localPendingEndorsementNullStateFragment;
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969128, paramViewGroup, false);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = new PendingEndorsementNullStateViewModel();
    onClickListener = new PendingEndorsementNullStateTransformer.1(tracker, "pending_endorsements:see_all_skills", new TrackingEventBuilder[0], this);
    paramView = (PendingEndorsementNullStateViewHolder)PendingEndorsementNullStateViewHolder.CREATOR.createViewHolder(paramView);
    LayoutInflater.from(getActivity());
    fragmentComponent.mediaCenter();
    paramBundle.onBindViewHolder$3164b360(paramView);
  }
  
  public final String pageKey()
  {
    return "pending_endorsements_null_state";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementNullStateFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */