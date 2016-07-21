package com.linkedin.android.pegasus.gen.voyager.entities.group;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Color;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.entities.common.EntityInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Group
  implements FissileDataModel<Group>, RecordTemplate<Group>
{
  public static final GroupBuilder BUILDER = GroupBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Color backgroundColor;
  public final BasicGroupInfo basicGroupInfo;
  public final String description;
  public final EntityInfo entityInfo;
  public final Urn entityUrn;
  public final GroupType groupType;
  public final boolean hasBackgroundColor;
  public final boolean hasBasicGroupInfo;
  public final boolean hasDescription;
  public final boolean hasEntityInfo;
  public final boolean hasEntityUrn;
  public final boolean hasGroupType;
  public final boolean hasHeroImage;
  public final boolean hasMembershipInfo;
  public final boolean hasOwner;
  public final boolean hasRules;
  public final boolean hasSections;
  public final Image heroImage;
  public final GroupMembershipInfo membershipInfo;
  public final MiniProfileWithDistance owner;
  public final String rules;
  public final GroupSections sections;
  
  Group(Urn paramUrn, BasicGroupInfo paramBasicGroupInfo, GroupType paramGroupType, GroupMembershipInfo paramGroupMembershipInfo, String paramString1, Image paramImage, Color paramColor, String paramString2, MiniProfileWithDistance paramMiniProfileWithDistance, GroupSections paramGroupSections, EntityInfo paramEntityInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11)
  {
    entityUrn = paramUrn;
    basicGroupInfo = paramBasicGroupInfo;
    groupType = paramGroupType;
    membershipInfo = paramGroupMembershipInfo;
    description = paramString1;
    heroImage = paramImage;
    backgroundColor = paramColor;
    rules = paramString2;
    owner = paramMiniProfileWithDistance;
    sections = paramGroupSections;
    entityInfo = paramEntityInfo;
    hasEntityUrn = paramBoolean1;
    hasBasicGroupInfo = paramBoolean2;
    hasGroupType = paramBoolean3;
    hasMembershipInfo = paramBoolean4;
    hasDescription = paramBoolean5;
    hasHeroImage = paramBoolean6;
    hasBackgroundColor = paramBoolean7;
    hasRules = paramBoolean8;
    hasOwner = paramBoolean9;
    hasSections = paramBoolean10;
    hasEntityInfo = paramBoolean11;
    paramBasicGroupInfo = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private Group accept(DataProcessor paramDataProcessor)
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
    Object localObject2 = null;
    boolean bool1 = false;
    label89:
    Object localObject3;
    boolean bool2;
    label153:
    label164:
    Object localObject4;
    boolean bool3;
    label229:
    label241:
    Object localObject5;
    boolean bool4;
    label281:
    label293:
    Object localObject6;
    boolean bool5;
    label358:
    label370:
    Object localObject7;
    boolean bool6;
    if (hasBasicGroupInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("basicGroupInfo");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = basicGroupInfo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label532;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasGroupType)
      {
        paramDataProcessor.startRecordField$505cff1c("groupType");
        paramDataProcessor.processEnum(groupType);
      }
      localObject3 = null;
      bool2 = false;
      if (hasMembershipInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("membershipInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label541;
        }
        localObject1 = membershipInfo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label559;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      if (hasDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("description");
        paramDataProcessor.processString(description);
      }
      localObject4 = null;
      bool3 = false;
      if (hasHeroImage)
      {
        paramDataProcessor.startRecordField$505cff1c("heroImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label568;
        }
        localObject1 = heroImage.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label586;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasBackgroundColor)
      {
        paramDataProcessor.startRecordField$505cff1c("backgroundColor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label596;
        }
        localObject1 = backgroundColor.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label614;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      if (hasRules)
      {
        paramDataProcessor.startRecordField$505cff1c("rules");
        paramDataProcessor.processString(rules);
      }
      localObject6 = null;
      bool5 = false;
      if (hasOwner)
      {
        paramDataProcessor.startRecordField$505cff1c("owner");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label624;
        }
        localObject1 = owner.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label642;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      localObject7 = null;
      bool6 = false;
      if (hasSections)
      {
        paramDataProcessor.startRecordField$505cff1c("sections");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label652;
        }
        localObject1 = sections.accept(paramDataProcessor);
        label410:
        if (localObject1 == null) {
          break label670;
        }
        bool6 = true;
        localObject7 = localObject1;
      }
      label422:
      localObject1 = null;
      bool7 = false;
      if (hasEntityInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("entityInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label680;
        }
        localObject1 = entityInfo.accept(paramDataProcessor);
        label462:
        if (localObject1 == null) {
          break label698;
        }
      }
    }
    label532:
    label541:
    label559:
    label568:
    label586:
    label596:
    label614:
    label624:
    label642:
    label652:
    label670:
    label680:
    label698:
    for (boolean bool7 = true;; bool7 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label827;
      }
      try
      {
        if (hasBasicGroupInfo) {
          break label704;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.group.Group", "basicGroupInfo");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (BasicGroupInfo)paramDataProcessor.processDataTemplate(basicGroupInfo);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label89;
      localObject1 = (GroupMembershipInfo)paramDataProcessor.processDataTemplate(membershipInfo);
      break label153;
      bool2 = false;
      localObject3 = localObject1;
      break label164;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(heroImage);
      break label229;
      bool3 = false;
      localObject4 = localObject1;
      break label241;
      localObject1 = (Color)paramDataProcessor.processDataTemplate(backgroundColor);
      break label281;
      bool4 = false;
      localObject5 = localObject1;
      break label293;
      localObject1 = (MiniProfileWithDistance)paramDataProcessor.processDataTemplate(owner);
      break label358;
      bool5 = false;
      localObject6 = localObject1;
      break label370;
      localObject1 = (GroupSections)paramDataProcessor.processDataTemplate(sections);
      break label410;
      bool6 = false;
      localObject7 = localObject1;
      break label422;
      localObject1 = (EntityInfo)paramDataProcessor.processDataTemplate(entityInfo);
      break label462;
    }
    label704:
    if (!hasGroupType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.group.Group", "groupType");
    }
    if (!hasMembershipInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.group.Group", "membershipInfo");
    }
    if (!hasEntityInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.group.Group", "entityInfo");
    }
    return new Group(entityUrn, (BasicGroupInfo)localObject2, groupType, (GroupMembershipInfo)localObject3, description, (Image)localObject4, (Color)localObject5, rules, (MiniProfileWithDistance)localObject6, (GroupSections)localObject7, (EntityInfo)localObject1, hasEntityUrn, bool1, hasGroupType, bool2, hasDescription, bool3, bool4, hasRules, bool5, bool6, bool7);
    label827:
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
      paramObject = (Group)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (basicGroupInfo != null)
      {
        if (basicGroupInfo.equals(basicGroupInfo)) {}
      }
      else {
        while (basicGroupInfo != null) {
          return false;
        }
      }
      if (groupType != null)
      {
        if (groupType.equals(groupType)) {}
      }
      else {
        while (groupType != null) {
          return false;
        }
      }
      if (membershipInfo != null)
      {
        if (membershipInfo.equals(membershipInfo)) {}
      }
      else {
        while (membershipInfo != null) {
          return false;
        }
      }
      if (description != null)
      {
        if (description.equals(description)) {}
      }
      else {
        while (description != null) {
          return false;
        }
      }
      if (heroImage != null)
      {
        if (heroImage.equals(heroImage)) {}
      }
      else {
        while (heroImage != null) {
          return false;
        }
      }
      if (backgroundColor != null)
      {
        if (backgroundColor.equals(backgroundColor)) {}
      }
      else {
        while (backgroundColor != null) {
          return false;
        }
      }
      if (rules != null)
      {
        if (rules.equals(rules)) {}
      }
      else {
        while (rules != null) {
          return false;
        }
      }
      if (owner != null)
      {
        if (owner.equals(owner)) {}
      }
      else {
        while (owner != null) {
          return false;
        }
      }
      if (sections != null)
      {
        if (sections.equals(sections)) {}
      }
      else {
        while (sections != null) {
          return false;
        }
      }
      if (entityInfo == null) {
        break;
      }
    } while (entityInfo.equals(entityInfo));
    for (;;)
    {
      return false;
      if (entityInfo == null) {
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
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasBasicGroupInfo)
    {
      i = j + 1;
      if (basicGroupInfo._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(basicGroupInfo._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasGroupType) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasMembershipInfo)
      {
        i = j + 1;
        if (membershipInfo._cachedId == null) {
          break label426;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(membershipInfo._cachedId);
      }
      label146:
      j = i + 1;
      i = j;
      if (hasDescription) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
      }
      j = i + 1;
      i = j;
      if (hasHeroImage)
      {
        i = j + 1;
        if (heroImage._cachedId == null) {
          break label439;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(heroImage._cachedId);
      }
      label213:
      j = i + 1;
      i = j;
      if (hasBackgroundColor)
      {
        i = j + 1;
        if (backgroundColor._cachedId == null) {
          break label452;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(backgroundColor._cachedId);
      }
      label255:
      j = i + 1;
      i = j;
      if (hasRules) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(rules);
      }
      j = i + 1;
      i = j;
      if (hasOwner)
      {
        i = j + 1;
        if (owner._cachedId == null) {
          break label465;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(owner._cachedId);
      }
      label322:
      j = i + 1;
      i = j;
      if (hasSections)
      {
        i = j + 1;
        if (sections._cachedId == null) {
          break label478;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(sections._cachedId);
      }
      label364:
      j = i + 1;
      i = j;
      if (hasEntityInfo)
      {
        i = j + 1;
        if (entityInfo._cachedId == null) {
          break label491;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(entityInfo._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += basicGroupInfo.getSerializedSize();
      break;
      label426:
      i += membershipInfo.getSerializedSize();
      break label146;
      label439:
      i += heroImage.getSerializedSize();
      break label213;
      label452:
      i += backgroundColor.getSerializedSize();
      break label255;
      label465:
      i += owner.getSerializedSize();
      break label322;
      label478:
      i += sections.getSerializedSize();
      break label364;
      label491:
      i += entityInfo.getSerializedSize();
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
    label76:
    int n;
    label92:
    int i1;
    label108:
    int i2;
    label124:
    int i3;
    label140:
    int i4;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (basicGroupInfo == null) {
        break label264;
      }
      j = basicGroupInfo.hashCode();
      if (groupType == null) {
        break label269;
      }
      k = groupType.hashCode();
      if (membershipInfo == null) {
        break label274;
      }
      m = membershipInfo.hashCode();
      if (description == null) {
        break label280;
      }
      n = description.hashCode();
      if (heroImage == null) {
        break label286;
      }
      i1 = heroImage.hashCode();
      if (backgroundColor == null) {
        break label292;
      }
      i2 = backgroundColor.hashCode();
      if (rules == null) {
        break label298;
      }
      i3 = rules.hashCode();
      if (owner == null) {
        break label304;
      }
      i4 = owner.hashCode();
      label156:
      if (sections == null) {
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
    for (int i5 = sections.hashCode();; i5 = 0)
    {
      if (entityInfo != null) {
        i6 = entityInfo.hashCode();
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
      break label76;
      n = 0;
      break label92;
      i1 = 0;
      break label108;
      i2 = 0;
      break label124;
      i3 = 0;
      break label140;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Group");
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
    label235:
    label295:
    label321:
    label381:
    label441:
    label467:
    label527:
    label587:
    label690:
    label715:
    label725:
    label735:
    label760:
    label770:
    label780:
    label805:
    label815:
    label840:
    label850:
    label860:
    label885:
    label895:
    label920:
    label930:
    label955:
    label963:
    label965:
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
        localByteBuffer.putInt(-1414998737);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasBasicGroupInfo) {
            break label715;
          }
          localByteBuffer.put((byte)1);
          if (basicGroupInfo._cachedId == null) {
            break label690;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, basicGroupInfo._cachedId);
          basicGroupInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasGroupType) {
            break label725;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, groupType.ordinal());
          if (!hasMembershipInfo) {
            break label760;
          }
          localByteBuffer.put((byte)1);
          if (membershipInfo._cachedId == null) {
            break label735;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, membershipInfo._cachedId);
          membershipInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasDescription) {
            break label770;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasHeroImage) {
            break label805;
          }
          localByteBuffer.put((byte)1);
          if (heroImage._cachedId == null) {
            break label780;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, heroImage._cachedId);
          heroImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasBackgroundColor) {
            break label840;
          }
          localByteBuffer.put((byte)1);
          if (backgroundColor._cachedId == null) {
            break label815;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, backgroundColor._cachedId);
          backgroundColor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasRules) {
            break label850;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, rules);
          if (!hasOwner) {
            break label885;
          }
          localByteBuffer.put((byte)1);
          if (owner._cachedId == null) {
            break label860;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, owner._cachedId);
          owner.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSections) {
            break label920;
          }
          localByteBuffer.put((byte)1);
          if (sections._cachedId == null) {
            break label895;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, sections._cachedId);
          sections.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasEntityInfo) {
            break label955;
          }
          localByteBuffer.put((byte)1);
          if (entityInfo._cachedId == null) {
            break label930;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, entityInfo._cachedId);
          entityInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label963;
          }
          if (str != null) {
            break label965;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          basicGroupInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label206;
          localByteBuffer.put((byte)0);
          break label206;
          localByteBuffer.put((byte)0);
          break label235;
          localByteBuffer.put((byte)1);
          membershipInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label295;
          localByteBuffer.put((byte)0);
          break label295;
          localByteBuffer.put((byte)0);
          break label321;
          localByteBuffer.put((byte)1);
          heroImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label381;
          localByteBuffer.put((byte)0);
          break label381;
          localByteBuffer.put((byte)1);
          backgroundColor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label441;
          localByteBuffer.put((byte)0);
          break label441;
          localByteBuffer.put((byte)0);
          break label467;
          localByteBuffer.put((byte)1);
          owner.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label527;
          localByteBuffer.put((byte)0);
          break label527;
          localByteBuffer.put((byte)1);
          sections.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label587;
          localByteBuffer.put((byte)0);
          break label587;
          localByteBuffer.put((byte)1);
          entityInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.group.Group
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */