package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ShareArticle$Author
  implements FissileDataModel<Author>, UnionTemplate<Author>
{
  public static final ShareArticleBuilder.AuthorBuilder BUILDER = ShareArticleBuilder.AuthorBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final ExternalAuthor externalAuthorValue;
  public final boolean hasExternalAuthorValue;
  public final boolean hasInfluencerActorValue;
  public final boolean hasMemberActorValue;
  public final InfluencerActor influencerActorValue;
  public final MemberActor memberActorValue;
  
  ShareArticle$Author(ExternalAuthor paramExternalAuthor, InfluencerActor paramInfluencerActor, MemberActor paramMemberActor, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    externalAuthorValue = paramExternalAuthor;
    influencerActorValue = paramInfluencerActor;
    memberActorValue = paramMemberActor;
    hasExternalAuthorValue = paramBoolean1;
    hasInfluencerActorValue = paramBoolean2;
    hasMemberActorValue = paramBoolean3;
    _cachedId = null;
  }
  
  public final Author accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasExternalAuthorValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ExternalAuthor");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = externalAuthorValue.accept(paramDataProcessor);
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
      return new Author((ExternalAuthor)localObject2, (InfluencerActor)localObject3, (MemberActor)localObject1, bool1, bool2, bool3);
      localObject1 = (ExternalAuthor)paramDataProcessor.processDataTemplate(externalAuthorValue);
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
      paramObject = (Author)paramObject;
      if (externalAuthorValue != null)
      {
        if (externalAuthorValue.equals(externalAuthorValue)) {}
      }
      else {
        while (externalAuthorValue != null) {
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
    if (hasExternalAuthorValue)
    {
      if (externalAuthorValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(externalAuthorValue._cachedId) + 9;
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
      i = externalAuthorValue.getSerializedSize() + 7;
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
    if (externalAuthorValue != null)
    {
      i = externalAuthorValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Author");
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
        localByteBuffer.putInt(-1731124413);
        if (hasExternalAuthorValue)
        {
          localByteBuffer.put((byte)1);
          if (externalAuthorValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, externalAuthorValue._cachedId);
            externalAuthorValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          externalAuthorValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle.Author
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */