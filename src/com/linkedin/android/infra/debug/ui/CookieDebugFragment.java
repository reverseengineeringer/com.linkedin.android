package com.linkedin.android.infra.debug.ui;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import butterknife.OnClick;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.debug.viewmodels.CookieViewModel;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.networking.cookies.CookieUtil;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class CookieDebugFragment
  extends PageFragment
{
  private static final String TAG = CookieDebugFragment.class.getSimpleName();
  private SearchableViewModelAdapter<CookieViewModel> adapter;
  private BroadcastReceiver broadcastReceiver;
  @Inject
  CookieUtil cookieUtil;
  @InjectView(2131756525)
  RecyclerView recyclerView;
  @InjectView(2131756524)
  SearchView searchView;
  @InjectView(2131756523)
  Toolbar toolbar;
  
  private void update()
  {
    FragmentManager localFragmentManager = getFragmentManager();
    Object localObject = cookieUtil.cookieManager().getCookieStore().getCookies();
    ArrayList localArrayList = new ArrayList();
    localObject = Util.safeGet((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      HttpCookie localHttpCookie = (HttpCookie)((Iterator)localObject).next();
      localArrayList.add(new CookieViewModel(localHttpCookie, new CookieDebugFragment.4(this, localHttpCookie, localFragmentManager)));
    }
    adapter.setValues(localArrayList);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    broadcastReceiver = new CookieDebugFragment.1(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("CookieEditDialogFragment.UPDATE_EVENT");
    paramBundle.addAction("CookieEditDialogFragment.DELETE_EVENT");
    LocalBroadcastManager.getInstance(getContext()).registerReceiver(broadcastReceiver, paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968931, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(broadcastReceiver);
  }
  
  public void onStart()
  {
    super.onStart();
    update();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    adapter = new SearchableViewModelAdapter(getActivity(), applicationComponent.mediaCenter());
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    recyclerView.setAdapter(adapter);
    searchView.setOnQueryTextListener(new CookieDebugFragment.2(this));
    toolbar.setNavigationOnClickListener(new CookieDebugFragment.3(this));
  }
  
  public final String pageKey()
  {
    return "";
  }
  
  public final boolean shouldTrack()
  {
    return false;
  }
  
  @OnClick({2131756526})
  public void showCreateNewCookieDialog()
  {
    CookieEditDialogFragment.newInstance(null).show(getFragmentManager(), TAG);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.debug.ui.CookieDebugFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */