package com.linkedin.android.identity.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.growth.login.LoginIntent;
import com.linkedin.android.growth.login.LoginIntentBundle;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.identity.edit.ProfileEditBaseFragment;
import com.linkedin.android.identity.edit.ProfileEditFragmentUtils;
import com.linkedin.android.identity.edit.ProfileEditListener;
import com.linkedin.android.identity.edit.newSections.ParentViewModel.Category;
import com.linkedin.android.identity.edit.newSections.ProfileNewSectionBundleBuilder;
import com.linkedin.android.identity.edit.newSections.ProfileNewSectionsFragment;
import com.linkedin.android.identity.edit.newSections.ProfileNewSectionsFragment.ProfileHubListener;
import com.linkedin.android.identity.profile.view.accomplishments.AccomplishmentType;
import com.linkedin.android.identity.profile.view.accomplishments.detail.ProfileAccomplishmentsBundleBuilder;
import com.linkedin.android.identity.profile.view.accomplishments.detail.ProfileAccomplishmentsFragment;
import com.linkedin.android.identity.profile.view.custominvite.CustomInviteFragment;
import com.linkedin.android.identity.profile.view.pagedlist.PagedListFragment;
import com.linkedin.android.identity.profile.view.pagedlist.PagedListPreProcessedFragment;
import com.linkedin.android.identity.shared.ProfileEditPhotoCropFragment.OnPhotoEditListener;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ProfileCategories;

public class ProfileViewActivity
  extends BaseActivity
  implements ProfileEditListener, ProfileNewSectionsFragment.ProfileHubListener, ProfileEditPhotoCropFragment.OnPhotoEditListener
{
  private void startDetailFragmentFromNonProfileView(BaseFragment paramBaseFragment)
  {
    getPageFragmentTransaction().replace(2131757804, paramBaseFragment).addToBackStack(null).commit();
  }
  
  public void onBackPressed()
  {
    Object localObject1 = getSupportFragmentManager().findFragmentById(2131757804);
    if ((localObject1 instanceof ProfileEditBaseFragment))
    {
      localObject1 = (ProfileEditBaseFragment)localObject1;
      localObject2 = getSupportFragmentManager().findFragmentById(2131757804);
      if (!(localObject2 instanceof CustomInviteFragment)) {
        break label59;
      }
    }
    label59:
    for (Object localObject2 = (CustomInviteFragment)localObject2;; localObject2 = null)
    {
      if (localObject1 == null) {
        break label64;
      }
      ((ProfileEditBaseFragment)localObject1).onBackPressed();
      return;
      localObject1 = null;
      break;
    }
    label64:
    if (localObject2 != null)
    {
      ((CustomInviteFragment)localObject2).onBackPressed();
      return;
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int k = 1;
    super.onCreate(paramBundle);
    boolean bool = "control".equals(activityComponent.lixManager().getTreatment(Lix.PROFILE_VIEW_DISABLE_PROFILE_VIEW_API));
    activityComponent.profileDataProvider().profileViewApiEnabled = bool;
    int i;
    label85:
    int j;
    if (getIntent() != null)
    {
      Object localObject = getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getBoolean("memberIdProfile")))
      {
        i = 1;
        if (i == 0) {
          break label228;
        }
        i = 1;
        if (applicationComponent.auth().isAuthenticated()) {
          break label288;
        }
        if (getIntent() == null) {
          break label238;
        }
        localObject = getIntent().getExtras();
        if ((localObject == null) || (TextUtils.isEmpty(((Bundle)localObject).getString("externalIdentifier"))) || (TextUtils.isEmpty(((Bundle)localObject).getString("thirdPartyApplicationPackageName")))) {
          break label233;
        }
        j = 1;
        label149:
        if (j == 0) {
          break label238;
        }
        j = k;
        label156:
        if (j == 0) {
          break label243;
        }
        paramBundle = getIntent().getExtras().getString("thirdPartyApplicationPackageName");
        localObject = new LoginIntentBundle().setRedirectIntent(getIntent());
        ((LoginIntentBundle)localObject).setThirdPartyApplicationPackageName(paramBundle);
        startActivity(activityComponent.intentRegistry().login.newIntent(this, (BundleBuilder)localObject));
        finish();
      }
    }
    label228:
    label233:
    label238:
    label243:
    label288:
    do
    {
      return;
      i = 0;
      break;
      i = 0;
      break label85;
      j = 0;
      break label149;
      j = 0;
      break label156;
      if (i != 0)
      {
        paramBundle = new LoginIntentBundle().setRedirectIntent(getIntent());
        startActivity(activityComponent.intentRegistry().login.newIntent(this, paramBundle));
        finish();
        return;
      }
      setContentView(2130969234);
    } while (paramBundle != null);
    if (i != 0)
    {
      paramBundle = new ProfileBundleBuilder(getIntent().getExtras());
      getSupportFragmentManager().beginTransaction().replace(2131757804, MemberIdResolverFragment.newInstance(paramBundle)).commit();
      return;
    }
    startViewFragment(getIntent().getExtras());
  }
  
  public final void onExitEdit()
  {
    getSupportFragmentManager().popBackStack();
  }
  
  public final void onExitProfileHub()
  {
    getSupportFragmentManager().popBackStack();
  }
  
  public final void onPhotoEditCancel()
  {
    getSupportFragmentManager().popBackStack();
  }
  
  public final void onPhotoSaved()
  {
    getSupportFragmentManager().popBackStack();
    getSupportFragmentManager().popBackStack$505cff1c("imageViewer");
  }
  
  public final void startDetailFragment(BaseFragment paramBaseFragment)
  {
    if ((isPostResumeDone) && (isSafeToExecuteTransaction())) {
      getPageFragmentTransaction().replace(2131757804, paramBaseFragment).addToBackStack(null).commit();
    }
  }
  
  public final void startEditFragment(ProfileEditBaseFragment paramProfileEditBaseFragment)
  {
    getModalFragmentTransaction().replace(2131757804, paramProfileEditBaseFragment).addToBackStack(null).commit();
  }
  
  public final void startPagedListFragment(PagedListFragment<?, ?, ?> paramPagedListFragment)
  {
    if ((isPostResumeDone) && (isSafeToExecuteTransaction())) {
      getPageFragmentTransaction().replace(2131757804, paramPagedListFragment).addToBackStack(null).commit();
    }
  }
  
  public final void startPagedListFragment(PagedListPreProcessedFragment<?, ?> paramPagedListPreProcessedFragment)
  {
    if ((isPostResumeDone) && (isSafeToExecuteTransaction())) {
      getPageFragmentTransaction().replace(2131757804, paramPagedListPreProcessedFragment).addToBackStack(null).commit();
    }
  }
  
  public final void startProfileHub(ParentViewModel.Category paramCategory)
  {
    if (canExecuteFragmentTransactions())
    {
      paramCategory = ProfileNewSectionsFragment.newInstance(new ProfileNewSectionBundleBuilder().setDefaultExpandCategory(paramCategory));
      getAnimationFragmentTransaction$228f0801().replace(2131757804, paramCategory).addToBackStack(null).commit();
    }
  }
  
  public final void startViewFragment(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      paramBundle = activityComponent.activity();
      IntentRegistry localIntentRegistry = activityComponent.intentRegistry();
      HomeBundle localHomeBundle = new HomeBundle();
      activeTab = HomeTabInfo.FEED;
      activeTabBundleBuilder = new FeedBundleBuilder();
      startActivity(home.newIntent(paramBundle, localHomeBundle).addFlags(268468224));
      finish();
    }
    do
    {
      do
      {
        do
        {
          return;
          paramBundle = new ProfileBundleBuilder(paramBundle);
          getSupportFragmentManager().beginTransaction().replace(2131757804, ProfileViewFragment.newInstance(paramBundle)).commit();
          paramBundle = bundle.getSerializable("defaultView");
          if ((paramBundle instanceof ProfileCategories)) {}
          for (paramBundle = (ProfileCategories)paramBundle; paramBundle != null; paramBundle = null) {
            switch (paramBundle)
            {
            default: 
              return;
            case ???: 
              ProfileEditFragmentUtils.startEditSkills(this, false);
              return;
            }
          }
          paramBundle = activityComponent.memberUtil().getProfileId();
        } while (paramBundle == null);
        startDetailFragmentFromNonProfileView(ProfileAccomplishmentsFragment.newInstance(ProfileAccomplishmentsBundleBuilder.create(AccomplishmentType.PUBLICATIONS, paramBundle)));
        return;
        paramBundle = activityComponent.memberUtil().getProfileId();
      } while (paramBundle == null);
      startDetailFragmentFromNonProfileView(ProfileAccomplishmentsFragment.newInstance(ProfileAccomplishmentsBundleBuilder.create(AccomplishmentType.PATENTS, paramBundle)));
      return;
      paramBundle = activityComponent.memberUtil().getProfileId();
    } while (paramBundle == null);
    startDetailFragmentFromNonProfileView(ProfileAccomplishmentsFragment.newInstance(ProfileAccomplishmentsBundleBuilder.create(AccomplishmentType.CERTIFICATIONS, paramBundle)));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.ProfileViewActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */