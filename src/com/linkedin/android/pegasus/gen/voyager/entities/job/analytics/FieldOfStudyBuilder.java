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

public final class FieldOfStudyBuilder
  implements FissileDataModelBuilder<FieldOfStudy>, DataTemplateBuilder<FieldOfStudy>
{
  public static final FieldOfStudyBuilder INSTANCE = new FieldOfStudyBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("name");
    JSON_KEY_STORE.put("count");
  }
  
  public static FieldOfStudy build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    long l = 0L;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("name", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
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
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: name when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.FieldOfStudy");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: count when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.FieldOfStudy");
    }
    return new FieldOfStudy(str, l, bool2, bool1);
  }
  
  public static FieldOfStudy readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building FieldOfStudy");
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
            break label170;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            break;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building FieldOfStudy");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building FieldOfStudy");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != -1629810609)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building FieldOfStudy");
    }
    paramString = null;
    long l = 0L;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label283;
      }
    }
    for (;;)
    {
      if (bool2) {
        l = ((ByteBuffer)localObject).getLong();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label289;
      }
      throw new IOException("Failed to find required field: name when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.FieldOfStudy from fission.");
      bool1 = false;
      break;
      label283:
      bool2 = false;
    }
    label289:
    if (!bool2) {
      throw new IOException("Failed to find required field: count when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.FieldOfStudy from fission.");
    }
    return new FieldOfStudy(paramString, l, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.FieldOfStudyBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */