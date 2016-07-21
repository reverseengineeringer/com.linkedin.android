package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NormProfile
  implements FissileDataModel<NormProfile>, RecordTemplate<NormProfile>
{
  public static final NormProfileBuilder BUILDER = NormProfileBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
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
  public final boolean hasMaidenName;
  public final boolean hasPhoneticFirstName;
  public final boolean hasPhoneticLastName;
  public final boolean hasPictureInfo;
  public final boolean hasSummary;
  public final String headline;
  public final String industryName;
  public final Urn industryUrn;
  public final String interests;
  public final String lastName;
  public final ProfileLocation location;
  public final String maidenName;
  public final String phoneticFirstName;
  public final String phoneticLastName;
  public final Picture pictureInfo;
  public final String summary;
  
  NormProfile(Urn paramUrn1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Urn paramUrn2, ProfileLocation paramProfileLocation, BackgroundImage paramBackgroundImage, Picture paramPicture, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, Date paramDate, String paramString11, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17)
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
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  private NormProfile accept(DataProcessor paramDataProcessor)
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
    if (hasLocation)
    {
      paramDataProcessor.startRecordField$505cff1c("location");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = location.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label609;
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
          break label618;
        }
        localObject1 = backgroundImage.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label636;
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
          break label645;
        }
        localObject1 = pictureInfo.accept(paramDataProcessor);
        label337:
        if (localObject1 == null) {
          break label663;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label349:
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
      localObject1 = null;
      bool4 = false;
      if (hasBirthDate)
      {
        paramDataProcessor.startRecordField$505cff1c("birthDate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label673;
        }
        localObject1 = birthDate.accept(paramDataProcessor);
        label514:
        if (localObject1 == null) {
          break label691;
        }
      }
    }
    label609:
    label618:
    label636:
    label645:
    label663:
    label673:
    label691:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasSummary)
      {
        paramDataProcessor.startRecordField$505cff1c("summary");
        paramDataProcessor.processString(summary);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label823;
      }
      try
      {
        if (hasFirstName) {
          break label697;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile", "firstName");
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
    }
    label697:
    return new NormProfile(entityUrn, firstName, lastName, maidenName, headline, industryName, industryUrn, (ProfileLocation)localObject2, (BackgroundImage)localObject3, (Picture)localObject4, phoneticFirstName, phoneticLastName, contactInstructions, interests, address, (Date)localObject1, summary, hasEntityUrn, hasFirstName, hasLastName, hasMaidenName, hasHeadline, hasIndustryName, hasIndustryUrn, bool1, bool2, bool3, hasPhoneticFirstName, hasPhoneticLastName, hasContactInstructions, hasInterests, hasAddress, bool4, hasSummary);
    label823:
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
      paramObject = (NormProfile)paramObject;
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
      if (summary == null) {
        break;
      }
    } while (summary.equals(summary));
    for (;;)
    {
      return false;
      if (summary == null) {
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
          break label540;
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
          break label553;
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
          break label566;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(birthDate._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasSummary) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(summary);
      }
      __sizeOfObject = i;
      return i;
      i += location.getSerializedSize();
      break;
      label540:
      i += backgroundImage.getSerializedSize();
      break label286;
      label553:
      i += pictureInfo.getSerializedSize();
      break label328;
      label566:
      i += birthDate.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i12 = 0;
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
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (firstName == null) {
        break label396;
      }
      j = firstName.hashCode();
      if (lastName == null) {
        break label401;
      }
      k = lastName.hashCode();
      if (maidenName == null) {
        break label406;
      }
      m = maidenName.hashCode();
      if (headline == null) {
        break label412;
      }
      n = headline.hashCode();
      if (industryName == null) {
        break label418;
      }
      i1 = industryName.hashCode();
      if (industryUrn == null) {
        break label424;
      }
      i2 = industryUrn.hashCode();
      if (location == null) {
        break label430;
      }
      i3 = location.hashCode();
      if (backgroundImage == null) {
        break label436;
      }
      i4 = backgroundImage.hashCode();
      if (pictureInfo == null) {
        break label442;
      }
      i5 = pictureInfo.hashCode();
      if (phoneticFirstName == null) {
        break label448;
      }
      i6 = phoneticFirstName.hashCode();
      if (phoneticLastName == null) {
        break label454;
      }
      i7 = phoneticLastName.hashCode();
      if (contactInstructions == null) {
        break label460;
      }
      i8 = contactInstructions.hashCode();
      if (interests == null) {
        break label466;
      }
      i9 = interests.hashCode();
      if (address == null) {
        break label472;
      }
      i10 = address.hashCode();
      label252:
      if (birthDate == null) {
        break label478;
      }
    }
    label396:
    label401:
    label406:
    label412:
    label418:
    label424:
    label430:
    label436:
    label442:
    label448:
    label454:
    label460:
    label466:
    label472:
    label478:
    for (int i11 = birthDate.hashCode();; i11 = 0)
    {
      if (summary != null) {
        i12 = summary.hashCode();
      }
      i = (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i12;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NormProfile");
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
    label749:
    label759:
    label769:
    label779:
    label789:
    label799:
    label809:
    label834:
    label844:
    label869:
    label879:
    label904:
    label914:
    label924:
    label934:
    label944:
    label954:
    label964:
    label989:
    label999:
    label1007:
    label1009:
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
        localByteBuffer.putInt(-1404167993);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasFirstName) {
            break label749;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, firstName);
          if (!hasLastName) {
            break label759;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, lastName);
          if (!hasMaidenName) {
            break label769;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, maidenName);
          if (!hasHeadline) {
            break label779;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, headline);
          if (!hasIndustryName) {
            break label789;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, industryName);
          if (!hasIndustryUrn) {
            break label799;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(industryUrn));
          if (!hasLocation) {
            break label834;
          }
          localByteBuffer.put((byte)1);
          if (location._cachedId == null) {
            break label809;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, location._cachedId);
          location.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasBackgroundImage) {
            break label869;
          }
          localByteBuffer.put((byte)1);
          if (backgroundImage._cachedId == null) {
            break label844;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, backgroundImage._cachedId);
          backgroundImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPictureInfo) {
            break label904;
          }
          localByteBuffer.put((byte)1);
          if (pictureInfo._cachedId == null) {
            break label879;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, pictureInfo._cachedId);
          pictureInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPhoneticFirstName) {
            break label914;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, phoneticFirstName);
          if (!hasPhoneticLastName) {
            break label924;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, phoneticLastName);
          if (!hasContactInstructions) {
            break label934;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, contactInstructions);
          if (!hasInterests) {
            break label944;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, interests);
          if (!hasAddress) {
            break label954;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, address);
          if (!hasBirthDate) {
            break label989;
          }
          localByteBuffer.put((byte)1);
          if (birthDate._cachedId == null) {
            break label964;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, birthDate._cachedId);
          birthDate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSummary) {
            break label999;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, summary);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label1007;
          }
          if (str != null) {
            break label1009;
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
    implements RecordTemplateBuilder<NormProfile>
  {
    public String address = null;
    private BackgroundImage backgroundImage = null;
    private Date birthDate = null;
    public String contactInstructions = null;
    private Urn entityUrn = null;
    private String firstName = null;
    public boolean hasAddress = false;
    private boolean hasBackgroundImage = false;
    private boolean hasBirthDate = false;
    public boolean hasContactInstructions = false;
    private boolean hasEntityUrn = false;
    private boolean hasFirstName = false;
    private boolean hasHeadline = false;
    private boolean hasIndustryName = false;
    private boolean hasIndustryUrn = false;
    public boolean hasInterests = false;
    private boolean hasLastName = false;
    private boolean hasLocation = false;
    public boolean hasMaidenName = false;
    private boolean hasPhoneticFirstName = false;
    private boolean hasPhoneticLastName = false;
    private boolean hasPictureInfo = false;
    private boolean hasSummary = false;
    private String headline = null;
    private String industryName = null;
    private Urn industryUrn = null;
    public String interests = null;
    private String lastName = null;
    private ProfileLocation location = null;
    public String maidenName = null;
    private String phoneticFirstName = null;
    private String phoneticLastName = null;
    private Picture pictureInfo = null;
    private String summary = null;
    
    public Builder() {}
    
    public Builder(NormProfile paramNormProfile)
    {
      entityUrn = entityUrn;
      firstName = firstName;
      lastName = lastName;
      maidenName = maidenName;
      headline = headline;
      industryName = industryName;
      industryUrn = industryUrn;
      location = location;
      backgroundImage = backgroundImage;
      pictureInfo = pictureInfo;
      phoneticFirstName = phoneticFirstName;
      phoneticLastName = phoneticLastName;
      contactInstructions = contactInstructions;
      interests = interests;
      address = address;
      birthDate = birthDate;
      summary = summary;
      hasEntityUrn = hasEntityUrn;
      hasFirstName = hasFirstName;
      hasLastName = hasLastName;
      hasMaidenName = hasMaidenName;
      hasHeadline = hasHeadline;
      hasIndustryName = hasIndustryName;
      hasIndustryUrn = hasIndustryUrn;
      hasLocation = hasLocation;
      hasBackgroundImage = hasBackgroundImage;
      hasPictureInfo = hasPictureInfo;
      hasPhoneticFirstName = hasPhoneticFirstName;
      hasPhoneticLastName = hasPhoneticLastName;
      hasContactInstructions = hasContactInstructions;
      hasInterests = hasInterests;
      hasAddress = hasAddress;
      hasBirthDate = hasBirthDate;
      hasSummary = hasSummary;
    }
    
    public final NormProfile build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (NormProfile.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new NormProfile(entityUrn, firstName, lastName, maidenName, headline, industryName, industryUrn, location, backgroundImage, pictureInfo, phoneticFirstName, phoneticLastName, contactInstructions, interests, address, birthDate, summary, hasEntityUrn, hasFirstName, hasLastName, hasMaidenName, hasHeadline, hasIndustryName, hasIndustryUrn, hasLocation, hasBackgroundImage, hasPictureInfo, hasPhoneticFirstName, hasPhoneticLastName, hasContactInstructions, hasInterests, hasAddress, hasBirthDate, hasSummary);
      } while (hasFirstName);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile", "firstName");
    }
    
    public final Builder setBackgroundImage(BackgroundImage paramBackgroundImage)
    {
      if (paramBackgroundImage == null)
      {
        hasBackgroundImage = false;
        backgroundImage = null;
        return this;
      }
      hasBackgroundImage = true;
      backgroundImage = paramBackgroundImage;
      return this;
    }
    
    public final Builder setBirthDate(Date paramDate)
    {
      if (paramDate == null)
      {
        hasBirthDate = false;
        birthDate = null;
        return this;
      }
      hasBirthDate = true;
      birthDate = paramDate;
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
    
    public final Builder setFirstName(String paramString)
    {
      if (paramString == null)
      {
        hasFirstName = false;
        firstName = null;
        return this;
      }
      hasFirstName = true;
      firstName = paramString;
      return this;
    }
    
    public final Builder setHeadline(String paramString)
    {
      if (paramString == null)
      {
        hasHeadline = false;
        headline = null;
        return this;
      }
      hasHeadline = true;
      headline = paramString;
      return this;
    }
    
    public final Builder setIndustryName(String paramString)
    {
      if (paramString == null)
      {
        hasIndustryName = false;
        industryName = null;
        return this;
      }
      hasIndustryName = true;
      industryName = paramString;
      return this;
    }
    
    public final Builder setIndustryUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasIndustryUrn = false;
        industryUrn = null;
        return this;
      }
      hasIndustryUrn = true;
      industryUrn = paramUrn;
      return this;
    }
    
    public final Builder setLastName(String paramString)
    {
      if (paramString == null)
      {
        hasLastName = false;
        lastName = null;
        return this;
      }
      hasLastName = true;
      lastName = paramString;
      return this;
    }
    
    public final Builder setLocation(ProfileLocation paramProfileLocation)
    {
      if (paramProfileLocation == null)
      {
        hasLocation = false;
        location = null;
        return this;
      }
      hasLocation = true;
      location = paramProfileLocation;
      return this;
    }
    
    public final Builder setPhoneticFirstName(String paramString)
    {
      if (paramString == null)
      {
        hasPhoneticFirstName = false;
        phoneticFirstName = null;
        return this;
      }
      hasPhoneticFirstName = true;
      phoneticFirstName = paramString;
      return this;
    }
    
    public final Builder setPhoneticLastName(String paramString)
    {
      if (paramString == null)
      {
        hasPhoneticLastName = false;
        phoneticLastName = null;
        return this;
      }
      hasPhoneticLastName = true;
      phoneticLastName = paramString;
      return this;
    }
    
    public final Builder setPictureInfo(Picture paramPicture)
    {
      if (paramPicture == null)
      {
        hasPictureInfo = false;
        pictureInfo = null;
        return this;
      }
      hasPictureInfo = true;
      pictureInfo = paramPicture;
      return this;
    }
    
    public final Builder setSummary(String paramString)
    {
      if (paramString == null)
      {
        hasSummary = false;
        summary = null;
        return this;
      }
      hasSummary = true;
      summary = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */