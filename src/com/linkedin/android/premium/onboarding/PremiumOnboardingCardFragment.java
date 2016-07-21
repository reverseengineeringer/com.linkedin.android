package com.linkedin.android.premium.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProductFamily;
import com.linkedin.android.pegasus.gen.voyager.premium.onboarding.PremiumOnboardingCard;
import com.linkedin.android.pegasus.gen.voyager.premium.onboarding.PremiumOnboardingCard.Card;
import javax.inject.Inject;

public final class PremiumOnboardingCardFragment
  extends PageFragment
{
  private View layout;
  @Inject
  MemberUtil memberUtil;
  boolean supportsDarkTheme = true;
  private BaseViewHolder viewHolder;
  private ViewModel viewModel;
  
  private void createViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, ViewHolderCreator paramViewHolderCreator)
  {
    viewHolder = paramViewHolderCreator.createViewHolder(paramLayoutInflater.inflate(paramViewHolderCreator.getLayoutId(), paramViewGroup, false));
  }
  
  public static PremiumOnboardingCardFragment newInstance(PremiumOnboardingBundleBuilder paramPremiumOnboardingBundleBuilder)
  {
    PremiumOnboardingCardFragment localPremiumOnboardingCardFragment = new PremiumOnboardingCardFragment();
    localPremiumOnboardingCardFragment.setArguments(paramPremiumOnboardingBundleBuilder.build());
    return localPremiumOnboardingCardFragment;
  }
  
  static boolean supportsOnboardingCard(PremiumOnboardingCard paramPremiumOnboardingCard)
  {
    return (card.welcomeCardValue != null) || (card.inMailCardValue != null) || (card.featuredApplicantCardValue != null) || (card.searchCardValue != null) || (card.wvmpCardValue != null) || (card.jobCardValue != null) || (card.launchCardValue != null);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = PremiumOnboardingBundleBuilder.getOnboardingCard(getArguments());
    PremiumProductFamily localPremiumProductFamily = PremiumOnboardingBundleBuilder.getProductFamily(getArguments());
    if (paramBundle == null) {
      return null;
    }
    Object localObject;
    String str;
    if (card.welcomeCardValue != null)
    {
      createViewHolder(paramLayoutInflater, paramViewGroup, PremiumOnboardingWelcomeViewHolder.CREATOR);
      paramViewGroup = (PremiumOnboardingWelcomeViewHolder)viewHolder;
      localObject = (PremiumOnboardingFragment)getParentFragment();
      layout = layout;
      cta.setOnClickListener(nextPageClickListener);
      supportsDarkTheme = false;
      paramViewGroup = fragmentComponent.i18NManager();
      localObject = fragmentComponent.memberUtil().getMiniProfile();
      str = Util.retrieveRumSessionId(fragmentComponent);
      if (card.welcomeCardValue == null) {
        break label376;
      }
      viewModel = PremiumOnboardingTransformer.toWelcomeViewModel(card.welcomeCardValue, localPremiumProductFamily, paramViewGroup, (MiniProfile)localObject, str);
    }
    for (;;)
    {
      if ((viewHolder != null) && (viewModel != null)) {
        break label578;
      }
      getActivity();
      Util.safeThrow$7a8b4789(new RuntimeException("Unexpected onboarding card"));
      return null;
      if (card.inMailCardValue != null)
      {
        createViewHolder(paramLayoutInflater, paramViewGroup, PremiumOnboardingInmailViewHolder.CREATOR);
        layout = viewHolder).layout;
        break;
      }
      if (card.jobCardValue != null)
      {
        createViewHolder(paramLayoutInflater, paramViewGroup, PremiumOnboardingJobViewHolder.CREATOR);
        layout = viewHolder).layout;
        break;
      }
      if (card.featuredApplicantCardValue != null)
      {
        createViewHolder(paramLayoutInflater, paramViewGroup, PremiumOnboardingFeaturedApplicantViewHolder.CREATOR);
        layout = viewHolder).layout;
        break;
      }
      if ((card.wvmpCardValue != null) || (card.searchCardValue != null))
      {
        createViewHolder(paramLayoutInflater, paramViewGroup, PremiumOnboardingPeopleViewHolder.CREATOR);
        layout = viewHolder).layout;
        break;
      }
      if (card.launchCardValue == null) {
        break;
      }
      createViewHolder(paramLayoutInflater, paramViewGroup, PremiumOnboardingLaunchViewHolder.CREATOR);
      layout = viewHolder).layout;
      supportsDarkTheme = false;
      break;
      label376:
      if (card.inMailCardValue != null) {
        viewModel = PremiumOnboardingTransformer.toInmailViewModel(card.inMailCardValue, localPremiumProductFamily, paramViewGroup, str);
      } else if (card.jobCardValue != null) {
        viewModel = PremiumOnboardingTransformer.toJobViewModel(card.jobCardValue, localPremiumProductFamily, paramViewGroup, str);
      } else if (card.featuredApplicantCardValue != null) {
        viewModel = PremiumOnboardingTransformer.toFeaturedApplicantViewModel(card.featuredApplicantCardValue, localPremiumProductFamily, paramViewGroup, (MiniProfile)localObject, str);
      } else if (card.wvmpCardValue != null) {
        viewModel = PremiumOnboardingTransformer.toPeopleViewModel(card.wvmpCardValue, localPremiumProductFamily, paramViewGroup, str);
      } else if (card.searchCardValue != null) {
        viewModel = PremiumOnboardingTransformer.toPeopleViewModel(card.searchCardValue, localPremiumProductFamily, paramViewGroup, str);
      } else if (card.launchCardValue != null) {
        viewModel = PremiumOnboardingTransformer.toLaunchViewModel(card.launchCardValue, localPremiumProductFamily, getActivity(), tracker, paramViewGroup, (MiniProfile)localObject);
      }
    }
    label578:
    viewModel.onBindViewHolder(paramLayoutInflater, applicationComponent.mediaCenter(), viewHolder);
    return layout;
  }
  
  public final String pageKey()
  {
    return null;
  }
  
  public final boolean shouldTrack()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.onboarding.PremiumOnboardingCardFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */