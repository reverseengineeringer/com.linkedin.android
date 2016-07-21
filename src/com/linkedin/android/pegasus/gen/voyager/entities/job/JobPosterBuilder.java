package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfoBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class JobPosterBuilder
  implements FissileDataModelBuilder<JobPoster>, DataTemplateBuilder<JobPoster>
{
  public static final JobPosterBuilder INSTANCE = new JobPosterBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("poster");
    JSON_KEY_STORE.put("connections");
    JSON_KEY_STORE.put("pagingInfo");
  }
  
  public static JobPoster build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("poster", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = EntitiesMiniProfileBuilder.INSTANCE;
        localObject3 = EntitiesMiniProfileBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("connections", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            EntitiesMiniProfileBuilder localEntitiesMiniProfileBuilder = EntitiesMiniProfileBuilder.INSTANCE;
            ((List)localObject1).add(EntitiesMiniProfileBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("pagingInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = PagingInfoBuilder.INSTANCE;
        localObject2 = PagingInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: poster when building com.linkedin.android.pegasus.gen.voyager.entities.job.JobPoster");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: pagingInfo when building com.linkedin.android.pegasus.gen.voyager.entities.job.JobPoster");
    }
    return new JobPoster((EntitiesMiniProfile)localObject3, (List)localObject1, (PagingInfo)localObject2, bool3, bool2, bool1);
  }
  
  public static JobPoster readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building JobPoster");
    }
    Object localObject1 = paramByteBuffer;
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
          localObject3 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building JobPoster");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building JobPoster");
    }
    if (((ByteBuffer)localObject3).getInt() != 1101551008)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building JobPoster");
    }
    paramString = null;
    Object localObject4 = null;
    localObject1 = null;
    Object localObject2 = null;
    PagingInfoBuilder localPagingInfoBuilder = null;
    boolean bool2;
    boolean bool1;
    label280:
    label306:
    boolean bool4;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = (String)localObject4;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject4 = EntitiesMiniProfileBuilder.INSTANCE;
          paramString = EntitiesMiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label461;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = EntitiesMiniProfileBuilder.INSTANCE;
          paramString = EntitiesMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label467;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label473;
      }
      bool4 = true;
      label318:
      if (!bool4) {
        break label491;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject4 = new ArrayList();
      label342:
      localObject1 = localObject4;
      if (j <= 0) {
        break label491;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject3).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
        EntitiesMiniProfileBuilder localEntitiesMiniProfileBuilder = EntitiesMiniProfileBuilder.INSTANCE;
        localObject1 = EntitiesMiniProfileBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label479;
        }
        i = 1;
      }
      label402:
      if (k == 1)
      {
        localObject1 = EntitiesMiniProfileBuilder.INSTANCE;
        localObject1 = EntitiesMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label485;
        }
      }
    }
    label461:
    label467:
    label473:
    label479:
    label485:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject4).add(localObject1);
      }
      j -= 1;
      break label342;
      bool2 = false;
      break;
      bool1 = false;
      break label280;
      bool1 = false;
      break label306;
      bool4 = false;
      break label318;
      i = 0;
      break label402;
    }
    label491:
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool2 = true;
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localPagingInfoBuilder;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localPagingInfoBuilder = PagingInfoBuilder.INSTANCE;
          localObject2 = PagingInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label637;
          }
          bool2 = true;
        }
        label561:
        bool3 = bool2;
        if (i == 1)
        {
          localObject2 = PagingInfoBuilder.INSTANCE;
          localObject2 = PagingInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label643;
          }
        }
      }
    }
    label637:
    label643:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (!bool4) {
        localObject1 = Collections.emptyList();
      }
      if (bool1) {
        break label649;
      }
      throw new IOException("Failed to find required field: poster when reading com.linkedin.android.pegasus.gen.voyager.entities.job.JobPoster from fission.");
      bool2 = false;
      break;
      bool2 = false;
      break label561;
    }
    label649:
    if (!bool3) {
      throw new IOException("Failed to find required field: pagingInfo when reading com.linkedin.android.pegasus.gen.voyager.entities.job.JobPoster from fission.");
    }
    return new JobPoster(paramString, (List)localObject1, (PagingInfo)localObject2, bool1, bool4, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.JobPosterBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */