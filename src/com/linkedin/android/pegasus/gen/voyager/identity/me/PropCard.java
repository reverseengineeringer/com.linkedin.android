package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.identity.me.ctaActions.CtaAction;
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

public final class PropCard
  implements FissileDataModel<PropCard>, RecordTemplate<PropCard>
{
  public static final PropCardBuilder BUILDER = PropCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<CtaAction> actions;
  public final ActorMiniProfile actor;
  public final boolean hasActions;
  public final boolean hasActor;
  public final boolean hasHeadline;
  public final boolean hasInsight;
  public final boolean hasPropType;
  public final boolean hasPropUrn;
  public final boolean hasPublishedAt;
  public final boolean hasRead;
  public final boolean hasSocialActivityInfo;
  public final AttributedText headline;
  public final AttributedText insight;
  public final PropType propType;
  public final Urn propUrn;
  public final long publishedAt;
  public final boolean read;
  public final SocialActivityCounts socialActivityInfo;
  
  PropCard(Urn paramUrn, PropType paramPropType, ActorMiniProfile paramActorMiniProfile, AttributedText paramAttributedText1, long paramLong, boolean paramBoolean1, AttributedText paramAttributedText2, List<CtaAction> paramList, SocialActivityCounts paramSocialActivityCounts, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    propUrn = paramUrn;
    propType = paramPropType;
    actor = paramActorMiniProfile;
    headline = paramAttributedText1;
    publishedAt = paramLong;
    read = paramBoolean1;
    insight = paramAttributedText2;
    if (paramList == null) {}
    for (paramUrn = null;; paramUrn = Collections.unmodifiableList(paramList))
    {
      actions = paramUrn;
      socialActivityInfo = paramSocialActivityCounts;
      hasPropUrn = paramBoolean2;
      hasPropType = paramBoolean3;
      hasActor = paramBoolean4;
      hasHeadline = paramBoolean5;
      hasPublishedAt = paramBoolean6;
      hasRead = paramBoolean7;
      hasInsight = paramBoolean8;
      hasActions = paramBoolean9;
      hasSocialActivityInfo = paramBoolean10;
      _cachedId = null;
      return;
    }
  }
  
  public final PropCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasPropUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("propUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(propUrn));
    }
    if (hasPropType)
    {
      paramDataProcessor.startRecordField$505cff1c("propType");
      paramDataProcessor.processEnum(propType);
    }
    Object localObject3 = null;
    boolean bool1 = false;
    label114:
    Object localObject4;
    boolean bool2;
    label154:
    label166:
    Object localObject5;
    boolean bool3;
    label256:
    label268:
    boolean bool4;
    int i;
    if (hasActor)
    {
      paramDataProcessor.startRecordField$505cff1c("actor");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = actor.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label434;
        }
        bool1 = true;
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject4 = null;
      bool2 = false;
      if (hasHeadline)
      {
        paramDataProcessor.startRecordField$505cff1c("headline");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label443;
        }
        localObject1 = headline.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label461;
        }
        bool2 = true;
        localObject4 = localObject1;
      }
      if (hasPublishedAt)
      {
        paramDataProcessor.startRecordField$505cff1c("publishedAt");
        paramDataProcessor.processLong(publishedAt);
      }
      if (hasRead)
      {
        paramDataProcessor.startRecordField$505cff1c("read");
        paramDataProcessor.processBoolean(read);
      }
      localObject5 = null;
      bool3 = false;
      if (hasInsight)
      {
        paramDataProcessor.startRecordField$505cff1c("insight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label471;
        }
        localObject1 = insight.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label489;
        }
        bool3 = true;
        localObject5 = localObject1;
      }
      localObject1 = null;
      localObject2 = null;
      bool4 = false;
      if (!hasActions) {
        break label529;
      }
      paramDataProcessor.startRecordField$505cff1c("actions");
      actions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = actions.iterator();
      label343:
      if (!localIterator.hasNext()) {
        break label515;
      }
      localObject2 = (CtaAction)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label499;
      }
    }
    label434:
    label443:
    label461:
    label471:
    label489:
    label499:
    for (Object localObject2 = ((CtaAction)localObject2).accept(paramDataProcessor);; localObject2 = (CtaAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label343;
      localObject1 = (ActorMiniProfile)paramDataProcessor.processDataTemplate(actor);
      break;
      bool1 = false;
      localObject3 = localObject1;
      break label114;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(headline);
      break label154;
      bool2 = false;
      localObject4 = localObject1;
      break label166;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(insight);
      break label256;
      bool3 = false;
      localObject5 = localObject1;
      break label268;
    }
    label515:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool4 = true;
      label529:
      localObject2 = null;
      bool5 = false;
      if (hasSocialActivityInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("socialActivityInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label639;
        }
        localObject2 = socialActivityInfo.accept(paramDataProcessor);
        label569:
        if (localObject2 == null) {
          break label657;
        }
      }
    }
    label639:
    label657:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label867;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasPropUrn) {
          break label663;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "propUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool4 = false;
      break;
      localObject2 = (SocialActivityCounts)paramDataProcessor.processDataTemplate(socialActivityInfo);
      break label569;
    }
    label663:
    if (!hasPropType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "propType");
    }
    if (!hasActor) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "actor");
    }
    if (!hasHeadline) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "headline");
    }
    if (!hasPublishedAt) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "publishedAt");
    }
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "read");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((CtaAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "actions");
        }
      }
    }
    return new PropCard(propUrn, propType, (ActorMiniProfile)localObject3, (AttributedText)localObject4, publishedAt, read, (AttributedText)localObject5, (List)localObject1, (SocialActivityCounts)localObject2, hasPropUrn, hasPropType, bool1, bool2, hasPublishedAt, hasRead, bool3, bool4, bool5);
    label867:
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
      paramObject = (PropCard)paramObject;
      if (propUrn != null)
      {
        if (propUrn.equals(propUrn)) {}
      }
      else {
        while (propUrn != null) {
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
      if (actor != null)
      {
        if (actor.equals(actor)) {}
      }
      else {
        while (actor != null) {
          return false;
        }
      }
      if (headline != null)
      {
        if (headline.equals(headline)) {}
      }
      else {
        while (headline != null) {
          return false;
        }
      }
      if (publishedAt != publishedAt) {
        return false;
      }
      if (read != read) {
        return false;
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
      if (actions != null)
      {
        if (actions.equals(actions)) {}
      }
      else {
        while (actions != null) {
          return false;
        }
      }
      if (socialActivityInfo == null) {
        break;
      }
    } while (socialActivityInfo.equals(socialActivityInfo));
    for (;;)
    {
      return false;
      if (socialActivityInfo == null) {
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
    if (hasPropUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(propUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasPropType) {
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
      if (hasHeadline)
      {
        i = j + 1;
        if (headline._cachedId == null) {
          break label313;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(headline._cachedId);
      }
      label146:
      j = i + 1;
      i = j;
      if (hasPublishedAt) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasRead) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasInsight)
      {
        i = j + 1;
        if (insight._cachedId == null) {
          break label326;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(insight._cachedId);
      }
      label223:
      i += 1;
      j = i;
      if (!hasActions) {
        break label350;
      }
      i += 2;
      localObject = actions.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label350;
      }
      CtaAction localCtaAction = (CtaAction)((Iterator)localObject).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += actor.getSerializedSize();
        break;
        label313:
        i += headline.getSerializedSize();
        break label146;
        label326:
        i += insight.getSerializedSize();
        break label223;
      }
      i += localCtaAction.getSerializedSize();
    }
    label350:
    j += 1;
    i = j;
    if (hasSocialActivityInfo)
    {
      i = j + 1;
      if (socialActivityInfo._cachedId == null) {
        break label399;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(socialActivityInfo._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label399:
      i += socialActivityInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i3 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int i4;
    int n;
    label101:
    int i1;
    if (propUrn != null)
    {
      i = propUrn.hashCode();
      if (propType == null) {
        break label215;
      }
      j = propType.hashCode();
      if (actor == null) {
        break label220;
      }
      k = actor.hashCode();
      if (headline == null) {
        break label225;
      }
      m = headline.hashCode();
      i4 = (int)(publishedAt ^ publishedAt >>> 32);
      if (!read) {
        break label231;
      }
      n = 1;
      if (insight == null) {
        break label237;
      }
      i1 = insight.hashCode();
      label117:
      if (actions == null) {
        break label243;
      }
    }
    label215:
    label220:
    label225:
    label231:
    label237:
    label243:
    for (int i2 = actions.hashCode();; i2 = 0)
    {
      if (socialActivityInfo != null) {
        i3 = socialActivityInfo.hashCode();
      }
      i = (i2 + (i1 + (n + ((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i4) * 31) * 31) * 31) * 31 + i3;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label101;
      i1 = 0;
      break label117;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PropCard");
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
    label175:
    label235:
    label295:
    label319:
    label343:
    label352:
    label412:
    label529:
    label539:
    label564:
    label574:
    label599:
    label609:
    label619:
    label625:
    label635:
    label660:
    label693:
    label700:
    label828:
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
        localByteBuffer.putInt(-2130026980);
        Object localObject;
        if (hasPropUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(propUrn));
          if (!hasPropType) {
            break label529;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, propType.ordinal());
          if (!hasActor) {
            break label564;
          }
          localByteBuffer.put((byte)1);
          if (actor._cachedId == null) {
            break label539;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, actor._cachedId);
          actor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasHeadline) {
            break label599;
          }
          localByteBuffer.put((byte)1);
          if (headline._cachedId == null) {
            break label574;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, headline._cachedId);
          headline.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPublishedAt) {
            break label609;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (!hasRead) {
            break label625;
          }
          localByteBuffer.put((byte)1);
          if (!read) {
            break label619;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasInsight) {
            break label660;
          }
          localByteBuffer.put((byte)1);
          if (insight._cachedId == null) {
            break label635;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, insight._cachedId);
          insight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasActions) {
            break label693;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
          localObject = actions.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label700;
          }
          CtaAction localCtaAction = (CtaAction)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localCtaAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label175;
            localByteBuffer.put((byte)1);
            actor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label235;
            localByteBuffer.put((byte)0);
            break label235;
            localByteBuffer.put((byte)1);
            headline.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label295;
            localByteBuffer.put((byte)0);
            break label295;
            localByteBuffer.put((byte)0);
            break label319;
            i = 0;
            break label343;
            localByteBuffer.put((byte)0);
            break label352;
            localByteBuffer.put((byte)1);
            insight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label412;
            localByteBuffer.put((byte)0);
            break label412;
          }
          localByteBuffer.put((byte)1);
          localCtaAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label828;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          socialActivityInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    implements RecordTemplateBuilder<PropCard>
  {
    private List<CtaAction> actions = null;
    private ActorMiniProfile actor = null;
    private boolean hasActions = false;
    private boolean hasActor = false;
    private boolean hasHeadline = false;
    private boolean hasInsight = false;
    private boolean hasPropType = false;
    private boolean hasPropUrn = false;
    private boolean hasPublishedAt = false;
    public boolean hasRead = false;
    private boolean hasSocialActivityInfo = false;
    private AttributedText headline = null;
    private AttributedText insight = null;
    private PropType propType = null;
    private Urn propUrn = null;
    private long publishedAt = 0L;
    public boolean read = false;
    private SocialActivityCounts socialActivityInfo = null;
    
    public Builder() {}
    
    public Builder(PropCard paramPropCard)
    {
      propUrn = propUrn;
      propType = propType;
      actor = actor;
      headline = headline;
      publishedAt = publishedAt;
      read = read;
      insight = insight;
      actions = actions;
      socialActivityInfo = socialActivityInfo;
      hasPropUrn = hasPropUrn;
      hasPropType = hasPropType;
      hasActor = hasActor;
      hasHeadline = hasHeadline;
      hasPublishedAt = hasPublishedAt;
      hasRead = hasRead;
      hasInsight = hasInsight;
      hasActions = hasActions;
      hasSocialActivityInfo = hasSocialActivityInfo;
    }
    
    public final PropCard build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PropCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (actions != null)
      {
        paramFlavor = actions.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((CtaAction)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "actions");
              if (!hasActions) {
                actions = Collections.emptyList();
              }
              if (!hasPropUrn) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "propUrn");
              }
              if (!hasPropType) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "propType");
              }
              if (!hasActor) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "actor");
              }
              if (!hasHeadline) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "headline");
              }
              if (!hasPublishedAt) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "publishedAt");
              }
              if (hasRead) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard", "read");
            }
          }
        }
      }
      return new PropCard(propUrn, propType, actor, headline, publishedAt, read, insight, actions, socialActivityInfo, hasPropUrn, hasPropType, hasActor, hasHeadline, hasPublishedAt, hasRead, hasInsight, hasActions, hasSocialActivityInfo);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */