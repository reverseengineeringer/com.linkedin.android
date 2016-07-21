package com.linkedin.android.pegasus.gen.voyager.premium.onboarding;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompanyBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJobBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class JobCardBuilder
  implements FissileDataModelBuilder<JobCard>, DataTemplateBuilder<JobCard>
{
  public static final JobCardBuilder INSTANCE = new JobCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("job");
    JSON_KEY_STORE.put("company");
    JSON_KEY_STORE.put("applicantInsightPercent");
    JSON_KEY_STORE.put("applicantInsightTotal");
  }
  
  public static JobCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    long l = 0L;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("job", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MiniJobBuilder.INSTANCE;
        localObject2 = MiniJobBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("company", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = MiniCompanyBuilder.INSTANCE;
        localObject1 = MiniCompanyBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("applicantInsightPercent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("applicantInsightTotal", JSON_KEY_STORE))
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
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: job when building com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: company when building com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: applicantInsightPercent when building com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: applicantInsightTotal when building com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard");
    }
    return new JobCard((MiniJob)localObject2, (MiniCompany)localObject1, i, l, bool4, bool3, bool2, bool1);
  }
  
  public static JobCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building JobCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building JobCard");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building JobCard");
    }
    if (((ByteBuffer)localObject2).getInt() != -1127752799)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building JobCard");
    }
    paramString = null;
    MiniJobBuilder localMiniJobBuilder = null;
    localObject1 = null;
    MiniCompanyBuilder localMiniCompanyBuilder = null;
    int i = 0;
    long l = 0L;
    boolean bool2;
    boolean bool1;
    label283:
    label309:
    boolean bool3;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject2).get();
        paramString = localMiniJobBuilder;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniJobBuilder = MiniJobBuilder.INSTANCE;
          paramString = MiniJobBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label493;
          }
          bool1 = true;
        }
        if (j == 1)
        {
          paramString = MiniJobBuilder.INSTANCE;
          paramString = MiniJobBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label499;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label505;
      }
      bool3 = true;
      label321:
      bool2 = bool3;
      if (bool3)
      {
        j = ((ByteBuffer)localObject2).get();
        localObject1 = localMiniCompanyBuilder;
        bool2 = bool3;
        if (j == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniCompanyBuilder = MiniCompanyBuilder.INSTANCE;
          localObject1 = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label511;
          }
          bool2 = true;
        }
        label383:
        if (j == 1)
        {
          localObject1 = MiniCompanyBuilder.INSTANCE;
          localObject1 = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label517;
          }
          bool2 = true;
        }
      }
      label412:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label523;
      }
      bool3 = true;
      label424:
      if (bool3) {
        i = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label529;
      }
    }
    label493:
    label499:
    label505:
    label511:
    label517:
    label523:
    label529:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (bool4) {
        l = ((ByteBuffer)localObject2).getLong();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label535;
      }
      throw new IOException("Failed to find required field: job when reading com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label283;
      bool1 = false;
      break label309;
      bool3 = false;
      break label321;
      bool2 = false;
      break label383;
      bool2 = false;
      break label412;
      bool3 = false;
      break label424;
    }
    label535:
    if (!bool2) {
      throw new IOException("Failed to find required field: company when reading com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: applicantInsightPercent when reading com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: applicantInsightTotal when reading com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard from fission.");
    }
    return new JobCard(paramString, (MiniCompany)localObject1, i, l, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */