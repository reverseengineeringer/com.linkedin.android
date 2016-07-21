package com.linkedin.android.identity.guidededit.pendingendorsement;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public class PendingEndorsementFragment
  extends PageFragment
  implements OnBackPressedListener
{
  public static final String TAG = PendingEndorsementFragment.class.getSimpleName();
  @InjectView(2131755468)
  Toolbar toolbar;
  
  public static PendingEndorsementFragment newInstance(PendingEndorsementBundleBuilder paramPendingEndorsementBundleBuilder)
  {
    PendingEndorsementFragment localPendingEndorsementFragment = new PendingEndorsementFragment();
    localPendingEndorsementFragment.setArguments(paramPendingEndorsementBundleBuilder.build());
    return localPendingEndorsementFragment;
  }
  
  public final String getTitle()
  {
    return getLocalizedString(2131233036);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean onBackPressed()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969125, paramViewGroup, false);
  }
  
  public void onStart()
  {
    super.onStart();
    toolbar.setNavigationOnClickListener(new PendingEndorsementFragment.1(this, getActivityactivityComponent.tracker(), "pending_endorsements:back", new TrackingEventBuilder[0]));
    toolbar.setTitle(getLocalizedString(2131233036));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public final String pageKey()
  {
    return "pending_endorsements";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */