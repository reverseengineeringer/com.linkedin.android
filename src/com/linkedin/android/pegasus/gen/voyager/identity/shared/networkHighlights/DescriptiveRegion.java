package com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.EnrichedLocation;
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

public final class DescriptiveRegion
  implements FissileDataModel<DescriptiveRegion>, RecordTemplate<DescriptiveRegion>
{
  public static final DescriptiveRegionBuilder BUILDER = DescriptiveRegionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<HighlightsMiniProfile> connections;
  public final boolean hasConnections;
  public final boolean hasLocation;
  public final boolean hasLocationName;
  public final boolean hasNumConnections;
  public final EnrichedLocation location;
  public final String locationName;
  public final int numConnections;
  
  DescriptiveRegion(EnrichedLocation paramEnrichedLocation, String paramString, int paramInt, List<HighlightsMiniProfile> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    location = paramEnrichedLocation;
    locationName = paramString;
    numConnections = paramInt;
    if (paramList == null) {}
    for (paramEnrichedLocation = null;; paramEnrichedLocation = Collections.unmodifiableList(paramList))
    {
      connections = paramEnrichedLocation;
      hasLocation = paramBoolean1;
      hasLocationName = paramBoolean2;
      hasNumConnections = paramBoolean3;
      hasConnections = paramBoolean4;
      _cachedId = null;
      return;
    }
  }
  
  public final DescriptiveRegion accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    int i;
    if (hasLocation)
    {
      paramDataProcessor.startRecordField$505cff1c("location");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = location.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label272;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasLocationName)
      {
        paramDataProcessor.startRecordField$505cff1c("locationName");
        paramDataProcessor.processString(locationName);
      }
      if (hasNumConnections)
      {
        paramDataProcessor.startRecordField$505cff1c("numConnections");
        paramDataProcessor.processInt(numConnections);
      }
      localObject1 = null;
      localHighlightsMiniProfile = null;
      bool2 = false;
      if (!hasConnections) {
        break label311;
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
      label181:
      if (!localIterator.hasNext()) {
        break label297;
      }
      localHighlightsMiniProfile = (HighlightsMiniProfile)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label281;
      }
    }
    label272:
    label281:
    for (HighlightsMiniProfile localHighlightsMiniProfile = localHighlightsMiniProfile.accept(paramDataProcessor);; localHighlightsMiniProfile = (HighlightsMiniProfile)paramDataProcessor.processDataTemplate(localHighlightsMiniProfile))
    {
      if ((localObject1 != null) && (localHighlightsMiniProfile != null)) {
        ((List)localObject1).add(localHighlightsMiniProfile);
      }
      i += 1;
      break label181;
      localObject1 = (EnrichedLocation)paramDataProcessor.processDataTemplate(location);
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
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label473;
      }
      if (!hasConnections) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasLocation) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveRegion", "location");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasNumConnections) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveRegion", "numConnections");
    }
    if (connections != null)
    {
      paramDataProcessor = connections.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((HighlightsMiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveRegion", "connections");
        }
      }
    }
    return new DescriptiveRegion((EnrichedLocation)localObject2, locationName, numConnections, (List)localObject1, bool1, hasLocationName, hasNumConnections, bool2);
    label473:
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
      paramObject = (DescriptiveRegion)paramObject;
      if (location != null)
      {
        if (location.equals(location)) {}
      }
      else {
        while (location != null) {
          return false;
        }
      }
      if (locationName != null)
      {
        if (locationName.equals(locationName)) {}
      }
      else {
        while (locationName != null) {
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
    if (hasLocation)
    {
      if (location._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(location._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasLocationName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(locationName);
      }
      j = i + 1;
      i = j;
      if (hasNumConnections) {
        i = j + 4;
      }
      i += 1;
      j = i;
      if (!hasConnections) {
        break label195;
      }
      i += 2;
      localIterator = connections.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label195;
      }
      HighlightsMiniProfile localHighlightsMiniProfile = (HighlightsMiniProfile)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = location.getSerializedSize() + 7;
        break;
      }
      i += localHighlightsMiniProfile.getSerializedSize();
    }
    label195:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (location != null)
    {
      i = location.hashCode();
      if (locationName == null) {
        break label101;
      }
    }
    label101:
    for (int j = locationName.hashCode();; j = 0)
    {
      int m = numConnections;
      if (connections != null) {
        k = connections.hashCode();
      }
      i = ((j + (i + 527) * 31) * 31 + m) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building DescriptiveRegion");
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
    label196:
    label220:
    label362:
    label372:
    label405:
    label412:
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
        localByteBuffer.putInt(792136440);
        Iterator localIterator;
        if (hasLocation)
        {
          localByteBuffer.put((byte)1);
          if (location._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, location._cachedId);
            location.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasLocationName) {
              break label362;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, locationName);
            if (!hasNumConnections) {
              break label372;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(numConnections);
            if (!hasConnections) {
              break label405;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, connections.size());
            localIterator = connections.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label412;
          }
          HighlightsMiniProfile localHighlightsMiniProfile = (HighlightsMiniProfile)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localHighlightsMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            location.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label196;
            localByteBuffer.put((byte)0);
            break label220;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.DescriptiveRegion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */