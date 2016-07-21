package com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EndorsedSkillHighlight
  implements FissileDataModel<EndorsedSkillHighlight>, RecordTemplate<EndorsedSkillHighlight>
{
  public static final EndorsedSkillHighlightBuilder BUILDER = EndorsedSkillHighlightBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Detail detail;
  public final boolean hasDetail;
  public final boolean hasSignature;
  public final String signature;
  
  EndorsedSkillHighlight(String paramString, Detail paramDetail, boolean paramBoolean1, boolean paramBoolean2)
  {
    signature = paramString;
    detail = paramDetail;
    hasSignature = paramBoolean1;
    hasDetail = paramBoolean2;
    _cachedId = null;
  }
  
  public final EndorsedSkillHighlight accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasSignature)
    {
      paramDataProcessor.startRecordField$505cff1c("signature");
      paramDataProcessor.processString(signature);
    }
    Detail localDetail = null;
    boolean bool = false;
    if (hasDetail)
    {
      paramDataProcessor.startRecordField$505cff1c("detail");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localDetail = detail.accept(paramDataProcessor);
      if (localDetail == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label177;
      }
      try
      {
        if (hasSignature) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.EndorsedSkillHighlight", "signature");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localDetail = (Detail)paramDataProcessor.processDataTemplate(detail);
      break;
    }
    label140:
    if (!hasDetail) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.EndorsedSkillHighlight", "detail");
    }
    return new EndorsedSkillHighlight(signature, localDetail, hasSignature, bool);
    label177:
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
      paramObject = (EndorsedSkillHighlight)paramObject;
      if (signature != null)
      {
        if (signature.equals(signature)) {}
      }
      else {
        while (signature != null) {
          return false;
        }
      }
      if (detail == null) {
        break;
      }
    } while (detail.equals(detail));
    for (;;)
    {
      return false;
      if (detail == null) {
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
    if (hasSignature) {
      i = PegasusBinaryUtils.getEncodedLength(signature) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasDetail)
    {
      i = j + 1;
      if (detail._cachedId == null) {
        break label87;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(detail._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label87:
      i += detail.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (signature != null) {}
    for (int i = signature.hashCode();; i = 0)
    {
      if (detail != null) {
        j = detail.hashCode();
      }
      i = (i + 527) * 31 + j;
      _cachedHashCode = i;
      return i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EndorsedSkillHighlight");
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
    label239:
    label264:
    label272:
    label274:
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
        localByteBuffer.putInt(-1053018383);
        if (hasSignature)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, signature);
          if (!hasDetail) {
            break label264;
          }
          localByteBuffer.put((byte)1);
          if (detail._cachedId == null) {
            break label239;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, detail._cachedId);
          detail.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label272;
          }
          if (str != null) {
            break label274;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          detail.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Detail
    implements FissileDataModel<Detail>, UnionTemplate<Detail>
  {
    public static final EndorsedSkillHighlightBuilder.DetailBuilder BUILDER = EndorsedSkillHighlightBuilder.DetailBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final ElitesInfo elitesInfoValue;
    public final boolean hasElitesInfoValue;
    public final boolean hasInfluencersInfoValue;
    public final boolean hasRecentlyEndorsedInfoValue;
    public final boolean hasSameSkillInfoValue;
    public final boolean hasSameTitleInfoValue;
    public final boolean hasSeniorLeadersInfoValue;
    public final boolean hasSharedConnectionsInfoValue;
    public final boolean hasSharedEntityInfoValue;
    public final boolean hasViewerSharedEntityInfoValue;
    public final InfluencersInfo influencersInfoValue;
    public final RecentlyEndorsedInfo recentlyEndorsedInfoValue;
    public final SameSkillInfo sameSkillInfoValue;
    public final SameTitleInfo sameTitleInfoValue;
    public final SeniorLeadersInfo seniorLeadersInfoValue;
    public final SharedConnectionsInfo sharedConnectionsInfoValue;
    public final SharedEntityInfo sharedEntityInfoValue;
    public final ViewerSharedEntityInfo viewerSharedEntityInfoValue;
    
    Detail(SharedConnectionsInfo paramSharedConnectionsInfo, ElitesInfo paramElitesInfo, InfluencersInfo paramInfluencersInfo, RecentlyEndorsedInfo paramRecentlyEndorsedInfo, SameSkillInfo paramSameSkillInfo, SameTitleInfo paramSameTitleInfo, SeniorLeadersInfo paramSeniorLeadersInfo, SharedEntityInfo paramSharedEntityInfo, ViewerSharedEntityInfo paramViewerSharedEntityInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
    {
      sharedConnectionsInfoValue = paramSharedConnectionsInfo;
      elitesInfoValue = paramElitesInfo;
      influencersInfoValue = paramInfluencersInfo;
      recentlyEndorsedInfoValue = paramRecentlyEndorsedInfo;
      sameSkillInfoValue = paramSameSkillInfo;
      sameTitleInfoValue = paramSameTitleInfo;
      seniorLeadersInfoValue = paramSeniorLeadersInfo;
      sharedEntityInfoValue = paramSharedEntityInfo;
      viewerSharedEntityInfoValue = paramViewerSharedEntityInfo;
      hasSharedConnectionsInfoValue = paramBoolean1;
      hasElitesInfoValue = paramBoolean2;
      hasInfluencersInfoValue = paramBoolean3;
      hasRecentlyEndorsedInfoValue = paramBoolean4;
      hasSameSkillInfoValue = paramBoolean5;
      hasSameTitleInfoValue = paramBoolean6;
      hasSeniorLeadersInfoValue = paramBoolean7;
      hasSharedEntityInfoValue = paramBoolean8;
      hasViewerSharedEntityInfoValue = paramBoolean9;
      _cachedId = null;
    }
    
    public final Detail accept(DataProcessor paramDataProcessor)
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
      label146:
      label158:
      Object localObject5;
      boolean bool4;
      label198:
      label210:
      Object localObject6;
      boolean bool5;
      label250:
      label262:
      Object localObject7;
      boolean bool6;
      label302:
      label314:
      Object localObject8;
      boolean bool7;
      label354:
      label366:
      Object localObject9;
      boolean bool8;
      if (hasSharedConnectionsInfoValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.endorsedSkill.SharedConnectionsInfo");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = sharedConnectionsInfoValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label541;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasElitesInfoValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.endorsedSkill.ElitesInfo");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label550;
          }
          localObject1 = elitesInfoValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label568;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        localObject4 = null;
        bool3 = false;
        if (hasInfluencersInfoValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.endorsedSkill.InfluencersInfo");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label577;
          }
          localObject1 = influencersInfoValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label595;
          }
          bool3 = true;
          localObject4 = localObject1;
        }
        localObject5 = null;
        bool4 = false;
        if (hasRecentlyEndorsedInfoValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.endorsedSkill.RecentlyEndorsedInfo");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label605;
          }
          localObject1 = recentlyEndorsedInfoValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label623;
          }
          bool4 = true;
          localObject5 = localObject1;
        }
        localObject6 = null;
        bool5 = false;
        if (hasSameSkillInfoValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.endorsedSkill.SameSkillInfo");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label633;
          }
          localObject1 = sameSkillInfoValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label651;
          }
          bool5 = true;
          localObject6 = localObject1;
        }
        localObject7 = null;
        bool6 = false;
        if (hasSameTitleInfoValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.endorsedSkill.SameTitleInfo");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label661;
          }
          localObject1 = sameTitleInfoValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label679;
          }
          bool6 = true;
          localObject7 = localObject1;
        }
        localObject8 = null;
        bool7 = false;
        if (hasSeniorLeadersInfoValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.endorsedSkill.SeniorLeadersInfo");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label689;
          }
          localObject1 = seniorLeadersInfoValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label707;
          }
          bool7 = true;
          localObject8 = localObject1;
        }
        localObject9 = null;
        bool8 = false;
        if (hasSharedEntityInfoValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.endorsedSkill.SharedEntityInfo");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label717;
          }
          localObject1 = sharedEntityInfoValue.accept(paramDataProcessor);
          label406:
          if (localObject1 == null) {
            break label735;
          }
          bool8 = true;
          localObject9 = localObject1;
        }
        label418:
        localObject1 = null;
        bool9 = false;
        if (hasViewerSharedEntityInfoValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.endorsedSkill.ViewerSharedEntityInfo");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label745;
          }
          localObject1 = viewerSharedEntityInfoValue.accept(paramDataProcessor);
          label458:
          if (localObject1 == null) {
            break label763;
          }
        }
      }
      label541:
      label550:
      label568:
      label577:
      label595:
      label605:
      label623:
      label633:
      label651:
      label661:
      label679:
      label689:
      label707:
      label717:
      label735:
      label745:
      label763:
      for (boolean bool9 = true;; bool9 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label769;
        }
        return new Detail((SharedConnectionsInfo)localObject2, (ElitesInfo)localObject3, (InfluencersInfo)localObject4, (RecentlyEndorsedInfo)localObject5, (SameSkillInfo)localObject6, (SameTitleInfo)localObject7, (SeniorLeadersInfo)localObject8, (SharedEntityInfo)localObject9, (ViewerSharedEntityInfo)localObject1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9);
        localObject1 = (SharedConnectionsInfo)paramDataProcessor.processDataTemplate(sharedConnectionsInfoValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (ElitesInfo)paramDataProcessor.processDataTemplate(elitesInfoValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (InfluencersInfo)paramDataProcessor.processDataTemplate(influencersInfoValue);
        break label146;
        bool3 = false;
        localObject4 = localObject1;
        break label158;
        localObject1 = (RecentlyEndorsedInfo)paramDataProcessor.processDataTemplate(recentlyEndorsedInfoValue);
        break label198;
        bool4 = false;
        localObject5 = localObject1;
        break label210;
        localObject1 = (SameSkillInfo)paramDataProcessor.processDataTemplate(sameSkillInfoValue);
        break label250;
        bool5 = false;
        localObject6 = localObject1;
        break label262;
        localObject1 = (SameTitleInfo)paramDataProcessor.processDataTemplate(sameTitleInfoValue);
        break label302;
        bool6 = false;
        localObject7 = localObject1;
        break label314;
        localObject1 = (SeniorLeadersInfo)paramDataProcessor.processDataTemplate(seniorLeadersInfoValue);
        break label354;
        bool7 = false;
        localObject8 = localObject1;
        break label366;
        localObject1 = (SharedEntityInfo)paramDataProcessor.processDataTemplate(sharedEntityInfoValue);
        break label406;
        bool8 = false;
        localObject9 = localObject1;
        break label418;
        localObject1 = (ViewerSharedEntityInfo)paramDataProcessor.processDataTemplate(viewerSharedEntityInfoValue);
        break label458;
      }
      label769:
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
        paramObject = (Detail)paramObject;
        if (sharedConnectionsInfoValue != null)
        {
          if (sharedConnectionsInfoValue.equals(sharedConnectionsInfoValue)) {}
        }
        else {
          while (sharedConnectionsInfoValue != null) {
            return false;
          }
        }
        if (elitesInfoValue != null)
        {
          if (elitesInfoValue.equals(elitesInfoValue)) {}
        }
        else {
          while (elitesInfoValue != null) {
            return false;
          }
        }
        if (influencersInfoValue != null)
        {
          if (influencersInfoValue.equals(influencersInfoValue)) {}
        }
        else {
          while (influencersInfoValue != null) {
            return false;
          }
        }
        if (recentlyEndorsedInfoValue != null)
        {
          if (recentlyEndorsedInfoValue.equals(recentlyEndorsedInfoValue)) {}
        }
        else {
          while (recentlyEndorsedInfoValue != null) {
            return false;
          }
        }
        if (sameSkillInfoValue != null)
        {
          if (sameSkillInfoValue.equals(sameSkillInfoValue)) {}
        }
        else {
          while (sameSkillInfoValue != null) {
            return false;
          }
        }
        if (sameTitleInfoValue != null)
        {
          if (sameTitleInfoValue.equals(sameTitleInfoValue)) {}
        }
        else {
          while (sameTitleInfoValue != null) {
            return false;
          }
        }
        if (seniorLeadersInfoValue != null)
        {
          if (seniorLeadersInfoValue.equals(seniorLeadersInfoValue)) {}
        }
        else {
          while (seniorLeadersInfoValue != null) {
            return false;
          }
        }
        if (sharedEntityInfoValue != null)
        {
          if (sharedEntityInfoValue.equals(sharedEntityInfoValue)) {}
        }
        else {
          while (sharedEntityInfoValue != null) {
            return false;
          }
        }
        if (viewerSharedEntityInfoValue == null) {
          break;
        }
      } while (viewerSharedEntityInfoValue.equals(viewerSharedEntityInfoValue));
      for (;;)
      {
        return false;
        if (viewerSharedEntityInfoValue == null) {
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
      if (hasSharedConnectionsInfoValue)
      {
        if (sharedConnectionsInfoValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(sharedConnectionsInfoValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasElitesInfoValue)
        {
          i = j + 1;
          if (elitesInfoValue._cachedId == null) {
            break label408;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(elitesInfoValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasInfluencersInfoValue)
        {
          i = j + 1;
          if (influencersInfoValue._cachedId == null) {
            break label421;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(influencersInfoValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasRecentlyEndorsedInfoValue)
        {
          i = j + 1;
          if (recentlyEndorsedInfoValue._cachedId == null) {
            break label434;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(recentlyEndorsedInfoValue._cachedId);
        }
        label177:
        j = i + 1;
        i = j;
        if (hasSameSkillInfoValue)
        {
          i = j + 1;
          if (sameSkillInfoValue._cachedId == null) {
            break label447;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(sameSkillInfoValue._cachedId);
        }
        label219:
        j = i + 1;
        i = j;
        if (hasSameTitleInfoValue)
        {
          i = j + 1;
          if (sameTitleInfoValue._cachedId == null) {
            break label460;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(sameTitleInfoValue._cachedId);
        }
        label261:
        j = i + 1;
        i = j;
        if (hasSeniorLeadersInfoValue)
        {
          i = j + 1;
          if (seniorLeadersInfoValue._cachedId == null) {
            break label473;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(seniorLeadersInfoValue._cachedId);
        }
        label303:
        j = i + 1;
        i = j;
        if (hasSharedEntityInfoValue)
        {
          i = j + 1;
          if (sharedEntityInfoValue._cachedId == null) {
            break label486;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(sharedEntityInfoValue._cachedId);
        }
        label345:
        j = i + 1;
        i = j;
        if (hasViewerSharedEntityInfoValue)
        {
          i = j + 1;
          if (viewerSharedEntityInfoValue._cachedId == null) {
            break label499;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(viewerSharedEntityInfoValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = sharedConnectionsInfoValue.getSerializedSize() + 7;
        break;
        label408:
        i += elitesInfoValue.getSerializedSize();
        break label93;
        label421:
        i += influencersInfoValue.getSerializedSize();
        break label135;
        label434:
        i += recentlyEndorsedInfoValue.getSerializedSize();
        break label177;
        label447:
        i += sameSkillInfoValue.getSerializedSize();
        break label219;
        label460:
        i += sameTitleInfoValue.getSerializedSize();
        break label261;
        label473:
        i += seniorLeadersInfoValue.getSerializedSize();
        break label303;
        label486:
        i += sharedEntityInfoValue.getSerializedSize();
        break label345;
        label499:
        i += viewerSharedEntityInfoValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int i4 = 0;
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
      int i1;
      label108:
      int i2;
      if (sharedConnectionsInfoValue != null)
      {
        i = sharedConnectionsInfoValue.hashCode();
        if (elitesInfoValue == null) {
          break label220;
        }
        j = elitesInfoValue.hashCode();
        if (influencersInfoValue == null) {
          break label225;
        }
        k = influencersInfoValue.hashCode();
        if (recentlyEndorsedInfoValue == null) {
          break label230;
        }
        m = recentlyEndorsedInfoValue.hashCode();
        if (sameSkillInfoValue == null) {
          break label236;
        }
        n = sameSkillInfoValue.hashCode();
        if (sameTitleInfoValue == null) {
          break label242;
        }
        i1 = sameTitleInfoValue.hashCode();
        if (seniorLeadersInfoValue == null) {
          break label248;
        }
        i2 = seniorLeadersInfoValue.hashCode();
        label124:
        if (sharedEntityInfoValue == null) {
          break label254;
        }
      }
      label220:
      label225:
      label230:
      label236:
      label242:
      label248:
      label254:
      for (int i3 = sharedEntityInfoValue.hashCode();; i3 = 0)
      {
        if (viewerSharedEntityInfoValue != null) {
          i4 = viewerSharedEntityInfoValue.hashCode();
        }
        i = (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
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
        break label108;
        i2 = 0;
        break label124;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Detail");
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
      label232:
      label292:
      label352:
      label412:
      label472:
      label532:
      label592:
      label720:
      label745:
      label755:
      label780:
      label790:
      label815:
      label825:
      label850:
      label860:
      label885:
      label895:
      label920:
      label930:
      label955:
      label965:
      label990:
      label998:
      label1000:
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
          localByteBuffer.putInt(2095983786);
          if (hasSharedConnectionsInfoValue)
          {
            localByteBuffer.put((byte)1);
            if (sharedConnectionsInfoValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, sharedConnectionsInfoValue._cachedId);
              sharedConnectionsInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasElitesInfoValue) {
                break label745;
              }
              localByteBuffer.put((byte)1);
              if (elitesInfoValue._cachedId == null) {
                break label720;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, elitesInfoValue._cachedId);
              elitesInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasInfluencersInfoValue) {
                break label780;
              }
              localByteBuffer.put((byte)1);
              if (influencersInfoValue._cachedId == null) {
                break label755;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, influencersInfoValue._cachedId);
              influencersInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasRecentlyEndorsedInfoValue) {
                break label815;
              }
              localByteBuffer.put((byte)1);
              if (recentlyEndorsedInfoValue._cachedId == null) {
                break label790;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, recentlyEndorsedInfoValue._cachedId);
              recentlyEndorsedInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSameSkillInfoValue) {
                break label850;
              }
              localByteBuffer.put((byte)1);
              if (sameSkillInfoValue._cachedId == null) {
                break label825;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, sameSkillInfoValue._cachedId);
              sameSkillInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSameTitleInfoValue) {
                break label885;
              }
              localByteBuffer.put((byte)1);
              if (sameTitleInfoValue._cachedId == null) {
                break label860;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, sameTitleInfoValue._cachedId);
              sameTitleInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSeniorLeadersInfoValue) {
                break label920;
              }
              localByteBuffer.put((byte)1);
              if (seniorLeadersInfoValue._cachedId == null) {
                break label895;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, seniorLeadersInfoValue._cachedId);
              seniorLeadersInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSharedEntityInfoValue) {
                break label955;
              }
              localByteBuffer.put((byte)1);
              if (sharedEntityInfoValue._cachedId == null) {
                break label930;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, sharedEntityInfoValue._cachedId);
              sharedEntityInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasViewerSharedEntityInfoValue) {
                break label990;
              }
              localByteBuffer.put((byte)1);
              if (viewerSharedEntityInfoValue._cachedId == null) {
                break label965;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, viewerSharedEntityInfoValue._cachedId);
              viewerSharedEntityInfoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label998;
            }
            if (str != null) {
              break label1000;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            sharedConnectionsInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            elitesInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label232;
            localByteBuffer.put((byte)0);
            break label232;
            localByteBuffer.put((byte)1);
            influencersInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label292;
            localByteBuffer.put((byte)0);
            break label292;
            localByteBuffer.put((byte)1);
            recentlyEndorsedInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label352;
            localByteBuffer.put((byte)0);
            break label352;
            localByteBuffer.put((byte)1);
            sameSkillInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label412;
            localByteBuffer.put((byte)0);
            break label412;
            localByteBuffer.put((byte)1);
            sameTitleInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label472;
            localByteBuffer.put((byte)0);
            break label472;
            localByteBuffer.put((byte)1);
            seniorLeadersInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label532;
            localByteBuffer.put((byte)0);
            break label532;
            localByteBuffer.put((byte)1);
            sharedEntityInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label592;
            localByteBuffer.put((byte)0);
            break label592;
            localByteBuffer.put((byte)1);
            viewerSharedEntityInfoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.EndorsedSkillHighlight
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */