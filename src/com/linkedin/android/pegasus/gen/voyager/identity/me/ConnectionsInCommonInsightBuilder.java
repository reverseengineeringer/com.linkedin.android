package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ConnectionsInCommonInsightBuilder
  implements FissileDataModelBuilder<ConnectionsInCommonInsight>, DataTemplateBuilder<ConnectionsInCommonInsight>
{
  public static final ConnectionsInCommonInsightBuilder INSTANCE = new ConnectionsInCommonInsightBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniProfile");
    JSON_KEY_STORE.put("numConnectionsInCommon");
  }
  
  public static ConnectionsInCommonInsight build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    int i = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("miniProfile", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = MiniProfileBuilder.INSTANCE;
        localObject = MiniProfileBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numConnectionsInCommon", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: miniProfile when building com.linkedin.android.pegasus.gen.voyager.identity.me.ConnectionsInCommonInsight");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: numConnectionsInCommon when building com.linkedin.android.pegasus.gen.voyager.identity.me.ConnectionsInCommonInsight");
    }
    return new ConnectionsInCommonInsight((MiniProfile)localObject, i, bool2, bool1);
  }
  
  public static ConnectionsInCommonInsight readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ConnectionsInCommonInsight");
    }
    Object localObject2 = paramByteBuffer;
    int j;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      i = paramString.get();
      do
      {
        do
        {
          localObject1 = paramString;
          if (i != 0) {
            break;
          }
          localObject1 = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject1 = paramFissionAdapter.readFromCache((String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            return null;
          }
          j = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject1;
          i = j;
        } while (j == 1);
        paramString = (String)localObject1;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ConnectionsInCommonInsight");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building ConnectionsInCommonInsight");
    }
    if (((ByteBuffer)localObject1).getInt() != 278179830)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building ConnectionsInCommonInsight");
    }
    paramString = null;
    localObject2 = null;
    int i = 0;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject1).get();
        bool1 = bool2;
        paramString = (String)localObject2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localObject2 = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label357;
          }
          bool1 = true;
        }
        label274:
        if (j == 1)
        {
          paramString = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label363;
          }
          bool1 = true;
        }
      }
      label300:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label369;
      }
    }
    label357:
    label363:
    label369:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (bool2) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label375;
      }
      throw new IOException("Failed to find required field: miniProfile when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ConnectionsInCommonInsight from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label274;
      bool1 = false;
      break label300;
    }
    label375:
    if (!bool2) {
      throw new IOException("Failed to find required field: numConnectionsInCommon when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ConnectionsInCommonInsight from fission.");
    }
    return new ConnectionsInCommonInsight(paramString, i, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ConnectionsInCommonInsightBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */