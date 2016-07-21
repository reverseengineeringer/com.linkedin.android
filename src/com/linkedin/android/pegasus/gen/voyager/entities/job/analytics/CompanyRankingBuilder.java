package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompanyBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CompanyRankingBuilder
  implements FissileDataModelBuilder<CompanyRanking>, DataTemplateBuilder<CompanyRanking>
{
  public static final CompanyRankingBuilder INSTANCE = new CompanyRankingBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniCompany");
    JSON_KEY_STORE.put("count");
    JSON_KEY_STORE.put("rank");
    JSON_KEY_STORE.put("viewerFromCompany");
  }
  
  public static CompanyRanking build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    long l = 0L;
    int i = 0;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("miniCompany", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = MiniCompanyBuilder.INSTANCE;
        localObject = MiniCompanyBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("count", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("rank", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("viewerFromCompany", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool5 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: miniCompany when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: count when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: rank when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: viewerFromCompany when building com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking");
    }
    return new CompanyRanking((MiniCompany)localObject, l, i, bool5, bool4, bool3, bool1, bool2);
  }
  
  public static CompanyRanking readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CompanyRanking");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building CompanyRanking");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building CompanyRanking");
    }
    if (((ByteBuffer)localObject1).getInt() != -69884295)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building CompanyRanking");
    }
    paramString = null;
    localObject2 = null;
    long l = 0L;
    int i = 0;
    boolean bool6 = false;
    boolean bool1;
    label280:
    label306:
    boolean bool3;
    label318:
    boolean bool4;
    label342:
    boolean bool5;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject1).get();
        paramString = (String)localObject2;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localObject2 = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label420;
          }
          bool1 = true;
        }
        if (j == 1)
        {
          paramString = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label426;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label432;
      }
      bool3 = true;
      if (bool3) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label438;
      }
      bool4 = true;
      if (bool4) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label444;
      }
      bool5 = true;
      label366:
      bool2 = bool6;
      if (bool5) {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label450;
        }
      }
    }
    label420:
    label426:
    label432:
    label438:
    label444:
    label450:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label456;
      }
      throw new IOException("Failed to find required field: miniCompany when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label280;
      bool1 = false;
      break label306;
      bool3 = false;
      break label318;
      bool4 = false;
      break label342;
      bool5 = false;
      break label366;
    }
    label456:
    if (!bool3) {
      throw new IOException("Failed to find required field: count when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: rank when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: viewerFromCompany when reading com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking from fission.");
    }
    return new CompanyRanking(paramString, l, i, bool2, bool1, bool3, bool4, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRankingBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */