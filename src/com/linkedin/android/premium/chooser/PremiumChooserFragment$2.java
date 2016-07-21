package com.linkedin.android.premium.chooser;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;

final class PremiumChooserFragment$2
  implements View.OnClickListener
{
  PremiumChooserFragment$2(PremiumChooserFragment paramPremiumChooserFragment) {}
  
  public final void onClick(View paramView)
  {
    PremiumChooserFragment.access$000(this$0, false);
    PremiumChooserFragment.access$200(this$0, "close", ControlType.BUTTON, InteractionType.SHORT_PRESS);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.chooser.PremiumChooserFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */