package com.linkedin.android.identity.profile.view.custominvite;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.profile.ProfileActionHandlerFragment;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.profile.view.topcard.events.SendCustomInvitationEvent;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.invitations.FlowType;
import com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.invitations.InvitationTargetType;
import com.linkedin.gen.avro2pegasus.events.invitations.InvitationTrackingInfo.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.Subscribe;

public class CustomInviteFragment
  extends ProfileActionHandlerFragment
  implements OnBackPressedListener
{
  private TextWatcher characterCounter = new CustomInviteFragment.1(this);
  @InjectView(2131755375)
  RelativeLayout header;
  @InjectView(2131755373)
  EditText inviteMessage;
  private KeyboardUtil keyboardUtil;
  @InjectView(2131755374)
  TextView messageLength;
  private ProfileDataProvider profileDataProvider;
  private String profileId;
  @InjectView(2131755372)
  TextView sendButton;
  @InjectView(2131755371)
  Toolbar toolbar;
  
  private TrackingClosure<Boolean, Void> getSaveClosure(MiniProfile paramMiniProfile)
  {
    return new CustomInviteFragment.3(this, fragmentComponent.tracker(), "personalize_invite_send", paramMiniProfile);
  }
  
  private void goBackToPreviousFragment()
  {
    getFragmentManager().popBackStack();
    if (getActivity() != null)
    {
      View localView = getActivity().getCurrentFocus();
      if (localView != null)
      {
        InputMethodManager localInputMethodManager = KeyboardUtil.fetchKeyboard(localView.getContext());
        if (localInputMethodManager != null) {
          localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
        }
      }
    }
  }
  
  public static CustomInviteFragment newInstance(CustomInviteBundleBuilder paramCustomInviteBundleBuilder)
  {
    CustomInviteFragment localCustomInviteFragment = new CustomInviteFragment();
    localCustomInviteFragment.setArguments(paramCustomInviteBundleBuilder.build());
    return localCustomInviteFragment;
  }
  
  private void setupHeader(MiniProfile paramMiniProfile)
  {
    if (paramMiniProfile == null)
    {
      header.setVisibility(8);
      return;
    }
    header.setVisibility(0);
    CustomInviteHeaderViewHolder localCustomInviteHeaderViewHolder = new CustomInviteHeaderViewHolder(header);
    FragmentComponent localFragmentComponent = fragmentComponent;
    I18NManager localI18NManager = localFragmentComponent.i18NManager();
    CustomInviteHeaderViewModel localCustomInviteHeaderViewModel = new CustomInviteHeaderViewModel();
    text = localI18NManager.getSpannedString(2131232641, new Object[] { I18NManager.getName(paramMiniProfile) });
    image = new ImageModel(picture, GhostImageUtils.getPerson(2131492963, paramMiniProfile), Util.retrieveRumSessionId(localFragmentComponent));
    LayoutInflater.from(header.getContext());
    localCustomInviteHeaderViewModel.onBindViewHolder$24f2b51e(fragmentComponent.mediaCenter(), localCustomInviteHeaderViewHolder);
  }
  
  private void setupSaveButton(TrackingClosure<Boolean, Void> paramTrackingClosure)
  {
    sendButton.setOnClickListener(new CustomInviteFragment.4(this, tracker, controlName, new TrackingEventBuilder[0], paramTrackingClosure));
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean onBackPressed()
  {
    if ((inviteMessage.getText() != null) && (inviteMessage.getText().length() != 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      new AlertDialog.Builder(getActivity()).setMessage(2131230839).setPositiveButton(2131230835, new CustomInviteFragment.6(this, fragmentComponent.tracker(), "personalize_invite_alert_continue_edit", new TrackingEventBuilder[0])).setNegativeButton(2131230834, new CustomInviteFragment.5(this, fragmentComponent.tracker(), "personalize_invite_alert_cancel_invite", new TrackingEventBuilder[0])).setIcon$38a3bc68().show();
      return true;
    }
    goBackToPreviousFragment();
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    return paramLayoutInflater.inflate(2130968642, paramViewGroup, false);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    paramType = profileDataProvider.getProfileModel();
    setupHeader(miniProfile);
    setupSaveButton(getSaveClosure(miniProfile));
  }
  
  @Subscribe
  public void onEvent(SendCustomInvitationEvent paramSendCustomInvitationEvent)
  {
    FragmentComponent localFragmentComponent;
    if (fragmentComponent.lixManager().getTreatment(Lix.LIX_DISABLE_INVITATION_CLICK_EVENT).equals("control"))
    {
      localFragmentComponent = fragmentComponent;
      localObject1 = null;
    }
    try
    {
      localObject2 = new InvitationTrackingInfo.Builder().setInvitationTrackingId(trackingId).setRecipientUrn(entityUrnString).build(RecordTemplate.Flavor.RECORD);
      localObject1 = localObject2;
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        Object localObject2;
        Util.safeThrow(new RuntimeException("Failed to create invitationTrackingInfo", localBuilderException));
      }
      profileDataProvider.sendConnectInvitation(profileId, trackingId, message, fragmentComponent);
    }
    localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    Object localObject1 = new InvitationClickEvent.Builder();
    ((InvitationClickEvent.Builder)localObject1).setProduct("profile").setSubproduct("mobile-voyager-primary").setInvitationType(InvitationTargetType.MEMBER).setInvitationTrackingInfo((List)localObject2).setFlow(FlowType.INVITATION);
    localFragmentComponent.tracker().send((TrackingEventBuilder)localObject1);
    if (!"control".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.LIX_HEATHROW_PROFILE_CONNECT)))
    {
      profileDataProvider.sendConnectInvitationAsync(miniProfile, trackingId, message, fragmentComponent);
      return;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    profileId = getArguments().getString("profileId");
    inviteMessage.addTextChangedListener(characterCounter);
    toolbar.setNavigationOnClickListener(new CustomInviteFragment.2(this));
    toolbar.setTitle(2131232640);
    keyboardUtil = new KeyboardUtil();
    KeyboardUtil.showKeyboard(inviteMessage);
    profileDataProvider = fragmentComponent.activity().activityComponent.profileDataProvider();
    if (profileDataProvider != null)
    {
      paramView = profileDataProvider;
      if ((!paramView.isDataAvailable()) || (paramView.getProfileModel() == null)) {
        break label157;
      }
    }
    label157:
    for (int i = 1; i != 0; i = 0)
    {
      paramView = profileDataProvider.getProfileModel();
      setupHeader(miniProfile);
      setupSaveButton(getSaveClosure(miniProfile));
      return;
    }
    paramView = profileDataProvider;
    paramBundle = busSubscriberId;
    String str = getRumSessionId();
    Object localObject = profileId;
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    state).profileViewRoute = ProfileRoutes.buildProfileViewRoute((String)localObject).toString();
    state).profileRoute = ProfileRoutes.buildProfileRoute((String)localObject).toString();
    localObject = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    if (profileViewApiEnabled) {
      ((MultiplexRequest.Builder)localObject).required(Request.get().url(state).profileViewRoute).builder(ProfileView.BUILDER));
    }
    for (;;)
    {
      paramView.performMultiplexedFetch(paramBundle, str, localMap, (MultiplexRequest.Builder)localObject);
      return;
      ((MultiplexRequest.Builder)localObject).required(Request.get().url(state).profileRoute).builder(Profile.BUILDER));
    }
  }
  
  public final String pageKey()
  {
    return "profile_view_personalize_invite";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.custominvite.CustomInviteFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */