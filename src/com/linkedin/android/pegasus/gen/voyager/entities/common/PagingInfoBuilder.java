package com.linkedin.android.pegasus.gen.voyager.entities.common;

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

public final class PagingInfoBuilder
  implements FissileDataModelBuilder<PagingInfo>, DataTemplateBuilder<PagingInfo>
{
  public static final PagingInfoBuilder INSTANCE = new PagingInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("start");
    JSON_KEY_STORE.put("count");
    JSON_KEY_STORE.put("total");
  }
  
  public static PagingInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    int k = 0;
    int j = 0;
    int i = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("start", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        k = paramDataReader.readInt();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("count", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("total", JSON_KEY_STORE))
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
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: start when building com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: count when building com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo");
    }
    return new PagingInfo(k, j, i, bool3, bool2, bool1);
  }
  
  public static PagingInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool3 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PagingInfo");
    }
    Object localObject1 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PagingInfo");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building PagingInfo");
    }
    label170:
    if (((ByteBuffer)localObject2).getInt() != -1201641331)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building PagingInfo");
    }
    int i = 0;
    int j = 0;
    int k = 0;
    boolean bool1;
    boolean bool2;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        i = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label309;
      }
      bool2 = true;
      label243:
      if (bool2) {
        j = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label315;
      }
    }
    for (;;)
    {
      if (bool3) {
        k = ((ByteBuffer)localObject2).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label321;
      }
      throw new IOException("Failed to find required field: start when reading com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo from fission.");
      bool1 = false;
      break;
      label309:
      bool2 = false;
      break label243;
      label315:
      bool3 = false;
    }
    label321:
    if (!bool2) {
      throw new IOException("Failed to find required field: count when reading com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo from fission.");
    }
    return new PagingInfo(i, j, k, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */