package com.linkedin.android.growth.onboarding.abi.m2m;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.MemberContact;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.abook.InvitationTarget;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;

public final class OnboardingAbiM2MFragment
  extends OnboardingAbiResultFragment
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
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968830, paramViewGroup, false);
  }
  
  @Subscribe
  public final void onEvent(MemberContact paramMemberContact)
  {
    hasAnyContactBeenInvited = true;
    trackLegoWidgetSecondaryAction(1, "invite");
    nextButton.setText(2131231366);
    abiDataProvider.sendMemberInvitation$38148e3b(paramMemberContact, Tracker.createPageInstanceHeader(getPageInstance()), contactsTrackingId);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    setupTitle(2131231501);
    setupSubtitle(2131231500, count);
    setupConnectToAllMemberContactsButton(inviteAllButton);
  }
  
  public final String pageKey()
  {
    return "onboarding_m2m";
  }
  
  protected final AbiAdapter setUpAdapter(ImportedContacts paramImportedContacts)
  {
    paramImportedContacts = AbiTransformer.transformMemberModelCollection(fragmentComponent, abiDataProvider, memberContacts);
    count = paramImportedContacts.size();
    return new AbiAdapter(getActivity(), applicationComponent.mediaCenter(), paramImportedContacts);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.abi.m2m.OnboardingAbiM2MFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */