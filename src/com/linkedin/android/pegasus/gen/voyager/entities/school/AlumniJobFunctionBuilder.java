package com.linkedin.android.pegasus.gen.voyager.entities.school;

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

public final class AlumniJobFunctionBuilder
  implements FissileDataModelBuilder<AlumniJobFunction>, DataTemplateBuilder<AlumniJobFunction>
{
  public static final AlumniJobFunctionBuilder INSTANCE = new AlumniJobFunctionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("jobFunction");
    JSON_KEY_STORE.put("alumniCount");
  }
  
  public static AlumniJobFunction build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    int i = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("jobFunction", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("alumniCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: jobFunction when building com.linkedin.android.pegasus.gen.voyager.entities.school.AlumniJobFunction");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: alumniCount when building com.linkedin.android.pegasus.gen.voyager.entities.school.AlumniJobFunction");
    }
    return new AlumniJobFunction(str, i, bool1, bool2);
  }
  
  public static AlumniJobFunction readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building AlumniJobFunction");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building AlumniJobFunction");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building AlumniJobFunction");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != -1726933650)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building AlumniJobFunction");
    }
    paramString = null;
    int i = 0;
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
        i = ((ByteBuffer)localObject).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label289;
      }
      throw new IOException("Failed to find required field: jobFunction when reading com.linkedin.android.pegasus.gen.voyager.entities.school.AlumniJobFunction from fission.");
      bool1 = false;
      break;
      label283:
      bool2 = false;
    }
    label289:
    if (!bool2) {
      throw new IOException("Failed to find required field: alumniCount when reading com.linkedin.android.pegasus.gen.voyager.entities.school.AlumniJobFunction from fission.");
    }
    return new AlumniJobFunction(paramString, i, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.AlumniJobFunctionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */