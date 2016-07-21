package com.linkedin.messengerlib.ui.compose;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.File;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.messaging.Conversation;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.EventSubtype;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.messengerlib.MessengerDrawableResources;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.MessengerLixManager;
import com.linkedin.messengerlib.R.color;
import com.linkedin.messengerlib.R.id;
import com.linkedin.messengerlib.R.layout;
import com.linkedin.messengerlib.attachment.AttachmentUploadState;
import com.linkedin.messengerlib.attachment.PendingAttachment;
import com.linkedin.messengerlib.consumers.ConversationDataManager;
import com.linkedin.messengerlib.consumers.DataManager;
import com.linkedin.messengerlib.event.EventCreateType;
import com.linkedin.messengerlib.event.PendingEvent;
import com.linkedin.messengerlib.event.PendingEvent.Factory;
import com.linkedin.messengerlib.me.MeFetcher;
import com.linkedin.messengerlib.shared.BaseFragment;
import com.linkedin.messengerlib.shared.FragmentComponent;
import com.linkedin.messengerlib.shared.MessengerRecyclerView;
import com.linkedin.messengerlib.sticker.LocalSticker;
import com.linkedin.messengerlib.ui.PeopleSearchCompletionView;
import com.linkedin.messengerlib.ui.common.ClearableEditText;
import com.linkedin.messengerlib.ui.messagelist.MessageListBundleBuilder;
import com.linkedin.messengerlib.ui.messagelist.MessageListFragment;
import com.linkedin.messengerlib.ui.messagelist.StickerTrayFragment.OnStickerActionListener;
import com.linkedin.messengerlib.ui.messagelist.StickerTrayView;
import com.linkedin.messengerlib.utils.ComposeButtonsVisibility;
import com.linkedin.messengerlib.utils.I18NManager;
import com.linkedin.messengerlib.utils.MessageSenderUtil;
import com.linkedin.messengerlib.utils.PreLayoutSoftKeyboardStateListener;
import com.linkedin.messengerlib.utils.UrnUtil;
import com.linkedin.messengerlib.viewmodel.GroupViewModel;
import com.linkedin.messengerlib.viewmodel.ViewModel;
import com.linkedin.messengerlib.viewmodel.ViewModelTransformer;
import com.linkedin.xmsg.Name;
import com.linkedin.xmsg.util.StringUtils;
import com.tokenautocomplete.TokenCompleteTextView.TokenClickStyle;
import com.tokenautocomplete.TokenCompleteTextView.TokenDeleteStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;

public class ComposeFragment
  extends MessageCreateFragment
  implements MessengerKeyboardFragment.MessengerKeyboardHost
{
  private static final String TAG = ComposeFragment.class.getCanonicalName();
  private float actionBarElevation;
  private Handler animationHandler;
  private ImageButton cameraButton;
  private ViewGroup composeMessageContainer;
  public ComposeProgressListener composeProgressListener;
  private EditText composeText;
  private TextWatcher composeTextWatcher;
  private ViewGroup contentContainer;
  public ComposeFragment.FetchProfilesListener fetchProfilesListener;
  private String groupUrn;
  private String hint;
  private ViewGroup insightMessageContainer;
  private String invitationMessageId;
  private boolean isComposeAssistEnabled;
  private boolean isGroupTypeaheadEnabled;
  private boolean isKeyboardV2Enabled;
  private boolean isRecipientsListLocked;
  private ViewGroup messageFragmentContainer;
  public MessageListFragment messageListFragment;
  private MessengerKeyboardFragment messengerKeyboardFragment;
  private ClearableEditText namingConversationText;
  private ViewGroup oldKeyboard;
  private StickerTrayFragment.OnStickerActionListener onStickerActionListener;
  private RecipientSelector peopleResultsListAdapter;
  private List<String> prefiledRecipientsArray;
  private String prefilledBody = "";
  private List<ViewModel> prefilledRecipients = new ArrayList();
  private String propActionEventParcel;
  private String propId;
  private List<ViewModel> recipientsList = new ArrayList();
  private PeopleSearchCompletionView recipientsView;
  private View recipientsViewDivider;
  private TextWatcher recipientsViewTextWatcher;
  private MessengerRecyclerView recyclerView;
  private ImageButton sendButton;
  public ComposeFragment.SendMessageListener sendMessageListener;
  private boolean shouldFinishActivityAfterSend;
  private boolean showInsightMessage;
  private ImageButton stickerButton;
  private StickerTrayView stickerKeyboard;
  private Timer timer;
  public TitleChangeListener titleChangeListener;
  private String updateUrnForPreview;
  
  private void animateNamingConversationTextIfNecessary()
  {
    if (recipientsList.size() >= 2) {}
    for (boolean bool = true;; bool = false)
    {
      animateNamingConversationTextIfNecessary(bool);
      return;
    }
  }
  
  private void animateNamingConversationTextIfNecessary(boolean paramBoolean)
  {
    float f2 = 0.0F;
    if (namingConversationText == null) {
      return;
    }
    float f1;
    if ((getActivity() instanceof AppCompatActivity))
    {
      localObject = ((AppCompatActivity)getActivity()).getSupportActionBar();
      if ((localObject != null) && (Build.VERSION.SDK_INT >= 21))
      {
        if (!paramBoolean) {
          break label101;
        }
        f1 = 0.0F;
        ((ActionBar)localObject).setElevation(f1);
        localObject = namingConversationText;
        f1 = f2;
        if (paramBoolean) {
          f1 = actionBarElevation;
        }
        ((ClearableEditText)localObject).setElevation(f1);
      }
    }
    Object localObject = namingConversationText;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((ClearableEditText)localObject).setVisibility(i);
      return;
      label101:
      f1 = actionBarElevation;
      break;
    }
  }
  
  private void fetchSuggestedConnections()
  {
    MessengerLibApi localMessengerLibApi = getMessengerLibApi();
    if (localMessengerLibApi == null) {
      return;
    }
    localMessengerLibApi.getSuggestedConnections(new ComposeFragment.24(this));
  }
  
  private String getConversationNameFromTextbox()
  {
    if ((namingConversationText == null) || (recipientsList.size() < 2)) {
      return null;
    }
    return namingConversationText.getText().toString().trim();
  }
  
  private String getRecipientViewContentDescription()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    List localList = ViewModelTransformer.flattenPeopleViewModels(recipientsList);
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (MiniProfile)localList.get(i);
      localObject = Name.builder().setFirstName(firstName).setLastName(lastName);
      localStringBuilder.append(fragmentComponent.i18NManager.getString("{0,name,full}", new Object[] { localObject }));
      if (i != j - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private boolean hasRecipientsChanged()
  {
    boolean bool1;
    if (prefilledRecipients.size() != recipientsList.size())
    {
      bool1 = true;
      return bool1;
    }
    boolean bool2 = false;
    HashSet localHashSet = new HashSet(recipientsList);
    Iterator localIterator = prefilledRecipients.iterator();
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
    } while (localHashSet.contains((ViewModel)localIterator.next()));
    return true;
  }
  
  private boolean isSharingMode()
  {
    return updateUrnForPreview != null;
  }
  
  private void sendNewEventAndTracking(PendingEvent paramPendingEvent)
  {
    Object localObject1 = null;
    if ((invitationMessageId == null) && (StringUtils.isNotEmpty(newConversationName))) {
      new TrackingOnClickListener(getTracker(), "name_conversation_save", new TrackingEventBuilder[0]).onClick(null);
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((StringUtils.isNotEmpty(propActionEventParcel)) && (getMessengerLibApi() != null))
    {
      localObject2 = getMessengerLibApi();
      localObject3 = getTracker();
      localObject4 = new ComposeBundleBuilder();
      String str = propActionEventParcel;
      bundle.putString("PROP_PARCEL", str);
      ((MessengerLibApi)localObject2).trackPropActionEvent((Tracker)localObject3, ((ComposeBundleBuilder)localObject4).build());
      propActionEventParcel = null;
    }
    try
    {
      if (invitationMessageId == null)
      {
        localObject2 = ViewModelTransformer.flattenViewModelsByClass(recipientsList, GroupViewModel.class);
        if (((List)localObject2).isEmpty()) {
          new MessageSenderUtil(fragmentComponent).composeEvent(paramPendingEvent, updateUrnForPreview, groupUrn, ViewModelTransformer.flattenPeopleViewModels(recipientsList), new ComposeFragment.17(this, StringUtils.isNotEmpty(newConversationName)));
        }
        for (;;)
        {
          return;
          localObject2 = (Conversation)((List)localObject2).get(0);
          localObject3 = UrnUtil.getConversationRemoteIdFromConversationUrn(entityUrn);
          long l2 = MessageSenderUtil.getConversationId((String)localObject3, fragmentComponent.dataManager.conversationDataManager);
          l1 = l2;
          if (l2 == -1L) {
            l1 = fragmentComponent.dataManager.conversationDataManager.saveConversation((Conversation)localObject2);
          }
          if (PendingEvent.access$200(paramPendingEvent) != EventCreateType.STICKER) {
            break;
          }
          paramPendingEvent = PendingEvent.Factory.newStickerEvent(PendingEvent.access$1000(paramPendingEvent), l1, (String)localObject3, EventSubtype.MEMBER_TO_GROUP_MEMBER);
          MeFetcher.getMe(fragmentComponent, new ComposeFragment.15(this, (Conversation)localObject2, paramPendingEvent));
        }
      }
    }
    catch (BuilderException paramPendingEvent)
    {
      for (;;)
      {
        long l1;
        Log.e(TAG, "Unable to start the conversation: " + paramPendingEvent.getMessage());
        return;
        localObject4 = messageBody;
        if (messageAttachments == null) {}
        for (paramPendingEvent = (PendingEvent)localObject1;; paramPendingEvent = (File)messageAttachments.get(0))
        {
          paramPendingEvent = PendingEvent.Factory.newMessageEvent((String)localObject4, paramPendingEvent, l1, (String)localObject3, EventSubtype.MEMBER_TO_GROUP_MEMBER, null);
          break;
        }
        conversationRemoteId = invitationMessageId;
        MessageSenderUtil.sendInvitationReplyEvent(getMessengerLibApi(), paramPendingEvent, new ComposeFragment.16(this));
      }
    }
    catch (IOException paramPendingEvent)
    {
      for (;;) {}
    }
    finally
    {
      animateNamingConversationTextIfNecessary(false);
    }
  }
  
  private void sendNewMessageAndTracking(String paramString, List<File> paramList)
  {
    sendNewEventAndTracking(PendingEvent.Factory.newMessageEvent(getConversationNameFromTextbox(), paramString, paramList));
  }
  
  private void showSharePreview()
  {
    if (!isSharingMode()) {
      return;
    }
    composeMessageContainer.setVisibility(8);
    composeMessageContainer.getParent().requestLayout();
    messageFragmentContainer.setVisibility(0);
    messageListFragment = ((MessageListFragment)getChildFragmentManager().findFragmentByTag("composeMessageListFragmentTag"));
    if (messageListFragment == null)
    {
      MessageListBundleBuilder localMessageListBundleBuilder = new MessageListBundleBuilder();
      String str = updateUrnForPreview;
      bundle.putString("SHARE_UPDATE_URN", str);
      localMessageListBundleBuilder.setIsEmbeddedInCompose$1385ff();
      messageListFragment = new MessageListFragment();
      messageListFragment.setArguments(localMessageListBundleBuilder.build());
    }
    messageListFragment.onComposeMessageListener = new ComposeFragment.23(this);
    getChildFragmentManager().beginTransaction().replace(R.id.msglib_compose_message_fragment, messageListFragment, "composeMessageListFragmentTag").commit();
  }
  
  private void updateRecipientListOnUiThread(List<ViewModel> paramList)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.runOnUiThread(new ComposeFragment.22(this, paramList));
    }
  }
  
  public final boolean composeMessage(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (recipientsList.isEmpty())) {
      return false;
    }
    sendNewMessageAndTracking(paramString, null);
    return true;
  }
  
  protected final int getFragmentId()
  {
    return R.layout.msglib_fragment_compose;
  }
  
  protected final EditText getRecipientsView()
  {
    return recipientsView;
  }
  
  protected final ImageButton getStickerButton()
  {
    return stickerButton;
  }
  
  protected final boolean handleOnBackPressed()
  {
    if (messengerKeyboardFragment == null) {
      return false;
    }
    return messengerKeyboardFragment.onBackPressed();
  }
  
  protected final boolean hasRecipients()
  {
    return !recipientsList.isEmpty();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    Object localObject = null;
    super.onActivityCreated(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStringArray("RECIPIENT_MINI_PROFILE_URNS");
      if ((paramBundle != null) && (fetchProfilesListener != null)) {
        fetchProfilesListener.performFetchProfiles(paramBundle, new ComposeFragment.1(this));
      }
      Bundle localBundle = getArguments();
      paramBundle = (Bundle)localObject;
      if (localBundle != null) {
        paramBundle = localBundle.getString("RECIPIENT_MEMBER_ID");
      }
      if ((!TextUtils.isEmpty(paramBundle)) && (fetchProfilesListener != null)) {
        fetchProfilesListener.performFetchProfile(paramBundle, new ComposeFragment.2(this));
      }
      if (isComposeAssistEnabled) {
        fetchSuggestedConnections();
      }
      if (getActivity() != null) {
        if (!isComposeAssistEnabled) {
          break label191;
        }
      }
    }
    label191:
    for (peopleResultsListAdapter = new ComposeAssistListAdapter(getActivity(), fragmentComponent, new ComposeFragment.3(this, getTracker(), "select_participant"));; peopleResultsListAdapter = new PeopleResultsListAdapter(getActivity(), fragmentComponent, new ComposeFragment.4(this, getTracker(), "select_participant")))
    {
      recyclerView.setAdapter((RecyclerView.Adapter)peopleResultsListAdapter);
      getActivity().setResult(0);
      return;
      paramBundle = null;
      break;
    }
  }
  
  public final void onCameraButtonTapped()
  {
    getOnCameraClickListener().onCameraClick();
  }
  
  public final void onComposeTextChanged(Editable paramEditable)
  {
    if ((isComposeAssistEnabled) && (!TextUtils.isEmpty(paramEditable)) && (!recipientsList.isEmpty())) {
      recyclerView.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.onCreate(paramBundle);
    timer = new Timer();
    animationHandler = new Handler();
    if (paramBundle != null)
    {
      propId = paramBundle.getString("propIdExtraKey", null);
      propActionEventParcel = paramBundle.getString("PROP_PARCEL", null);
      groupUrn = paramBundle.getString("groupUrnExtraKey", null);
      invitationMessageId = paramBundle.getString("invitationMessageIdExtraKey", "");
      isRecipientsListLocked = paramBundle.getBoolean("lockRecipientsExtraKey", false);
    }
    onStickerActionListener = buildOnStickerActionListener();
    if ((getLixManager() != null) && (getLixManager().isKeyboardV2Enabled()))
    {
      bool1 = true;
      isKeyboardV2Enabled = bool1;
      if ((getLixManager() == null) || (!getLixManager().isGroupTypeaheadEnabled())) {
        break label215;
      }
      bool1 = true;
      label149:
      isGroupTypeaheadEnabled = bool1;
      if ((showInsightMessage) || (getLixManager() == null) || (!getLixManager().isComposeAssistLixEnabled())) {
        break label220;
      }
    }
    label215:
    label220:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      isComposeAssistEnabled = bool1;
      prefilledRecipients = ViewModelTransformer.fromProfileStringToDelegates(prefiledRecipientsArray, fragmentComponent.i18NManager, isComposeAssistEnabled);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label149;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (paramLayoutInflater != null)
    {
      recipientsView = ((PeopleSearchCompletionView)paramLayoutInflater.findViewById(R.id.msglib_recipient_input));
      recipientsViewDivider = paramLayoutInflater.findViewById(R.id.msglib_recipient_input_divider);
      recyclerView = ((MessengerRecyclerView)paramLayoutInflater.findViewById(R.id.msglib_compose_search_results));
      composeMessageContainer = ((ViewGroup)paramLayoutInflater.findViewById(R.id.msglib_message_list_keyboard_container));
      contentContainer = ((ViewGroup)paramLayoutInflater.findViewById(R.id.msglib_compose_message_content_area));
      messageFragmentContainer = ((ViewGroup)paramLayoutInflater.findViewById(R.id.msglib_compose_message_fragment));
      oldKeyboard = ((ViewGroup)paramLayoutInflater.findViewById(R.id.message_keyboard_old));
      insightMessageContainer = ((ViewGroup)paramLayoutInflater.findViewById(R.id.msglib_reconnect_insights_container));
      if (isSharingMode()) {
        showSharePreview();
      }
      for (;;)
      {
        recipientsView.setEditTextHost(new ComposeFragment.7(this));
        recipientsView.setAdapter(new ArrayAdapter(getActivity(), 0));
        recipientsView.setTokenClickStyle(TokenCompleteTextView.TokenClickStyle.Delete);
        recipientsView.setDeletionStyle(TokenCompleteTextView.TokenDeleteStyle.ToString);
        recipientsView.setTokenListener(new ComposeFragment.8(this));
        recipientsView.setOnFocusChangeListener(new ComposeFragment.9(this));
        paramViewGroup = prefilledRecipients.iterator();
        while (paramViewGroup.hasNext())
        {
          paramBundle = (ViewModel)paramViewGroup.next();
          recipientsView.addObject(paramBundle);
        }
        if (isKeyboardV2Enabled)
        {
          messengerKeyboardFragment = ((MessengerKeyboardFragment)getChildFragmentManager().findFragmentByTag("keyboardFragmentV2"));
          if (messengerKeyboardFragment == null)
          {
            paramViewGroup = new MessengerKeyboardBundleBuilder();
            paramViewGroup.setIsSharing(isSharingMode());
            if (StringUtils.isNotEmpty(prefilledBody))
            {
              paramBundle = prefilledBody;
              bundle.putString("MESSENGER_KEYBOARD_PRE_FILLED_TEXT", paramBundle);
            }
            if (!prefilledRecipients.isEmpty()) {
              paramViewGroup.setComposeTextFocus(true);
            }
            messengerKeyboardFragment = MessengerKeyboardFragment.newInstance(paramViewGroup.build());
            getChildFragmentManager().beginTransaction().replace(R.id.message_keyboard, messengerKeyboardFragment, "keyboardFragmentV2").commit();
          }
          messageFragmentContainer.setVisibility(0);
          oldKeyboard.setVisibility(8);
          messengerKeyboardFragment.setRecipients(recipientsList);
        }
        else
        {
          stickerKeyboard = ((StickerTrayView)paramLayoutInflater.findViewById(R.id.message_sticker_keyboard));
          stickerButton = ((ImageButton)paramLayoutInflater.findViewById(R.id.message_sticker_icon));
          sendButton = ((ImageButton)paramLayoutInflater.findViewById(R.id.message_send));
          cameraButton = ((ImageButton)paramLayoutInflater.findViewById(R.id.message_camera_button));
          composeText = ((EditText)paramLayoutInflater.findViewById(R.id.message_input));
          MessengerDrawableResources.setImageResource(fragmentComponent.drawableResources(), cameraButton, 5);
          messageFragmentContainer.setVisibility(8);
          oldKeyboard.setVisibility(0);
          if (paramBundle != null) {
            composeText.setText(paramBundle.getString("composeTextExtraKey", ""));
          }
          if (prefilledBody != null) {
            composeText.setText(prefilledBody);
          }
          if (hint != null) {
            composeText.setHint(hint);
          }
          if (!prefilledRecipients.isEmpty()) {
            composeText.requestFocus();
          }
          boolean bool = hasRecipients();
          ComposeButtonsVisibility.updateVisibility(getActivity(), composeText, sendButton, stickerButton, cameraButton, bool, isSharingMode(), isStickerKeyboardShown());
          setupStickerKeyboard(paramLayoutInflater, stickerKeyboard, composeText);
          updateStickerKeyboardRecipients(bool);
          composeTextWatcher = new ComposeFragment.12(this);
          composeText.addTextChangedListener(composeTextWatcher);
          composeText.setOnFocusChangeListener(new ComposeFragment.13(this));
          sendButton.setOnClickListener(new ComposeFragment.14(this, getTracker(), "send", new TrackingEventBuilder[0]));
          stickerButton.setOnClickListener(newOnStickerButtonClickListener());
          cameraButton.setOnClickListener(newCameraButtonOnClickListener());
        }
      }
      if ((!isRecipientsListLocked) && (invitationMessageId == null)) {
        break label878;
      }
    }
    label878:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        recipientsView.setOnTouchListener(new ComposeFragment.10(this));
      }
      recipientsViewTextWatcher = new ComposeFragment.11(this);
      recipientsView.addTextChangedListener(recipientsViewTextWatcher);
      if ((getLixManager() != null) && (getLixManager().isNamingGroupConversationEnabled())) {
        break;
      }
      if ((!isSharingMode()) && (showInsightMessage))
      {
        insightMessageContainer.setVisibility(0);
        paramViewGroup = (ImageView)paramLayoutInflater.findViewById(R.id.insight_icon);
        paramViewGroup.setColorFilter(getResources().getColor(R.color.ad_black_55), PorterDuff.Mode.SRC_IN);
        MessengerDrawableResources.setImageResource(getDrawableResources(), paramViewGroup, 10);
      }
      return paramLayoutInflater;
    }
    namingConversationText = ((ClearableEditText)paramLayoutInflater.findViewById(R.id.msglib_compose_naming_conversation));
    namingConversationText.onBind(fragmentComponent, getTracker(), "name_conversation_clear");
    namingConversationText.setOnClickListener(new ComposeFragment.5(this));
    namingConversationText.setOnKeyListener(new ComposeFragment.6(this));
    if ((getActivity() instanceof AppCompatActivity))
    {
      paramViewGroup = ((AppCompatActivity)getActivity()).getSupportActionBar();
      if ((paramViewGroup == null) || (Build.VERSION.SDK_INT < 21)) {}
    }
    for (float f = paramViewGroup.getElevation();; f = 0.0F)
    {
      actionBarElevation = f;
      animateNamingConversationTextIfNecessary(false);
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    timer.cancel();
    timer = null;
    animationHandler.removeCallbacksAndMessages(null);
    animationHandler = null;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    recipientsView.removeTextChangedListener(recipientsViewTextWatcher);
    recipientsView.setTokenListener(null);
    if ((!isKeyboardV2Enabled) && (!isSharingMode())) {
      composeText.removeTextChangedListener(composeTextWatcher);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (composeText != null) {
      paramBundle.putString("composeTextExtraKey", composeText.getText().toString());
    }
    if (propId != null) {
      paramBundle.putString("propIdExtraKey", propId);
    }
    if (propActionEventParcel != null) {
      paramBundle.putString("PROP_PARCEL", propActionEventParcel);
    }
    if (groupUrn != null) {
      paramBundle.putString("groupUrnExtraKey", groupUrn);
    }
    if (invitationMessageId != null) {
      paramBundle.putString("invitationMessageIdExtraKey", invitationMessageId);
    }
    if (isRecipientsListLocked) {
      paramBundle.putBoolean("lockRecipientsExtraKey", true);
    }
    super.onSaveInstanceState(paramBundle);
  }
  
  protected final void onSendAttachmentApproved(File paramFile, PendingAttachment paramPendingAttachment)
  {
    if (uploadState == AttachmentUploadState.UPLOADED)
    {
      paramPendingAttachment = new ArrayList();
      paramPendingAttachment.add(paramFile);
      sendNewMessageAndTracking("", paramPendingAttachment);
      return;
    }
    paramFile = AttachmentUploadState.FAILED;
  }
  
  protected final void onSendStickerApproved(LocalSticker paramLocalSticker)
  {
    sendNewEventAndTracking(PendingEvent.Factory.newStickerEvent(getConversationNameFromTextbox(), paramLocalSticker));
  }
  
  public final void onStickerPreview(LocalSticker paramLocalSticker)
  {
    onStickerActionListener.onStickerView(paramLocalSticker);
  }
  
  public final void onStickerSend(LocalSticker paramLocalSticker)
  {
    onStickerActionListener.onStickerSend(paramLocalSticker);
  }
  
  public final void onStickerView(LocalSticker paramLocalSticker)
  {
    onStickerActionListener.onStickerView(paramLocalSticker);
  }
  
  protected final void onUploadAttachmentFailure(File paramFile, boolean paramBoolean) {}
  
  protected final void onUploadAttachmentSuccess(File paramFile, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramFile);
      sendNewMessageAndTracking("", localArrayList);
    }
  }
  
  protected final void refreshStickersFromCursor()
  {
    if (messengerKeyboardFragment == null) {
      return;
    }
    messengerKeyboardFragment.refreshStickerPacksFromCursor();
  }
  
  public void setArguments(Bundle paramBundle)
  {
    boolean bool2 = true;
    Object localObject2 = null;
    super.setArguments(paramBundle);
    int i;
    Object localObject1;
    if ((paramBundle != null) && (paramBundle.containsKey("BODY")))
    {
      i = 1;
      if (i != 0)
      {
        if (paramBundle == null) {
          break label257;
        }
        localObject1 = paramBundle.getString("BODY");
        label44:
        prefilledBody = ((String)localObject1);
      }
      if (paramBundle == null) {
        break label263;
      }
      localObject1 = paramBundle.getString("HINT");
      label63:
      hint = ((String)localObject1);
      if (paramBundle == null) {
        break label269;
      }
      localObject1 = paramBundle.getString("PROP_ID");
      label82:
      propId = ((String)localObject1);
      if (paramBundle == null) {
        break label275;
      }
      localObject1 = paramBundle.getString("PROP_PARCEL");
      label101:
      propActionEventParcel = ((String)localObject1);
      if (paramBundle == null) {
        break label281;
      }
      localObject1 = paramBundle.getString("GROUP_URN");
      label120:
      groupUrn = ((String)localObject1);
      if (paramBundle == null) {
        break label287;
      }
      localObject1 = paramBundle.getString("INVITATION_MESSAGE_ID");
      label139:
      invitationMessageId = ((String)localObject1);
      if (paramBundle == null) {
        break label293;
      }
      localObject1 = paramBundle.getStringArrayList("RECIPIENT_PROFILES");
      label158:
      prefiledRecipientsArray = ((List)localObject1);
      localObject1 = localObject2;
      if (paramBundle != null) {
        localObject1 = paramBundle.getString("UPDATE_URN");
      }
      updateUrnForPreview = ((String)localObject1);
      if ((paramBundle == null) || (!paramBundle.getBoolean("LOCK_RECIPIENTS"))) {
        break label299;
      }
      bool1 = true;
      label203:
      isRecipientsListLocked = bool1;
      if ((paramBundle == null) || (!paramBundle.getBoolean("SHOULD_FINISH_ACTIVITY_AFTER_SEND"))) {
        break label304;
      }
      bool1 = true;
      label224:
      shouldFinishActivityAfterSend = bool1;
      if ((paramBundle == null) || (!paramBundle.getBoolean("SHOULD_SHOW_INSIGHT_MESSAGE"))) {
        break label309;
      }
    }
    label257:
    label263:
    label269:
    label275:
    label281:
    label287:
    label293:
    label299:
    label304:
    label309:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      showInsightMessage = bool1;
      return;
      i = 0;
      break;
      localObject1 = null;
      break label44;
      localObject1 = null;
      break label63;
      localObject1 = null;
      break label82;
      localObject1 = null;
      break label101;
      localObject1 = null;
      break label120;
      localObject1 = null;
      break label139;
      localObject1 = null;
      break label158;
      bool1 = false;
      break label203;
      bool1 = false;
      break label224;
    }
  }
  
  public final boolean shouldShowDeleteWarningOnBack()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (messengerKeyboardFragment != null)
    {
      MessengerKeyboardFragment localMessengerKeyboardFragment = messengerKeyboardFragment;
      if ((!isKeyboardContentAreaShowing) && (!softKeyboardStateListener.isSoftKeyboardOpened)) {
        break label83;
      }
    }
    label83:
    for (int i = 1;; i = 0)
    {
      bool1 = bool3;
      if (i != 0) {
        break label96;
      }
      if (messageListFragment == null) {
        break label98;
      }
      if (!isSharingMode()) {
        break;
      }
      if (!messageListFragment.shouldShowDeleteWarningOnBack())
      {
        bool1 = bool2;
        if (!hasRecipientsChanged()) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    boolean bool1 = messageListFragment.shouldShowDeleteWarningOnBack();
    label96:
    return bool1;
    label98:
    if (isKeyboardV2Enabled) {
      if (!TextUtils.equals(prefilledBody, messengerKeyboardFragment.getComposeText())) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        bool1 = bool3;
        if (!hasRecipientsChanged()) {
          break;
        }
      }
      return true;
      i = 0;
      continue;
      if (!TextUtils.equals(prefilledBody, composeText.getText())) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  protected final boolean shouldShowPendingMessagesWarningOnBack()
  {
    return false;
  }
  
  public final boolean supportsMessageQueue()
  {
    return false;
  }
  
  protected final void trackAttachAction(String paramString) {}
  
  protected final void trackStickerAction(LocalSticker paramLocalSticker) {}
  
  protected final void trackStickerImpression(LocalSticker paramLocalSticker) {}
  
  public static abstract interface ComposeProgressListener
  {
    public abstract void onComposeFinished();
    
    public abstract void onComposeProgress(int paramInt);
  }
  
  public static abstract interface TitleChangeListener
  {
    public abstract void onTitleChange(String paramString);
    
    public abstract void onTitleChangeDefault();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.compose.ComposeFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */