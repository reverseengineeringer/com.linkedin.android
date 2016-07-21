package com.linkedin.android.search.starter;

import android.util.SparseIntArray;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHistory;
import com.linkedin.android.search.shared.SearchTracking;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.search.typeahead.TypeaheadTransformer;
import java.util.List;
import javax.inject.Inject;

public final class SearchStarterItemPresenter
{
  final EndlessViewModelAdapter<ViewModel> adapter;
  private final FragmentComponent fragmentComponent;
  final SparseIntArray positionMap;
  private final TypeaheadTransformer typeaheadTransformer;
  
  @Inject
  public SearchStarterItemPresenter(TypeaheadTransformer paramTypeaheadTransformer, ActivityComponent paramActivityComponent, FragmentComponent paramFragmentComponent)
  {
    fragmentComponent = paramFragmentComponent;
    typeaheadTransformer = paramTypeaheadTransformer;
    positionMap = new SparseIntArray();
    adapter = new EndlessViewModelAdapter(paramActivityComponent.activity(), paramFragmentComponent.mediaCenter(), null);
  }
  
  public final void showLoadingView(boolean paramBoolean)
  {
    EndlessViewModelAdapter localEndlessViewModelAdapter = adapter;
    if ((paramBoolean) && (adapter.isEmpty())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localEndlessViewModelAdapter.showLoadingView(paramBoolean);
      return;
    }
  }
  
  public final void updateData(List<SearchHistory> paramList)
  {
    adapter.showLoadingView(false);
    String str = SearchUtils.generateSearchId(String.valueOf(fragmentComponent.memberUtil().getMemberId()));
    adapter.setValues(typeaheadTransformer.transformHistoryToModelList(fragmentComponent, paramList, positionMap, str));
    SearchTracking.trackStarterImpressions(fragmentComponent.tracker(), str, paramList, positionMap);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.starter.SearchStarterItemPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */