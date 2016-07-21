package com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
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

public final class Prop
  implements FissileDataModel<Prop>, RecordTemplate<Prop>
{
  public static final PropBuilder BUILDER = PropBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final List<PropAction> actions;
  public final List<PropDetail> details;
  public final List<AttributedText> displayMessages;
  public final Urn entityUrn;
  public final boolean hasActions;
  public final boolean hasDetails;
  public final boolean hasDisplayMessages;
  public final boolean hasEntityUrn;
  public final boolean hasMiniProfile;
  public final boolean hasProfileSummary;
  public final boolean hasPropType;
  public final boolean hasSeen;
  public final boolean hasSocialActivityInfo;
  public final boolean hasTitle;
  public final boolean hasTrackingId;
  public final MiniProfile miniProfile;
  public final AttributedText profileSummary;
  public final PropType propType;
  public final boolean seen;
  public final SocialActivityCounts socialActivityInfo;
  public final String title;
  public final String trackingId;
  
  Prop(Urn paramUrn, String paramString1, String paramString2, List<AttributedText> paramList, PropType paramPropType, List<PropAction> paramList1, MiniProfile paramMiniProfile, boolean paramBoolean1, List<PropDetail> paramList2, SocialActivityCounts paramSocialActivityCounts, AttributedText paramAttributedText, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12)
  {
    entityUrn = paramUrn;
    trackingId = paramString1;
    title = paramString2;
    if (paramList == null)
    {
      paramString1 = null;
      displayMessages = paramString1;
      propType = paramPropType;
      if (paramList1 != null) {
        break label183;
      }
      paramString1 = null;
      label54:
      actions = paramString1;
      miniProfile = paramMiniProfile;
      seen = paramBoolean1;
      if (paramList2 != null) {
        break label192;
      }
    }
    label183:
    label192:
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList2))
    {
      details = paramString1;
      socialActivityInfo = paramSocialActivityCounts;
      profileSummary = paramAttributedText;
      hasEntityUrn = paramBoolean2;
      hasTrackingId = paramBoolean3;
      hasTitle = paramBoolean4;
      hasDisplayMessages = paramBoolean5;
      hasPropType = paramBoolean6;
      hasActions = paramBoolean7;
      hasMiniProfile = paramBoolean8;
      hasSeen = paramBoolean9;
      hasDetails = paramBoolean10;
      hasSocialActivityInfo = paramBoolean11;
      hasProfileSummary = paramBoolean12;
      paramString1 = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
      paramString1 = Collections.unmodifiableList(paramList);
      break;
      paramString1 = Collections.unmodifiableList(paramList1);
      break label54;
    }
  }
  
  private Prop accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    Object localObject4 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    int i;
    boolean bool2;
    if (hasDisplayMessages)
    {
      paramDataProcessor.startRecordField$505cff1c("displayMessages");
      displayMessages.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = displayMessages.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (AttributedText)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((AttributedText)localObject2).accept(paramDataProcessor);; localObject2 = (AttributedText)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null)
      {
        bool1 = true;
        localObject4 = localObject1;
      }
    }
    else
    {
      if (hasPropType)
      {
        paramDataProcessor.startRecordField$505cff1c("propType");
        paramDataProcessor.processEnum(propType);
      }
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasActions) {
        break label477;
      }
      paramDataProcessor.startRecordField$505cff1c("actions");
      actions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = actions.iterator();
      label365:
      if (!((Iterator)localObject3).hasNext()) {
        break label463;
      }
      localObject2 = (PropAction)((Iterator)localObject3).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label447;
      }
    }
    label447:
    for (Object localObject2 = ((PropAction)localObject2).accept(paramDataProcessor);; localObject2 = (PropAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label365;
      bool1 = false;
      localObject4 = localObject1;
      break;
    }
    label463:
    paramDataProcessor.endArray();
    label477:
    Object localObject5;
    boolean bool3;
    label517:
    label529:
    boolean bool4;
    Object localObject6;
    if (localObject1 != null)
    {
      bool2 = true;
      localObject5 = null;
      bool3 = false;
      if (hasMiniProfile)
      {
        paramDataProcessor.startRecordField$505cff1c("miniProfile");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label708;
        }
        localObject2 = miniProfile.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label726;
        }
        bool3 = true;
        localObject5 = localObject2;
      }
      if (hasSeen)
      {
        paramDataProcessor.startRecordField$505cff1c("seen");
        paramDataProcessor.processBoolean(seen);
      }
      localObject2 = null;
      localObject3 = null;
      bool4 = false;
      if (!hasDetails) {
        break label766;
      }
      paramDataProcessor.startRecordField$505cff1c("details");
      details.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      localObject6 = details.iterator();
      label629:
      if (!((Iterator)localObject6).hasNext()) {
        break label752;
      }
      localObject3 = (PropDetail)((Iterator)localObject6).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label736;
      }
    }
    label708:
    label726:
    label736:
    for (Object localObject3 = ((PropDetail)localObject3).accept(paramDataProcessor);; localObject3 = (PropDetail)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject2 != null) && (localObject3 != null)) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
      break label629;
      bool2 = false;
      break;
      localObject2 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break label517;
      bool3 = false;
      localObject5 = localObject2;
      break label529;
    }
    label752:
    paramDataProcessor.endArray();
    label766:
    boolean bool5;
    if (localObject2 != null)
    {
      bool4 = true;
      localObject6 = null;
      bool5 = false;
      if (hasSocialActivityInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("socialActivityInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label940;
        }
        localObject3 = socialActivityInfo.accept(paramDataProcessor);
        label806:
        if (localObject3 == null) {
          break label958;
        }
        bool5 = true;
        localObject6 = localObject3;
      }
      label818:
      localObject3 = null;
      bool6 = false;
      if (hasProfileSummary)
      {
        paramDataProcessor.startRecordField$505cff1c("profileSummary");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label968;
        }
        localObject3 = profileSummary.accept(paramDataProcessor);
        label858:
        if (localObject3 == null) {
          break label986;
        }
      }
    }
    label940:
    label958:
    label968:
    label986:
    for (boolean bool6 = true;; bool6 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1308;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      if (!hasDetails) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (hasEntityUrn) {
          break label992;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool4 = false;
      break;
      localObject3 = (SocialActivityCounts)paramDataProcessor.processDataTemplate(socialActivityInfo);
      break label806;
      bool5 = false;
      localObject6 = localObject3;
      break label818;
      localObject3 = (AttributedText)paramDataProcessor.processDataTemplate(profileSummary);
      break label858;
    }
    label992:
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop", "trackingId");
    }
    if (!hasTitle) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop", "title");
    }
    if (!hasDisplayMessages) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop", "displayMessages");
    }
    if (!hasPropType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop", "propType");
    }
    if (!hasSeen) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop", "seen");
    }
    if (displayMessages != null)
    {
      paramDataProcessor = displayMessages.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((AttributedText)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop", "displayMessages");
        }
      }
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PropAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop", "actions");
        }
      }
    }
    if (details != null)
    {
      paramDataProcessor = details.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PropDetail)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop", "details");
        }
      }
    }
    return new Prop(entityUrn, trackingId, title, (List)localObject4, propType, (List)localObject1, (MiniProfile)localObject5, seen, (List)localObject2, (SocialActivityCounts)localObject6, (AttributedText)localObject3, hasEntityUrn, hasTrackingId, hasTitle, bool1, hasPropType, bool2, bool3, hasSeen, bool4, bool5, bool6);
    label1308:
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
      paramObject = (Prop)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
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
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (displayMessages != null)
      {
        if (displayMessages.equals(displayMessages)) {}
      }
      else {
        while (displayMessages != null) {
          return false;
        }
      }
      if (propType != null)
      {
        if (propType.equals(propType)) {}
      }
      else {
        while (propType != null) {
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
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
      if (seen != seen) {
        return false;
      }
      if (details != null)
      {
        if (details.equals(details)) {}
      }
      else {
        while (details != null) {
          return false;
        }
      }
      if (socialActivityInfo != null)
      {
        if (socialActivityInfo.equals(socialActivityInfo)) {}
      }
      else {
        while (socialActivityInfo != null) {
          return false;
        }
      }
      if (profileSummary == null) {
        break;
      }
    } while (profileSummary.equals(profileSummary));
    for (;;)
    {
      return false;
      if (profileSummary == null) {
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
    Object localObject1;
    if (hasEntityUrn)
    {
      localObject1 = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasTrackingId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
    }
    j = i + 1;
    i = j;
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    i += 1;
    j = i;
    Object localObject2;
    if (hasDisplayMessages)
    {
      i += 2;
      localObject1 = displayMessages.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (AttributedText)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((AttributedText)localObject2).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasPropType) {
      i = j + 2;
    }
    i += 1;
    j = i;
    if (hasActions)
    {
      i += 2;
      localObject1 = actions.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (PropAction)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((PropAction)localObject2).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasMiniProfile)
    {
      i = j + 1;
      if (miniProfile._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasSeen) {
        i = j + 1;
      }
      i += 1;
      j = i;
      if (!hasDetails) {
        break label448;
      }
      i += 2;
      localObject1 = details.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label448;
      }
      localObject2 = (PropDetail)((Iterator)localObject1).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += miniProfile.getSerializedSize();
        break;
      }
      i += ((PropDetail)localObject2).getSerializedSize();
    }
    label448:
    j += 1;
    i = j;
    if (hasSocialActivityInfo)
    {
      i = j + 1;
      if (socialActivityInfo._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(socialActivityInfo._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasProfileSummary)
      {
        i = j + 1;
        if (profileSummary._cachedId == null) {
          break label552;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(profileSummary._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += socialActivityInfo.getSerializedSize();
      break;
      label552:
      i += profileSummary.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i6 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label78:
    int n;
    label94:
    int i1;
    label112:
    int i2;
    label128:
    int i3;
    label138:
    int i4;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (trackingId == null) {
        break label264;
      }
      j = trackingId.hashCode();
      if (title == null) {
        break label269;
      }
      k = title.hashCode();
      if (displayMessages == null) {
        break label274;
      }
      m = displayMessages.hashCode();
      if (propType == null) {
        break label280;
      }
      n = propType.hashCode();
      if (actions == null) {
        break label286;
      }
      i1 = actions.hashCode();
      if (miniProfile == null) {
        break label292;
      }
      i2 = miniProfile.hashCode();
      if (!seen) {
        break label298;
      }
      i3 = 1;
      if (details == null) {
        break label304;
      }
      i4 = details.hashCode();
      label156:
      if (socialActivityInfo == null) {
        break label310;
      }
    }
    label264:
    label269:
    label274:
    label280:
    label286:
    label292:
    label298:
    label304:
    label310:
    for (int i5 = socialActivityInfo.hashCode();; i5 = 0)
    {
      if (profileSummary != null) {
        i6 = profileSummary.hashCode();
      }
      i = (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i6;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label78;
      n = 0;
      break label94;
      i1 = 0;
      break label112;
      i2 = 0;
      break label128;
      i3 = 0;
      break label138;
      i4 = 0;
      break label156;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Prop");
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
    label172:
    label198:
    label315:
    label325:
    label358:
    label365:
    label541:
    label625:
    label634:
    label776:
    label782:
    label815:
    label822:
    label1010:
    label1035:
    label1043:
    label1045:
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
        localByteBuffer.putInt(612094767);
        Object localObject1;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject1 = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasTrackingId) {
            break label315;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasTitle) {
            break label325;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasDisplayMessages) {
            break label358;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, displayMessages.size());
          localObject1 = displayMessages.iterator();
        }
        Object localObject2;
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label365;
          }
          localObject2 = (AttributedText)((Iterator)localObject1).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((AttributedText)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label172;
            localByteBuffer.put((byte)0);
            break label198;
          }
          localByteBuffer.put((byte)1);
          ((AttributedText)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasPropType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, propType.ordinal());
          if (hasActions)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
            localObject1 = actions.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label541;
            }
            localObject2 = (PropAction)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((PropAction)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            ((PropAction)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
        }
        localByteBuffer.put((byte)0);
        if (hasMiniProfile)
        {
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
            miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSeen) {
              break label782;
            }
            localByteBuffer.put((byte)1);
            if (!seen) {
              break label776;
            }
            i = 1;
            localByteBuffer.put((byte)i);
            if (!hasDetails) {
              break label815;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, details.size());
            localObject1 = details.iterator();
          }
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label822;
          }
          localObject2 = (PropDetail)((Iterator)localObject1).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((PropDetail)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            i = 0;
            break label625;
            localByteBuffer.put((byte)0);
            break label634;
          }
          localByteBuffer.put((byte)1);
          ((PropDetail)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasSocialActivityInfo)
        {
          localByteBuffer.put((byte)1);
          if (socialActivityInfo._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, socialActivityInfo._cachedId);
            socialActivityInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasProfileSummary) {
              break label1035;
            }
            localByteBuffer.put((byte)1);
            if (profileSummary._cachedId == null) {
              break label1010;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, profileSummary._cachedId);
            profileSummary.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label1043;
          }
          if (str != null) {
            break label1045;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          socialActivityInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          profileSummary.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */