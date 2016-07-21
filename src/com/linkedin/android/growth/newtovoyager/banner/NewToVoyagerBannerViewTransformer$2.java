package com.linkedin.android.growth.newtovoyager.banner;

import com.linkedin.android.infra.components.FragmentComponent;

public final class NewToVoyagerBannerViewTransformer$2
  implements NewToVoyagerMeCardTrackingViewModel.CustomTrackImpressionListener
{
  public NewToVoyagerBannerViewTransformer$2(FragmentComponent paramFragmentComponent) {}
  
  public final void emit(String paramString)
  {
    NewToVoyagerBannerViewTransformer.sendLegoWidgetImpressionEvent(val$fragmentComponent, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerBannerViewTransformer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */