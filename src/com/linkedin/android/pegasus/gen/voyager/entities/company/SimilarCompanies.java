package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SimilarCompanies
  implements FissileDataModel<SimilarCompanies>, RecordTemplate<SimilarCompanies>
{
  public static final SimilarCompaniesBuilder BUILDER = SimilarCompaniesBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<NextCompany> companies;
  public final boolean hasCompanies;
  public final boolean hasPagingInfo;
  public final PagingInfo pagingInfo;
  
  SimilarCompanies(List<NextCompany> paramList, PagingInfo paramPagingInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      companies = paramList;
      pagingInfo = paramPagingInfo;
      hasCompanies = paramBoolean1;
      hasPagingInfo = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final SimilarCompanies accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    if (hasCompanies)
    {
      paramDataProcessor.startRecordField$505cff1c("companies");
      companies.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = companies.iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (NextCompany)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((NextCompany)localObject2).accept(paramDataProcessor);; localObject2 = (NextCompany)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null)
      {
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      bool2 = false;
      if (hasPagingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("pagingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label283;
        }
        localObject1 = pagingInfo.accept(paramDataProcessor);
        label222:
        if (localObject1 == null) {
          break label301;
        }
      }
    }
    label283:
    label301:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label391;
      }
      try
      {
        if (hasCompanies) {
          break label307;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.SimilarCompanies", "companies");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      localObject2 = localObject1;
      break;
      localObject1 = (PagingInfo)paramDataProcessor.processDataTemplate(pagingInfo);
      break label222;
    }
    label307:
    if (!hasPagingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.SimilarCompanies", "pagingInfo");
    }
    if (companies != null)
    {
      paramDataProcessor = companies.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((NextCompany)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.company.SimilarCompanies", "companies");
        }
      }
    }
    return new SimilarCompanies((List)localObject2, (PagingInfo)localObject1, bool1, bool2);
    label391:
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
      paramObject = (SimilarCompanies)paramObject;
      if (companies != null)
      {
        if (companies.equals(companies)) {}
      }
      else {
        while (companies != null) {
          return false;
        }
      }
      if (pagingInfo == null) {
        break;
      }
    } while (pagingInfo.equals(pagingInfo));
    for (;;)
    {
      return false;
      if (pagingInfo == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    int j = i;
    if (hasCompanies)
    {
      i += 2;
      Iterator localIterator = companies.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        NextCompany localNextCompany = (NextCompany)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localNextCompany.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasPagingInfo)
    {
      i = j + 1;
      if (pagingInfo._cachedId == null) {
        break label153;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(pagingInfo._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label153:
      i += pagingInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (companies != null) {}
    for (int i = companies.hashCode();; i = 0)
    {
      if (pagingInfo != null) {
        j = pagingInfo.hashCode();
      }
      i = (i + 527) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SimilarCompanies");
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
    label375:
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
        localByteBuffer.putInt(-2020936988);
        if (hasCompanies)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, companies.size());
          Iterator localIterator = companies.iterator();
          while (localIterator.hasNext())
          {
            NextCompany localNextCompany = (NextCompany)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localNextCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localNextCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasPagingInfo)
        {
          localByteBuffer.put((byte)1);
          if (pagingInfo._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, pagingInfo._cachedId);
            pagingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label375;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          pagingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.SimilarCompanies
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */