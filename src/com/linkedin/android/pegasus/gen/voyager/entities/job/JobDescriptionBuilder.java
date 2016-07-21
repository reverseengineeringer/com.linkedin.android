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

public final class JobDescriptionBuilder
  implements FissileDataModelBuilder<JobDescription>, DataTemplateBuilder<JobDescription>
{
  public static final JobDescriptionBuilder INSTANCE = new JobDescriptionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("description");
    JSON_KEY_STORE.put("skillsAndExperience");
    JSON_KEY_STORE.put("employmentStatus");
    JSON_KEY_STORE.put("experience");
    JSON_KEY_STORE.put("jobFunctions");
    JSON_KEY_STORE.put("industries");
    JSON_KEY_STORE.put("jobId");
  }
  
  public static JobDescription build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    long l = 0L;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("skillsAndExperience", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("employmentStatus", JSON_KEY_STORE))
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
        String str5;
        if (paramDataReader.shouldReadField$11ca93e7("jobFunctions", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              str5 = paramDataReader.readString();
              if (str5 != null) {
                ((List)localObject2).add(str5);
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
              str5 = paramDataReader.readString();
              if (str5 != null) {
                ((List)localObject1).add(str5);
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
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: description when building com.linkedin.android.pegasus.gen.voyager.entities.job.JobDescription");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: jobId when building com.linkedin.android.pegasus.gen.voyager.entities.job.JobDescription");
    }
    return new JobDescription(str4, str3, str2, str1, (List)localObject2, (List)localObject1, l, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static JobDescription readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building JobDescription");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building JobDescription");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building JobDescription");
    }
    if (((ByteBuffer)localObject1).getInt() != 1466535364)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building JobDescription");
    }
    localObject2 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    paramString = null;
    paramFissionTransaction = null;
    long l = 0L;
    boolean bool1;
    boolean bool2;
    label255:
    boolean bool3;
    label282:
    boolean bool4;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label399;
      }
      bool2 = true;
      if (bool2) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label405;
      }
      bool3 = true;
      if (bool3) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label411;
      }
      bool4 = true;
      label309:
      if (bool4) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label417;
      }
    }
    ArrayList localArrayList;
    label399:
    label405:
    label411:
    label417:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (!bool5) {
        break label423;
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
      break label255;
      bool3 = false;
      break label282;
      bool4 = false;
      break label309;
    }
    label423:
    if (((ByteBuffer)localObject1).get() == 1) {}
    for (boolean bool6 = true; bool6; bool6 = false)
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
    for (boolean bool7 = true;; bool7 = false)
    {
      if (bool7) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (!bool5) {
        paramString = Collections.emptyList();
      }
      if (!bool6) {
        paramFissionTransaction = Collections.emptyList();
      }
      if (bool1) {
        break;
      }
      throw new IOException("Failed to find required field: description when reading com.linkedin.android.pegasus.gen.voyager.entities.job.JobDescription from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: jobId when reading com.linkedin.android.pegasus.gen.voyager.entities.job.JobDescription from fission.");
    }
    return new JobDescription((String)localObject2, str1, str2, str3, paramString, paramFissionTransaction, l, bool1, bool2, bool3, bool4, bool5, bool6, bool7);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.JobDescriptionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */