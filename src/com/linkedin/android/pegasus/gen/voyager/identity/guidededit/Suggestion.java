package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Certification;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
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

public final class Suggestion
  implements FissileDataModel<Suggestion>, RecordTemplate<Suggestion>
{
  public static final SuggestionBuilder BUILDER = SuggestionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Urn entityUrn;
  public final String flowTrackingId;
  public final boolean hasEntityUrn;
  public final boolean hasFlowTrackingId;
  public final boolean hasInferredMembers;
  public final boolean hasRawProfileElement;
  public final boolean hasSourceType;
  public final boolean hasSuggestedContent;
  public final List<Urn> inferredMembers;
  public final Urn rawProfileElement;
  public final SuggestionSourceType sourceType;
  public final SuggestedContent suggestedContent;
  
  Suggestion(Urn paramUrn1, Urn paramUrn2, SuggestedContent paramSuggestedContent, SuggestionSourceType paramSuggestionSourceType, List<Urn> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    entityUrn = paramUrn1;
    rawProfileElement = paramUrn2;
    suggestedContent = paramSuggestedContent;
    sourceType = paramSuggestionSourceType;
    if (paramList == null) {}
    for (paramUrn2 = null;; paramUrn2 = Collections.unmodifiableList(paramList))
    {
      inferredMembers = paramUrn2;
      flowTrackingId = paramString;
      hasEntityUrn = paramBoolean1;
      hasRawProfileElement = paramBoolean2;
      hasSuggestedContent = paramBoolean3;
      hasSourceType = paramBoolean4;
      hasInferredMembers = paramBoolean5;
      hasFlowTrackingId = paramBoolean6;
      paramUrn2 = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
      return;
    }
  }
  
  public final Suggestion accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasRawProfileElement)
    {
      paramDataProcessor.startRecordField$505cff1c("rawProfileElement");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(rawProfileElement));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasSuggestedContent)
    {
      paramDataProcessor.startRecordField$505cff1c("suggestedContent");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label289;
      }
      localObject1 = suggestedContent.accept(paramDataProcessor);
      if (localObject1 == null) {
        break label307;
      }
      bool1 = true;
    }
    for (localObject2 = localObject1;; localObject2 = localObject1)
    {
      if (hasSourceType)
      {
        paramDataProcessor.startRecordField$505cff1c("sourceType");
        paramDataProcessor.processEnum(sourceType);
      }
      localObject1 = null;
      Iterator localIterator = null;
      bool2 = false;
      if (!hasInferredMembers) {
        break label330;
      }
      paramDataProcessor.startRecordField$505cff1c("inferredMembers");
      inferredMembers.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localIterator = inferredMembers.iterator();
      while (localIterator.hasNext())
      {
        Urn localUrn = (Urn)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(localUrn));
        if (localObject1 != null) {
          ((List)localObject1).add(localUrn);
        }
        i += 1;
      }
      label289:
      localObject1 = (SuggestedContent)paramDataProcessor.processDataTemplate(suggestedContent);
      break;
      label307:
      bool1 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label330:
      if (hasFlowTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("flowTrackingId");
        paramDataProcessor.processString(flowTrackingId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label540;
      }
      try
      {
        if (hasRawProfileElement) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion", "rawProfileElement");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasSuggestedContent) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion", "suggestedContent");
    }
    if (!hasFlowTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion", "flowTrackingId");
    }
    if (inferredMembers != null)
    {
      paramDataProcessor = inferredMembers.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Urn)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion", "inferredMembers");
        }
      }
    }
    return new Suggestion(entityUrn, rawProfileElement, (SuggestedContent)localObject2, sourceType, (List)localObject1, flowTrackingId, hasEntityUrn, hasRawProfileElement, bool1, hasSourceType, bool2, hasFlowTrackingId);
    label540:
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
      paramObject = (Suggestion)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (rawProfileElement != null)
      {
        if (rawProfileElement.equals(rawProfileElement)) {}
      }
      else {
        while (rawProfileElement != null) {
          return false;
        }
      }
      if (suggestedContent != null)
      {
        if (suggestedContent.equals(suggestedContent)) {}
      }
      else {
        while (suggestedContent != null) {
          return false;
        }
      }
      if (sourceType != null)
      {
        if (sourceType.equals(sourceType)) {}
      }
      else {
        while (sourceType != null) {
          return false;
        }
      }
      if (inferredMembers == null) {
        break;
      }
    } while (inferredMembers.equals(inferredMembers));
    for (;;)
    {
      return false;
      if (inferredMembers == null) {
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
    if (hasEntityUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasRawProfileElement)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(rawProfileElement));
    }
    j = i + 1;
    i = j;
    if (hasSuggestedContent)
    {
      i = j + 1;
      if (suggestedContent._cachedId == null) {
        break label206;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(suggestedContent._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasSourceType) {
        i = j + 2;
      }
      i += 1;
      j = i;
      if (!hasInferredMembers) {
        break;
      }
      i += 2;
      localObject = inferredMembers.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        Urn localUrn = (Urn)((Iterator)localObject).next();
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(localUrn));
      }
      label206:
      i += suggestedContent.getSerializedSize();
    }
    j += 1;
    i = j;
    if (hasFlowTrackingId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(flowTrackingId);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (rawProfileElement == null) {
        break label134;
      }
      j = rawProfileElement.hashCode();
      if (suggestedContent == null) {
        break label139;
      }
      k = suggestedContent.hashCode();
      label60:
      if (sourceType == null) {
        break label144;
      }
    }
    label134:
    label139:
    label144:
    for (int m = sourceType.hashCode();; m = 0)
    {
      if (inferredMembers != null) {
        n = inferredMembers.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Suggestion");
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
    label239:
    label363:
    label373:
    label398:
    label408:
    label418:
    label494:
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
        localByteBuffer.putInt(-661026821);
        Object localObject;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasRawProfileElement) {
            break label363;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(rawProfileElement));
          if (!hasSuggestedContent) {
            break label398;
          }
          localByteBuffer.put((byte)1);
          if (suggestedContent._cachedId == null) {
            break label373;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, suggestedContent._cachedId);
          suggestedContent.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSourceType) {
            break label408;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, sourceType.ordinal());
        }
        for (;;)
        {
          if (!hasInferredMembers) {
            break label418;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, inferredMembers.size());
          localObject = inferredMembers.iterator();
          while (((Iterator)localObject).hasNext())
          {
            Urn localUrn = (Urn)((Iterator)localObject).next();
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(localUrn));
          }
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label179;
          localByteBuffer.put((byte)1);
          suggestedContent.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label239;
          localByteBuffer.put((byte)0);
          break label239;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasFlowTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, flowTrackingId);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label494;
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
  
  public static final class SuggestedContent
    implements FissileDataModel<SuggestedContent>, UnionTemplate<SuggestedContent>
  {
    public static final SuggestionBuilder.SuggestedContentBuilder BUILDER = SuggestionBuilder.SuggestedContentBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final Certification certificationValue;
    public final boolean hasCertificationValue;
    public final boolean hasPatentValue;
    public final boolean hasPublicationValue;
    public final boolean hasSkillValue;
    public final Patent patentValue;
    public final Publication publicationValue;
    public final Skill skillValue;
    
    SuggestedContent(Skill paramSkill, Certification paramCertification, Patent paramPatent, Publication paramPublication, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      skillValue = paramSkill;
      certificationValue = paramCertification;
      patentValue = paramPatent;
      publicationValue = paramPublication;
      hasSkillValue = paramBoolean1;
      hasCertificationValue = paramBoolean2;
      hasPatentValue = paramBoolean3;
      hasPublicationValue = paramBoolean4;
      _cachedId = null;
    }
    
    public final SuggestedContent accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label56:
      Object localObject3;
      boolean bool2;
      label95:
      label106:
      Object localObject4;
      boolean bool3;
      if (hasSkillValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.Skill");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = skillValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label261;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasCertificationValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.Certification");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label270;
          }
          localObject1 = certificationValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label288;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        localObject4 = null;
        bool3 = false;
        if (hasPatentValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.Patent");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label297;
          }
          localObject1 = patentValue.accept(paramDataProcessor);
          label146:
          if (localObject1 == null) {
            break label315;
          }
          bool3 = true;
          localObject4 = localObject1;
        }
        label158:
        localObject1 = null;
        bool4 = false;
        if (hasPublicationValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.Publication");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label325;
          }
          localObject1 = publicationValue.accept(paramDataProcessor);
          label198:
          if (localObject1 == null) {
            break label343;
          }
        }
      }
      label261:
      label270:
      label288:
      label297:
      label315:
      label325:
      label343:
      for (boolean bool4 = true;; bool4 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label349;
        }
        return new SuggestedContent((Skill)localObject2, (Certification)localObject3, (Patent)localObject4, (Publication)localObject1, bool1, bool2, bool3, bool4);
        localObject1 = (Skill)paramDataProcessor.processDataTemplate(skillValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (Certification)paramDataProcessor.processDataTemplate(certificationValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (Patent)paramDataProcessor.processDataTemplate(patentValue);
        break label146;
        bool3 = false;
        localObject4 = localObject1;
        break label158;
        localObject1 = (Publication)paramDataProcessor.processDataTemplate(publicationValue);
        break label198;
      }
      label349:
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
        paramObject = (SuggestedContent)paramObject;
        if (skillValue != null)
        {
          if (skillValue.equals(skillValue)) {}
        }
        else {
          while (skillValue != null) {
            return false;
          }
        }
        if (certificationValue != null)
        {
          if (certificationValue.equals(certificationValue)) {}
        }
        else {
          while (certificationValue != null) {
            return false;
          }
        }
        if (patentValue != null)
        {
          if (patentValue.equals(patentValue)) {}
        }
        else {
          while (patentValue != null) {
            return false;
          }
        }
        if (publicationValue == null) {
          break;
        }
      } while (publicationValue.equals(publicationValue));
      for (;;)
      {
        return false;
        if (publicationValue == null) {
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
      if (hasSkillValue)
      {
        if (skillValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(skillValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasCertificationValue)
        {
          i = j + 1;
          if (certificationValue._cachedId == null) {
            break label198;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(certificationValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasPatentValue)
        {
          i = j + 1;
          if (patentValue._cachedId == null) {
            break label211;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(patentValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasPublicationValue)
        {
          i = j + 1;
          if (publicationValue._cachedId == null) {
            break label224;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(publicationValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = skillValue.getSerializedSize() + 7;
        break;
        label198:
        i += certificationValue.getSerializedSize();
        break label93;
        label211:
        i += patentValue.getSerializedSize();
        break label135;
        label224:
        i += publicationValue.getSerializedSize();
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
      if (skillValue != null)
      {
        i = skillValue.hashCode();
        if (certificationValue == null) {
          break label110;
        }
        j = certificationValue.hashCode();
        label45:
        if (patentValue == null) {
          break label115;
        }
      }
      label110:
      label115:
      for (int k = patentValue.hashCode();; k = 0)
      {
        if (publicationValue != null) {
          m = publicationValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SuggestedContent");
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
          localByteBuffer.putInt(1978445395);
          if (hasSkillValue)
          {
            localByteBuffer.put((byte)1);
            if (skillValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, skillValue._cachedId);
              skillValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasCertificationValue) {
                break label443;
              }
              localByteBuffer.put((byte)1);
              if (certificationValue._cachedId == null) {
                break label418;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, certificationValue._cachedId);
              certificationValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasPatentValue) {
                break label478;
              }
              localByteBuffer.put((byte)1);
              if (patentValue._cachedId == null) {
                break label453;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, patentValue._cachedId);
              patentValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasPublicationValue) {
                break label513;
              }
              localByteBuffer.put((byte)1);
              if (publicationValue._cachedId == null) {
                break label488;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, publicationValue._cachedId);
              publicationValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            skillValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            certificationValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            patentValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label290;
            localByteBuffer.put((byte)0);
            break label290;
            localByteBuffer.put((byte)1);
            publicationValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */