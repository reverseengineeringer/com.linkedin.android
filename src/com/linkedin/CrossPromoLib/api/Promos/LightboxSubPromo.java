package com.linkedin.CrossPromoLib.api.Promos;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.linkedin.CrossPromoLib.R.id;
import com.linkedin.CrossPromoLib.R.layout;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.models.types.ImageType;
import com.linkedin.CrossPromoLib.utils.EventTypes;
import com.linkedin.CrossPromoLib.utils.Sequence;
import com.linkedin.crosspromo.common.android.RichText;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;
import com.linkedin.crosspromo.fe.api.android.SubPromo;
import java.util.Map;

public abstract class LightboxSubPromo
{
  public static View createSubView(Context paramContext, View paramView, SubPromo paramSubPromo, String paramString, BasePromo paramBasePromo)
  {
    View localView = LayoutInflater.from(paramContext).inflate(R.layout.lightbox_sub, null);
    Object localObject = (ImageView)localView.findViewById(R.id.main_image);
    Button localButton1 = (Button)localView.findViewById(R.id.prompt_btn);
    Button localButton2 = (Button)localView.findViewById(R.id.dismiss_btn);
    paramBasePromo.addImageToSubPromoView((ImageView)localObject, paramSubPromo, ImageType.MAIN);
    if (paramView != null)
    {
      localObject = metricsMap;
      if (localObject == null) {
        break label283;
      }
      localObject = (MetricsInfo)((Map)localObject).get("action");
      label92:
      localObject = paramBasePromo.newEventTracker(EventTypes.FIRE_ACTION_AND_FETCH_PROMO, (MetricsInfo)localObject);
      if (!(paramContext instanceof Activity)) {
        break label289;
      }
      localObject = new Sequence(new Runnable[] { localObject, new Runnable()
      {
        public final void run()
        {
          ((Activity)val$context).finish();
        }
      } });
      label140:
      localObject = paramBasePromo.createOnClickListener(paramContext, paramString, actionUrl, storeUrl, (Runnable)localObject, null);
      paramString = metricsMap;
      if (paramString == null) {
        break label292;
      }
      paramString = (MetricsInfo)paramString.get("dismiss");
      label181:
      paramString = paramBasePromo.newEventTracker(EventTypes.FIRE_ACTION, paramString);
      if (!(paramContext instanceof Activity)) {
        break label297;
      }
    }
    label283:
    label289:
    label292:
    label297:
    for (paramContext = new Sequence(new Runnable[] { paramString, new Runnable()
        {
          public final void run()
          {
            ((Activity)val$context).finish();
          }
        } });; paramContext = paramString)
    {
      paramContext = paramBasePromo.createOnClickDismissListener(paramView, paramContext);
      BasePromo.addButton$6e97a4d(localButton1, (RichText)texts.get("download"), (View.OnClickListener)localObject);
      BasePromo.addButton$6e97a4d(localButton2, (RichText)texts.get("dismiss"), paramContext);
      return localView;
      paramView = localView;
      break;
      localObject = null;
      break label92;
      break label140;
      paramString = null;
      break label181;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.Promos.LightboxSubPromo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */