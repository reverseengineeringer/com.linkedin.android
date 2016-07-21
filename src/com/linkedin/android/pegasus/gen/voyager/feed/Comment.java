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

public final class Comment
  implements FissileDataModel<Comment>, RecordTemplate<Comment>
{
  public static final CommentBuilder BUILDER = CommentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<CommentAction> actions;
  public final boolean canDelete;
  public final AnnotatedText comment;
  public final SocialActor commenter;
  public final long createdTime;
  public final Urn entityUrn;
  public final boolean hasActions;
  public final boolean hasCanDelete;
  public final boolean hasComment;
  public final boolean hasCommenter;
  public final boolean hasCreatedTime;
  public final boolean hasEntityUrn;
  public final boolean hasIndex;
  public final boolean hasInsight;
  public final boolean hasParentCommentUrn;
  public final boolean hasSocialDetail;
  public final boolean hasThreadId;
  public final boolean hasUrn;
  public final int index;
  public final Insight insight;
  public final Urn parentCommentUrn;
  public final SocialDetail socialDetail;
  public final String threadId;
  public final Urn urn;
  
  Comment(Urn paramUrn1, Urn paramUrn2, SocialActor paramSocialActor, AnnotatedText paramAnnotatedText, long paramLong, SocialDetail paramSocialDetail, String paramString, int paramInt, Insight paramInsight, boolean paramBoolean1, List<CommentAction> paramList, Urn paramUrn3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13)
  {
    urn = paramUrn1;
    entityUrn = paramUrn2;
    commenter = paramSocialActor;
    comment = paramAnnotatedText;
    createdTime = paramLong;
    socialDetail = paramSocialDetail;
    threadId = paramString;
    index = paramInt;
    insight = paramInsight;
    canDelete = paramBoolean1;
    if (paramList == null) {}
    for (paramUrn1 = null;; paramUrn1 = Collections.unmodifiableList(paramList))
    {
      actions = paramUrn1;
      parentCommentUrn = paramUrn3;
      hasUrn = paramBoolean2;
      hasEntityUrn = paramBoolean3;
      hasCommenter = paramBoolean4;
      hasComment = paramBoolean5;
      hasCreatedTime = paramBoolean6;
      hasSocialDetail = paramBoolean7;
      hasThreadId = paramBoolean8;
      hasIndex = paramBoolean9;
      hasInsight = paramBoolean10;
      hasCanDelete = paramBoolean11;
      hasActions = paramBoolean12;
      hasParentCommentUrn = paramBoolean13;
      paramUrn1 = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn2);
      return;
    }
  }
  
  public final Comment accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("urn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(urn));
    }
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label122:
    Object localObject3;
    boolean bool2;
    label162:
    label174:
    Object localObject4;
    boolean bool3;
    label239:
    label251:
    boolean bool4;
    if (hasCommenter)
    {
      paramDataProcessor.startRecordField$505cff1c("commenter");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = commenter.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label530;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasComment)
      {
        paramDataProcessor.startRecordField$505cff1c("comment");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label539;
        }
        localObject1 = comment.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label557;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      if (hasCreatedTime)
      {
        paramDataProcessor.startRecordField$505cff1c("createdTime");
        paramDataProcessor.processLong(createdTime);
      }
      localObject4 = null;
      bool3 = false;
      if (hasSocialDetail)
      {
        paramDataProcessor.startRecordField$505cff1c("socialDetail");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label567;
        }
        localObject1 = socialDetail.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label585;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      if (hasThreadId)
      {
        paramDataProcessor.startRecordField$505cff1c("threadId");
        paramDataProcessor.processString(threadId);
      }
      if (hasIndex)
      {
        paramDataProcessor.startRecordField$505cff1c("index");
        paramDataProcessor.processInt(index);
      }
      localObject5 = null;
      bool4 = false;
      if (hasInsight)
      {
        paramDataProcessor.startRecordField$505cff1c("insight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label595;
        }
        localObject1 = insight.accept(paramDataProcessor);
        label341:
        if (localObject1 == null) {
          break label613;
        }
        bool4 = true;
      }
    }
    Object localObject6;
    for (Object localObject5 = localObject1;; localObject5 = localObject1)
    {
      if (hasCanDelete)
      {
        paramDataProcessor.startRecordField$505cff1c("canDelete");
        paramDataProcessor.processBoolean(canDelete);
      }
      localObject1 = null;
      localObject6 = null;
      bool5 = false;
      if (!hasActions) {
        break label637;
      }
      paramDataProcessor.startRecordField$505cff1c("actions");
      actions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject6;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localObject6 = actions.iterator();
      while (((Iterator)localObject6).hasNext())
      {
        CommentAction localCommentAction = (CommentAction)((Iterator)localObject6).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processEnum(localCommentAction);
        if (localObject1 != null) {
          ((List)localObject1).add(localCommentAction);
        }
        i += 1;
      }
      localObject1 = (SocialActor)paramDataProcessor.processDataTemplate(commenter);
      break;
      label530:
      bool1 = false;
      localObject2 = localObject1;
      break label122;
      label539:
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(comment);
      break label162;
      label557:
      bool2 = false;
      localObject3 = localObject1;
      break label174;
      label567:
      localObject1 = (SocialDetail)paramDataProcessor.processDataTemplate(socialDetail);
      break label239;
      label585:
      bool3 = false;
      localObject4 = localObject1;
      break label251;
      label595:
      localObject1 = (Insight)paramDataProcessor.processDataTemplate(insight);
      break label341;
      label613:
      bool4 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool5 = true;; bool5 = false)
    {
      label637:
      if (hasParentCommentUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("parentCommentUrn");
        localObject6 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(parentCommentUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label947;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasCommenter) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "commenter");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasComment) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "comment");
    }
    if (!hasCreatedTime) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "createdTime");
    }
    if (!hasThreadId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "threadId");
    }
    if (!hasIndex) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "index");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((CommentAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "actions");
        }
      }
    }
    return new Comment(urn, entityUrn, (SocialActor)localObject2, (AnnotatedText)localObject3, createdTime, (SocialDetail)localObject4, threadId, index, (Insight)localObject5, canDelete, (List)localObject1, parentCommentUrn, hasUrn, hasEntityUrn, bool1, bool2, hasCreatedTime, bool3, hasThreadId, hasIndex, bool4, hasCanDelete, bool5, hasParentCommentUrn);
    label947:
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
      paramObject = (Comment)paramObject;
      if (urn != null)
      {
        if (urn.equals(urn)) {}
      }
      else {
        while (urn != null) {
          return false;
        }
      }
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (commenter != null)
      {
        if (commenter.equals(commenter)) {}
      }
      else {
        while (commenter != null) {
          return false;
        }
      }
      if (comment != null)
      {
        if (comment.equals(comment)) {}
      }
      else {
        while (comment != null) {
          return false;
        }
      }
      if (createdTime != createdTime) {
        return false;
      }
      if (socialDetail != null)
      {
        if (socialDetail.equals(socialDetail)) {}
      }
      else {
        while (socialDetail != null) {
          return false;
        }
      }
      if (threadId != null)
      {
        if (threadId.equals(threadId)) {}
      }
      else {
        while (threadId != null) {
          return false;
        }
      }
      if (index != index) {
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
      if (canDelete != canDelete) {
        return false;
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
      if (parentCommentUrn == null) {
        break;
      }
    } while (parentCommentUrn.equals(parentCommentUrn));
    for (;;)
    {
      return false;
      if (parentCommentUrn == null) {
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
    if (hasUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(urn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasEntityUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    j = i + 1;
    i = j;
    if (hasCommenter)
    {
      i = j + 1;
      if (commenter._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(commenter._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasComment)
      {
        i = j + 1;
        if (comment._cachedId == null) {
          break label387;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(comment._cachedId);
      }
      label161:
      j = i + 1;
      i = j;
      if (hasCreatedTime) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasSocialDetail)
      {
        i = j + 1;
        if (socialDetail._cachedId == null) {
          break label400;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(socialDetail._cachedId);
      }
      label221:
      j = i + 1;
      i = j;
      if (hasThreadId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(threadId);
      }
      j = i + 1;
      i = j;
      if (hasIndex) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasInsight)
      {
        i = j + 1;
        if (insight._cachedId == null) {
          break label413;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(insight._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasCanDelete) {
        i = j + 1;
      }
      i += 1;
      j = i;
      if (!hasActions) {
        break label426;
      }
      i += 2;
      localObject = actions.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        ((Iterator)localObject).next();
        i += 2;
      }
      i += commenter.getSerializedSize();
      break;
      label387:
      i += comment.getSerializedSize();
      break label161;
      label400:
      i += socialDetail.getSerializedSize();
      break label221;
      label413:
      i += insight.getSerializedSize();
    }
    label426:
    j += 1;
    i = j;
    if (hasParentCommentUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(parentCommentUrn));
    }
    __sizeOfObject = i;
    return i;
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
    label60:
    int m;
    label76:
    int i6;
    int n;
    label107:
    int i1;
    label123:
    int i7;
    int i2;
    label145:
    int i3;
    if (urn != null)
    {
      i = urn.hashCode();
      if (entityUrn == null) {
        break label271;
      }
      j = entityUrn.hashCode();
      if (commenter == null) {
        break label276;
      }
      k = commenter.hashCode();
      if (comment == null) {
        break label281;
      }
      m = comment.hashCode();
      i6 = (int)(createdTime ^ createdTime >>> 32);
      if (socialDetail == null) {
        break label287;
      }
      n = socialDetail.hashCode();
      if (threadId == null) {
        break label293;
      }
      i1 = threadId.hashCode();
      i7 = index;
      if (insight == null) {
        break label299;
      }
      i2 = insight.hashCode();
      if (!canDelete) {
        break label305;
      }
      i3 = 1;
      label155:
      if (actions == null) {
        break label311;
      }
    }
    label271:
    label276:
    label281:
    label287:
    label293:
    label299:
    label305:
    label311:
    for (int i4 = actions.hashCode();; i4 = 0)
    {
      if (parentCommentUrn != null) {
        i5 = parentCommentUrn.hashCode();
      }
      i = (i4 + (i3 + (i2 + ((i1 + (n + ((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i6) * 31) * 31) * 31 + i7) * 31) * 31) * 31) * 31 + i5;
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
      break label107;
      i1 = 0;
      break label123;
      i2 = 0;
      break label145;
      i3 = 0;
      break label155;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Comment");
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
    label180:
    label240:
    label300:
    label324:
    label384:
    label410:
    label434:
    label494:
    label518:
    label613:
    label623:
    label648:
    label658:
    label683:
    label693:
    label703:
    label728:
    label738:
    label748:
    label758:
    label783:
    label793:
    label799:
    label809:
    label893:
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
        localByteBuffer.putInt(1175712204);
        Object localObject;
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasEntityUrn) {
            break label613;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasCommenter) {
            break label648;
          }
          localByteBuffer.put((byte)1);
          if (commenter._cachedId == null) {
            break label623;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, commenter._cachedId);
          commenter.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasComment) {
            break label683;
          }
          localByteBuffer.put((byte)1);
          if (comment._cachedId == null) {
            break label658;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, comment._cachedId);
          comment.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCreatedTime) {
            break label693;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(createdTime);
          if (!hasSocialDetail) {
            break label728;
          }
          localByteBuffer.put((byte)1);
          if (socialDetail._cachedId == null) {
            break label703;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, socialDetail._cachedId);
          socialDetail.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasThreadId) {
            break label738;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, threadId);
          if (!hasIndex) {
            break label748;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(index);
          if (!hasInsight) {
            break label783;
          }
          localByteBuffer.put((byte)1);
          if (insight._cachedId == null) {
            break label758;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, insight._cachedId);
          insight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCanDelete) {
            break label799;
          }
          localByteBuffer.put((byte)1);
          if (!canDelete) {
            break label793;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (!hasActions) {
            break label809;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
          localObject = actions.iterator();
          while (((Iterator)localObject).hasNext()) {
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, ((CommentAction)((Iterator)localObject).next()).ordinal());
          }
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label180;
          localByteBuffer.put((byte)1);
          commenter.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label240;
          localByteBuffer.put((byte)0);
          break label240;
          localByteBuffer.put((byte)1);
          comment.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label300;
          localByteBuffer.put((byte)0);
          break label300;
          localByteBuffer.put((byte)0);
          break label324;
          localByteBuffer.put((byte)1);
          socialDetail.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label384;
          localByteBuffer.put((byte)0);
          break label384;
          localByteBuffer.put((byte)0);
          break label410;
          localByteBuffer.put((byte)0);
          break label434;
          localByteBuffer.put((byte)1);
          insight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label494;
          localByteBuffer.put((byte)0);
          break label494;
          i = 0;
          break label518;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasParentCommentUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(parentCommentUrn));
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label893;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
    implements RecordTemplateBuilder<Comment>
  {
    private List<CommentAction> actions = null;
    private boolean canDelete = false;
    private AnnotatedText comment = null;
    private SocialActor commenter = null;
    private long createdTime = 0L;
    private Urn entityUrn = null;
    private boolean hasActions = false;
    private boolean hasCanDelete = false;
    private boolean hasComment = false;
    private boolean hasCommenter = false;
    private boolean hasCreatedTime = false;
    private boolean hasEntityUrn = false;
    private boolean hasIndex = false;
    private boolean hasInsight = false;
    public boolean hasParentCommentUrn = false;
    private boolean hasSocialDetail = false;
    private boolean hasThreadId = false;
    private boolean hasUrn = false;
    private int index = 0;
    private Insight insight = null;
    public Urn parentCommentUrn = null;
    private SocialDetail socialDetail = null;
    private String threadId = null;
    private Urn urn = null;
    
    public Builder() {}
    
    public Builder(Comment paramComment)
    {
      urn = urn;
      entityUrn = entityUrn;
      commenter = commenter;
      comment = comment;
      createdTime = createdTime;
      socialDetail = socialDetail;
      threadId = threadId;
      index = index;
      insight = insight;
      canDelete = canDelete;
      actions = actions;
      parentCommentUrn = parentCommentUrn;
      hasUrn = hasUrn;
      hasEntityUrn = hasEntityUrn;
      hasCommenter = hasCommenter;
      hasComment = hasComment;
      hasCreatedTime = hasCreatedTime;
      hasSocialDetail = hasSocialDetail;
      hasThreadId = hasThreadId;
      hasIndex = hasIndex;
      hasInsight = hasInsight;
      hasCanDelete = hasCanDelete;
      hasActions = hasActions;
      hasParentCommentUrn = hasParentCommentUrn;
    }
    
    public final Comment build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
    
    public final Comment build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Comment.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (actions != null)
      {
        paramFlavor = actions.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((CommentAction)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "actions");
              if (!hasCanDelete) {
                canDelete = false;
              }
              if (!hasActions) {
                actions = Collections.emptyList();
              }
              if (!hasCommenter) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "commenter");
              }
              if (!hasComment) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "comment");
              }
              if (!hasCreatedTime) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "createdTime");
              }
              if (!hasThreadId) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "threadId");
              }
              if (hasIndex) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Comment", "index");
            }
          }
        }
      }
      return new Comment(urn, entityUrn, commenter, comment, createdTime, socialDetail, threadId, index, insight, canDelete, actions, parentCommentUrn, hasUrn, hasEntityUrn, hasCommenter, hasComment, hasCreatedTime, hasSocialDetail, hasThreadId, hasIndex, hasInsight, hasCanDelete, hasActions, hasParentCommentUrn);
    }
    
    public final Builder setActions(List<CommentAction> paramList)
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
    
    public final Builder setCanDelete(Boolean paramBoolean)
    {
      if ((paramBoolean == null) || (!paramBoolean.booleanValue()))
      {
        hasCanDelete = false;
        canDelete = false;
        return this;
      }
      hasCanDelete = true;
      canDelete = paramBoolean.booleanValue();
      return this;
    }
    
    public final Builder setComment(AnnotatedText paramAnnotatedText)
    {
      if (paramAnnotatedText == null)
      {
        hasComment = false;
        comment = null;
        return this;
      }
      hasComment = true;
      comment = paramAnnotatedText;
      return this;
    }
    
    public final Builder setCommenter(SocialActor paramSocialActor)
    {
      if (paramSocialActor == null)
      {
        hasCommenter = false;
        commenter = null;
        return this;
      }
      hasCommenter = true;
      commenter = paramSocialActor;
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
    
    public final Builder setEntityUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasEntityUrn = false;
        entityUrn = null;
        return this;
      }
      hasEntityUrn = true;
      entityUrn = paramUrn;
      return this;
    }
    
    public final Builder setIndex(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasIndex = false;
        index = 0;
        return this;
      }
      hasIndex = true;
      index = paramInteger.intValue();
      return this;
    }
    
    public final Builder setSocialDetail(SocialDetail paramSocialDetail)
    {
      if (paramSocialDetail == null)
      {
        hasSocialDetail = false;
        socialDetail = null;
        return this;
      }
      hasSocialDetail = true;
      socialDetail = paramSocialDetail;
      return this;
    }
    
    public final Builder setThreadId(String paramString)
    {
      if (paramString == null)
      {
        hasThreadId = false;
        threadId = null;
        return this;
      }
      hasThreadId = true;
      threadId = paramString;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.Comment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */