package com.linkedin.android.growth.onboarding;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.lego.LegoWidget;

@SuppressLint({"ValidFragment"})
public class OnboardingPlaceholderFragment
  extends LegoFragment
{
  @InjectView(2131756133)
  TextView title;
  private final String titleText;
  
  public OnboardingPlaceholderFragment(String paramString)
  {
    titleText = paramString;
  }
  
  public static OnboardingPlaceholderFragment newInstance(String paramString)
  {
    return new OnboardingPlaceholderFragment(paramString);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968844, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    title.setText(titleText);
  }
  
  public final String pageKey()
  {
    return "onboarding_placeholder";
  }
  
  @OnClick({2131756107})
  public void skipFragment()
  {
    legoWidget.finishCurrentFragment();
  }
  
  protected final void trackLegoPageImpression() {}
  
  protected final void trackLegoWidgetImpression() {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingPlaceholderFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */