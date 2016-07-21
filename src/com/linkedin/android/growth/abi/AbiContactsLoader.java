package com.linkedin.android.growth.abi;

import android.content.Context;
import com.linkedin.android.infra.AsyncTaskLoaderBase;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact;
import java.util.List;

public final class AbiContactsLoader
  extends AsyncTaskLoaderBase<List<RawContact>>
{
  private final AbiContactsReader abiContactsReader;
  
  public AbiContactsLoader(Context paramContext, AbiContactsReader paramAbiContactsReader)
  {
    super(paramContext);
    abiContactsReader = paramAbiContactsReader;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiContactsLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */