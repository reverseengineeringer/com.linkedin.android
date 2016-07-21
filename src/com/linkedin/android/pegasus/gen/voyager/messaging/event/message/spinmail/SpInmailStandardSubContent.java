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

public final class SpInmailStandardSubContent
  implements FissileDataModel<SpInmailStandardSubContent>, RecordTemplate<SpInmailStandardSubContent>
{
  public static final SpInmailStandardSubContentBuilder BUILDER = SpInmailStandardSubContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String action;
  public final String actionText;
  public final String actionTracking;
  public final SpInmailAdUnit adUnit;
  public final boolean hasAction;
  public final boolean hasActionText;
  public final boolean hasActionTracking;
  public final boolean hasAdUnit;
  
  SpInmailStandardSubContent(String paramString1, String paramString2, String paramString3, SpInmailAdUnit paramSpInmailAdUnit, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    actionText = paramString1;
    action = paramString2;
    actionTracking = paramString3;
    adUnit = paramSpInmailAdUnit;
    hasActionText = paramBoolean1;
    hasAction = paramBoolean2;
    hasActionTracking = paramBoolean3;
    hasAdUnit = paramBoolean4;
    _cachedId = null;
  }
  
  public final SpInmailStandardSubContent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasActionText)
    {
      paramDataProcessor.startRecordField$505cff1c("actionText");
      paramDataProcessor.processString(actionText);
    }
    if (hasAction)
    {
      paramDataProcessor.startRecordField$505cff1c("action");
      paramDataProcessor.processString(action);
    }
    if (hasActionTracking)
    {
      paramDataProcessor.startRecordField$505cff1c("actionTracking");
      paramDataProcessor.processString(actionTracking);
    }
    SpInmailAdUnit localSpInmailAdUnit = null;
    boolean bool = false;
    if (hasAdUnit)
    {
      paramDataProcessor.startRecordField$505cff1c("adUnit");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label168;
      }
      localSpInmailAdUnit = adUnit.accept(paramDataProcessor);
      if (localSpInmailAdUnit == null) {
        break label185;
      }
    }
    label168:
    label185:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label262;
      }
      try
      {
        if (hasActionText) {
          break label190;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent", "actionText");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localSpInmailAdUnit = (SpInmailAdUnit)paramDataProcessor.processDataTemplate(adUnit);
      break;
    }
    label190:
    if (!hasAction) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent", "action");
    }
    if (!hasActionTracking) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent", "actionTracking");
    }
    return new SpInmailStandardSubContent(actionText, action, actionTracking, localSpInmailAdUnit, hasActionText, hasAction, hasActionTracking, bool);
    label262:
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
      paramObject = (SpInmailStandardSubContent)paramObject;
      if (actionText != null)
      {
        if (actionText.equals(actionText)) {}
      }
      else {
        while (actionText != null) {
          return false;
        }
      }
      if (action != null)
      {
        if (action.equals(action)) {}
      }
      else {
        while (action != null) {
          return false;
        }
      }
      if (actionTracking != null)
      {
        if (actionTracking.equals(actionTracking)) {}
      }
      else {
        while (actionTracking != null) {
          return false;
        }
      }
      if (adUnit == null) {
        break;
      }
    } while (adUnit.equals(adUnit));
    for (;;)
    {
      return false;
      if (adUnit == null) {
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
    if (hasAction) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(action);
    }
    j = i + 1;
    i = j;
    if (hasActionTracking) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(actionTracking);
    }
    j = i + 1;
    i = j;
    if (hasAdUnit)
    {
      i = j + 1;
      if (adUnit._cachedId == null) {
        break label137;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(adUnit._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label137:
      i += adUnit.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (actionText != null)
    {
      i = actionText.hashCode();
      if (action == null) {
        break label110;
      }
      j = action.hashCode();
      label45:
      if (actionTracking == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = actionTracking.hashCode();; k = 0)
    {
      if (adUnit != null) {
        m = adUnit.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SpInmailStandardSubContent");
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
    label188:
    label291:
    label301:
    label311:
    label336:
    label344:
    label346:
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
        localByteBuffer.putInt(440064875);
        if (hasActionText)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, actionText);
          if (!hasAction) {
            break label291;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, action);
          if (!hasActionTracking) {
            break label301;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, actionTracking);
          if (!hasAdUnit) {
            break label336;
          }
          localByteBuffer.put((byte)1);
          if (adUnit._cachedId == null) {
            break label311;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, adUnit._cachedId);
          adUnit.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label344;
          }
          if (str != null) {
            break label346;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)0);
          break label188;
          localByteBuffer.put((byte)1);
          adUnit.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */