package com.linkedin.android.feed.channel;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import butterknife.internal.DebouncingOnClickListener;

public class ChannelFragment$$ViewInjector<T extends ChannelFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, final T paramT, Object paramObject)
  {
    channelRecyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755583, "field 'channelRecyclerView'"), 2131755583, "field 'channelRecyclerView'"));
    channelToolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755586, "field 'channelToolbar'"), 2131755586, "field 'channelToolbar'"));
    collapsingToolbarLayout = ((CollapsingToolbarLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755585, "field 'collapsingToolbarLayout'"), 2131755585, "field 'collapsingToolbarLayout'"));
    channelNameView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755590, "field 'channelNameView'"), 2131755590, "field 'channelNameView'"));
    followerCountView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755591, "field 'followerCountView'"), 2131755591, "field 'followerCountView'"));
    channelLogoView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755593, "field 'channelLogoView'"), 2131755593, "field 'channelLogoView'"));
    channelBackgroundView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755587, "field 'channelBackgroundView'"), 2131755587, "field 'channelBackgroundView'"));
    paramObject = (View)paramFinder.findRequiredView(paramObject, 2131755592, "field 'channelFollowButton' and method 'handleFollowChannelClick'");
    channelFollowButton = ((Button)paramFinder.castView((View)paramObject, 2131755592, "field 'channelFollowButton'"));
    ((View)paramObject).setOnClickListener(new DebouncingOnClickListener()
    {
      public final void doClick(View paramAnonymousView)
      {
        paramT.handleFollowChannelClick();
      }
    });
  }
  
  public void reset(T paramT)
  {
    channelRecyclerView = null;
    channelToolbar = null;
    collapsingToolbarLayout = null;
    channelNameView = null;
    followerCountView = null;
    channelLogoView = null;
    channelBackgroundView = null;
    channelFollowButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */