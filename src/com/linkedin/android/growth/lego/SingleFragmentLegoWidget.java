package com.linkedin.android.growth.lego;

import android.os.Bundle;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;

public abstract class SingleFragmentLegoWidget
  extends LegoWidget
{
  public final String getCurrentActiveFragmentTag()
  {
    return "landing";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    fragmentComponent.inject(this);
    super.onCreate(paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.SingleFragmentLegoWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */