package com.linkedin.android.growth.onboarding;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.voyager.common.Industry;

public final class OnboardingTransformer$1
  implements View.OnClickListener
{
  public OnboardingTransformer$1(FragmentComponent paramFragmentComponent, Industry paramIndustry, LegoWidget paramLegoWidget) {}
  
  public final void onClick(View paramView)
  {
    val$fragmentComponent.eventBus();
    Bus.publish(val$industry);
    val$legoWidget.finishCurrentFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */