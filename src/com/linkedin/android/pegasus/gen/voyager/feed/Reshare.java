package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
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

public final class Reshare
  implements FissileDataModel<Reshare>, RecordTemplate<Reshare>
{
  public static final ReshareBuilder BUILDER = ReshareBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<UpdateAction> actions;
  public final SocialActor actor;
  public final AttributedText attributedText;
  public final long createdTime;
  public final boolean edited;
  public final boolean hasActions;
  public final boolean hasActor;
  public final boolean hasAttributedText;
  public final boolean hasCreatedTime;
  public final boolean hasEdited;
  public final boolean hasHeader;
  public final boolean hasOriginalUpdate;
  public final boolean hasShareAudience;
  public final boolean hasShareUrn;
  public final boolean hasText;
  public final boolean hasTracking;
  public final boolean hasTrackingId;
  public final boolean hasUrn;
  public final AttributedText header;
  public final Update originalUpdate;
  public final ShareAudience shareAudience;
  public final Urn shareUrn;
  public final AnnotatedText text;
  public final TrackingData tracking;
  public final String trackingId;
  public final Urn urn;
  
  Reshare(ShareAudience paramShareAudience, List<UpdateAction> paramList, Urn paramUrn1, AnnotatedText paramAnnotatedText, AttributedText paramAttributedText1, Update paramUpdate, SocialActor paramSocialActor, long paramLong, String paramString, TrackingData paramTrackingData, AttributedText paramAttributedText2, boolean paramBoolean1, Urn paramUrn2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14)
  {
    shareAudience = paramShareAudience;
    if (paramList == null) {}
    for (paramShareAudience = null;; paramShareAudience = Collections.unmodifiableList(paramList))
    {
      actions = paramShareAudience;
      urn = paramUrn1;
      text = paramAnnotatedText;
      attributedText = paramAttributedText1;
      originalUpdate = paramUpdate;
      actor = paramSocialActor;
      createdTime = paramLong;
      trackingId = paramString;
      tracking = paramTrackingData;
      header = paramAttributedText2;
      edited = paramBoolean1;
      shareUrn = paramUrn2;
      hasShareAudience = paramBoolean2;
      hasActions = paramBoolean3;
      hasUrn = paramBoolean4;
      hasText = paramBoolean5;
      hasAttributedText = paramBoolean6;
      hasOriginalUpdate = paramBoolean7;
      hasActor = paramBoolean8;
      hasCreatedTime = paramBoolean9;
      hasTrackingId = paramBoolean10;
      hasTracking = paramBoolean11;
      hasHeader = paramBoolean12;
      hasEdited = paramBoolean13;
      hasShareUrn = paramBoolean14;
      _cachedId = null;
      return;
    }
  }
  
  public final Reshare accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasShareAudience)
    {
      paramDataProcessor.startRecordField$505cff1c("shareAudience");
      paramDataProcessor.processEnum(shareAudience);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject3;
    boolean bool2;
    label280:
    label292:
    Object localObject4;
    boolean bool3;
    label332:
    label344:
    Object localObject5;
    boolean bool4;
    label384:
    label396:
    Object localObject6;
    boolean bool5;
    label436:
    label448:
    Object localObject7;
    boolean bool6;
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
      if (hasText)
      {
        paramDataProcessor.startRecordField$505cff1c("text");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label721;
        }
        localObject2 = text.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label739;
        }
        bool2 = true;
        localObject3 = localObject2;
      }
      localObject4 = null;
      bool3 = false;
      if (hasAttributedText)
      {
        paramDataProcessor.startRecordField$505cff1c("attributedText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label749;
        }
        localObject2 = attributedText.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label767;
        }
        bool3 = true;
        localObject4 = localObject2;
      }
      localObject5 = null;
      bool4 = false;
      if (hasOriginalUpdate)
      {
        paramDataProcessor.startRecordField$505cff1c("originalUpdate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label777;
        }
        localObject2 = originalUpdate.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label795;
        }
        bool4 = true;
        localObject5 = localObject2;
      }
      localObject6 = null;
      bool5 = false;
      if (hasActor)
      {
        paramDataProcessor.startRecordField$505cff1c("actor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label805;
        }
        localObject2 = actor.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label823;
        }
        bool5 = true;
        localObject6 = localObject2;
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
      localObject7 = null;
      bool6 = false;
      if (hasTracking)
      {
        paramDataProcessor.startRecordField$505cff1c("tracking");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label833;
        }
        localObject2 = tracking.accept(paramDataProcessor);
        label538:
        if (localObject2 == null) {
          break label851;
        }
        bool6 = true;
        localObject7 = localObject2;
      }
      label550:
      localObject2 = null;
      bool7 = false;
      if (hasHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("header");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label861;
        }
        localObject2 = header.accept(paramDataProcessor);
        label591:
        if (localObject2 == null) {
          break label879;
        }
      }
    }
    label721:
    label739:
    label749:
    label767:
    label777:
    label795:
    label805:
    label823:
    label833:
    label851:
    label861:
    label879:
    for (boolean bool7 = true;; bool7 = false)
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
        break label1079;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasShareAudience) {
          break label885;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "shareAudience");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      break;
      localObject2 = (AnnotatedText)paramDataProcessor.processDataTemplate(text);
      break label280;
      bool2 = false;
      localObject3 = localObject2;
      break label292;
      localObject2 = (AttributedText)paramDataProcessor.processDataTemplate(attributedText);
      break label332;
      bool3 = false;
      localObject4 = localObject2;
      break label344;
      localObject2 = (Update)paramDataProcessor.processDataTemplate(originalUpdate);
      break label384;
      bool4 = false;
      localObject5 = localObject2;
      break label396;
      localObject2 = (SocialActor)paramDataProcessor.processDataTemplate(actor);
      break label436;
      bool5 = false;
      localObject6 = localObject2;
      break label448;
      localObject2 = (TrackingData)paramDataProcessor.processDataTemplate(tracking);
      break label538;
      bool6 = false;
      localObject7 = localObject2;
      break label550;
      localObject2 = (AttributedText)paramDataProcessor.processDataTemplate(header);
      break label591;
    }
    label885:
    if (!hasOriginalUpdate) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "originalUpdate");
    }
    if (!hasActor) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "actor");
    }
    if (!hasCreatedTime) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "createdTime");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "actions");
        }
      }
    }
    return new Reshare(shareAudience, (List)localObject1, urn, (AnnotatedText)localObject3, (AttributedText)localObject4, (Update)localObject5, (SocialActor)localObject6, createdTime, trackingId, (TrackingData)localObject7, (AttributedText)localObject2, edited, shareUrn, hasShareAudience, bool1, hasUrn, bool2, bool3, bool4, bool5, hasCreatedTime, hasTrackingId, bool6, bool7, hasEdited, hasShareUrn);
    label1079:
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
      paramObject = (Reshare)paramObject;
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
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (attributedText != null)
      {
        if (attributedText.equals(attributedText)) {}
      }
      else {
        while (attributedText != null) {
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
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasShareAudience) {
      i = j + 2;
    }
    i += 1;
    j = i;
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
    if (hasText)
    {
      i = j + 1;
      if (text._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(text._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasAttributedText)
      {
        i = j + 1;
        if (attributedText._cachedId == null) {
          break label517;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(attributedText._cachedId);
      }
      label237:
      j = i + 1;
      i = j;
      if (hasOriginalUpdate)
      {
        i = j + 1;
        if (originalUpdate._cachedId == null) {
          break label530;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(originalUpdate._cachedId);
      }
      label279:
      j = i + 1;
      i = j;
      if (hasActor)
      {
        i = j + 1;
        if (actor._cachedId == null) {
          break label543;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(actor._cachedId);
      }
      label321:
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
          break label556;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(tracking._cachedId);
      }
      label406:
      j = i + 1;
      i = j;
      if (hasHeader)
      {
        i = j + 1;
        if (header._cachedId == null) {
          break label569;
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
      i += text.getSerializedSize();
      break;
      label517:
      i += attributedText.getSerializedSize();
      break label237;
      label530:
      i += originalUpdate.getSerializedSize();
      break label279;
      label543:
      i += actor.getSerializedSize();
      break label321;
      label556:
      i += tracking.getSerializedSize();
      break label406;
      label569:
      i += header.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i7 = 0;
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
    int i8;
    int i3;
    label157:
    int i4;
    label173:
    int i5;
    if (shareAudience != null)
    {
      i = shareAudience.hashCode();
      if (actions == null) {
        break label303;
      }
      j = actions.hashCode();
      if (urn == null) {
        break label308;
      }
      k = urn.hashCode();
      if (text == null) {
        break label313;
      }
      m = text.hashCode();
      if (attributedText == null) {
        break label319;
      }
      n = attributedText.hashCode();
      if (originalUpdate == null) {
        break label325;
      }
      i1 = originalUpdate.hashCode();
      if (actor == null) {
        break label331;
      }
      i2 = actor.hashCode();
      i8 = (int)(createdTime ^ createdTime >>> 32);
      if (trackingId == null) {
        break label337;
      }
      i3 = trackingId.hashCode();
      if (tracking == null) {
        break label343;
      }
      i4 = tracking.hashCode();
      if (header == null) {
        break label349;
      }
      i5 = header.hashCode();
      label189:
      if (!edited) {
        break label355;
      }
    }
    label303:
    label308:
    label313:
    label319:
    label325:
    label331:
    label337:
    label343:
    label349:
    label355:
    for (int i6 = 1;; i6 = 0)
    {
      if (shareUrn != null) {
        i7 = shareUrn.hashCode();
      }
      i = (i6 + (i5 + (i4 + (i3 + ((i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i8) * 31) * 31) * 31) * 31) * 31 + i7;
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
      i3 = 0;
      break label157;
      i4 = 0;
      break label173;
      i5 = 0;
      break label189;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Reshare");
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
    label288:
    label382:
    label442:
    label502:
    label562:
    label586:
    label612:
    label672:
    label732:
    label756:
    label765:
    label842:
    label867:
    label877:
    label902:
    label912:
    label937:
    label947:
    label972:
    label982:
    label992:
    label1002:
    label1027:
    label1037:
    label1062:
    label1072:
    label1078:
    label1088:
    label1096:
    label1098:
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
        localByteBuffer.putInt(1409261936);
        Object localObject;
        if (hasShareAudience)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, shareAudience.ordinal());
          if (hasActions)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
            localObject = actions.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label288;
            }
            UpdateAction localUpdateAction = (UpdateAction)((Iterator)localObject).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localUpdateAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            localUpdateAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
        }
        localByteBuffer.put((byte)0);
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasText) {
            break label867;
          }
          localByteBuffer.put((byte)1);
          if (text._cachedId == null) {
            break label842;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
          text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasAttributedText) {
            break label902;
          }
          localByteBuffer.put((byte)1);
          if (attributedText._cachedId == null) {
            break label877;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, attributedText._cachedId);
          attributedText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasOriginalUpdate) {
            break label937;
          }
          localByteBuffer.put((byte)1);
          if (originalUpdate._cachedId == null) {
            break label912;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, originalUpdate._cachedId);
          originalUpdate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasActor) {
            break label972;
          }
          localByteBuffer.put((byte)1);
          if (actor._cachedId == null) {
            break label947;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, actor._cachedId);
          actor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCreatedTime) {
            break label982;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(createdTime);
          if (!hasTrackingId) {
            break label992;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasTracking) {
            break label1027;
          }
          localByteBuffer.put((byte)1);
          if (tracking._cachedId == null) {
            break label1002;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, tracking._cachedId);
          tracking.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasHeader) {
            break label1062;
          }
          localByteBuffer.put((byte)1);
          if (header._cachedId == null) {
            break label1037;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, header._cachedId);
          header.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasEdited) {
            break label1078;
          }
          localByteBuffer.put((byte)1);
          if (!edited) {
            break label1072;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasShareUrn) {
            break label1088;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(shareUrn));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label1096;
          }
          if (str != null) {
            break label1098;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label382;
          localByteBuffer.put((byte)0);
          break label382;
          localByteBuffer.put((byte)1);
          attributedText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label442;
          localByteBuffer.put((byte)0);
          break label442;
          localByteBuffer.put((byte)1);
          originalUpdate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label502;
          localByteBuffer.put((byte)0);
          break label502;
          localByteBuffer.put((byte)1);
          actor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label562;
          localByteBuffer.put((byte)0);
          break label562;
          localByteBuffer.put((byte)0);
          break label586;
          localByteBuffer.put((byte)0);
          break label612;
          localByteBuffer.put((byte)1);
          tracking.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label672;
          localByteBuffer.put((byte)0);
          break label672;
          localByteBuffer.put((byte)1);
          header.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label732;
          localByteBuffer.put((byte)0);
          break label732;
          i = 0;
          break label756;
          localByteBuffer.put((byte)0);
          break label765;
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
    implements RecordTemplateBuilder<Reshare>
  {
    public List<UpdateAction> actions = null;
    public SocialActor actor = null;
    private AttributedText attributedText = null;
    public long createdTime = 0L;
    public boolean edited = false;
    public boolean hasActions = false;
    public boolean hasActor = false;
    private boolean hasAttributedText = false;
    public boolean hasCreatedTime = false;
    public boolean hasEdited = false;
    private boolean hasHeader = false;
    public boolean hasOriginalUpdate = false;
    public boolean hasShareAudience = false;
    private boolean hasShareUrn = false;
    private boolean hasText = false;
    private boolean hasTracking = false;
    private boolean hasTrackingId = false;
    public boolean hasUrn = false;
    private AttributedText header = null;
    public Update originalUpdate = null;
    public ShareAudience shareAudience = null;
    private Urn shareUrn = null;
    private AnnotatedText text = null;
    private TrackingData tracking = null;
    private String trackingId = null;
    public Urn urn = null;
    
    public Builder() {}
    
    public Builder(Reshare paramReshare)
    {
      shareAudience = shareAudience;
      actions = actions;
      urn = urn;
      text = text;
      attributedText = attributedText;
      originalUpdate = originalUpdate;
      actor = actor;
      createdTime = createdTime;
      trackingId = trackingId;
      tracking = tracking;
      header = header;
      edited = edited;
      shareUrn = shareUrn;
      hasShareAudience = hasShareAudience;
      hasActions = hasActions;
      hasUrn = hasUrn;
      hasText = hasText;
      hasAttributedText = hasAttributedText;
      hasOriginalUpdate = hasOriginalUpdate;
      hasActor = hasActor;
      hasCreatedTime = hasCreatedTime;
      hasTrackingId = hasTrackingId;
      hasTracking = hasTracking;
      hasHeader = hasHeader;
      hasEdited = hasEdited;
      hasShareUrn = hasShareUrn;
    }
    
    public final Reshare build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Reshare.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
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
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "actions");
              if (!hasActions) {
                actions = Collections.emptyList();
              }
              if (!hasShareAudience) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "shareAudience");
              }
              if (!hasOriginalUpdate) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "originalUpdate");
              }
              if (!hasActor) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "actor");
              }
              if (hasCreatedTime) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Reshare", "createdTime");
            }
          }
        }
      }
      return new Reshare(shareAudience, actions, urn, text, attributedText, originalUpdate, actor, createdTime, trackingId, tracking, header, edited, shareUrn, hasShareAudience, hasActions, hasUrn, hasText, hasAttributedText, hasOriginalUpdate, hasActor, hasCreatedTime, hasTrackingId, hasTracking, hasHeader, hasEdited, hasShareUrn);
    }
    
    public final Builder setText(AnnotatedText paramAnnotatedText)
    {
      if (paramAnnotatedText == null)
      {
        hasText = false;
        text = null;
        return this;
      }
      hasText = true;
      text = paramAnnotatedText;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.Reshare
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */