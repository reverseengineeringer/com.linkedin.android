package com.linkedin.android.growth.abi;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.abi.m2m.events.MainAbiM2MResultsRefreshEvent;
import com.linkedin.android.growth.heathrow.HeathrowSource;
import com.linkedin.android.growth.utils.GrowthLixHelper;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.growth.utils.TelephonyUtils;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponseBuilder;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.ContactsOrder;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact.Handle;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.MemberContact;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.MiniProfileUrns;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.MiniProfileUrns.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeEmail.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteePhone.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.abook.InvitationSentTo;
import com.linkedin.xmsg.util.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AbiDataProvider
  extends DataProvider<AbiState, DataProvider.DataProviderListener>
{
  Set<String> invitedGuests;
  Set<String> invitedMembers;
  
  @Inject
  public AbiDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  private static MiniProfileUrns buildMiniProfileUrnsForContactFilteringRequest(List<MemberContact> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(nextminiProfile.entityUrn);
    }
    try
    {
      paramList = new MiniProfileUrns.Builder();
      if (localArrayList.equals(Collections.emptyList())) {
        hasMiniProfileUrns = false;
      }
      for (miniProfileUrns = Collections.emptyList();; miniProfileUrns = localArrayList)
      {
        return paramList.build(RecordTemplate.Flavor.RECORD);
        hasMiniProfileUrns = true;
      }
      return null;
    }
    catch (BuilderException paramList)
    {
      CrashReporter.reportNonFatal(new Throwable("Error when building MiniProfileUrns for ContactsFiltering request", paramList));
    }
  }
  
  private static NormInvitation buildNormInvitationFromEmail(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new InviteeEmail.Builder().setEmail(paramString1).build(RecordTemplate.Flavor.RECORD);
      paramString1 = new NormInvitation.Invitee.Builder().setInviteeEmailValue(paramString1).build();
      paramString1 = new NormInvitation.Builder().setInvitee(paramString1).setTrackingId(paramString2).build(RecordTemplate.Flavor.RECORD);
      return paramString1;
    }
    catch (BuilderException paramString1)
    {
      Util.safeThrow(new IllegalArgumentException("Validation failed"));
    }
    return null;
  }
  
  private static NormInvitation buildNormInvitationFromPhoneNumber(PhoneNumber paramPhoneNumber, String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        paramPhoneNumber = new InviteePhone.Builder().setPhoneNumber(paramPhoneNumber);
        if (paramString1 == null)
        {
          hasFirstName = false;
          firstName = null;
          if (paramString2 == null)
          {
            hasLastName = false;
            lastName = null;
            paramPhoneNumber = paramPhoneNumber.build(RecordTemplate.Flavor.RECORD);
            paramPhoneNumber = new NormInvitation.Invitee.Builder().setInviteePhoneValue(paramPhoneNumber).build();
            return new NormInvitation.Builder().setInvitee(paramPhoneNumber).setTrackingId(paramString3).build(RecordTemplate.Flavor.RECORD);
          }
        }
        else
        {
          hasFirstName = true;
          firstName = paramString1;
          continue;
        }
        hasLastName = true;
      }
      catch (BuilderException paramPhoneNumber)
      {
        Util.safeThrow(new IllegalArgumentException("Validation failed"));
        return null;
      }
      lastName = paramString2;
    }
  }
  
  private static NormInvitation buildNormInvitationFromProfileId(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new InviteeProfile.Builder().setProfileId(paramString1).build(RecordTemplate.Flavor.RECORD);
      paramString1 = new NormInvitation.Invitee.Builder().setInviteeProfileValue(paramString1).build();
      paramString1 = new NormInvitation.Builder().setInvitee(paramString1).setTrackingId(paramString2).build(RecordTemplate.Flavor.RECORD);
      return paramString1;
    }
    catch (BuilderException paramString1)
    {
      Util.safeThrow(new IllegalArgumentException("Validation failed"));
    }
    return null;
  }
  
  static String buildUploadContactsRoute$1afe14f3()
  {
    return Routes.CONTACTS.buildUponRoot().buildUpon().appendQueryParameter("action", "uploadContacts").build().toString();
  }
  
  static List<MemberContact> filterByUnblockedMembers(MiniProfileUrns paramMiniProfileUrns, List<MemberContact> paramList)
  {
    if (paramMiniProfileUrns == null) {}
    ArrayList localArrayList;
    do
    {
      return paramList;
      localArrayList = new ArrayList(miniProfileUrns.size());
      if (CollectionUtils.isEmpty(miniProfileUrns)) {
        break;
      }
    } while (miniProfileUrns.size() == localArrayList.size());
    paramMiniProfileUrns = new HashSet(miniProfileUrns);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MemberContact localMemberContact = (MemberContact)paramList.next();
      if (paramMiniProfileUrns.contains(miniProfile.entityUrn)) {
        localArrayList.add(localMemberContact);
      }
    }
    return localArrayList;
  }
  
  public static List<GuestContact> getEmailContacts(List<GuestContact> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = Util.safeGet(paramList).iterator();
    while (paramList.hasNext())
    {
      GuestContact localGuestContact = (GuestContact)paramList.next();
      if (!TextUtils.isEmpty(handle.stringValue)) {
        localArrayList.add(localGuestContact);
      }
    }
    return localArrayList;
  }
  
  private static String getGuestHandleUniqueIdentifier(GuestContact.Handle paramHandle)
  {
    if (!TextUtils.isEmpty(stringValue)) {
      return stringValue;
    }
    if (phoneNumberValue != null)
    {
      if (phoneNumberValue.hasExtension) {
        return phoneNumberValue.number + "_ext_" + phoneNumberValue.extension;
      }
      return phoneNumberValue.number;
    }
    return null;
  }
  
  static String getMemberUniqueIdentifier(MemberContact paramMemberContact)
  {
    return miniProfile.entityUrn.getId();
  }
  
  public static List<GuestContact> getSmsContacts(List<GuestContact> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = Util.safeGet(paramList).iterator();
    while (paramList.hasNext())
    {
      GuestContact localGuestContact = (GuestContact)paramList.next();
      if (handle.phoneNumberValue != null) {
        localArrayList.add(localGuestContact);
      }
    }
    return localArrayList;
  }
  
  private void sendInvitations$4e5e07f4(String paramString1, JSONArray paramJSONArray, Map<String, String> paramMap, String paramString2)
    throws JSONException
  {
    String str = Routes.NORM_INVITATIONS.buildUponRoot().buildUpon().appendQueryParameter("action", "batchCreate").build().toString();
    paramJSONArray = new JSONObject().put("invitations", paramJSONArray);
    if (paramString1 != null) {
      paramJSONArray.put("defaultCountryCode", paramString1);
    }
    if (paramString2 != null) {
      paramJSONArray.put("uploadTransactionId", paramString2);
    }
    activityComponent.dataManager().submit(Request.post().url(str).model(new JsonModel(paramJSONArray)).listener(null).filter(DataManager.DataStoreFilter.NETWORK_ONLY).customHeaders(paramMap));
  }
  
  public final void batchSendGuestInvitations$5b775b21(Context paramContext, List<GuestContact> paramList, Map<String, String> paramMap, String paramString)
  {
    String str1 = TelephonyUtils.getCountryCode(paramContext);
    for (;;)
    {
      JSONArray localJSONArray;
      PhoneNumber localPhoneNumber;
      String str3;
      try
      {
        localJSONArray = new JSONArray();
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break label161;
        }
        paramContext = (GuestContact)localIterator.next();
        invitedGuests.add(getGuestHandleUniqueIdentifier(handle));
        if (paramContext == null) {
          break label313;
        }
        String str2 = handle.stringValue;
        localPhoneNumber = handle.phoneNumberValue;
        str3 = trackingId;
        if (!TextUtils.isEmpty(str2))
        {
          paramContext = buildNormInvitationFromEmail(str2, str3);
          if (paramContext == null) {
            continue;
          }
          localJSONArray.put(PegasusPatchGenerator.modelToJSON(paramContext));
          continue;
        }
        if (localPhoneNumber == null) {
          break label313;
        }
      }
      catch (JSONException paramContext)
      {
        Util.safeThrow(new IllegalStateException("Json error"));
        return;
      }
      paramContext = buildNormInvitationFromPhoneNumber(localPhoneNumber, firstName, lastName, str3);
      continue;
      label161:
      sendInvitations$4e5e07f4(str1, localJSONArray, paramMap, paramString);
      if (!"control".equals(activityComponent.lixManager().getTreatment(Lix.LIX_ABOOK_IMPORT_INVITATION_CREATE_EVENT)))
      {
        int i = getEmailContacts(paramList).size();
        int j = getSmsContacts(paramList).size();
        paramContext = OwlTrackingUtils.getAbookImportInvitationCreateEventBuilder(paramString, state).abookImportTransactionId, InvitationSentTo.GUEST, i + j, activityComponent.lixManager());
        paramList = activityComponent.tracker();
        paramMap = OwlTrackingUtils.buildInvitationCountPerChannel(activityComponent.lixManager(), i, j);
        if (paramMap == null) {
          hasInvitationCounts = false;
        }
        for (invitationCounts = null;; invitationCounts = paramMap)
        {
          paramList.send(paramContext);
          return;
          hasInvitationCounts = true;
        }
        label313:
        paramContext = null;
      }
    }
  }
  
  public final void batchSendMemberInvitations$235b8adf(List<MemberContact> paramList, Map<String, String> paramMap, String paramString)
  {
    do
    {
      JSONArray localJSONArray;
      for (;;)
      {
        try
        {
          localJSONArray = new JSONArray();
          Iterator localIterator = paramList.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject2 = (MemberContact)localIterator.next();
          invitedMembers.add(getMemberUniqueIdentifier((MemberContact)localObject2));
          if (localObject2 != null)
          {
            localObject1 = trackingId;
            localObject2 = miniProfile.entityUrn.getId();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = buildNormInvitationFromProfileId((String)localObject2, (String)localObject1);
              if (localObject1 == null) {
                continue;
              }
              localJSONArray.put(PegasusPatchGenerator.modelToJSON((RecordTemplate)localObject1));
              continue;
            }
          }
          Object localObject1 = null;
        }
        catch (JSONException paramList)
        {
          Util.safeThrow(new IllegalStateException("Json error"));
          return;
        }
      }
      sendInvitations$4e5e07f4(null, localJSONArray, paramMap, paramString);
    } while ("control".equals(activityComponent.lixManager().getTreatment(Lix.LIX_ABOOK_IMPORT_INVITATION_CREATE_EVENT)));
    activityComponent.tracker().send(OwlTrackingUtils.getAbookImportInvitationCreateEventBuilder(paramString, state).abookImportTransactionId, InvitationSentTo.MEMBER, paramList.size(), activityComponent.lixManager()));
  }
  
  public final MultiplexRequest.Builder buildMuxRequestForPastImportedContactsAndItsLegoFlow(Context paramContext, DataManager.DataStoreFilter paramDataStoreFilter)
  {
    initializeInvitedContacts();
    state).isPastImportedContacts = true;
    state).abiLegoRoute = Routes.ABI_PAST_IMPORTED_CONTACTS_FLOW.buildUponRoot().buildUpon().toString();
    state).contactsRoute = buildPastImportedContactsRoute(paramContext, state).abookImportTransactionId);
    paramContext = Request.get().url(state).contactsRoute).builder(CollectionTemplate.of(ImportedContacts.BUILDER)).cacheKey("abiPastImportedContactsCacheKey");
    Request.Builder localBuilder = Request.get().url(state).abiLegoRoute).builder(PageContent.BUILDER);
    MultiplexRequest.Builder localBuilder1 = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    paramDataStoreFilter = localBuilder1.filter(paramDataStoreFilter);
    timeout = 20000;
    return paramDataStoreFilter.required(paramContext).required(localBuilder);
  }
  
  final String buildPastImportedContactsRoute(Context paramContext, String paramString)
  {
    paramContext = Routes.CONTACTS.buildUponRoot().buildUpon().appendQueryParameter("q", "viewer").appendQueryParameter("deviceCountryCode", TelephonyUtils.getCountryCode(paramContext));
    if (StringUtils.isNotBlank(paramString)) {
      paramContext.appendQueryParameter("uploadTransactionId", paramString);
    }
    if (state).shouldHighlightRecentContacts) {
      paramContext.appendQueryParameter("orderBy", ContactsOrder.RECENT_N_FIRST.name());
    }
    return paramContext.build().toString();
  }
  
  public final void fetchAndFilterByUnblockedMemberContacts(boolean paramBoolean)
  {
    if ((hasMemberContact()) && (paramBoolean))
    {
      state).memberContactsFilteringRoute = Routes.ABI_CONTACTS_FILTERING.buildUponRoot().buildUpon().appendQueryParameter("action", "filterMemberContacts").build().toString();
      Object localObject = new RecordTemplateListener()
      {
        public final void onResponse(DataStoreResponse<ActionResponse<MiniProfileUrns>> paramAnonymousDataStoreResponse)
        {
          if ((paramAnonymousDataStoreResponse != null) && (error == null) && (model != null))
          {
            state).unblockedMemberContacts = AbiDataProvider.filterByUnblockedMembers((MiniProfileUrns)model).value, state).contacts.memberContacts);
            if (state).unblockedMemberContacts.size() == Util.safeGet(state).contacts.memberContacts).size()) {
              return;
            }
            activityComponent.eventBus();
            Bus.publish(new MainAbiM2MResultsRefreshEvent());
            return;
          }
          CrashReporter.reportNonFatal(new Throwable("Error fetching m2m blocking from server"));
        }
      };
      localObject = Request.post().url(state).memberContactsFilteringRoute).builder(new ActionResponseBuilder(MiniProfileUrns.BUILDER)).filter(DataManager.DataStoreFilter.NETWORK_ONLY).model(buildMiniProfileUrnsForContactFilteringRequest(state).contacts.memberContacts)).listener((RecordTemplateListener)localObject);
      activityComponent.dataManager().submit((Request.Builder)localObject);
    }
  }
  
  public final void fetchPastImportedContactsAndItsLegoFlow(Context paramContext, DataManager.DataStoreFilter paramDataStoreFilter, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    performMultiplexedFetch(paramString1, paramString2, paramMap, buildMuxRequestForPastImportedContactsAndItsLegoFlow(paramContext, paramDataStoreFilter));
  }
  
  protected final DataManager.DataStoreFilter getDataStoreFilterTypeForFetchingPastImportedContactsAndItsLegoFlow(LixManager paramLixManager)
  {
    if ("mobile-voyager-takeover-resultsLanding".equalsIgnoreCase(state).abiSource)) {
      return DataManager.DataStoreFilter.LOCAL_ONLY;
    }
    if ("enabled".equalsIgnoreCase(paramLixManager.getTreatment(Lix.GROWTH_ABI_INSTANT_RESULTS)))
    {
      paramLixManager = activityComponent.abiCacheUtils();
      int i;
      if (!"control".equalsIgnoreCase(lixManager.getTreatment(Lix.GROWTH_ABI_PAST_IMPORTED_CONTACTS_RESULTS_CACHE_EXPIRATION_DAYS)))
      {
        long l1 = System.currentTimeMillis();
        long l2 = flagshipSharedPreferences.getPreferences().getLong("lastAbiPastImportedContactsResultsCacheUpdatedTimestamp", 0L);
        i = GrowthLixHelper.parseInt(lixManager, Lix.GROWTH_ABI_PAST_IMPORTED_CONTACTS_RESULTS_CACHE_EXPIRATION_DAYS, 21, "value_");
        if (l1 - l2 >= TimeUnit.DAYS.toMillis(i)) {
          i = 1;
        }
      }
      while ((i == 0) && (!state).shouldHighlightRecentContacts))
      {
        return DataManager.DataStoreFilter.ALL;
        i = 0;
        continue;
        i = 0;
      }
      return DataManager.DataStoreFilter.NETWORK_ONLY;
    }
    return DataManager.DataStoreFilter.NETWORK_ONLY;
  }
  
  public final boolean hasEmailGuestContact()
  {
    if (!isContactsDataAvailable()) {
      return false;
    }
    Object localObject = Util.safeGet(state).contacts().guestContacts);
    if (((List)localObject).isEmpty()) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (nexthandle.stringValue != null) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean hasGuestContact()
  {
    return (isContactsDataAvailable()) && (!Util.safeGet(state).contacts().guestContacts).isEmpty());
  }
  
  public final boolean hasMemberContact()
  {
    return (isContactsDataAvailable()) && (!Util.safeGet(state).contacts().memberContacts).isEmpty());
  }
  
  public final boolean hasPhoneGuestContact()
  {
    if (!isContactsDataAvailable()) {
      return false;
    }
    Object localObject = Util.safeGet(state).contacts().guestContacts);
    if (((List)localObject).isEmpty()) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (nexthandle.phoneNumberValue != null) {
        return true;
      }
    }
    return false;
  }
  
  final void initializeInvitedContacts()
  {
    if (invitedGuests == null)
    {
      localObject = new HashSet();
      invitedGuests = ((Set)localObject);
      if (invitedMembers != null) {
        break label49;
      }
    }
    label49:
    for (Object localObject = new HashSet();; localObject = invitedMembers)
    {
      invitedMembers = ((Set)localObject);
      return;
      localObject = invitedGuests;
      break;
    }
  }
  
  public final boolean isContactsDataAvailable()
  {
    return ((AbiState)state).contacts() != null;
  }
  
  public final boolean isGuestContactInvited(GuestContact paramGuestContact)
  {
    return (paramGuestContact != null) && (invitedGuests.contains(getGuestHandleUniqueIdentifier(handle)));
  }
  
  public final boolean isLegoDataAvailable()
  {
    return (state).abiLegoRoute != null) && (((AbiState)state).abiLegoFlow() != null);
  }
  
  public final void sendGuestInvitation$6dab7f4f(Context paramContext, GuestContact paramGuestContact, Map<String, String> paramMap, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramGuestContact);
    batchSendGuestInvitations$5b775b21(paramContext, localArrayList, paramMap, paramString);
  }
  
  public final void sendMemberInvitation$38148e3b(MemberContact paramMemberContact, Map<String, String> paramMap, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMemberContact);
    batchSendMemberInvitations$235b8adf(localArrayList, paramMap, paramString);
  }
  
  public static final class AbiState
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
    
    public AbiState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */