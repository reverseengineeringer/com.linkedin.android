package com.linkedin.android.feed.mentions;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.events.MentionStartSuggestionTrackingEvent;
import com.linkedin.android.feed.tracking.MentionsTracking;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadType;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.search.typeahead.TypeaheadLargeEntityViewModel;
import com.linkedin.android.search.typeahead.TypeaheadTransformer;
import com.linkedin.android.spyglass.mentions.Mentionable;
import com.linkedin.android.spyglass.tokenization.QueryToken;
import com.linkedin.android.spyglass.tokenization.interfaces.QueryTokenReceiver;
import com.linkedin.android.spyglass.ui.MentionsEditText.MentionWatcher;
import com.linkedin.gen.avro2pegasus.events.mentions.MentionActionType;
import com.linkedin.gen.avro2pegasus.events.mentions.MentionResultHit;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public class MentionsPresenter
  implements QueryTokenReceiver, MentionsEditText.MentionWatcher
{
  private static final String TAG = MentionsPresenter.class.getSimpleName();
  private ViewModelArrayAdapter<ViewModel> adapter;
  public boolean alwaysExplicit;
  @Inject
  FlagshipDataManager dataManager;
  @Inject
  DelayedExecution delayedExecution;
  private TypeaheadHitModelListener explicitModelListener;
  private FragmentComponent fragmentComponent;
  private String groupId;
  private TypeaheadHitModelListener implicitModelListener;
  private boolean isGroupDetailPage;
  private Map<String, MentionResultHit> mentionResultHitMap;
  public String mentionWorkFlowId;
  public MentionsResultListener mentionsResultListener;
  public String query;
  public List<Mentionable> selectedMentionList;
  public boolean shouldShowMentionSelectionState;
  private TypeaheadRunnable typeaheadRunnable;
  @Inject
  TypeaheadTransformer typeaheadTransformer;
  private TypeaheadType[] types = { TypeaheadType.COMPANY, TypeaheadType.SCHOOL, TypeaheadType.PEOPLE };
  
  @Inject
  public MentionsPresenter(FragmentComponent paramFragmentComponent)
  {
    adapter = new ViewModelArrayAdapter(paramFragmentComponent.activity(), paramFragmentComponent.mediaCenter(), null);
    fragmentComponent = paramFragmentComponent;
    implicitModelListener = new TypeaheadHitModelListener(this, paramFragmentComponent.fragment(), false, (byte)0);
    explicitModelListener = new TypeaheadHitModelListener(this, paramFragmentComponent.fragment(), true, (byte)0);
    mentionResultHitMap = Collections.emptyMap();
    selectedMentionList = new ArrayList();
  }
  
  private MentionResultHit getMentionResultHit(Mentionable paramMentionable)
  {
    if ((paramMentionable instanceof MentionableImpl))
    {
      paramMentionable = entityUrn;
      return (MentionResultHit)mentionResultHitMap.get(paramMentionable);
    }
    return null;
  }
  
  private Map<String, String> getTrackingHeader()
  {
    Fragment localFragment = fragmentComponent.fragment();
    if ((localFragment instanceof TrackableFragment)) {
      return Tracker.createPageInstanceHeader(((TrackableFragment)localFragment).getPageInstance());
    }
    return null;
  }
  
  private void onMentionSelectionStateChanged(Mentionable paramMentionable, boolean paramBoolean)
  {
    String str = "";
    if ((paramMentionable instanceof MentionableImpl)) {
      str = entityUrn;
    }
    int i = adapter.getValues().size() - 1;
    while (i >= 0)
    {
      paramMentionable = (ViewModel)adapter.getValues().get(i);
      if ((paramMentionable instanceof TypeaheadLargeEntityViewModel))
      {
        paramMentionable = (TypeaheadLargeEntityViewModel)paramMentionable;
        if (str.equals(entityUrn))
        {
          isMentionSelected = paramBoolean;
          adapter.notifyItemChanged(i);
        }
      }
      i -= 1;
    }
  }
  
  public final void bind(RecyclerView paramRecyclerView)
  {
    paramRecyclerView.setLayoutManager(new LinearLayoutManager(paramRecyclerView.getContext()));
    paramRecyclerView.setAdapter(adapter);
  }
  
  public final void cleanUp()
  {
    if (typeaheadRunnable != null) {
      delayedExecution.stopDelayedExecution(typeaheadRunnable);
    }
  }
  
  public final Mentionable getMentionable(ClickEvent paramClickEvent)
  {
    return MentionsUtils.getMentionable(fragmentComponent, paramClickEvent);
  }
  
  public final void onMentionAdded$658a83e4(Mentionable paramMentionable)
  {
    MentionsTracking.fireMentionSuggestionActionEvent(fragmentComponent, query, mentionWorkFlowId, MentionActionType.SELECT, getMentionResultHit(paramMentionable));
    if (shouldShowMentionSelectionState)
    {
      selectedMentionList.add(paramMentionable);
      onMentionSelectionStateChanged(paramMentionable, true);
    }
  }
  
  public final void onMentionDeleted$658a83e4(Mentionable paramMentionable)
  {
    MentionsTracking.fireMentionSuggestionActionEvent(fragmentComponent, query, mentionWorkFlowId, MentionActionType.DELETE, getMentionResultHit(paramMentionable));
    if (shouldShowMentionSelectionState) {
      removeMentionFromSelection(paramMentionable);
    }
  }
  
  public final void onMentionPartiallyDeleted$658a83e4(Mentionable paramMentionable)
  {
    MentionsTracking.fireMentionSuggestionActionEvent(fragmentComponent, query, mentionWorkFlowId, MentionActionType.PERSONALIZE, getMentionResultHit(paramMentionable));
  }
  
  public final List<String> onQueryReceived(QueryToken paramQueryToken)
  {
    query = paramQueryToken.getKeywords();
    boolean bool2 = TextUtils.isEmpty(query);
    if (((paramQueryToken.isExplicit()) && (bool2)) || ((!paramQueryToken.isExplicit()) && (query.length() == 4)))
    {
      fragmentComponent.eventBus();
      Bus.publish(new MentionStartSuggestionTrackingEvent(paramQueryToken.isExplicit()));
    }
    if (typeaheadRunnable != null) {
      delayedExecution.stopDelayedExecution(typeaheadRunnable);
    }
    String str = query;
    if ((alwaysExplicit) || (paramQueryToken.isExplicit())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      typeaheadRunnable = new TypeaheadRunnable(this, str, bool2, bool1, isGroupDetailPage, (byte)0);
      delayedExecution.postDelayedExecution(typeaheadRunnable, 200L);
      return null;
    }
  }
  
  public final void removeMentionFromSelection(Mentionable paramMentionable)
  {
    selectedMentionList.remove(paramMentionable);
    onMentionSelectionStateChanged(paramMentionable, false);
  }
  
  public final void setGroupDetails$2598ce09(String paramString)
  {
    isGroupDetailPage = true;
    groupId = paramString;
  }
  
  public static abstract interface MentionsResultListener
  {
    public abstract void displaySuggestions(boolean paramBoolean);
  }
  
  private static final class TypeaheadHitModelListener
    implements RecordTemplateListener<CollectionTemplate<TypeaheadHit, CollectionMetadata>>
  {
    private WeakReference<Fragment> fragmentWeakReference;
    private boolean isExplicit;
    private WeakReference<MentionsPresenter> mentionsPresenterWeakReference;
    
    private TypeaheadHitModelListener(MentionsPresenter paramMentionsPresenter, Fragment paramFragment, boolean paramBoolean)
    {
      mentionsPresenterWeakReference = new WeakReference(paramMentionsPresenter);
      fragmentWeakReference = new WeakReference(paramFragment);
      isExplicit = paramBoolean;
    }
    
    public final void onResponse(DataStoreResponse<CollectionTemplate<TypeaheadHit, CollectionMetadata>> paramDataStoreResponse)
    {
      MentionsPresenter localMentionsPresenter = (MentionsPresenter)mentionsPresenterWeakReference.get();
      Object localObject = (Fragment)fragmentWeakReference.get();
      if ((localObject == null) || (!((Fragment)localObject).isAdded()) || (localMentionsPresenter == null)) {}
      do
      {
        return;
        if (model == null) {
          break;
        }
        List localList = model).elements;
        localObject = localList;
        if (localList == null) {
          localObject = new ArrayList();
        }
        MentionsPresenter.access$200(localMentionsPresenter, (List)localObject, isExplicit, type, request.trackingSessionId);
      } while (!shouldShowMentionSelectionState);
      MentionsPresenter.access$400(localMentionsPresenter);
      return;
      Log.e(MentionsPresenter.TAG, "Failed to get typeahead data: " + error.getClass().getName() + "; " + error.getMessage());
    }
  }
  
  private static final class TypeaheadRunnable
    implements Runnable
  {
    private boolean isExplicitMentionQuery;
    private boolean isGroupsDetailPage;
    private boolean isRecentMentionsQuery;
    private WeakReference<MentionsPresenter> mentionsPresenterWeakReference;
    private String query;
    
    private TypeaheadRunnable(MentionsPresenter paramMentionsPresenter, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      mentionsPresenterWeakReference = new WeakReference(paramMentionsPresenter);
      query = paramString;
      isRecentMentionsQuery = paramBoolean1;
      isExplicitMentionQuery = paramBoolean2;
      isGroupsDetailPage = paramBoolean3;
    }
    
    public final void run()
    {
      MentionsPresenter localMentionsPresenter = (MentionsPresenter)mentionsPresenterWeakReference.get();
      if (localMentionsPresenter != null)
      {
        if (isGroupsDetailPage) {
          MentionsPresenter.access$600(localMentionsPresenter, query);
        }
      }
      else {
        return;
      }
      if (isExplicitMentionQuery)
      {
        MentionsPresenter.access$700(localMentionsPresenter, query, isRecentMentionsQuery);
        return;
      }
      MentionsPresenter.access$800(localMentionsPresenter, query);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.mentions.MentionsPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */