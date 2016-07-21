package com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.HighlightsMiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class DescriptiveCompany
  implements FissileDataModel<DescriptiveCompany>, RecordTemplate<DescriptiveCompany>
{
  public static final DescriptiveCompanyBuilder BUILDER = DescriptiveCompanyBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final MiniCompany company;
  public final List<HighlightsMiniProfile> connections;
  public final boolean hasCompany;
  public final boolean hasConnections;
  public final boolean hasNumConnections;
  public final int numConnections;
  
  DescriptiveCompany(MiniCompany paramMiniCompany, int paramInt, List<HighlightsMiniProfile> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    company = paramMiniCompany;
    numConnections = paramInt;
    if (paramList == null) {}
    for (paramMiniCompany = null;; paramMiniCompany = Collections.unmodifiableList(paramList))
    {
      connections = paramMiniCompany;
      hasCompany = paramBoolean1;
      hasNumConnections = paramBoolean2;
      hasConnections = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final DescriptiveCompany accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    int i;
    if (hasCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("company");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = company.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label247;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasNumConnections)
      {
        paramDataProcessor.startRecordField$505cff1c("numConnections");
        paramDataProcessor.processInt(numConnections);
      }
      localObject1 = null;
      localHighlightsMiniProfile = null;
      bool2 = false;
      if (!hasConnections) {
        break label286;
      }
      paramDataProcessor.startRecordField$505cff1c("connections");
      connections.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localHighlightsMiniProfile;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = connections.iterator();
      label156:
      if (!localIterator.hasNext()) {
        break label272;
      }
      localHighlightsMiniProfile = (HighlightsMiniProfile)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label256;
      }
    }
    label247:
    label256:
    for (HighlightsMiniProfile localHighlightsMiniProfile = localHighlightsMiniProfile.accept(paramDataProcessor);; localHighlightsMiniProfile = (HighlightsMiniProfile)paramDataProcessor.processDataTemplate(localHighlightsMiniProfile))
    {
      if ((localObject1 != null) && (localHighlightsMiniProfile != null)) {
        ((List)localObject1).add(localHighlightsMiniProfile);
      }
      i += 1;
      break label156;
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(company);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
    }
    label272:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label286:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label440;
      }
      if (!hasConnections) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasCompany) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveCompany", "company");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasNumConnections) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveCompany", "numConnections");
    }
    if (connections != null)
    {
      paramDataProcessor = connections.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((HighlightsMiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveCompany", "connections");
        }
      }
    }
    return new DescriptiveCompany((MiniCompany)localObject2, numConnections, (List)localObject1, bool1, hasNumConnections, bool2);
    label440:
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
      paramObject = (DescriptiveCompany)paramObject;
      if (company != null)
      {
        if (company.equals(company)) {}
      }
      else {
        while (company != null) {
          return false;
        }
      }
      if (numConnections != numConnections) {
        return false;
      }
      if (connections == null) {
        break;
      }
    } while (connections.equals(connections));
    for (;;)
    {
      return false;
      if (connections == null) {
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
    int j;
    Iterator localIterator;
    if (hasCompany)
    {
      if (company._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(company._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasNumConnections) {
        i = j + 4;
      }
      i += 1;
      j = i;
      if (!hasConnections) {
        break label170;
      }
      i += 2;
      localIterator = connections.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label170;
      }
      HighlightsMiniProfile localHighlightsMiniProfile = (HighlightsMiniProfile)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = company.getSerializedSize() + 7;
        break;
      }
      i += localHighlightsMiniProfile.getSerializedSize();
    }
    label170:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (company != null) {}
    for (int i = company.hashCode();; i = 0)
    {
      int k = numConnections;
      if (connections != null) {
        j = connections.hashCode();
      }
      i = ((i + 527) * 31 + k) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building DescriptiveCompany");
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
    label336:
    label369:
    label376:
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
        localByteBuffer.putInt(-1957801286);
        Iterator localIterator;
        if (hasCompany)
        {
          localByteBuffer.put((byte)1);
          if (company._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, company._cachedId);
            company.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasNumConnections) {
              break label336;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(numConnections);
            if (!hasConnections) {
              break label369;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, connections.size());
            localIterator = connections.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label376;
          }
          HighlightsMiniProfile localHighlightsMiniProfile = (HighlightsMiniProfile)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localHighlightsMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            company.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label194;
          }
          localByteBuffer.put((byte)1);
          localHighlightsMiniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveCompany
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */