package com.linkedin.android.growth.abi;

import com.linkedin.android.growth.heathrow.HeathrowSource;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.MemberContact;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection;
import java.util.List;

public final class AbiDataProvider$AbiState
  extends DataProvider.State
{
  PageContent abiLegoFlow;
  String abiLegoRoute;
  public String abiLegoToastRoute;
  String abiSource;
  public String abookImportTransactionId;
  public String connectionsRoute;
  ImportedContacts contacts;
  String contactsRoute;
  public MiniProfile contextualMiniProfile;
  public HeathrowSource heathrowSource;
  boolean isPastImportedContacts;
  String memberContactsFilteringRoute;
  boolean shouldHighlightRecentContacts;
  public CollectionTemplate<Connection, CollectionMetadata> socialProofConnections;
  public List<MemberContact> unblockedMemberContacts;
  
  public AbiDataProvider$AbiState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
  }
  
  public final PageContent abiLegoFlow()
  {
    if (abiLegoFlow != null) {
      return abiLegoFlow;
    }
    return (PageContent)getModel(abiLegoRoute);
  }
  
  public final ImportedContacts contacts()
  {
    Object localObject;
    if (contacts == null)
    {
      if (!isPastImportedContacts) {
        break label71;
      }
      localObject = (CollectionTemplate)getModel(contactsRoute);
      if (localObject != null) {
        break label42;
      }
      localObject = null;
    }
    for (;;)
    {
      contacts = ((ImportedContacts)localObject);
      return contacts;
      label42:
      if (elements == null)
      {
        localObject = null;
      }
      else
      {
        localObject = (ImportedContacts)elements.get(0);
        continue;
        label71:
        localObject = (ActionResponse)getModel(contactsRoute);
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = (ImportedContacts)value;
        }
      }
    }
  }
  
  public final CollectionTemplate<Connection, CollectionMetadata> getConnectionsCollection()
  {
    if (socialProofConnections == null) {
      socialProofConnections = ((CollectionTemplate)getModel(connectionsRoute));
    }
    return socialProofConnections;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiDataProvider.AbiState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */