package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ViralUpdate
  implements FissileDataModel<ViralUpdate>, RecordTemplate<ViralUpdate>
{
  public static final ViralUpdateBuilder BUILDER = ViralUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<UpdateAction> actions;
  public final SocialActor actor;
  public final boolean hasActions;
  public final boolean hasActor;
  public final boolean hasHeader;
  public final boolean hasInsight;
  public final boolean hasOriginalUpdate;
  public final boolean hasTracking;
  public final boolean hasTrackingId;
  public final boolean hasUrn;
  public final boolean hasViralType;
  public final AttributedText header;
  public final String insight;
  public final Update originalUpdate;
  public final TrackingData tracking;
  public final String trackingId;
  public final Urn urn;
  public final ViralType viralType;
  
  ViralUpdate(List<UpdateAction> paramList, Urn paramUrn, SocialActor paramSocialActor, Update paramUpdate, String paramString1, AttributedText paramAttributedText, ViralType paramViralType, String paramString2, TrackingData paramTrackingData, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      actions = paramList;
      urn = paramUrn;
      actor = paramSocialActor;
      originalUpdate = paramUpdate;
      insight = paramString1;
      header = paramAttributedText;
      viralType = paramViralType;
      trackingId = paramString2;
      tracking = paramTrackingData;
      hasActions = paramBoolean1;
      hasUrn = paramBoolean2;
      hasActor = paramBoolean3;
      hasOriginalUpdate = paramBoolean4;
      hasInsight = paramBoolean5;
      hasHeader = paramBoolean6;
      hasViralType = paramBoolean7;
      hasTrackingId = paramBoolean8;
      hasTracking = paramBoolean9;
      _cachedId = null;
      return;
    }
  }
  
  public final ViralUpdate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject3;
    boolean bool2;
    label255:
    label267:
    Object localObject4;
    boolean bool3;
    label307:
    label319:
    Object localObject5;
    boolean bool4;
    label384:
    label396:
    Object localObject6;
    boolean bool5;
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
      if (hasUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("urn");
        localObject2 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(urn));
      }
      localObject3 = null;
      bool2 = false;
      if (hasActor)
      {
        paramDataProcessor.startRecordField$505cff1c("actor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label582;
        }
        localObject2 = actor.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label600;
        }
        bool2 = true;
        localObject3 = localObject2;
      }
      localObject4 = null;
      bool3 = false;
      if (hasOriginalUpdate)
      {
        paramDataProcessor.startRecordField$505cff1c("originalUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label610;
        }
        localObject2 = originalUpdate.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label628;
        }
        bool3 = true;
        localObject4 = localObject2;
      }
      if (hasInsight)
      {
        paramDataProcessor.startRecordField$505cff1c("insight");
        paramDataProcessor.processString(insight);
      }
      localObject5 = null;
      bool4 = false;
      if (hasHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("header");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label638;
        }
        localObject2 = header.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label656;
        }
        bool4 = true;
        localObject5 = localObject2;
      }
      localObject6 = null;
      bool5 = false;
      if (hasViralType)
      {
        paramDataProcessor.startRecordField$505cff1c("viralType");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label666;
        }
        localObject2 = viralType.accept(paramDataProcessor);
        label436:
        if (localObject2 == null) {
          break label684;
        }
        bool5 = true;
        localObject6 = localObject2;
      }
      label448:
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        paramDataProcessor.processString(trackingId);
      }
      localObject2 = null;
      bool6 = false;
      if (hasTracking)
      {
        paramDataProcessor.startRecordField$505cff1c("tracking");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label694;
        }
        localObject2 = tracking.accept(paramDataProcessor);
        label513:
        if (localObject2 == null) {
          break label712;
        }
      }
    }
    label582:
    label600:
    label610:
    label628:
    label638:
    label656:
    label666:
    label684:
    label694:
    label712:
    for (boolean bool6 = true;; bool6 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label861;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasActor) {
          break label718;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate", "actor");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      break;
      localObject2 = (SocialActor)paramDataProcessor.processDataTemplate(actor);
      break label255;
      bool2 = false;
      localObject3 = localObject2;
      break label267;
      localObject2 = (Update)paramDataProcessor.processDataTemplate(originalUpdate);
      break label307;
      bool3 = false;
      localObject4 = localObject2;
      break label319;
      localObject2 = (AttributedText)paramDataProcessor.processDataTemplate(header);
      break label384;
      bool4 = false;
      localObject5 = localObject2;
      break label396;
      localObject2 = (ViralType)paramDataProcessor.processDataTemplate(viralType);
      break label436;
      bool5 = false;
      localObject6 = localObject2;
      break label448;
      localObject2 = (TrackingData)paramDataProcessor.processDataTemplate(tracking);
      break label513;
    }
    label718:
    if (!hasOriginalUpdate) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate", "originalUpdate");
    }
    if (!hasViralType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate", "viralType");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate", "actions");
        }
      }
    }
    return new ViralUpdate((List)localObject1, urn, (SocialActor)localObject3, (Update)localObject4, insight, (AttributedText)localObject5, (ViralType)localObject6, trackingId, (TrackingData)localObject2, bool1, hasUrn, bool2, bool3, hasInsight, bool4, bool5, hasTrackingId, bool6);
    label861:
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
      paramObject = (ViralUpdate)paramObject;
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
      if (originalUpdate != null)
      {
        if (originalUpdate.equals(originalUpdate)) {}
      }
      else {
        while (originalUpdate != null) {
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
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (viralType != null)
      {
        if (viralType.equals(viralType)) {}
      }
      else {
        while (viralType != null) {
          return false;
        }
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
    int j = i;
    Object localObject;
    if (hasActions)
    {
      i += 2;
      localObject = actions.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        UpdateAction localUpdateAction = (UpdateAction)((Iterator)localObject).next();
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
    if (hasUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(urn));
    }
    j = i + 1;
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
      if (hasOriginalUpdate)
      {
        i = j + 1;
        if (originalUpdate._cachedId == null) {
          break label416;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(originalUpdate._cachedId);
      }
      label220:
      j = i + 1;
      i = j;
      if (hasInsight) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(insight);
      }
      j = i + 1;
      i = j;
      if (hasHeader)
      {
        i = j + 1;
        if (header._cachedId == null) {
          break label429;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(header._cachedId);
      }
      label287:
      j = i + 1;
      i = j;
      if (hasViralType)
      {
        i = j + 1;
        if (viralType._cachedId == null) {
          break label442;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(viralType._cachedId);
      }
      label329:
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
          break label455;
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
      label416:
      i += originalUpdate.getSerializedSize();
      break label220;
      label429:
      i += header.getSerializedSize();
      break label287;
      label442:
      i += viralType.getSerializedSize();
      break label329;
      label455:
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
    if (actions != null)
    {
      i = actions.hashCode();
      if (urn == null) {
        break label222;
      }
      j = urn.hashCode();
      if (actor == null) {
        break label227;
      }
      k = actor.hashCode();
      if (originalUpdate == null) {
        break label232;
      }
      m = originalUpdate.hashCode();
      if (insight == null) {
        break label238;
      }
      n = insight.hashCode();
      if (header == null) {
        break label244;
      }
      i1 = header.hashCode();
      if (viralType == null) {
        break label250;
      }
      i2 = viralType.hashCode();
      label126:
      if (trackingId == null) {
        break label256;
      }
    }
    label222:
    label227:
    label232:
    label238:
    label244:
    label250:
    label256:
    for (int i3 = trackingId.hashCode();; i3 = 0)
    {
      if (tracking != null) {
        i4 = tracking.hashCode();
      }
      i = (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ViralUpdate");
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
    label343:
    label403:
    label429:
    label489:
    label549:
    label575:
    label678:
    label703:
    label713:
    label738:
    label748:
    label758:
    label783:
    label793:
    label818:
    label828:
    label838:
    label863:
    label871:
    label873:
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
        localByteBuffer.putInt(1472920570);
        Object localObject;
        if (hasActions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
          localObject = actions.iterator();
          while (((Iterator)localObject).hasNext())
          {
            UpdateAction localUpdateAction = (UpdateAction)((Iterator)localObject).next();
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
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasActor) {
            break label703;
          }
          localByteBuffer.put((byte)1);
          if (actor._cachedId == null) {
            break label678;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, actor._cachedId);
          actor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasOriginalUpdate) {
            break label738;
          }
          localByteBuffer.put((byte)1);
          if (originalUpdate._cachedId == null) {
            break label713;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, originalUpdate._cachedId);
          originalUpdate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasInsight) {
            break label748;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, insight);
          if (!hasHeader) {
            break label783;
          }
          localByteBuffer.put((byte)1);
          if (header._cachedId == null) {
            break label758;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, header._cachedId);
          header.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasViralType) {
            break label818;
          }
          localByteBuffer.put((byte)1);
          if (viralType._cachedId == null) {
            break label793;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, viralType._cachedId);
          viralType.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasTrackingId) {
            break label828;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasTracking) {
            break label863;
          }
          localByteBuffer.put((byte)1);
          if (tracking._cachedId == null) {
            break label838;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, tracking._cachedId);
          tracking.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label871;
          }
          if (str != null) {
            break label873;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          actor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label343;
          localByteBuffer.put((byte)0);
          break label343;
          localByteBuffer.put((byte)1);
          originalUpdate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label403;
          localByteBuffer.put((byte)0);
          break label403;
          localByteBuffer.put((byte)0);
          break label429;
          localByteBuffer.put((byte)1);
          header.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label489;
          localByteBuffer.put((byte)0);
          break label489;
          localByteBuffer.put((byte)1);
          viralType.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label549;
          localByteBuffer.put((byte)0);
          break label549;
          localByteBuffer.put((byte)0);
          break label575;
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
  
  public static final class ViralType
    implements FissileDataModel<ViralType>, UnionTemplate<ViralType>
  {
    public static final ViralUpdateBuilder.ViralTypeBuilder BUILDER = ViralUpdateBuilder.ViralTypeBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasViralCommentOnCommentTypeValue;
    public final boolean hasViralCommentTypeValue;
    public final boolean hasViralLikeOnCommentTypeValue;
    public final boolean hasViralLikeTypeValue;
    public final ViralCommentOnCommentType viralCommentOnCommentTypeValue;
    public final ViralCommentType viralCommentTypeValue;
    public final ViralLikeOnCommentType viralLikeOnCommentTypeValue;
    public final ViralLikeType viralLikeTypeValue;
    
    ViralType(ViralLikeType paramViralLikeType, ViralCommentType paramViralCommentType, ViralLikeOnCommentType paramViralLikeOnCommentType, ViralCommentOnCommentType paramViralCommentOnCommentType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      viralLikeTypeValue = paramViralLikeType;
      viralCommentTypeValue = paramViralCommentType;
      viralLikeOnCommentTypeValue = paramViralLikeOnCommentType;
      viralCommentOnCommentTypeValue = paramViralCommentOnCommentType;
      hasViralLikeTypeValue = paramBoolean1;
      hasViralCommentTypeValue = paramBoolean2;
      hasViralLikeOnCommentTypeValue = paramBoolean3;
      hasViralCommentOnCommentTypeValue = paramBoolean4;
      _cachedId = null;
    }
    
    public final ViralType accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label52:
      Object localObject3;
      boolean bool2;
      label91:
      label102:
      Object localObject4;
      boolean bool3;
      if (hasViralLikeTypeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ViralLikeType");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = ViralLikeType.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label249;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasViralCommentTypeValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ViralCommentType");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label258;
          }
          localObject1 = viralCommentTypeValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label276;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        localObject4 = null;
        bool3 = false;
        if (hasViralLikeOnCommentTypeValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ViralLikeOnCommentType");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label285;
          }
          localObject1 = ViralLikeOnCommentType.accept(paramDataProcessor);
          label138:
          if (localObject1 == null) {
            break label303;
          }
          bool3 = true;
          localObject4 = localObject1;
        }
        label150:
        localObject1 = null;
        bool4 = false;
        if (hasViralCommentOnCommentTypeValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ViralCommentOnCommentType");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label313;
          }
          localObject1 = ViralCommentOnCommentType.accept(paramDataProcessor);
          label186:
          if (localObject1 == null) {
            break label331;
          }
        }
      }
      label249:
      label258:
      label276:
      label285:
      label303:
      label313:
      label331:
      for (boolean bool4 = true;; bool4 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label337;
        }
        return new ViralType((ViralLikeType)localObject2, (ViralCommentType)localObject3, (ViralLikeOnCommentType)localObject4, (ViralCommentOnCommentType)localObject1, bool1, bool2, bool3, bool4);
        localObject1 = (ViralLikeType)paramDataProcessor.processDataTemplate(viralLikeTypeValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label52;
        localObject1 = (ViralCommentType)paramDataProcessor.processDataTemplate(viralCommentTypeValue);
        break label91;
        bool2 = false;
        localObject3 = localObject1;
        break label102;
        localObject1 = (ViralLikeOnCommentType)paramDataProcessor.processDataTemplate(viralLikeOnCommentTypeValue);
        break label138;
        bool3 = false;
        localObject4 = localObject1;
        break label150;
        localObject1 = (ViralCommentOnCommentType)paramDataProcessor.processDataTemplate(viralCommentOnCommentTypeValue);
        break label186;
      }
      label337:
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
        paramObject = (ViralType)paramObject;
        if (viralLikeTypeValue != null)
        {
          if (viralLikeTypeValue.equals(viralLikeTypeValue)) {}
        }
        else {
          while (viralLikeTypeValue != null) {
            return false;
          }
        }
        if (viralCommentTypeValue != null)
        {
          if (viralCommentTypeValue.equals(viralCommentTypeValue)) {}
        }
        else {
          while (viralCommentTypeValue != null) {
            return false;
          }
        }
        if (viralLikeOnCommentTypeValue != null)
        {
          if (viralLikeOnCommentTypeValue.equals(viralLikeOnCommentTypeValue)) {}
        }
        else {
          while (viralLikeOnCommentTypeValue != null) {
            return false;
          }
        }
        if (viralCommentOnCommentTypeValue == null) {
          break;
        }
      } while (viralCommentOnCommentTypeValue.equals(viralCommentOnCommentTypeValue));
      for (;;)
      {
        return false;
        if (viralCommentOnCommentTypeValue == null) {
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
      if (hasViralLikeTypeValue)
      {
        if (viralLikeTypeValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(viralLikeTypeValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasViralCommentTypeValue)
        {
          i = j + 1;
          if (viralCommentTypeValue._cachedId == null) {
            break label198;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(viralCommentTypeValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasViralLikeOnCommentTypeValue)
        {
          i = j + 1;
          if (viralLikeOnCommentTypeValue._cachedId == null) {
            break label211;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(viralLikeOnCommentTypeValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasViralCommentOnCommentTypeValue)
        {
          i = j + 1;
          if (viralCommentOnCommentTypeValue._cachedId == null) {
            break label224;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(viralCommentOnCommentTypeValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = viralLikeTypeValue.getSerializedSize() + 7;
        break;
        label198:
        i += viralCommentTypeValue.getSerializedSize();
        break label93;
        label211:
        i += viralLikeOnCommentTypeValue.getSerializedSize();
        break label135;
        label224:
        i += viralCommentOnCommentTypeValue.getSerializedSize();
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
      if (viralLikeTypeValue != null)
      {
        i = viralLikeTypeValue.hashCode();
        if (viralCommentTypeValue == null) {
          break label110;
        }
        j = viralCommentTypeValue.hashCode();
        label45:
        if (viralLikeOnCommentTypeValue == null) {
          break label115;
        }
      }
      label110:
      label115:
      for (int k = viralLikeOnCommentTypeValue.hashCode();; k = 0)
      {
        if (viralCommentOnCommentTypeValue != null) {
          m = viralCommentOnCommentTypeValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ViralType");
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
      label290:
      label418:
      label443:
      label453:
      label478:
      label488:
      label513:
      label521:
      label523:
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
          localByteBuffer.putInt(1982842573);
          if (hasViralLikeTypeValue)
          {
            localByteBuffer.put((byte)1);
            if (viralLikeTypeValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, viralLikeTypeValue._cachedId);
              viralLikeTypeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasViralCommentTypeValue) {
                break label443;
              }
              localByteBuffer.put((byte)1);
              if (viralCommentTypeValue._cachedId == null) {
                break label418;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, viralCommentTypeValue._cachedId);
              viralCommentTypeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasViralLikeOnCommentTypeValue) {
                break label478;
              }
              localByteBuffer.put((byte)1);
              if (viralLikeOnCommentTypeValue._cachedId == null) {
                break label453;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, viralLikeOnCommentTypeValue._cachedId);
              viralLikeOnCommentTypeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasViralCommentOnCommentTypeValue) {
                break label513;
              }
              localByteBuffer.put((byte)1);
              if (viralCommentOnCommentTypeValue._cachedId == null) {
                break label488;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, viralCommentOnCommentTypeValue._cachedId);
              viralCommentOnCommentTypeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label521;
            }
            if (str != null) {
              break label523;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            viralLikeTypeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            viralCommentTypeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            viralLikeOnCommentTypeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label290;
            localByteBuffer.put((byte)0);
            break label290;
            localByteBuffer.put((byte)1);
            viralCommentOnCommentTypeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */