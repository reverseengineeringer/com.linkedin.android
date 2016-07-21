package com.linkedin.android.axle;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;

class ToastPromo$PromoViewHolder
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
  
  ToastPromo$PromoViewHolder(ToastPromo paramToastPromo, View paramView, ViewGroup paramViewGroup)
  {
    super(paramView);
    promoView = paramView;
    container = paramViewGroup;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.ToastPromo.PromoViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */