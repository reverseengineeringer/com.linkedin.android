package com.linkedin.android.entities.company.controllers;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.linkedin.android.entities.EntityUpdatesFragment;
import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.company.CompanyDataProvider.CompanyState;
import com.linkedin.android.entities.company.CompanyUpdatesBundleBuilder;
import com.linkedin.android.feed.events.UpdateActionEvent;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFeedModuleKey;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;

public final class CompanyUpdatesFragment
  extends EntityUpdatesFragment
{
  private String companyUpdatesRoute;
  private CompanyDataProvider dataProvider;
  
  public static CompanyUpdatesFragment newInstance(CompanyUpdatesBundleBuilder paramCompanyUpdatesBundleBuilder)
  {
    CompanyUpdatesFragment localCompanyUpdatesFragment = new CompanyUpdatesFragment();
    localCompanyUpdatesFragment.setArguments(paramCompanyUpdatesBundleBuilder.build());
    return localCompanyUpdatesFragment;
  }
  
  public final void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    fragmentComponent.eventBus();
    Bus.subscribe(this);
  }
  
  public final int feedType()
  {
    return 7;
  }
  
  protected final TrackingClosure<Void, Void> getOnErrorButtonClickClosure()
  {
    new TrackingClosure(tracker, "try_again") {};
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    dataProvider = getActivityactivityComponent.companyDataProvider();
    dataProvider.state).fromSubEntityPage = true;
    super.onActivityCreated(paramBundle);
    toolbar.setTitle(getLocalizedString(2131230875));
    paramBundle = getArguments().getString("companyId");
    companyUpdatesRoute = Routes.FEED.buildUponRoot().buildUpon().appendQueryParameter("q", "companyFeed").appendQueryParameter("companyId", paramBundle).appendQueryParameter("moduleKey", EntitiesFeedModuleKey.ENTITIES_COMPANY_PHONE.name()).build().toString();
    dataProvider.fetchInitialCompanyUpdates(busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), companyUpdatesRoute);
    paramBundle = dataProvider.state).allUpdatesHelper;
    if (paramBundle != null) {
      setupLoadMoreScrollListener(paramBundle, companyUpdatesRoute);
    }
  }
  
  @Subscribe
  public final void onEvent(UpdateActionEvent paramUpdateActionEvent)
  {
    CompanyDataProvider.handleUpdateOverflowAction(fragmentComponent, paramUpdateActionEvent, Tracker.createPageInstanceHeader(getPageInstance()), isActive);
  }
  
  public final String pageKey()
  {
    return "company_updates";
  }
  
  protected final List<ViewModel> setupInitialRows()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.controllers.CompanyUpdatesFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */