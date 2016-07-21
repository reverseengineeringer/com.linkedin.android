package com.linkedin.android.pegasus.gen.voyager.common;

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

public final class LaunchAlert
  implements FissileDataModel<LaunchAlert>, RecordTemplate<LaunchAlert>
{
  public static final LaunchAlertBuilder BUILDER = LaunchAlertBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasLabelForAction;
  public final boolean hasLabelForCancel;
  public final boolean hasLink;
  public final boolean hasMessage;
  public final boolean hasTitle;
  public final String labelForAction;
  public final String labelForCancel;
  public final String link;
  public final String message;
  public final String title;
  
  LaunchAlert(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    title = paramString1;
    message = paramString2;
    link = paramString3;
    labelForAction = paramString4;
    labelForCancel = paramString5;
    hasTitle = paramBoolean1;
    hasMessage = paramBoolean2;
    hasLink = paramBoolean3;
    hasLabelForAction = paramBoolean4;
    hasLabelForCancel = paramBoolean5;
    _cachedId = null;
  }
  
  public final LaunchAlert accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasMessage)
    {
      paramDataProcessor.startRecordField$505cff1c("message");
      paramDataProcessor.processString(message);
    }
    if (hasLink)
    {
      paramDataProcessor.startRecordField$505cff1c("link");
      paramDataProcessor.processString(link);
    }
    if (hasLabelForAction)
    {
      paramDataProcessor.startRecordField$505cff1c("labelForAction");
      paramDataProcessor.processString(labelForAction);
    }
    if (hasLabelForCancel)
    {
      paramDataProcessor.startRecordField$505cff1c("labelForCancel");
      paramDataProcessor.processString(labelForCancel);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasTitle) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.LaunchAlert", "title");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasMessage) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.LaunchAlert", "message");
      }
      return new LaunchAlert(title, message, link, labelForAction, labelForCancel, hasTitle, hasMessage, hasLink, hasLabelForAction, hasLabelForCancel);
    }
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
      paramObject = (LaunchAlert)paramObject;
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (message != null)
      {
        if (message.equals(message)) {}
      }
      else {
        while (message != null) {
          return false;
        }
      }
      if (link != null)
      {
        if (link.equals(link)) {}
      }
      else {
        while (link != null) {
          return false;
        }
      }
      if (labelForAction != null)
      {
        if (labelForAction.equals(labelForAction)) {}
      }
      else {
        while (labelForAction != null) {
          return false;
        }
      }
      if (labelForCancel == null) {
        break;
      }
    } while (labelForCancel.equals(labelForCancel));
    for (;;)
    {
      return false;
      if (labelForCancel == null) {
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
    if (hasTitle) {
      i = PegasusBinaryUtils.getEncodedLength(title) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasMessage) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(message);
    }
    j = i + 1;
    i = j;
    if (hasLink) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(link);
    }
    j = i + 1;
    i = j;
    if (hasLabelForAction) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(labelForAction);
    }
    j = i + 1;
    i = j;
    if (hasLabelForCancel) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(labelForCancel);
    }
    __sizeOfObject = i;
    return i;
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
    if (title != null)
    {
      i = title.hashCode();
      if (message == null) {
        break label132;
      }
      j = message.hashCode();
      if (link == null) {
        break label137;
      }
      k = link.hashCode();
      label60:
      if (labelForAction == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = labelForAction.hashCode();; m = 0)
    {
      if (labelForCancel != null) {
        n = labelForCancel.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building LaunchAlert");
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
    label214:
    label283:
    label293:
    label303:
    label313:
    label321:
    label323:
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
        localByteBuffer.putInt(725870082);
        if (hasTitle)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasMessage) {
            break label283;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, message);
          if (!hasLink) {
            break label293;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, link);
          if (!hasLabelForAction) {
            break label303;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, labelForAction);
          if (!hasLabelForCancel) {
            break label313;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, labelForCancel);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label321;
          }
          if (str != null) {
            break label323;
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
          localByteBuffer.put((byte)0);
          break label214;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.LaunchAlert
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */