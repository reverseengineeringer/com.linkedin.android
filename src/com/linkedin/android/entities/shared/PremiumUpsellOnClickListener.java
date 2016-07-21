package com.linkedin.android.entities.shared;

import android.view.View;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel;
import com.linkedin.android.premium.PremiumActivityBundleBuilder;
import com.linkedin.android.premium.PremiumActivityIntent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class PremiumUpsellOnClickListener
  extends TrackingOnClickListener
{
  private final String controlName;
  private final FragmentComponent fragmentComponent;
  private final PremiumUpsellChannel upsellChannel;
  
  public PremiumUpsellOnClickListener(FragmentComponent paramFragmentComponent, PremiumUpsellChannel paramPremiumUpsellChannel, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    fragmentComponent = paramFragmentComponent;
    upsellChannel = paramPremiumUpsellChannel;
    controlName = paramString;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = new PremiumActivityBundleBuilder().setFromChannel(upsellChannel).setUpsellTrackingCode(Urn.createFromTuple("control", new Object[] { controlName })).setNextActivity(null);
    paramView = fragmentComponent.intentRegistry().chooser.newIntent(fragmentComponent.activity(), paramView);
    fragmentComponent.activity().startActivity(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.PremiumUpsellOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */