package com.linkedin.android.pegasus.gen.voyager.identity.profile;

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

public final class WWUAd
  implements FissileDataModel<WWUAd>, RecordTemplate<WWUAd>
{
  public static final WWUAdBuilder BUILDER = WWUAdBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final MiniCompany company;
  public final List<String> externalClickTrackingUrls;
  public final List<String> externalImpressionTrackingUrls;
  public final boolean hasCompany;
  public final boolean hasExternalClickTrackingUrls;
  public final boolean hasExternalImpressionTrackingUrls;
  public final boolean hasInternalClickTrackingUrls;
  public final boolean hasInternalImpressionTrackingUrls;
  public final List<String> internalClickTrackingUrls;
  public final List<String> internalImpressionTrackingUrls;
  
  WWUAd(MiniCompany paramMiniCompany, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    company = paramMiniCompany;
    if (paramList1 == null)
    {
      paramMiniCompany = null;
      internalClickTrackingUrls = paramMiniCompany;
      if (paramList2 != null) {
        break label109;
      }
      paramMiniCompany = null;
      label36:
      externalClickTrackingUrls = paramMiniCompany;
      if (paramList3 != null) {
        break label117;
      }
      paramMiniCompany = null;
      label48:
      internalImpressionTrackingUrls = paramMiniCompany;
      if (paramList4 != null) {
        break label126;
      }
    }
    label109:
    label117:
    label126:
    for (paramMiniCompany = null;; paramMiniCompany = Collections.unmodifiableList(paramList4))
    {
      externalImpressionTrackingUrls = paramMiniCompany;
      hasCompany = paramBoolean1;
      hasInternalClickTrackingUrls = paramBoolean2;
      hasExternalClickTrackingUrls = paramBoolean3;
      hasInternalImpressionTrackingUrls = paramBoolean4;
      hasExternalImpressionTrackingUrls = paramBoolean5;
      _cachedId = null;
      return;
      paramMiniCompany = Collections.unmodifiableList(paramList1);
      break;
      paramMiniCompany = Collections.unmodifiableList(paramList2);
      break label36;
      paramMiniCompany = Collections.unmodifiableList(paramList3);
      break label48;
    }
  }
  
  private WWUAd accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject5 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("company");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label190;
      }
      localObject1 = company.accept(paramDataProcessor);
      if (localObject1 == null) {
        break label208;
      }
      bool1 = true;
    }
    Object localObject2;
    int i;
    Object localObject3;
    for (localObject5 = localObject1;; localObject5 = localObject1)
    {
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasInternalClickTrackingUrls) {
        break label231;
      }
      paramDataProcessor.startRecordField$505cff1c("internalClickTrackingUrls");
      internalClickTrackingUrls.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject2 = internalClickTrackingUrls.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject3);
        if (localObject1 != null) {
          ((List)localObject1).add(localObject3);
        }
        i += 1;
      }
      label190:
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(company);
      break;
      label208:
      bool1 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    label231:
    Object localObject4;
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject2 = null;
      localObject3 = null;
      bool3 = false;
      if (!hasExternalClickTrackingUrls) {
        break label385;
      }
      paramDataProcessor.startRecordField$505cff1c("externalClickTrackingUrls");
      externalClickTrackingUrls.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      localObject3 = externalClickTrackingUrls.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject4);
        if (localObject2 != null) {
          ((List)localObject2).add(localObject4);
        }
        i += 1;
      }
    }
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    label385:
    Object localObject6;
    for (boolean bool3 = true;; bool3 = false)
    {
      localObject3 = null;
      localObject4 = null;
      bool4 = false;
      if (!hasInternalImpressionTrackingUrls) {
        break label539;
      }
      paramDataProcessor.startRecordField$505cff1c("internalImpressionTrackingUrls");
      internalImpressionTrackingUrls.size();
      paramDataProcessor.startArray$13462e();
      localObject3 = localObject4;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject3 = new ArrayList();
      }
      i = 0;
      localObject4 = internalImpressionTrackingUrls.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (String)((Iterator)localObject4).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject6);
        if (localObject3 != null) {
          ((List)localObject3).add(localObject6);
        }
        i += 1;
      }
    }
    paramDataProcessor.endArray();
    if (localObject3 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label539:
      localObject4 = null;
      localObject6 = null;
      bool5 = false;
      if (!hasExternalImpressionTrackingUrls) {
        break label693;
      }
      paramDataProcessor.startRecordField$505cff1c("externalImpressionTrackingUrls");
      externalImpressionTrackingUrls.size();
      paramDataProcessor.startArray$13462e();
      localObject4 = localObject6;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject4 = new ArrayList();
      }
      i = 0;
      localObject6 = externalImpressionTrackingUrls.iterator();
      while (((Iterator)localObject6).hasNext())
      {
        String str = (String)((Iterator)localObject6).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject4 != null) {
          ((List)localObject4).add(str);
        }
        i += 1;
      }
    }
    paramDataProcessor.endArray();
    if (localObject4 != null) {}
    for (boolean bool5 = true;; bool5 = false)
    {
      label693:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label999;
      }
      if (!hasInternalClickTrackingUrls) {
        localObject1 = Collections.emptyList();
      }
      if (!hasExternalClickTrackingUrls) {
        localObject2 = Collections.emptyList();
      }
      if (!hasInternalImpressionTrackingUrls) {
        localObject3 = Collections.emptyList();
      }
      if (!hasExternalImpressionTrackingUrls) {
        localObject4 = Collections.emptyList();
      }
      try
      {
        if (internalClickTrackingUrls == null) {
          break;
        }
        paramDataProcessor = internalClickTrackingUrls.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((String)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.WWUAd", "internalClickTrackingUrls");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (externalClickTrackingUrls != null)
    {
      paramDataProcessor = externalClickTrackingUrls.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.WWUAd", "externalClickTrackingUrls");
        }
      }
    }
    if (internalImpressionTrackingUrls != null)
    {
      paramDataProcessor = internalImpressionTrackingUrls.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.WWUAd", "internalImpressionTrackingUrls");
        }
      }
    }
    if (externalImpressionTrackingUrls != null)
    {
      paramDataProcessor = externalImpressionTrackingUrls.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.WWUAd", "externalImpressionTrackingUrls");
        }
      }
    }
    return new WWUAd((MiniCompany)localObject5, (List)localObject1, (List)localObject2, (List)localObject3, (List)localObject4, bool1, bool2, bool3, bool4, bool5);
    label999:
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
      paramObject = (WWUAd)paramObject;
      if (company != null)
      {
        if (company.equals(company)) {}
      }
      else {
        while (company != null) {
          return false;
        }
      }
      if (internalClickTrackingUrls != null)
      {
        if (internalClickTrackingUrls.equals(internalClickTrackingUrls)) {}
      }
      else {
        while (internalClickTrackingUrls != null) {
          return false;
        }
      }
      if (externalClickTrackingUrls != null)
      {
        if (externalClickTrackingUrls.equals(externalClickTrackingUrls)) {}
      }
      else {
        while (externalClickTrackingUrls != null) {
          return false;
        }
      }
      if (internalImpressionTrackingUrls != null)
      {
        if (internalImpressionTrackingUrls.equals(internalImpressionTrackingUrls)) {}
      }
      else {
        while (internalImpressionTrackingUrls != null) {
          return false;
        }
      }
      if (externalImpressionTrackingUrls == null) {
        break;
      }
    } while (externalImpressionTrackingUrls.equals(externalImpressionTrackingUrls));
    for (;;)
    {
      return false;
      if (externalImpressionTrackingUrls == null) {
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
    if (hasCompany) {
      if (company._cachedId == null) {
        break label109;
      }
    }
    Iterator localIterator;
    label109:
    for (i = PegasusBinaryUtils.getEncodedLength(company._cachedId) + 9;; i = company.getSerializedSize() + 7)
    {
      i += 1;
      j = i;
      if (!hasInternalClickTrackingUrls) {
        break;
      }
      i += 2;
      localIterator = internalClickTrackingUrls.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
    }
    i = j + 1;
    int j = i;
    if (hasExternalClickTrackingUrls)
    {
      i += 2;
      localIterator = externalClickTrackingUrls.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
    }
    i = j + 1;
    j = i;
    if (hasInternalImpressionTrackingUrls)
    {
      i += 2;
      localIterator = internalImpressionTrackingUrls.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
    }
    i = j + 1;
    j = i;
    if (hasExternalImpressionTrackingUrls)
    {
      i += 2;
      localIterator = externalImpressionTrackingUrls.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label47:
    int k;
    if (company != null)
    {
      i = company.hashCode();
      if (internalClickTrackingUrls == null) {
        break label140;
      }
      j = internalClickTrackingUrls.hashCode();
      if (externalClickTrackingUrls == null) {
        break label145;
      }
      k = externalClickTrackingUrls.hashCode();
      label64:
      if (internalImpressionTrackingUrls == null) {
        break label150;
      }
    }
    label140:
    label145:
    label150:
    for (int m = internalImpressionTrackingUrls.hashCode();; m = 0)
    {
      if (externalImpressionTrackingUrls != null) {
        n = externalImpressionTrackingUrls.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label47;
      k = 0;
      break label64;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WWUAd");
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
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(960468105);
        if (hasCompany)
        {
          localByteBuffer.put((byte)1);
          if (company._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, company._cachedId);
            company.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        Iterator localIterator;
        while (hasInternalClickTrackingUrls)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, internalClickTrackingUrls.size());
          localIterator = internalClickTrackingUrls.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
          localByteBuffer.put((byte)1);
          company.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasExternalClickTrackingUrls)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, externalClickTrackingUrls.size());
          localIterator = externalClickTrackingUrls.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
        }
        localByteBuffer.put((byte)0);
        if (hasInternalImpressionTrackingUrls)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, internalImpressionTrackingUrls.size());
          localIterator = internalImpressionTrackingUrls.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
        }
        localByteBuffer.put((byte)0);
        if (hasExternalImpressionTrackingUrls)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, externalImpressionTrackingUrls.size());
          localIterator = externalImpressionTrackingUrls.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.WWUAd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */