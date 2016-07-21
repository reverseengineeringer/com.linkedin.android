package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CompanyGrowthInsights
  implements FissileDataModel<CompanyGrowthInsights>, RecordTemplate<CompanyGrowthInsights>
{
  public static final CompanyGrowthInsightsBuilder BUILDER = CompanyGrowthInsightsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final double averageTenureYears;
  public final int companyGrowthPercent;
  public final List<EmployeeCount> growth;
  public final boolean hasAverageTenureYears;
  public final boolean hasCompanyGrowthPercent;
  public final boolean hasGrowth;
  public final boolean hasMedianTenureYears;
  public final boolean hasMiniCompany;
  public final double medianTenureYears;
  public final MiniCompany miniCompany;
  
  CompanyGrowthInsights(MiniCompany paramMiniCompany, double paramDouble1, double paramDouble2, List<EmployeeCount> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    miniCompany = paramMiniCompany;
    averageTenureYears = paramDouble1;
    medianTenureYears = paramDouble2;
    if (paramList == null) {}
    for (paramMiniCompany = null;; paramMiniCompany = Collections.unmodifiableList(paramList))
    {
      growth = paramMiniCompany;
      companyGrowthPercent = paramInt;
      hasMiniCompany = paramBoolean1;
      hasAverageTenureYears = paramBoolean2;
      hasMedianTenureYears = paramBoolean3;
      hasGrowth = paramBoolean4;
      hasCompanyGrowthPercent = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  public final CompanyGrowthInsights accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    int i;
    if (hasMiniCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("miniCompany");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniCompany.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label272;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasAverageTenureYears)
      {
        paramDataProcessor.startRecordField$505cff1c("averageTenureYears");
        paramDataProcessor.processDouble(averageTenureYears);
      }
      if (hasMedianTenureYears)
      {
        paramDataProcessor.startRecordField$505cff1c("medianTenureYears");
        paramDataProcessor.processDouble(medianTenureYears);
      }
      localObject1 = null;
      localEmployeeCount = null;
      bool2 = false;
      if (!hasGrowth) {
        break label311;
      }
      paramDataProcessor.startRecordField$505cff1c("growth");
      growth.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localEmployeeCount;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = growth.iterator();
      label181:
      if (!localIterator.hasNext()) {
        break label297;
      }
      localEmployeeCount = (EmployeeCount)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label281;
      }
    }
    label272:
    label281:
    for (EmployeeCount localEmployeeCount = localEmployeeCount.accept(paramDataProcessor);; localEmployeeCount = (EmployeeCount)paramDataProcessor.processDataTemplate(localEmployeeCount))
    {
      if ((localObject1 != null) && (localEmployeeCount != null)) {
        ((List)localObject1).add(localEmployeeCount);
      }
      i += 1;
      break label181;
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompany);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
    }
    label297:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label311:
      if (hasCompanyGrowthPercent)
      {
        paramDataProcessor.startRecordField$505cff1c("companyGrowthPercent");
        paramDataProcessor.processInt(companyGrowthPercent);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label468;
      }
      if (!hasGrowth) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (growth == null) {
          break;
        }
        paramDataProcessor = growth.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((EmployeeCount)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyGrowthInsights", "growth");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    return new CompanyGrowthInsights((MiniCompany)localObject2, averageTenureYears, medianTenureYears, (List)localObject1, companyGrowthPercent, bool1, hasAverageTenureYears, hasMedianTenureYears, bool2, hasCompanyGrowthPercent);
    label468:
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (CompanyGrowthInsights)paramObject;
      if (miniCompany != null)
      {
        if (miniCompany.equals(miniCompany)) {}
      }
      else {
        while (miniCompany != null) {
          return false;
        }
      }
      if (averageTenureYears != averageTenureYears) {
        return false;
      }
      if (medianTenureYears != medianTenureYears) {
        return false;
      }
      if (growth != null)
      {
        if (growth.equals(growth)) {}
      }
      else {
        while (growth != null) {
          return false;
        }
      }
    } while (companyGrowthPercent == companyGrowthPercent);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    int j;
    Iterator localIterator;
    if (hasMiniCompany)
    {
      if (miniCompany._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniCompany._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasAverageTenureYears) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasMedianTenureYears) {
        i = j + 8;
      }
      i += 1;
      j = i;
      if (!hasGrowth) {
        break label189;
      }
      i += 2;
      localIterator = growth.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label189;
      }
      EmployeeCount localEmployeeCount = (EmployeeCount)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = miniCompany.getSerializedSize() + 7;
        break;
      }
      i += localEmployeeCount.getSerializedSize();
    }
    label189:
    j += 1;
    i = j;
    if (hasCompanyGrowthPercent) {
      i = j + 4;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (miniCompany != null) {}
    for (int i = miniCompany.hashCode();; i = 0)
    {
      int k = (int)(Double.doubleToLongBits(averageTenureYears) ^ Double.doubleToLongBits(averageTenureYears) >>> 32);
      int m = (int)(Double.doubleToLongBits(medianTenureYears) ^ Double.doubleToLongBits(medianTenureYears) >>> 32);
      if (growth != null) {
        j = growth.hashCode();
      }
      i = ((((i + 527) * 31 + k) * 31 + m) * 31 + j) * 31 + companyGrowthPercent;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CompanyGrowthInsights");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label194:
    label218:
    label360:
    label370:
    label403:
    label410:
    label477:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(1751941307);
        Iterator localIterator;
        if (hasMiniCompany)
        {
          localByteBuffer.put((byte)1);
          if (miniCompany._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniCompany._cachedId);
            miniCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAverageTenureYears) {
              break label360;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putDouble(averageTenureYears);
            if (!hasMedianTenureYears) {
              break label370;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putDouble(medianTenureYears);
            if (!hasGrowth) {
              break label403;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, growth.size());
            localIterator = growth.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label410;
          }
          EmployeeCount localEmployeeCount = (EmployeeCount)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localEmployeeCount.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            miniCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label194;
            localByteBuffer.put((byte)0);
            break label218;
          }
          localByteBuffer.put((byte)1);
          localEmployeeCount.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasCompanyGrowthPercent)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(companyGrowthPercent);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label477;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyGrowthInsights
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */