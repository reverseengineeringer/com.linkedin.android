package com.linkedin.android.infra.debug.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.debug.viewmodels.SharedPreferenceViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SharedPreferenceDebugFragment
  extends PageFragment
{
  private ViewModelArrayAdapter<SharedPreferenceViewModel> adapter;
  @InjectView(2131756567)
  RecyclerView recyclerView;
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968949, paramViewGroup, false);
  }
  
  public void onStart()
  {
    super.onStart();
    Object localObject = getActivity().getSharedPreferences("linkedInPrefsName", 0);
    ArrayList localArrayList = new ArrayList();
    localObject = ((SharedPreferences)localObject).getAll().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      SharedPreferenceViewModel localSharedPreferenceViewModel = new SharedPreferenceViewModel();
      key = ((String)localEntry.getKey());
      value = localEntry.getValue();
      localArrayList.add(localSharedPreferenceViewModel);
    }
    adapter.setValues(localArrayList);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    adapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    recyclerView.setAdapter(adapter);
  }
  
  public final String pageKey()
  {
    return "";
  }
  
  public final boolean shouldTrack()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.debug.ui.SharedPreferenceDebugFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */