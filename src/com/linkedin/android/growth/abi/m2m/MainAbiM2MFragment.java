package com.linkedin.android.growth.abi.m2m;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.linkedin.android.growth.abi.AbiAdapter;
import com.linkedin.android.growth.abi.AbiDataProvider;
import com.linkedin.android.growth.abi.AbiDataProvider.AbiState;
import com.linkedin.android.growth.abi.AbiTransformer;
import com.linkedin.android.growth.abi.MainAbiResultFragment;
import com.linkedin.android.growth.abi.m2m.events.MainAbiM2MResultsRefreshEvent;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.ui.TintableButton;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.MemberContact;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.abook.InvitationTarget;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;

public final class MainAbiM2MFragment
  extends MainAbiResultFragment
{
  public final void doEnter()
  {
    super.doEnter();
    if ((!"control".equals(fragmentComponent.lixManager().getTreatment(Lix.LIX_ABOOK_IMPORT_INVITATION_IMPRESSION_EVENT))) && (abiDataProvider.hasMemberContact()) && (contacts.hasTrackingId)) {
      tracker.send(OwlTrackingUtils.getAbookImportInvitationImpressionEventBuilder(contacts.trackingId, abiDataProvider.state).abookImportTransactionId, fragmentComponent.lixManager()).setImpressionType(InvitationTarget.MEMBER).setCount(Integer.valueOf(contacts.memberContacts.size())));
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  @Subscribe
  public final void onEvent(MainAbiM2MResultsRefreshEvent paramMainAbiM2MResultsRefreshEvent)
  {
    if (!isAdded()) {
      return;
    }
    paramMainAbiM2MResultsRefreshEvent = abiDataProvider.state).unblockedMemberContacts;
    if (CollectionUtils.isEmpty(paramMainAbiM2MResultsRefreshEvent))
    {
      goNext();
      return;
    }
    setupTitleNumberOfContacts(2131231364, paramMainAbiM2MResultsRefreshEvent.size());
    adapter.setValues(AbiTransformer.transformMemberModelCollection(fragmentComponent, abiDataProvider, paramMainAbiM2MResultsRefreshEvent));
    adapter.notifyDataSetChanged();
  }
  
  @Subscribe
  public final void onEvent(MemberContact paramMemberContact)
  {
    hasAnyContactBeenInvited = true;
    trackLegoWidgetSecondaryAction(1, "invite");
    navNextText.setText(getLocalizedString(2131231366));
    abiDataProvider.sendMemberInvitation$38148e3b(paramMemberContact, Tracker.createPageInstanceHeader(getPageInstance()), contactsTrackingId);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    toolbar.setTitle(2131231362);
    setupTitleNumberOfContacts(2131231364, count);
    setupConnectToAllMemberContactsButton(connectAllButton);
    connectAllButton.setVisibility(0);
  }
  
  public final String pageKey()
  {
    return "abi_m2m";
  }
  
  protected final AbiAdapter setUpAdapter(ImportedContacts paramImportedContacts)
  {
    FragmentComponent localFragmentComponent = fragmentComponent;
    AbiDataProvider localAbiDataProvider = abiDataProvider;
    if (abiDataProvider.state).unblockedMemberContacts != null) {}
    for (paramImportedContacts = abiDataProvider.state).unblockedMemberContacts;; paramImportedContacts = memberContacts)
    {
      paramImportedContacts = AbiTransformer.transformMemberModelCollection(localFragmentComponent, localAbiDataProvider, paramImportedContacts);
      count = paramImportedContacts.size();
      return new AbiAdapter(getActivity(), applicationComponent.mediaCenter(), paramImportedContacts);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2m.MainAbiM2MFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */