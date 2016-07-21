package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.DateBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EmployeeCountBuilder
  implements FissileDataModelBuilder<EmployeeCount>, DataTemplateBuilder<EmployeeCount>
{
  public static final EmployeeCountBuilder INSTANCE = new EmployeeCountBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("date");
    JSON_KEY_STORE.put("recordedOn");
    JSON_KEY_STORE.put("count");
  }
  
  public static EmployeeCount build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    long l = 0L;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("date", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = DateBuilder.INSTANCE;
        localObject2 = DateBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("recordedOn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = DateBuilder.INSTANCE;
        localObject1 = DateBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("count", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: count when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EmployeeCount");
    }
    return new EmployeeCount((Date)localObject2, (Date)localObject1, l, bool3, bool2, bool1);
  }
  
  public static EmployeeCount readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building EmployeeCount");
    }
    Object localObject1 = paramByteBuffer;
    int i;
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
          localObject2 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building EmployeeCount");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building EmployeeCount");
    }
    if (((ByteBuffer)localObject2).getInt() != 304478099)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building EmployeeCount");
    }
    paramString = null;
    DateBuilder localDateBuilder2 = null;
    localObject1 = null;
    DateBuilder localDateBuilder1 = null;
    long l = 0L;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localDateBuilder2;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localDateBuilder2 = DateBuilder.INSTANCE;
          paramString = DateBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label466;
          }
          bool1 = true;
        }
        label280:
        if (i == 1)
        {
          paramString = DateBuilder.INSTANCE;
          paramString = DateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label472;
          }
          bool1 = true;
        }
      }
      label306:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label478;
      }
      bool3 = true;
      label318:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localDateBuilder1;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localDateBuilder1 = DateBuilder.INSTANCE;
          localObject1 = DateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label484;
          }
          bool2 = true;
        }
        label380:
        if (i == 1)
        {
          localObject1 = DateBuilder.INSTANCE;
          localObject1 = DateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label490;
          }
          bool2 = true;
        }
      }
      label409:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label496;
      }
    }
    label466:
    label472:
    label478:
    label484:
    label490:
    label496:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (bool3) {
        l = ((ByteBuffer)localObject2).getLong();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool3) {
        break label502;
      }
      throw new IOException("Failed to find required field: count when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EmployeeCount from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label280;
      bool1 = false;
      break label306;
      bool3 = false;
      break label318;
      bool2 = false;
      break label380;
      bool2 = false;
      break label409;
    }
    label502:
    return new EmployeeCount(paramString, (Date)localObject1, l, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EmployeeCountBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */