package com.linkedin.android.identity.guidededit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.identity.guidededit.infra.GuidedEditBaseBundleBuilder;
import com.linkedin.android.identity.guidededit.infra.GuidedEditFlowRootFragment;
import com.linkedin.android.identity.guidededit.infra.GuidedEditFlowRootFragment.GuidedEditListener;
import com.linkedin.android.identity.guidededit.infra.GuidedEditFragmentHelper;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditSource;
import com.linkedin.android.identity.profile.ProfileBundleBuilder;
import com.linkedin.android.identity.profile.ProfileViewIntent;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdate;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ProfileCategories;

public class GuidedEditActivity
  extends BaseActivity
  implements GuidedEditFlowRootFragment.GuidedEditListener
{
  public final void onCancelAndExitGuidedEdit$b0b86fb()
  {
    Object localObject = GuidedEditBaseBundleBuilder.getGuidedEditSource(getIntent().getExtras());
    switch (localObject)
    {
    default: 
      onBackPressed();
      return;
    }
    if (getIntent().getExtras().getBoolean("meTabProfile"))
    {
      localObject = new HomeBundle();
      activeTab = HomeTabInfo.ME;
    }
    for (localObject = applicationComponent.intentRegistry().home.newIntent(this, (BundleBuilder)localObject);; localObject = applicationComponent.intentRegistry().profileView.newIntent(this, (BundleBuilder)localObject))
    {
      ((Intent)localObject).addFlags(67108864);
      startActivity((Intent)localObject);
      finish();
      return;
      localObject = ProfileBundleBuilder.createSelfProfile();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    activityComponent.inject(this);
    setContentView(2130968943);
    if (paramBundle == null)
    {
      paramBundle = getIntent().getExtras();
      if (paramBundle != null)
      {
        paramBundle = GuidedEditBaseBundleBuilder.wrap(paramBundle);
        getSupportFragmentManager().beginTransaction().replace(16908290, GuidedEditFlowRootFragment.newInstance(paramBundle), GuidedEditFlowRootFragment.TAG).commit();
      }
    }
  }
  
  public final void onFinishGuidedEdit(GuidedEditCategory paramGuidedEditCategory, GuidedEditProfileUpdate paramGuidedEditProfileUpdate)
  {
    Intent localIntent = new Intent();
    GuidedEditBaseBundleBuilder localGuidedEditBaseBundleBuilder = GuidedEditBaseBundleBuilder.create();
    localGuidedEditBaseBundleBuilder.setCategory(paramGuidedEditCategory);
    if (paramGuidedEditProfileUpdate != null) {
      RecordParceler.quietParcel(paramGuidedEditProfileUpdate, "guidedEditProfileUpdate", bundle);
    }
    localIntent.putExtras(localGuidedEditBaseBundleBuilder.build());
    setResult(-1, localIntent);
    if ((GuidedEditBaseBundleBuilder.getGuidedEditSource(getIntent().getExtras()) == GuidedEditSource.ME) && (paramGuidedEditCategory != null)) {
      switch (1.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$identity$guidededit$CategoryNames[id.ordinal()])
      {
      }
    }
    for (;;)
    {
      onBackPressed();
      return;
      GuidedEditFragmentHelper.postMeSnackbarAction(activityComponent, ProfileCategories.PUBLICATIONS, 2131231988, "suggested_publication_view_on_profile");
      continue;
      GuidedEditFragmentHelper.postMeSnackbarAction(activityComponent, ProfileCategories.PATENTS, 2131231977, "suggested_patent_view_on_profile");
      continue;
      GuidedEditFragmentHelper.postMeSnackbarAction(activityComponent, ProfileCategories.CERTIFICATIONS, 2131231970, "suggested_certification_view_on_profile");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.GuidedEditActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */