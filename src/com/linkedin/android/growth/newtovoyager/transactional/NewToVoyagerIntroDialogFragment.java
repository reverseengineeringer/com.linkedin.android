package com.linkedin.android.growth.newtovoyager.transactional;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.view.LayoutInflater;
import android.view.View;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseDialogFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;

public class NewToVoyagerIntroDialogFragment
  extends BaseDialogFragment
{
  public static final String TAG = NewToVoyagerIntroDialogFragment.class.getSimpleName();
  private LegoTrackingDataProvider legoTrackingDataProvider;
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new AlertDialog.Builder(getActivity());
    View localView = getActivity().getLayoutInflater().inflate(2130968826, null);
    ApplicationComponent localApplicationComponent = getBaseActivityapplicationComponent;
    legoTrackingDataProvider = getBaseActivityactivityComponent.legoTrackingDataProvider();
    Object localObject = new NewToVoyagerIntroViewTransformer.NewToVoyagerIntroListener()
    {
      public final void dismiss()
      {
        String str = getArguments().getString("legoTrackingTokenKey");
        if (legoTrackingDataProvider != null) {
          legoTrackingDataProvider.sendActionEvent$67c7f505(str, ActionCategory.DISMISS);
        }
        NewToVoyagerIntroDialogFragment.this.dismiss();
      }
    };
    NewToVoyagerIntroViewModel localNewToVoyagerIntroViewModel = new NewToVoyagerIntroViewModel();
    MiniProfile localMiniProfile = localApplicationComponent.memberUtil().getMiniProfile();
    I18NManager localI18NManager = localApplicationComponent.i18NManager();
    if (localMiniProfile != null) {
      title = localI18NManager.getString(2131231490, new Object[] { I18NManager.getName(localMiniProfile) });
    }
    okayButtonOnClickListener = new NewToVoyagerIntroViewTransformer.1((NewToVoyagerIntroViewTransformer.NewToVoyagerIntroListener)localObject);
    localObject = (NewToVoyagerIntroViewHolder)NewToVoyagerIntroViewHolder.CREATOR.createViewHolder(localView);
    getActivity().getLayoutInflater();
    localApplicationComponent.mediaCenter();
    localNewToVoyagerIntroViewModel.onBindViewHolder$5e7e9a38((NewToVoyagerIntroViewHolder)localObject);
    paramBundle.setView(localView);
    paramBundle = paramBundle.create();
    paramBundle.setCanceledOnTouchOutside(false);
    return paramBundle;
  }
  
  public void onStart()
  {
    super.onStart();
    String str = getArguments().getString("legoTrackingTokenKey");
    if (legoTrackingDataProvider != null) {
      legoTrackingDataProvider.sendWidgetImpressionEvent$4bb724c7(str, Visibility.SHOW);
    }
  }
  
  public final String pageKey()
  {
    return "onboarding_new_to_voyager_txn";
  }
  
  public final boolean shouldTrackPageView()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */