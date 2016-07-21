package com.linkedin.android.growth.login.sso;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.growth.login.LoginTransformer.1;
import com.linkedin.android.growth.login.LoginTransformer.2;
import com.linkedin.android.growth.login.LoginTransformer.3;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.liauthlib.common.LiSSOInfo;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.List;

public class SSOFragment
  extends PageFragment
{
  private static final String TAG = SSOFragment.class.getSimpleName();
  protected PreRegListener preRegListener;
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof PreRegListener))
    {
      preRegListener = ((PreRegListener)paramActivity);
      return;
    }
    Util.safeThrow$7a8b4789(new IllegalStateException(TAG + " attached to an Activity that does not implement PreRegListener"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968878, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    SSOManager localSSOManager = fragmentComponent.activity().activityComponent.ssoManager();
    Object localObject = Util.safeGet(localSSOManager.getSSOUsers());
    int i = ((List)localObject).size() - 1;
    while (i >= 0)
    {
      LiSSOInfo localLiSSOInfo = (LiSSOInfo)((List)localObject).get(i);
      if ((localLiSSOInfo != null) && (!TextUtils.isEmpty(firstName)))
      {
        paramView = (SSOFragmentViewHolder)SSOFragmentViewHolder.CREATOR.createViewHolder(paramView);
        localObject = (BaseActivity)getActivity();
        FragmentComponent localFragmentComponent = fragmentComponent;
        PreRegListener localPreRegListener = preRegListener;
        I18NManager localI18NManager = localFragmentComponent.i18NManager();
        SSOFragmentViewModel localSSOFragmentViewModel = new SSOFragmentViewModel();
        profilePictureUrl = pictureUrl;
        continueText = localI18NManager.getNamedString(2131231737, firstName, "", "");
        continueListener = new LoginTransformer.1(localFragmentComponent.tracker(), "continue", new TrackingEventBuilder[0], localSSOManager, localLiSSOInfo, (Context)localObject, localPreRegListener);
        signInText = localI18NManager.getNamedString(2131231742, firstName, "", "");
        signInListener = new LoginTransformer.2(localFragmentComponent.tracker(), "sign_in_different", new TrackingEventBuilder[0], localPreRegListener);
        joinNowListener = new LoginTransformer.3(localFragmentComponent.tracker(), "join", new TrackingEventBuilder[0], localPreRegListener);
        localSSOFragmentViewModel.onBindViewHolder(getLayoutInflater(paramBundle), fragmentComponent.mediaCenter(), paramView);
        return;
      }
      i -= 1;
    }
    getActivity();
    Util.safeThrow$7a8b4789(new IllegalStateException("SSO should not have started if there is no valid SSO user"));
  }
  
  public final String pageKey()
  {
    return "reg_sign_in_sso";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.sso.SSOFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */