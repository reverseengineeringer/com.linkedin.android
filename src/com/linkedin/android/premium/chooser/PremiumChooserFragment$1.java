package com.linkedin.android.premium.chooser;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;

final class PremiumChooserFragment$1
  implements View.OnClickListener
{
  PremiumChooserFragment$1(PremiumChooserFragment paramPremiumChooserFragment) {}
  
  public final void onClick(View paramView)
  {
    PremiumChooserFragment.access$000(this$0, true);
    PremiumChooserFragment.access$100(this$0, "tell_me_more_link", ControlType.BUTTON, InteractionType.SHORT_PRESS);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.chooser.PremiumChooserFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */