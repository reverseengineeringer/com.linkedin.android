package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ProfileViewEvent$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.ProfileViewEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */