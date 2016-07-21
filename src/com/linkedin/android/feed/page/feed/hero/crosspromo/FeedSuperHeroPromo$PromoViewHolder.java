package com.linkedin.android.feed.page.feed.hero.crosspromo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.CrossPromoLib.utils.NonMarketUrlRunnable;
import com.linkedin.android.feed.page.feed.hero.FeedHeroViewHolder;
import com.linkedin.android.feed.shared.LinkUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.crosspromo.common.android.RichText;

final class FeedSuperHeroPromo$PromoViewHolder
  extends FeedHeroViewHolder
{
  RichText headline;
  final LayoutInflater inflater;
  final View promoView;
  
  FeedSuperHeroPromo$PromoViewHolder(FeedSuperHeroPromo paramFeedSuperHeroPromo, View paramView)
  {
    super(paramView);
    promoView = paramView;
    inflater = LayoutInflater.from(paramView.getContext());
  }
  
  final Runnable sequence$3f44bd85(final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    if (0L <= 0L) {}
    for (final Handler localHandler = null;; localHandler = new Handler(promoView.getContext().getMainLooper())) {
      new Runnable()
      {
        public final void run()
        {
          try
          {
            paramRunnable1.run();
            if (localHandler == null)
            {
              paramRunnable2.run();
              return;
            }
            localHandler.postDelayed(paramRunnable2, val$delayMsec);
            return;
          }
          finally
          {
            if (localHandler != null) {
              break label62;
            }
          }
          paramRunnable2.run();
          for (;;)
          {
            throw ((Throwable)localObject);
            label62:
            localHandler.postDelayed(paramRunnable2, val$delayMsec);
          }
        }
      };
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.crosspromo.FeedSuperHeroPromo.PromoViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */