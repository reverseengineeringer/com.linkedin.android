package com.linkedin.android.entities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.InjectView;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Util;

public class EntityHeadlessProfilePageFragment
  extends BaseFragment
{
  @InjectView(2131755480)
  Button backButton;
  
  public static EntityHeadlessProfilePageFragment newInstance(EntityHeadlessProfilePageBundleBuilder paramEntityHeadlessProfilePageBundleBuilder)
  {
    EntityHeadlessProfilePageFragment localEntityHeadlessProfilePageFragment = new EntityHeadlessProfilePageFragment();
    localEntityHeadlessProfilePageFragment.setArguments(bundle);
    return localEntityHeadlessProfilePageFragment;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968681, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    switch (getArguments().getInt("entityType"))
    {
    default: 
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Unsupported entityType for EntityHeadlessProfilePageFragment"));
    }
    for (;;)
    {
      backButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (isResumed()) {
            getActivity().onBackPressed();
          }
        }
      });
      return;
      backButton.setText(fragmentComponent.i18NManager().getString(2131231006));
      continue;
      backButton.setText(fragmentComponent.i18NManager().getString(2131230825));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityHeadlessProfilePageFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */