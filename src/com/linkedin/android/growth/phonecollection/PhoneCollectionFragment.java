package com.linkedin.android.growth.phonecollection;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.InjectView;
import com.linkedin.android.growth.takeover.TakeoverIntentBundleBuilder;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import javax.inject.Inject;

public class PhoneCollectionFragment
  extends PageFragment
{
  @InjectView(2131756161)
  Button addPhoneNumberButton;
  @Inject
  IntentRegistry intentRegistry;
  @Inject
  LegoTrackingDataProvider legoTrackingDataProvider;
  private String legoTrackingToken;
  @InjectView(2131756162)
  Button notNowButton;
  @Inject
  FlagshipSharedPreferences sharedPreferences;
  @InjectView(2131756158)
  LiImageView splashImage;
  @InjectView(2131756157)
  Toolbar toolbar;
  
  public static PhoneCollectionFragment newInstance(TakeoverIntentBundleBuilder paramTakeoverIntentBundleBuilder)
  {
    PhoneCollectionFragment localPhoneCollectionFragment = new PhoneCollectionFragment();
    localPhoneCollectionFragment.setArguments(paramTakeoverIntentBundleBuilder.build());
    return localPhoneCollectionFragment;
  }
  
  public final void doEnter()
  {
    super.doEnter();
    if (!TextUtils.isEmpty(legoTrackingToken)) {
      legoTrackingDataProvider.sendWidgetImpressionEvent$4bb724c7(legoTrackingToken, Visibility.SHOW);
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    legoTrackingToken = TakeoverIntentBundleBuilder.getLegoTrackingToken(getArguments());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968851, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    toolbar.setNavigationOnClickListener(new PhoneCollectionFragment.3(this, tracker, "cancel", new TrackingEventBuilder[0]));
    int i = getActivity().getResources().getColor(2131624058);
    splashImage.setColorFilter(i);
    addPhoneNumberButton.setOnClickListener(new PhoneCollectionFragment.1(this, tracker, "add_phone_number", new TrackingEventBuilder[0]));
    notNowButton.setOnClickListener(new PhoneCollectionFragment.2(this, tracker, "not_now", new TrackingEventBuilder[0]));
  }
  
  public final String pageKey()
  {
    return "phone_collection";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.phonecollection.PhoneCollectionFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */