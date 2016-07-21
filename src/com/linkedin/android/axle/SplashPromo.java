package com.linkedin.android.axle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.PromoBase.OverlayPromo;
import com.linkedin.CrossPromoLib.api.PromoBase.OverlayPromo.1;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.CrossPromoLib.utils.EventTypes;
import com.linkedin.CrossPromoLib.utils.NonMarketUrlRunnable;
import com.linkedin.CrossPromoLib.utils.Utils;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;
import com.linkedin.crosspromo.fe.api.android.Promo;
import java.util.List;
import java.util.Map;

public final class SplashPromo
  extends OverlayPromo
{
  private FragmentComponent fragmentComponent;
  private boolean isDogfoodSplash;
  
  public SplashPromo(PromoSource paramPromoSource, FragmentComponent paramFragmentComponent, boolean paramBoolean)
  {
    super(paramPromoSource);
    fragmentComponent = paramFragmentComponent;
    isDogfoodSplash = paramBoolean;
  }
  
  private Runnable createNextThenRemoveChildViews(final Runnable paramRunnable)
  {
    new Runnable()
    {
      public final void run()
      {
        try
        {
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          return;
        }
        finally
        {
          container.animate().alpha(0.0F).setDuration(val$fadeOutDuration).setListener(new AnimatorListenerAdapter()
          {
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              super.onAnimationEnd(paramAnonymous2Animator);
              container.setVisibility(8);
              container.removeAllViews();
            }
          });
        }
      }
    };
  }
  
  public final View.OnClickListener createOnClickDismissListener(View paramView, final Runnable paramRunnable)
  {
    new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        SplashPromo.this.createNextThenRemoveChildViews(paramRunnable).run();
      }
    };
  }
  
  public final View.OnClickListener createOnClickListener(Context paramContext, String paramString1, String paramString2, String paramString3, Runnable paramRunnable, NonMarketUrlRunnable paramNonMarketUrlRunnable)
  {
    return Utils.createOnClickListener(paramContext, paramString1, paramString2, paramString3, createNextThenRemoveChildViews(paramRunnable), paramNonMarketUrlRunnable);
  }
  
  protected final View initView(Context paramContext, ViewGroup paramViewGroup)
  {
    if ((getPromoModelpromo.hasSubPromos) && (getPromoModelpromo.subPromos != null))
    {
      int i = getPromoModelpromo.subPromos.size();
      while (i > 0)
      {
        lockLoadingImages();
        i -= 1;
      }
    }
    View localView = LayoutInflater.from(paramContext).inflate(2130968617, paramViewGroup, false);
    SplashPromoViewHolder localSplashPromoViewHolder = new SplashPromoViewHolder(this, fragmentComponent, fragmentComponent.fragment().getFragmentManager(), fragmentComponent.tracker(), paramViewGroup, localView, isDogfoodSplash);
    Context localContext = inflater.getContext();
    PromoModel localPromoModel = promoTemplate.getPromoModel();
    addText(title, localPromoModel.getRichTextFromModel("title"));
    label215:
    label296:
    SplashPromoViewPagerAdapter localSplashPromoViewPagerAdapter;
    if (promo.metricsMap == null)
    {
      paramContext = null;
      paramContext = promoTemplate.newEventTracker(EventTypes.FIRE_ACTION, paramContext);
      addButton$6e97a4d(dismissButton, localPromoModel.getRichTextFromModel("dismiss"), promoTemplate.createOnClickDismissListener(container, paramContext));
      if (promo.metricsMap != null) {
        break label609;
      }
      paramContext = null;
      paramContext = promoTemplate.newEventTracker(EventTypes.FIRE_ACTION, paramContext);
      if (!isDogfoodSplash) {
        break label632;
      }
      addButton$6e97a4d(promptButton, localPromoModel.getPromptTextDownload(), new SplashPromoViewHolder.1(localSplashPromoViewHolder, localContext));
      addButton$6e97a4d(secondaryPromptButton, localPromoModel.getPromptTextOpen(), new SplashPromoViewHolder.2(localSplashPromoViewHolder, localContext, localPromoModel));
      secondaryPromptButton.setVisibility(8);
      localSplashPromoViewPagerAdapter = new SplashPromoViewPagerAdapter(promoTemplate, fragmentManager);
      viewPager.setAdapter(localSplashPromoViewPagerAdapter);
      viewPager.setOffscreenPageLimit(localSplashPromoViewPagerAdapter.getCount() + 2);
      viewPager.setClipChildren(false);
      viewPager.setPageTransformer(true, new CardPeakPagerTransformer(localContext));
      viewPager.enableInteractionTracking(tracker, "xpromo_viewpager");
      if (promo.metricsMap != null) {
        break label660;
      }
      paramContext = null;
      label395:
      paramContext = promoTemplate.newEventTracker(EventTypes.FIRE_ACTION, paramContext);
      viewPager.addOnPageChangeListener(new SplashPromoViewHolder.3(localSplashPromoViewHolder, paramContext));
      if (localSplashPromoViewPagerAdapter.getCount() <= 1) {
        break label683;
      }
      pagerIndicator.setViewPager(viewPager);
    }
    for (;;)
    {
      ObjectAnimator.ofFloat(container, "alpha", new float[] { 0.0F, 1.0F }).setDuration(localContext.getResources().getInteger(2131558410)).start();
      paramContext = ObjectAnimator.ofFloat(viewPagerContainer, "translationX", new float[] { getResourcesgetDisplayMetricswidthPixels, 0.0F }).setDuration(localContext.getResources().getInteger(2131558411));
      paramContext.setInterpolator(new DecelerateInterpolator());
      paramContext.start();
      container = paramViewGroup;
      paramViewGroup.removeAllViews();
      paramViewGroup.setVisibility(0);
      paramViewGroup.setOnTouchListener(new OverlayPromo.1(this));
      paramViewGroup.addView(localView);
      return localView;
      paramContext = (MetricsInfo)promo.metricsMap.get("dismiss");
      break;
      label609:
      paramContext = (MetricsInfo)promo.metricsMap.get("action");
      break label215;
      label632:
      addButton$6e97a4d(promptButton, localPromoModel.getPromptTextDownload(), promoTemplate.createOnClickListener(localContext, paramContext, null));
      break label296;
      label660:
      paramContext = (MetricsInfo)promo.metricsMap.get("swipe");
      break label395;
      label683:
      if (localSplashPromoViewPagerAdapter.getCount() == 0) {
        pagerIndicator.setVisibility(8);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */