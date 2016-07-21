package com.linkedin.messengerlib.ui.participantdetails;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate.Builder;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.messengerlib.MessengerLixManager;
import com.linkedin.messengerlib.R.id;
import com.linkedin.messengerlib.R.layout;
import com.linkedin.messengerlib.R.string;
import com.linkedin.messengerlib.consumers.ActorDataManager;
import com.linkedin.messengerlib.consumers.ActorDataManager.ParticipantChangeEventType;
import com.linkedin.messengerlib.consumers.DataManager;
import com.linkedin.messengerlib.consumers.EventsDataManager;
import com.linkedin.messengerlib.database.MessengerProvider;
import com.linkedin.messengerlib.me.MeFetcher.Callback;
import com.linkedin.messengerlib.shared.BaseFragment;
import com.linkedin.messengerlib.shared.FragmentComponent;
import com.linkedin.messengerlib.shared.MessengerRecyclerView;
import com.linkedin.messengerlib.tracking.ImpressionUtil;
import com.linkedin.messengerlib.ui.PeopleSearchCompletionView;
import com.linkedin.messengerlib.ui.compose.PeopleResultsListAdapter;
import com.linkedin.messengerlib.utils.EventCreateBuilderUtil;
import com.linkedin.messengerlib.utils.I18NManager;
import com.linkedin.messengerlib.utils.MessageSenderUtil;
import com.linkedin.messengerlib.utils.NameFormatter;
import com.linkedin.messengerlib.utils.PendingRemoteId;
import com.linkedin.messengerlib.utils.SnackbarBuilder;
import com.tokenautocomplete.TokenCompleteTextView.TokenClickStyle;
import com.tokenautocomplete.TokenCompleteTextView.TokenDeleteStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

public class AddParticipantFragment
  extends BaseFragment
{
  private static final String TAG = AddParticipantFragment.class.getCanonicalName();
  public AddParticipantCallbacks callbacks;
  private ContentObserver contentObserver;
  private long conversationId;
  private String conversationRemoteId;
  private MessengerRecyclerView currentParticipantList;
  private AddParticipantDetailsListAdapter currentParticipantListAdapter;
  private Handler handler = new Handler();
  private PeopleResultsListAdapter peopleResultsListAdapter;
  public PeopleSearchCompletionView searchBar;
  private MessengerRecyclerView searchResultList;
  private Timer timer;
  
  private static List<MiniProfile> buildPrefilteredProfiles(List<TypeaheadHit> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MiniProfile localMiniProfile = nexthitInfo.typeaheadProfileValue.miniProfile;
      if (localMiniProfile != null) {
        localArrayList.add(localMiniProfile);
      }
    }
    return localArrayList;
  }
  
  /* Error */
  private java.util.Set<String> fetchAlreadyAddedProfiles()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 64	com/linkedin/messengerlib/ui/participantdetails/AddParticipantFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   4: ifnonnull +9 -> 13
    //   7: invokestatic 273	java/util/Collections:emptySet	()Ljava/util/Set;
    //   10: astore_1
    //   11: aload_1
    //   12: areturn
    //   13: new 275	java/util/HashSet
    //   16: dup
    //   17: invokespecial 276	java/util/HashSet:<init>	()V
    //   20: astore_2
    //   21: aload_0
    //   22: getfield 124	com/linkedin/messengerlib/shared/BaseFragment:fragmentComponent	Lcom/linkedin/messengerlib/shared/FragmentComponent;
    //   25: getfield 280	com/linkedin/messengerlib/shared/FragmentComponent:dataManager	Lcom/linkedin/messengerlib/consumers/DataManager;
    //   28: getfield 286	com/linkedin/messengerlib/consumers/DataManager:actorDataManager	Lcom/linkedin/messengerlib/consumers/ActorDataManager;
    //   31: aload_0
    //   32: getfield 54	com/linkedin/messengerlib/ui/participantdetails/AddParticipantFragment:conversationId	J
    //   35: invokevirtual 292	com/linkedin/messengerlib/consumers/ActorDataManager:getActorsForConversation	(J)Landroid/database/Cursor;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +45 -> 85
    //   43: aload_3
    //   44: invokeinterface 297 1 0
    //   49: ifeq +36 -> 85
    //   52: aload_2
    //   53: aload_3
    //   54: invokestatic 303	com/linkedin/messengerlib/consumers/ActorDataManager$ActorsForConversationCursor:miniProfileForActor	(Landroid/database/Cursor;)Lcom/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile;
    //   57: getfield 107	com/linkedin/android/pegasus/gen/voyager/identity/shared/MiniProfile:entityUrn	Lcom/linkedin/android/pegasus/gen/common/Urn;
    //   60: invokevirtual 112	com/linkedin/android/pegasus/gen/common/Urn:getLastId	()Ljava/lang/String;
    //   63: invokeinterface 304 2 0
    //   68: pop
    //   69: goto -30 -> 39
    //   72: astore_1
    //   73: aload_3
    //   74: ifnull +9 -> 83
    //   77: aload_3
    //   78: invokeinterface 307 1 0
    //   83: aload_1
    //   84: athrow
    //   85: aload_2
    //   86: astore_1
    //   87: aload_3
    //   88: ifnull -77 -> 11
    //   91: aload_3
    //   92: invokeinterface 307 1 0
    //   97: aload_2
    //   98: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	AddParticipantFragment
    //   10	2	1	localSet	java.util.Set
    //   72	12	1	localObject1	Object
    //   86	1	1	localObject2	Object
    //   20	78	2	localHashSet	java.util.HashSet
    //   38	54	3	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   43	69	72	finally
  }
  
  private int getEventCountByConversationId(long paramLong)
  {
    Cursor localCursor = fragmentComponent.dataManager.eventsDataManager.getEventsForConversationId(paramLong);
    if (localCursor != null) {
      try
      {
        int i = localCursor.getCount();
        return i;
      }
      finally
      {
        localCursor.close();
      }
    }
    return 0;
  }
  
  private void refreshParticipantListFromCursor()
  {
    if ((getMessengerLibApi() == null) || (!isFragmentActive())) {}
    int i;
    Cursor localCursor;
    do
    {
      return;
      i = getEventCountByConversationId(conversationId);
      localCursor = fragmentComponent.dataManager.actorDataManager.getActorsForConversation(conversationId);
    } while (localCursor == null);
    AddParticipantDetailsListAdapter localAddParticipantDetailsListAdapter = currentParticipantListAdapter;
    if (i <= 3) {}
    for (boolean bool = true;; bool = false)
    {
      shouldIncludeConversationHistory = bool;
      currentParticipantListAdapter.swapCursor(localCursor);
      return;
    }
  }
  
  private void showCurrentParticipantList()
  {
    searchResultList.setVisibility(8);
    currentParticipantList.setVisibility(0);
  }
  
  protected final int getFragmentId()
  {
    return R.layout.add_participant_fragment;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getLixManager() != null) && (getLixManager().isAddPeopleIncludeConversationHistoryEnabled())) {}
    for (boolean bool = true;; bool = false)
    {
      if (currentParticipantListAdapter == null) {
        currentParticipantListAdapter = new AddParticipantDetailsListAdapter.1(fragmentComponent, paramActivity, new AddParticipantFragment.1(this, getTracker(), "view_profile"), bool);
      }
      if (peopleResultsListAdapter == null) {
        peopleResultsListAdapter = new PeopleResultsListAdapter(getActivity(), fragmentComponent, new AddParticipantFragment.2(this, getTracker(), "select_participant"));
      }
      if (contentObserver == null) {
        contentObserver = new AddParticipantFragment.3(this, new Handler(), paramActivity);
      }
      paramActivity.getContentResolver().registerContentObserver(MessengerProvider.EVENTS_VIEW_URI, false, contentObserver);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    timer = new Timer();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    currentParticipantList = ((MessengerRecyclerView)paramLayoutInflater.findViewById(R.id.add_participant_current_people_list));
    searchResultList = ((MessengerRecyclerView)paramLayoutInflater.findViewById(R.id.add_participant_search_result_list));
    searchBar = ((PeopleSearchCompletionView)paramLayoutInflater.findViewById(R.id.add_participant_new_people));
    if (paramBundle != null)
    {
      conversationId = ParticipantDetailsBundleBuilder.getConversationId(paramBundle);
      conversationRemoteId = ParticipantDetailsBundleBuilder.getConversationRemoteId(paramBundle);
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    timer.cancel();
    timer = null;
  }
  
  public void onDetach()
  {
    if ((getActivity() != null) && (contentObserver != null))
    {
      getActivity().getContentResolver().unregisterContentObserver(contentObserver);
      contentObserver = null;
    }
    super.onDetach();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    ParticipantDetailsBundleBuilder.setConversation(paramBundle, conversationId, conversationRemoteId);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    currentParticipantList.setAdapter(currentParticipantListAdapter);
    searchResultList.setAdapter(peopleResultsListAdapter);
    searchBar.addTextChangedListener(new AddParticipantFragment.5(this));
    searchBar.setAdapter(new ArrayAdapter(getActivity(), 0));
    searchBar.setTokenClickStyle(TokenCompleteTextView.TokenClickStyle.Delete);
    searchBar.setDeletionStyle(TokenCompleteTextView.TokenDeleteStyle.ToString);
    searchBar.setTokenListener(new AddParticipantFragment.8(this));
    searchBar.setOnFocusChangeListener(new AddParticipantFragment.9(this));
    refreshParticipantListFromCursor();
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
    if (!ParticipantDetailsBundleBuilder.containsKey(paramBundle, "CONVERSATION_ID")) {
      throw new RuntimeException("No conversation ID provided");
    }
    if (!ParticipantDetailsBundleBuilder.containsKey(paramBundle, "CONVERSATION_REMOTE_ID")) {
      throw new RuntimeException("No remote conversation ID provided");
    }
    conversationId = ParticipantDetailsBundleBuilder.getConversationId(paramBundle);
    conversationRemoteId = ParticipantDetailsBundleBuilder.getConversationRemoteId(paramBundle);
  }
  
  public static abstract interface AddParticipantCallbacks
  {
    public abstract void onPendingParticipantsChange(boolean paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */