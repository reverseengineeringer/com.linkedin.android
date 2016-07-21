package com.linkedin.android.growth.onboarding.abi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.Optional;
import com.linkedin.android.growth.abi.AbiResultFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.ui.TintableButton;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public abstract class OnboardingAbiResultFragment
  extends AbiResultFragment
{
  @InjectView(2131756106)
  @Optional
  public TintableButton inviteAllButton;
  @InjectView(2131756107)
  public Button nextButton;
  @InjectView(2131756076)
  @Optional
  protected TextView subtitle;
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    setupNextButton(nextButton);
  }
  
  public final void setupNextButton(Button paramButton)
  {
    if (hasAnyContactBeenInvited) {
      paramButton.setText(2131231366);
    }
    for (;;)
    {
      paramButton.setOnClickListener(new TrackingOnClickListener(tracker, "next", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          goNext();
        }
      });
      return;
      paramButton.setText(2131231369);
    }
  }
  
  public final void setupSubtitle(int paramInt1, int paramInt2)
  {
    if (subtitle != null) {
      subtitle.setText(getLocalizedString(paramInt1, new Object[] { Integer.valueOf(paramInt2) }));
    }
  }
  
  public final void setupTitle(int paramInt)
  {
    if (title != null) {
      title.setText(getLocalizedString(paramInt));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.OnboardingAbiResultFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */