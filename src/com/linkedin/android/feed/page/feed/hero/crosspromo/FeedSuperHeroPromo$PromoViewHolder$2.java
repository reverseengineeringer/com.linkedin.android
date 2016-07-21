package com.linkedin.android.feed.page.feed.hero.crosspromo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.CrossPromoLib.utils.NonMarketUrlRunnable;
import com.linkedin.android.feed.shared.LinkUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.crosspromo.common.android.RichText;

final class FeedSuperHeroPromo$PromoViewHolder$2
  extends NonMarketUrlRunnable
{
  FeedSuperHeroPromo$PromoViewHolder$2(FeedSuperHeroPromo.PromoViewHolder paramPromoViewHolder, PromoModel paramPromoModel) {}
  
  public final void run()
  {
    String str1 = LinkUtils.addHttpPrefixIfNecessary(storeUrl);
    Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(str1));
    String str2 = FeedSuperHeroPromo.access$300(this$1.this$0).activity().getPackageName();
    ((Intent)localObject).setPackage(str2);
    ResolveInfo localResolveInfo = FeedSuperHeroPromo.access$300(this$1.this$0).activity().getPackageManager().resolveActivity((Intent)localObject, 0);
    if (localResolveInfo != null)
    {
      ((Intent)localObject).setClassName(str2, activityInfo.name);
      FeedSuperHeroPromo.access$300(this$1.this$0).activity().startActivity((Intent)localObject);
      return;
    }
    localObject = "";
    if (val$promoModel.getRichTextFromModel("title") != null) {
      localObject = val$promoModel.getRichTextFromModel("title").rawText;
    }
    localObject = WebViewerBundle.create(str1, (String)localObject, str1, 0);
    FeedSuperHeroPromo.access$300(this$1.this$0).webRouterUtil().launchWebViewer((WebViewerBundle)localObject, FeedSuperHeroPromo.access$300(this$1.this$0), WebRouterUtil.shouldForceIgnoreDeeplink(str1));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.crosspromo.FeedSuperHeroPromo.PromoViewHolder.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */