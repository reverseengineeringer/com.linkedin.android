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
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ShareUpdate
  implements FissileDataModel<ShareUpdate>, RecordTemplate<ShareUpdate>
{
  public static final ShareUpdateBuilder BUILDER = ShareUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<UpdateAction> actions;
  public final SocialActor actor;
  public final ShareUpdateContent.Content content;
  public final long createdTime;
  public final boolean edited;
  public final boolean hasActions;
  public final boolean hasActor;
  public final boolean hasContent;
  public final boolean hasCreatedTime;
  public final boolean hasEdited;
  public final boolean hasHeader;
  public final boolean hasShareAudience;
  public final boolean hasShareUrn;
  public final boolean hasTracking;
  public final boolean hasTrackingId;
  public final boolean hasUrn;
  public final AttributedText header;
  public final ShareAudience shareAudience;
  public final Urn shareUrn;
  public final TrackingData tracking;
  public final String trackingId;
  public final Urn urn;
  
  ShareUpdate(ShareUpdateContent.Content paramContent, ShareAudience paramShareAudience, List<UpdateAction> paramList, Urn paramUrn1, SocialActor paramSocialActor, long paramLong, String paramString, TrackingData paramTrackingData, AttributedText paramAttributedText, boolean paramBoolean1, Urn paramUrn2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12)
  {
    content = paramContent;
    shareAudience = paramShareAudience;
    if (paramList == null) {}
    for (paramContent = null;; paramContent = Collections.unmodifiableList(paramList))
    {
      actions = paramContent;
      urn = paramUrn1;
      actor = paramSocialActor;
      createdTime = paramLong;
      trackingId = paramString;
      tracking = paramTrackingData;
      header = paramAttributedText;
      edited = paramBoolean1;
      shareUrn = paramUrn2;
      hasContent = paramBoolean2;
      hasShareAudience = paramBoolean3;
      hasActions = paramBoolean4;
      hasUrn = paramBoolean5;
      hasActor = paramBoolean6;
      hasCreatedTime = paramBoolean7;
      hasTrackingId = paramBoolean8;
      hasTracking = paramBoolean9;
      hasHeader = paramBoolean10;
      hasEdited = paramBoolean11;
      hasShareUrn = paramBoolean12;
      _cachedId = null;
      return;
    }
  }
  
  public final ShareUpdate accept(DataProcessor paramDataProcessor)
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
          break label247;
        }
        bool1 = true;
        localObject3 = localObject1;
      }
    }
    else
    {
      if (hasShareAudience)
      {
        paramDataProcessor.startRecordField$505cff1c("shareAudience");
        paramDataProcessor.processEnum(shareAudience);
      }
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasActions) {
        break label286;
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
      label156:
      if (!((Iterator)localObject4).hasNext()) {
        break label272;
      }
      localObject2 = (UpdateAction)((Iterator)localObject4).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label256;
      }
    }
    label247:
    label256:
    for (Object localObject2 = ((UpdateAction)localObject2).accept(paramDataProcessor);; localObject2 = (UpdateAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label156;
      localObject1 = (ShareUpdateContent.Content)paramDataProcessor.processDataTemplate(content);
      break;
      bool1 = false;
      localObject3 = localObject1;
      break label56;
    }
    label272:
    paramDataProcessor.endArray();
    label286:
    boolean bool3;
    label359:
    label371:
    Object localObject5;
    boolean bool4;
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
          break label642;
        }
        localObject2 = actor.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label660;
        }
        bool3 = true;
        localObject4 = localObject2;
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
      localObject5 = null;
      bool4 = false;
      if (hasTracking)
      {
        paramDataProcessor.startRecordField$505cff1c("tracking");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label670;
        }
        localObject2 = tracking.accept(paramDataProcessor);
        label461:
        if (localObject2 == null) {
          break label688;
        }
        bool4 = true;
        localObject5 = localObject2;
      }
      label473:
      localObject2 = null;
      bool5 = false;
      if (hasHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("header");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label698;
        }
        localObject2 = header.accept(paramDataProcessor);
        label513:
        if (localObject2 == null) {
          break label716;
        }
      }
    }
    label642:
    label660:
    label670:
    label688:
    label698:
    label716:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (hasEdited)
      {
        paramDataProcessor.startRecordField$505cff1c("edited");
        paramDataProcessor.processBoolean(edited);
      }
      if (hasShareUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("shareUrn");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(shareUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label908;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasContent) {
          break label722;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "content");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool2 = false;
      break;
      localObject2 = (SocialActor)paramDataProcessor.processDataTemplate(actor);
      break label359;
      bool3 = false;
      localObject4 = localObject2;
      break label371;
      localObject2 = (TrackingData)paramDataProcessor.processDataTemplate(tracking);
      break label461;
      bool4 = false;
      localObject5 = localObject2;
      break label473;
      localObject2 = (AttributedText)paramDataProcessor.processDataTemplate(header);
      break label513;
    }
    label722:
    if (!hasShareAudience) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "shareAudience");
    }
    if (!hasActor) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "actor");
    }
    if (!hasCreatedTime) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "createdTime");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "actions");
        }
      }
    }
    return new ShareUpdate((ShareUpdateContent.Content)localObject3, shareAudience, (List)localObject1, urn, (SocialActor)localObject4, createdTime, trackingId, (TrackingData)localObject5, (AttributedText)localObject2, edited, shareUrn, bool1, hasShareAudience, bool2, hasUrn, bool3, hasCreatedTime, hasTrackingId, bool4, bool5, hasEdited, hasShareUrn);
    label908:
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
      paramObject = (ShareUpdate)paramObject;
      if (content != null)
      {
        if (content.equals(content)) {}
      }
      else {
        while (content != null) {
          return false;
        }
      }
      if (shareAudience != null)
      {
        if (shareAudience.equals(shareAudience)) {}
      }
      else {
        while (shareAudience != null) {
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
      if (tracking != null)
      {
        if (tracking.equals(tracking)) {}
      }
      else {
        while (tracking != null) {
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
      if (edited != edited) {
        return false;
      }
      if (shareUrn == null) {
        break;
      }
    } while (shareUrn.equals(shareUrn));
    for (;;)
    {
      return false;
      if (shareUrn == null) {
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
      j = i + 1;
      i = j;
      if (hasShareAudience) {
        i = j + 2;
      }
      i += 1;
      j = i;
      if (!hasActions) {
        break label170;
      }
      i += 2;
      localObject = actions.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label170;
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
    label170:
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
          break label440;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(tracking._cachedId);
      }
      label329:
      j = i + 1;
      i = j;
      if (hasHeader)
      {
        i = j + 1;
        if (header._cachedId == null) {
          break label453;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(header._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasEdited) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasShareUrn)
      {
        localObject = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(shareUrn));
      }
      __sizeOfObject = i;
      return i;
      i += actor.getSerializedSize();
      break;
      label440:
      i += tracking.getSerializedSize();
      break label329;
      label453:
      i += header.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i5 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label62:
    int m;
    label78:
    int n;
    label94:
    int i6;
    int i1;
    label125:
    int i2;
    label141:
    int i3;
    if (content != null)
    {
      i = content.hashCode();
      if (shareAudience == null) {
        break label259;
      }
      j = shareAudience.hashCode();
      if (actions == null) {
        break label264;
      }
      k = actions.hashCode();
      if (urn == null) {
        break label269;
      }
      m = urn.hashCode();
      if (actor == null) {
        break label275;
      }
      n = actor.hashCode();
      i6 = (int)(createdTime ^ createdTime >>> 32);
      if (trackingId == null) {
        break label281;
      }
      i1 = trackingId.hashCode();
      if (tracking == null) {
        break label287;
      }
      i2 = tracking.hashCode();
      if (header == null) {
        break label293;
      }
      i3 = header.hashCode();
      label157:
      if (!edited) {
        break label299;
      }
    }
    label259:
    label264:
    label269:
    label275:
    label281:
    label287:
    label293:
    label299:
    for (int i4 = 1;; i4 = 0)
    {
      if (shareUrn != null) {
        i5 = shareUrn.hashCode();
      }
      i = (i4 + (i3 + (i2 + (i1 + ((n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i6) * 31) * 31) * 31) * 31) * 31 + i5;
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
      n = 0;
      break label94;
      i1 = 0;
      break label125;
      i2 = 0;
      break label141;
      i3 = 0;
      break label157;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ShareUpdate");
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
    label201:
    label343:
    label376:
    label383:
    label477:
    label501:
    label527:
    label587:
    label647:
    label671:
    label680:
    label757:
    label782:
    label792:
    label802:
    label812:
    label837:
    label847:
    label872:
    label882:
    label888:
    label898:
    label906:
    label908:
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
        localByteBuffer.putInt(-659898025);
        Object localObject;
        if (hasContent)
        {
          localByteBuffer.put((byte)1);
          if (content._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, content._cachedId);
            content.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasShareAudience) {
              break label343;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, shareAudience.ordinal());
            if (!hasActions) {
              break label376;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
            localObject = actions.iterator();
          }
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label383;
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
            localByteBuffer.put((byte)0);
            break label201;
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
            break label782;
          }
          localByteBuffer.put((byte)1);
          if (actor._cachedId == null) {
            break label757;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, actor._cachedId);
          actor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCreatedTime) {
            break label792;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(createdTime);
          if (!hasTrackingId) {
            break label802;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasTracking) {
            break label837;
          }
          localByteBuffer.put((byte)1);
          if (tracking._cachedId == null) {
            break label812;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, tracking._cachedId);
          tracking.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasHeader) {
            break label872;
          }
          localByteBuffer.put((byte)1);
          if (header._cachedId == null) {
            break label847;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, header._cachedId);
          header.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasEdited) {
            break label888;
          }
          localByteBuffer.put((byte)1);
          if (!edited) {
            break label882;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasShareUrn) {
            break label898;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(shareUrn));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label906;
          }
          if (str != null) {
            break label908;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          actor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label477;
          localByteBuffer.put((byte)0);
          break label477;
          localByteBuffer.put((byte)0);
          break label501;
          localByteBuffer.put((byte)0);
          break label527;
          localByteBuffer.put((byte)1);
          tracking.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label587;
          localByteBuffer.put((byte)0);
          break label587;
          localByteBuffer.put((byte)1);
          header.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label647;
          localByteBuffer.put((byte)0);
          break label647;
          i = 0;
          break label671;
          localByteBuffer.put((byte)0);
          break label680;
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
    implements RecordTemplateBuilder<ShareUpdate>
  {
    public List<UpdateAction> actions = null;
    public SocialActor actor = null;
    private ShareUpdateContent.Content content = null;
    public long createdTime = 0L;
    public boolean edited = false;
    public boolean hasActions = false;
    public boolean hasActor = false;
    private boolean hasContent = false;
    public boolean hasCreatedTime = false;
    public boolean hasEdited = false;
    private boolean hasHeader = false;
    public boolean hasShareAudience = false;
    private boolean hasShareUrn = false;
    private boolean hasTracking = false;
    private boolean hasTrackingId = false;
    public boolean hasUrn = false;
    private AttributedText header = null;
    public ShareAudience shareAudience = null;
    private Urn shareUrn = null;
    private TrackingData tracking = null;
    private String trackingId = null;
    public Urn urn = null;
    
    public Builder() {}
    
    public Builder(ShareUpdate paramShareUpdate)
    {
      content = content;
      shareAudience = shareAudience;
      actions = actions;
      urn = urn;
      actor = actor;
      createdTime = createdTime;
      trackingId = trackingId;
      tracking = tracking;
      header = header;
      edited = edited;
      shareUrn = shareUrn;
      hasContent = hasContent;
      hasShareAudience = hasShareAudience;
      hasActions = hasActions;
      hasUrn = hasUrn;
      hasActor = hasActor;
      hasCreatedTime = hasCreatedTime;
      hasTrackingId = hasTrackingId;
      hasTracking = hasTracking;
      hasHeader = hasHeader;
      hasEdited = hasEdited;
      hasShareUrn = hasShareUrn;
    }
    
    public final ShareUpdate build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
    
    public final ShareUpdate build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ShareUpdate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
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
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "actions");
              if (!hasActions) {
                actions = Collections.emptyList();
              }
              if (!hasContent) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "content");
              }
              if (!hasShareAudience) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "shareAudience");
              }
              if (!hasActor) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "actor");
              }
              if (hasCreatedTime) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate", "createdTime");
            }
          }
        }
      }
      return new ShareUpdate(content, shareAudience, actions, urn, actor, createdTime, trackingId, tracking, header, edited, shareUrn, hasContent, hasShareAudience, hasActions, hasUrn, hasActor, hasCreatedTime, hasTrackingId, hasTracking, hasHeader, hasEdited, hasShareUrn);
    }
    
    public final Builder setContent(ShareUpdateContent.Content paramContent)
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
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */