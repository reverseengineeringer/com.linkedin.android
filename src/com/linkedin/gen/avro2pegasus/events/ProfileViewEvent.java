package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ProfileViewEvent
  implements RecordTemplate<ProfileViewEvent>
{
  public static final ProfileViewEventBuilder BUILDER = ProfileViewEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String authToken;
  public final String authType;
  public final int contractId;
  public final EntityView entityView;
  public final boolean hasAuthToken;
  public final boolean hasAuthType;
  public final boolean hasContractId;
  public final boolean hasEntityView;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasNetworkDistance;
  public final boolean hasProfileTrackingId;
  public final boolean hasRequestHeader;
  public final boolean hasSource;
  public final boolean hasVieweeMemberUrn;
  public final boolean hasVieweePrivacySetting;
  public final boolean hasViewerPrivacySetting;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final int networkDistance;
  public final String profileTrackingId;
  public final UserRequestHeader requestHeader;
  public final String source;
  public final String vieweeMemberUrn;
  public final String vieweePrivacySetting;
  public final String viewerPrivacySetting;
  
  ProfileViewEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, EntityView paramEntityView, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, MobileHeader paramMobileHeader, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    entityView = paramEntityView;
    viewerPrivacySetting = paramString1;
    vieweePrivacySetting = paramString2;
    source = paramString3;
    contractId = paramInt1;
    networkDistance = paramInt2;
    authType = paramString4;
    authToken = paramString5;
    mobileHeader = paramMobileHeader;
    vieweeMemberUrn = paramString6;
    profileTrackingId = paramString7;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasEntityView = paramBoolean3;
    hasViewerPrivacySetting = paramBoolean4;
    hasVieweePrivacySetting = paramBoolean5;
    hasSource = paramBoolean6;
    hasContractId = paramBoolean7;
    hasNetworkDistance = paramBoolean8;
    hasAuthType = paramBoolean9;
    hasAuthToken = paramBoolean10;
    hasMobileHeader = paramBoolean11;
    hasVieweeMemberUrn = paramBoolean12;
    hasProfileTrackingId = paramBoolean13;
    _cachedId = null;
  }
  
  private ProfileViewEvent accept(DataProcessor paramDataProcessor)
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
          break label501;
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
          break label510;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label528;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasEntityView)
      {
        paramDataProcessor.startRecordField$505cff1c("entityView");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label537;
        }
        localObject1 = entityView.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label555;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      if (hasViewerPrivacySetting)
      {
        paramDataProcessor.startRecordField$505cff1c("viewerPrivacySetting");
        paramDataProcessor.processString(viewerPrivacySetting);
      }
      if (hasVieweePrivacySetting)
      {
        paramDataProcessor.startRecordField$505cff1c("vieweePrivacySetting");
        paramDataProcessor.processString(vieweePrivacySetting);
      }
      if (hasSource)
      {
        paramDataProcessor.startRecordField$505cff1c("source");
        paramDataProcessor.processString(source);
      }
      if (hasContractId)
      {
        paramDataProcessor.startRecordField$505cff1c("contractId");
        paramDataProcessor.processInt(contractId);
      }
      if (hasNetworkDistance)
      {
        paramDataProcessor.startRecordField$505cff1c("networkDistance");
        paramDataProcessor.processInt(networkDistance);
      }
      if (hasAuthType)
      {
        paramDataProcessor.startRecordField$505cff1c("authType");
        paramDataProcessor.processString(authType);
      }
      if (hasAuthToken)
      {
        paramDataProcessor.startRecordField$505cff1c("authToken");
        paramDataProcessor.processString(authToken);
      }
      localObject1 = null;
      bool4 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label565;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label373:
        if (localObject1 == null) {
          break label583;
        }
      }
    }
    label501:
    label510:
    label528:
    label537:
    label555:
    label565:
    label583:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasVieweeMemberUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("vieweeMemberUrn");
        paramDataProcessor.processString(vieweeMemberUrn);
      }
      if (hasProfileTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("profileTrackingId");
        BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(profileTrackingId));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label721;
      }
      try
      {
        if (hasHeader) {
          break label589;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.ProfileViewEvent", "header");
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
      localObject1 = (EntityView)paramDataProcessor.processDataTemplate(entityView);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label373;
    }
    label589:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.ProfileViewEvent", "requestHeader");
    }
    if (!hasEntityView) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.ProfileViewEvent", "entityView");
    }
    return new ProfileViewEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (EntityView)localObject4, viewerPrivacySetting, vieweePrivacySetting, source, contractId, networkDistance, authType, authToken, (MobileHeader)localObject1, vieweeMemberUrn, profileTrackingId, bool1, bool2, bool3, hasViewerPrivacySetting, hasVieweePrivacySetting, hasSource, hasContractId, hasNetworkDistance, hasAuthType, hasAuthToken, bool4, hasVieweeMemberUrn, hasProfileTrackingId);
    label721:
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
      paramObject = (ProfileViewEvent)paramObject;
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
      if (entityView != null)
      {
        if (entityView.equals(entityView)) {}
      }
      else {
        while (entityView != null) {
          return false;
        }
      }
      if (viewerPrivacySetting != null)
      {
        if (viewerPrivacySetting.equals(viewerPrivacySetting)) {}
      }
      else {
        while (viewerPrivacySetting != null) {
          return false;
        }
      }
      if (vieweePrivacySetting != null)
      {
        if (vieweePrivacySetting.equals(vieweePrivacySetting)) {}
      }
      else {
        while (vieweePrivacySetting != null) {
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
      if (contractId != contractId) {
        return false;
      }
      if (networkDistance != networkDistance) {
        return false;
      }
      if (authType != null)
      {
        if (authType.equals(authType)) {}
      }
      else {
        while (authType != null) {
          return false;
        }
      }
      if (authToken != null)
      {
        if (authToken.equals(authToken)) {}
      }
      else {
        while (authToken != null) {
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
      if (vieweeMemberUrn != null)
      {
        if (vieweeMemberUrn.equals(vieweeMemberUrn)) {}
      }
      else {
        while (vieweeMemberUrn != null) {
          return false;
        }
      }
      if (profileTrackingId == null) {
        break;
      }
    } while (profileTrackingId.equals(profileTrackingId));
    for (;;)
    {
      return false;
      if (profileTrackingId == null) {
        break;
      }
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
    int i7;
    int i8;
    int i2;
    label136:
    int i3;
    label152:
    int i4;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label288;
      }
      j = requestHeader.hashCode();
      if (entityView == null) {
        break label293;
      }
      k = entityView.hashCode();
      if (viewerPrivacySetting == null) {
        break label298;
      }
      m = viewerPrivacySetting.hashCode();
      if (vieweePrivacySetting == null) {
        break label304;
      }
      n = vieweePrivacySetting.hashCode();
      if (source == null) {
        break label310;
      }
      i1 = source.hashCode();
      i7 = contractId;
      i8 = networkDistance;
      if (authType == null) {
        break label316;
      }
      i2 = authType.hashCode();
      if (authToken == null) {
        break label322;
      }
      i3 = authToken.hashCode();
      if (mobileHeader == null) {
        break label328;
      }
      i4 = mobileHeader.hashCode();
      label168:
      if (vieweeMemberUrn == null) {
        break label334;
      }
    }
    label288:
    label293:
    label298:
    label304:
    label310:
    label316:
    label322:
    label328:
    label334:
    for (int i5 = vieweeMemberUrn.hashCode();; i5 = 0)
    {
      if (profileTrackingId != null) {
        i6 = profileTrackingId.hashCode();
      }
      i = (i5 + (i4 + (i3 + (i2 + (((i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i7) * 31 + i8) * 31) * 31) * 31) * 31) * 31 + i6;
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
      break label136;
      i3 = 0;
      break label152;
      i4 = 0;
      break label168;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<ProfileViewEvent>
  {
    private String authToken = null;
    private String authType = null;
    private int contractId = 0;
    public EntityView entityView = null;
    private boolean hasAuthToken = false;
    private boolean hasAuthType = false;
    private boolean hasContractId = false;
    public boolean hasEntityView = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasNetworkDistance = false;
    private boolean hasProfileTrackingId = false;
    private boolean hasRequestHeader = false;
    private boolean hasSource = false;
    public boolean hasVieweeMemberUrn = false;
    private boolean hasVieweePrivacySetting = false;
    public boolean hasViewerPrivacySetting = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public int networkDistance = 0;
    private String profileTrackingId = null;
    private UserRequestHeader requestHeader = null;
    private String source = null;
    public String vieweeMemberUrn = null;
    private String vieweePrivacySetting = null;
    public String viewerPrivacySetting = null;
    
    private ProfileViewEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ProfileViewEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new ProfileViewEvent(header, requestHeader, entityView, viewerPrivacySetting, vieweePrivacySetting, source, contractId, networkDistance, authType, authToken, mobileHeader, vieweeMemberUrn, profileTrackingId, hasHeader, hasRequestHeader, hasEntityView, hasViewerPrivacySetting, hasVieweePrivacySetting, hasSource, hasContractId, hasNetworkDistance, hasAuthType, hasAuthToken, hasMobileHeader, hasVieweeMemberUrn, hasProfileTrackingId);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.ProfileViewEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.ProfileViewEvent", "requestHeader");
        }
      } while (hasEntityView);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.ProfileViewEvent", "entityView");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.ProfileViewEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */