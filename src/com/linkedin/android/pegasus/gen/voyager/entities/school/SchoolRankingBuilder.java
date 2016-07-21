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

public final class SchoolRankingBuilder
  implements FissileDataModelBuilder<SchoolRanking>, DataTemplateBuilder<SchoolRanking>
{
  public static final SchoolRankingBuilder INSTANCE = new SchoolRankingBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("category");
    JSON_KEY_STORE.put("ranking");
    JSON_KEY_STORE.put("degreeLevel");
  }
  
  public static SchoolRanking build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    int i = 0;
    String str1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("category", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("ranking", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("degreeLevel", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: category when building com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolRanking");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: ranking when building com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolRanking");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: degreeLevel when building com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolRanking");
    }
    return new SchoolRanking(str2, i, str1, bool3, bool2, bool1);
  }
  
  public static SchoolRanking readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool3 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SchoolRanking");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SchoolRanking");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building SchoolRanking");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != 576084071)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building SchoolRanking");
    }
    paramString = null;
    int i = 0;
    paramFissionTransaction = null;
    boolean bool1;
    boolean bool2;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label311;
      }
      bool2 = true;
      label243:
      if (bool2) {
        i = ((ByteBuffer)localObject).getInt();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label317;
      }
    }
    for (;;)
    {
      if (bool3) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label323;
      }
      throw new IOException("Failed to find required field: category when reading com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolRanking from fission.");
      bool1 = false;
      break;
      label311:
      bool2 = false;
      break label243;
      label317:
      bool3 = false;
    }
    label323:
    if (!bool2) {
      throw new IOException("Failed to find required field: ranking when reading com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolRanking from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: degreeLevel when reading com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolRanking from fission.");
    }
    return new SchoolRanking(paramString, i, paramFissionTransaction, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolRankingBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */