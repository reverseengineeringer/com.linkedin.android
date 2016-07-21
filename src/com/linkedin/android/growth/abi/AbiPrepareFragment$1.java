package com.linkedin.android.growth.abi;

import android.widget.TextView;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;

final class AbiPrepareFragment$1
  implements Runnable
{
  AbiPrepareFragment$1(AbiPrepareFragment paramAbiPrepareFragment) {}
  
  public final void run()
  {
    if ((this$0.abiResultsLoadingToolbarText != null) && (this$0.isAdded())) {
      this$0.abiResultsLoadingToolbarText.setText(this$0.fragmentComponent.i18NManager().getString(2131231345));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiPrepareFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */