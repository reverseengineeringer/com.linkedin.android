package com.linkedin.android.growth.onboarding.abi.m2g;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.InjectView;
import com.linkedin.android.growth.abi.AbiAdapter;
import com.linkedin.android.growth.abi.AbiDataProvider;
import com.linkedin.android.growth.abi.AbiDataProvider.AbiState;
import com.linkedin.android.growth.abi.AbiTransformer;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.onboarding.abi.OnboardingAbiResultFragment;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.abook.InvitationTarget;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;

public class OnboardingAbiM2GSmsFragment
  extends OnboardingAbiResultFragment
{
  @InjectView(2131756121)
  LinearLayout doubleNavigationButtonContainer;
  @InjectView(2131756077)
  Button singleNextButton;
  
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
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968830, paramViewGroup, false);
  }
  
  @Subscribe
  public void onEvent(GuestContact paramGuestContact)
  {
    hasAnyContactBeenInvited = true;
    trackLegoWidgetSecondaryAction(1, "invite");
    nextButton.setText(2131231366);
    abiDataProvider.sendGuestInvitation$6dab7f4f(getActivity(), paramGuestContact, Tracker.createPageInstanceHeader(getPageInstance()), contactsTrackingId);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!"control".equals(fragmentComponent.lixManager().getTreatment(Lix.ABI_M2G_SMS_INVITE_ALL)))
    {
      doubleNavigationButtonContainer.setVisibility(0);
      singleNextButton.setVisibility(8);
      setupInviteAllSmsGuestContactsButton(inviteAllButton);
    }
    for (;;)
    {
      setupTitle(2131231497);
      setupSubtitle(2131231496, count);
      return;
      doubleNavigationButtonContainer.setVisibility(8);
      singleNextButton.setVisibility(0);
      setupNextButton(singleNextButton);
    }
  }
  
  public final String pageKey()
  {
    return "onboarding_sms";
  }
  
  protected final AbiAdapter setUpAdapter(ImportedContacts paramImportedContacts)
  {
    paramImportedContacts = AbiTransformer.transformGuestModelCollection(fragmentComponent, abiDataProvider, true, guestContacts);
    count = paramImportedContacts.size();
    return new AbiAdapter(getActivity(), applicationComponent.mediaCenter(), paramImportedContacts);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GSmsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */