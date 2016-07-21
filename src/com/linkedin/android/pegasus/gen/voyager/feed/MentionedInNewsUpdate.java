package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
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

public final class MentionedInNewsUpdate
  implements FissileDataModel<MentionedInNewsUpdate>, RecordTemplate<MentionedInNewsUpdate>
{
  public static final MentionedInNewsUpdateBuilder BUILDER = MentionedInNewsUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<UpdateAction> actions;
  public final ShareArticle article;
  public final boolean hasActions;
  public final boolean hasArticle;
  public final boolean hasHeader;
  public final boolean hasMentionedActor;
  public final AttributedText header;
  public final MentionedActor mentionedActor;
  
  MentionedInNewsUpdate(List<UpdateAction> paramList, MentionedActor paramMentionedActor, AttributedText paramAttributedText, ShareArticle paramShareArticle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      actions = paramList;
      mentionedActor = paramMentionedActor;
      header = paramAttributedText;
      article = paramShareArticle;
      hasActions = paramBoolean1;
      hasMentionedActor = paramBoolean2;
      hasHeader = paramBoolean3;
      hasArticle = paramBoolean4;
      _cachedId = null;
      return;
    }
  }
  
  public final MentionedInNewsUpdate accept(DataProcessor paramDataProcessor)
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
      if (hasMentionedActor)
      {
        paramDataProcessor.startRecordField$505cff1c("mentionedActor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label395;
        }
        localObject2 = mentionedActor.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label413;
        }
        bool2 = true;
        localObject3 = localObject2;
      }
      localObject4 = null;
      bool3 = false;
      if (hasHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("header");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label423;
        }
        localObject2 = header.accept(paramDataProcessor);
        label274:
        if (localObject2 == null) {
          break label441;
        }
        bool3 = true;
        localObject4 = localObject2;
      }
      label286:
      localObject2 = null;
      bool4 = false;
      if (hasArticle)
      {
        paramDataProcessor.startRecordField$505cff1c("article");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label451;
        }
        localObject2 = article.accept(paramDataProcessor);
        label326:
        if (localObject2 == null) {
          break label469;
        }
      }
    }
    label395:
    label413:
    label423:
    label441:
    label451:
    label469:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label586;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasMentionedActor) {
          break label475;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate", "mentionedActor");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      break;
      localObject2 = (MentionedActor)paramDataProcessor.processDataTemplate(mentionedActor);
      break label222;
      bool2 = false;
      localObject3 = localObject2;
      break label234;
      localObject2 = (AttributedText)paramDataProcessor.processDataTemplate(header);
      break label274;
      bool3 = false;
      localObject4 = localObject2;
      break label286;
      localObject2 = (ShareArticle)paramDataProcessor.processDataTemplate(article);
      break label326;
    }
    label475:
    if (!hasHeader) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate", "header");
    }
    if (!hasArticle) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate", "article");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate", "actions");
        }
      }
    }
    return new MentionedInNewsUpdate((List)localObject1, (MentionedActor)localObject3, (AttributedText)localObject4, (ShareArticle)localObject2, bool1, bool2, bool3, bool4);
    label586:
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
      paramObject = (MentionedInNewsUpdate)paramObject;
      if (actions != null)
      {
        if (actions.equals(actions)) {}
      }
      else {
        while (actions != null) {
          return false;
        }
      }
      if (mentionedActor != null)
      {
        if (mentionedActor.equals(mentionedActor)) {}
      }
      else {
        while (mentionedActor != null) {
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
      if (article == null) {
        break;
      }
    } while (article.equals(article));
    for (;;)
    {
      return false;
      if (article == null) {
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
    if (hasMentionedActor)
    {
      i = j + 1;
      if (mentionedActor._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(mentionedActor._cachedId);
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
          break label250;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(header._cachedId);
      }
      label188:
      j = i + 1;
      i = j;
      if (hasArticle)
      {
        i = j + 1;
        if (article._cachedId == null) {
          break label263;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(article._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += mentionedActor.getSerializedSize();
      break;
      label250:
      i += header.getSerializedSize();
      break label188;
      label263:
      i += article.getSerializedSize();
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
    if (actions != null)
    {
      i = actions.hashCode();
      if (mentionedActor == null) {
        break label112;
      }
      j = mentionedActor.hashCode();
      label47:
      if (header == null) {
        break label117;
      }
    }
    label112:
    label117:
    for (int k = header.hashCode();; k = 0)
    {
      if (article != null) {
        m = article.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label47;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MentionedInNewsUpdate");
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
    label367:
    label495:
    label520:
    label530:
    label555:
    label563:
    label565:
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
        localByteBuffer.putInt(1832416499);
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
        if (hasMentionedActor)
        {
          localByteBuffer.put((byte)1);
          if (mentionedActor._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, mentionedActor._cachedId);
            mentionedActor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasHeader) {
              break label520;
            }
            localByteBuffer.put((byte)1);
            if (header._cachedId == null) {
              break label495;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, header._cachedId);
            header.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasArticle) {
              break label555;
            }
            localByteBuffer.put((byte)1);
            if (article._cachedId == null) {
              break label530;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, article._cachedId);
            article.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label563;
          }
          if (str != null) {
            break label565;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          mentionedActor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          header.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label367;
          localByteBuffer.put((byte)0);
          break label367;
          localByteBuffer.put((byte)1);
          article.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class MentionedActor
    implements FissileDataModel<MentionedActor>, UnionTemplate<MentionedActor>
  {
    public static final MentionedInNewsUpdateBuilder.MentionedActorBuilder BUILDER = MentionedInNewsUpdateBuilder.MentionedActorBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final CompanyActor companyActorValue;
    public final boolean hasCompanyActorValue;
    public final boolean hasInfluencerActorValue;
    public final boolean hasMemberActorValue;
    public final InfluencerActor influencerActorValue;
    public final MemberActor memberActorValue;
    
    MentionedActor(CompanyActor paramCompanyActor, InfluencerActor paramInfluencerActor, MemberActor paramMemberActor, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      companyActorValue = paramCompanyActor;
      influencerActorValue = paramInfluencerActor;
      memberActorValue = paramMemberActor;
      hasCompanyActorValue = paramBoolean1;
      hasInfluencerActorValue = paramBoolean2;
      hasMemberActorValue = paramBoolean3;
      _cachedId = null;
    }
    
    public final MentionedActor accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label56:
      Object localObject3;
      boolean bool2;
      if (hasCompanyActorValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.CompanyActor");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = companyActorValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label205;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasInfluencerActorValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.InfluencerActor");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label214;
          }
          localObject1 = influencerActorValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label232;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        label106:
        localObject1 = null;
        bool3 = false;
        if (hasMemberActorValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.MemberActor");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label241;
          }
          localObject1 = memberActorValue.accept(paramDataProcessor);
          label146:
          if (localObject1 == null) {
            break label259;
          }
        }
      }
      label205:
      label214:
      label232:
      label241:
      label259:
      for (boolean bool3 = true;; bool3 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label265;
        }
        return new MentionedActor((CompanyActor)localObject2, (InfluencerActor)localObject3, (MemberActor)localObject1, bool1, bool2, bool3);
        localObject1 = (CompanyActor)paramDataProcessor.processDataTemplate(companyActorValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (InfluencerActor)paramDataProcessor.processDataTemplate(influencerActorValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (MemberActor)paramDataProcessor.processDataTemplate(memberActorValue);
        break label146;
      }
      label265:
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
        paramObject = (MentionedActor)paramObject;
        if (companyActorValue != null)
        {
          if (companyActorValue.equals(companyActorValue)) {}
        }
        else {
          while (companyActorValue != null) {
            return false;
          }
        }
        if (influencerActorValue != null)
        {
          if (influencerActorValue.equals(influencerActorValue)) {}
        }
        else {
          while (influencerActorValue != null) {
            return false;
          }
        }
        if (memberActorValue == null) {
          break;
        }
      } while (memberActorValue.equals(memberActorValue));
      for (;;)
      {
        return false;
        if (memberActorValue == null) {
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
      if (hasCompanyActorValue)
      {
        if (companyActorValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(companyActorValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasInfluencerActorValue)
        {
          i = j + 1;
          if (influencerActorValue._cachedId == null) {
            break label156;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(influencerActorValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasMemberActorValue)
        {
          i = j + 1;
          if (memberActorValue._cachedId == null) {
            break label169;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(memberActorValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = companyActorValue.getSerializedSize() + 7;
        break;
        label156:
        i += influencerActorValue.getSerializedSize();
        break label93;
        label169:
        i += memberActorValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int k = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      int i;
      if (companyActorValue != null)
      {
        i = companyActorValue.hashCode();
        if (influencerActorValue == null) {
          break label87;
        }
      }
      label87:
      for (int j = influencerActorValue.hashCode();; j = 0)
      {
        if (memberActorValue != null) {
          k = memberActorValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MentionedActor");
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
      label358:
      label383:
      label393:
      label418:
      label426:
      label428:
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
          localByteBuffer.putInt(589834161);
          if (hasCompanyActorValue)
          {
            localByteBuffer.put((byte)1);
            if (companyActorValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, companyActorValue._cachedId);
              companyActorValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasInfluencerActorValue) {
                break label383;
              }
              localByteBuffer.put((byte)1);
              if (influencerActorValue._cachedId == null) {
                break label358;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, influencerActorValue._cachedId);
              influencerActorValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMemberActorValue) {
                break label418;
              }
              localByteBuffer.put((byte)1);
              if (memberActorValue._cachedId == null) {
                break label393;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, memberActorValue._cachedId);
              memberActorValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label426;
            }
            if (str != null) {
              break label428;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            companyActorValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            influencerActorValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            memberActorValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */