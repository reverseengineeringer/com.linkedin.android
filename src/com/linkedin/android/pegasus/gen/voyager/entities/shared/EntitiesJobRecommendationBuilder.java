package com.linkedin.android.pegasus.gen.voyager.entities.shared;

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

public final class EntitiesJobRecommendationBuilder
  implements FissileDataModelBuilder<EntitiesJobRecommendation>, DataTemplateBuilder<EntitiesJobRecommendation>
{
  public static final EntitiesJobRecommendationBuilder INSTANCE = new EntitiesJobRecommendationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("createdAt");
    JSON_KEY_STORE.put("miniJob");
    JSON_KEY_STORE.put("jobUrl");
  }
  
  public static EntitiesJobRecommendation build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    Object localObject = null;
    String str = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("createdAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("miniJob", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = MiniJobBuilder.INSTANCE;
        localObject = MiniJobBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("jobUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: createdAt when building com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesJobRecommendation");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: miniJob when building com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesJobRecommendation");
    }
    return new EntitiesJobRecommendation(l, (MiniJob)localObject, str, bool3, bool2, bool1);
  }
  
  public static EntitiesJobRecommendation readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building EntitiesJobRecommendation");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building EntitiesJobRecommendation");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building EntitiesJobRecommendation");
    }
    if (((ByteBuffer)localObject).getInt() != 750881252)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building EntitiesJobRecommendation");
    }
    long l = 0L;
    paramString = null;
    MiniJobBuilder localMiniJobBuilder = null;
    localByteBuffer = null;
    boolean bool3;
    label244:
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        l = ((ByteBuffer)localObject).getLong();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label389;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject).get();
        paramString = localMiniJobBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
          localMiniJobBuilder = MiniJobBuilder.INSTANCE;
          paramString = MiniJobBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label395;
          }
          bool1 = true;
        }
        label301:
        if (i == 1)
        {
          paramString = MiniJobBuilder.INSTANCE;
          paramString = MiniJobBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject, null, paramFissionTransaction);
          if (paramString == null) {
            break label401;
          }
          bool1 = true;
        }
      }
      label327:
      if (((ByteBuffer)localObject).get() != 1) {
        break label407;
      }
    }
    label389:
    label395:
    label401:
    label407:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramFissionTransaction = localByteBuffer;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool3) {
        break label413;
      }
      throw new IOException("Failed to find required field: createdAt when reading com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesJobRecommendation from fission.");
      bool3 = false;
      break;
      bool2 = false;
      break label244;
      bool1 = false;
      break label301;
      bool1 = false;
      break label327;
    }
    label413:
    if (!bool1) {
      throw new IOException("Failed to find required field: miniJob when reading com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesJobRecommendation from fission.");
    }
    return new EntitiesJobRecommendation(l, paramString, paramFissionTransaction, bool3, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesJobRecommendationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */