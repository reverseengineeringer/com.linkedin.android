package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateType;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateType.Builder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ReachStatisticsBuilder
  implements FissileDataModelBuilder<ReachStatistics>, DataTemplateBuilder<ReachStatistics>
{
  public static final ReachStatisticsBuilder INSTANCE = new ReachStatisticsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("numInNetworkViewers");
    JSON_KEY_STORE.put("numOutOfNetworkViewers");
    JSON_KEY_STORE.put("socialUpdateType");
  }
  
  public static ReachStatistics build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l2 = 0L;
    long l1 = 0L;
    SocialUpdateType localSocialUpdateType = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("numInNetworkViewers", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numOutOfNetworkViewers", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("socialUpdateType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSocialUpdateType = (SocialUpdateType)paramDataReader.readEnum(SocialUpdateType.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: numInNetworkViewers when building com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ReachStatistics");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: numOutOfNetworkViewers when building com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ReachStatistics");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: socialUpdateType when building com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ReachStatistics");
    }
    return new ReachStatistics(l2, l1, localSocialUpdateType, bool3, bool2, bool1);
  }
  
  public static ReachStatistics readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ReachStatistics");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
          localObject = paramString;
          if (i != 0) {
            break;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            return null;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building ReachStatistics");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building ReachStatistics");
    }
    if (((ByteBuffer)localObject).getInt() != -1793547122)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building ReachStatistics");
    }
    long l1 = 0L;
    long l2 = 0L;
    paramString = null;
    boolean bool1;
    boolean bool2;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        l1 = ((ByteBuffer)localObject).getLong();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label315;
      }
      bool2 = true;
      label241:
      if (bool2) {
        l2 = ((ByteBuffer)localObject).getLong();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label321;
      }
    }
    label315:
    label321:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (bool3) {
        paramString = SocialUpdateType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label327;
      }
      throw new IOException("Failed to find required field: numInNetworkViewers when reading com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ReachStatistics from fission.");
      bool1 = false;
      break;
      bool2 = false;
      break label241;
    }
    label327:
    if (!bool2) {
      throw new IOException("Failed to find required field: numOutOfNetworkViewers when reading com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ReachStatistics from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: socialUpdateType when reading com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ReachStatistics from fission.");
    }
    return new ReachStatistics(l1, l2, paramString, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ReachStatisticsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */