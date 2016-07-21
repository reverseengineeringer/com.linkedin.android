package com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail;

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

public final class SpInmailLeadGenSubContent
  implements FissileDataModel<SpInmailLeadGenSubContent>, RecordTemplate<SpInmailLeadGenSubContent>
{
  public static final SpInmailLeadGenSubContentBuilder BUILDER = SpInmailLeadGenSubContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String actionText;
  public final SpInmailAdUnit adUnit;
  public final String afterActionText;
  public final boolean hasActionText;
  public final boolean hasAdUnit;
  public final boolean hasAfterActionText;
  public final boolean hasLeadGenInterestedTracking;
  public final boolean hasLeadGenSharedEmailTracking;
  public final String leadGenInterestedTracking;
  public final String leadGenSharedEmailTracking;
  
  SpInmailLeadGenSubContent(String paramString1, String paramString2, SpInmailAdUnit paramSpInmailAdUnit, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    actionText = paramString1;
    afterActionText = paramString2;
    adUnit = paramSpInmailAdUnit;
    leadGenInterestedTracking = paramString3;
    leadGenSharedEmailTracking = paramString4;
    hasActionText = paramBoolean1;
    hasAfterActionText = paramBoolean2;
    hasAdUnit = paramBoolean3;
    hasLeadGenInterestedTracking = paramBoolean4;
    hasLeadGenSharedEmailTracking = paramBoolean5;
    _cachedId = null;
  }
  
  public final SpInmailLeadGenSubContent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasActionText)
    {
      paramDataProcessor.startRecordField$505cff1c("actionText");
      paramDataProcessor.processString(actionText);
    }
    if (hasAfterActionText)
    {
      paramDataProcessor.startRecordField$505cff1c("afterActionText");
      paramDataProcessor.processString(afterActionText);
    }
    SpInmailAdUnit localSpInmailAdUnit = null;
    boolean bool = false;
    if (hasAdUnit)
    {
      paramDataProcessor.startRecordField$505cff1c("adUnit");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label193;
      }
      localSpInmailAdUnit = adUnit.accept(paramDataProcessor);
      if (localSpInmailAdUnit == null) {
        break label210;
      }
    }
    label193:
    label210:
    for (bool = true;; bool = false)
    {
      if (hasLeadGenInterestedTracking)
      {
        paramDataProcessor.startRecordField$505cff1c("leadGenInterestedTracking");
        paramDataProcessor.processString(leadGenInterestedTracking);
      }
      if (hasLeadGenSharedEmailTracking)
      {
        paramDataProcessor.startRecordField$505cff1c("leadGenSharedEmailTracking");
        paramDataProcessor.processString(leadGenSharedEmailTracking);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label257;
      }
      try
      {
        if (hasActionText) {
          break label215;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailLeadGenSubContent", "actionText");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localSpInmailAdUnit = (SpInmailAdUnit)paramDataProcessor.processDataTemplate(adUnit);
      break;
    }
    label215:
    return new SpInmailLeadGenSubContent(actionText, afterActionText, localSpInmailAdUnit, leadGenInterestedTracking, leadGenSharedEmailTracking, hasActionText, hasAfterActionText, bool, hasLeadGenInterestedTracking, hasLeadGenSharedEmailTracking);
    label257:
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
      paramObject = (SpInmailLeadGenSubContent)paramObject;
      if (actionText != null)
      {
        if (actionText.equals(actionText)) {}
      }
      else {
        while (actionText != null) {
          return false;
        }
      }
      if (afterActionText != null)
      {
        if (afterActionText.equals(afterActionText)) {}
      }
      else {
        while (afterActionText != null) {
          return false;
        }
      }
      if (adUnit != null)
      {
        if (adUnit.equals(adUnit)) {}
      }
      else {
        while (adUnit != null) {
          return false;
        }
      }
      if (leadGenInterestedTracking != null)
      {
        if (leadGenInterestedTracking.equals(leadGenInterestedTracking)) {}
      }
      else {
        while (leadGenInterestedTracking != null) {
          return false;
        }
      }
      if (leadGenSharedEmailTracking == null) {
        break;
      }
    } while (leadGenSharedEmailTracking.equals(leadGenSharedEmailTracking));
    for (;;)
    {
      return false;
      if (leadGenSharedEmailTracking == null) {
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
    if (hasActionText) {
      i = PegasusBinaryUtils.getEncodedLength(actionText) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasAfterActionText) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(afterActionText);
    }
    j = i + 1;
    i = j;
    if (hasAdUnit)
    {
      i = j + 1;
      if (adUnit._cachedId == null) {
        break label162;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(adUnit._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasLeadGenInterestedTracking) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(leadGenInterestedTracking);
      }
      j = i + 1;
      i = j;
      if (hasLeadGenSharedEmailTracking) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(leadGenSharedEmailTracking);
      }
      __sizeOfObject = i;
      return i;
      label162:
      i += adUnit.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (actionText != null)
    {
      i = actionText.hashCode();
      if (afterActionText == null) {
        break label132;
      }
      j = afterActionText.hashCode();
      if (adUnit == null) {
        break label137;
      }
      k = adUnit.hashCode();
      label60:
      if (leadGenInterestedTracking == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = leadGenInterestedTracking.hashCode();; m = 0)
    {
      if (leadGenSharedEmailTracking != null) {
        n = leadGenSharedEmailTracking.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SpInmailLeadGenSubContent");
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
    label162:
    label222:
    label248:
    label317:
    label327:
    label352:
    label362:
    label372:
    label380:
    label382:
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
        localByteBuffer.putInt(1795947826);
        if (hasActionText)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, actionText);
          if (!hasAfterActionText) {
            break label317;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, afterActionText);
          if (!hasAdUnit) {
            break label352;
          }
          localByteBuffer.put((byte)1);
          if (adUnit._cachedId == null) {
            break label327;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, adUnit._cachedId);
          adUnit.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasLeadGenInterestedTracking) {
            break label362;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, leadGenInterestedTracking);
          if (!hasLeadGenSharedEmailTracking) {
            break label372;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, leadGenSharedEmailTracking);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label380;
          }
          if (str != null) {
            break label382;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)1);
          adUnit.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label222;
          localByteBuffer.put((byte)0);
          break label222;
          localByteBuffer.put((byte)0);
          break label248;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailLeadGenSubContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */