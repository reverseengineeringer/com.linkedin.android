package com.linkedin.android.growth.abi;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.DrawableHelper;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.TintableButton;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts.Builder;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.JsonGeneratorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.inject.Inject;

public abstract class AbiResultFragment
  extends LegoFragment
{
  public AbiDataProvider abiDataProvider;
  public AbiAdapter adapter;
  public ImportedContacts contacts;
  public String contactsTrackingId;
  public int count;
  @Inject
  Bus eventBus;
  public boolean hasAnyContactBeenInvited;
  @InjectView(2131755940)
  protected RecyclerView recyclerView;
  @InjectView(2131755939)
  public TextView title;
  
  private void setButtonDrawable(TintableButton paramTintableButton, int paramInt)
  {
    JellyBeanMr1Utils.setCompoundDrawablesWithIntrinsicBounds$16207aff(paramTintableButton, DrawableHelper.setTint(ContextCompat.getDrawable(getContext(), paramInt), ContextCompat.getColor(getContext(), 2131624058)), null);
  }
  
  public final void doPause()
  {
    super.doPause();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    Bus.subscribe(this);
  }
  
  public final void goNext()
  {
    if (!hasAnyContactBeenInvited) {
      trackLegoWidgetSkipAction("next");
    }
    legoWidget.finishCurrentFragment();
  }
  
  protected final void inviteAllGuestContacts(List<GuestContact> paramList)
  {
    trackLegoWidgetSecondaryAction(paramList.size(), "invite");
    hasAnyContactBeenInvited = true;
    abiDataProvider.batchSendGuestInvitations$5b775b21(getActivity(), paramList, Tracker.createPageInstanceHeader(getPageInstance()), contactsTrackingId);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    abiDataProvider = getActivityactivityComponent.abiDataProvider();
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("member", (HashSet)abiDataProvider.invitedMembers);
    paramBundle.putSerializable("guest", (HashSet)abiDataProvider.invitedGuests);
    paramBundle.putBoolean("isPastImportedContacts", abiDataProvider.state).isPastImportedContacts);
    paramBundle.putBoolean("hasAnyContactBeenInvited", hasAnyContactBeenInvited);
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = ((AbiDataProvider.AbiState)abiDataProvider.state).contacts();
        localList = abiDataProvider.state).unblockedMemberContacts;
        if (localList == null) {
          break label272;
        }
        localBuilder = new ImportedContacts.Builder();
        localObject = guestContacts;
        if ((localObject != null) && (!((List)localObject).equals(Collections.emptyList()))) {
          continue;
        }
        hasGuestContacts = false;
        guestContacts = Collections.emptyList();
        if ((localList != null) && (!localList.equals(Collections.emptyList()))) {
          continue;
        }
        hasMemberContacts = false;
        memberContacts = Collections.emptyList();
      }
      catch (JsonGeneratorException paramBundle)
      {
        List localList;
        ImportedContacts.Builder localBuilder;
        getActivity();
        Util.safeThrow$7a8b4789(new RuntimeException("Model Parceler fail"));
        return;
        hasMemberContacts = true;
        memberContacts = localList;
        continue;
      }
      catch (BuilderException paramBundle)
      {
        getActivity();
        Util.safeThrow$7a8b4789(new RuntimeException("Failed to build ImportedContacts for non blocked member contacts"));
        return;
      }
      RecordParceler.parcel(localBuilder.build(RecordTemplate.Flavor.RECORD), "contact", paramBundle);
      return;
      hasGuestContacts = true;
      guestContacts = ((List)localObject);
    }
    label272:
    if (localObject != null) {
      RecordParceler.parcel((RecordTemplate)localObject, "contact", paramBundle);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    fragmentComponent.inject(this);
    super.onViewCreated(paramView, paramBundle);
    abiDataProvider = getActivityactivityComponent.abiDataProvider();
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    if (paramBundle != null) {
      hasAnyContactBeenInvited = paramBundle.getBoolean("hasAnyContactBeenInvited");
    }
    for (;;)
    {
      try
      {
        HashSet localHashSet1 = (HashSet)paramBundle.getSerializable("guest");
        HashSet localHashSet2 = (HashSet)paramBundle.getSerializable("member");
        boolean bool = paramBundle.getBoolean("isPastImportedContacts");
        paramBundle = (ImportedContacts)RecordParceler.unparcel(ImportedContacts.BUILDER, "contact", paramBundle);
        AbiDataProvider localAbiDataProvider = abiDataProvider;
        state).isPastImportedContacts = bool;
        paramView = activityComponent.activity();
        AbiDataProvider.AbiState localAbiState = (AbiDataProvider.AbiState)state;
        if (!bool) {
          continue;
        }
        paramView = localAbiDataProvider.buildPastImportedContactsRoute(paramView, state).abookImportTransactionId);
        contactsRoute = paramView;
        state).contacts = paramBundle;
        invitedGuests = localHashSet1;
        invitedMembers = localHashSet2;
      }
      catch (DataReaderException paramView)
      {
        getActivity();
        Util.safeThrow$7a8b4789(new RuntimeException("Model Parceler fail"));
        continue;
        paramView = null;
        continue;
      }
      if (abiDataProvider.isContactsDataAvailable())
      {
        contacts = ((AbiDataProvider.AbiState)abiDataProvider.state).contacts();
        if (contacts == null) {
          continue;
        }
        paramView = contacts.trackingId;
        contactsTrackingId = paramView;
        adapter = setUpAdapter(contacts);
        recyclerView.setAdapter(adapter);
      }
      return;
      paramView = AbiDataProvider.buildUploadContactsRoute$1afe14f3();
    }
  }
  
  public abstract AbiAdapter setUpAdapter(ImportedContacts paramImportedContacts);
  
  public final void setupConnectToAllMemberContactsButton(TintableButton paramTintableButton)
  {
    paramTintableButton.setEnabled(true);
    paramTintableButton.setText(getLocalizedString(2131231363));
    setButtonDrawable(paramTintableButton, 2130837974);
    paramTintableButton.setOnClickListener(new TrackingOnClickListener(tracker, "connect_all", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        paramAnonymousView = AbiResultFragment.this;
        List localList = contacts.memberContacts;
        paramAnonymousView.trackLegoWidgetSecondaryAction(localList.size(), "connect");
        hasAnyContactBeenInvited = true;
        abiDataProvider.batchSendMemberInvitations$235b8adf(localList, Tracker.createPageInstanceHeader(paramAnonymousView.getPageInstance()), contactsTrackingId);
        goNext();
      }
    });
  }
  
  public final void setupInviteAllEmailGuestContactsButton(TintableButton paramTintableButton)
  {
    paramTintableButton.setEnabled(true);
    paramTintableButton.setText(getLocalizedString(2131231357));
    setButtonDrawable(paramTintableButton, 2130837998);
    paramTintableButton.setOnClickListener(new TrackingOnClickListener(tracker, "invite_all", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        paramAnonymousView = AbiResultFragment.this;
        AbiDataProvider localAbiDataProvider = abiDataProvider;
        paramAnonymousView.inviteAllGuestContacts(AbiDataProvider.getEmailContacts(contacts.guestContacts));
        goNext();
      }
    });
  }
  
  public final void setupInviteAllSmsGuestContactsButton(TintableButton paramTintableButton)
  {
    paramTintableButton.setEnabled(true);
    paramTintableButton.setText(getLocalizedString(2131231357));
    setButtonDrawable(paramTintableButton, 2130838130);
    paramTintableButton.setOnClickListener(new TrackingOnClickListener(tracker, "invite_all", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        paramAnonymousView = AbiResultFragment.this;
        AbiDataProvider localAbiDataProvider = abiDataProvider;
        paramAnonymousView.inviteAllGuestContacts(AbiDataProvider.getSmsContacts(contacts.guestContacts));
        goNext();
      }
    });
  }
  
  public final void setupInviteAllUnifiedGuestsContactsButton(TintableButton paramTintableButton)
  {
    paramTintableButton.setEnabled(true);
    paramTintableButton.setText(getLocalizedString(2131231357));
    setButtonDrawable(paramTintableButton, 2130837974);
    paramTintableButton.setOnClickListener(new TrackingOnClickListener(tracker, "invite_all", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        if (contacts.guestContacts != null) {
          inviteAllGuestContacts(contacts.guestContacts);
        }
        goNext();
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiResultFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */