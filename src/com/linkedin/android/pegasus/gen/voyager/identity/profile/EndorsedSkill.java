package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.EndorsedSkillHighlight;
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

public final class EndorsedSkill
  implements FissileDataModel<EndorsedSkill>, RecordTemplate<EndorsedSkill>
{
  public static final EndorsedSkillBuilder BUILDER = EndorsedSkillBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean endorsedByViewer;
  public final int endorsementCount;
  public final List<Endorsement> endorsements;
  public final Urn entityUrn;
  public final boolean hasEndorsedByViewer;
  public final boolean hasEndorsementCount;
  public final boolean hasEndorsements;
  public final boolean hasEntityUrn;
  public final boolean hasHighlights;
  public final boolean hasSkill;
  public final List<EndorsedSkillHighlight> highlights;
  public final Skill skill;
  
  EndorsedSkill(Urn paramUrn, Skill paramSkill, int paramInt, boolean paramBoolean1, List<Endorsement> paramList, List<EndorsedSkillHighlight> paramList1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    entityUrn = paramUrn;
    skill = paramSkill;
    endorsementCount = paramInt;
    endorsedByViewer = paramBoolean1;
    if (paramList == null)
    {
      paramSkill = null;
      endorsements = paramSkill;
      if (paramList1 != null) {
        break label121;
      }
    }
    label121:
    for (paramSkill = (Skill)localObject;; paramSkill = Collections.unmodifiableList(paramList1))
    {
      highlights = paramSkill;
      hasEntityUrn = paramBoolean2;
      hasSkill = paramBoolean3;
      hasEndorsementCount = paramBoolean4;
      hasEndorsedByViewer = paramBoolean5;
      hasEndorsements = paramBoolean6;
      hasHighlights = paramBoolean7;
      paramSkill = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
      paramSkill = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  private EndorsedSkill accept(DataProcessor paramDataProcessor)
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
    Object localObject3 = null;
    boolean bool1 = false;
    label89:
    boolean bool2;
    int i;
    if (hasSkill)
    {
      paramDataProcessor.startRecordField$505cff1c("skill");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = skill.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label305;
        }
        bool1 = true;
        localObject3 = localObject1;
      }
    }
    else
    {
      if (hasEndorsementCount)
      {
        paramDataProcessor.startRecordField$505cff1c("endorsementCount");
        paramDataProcessor.processInt(endorsementCount);
      }
      if (hasEndorsedByViewer)
      {
        paramDataProcessor.startRecordField$505cff1c("endorsedByViewer");
        paramDataProcessor.processBoolean(endorsedByViewer);
      }
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasEndorsements) {
        break label344;
      }
      paramDataProcessor.startRecordField$505cff1c("endorsements");
      endorsements.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject4 = endorsements.iterator();
      label214:
      if (!((Iterator)localObject4).hasNext()) {
        break label330;
      }
      localObject2 = (Endorsement)((Iterator)localObject4).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label314;
      }
    }
    label305:
    label314:
    for (Object localObject2 = ((Endorsement)localObject2).accept(paramDataProcessor);; localObject2 = (Endorsement)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label214;
      localObject1 = (Skill)paramDataProcessor.processDataTemplate(skill);
      break;
      bool1 = false;
      localObject3 = localObject1;
      break label89;
    }
    label330:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool2 = true;
      label344:
      localObject2 = null;
      localObject4 = null;
      bool3 = false;
      if (!hasHighlights) {
        break label528;
      }
      paramDataProcessor.startRecordField$505cff1c("highlights");
      highlights.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject4;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = highlights.iterator();
      label419:
      if (!localIterator.hasNext()) {
        break label514;
      }
      localObject4 = (EndorsedSkillHighlight)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label498;
      }
    }
    label498:
    for (Object localObject4 = ((EndorsedSkillHighlight)localObject4).accept(paramDataProcessor);; localObject4 = (EndorsedSkillHighlight)paramDataProcessor.processDataTemplate((DataTemplate)localObject4))
    {
      if ((localObject2 != null) && (localObject4 != null)) {
        ((List)localObject2).add(localObject4);
      }
      i += 1;
      break label419;
      bool2 = false;
      break;
    }
    label514:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      label528:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label764;
      }
      if (!hasEndorsements) {
        localObject1 = Collections.emptyList();
      }
      if (!hasHighlights) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (hasSkill) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill", "skill");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasEndorsedByViewer) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill", "endorsedByViewer");
    }
    if (endorsements != null)
    {
      paramDataProcessor = endorsements.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Endorsement)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill", "endorsements");
        }
      }
    }
    if (highlights != null)
    {
      paramDataProcessor = highlights.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((EndorsedSkillHighlight)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill", "highlights");
        }
      }
    }
    return new EndorsedSkill(entityUrn, (Skill)localObject3, endorsementCount, endorsedByViewer, (List)localObject1, (List)localObject2, hasEntityUrn, bool1, hasEndorsementCount, hasEndorsedByViewer, bool2, bool3);
    label764:
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
      paramObject = (EndorsedSkill)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (skill != null)
      {
        if (skill.equals(skill)) {}
      }
      else {
        while (skill != null) {
          return false;
        }
      }
      if (endorsementCount != endorsementCount) {
        return false;
      }
      if (endorsedByViewer != endorsedByViewer) {
        return false;
      }
      if (endorsements != null)
      {
        if (endorsements.equals(endorsements)) {}
      }
      else {
        while (endorsements != null) {
          return false;
        }
      }
      if (highlights == null) {
        break;
      }
    } while (highlights.equals(highlights));
    for (;;)
    {
      return false;
      if (highlights == null) {
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
    if (hasSkill)
    {
      i = j + 1;
      if (skill._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(skill._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasEndorsementCount) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasEndorsedByViewer) {
        i = j + 1;
      }
      i += 1;
      j = i;
      if (!hasEndorsements) {
        break label222;
      }
      i += 2;
      localObject1 = endorsements.iterator();
    }
    Object localObject2;
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label222;
      }
      localObject2 = (Endorsement)((Iterator)localObject1).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += skill.getSerializedSize();
        break;
      }
      i += ((Endorsement)localObject2).getSerializedSize();
    }
    label222:
    i = j + 1;
    j = i;
    if (hasHighlights)
    {
      i += 2;
      localObject1 = highlights.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (EndorsedSkillHighlight)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((EndorsedSkillHighlight)localObject2).getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
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
    int i1;
    int k;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (skill == null) {
        break label142;
      }
      j = skill.hashCode();
      i1 = endorsementCount;
      if (!endorsedByViewer) {
        break label147;
      }
      k = 1;
      label60:
      if (endorsements == null) {
        break label152;
      }
    }
    label142:
    label147:
    label152:
    for (int m = endorsements.hashCode();; m = 0)
    {
      if (highlights != null) {
        n = highlights.hashCode();
      }
      i = (m + (k + ((j + (i + 527) * 31) * 31 + i1) * 31) * 31) * 31 + n;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EndorsedSkill");
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
    label206:
    label230:
    label254:
    label263:
    label380:
    label405:
    label415:
    label425:
    label431:
    label464:
    label471:
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-148545651);
        Object localObject1;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject1 = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasSkill) {
            break label405;
          }
          localByteBuffer.put((byte)1);
          if (skill._cachedId == null) {
            break label380;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, skill._cachedId);
          skill.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasEndorsementCount) {
            break label415;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(endorsementCount);
          if (!hasEndorsedByViewer) {
            break label431;
          }
          localByteBuffer.put((byte)1);
          if (!endorsedByViewer) {
            break label425;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasEndorsements) {
            break label464;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, endorsements.size());
          localObject1 = endorsements.iterator();
        }
        Object localObject2;
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label471;
          }
          localObject2 = (Endorsement)((Iterator)localObject1).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((Endorsement)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            skill.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label206;
            localByteBuffer.put((byte)0);
            break label206;
            localByteBuffer.put((byte)0);
            break label230;
            i = 0;
            break label254;
            localByteBuffer.put((byte)0);
            break label263;
          }
          localByteBuffer.put((byte)1);
          ((Endorsement)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasHighlights)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, highlights.size());
          localObject1 = highlights.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (EndorsedSkillHighlight)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((EndorsedSkillHighlight)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((EndorsedSkillHighlight)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
    implements RecordTemplateBuilder<EndorsedSkill>
  {
    private boolean endorsedByViewer = false;
    private int endorsementCount = 0;
    private List<Endorsement> endorsements = null;
    private Urn entityUrn = null;
    private boolean hasEndorsedByViewer = false;
    private boolean hasEndorsementCount = false;
    private boolean hasEndorsements = false;
    private boolean hasEntityUrn = false;
    private boolean hasHighlights = false;
    private boolean hasSkill = false;
    private List<EndorsedSkillHighlight> highlights = null;
    private Skill skill = null;
    
    private EndorsedSkill build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (EndorsedSkill.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (endorsements != null)
      {
        paramFlavor = endorsements.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((Endorsement)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill", "endorsements");
              if (!hasEndorsementCount) {
                endorsementCount = 0;
              }
              if (!hasEndorsements) {
                endorsements = Collections.emptyList();
              }
              if (!hasHighlights) {
                highlights = Collections.emptyList();
              }
              if (!hasSkill) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill", "skill");
              }
              if (hasEndorsedByViewer) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill", "endorsedByViewer");
            }
          }
        }
      }
      if (highlights != null)
      {
        paramFlavor = highlights.iterator();
        while (paramFlavor.hasNext()) {
          if ((EndorsedSkillHighlight)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill", "highlights");
          }
        }
      }
      return new EndorsedSkill(entityUrn, skill, endorsementCount, endorsedByViewer, endorsements, highlights, hasEntityUrn, hasSkill, hasEndorsementCount, hasEndorsedByViewer, hasEndorsements, hasHighlights);
    }
    
    public final EndorsedSkill build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
    
    public final Builder setEndorsedByViewer(Boolean paramBoolean)
    {
      if (paramBoolean == null)
      {
        hasEndorsedByViewer = false;
        endorsedByViewer = false;
        return this;
      }
      hasEndorsedByViewer = true;
      endorsedByViewer = paramBoolean.booleanValue();
      return this;
    }
    
    public final Builder setEndorsementCount(Integer paramInteger)
    {
      if ((paramInteger == null) || (paramInteger.intValue() == 0))
      {
        hasEndorsementCount = false;
        endorsementCount = 0;
        return this;
      }
      hasEndorsementCount = true;
      endorsementCount = paramInteger.intValue();
      return this;
    }
    
    public final Builder setEndorsements(List<Endorsement> paramList)
    {
      if (paramList.equals(Collections.emptyList()))
      {
        hasEndorsements = false;
        endorsements = Collections.emptyList();
        return this;
      }
      hasEndorsements = true;
      endorsements = paramList;
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
    
    public final Builder setSkill(Skill paramSkill)
    {
      if (paramSkill == null)
      {
        hasSkill = false;
        skill = null;
        return this;
      }
      hasSkill = true;
      skill = paramSkill;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */