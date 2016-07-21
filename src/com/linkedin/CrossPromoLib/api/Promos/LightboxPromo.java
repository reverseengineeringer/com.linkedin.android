package com.linkedin.CrossPromoLib.api.Promos;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.linkedin.CrossPromoLib.R.dimen;
import com.linkedin.CrossPromoLib.R.drawable;
import com.linkedin.CrossPromoLib.R.id;
import com.linkedin.CrossPromoLib.R.layout;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.CrossPromoLib.models.types.ImageType;
import com.linkedin.CrossPromoLib.models.types.PromoType;
import com.linkedin.CrossPromoLib.utils.EventTypes;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.crosspromo.fe.api.android.SubPromo;
import java.util.List;
import java.util.Map;

public final class LightboxPromo
  extends BasePromo
{
  private Runnable fireScrollRunnable;
  protected FragmentManager fragmentManager = null;
  private View promoView;
  protected int subViewCount;
  
  public LightboxPromo(PromoSource paramPromoSource)
  {
    super(paramPromoSource);
    paramPromoSource = getPromoModelpromo.subPromos;
    if (paramPromoSource == null) {}
    for (int i = 0;; i = paramPromoSource.size())
    {
      subViewCount = i;
      return;
    }
  }
  
  private void updateDotIndicator(Context paramContext, int paramInt)
  {
    if (subViewCount > 1)
    {
      LinearLayout localLinearLayout = (LinearLayout)promoView.findViewById(R.id.pager_indicator);
      localLinearLayout.removeAllViews();
      int i = 0;
      if (i < subViewCount)
      {
        ImageView localImageView = new ImageView(paramContext);
        int j = (int)promoView.getResources().getDimension(R.dimen.lightbox_indicator_size);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
        j = (int)promoView.getResources().getDimension(R.dimen.lightbox_indicator_margin_side);
        localLayoutParams.setMargins(j, 0, j, 0);
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (i == paramInt) {
          localImageView.setBackgroundResource(R.drawable.dot_filled);
        }
        for (;;)
        {
          localLinearLayout.addView(localImageView);
          i += 1;
          break;
          localImageView.setBackgroundResource(R.drawable.dot_stroke);
        }
      }
    }
  }
  
  protected final View initView(Context paramContext, ViewGroup paramViewGroup)
  {
    Object localObject = getPromoModel();
    paramViewGroup = LayoutInflater.from(paramContext).inflate(R.layout.lightbox_master, paramViewGroup, false);
    ViewPager localViewPager = (ViewPager)paramViewGroup.findViewById(R.id.promoPager);
    localViewPager.setAdapter(new subViewAdapter(fragmentManager, promo.subPromos, promo.appId, this, paramViewGroup));
    LightboxPageChangeListener localLightboxPageChangeListener = new LightboxPageChangeListener(paramContext);
    if (promo.metricsMap != null)
    {
      localObject = (MetricsInfo)promo.metricsMap.get("sweep");
      fireScrollRunnable = newEventTracker(EventTypes.FIRE_ACTION, (MetricsInfo)localObject);
    }
    localViewPager.setOnPageChangeListener(localLightboxPageChangeListener);
    updateDotIndicator(paramContext, 0);
    lockLoadingImages();
    return paramViewGroup;
  }
  
  private final class LightboxPageChangeListener
    implements ViewPager.OnPageChangeListener
  {
    private Context context;
    
    public LightboxPageChangeListener(Context paramContext)
    {
      context = paramContext;
    }
    
    public final void onPageScrollStateChanged(int paramInt) {}
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public final void onPageSelected(int paramInt)
    {
      LightboxPromo.this.updateDotIndicator(context, paramInt);
      if (fireScrollRunnable != null) {
        fireScrollRunnable.run();
      }
    }
  }
  
  private static final class subViewAdapter
    extends FragmentStatePagerAdapter
  {
    private String appId;
    private final BasePromo promo;
    private List<SubPromo> subPromos;
    private View view;
    
    public subViewAdapter(FragmentManager paramFragmentManager, List<SubPromo> paramList, String paramString, BasePromo paramBasePromo, View paramView)
    {
      super();
      subPromos = paramList;
      appId = paramString;
      promo = paramBasePromo;
      view = paramView;
    }
    
    public final int getCount()
    {
      return subPromos.size();
    }
    
    public final Fragment getItem(int paramInt)
    {
      SubPromo localSubPromo = (SubPromo)subPromos.get(paramInt);
      if (localSubPromo != null) {
        return PagerFragment.getInstance(localSubPromo, appId, promo, view);
      }
      return null;
    }
    
    public static final class PagerFragment
      extends Fragment
    {
      private String appId;
      private View masterView;
      private BasePromo promo;
      private SubPromo subPromo;
      
      public static PagerFragment getInstance(SubPromo paramSubPromo, String paramString, BasePromo paramBasePromo, View paramView)
      {
        PagerFragment localPagerFragment = new PagerFragment();
        subPromo = paramSubPromo;
        appId = paramString;
        promo = paramBasePromo;
        masterView = paramView;
        return localPagerFragment;
      }
      
      public final void onActivityCreated(Bundle paramBundle)
      {
        super.onActivityCreated(paramBundle);
      }
      
      public final void onCreate(Bundle paramBundle)
      {
        super.onCreate(paramBundle);
      }
      
      public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
      {
        if (paramViewGroup == null) {
          return null;
        }
        paramViewGroup = (LinearLayout)paramLayoutInflater.inflate(R.layout.subpromo_view_holder, paramViewGroup, false);
        paramBundle = new PromoType(subPromo.tType);
        paramLayoutInflater = null;
        Object localObject2;
        Object localObject1;
        if (PromoType.LIGHTBOX_PROMO_ICON.equals(paramBundle))
        {
          localObject2 = masterView.getContext();
          paramBundle = subPromo;
          paramLayoutInflater = appId;
          localObject1 = promo;
          paramLayoutInflater = LightboxSubPromo.createSubView((Context)localObject2, paramViewGroup, paramBundle, paramLayoutInflater, (BasePromo)localObject1);
          Object localObject3 = (LinearLayout)paramLayoutInflater.findViewById(R.id.info_container);
          LayoutInflater.from((Context)localObject2).inflate(R.layout.lightbox_icon, (ViewGroup)localObject3);
          localObject2 = (TextView)paramLayoutInflater.findViewById(R.id.title_text);
          localObject3 = (TextView)paramLayoutInflater.findViewById(R.id.main_text);
          BasePromo.addRichTextToSubPromoTextView((TextView)localObject2, paramBundle, "title");
          BasePromo.addRichTextToSubPromoTextView((TextView)localObject3, paramBundle, "main");
          ((BasePromo)localObject1).addImageToSubPromoView((ImageView)paramLayoutInflater.findViewById(R.id.icon_logo), paramBundle, ImageType.LOGO);
        }
        for (;;)
        {
          paramViewGroup.addView(paramLayoutInflater, 0);
          promo.doneLoadingImages();
          return paramViewGroup;
          if (PromoType.LIGHTBOX_PROMO_NOICON.equals(paramBundle))
          {
            localObject1 = masterView.getContext();
            paramBundle = subPromo;
            paramLayoutInflater = LightboxSubPromo.createSubView((Context)localObject1, paramViewGroup, paramBundle, appId, promo);
            localObject2 = (LinearLayout)paramLayoutInflater.findViewById(R.id.info_container);
            LayoutInflater.from((Context)localObject1).inflate(R.layout.lightbox_noicon, (ViewGroup)localObject2);
            localObject1 = (TextView)paramLayoutInflater.findViewById(R.id.title_text);
            localObject2 = (TextView)paramLayoutInflater.findViewById(R.id.main_text);
            BasePromo.addRichTextToSubPromoTextView((TextView)localObject1, paramBundle, "title");
            BasePromo.addRichTextToSubPromoTextView((TextView)localObject2, paramBundle, "main");
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.Promos.LightboxPromo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */