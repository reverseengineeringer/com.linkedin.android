package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropType;
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

public final class PropUpdate
  implements FissileDataModel<PropUpdate>, RecordTemplate<PropUpdate>
{
  public static final PropUpdateBuilder BUILDER = PropUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<UpdateAction> actions;
  public final SocialActor actor;
  public final long createdAt;
  public final boolean hasActions;
  public final boolean hasActor;
  public final boolean hasCreatedAt;
  public final boolean hasHeader;
  public final boolean hasSubtext;
  public final boolean hasText;
  public final boolean hasType;
  public final AnnotatedText header;
  public final AttributedText subtext;
  public final AttributedText text;
  public final PropType type;
  
  PropUpdate(List<UpdateAction> paramList, AnnotatedText paramAnnotatedText, SocialActor paramSocialActor, long paramLong, AttributedText paramAttributedText1, AttributedText paramAttributedText2, PropType paramPropType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      actions = paramList;
      header = paramAnnotatedText;
      actor = paramSocialActor;
      createdAt = paramLong;
      text = paramAttributedText1;
      subtext = paramAttributedText2;
      type = paramPropType;
      hasActions = paramBoolean1;
      hasHeader = paramBoolean2;
      hasActor = paramBoolean3;
      hasCreatedAt = paramBoolean4;
      hasText = paramBoolean5;
      hasSubtext = paramBoolean6;
      hasType = paramBoolean7;
      _cachedId = null;
      return;
    }
  }
  
  public final PropUpdate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject3;
    boolean bool2;
    label222:
    label234:
    Object localObject4;
    boolean bool3;
    label274:
    label286:
    Object localObject5;
    boolean bool4;
    if (hasActions)
    {
      paramDataProcessor.startRecordField$505cff1c("actions");
      actions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localObject3 = actions.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (UpdateAction)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((UpdateAction)localObject2).accept(paramDataProcessor);; localObject2 = (UpdateAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
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
      if (hasHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("header");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label497;
        }
        localObject2 = header.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label515;
        }
        bool2 = true;
        localObject3 = localObject2;
      }
      localObject4 = null;
      bool3 = false;
      if (hasActor)
      {
        paramDataProcessor.startRecordField$505cff1c("actor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label525;
        }
        localObject2 = actor.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label543;
        }
        bool3 = true;
        localObject4 = localObject2;
      }
      if (hasCreatedAt)
      {
        paramDataProcessor.startRecordField$505cff1c("createdAt");
        paramDataProcessor.processLong(createdAt);
      }
      localObject5 = null;
      bool4 = false;
      if (hasText)
      {
        paramDataProcessor.startRecordField$505cff1c("text");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label553;
        }
        localObject2 = text.accept(paramDataProcessor);
        label351:
        if (localObject2 == null) {
          break label571;
        }
        bool4 = true;
        localObject5 = localObject2;
      }
      label363:
      localObject2 = null;
      bool5 = false;
      if (hasSubtext)
      {
        paramDataProcessor.startRecordField$505cff1c("subtext");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label581;
        }
        localObject2 = subtext.accept(paramDataProcessor);
        label403:
        if (localObject2 == null) {
          break label599;
        }
      }
    }
    label497:
    label515:
    label525:
    label543:
    label553:
    label571:
    label581:
    label599:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (hasType)
      {
        paramDataProcessor.startRecordField$505cff1c("type");
        paramDataProcessor.processEnum(type);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label755;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasHeader) {
          break label605;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      break;
      localObject2 = (AnnotatedText)paramDataProcessor.processDataTemplate(header);
      break label222;
      bool2 = false;
      localObject3 = localObject2;
      break label234;
      localObject2 = (SocialActor)paramDataProcessor.processDataTemplate(actor);
      break label274;
      bool3 = false;
      localObject4 = localObject2;
      break label286;
      localObject2 = (AttributedText)paramDataProcessor.processDataTemplate(text);
      break label351;
      bool4 = false;
      localObject5 = localObject2;
      break label363;
      localObject2 = (AttributedText)paramDataProcessor.processDataTemplate(subtext);
      break label403;
    }
    label605:
    if (!hasActor) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate", "actor");
    }
    if (!hasText) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate", "text");
    }
    if (!hasType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate", "type");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate", "actions");
        }
      }
    }
    return new PropUpdate((List)localObject1, (AnnotatedText)localObject3, (SocialActor)localObject4, createdAt, (AttributedText)localObject5, (AttributedText)localObject2, type, bool1, bool2, bool3, hasCreatedAt, bool4, bool5, hasType);
    label755:
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
      paramObject = (PropUpdate)paramObject;
      if (actions != null)
      {
        if (actions.equals(actions)) {}
      }
      else {
        while (actions != null) {
          return false;
        }
      }
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (actor != null)
      {
        if (actor.equals(actor)) {}
      }
      else {
        while (actor != null) {
          return false;
        }
      }
      if (createdAt != createdAt) {
        return false;
      }
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (subtext != null)
      {
        if (subtext.equals(subtext)) {}
      }
      else {
        while (subtext != null) {
          return false;
        }
      }
      if (type == null) {
        break;
      }
    } while (type.equals(type));
    for (;;)
    {
      return false;
      if (type == null) {
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
    int j = i;
    if (hasActions)
    {
      i += 2;
      Iterator localIterator = actions.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        UpdateAction localUpdateAction = (UpdateAction)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localUpdateAction.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasHeader)
    {
      i = j + 1;
      if (header._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(header._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasActor)
      {
        i = j + 1;
        if (actor._cachedId == null) {
          break label327;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(actor._cachedId);
      }
      label188:
      j = i + 1;
      i = j;
      if (hasCreatedAt) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasText)
      {
        i = j + 1;
        if (text._cachedId == null) {
          break label340;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(text._cachedId);
      }
      label248:
      j = i + 1;
      i = j;
      if (hasSubtext)
      {
        i = j + 1;
        if (subtext._cachedId == null) {
          break label353;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(subtext._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasType) {
        i = j + 2;
      }
      __sizeOfObject = i;
      return i;
      i += header.getSerializedSize();
      break;
      label327:
      i += actor.getSerializedSize();
      break label188;
      label340:
      i += text.getSerializedSize();
      break label248;
      label353:
      i += subtext.getSerializedSize();
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
    label47:
    int k;
    label62:
    int i2;
    int m;
    if (actions != null)
    {
      i = actions.hashCode();
      if (header == null) {
        break label177;
      }
      j = header.hashCode();
      if (actor == null) {
        break label182;
      }
      k = actor.hashCode();
      i2 = (int)(createdAt ^ createdAt >>> 32);
      if (text == null) {
        break label187;
      }
      m = text.hashCode();
      label93:
      if (subtext == null) {
        break label193;
      }
    }
    label177:
    label182:
    label187:
    label193:
    for (int n = subtext.hashCode();; n = 0)
    {
      if (type != null) {
        i1 = type.hashCode();
      }
      i = (n + (m + ((k + (j + (i + 527) * 31) * 31) * 31 + i2) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label47;
      k = 0;
      break label62;
      m = 0;
      break label93;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PropUpdate");
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
    label369:
    label393:
    label453:
    label513:
    label610:
    label635:
    label645:
    label655:
    label680:
    label690:
    label715:
    label725:
    label733:
    label735:
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
        localByteBuffer.putInt(688823024);
        if (hasActions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
          Iterator localIterator = actions.iterator();
          while (localIterator.hasNext())
          {
            UpdateAction localUpdateAction = (UpdateAction)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localUpdateAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localUpdateAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasHeader)
        {
          localByteBuffer.put((byte)1);
          if (header._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, header._cachedId);
            header.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasActor) {
              break label635;
            }
            localByteBuffer.put((byte)1);
            if (actor._cachedId == null) {
              break label610;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, actor._cachedId);
            actor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCreatedAt) {
              break label645;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putLong(createdAt);
            if (!hasText) {
              break label680;
            }
            localByteBuffer.put((byte)1);
            if (text._cachedId == null) {
              break label655;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
            text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSubtext) {
              break label715;
            }
            localByteBuffer.put((byte)1);
            if (subtext._cachedId == null) {
              break label690;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, subtext._cachedId);
            subtext.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasType) {
              break label725;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label733;
          }
          if (str != null) {
            break label735;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          header.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          actor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label369;
          localByteBuffer.put((byte)0);
          break label369;
          localByteBuffer.put((byte)0);
          break label393;
          localByteBuffer.put((byte)1);
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label453;
          localByteBuffer.put((byte)0);
          break label453;
          localByteBuffer.put((byte)1);
          subtext.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label513;
          localByteBuffer.put((byte)0);
          break label513;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */