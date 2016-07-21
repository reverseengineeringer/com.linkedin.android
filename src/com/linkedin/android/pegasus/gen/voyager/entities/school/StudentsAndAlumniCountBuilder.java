package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class StudentsAndAlumniCountBuilder
  implements FissileDataModelBuilder<StudentsAndAlumniCount>, DataTemplateBuilder<StudentsAndAlumniCount>
{
  public static final StudentsAndAlumniCountBuilder INSTANCE = new StudentsAndAlumniCountBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("count");
  }
  
  public static StudentsAndAlumniCount build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    int i = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = UrnCoercer.INSTANCE;
        localObject = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("count", JSON_KEY_STORE))
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
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: count when building com.linkedin.android.pegasus.gen.voyager.entities.school.StudentsAndAlumniCount");
    }
    return new StudentsAndAlumniCount((Urn)localObject, i, bool1, bool2);
  }
  
  public static StudentsAndAlumniCount readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building StudentsAndAlumniCount");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building StudentsAndAlumniCount");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building StudentsAndAlumniCount");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != 410463355)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building StudentsAndAlumniCount");
    }
    paramString = null;
    int i = 0;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1)
      {
        paramString = UrnCoercer.INSTANCE;
        paramString = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label290;
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
      if (bool2) {
        break label296;
      }
      throw new IOException("Failed to find required field: count when reading com.linkedin.android.pegasus.gen.voyager.entities.school.StudentsAndAlumniCount from fission.");
      bool1 = false;
      break;
      label290:
      bool2 = false;
    }
    label296:
    return new StudentsAndAlumniCount(paramString, i, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.StudentsAndAlumniCountBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */