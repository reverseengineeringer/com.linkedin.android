package com.linkedin.android.search.searchengine;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.DrawableHelper;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.LongClickUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHit;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHit.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.search.SearchProfile;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;
import com.linkedin.android.pegasus.gen.voyager.search.SecondaryResult;
import com.linkedin.android.pegasus.gen.voyager.search.SecondaryResultContainer;
import com.linkedin.android.pegasus.gen.voyager.search.Snippet;
import com.linkedin.android.relationships.shared.AnnotatedTextUtils;
import com.linkedin.android.search.SearchDataProvider;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public final class SearchEngineTransformer
{
  final SearchDataProvider dataProvider;
  private Handler handler = new Handler(Looper.getMainLooper());
  private final LongClickUtil longClickUtil;
  SearchEngineViewModel revealedViewModel;
  private Runnable revealedViewModelRunnable = new SearchEngineTransformer.1(this);
  
  @Inject
  public SearchEngineTransformer(ActivityComponent paramActivityComponent)
  {
    dataProvider = paramActivityComponent.searchDataProvider();
    longClickUtil = paramActivityComponent.longClickUtil();
  }
  
  private void setupActionClickListener(FragmentComponent paramFragmentComponent, SearchHit paramSearchHit, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, SearchEngineViewModel paramSearchEngineViewModel)
  {
    ctaButtonListener = new SearchEngineTransformer.6(this, paramFragmentComponent.tracker(), paramSearchEngineViewModel, paramFragmentComponent, paramSearchHit, paramString1, paramInt1, paramInt2, paramString2, paramString3);
  }
  
  public static SearchEngineEmptyStateViewModel transformToEmptyResultViewModel(FragmentComponent paramFragmentComponent)
  {
    SearchEngineEmptyStateViewModel localSearchEngineEmptyStateViewModel = new SearchEngineEmptyStateViewModel();
    imageResource = 2130838520;
    title = paramFragmentComponent.i18NManager().getString(2131233526);
    subtitle = paramFragmentComponent.i18NManager().getString(2131233525);
    return localSearchEngineEmptyStateViewModel;
  }
  
  private SearchEngineSecondaryResultsViewModel transformToSecondaryResultsViewModel(FragmentComponent paramFragmentComponent, SearchHit paramSearchHit, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    SearchEngineSecondaryResultsViewModel localSearchEngineSecondaryResultsViewModel = new SearchEngineSecondaryResultsViewModel();
    SecondaryResultContainer localSecondaryResultContainer = hitInfo.secondaryResultContainerValue;
    int j = 0;
    if (j < secondaryResults.size())
    {
      SecondaryResult localSecondaryResult = (SecondaryResult)secondaryResults.get(j);
      Object localObject = paramFragmentComponent.i18NManager();
      Tracker localTracker = paramFragmentComponent.tracker();
      Bus localBus = paramFragmentComponent.eventBus();
      List localList = clusterNames;
      label133:
      int i;
      switch (SearchEngineTransformer.12.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$search$SearchType[type.ordinal()])
      {
      default: 
        localObject = "";
        localList.add(localObject);
        localObject = imageResources;
        switch (SearchEngineTransformer.12.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$search$SearchType[type.ordinal()])
        {
        default: 
          i = 0;
        }
        break;
      }
      for (;;)
      {
        ((List)localObject).add(Integer.valueOf(i));
        listeners.add(new SearchEngineTransformer.2(this, localTracker, "search_srp_cluster", new TrackingEventBuilder[0], localBus, localSecondaryResult, localTracker, paramString1, paramSearchHit, paramInt1, paramInt2, paramString2, paramString3));
        j += 1;
        break;
        localObject = ((I18NManager)localObject).getString(2131233533);
        break label133;
        localObject = ((I18NManager)localObject).getString(2131233532);
        break label133;
        localObject = ((I18NManager)localObject).getString(2131233531);
        break label133;
        localObject = ((I18NManager)localObject).getString(2131233534);
        break label133;
        i = 2130837920;
        continue;
        i = 2130838046;
        continue;
        i = 2130837961;
        continue;
        i = 2130838314;
      }
    }
    return localSearchEngineSecondaryResultsViewModel;
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
  
  public final List<SearchEngineViewModel> transformToEngineViewModelWithBackground(FragmentComponent paramFragmentComponent, List<SearchHit> paramList, String paramString1, SparseIntArray paramSparseIntArray, int paramInt, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = paramInt;
    paramInt = 0;
    if (paramInt < paramList.size())
    {
      SearchHit localSearchHit = (SearchHit)paramList.get(paramInt);
      int k = paramSparseIntArray.get(i);
      BaseActivity localBaseActivity = paramFragmentComponent.activity();
      IntentRegistry localIntentRegistry = paramFragmentComponent.intentRegistry();
      I18NManager localI18NManager = paramFragmentComponent.i18NManager();
      SearchEngineViewModel localSearchEngineViewModel = new SearchEngineViewModel();
      type = SearchType.PEOPLE;
      SearchProfile localSearchProfile = hitInfo.searchProfileValue;
      image = new ImageModel(miniProfile.picture, GhostImageUtils.getPerson(2131492962, miniProfile), Util.retrieveRumSessionId(paramFragmentComponent));
      degree = SearchUtils.getDegree(distance, localI18NManager);
      Object localObject3 = miniProfile.firstName;
      Object localObject2 = miniProfile.lastName;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      label216:
      int j;
      boolean bool1;
      boolean bool2;
      if ((TextUtils.isEmpty((CharSequence)localObject3)) && (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        localObject1 = localI18NManager.getString(2131232803);
        name = ((CharSequence)localObject1);
        localObject1 = snippets;
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()) && (get0fieldType != null)) {
          break label593;
        }
        localObject1 = null;
        snippet = ((CharSequence)localObject1);
        metaData = location;
        localObject3 = localBaseActivity.getResources();
        localObject2 = ResourcesCompat.getDrawable((Resources)localObject3, 2130838119, localBaseActivity.getTheme());
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          j = (int)((Resources)localObject3).getDimension(2131493537);
          ((Drawable)localObject2).setBounds(0, 0, j, j);
          localObject1 = DrawableHelper.setTint((Drawable)localObject2, ContextCompat.getColor(localBaseActivity, 2131624083));
        }
        metaDataIcon = ((Drawable)localObject1);
        occupation = miniProfile.occupation;
        graphDistance = distance.value;
        position = i;
        if (headless) {
          break label897;
        }
        listener = new SearchEngineTransformer.3(this, paramFragmentComponent.tracker(), "search_srp_result", new TrackingEventBuilder[0], localSearchEngineViewModel, localBaseActivity, localIntentRegistry, localSearchProfile, localSearchHit, localI18NManager, paramFragmentComponent, paramString1, i, k, paramString2, paramString3);
        bool1 = SearchUtils.shouldShowInviteView(paramFragmentComponent, distance);
        bool2 = SearchUtils.shouldShowSendMessageView(paramFragmentComponent, distance);
        if ((!SearchUtils.shouldShowInviteMessageInSearchResultsAndTypeAhead(paramFragmentComponent)) && (!SearchUtils.shouldShowInviteMessageInSearchResultsOnly(paramFragmentComponent))) {
          break label844;
        }
        j = 1;
        label485:
        if (j == 0) {
          break label850;
        }
        alwaysShowCtaButtons = true;
        setupActionClickListener(paramFragmentComponent, localSearchHit, paramString1, i, k, paramString2, paramString3, localSearchEngineViewModel);
        label514:
        if (paramInt != 0) {
          break label938;
        }
        backgroundType = 0;
        if (paramList.size() == 1) {
          backgroundType = 3;
        }
      }
      for (;;)
      {
        localArrayList.add(localSearchEngineViewModel);
        i += 1;
        paramInt += 1;
        break;
        localObject1 = localI18NManager.getString(2131233236, new Object[] { I18NManager.getName((String)localObject3, (String)localObject1) });
        break label216;
        label593:
        localObject2 = (Snippet)((List)localObject1).get(0);
        localObject3 = fieldType;
        localObject1 = new SpannableStringBuilder();
        switch (SearchEngineTransformer.12.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$search$SnippetField[localObject3.ordinal()])
        {
        }
        for (;;)
        {
          if (hasHeading) {
            ((SpannableStringBuilder)localObject1).append(AnnotatedTextUtils.getCharSequenceFromAnnotatedText$706ef64d(localBaseActivity, heading));
          }
          if (!TextUtils.isEmpty(body.text))
          {
            if (hasHeading) {
              ((SpannableStringBuilder)localObject1).append("\n");
            }
            ((SpannableStringBuilder)localObject1).append(AnnotatedTextUtils.getCharSequenceFromAnnotatedText$706ef64d(localBaseActivity, body));
          }
          break;
          ((SpannableStringBuilder)localObject1).append(localI18NManager.getString(2131233506));
          continue;
          ((SpannableStringBuilder)localObject1).append(localI18NManager.getString(2131233557));
          continue;
          ((SpannableStringBuilder)localObject1).append(localI18NManager.getString(2131233509));
          continue;
          ((SpannableStringBuilder)localObject1).append(localI18NManager.getString(2131233573));
          continue;
          ((SpannableStringBuilder)localObject1).append(localI18NManager.getString(2131233572));
          continue;
          ((SpannableStringBuilder)localObject1).append(localI18NManager.getString(2131233571));
        }
        label844:
        j = 0;
        break label485;
        label850:
        if ((!bool1) && (!bool2)) {
          break label514;
        }
        longClickListener = new SearchEngineTransformer.5(this, localSearchEngineViewModel, paramFragmentComponent);
        setupActionClickListener(paramFragmentComponent, localSearchHit, paramString1, i, k, paramString2, paramString3, localSearchEngineViewModel);
        break label514;
        label897:
        listener = new SearchEngineTransformer.4(this, paramFragmentComponent.tracker(), "search_srp_result", new TrackingEventBuilder[0], localSearchHit, paramFragmentComponent, paramString1, i, k, paramString2, paramString3);
        break label514;
        label938:
        if (paramInt == paramList.size() - 1) {
          backgroundType = 2;
        } else {
          backgroundType = 1;
        }
      }
    }
    return localArrayList;
  }
  
  public final List<ViewModel> transformToViewModelList(FragmentComponent paramFragmentComponent, List<SearchHit> paramList, String paramString1, int paramInt, SparseIntArray paramSparseIntArray, String paramString2, String paramString3)
  {
    int i = paramInt;
    ArrayList localArrayList1 = new ArrayList(paramList.size());
    if (CollectionUtils.isEmpty(paramList))
    {
      localArrayList1.add(transformToEmptyResultViewModel(paramFragmentComponent));
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList(10);
    int j = 0;
    paramInt = 0;
    label58:
    SearchHit localSearchHit;
    int m;
    label114:
    int k;
    if (paramInt < paramList.size())
    {
      localSearchHit = (SearchHit)paramList.get(paramInt);
      if (hitInfo.secondaryResultContainerValue != null) {
        break label238;
      }
      localArrayList2.add(localSearchHit);
      if (j == 0) {
        break label231;
      }
      m = paramInt - 1;
      k = j;
      if (!localArrayList2.isEmpty()) {
        if ((m % 10 != 9) && (localArrayList2.size() != 10))
        {
          k = j;
          if (paramInt != paramList.size() - 1) {}
        }
        else
        {
          localArrayList1.addAll(transformToEngineViewModelWithBackground(paramFragmentComponent, localArrayList2, paramString1, paramSparseIntArray, i - localArrayList2.size() + 1, paramString2, paramString3));
          localArrayList2.clear();
          k = j;
        }
      }
    }
    for (;;)
    {
      i += 1;
      paramInt += 1;
      j = k;
      break label58;
      break;
      label231:
      m = paramInt;
      break label114;
      label238:
      k = 1;
      j = localArrayList2.size();
      if (!localArrayList2.isEmpty()) {
        localArrayList1.addAll(transformToEngineViewModelWithBackground(paramFragmentComponent, localArrayList2, paramString1, paramSparseIntArray, i - j, paramString2, paramString3));
      }
      localArrayList2.clear();
      localArrayList1.add(transformToSecondaryResultsViewModel(paramFragmentComponent, localSearchHit, paramString1, i, paramSparseIntArray.get(i), paramString2, paramString3));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.searchengine.SearchEngineTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */