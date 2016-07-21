package com.linkedin.android.feed.page.feed.hero.crosspromo;

import android.os.Handler;

final class FeedSuperHeroPromo$PromoViewHolder$1
  implements Runnable
{
  FeedSuperHeroPromo$PromoViewHolder$1(FeedSuperHeroPromo.PromoViewHolder paramPromoViewHolder, Runnable paramRunnable1, Handler paramHandler, Runnable paramRunnable2) {}
  
  public final void run()
  {
    try
    {
      val$first.run();
      if (val$handler == null)
      {
        val$next.run();
        return;
      }
      val$handler.postDelayed(val$next, val$delayMsec);
      return;
    }
    finally
    {
      if (val$handler != null) {
        break label62;
      }
    }
    val$next.run();
    for (;;)
    {
      throw ((Throwable)localObject);
      label62:
      val$handler.postDelayed(val$next, val$delayMsec);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.crosspromo.FeedSuperHeroPromo.PromoViewHolder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */