package com.linkedin.android.pegasus.gen.realtimefrontend;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class HeartbeatBuilder
  implements FissileDataModelBuilder<Heartbeat>, DataTemplateBuilder<Heartbeat>
{
  public static final HeartbeatBuilder INSTANCE = new HeartbeatBuilder();
  private static final JsonKeyStore JSON_KEY_STORE = new HashStringKeyStore();
  
  public static Heartbeat build(DataReader paramDataReader)
    throws DataReaderException
  {
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {}
    return new Heartbeat();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.realtimefrontend.HeartbeatBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */