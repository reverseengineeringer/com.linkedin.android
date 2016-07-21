package com.linkedin.android.growth.abi;

import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.linkedin.android.infra.ui.TintableButton;

final class MainAbiResultFragment$5
  implements MenuItemCompat.OnActionExpandListener
{
  MainAbiResultFragment$5(MainAbiResultFragment paramMainAbiResultFragment) {}
  
  public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    this$0.searchOverlay.setVisibility(4);
    this$0.titleNumberOfContacts.setVisibility(0);
    if (this$0.shouldShowInviteAllButton()) {
      this$0.connectAllButton.setVisibility(0);
    }
    return true;
  }
  
  public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    this$0.searchOverlay.setVisibility(0);
    if (this$0.connectAllButton != null) {
      this$0.connectAllButton.setVisibility(8);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.MainAbiResultFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */