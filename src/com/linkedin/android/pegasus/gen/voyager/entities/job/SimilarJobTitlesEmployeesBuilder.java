package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistanceBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class SimilarJobTitlesEmployeesBuilder
  implements FissileDataModelBuilder<SimilarJobTitlesEmployees>, DataTemplateBuilder<SimilarJobTitlesEmployees>
{
  public static final SimilarJobTitlesEmployeesBuilder INSTANCE = new SimilarJobTitlesEmployeesBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("peopleWithDistance");
    JSON_KEY_STORE.put("total");
  }
  
  public static SimilarJobTitlesEmployees build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    int i = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("peopleWithDistance", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            MiniProfileWithDistanceBuilder localMiniProfileWithDistanceBuilder = MiniProfileWithDistanceBuilder.INSTANCE;
            localArrayList.add(MiniProfileWithDistanceBuilder.build(paramDataReader));
          }
        }
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
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: peopleWithDistance when building com.linkedin.android.pegasus.gen.voyager.entities.job.SimilarJobTitlesEmployees");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: total when building com.linkedin.android.pegasus.gen.voyager.entities.job.SimilarJobTitlesEmployees");
    }
    return new SimilarJobTitlesEmployees(localArrayList, i, bool2, bool1);
  }
  
  public static SimilarJobTitlesEmployees readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SimilarJobTitlesEmployees");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SimilarJobTitlesEmployees");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SimilarJobTitlesEmployees");
    }
    if (((ByteBuffer)localObject1).getInt() != 764406402)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SimilarJobTitlesEmployees");
    }
    paramString = null;
    int k = 0;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (!bool1) {
        break label359;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject2 = new ArrayList();
      label238:
      paramString = (String)localObject2;
      if (j <= 0) {
        break label359;
      }
      paramString = null;
      i = 1;
      int m = ((ByteBuffer)localObject1).get();
      if (m == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        MiniProfileWithDistanceBuilder localMiniProfileWithDistanceBuilder = MiniProfileWithDistanceBuilder.INSTANCE;
        paramString = MiniProfileWithDistanceBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label347;
        }
        i = 1;
      }
      label292:
      if (m == 1)
      {
        paramString = MiniProfileWithDistanceBuilder.INSTANCE;
        paramString = MiniProfileWithDistanceBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label353;
        }
      }
    }
    label347:
    label353:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject2).add(paramString);
      }
      j -= 1;
      break label238;
      bool1 = false;
      break;
      i = 0;
      break label292;
    }
    label359:
    if (((ByteBuffer)localObject1).get() == 1) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      i = k;
      if (bool2) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break;
      }
      throw new IOException("Failed to find required field: peopleWithDistance when reading com.linkedin.android.pegasus.gen.voyager.entities.job.SimilarJobTitlesEmployees from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: total when reading com.linkedin.android.pegasus.gen.voyager.entities.job.SimilarJobTitlesEmployees from fission.");
    }
    return new SimilarJobTitlesEmployees(paramString, i, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.SimilarJobTitlesEmployeesBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */