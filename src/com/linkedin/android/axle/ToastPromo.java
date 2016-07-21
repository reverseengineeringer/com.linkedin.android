package com.linkedin.android.axle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.CrossPromoLib.utils.EventTypes;
import com.linkedin.CrossPromoLib.utils.PromoUtils;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;
import com.linkedin.crosspromo.fe.api.android.Promo;
import java.util.Map;

public final class ToastPromo
  extends BasePromo
{
  private final Bus bus;
  private int translationDistance;
  private int translationDuration;
  
  public ToastPromo(PromoSource paramPromoSource, Bus paramBus)
  {
    super(paramPromoSource);
    bus = paramBus;
  }
  
  protected final View initView(Context paramContext, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    View localView = LayoutInflater.from(paramContext).inflate(2130969443, paramViewGroup, false);
    PromoViewHolder localPromoViewHolder = new PromoViewHolder(localView, paramViewGroup);
    Object localObject3 = promoView.getContext();
    PromoModel localPromoModel = this$0.getPromoModel();
    Promo localPromo = promo;
    if (metricsMap == null)
    {
      localObject1 = null;
      localObject1 = this$0.newEventTracker(EventTypes.FIRE_ACTION, (MetricsInfo)localObject1);
      localObject3 = new DismissAndThen(this$0, this$0.createOnClickListener((Context)localObject3, (Runnable)localObject1, null), container);
      if (metricsMap != null) {
        break label341;
      }
    }
    label341:
    for (Object localObject1 = localObject2;; localObject1 = (MetricsInfo)metricsMap.get("dismiss"))
    {
      localObject1 = new ToastPromo.PromoViewHolder.1(localPromoViewHolder, (MetricsInfo)localObject1, this$0.newEventTracker(EventTypes.FIRE_ACTION, (MetricsInfo)localObject1));
      localObject1 = new DismissAndThen(this$0, (View.OnClickListener)localObject1, container);
      this$0.addLogoImage(logo);
      PromoUtils.addText(title, localPromoModel.getText());
      cancel.setOnClickListener((View.OnClickListener)localObject1);
      cancelArea.setOnClickListener((View.OnClickListener)localObject1);
      promoView.setOnClickListener((View.OnClickListener)localObject3);
      prompt.setOnClickListener((View.OnClickListener)localObject3);
      logo.setOnClickListener((View.OnClickListener)localObject3);
      paramViewGroup.removeAllViews();
      paramViewGroup.addView(localView);
      translationDistance = (paramContext.getResources().getDimensionPixelSize(2131492963) + paramContext.getResources().getDimensionPixelSize(2131492989));
      translationDuration = paramContext.getResources().getInteger(2131558410);
      paramViewGroup.setTranslationY(translationDistance);
      paramViewGroup.animate().setInterpolator(new DecelerateInterpolator()).setDuration(translationDuration).translationY(0.0F);
      return localView;
      localObject1 = (MetricsInfo)metricsMap.get("action");
      break;
    }
  }
  
  private final class DismissAndThen
    implements View.OnClickListener
  {
    final ViewGroup container;
    final View.OnClickListener next;
    
    public DismissAndThen(View.OnClickListener paramOnClickListener, ViewGroup paramViewGroup)
    {
      next = paramOnClickListener;
      container = paramViewGroup;
    }
    
    public final void onClick(final View paramView)
    {
      container.animate().setInterpolator(new AccelerateInterpolator()).setDuration(translationDuration).translationY(translationDistance).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          super.onAnimationEnd(paramAnonymousAnimator);
          if (next != null) {
            next.onClick(paramView);
          }
          container.setVisibility(8);
          container.removeAllViews();
        }
      });
    }
  }
  
  class PromoViewHolder
    extends BaseViewHolder
  {
    @InjectView(2131758661)
    ImageView cancel;
    @InjectView(2131758660)
    RelativeLayout cancelArea;
    final ViewGroup container;
    @InjectView(2131758662)
    ImageView logo;
    final View promoView;
    @InjectView(2131758664)
    ImageView prompt;
    @InjectView(2131758663)
    TextView title;
    
    PromoViewHolder(View paramView, ViewGroup paramViewGroup)
    {
      super();
      promoView = paramView;
      container = paramViewGroup;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.ToastPromo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */