package com.linkedin.android.growth.abi;

import android.os.AsyncTask;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.AsyncTaskCallback;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact;
import java.util.List;

public final class AbiContactsReadTask
  extends AsyncTask<Void, Void, List<RawContact>>
{
  private AbiContactsReader abiContactsReader;
  AsyncTaskCallback<List<RawContact>> asyncTaskCallback;
  
  public AbiContactsReadTask(AbiContactsReader paramAbiContactsReader)
  {
    abiContactsReader = paramAbiContactsReader;
  }
  
  private List<RawContact> doInBackground$68cf9880()
  {
    try
    {
      List localList = abiContactsReader.readContactsIncrementally();
      return localList;
    }
    catch (SecurityException localSecurityException)
    {
      CrashReporter.reportNonFatal(new Throwable("SecurityException when reading contacts in background for abi", localSecurityException));
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiContactsReadTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */