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

public final class DegreeCountBuilder
  implements FissileDataModelBuilder<DegreeCount>, DataTemplateBuilder<DegreeCount>
{
  public static final DegreeCountBuilder INSTANCE = new DegreeCountBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("degree");
    JSON_KEY_STORE.put("count");
    JSON_KEY_STORE.put("percent");
    JSON_KEY_STORE.put("sharedDegree");
  }
  
  public static DegreeCount build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    long l = 0L;
    int i = 0;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("degree", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("count", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("percent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sharedDegree", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool1 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      bool1 = false;
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: degree when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.DegreeCount");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: count when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.DegreeCount");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: percent when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.DegreeCount");
    }
    return new DegreeCount(str, l, i, bool1, bool5, bool4, bool2, bool3);
  }
  
  public static DegreeCount readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building DegreeCount");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building DegreeCount");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building DegreeCount");
    }
    if (((ByteBuffer)localObject).getInt() != -829717739)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building DegreeCount");
    }
    paramString = null;
    long l = 0L;
    int i = 0;
    boolean bool1 = false;
    boolean bool2;
    boolean bool3;
    label246:
    boolean bool4;
    label270:
    boolean bool5;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      if (bool2) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label352;
      }
      bool3 = true;
      if (bool3) {
        l = ((ByteBuffer)localObject).getLong();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label358;
      }
      bool4 = true;
      if (bool4) {
        i = ((ByteBuffer)localObject).getInt();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label364;
      }
      bool5 = true;
      label294:
      if (bool5) {
        if (((ByteBuffer)localObject).get() != 1) {
          break label370;
        }
      }
    }
    label352:
    label358:
    label364:
    label370:
    for (bool1 = true;; bool1 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (!bool5) {
        bool1 = false;
      }
      if (bool2) {
        break label376;
      }
      throw new IOException("Failed to find required field: degree when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.DegreeCount from fission.");
      bool2 = false;
      break;
      bool3 = false;
      break label246;
      bool4 = false;
      break label270;
      bool5 = false;
      break label294;
    }
    label376:
    if (!bool3) {
      throw new IOException("Failed to find required field: count when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.DegreeCount from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: percent when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.DegreeCount from fission.");
    }
    return new DegreeCount(paramString, l, i, bool1, bool2, bool3, bool4, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.DegreeCountBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */