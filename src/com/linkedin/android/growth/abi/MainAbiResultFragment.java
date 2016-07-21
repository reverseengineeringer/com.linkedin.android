package com.linkedin.android.growth.abi;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.Optional;
import com.linkedin.android.growth.heathrow.HeathrowLandingUtil;
import com.linkedin.android.growth.lego.LegoManager;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.lego.LegoWidgetContent;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.DrawableHelper;
import com.linkedin.android.infra.ui.TintableButton;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MainAbiResultFragment
  extends AbiResultFragment
  implements SearchView.OnQueryTextListener
{
  @InjectView(2131755942)
  @Optional
  public TintableButton connectAllButton;
  @InjectView(2131755935)
  protected LinearLayout navBack;
  @InjectView(2131755936)
  protected LinearLayout navNext;
  @InjectView(2131755938)
  protected ImageView navNextArrow;
  @InjectView(2131755937)
  public TextView navNextText;
  @InjectView(2131755940)
  protected RecyclerView recyclerView;
  @InjectView(2131755943)
  protected View searchOverlay;
  @InjectView(2131755939)
  protected TextView titleNumberOfContacts;
  @InjectView(2131755468)
  public Toolbar toolbar;
  @InjectView(2131758309)
  RelativeLayout topCard;
  @InjectView(2131755948)
  LinearLayout topCardContainer;
  private MiniProfile topCardMiniProfile;
  @InjectView(2131755955)
  protected LinearLayout valueProp;
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ("enabled".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.GROWTH_ABI_RESULTS_LANDING_TOP_NAVBAR))) {
      return paramLayoutInflater.inflate(2130968787, paramViewGroup, false);
    }
    return paramLayoutInflater.inflate(2130968786, paramViewGroup, false);
  }
  
  public final boolean onQueryTextChange(String paramString)
  {
    if (!"".equals(paramString))
    {
      searchOverlay.setVisibility(4);
      titleNumberOfContacts.setVisibility(8);
    }
    if (adapter != null)
    {
      adapter.getFilter().filter(paramString);
      return true;
    }
    return false;
  }
  
  public void onViewCreated(View paramView, final Bundle paramBundle)
  {
    int j = 1;
    super.onViewCreated(paramView, paramBundle);
    Object localObject1;
    label354:
    Object localObject2;
    int i;
    label394:
    label435:
    label475:
    I18NManager localI18NManager;
    if (legoWidget.isFirstWidgetInLegoFlow)
    {
      if (topCardMiniProfile != null)
      {
        paramBundle = topCardMiniProfile;
        topCardMiniProfile = paramBundle;
        paramBundle = fragmentComponent;
        ((BaseActivity)getActivity()).getLayoutInflater();
        HeathrowLandingUtil.setupTopCard$21706835(paramBundle, applicationComponent.mediaCenter(), topCard, topCardContainer, topCardMiniProfile, true, abiDataProvider.state).heathrowSource);
      }
    }
    else
    {
      toolbar.inflateMenu(2131820546);
      toolbar.setNavigationOnClickListener(new TrackingOnClickListener(tracker, "cancel", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          AbiActivity.restartAbiFlow(getActivity());
        }
      });
      paramBundle = toolbar.getNavigationIcon();
      if (paramBundle != null)
      {
        paramBundle = DrawableHelper.setTint(paramBundle, ContextCompat.getColor(getActivity(), 2131624058));
        toolbar.setNavigationIcon(paramBundle);
      }
      paramBundle = toolbar.getMenu().findItem(2131758747);
      paramBundle.setIcon(DrawableHelper.setTint(paramBundle.getIcon(), ContextCompat.getColor(getActivity(), 2131624058)));
      ((SearchView)paramBundle.getActionView()).setOnQueryTextListener(this);
      searchOverlay.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          MenuItemCompat.collapseActionView(paramBundle);
        }
      });
      MenuItemCompat.setOnActionExpandListener(paramBundle, new MenuItemCompat.OnActionExpandListener()
      {
        public final boolean onMenuItemActionCollapse(MenuItem paramAnonymousMenuItem)
        {
          searchOverlay.setVisibility(4);
          titleNumberOfContacts.setVisibility(0);
          if (shouldShowInviteAllButton()) {
            connectAllButton.setVisibility(0);
          }
          return true;
        }
        
        public final boolean onMenuItemActionExpand(MenuItem paramAnonymousMenuItem)
        {
          searchOverlay.setVisibility(0);
          if (connectAllButton != null) {
            connectAllButton.setVisibility(8);
          }
          return true;
        }
      });
      navBack.setOnClickListener(new TrackingOnClickListener(tracker, "back", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          getActivity().onBackPressed();
        }
      });
      navNext.setOnClickListener(new TrackingOnClickListener(tracker, "next", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          goNext();
        }
      });
      if (hasAnyContactBeenInvited) {
        navNextText.setText(getLocalizedString(2131231366));
      }
      if (((BaseActivity)getActivity() instanceof AbiActivity))
      {
        localObject1 = (AbiActivity)getActivity();
        paramBundle = legoManager;
        if (currentWidget != null) {
          break label750;
        }
        paramBundle = null;
        if (paramBundle == null) {
          break label769;
        }
        localObject2 = abiFragmentSwitch.getLegoWidget(widgetContent, null);
        if ((localObject2 == null) || (((LegoWidget)localObject2).getStatus(activityComponent) != 3)) {
          break label761;
        }
        i = 1;
        if (i == 0)
        {
          navNextText.setText(getLocalizedString(2131231340));
          navNextArrow.setVisibility(4);
        }
        paramBundle = legoManager;
        if (currentWidget != null) {
          break label774;
        }
        paramBundle = null;
        if (paramBundle == null) {
          break label793;
        }
        localObject2 = abiFragmentSwitch.getLegoWidget(widgetContent, null);
        if ((localObject2 == null) || (((LegoWidget)localObject2).getStatus(activityComponent) != 3)) {
          break label785;
        }
        i = 1;
        if (i == 0) {
          navBack.setVisibility(8);
        }
      }
      valueProp.setVisibility(8);
      if (("mobile-voyager-takeover-resultsLanding".equals(abiDataProvider.state).abiSource)) && (legoWidget.isFirstWidgetInLegoFlow))
      {
        valueProp.setVisibility(0);
        localObject1 = (AbiResultsLandingValuePropHolder)AbiResultsLandingValuePropHolder.CREATOR.createViewHolder(paramView);
        paramBundle = fragmentComponent;
        localObject2 = new AbiResultsLandingValuePropViewModel();
        localI18NManager = paramBundle.i18NManager();
        paramView = "";
        paramBundle = paramBundle.lixManager().getTreatment(Lix.GROWTH_ABI_RESULT_LANDING_VALUE_PROP);
        switch (paramBundle.hashCode())
        {
        default: 
          label632:
          i = -1;
          switch (i)
          {
          default: 
            label634:
            paramBundle = localI18NManager.getString(2131230771);
            paramView = localI18NManager.getString(2131230777);
          }
          break;
        }
      }
    }
    for (;;)
    {
      headerText = paramBundle;
      subheaderText = paramView;
      fragmentComponent.activity().getLayoutInflater();
      fragmentComponent.mediaCenter();
      ((AbiResultsLandingValuePropViewModel)localObject2).onBindViewHolder$5c3b4152((AbiResultsLandingValuePropHolder)localObject1);
      return;
      paramBundle = abiDataProvider.state).contextualMiniProfile;
      break;
      label750:
      paramBundle = currentWidget.next;
      break label354;
      label761:
      paramBundle = next;
      break label354;
      label769:
      i = 0;
      break label394;
      label774:
      paramBundle = currentWidget.previous;
      break label435;
      label785:
      paramBundle = previous;
      break label435;
      label793:
      i = 0;
      break label475;
      if (!paramBundle.equals("v1")) {
        break label632;
      }
      i = 0;
      break label634;
      if (!paramBundle.equals("v2")) {
        break label632;
      }
      i = j;
      break label634;
      if (!paramBundle.equals("v3")) {
        break label632;
      }
      i = 2;
      break label634;
      if (!paramBundle.equals("v4")) {
        break label632;
      }
      i = 3;
      break label634;
      if (!paramBundle.equals("v5")) {
        break label632;
      }
      i = 4;
      break label634;
      if (!paramBundle.equals("v6")) {
        break label632;
      }
      i = 5;
      break label634;
      paramBundle = localI18NManager.getString(2131230771);
      paramView = localI18NManager.getString(2131230777);
      continue;
      paramBundle = localI18NManager.getString(2131230772);
      paramView = localI18NManager.getString(2131230778);
      continue;
      paramBundle = localI18NManager.getString(2131230773);
      paramView = localI18NManager.getString(2131230779);
      continue;
      paramBundle = localI18NManager.getString(2131230774);
      paramView = localI18NManager.getString(2131230780);
      continue;
      paramBundle = localI18NManager.getString(2131230775);
      paramView = localI18NManager.getString(2131230781);
      continue;
      paramBundle = localI18NManager.getString(2131230776);
    }
  }
  
  public final void setupTitleNumberOfContacts(int paramInt1, int paramInt2)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getLocalizedString(paramInt1, new Object[] { Integer.valueOf(paramInt2) }));
    Object localObject = getLocalizedString(paramInt1, new Object[] { Integer.valueOf(paramInt2) });
    localObject = Pattern.compile("\\d+").matcher((CharSequence)localObject);
    while (((Matcher)localObject).find()) {
      localSpannableStringBuilder.setSpan(new StyleSpan(1), ((Matcher)localObject).start(), ((Matcher)localObject).end(), 33);
    }
    titleNumberOfContacts.setText(localSpannableStringBuilder);
  }
  
  public boolean shouldShowInviteAllButton()
  {
    return connectAllButton != null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.MainAbiResultFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */