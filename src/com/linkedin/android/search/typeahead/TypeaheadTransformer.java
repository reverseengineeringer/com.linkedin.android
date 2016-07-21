package com.linkedin.android.search.typeahead;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseIntArray;
import com.linkedin.android.feed.mentions.MentionsUtils;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.LongClickUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.GraphDistance;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipStatus;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistory;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistory.HistoryInfo;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryCompany;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryGroup;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryJob;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryProfile;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistorySchool;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadAutoComplete;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCompany;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadGroup;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadProfile;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSchool;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadShowcase;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSuggestion;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadType;
import com.linkedin.android.relationships.shared.AnnotatedTextUtils;
import com.linkedin.android.search.FollowingInfoChangeListener;
import com.linkedin.android.search.SearchActivity;
import com.linkedin.android.search.SearchDataProvider;
import com.linkedin.android.search.searchengine.SearchEngineEmptyStateViewModel;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.gen.avro2pegasus.events.search.SearchResultPageOrigin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

public final class TypeaheadTransformer
{
  private static final int[] EMPTY_HISTORY_IMAGES = { 2130838516, 2130838519, 2130838521, 2130838518, 2130838517 };
  private static final int[] EMPTY_HISTORY_SUBTITLES;
  private static final int[] EMPTY_HISTORY_TITLES = { 2131233512, 2131233521, 2131233524, 2131233518, 2131233515 };
  private static final Map<Integer, Integer> SUBTITLES_TO_QUERY_MAP;
  private final SearchDataProvider dataProvider;
  FollowingInfoChangeListener<TypeaheadLargeEntityViewModel> followingListener;
  private Handler handler = new Handler(Looper.getMainLooper());
  @Inject
  IntentRegistry intentRegistry;
  private final LongClickUtil longClickUtil;
  private TypeaheadLargeEntityViewModel revealedViewModel;
  private Runnable revealedViewModelRunnable = new TypeaheadTransformer.1(this);
  private String starterId;
  
  static
  {
    EMPTY_HISTORY_SUBTITLES = new int[] { 2131233510, 2131233519, 2131233522, 2131233516, 2131233513 };
    HashMap localHashMap = new HashMap(5);
    SUBTITLES_TO_QUERY_MAP = localHashMap;
    localHashMap.put(Integer.valueOf(2131233510), Integer.valueOf(2131233511));
    SUBTITLES_TO_QUERY_MAP.put(Integer.valueOf(2131233519), Integer.valueOf(2131233520));
    SUBTITLES_TO_QUERY_MAP.put(Integer.valueOf(2131233522), Integer.valueOf(2131233523));
    SUBTITLES_TO_QUERY_MAP.put(Integer.valueOf(2131233516), Integer.valueOf(2131233517));
    SUBTITLES_TO_QUERY_MAP.put(Integer.valueOf(2131233513), Integer.valueOf(2131233514));
  }
  
  @Inject
  public TypeaheadTransformer(ActivityComponent paramActivityComponent)
  {
    dataProvider = paramActivityComponent.searchDataProvider();
    longClickUtil = paramActivityComponent.longClickUtil();
  }
  
  private void setupActionClickListener(TypeaheadLargeEntityViewModel paramTypeaheadLargeEntityViewModel, TypeaheadHit paramTypeaheadHit, FragmentComponent paramFragmentComponent, String paramString1, int paramInt, SparseIntArray paramSparseIntArray, String paramString2)
  {
    ctaButtonListener = new TypeaheadTransformer.14(this, paramFragmentComponent, paramTypeaheadLargeEntityViewModel, paramTypeaheadHit, paramString1, paramInt, paramSparseIntArray, paramString2);
  }
  
  private void setupRevealViewListeners(TypeaheadLargeEntityViewModel paramTypeaheadLargeEntityViewModel, TypeaheadHit paramTypeaheadHit, FragmentComponent paramFragmentComponent, String paramString1, int paramInt, SparseIntArray paramSparseIntArray, String paramString2)
  {
    longClickListener = new TypeaheadTransformer.13(this, paramTypeaheadLargeEntityViewModel, paramFragmentComponent);
    setupActionClickListener(paramTypeaheadLargeEntityViewModel, paramTypeaheadHit, paramFragmentComponent, paramString1, paramInt, paramSparseIntArray, paramString2);
  }
  
  public final void startRevealViewModelRunnable(FragmentComponent paramFragmentComponent)
  {
    startRevealViewModelRunnable(paramFragmentComponent, 4000L);
  }
  
  public final void startRevealViewModelRunnable(FragmentComponent paramFragmentComponent, long paramLong)
  {
    if (revealedViewModel != null)
    {
      paramFragmentComponent.animationProxy();
      handler.postDelayed(revealedViewModelRunnable, paramLong);
    }
  }
  
  public final void stopRevealViewModelRunnable()
  {
    if (revealedViewModel != null) {
      handler.removeCallbacks(revealedViewModelRunnable);
    }
  }
  
  public final List<ViewModel> transformHistoryToModelList(FragmentComponent paramFragmentComponent, List<SearchHistory> paramList, SparseIntArray paramSparseIntArray, String paramString)
  {
    starterId = paramString;
    Bus localBus = paramFragmentComponent.eventBus();
    int i;
    ArrayList localArrayList;
    if (paramList.size() > 0)
    {
      i = paramList.size();
      localArrayList = new ArrayList(i);
      if (!CollectionUtils.isEmpty(paramList)) {
        break label350;
      }
      i = 5;
      if ("disabled".equals(paramFragmentComponent.lixManager().getTreatment(Lix.SEARCH_DISABLE_GROUPS))) {
        i = 4;
      }
      paramList = new SearchEngineEmptyStateViewModel();
      i = new Random().nextInt(i);
      imageResource = EMPTY_HISTORY_IMAGES[i];
      title = paramFragmentComponent.i18NManager().getString(EMPTY_HISTORY_TITLES[i]);
      paramSparseIntArray = paramFragmentComponent.i18NManager().getSpannedString(EMPTY_HISTORY_SUBTITLES[i], new Object[0]);
      if ((!(paramFragmentComponent.activity() instanceof SearchActivity)) || (!(paramFragmentComponent.fragment() instanceof TypeaheadFragment))) {
        break label344;
      }
    }
    label344:
    for (boolean bool = true;; bool = false)
    {
      isTypeaheadView = bool;
      if ("enabled".equals(paramFragmentComponent.lixManager().getTreatment(Lix.SEARCH_CLICKABLE_EMPTY_HISTORY_SUBTEXT)))
      {
        paramString = paramFragmentComponent.i18NManager().getString(((Integer)SUBTITLES_TO_QUERY_MAP.get(Integer.valueOf(EMPTY_HISTORY_SUBTITLES[i]))).intValue());
        localSpannableString = new SpannableString(paramSparseIntArray);
        i = paramSparseIntArray.toString().indexOf(paramString);
        if (i > 0)
        {
          localSpannableString.setSpan(new ForegroundColorSpan(paramFragmentComponent.activity().getResources().getColor(2131623966)), i, paramString.length() + i, 0);
          subTextOnClickeListener = new TypeaheadTransformer.4(this, paramFragmentComponent, bool, paramString);
        }
        subtitle = localSpannableString;
      }
      localArrayList.add(paramList);
      return localArrayList;
      i = 1;
      break;
    }
    label350:
    int j = 1;
    Iterator localIterator = paramList.iterator();
    label361:
    SearchHistory localSearchHistory;
    if (localIterator.hasNext())
    {
      localSearchHistory = (SearchHistory)localIterator.next();
      if (historyInfo.searchHistoryProfileValue == null) {
        break label522;
      }
      i = 1;
      label397:
      if (historyInfo.entityAwareSearchQueryValue == null) {
        break label633;
      }
      paramString = new TypeaheadSuggestionViewModel();
      entitySuggestionImage = SearchUtils.getImageByType(searchType);
      name = displayText;
      if (!hasSubtext) {
        break label626;
      }
    }
    label522:
    label626:
    for (paramList = subtext;; paramList = "")
    {
      headline = paramList;
      position = j;
      listener = new TypeaheadTransformer.3(this, paramFragmentComponent.tracker(), "search_starter_result", new TrackingEventBuilder[0], i, localBus, localSearchHistory, paramFragmentComponent, paramString, paramSparseIntArray);
      localArrayList.add(paramString);
      j += 1;
      break label361;
      break;
      if (historyInfo.searchHistoryCompanyValue != null)
      {
        i = 3;
        break label397;
      }
      if (historyInfo.searchHistorySchoolValue != null)
      {
        i = 2;
        break label397;
      }
      if (historyInfo.searchHistoryJobValue != null)
      {
        i = 12;
        break label397;
      }
      if (historyInfo.searchHistoryGroupValue != null)
      {
        i = 10;
        break label397;
      }
      if ((historyInfo.searchQueryValue != null) || (historyInfo.entityAwareSearchQueryValue != null))
      {
        i = 4;
        break label397;
      }
      i = -1;
      break label397;
    }
    label633:
    TypeaheadSmallViewModel localTypeaheadSmallViewModel = new TypeaheadSmallViewModel();
    SearchHistory.HistoryInfo localHistoryInfo = historyInfo;
    name = displayText;
    position = j;
    type = searchType;
    SpannableString localSpannableString = null;
    Object localObject = null;
    paramList = historyInfo;
    if (searchHistoryProfileValue != null)
    {
      paramList = searchHistoryProfileValue.profile.picture;
      paramString = GhostImageUtils.getAnonymousPerson(2131492961);
      label714:
      if (paramString != null) {
        image = new ImageModel(paramList, paramString, Util.retrieveRumSessionId(paramFragmentComponent));
      }
      if (("enabled".equals(paramFragmentComponent.lixManager().getTreatment(Lix.LIX_SEARCH_NEW_JOB))) && (searchHistoryJobValue != null))
      {
        paramList = Long.valueOf(searchHistoryJobValue.job.listedAt);
        if (paramList == null) {
          break label1030;
        }
        long l1 = System.currentTimeMillis();
        long l2 = paramList.longValue();
        if (TimeUnit.MILLISECONDS.toHours(l1 - l2) >= 24L) {
          break label1030;
        }
      }
    }
    label1030:
    for (bool = true;; bool = false)
    {
      newPost = bool;
      listener = new TypeaheadTransformer.2(this, paramFragmentComponent.tracker(), "search_starter_result", new TrackingEventBuilder[0], i, localBus, localSearchHistory, localHistoryInfo, paramFragmentComponent, localTypeaheadSmallViewModel, paramSparseIntArray);
      localArrayList.add(localTypeaheadSmallViewModel);
      break;
      if (searchHistoryCompanyValue != null)
      {
        paramList = searchHistoryCompanyValue.company.logo;
        paramString = GhostImageUtils.getUnstructuredCompany(2131492961);
        break label714;
      }
      if (searchHistorySchoolValue != null)
      {
        paramList = searchHistorySchoolValue.school.logo;
        paramString = GhostImageUtils.getUnstructuredSchool(2131492961);
        break label714;
      }
      if (searchHistoryJobValue != null)
      {
        paramList = searchHistoryJobValue.job.logo;
        paramString = GhostImageUtils.getUnstructuredJob(2131492961);
        break label714;
      }
      if (searchHistoryGroupValue != null)
      {
        paramList = searchHistoryGroupValue.group.logo;
        paramString = GhostImageUtils.getUnstructuredGroup(2131492961);
        break label714;
      }
      paramList = (List<SearchHistory>)localObject;
      paramString = localSpannableString;
      if (historyInfo.searchQueryValue == null) {
        break label714;
      }
      suggestionLogo = 2130838323;
      paramList = (List<SearchHistory>)localObject;
      paramString = localSpannableString;
      break label714;
    }
  }
  
  public final List<ViewModel> transformTypeAheadToModelList(FragmentComponent paramFragmentComponent, List<TypeaheadHit> paramList, boolean paramBoolean, String paramString1, SparseIntArray paramSparseIntArray, String paramString2, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    stopRevealViewModelRunnable();
    revealedViewModel = null;
    int i = 0;
    if (i < paramList.size())
    {
      TypeaheadHit localTypeaheadHit = (TypeaheadHit)paramList.get(i);
      boolean bool1;
      label61:
      int j;
      label83:
      Object localObject3;
      Object localObject1;
      Object localObject2;
      Object localObject4;
      label157:
      Object localObject5;
      label283:
      boolean bool2;
      if (i < paramInt2)
      {
        bool1 = true;
        if ((!hasHitInfo) || (!SearchUtils.isTypeaheadEntity(hitInfo))) {
          break label425;
        }
        j = 1;
        if (j == 0) {
          break label1217;
        }
        localObject3 = paramFragmentComponent.eventBus();
        localObject1 = paramFragmentComponent.activity();
        localObject2 = new TypeaheadLargeEntityViewModel();
        localObject4 = hitInfo;
        name = AnnotatedTextUtils.getCharSequenceFromAnnotatedText$706ef64d((Context)localObject1, text);
        position = paramInt1;
        if (!hasSubtext) {
          break label431;
        }
        localObject1 = subtext;
        headline = ((CharSequence)localObject1);
        entityUrn = MentionsUtils.getEntityUrn(hitInfo);
        if (typeaheadProfileValue == null) {
          break label477;
        }
        localObject4 = hitInfo.typeaheadProfileValue;
        localObject5 = paramFragmentComponent.tracker();
        type = TypeaheadType.PEOPLE;
        image = new ImageModel(miniProfile.picture, GhostImageUtils.getPerson(2131492961, miniProfile), Util.retrieveRumSessionId(paramFragmentComponent));
        degree = SearchUtils.getDegree(distance, paramFragmentComponent.i18NManager());
        if (distance == null) {
          break label439;
        }
        localObject1 = distance.value;
        graphDistance = ((GraphDistance)localObject1);
        listener = new TypeaheadTransformer.12(this, (Tracker)localObject5, "search_tyah_result", new TrackingEventBuilder[0], (TypeaheadLargeEntityViewModel)localObject2, paramBoolean, (Bus)localObject3, localTypeaheadHit, (Tracker)localObject5, paramString1, paramInt1, paramSparseIntArray, paramString2, bool1, (TypeaheadProfile)localObject4);
        bool1 = SearchUtils.shouldShowInviteView(paramFragmentComponent, distance);
        bool2 = SearchUtils.shouldShowSendMessageView(paramFragmentComponent, distance);
        if (!SearchUtils.shouldShowInviteMessageInSearchResultsAndTypeAhead(paramFragmentComponent)) {
          break label447;
        }
        alwaysShowCtaButtons = true;
        setupActionClickListener((TypeaheadLargeEntityViewModel)localObject2, localTypeaheadHit, paramFragmentComponent, paramString1, paramInt1, paramSparseIntArray, paramString2);
        label385:
        localObject1 = localObject2;
      }
      for (;;)
      {
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        i += 1;
        paramInt1 += 1;
        break;
        bool1 = false;
        break label61;
        label425:
        j = 0;
        break label83;
        label431:
        localObject1 = "";
        break label157;
        label439:
        localObject1 = GraphDistance.$UNKNOWN;
        break label283;
        label447:
        if ((!bool1) && (!bool2)) {
          break label385;
        }
        setupRevealViewListeners((TypeaheadLargeEntityViewModel)localObject2, localTypeaheadHit, paramFragmentComponent, paramString1, paramInt1, paramSparseIntArray, paramString2);
        break label385;
        label477:
        if (typeaheadCompanyValue != null)
        {
          localObject1 = hitInfo.typeaheadCompanyValue;
          localObject4 = paramFragmentComponent.tracker();
          type = TypeaheadType.COMPANY;
          image = new ImageModel(company.logo, GhostImageUtils.getCompany(2131492961, company), Util.retrieveRumSessionId(paramFragmentComponent));
          if ((following != null) && (following.following)) {}
          for (bool1 = true;; bool1 = false)
          {
            isCtaClicked = bool1;
            localObject5 = company;
            listener = new TypeaheadTransformer.11(this, (Tracker)localObject4, "search_tyah_result", new TrackingEventBuilder[0], (TypeaheadLargeEntityViewModel)localObject2, (Bus)localObject3, (MiniCompany)localObject5, paramBoolean, localTypeaheadHit, (Tracker)localObject4, paramString1, paramInt1, paramSparseIntArray, paramString2);
            if (SearchUtils.shouldShowFollowView(paramFragmentComponent, following, Lix.LIX_SEARCH_FOLLOW_COMPANY_ACTION)) {
              setupRevealViewListeners((TypeaheadLargeEntityViewModel)localObject2, localTypeaheadHit, paramFragmentComponent, paramString1, paramInt1, paramSparseIntArray, paramString2);
            }
            if ((followingListener == null) || (following == null)) {
              break;
            }
            followingListener.listenForUpdates(following, (ViewModel)localObject2);
            break;
          }
        }
        if (typeaheadSchoolValue != null)
        {
          localObject1 = hitInfo.typeaheadSchoolValue;
          localObject4 = paramFragmentComponent.tracker();
          type = TypeaheadType.SCHOOL;
          image = new ImageModel(school.logo, GhostImageUtils.getSchool(2131492961, school), Util.retrieveRumSessionId(paramFragmentComponent));
          if ((following != null) && (following.following)) {}
          for (bool1 = true;; bool1 = false)
          {
            isCtaClicked = bool1;
            localObject5 = school;
            listener = new TypeaheadTransformer.10(this, (Tracker)localObject4, "search_tyah_result", new TrackingEventBuilder[0], (TypeaheadLargeEntityViewModel)localObject2, (Bus)localObject3, (MiniSchool)localObject5, paramBoolean, localTypeaheadHit, (Tracker)localObject4, paramString1, paramInt1, paramSparseIntArray, paramString2);
            if (SearchUtils.shouldShowFollowView(paramFragmentComponent, following, Lix.LIX_SEARCH_FOLLOW_SCHOOL_ACTION)) {
              setupRevealViewListeners((TypeaheadLargeEntityViewModel)localObject2, localTypeaheadHit, paramFragmentComponent, paramString1, paramInt1, paramSparseIntArray, paramString2);
            }
            if ((followingListener == null) || (following == null)) {
              break;
            }
            followingListener.listenForUpdates(following, (ViewModel)localObject2);
            break;
          }
        }
        if (typeaheadGroupValue != null)
        {
          localObject1 = hitInfo.typeaheadGroupValue;
          localObject4 = paramFragmentComponent.tracker();
          type = TypeaheadType.GROUP;
          localObject5 = group;
          image = new ImageModel(group.logo, GhostImageUtils.getGroup(2131492961, (MiniGroup)localObject5), Util.retrieveRumSessionId(paramFragmentComponent));
          if ((membershipInfo != null) && (membershipInfo.status != GroupMembershipStatus.NON_MEMBER)) {}
          for (bool1 = true;; bool1 = false)
          {
            isCtaClicked = bool1;
            listener = new TypeaheadTransformer.9(this, (Tracker)localObject4, "search_tyah_result", new TrackingEventBuilder[0], (TypeaheadLargeEntityViewModel)localObject2, (Bus)localObject3, (MiniGroup)localObject5, paramBoolean, localTypeaheadHit, (Tracker)localObject4, paramString1, paramInt1, paramSparseIntArray, paramString2);
            if (!"enabled".equals(paramFragmentComponent.lixManager().getTreatment(Lix.LIX_SEARCH_JOIN_GROUP_ACTION))) {
              break;
            }
            setupRevealViewListeners((TypeaheadLargeEntityViewModel)localObject2, localTypeaheadHit, paramFragmentComponent, paramString1, paramInt1, paramSparseIntArray, paramString2);
            break;
          }
        }
        if (typeaheadShowcaseValue == null) {
          break label385;
        }
        localObject1 = paramFragmentComponent.tracker();
        localObject4 = hitInfo.typeaheadShowcaseValue.company;
        image = new ImageModel(hitInfo.typeaheadShowcaseValue.company.logo, GhostImageUtils.getCompany(2131492961, (MiniCompany)localObject4), Util.retrieveRumSessionId(paramFragmentComponent));
        listener = new TypeaheadTransformer.8(this, (Tracker)localObject1, "search_tyah_result", new TrackingEventBuilder[0], (Bus)localObject3, (MiniCompany)localObject4, paramBoolean, localTypeaheadHit, (Tracker)localObject1, paramString1, paramInt1, paramSparseIntArray, paramString2);
        break label385;
        label1217:
        if ((hasHitInfo) && (hitInfo.typeaheadSuggestionValue != null))
        {
          j = 1;
          label1239:
          if (j == 0) {
            break label1399;
          }
          localObject3 = paramFragmentComponent.eventBus();
          localObject4 = paramFragmentComponent.activity();
          localObject2 = new TypeaheadSuggestionViewModel();
          name = AnnotatedTextUtils.getCharSequenceFromAnnotatedText$706ef64d((Context)localObject4, text);
          position = paramInt1;
          if (!hasSubtext) {
            break label1391;
          }
        }
        label1391:
        for (localObject1 = subtext;; localObject1 = "")
        {
          headline = ((CharSequence)localObject1);
          localObject1 = paramFragmentComponent.tracker();
          entitySuggestionImage = SearchUtils.getImageByType(hitInfo.typeaheadSuggestionValue.type);
          listener = new TypeaheadTransformer.7(this, (Tracker)localObject1, "search_tyah_suggestion", new TrackingEventBuilder[0], (Bus)localObject3, localTypeaheadHit, (Context)localObject4, (Tracker)localObject1, paramString1, paramInt1, paramSparseIntArray, paramString2);
          localObject1 = localObject2;
          break;
          j = 0;
          break label1239;
        }
        label1399:
        if ((hasHitInfo) && (hitInfo.typeaheadAutoCompleteValue != null))
        {
          j = 1;
          label1421:
          if (j == 0) {
            break label1575;
          }
          localObject2 = paramFragmentComponent.eventBus();
          localObject3 = paramFragmentComponent.activity();
          localObject1 = new TypeaheadSmallViewModel();
          localObject4 = SearchResultPageOrigin.AUTO_COMPLETE;
          if (!hitInfo.typeaheadAutoCompleteValue.hasDisplayText) {
            break label1557;
          }
        }
        label1557:
        for (name = AttributedTextUtils.getAttributedString(hitInfo.typeaheadAutoCompleteValue.displayText, (Context)localObject3);; name = AnnotatedTextUtils.getCharSequenceFromAnnotatedText$706ef64d((Context)localObject3, text))
        {
          position = paramInt1;
          suggestionLogo = 2130838323;
          listener = new TypeaheadTransformer.5(this, paramFragmentComponent.tracker(), "search_tyah_result", new TrackingEventBuilder[0], (Bus)localObject2, localTypeaheadHit, paramBoolean, paramFragmentComponent, paramString1, (SearchResultPageOrigin)localObject4, (TypeaheadSmallViewModel)localObject1, paramSparseIntArray, paramString2);
          break;
          j = 0;
          break label1421;
        }
        label1575:
        if (paramBoolean)
        {
          localObject2 = paramFragmentComponent.eventBus();
          localObject3 = paramFragmentComponent.activity();
          localObject1 = new TypeaheadSmallNoIconViewModel();
          name = AnnotatedTextUtils.getCharSequenceFromAnnotatedText$706ef64d((Context)localObject3, text);
          listener = new TypeaheadTransformer.6(this, (Bus)localObject2, localTypeaheadHit);
        }
        else
        {
          localObject1 = null;
        }
      }
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.typeahead.TypeaheadTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */