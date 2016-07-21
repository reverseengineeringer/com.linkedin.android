package com.linkedin.android.feed.page.feed.hero.crosspromo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo.4;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.CrossPromoLib.utils.EventTypes;
import com.linkedin.CrossPromoLib.utils.NonMarketUrlRunnable;
import com.linkedin.CrossPromoLib.utils.PromoUtils;
import com.linkedin.android.feed.page.feed.hero.FeedHeroViewHolder;
import com.linkedin.android.feed.shared.LinkUtils;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.GhostImage;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.crosspromo.common.android.RichText;
import com.linkedin.crosspromo.fe.api.android.Bolton;
import com.linkedin.crosspromo.fe.api.android.Bolton.BoltOnUnion;
import com.linkedin.crosspromo.fe.api.android.Image;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.crosspromo.fe.api.bolton.android.JobRecommendationBoltOn;
import com.linkedin.crosspromo.fe.api.bolton.android.PulseTrendingArticleBoltOn;
import com.linkedin.crosspromo.fe.api.bolton.android.SocialProofBoltOn;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FeedSuperHeroPromo
  extends BasePromo
{
  private static long waitForStartMsec = 3000L;
  private final Bus bus;
  private Runnable dismissPromo = new Runnable()
  {
    public final void run()
    {
      dismissed.set(true);
      Bus.publish(new CrossPromoHeroViewModel.HeroDismissedEvent());
    }
  };
  private final AtomicBoolean dismissed;
  private FragmentComponent fragmentComponent;
  
  public FeedSuperHeroPromo(PromoSource paramPromoSource, AtomicBoolean paramAtomicBoolean, Bus paramBus, FragmentComponent paramFragmentComponent)
  {
    super(paramPromoSource);
    dismissed = paramAtomicBoolean;
    bus = paramBus;
    fragmentComponent = paramFragmentComponent;
  }
  
  protected final void OverridableOnViewReady$3c7ec8c3() {}
  
  protected final View initView(Context paramContext, ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130968752, paramViewGroup, false);
    PromoViewHolder localPromoViewHolder = new PromoViewHolder(localView);
    Object localObject1 = promoView.getContext();
    PromoModel localPromoModel = this$0.getPromoModel();
    Object localObject2 = promo;
    Object localObject3;
    if ((hasImages) && (localPromoModel.getImageFromModel("background") != null))
    {
      paramContext = this$0;
      localObject3 = promoView;
      paramContext.fetchImage(localPromoModel.getImageFromModel("background"), null, new BasePromo.4(paramContext, (View)localObject3));
      title.setTextColor(ContextCompat.getColor((Context)localObject1, 2131624058));
      text.setTextColor(ContextCompat.getColor((Context)localObject1, 2131624058));
      dismiss.setTextColor(ContextCompat.getColor((Context)localObject1, 2131624055));
      prompt.setTextColor(ContextCompat.getColor((Context)localObject1, 2131624058));
      div1.setBackgroundColor(ContextCompat.getColor((Context)localObject1, 2131624057));
      div2.setBackgroundColor(ContextCompat.getColor((Context)localObject1, 2131624057));
    }
    label263:
    label388:
    Object localObject4;
    if (metricsMap == null)
    {
      paramContext = null;
      paramContext = this$0.newEventTracker(EventTypes.FIRE_ACTION, paramContext);
      localObject3 = this$0.createOnClickListener((Context)localObject1, localPromoViewHolder.sequence$3f44bd85(paramContext, this$0.dismissPromo), new FeedSuperHeroPromo.PromoViewHolder.2(localPromoViewHolder, localPromoModel));
      if (metricsMap != null) {
        break label838;
      }
      paramContext = null;
      paramContext = this$0.newEventTracker(EventTypes.FIRE_ACTION, paramContext);
      paramContext = this$0.createOnClickDismissListener(promoView, localPromoViewHolder.sequence$3f44bd85(paramContext, this$0.dismissPromo));
      this$0.addLogoImage(logo);
      PromoUtils.addText(title, localPromoModel.getRichTextFromModel("title"));
      headline = null;
      PromoUtils.addButton$6e97a4d(dismiss, localPromoModel.getRichTextFromModel("dismiss"), paramContext);
      PromoUtils.addPromptButton(prompt, localPromoModel, (Context)localObject1, (View.OnClickListener)localObject3);
      if (!hasBoltons) {
        break label1044;
      }
      localObject1 = boltons.iterator();
      label494:
      label501:
      label624:
      label631:
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = nextboltOnUnion;
        } while (localObject2 == null);
        TextView localTextView;
        if (pulseTrendingArticleBoltOnValue != null)
        {
          localObject3 = pulseTrendingArticleBoltOnValue;
          localObject4 = (ViewGroup)inflater.inflate(2130968741, boltOns, false);
          localTextView = (TextView)((ViewGroup)localObject4).findViewById(2131755758);
          paramContext = (LiImageView)((ViewGroup)localObject4).findViewById(2131755757);
          if (icon != null) {
            break;
          }
          paramContext.setVisibility(8);
          if (localObject3 != null) {
            break label896;
          }
          paramContext = null;
          PromoUtils.addText(localTextView, paramContext);
          headline = ((RichText)PromoUtils.firstNonNull(new RichText[] { headline, headlineText }));
          boltOns.addView((View)localObject4);
        }
        if (jobRecommendationBoltOnValue != null)
        {
          localObject3 = jobRecommendationBoltOnValue;
          localObject4 = (ViewGroup)inflater.inflate(2130968741, boltOns, false);
          localTextView = (TextView)((ViewGroup)localObject4).findViewById(2131755758);
          paramContext = (LiImageView)((ViewGroup)localObject4).findViewById(2131755757);
          if (icon != null) {
            break label926;
          }
          paramContext.setVisibility(8);
          if (localObject3 != null) {
            break label965;
          }
          paramContext = null;
          PromoUtils.addText(localTextView, paramContext);
          headline = ((RichText)PromoUtils.firstNonNull(new RichText[] { headline, headlineText }));
          boltOns.addView((View)localObject4);
        }
      } while (socialProofBoltOnValue == null);
      paramContext = socialProofBoltOnValue;
      localObject2 = (ViewGroup)inflater.inflate(2130968740, boltOns, false);
      localObject3 = (TextView)((ViewGroup)localObject2).findViewById(2131755756);
      localObject4 = (LiImageView)((ViewGroup)localObject2).findViewById(2131755755);
      if ((profileImages != null) && (!profileImages.isEmpty())) {
        break label995;
      }
      ((LiImageView)localObject4).setVisibility(8);
    }
    for (;;)
    {
      PromoUtils.addText((TextView)localObject3, PromoUtils.getBoltonText(paramContext));
      headline = ((RichText)PromoUtils.firstNonNull(new RichText[] { headline, headlineText }));
      boltOns.addView((View)localObject2);
      break label388;
      paramContext = (MetricsInfo)metricsMap.get("action");
      break;
      label838:
      paramContext = (MetricsInfo)metricsMap.get("dismiss");
      break label263;
      paramContext.setDefaultDrawable(GhostImageUtils.getUnstructuredCompany(2131492961).getDrawable(inflater.getContext()));
      this$0.attachImageToImageViewWithFixedWidth(paramContext, icon, 0);
      break label494;
      label896:
      paramContext = (RichText)PromoUtils.firstNonNull(new RichText[] { boltonText, text });
      break label501;
      label926:
      paramContext.setDefaultDrawable(GhostImageUtils.getUnstructuredJob(2131492960).getDrawable(inflater.getContext()));
      this$0.attachImageToImageViewWithFixedWidth(paramContext, icon, 0);
      break label624;
      label965:
      paramContext = (RichText)PromoUtils.firstNonNull(new RichText[] { boltonText, text });
      break label631;
      label995:
      ((LiImageView)localObject4).setDefaultDrawable(GhostImageUtils.getAnonymousPerson(2131492960).getDrawable(inflater.getContext()));
      this$0.attachImageToImageViewWithFixedWidth((ImageView)localObject4, (Image)profileImages.get(0), 0);
    }
    label1044:
    PromoUtils.addText(text, (RichText)PromoUtils.firstNonNull(new RichText[] { headline, localPromoModel.getText() }));
    paramViewGroup.removeAllViews();
    paramViewGroup.addView(localView);
    return localView;
  }
  
  final class PromoViewHolder
    extends FeedHeroViewHolder
  {
    RichText headline;
    final LayoutInflater inflater;
    final View promoView;
    
    PromoViewHolder(View paramView)
    {
      super();
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.crosspromo.FeedSuperHeroPromo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */