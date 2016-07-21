package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
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

public final class ChannelUpdate
  implements FissileDataModel<ChannelUpdate>, RecordTemplate<ChannelUpdate>
{
  public static final ChannelUpdateBuilder BUILDER = ChannelUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<UpdateAction> actions;
  public final ChannelActor actor;
  public final Update articleUpdate;
  public final ShareUpdateContent.Content content;
  public final AnnotatedText contentPool;
  public final long createdTime;
  public final boolean hasActions;
  public final boolean hasActor;
  public final boolean hasArticleUpdate;
  public final boolean hasContent;
  public final boolean hasContentPool;
  public final boolean hasCreatedTime;
  public final boolean hasHeader;
  public final boolean hasTracking;
  public final boolean hasTrackingId;
  public final boolean hasUrn;
  public final AnnotatedText header;
  public final TrackingData tracking;
  public final String trackingId;
  public final Urn urn;
  
  ChannelUpdate(ShareUpdateContent.Content paramContent, List<UpdateAction> paramList, Urn paramUrn, ChannelActor paramChannelActor, AnnotatedText paramAnnotatedText1, AnnotatedText paramAnnotatedText2, Update paramUpdate, long paramLong, String paramString, TrackingData paramTrackingData, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    content = paramContent;
    if (paramList == null) {}
    for (paramContent = null;; paramContent = Collections.unmodifiableList(paramList))
    {
      actions = paramContent;
      urn = paramUrn;
      actor = paramChannelActor;
      header = paramAnnotatedText1;
      contentPool = paramAnnotatedText2;
      articleUpdate = paramUpdate;
      createdTime = paramLong;
      trackingId = paramString;
      tracking = paramTrackingData;
      hasContent = paramBoolean1;
      hasActions = paramBoolean2;
      hasUrn = paramBoolean3;
      hasActor = paramBoolean4;
      hasHeader = paramBoolean5;
      hasContentPool = paramBoolean6;
      hasArticleUpdate = paramBoolean7;
      hasCreatedTime = paramBoolean8;
      hasTrackingId = paramBoolean9;
      hasTracking = paramBoolean10;
      _cachedId = null;
      return;
    }
  }
  
  public final ChannelUpdate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject3 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    boolean bool2;
    int i;
    Object localObject4;
    if (hasContent)
    {
      paramDataProcessor.startRecordField$505cff1c("content");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = content.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
        }
        bool1 = true;
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasActions) {
        break label261;
      }
      paramDataProcessor.startRecordField$505cff1c("actions");
      actions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject4 = actions.iterator();
      label131:
      if (!((Iterator)localObject4).hasNext()) {
        break label247;
      }
      localObject2 = (UpdateAction)((Iterator)localObject4).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label231;
      }
    }
    label222:
    label231:
    for (Object localObject2 = ((UpdateAction)localObject2).accept(paramDataProcessor);; localObject2 = (UpdateAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label131;
      localObject1 = (ShareUpdateContent.Content)paramDataProcessor.processDataTemplate(content);
      break;
      bool1 = false;
      localObject3 = localObject1;
      break label56;
    }
    label247:
    paramDataProcessor.endArray();
    label261:
    boolean bool3;
    label334:
    label346:
    Object localObject5;
    boolean bool4;
    label386:
    label398:
    Object localObject6;
    boolean bool5;
    label438:
    label450:
    Object localObject7;
    boolean bool6;
    if (localObject1 != null)
    {
      bool2 = true;
      if (hasUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("urn");
        localObject2 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(urn));
      }
      localObject4 = null;
      bool3 = false;
      if (hasActor)
      {
        paramDataProcessor.startRecordField$505cff1c("actor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label662;
        }
        localObject2 = actor.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label680;
        }
        bool3 = true;
        localObject4 = localObject2;
      }
      localObject5 = null;
      bool4 = false;
      if (hasHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("header");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label690;
        }
        localObject2 = header.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label708;
        }
        bool4 = true;
        localObject5 = localObject2;
      }
      localObject6 = null;
      bool5 = false;
      if (hasContentPool)
      {
        paramDataProcessor.startRecordField$505cff1c("contentPool");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label718;
        }
        localObject2 = contentPool.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label736;
        }
        bool5 = true;
        localObject6 = localObject2;
      }
      localObject7 = null;
      bool6 = false;
      if (hasArticleUpdate)
      {
        paramDataProcessor.startRecordField$505cff1c("articleUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label746;
        }
        localObject2 = articleUpdate.accept(paramDataProcessor);
        label490:
        if (localObject2 == null) {
          break label764;
        }
        bool6 = true;
        localObject7 = localObject2;
      }
      label502:
      if (hasCreatedTime)
      {
        paramDataProcessor.startRecordField$505cff1c("createdTime");
        paramDataProcessor.processLong(createdTime);
      }
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        paramDataProcessor.processString(trackingId);
      }
      localObject2 = null;
      bool7 = false;
      if (hasTracking)
      {
        paramDataProcessor.startRecordField$505cff1c("tracking");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label774;
        }
        localObject2 = tracking.accept(paramDataProcessor);
        label592:
        if (localObject2 == null) {
          break label792;
        }
      }
    }
    label662:
    label680:
    label690:
    label708:
    label718:
    label736:
    label746:
    label764:
    label774:
    label792:
    for (boolean bool7 = true;; bool7 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label945;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasContent) {
          break label798;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate", "content");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool2 = false;
      break;
      localObject2 = (ChannelActor)paramDataProcessor.processDataTemplate(actor);
      break label334;
      bool3 = false;
      localObject4 = localObject2;
      break label346;
      localObject2 = (AnnotatedText)paramDataProcessor.processDataTemplate(header);
      break label386;
      bool4 = false;
      localObject5 = localObject2;
      break label398;
      localObject2 = (AnnotatedText)paramDataProcessor.processDataTemplate(contentPool);
      break label438;
      bool5 = false;
      localObject6 = localObject2;
      break label450;
      localObject2 = (Update)paramDataProcessor.processDataTemplate(articleUpdate);
      break label490;
      bool6 = false;
      localObject7 = localObject2;
      break label502;
      localObject2 = (TrackingData)paramDataProcessor.processDataTemplate(tracking);
      break label592;
    }
    label798:
    if (!hasActor) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate", "actor");
    }
    if (!hasHeader) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate", "header");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate", "actions");
        }
      }
    }
    return new ChannelUpdate((ShareUpdateContent.Content)localObject3, (List)localObject1, urn, (ChannelActor)localObject4, (AnnotatedText)localObject5, (AnnotatedText)localObject6, (Update)localObject7, createdTime, trackingId, (TrackingData)localObject2, bool1, bool2, hasUrn, bool3, bool4, bool5, bool6, hasCreatedTime, hasTrackingId, bool7);
    label945:
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
      paramObject = (ChannelUpdate)paramObject;
      if (content != null)
      {
        if (content.equals(content)) {}
      }
      else {
        while (content != null) {
          return false;
        }
      }
      if (actions != null)
      {
        if (actions.equals(actions)) {}
      }
      else {
        while (actions != null) {
          return false;
        }
      }
      if (urn != null)
      {
        if (urn.equals(urn)) {}
      }
      else {
        while (urn != null) {
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
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (contentPool != null)
      {
        if (contentPool.equals(contentPool)) {}
      }
      else {
        while (contentPool != null) {
          return false;
        }
      }
      if (articleUpdate != null)
      {
        if (articleUpdate.equals(articleUpdate)) {}
      }
      else {
        while (articleUpdate != null) {
          return false;
        }
      }
      if (createdTime != createdTime) {
        return false;
      }
      if (trackingId != null)
      {
        if (trackingId.equals(trackingId)) {}
      }
      else {
        while (trackingId != null) {
          return false;
        }
      }
      if (tracking == null) {
        break;
      }
    } while (tracking.equals(tracking));
    for (;;)
    {
      return false;
      if (tracking == null) {
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
    Object localObject;
    if (hasContent)
    {
      if (content._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(content._cachedId) + 9;
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasActions) {
        break label153;
      }
      i += 2;
      localObject = actions.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label153;
      }
      UpdateAction localUpdateAction = (UpdateAction)((Iterator)localObject).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = content.getSerializedSize() + 7;
        break;
      }
      i += localUpdateAction.getSerializedSize();
    }
    label153:
    j += 1;
    i = j;
    if (hasUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(urn));
    }
    int j = i + 1;
    i = j;
    if (hasActor)
    {
      i = j + 1;
      if (actor._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(actor._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasHeader)
      {
        i = j + 1;
        if (header._cachedId == null) {
          break label458;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(header._cachedId);
      }
      label269:
      j = i + 1;
      i = j;
      if (hasContentPool)
      {
        i = j + 1;
        if (contentPool._cachedId == null) {
          break label471;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(contentPool._cachedId);
      }
      label311:
      j = i + 1;
      i = j;
      if (hasArticleUpdate)
      {
        i = j + 1;
        if (articleUpdate._cachedId == null) {
          break label484;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(articleUpdate._cachedId);
      }
      label353:
      j = i + 1;
      i = j;
      if (hasCreatedTime) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasTrackingId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
      }
      j = i + 1;
      i = j;
      if (hasTracking)
      {
        i = j + 1;
        if (tracking._cachedId == null) {
          break label497;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(tracking._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += actor.getSerializedSize();
      break;
      label458:
      i += header.getSerializedSize();
      break label269;
      label471:
      i += contentPool.getSerializedSize();
      break label311;
      label484:
      i += articleUpdate.getSerializedSize();
      break label353;
      label497:
      i += tracking.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i4 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label47:
    int k;
    label62:
    int m;
    label78:
    int n;
    label94:
    int i1;
    label110:
    int i2;
    label126:
    int i5;
    if (content != null)
    {
      i = content.hashCode();
      if (actions == null) {
        break label243;
      }
      j = actions.hashCode();
      if (urn == null) {
        break label248;
      }
      k = urn.hashCode();
      if (actor == null) {
        break label253;
      }
      m = actor.hashCode();
      if (header == null) {
        break label259;
      }
      n = header.hashCode();
      if (contentPool == null) {
        break label265;
      }
      i1 = contentPool.hashCode();
      if (articleUpdate == null) {
        break label271;
      }
      i2 = articleUpdate.hashCode();
      i5 = (int)(createdTime ^ createdTime >>> 32);
      if (trackingId == null) {
        break label277;
      }
    }
    label243:
    label248:
    label253:
    label259:
    label265:
    label271:
    label277:
    for (int i3 = trackingId.hashCode();; i3 = 0)
    {
      if (tracking != null) {
        i4 = tracking.hashCode();
      }
      i = (i3 + ((i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i5) * 31) * 31 + i4;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label47;
      k = 0;
      break label62;
      m = 0;
      break label78;
      n = 0;
      break label94;
      i1 = 0;
      break label110;
      i2 = 0;
      break label126;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ChannelUpdate");
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
    label337:
    label344:
    label438:
    label498:
    label558:
    label618:
    label642:
    label668:
    label771:
    label796:
    label806:
    label831:
    label841:
    label866:
    label876:
    label901:
    label911:
    label921:
    label931:
    label956:
    label964:
    label966:
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
        localByteBuffer.putInt(-341439366);
        Object localObject;
        if (hasContent)
        {
          localByteBuffer.put((byte)1);
          if (content._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, content._cachedId);
            content.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasActions) {
              break label337;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
            localObject = actions.iterator();
          }
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label344;
          }
          UpdateAction localUpdateAction = (UpdateAction)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localUpdateAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            content.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
          }
          localByteBuffer.put((byte)1);
          localUpdateAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasActor) {
            break label796;
          }
          localByteBuffer.put((byte)1);
          if (actor._cachedId == null) {
            break label771;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, actor._cachedId);
          actor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasHeader) {
            break label831;
          }
          localByteBuffer.put((byte)1);
          if (header._cachedId == null) {
            break label806;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, header._cachedId);
          header.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasContentPool) {
            break label866;
          }
          localByteBuffer.put((byte)1);
          if (contentPool._cachedId == null) {
            break label841;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, contentPool._cachedId);
          contentPool.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasArticleUpdate) {
            break label901;
          }
          localByteBuffer.put((byte)1);
          if (articleUpdate._cachedId == null) {
            break label876;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, articleUpdate._cachedId);
          articleUpdate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCreatedTime) {
            break label911;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(createdTime);
          if (!hasTrackingId) {
            break label921;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasTracking) {
            break label956;
          }
          localByteBuffer.put((byte)1);
          if (tracking._cachedId == null) {
            break label931;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, tracking._cachedId);
          tracking.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label964;
          }
          if (str != null) {
            break label966;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          actor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label438;
          localByteBuffer.put((byte)0);
          break label438;
          localByteBuffer.put((byte)1);
          header.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label498;
          localByteBuffer.put((byte)0);
          break label498;
          localByteBuffer.put((byte)1);
          contentPool.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label558;
          localByteBuffer.put((byte)0);
          break label558;
          localByteBuffer.put((byte)1);
          articleUpdate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label618;
          localByteBuffer.put((byte)0);
          break label618;
          localByteBuffer.put((byte)0);
          break label642;
          localByteBuffer.put((byte)0);
          break label668;
          localByteBuffer.put((byte)1);
          tracking.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */