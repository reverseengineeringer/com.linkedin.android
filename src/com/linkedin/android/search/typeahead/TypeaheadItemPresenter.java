package com.linkedin.android.search.typeahead;

import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistory;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.android.search.FollowingInfoChangeListener;
import com.linkedin.android.search.SearchDataProvider;
import com.linkedin.android.search.shared.SearchTracking;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.search.ui.SearchHistoryBar;
import com.linkedin.consistency.ModelListConsistencyCoordinator;
import com.linkedin.consistency.ModelListItemChangedListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public final class TypeaheadItemPresenter
  implements FollowingInfoChangeListener<TypeaheadLargeEntityViewModel>
{
  EndlessViewModelAdapter<ViewModel> adapter;
  ModelListConsistencyCoordinator<FollowingInfo> consistencyCoordinator;
  SearchDataProvider dataProvider;
  @Inject
  DelayedExecution delayedExecution;
  boolean fakeHitAtTop;
  final FragmentComponent fragmentComponent;
  boolean hasFakeHit;
  SearchHistoryBar historyBar;
  boolean isLoadingRunnableScheduled;
  boolean isPickerMode;
  @Inject
  KeyboardUtil keyboardUtil;
  LinearLayoutManager layoutManager;
  Runnable loadingRunnable;
  private final String memberId;
  Map<String, TypeaheadLargeEntityViewModel> modelMap;
  private final SparseIntArray starterPositionMap;
  @Inject
  Tracker tracker;
  TypeaheadItemPresenter.TrackingRunnable trackingRunnable;
  List<TypeaheadHit> typeaheadHitList;
  SparseIntArray typeaheadPositionMap;
  @Inject
  TypeaheadTransformer typeaheadTransformer;
  final ModelListItemChangedListener<FollowingInfo> updateChangedListener = new TypeaheadItemPresenter.1(this);
  
  @Inject
  public TypeaheadItemPresenter(MediaCenter paramMediaCenter, FragmentComponent paramFragmentComponent)
  {
    fragmentComponent = paramFragmentComponent;
    adapter = new EndlessViewModelAdapter(paramFragmentComponent.activity(), paramMediaCenter, null);
    memberId = String.valueOf(paramFragmentComponent.memberUtil().getMemberId());
    starterPositionMap = new SparseIntArray();
    typeaheadPositionMap = new SparseIntArray();
    typeaheadHitList = new ArrayList();
    loadingRunnable = new TypeaheadItemPresenter.2(this);
  }
  
  private static void adjustDivider(List<ViewModel> paramList, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if (i < paramList.size() - 1)
    {
      ViewModel localViewModel1 = (ViewModel)paramList.get(i);
      ViewModel localViewModel2 = (ViewModel)paramList.get(i + 1);
      if (getType(localViewModel1) != getType(localViewModel2)) {
        setDividerToType(localViewModel1, 1);
      }
      for (;;)
      {
        i += 1;
        break;
        setDividerToType(localViewModel1, 0);
      }
    }
    if (!paramList.isEmpty()) {
      if (!paramBoolean) {
        break label114;
      }
    }
    label114:
    for (i = j;; i = 2)
    {
      setDividerToType((ViewModel)paramList.get(paramList.size() - 1), i);
      return;
    }
  }
  
  private static int getType(ViewModel paramViewModel)
  {
    if ((paramViewModel instanceof TypeaheadSmallViewModel)) {
      return 3;
    }
    if ((paramViewModel instanceof TypeaheadLargeEntityViewModel)) {
      return 1;
    }
    if ((paramViewModel instanceof TypeaheadSuggestionViewModel)) {
      return 2;
    }
    return 0;
  }
  
  private static void setDividerToType(ViewModel paramViewModel, int paramInt)
  {
    if ((paramViewModel instanceof TypeaheadLargeEntityViewModel)) {
      dividerType = paramInt;
    }
    do
    {
      return;
      if ((paramViewModel instanceof TypeaheadSmallViewModel))
      {
        dividerType = paramInt;
        return;
      }
    } while (!(paramViewModel instanceof TypeaheadSuggestionViewModel));
    dividerType = paramInt;
  }
  
  public final void trackTypeaheadImpression(String paramString1, String paramString2, int paramInt)
  {
    SearchTracking.trackTypeaheadImpressions(fragmentComponent.tracker(), paramString1, paramInt, typeaheadHitList, typeaheadPositionMap, paramString2);
  }
  
  public final void updateStarterData(List<SearchHistory> paramList, boolean paramBoolean)
  {
    if (!paramList.isEmpty()) {
      historyBar.setVisibility(0);
    }
    String str = SearchUtils.generateSearchId(memberId);
    adapter.setValues(typeaheadTransformer.transformHistoryToModelList(fragmentComponent, paramList, starterPositionMap, str));
    if (paramBoolean) {
      SearchTracking.trackStarterImpressions(fragmentComponent.tracker(), str, paramList, starterPositionMap);
    }
  }
  
  public final void updateTypeaheadData(String paramString1, List<TypeaheadHit> paramList, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    Object localObject;
    if (isPickerMode)
    {
      if (TextUtils.isEmpty(paramString1))
      {
        adapter.setValues(typeaheadTransformer.transformTypeAheadToModelList(fragmentComponent, paramList, isPickerMode, paramString1, null, paramString2, 1, 0));
        return;
      }
      paramList = new ArrayList(paramList);
      localObject = SearchUtils.getFakedHit(paramString1);
      if ((hasFakeHit) && (fakeHitAtTop)) {
        paramList.add(0, localObject);
      }
      for (;;)
      {
        adapter.setValues(typeaheadTransformer.transformTypeAheadToModelList(fragmentComponent, paramList, isPickerMode, paramString1, null, paramString2, 1, 0));
        return;
        if ((hasFakeHit) && (!fakeHitAtTop)) {
          paramList.add(localObject);
        }
      }
    }
    int i;
    label151:
    FragmentComponent localFragmentComponent;
    boolean bool;
    SparseIntArray localSparseIntArray;
    int j;
    if (paramBoolean2)
    {
      i = paramList.size();
      localObject = typeaheadTransformer;
      localFragmentComponent = fragmentComponent;
      bool = isPickerMode;
      localSparseIntArray = typeaheadPositionMap;
      if (!paramBoolean2) {
        break label376;
      }
      j = 1;
      label183:
      if (!paramBoolean2) {
        break label385;
      }
    }
    label376:
    label385:
    for (int k = i;; k = 0)
    {
      localObject = ((TypeaheadTransformer)localObject).transformTypeAheadToModelList(localFragmentComponent, paramList, bool, paramString1, localSparseIntArray, paramString2, j, k);
      historyBar.hideAndRestore();
      j = adapter.getValues().size();
      adapter.appendValues((List)localObject);
      layoutManager.scrollToPosition(0);
      adjustDivider(adapter.getValues(), paramBoolean2);
      if (j > 0) {
        adapter.notifyItemChanged(j - 1);
      }
      if (trackingRunnable != null) {
        delayedExecution.stopDelayedExecution(trackingRunnable);
      }
      trackingRunnable = new TypeaheadItemPresenter.TrackingRunnable(tracker);
      delayedExecution.postDelayedExecution(trackingRunnable, 500L);
      typeaheadHitList.addAll(paramList);
      SearchTracking.prepareVerticalPositionMap(typeaheadHitList, typeaheadPositionMap);
      if (!paramBoolean1) {
        break;
      }
      trackTypeaheadImpression(paramString1, paramString2, i);
      return;
      i = typeaheadHitList.size();
      break label151;
      j = i + 1;
      break label183;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.typeahead.TypeaheadItemPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */