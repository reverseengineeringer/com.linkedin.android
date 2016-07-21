package com.linkedin.gen.avro2pegasus.events.invitations;

import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class InvitationTrackingInfoBuilder
  implements DataTemplateBuilder<InvitationTrackingInfo>
{
  public static final InvitationTrackingInfoBuilder INSTANCE = new InvitationTrackingInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("invitationTrackingId");
    JSON_KEY_STORE.put("recipientUrn");
  }
  
  public static InvitationTrackingInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    String str = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("invitationTrackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = BytesCoercer.INSTANCE;
        localObject = BytesCoercer.coerceToCustomType(paramDataReader.readBytes());
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("recipientUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: invitationTrackingId when building com.linkedin.gen.avro2pegasus.events.invitations.InvitationTrackingInfo");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: recipientUrn when building com.linkedin.gen.avro2pegasus.events.invitations.InvitationTrackingInfo");
    }
    return new InvitationTrackingInfo((String)localObject, str, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.invitations.InvitationTrackingInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */