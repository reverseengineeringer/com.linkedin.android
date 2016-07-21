package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

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

public final class SeniorityCountBuilder
  implements FissileDataModelBuilder<SeniorityCount>, DataTemplateBuilder<SeniorityCount>
{
  public static final SeniorityCountBuilder INSTANCE = new SeniorityCountBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("seniority");
    JSON_KEY_STORE.put("count");
    JSON_KEY_STORE.put("level");
  }
  
  public static SeniorityCount build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    long l = 0L;
    int i = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("seniority", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("count", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("level", JSON_KEY_STORE))
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
      throw new DataReaderException("Failed to find required field: seniority when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityCount");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: count when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityCount");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: level when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityCount");
    }
    return new SeniorityCount(str, l, i, bool3, bool2, bool1);
  }
  
  public static SeniorityCount readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SeniorityCount");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      i = paramString.get();
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SeniorityCount");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building SeniorityCount");
    }
    if (((ByteBuffer)localObject).getInt() != 2013023136)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building SeniorityCount");
    }
    paramString = null;
    long l = 0L;
    int i = 0;
    boolean bool1;
    boolean bool2;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label312;
      }
      bool2 = true;
      label243:
      if (bool2) {
        l = ((ByteBuffer)localObject).getLong();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label318;
      }
    }
    label312:
    label318:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (bool3) {
        i = ((ByteBuffer)localObject).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label324;
      }
      throw new IOException("Failed to find required field: seniority when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityCount from fission.");
      bool1 = false;
      break;
      bool2 = false;
      break label243;
    }
    label324:
    if (!bool2) {
      throw new IOException("Failed to find required field: count when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityCount from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: level when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityCount from fission.");
    }
    return new SeniorityCount(paramString, l, i, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityCountBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */