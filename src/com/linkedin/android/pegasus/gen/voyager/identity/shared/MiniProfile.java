package com.linkedin.android.pegasus.gen.voyager.identity.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MiniProfile
  implements FissileDataModel<MiniProfile>, RecordTemplate<MiniProfile>
{
  public static final MiniProfileBuilder BUILDER = MiniProfileBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Image backgroundImage;
  public final Urn entityUrn;
  public final String firstName;
  public final boolean hasBackgroundImage;
  public final boolean hasEntityUrn;
  public final boolean hasFirstName;
  public final boolean hasLastName;
  public final boolean hasObjectUrn;
  public final boolean hasOccupation;
  public final boolean hasPicture;
  public final boolean hasPublicIdentifier;
  public final boolean hasTrackingId;
  public final String lastName;
  public final Urn objectUrn;
  public final String occupation;
  public final Image picture;
  public final String publicIdentifier;
  public final String trackingId;
  
  MiniProfile(String paramString1, Urn paramUrn1, Urn paramUrn2, String paramString2, String paramString3, String paramString4, Image paramImage1, Image paramImage2, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    trackingId = paramString1;
    objectUrn = paramUrn1;
    entityUrn = paramUrn2;
    firstName = paramString2;
    lastName = paramString3;
    occupation = paramString4;
    backgroundImage = paramImage1;
    picture = paramImage2;
    publicIdentifier = paramString5;
    hasTrackingId = paramBoolean1;
    hasObjectUrn = paramBoolean2;
    hasEntityUrn = paramBoolean3;
    hasFirstName = paramBoolean4;
    hasLastName = paramBoolean5;
    hasOccupation = paramBoolean6;
    hasBackgroundImage = paramBoolean7;
    hasPicture = paramBoolean8;
    hasPublicIdentifier = paramBoolean9;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn2);
  }
  
  public final MiniProfile accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    Object localObject1;
    if (hasObjectUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("objectUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(objectUrn));
    }
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
    if (hasOccupation)
    {
      paramDataProcessor.startRecordField$505cff1c("occupation");
      paramDataProcessor.processString(occupation);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasBackgroundImage)
    {
      paramDataProcessor.startRecordField$505cff1c("backgroundImage");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = backgroundImage.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label355;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label222:
      localObject1 = null;
      bool2 = false;
      if (hasPicture)
      {
        paramDataProcessor.startRecordField$505cff1c("picture");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label364;
        }
        localObject1 = picture.accept(paramDataProcessor);
        label261:
        if (localObject1 == null) {
          break label382;
        }
      }
    }
    label355:
    label364:
    label382:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasPublicIdentifier)
      {
        paramDataProcessor.startRecordField$505cff1c("publicIdentifier");
        paramDataProcessor.processString(publicIdentifier);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label495;
      }
      try
      {
        if (hasEntityUrn) {
          break label387;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (Image)paramDataProcessor.processDataTemplate(backgroundImage);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label222;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(picture);
      break label261;
    }
    label387:
    if (!hasFirstName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile", "firstName");
    }
    if (!hasPublicIdentifier) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile", "publicIdentifier");
    }
    return new MiniProfile(trackingId, objectUrn, entityUrn, firstName, lastName, occupation, (Image)localObject2, (Image)localObject1, publicIdentifier, hasTrackingId, hasObjectUrn, hasEntityUrn, hasFirstName, hasLastName, hasOccupation, bool1, bool2, hasPublicIdentifier);
    label495:
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
      paramObject = (MiniProfile)paramObject;
      if (objectUrn != null)
      {
        if (objectUrn.equals(objectUrn)) {}
      }
      else {
        while (objectUrn != null) {
          return false;
        }
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
      if (occupation != null)
      {
        if (occupation.equals(occupation)) {}
      }
      else {
        while (occupation != null) {
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
      if (picture != null)
      {
        if (picture.equals(picture)) {}
      }
      else {
        while (picture != null) {
          return false;
        }
      }
      if (publicIdentifier == null) {
        break;
      }
    } while (publicIdentifier.equals(publicIdentifier));
    for (;;)
    {
      return false;
      if (publicIdentifier == null) {
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
    if (hasTrackingId) {
      i = PegasusBinaryUtils.getEncodedLength(trackingId) + 8;
    }
    int j = i + 1;
    i = j;
    UrnCoercer localUrnCoercer;
    if (hasObjectUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(objectUrn));
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
    if (hasOccupation) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(occupation);
    }
    j = i + 1;
    i = j;
    if (hasBackgroundImage)
    {
      i = j + 1;
      if (backgroundImage._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(backgroundImage._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasPicture)
      {
        i = j + 1;
        if (picture._cachedId == null) {
          break label306;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(picture._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasPublicIdentifier) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(publicIdentifier);
      }
      __sizeOfObject = i;
      return i;
      i += backgroundImage.getSerializedSize();
      break;
      label306:
      i += picture.getSerializedSize();
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
    int i1;
    if (objectUrn != null)
    {
      i = objectUrn.hashCode();
      if (entityUrn == null) {
        break label198;
      }
      j = entityUrn.hashCode();
      if (firstName == null) {
        break label203;
      }
      k = firstName.hashCode();
      if (lastName == null) {
        break label208;
      }
      m = lastName.hashCode();
      if (occupation == null) {
        break label214;
      }
      n = occupation.hashCode();
      if (backgroundImage == null) {
        break label220;
      }
      i1 = backgroundImage.hashCode();
      label108:
      if (picture == null) {
        break label226;
      }
    }
    label198:
    label203:
    label208:
    label214:
    label220:
    label226:
    for (int i2 = picture.hashCode();; i2 = 0)
    {
      if (publicIdentifier != null) {
        i3 = publicIdentifier.hashCode();
      }
      i = (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MiniProfile");
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
    label170:
    label204:
    label230:
    label256:
    label282:
    label342:
    label402:
    label471:
    label481:
    label491:
    label501:
    label511:
    label521:
    label546:
    label556:
    label581:
    label591:
    label599:
    label601:
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
        localByteBuffer.putInt(-700805101);
        if (hasTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasObjectUrn) {
            break label471;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
          if (!hasEntityUrn) {
            break label481;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasFirstName) {
            break label491;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, firstName);
          if (!hasLastName) {
            break label501;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, lastName);
          if (!hasOccupation) {
            break label511;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, occupation);
          if (!hasBackgroundImage) {
            break label546;
          }
          localByteBuffer.put((byte)1);
          if (backgroundImage._cachedId == null) {
            break label521;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, backgroundImage._cachedId);
          backgroundImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPicture) {
            break label581;
          }
          localByteBuffer.put((byte)1);
          if (picture._cachedId == null) {
            break label556;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, picture._cachedId);
          picture.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPublicIdentifier) {
            break label591;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, publicIdentifier);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label599;
          }
          if (str != null) {
            break label601;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)0);
          break label256;
          localByteBuffer.put((byte)0);
          break label282;
          localByteBuffer.put((byte)1);
          backgroundImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label342;
          localByteBuffer.put((byte)0);
          break label342;
          localByteBuffer.put((byte)1);
          picture.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label402;
          localByteBuffer.put((byte)0);
          break label402;
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
    implements RecordTemplateBuilder<MiniProfile>
  {
    private Image backgroundImage = null;
    private Urn entityUrn = null;
    private String firstName = null;
    private boolean hasBackgroundImage = false;
    private boolean hasEntityUrn = false;
    private boolean hasFirstName = false;
    private boolean hasLastName = false;
    public boolean hasObjectUrn = false;
    private boolean hasOccupation = false;
    private boolean hasPicture = false;
    private boolean hasPublicIdentifier = false;
    public boolean hasTrackingId = false;
    private String lastName = null;
    public Urn objectUrn = null;
    private String occupation = null;
    private Image picture = null;
    private String publicIdentifier = null;
    public String trackingId = null;
    
    public final MiniProfile build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (MiniProfile.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new MiniProfile(trackingId, objectUrn, entityUrn, firstName, lastName, occupation, backgroundImage, picture, publicIdentifier, hasTrackingId, hasObjectUrn, hasEntityUrn, hasFirstName, hasLastName, hasOccupation, hasBackgroundImage, hasPicture, hasPublicIdentifier);
        if (!hasEntityUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile", "entityUrn");
        }
        if (!hasFirstName) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile", "firstName");
        }
      } while (hasPublicIdentifier);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile", "publicIdentifier");
    }
    
    public final Builder setBackgroundImage(Image paramImage)
    {
      if (paramImage == null)
      {
        hasBackgroundImage = false;
        backgroundImage = null;
        return this;
      }
      hasBackgroundImage = true;
      backgroundImage = paramImage;
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
    
    public final Builder setOccupation(String paramString)
    {
      if (paramString == null)
      {
        hasOccupation = false;
        occupation = null;
        return this;
      }
      hasOccupation = true;
      occupation = paramString;
      return this;
    }
    
    public final Builder setPicture(Image paramImage)
    {
      if (paramImage == null)
      {
        hasPicture = false;
        picture = null;
        return this;
      }
      hasPicture = true;
      picture = paramImage;
      return this;
    }
    
    public final Builder setPublicIdentifier(String paramString)
    {
      if (paramString == null)
      {
        hasPublicIdentifier = false;
        publicIdentifier = null;
        return this;
      }
      hasPublicIdentifier = true;
      publicIdentifier = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */