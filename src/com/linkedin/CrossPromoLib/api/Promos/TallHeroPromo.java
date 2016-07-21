package com.linkedin.CrossPromoLib.api.Promos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.linkedin.CrossPromoLib.R.id;
import com.linkedin.CrossPromoLib.R.layout;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.CrossPromoLib.models.types.ImageType;
import com.linkedin.CrossPromoLib.utils.EventTypes;
import com.linkedin.CrossPromoLib.utils.Utils;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;
import com.linkedin.crosspromo.fe.api.android.Promo;
import java.util.Map;

public final class TallHeroPromo
  extends BasePromo
{
  public TallHeroPromo(PromoSource paramPromoSource)
  {
    super(paramPromoSource);
  }
  
  protected final View initView(Context paramContext, ViewGroup paramViewGroup)
  {
    PromoModel localPromoModel = getPromoModel();
    Object localObject1 = promo;
    if (Utils.isLandscapeView(paramContext)) {
      return LayoutInflater.from(paramContext).inflate(R.layout.empty_view, paramViewGroup, false);
    }
    paramViewGroup = LayoutInflater.from(paramContext).inflate(R.layout.promo7, paramViewGroup, false);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(R.id.promo7_icon_logo);
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(R.id.promo7_title_text);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(R.id.promo7_headline_text);
    Button localButton1 = (Button)paramViewGroup.findViewById(R.id.promo7_prompt_btn);
    Button localButton2 = (Button)paramViewGroup.findViewById(R.id.promo7_dismiss_btn);
    if (Utils.isPortraitView(paramContext))
    {
      localObject2 = (ImageView)paramViewGroup.findViewById(R.id.promo7_main_image);
      attachImageToImageViewWithFixedWidth((ImageView)localObject2, ImageType.MAIN.getImage(localPromoModel), ((ImageView)localObject2).getMeasuredWidth());
    }
    Object localObject2 = (MetricsInfo)metricsMap.get("action");
    localObject2 = createOnClickListener(paramContext, newEventTracker(EventTypes.FIRE_ACTION_AND_FETCH_PROMO, (MetricsInfo)localObject2), null);
    localObject1 = (MetricsInfo)metricsMap.get("dismiss");
    localObject1 = createOnClickDismissListener(paramViewGroup, newEventTracker(EventTypes.FIRE_ACTION, (MetricsInfo)localObject1));
    addLogoImage(localImageView);
    addText(localTextView1, localPromoModel.getRichTextFromModel("title"));
    addText(localTextView2, localPromoModel.getRichTextFromModel("headline"));
    addPromptButton(localButton1, localPromoModel, paramContext, (View.OnClickListener)localObject2);
    addButton$6e97a4d(localButton2, localPromoModel.getRichTextFromModel("dismiss"), (View.OnClickListener)localObject1);
    return paramViewGroup;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.Promos.TallHeroPromo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */