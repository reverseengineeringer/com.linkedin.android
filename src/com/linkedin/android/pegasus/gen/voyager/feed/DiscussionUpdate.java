package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class DiscussionUpdate
  implements FissileDataModel<DiscussionUpdate>, RecordTemplate<DiscussionUpdate>
{
  public static final DiscussionUpdateBuilder BUILDER = DiscussionUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<UpdateAction> actions;
  public final boolean active;
  public final SocialActor actor;
  public final DiscussionUpdateContent.Content content;
  public final long createdTime;
  public final DiscussionSource discussionSource;
  public final boolean featured;
  public final boolean hasActions;
  public final boolean hasActive;
  public final boolean hasActor;
  public final boolean hasContent;
  public final boolean hasCreatedTime;
  public final boolean hasDiscussionSource;
  public final boolean hasFeatured;
  public final boolean hasId;
  public final boolean hasMiniGroup;
  public final boolean hasTracking;
  public final boolean hasTrackingId;
  public final boolean hasUrn;
  public final String id;
  public final MiniGroup miniGroup;
  public final TrackingData tracking;
  public final String trackingId;
  public final Urn urn;
  
  DiscussionUpdate(DiscussionUpdateContent.Content paramContent, List<UpdateAction> paramList, String paramString1, Urn paramUrn, DiscussionSource paramDiscussionSource, SocialActor paramSocialActor, MiniGroup paramMiniGroup, boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString2, TrackingData paramTrackingData, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14)
  {
    content = paramContent;
    if (paramList == null) {}
    for (paramContent = null;; paramContent = Collections.unmodifiableList(paramList))
    {
      actions = paramContent;
      id = paramString1;
      urn = paramUrn;
      discussionSource = paramDiscussionSource;
      actor = paramSocialActor;
      miniGroup = paramMiniGroup;
      featured = paramBoolean1;
      active = paramBoolean2;
      createdTime = paramLong;
      trackingId = paramString2;
      tracking = paramTrackingData;
      hasContent = paramBoolean3;
      hasActions = paramBoolean4;
      hasId = paramBoolean5;
      hasUrn = paramBoolean6;
      hasDiscussionSource = paramBoolean7;
      hasActor = paramBoolean8;
      hasMiniGroup = paramBoolean9;
      hasFeatured = paramBoolean10;
      hasActive = paramBoolean11;
      hasCreatedTime = paramBoolean12;
      hasTrackingId = paramBoolean13;
      hasTracking = paramBoolean14;
      _cachedId = null;
      return;
    }
  }
  
  public final DiscussionUpdate accept(DataProcessor paramDataProcessor)
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
      localObject1 = (DiscussionUpdateContent.Content)paramDataProcessor.processDataTemplate(content);
      break;
      bool1 = false;
      localObject3 = localObject1;
      break label56;
    }
    label247:
    paramDataProcessor.endArray();
    label261:
    boolean bool3;
    label384:
    label396:
    Object localObject5;
    boolean bool4;
    if (localObject1 != null)
    {
      bool2 = true;
      if (hasId)
      {
        paramDataProcessor.startRecordField$505cff1c("id");
        paramDataProcessor.processString(id);
      }
      if (hasUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("urn");
        localObject2 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(urn));
      }
      if (hasDiscussionSource)
      {
        paramDataProcessor.startRecordField$505cff1c("discussionSource");
        paramDataProcessor.processEnum(discussionSource);
      }
      localObject4 = null;
      bool3 = false;
      if (hasActor)
      {
        paramDataProcessor.startRecordField$505cff1c("actor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label659;
        }
        localObject2 = actor.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label677;
        }
        bool3 = true;
        localObject4 = localObject2;
      }
      localObject5 = null;
      bool4 = false;
      if (hasMiniGroup)
      {
        paramDataProcessor.startRecordField$505cff1c("miniGroup");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label687;
        }
        localObject2 = miniGroup.accept(paramDataProcessor);
        label436:
        if (localObject2 == null) {
          break label705;
        }
        bool4 = true;
        localObject5 = localObject2;
      }
      label448:
      if (hasFeatured)
      {
        paramDataProcessor.startRecordField$505cff1c("featured");
        paramDataProcessor.processBoolean(featured);
      }
      if (hasActive)
      {
        paramDataProcessor.startRecordField$505cff1c("active");
        paramDataProcessor.processBoolean(active);
      }
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
      bool5 = false;
      if (hasTracking)
      {
        paramDataProcessor.startRecordField$505cff1c("tracking");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label715;
        }
        localObject2 = tracking.accept(paramDataProcessor);
        label588:
        if (localObject2 == null) {
          break label733;
        }
      }
    }
    label659:
    label677:
    label687:
    label705:
    label715:
    label733:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label933;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasContent) {
          break label739;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "content");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool2 = false;
      break;
      localObject2 = (SocialActor)paramDataProcessor.processDataTemplate(actor);
      break label384;
      bool3 = false;
      localObject4 = localObject2;
      break label396;
      localObject2 = (MiniGroup)paramDataProcessor.processDataTemplate(miniGroup);
      break label436;
      bool4 = false;
      localObject5 = localObject2;
      break label448;
      localObject2 = (TrackingData)paramDataProcessor.processDataTemplate(tracking);
      break label588;
    }
    label739:
    if (!hasActor) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "actor");
    }
    if (!hasMiniGroup) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "miniGroup");
    }
    if (!hasCreatedTime) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "createdTime");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "actions");
        }
      }
    }
    return new DiscussionUpdate((DiscussionUpdateContent.Content)localObject3, (List)localObject1, id, urn, discussionSource, (SocialActor)localObject4, (MiniGroup)localObject5, featured, active, createdTime, trackingId, (TrackingData)localObject2, bool1, bool2, hasId, hasUrn, hasDiscussionSource, bool3, bool4, hasFeatured, hasActive, hasCreatedTime, hasTrackingId, bool5);
    label933:
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
      paramObject = (DiscussionUpdate)paramObject;
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
      if (id != null)
      {
        if (id.equals(id)) {}
      }
      else {
        while (id != null) {
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
      if (discussionSource != null)
      {
        if (discussionSource.equals(discussionSource)) {}
      }
      else {
        while (discussionSource != null) {
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
      if (miniGroup != null)
      {
        if (miniGroup.equals(miniGroup)) {}
      }
      else {
        while (miniGroup != null) {
          return false;
        }
      }
      if (featured != featured) {
        return false;
      }
      if (active != active) {
        return false;
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
    if (hasId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(id);
    }
    int j = i + 1;
    i = j;
    if (hasUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(urn));
    }
    j = i + 1;
    i = j;
    if (hasDiscussionSource) {
      i = j + 2;
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
      if (hasMiniGroup)
      {
        i = j + 1;
        if (miniGroup._cachedId == null) {
          break label450;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniGroup._cachedId);
      }
      label311:
      j = i + 1;
      i = j;
      if (hasFeatured) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasActive) {
        i = j + 1;
      }
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
          break label463;
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
      label450:
      i += miniGroup.getSerializedSize();
      break label311;
      label463:
      i += tracking.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i4 = 1;
    int i6 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label50:
    int k;
    label65:
    int m;
    label81:
    int n;
    label97:
    int i1;
    label113:
    int i2;
    label129:
    int i3;
    label139:
    label146:
    int i7;
    if (content != null)
    {
      i = content.hashCode();
      if (actions == null) {
        break label275;
      }
      j = actions.hashCode();
      if (id == null) {
        break label280;
      }
      k = id.hashCode();
      if (urn == null) {
        break label285;
      }
      m = urn.hashCode();
      if (discussionSource == null) {
        break label291;
      }
      n = discussionSource.hashCode();
      if (actor == null) {
        break label297;
      }
      i1 = actor.hashCode();
      if (miniGroup == null) {
        break label303;
      }
      i2 = miniGroup.hashCode();
      if (!featured) {
        break label309;
      }
      i3 = 1;
      if (!active) {
        break label315;
      }
      i7 = (int)(createdTime ^ createdTime >>> 32);
      if (trackingId == null) {
        break label321;
      }
    }
    label275:
    label280:
    label285:
    label291:
    label297:
    label303:
    label309:
    label315:
    label321:
    for (int i5 = trackingId.hashCode();; i5 = 0)
    {
      if (tracking != null) {
        i6 = tracking.hashCode();
      }
      i = (i5 + (((i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4) * 31 + i7) * 31) * 31 + i6;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label50;
      k = 0;
      break label65;
      m = 0;
      break label81;
      n = 0;
      break label97;
      i1 = 0;
      break label113;
      i2 = 0;
      break label129;
      i3 = 0;
      break label139;
      i4 = 0;
      break label146;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building DiscussionUpdate");
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
    label404:
    label433:
    label493:
    label553:
    label577:
    label586:
    label610:
    label619:
    label643:
    label669:
    label772:
    label782:
    label792:
    label817:
    label827:
    label852:
    label862:
    label868:
    label878:
    label884:
    label894:
    label904:
    label914:
    label939:
    label947:
    label949:
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
        localByteBuffer.putInt(-767731381);
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
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasUrn) {
            break label772;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasDiscussionSource) {
            break label782;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, discussionSource.ordinal());
          if (!hasActor) {
            break label817;
          }
          localByteBuffer.put((byte)1);
          if (actor._cachedId == null) {
            break label792;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, actor._cachedId);
          actor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasMiniGroup) {
            break label852;
          }
          localByteBuffer.put((byte)1);
          if (miniGroup._cachedId == null) {
            break label827;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniGroup._cachedId);
          miniGroup.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasFeatured) {
            break label868;
          }
          localByteBuffer.put((byte)1);
          if (!featured) {
            break label862;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasActive) {
            break label884;
          }
          localByteBuffer.put((byte)1);
          if (!active) {
            break label878;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasCreatedTime) {
            break label894;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(createdTime);
          if (!hasTrackingId) {
            break label904;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasTracking) {
            break label939;
          }
          localByteBuffer.put((byte)1);
          if (tracking._cachedId == null) {
            break label914;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, tracking._cachedId);
          tracking.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label947;
          }
          if (str != null) {
            break label949;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label404;
          localByteBuffer.put((byte)0);
          break label433;
          localByteBuffer.put((byte)1);
          actor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label493;
          localByteBuffer.put((byte)0);
          break label493;
          localByteBuffer.put((byte)1);
          miniGroup.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label553;
          localByteBuffer.put((byte)0);
          break label553;
          i = 0;
          break label577;
          localByteBuffer.put((byte)0);
          break label586;
          i = 0;
          break label610;
          localByteBuffer.put((byte)0);
          break label619;
          localByteBuffer.put((byte)0);
          break label643;
          localByteBuffer.put((byte)0);
          break label669;
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
  
  public static final class Builder
    implements RecordTemplateBuilder<DiscussionUpdate>
  {
    private List<UpdateAction> actions = null;
    private boolean active = false;
    private SocialActor actor = null;
    private DiscussionUpdateContent.Content content = null;
    private long createdTime = 0L;
    private DiscussionSource discussionSource = null;
    private boolean featured = false;
    private boolean hasActions = false;
    private boolean hasActive = false;
    private boolean hasActor = false;
    private boolean hasContent = false;
    private boolean hasCreatedTime = false;
    private boolean hasDiscussionSource = false;
    private boolean hasFeatured = false;
    private boolean hasId = false;
    private boolean hasMiniGroup = false;
    private boolean hasTracking = false;
    private boolean hasTrackingId = false;
    private boolean hasUrn = false;
    private String id = null;
    private MiniGroup miniGroup = null;
    private TrackingData tracking = null;
    private String trackingId = null;
    private Urn urn = null;
    
    public final DiscussionUpdate build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (DiscussionUpdate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (actions != null)
      {
        paramFlavor = actions.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((UpdateAction)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "actions");
              if (!hasActions) {
                actions = Collections.emptyList();
              }
              if (!hasContent) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "content");
              }
              if (!hasActor) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "actor");
              }
              if (!hasMiniGroup) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "miniGroup");
              }
              if (hasCreatedTime) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate", "createdTime");
            }
          }
        }
      }
      return new DiscussionUpdate(content, actions, id, urn, discussionSource, actor, miniGroup, featured, active, createdTime, trackingId, tracking, hasContent, hasActions, hasId, hasUrn, hasDiscussionSource, hasActor, hasMiniGroup, hasFeatured, hasActive, hasCreatedTime, hasTrackingId, hasTracking);
    }
    
    public final Builder setActions(List<UpdateAction> paramList)
    {
      if ((paramList == null) || (paramList.equals(Collections.emptyList())))
      {
        hasActions = false;
        actions = Collections.emptyList();
        return this;
      }
      hasActions = true;
      actions = paramList;
      return this;
    }
    
    public final Builder setActive(Boolean paramBoolean)
    {
      if (paramBoolean == null)
      {
        hasActive = false;
        active = false;
        return this;
      }
      hasActive = true;
      active = paramBoolean.booleanValue();
      return this;
    }
    
    public final Builder setActor(SocialActor paramSocialActor)
    {
      if (paramSocialActor == null)
      {
        hasActor = false;
        actor = null;
        return this;
      }
      hasActor = true;
      actor = paramSocialActor;
      return this;
    }
    
    public final Builder setContent(DiscussionUpdateContent.Content paramContent)
    {
      if (paramContent == null)
      {
        hasContent = false;
        content = null;
        return this;
      }
      hasContent = true;
      content = paramContent;
      return this;
    }
    
    public final Builder setCreatedTime(Long paramLong)
    {
      if (paramLong == null)
      {
        hasCreatedTime = false;
        createdTime = 0L;
        return this;
      }
      hasCreatedTime = true;
      createdTime = paramLong.longValue();
      return this;
    }
    
    public final Builder setDiscussionSource(DiscussionSource paramDiscussionSource)
    {
      if (paramDiscussionSource == null)
      {
        hasDiscussionSource = false;
        discussionSource = null;
        return this;
      }
      hasDiscussionSource = true;
      discussionSource = paramDiscussionSource;
      return this;
    }
    
    public final Builder setFeatured(Boolean paramBoolean)
    {
      if (paramBoolean == null)
      {
        hasFeatured = false;
        featured = false;
        return this;
      }
      hasFeatured = true;
      featured = paramBoolean.booleanValue();
      return this;
    }
    
    public final Builder setMiniGroup(MiniGroup paramMiniGroup)
    {
      if (paramMiniGroup == null)
      {
        hasMiniGroup = false;
        miniGroup = null;
        return this;
      }
      hasMiniGroup = true;
      miniGroup = paramMiniGroup;
      return this;
    }
    
    public final Builder setUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasUrn = false;
        urn = null;
        return this;
      }
      hasUrn = true;
      urn = paramUrn;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */