package com.linkedin.android.pegasus.gen.voyager.messaging.event;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.common.File;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.CustomContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.message.ShareContent;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MessageEvent
  implements FissileDataModel<MessageEvent>, RecordTemplate<MessageEvent>
{
  public static final MessageEventBuilder BUILDER = MessageEventBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<File> attachments;
  public final AttributedText attributedBody;
  public final String body;
  public final CustomContent customContent;
  public final boolean hasAttachments;
  public final boolean hasAttributedBody;
  public final boolean hasBody;
  public final boolean hasCustomContent;
  public final boolean hasShareContent;
  public final boolean hasSubject;
  public final ShareContent shareContent;
  public final String subject;
  
  MessageEvent(String paramString1, String paramString2, List<File> paramList, CustomContent paramCustomContent, ShareContent paramShareContent, AttributedText paramAttributedText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    body = paramString1;
    subject = paramString2;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      attachments = paramString1;
      customContent = paramCustomContent;
      shareContent = paramShareContent;
      attributedBody = paramAttributedText;
      hasBody = paramBoolean1;
      hasSubject = paramBoolean2;
      hasAttachments = paramBoolean3;
      hasCustomContent = paramBoolean4;
      hasShareContent = paramBoolean5;
      hasAttributedBody = paramBoolean6;
      _cachedId = null;
      return;
    }
  }
  
  public final MessageEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasBody)
    {
      paramDataProcessor.startRecordField$505cff1c("body");
      paramDataProcessor.processString(body);
    }
    if (hasSubject)
    {
      paramDataProcessor.startRecordField$505cff1c("subject");
      paramDataProcessor.processString(subject);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject3;
    boolean bool2;
    label272:
    label284:
    Object localObject4;
    boolean bool3;
    if (hasAttachments)
    {
      paramDataProcessor.startRecordField$505cff1c("attachments");
      attachments.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localObject3 = attachments.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (File)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((File)localObject2).accept(paramDataProcessor);; localObject2 = (File)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null) {
        bool1 = true;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasCustomContent)
      {
        paramDataProcessor.startRecordField$505cff1c("customContent");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label445;
        }
        localObject2 = customContent.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label463;
        }
        bool2 = true;
        localObject3 = localObject2;
      }
      localObject4 = null;
      bool3 = false;
      if (hasShareContent)
      {
        paramDataProcessor.startRecordField$505cff1c("shareContent");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label473;
        }
        localObject2 = shareContent.accept(paramDataProcessor);
        label324:
        if (localObject2 == null) {
          break label491;
        }
        bool3 = true;
        localObject4 = localObject2;
      }
      label336:
      localObject2 = null;
      bool4 = false;
      if (hasAttributedBody)
      {
        paramDataProcessor.startRecordField$505cff1c("attributedBody");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label501;
        }
        localObject2 = attributedBody.accept(paramDataProcessor);
        label376:
        if (localObject2 == null) {
          break label519;
        }
      }
    }
    label445:
    label463:
    label473:
    label491:
    label501:
    label519:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label614;
      }
      if (!hasAttachments) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasBody) {
          break label525;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.MessageEvent", "body");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      break;
      localObject2 = (CustomContent)paramDataProcessor.processDataTemplate(customContent);
      break label272;
      bool2 = false;
      localObject3 = localObject2;
      break label284;
      localObject2 = (ShareContent)paramDataProcessor.processDataTemplate(shareContent);
      break label324;
      bool3 = false;
      localObject4 = localObject2;
      break label336;
      localObject2 = (AttributedText)paramDataProcessor.processDataTemplate(attributedBody);
      break label376;
    }
    label525:
    if (attachments != null)
    {
      paramDataProcessor = attachments.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((File)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.event.MessageEvent", "attachments");
        }
      }
    }
    return new MessageEvent(body, subject, (List)localObject1, (CustomContent)localObject3, (ShareContent)localObject4, (AttributedText)localObject2, hasBody, hasSubject, bool1, bool2, bool3, bool4);
    label614:
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
      paramObject = (MessageEvent)paramObject;
      if (body != null)
      {
        if (body.equals(body)) {}
      }
      else {
        while (body != null) {
          return false;
        }
      }
      if (subject != null)
      {
        if (subject.equals(subject)) {}
      }
      else {
        while (subject != null) {
          return false;
        }
      }
      if (attachments != null)
      {
        if (attachments.equals(attachments)) {}
      }
      else {
        while (attachments != null) {
          return false;
        }
      }
      if (customContent != null)
      {
        if (customContent.equals(customContent)) {}
      }
      else {
        while (customContent != null) {
          return false;
        }
      }
      if (shareContent != null)
      {
        if (shareContent.equals(shareContent)) {}
      }
      else {
        while (shareContent != null) {
          return false;
        }
      }
      if (attributedBody == null) {
        break;
      }
    } while (attributedBody.equals(attributedBody));
    for (;;)
    {
      return false;
      if (attributedBody == null) {
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
    if (hasBody) {
      i = PegasusBinaryUtils.getEncodedLength(body) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasSubject) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(subject);
    }
    i += 1;
    j = i;
    if (hasAttachments)
    {
      i += 2;
      Iterator localIterator = attachments.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        File localFile = (File)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localFile.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasCustomContent)
    {
      i = j + 1;
      if (customContent._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(customContent._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasShareContent)
      {
        i = j + 1;
        if (shareContent._cachedId == null) {
          break label297;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareContent._cachedId);
      }
      label235:
      j = i + 1;
      i = j;
      if (hasAttributedBody)
      {
        i = j + 1;
        if (attributedBody._cachedId == null) {
          break label310;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(attributedBody._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += customContent.getSerializedSize();
      break;
      label297:
      i += shareContent.getSerializedSize();
      break label235;
      label310:
      i += attributedBody.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label62:
    int m;
    if (body != null)
    {
      i = body.hashCode();
      if (subject == null) {
        break label156;
      }
      j = subject.hashCode();
      if (attachments == null) {
        break label161;
      }
      k = attachments.hashCode();
      if (customContent == null) {
        break label166;
      }
      m = customContent.hashCode();
      label78:
      if (shareContent == null) {
        break label172;
      }
    }
    label156:
    label161:
    label166:
    label172:
    for (int n = shareContent.hashCode();; n = 0)
    {
      if (attributedBody != null) {
        i1 = attributedBody.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label62;
      m = 0;
      break label78;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MessageEvent");
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
    label163:
    label280:
    label313:
    label320:
    label440:
    label568:
    label593:
    label603:
    label628:
    label636:
    label638:
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
        localByteBuffer.putInt(67982659);
        Iterator localIterator;
        if (hasBody)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, body);
          if (!hasSubject) {
            break label280;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, subject);
          if (!hasAttachments) {
            break label313;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, attachments.size());
          localIterator = attachments.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label320;
          }
          File localFile = (File)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localFile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label163;
          }
          localByteBuffer.put((byte)1);
          localFile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasCustomContent)
        {
          localByteBuffer.put((byte)1);
          if (customContent._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, customContent._cachedId);
            customContent.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasShareContent) {
              break label593;
            }
            localByteBuffer.put((byte)1);
            if (shareContent._cachedId == null) {
              break label568;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, shareContent._cachedId);
            shareContent.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAttributedBody) {
              break label628;
            }
            localByteBuffer.put((byte)1);
            if (attributedBody._cachedId == null) {
              break label603;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, attributedBody._cachedId);
            attributedBody.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label636;
          }
          if (str != null) {
            break label638;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          customContent.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          shareContent.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label440;
          localByteBuffer.put((byte)0);
          break label440;
          localByteBuffer.put((byte)1);
          attributedBody.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.MessageEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */