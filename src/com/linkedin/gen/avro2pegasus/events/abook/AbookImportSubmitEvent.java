package com.linkedin.gen.avro2pegasus.events.abook;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class AbookImportSubmitEvent
  implements RecordTemplate<AbookImportSubmitEvent>
{
  public static final AbookImportSubmitEventBuilder BUILDER = AbookImportSubmitEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String abookImportTransactionId;
  public final boolean hasAbookImportTransactionId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasProviderName;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final ProviderName providerName;
  public final UserRequestHeader requestHeader;
  
  AbookImportSubmitEvent(EventHeader paramEventHeader, String paramString, MobileHeader paramMobileHeader, ProviderName paramProviderName, UserRequestHeader paramUserRequestHeader, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    abookImportTransactionId = paramString;
    mobileHeader = paramMobileHeader;
    providerName = paramProviderName;
    requestHeader = paramUserRequestHeader;
    hasHeader = paramBoolean1;
    hasAbookImportTransactionId = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasProviderName = paramBoolean4;
    hasRequestHeader = paramBoolean5;
    _cachedId = null;
  }
  
  private AbookImportSubmitEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label266;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasAbookImportTransactionId)
      {
        paramDataProcessor.startRecordField$505cff1c("abookImportTransactionId");
        paramDataProcessor.processString(abookImportTransactionId);
      }
      localObject3 = null;
      bool2 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label275;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label120:
        if (localObject1 == null) {
          break label293;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label131:
      if (hasProviderName)
      {
        paramDataProcessor.startRecordField$505cff1c("providerName");
        paramDataProcessor.processEnum(providerName);
      }
      localObject1 = null;
      bool3 = false;
      if (hasRequestHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("requestHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label302;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label196:
        if (localObject1 == null) {
          break label320;
        }
      }
    }
    label266:
    label275:
    label293:
    label302:
    label320:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label360;
      }
      try
      {
        if (hasHeader) {
          break label326;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportSubmitEvent", "header");
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
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label120;
      bool2 = false;
      localObject3 = localObject1;
      break label131;
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label196;
    }
    label326:
    return new AbookImportSubmitEvent((EventHeader)localObject2, abookImportTransactionId, (MobileHeader)localObject3, providerName, (UserRequestHeader)localObject1, bool1, hasAbookImportTransactionId, bool2, hasProviderName, bool3);
    label360:
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
      paramObject = (AbookImportSubmitEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (abookImportTransactionId != null)
      {
        if (abookImportTransactionId.equals(abookImportTransactionId)) {}
      }
      else {
        while (abookImportTransactionId != null) {
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
      if (providerName != null)
      {
        if (providerName.equals(providerName)) {}
      }
      else {
        while (providerName != null) {
          return false;
        }
      }
      if (requestHeader == null) {
        break;
      }
    } while (requestHeader.equals(requestHeader));
    for (;;)
    {
      return false;
      if (requestHeader == null) {
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
      if (abookImportTransactionId == null) {
        break label132;
      }
      j = abookImportTransactionId.hashCode();
      if (mobileHeader == null) {
        break label137;
      }
      k = mobileHeader.hashCode();
      label60:
      if (providerName == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = providerName.hashCode();; m = 0)
    {
      if (requestHeader != null) {
        n = requestHeader.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<AbookImportSubmitEvent>
  {
    public String abookImportTransactionId = null;
    public boolean hasAbookImportTransactionId = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasProviderName = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private ProviderName providerName = null;
    private UserRequestHeader requestHeader = null;
    
    private AbookImportSubmitEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (AbookImportSubmitEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new AbookImportSubmitEvent(header, abookImportTransactionId, mobileHeader, providerName, requestHeader, hasHeader, hasAbookImportTransactionId, hasMobileHeader, hasProviderName, hasRequestHeader);
      } while (hasHeader);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportSubmitEvent", "header");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportSubmitEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */