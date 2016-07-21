package com.linkedin.android.growth.newtovoyager.transactional;

import android.os.Bundle;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;

final class NewToVoyagerIntroDialogFragment$1
  implements NewToVoyagerIntroViewTransformer.NewToVoyagerIntroListener
{
  NewToVoyagerIntroDialogFragment$1(NewToVoyagerIntroDialogFragment paramNewToVoyagerIntroDialogFragment) {}
  
  public final void dismiss()
  {
    String str = this$0.getArguments().getString("legoTrackingTokenKey");
    if (NewToVoyagerIntroDialogFragment.access$000(this$0) != null) {
      NewToVoyagerIntroDialogFragment.access$000(this$0).sendActionEvent$67c7f505(str, ActionCategory.DISMISS);
    }
    this$0.dismiss();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroDialogFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */