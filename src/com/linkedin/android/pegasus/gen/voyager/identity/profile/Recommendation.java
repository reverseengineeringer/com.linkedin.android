package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Recommendation
  implements FissileDataModel<Recommendation>, RecordTemplate<Recommendation>
{
  public static final RecommendationBuilder BUILDER = RecommendationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final long created;
  public final long deleted;
  public final Urn entityUrn;
  public final boolean hasCreated;
  public final boolean hasDeleted;
  public final boolean hasEntityUrn;
  public final boolean hasLastModified;
  public final boolean hasRecommendationText;
  public final boolean hasRecommendee;
  public final boolean hasRecommendeeEntity;
  public final boolean hasRecommender;
  public final boolean hasRecommenderEntity;
  public final boolean hasRelationship;
  public final boolean hasStatus;
  public final long lastModified;
  public final String recommendationText;
  public final MiniProfile recommendee;
  public final Urn recommendeeEntity;
  public final MiniProfile recommender;
  public final Urn recommenderEntity;
  public final RecommendationRelationship relationship;
  public final RecommendationStatus status;
  
  Recommendation(Urn paramUrn1, Urn paramUrn2, RecommendationRelationship paramRecommendationRelationship, String paramString, RecommendationStatus paramRecommendationStatus, long paramLong1, long paramLong2, long paramLong3, Urn paramUrn3, MiniProfile paramMiniProfile1, MiniProfile paramMiniProfile2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11)
  {
    recommenderEntity = paramUrn1;
    recommendeeEntity = paramUrn2;
    relationship = paramRecommendationRelationship;
    recommendationText = paramString;
    status = paramRecommendationStatus;
    created = paramLong1;
    lastModified = paramLong2;
    deleted = paramLong3;
    entityUrn = paramUrn3;
    recommender = paramMiniProfile1;
    recommendee = paramMiniProfile2;
    hasRecommenderEntity = paramBoolean1;
    hasRecommendeeEntity = paramBoolean2;
    hasRelationship = paramBoolean3;
    hasRecommendationText = paramBoolean4;
    hasStatus = paramBoolean5;
    hasCreated = paramBoolean6;
    hasLastModified = paramBoolean7;
    hasDeleted = paramBoolean8;
    hasEntityUrn = paramBoolean9;
    hasRecommender = paramBoolean10;
    hasRecommendee = paramBoolean11;
    paramUrn1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn3);
  }
  
  private Recommendation accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasRecommenderEntity)
    {
      paramDataProcessor.startRecordField$505cff1c("recommenderEntity");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(recommenderEntity));
    }
    if (hasRecommendeeEntity)
    {
      paramDataProcessor.startRecordField$505cff1c("recommendeeEntity");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(recommendeeEntity));
    }
    if (hasRelationship)
    {
      paramDataProcessor.startRecordField$505cff1c("relationship");
      paramDataProcessor.processEnum(relationship);
    }
    if (hasRecommendationText)
    {
      paramDataProcessor.startRecordField$505cff1c("recommendationText");
      paramDataProcessor.processString(recommendationText);
    }
    if (hasStatus)
    {
      paramDataProcessor.startRecordField$505cff1c("status");
      paramDataProcessor.processEnum(status);
    }
    if (hasCreated)
    {
      paramDataProcessor.startRecordField$505cff1c("created");
      paramDataProcessor.processLong(created);
    }
    if (hasLastModified)
    {
      paramDataProcessor.startRecordField$505cff1c("lastModified");
      paramDataProcessor.processLong(lastModified);
    }
    if (hasDeleted)
    {
      paramDataProcessor.startRecordField$505cff1c("deleted");
      paramDataProcessor.processLong(deleted);
    }
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasRecommender)
    {
      paramDataProcessor.startRecordField$505cff1c("recommender");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = recommender.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label413;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label305:
      localObject1 = null;
      bool2 = false;
      if (hasRecommendee)
      {
        paramDataProcessor.startRecordField$505cff1c("recommendee");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label422;
        }
        localObject1 = recommendee.accept(paramDataProcessor);
        label344:
        if (localObject1 == null) {
          break label440;
        }
      }
    }
    label413:
    label422:
    label440:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label645;
      }
      try
      {
        if (hasRelationship) {
          break label445;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Recommendation", "relationship");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(recommender);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label305;
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(recommendee);
      break label344;
    }
    label445:
    if (!hasRecommendationText) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Recommendation", "recommendationText");
    }
    if (!hasStatus) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Recommendation", "status");
    }
    if (!hasCreated) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Recommendation", "created");
    }
    if (!hasLastModified) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Recommendation", "lastModified");
    }
    if (!hasRecommender) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Recommendation", "recommender");
    }
    if (!hasRecommendee) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Recommendation", "recommendee");
    }
    return new Recommendation(recommenderEntity, recommendeeEntity, relationship, recommendationText, status, created, lastModified, deleted, entityUrn, (MiniProfile)localObject2, (MiniProfile)localObject1, hasRecommenderEntity, hasRecommendeeEntity, hasRelationship, hasRecommendationText, hasStatus, hasCreated, hasLastModified, hasDeleted, hasEntityUrn, bool1, bool2);
    label645:
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
      paramObject = (Recommendation)paramObject;
      if (recommenderEntity != null)
      {
        if (recommenderEntity.equals(recommenderEntity)) {}
      }
      else {
        while (recommenderEntity != null) {
          return false;
        }
      }
      if (recommendeeEntity != null)
      {
        if (recommendeeEntity.equals(recommendeeEntity)) {}
      }
      else {
        while (recommendeeEntity != null) {
          return false;
        }
      }
      if (relationship != null)
      {
        if (relationship.equals(relationship)) {}
      }
      else {
        while (relationship != null) {
          return false;
        }
      }
      if (recommendationText != null)
      {
        if (recommendationText.equals(recommendationText)) {}
      }
      else {
        while (recommendationText != null) {
          return false;
        }
      }
      if (status != null)
      {
        if (status.equals(status)) {}
      }
      else {
        while (status != null) {
          return false;
        }
      }
      if (created != created) {
        return false;
      }
      if (lastModified != lastModified) {
        return false;
      }
      if (deleted != deleted) {
        return false;
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
      if (recommender != null)
      {
        if (recommender.equals(recommender)) {}
      }
      else {
        while (recommender != null) {
          return false;
        }
      }
      if (recommendee == null) {
        break;
      }
    } while (recommendee.equals(recommendee));
    for (;;)
    {
      return false;
      if (recommendee == null) {
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
    UrnCoercer localUrnCoercer;
    if (hasRecommenderEntity)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(recommenderEntity)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasRecommendeeEntity)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(recommendeeEntity));
    }
    j = i + 1;
    i = j;
    if (hasRelationship) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasRecommendationText) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(recommendationText);
    }
    j = i + 1;
    i = j;
    if (hasStatus) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasCreated) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasLastModified) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasDeleted) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasEntityUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    j = i + 1;
    i = j;
    if (hasRecommender)
    {
      i = j + 1;
      if (recommender._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(recommender._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasRecommendee)
      {
        i = j + 1;
        if (recommendee._cachedId == null) {
          break label326;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(recommendee._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += recommender.getSerializedSize();
      break;
      label326:
      i += recommendee.getSerializedSize();
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
    int n;
    label92:
    int i4;
    int i5;
    int i6;
    int i1;
    if (recommenderEntity != null)
    {
      i = recommenderEntity.hashCode();
      if (recommendeeEntity == null) {
        break label261;
      }
      j = recommendeeEntity.hashCode();
      if (relationship == null) {
        break label266;
      }
      k = relationship.hashCode();
      if (recommendationText == null) {
        break label271;
      }
      m = recommendationText.hashCode();
      if (status == null) {
        break label277;
      }
      n = status.hashCode();
      i4 = (int)(created ^ created >>> 32);
      i5 = (int)(lastModified ^ lastModified >>> 32);
      i6 = (int)(deleted ^ deleted >>> 32);
      if (entityUrn == null) {
        break label283;
      }
      i1 = entityUrn.hashCode();
      label153:
      if (recommender == null) {
        break label289;
      }
    }
    label261:
    label266:
    label271:
    label277:
    label283:
    label289:
    for (int i2 = recommender.hashCode();; i2 = 0)
    {
      if (recommendee != null) {
        i3 = recommendee.hashCode();
      }
      i = (i2 + (i1 + ((((n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i4) * 31 + i5) * 31 + i6) * 31) * 31) * 31 + i3;
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
      break label92;
      i1 = 0;
      break label153;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Recommendation");
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
    label179:
    label208:
    label234:
    label263:
    label287:
    label311:
    label335:
    label369:
    label429:
    label532:
    label542:
    label552:
    label562:
    label572:
    label582:
    label592:
    label602:
    label612:
    label637:
    label647:
    label672:
    label680:
    label682:
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
        localByteBuffer.putInt(34830106);
        if (hasRecommenderEntity)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(recommenderEntity));
          if (!hasRecommendeeEntity) {
            break label532;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(recommendeeEntity));
          if (!hasRelationship) {
            break label542;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, relationship.ordinal());
          if (!hasRecommendationText) {
            break label552;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, recommendationText);
          if (!hasStatus) {
            break label562;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, status.ordinal());
          if (!hasCreated) {
            break label572;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(created);
          if (!hasLastModified) {
            break label582;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(lastModified);
          if (!hasDeleted) {
            break label592;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(deleted);
          if (!hasEntityUrn) {
            break label602;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasRecommender) {
            break label637;
          }
          localByteBuffer.put((byte)1);
          if (recommender._cachedId == null) {
            break label612;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, recommender._cachedId);
          recommender.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasRecommendee) {
            break label672;
          }
          localByteBuffer.put((byte)1);
          if (recommendee._cachedId == null) {
            break label647;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, recommendee._cachedId);
          recommendee.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label680;
          }
          if (str != null) {
            break label682;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label179;
          localByteBuffer.put((byte)0);
          break label208;
          localByteBuffer.put((byte)0);
          break label234;
          localByteBuffer.put((byte)0);
          break label263;
          localByteBuffer.put((byte)0);
          break label287;
          localByteBuffer.put((byte)0);
          break label311;
          localByteBuffer.put((byte)0);
          break label335;
          localByteBuffer.put((byte)0);
          break label369;
          localByteBuffer.put((byte)1);
          recommender.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label429;
          localByteBuffer.put((byte)0);
          break label429;
          localByteBuffer.put((byte)1);
          recommendee.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Recommendation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */