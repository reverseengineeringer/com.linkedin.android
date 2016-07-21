package com.linkedin.android.premium;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.TaskStackBuilder;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.premium.chooser.PremiumChooserFragment;

public class PremiumActivity
  extends BaseActivity
  implements OnboardingFinishHandler
{
  private static final String CHOOSER_TAG = PremiumChooserFragment.class.getSimpleName();
  
  public final void finishOnboarding()
  {
    Object localObject1 = PremiumActivityBundleBuilder.getNextActivityIntent(getIntent().getExtras());
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = PremiumActivityBundleBuilder.getNextActivityOptions(getIntent().getExtras());
      if (Build.VERSION.SDK_INT >= 16) {
        break label137;
      }
      startActivity((Intent)localObject1);
    }
    for (;;)
    {
      localObject1 = activityComponent.intentRegistry().home;
      localObject2 = activityComponent.activity();
      HomeBundle localHomeBundle = new HomeBundle();
      activeTab = HomeTabInfo.FEED;
      localObject1 = ((HomeIntent)localObject1).newIntent((Context)localObject2, localHomeBundle);
      localObject2 = activityComponent.activity();
      if ((!((Activity)localObject2).isTaskRoot()) || (((Activity)localObject2).getFragmentManager().getBackStackEntryCount() != 0)) {
        break;
      }
      TaskStackBuilder.create((Context)localObject2).addNextIntentWithParentStack((Intent)localObject1).startActivities();
      if ((localObject2 instanceof BaseActivity)) {
        ((BaseActivity)localObject2).fireBackPressedControlInteractionEvent();
      }
      return;
      label137:
      startActivity((Intent)localObject1, (Bundle)localObject2);
    }
    if ((localObject2 instanceof BaseActivity))
    {
      isSoftwareBack = true;
      ignoreBackButtonTracking = false;
    }
    supportFinishAfterTransition();
  }
  
  public void onBackPressed()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentById(2131756509);
    if (((localFragment instanceof OnBackPressedListener)) && (((OnBackPressedListener)localFragment).onBackPressed())) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = activityComponent.lixManager();
    PremiumModel.setShowAttributedText("show".equals(paramBundle.getTreatment(Lix.PREMIUM_ATTRIBUTED_TEXT)));
    setContentView(2130968929);
    android.support.v4.app.FragmentManager localFragmentManager = getSupportFragmentManager();
    if (localFragmentManager.findFragmentByTag(CHOOSER_TAG) == null) {
      if (!"show_slider".equals(paramBundle.getTreatment(Lix.PREMIUM_HIDE_FULL_CARD))) {
        break label92;
      }
    }
    label92:
    for (paramBundle = PremiumChooserFragment.newInstance();; paramBundle = SubscriptionChooserFragment.newInstance())
    {
      localFragmentManager.beginTransaction().add(2131756509, paramBundle, CHOOSER_TAG).commit();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.PremiumActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */