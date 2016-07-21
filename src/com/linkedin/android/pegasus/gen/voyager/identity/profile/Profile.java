package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.State;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Profile
  implements FissileDataModel<Profile>, RecordTemplate<Profile>
{
  public static final ProfileBuilder BUILDER = ProfileBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String address;
  public final BackgroundImage backgroundImage;
  public final Date birthDate;
  public final String contactInstructions;
  public final Urn entityUrn;
  public final String firstName;
  public final boolean hasAddress;
  public final boolean hasBackgroundImage;
  public final boolean hasBirthDate;
  public final boolean hasContactInstructions;
  public final boolean hasEntityUrn;
  public final boolean hasFirstName;
  public final boolean hasHeadline;
  public final boolean hasIndustryName;
  public final boolean hasIndustryUrn;
  public final boolean hasInterests;
  public final boolean hasLastName;
  public final boolean hasLocation;
  public final boolean hasLocationName;
  public final boolean hasMaidenName;
  public final boolean hasMiniProfile;
  public final boolean hasPhoneticFirstName;
  public final boolean hasPhoneticLastName;
  public final boolean hasPictureInfo;
  public final boolean hasState;
  public final boolean hasSummary;
  public final boolean hasVersionTag;
  public final String headline;
  public final String industryName;
  public final Urn industryUrn;
  public final String interests;
  public final String lastName;
  public final ProfileLocation location;
  public final String locationName;
  public final String maidenName;
  public final MiniProfile miniProfile;
  public final String phoneticFirstName;
  public final String phoneticLastName;
  public final Picture pictureInfo;
  public final State state;
  public final String summary;
  public final String versionTag;
  
  Profile(Urn paramUrn1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Urn paramUrn2, ProfileLocation paramProfileLocation, BackgroundImage paramBackgroundImage, Picture paramPicture, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, Date paramDate, String paramString11, String paramString12, State paramState, String paramString13, MiniProfile paramMiniProfile, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18, boolean paramBoolean19, boolean paramBoolean20, boolean paramBoolean21)
  {
    entityUrn = paramUrn1;
    firstName = paramString1;
    lastName = paramString2;
    maidenName = paramString3;
    headline = paramString4;
    industryName = paramString5;
    industryUrn = paramUrn2;
    location = paramProfileLocation;
    backgroundImage = paramBackgroundImage;
    pictureInfo = paramPicture;
    phoneticFirstName = paramString6;
    phoneticLastName = paramString7;
    contactInstructions = paramString8;
    interests = paramString9;
    address = paramString10;
    birthDate = paramDate;
    summary = paramString11;
    versionTag = paramString12;
    state = paramState;
    locationName = paramString13;
    miniProfile = paramMiniProfile;
    hasEntityUrn = paramBoolean1;
    hasFirstName = paramBoolean2;
    hasLastName = paramBoolean3;
    hasMaidenName = paramBoolean4;
    hasHeadline = paramBoolean5;
    hasIndustryName = paramBoolean6;
    hasIndustryUrn = paramBoolean7;
    hasLocation = paramBoolean8;
    hasBackgroundImage = paramBoolean9;
    hasPictureInfo = paramBoolean10;
    hasPhoneticFirstName = paramBoolean11;
    hasPhoneticLastName = paramBoolean12;
    hasContactInstructions = paramBoolean13;
    hasInterests = paramBoolean14;
    hasAddress = paramBoolean15;
    hasBirthDate = paramBoolean16;
    hasSummary = paramBoolean17;
    hasVersionTag = paramBoolean18;
    hasState = paramBoolean19;
    hasLocationName = paramBoolean20;
    hasMiniProfile = paramBoolean21;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  public final Profile accept(DataProcessor paramDataProcessor)
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
    if (hasFirstName)
    {
      paramDataProcessor.startRecordField$505cff1c("firstName");
      paramDataProcessor.processString(firstName);
    }
    if (hasLastName)
    {
      paramDataProcessor.startRecordField$505cff1c("lastName");
      paramDataProcessor.processString(lastName);
    }
    if (hasMaidenName)
    {
      paramDataProcessor.startRecordField$505cff1c("maidenName");
      paramDataProcessor.processString(maidenName);
    }
    if (hasHeadline)
    {
      paramDataProcessor.startRecordField$505cff1c("headline");
      paramDataProcessor.processString(headline);
    }
    if (hasIndustryName)
    {
      paramDataProcessor.startRecordField$505cff1c("industryName");
      paramDataProcessor.processString(industryName);
    }
    if (hasIndustryUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("industryUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(industryUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label247:
    Object localObject3;
    boolean bool2;
    label286:
    label297:
    Object localObject4;
    boolean bool3;
    label337:
    label349:
    Object localObject5;
    boolean bool4;
    label514:
    label526:
    Object localObject6;
    boolean bool5;
    if (hasLocation)
    {
      paramDataProcessor.startRecordField$505cff1c("location");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = location.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label764;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasBackgroundImage)
      {
        paramDataProcessor.startRecordField$505cff1c("backgroundImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label773;
        }
        localObject1 = backgroundImage.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label791;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasPictureInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("pictureInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label800;
        }
        localObject1 = pictureInfo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label818;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      if (hasPhoneticFirstName)
      {
        paramDataProcessor.startRecordField$505cff1c("phoneticFirstName");
        paramDataProcessor.processString(phoneticFirstName);
      }
      if (hasPhoneticLastName)
      {
        paramDataProcessor.startRecordField$505cff1c("phoneticLastName");
        paramDataProcessor.processString(phoneticLastName);
      }
      if (hasContactInstructions)
      {
        paramDataProcessor.startRecordField$505cff1c("contactInstructions");
        paramDataProcessor.processString(contactInstructions);
      }
      if (hasInterests)
      {
        paramDataProcessor.startRecordField$505cff1c("interests");
        paramDataProcessor.processString(interests);
      }
      if (hasAddress)
      {
        paramDataProcessor.startRecordField$505cff1c("address");
        paramDataProcessor.processString(address);
      }
      localObject5 = null;
      bool4 = false;
      if (hasBirthDate)
      {
        paramDataProcessor.startRecordField$505cff1c("birthDate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label828;
        }
        localObject1 = birthDate.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label846;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      if (hasSummary)
      {
        paramDataProcessor.startRecordField$505cff1c("summary");
        paramDataProcessor.processString(summary);
      }
      if (hasVersionTag)
      {
        paramDataProcessor.startRecordField$505cff1c("versionTag");
        paramDataProcessor.processString(versionTag);
      }
      localObject6 = null;
      bool5 = false;
      if (hasState)
      {
        paramDataProcessor.startRecordField$505cff1c("state");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label856;
        }
        localObject1 = state.accept(paramDataProcessor);
        label616:
        if (localObject1 == null) {
          break label874;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      label628:
      if (hasLocationName)
      {
        paramDataProcessor.startRecordField$505cff1c("locationName");
        paramDataProcessor.processString(locationName);
      }
      localObject1 = null;
      bool6 = false;
      if (hasMiniProfile)
      {
        paramDataProcessor.startRecordField$505cff1c("miniProfile");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label884;
        }
        localObject1 = miniProfile.accept(paramDataProcessor);
        label693:
        if (localObject1 == null) {
          break label902;
        }
      }
    }
    label764:
    label773:
    label791:
    label800:
    label818:
    label828:
    label846:
    label856:
    label874:
    label884:
    label902:
    for (boolean bool6 = true;; bool6 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1098;
      }
      try
      {
        if (hasFirstName) {
          break label908;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile", "firstName");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (ProfileLocation)paramDataProcessor.processDataTemplate(location);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label247;
      localObject1 = (BackgroundImage)paramDataProcessor.processDataTemplate(backgroundImage);
      break label286;
      bool2 = false;
      localObject3 = localObject1;
      break label297;
      localObject1 = (Picture)paramDataProcessor.processDataTemplate(pictureInfo);
      break label337;
      bool3 = false;
      localObject4 = localObject1;
      break label349;
      localObject1 = (Date)paramDataProcessor.processDataTemplate(birthDate);
      break label514;
      bool4 = false;
      localObject5 = localObject1;
      break label526;
      localObject1 = (State)paramDataProcessor.processDataTemplate(state);
      break label616;
      bool5 = false;
      localObject6 = localObject1;
      break label628;
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break label693;
    }
    label908:
    if (!hasVersionTag) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile", "versionTag");
    }
    if (!hasMiniProfile) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile", "miniProfile");
    }
    return new Profile(entityUrn, firstName, lastName, maidenName, headline, industryName, industryUrn, (ProfileLocation)localObject2, (BackgroundImage)localObject3, (Picture)localObject4, phoneticFirstName, phoneticLastName, contactInstructions, interests, address, (Date)localObject5, summary, versionTag, (State)localObject6, locationName, (MiniProfile)localObject1, hasEntityUrn, hasFirstName, hasLastName, hasMaidenName, hasHeadline, hasIndustryName, hasIndustryUrn, bool1, bool2, bool3, hasPhoneticFirstName, hasPhoneticLastName, hasContactInstructions, hasInterests, hasAddress, bool4, hasSummary, hasVersionTag, bool5, hasLocationName, bool6);
    label1098:
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
      paramObject = (Profile)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (firstName != null)
      {
        if (firstName.equals(firstName)) {}
      }
      else {
        while (firstName != null) {
          return false;
        }
      }
      if (lastName != null)
      {
        if (lastName.equals(lastName)) {}
      }
      else {
        while (lastName != null) {
          return false;
        }
      }
      if (maidenName != null)
      {
        if (maidenName.equals(maidenName)) {}
      }
      else {
        while (maidenName != null) {
          return false;
        }
      }
      if (headline != null)
      {
        if (headline.equals(headline)) {}
      }
      else {
        while (headline != null) {
          return false;
        }
      }
      if (industryName != null)
      {
        if (industryName.equals(industryName)) {}
      }
      else {
        while (industryName != null) {
          return false;
        }
      }
      if (industryUrn != null)
      {
        if (industryUrn.equals(industryUrn)) {}
      }
      else {
        while (industryUrn != null) {
          return false;
        }
      }
      if (location != null)
      {
        if (location.equals(location)) {}
      }
      else {
        while (location != null) {
          return false;
        }
      }
      if (backgroundImage != null)
      {
        if (backgroundImage.equals(backgroundImage)) {}
      }
      else {
        while (backgroundImage != null) {
          return false;
        }
      }
      if (pictureInfo != null)
      {
        if (pictureInfo.equals(pictureInfo)) {}
      }
      else {
        while (pictureInfo != null) {
          return false;
        }
      }
      if (phoneticFirstName != null)
      {
        if (phoneticFirstName.equals(phoneticFirstName)) {}
      }
      else {
        while (phoneticFirstName != null) {
          return false;
        }
      }
      if (phoneticLastName != null)
      {
        if (phoneticLastName.equals(phoneticLastName)) {}
      }
      else {
        while (phoneticLastName != null) {
          return false;
        }
      }
      if (contactInstructions != null)
      {
        if (contactInstructions.equals(contactInstructions)) {}
      }
      else {
        while (contactInstructions != null) {
          return false;
        }
      }
      if (interests != null)
      {
        if (interests.equals(interests)) {}
      }
      else {
        while (interests != null) {
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
      if (birthDate != null)
      {
        if (birthDate.equals(birthDate)) {}
      }
      else {
        while (birthDate != null) {
          return false;
        }
      }
      if (summary != null)
      {
        if (summary.equals(summary)) {}
      }
      else {
        while (summary != null) {
          return false;
        }
      }
      if (versionTag != null)
      {
        if (versionTag.equals(versionTag)) {}
      }
      else {
        while (versionTag != null) {
          return false;
        }
      }
      if (state != null)
      {
        if (state.equals(state)) {}
      }
      else {
        while (state != null) {
          return false;
        }
      }
      if (locationName != null)
      {
        if (locationName.equals(locationName)) {}
      }
      else {
        while (locationName != null) {
          return false;
        }
      }
      if (miniProfile == null) {
        break;
      }
    } while (miniProfile.equals(miniProfile));
    for (;;)
    {
      return false;
      if (miniProfile == null) {
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
    if (hasEntityUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasFirstName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(firstName);
    }
    j = i + 1;
    i = j;
    if (hasLastName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(lastName);
    }
    j = i + 1;
    i = j;
    if (hasMaidenName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(maidenName);
    }
    j = i + 1;
    i = j;
    if (hasHeadline) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(headline);
    }
    j = i + 1;
    i = j;
    if (hasIndustryName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(industryName);
    }
    j = i + 1;
    i = j;
    if (hasIndustryUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(industryUrn));
    }
    j = i + 1;
    i = j;
    if (hasLocation)
    {
      i = j + 1;
      if (location._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(location._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasBackgroundImage)
      {
        i = j + 1;
        if (backgroundImage._cachedId == null) {
          break label674;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(backgroundImage._cachedId);
      }
      label286:
      j = i + 1;
      i = j;
      if (hasPictureInfo)
      {
        i = j + 1;
        if (pictureInfo._cachedId == null) {
          break label687;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(pictureInfo._cachedId);
      }
      label328:
      j = i + 1;
      i = j;
      if (hasPhoneticFirstName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(phoneticFirstName);
      }
      j = i + 1;
      i = j;
      if (hasPhoneticLastName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(phoneticLastName);
      }
      j = i + 1;
      i = j;
      if (hasContactInstructions) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(contactInstructions);
      }
      j = i + 1;
      i = j;
      if (hasInterests) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(interests);
      }
      j = i + 1;
      i = j;
      if (hasAddress) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(address);
      }
      j = i + 1;
      i = j;
      if (hasBirthDate)
      {
        i = j + 1;
        if (birthDate._cachedId == null) {
          break label700;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(birthDate._cachedId);
      }
      label495:
      j = i + 1;
      i = j;
      if (hasSummary) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(summary);
      }
      j = i + 1;
      i = j;
      if (hasVersionTag) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(versionTag);
      }
      j = i + 1;
      i = j;
      if (hasState)
      {
        i = j + 1;
        if (state._cachedId == null) {
          break label713;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(state._cachedId);
      }
      label587:
      j = i + 1;
      i = j;
      if (hasLocationName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(locationName);
      }
      j = i + 1;
      i = j;
      if (hasMiniProfile)
      {
        i = j + 1;
        if (miniProfile._cachedId == null) {
          break label726;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += location.getSerializedSize();
      break;
      label674:
      i += backgroundImage.getSerializedSize();
      break label286;
      label687:
      i += pictureInfo.getSerializedSize();
      break label328;
      label700:
      i += birthDate.getSerializedSize();
      break label495;
      label713:
      i += state.getSerializedSize();
      break label587;
      label726:
      i += miniProfile.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i16 = 0;
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
    label156:
    int i5;
    label172:
    int i6;
    label188:
    int i7;
    label204:
    int i8;
    label220:
    int i9;
    label236:
    int i10;
    label252:
    int i11;
    label268:
    int i12;
    label284:
    int i13;
    label300:
    int i14;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (firstName == null) {
        break label484;
      }
      j = firstName.hashCode();
      if (lastName == null) {
        break label489;
      }
      k = lastName.hashCode();
      if (maidenName == null) {
        break label494;
      }
      m = maidenName.hashCode();
      if (headline == null) {
        break label500;
      }
      n = headline.hashCode();
      if (industryName == null) {
        break label506;
      }
      i1 = industryName.hashCode();
      if (industryUrn == null) {
        break label512;
      }
      i2 = industryUrn.hashCode();
      if (location == null) {
        break label518;
      }
      i3 = location.hashCode();
      if (backgroundImage == null) {
        break label524;
      }
      i4 = backgroundImage.hashCode();
      if (pictureInfo == null) {
        break label530;
      }
      i5 = pictureInfo.hashCode();
      if (phoneticFirstName == null) {
        break label536;
      }
      i6 = phoneticFirstName.hashCode();
      if (phoneticLastName == null) {
        break label542;
      }
      i7 = phoneticLastName.hashCode();
      if (contactInstructions == null) {
        break label548;
      }
      i8 = contactInstructions.hashCode();
      if (interests == null) {
        break label554;
      }
      i9 = interests.hashCode();
      if (address == null) {
        break label560;
      }
      i10 = address.hashCode();
      if (birthDate == null) {
        break label566;
      }
      i11 = birthDate.hashCode();
      if (summary == null) {
        break label572;
      }
      i12 = summary.hashCode();
      if (versionTag == null) {
        break label578;
      }
      i13 = versionTag.hashCode();
      if (state == null) {
        break label584;
      }
      i14 = state.hashCode();
      label316:
      if (locationName == null) {
        break label590;
      }
    }
    label484:
    label489:
    label494:
    label500:
    label506:
    label512:
    label518:
    label524:
    label530:
    label536:
    label542:
    label548:
    label554:
    label560:
    label566:
    label572:
    label578:
    label584:
    label590:
    for (int i15 = locationName.hashCode();; i15 = 0)
    {
      if (miniProfile != null) {
        i16 = miniProfile.hashCode();
      }
      i = (i15 + (i14 + (i13 + (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i16;
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
      i5 = 0;
      break label172;
      i6 = 0;
      break label188;
      i7 = 0;
      break label204;
      i8 = 0;
      break label220;
      i9 = 0;
      break label236;
      i10 = 0;
      break label252;
      i11 = 0;
      break label268;
      i12 = 0;
      break label284;
      i13 = 0;
      break label300;
      i14 = 0;
      break label316;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Profile");
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
    label172:
    label198:
    label224:
    label250:
    label276:
    label310:
    label370:
    label430:
    label490:
    label516:
    label542:
    label568:
    label594:
    label620:
    label680:
    label706:
    label732:
    label792:
    label818:
    label921:
    label931:
    label941:
    label951:
    label961:
    label971:
    label981:
    label1006:
    label1016:
    label1041:
    label1051:
    label1076:
    label1086:
    label1096:
    label1106:
    label1116:
    label1126:
    label1136:
    label1161:
    label1171:
    label1181:
    label1191:
    label1216:
    label1226:
    label1236:
    label1261:
    label1269:
    label1271:
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
        localByteBuffer.putInt(-548248113);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasFirstName) {
            break label921;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, firstName);
          if (!hasLastName) {
            break label931;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, lastName);
          if (!hasMaidenName) {
            break label941;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, maidenName);
          if (!hasHeadline) {
            break label951;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, headline);
          if (!hasIndustryName) {
            break label961;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, industryName);
          if (!hasIndustryUrn) {
            break label971;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(industryUrn));
          if (!hasLocation) {
            break label1006;
          }
          localByteBuffer.put((byte)1);
          if (location._cachedId == null) {
            break label981;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, location._cachedId);
          location.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasBackgroundImage) {
            break label1041;
          }
          localByteBuffer.put((byte)1);
          if (backgroundImage._cachedId == null) {
            break label1016;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, backgroundImage._cachedId);
          backgroundImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPictureInfo) {
            break label1076;
          }
          localByteBuffer.put((byte)1);
          if (pictureInfo._cachedId == null) {
            break label1051;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, pictureInfo._cachedId);
          pictureInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPhoneticFirstName) {
            break label1086;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, phoneticFirstName);
          if (!hasPhoneticLastName) {
            break label1096;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, phoneticLastName);
          if (!hasContactInstructions) {
            break label1106;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, contactInstructions);
          if (!hasInterests) {
            break label1116;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, interests);
          if (!hasAddress) {
            break label1126;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, address);
          if (!hasBirthDate) {
            break label1161;
          }
          localByteBuffer.put((byte)1);
          if (birthDate._cachedId == null) {
            break label1136;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, birthDate._cachedId);
          birthDate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSummary) {
            break label1171;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, summary);
          if (!hasVersionTag) {
            break label1181;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, versionTag);
          if (!hasState) {
            break label1216;
          }
          localByteBuffer.put((byte)1);
          if (state._cachedId == null) {
            break label1191;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, state._cachedId);
          state.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasLocationName) {
            break label1226;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, locationName);
          if (!hasMiniProfile) {
            break label1261;
          }
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId == null) {
            break label1236;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
          miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label1269;
          }
          if (str != null) {
            break label1271;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label172;
          localByteBuffer.put((byte)0);
          break label198;
          localByteBuffer.put((byte)0);
          break label224;
          localByteBuffer.put((byte)0);
          break label250;
          localByteBuffer.put((byte)0);
          break label276;
          localByteBuffer.put((byte)0);
          break label310;
          localByteBuffer.put((byte)1);
          location.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label370;
          localByteBuffer.put((byte)0);
          break label370;
          localByteBuffer.put((byte)1);
          backgroundImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label430;
          localByteBuffer.put((byte)0);
          break label430;
          localByteBuffer.put((byte)1);
          pictureInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label490;
          localByteBuffer.put((byte)0);
          break label490;
          localByteBuffer.put((byte)0);
          break label516;
          localByteBuffer.put((byte)0);
          break label542;
          localByteBuffer.put((byte)0);
          break label568;
          localByteBuffer.put((byte)0);
          break label594;
          localByteBuffer.put((byte)0);
          break label620;
          localByteBuffer.put((byte)1);
          birthDate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label680;
          localByteBuffer.put((byte)0);
          break label680;
          localByteBuffer.put((byte)0);
          break label706;
          localByteBuffer.put((byte)0);
          break label732;
          localByteBuffer.put((byte)1);
          state.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label792;
          localByteBuffer.put((byte)0);
          break label792;
          localByteBuffer.put((byte)0);
          break label818;
          localByteBuffer.put((byte)1);
          miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */