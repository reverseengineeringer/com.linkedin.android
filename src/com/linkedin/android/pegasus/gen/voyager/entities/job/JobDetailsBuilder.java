package com.linkedin.android.pegasus.gen.voyager.entities.job;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class JobDetailsBuilder
  implements FissileDataModelBuilder<JobDetails>, DataTemplateBuilder<JobDetails>
{
  public static final JobDetailsBuilder INSTANCE = new JobDetailsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("employmentStatus");
    JSON_KEY_STORE.put("experience");
    JSON_KEY_STORE.put("jobFunctions");
    JSON_KEY_STORE.put("industries");
    JSON_KEY_STORE.put("jobId");
  }
  
  public static JobDetails build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    long l = 0L;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("employmentStatus", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("experience", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool4 = true;
      }
      else
      {
        String str3;
        if (paramDataReader.shouldReadField$11ca93e7("jobFunctions", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              str3 = paramDataReader.readString();
              if (str3 != null) {
                ((List)localObject2).add(str3);
              }
            }
          }
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("industries", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              str3 = paramDataReader.readString();
              if (str3 != null) {
                ((List)localObject1).add(str3);
              }
            }
          }
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("jobId", JSON_KEY_STORE))
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
    }
    if (!bool3) {
      localObject2 = Collections.emptyList();
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    return new JobDetails(str2, str1, (List)localObject2, (List)localObject1, l, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static JobDetails readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building JobDetails");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building JobDetails");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building JobDetails");
    }
    if (((ByteBuffer)localObject1).getInt() != -2088958332)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building JobDetails");
    }
    localObject2 = null;
    String str = null;
    paramString = null;
    paramFissionTransaction = null;
    long l = 0L;
    boolean bool1;
    boolean bool2;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label339;
      }
      bool2 = true;
      label249:
      if (bool2) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label345;
      }
    }
    ArrayList localArrayList;
    label339:
    label345:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (!bool3) {
        break label351;
      }
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      for (;;)
      {
        paramString = localArrayList;
        if (i <= 0) {
          break;
        }
        localArrayList.add(paramFissionAdapter.readString((ByteBuffer)localObject1));
        i -= 1;
      }
      bool1 = false;
      break;
      bool2 = false;
      break label249;
    }
    label351:
    if (((ByteBuffer)localObject1).get() == 1) {}
    for (boolean bool4 = true; bool4; bool4 = false)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      for (;;)
      {
        paramFissionTransaction = localArrayList;
        if (i <= 0) {
          break;
        }
        localArrayList.add(paramFissionAdapter.readString((ByteBuffer)localObject1));
        i -= 1;
      }
    }
    if (((ByteBuffer)localObject1).get() == 1) {}
    for (boolean bool5 = true;; bool5 = false)
    {
      if (bool5) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (!bool3) {
        paramString = Collections.emptyList();
      }
      if (!bool4) {
        paramFissionTransaction = Collections.emptyList();
      }
      return new JobDetails((String)localObject2, str, paramString, paramFissionTransaction, l, bool1, bool2, bool3, bool4, bool5);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.JobDetailsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */