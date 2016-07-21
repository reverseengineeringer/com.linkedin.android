package com.linkedin.android.growth.abi;

import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact;
import java.util.List;

final class AbiLoadContactsFragment$2
  implements LoaderManager.LoaderCallbacks<List<RawContact>>
{
  AbiLoadContactsFragment$2(AbiLoadContactsFragment paramAbiLoadContactsFragment) {}
  
  public final Loader<List<RawContact>> onCreateLoader$e57f803(int paramInt)
  {
    return new AbiContactsLoader(this$0.fragmentComponent.activity(), this$0.fragmentComponent.abiContactsReader());
  }
  
  public final void onLoaderReset$5dda1f52() {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiLoadContactsFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */