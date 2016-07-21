package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.TwitterHandle;
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

public final class ProfileContactInfo
  implements FissileDataModel<ProfileContactInfo>, RecordTemplate<ProfileContactInfo>
{
  public static final ProfileContactInfoBuilder BUILDER = ProfileContactInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String address;
  public final Date birthDateOn;
  public final NetworkVisibilitySetting birthdayVisibilitySetting;
  public final String emailAddress;
  public final Urn entityUrn;
  public final boolean hasAddress;
  public final boolean hasBirthDateOn;
  public final boolean hasBirthdayVisibilitySetting;
  public final boolean hasEmailAddress;
  public final boolean hasEntityUrn;
  public final boolean hasIms;
  public final boolean hasPhoneNumbers;
  public final boolean hasTwitterHandles;
  public final boolean hasWeChatContactInfo;
  public final boolean hasWebsites;
  public final List<IM> ims;
  public final List<PhoneNumber> phoneNumbers;
  public final List<TwitterHandle> twitterHandles;
  public final WeChatContactInfo weChatContactInfo;
  public final List<ProfileWebsite> websites;
  
  ProfileContactInfo(Urn paramUrn, WeChatContactInfo paramWeChatContactInfo, List<PhoneNumber> paramList, List<ProfileWebsite> paramList1, List<TwitterHandle> paramList2, List<IM> paramList3, String paramString1, String paramString2, Date paramDate, NetworkVisibilitySetting paramNetworkVisibilitySetting, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    entityUrn = paramUrn;
    weChatContactInfo = paramWeChatContactInfo;
    if (paramList == null)
    {
      paramWeChatContactInfo = null;
      phoneNumbers = paramWeChatContactInfo;
      if (paramList1 != null) {
        break label176;
      }
      paramWeChatContactInfo = null;
      label42:
      websites = paramWeChatContactInfo;
      if (paramList2 != null) {
        break label185;
      }
      paramWeChatContactInfo = null;
      label54:
      twitterHandles = paramWeChatContactInfo;
      if (paramList3 != null) {
        break label194;
      }
    }
    label176:
    label185:
    label194:
    for (paramWeChatContactInfo = null;; paramWeChatContactInfo = Collections.unmodifiableList(paramList3))
    {
      ims = paramWeChatContactInfo;
      emailAddress = paramString1;
      address = paramString2;
      birthDateOn = paramDate;
      birthdayVisibilitySetting = paramNetworkVisibilitySetting;
      hasEntityUrn = paramBoolean1;
      hasWeChatContactInfo = paramBoolean2;
      hasPhoneNumbers = paramBoolean3;
      hasWebsites = paramBoolean4;
      hasTwitterHandles = paramBoolean5;
      hasIms = paramBoolean6;
      hasEmailAddress = paramBoolean7;
      hasAddress = paramBoolean8;
      hasBirthDateOn = paramBoolean9;
      hasBirthdayVisibilitySetting = paramBoolean10;
      paramWeChatContactInfo = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
      paramWeChatContactInfo = Collections.unmodifiableList(paramList);
      break;
      paramWeChatContactInfo = Collections.unmodifiableList(paramList1);
      break label42;
      paramWeChatContactInfo = Collections.unmodifiableList(paramList2);
      break label54;
    }
  }
  
  private ProfileContactInfo accept(DataProcessor paramDataProcessor)
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
    Object localObject6 = null;
    boolean bool1 = false;
    label89:
    boolean bool2;
    int i;
    if (hasWeChatContactInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("weChatContactInfo");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = weChatContactInfo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label255;
        }
        bool1 = true;
        localObject6 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasPhoneNumbers) {
        break label294;
      }
      paramDataProcessor.startRecordField$505cff1c("phoneNumbers");
      phoneNumbers.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = phoneNumbers.iterator();
      label164:
      if (!((Iterator)localObject3).hasNext()) {
        break label280;
      }
      localObject2 = (PhoneNumber)((Iterator)localObject3).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label264;
      }
    }
    label255:
    label264:
    for (Object localObject2 = ((PhoneNumber)localObject2).accept(paramDataProcessor);; localObject2 = (PhoneNumber)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label164;
      localObject1 = (WeChatContactInfo)paramDataProcessor.processDataTemplate(weChatContactInfo);
      break;
      bool1 = false;
      localObject6 = localObject1;
      break label89;
    }
    label280:
    paramDataProcessor.endArray();
    label294:
    boolean bool3;
    if (localObject1 != null)
    {
      bool2 = true;
      localObject2 = null;
      localObject3 = null;
      bool3 = false;
      if (!hasWebsites) {
        break label478;
      }
      paramDataProcessor.startRecordField$505cff1c("websites");
      websites.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      localObject4 = websites.iterator();
      label369:
      if (!((Iterator)localObject4).hasNext()) {
        break label464;
      }
      localObject3 = (ProfileWebsite)((Iterator)localObject4).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label448;
      }
    }
    label448:
    for (Object localObject3 = ((ProfileWebsite)localObject3).accept(paramDataProcessor);; localObject3 = (ProfileWebsite)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject2 != null) && (localObject3 != null)) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
      break label369;
      bool2 = false;
      break;
    }
    label464:
    paramDataProcessor.endArray();
    label478:
    boolean bool4;
    if (localObject2 != null)
    {
      bool3 = true;
      localObject3 = null;
      localObject4 = null;
      bool4 = false;
      if (!hasTwitterHandles) {
        break label662;
      }
      paramDataProcessor.startRecordField$505cff1c("twitterHandles");
      twitterHandles.size();
      paramDataProcessor.startArray$13462e();
      localObject3 = localObject4;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject3 = new ArrayList();
      }
      i = 0;
      localObject5 = twitterHandles.iterator();
      label553:
      if (!((Iterator)localObject5).hasNext()) {
        break label648;
      }
      localObject4 = (TwitterHandle)((Iterator)localObject5).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label632;
      }
    }
    label632:
    for (Object localObject4 = ((TwitterHandle)localObject4).accept(paramDataProcessor);; localObject4 = (TwitterHandle)paramDataProcessor.processDataTemplate((DataTemplate)localObject4))
    {
      if ((localObject3 != null) && (localObject4 != null)) {
        ((List)localObject3).add(localObject4);
      }
      i += 1;
      break label553;
      bool3 = false;
      break;
    }
    label648:
    paramDataProcessor.endArray();
    label662:
    boolean bool5;
    if (localObject3 != null)
    {
      bool4 = true;
      localObject4 = null;
      localObject5 = null;
      bool5 = false;
      if (!hasIms) {
        break label846;
      }
      paramDataProcessor.startRecordField$505cff1c("ims");
      ims.size();
      paramDataProcessor.startArray$13462e();
      localObject4 = localObject5;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject4 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = ims.iterator();
      label737:
      if (!localIterator.hasNext()) {
        break label832;
      }
      localObject5 = (IM)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label816;
      }
    }
    label816:
    for (Object localObject5 = ((IM)localObject5).accept(paramDataProcessor);; localObject5 = (IM)paramDataProcessor.processDataTemplate((DataTemplate)localObject5))
    {
      if ((localObject4 != null) && (localObject5 != null)) {
        ((List)localObject4).add(localObject5);
      }
      i += 1;
      break label737;
      bool4 = false;
      break;
    }
    label832:
    paramDataProcessor.endArray();
    if (localObject4 != null)
    {
      bool5 = true;
      label846:
      if (hasEmailAddress)
      {
        paramDataProcessor.startRecordField$505cff1c("emailAddress");
        paramDataProcessor.processString(emailAddress);
      }
      if (hasAddress)
      {
        paramDataProcessor.startRecordField$505cff1c("address");
        paramDataProcessor.processString(address);
      }
      localObject5 = null;
      bool6 = false;
      if (hasBirthDateOn)
      {
        paramDataProcessor.startRecordField$505cff1c("birthDateOn");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1067;
        }
        localObject5 = birthDateOn.accept(paramDataProcessor);
        label936:
        if (localObject5 == null) {
          break label1085;
        }
      }
    }
    label1067:
    label1085:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (hasBirthdayVisibilitySetting)
      {
        paramDataProcessor.startRecordField$505cff1c("birthdayVisibilitySetting");
        paramDataProcessor.processEnum(birthdayVisibilitySetting);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1354;
      }
      if (!hasPhoneNumbers) {
        localObject1 = Collections.emptyList();
      }
      if (!hasWebsites) {
        localObject2 = Collections.emptyList();
      }
      if (!hasTwitterHandles) {
        localObject3 = Collections.emptyList();
      }
      if (!hasIms) {
        localObject4 = Collections.emptyList();
      }
      try
      {
        if (hasEntityUrn) {
          break label1091;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool5 = false;
      break;
      localObject5 = (Date)paramDataProcessor.processDataTemplate(birthDateOn);
      break label936;
    }
    label1091:
    if (phoneNumbers != null)
    {
      paramDataProcessor = phoneNumbers.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PhoneNumber)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "phoneNumbers");
        }
      }
    }
    if (websites != null)
    {
      paramDataProcessor = websites.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((ProfileWebsite)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "websites");
        }
      }
    }
    if (twitterHandles != null)
    {
      paramDataProcessor = twitterHandles.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((TwitterHandle)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "twitterHandles");
        }
      }
    }
    if (ims != null)
    {
      paramDataProcessor = ims.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((IM)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "ims");
        }
      }
    }
    return new ProfileContactInfo(entityUrn, (WeChatContactInfo)localObject6, (List)localObject1, (List)localObject2, (List)localObject3, (List)localObject4, emailAddress, address, (Date)localObject5, birthdayVisibilitySetting, hasEntityUrn, bool1, bool2, bool3, bool4, bool5, hasEmailAddress, hasAddress, bool6, hasBirthdayVisibilitySetting);
    label1354:
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
      paramObject = (ProfileContactInfo)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (weChatContactInfo != null)
      {
        if (weChatContactInfo.equals(weChatContactInfo)) {}
      }
      else {
        while (weChatContactInfo != null) {
          return false;
        }
      }
      if (phoneNumbers != null)
      {
        if (phoneNumbers.equals(phoneNumbers)) {}
      }
      else {
        while (phoneNumbers != null) {
          return false;
        }
      }
      if (websites != null)
      {
        if (websites.equals(websites)) {}
      }
      else {
        while (websites != null) {
          return false;
        }
      }
      if (twitterHandles != null)
      {
        if (twitterHandles.equals(twitterHandles)) {}
      }
      else {
        while (twitterHandles != null) {
          return false;
        }
      }
      if (ims != null)
      {
        if (ims.equals(ims)) {}
      }
      else {
        while (ims != null) {
          return false;
        }
      }
      if (emailAddress != null)
      {
        if (emailAddress.equals(emailAddress)) {}
      }
      else {
        while (emailAddress != null) {
          return false;
        }
      }
      if (address != null)
      {
        if (address.equals(address)) {}
      }
      else {
        while (address != null) {
          return false;
        }
      }
      if (birthDateOn != null)
      {
        if (birthDateOn.equals(birthDateOn)) {}
      }
      else {
        while (birthDateOn != null) {
          return false;
        }
      }
      if (birthdayVisibilitySetting == null) {
        break;
      }
    } while (birthdayVisibilitySetting.equals(birthdayVisibilitySetting));
    for (;;)
    {
      return false;
      if (birthdayVisibilitySetting == null) {
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
    if (hasWeChatContactInfo)
    {
      i = j + 1;
      if (weChatContactInfo._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(weChatContactInfo._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasPhoneNumbers) {
        break label188;
      }
      i += 2;
      localObject1 = phoneNumbers.iterator();
    }
    Object localObject2;
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label188;
      }
      localObject2 = (PhoneNumber)((Iterator)localObject1).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += weChatContactInfo.getSerializedSize();
        break;
      }
      i += ((PhoneNumber)localObject2).getSerializedSize();
    }
    label188:
    i = j + 1;
    j = i;
    if (hasWebsites)
    {
      i += 2;
      localObject1 = websites.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ProfileWebsite)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((ProfileWebsite)localObject2).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasTwitterHandles)
    {
      i += 2;
      localObject1 = twitterHandles.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (TwitterHandle)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((TwitterHandle)localObject2).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasIms)
    {
      i += 2;
      localObject1 = ims.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (IM)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((IM)localObject2).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasEmailAddress) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(emailAddress);
    }
    j = i + 1;
    i = j;
    if (hasAddress) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(address);
    }
    j = i + 1;
    i = j;
    if (hasBirthDateOn)
    {
      i = j + 1;
      if (birthDateOn._cachedId == null) {
        break label568;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(birthDateOn._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasBirthdayVisibilitySetting) {
        i = j + 2;
      }
      __sizeOfObject = i;
      return i;
      label568:
      i += birthDateOn.getSerializedSize();
    }
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
    label62:
    int m;
    label80:
    int n;
    label98:
    int i1;
    label116:
    int i2;
    label132:
    int i3;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (weChatContactInfo == null) {
        break label250;
      }
      j = weChatContactInfo.hashCode();
      if (phoneNumbers == null) {
        break label255;
      }
      k = phoneNumbers.hashCode();
      if (websites == null) {
        break label260;
      }
      m = websites.hashCode();
      if (twitterHandles == null) {
        break label266;
      }
      n = twitterHandles.hashCode();
      if (ims == null) {
        break label272;
      }
      i1 = ims.hashCode();
      if (emailAddress == null) {
        break label278;
      }
      i2 = emailAddress.hashCode();
      if (address == null) {
        break label284;
      }
      i3 = address.hashCode();
      label148:
      if (birthDateOn == null) {
        break label290;
      }
    }
    label250:
    label255:
    label260:
    label266:
    label272:
    label278:
    label284:
    label290:
    for (int i4 = birthDateOn.hashCode();; i4 = 0)
    {
      if (birthdayVisibilitySetting != null) {
        i5 = birthdayVisibilitySetting.hashCode();
      }
      i = (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i5;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label62;
      m = 0;
      break label80;
      n = 0;
      break label98;
      i1 = 0;
      break label116;
      i2 = 0;
      break label132;
      i3 = 0;
      break label148;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfileContactInfo");
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
    label323:
    label348:
    label381:
    label388:
    label851:
    label911:
    label983:
    label993:
    label1018:
    label1028:
    label1036:
    label1038:
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
        localByteBuffer.putInt(-863060636);
        Object localObject1;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject1 = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasWeChatContactInfo) {
            break label348;
          }
          localByteBuffer.put((byte)1);
          if (weChatContactInfo._cachedId == null) {
            break label323;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, weChatContactInfo._cachedId);
          weChatContactInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPhoneNumbers) {
            break label381;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, phoneNumbers.size());
          localObject1 = phoneNumbers.iterator();
        }
        Object localObject2;
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label388;
          }
          localObject2 = (PhoneNumber)((Iterator)localObject1).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((PhoneNumber)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            weChatContactInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label206;
            localByteBuffer.put((byte)0);
            break label206;
          }
          localByteBuffer.put((byte)1);
          ((PhoneNumber)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasWebsites)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, websites.size());
          localObject1 = websites.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ProfileWebsite)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((ProfileWebsite)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((ProfileWebsite)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasTwitterHandles)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, twitterHandles.size());
          localObject1 = twitterHandles.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (TwitterHandle)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((TwitterHandle)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((TwitterHandle)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasIms)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, ims.size());
          localObject1 = ims.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (IM)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((IM)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((IM)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasEmailAddress)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, emailAddress);
          if (!hasAddress) {
            break label983;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, address);
          if (!hasBirthDateOn) {
            break label1018;
          }
          localByteBuffer.put((byte)1);
          if (birthDateOn._cachedId == null) {
            break label993;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, birthDateOn._cachedId);
          birthDateOn.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasBirthdayVisibilitySetting) {
            break label1028;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, birthdayVisibilitySetting.ordinal());
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label1036;
          }
          if (str != null) {
            break label1038;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label851;
          localByteBuffer.put((byte)1);
          birthDateOn.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label911;
          localByteBuffer.put((byte)0);
          break label911;
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
    implements RecordTemplateBuilder<ProfileContactInfo>
  {
    private String address = null;
    public Date birthDateOn = null;
    public NetworkVisibilitySetting birthdayVisibilitySetting = null;
    private String emailAddress = null;
    private Urn entityUrn = null;
    private boolean hasAddress = false;
    public boolean hasBirthDateOn = false;
    public boolean hasBirthdayVisibilitySetting = false;
    private boolean hasEmailAddress = false;
    private boolean hasEntityUrn = false;
    private boolean hasIms = false;
    private boolean hasPhoneNumbers = false;
    public boolean hasTwitterHandles = false;
    public boolean hasWeChatContactInfo = false;
    private boolean hasWebsites = false;
    private List<IM> ims = null;
    private List<PhoneNumber> phoneNumbers = null;
    public List<TwitterHandle> twitterHandles = null;
    public WeChatContactInfo weChatContactInfo = null;
    private List<ProfileWebsite> websites = null;
    
    public final ProfileContactInfo build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ProfileContactInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (phoneNumbers != null)
      {
        paramFlavor = phoneNumbers.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((PhoneNumber)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "phoneNumbers");
              if (!hasPhoneNumbers) {
                phoneNumbers = Collections.emptyList();
              }
              if (!hasWebsites) {
                websites = Collections.emptyList();
              }
              if (!hasTwitterHandles) {
                twitterHandles = Collections.emptyList();
              }
              if (!hasIms) {
                ims = Collections.emptyList();
              }
              if (hasEntityUrn) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "entityUrn");
            }
          }
        }
      }
      if (websites != null)
      {
        paramFlavor = websites.iterator();
        while (paramFlavor.hasNext()) {
          if ((ProfileWebsite)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "websites");
          }
        }
      }
      if (twitterHandles != null)
      {
        paramFlavor = twitterHandles.iterator();
        while (paramFlavor.hasNext()) {
          if ((TwitterHandle)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "twitterHandles");
          }
        }
      }
      if (ims != null)
      {
        paramFlavor = ims.iterator();
        while (paramFlavor.hasNext()) {
          if ((IM)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo", "ims");
          }
        }
      }
      return new ProfileContactInfo(entityUrn, weChatContactInfo, phoneNumbers, websites, twitterHandles, ims, emailAddress, address, birthDateOn, birthdayVisibilitySetting, hasEntityUrn, hasWeChatContactInfo, hasPhoneNumbers, hasWebsites, hasTwitterHandles, hasIms, hasEmailAddress, hasAddress, hasBirthDateOn, hasBirthdayVisibilitySetting);
    }
    
    public final Builder setAddress(String paramString)
    {
      if (paramString == null)
      {
        hasAddress = false;
        address = null;
        return this;
      }
      hasAddress = true;
      address = paramString;
      return this;
    }
    
    public final Builder setEmailAddress(String paramString)
    {
      if (paramString == null)
      {
        hasEmailAddress = false;
        emailAddress = null;
        return this;
      }
      hasEmailAddress = true;
      emailAddress = paramString;
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
    
    public final Builder setIms(List<IM> paramList)
    {
      if ((paramList == null) || (paramList.equals(Collections.emptyList())))
      {
        hasIms = false;
        ims = Collections.emptyList();
        return this;
      }
      hasIms = true;
      ims = paramList;
      return this;
    }
    
    public final Builder setPhoneNumbers(List<PhoneNumber> paramList)
    {
      if ((paramList == null) || (paramList.equals(Collections.emptyList())))
      {
        hasPhoneNumbers = false;
        phoneNumbers = Collections.emptyList();
        return this;
      }
      hasPhoneNumbers = true;
      phoneNumbers = paramList;
      return this;
    }
    
    public final Builder setWebsites(List<ProfileWebsite> paramList)
    {
      if ((paramList == null) || (paramList.equals(Collections.emptyList())))
      {
        hasWebsites = false;
        websites = Collections.emptyList();
        return this;
      }
      hasWebsites = true;
      websites = paramList;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */