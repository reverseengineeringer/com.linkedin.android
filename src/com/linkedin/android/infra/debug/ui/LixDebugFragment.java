package com.linkedin.android.infra.debug.ui;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.debug.viewmodels.LixViewModel;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixDefinition;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.lix.PreAuthLix;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.networking.cookies.CookieUtil;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public class LixDebugFragment
  extends PageFragment
{
  public static final String TAG = LixDebugFragment.class.getSimpleName();
  private SearchableViewModelAdapter adapter;
  private String baseUrl;
  private BroadcastReceiver broadcastReceiver;
  @Inject
  CookieUtil cookieUtil;
  @InjectView(2131756542)
  TextView legend;
  @InjectView(2131756546)
  FloatingActionButton lixAddButton;
  private LixManager lixManager;
  @InjectView(2131756543)
  Button lixResetButton;
  private PreAuthLixManager preAuthLixManager;
  @InjectView(2131756545)
  RecyclerView recyclerView;
  @InjectView(2131756544)
  SearchView searchView;
  
  private static LixViewModel createLixModel(LixDebugFragment paramLixDebugFragment, FragmentManager paramFragmentManager, LixManager paramLixManager, LixDefinition paramLixDefinition, int paramInt)
  {
    return createLixModel(paramLixDebugFragment, paramFragmentManager, paramLixManager, paramLixDefinition.getName(), paramLixManager.getTreatment(paramLixDefinition), paramInt);
  }
  
  private static LixViewModel createLixModel(LixDebugFragment paramLixDebugFragment, FragmentManager paramFragmentManager, LixManager paramLixManager, String paramString1, String paramString2, int paramInt)
  {
    LixViewModel localLixViewModel = new LixViewModel();
    lixType = paramInt;
    name = paramString1;
    treatment = paramString2;
    clickListener = new LixDebugFragment.7(paramString1, paramString2, paramFragmentManager, paramInt, paramLixDebugFragment, paramLixManager);
    return localLixViewModel;
  }
  
  private void update()
  {
    Map localMap = cookieUtil.getLixOverrideKeyValues(baseUrl);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new SimpleArrayMap();
    Object localObject2 = PreAuthLix.values();
    int j = localObject2.length;
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject3 = localObject2[i];
      ((SimpleArrayMap)localObject1).put(localObject3, defaultTreatment);
      i += 1;
    }
    localObject1 = new ArrayList(new ArrayMap((SimpleArrayMap)localObject1).keySet());
    Collections.sort((List)localObject1, new LixDebugFragment.5(this));
    i = 0;
    j = ((List)localObject1).size();
    while (i < j)
    {
      localObject2 = (LixDefinition)((List)localObject1).get(i);
      localArrayList.add(createLixModel(this, getFragmentManager(), preAuthLixManager, (LixDefinition)localObject2, 0));
      if (localMap.containsKey(((LixDefinition)localObject2).getName())) {
        localMap.remove(((LixDefinition)localObject2).getName());
      }
      i += 1;
    }
    localObject1 = new SimpleArrayMap();
    localObject2 = Lix.values();
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject2[i];
      ((SimpleArrayMap)localObject1).put(localObject3, defaultTreatment);
      i += 1;
    }
    localObject2 = new ArrayList(new ArrayMap((SimpleArrayMap)localObject1).keySet());
    Collections.sort((List)localObject2, new LixDebugFragment.6(this));
    i = 0;
    j = ((SimpleArrayMap)localObject1).size();
    while (i < j)
    {
      localObject1 = (LixDefinition)((List)localObject2).get(i);
      localArrayList.add(createLixModel(this, getFragmentManager(), lixManager, (LixDefinition)localObject1, 1));
      if (localMap.containsKey(((LixDefinition)localObject1).getName())) {
        localMap.remove(((LixDefinition)localObject1).getName());
      }
      i += 1;
    }
    localObject1 = new ArrayList(localMap.keySet());
    Collections.sort((List)localObject1);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localArrayList.add(createLixModel(this, getFragmentManager(), lixManager, (String)localObject2, (String)localMap.get(localObject2), 2));
    }
    adapter.setValues(localArrayList);
    if (searchView != null) {
      adapter.setFilterText(searchView.getQuery().toString());
    }
  }
  
  @OnClick({2131756543})
  public void clearLixOverrideCookieAndTriggerSync()
  {
    CookieUtil localCookieUtil = cookieUtil;
    String str = baseUrl;
    HttpCookie localHttpCookie = localCookieUtil.getCookieWithName("lror", str);
    if (localHttpCookie != null) {
      localCookieUtil.cookieManager().getCookieStore().remove(CookieUtil.uriForString(str), localHttpCookie);
    }
    lixManager.triggerSync(true);
    preAuthLixManager.triggerSync(true);
    update();
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    lixManager = fragmentComponent.lixManager();
    preAuthLixManager = fragmentComponent.preAuthLixManager();
    baseUrl = fragmentComponent.flagshipSharedPreferences().getBaseUrl();
    broadcastReceiver = new LixDebugFragment.1(this);
    LocalBroadcastManager.getInstance(getContext()).registerReceiver(broadcastReceiver, new IntentFilter("LIX_DIALOG_DISMISS_EVENT"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968938, paramViewGroup, false);
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
    searchView.setOnCloseListener(new LixDebugFragment.2(this));
    searchView.setOnSearchClickListener(new LixDebugFragment.3(this));
    searchView.setOnQueryTextListener(new LixDebugFragment.4(this));
  }
  
  public final String pageKey()
  {
    return "";
  }
  
  public final boolean shouldTrack()
  {
    return false;
  }
  
  @OnClick({2131756546})
  public void showLixOverrideDialog()
  {
    LixOverrideDialogFragment.newInstance(null, null).show(getFragmentManager(), TAG);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.debug.ui.LixDebugFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */