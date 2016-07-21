package com.linkedin.gen.avro2pegasus.events.abook;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class AbookImportInvitationImpressionDiscardEventBuilder
  implements DataTemplateBuilder<AbookImportInvitationImpressionDiscardEvent>
{
  public static final AbookImportInvitationImpressionDiscardEventBuilder INSTANCE = new AbookImportInvitationImpressionDiscardEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("abookImportTransactionId");
    JSON_KEY_STORE.put("abookImportInvitationDiscardReason");
  }
  
  public static final class AbookImportInvitationDiscardReasonBuilder
    implements DataTemplateBuilder<AbookImportInvitationImpressionDiscardEvent.AbookImportInvitationDiscardReason>
  {
    public static final AbookImportInvitationDiscardReasonBuilder INSTANCE = new AbookImportInvitationDiscardReasonBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.avro2pegasus.events.abook.AbookImportInvitationDiscardReason");
    }
    
    public static AbookImportInvitationImpressionDiscardEvent.AbookImportInvitationDiscardReason build(DataReader paramDataReader)
      throws DataReaderException
    {
      AbookImportInvitationDiscardReason localAbookImportInvitationDiscardReason = null;
      boolean bool = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.avro2pegasus.events.abook.AbookImportInvitationDiscardReason", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localAbookImportInvitationDiscardReason = (AbookImportInvitationDiscardReason)paramDataReader.readEnum(AbookImportInvitationDiscardReason.Builder.INSTANCE);
          bool = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      return new AbookImportInvitationImpressionDiscardEvent.AbookImportInvitationDiscardReason(localAbookImportInvitationDiscardReason, bool);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionDiscardEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */