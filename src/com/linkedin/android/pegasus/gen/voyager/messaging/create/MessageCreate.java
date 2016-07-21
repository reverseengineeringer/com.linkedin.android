package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.common.File;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.InmailContentCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.ShareContentCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.ShareCreate;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.data.lite.UnionMemberCountException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MessageCreate
  implements FissileDataModel<MessageCreate>, RecordTemplate<MessageCreate>
{
  public static final MessageCreateBuilder BUILDER = MessageCreateBuilder.INSTANCE;
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
  public final ShareContentCreate shareContent;
  
  MessageCreate(String paramString, List<File> paramList, CustomContent paramCustomContent, ShareContentCreate paramShareContentCreate, AttributedText paramAttributedText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    body = paramString;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      attachments = paramString;
      customContent = paramCustomContent;
      shareContent = paramShareContentCreate;
      attributedBody = paramAttributedText;
      hasBody = paramBoolean1;
      hasAttachments = paramBoolean2;
      hasCustomContent = paramBoolean3;
      hasShareContent = paramBoolean4;
      hasAttributedBody = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  public final MessageCreate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasBody)
    {
      paramDataProcessor.startRecordField$505cff1c("body");
      paramDataProcessor.processString(body);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject3;
    boolean bool2;
    label247:
    label259:
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
          break label420;
        }
        localObject2 = customContent.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label438;
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
          break label448;
        }
        localObject2 = shareContent.accept(paramDataProcessor);
        label299:
        if (localObject2 == null) {
          break label466;
        }
        bool3 = true;
        localObject4 = localObject2;
      }
      label311:
      localObject2 = null;
      bool4 = false;
      if (hasAttributedBody)
      {
        paramDataProcessor.startRecordField$505cff1c("attributedBody");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label476;
        }
        localObject2 = attributedBody.accept(paramDataProcessor);
        label351:
        if (localObject2 == null) {
          break label494;
        }
      }
    }
    label420:
    label438:
    label448:
    label466:
    label476:
    label494:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label581;
      }
      if (!hasAttachments) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasBody) {
          break label500;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.MessageCreate", "body");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      break;
      localObject2 = (CustomContent)paramDataProcessor.processDataTemplate(customContent);
      break label247;
      bool2 = false;
      localObject3 = localObject2;
      break label259;
      localObject2 = (ShareContentCreate)paramDataProcessor.processDataTemplate(shareContent);
      break label299;
      bool3 = false;
      localObject4 = localObject2;
      break label311;
      localObject2 = (AttributedText)paramDataProcessor.processDataTemplate(attributedBody);
      break label351;
    }
    label500:
    if (attachments != null)
    {
      paramDataProcessor = attachments.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((File)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.create.MessageCreate", "attachments");
        }
      }
    }
    return new MessageCreate(body, (List)localObject1, (CustomContent)localObject3, (ShareContentCreate)localObject4, (AttributedText)localObject2, hasBody, bool1, bool2, bool3, bool4);
    label581:
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
      paramObject = (MessageCreate)paramObject;
      if (body != null)
      {
        if (body.equals(body)) {}
      }
      else {
        while (body != null) {
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
    i += 1;
    int j = i;
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
          break label272;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareContent._cachedId);
      }
      label210:
      j = i + 1;
      i = j;
      if (hasAttributedBody)
      {
        i = j + 1;
        if (attributedBody._cachedId == null) {
          break label285;
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
      label272:
      i += shareContent.getSerializedSize();
      break label210;
      label285:
      i += attributedBody.getSerializedSize();
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
    label47:
    int k;
    if (body != null)
    {
      i = body.hashCode();
      if (attachments == null) {
        break label134;
      }
      j = attachments.hashCode();
      if (customContent == null) {
        break label139;
      }
      k = customContent.hashCode();
      label62:
      if (shareContent == null) {
        break label144;
      }
    }
    label134:
    label139:
    label144:
    for (int m = shareContent.hashCode();; m = 0)
    {
      if (attributedBody != null) {
        n = attributedBody.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label47;
      k = 0;
      break label62;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MessageCreate");
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
    label284:
    label404:
    label532:
    label557:
    label567:
    label592:
    label600:
    label602:
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
        localByteBuffer.putInt(124401551);
        Iterator localIterator;
        if (hasBody)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, body);
          if (hasAttachments)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, attachments.size());
            localIterator = attachments.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label284;
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
            }
            localByteBuffer.put((byte)1);
            localFile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
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
              break label557;
            }
            localByteBuffer.put((byte)1);
            if (shareContent._cachedId == null) {
              break label532;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, shareContent._cachedId);
            shareContent.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAttributedBody) {
              break label592;
            }
            localByteBuffer.put((byte)1);
            if (attributedBody._cachedId == null) {
              break label567;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, attributedBody._cachedId);
            attributedBody.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label600;
          }
          if (str != null) {
            break label602;
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
          break label404;
          localByteBuffer.put((byte)0);
          break label404;
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
  
  public static final class Builder
    implements RecordTemplateBuilder<MessageCreate>
  {
    private List<File> attachments = null;
    private AttributedText attributedBody = null;
    private String body = null;
    private MessageCreate.CustomContent customContent = null;
    private boolean hasAttachments = false;
    private boolean hasAttributedBody = false;
    private boolean hasBody = false;
    private boolean hasCustomContent = false;
    private boolean hasShareContent = false;
    private ShareContentCreate shareContent = null;
    
    public final MessageCreate build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (MessageCreate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (attachments != null)
      {
        paramFlavor = attachments.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((File)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.create.MessageCreate", "attachments");
              if (!hasAttachments) {
                attachments = Collections.emptyList();
              }
              if (hasBody) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.MessageCreate", "body");
            }
          }
        }
      }
      return new MessageCreate(body, attachments, customContent, shareContent, attributedBody, hasBody, hasAttachments, hasCustomContent, hasShareContent, hasAttributedBody);
    }
    
    public final Builder setAttachments(List<File> paramList)
    {
      if ((paramList == null) || (paramList.equals(Collections.emptyList())))
      {
        hasAttachments = false;
        attachments = Collections.emptyList();
        return this;
      }
      hasAttachments = true;
      attachments = paramList;
      return this;
    }
    
    public final Builder setBody(String paramString)
    {
      if (paramString == null)
      {
        hasBody = false;
        body = null;
        return this;
      }
      hasBody = true;
      body = paramString;
      return this;
    }
    
    public final Builder setCustomContent(MessageCreate.CustomContent paramCustomContent)
    {
      if (paramCustomContent == null)
      {
        hasCustomContent = false;
        customContent = null;
        return this;
      }
      hasCustomContent = true;
      customContent = paramCustomContent;
      return this;
    }
  }
  
  public static final class CustomContent
    implements FissileDataModel<CustomContent>, UnionTemplate<CustomContent>
  {
    public static final MessageCreateBuilder.CustomContentBuilder BUILDER = MessageCreateBuilder.CustomContentBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasInmailContentCreateValue;
    public final boolean hasMiniGroupUrnValue;
    public final boolean hasShareCreateValue;
    public final InmailContentCreate inmailContentCreateValue;
    public final Urn miniGroupUrnValue;
    public final ShareCreate shareCreateValue;
    
    CustomContent(InmailContentCreate paramInmailContentCreate, ShareCreate paramShareCreate, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      inmailContentCreateValue = paramInmailContentCreate;
      shareCreateValue = paramShareCreate;
      miniGroupUrnValue = paramUrn;
      hasInmailContentCreateValue = paramBoolean1;
      hasShareCreateValue = paramBoolean2;
      hasMiniGroupUrnValue = paramBoolean3;
      _cachedId = null;
    }
    
    public final CustomContent accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasInmailContentCreateValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.create.message.InmailContentCreate");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = inmailContentCreateValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label190;
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
        if (hasShareCreateValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.create.message.ShareCreate");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label199;
          }
          localObject1 = shareCreateValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label217;
          }
        }
      }
      label190:
      label199:
      label217:
      for (boolean bool2 = true;; bool2 = false)
      {
        if (hasMiniGroupUrnValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("string");
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(miniGroupUrnValue));
        }
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label222;
        }
        return new CustomContent((InmailContentCreate)localObject2, (ShareCreate)localObject1, miniGroupUrnValue, bool1, bool2, hasMiniGroupUrnValue);
        localObject1 = (InmailContentCreate)paramDataProcessor.processDataTemplate(inmailContentCreateValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (ShareCreate)paramDataProcessor.processDataTemplate(shareCreateValue);
        break label95;
      }
      label222:
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
        paramObject = (CustomContent)paramObject;
        if (inmailContentCreateValue != null)
        {
          if (inmailContentCreateValue.equals(inmailContentCreateValue)) {}
        }
        else {
          while (inmailContentCreateValue != null) {
            return false;
          }
        }
        if (shareCreateValue != null)
        {
          if (shareCreateValue.equals(shareCreateValue)) {}
        }
        else {
          while (shareCreateValue != null) {
            return false;
          }
        }
        if (miniGroupUrnValue == null) {
          break;
        }
      } while (miniGroupUrnValue.equals(miniGroupUrnValue));
      for (;;)
      {
        return false;
        if (miniGroupUrnValue == null) {
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
      if (hasInmailContentCreateValue)
      {
        if (inmailContentCreateValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(inmailContentCreateValue._cachedId) + 9;
        }
      }
      else
      {
        j = i + 1;
        i = j;
        if (hasShareCreateValue)
        {
          i = j + 1;
          if (shareCreateValue._cachedId == null) {
            break label146;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareCreateValue._cachedId);
        }
      }
      for (;;)
      {
        j = i + 1;
        i = j;
        if (hasMiniGroupUrnValue)
        {
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(miniGroupUrnValue));
        }
        __sizeOfObject = i;
        return i;
        i = inmailContentCreateValue.getSerializedSize() + 7;
        break;
        label146:
        i += shareCreateValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int k = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      int i;
      if (inmailContentCreateValue != null)
      {
        i = inmailContentCreateValue.hashCode();
        if (shareCreateValue == null) {
          break label87;
        }
      }
      label87:
      for (int j = shareCreateValue.hashCode();; j = 0)
      {
        if (miniGroupUrnValue != null) {
          k = miniGroupUrnValue.hashCode();
        }
        i = (j + (i + 527) * 31) * 31 + k;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CustomContent");
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
      label230:
      label332:
      label357:
      label367:
      label375:
      label377:
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
          localByteBuffer.putInt(-535643681);
          if (hasInmailContentCreateValue)
          {
            localByteBuffer.put((byte)1);
            if (inmailContentCreateValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, inmailContentCreateValue._cachedId);
              inmailContentCreateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasShareCreateValue) {
                break label357;
              }
              localByteBuffer.put((byte)1);
              if (shareCreateValue._cachedId == null) {
                break label332;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, shareCreateValue._cachedId);
              shareCreateValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMiniGroupUrnValue) {
                break label367;
              }
              localByteBuffer.put((byte)1);
              UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
              paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(miniGroupUrnValue));
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label375;
            }
            if (str != null) {
              break label377;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            inmailContentCreateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            shareCreateValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
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
    
    public static final class Builder
    {
      public boolean hasInmailContentCreateValue = false;
      public boolean hasMiniGroupUrnValue = false;
      public boolean hasShareCreateValue = false;
      public InmailContentCreate inmailContentCreateValue = null;
      public Urn miniGroupUrnValue = null;
      public ShareCreate shareCreateValue = null;
      
      public final MessageCreate.CustomContent build()
        throws BuilderException
      {
        int j = 0;
        if (hasInmailContentCreateValue) {
          j = 0 + 1;
        }
        int i = j;
        if (hasShareCreateValue) {
          i = j + 1;
        }
        j = i;
        if (hasMiniGroupUrnValue) {
          j = i + 1;
        }
        if (j > 1) {
          throw new UnionMemberCountException("CustomContent", j);
        }
        return new MessageCreate.CustomContent(inmailContentCreateValue, shareCreateValue, miniGroupUrnValue, hasInmailContentCreateValue, hasShareCreateValue, hasMiniGroupUrnValue);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.MessageCreate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */