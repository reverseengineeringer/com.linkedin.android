package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfileViewsTimeIntervalDataPointBuilder
  implements FissileDataModelBuilder<ProfileViewsTimeIntervalDataPoint>, DataTemplateBuilder<ProfileViewsTimeIntervalDataPoint>
{
  public static final ProfileViewsTimeIntervalDataPointBuilder INSTANCE = new ProfileViewsTimeIntervalDataPointBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("endTimestamp");
    JSON_KEY_STORE.put("numViews");
  }
  
  public static ProfileViewsTimeIntervalDataPoint build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l2 = 0L;
    long l1 = 0L;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("endTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numViews", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: endTimestamp when building com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewsTimeIntervalDataPoint");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: numViews when building com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewsTimeIntervalDataPoint");
    }
    return new ProfileViewsTimeIntervalDataPoint(l2, l1, bool2, bool1);
  }
  
  public static ProfileViewsTimeIntervalDataPoint readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ProfileViewsTimeIntervalDataPoint");
    }
    Object localObject1 = paramByteBuffer;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      int i = paramString.get();
      int j;
      do
      {
        do
        {
          localObject2 = paramString;
          if (i != 0) {
            break label170;
          }
          localObject1 = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject1 = paramFissionAdapter.readFromCache((String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break;
          }
          j = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject1;
          i = j;
        } while (j == 1);
        paramString = (String)localObject1;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfileViewsTimeIntervalDataPoint");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfileViewsTimeIntervalDataPoint");
    }
    label170:
    if (((ByteBuffer)localObject2).getInt() != -1032769998)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building ProfileViewsTimeIntervalDataPoint");
    }
    long l1 = 0L;
    long l2 = 0L;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        l1 = ((ByteBuffer)localObject2).getLong();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label282;
      }
    }
    for (;;)
    {
      if (bool2) {
        l2 = ((ByteBuffer)localObject2).getLong();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label288;
      }
      throw new IOException("Failed to find required field: endTimestamp when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewsTimeIntervalDataPoint from fission.");
      bool1 = false;
      break;
      label282:
      bool2 = false;
    }
    label288:
    if (!bool2) {
      throw new IOException("Failed to find required field: numViews when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewsTimeIntervalDataPoint from fission.");
    }
    return new ProfileViewsTimeIntervalDataPoint(l1, l2, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewsTimeIntervalDataPointBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */