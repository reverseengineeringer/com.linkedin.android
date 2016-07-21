package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SuggestedEndorsementReasonExpert
  implements FissileDataModel<SuggestedEndorsementReasonExpert>, RecordTemplate<SuggestedEndorsementReasonExpert>
{
  public static final SuggestedEndorsementReasonExpertBuilder BUILDER = SuggestedEndorsementReasonExpertBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasHighlight;
  public final Highlight highlight;
  
  SuggestedEndorsementReasonExpert(Highlight paramHighlight, boolean paramBoolean)
  {
    highlight = paramHighlight;
    hasHighlight = paramBoolean;
    _cachedId = null;
  }
  
  public final SuggestedEndorsementReasonExpert accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Highlight localHighlight = null;
    boolean bool = false;
    if (hasHighlight)
    {
      paramDataProcessor.startRecordField$505cff1c("highlight");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label74;
      }
      localHighlight = highlight.accept(paramDataProcessor);
      if (localHighlight == null) {
        break label91;
      }
    }
    label74:
    label91:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label96;
      }
      return new SuggestedEndorsementReasonExpert(localHighlight, bool);
      localHighlight = (Highlight)paramDataProcessor.processDataTemplate(highlight);
      break;
    }
    label96:
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
      paramObject = (SuggestedEndorsementReasonExpert)paramObject;
      if (highlight == null) {
        break;
      }
    } while (highlight.equals(highlight));
    for (;;)
    {
      return false;
      if (highlight == null) {
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
    if (hasHighlight) {
      if (highlight._cachedId == null) {
        break label58;
      }
    }
    label58:
    for (i = PegasusBinaryUtils.getEncodedLength(highlight._cachedId) + 9;; i = highlight.getSerializedSize() + 7)
    {
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (highlight != null) {}
    for (int i = highlight.hashCode();; i = 0)
    {
      i += 527;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SuggestedEndorsementReasonExpert");
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
    label238:
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
        localByteBuffer.putInt(793305103);
        if (hasHighlight)
        {
          localByteBuffer.put((byte)1);
          if (highlight._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, highlight._cachedId);
            highlight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label238;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          highlight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.SuggestedEndorsementReasonExpert
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */