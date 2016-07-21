package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionMemberCountException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SocialActor
  implements FissileDataModel<SocialActor>, UnionTemplate<SocialActor>
{
  public static final SocialActorBuilder BUILDER = SocialActorBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AppActor appActorValue;
  public final CompanyActor companyActorValue;
  public final boolean hasAppActorValue;
  public final boolean hasCompanyActorValue;
  public final boolean hasInfluencerActorValue;
  public final boolean hasMemberActorValue;
  public final boolean hasSchoolActorValue;
  public final InfluencerActor influencerActorValue;
  public final MemberActor memberActorValue;
  public final SchoolActor schoolActorValue;
  
  SocialActor(MemberActor paramMemberActor, CompanyActor paramCompanyActor, SchoolActor paramSchoolActor, InfluencerActor paramInfluencerActor, AppActor paramAppActor, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    memberActorValue = paramMemberActor;
    companyActorValue = paramCompanyActor;
    schoolActorValue = paramSchoolActor;
    influencerActorValue = paramInfluencerActor;
    appActorValue = paramAppActor;
    hasMemberActorValue = paramBoolean1;
    hasCompanyActorValue = paramBoolean2;
    hasSchoolActorValue = paramBoolean3;
    hasInfluencerActorValue = paramBoolean4;
    hasAppActorValue = paramBoolean5;
    _cachedId = null;
  }
  
  public final SocialActor accept(DataProcessor paramDataProcessor)
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
    if (hasMemberActorValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.MemberActor");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = memberActorValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label317;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasCompanyActorValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.CompanyActor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label326;
        }
        localObject1 = companyActorValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label344;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasSchoolActorValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.SchoolActor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label353;
        }
        localObject1 = schoolActorValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label371;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasInfluencerActorValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.InfluencerActor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label381;
        }
        localObject1 = influencerActorValue.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label399;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      label210:
      localObject1 = null;
      bool5 = false;
      if (hasAppActorValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.AppActor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label409;
        }
        localObject1 = appActorValue.accept(paramDataProcessor);
        label250:
        if (localObject1 == null) {
          break label427;
        }
      }
    }
    label317:
    label326:
    label344:
    label353:
    label371:
    label381:
    label399:
    label409:
    label427:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label433;
      }
      return new SocialActor((MemberActor)localObject2, (CompanyActor)localObject3, (SchoolActor)localObject4, (InfluencerActor)localObject5, (AppActor)localObject1, bool1, bool2, bool3, bool4, bool5);
      localObject1 = (MemberActor)paramDataProcessor.processDataTemplate(memberActorValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (CompanyActor)paramDataProcessor.processDataTemplate(companyActorValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (SchoolActor)paramDataProcessor.processDataTemplate(schoolActorValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (InfluencerActor)paramDataProcessor.processDataTemplate(influencerActorValue);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (AppActor)paramDataProcessor.processDataTemplate(appActorValue);
      break label250;
    }
    label433:
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
      paramObject = (SocialActor)paramObject;
      if (memberActorValue != null)
      {
        if (memberActorValue.equals(memberActorValue)) {}
      }
      else {
        while (memberActorValue != null) {
          return false;
        }
      }
      if (companyActorValue != null)
      {
        if (companyActorValue.equals(companyActorValue)) {}
      }
      else {
        while (companyActorValue != null) {
          return false;
        }
      }
      if (schoolActorValue != null)
      {
        if (schoolActorValue.equals(schoolActorValue)) {}
      }
      else {
        while (schoolActorValue != null) {
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
      if (appActorValue == null) {
        break;
      }
    } while (appActorValue.equals(appActorValue));
    for (;;)
    {
      return false;
      if (appActorValue == null) {
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
    if (hasMemberActorValue)
    {
      if (memberActorValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(memberActorValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasCompanyActorValue)
      {
        i = j + 1;
        if (companyActorValue._cachedId == null) {
          break label240;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(companyActorValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasSchoolActorValue)
      {
        i = j + 1;
        if (schoolActorValue._cachedId == null) {
          break label253;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(schoolActorValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasInfluencerActorValue)
      {
        i = j + 1;
        if (influencerActorValue._cachedId == null) {
          break label266;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(influencerActorValue._cachedId);
      }
      label177:
      j = i + 1;
      i = j;
      if (hasAppActorValue)
      {
        i = j + 1;
        if (appActorValue._cachedId == null) {
          break label279;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(appActorValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = memberActorValue.getSerializedSize() + 7;
      break;
      label240:
      i += companyActorValue.getSerializedSize();
      break label93;
      label253:
      i += schoolActorValue.getSerializedSize();
      break label135;
      label266:
      i += influencerActorValue.getSerializedSize();
      break label177;
      label279:
      i += appActorValue.getSerializedSize();
    }
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
    if (memberActorValue != null)
    {
      i = memberActorValue.hashCode();
      if (companyActorValue == null) {
        break label132;
      }
      j = companyActorValue.hashCode();
      if (schoolActorValue == null) {
        break label137;
      }
      k = schoolActorValue.hashCode();
      label60:
      if (influencerActorValue == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = influencerActorValue.hashCode();; m = 0)
    {
      if (appActorValue != null) {
        n = appActorValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SocialActor");
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
    label350:
    label478:
    label503:
    label513:
    label538:
    label548:
    label573:
    label583:
    label608:
    label616:
    label618:
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
        localByteBuffer.putInt(1116018062);
        if (hasMemberActorValue)
        {
          localByteBuffer.put((byte)1);
          if (memberActorValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, memberActorValue._cachedId);
            memberActorValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCompanyActorValue) {
              break label503;
            }
            localByteBuffer.put((byte)1);
            if (companyActorValue._cachedId == null) {
              break label478;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, companyActorValue._cachedId);
            companyActorValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSchoolActorValue) {
              break label538;
            }
            localByteBuffer.put((byte)1);
            if (schoolActorValue._cachedId == null) {
              break label513;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, schoolActorValue._cachedId);
            schoolActorValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasInfluencerActorValue) {
              break label573;
            }
            localByteBuffer.put((byte)1);
            if (influencerActorValue._cachedId == null) {
              break label548;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, influencerActorValue._cachedId);
            influencerActorValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAppActorValue) {
              break label608;
            }
            localByteBuffer.put((byte)1);
            if (appActorValue._cachedId == null) {
              break label583;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, appActorValue._cachedId);
            appActorValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label616;
          }
          if (str != null) {
            break label618;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          memberActorValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          companyActorValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          schoolActorValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          influencerActorValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label350;
          localByteBuffer.put((byte)0);
          break label350;
          localByteBuffer.put((byte)1);
          appActorValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  {
    private AppActor appActorValue = null;
    private CompanyActor companyActorValue = null;
    private boolean hasAppActorValue = false;
    private boolean hasCompanyActorValue = false;
    private boolean hasInfluencerActorValue = false;
    private boolean hasMemberActorValue = false;
    private boolean hasSchoolActorValue = false;
    private InfluencerActor influencerActorValue = null;
    private MemberActor memberActorValue = null;
    private SchoolActor schoolActorValue = null;
    
    public final SocialActor build()
      throws BuilderException
    {
      int j = 0;
      if (hasMemberActorValue) {
        j = 0 + 1;
      }
      int i = j;
      if (hasCompanyActorValue) {
        i = j + 1;
      }
      j = i;
      if (hasSchoolActorValue) {
        j = i + 1;
      }
      i = j;
      if (hasInfluencerActorValue) {
        i = j + 1;
      }
      j = i;
      if (hasAppActorValue) {
        j = i + 1;
      }
      if (j > 1) {
        throw new UnionMemberCountException("com.linkedin.android.pegasus.gen.voyager.feed.SocialActor", j);
      }
      return new SocialActor(memberActorValue, companyActorValue, schoolActorValue, influencerActorValue, appActorValue, hasMemberActorValue, hasCompanyActorValue, hasSchoolActorValue, hasInfluencerActorValue, hasAppActorValue);
    }
    
    public final Builder setMemberActorValue(MemberActor paramMemberActor)
    {
      if (paramMemberActor == null)
      {
        hasMemberActorValue = false;
        memberActorValue = null;
        return this;
      }
      hasMemberActorValue = true;
      memberActorValue = paramMemberActor;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.SocialActor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */