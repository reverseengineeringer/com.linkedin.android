package com.linkedin.gen.avro2pegasus.events.abook;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class AbookImportImpressionEvent
  implements RecordTemplate<AbookImportImpressionEvent>
{
  public static final AbookImportImpressionEventBuilder BUILDER = AbookImportImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String abookImportTransactionId;
  public final String autoFilledEmail;
  public final AbookImportEmailProvider autoSelectedEmailProvider;
  public final boolean hasAbookImportTransactionId;
  public final boolean hasAutoFilledEmail;
  public final boolean hasAutoSelectedEmailProvider;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasOrderOfEmailProviderss;
  public final boolean hasRequestHeader;
  public final boolean hasSocialProofCount;
  public final boolean hasSocialProofType;
  public final boolean hasSource;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final List<AbookImportEmailProvider> orderOfEmailProviderss;
  public final UserRequestHeader requestHeader;
  public final int socialProofCount;
  public final String socialProofType;
  public final String source;
  
  AbookImportImpressionEvent(EventHeader paramEventHeader, String paramString1, UserRequestHeader paramUserRequestHeader, String paramString2, String paramString3, AbookImportEmailProvider paramAbookImportEmailProvider, List<AbookImportEmailProvider> paramList, String paramString4, int paramInt, MobileHeader paramMobileHeader, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    header = paramEventHeader;
    abookImportTransactionId = paramString1;
    requestHeader = paramUserRequestHeader;
    source = paramString2;
    autoFilledEmail = paramString3;
    autoSelectedEmailProvider = paramAbookImportEmailProvider;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      orderOfEmailProviderss = paramEventHeader;
      socialProofType = paramString4;
      socialProofCount = paramInt;
      mobileHeader = paramMobileHeader;
      hasHeader = paramBoolean1;
      hasAbookImportTransactionId = paramBoolean2;
      hasRequestHeader = paramBoolean3;
      hasSource = paramBoolean4;
      hasAutoFilledEmail = paramBoolean5;
      hasAutoSelectedEmailProvider = paramBoolean6;
      hasOrderOfEmailProviderss = paramBoolean7;
      hasSocialProofType = paramBoolean8;
      hasSocialProofCount = paramBoolean9;
      hasMobileHeader = paramBoolean10;
      _cachedId = null;
      return;
    }
  }
  
  private AbookImportImpressionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    boolean bool2;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label356;
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
      if (hasRequestHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("requestHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label365;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label121:
        if (localObject1 == null) {
          break label383;
        }
        bool2 = true;
      }
    }
    Object localObject4;
    boolean bool3;
    for (Object localObject3 = localObject1;; localObject3 = localObject1)
    {
      if (hasSource)
      {
        paramDataProcessor.startRecordField$505cff1c("source");
        paramDataProcessor.processString(source);
      }
      if (hasAutoFilledEmail)
      {
        paramDataProcessor.startRecordField$505cff1c("autoFilledEmail");
        paramDataProcessor.processString(autoFilledEmail);
      }
      if (hasAutoSelectedEmailProvider)
      {
        paramDataProcessor.startRecordField$505cff1c("autoSelectedEmailProvider");
        paramDataProcessor.processEnum(autoSelectedEmailProvider);
      }
      localObject4 = null;
      localObject1 = null;
      bool3 = false;
      if (!hasOrderOfEmailProviderss) {
        break label411;
      }
      paramDataProcessor.startRecordField$505cff1c("orderOfEmailProviderss");
      orderOfEmailProviderss.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localObject4 = orderOfEmailProviderss.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        AbookImportEmailProvider localAbookImportEmailProvider = (AbookImportEmailProvider)((Iterator)localObject4).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processEnum(localAbookImportEmailProvider);
        if (localObject1 != null) {
          ((List)localObject1).add(localAbookImportEmailProvider);
        }
        i += 1;
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      label356:
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      label365:
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label121;
      label383:
      bool2 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool3 = true;
      localObject4 = localObject1;
      label411:
      if (hasSocialProofType)
      {
        paramDataProcessor.startRecordField$505cff1c("socialProofType");
        paramDataProcessor.processString(socialProofType);
      }
      if (hasSocialProofCount)
      {
        paramDataProcessor.startRecordField$505cff1c("socialProofCount");
        paramDataProcessor.processInt(socialProofCount);
      }
      localObject1 = null;
      bool4 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label563;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label501:
        if (localObject1 == null) {
          break label581;
        }
      }
    }
    label563:
    label581:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label803;
      }
      try
      {
        if (hasHeader) {
          break label587;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool3 = false;
      localObject4 = localObject1;
      break;
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label501;
    }
    label587:
    if (!hasAbookImportTransactionId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "abookImportTransactionId");
    }
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "requestHeader");
    }
    if (!hasAutoSelectedEmailProvider) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "autoSelectedEmailProvider");
    }
    if (!hasOrderOfEmailProviderss) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "orderOfEmailProviderss");
    }
    if (!hasSocialProofCount) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "socialProofCount");
    }
    if (orderOfEmailProviderss != null)
    {
      paramDataProcessor = orderOfEmailProviderss.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((AbookImportEmailProvider)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "orderOfEmailProviderss");
        }
      }
    }
    return new AbookImportImpressionEvent((EventHeader)localObject2, abookImportTransactionId, (UserRequestHeader)localObject3, source, autoFilledEmail, autoSelectedEmailProvider, (List)localObject4, socialProofType, socialProofCount, (MobileHeader)localObject1, bool1, hasAbookImportTransactionId, bool2, hasSource, hasAutoFilledEmail, hasAutoSelectedEmailProvider, bool3, hasSocialProofType, hasSocialProofCount, bool4);
    label803:
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
      paramObject = (AbookImportImpressionEvent)paramObject;
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
      if (requestHeader != null)
      {
        if (requestHeader.equals(requestHeader)) {}
      }
      else {
        while (requestHeader != null) {
          return false;
        }
      }
      if (source != null)
      {
        if (source.equals(source)) {}
      }
      else {
        while (source != null) {
          return false;
        }
      }
      if (autoFilledEmail != null)
      {
        if (autoFilledEmail.equals(autoFilledEmail)) {}
      }
      else {
        while (autoFilledEmail != null) {
          return false;
        }
      }
      if (autoSelectedEmailProvider != null)
      {
        if (autoSelectedEmailProvider.equals(autoSelectedEmailProvider)) {}
      }
      else {
        while (autoSelectedEmailProvider != null) {
          return false;
        }
      }
      if (orderOfEmailProviderss != null)
      {
        if (orderOfEmailProviderss.equals(orderOfEmailProviderss)) {}
      }
      else {
        while (orderOfEmailProviderss != null) {
          return false;
        }
      }
      if (socialProofType != null)
      {
        if (socialProofType.equals(socialProofType)) {}
      }
      else {
        while (socialProofType != null) {
          return false;
        }
      }
      if (socialProofCount != socialProofCount) {
        return false;
      }
      if (mobileHeader == null) {
        break;
      }
    } while (mobileHeader.equals(mobileHeader));
    for (;;)
    {
      return false;
      if (mobileHeader == null) {
        break;
      }
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
    if (header != null)
    {
      i = header.hashCode();
      if (abookImportTransactionId == null) {
        break label234;
      }
      j = abookImportTransactionId.hashCode();
      if (requestHeader == null) {
        break label239;
      }
      k = requestHeader.hashCode();
      if (source == null) {
        break label244;
      }
      m = source.hashCode();
      if (autoFilledEmail == null) {
        break label250;
      }
      n = autoFilledEmail.hashCode();
      if (autoSelectedEmailProvider == null) {
        break label256;
      }
      i1 = autoSelectedEmailProvider.hashCode();
      if (orderOfEmailProviderss == null) {
        break label262;
      }
      i2 = orderOfEmailProviderss.hashCode();
      label126:
      if (socialProofType == null) {
        break label268;
      }
    }
    label234:
    label239:
    label244:
    label250:
    label256:
    label262:
    label268:
    for (int i3 = socialProofType.hashCode();; i3 = 0)
    {
      int i5 = socialProofCount;
      if (mobileHeader != null) {
        i4 = mobileHeader.hashCode();
      }
      i = ((i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i5) * 31 + i4;
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
      break label126;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<AbookImportImpressionEvent>
  {
    public String abookImportTransactionId = null;
    private String autoFilledEmail = null;
    public AbookImportEmailProvider autoSelectedEmailProvider = null;
    public boolean hasAbookImportTransactionId = false;
    private boolean hasAutoFilledEmail = false;
    public boolean hasAutoSelectedEmailProvider = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasOrderOfEmailProviderss = false;
    private boolean hasRequestHeader = false;
    public boolean hasSocialProofCount = false;
    private boolean hasSocialProofType = false;
    public boolean hasSource = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public List<AbookImportEmailProvider> orderOfEmailProviderss = null;
    private UserRequestHeader requestHeader = null;
    public int socialProofCount = 0;
    private String socialProofType = null;
    public String source = null;
    
    private AbookImportImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (AbookImportImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (orderOfEmailProviderss != null)
      {
        paramFlavor = orderOfEmailProviderss.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((AbookImportEmailProvider)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "orderOfEmailProviderss");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "header");
              }
              if (!hasAbookImportTransactionId) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "abookImportTransactionId");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "requestHeader");
              }
              if (!hasAutoSelectedEmailProvider) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "autoSelectedEmailProvider");
              }
              if (!hasOrderOfEmailProviderss) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "orderOfEmailProviderss");
              }
              if (hasSocialProofCount) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent", "socialProofCount");
            }
          }
        }
      }
      return new AbookImportImpressionEvent(header, abookImportTransactionId, requestHeader, source, autoFilledEmail, autoSelectedEmailProvider, orderOfEmailProviderss, socialProofType, socialProofCount, mobileHeader, hasHeader, hasAbookImportTransactionId, hasRequestHeader, hasSource, hasAutoFilledEmail, hasAutoSelectedEmailProvider, hasOrderOfEmailProviderss, hasSocialProofType, hasSocialProofCount, hasMobileHeader);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */