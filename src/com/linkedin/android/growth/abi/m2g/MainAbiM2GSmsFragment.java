package com.linkedin.android.growth.abi.m2g;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.linkedin.android.growth.abi.AbiAdapter;
import com.linkedin.android.growth.abi.AbiDataProvider;
import com.linkedin.android.growth.abi.AbiDataProvider.AbiState;
import com.linkedin.android.growth.abi.AbiTransformer;
import com.linkedin.android.growth.abi.MainAbiResultFragment;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.ui.TintableButton;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.abook.InvitationTarget;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;

public final class MainAbiM2GSmsFragment
  extends MainAbiResultFragment
{
  public final void doEnter()
  {
    super.doEnter();
    if ((!"control".equals(fragmentComponent.lixManager().getTreatment(Lix.LIX_ABOOK_IMPORT_INVITATION_IMPRESSION_EVENT))) && (abiDataProvider.hasPhoneGuestContact()) && (contacts.hasTrackingId))
    {
      int i = AbiDataProvider.getSmsContacts(contacts.guestContacts).size();
      tracker.send(OwlTrackingUtils.getAbookImportInvitationImpressionEventBuilder(contacts.trackingId, abiDataProvider.state).abookImportTransactionId, fragmentComponent.lixManager()).setImpressionType(InvitationTarget.GUEST).setCount(Integer.valueOf(i)).setInvitationCounts(OwlTrackingUtils.buildInvitationCountPerChannelForSms(fragmentComponent.lixManager(), i)));
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  @Subscribe
  public final void onEvent(GuestContact paramGuestContact)
  {
    hasAnyContactBeenInvited = true;
    trackLegoWidgetSecondaryAction(1, "invite");
    abiDataProvider.sendGuestInvitation$6dab7f4f(getActivity(), paramGuestContact, Tracker.createPageInstanceHeader(getPageInstance()), contactsTrackingId);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    setupTitleNumberOfContacts(2131231359, count);
    toolbar.setTitle(2131231358);
    if (connectAllButton != null)
    {
      if (shouldShowInviteAllButton())
      {
        setupInviteAllSmsGuestContactsButton(connectAllButton);
        connectAllButton.setVisibility(0);
      }
    }
    else {
      return;
    }
    connectAllButton.setVisibility(8);
  }
  
  public final String pageKey()
  {
    return "abi_m2g_sms";
  }
  
  protected final AbiAdapter setUpAdapter(ImportedContacts paramImportedContacts)
  {
    paramImportedContacts = AbiTransformer.transformGuestModelCollection(fragmentComponent, abiDataProvider, true, guestContacts);
    count = paramImportedContacts.size();
    return new AbiAdapter(getActivity(), applicationComponent.mediaCenter(), paramImportedContacts);
  }
  
  protected final boolean shouldShowInviteAllButton()
  {
    LixManager localLixManager = fragmentComponent.lixManager();
    return (super.shouldShowInviteAllButton()) && (!"control".equals(localLixManager.getTreatment(Lix.ABI_M2G_SMS_INVITE_ALL)));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2g.MainAbiM2GSmsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */