package com.linkedin.android.search.resourcelist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;

public abstract class ResourceListFragment<T extends FissileDataModel<T>, V extends ViewModel>
  extends PageFragment
{
  ViewModelArrayAdapter<V> adapter;
  CollectionTemplateHelper<T, CollectionMetadata> collectionHelper;
  @InjectView(2131758546)
  RecyclerView recyclerView;
  
  public abstract FissileDataModelBuilder<T> getDataBuilder();
  
  public abstract String getRoute();
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969407, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = fragmentComponent;
    adapter = new ViewModelArrayAdapter(paramView.activity(), applicationComponent.mediaCenter(), null);
    recyclerView.setLayoutManager(new LinearLayoutManager(paramView.activity()));
    recyclerView.setAdapter(adapter);
    collectionHelper = new CollectionTemplateHelper(paramView.dataManager(), null, getDataBuilder(), CollectionMetadata.BUILDER);
    collectionHelper.fetchInitialData(Tracker.createPageInstanceHeader(getPageInstance()), 2, getRoute(), new ResourceListFragment.1(this), null);
  }
  
  public abstract V transformModel(T paramT);
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.resourcelist.ResourceListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */