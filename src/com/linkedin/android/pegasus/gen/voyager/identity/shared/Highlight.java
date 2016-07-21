package com.linkedin.android.pegasus.gen.voyager.identity.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.NetworkHighlight;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.ProfileHighlight;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Highlight
  implements FissileDataModel<Highlight>, RecordTemplate<Highlight>
{
  public static final HighlightBuilder BUILDER = HighlightBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Detail detail;
  public final boolean hasDetail;
  public final boolean hasHighlightUrn;
  public final boolean hasTrackingId;
  public final Urn highlightUrn;
  public final String trackingId;
  
  Highlight(Detail paramDetail, Urn paramUrn, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    detail = paramDetail;
    highlightUrn = paramUrn;
    trackingId = paramString;
    hasDetail = paramBoolean1;
    hasHighlightUrn = paramBoolean2;
    hasTrackingId = paramBoolean3;
    _cachedId = null;
  }
  
  public final Highlight accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Detail localDetail = null;
    boolean bool = false;
    if (hasDetail)
    {
      paramDataProcessor.startRecordField$505cff1c("detail");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label151;
      }
      localDetail = detail.accept(paramDataProcessor);
      if (localDetail == null) {
        break label168;
      }
    }
    label151:
    label168:
    for (bool = true;; bool = false)
    {
      if (hasHighlightUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("highlightUrn");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(highlightUrn));
      }
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        paramDataProcessor.processString(trackingId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label237;
      }
      try
      {
        if (hasDetail) {
          break label173;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight", "detail");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localDetail = (Detail)paramDataProcessor.processDataTemplate(detail);
      break;
    }
    label173:
    if (!hasHighlightUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight", "highlightUrn");
    }
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight", "trackingId");
    }
    return new Highlight(localDetail, highlightUrn, trackingId, bool, hasHighlightUrn, hasTrackingId);
    label237:
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
      paramObject = (Highlight)paramObject;
      if (detail != null)
      {
        if (detail.equals(detail)) {}
      }
      else {
        while (detail != null) {
          return false;
        }
      }
      if (highlightUrn == null) {
        break;
      }
    } while (highlightUrn.equals(highlightUrn));
    for (;;)
    {
      return false;
      if (highlightUrn == null) {
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
    if (hasDetail) {
      if (detail._cachedId == null) {
        break label115;
      }
    }
    label115:
    for (i = PegasusBinaryUtils.getEncodedLength(detail._cachedId) + 9;; i = detail.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasHighlightUrn)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(highlightUrn));
      }
      j = i + 1;
      i = j;
      if (hasTrackingId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (detail != null) {}
    for (int i = detail.hashCode();; i = 0)
    {
      if (highlightUrn != null) {
        j = highlightUrn.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Highlight");
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
    label204:
    label298:
    label308:
    label316:
    label318:
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
        localByteBuffer.putInt(-849332407);
        if (hasDetail)
        {
          localByteBuffer.put((byte)1);
          if (detail._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, detail._cachedId);
            detail.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasHighlightUrn) {
              break label298;
            }
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(highlightUrn));
            if (!hasTrackingId) {
              break label308;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, trackingId);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label316;
          }
          if (str != null) {
            break label318;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          detail.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label204;
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
  
  public static final class Detail
    implements FissileDataModel<Detail>, UnionTemplate<Detail>
  {
    public static final HighlightBuilder.DetailBuilder BUILDER = HighlightBuilder.DetailBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasNetworkHighlightValue;
    public final boolean hasProfileHighlightValue;
    public final NetworkHighlight networkHighlightValue;
    public final ProfileHighlight profileHighlightValue;
    
    Detail(ProfileHighlight paramProfileHighlight, NetworkHighlight paramNetworkHighlight, boolean paramBoolean1, boolean paramBoolean2)
    {
      profileHighlightValue = paramProfileHighlight;
      networkHighlightValue = paramNetworkHighlight;
      hasProfileHighlightValue = paramBoolean1;
      hasNetworkHighlightValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final Detail accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasProfileHighlightValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.profileHighlights.ProfileHighlight");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = profileHighlightValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label149;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        label56:
        localObject1 = null;
        bool2 = false;
        if (hasNetworkHighlightValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.networkHighlights.NetworkHighlight");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label158;
          }
          localObject1 = networkHighlightValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label176;
          }
        }
      }
      label149:
      label158:
      label176:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label181;
        }
        return new Detail((ProfileHighlight)localObject2, (NetworkHighlight)localObject1, bool1, bool2);
        localObject1 = (ProfileHighlight)paramDataProcessor.processDataTemplate(profileHighlightValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (NetworkHighlight)paramDataProcessor.processDataTemplate(networkHighlightValue);
        break label95;
      }
      label181:
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
        paramObject = (Detail)paramObject;
        if (profileHighlightValue != null)
        {
          if (profileHighlightValue.equals(profileHighlightValue)) {}
        }
        else {
          while (profileHighlightValue != null) {
            return false;
          }
        }
        if (networkHighlightValue == null) {
          break;
        }
      } while (networkHighlightValue.equals(networkHighlightValue));
      for (;;)
      {
        return false;
        if (networkHighlightValue == null) {
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
      if (hasProfileHighlightValue)
      {
        if (profileHighlightValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(profileHighlightValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasNetworkHighlightValue)
        {
          i = j + 1;
          if (networkHighlightValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(networkHighlightValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = profileHighlightValue.getSerializedSize() + 7;
        break;
        label114:
        i += networkHighlightValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (profileHighlightValue != null) {}
      for (int i = profileHighlightValue.hashCode();; i = 0)
      {
        if (networkHighlightValue != null) {
          j = networkHighlightValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Detail");
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
      label298:
      label323:
      label331:
      label333:
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
          localByteBuffer.putInt(-1140694555);
          if (hasProfileHighlightValue)
          {
            localByteBuffer.put((byte)1);
            if (profileHighlightValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, profileHighlightValue._cachedId);
              profileHighlightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasNetworkHighlightValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (networkHighlightValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, networkHighlightValue._cachedId);
              networkHighlightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label331;
            }
            if (str != null) {
              break label333;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            profileHighlightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            networkHighlightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */