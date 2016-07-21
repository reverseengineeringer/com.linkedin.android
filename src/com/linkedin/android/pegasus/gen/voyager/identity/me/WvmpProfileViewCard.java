package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class WvmpProfileViewCard
  implements FissileDataModel<WvmpProfileViewCard>, RecordTemplate<WvmpProfileViewCard>
{
  public static final WvmpProfileViewCardBuilder BUILDER = WvmpProfileViewCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasInsight;
  public final boolean hasPendingInvitee;
  public final boolean hasReferrer;
  public final boolean hasViewedAt;
  public final boolean hasViewer;
  public final Insight insight;
  public final boolean pendingInvitee;
  public final String referrer;
  public final long viewedAt;
  public final ProfileViewer viewer;
  
  WvmpProfileViewCard(long paramLong, ProfileViewer paramProfileViewer, Insight paramInsight, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    viewedAt = paramLong;
    viewer = paramProfileViewer;
    insight = paramInsight;
    referrer = paramString;
    pendingInvitee = paramBoolean1;
    hasViewedAt = paramBoolean2;
    hasViewer = paramBoolean3;
    hasInsight = paramBoolean4;
    hasReferrer = paramBoolean5;
    hasPendingInvitee = paramBoolean6;
    _cachedId = null;
  }
  
  public final WvmpProfileViewCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasViewedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("viewedAt");
      paramDataProcessor.processLong(viewedAt);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasViewer)
    {
      paramDataProcessor.startRecordField$505cff1c("viewer");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = viewer.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label239;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label81:
      localObject1 = null;
      bool2 = false;
      if (hasInsight)
      {
        paramDataProcessor.startRecordField$505cff1c("insight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label248;
        }
        localObject1 = insight.accept(paramDataProcessor);
        label120:
        if (localObject1 == null) {
          break label266;
        }
      }
    }
    label239:
    label248:
    label266:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasReferrer)
      {
        paramDataProcessor.startRecordField$505cff1c("referrer");
        paramDataProcessor.processString(referrer);
      }
      if (hasPendingInvitee)
      {
        paramDataProcessor.startRecordField$505cff1c("pendingInvitee");
        paramDataProcessor.processBoolean(pendingInvitee);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label328;
      }
      try
      {
        if (hasViewedAt) {
          break label271;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpProfileViewCard", "viewedAt");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (ProfileViewer)paramDataProcessor.processDataTemplate(viewer);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
      localObject1 = (Insight)paramDataProcessor.processDataTemplate(insight);
      break label120;
    }
    label271:
    if (!hasViewer) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpProfileViewCard", "viewer");
    }
    return new WvmpProfileViewCard(viewedAt, (ProfileViewer)localObject2, (Insight)localObject1, referrer, pendingInvitee, hasViewedAt, bool1, bool2, hasReferrer, hasPendingInvitee);
    label328:
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
      paramObject = (WvmpProfileViewCard)paramObject;
      if (viewedAt != viewedAt) {
        return false;
      }
      if (viewer != null)
      {
        if (viewer.equals(viewer)) {}
      }
      else {
        while (viewer != null) {
          return false;
        }
      }
      if (insight != null)
      {
        if (insight.equals(insight)) {}
      }
      else {
        while (insight != null) {
          return false;
        }
      }
      if (referrer != null)
      {
        if (referrer.equals(referrer)) {}
      }
      else {
        while (referrer != null) {
          return false;
        }
      }
    } while (pendingInvitee == pendingInvitee);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasViewedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasViewer)
    {
      i = j + 1;
      if (viewer._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(viewer._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasInsight)
      {
        i = j + 1;
        if (insight._cachedId == null) {
          break label180;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(insight._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasReferrer) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(referrer);
      }
      j = i + 1;
      i = j;
      if (hasPendingInvitee) {
        i = j + 1;
      }
      __sizeOfObject = i;
      return i;
      i += viewer.getSerializedSize();
      break;
      label180:
      i += insight.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int n = (int)(viewedAt ^ viewedAt >>> 32);
    int i;
    int j;
    if (viewer != null)
    {
      i = viewer.hashCode();
      if (insight == null) {
        break label125;
      }
      j = insight.hashCode();
      label60:
      if (referrer == null) {
        break label130;
      }
    }
    label125:
    label130:
    for (int k = referrer.hashCode();; k = 0)
    {
      if (pendingInvitee) {
        m = 1;
      }
      i = (k + (j + (i + (n + 527) * 31) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WvmpProfileViewCard");
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
    label254:
    label280:
    label304:
    label356:
    label381:
    label391:
    label416:
    label426:
    label436:
    label442:
    label450:
    label452:
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
        localByteBuffer.putInt(1712841196);
        if (hasViewedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(viewedAt);
          if (!hasViewer) {
            break label381;
          }
          localByteBuffer.put((byte)1);
          if (viewer._cachedId == null) {
            break label356;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, viewer._cachedId);
          viewer.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasInsight) {
            break label416;
          }
          localByteBuffer.put((byte)1);
          if (insight._cachedId == null) {
            break label391;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, insight._cachedId);
          insight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasReferrer) {
            break label426;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, referrer);
          if (!hasPendingInvitee) {
            break label442;
          }
          localByteBuffer.put((byte)1);
          if (!pendingInvitee) {
            break label436;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label450;
          }
          if (str != null) {
            break label452;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          viewer.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label194;
          localByteBuffer.put((byte)0);
          break label194;
          localByteBuffer.put((byte)1);
          insight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label254;
          localByteBuffer.put((byte)0);
          break label254;
          localByteBuffer.put((byte)0);
          break label280;
          i = 0;
          break label304;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpProfileViewCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */