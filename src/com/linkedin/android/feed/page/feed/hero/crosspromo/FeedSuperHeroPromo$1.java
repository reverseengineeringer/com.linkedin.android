package com.linkedin.android.feed.page.feed.hero.crosspromo;

import com.linkedin.android.infra.events.Bus;
import java.util.concurrent.atomic.AtomicBoolean;

final class FeedSuperHeroPromo$1
  implements Runnable
{
  FeedSuperHeroPromo$1(FeedSuperHeroPromo paramFeedSuperHeroPromo) {}
  
  public final void run()
  {
    FeedSuperHeroPromo.access$000(this$0).set(true);
    FeedSuperHeroPromo.access$100(this$0);
    Bus.publish(new CrossPromoHeroViewModel.HeroDismissedEvent());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.crosspromo.FeedSuperHeroPromo.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */