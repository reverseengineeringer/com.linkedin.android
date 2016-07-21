package com.linkedin.android.identity.guidededit.infra;

import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdate;

public abstract interface GuidedEditFlowRootFragment$GuidedEditListener
{
  public abstract void onCancelAndExitGuidedEdit$b0b86fb();
  
  public abstract void onFinishGuidedEdit(GuidedEditCategory paramGuidedEditCategory, GuidedEditProfileUpdate paramGuidedEditProfileUpdate);
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.infra.GuidedEditFlowRootFragment.GuidedEditListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */