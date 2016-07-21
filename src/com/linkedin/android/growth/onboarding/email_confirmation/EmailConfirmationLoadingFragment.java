package com.linkedin.android.growth.onboarding.email_confirmation;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.ConfirmEmailAddress.DeepLinkEmailManagementController;
import com.linkedin.android.ConfirmEmailAddress.DeepLinkEmailManagementController.1;
import com.linkedin.android.ConfirmEmailAddress.DeepLinkEmailManagementController.Result;
import com.linkedin.android.ConfirmEmailAddress.DeepLinkEmailManagementController.ResultListener;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.AbstractRequest;
import com.linkedin.android.networking.request.RequestDelegateBuilder;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import java.util.Map;
import javax.inject.Inject;

public final class EmailConfirmationLoadingFragment
  extends LegoFragment
{
  @Inject
  DeepLinkEmailManagementController confirmEmailHandler;
  private DeepLinkEmailManagementController.ResultListener confirmEmailListener;
  private String confirmEmailUrl;
  private Runnable confirmedRunnable;
  @Inject
  DelayedExecution delayedExecution;
  private boolean emailConfirmed;
  private boolean hasConfirmationError;
  @Inject
  IntentRegistry intentRegistry;
  private boolean isFirstTimeConfirmingPrimaryEmail;
  @Inject
  MediaCenter mediaCenter;
  
  private LegoTrackingDataProvider getLegoTrackingDataProvider()
  {
    return fragmentComponent.activity().activityComponent.legoTrackingDataProvider();
  }
  
  private void updateView()
  {
    Object localObject = getView();
    boolean bool2;
    EmailConfirmationLoadingFragmentViewModel localEmailConfirmationLoadingFragmentViewModel;
    if (localObject != null)
    {
      localObject = (EmailConfirmationLoadingFragmentViewHolder)EmailConfirmationLoadingFragmentViewHolder.CREATOR.createViewHolder((View)localObject);
      boolean bool1 = emailConfirmed;
      bool2 = hasConfirmationError;
      localEmailConfirmationLoadingFragmentViewModel = new EmailConfirmationLoadingFragmentViewModel();
      if (!bool1) {
        break label65;
      }
      textId = 2131231530;
    }
    for (;;)
    {
      getLayoutInflater(null);
      localEmailConfirmationLoadingFragmentViewModel.onBindViewHolder$5b09ea1((EmailConfirmationLoadingFragmentViewHolder)localObject);
      return;
      label65:
      if (!bool2) {
        textId = 2131231531;
      } else {
        textId = 2131233721;
      }
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    delayedExecution.stopDelayedExecution(confirmedRunnable);
  }
  
  public final void doResume()
  {
    super.doResume();
    if (emailConfirmed)
    {
      delayedExecution.postDelayedExecution(confirmedRunnable, 2000L);
      return;
    }
    Object localObject1 = getArguments();
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getString("confirmEmailUrl");
      confirmEmailUrl = ((String)localObject1);
      localObject1 = getArguments();
      if ((localObject1 == null) || (!((Bundle)localObject1).getBoolean("isFirstTimeConfirmingPrimaryEmail", true))) {
        break label148;
      }
    }
    label148:
    for (boolean bool = true;; bool = false)
    {
      isFirstTimeConfirmingPrimaryEmail = bool;
      if (confirmEmailUrl == null) {
        break label340;
      }
      localObject1 = confirmEmailHandler;
      localObject3 = confirmEmailUrl;
      localObject2 = confirmEmailListener;
      localObject6 = DeepLinkEmailManagementController.getUri((String)localObject3);
      if (localObject6 != null) {
        break label153;
      }
      Log.e(DeepLinkEmailManagementController.TAG, "url is invalid " + (String)localObject3);
      ((DeepLinkEmailManagementController.ResultListener)localObject2).onResult(DeepLinkEmailManagementController.Result.fail(null));
      return;
      localObject1 = null;
      break;
    }
    label153:
    Object localObject4 = ((Uri)localObject6).getQueryParameter("id");
    Object localObject5 = ((Uri)localObject6).getQueryParameter("ct");
    String str = ((Uri)localObject6).getQueryParameter("sig");
    Object localObject6 = ((Uri)localObject6).getQueryParameter("redirectUrlAlias");
    if ((localObject4 == null) || (str == null) || (localObject5 == null))
    {
      Log.e(DeepLinkEmailManagementController.TAG, "one of message ID or signature or create Time is absent from url " + (String)localObject3);
      ((DeepLinkEmailManagementController.ResultListener)localObject2).onResult(DeepLinkEmailManagementController.Result.fail(null));
      return;
    }
    Object localObject3 = new ArrayMap(3);
    ((ArrayMap)localObject3).put("id", localObject4);
    ((ArrayMap)localObject3).put("ct", localObject5);
    ((ArrayMap)localObject3).put("sig", str);
    localObject4 = mNetworkClient.getRequestFactory();
    Object localObject2 = new DeepLinkEmailManagementController.1((DeepLinkEmailManagementController)localObject1, (DeepLinkEmailManagementController.ResultListener)localObject2, (String)localObject6);
    localObject5 = mContext;
    localObject2 = ((RequestFactory)localObject4).getAbsoluteRequest$3868be9b(1, "https://www.linkedin.com/psettings/email/confirm/submit", (ResponseListener)localObject2, createsetParams"application/x-www-form-urlencoded"requestDelegate);
    mNetworkClient.add((AbstractRequest)localObject2);
    return;
    label340:
    Util.safeThrow$7a8b4789(new IllegalStateException("Confirm email url is null"));
    hasConfirmationError = true;
    updateView();
    delayedExecution.postDelayedExecution(confirmedRunnable, 2000L);
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      emailConfirmed = paramBundle.getBoolean("emailConfirmed");
      confirmEmailUrl = paramBundle.getString("confirmEmailUrl");
      isFirstTimeConfirmingPrimaryEmail = paramBundle.getBoolean("isFirstTimeConfirmingPrimaryEmail");
      hasConfirmationError = paramBundle.getBoolean("hasConfirmationError");
    }
    confirmedRunnable = new EmailConfirmationLoadingFragment.1(this);
    confirmEmailListener = new EmailConfirmationLoadingFragment.2(this);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968835, paramViewGroup, false);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("emailConfirmed", emailConfirmed);
    paramBundle.putString("confirmEmailUrl", confirmEmailUrl);
    paramBundle.putBoolean("isFirstTimeConfirmingPrimaryEmail", isFirstTimeConfirmingPrimaryEmail);
    paramBundle.putBoolean("hasConfirmationError", hasConfirmationError);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    updateView();
  }
  
  public final String pageKey()
  {
    return "onboarding_post_profile";
  }
  
  protected final void trackLegoPageImpression()
  {
    String str = EmailConfirmationBundle.getWidgetTrackingToken(getArguments());
    if ((legoWidget == null) && (str != null)) {
      getLegoTrackingDataProvider().sendPageImpressionEvent$505cbf4b(str);
    }
    while (legoWidget == null) {
      return;
    }
    super.trackLegoPageImpression();
  }
  
  protected final void trackLegoWidgetImpression()
  {
    String str = EmailConfirmationBundle.getWidgetTrackingToken(getArguments());
    if ((legoWidget == null) && (str != null)) {
      getLegoTrackingDataProvider().sendWidgetImpressionEvent$4bb724c7(str, Visibility.SHOW);
    }
    while (legoWidget == null) {
      return;
    }
    super.trackLegoWidgetImpression();
  }
  
  protected final void trackLegoWidgetSkipAction(String paramString)
  {
    String str = EmailConfirmationBundle.getWidgetTrackingToken(getArguments());
    if ((legoWidget == null) && (str != null)) {
      getLegoTrackingDataProvider().sendActionEvent$3082e732(str, ActionCategory.SKIP, 1, paramString);
    }
    while (legoWidget == null) {
      return;
    }
    super.trackLegoWidgetSkipAction(paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationLoadingFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */