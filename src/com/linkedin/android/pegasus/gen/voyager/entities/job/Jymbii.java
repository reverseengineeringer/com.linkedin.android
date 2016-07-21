package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Jymbii
  implements FissileDataModel<Jymbii>, RecordTemplate<Jymbii>
{
  public static final JymbiiBuilder BUILDER = JymbiiBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasJymbiiUpdate;
  public final boolean hasLinkedInApplication;
  public final boolean hasObjectUrn;
  public final boolean hasSponsored;
  public final boolean hasTrackingId;
  public final JymbiiUpdate jymbiiUpdate;
  public final boolean linkedInApplication;
  public final Urn objectUrn;
  public final boolean sponsored;
  public final String trackingId;
  
  Jymbii(boolean paramBoolean1, String paramString, Urn paramUrn, JymbiiUpdate paramJymbiiUpdate, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    sponsored = paramBoolean1;
    trackingId = paramString;
    objectUrn = paramUrn;
    jymbiiUpdate = paramJymbiiUpdate;
    linkedInApplication = paramBoolean2;
    hasSponsored = paramBoolean3;
    hasTrackingId = paramBoolean4;
    hasObjectUrn = paramBoolean5;
    hasJymbiiUpdate = paramBoolean6;
    hasLinkedInApplication = paramBoolean7;
    _cachedId = null;
  }
  
  private Jymbii accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasSponsored)
    {
      paramDataProcessor.startRecordField$505cff1c("sponsored");
      paramDataProcessor.processBoolean(sponsored);
    }
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    if (hasObjectUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("objectUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(objectUrn));
    }
    Object localObject = null;
    boolean bool = false;
    if (hasJymbiiUpdate)
    {
      paramDataProcessor.startRecordField$505cff1c("jymbiiUpdate");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label200;
      }
      localObject = jymbiiUpdate.accept(paramDataProcessor);
      if (localObject == null) {
        break label217;
      }
    }
    label200:
    label217:
    for (bool = true;; bool = false)
    {
      if (hasLinkedInApplication)
      {
        paramDataProcessor.startRecordField$505cff1c("linkedInApplication");
        paramDataProcessor.processBoolean(linkedInApplication);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label321;
      }
      try
      {
        if (hasSponsored) {
          break label222;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.Jymbii", "sponsored");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (JymbiiUpdate)paramDataProcessor.processDataTemplate(jymbiiUpdate);
      break;
    }
    label222:
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.Jymbii", "trackingId");
    }
    if (!hasObjectUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.Jymbii", "objectUrn");
    }
    if (!hasJymbiiUpdate) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.Jymbii", "jymbiiUpdate");
    }
    return new Jymbii(sponsored, trackingId, objectUrn, (JymbiiUpdate)localObject, linkedInApplication, hasSponsored, hasTrackingId, hasObjectUrn, bool, hasLinkedInApplication);
    label321:
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
      paramObject = (Jymbii)paramObject;
      if (sponsored != sponsored) {
        return false;
      }
      if (objectUrn != null)
      {
        if (objectUrn.equals(objectUrn)) {}
      }
      else {
        while (objectUrn != null) {
          return false;
        }
      }
      if (jymbiiUpdate != null)
      {
        if (jymbiiUpdate.equals(jymbiiUpdate)) {}
      }
      else {
        while (jymbiiUpdate != null) {
          return false;
        }
      }
    } while (linkedInApplication == linkedInApplication);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasSponsored) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasTrackingId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
    }
    j = i + 1;
    i = j;
    if (hasObjectUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(objectUrn));
    }
    j = i + 1;
    i = j;
    if (hasJymbiiUpdate)
    {
      i = j + 1;
      if (jymbiiUpdate._cachedId == null) {
        break label156;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(jymbiiUpdate._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasLinkedInApplication) {
        i = j + 1;
      }
      __sizeOfObject = i;
      return i;
      label156:
      i += jymbiiUpdate.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 1;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label39:
    int k;
    if (sponsored)
    {
      i = 1;
      if (objectUrn == null) {
        break label95;
      }
      j = objectUrn.hashCode();
      if (jymbiiUpdate == null) {
        break label100;
      }
      k = jymbiiUpdate.hashCode();
      label54:
      if (!linkedInApplication) {
        break label105;
      }
    }
    for (;;)
    {
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      label95:
      j = 0;
      break label39;
      label100:
      k = 0;
      break label54;
      label105:
      m = 0;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Jymbii");
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
    label143:
    label169:
    label203:
    label263:
    label287:
    label345:
    label355:
    label365:
    label390:
    label400:
    label406:
    label414:
    label416:
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
        localByteBuffer.putInt(1887601072);
        if (hasSponsored)
        {
          localByteBuffer.put((byte)1);
          if (sponsored)
          {
            i = 1;
            localByteBuffer.put((byte)i);
            if (!hasTrackingId) {
              break label345;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, trackingId);
            if (!hasObjectUrn) {
              break label355;
            }
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
            if (!hasJymbiiUpdate) {
              break label390;
            }
            localByteBuffer.put((byte)1);
            if (jymbiiUpdate._cachedId == null) {
              break label365;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, jymbiiUpdate._cachedId);
            jymbiiUpdate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasLinkedInApplication) {
              break label406;
            }
            localByteBuffer.put((byte)1);
            if (!linkedInApplication) {
              break label400;
            }
            i = 1;
            localByteBuffer.put((byte)i);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label414;
          }
          if (str != null) {
            break label416;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          i = 0;
          break;
          localByteBuffer.put((byte)0);
          break label143;
          localByteBuffer.put((byte)0);
          break label169;
          localByteBuffer.put((byte)0);
          break label203;
          localByteBuffer.put((byte)1);
          jymbiiUpdate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label263;
          localByteBuffer.put((byte)0);
          break label263;
          i = 0;
          break label287;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.Jymbii
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */