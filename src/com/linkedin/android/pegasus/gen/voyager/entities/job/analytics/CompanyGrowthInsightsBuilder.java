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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CompanyGrowthInsightsBuilder
  implements FissileDataModelBuilder<CompanyGrowthInsights>, DataTemplateBuilder<CompanyGrowthInsights>
{
  public static final CompanyGrowthInsightsBuilder INSTANCE = new CompanyGrowthInsightsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniCompany");
    JSON_KEY_STORE.put("averageTenureYears");
    JSON_KEY_STORE.put("medianTenureYears");
    JSON_KEY_STORE.put("growth");
    JSON_KEY_STORE.put("companyGrowthPercent");
  }
  
  public static CompanyGrowthInsights build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    double d2 = 0.0D;
    double d1 = 0.0D;
    Object localObject1 = null;
    int i = 0;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("miniCompany", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MiniCompanyBuilder.INSTANCE;
        localObject2 = MiniCompanyBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("averageTenureYears", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        d2 = paramDataReader.readDouble();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("medianTenureYears", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        d1 = paramDataReader.readDouble();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("growth", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            EmployeeCountBuilder localEmployeeCountBuilder = EmployeeCountBuilder.INSTANCE;
            ((List)localObject1).add(EmployeeCountBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("companyGrowthPercent", JSON_KEY_STORE))
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
      localObject1 = Collections.emptyList();
    }
    return new CompanyGrowthInsights((MiniCompany)localObject2, d2, d1, (List)localObject1, i, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static CompanyGrowthInsights readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CompanyGrowthInsights");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building CompanyGrowthInsights");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building CompanyGrowthInsights");
    }
    if (((ByteBuffer)localObject2).getInt() != 1751941307)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building CompanyGrowthInsights");
    }
    paramString = null;
    Object localObject3 = null;
    double d1 = 0.0D;
    double d2 = 0.0D;
    localObject1 = null;
    int k = 0;
    boolean bool2;
    boolean bool1;
    label283:
    label309:
    label321:
    boolean bool3;
    label345:
    boolean bool4;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = (String)localObject3;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localObject3 = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label512;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label518;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label524;
      }
      bool2 = true;
      if (bool2) {
        d1 = ((ByteBuffer)localObject2).getDouble();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label530;
      }
      bool3 = true;
      if (bool3) {
        d2 = ((ByteBuffer)localObject2).getDouble();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label536;
      }
      bool4 = true;
      label369:
      if (!bool4) {
        break label554;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject3 = new ArrayList();
      label393:
      localObject1 = localObject3;
      if (j <= 0) {
        break label554;
      }
      localObject1 = null;
      i = 1;
      int m = ((ByteBuffer)localObject2).get();
      if (m == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        EmployeeCountBuilder localEmployeeCountBuilder = EmployeeCountBuilder.INSTANCE;
        localObject1 = EmployeeCountBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label542;
        }
        i = 1;
      }
      label453:
      if (m == 1)
      {
        localObject1 = EmployeeCountBuilder.INSTANCE;
        localObject1 = EmployeeCountBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label548;
        }
      }
    }
    label512:
    label518:
    label524:
    label530:
    label536:
    label542:
    label548:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject3).add(localObject1);
      }
      j -= 1;
      break label393;
      bool2 = false;
      break;
      bool1 = false;
      break label283;
      bool1 = false;
      break label309;
      bool2 = false;
      break label321;
      bool3 = false;
      break label345;
      bool4 = false;
      break label369;
      i = 0;
      break label453;
    }
    label554:
    if (((ByteBuffer)localObject2).get() == 1) {}
    for (boolean bool5 = true;; bool5 = false)
    {
      i = k;
      if (bool5) {
        i = ((ByteBuffer)localObject2).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (!bool4) {
        localObject1 = Collections.emptyList();
      }
      return new CompanyGrowthInsights(paramString, d1, d2, (List)localObject1, i, bool1, bool2, bool3, bool4, bool5);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyGrowthInsightsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */