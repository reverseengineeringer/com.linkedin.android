package com.linkedin.gen.avro2pegasus.events.promotions;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.messages.flock.PhoneNumberInfo;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class UpgradeConfirmationViewEvent
  implements RecordTemplate<UpgradeConfirmationViewEvent>
{
  public static final UpgradeConfirmationViewEventBuilder BUILDER = UpgradeConfirmationViewEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasPhoneNumberInfo;
  public final boolean hasProductUrn;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final PhoneNumberInfo phoneNumberInfo;
  public final String productUrn;
  public final UserRequestHeader requestHeader;
  
  UpgradeConfirmationViewEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, PhoneNumberInfo paramPhoneNumberInfo, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    phoneNumberInfo = paramPhoneNumberInfo;
    productUrn = paramString;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasPhoneNumberInfo = paramBoolean4;
    hasProductUrn = paramBoolean5;
    _cachedId = null;
  }
  
  private UpgradeConfirmationViewEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
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
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label293;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasRequestHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("requestHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label302;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label320;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label329;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label347;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      localObject1 = null;
      bool4 = false;
      if (hasPhoneNumberInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("phoneNumberInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label357;
        }
        localObject1 = phoneNumberInfo.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label375;
        }
      }
    }
    label293:
    label302:
    label320:
    label329:
    label347:
    label357:
    label375:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasProductUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("productUrn");
        paramDataProcessor.processString(productUrn);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label449;
      }
      try
      {
        if (hasHeader) {
          break label381;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.UpgradeConfirmationViewEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (PhoneNumberInfo)paramDataProcessor.processDataTemplate(phoneNumberInfo);
      break label198;
    }
    label381:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.UpgradeConfirmationViewEvent", "requestHeader");
    }
    if (!hasProductUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.UpgradeConfirmationViewEvent", "productUrn");
    }
    return new UpgradeConfirmationViewEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (PhoneNumberInfo)localObject1, productUrn, bool1, bool2, bool3, bool4, hasProductUrn);
    label449:
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
      paramObject = (UpgradeConfirmationViewEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (requestHeader != null)
      {
        if (requestHeader.equals(requestHeader)) {}
      }
      else {
        while (requestHeader != null) {
          return false;
        }
      }
      if (mobileHeader != null)
      {
        if (mobileHeader.equals(mobileHeader)) {}
      }
      else {
        while (mobileHeader != null) {
          return false;
        }
      }
      if (phoneNumberInfo != null)
      {
        if (phoneNumberInfo.equals(phoneNumberInfo)) {}
      }
      else {
        while (phoneNumberInfo != null) {
          return false;
        }
      }
      if (productUrn == null) {
        break;
      }
    } while (productUrn.equals(productUrn));
    for (;;)
    {
      return false;
      if (productUrn == null) {
        break;
      }
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
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label132;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label137;
      }
      k = mobileHeader.hashCode();
      label60:
      if (phoneNumberInfo == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = phoneNumberInfo.hashCode();; m = 0)
    {
      if (productUrn != null) {
        n = productUrn.hashCode();
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
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<UpgradeConfirmationViewEvent>
  {
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasPhoneNumberInfo = false;
    public boolean hasProductUrn = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public PhoneNumberInfo phoneNumberInfo = null;
    public String productUrn = null;
    private UserRequestHeader requestHeader = null;
    
    private UpgradeConfirmationViewEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (UpgradeConfirmationViewEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new UpgradeConfirmationViewEvent(header, requestHeader, mobileHeader, phoneNumberInfo, productUrn, hasHeader, hasRequestHeader, hasMobileHeader, hasPhoneNumberInfo, hasProductUrn);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.UpgradeConfirmationViewEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.UpgradeConfirmationViewEvent", "requestHeader");
        }
      } while (hasProductUrn);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.UpgradeConfirmationViewEvent", "productUrn");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.promotions.UpgradeConfirmationViewEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */