package com.linkedin.android.growth.abi;

import com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact;
import java.util.List;

public abstract interface AbiContactsReader
{
  public abstract List<RawContact> readContactsFull();
  
  public abstract List<RawContact> readContactsIncrementally();
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiContactsReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */