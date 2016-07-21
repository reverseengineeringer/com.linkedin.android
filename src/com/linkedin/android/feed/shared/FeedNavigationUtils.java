package com.linkedin.android.feed.shared;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.widget.ImageView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.entities.company.CompanyBundleBuilder;
import com.linkedin.android.entities.company.CompanyIntent;
import com.linkedin.android.entities.group.GroupBundleBuilder;
import com.linkedin.android.entities.group.GroupIntent;
import com.linkedin.android.entities.job.JobBundleBuilder;
import com.linkedin.android.entities.job.JobIntent;
import com.linkedin.android.entities.school.SchoolBundleBuilder;
import com.linkedin.android.entities.school.SchoolIntent;
import com.linkedin.android.feed.channel.ChannelBundle;
import com.linkedin.android.feed.channel.ChannelIntent;
import com.linkedin.android.feed.followhub.FollowHubBundleBuilder;
import com.linkedin.android.feed.followhub.FollowHubIntent;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.identity.profile.ProfileBundleBuilder;
import com.linkedin.android.identity.profile.ProfileViewIntent;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.makeramen.roundedimageview.RoundedDrawable;
import java.io.ByteArrayOutputStream;

public final class FeedNavigationUtils
{
  public static void navigateUp(ActivityComponent paramActivityComponent, boolean paramBoolean)
  {
    Object localObject = intentRegistryhome;
    BaseActivity localBaseActivity = paramActivityComponent.activity();
    HomeBundle localHomeBundle = new HomeBundle();
    activeTab = HomeTabInfo.FEED;
    localObject = ((HomeIntent)localObject).newIntent(localBaseActivity, localHomeBundle);
    NavigationUtils.navigateUp(paramActivityComponent.activity(), (Intent)localObject, paramBoolean);
  }
  
  public static void openChannel(Channel paramChannel, ActivityComponent paramActivityComponent)
  {
    Context localContext = paramActivityComponent.context();
    paramChannel = ChannelBundle.create(paramChannel);
    localContext.startActivity(intentRegistrychannel.newIntent(localContext, paramChannel));
  }
  
  public static void openFollowHub(FragmentComponent paramFragmentComponent)
  {
    Object localObject = FollowHubBundleBuilder.createBundle();
    localObject = intentRegistryfollowHubIntent.newIntent(paramFragmentComponent.activity(), (BundleBuilder)localObject);
    paramFragmentComponent.context().startActivity((Intent)localObject);
  }
  
  @Deprecated
  public static void openMiniCompany(MiniCompany paramMiniCompany, ActivityComponent paramActivityComponent, ImageView paramImageView)
  {
    saveMiniCompanyToCache(paramActivityComponent.dataManager(), paramMiniCompany);
    BaseActivity localBaseActivity = paramActivityComponent.activity();
    paramMiniCompany = CompanyBundleBuilder.create(paramMiniCompany, false);
    logoView = paramImageView;
    ActivityCompat.startActivity(localBaseActivity, intentRegistrycompany.newIntent(localBaseActivity, paramMiniCompany), paramMiniCompany.buildTransitionBundle(localBaseActivity));
  }
  
  public static void openMiniCompany(MiniCompany paramMiniCompany, ActivityComponent paramActivityComponent, ImageView paramImageView, boolean paramBoolean)
  {
    saveMiniCompanyToCache(paramActivityComponent.dataManager(), paramMiniCompany);
    BaseActivity localBaseActivity = paramActivityComponent.activity();
    paramMiniCompany = CompanyBundleBuilder.create(paramMiniCompany, paramBoolean);
    logoView = paramImageView;
    ActivityCompat.startActivity(localBaseActivity, intentRegistrycompany.newIntent(localBaseActivity, paramMiniCompany), paramMiniCompany.buildTransitionBundle(localBaseActivity));
  }
  
  public static void openMiniGroup(MiniGroup paramMiniGroup, ActivityComponent paramActivityComponent, ImageView paramImageView)
  {
    BaseActivity localBaseActivity = paramActivityComponent.activity();
    GroupBundleBuilder localGroupBundleBuilder = GroupBundleBuilder.create(entityUrn.getId());
    ByteArrayOutputStream localByteArrayOutputStream;
    if (paramImageView != null)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      paramMiniGroup = paramImageView.getDrawable();
      if (!(paramMiniGroup instanceof BitmapDrawable)) {
        break label109;
      }
      paramMiniGroup = ((BitmapDrawable)paramMiniGroup).getBitmap();
    }
    for (;;)
    {
      if (paramMiniGroup != null)
      {
        paramMiniGroup.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
        bundle.putByteArray("logoBitmap", localByteArrayOutputStream.toByteArray());
        logoView = paramImageView;
      }
      localBaseActivity.startActivity(intentRegistrygroup.newIntent(localBaseActivity, localGroupBundleBuilder));
      return;
      label109:
      if ((paramMiniGroup instanceof RoundedBitmapDrawable)) {
        paramMiniGroup = mBitmap;
      } else if ((paramMiniGroup instanceof RoundedDrawable)) {
        paramMiniGroup = RoundedDrawable.drawableToBitmap((RoundedDrawable)paramMiniGroup);
      } else {
        paramMiniGroup = null;
      }
    }
  }
  
  public static void openMiniJob(MiniJob paramMiniJob, ActivityComponent paramActivityComponent, ImageView paramImageView)
  {
    BaseActivity localBaseActivity = paramActivityComponent.activity();
    JobBundleBuilder localJobBundleBuilder = JobBundleBuilder.create(paramMiniJob);
    ByteArrayOutputStream localByteArrayOutputStream;
    if (paramImageView != null)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      paramMiniJob = paramImageView.getDrawable();
      if (!(paramMiniJob instanceof BitmapDrawable)) {
        break label103;
      }
      paramMiniJob = ((BitmapDrawable)paramMiniJob).getBitmap();
    }
    for (;;)
    {
      if (paramMiniJob != null)
      {
        paramMiniJob.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
        bundle.putByteArray("logoBitmap", localByteArrayOutputStream.toByteArray());
        logoView = paramImageView;
      }
      localBaseActivity.startActivity(intentRegistryjob.newIntent(localBaseActivity, localJobBundleBuilder));
      return;
      label103:
      if ((paramMiniJob instanceof RoundedBitmapDrawable)) {
        paramMiniJob = mBitmap;
      } else if ((paramMiniJob instanceof RoundedDrawable)) {
        paramMiniJob = RoundedDrawable.drawableToBitmap((RoundedDrawable)paramMiniJob);
      } else {
        paramMiniJob = null;
      }
    }
  }
  
  public static void openMiniProfile(MiniProfile paramMiniProfile, Context paramContext)
  {
    IntentRegistry localIntentRegistry = Util.getAppComponent(paramContext).intentRegistry();
    paramMiniProfile = ProfileBundleBuilder.create(paramMiniProfile);
    paramContext.startActivity(profileView.newIntent(paramContext, paramMiniProfile));
  }
  
  public static void openMiniProfile(MiniProfile paramMiniProfile, ActivityComponent paramActivityComponent)
  {
    openMiniProfile(paramMiniProfile, paramActivityComponent.activity());
  }
  
  public static void openMiniSchool(MiniSchool paramMiniSchool, ActivityComponent paramActivityComponent)
  {
    BaseActivity localBaseActivity = paramActivityComponent.activity();
    paramMiniSchool = SchoolBundleBuilder.create(entityUrn.getId());
    localBaseActivity.startActivity(intentRegistryschool.newIntent(localBaseActivity, paramMiniSchool));
  }
  
  private static void saveMiniCompanyToCache(FlagshipDataManager paramFlagshipDataManager, MiniCompany paramMiniCompany)
  {
    String str = entityUrn.toString();
    paramFlagshipDataManager.submit(Request.put().cacheKey(str).model(paramMiniCompany).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.FeedNavigationUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */