package com.linkedin.gen.avro2pegasus.events.promotions;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.messages.flock.PhoneNumberInfo;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class PromotionImpressionEvent
  implements RecordTemplate<PromotionImpressionEvent>
{
  public static final PromotionImpressionEventBuilder BUILDER = PromotionImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasPhoneNumberInfo;
  public final boolean hasProductUrns;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final PhoneNumberInfo phoneNumberInfo;
  public final List<String> productUrns;
  public final UserRequestHeader requestHeader;
  
  PromotionImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, PhoneNumberInfo paramPhoneNumberInfo, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    phoneNumberInfo = paramPhoneNumberInfo;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      productUrns = paramEventHeader;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasPhoneNumberInfo = paramBoolean4;
      hasProductUrns = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  private PromotionImpressionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label96:
    label108:
    Object localObject4;
    boolean bool3;
    label148:
    label160:
    boolean bool4;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label364;
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
          break label373;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label391;
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
          break label401;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label419;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasPhoneNumberInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("phoneNumberInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label429;
        }
        localObject1 = phoneNumberInfo.accept(paramDataProcessor);
        label200:
        if (localObject1 == null) {
          break label447;
        }
        bool4 = true;
      }
    }
    for (Object localObject5 = localObject1;; localObject5 = localObject1)
    {
      localObject1 = null;
      Iterator localIterator = null;
      bool5 = false;
      if (!hasProductUrns) {
        break label471;
      }
      paramDataProcessor.startRecordField$505cff1c("productUrns");
      productUrns.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localIterator = productUrns.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject1 != null) {
          ((List)localObject1).add(str);
        }
        i += 1;
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      label364:
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      label373:
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label96;
      label391:
      bool2 = false;
      localObject3 = localObject1;
      break label108;
      label401:
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label148;
      label419:
      bool3 = false;
      localObject4 = localObject1;
      break label160;
      label429:
      localObject1 = (PhoneNumberInfo)paramDataProcessor.processDataTemplate(phoneNumberInfo);
      break label200;
      label447:
      bool4 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool5 = true;; bool5 = false)
    {
      label471:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label636;
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent", "requestHeader");
    }
    if (!hasProductUrns) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent", "productUrns");
    }
    if (productUrns != null)
    {
      paramDataProcessor = productUrns.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent", "productUrns");
        }
      }
    }
    return new PromotionImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (PhoneNumberInfo)localObject5, (List)localObject1, bool1, bool2, bool3, bool4, bool5);
    label636:
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
      paramObject = (PromotionImpressionEvent)paramObject;
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
      if (productUrns == null) {
        break;
      }
    } while (productUrns.equals(productUrns));
    for (;;)
    {
      return false;
      if (productUrns == null) {
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
        break label134;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label139;
      }
      k = mobileHeader.hashCode();
      label60:
      if (phoneNumberInfo == null) {
        break label144;
      }
    }
    label134:
    label139:
    label144:
    for (int m = phoneNumberInfo.hashCode();; m = 0)
    {
      if (productUrns != null) {
        n = productUrns.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<PromotionImpressionEvent>
  {
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasPhoneNumberInfo = false;
    public boolean hasProductUrns = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public PhoneNumberInfo phoneNumberInfo = null;
    public List<String> productUrns = null;
    private UserRequestHeader requestHeader = null;
    
    private PromotionImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PromotionImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (productUrns != null)
      {
        paramFlavor = productUrns.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((String)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent", "productUrns");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent", "requestHeader");
              }
              if (hasProductUrns) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent", "productUrns");
            }
          }
        }
      }
      return new PromotionImpressionEvent(header, requestHeader, mobileHeader, phoneNumberInfo, productUrns, hasHeader, hasRequestHeader, hasMobileHeader, hasPhoneNumberInfo, hasProductUrns);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.promotions.PromotionImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */