package com.linkedin.android.feed.followhub;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.imageloader.LiImageView;

public class FollowHubPackageRecyclerViewAdapter$ViewHolder$$ViewInjector<T extends FollowHubPackageRecyclerViewAdapter.ViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    entity = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755890, "field 'entity'"), 2131755890, "field 'entity'"));
    imageView = ((LiImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755889, "field 'imageView'"), 2131755889, "field 'imageView'"));
    followText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755891, "field 'followText'"), 2131755891, "field 'followText'"));
    followPlus = ((LiImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755892, "field 'followPlus'"), 2131755892, "field 'followPlus'"));
  }
  
  public void reset(T paramT)
  {
    entity = null;
    imageView = null;
    followText = null;
    followPlus = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubPackageRecyclerViewAdapter.ViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */