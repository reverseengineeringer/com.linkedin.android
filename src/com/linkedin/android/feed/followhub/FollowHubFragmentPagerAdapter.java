package com.linkedin.android.feed.followhub;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.linkedin.android.infra.FragmentReferencingPagerAdapter;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import java.util.ArrayList;
import java.util.List;

public final class FollowHubFragmentPagerAdapter
  extends FragmentReferencingPagerAdapter
{
  private FragmentRegistry fragmentRegistry;
  final List<RecommendedPackage> packages = new ArrayList();
  
  public FollowHubFragmentPagerAdapter(FragmentComponent paramFragmentComponent, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    fragmentRegistry = paramFragmentComponent.fragmentRegistry();
  }
  
  public final int getCount()
  {
    return packages.size();
  }
  
  public final Fragment getItem(int paramInt)
  {
    FollowHubPackageBundleBuilder localFollowHubPackageBundleBuilder = new FollowHubPackageBundleBuilder(packages.get(paramInt)).packageId);
    return fragmentRegistry.followHubPackage.newFragment(localFollowHubPackageBundleBuilder);
  }
  
  public final CharSequence getPageTitle(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (paramInt >= 0)
    {
      str1 = str2;
      if (paramInt < packages.size())
      {
        RecommendedPackage localRecommendedPackage = (RecommendedPackage)packages.get(paramInt);
        str1 = str2;
        if (localRecommendedPackage != null)
        {
          str1 = str2;
          if (reason != null) {
            str1 = reason.values.get(0)).value;
          }
        }
      }
    }
    return str1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubFragmentPagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */