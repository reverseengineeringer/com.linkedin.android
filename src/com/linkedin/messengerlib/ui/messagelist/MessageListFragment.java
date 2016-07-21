package com.linkedin.messengerlib.ui.messagelist;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.File;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation;
import com.linkedin.android.spyglass.mentions.Mentionable;
import com.linkedin.android.spyglass.suggestions.interfaces.SuggestionsVisibilityManager;
import com.linkedin.android.spyglass.tokenization.impl.WordTokenizer;
import com.linkedin.android.spyglass.ui.MentionsEditText;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.messengerlib.MessengerDrawableResources;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.MessengerLixManager;
import com.linkedin.messengerlib.R.id;
import com.linkedin.messengerlib.R.layout;
import com.linkedin.messengerlib.R.string;
import com.linkedin.messengerlib.attachment.PendingAttachment;
import com.linkedin.messengerlib.consumers.ConversationDataManager;
import com.linkedin.messengerlib.consumers.DataManager;
import com.linkedin.messengerlib.consumers.EventsDataManager;
import com.linkedin.messengerlib.consumers.EventsDataManager.EventCursor;
import com.linkedin.messengerlib.consumers.StickersDataManager;
import com.linkedin.messengerlib.database.DatabaseExecutor;
import com.linkedin.messengerlib.database.MessengerProvider;
import com.linkedin.messengerlib.downloads.EventAttachmentMap;
import com.linkedin.messengerlib.downloads.EventAttachmentMap.Event;
import com.linkedin.messengerlib.downloads.MessengerDownloads;
import com.linkedin.messengerlib.event.PendingEvent;
import com.linkedin.messengerlib.event.PendingEvent.Factory;
import com.linkedin.messengerlib.me.MeFetcher;
import com.linkedin.messengerlib.queue.EventQueueWorker;
import com.linkedin.messengerlib.queue.EventQueueWorker.EventQueueWorkerDelegate;
import com.linkedin.messengerlib.shared.BaseFragment;
import com.linkedin.messengerlib.shared.FragmentComponent;
import com.linkedin.messengerlib.shared.MessengerLoadMoreRecyclerAdapter;
import com.linkedin.messengerlib.shared.MessengerRecyclerView;
import com.linkedin.messengerlib.shared.MessengerRecyclerView.MessengerRecyclerViewEvents;
import com.linkedin.messengerlib.sticker.LocalSticker;
import com.linkedin.messengerlib.tracking.ImpressionUtil;
import com.linkedin.messengerlib.tracking.TrackingAdapterDelegate;
import com.linkedin.messengerlib.ui.Mentions.MentionsPresenter;
import com.linkedin.messengerlib.ui.Mentions.MentionsPresenter.MentionInterface;
import com.linkedin.messengerlib.ui.common.KeyboardAwareEditText;
import com.linkedin.messengerlib.ui.compose.MessageCreateFragment;
import com.linkedin.messengerlib.ui.compose.MessageCreateFragment.OnCameraClickListener;
import com.linkedin.messengerlib.ui.compose.MessengerKeyboardBundleBuilder;
import com.linkedin.messengerlib.ui.compose.MessengerKeyboardFragment;
import com.linkedin.messengerlib.ui.compose.MessengerKeyboardFragment.MessengerKeyboardHost;
import com.linkedin.messengerlib.ui.dialogs.EventLongPressDialogFragment;
import com.linkedin.messengerlib.ui.receiver.NetworkChangeReceiver;
import com.linkedin.messengerlib.utils.ComposeButtonsVisibility;
import com.linkedin.messengerlib.utils.ConversationUtil;
import com.linkedin.messengerlib.utils.EasterEggShip;
import com.linkedin.messengerlib.utils.EasterEggShip.1;
import com.linkedin.messengerlib.utils.I18NManager;
import com.linkedin.messengerlib.utils.MessageSenderUtil;
import com.linkedin.messengerlib.utils.NetworkStatusUtil;
import com.linkedin.messengerlib.utils.UrnUtil;
import com.linkedin.messengerlib.viewmodel.ViewModelTransformer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MessageListFragment
  extends MessageListBaseFragment
  implements SuggestionsVisibilityManager, MessengerRecyclerView.MessengerRecyclerViewEvents, TrackingAdapterDelegate, MentionsPresenter.MentionInterface, MessengerKeyboardFragment.MessengerKeyboardHost, InvitationActionListener, MessageListAdapter.ApiForwarder
{
  private static final String TAG = MessageListFragment.class.getCanonicalName();
  private final ArrayMap<Long, Runnable> actorIdToTimeoutTaskMap = new ArrayMap();
  private ImageButton cameraButton;
  private View composeMessageContainer;
  private ViewGroup containerView;
  private ContentObserver contentObserver;
  public long conversationId = -1L;
  public String conversationRemoteId;
  private TextView errorMessageView;
  public final EventQueueWorker eventQueueWorker = new EventQueueWorker();
  private View forwardActionContainer;
  private TextView forwardCancelAction;
  private TextView forwardOkAction;
  private View inMailResponseContainer;
  private TextView inmailWarningText;
  private InvitationItemPresenter invitationPresenter;
  private boolean isEmbeddedInComposer;
  private boolean isKeyboardV2Enabled;
  private boolean isLoading;
  private final Handler mainLooperHandler = new Handler();
  private MentionsPresenter mentionsPresenter;
  private MessengerRecyclerView mentionsRecyclerView;
  public MentionsEditText messageInput;
  private View messageInputSpacer;
  private MessengerRecyclerView messageList;
  private MessageListAdapter messageListAdapter;
  private ViewGroup messageListContainer;
  private ImageButton messageSendButton;
  private MessengerKeyboardFragment messengerKeyboardFragment;
  private MessageListModeManager modeManager;
  private NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
  public MessageListFragment.NetworkRefreshListener networkRefreshListener;
  private ViewGroup oldKeyboard;
  public MessageListFragment.OnComposeMessageListener onComposeMessageListener;
  private StickerTrayFragment.OnStickerActionListener onStickerActionListener;
  private PendingEvent pendingEvent;
  private String pendingEventLongPressRemoteId;
  private Invitation pendingInvitation;
  private boolean queueMarkAsReadOnResume;
  private final BroadcastReceiver receivedTypingIndicatorBroadcastReceiver = new MessageListFragment.3(this);
  private List<MiniProfile> recipients = Collections.emptyList();
  private TextView replyButton;
  private final BroadcastReceiver sendTypingIndicatorBroadcastReceiver = new MessageListFragment.2(this);
  private UpdateShareView sharePreview;
  private String shareUpdateUrn;
  private boolean shouldShowPendingInvitation = true;
  private ImageButton stickerButton;
  private StickerTrayView stickerKeyboard;
  private final BroadcastReceiver syncBroadcastReceiver = new MessageListFragment.1(this);
  private TextView useQuickReplyButton;
  
  private void clearMessageInputText()
  {
    if (isKeyboardV2Enabled)
    {
      messengerKeyboardFragment.setComposeText("");
      return;
    }
    messageInput.getText().clear();
  }
  
  private void failEvent()
  {
    MessageSenderUtil.setEventStatusFailed(fragmentComponent, pendingEvent.eventId);
    pendingAttachment.clear();
  }
  
  private String getDraftFromDiskIfExists()
  {
    return getActivity().getPreferences(0).getString("MESSENGER_DRAFT_" + conversationRemoteId, "");
  }
  
  private boolean isSharing()
  {
    return !TextUtils.isEmpty(shareUpdateUrn);
  }
  
  private void markConversationAsRead()
  {
    if (getMessengerLibApi() == null) {
      return;
    }
    getMessengerLibApi().setConversationReadState(conversationRemoteId, true, new MessageListFragment.16(this));
  }
  
  private void refreshMessagesFromCursor()
  {
    if (getMessengerLibApi() == null) {
      return;
    }
    MeFetcher.getMe(fragmentComponent, new MessageListFragment.11(this));
  }
  
  private void refreshMessagesFromNetwork(String paramString1, String paramString2)
  {
    if ((getMessengerLibApi() == null) || (getActivity() == null) || (isLoading)) {
      return;
    }
    messageListAdapter.showLoading();
    if (!isEmbeddedInComposer) {
      getMessengerLibApi().getConversationById(conversationRemoteId, new MessageListFragment.28(this, getRumSessionId()));
    }
    isLoading = true;
    getMessengerLibApi().getMessageList(conversationRemoteId, paramString1, paramString2, new MessageListFragment.13(this, getRumSessionId()));
  }
  
  private void refreshMessagesFromNetworkAsync$16da05f7(String paramString)
  {
    if (NetworkStatusUtil.isNetworkConnected(getContext()))
    {
      refreshMessagesFromNetwork(paramString, null);
      return;
    }
    messageListAdapter.hideLoading();
    Snackbar localSnackbar = Snackbar.make(containerView, R.string.messenger_message_list_network_error, -2);
    localSnackbar.show();
    NetworkChangeReceiver localNetworkChangeReceiver = networkChangeReceiver;
    paramString = new MessageListFragment.12(this, paramString, localSnackbar);
    onNetworkChangedListeners.add(paramString);
  }
  
  private void saveDraftToDisk(String paramString)
  {
    getActivity().getPreferences(0).edit().putString("MESSENGER_DRAFT_" + conversationRemoteId, paramString).commit();
  }
  
  private void saveEvent(PendingEvent paramPendingEvent, PendingAttachment paramPendingAttachment)
  {
    if ((isSharing()) && (onComposeMessageListener != null))
    {
      onComposeMessageListener.composeMessage(messageBody);
      return;
    }
    if (supportsMessageQueue())
    {
      eventQueueWorker.enqueue(paramPendingEvent, paramPendingAttachment);
      return;
    }
    MeFetcher.getMe(fragmentComponent, new MessageListFragment.15(this, paramPendingEvent, paramPendingAttachment));
  }
  
  private void saveMessageEvent(String paramString, File paramFile, PendingAttachment paramPendingAttachment)
  {
    saveEvent(PendingEvent.Factory.newMessageEvent(paramString, paramFile, conversationId, conversationRemoteId, modeManager.getOutgoingMessageSubtype(), modeManager.inmailResponse), paramPendingAttachment);
  }
  
  /* Error */
  private void sendEvent()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 657	com/linkedin/messengerlib/ui/messagelist/MessageListFragment:pendingEvent	Lcom/linkedin/messengerlib/event/PendingEvent;
    //   4: ifnull +22 -> 26
    //   7: aload_0
    //   8: getfield 385	com/linkedin/messengerlib/shared/BaseFragment:fragmentComponent	Lcom/linkedin/messengerlib/shared/FragmentComponent;
    //   11: aload_0
    //   12: getfield 657	com/linkedin/messengerlib/ui/messagelist/MessageListFragment:pendingEvent	Lcom/linkedin/messengerlib/event/PendingEvent;
    //   15: aconst_null
    //   16: invokestatic 1153	com/linkedin/messengerlib/utils/MessageSenderUtil:sendEventAndTrack	(Lcom/linkedin/messengerlib/shared/FragmentComponent;Lcom/linkedin/messengerlib/event/PendingEvent;Lcom/linkedin/messengerlib/utils/MessageSenderUtil$MessageSendCompleteCallback;)V
    //   19: aload_0
    //   20: getfield 250	com/linkedin/messengerlib/ui/compose/MessageCreateFragment:pendingAttachment	Lcom/linkedin/messengerlib/attachment/PendingAttachment;
    //   23: invokevirtual 255	com/linkedin/messengerlib/attachment/PendingAttachment:clear	()V
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 657	com/linkedin/messengerlib/ui/messagelist/MessageListFragment:pendingEvent	Lcom/linkedin/messengerlib/event/PendingEvent;
    //   31: return
    //   32: astore_1
    //   33: getstatic 112	com/linkedin/messengerlib/ui/messagelist/MessageListFragment:TAG	Ljava/lang/String;
    //   36: new 1003	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 1155
    //   43: invokespecial 1007	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload_1
    //   47: invokevirtual 1160	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   50: invokevirtual 1011	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 1012	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 1166	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   59: pop
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 657	com/linkedin/messengerlib/ui/messagelist/MessageListFragment:pendingEvent	Lcom/linkedin/messengerlib/event/PendingEvent;
    //   65: return
    //   66: astore_1
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 657	com/linkedin/messengerlib/ui/messagelist/MessageListFragment:pendingEvent	Lcom/linkedin/messengerlib/event/PendingEvent;
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: goto -42 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	MessageListFragment
    //   32	15	1	localBuilderException	com.linkedin.data.lite.BuilderException
    //   66	7	1	localObject	Object
    //   74	1	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   0	26	32	com/linkedin/data/lite/BuilderException
    //   0	26	66	finally
    //   33	60	66	finally
    //   0	26	74	java/io/IOException
  }
  
  private void setMessageInputText(String paramString)
  {
    if (isKeyboardV2Enabled)
    {
      messengerKeyboardFragment.setComposeText(paramString);
      return;
    }
    messageInput.setText(paramString);
  }
  
  private void updateReplyActionVisibility()
  {
    Object localObject;
    switch (MessageListFragment.29.$SwitchMap$com$linkedin$messengerlib$ui$messagelist$MessageListModeManager$Mode[modeManager.mode.ordinal()])
    {
    default: 
      composeMessageContainer.setVisibility(0);
      inMailResponseContainer.setVisibility(8);
      inmailWarningText.setVisibility(8);
      forwardActionContainer.setVisibility(8);
      messageListAdapter.disableForwardingMode();
    case 1: 
      do
      {
        do
        {
          return;
          composeMessageContainer.setVisibility(8);
          inMailResponseContainer.setVisibility(0);
          inmailWarningText.setVisibility(8);
          forwardActionContainer.setVisibility(8);
          messageListAdapter.disableForwardingMode();
        } while ((!isKeyboardV2Enabled) || (messengerKeyboardFragment == null));
        localObject = messengerKeyboardFragment;
        hideInsightsButton = true;
      } while (insightsButton == null);
      insightsButton.setVisibility(8);
      return;
    case 2: 
      composeMessageContainer.setVisibility(8);
      inMailResponseContainer.setVisibility(8);
      inmailWarningText.setVisibility(0);
      forwardActionContainer.setVisibility(8);
      messageListAdapter.disableForwardingMode();
      inmailWarningText.setText(fragmentComponent.i18NManager.getString(R.string.inmail_no_reply_warning));
      return;
    case 3: 
      composeMessageContainer.setVisibility(8);
      inMailResponseContainer.setVisibility(8);
      inmailWarningText.setVisibility(8);
      forwardActionContainer.setVisibility(0);
      localObject = messageListAdapter;
      isForwarding = true;
      ((MessageListAdapter)localObject).notifyDataSetChanged();
      return;
    case 4: 
      composeMessageContainer.setVisibility(8);
      inMailResponseContainer.setVisibility(8);
      inmailWarningText.setVisibility(0);
      forwardActionContainer.setVisibility(8);
      messageListAdapter.disableForwardingMode();
      inmailWarningText.setText(fragmentComponent.i18NManager.getString(R.string.inmail_declined_warning));
      return;
    }
    composeMessageContainer.setVisibility(8);
    inMailResponseContainer.setVisibility(8);
    inmailWarningText.setVisibility(8);
    forwardActionContainer.setVisibility(8);
    messageListAdapter.disableForwardingMode();
  }
  
  public final boolean composeMessage(String paramString)
  {
    if (isSharing())
    {
      if (isKeyboardV2Enabled) {
        messengerKeyboardFragment.disableSendButton();
      }
    }
    else
    {
      clearMessageInputText();
      getActivity().getPreferences(0).edit().remove("MESSENGER_DRAFT_" + conversationRemoteId).commit();
      if ((paramString.isEmpty()) && (!isSharing())) {
        break label231;
      }
      if ((getLixManager() == null) || (!getLixManager().isEasterEggEnabled()) || (!paramString.equals("/voyager"))) {
        break label210;
      }
      paramString = new EasterEggShip(getActivity(), (LinearLayoutManager)messageList.getLayoutManager(), composeMessageContainer);
      replyContainer.setVisibility(4);
      if (activity != null) {
        ((InputMethodManager)activity.getSystemService("input_method")).hideSoftInputFromWindow(replyContainer.getWindowToken(), 0);
      }
      handler.postDelayed(new EasterEggShip.1(paramString), 500L);
    }
    for (;;)
    {
      return true;
      messageSendButton.setEnabled(false);
      break;
      label210:
      saveMessageEvent(paramString, null, null);
      messageList.getLayoutManager().scrollToPosition(0);
    }
    label231:
    return false;
  }
  
  public final void displaySuggestions(boolean paramBoolean)
  {
    MessengerRecyclerView localMessengerRecyclerView = mentionsRecyclerView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localMessengerRecyclerView.setVisibility(i);
      return;
    }
  }
  
  protected final int getFragmentId()
  {
    return R.layout.msglib_fragment_message_list;
  }
  
  public final Tracker getFragmentTracker()
  {
    return getTracker();
  }
  
  protected final EditText getRecipientsView()
  {
    return null;
  }
  
  protected final ImageButton getStickerButton()
  {
    return stickerButton;
  }
  
  protected final boolean handleOnBackPressed()
  {
    displaySuggestions(false);
    if (messengerKeyboardFragment == null) {
      return false;
    }
    return messengerKeyboardFragment.onBackPressed();
  }
  
  protected final boolean hasRecipients()
  {
    return (conversationRemoteId != null) || (!recipients.isEmpty());
  }
  
  public final boolean isDisplayingSuggestions()
  {
    return mentionsRecyclerView.getVisibility() == 0;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (conversationRemoteId != null) {
      DatabaseExecutor.getInstance().execute(new MessageListFragment.7(this));
    }
    if (contentObserver == null) {
      contentObserver = new MessageListFragment.8(this, mainLooperHandler);
    }
    paramActivity.getContentResolver().registerContentObserver(MessengerProvider.EVENTS_VIEW_URI, false, contentObserver);
    Object localObject1 = new IntentFilter("com.linkedin.messengerlib.SYNC_INTENT");
    ((IntentFilter)localObject1).setPriority(1000);
    paramActivity.registerReceiver(syncBroadcastReceiver, (IntentFilter)localObject1);
    localObject1 = networkChangeReceiver;
    Object localObject2 = getActivity();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    ((Context)localObject2).registerReceiver((BroadcastReceiver)localObject1, localIntentFilter);
    localObject1 = eventQueueWorker;
    localObject2 = new MessageListFragment.9(this);
    activity = paramActivity;
    delegate = ((EventQueueWorker.EventQueueWorkerDelegate)localObject2);
  }
  
  public final void onCameraButtonTapped()
  {
    getOnCameraClickListener().onCameraClick();
  }
  
  public final void onComposeTextChanged(Editable paramEditable) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    onStickerActionListener = buildOnStickerActionListener();
    isKeyboardV2Enabled = getLixManager().isKeyboardV2Enabled();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    containerView = ((ViewGroup)paramViewGroup.findViewById(R.id.msglib_compose_fragment_container));
    errorMessageView = ((TextView)paramViewGroup.findViewById(R.id.message_list_error));
    messageListContainer = ((ViewGroup)paramViewGroup.findViewById(R.id.message_list_container));
    inmailWarningText = ((TextView)paramViewGroup.findViewById(R.id.inmail_warning_text));
    oldKeyboard = ((ViewGroup)paramViewGroup.findViewById(R.id.message_keyboard_old));
    messageList = ((MessengerRecyclerView)paramViewGroup.findViewById(R.id.message_list));
    mentionsRecyclerView = ((MessengerRecyclerView)paramViewGroup.findViewById(R.id.mentions_list));
    composeMessageContainer = paramViewGroup.findViewById(R.id.msglib_message_list_keyboard_container);
    sharePreview = ((UpdateShareView)paramViewGroup.findViewById(R.id.share_preview));
    inMailResponseContainer = paramViewGroup.findViewById(R.id.inmail_response_container);
    replyButton = ((TextView)paramViewGroup.findViewById(R.id.inmail_reply));
    useQuickReplyButton = ((TextView)paramViewGroup.findViewById(R.id.inmail_quick_reply));
    forwardActionContainer = paramViewGroup.findViewById(R.id.message_list_forward_reply_container);
    forwardOkAction = ((TextView)paramViewGroup.findViewById(R.id.message_list_forward_ok_action));
    forwardCancelAction = ((TextView)paramViewGroup.findViewById(R.id.message_list_forward_cancel_action));
    messageListAdapter = new MessageListAdapter(fragmentComponent, this, fileTransferManager, this, conversationId, conversationRemoteId);
    messageListAdapter.onNotifyItemInsertedListener = new MessageListFragment.4(this);
    if ((getLixManager() != null) && (getLixManager().isFastListAnimationEnabled()))
    {
      paramLayoutInflater = new DefaultItemAnimator();
      mAddDuration = 60L;
      mRemoveDuration = 60L;
      mMoveDuration = 125L;
      mChangeDuration = 125L;
      messageList.setItemAnimator(paramLayoutInflater);
    }
    ((LinearLayoutManager)messageList.getLayoutManager()).setReverseLayout(true);
    messageList.setEventDelegate(this);
    messageList.setAdapter(messageListAdapter);
    if (paramBundle != null)
    {
      paramLayoutInflater = paramBundle.getString("messageInputExtraKey", "");
      conversationId = paramBundle.getLong("conversationIdExtraKey");
      conversationRemoteId = paramBundle.getString("conversationRemoteIdExtraKey", "");
      shareUpdateUrn = paramBundle.getString("shareUpdateUrnExtraKey", "");
      shouldShowPendingInvitation = paramBundle.getBoolean("shouldShowPendingInvitation");
      if (!isKeyboardV2Enabled) {
        break label897;
      }
      messengerKeyboardFragment = ((MessengerKeyboardFragment)getChildFragmentManager().findFragmentByTag("MessageListKeyboardFragmentV2"));
      if (messengerKeyboardFragment == null)
      {
        paramBundle = new MessengerKeyboardBundleBuilder();
        paramBundle.setIsSharing(isSharing());
        paramBundle.setComposeTextFocus(isEmbeddedInComposer);
        messengerKeyboardFragment = MessengerKeyboardFragment.newInstance(paramBundle.build());
        getChildFragmentManager().beginTransaction().replace(R.id.message_keyboard, messengerKeyboardFragment, "MessageListKeyboardFragmentV2").commit();
      }
      messengerKeyboardFragment.setRecipients(ViewModelTransformer.fromMiniProfileToViewModels$18a2b177(recipients, fragmentComponent.i18NManager));
      oldKeyboard.setVisibility(8);
      label534:
      setMessageInputText(paramLayoutInflater);
      if (!isKeyboardV2Enabled) {
        if (!isSharing()) {
          break label1004;
        }
      }
    }
    label897:
    label1004:
    for (paramLayoutInflater = "send_message";; paramLayoutInflater = "send")
    {
      messageSendButton.setOnClickListener(new MessageListFragment.17(this, getTracker(), paramLayoutInflater, new TrackingEventBuilder[0]));
      cameraButton.setOnClickListener(newCameraButtonOnClickListener());
      forwardOkAction.setOnClickListener(new MessageListFragment.18(this));
      forwardCancelAction.setOnClickListener(new MessageListFragment.19(this));
      messageInput.addTextChangedListener(new MessageListFragment.20(this));
      messageInput.setOnFocusChangeListener(new MessageListFragment.21(this));
      stickerButton.setOnClickListener(newOnStickerButtonClickListener());
      setupStickerKeyboard(paramViewGroup, stickerKeyboard, messageInput);
      ComposeButtonsVisibility.updateVisibility(getActivity(), messageInput, messageSendButton, stickerButton, cameraButton, hasRecipients(), isSharing(), isStickerKeyboardShown());
      useQuickReplyButton.setOnClickListener(new MessageListFragment.5(this, getTracker(), "quick_reply", new TrackingEventBuilder[0]));
      replyButton.setOnClickListener(new MessageListFragment.6(this));
      modeManager = new MessageListModeManager();
      updateReplyActionVisibility();
      if (isSharing())
      {
        messageListContainer.getLayoutParams().height = -2;
        getActivity().getContentResolver().unregisterContentObserver(contentObserver);
        if (!isKeyboardV2Enabled)
        {
          messageInputSpacer.setVisibility(0);
          cameraButton.setVisibility(8);
          stickerButton.setVisibility(8);
          ComposeButtonsVisibility.updateVisibility(getActivity(), messageInput, messageSendButton, stickerButton, cameraButton, hasRecipients(), isSharing(), isStickerKeyboardShown());
        }
        getMessengerLibApi().getFeedUpdateModel(shareUpdateUrn, new MessageListFragment.27(this));
      }
      return paramViewGroup;
      paramLayoutInflater = getDraftFromDiskIfExists();
      break;
      messageSendButton = ((ImageButton)paramViewGroup.findViewById(R.id.message_send));
      cameraButton = ((ImageButton)paramViewGroup.findViewById(R.id.message_camera_button));
      messageInput = ((MentionsEditText)paramViewGroup.findViewById(R.id.message_input));
      stickerKeyboard = ((StickerTrayView)paramViewGroup.findViewById(R.id.message_sticker_keyboard));
      stickerButton = ((ImageButton)paramViewGroup.findViewById(R.id.message_sticker_icon));
      messageInputSpacer = paramViewGroup.findViewById(R.id.message_input_spacer);
      MessengerDrawableResources.setImageResource(fragmentComponent.drawableResources(), cameraButton, 5);
      oldKeyboard.setVisibility(0);
      break label534;
    }
  }
  
  public void onDestroy()
  {
    if ((messageInput != null) && (messageInput.getText() != null)) {
      saveDraftToDisk(messageInput.getText().toString());
    }
    super.onDestroy();
  }
  
  public void onDetach()
  {
    Object localObject = getActivity();
    if (localObject != null)
    {
      if (contentObserver != null)
      {
        getActivity().getContentResolver().unregisterContentObserver(contentObserver);
        contentObserver = null;
      }
      ((Activity)localObject).unregisterReceiver(syncBroadcastReceiver);
      ((Context)localObject).unregisterReceiver(networkChangeReceiver);
    }
    if (messageListAdapter != null) {
      messageListAdapter.closeEventCursor();
    }
    localObject = eventQueueWorker;
    activity = null;
    delegate = null;
    super.onDetach();
  }
  
  public final void onEventLongPressCopyAction()
  {
    String str;
    Object localObject;
    if (pendingEventLongPressRemoteId != null)
    {
      str = pendingEventLongPressRemoteId;
      localObject = fragmentComponent.dataManager.eventsDataManager.getEventForEventRemoteId(str);
      if (localObject == null) {
        break label105;
      }
      if (!((Cursor)localObject).moveToFirst()) {
        break label100;
      }
      str = EventsDataManager.EventCursor.getMessageBody((Cursor)localObject);
      ((Cursor)localObject).close();
    }
    for (;;)
    {
      if (str != null)
      {
        localObject = (ClipboardManager)getActivity().getSystemService("clipboard");
        if (localObject != null) {
          ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText(fragmentComponent.i18NManager.getString(R.string.linkedin), str));
        }
      }
      pendingEventLongPressRemoteId = null;
      return;
      label100:
      str = null;
      break;
      label105:
      str = null;
    }
  }
  
  public final void onInvitationAction(int paramInt)
  {
    shouldShowPendingInvitation = false;
    if ((getMessengerLibApi() != null) && (pendingInvitation != null)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      getMessengerLibApi().setInvitationResponse(pendingInvitation, paramInt, new MessageListFragment.10(this, paramInt));
      return;
      localObject = pendingInvitation.fromMember;
    } while (localObject == null);
    Object localObject = entityUrn.toString();
    ConversationUtil.reportConversationParticipantAndTrack(fragmentComponent, conversationId, conversationRemoteId, (String)localObject, true);
  }
  
  public final void onLoadMore()
  {
    if ((isLoading) || (messageListAdapter == null)) {}
    while (messageListAdapter.loadMoreTerminated) {
      return;
    }
    MessageListAdapter localMessageListAdapter = messageListAdapter;
    String str;
    if (eventCursor != null)
    {
      int i = eventCursor.getPosition();
      if (i >= 0)
      {
        eventCursor.moveToLast();
        str = eventCursor.getString(eventCursor.getColumnIndex("timestamp"));
        eventCursor.moveToPosition(i);
      }
    }
    for (;;)
    {
      refreshMessagesFromNetworkAsync$16da05f7(str);
      messageListAdapter.showLoading();
      return;
      str = null;
    }
  }
  
  public void onPause()
  {
    if (messageListAdapter != null) {
      messageListAdapter.latestOnPauseTimestamp = System.currentTimeMillis();
    }
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(sendTypingIndicatorBroadcastReceiver);
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(receivedTypingIndicatorBroadcastReceiver);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (isDetached()) {
      return;
    }
    MessageListAdapter localMessageListAdapter;
    long l2;
    long l1;
    if (messageListAdapter != null)
    {
      localMessageListAdapter = messageListAdapter;
      if (latestOnPauseTimestamp == -1L) {
        break label195;
      }
      l2 = latestOnPauseTimestamp;
      Iterator localIterator = getDownloadsevents.values().iterator();
      l1 = -1L;
      label66:
      if (localIterator.hasNext())
      {
        EventAttachmentMap.Event localEvent = (EventAttachmentMap.Event)localIterator.next();
        if (l1 >= latestPutTimestamp) {
          break label200;
        }
        l1 = latestPutTimestamp;
      }
    }
    label195:
    label200:
    for (;;)
    {
      break label66;
      if (l2 < l1) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localMessageListAdapter.notifyDataSetChanged();
        }
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(sendTypingIndicatorBroadcastReceiver, new IntentFilter("com.linkedin.messengerlib.SEND_TYPING_INDICATOR"));
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(receivedTypingIndicatorBroadcastReceiver, new IntentFilter("com.linkedin.messengerlib.RECEIVED_TYPING_INDICATOR"));
        refreshMessagesFromNetworkAsync$16da05f7(null);
        if (!queueMarkAsReadOnResume) {
          break;
        }
        queueMarkAsReadOnResume = false;
        markConversationAsRead();
        return;
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if ((messageInput != null) && (messageInput.getText() != null))
    {
      paramBundle.putString("messageInputExtraKey", messageInput.getText().toString());
      saveDraftToDisk(messageInput.getText().toString());
    }
    paramBundle.putLong("conversationIdExtraKey", conversationId);
    paramBundle.putString("conversationRemoteIdExtraKey", conversationRemoteId);
    paramBundle.putString("shareUpdateUrnExtraKey", shareUpdateUrn);
    paramBundle.putBoolean("shouldShowPendingInvitation", shouldShowPendingInvitation);
  }
  
  public final void onScroll() {}
  
  protected final void onSendAttachmentApproved(File paramFile, PendingAttachment paramPendingAttachment)
  {
    saveMessageEvent("", paramFile, paramPendingAttachment);
  }
  
  protected final void onSendStickerApproved(LocalSticker paramLocalSticker)
  {
    saveEvent(PendingEvent.Factory.newStickerEvent(paramLocalSticker, conversationId, conversationRemoteId, modeManager.getOutgoingMessageSubtype()), null);
  }
  
  public final void onStickerPreview(LocalSticker paramLocalSticker)
  {
    onStickerActionListener.onStickerPreview(paramLocalSticker);
  }
  
  public final void onStickerSend(LocalSticker paramLocalSticker)
  {
    onStickerActionListener.onStickerSend(paramLocalSticker);
  }
  
  public final void onStickerView(LocalSticker paramLocalSticker)
  {
    onStickerActionListener.onStickerView(paramLocalSticker);
  }
  
  protected final void onUploadAttachmentFailure(File paramFile, boolean paramBoolean)
  {
    if (getMessengerLibApi() == null) {}
    while ((pendingEvent == null) || (!paramBoolean) || (supportsMessageQueue())) {
      return;
    }
    pendingEvent.setMessageAttachment(paramFile);
    fragmentComponent.dataManager.eventsDataManager.setMessageAttachments(pendingEvent.eventId, pendingEvent.messageAttachments);
    failEvent();
  }
  
  protected final void onUploadAttachmentSuccess(File paramFile, boolean paramBoolean)
  {
    if (getMessengerLibApi() == null) {}
    while ((pendingEvent == null) || (!paramBoolean) || (supportsMessageQueue())) {
      return;
    }
    pendingEvent.setMessageAttachment(paramFile);
    fragmentComponent.dataManager.eventsDataManager.setMessageAttachments(pendingEvent.eventId, pendingEvent.messageAttachments);
    sendEvent();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    pendingInvitation = ConversationDataManager.getPendingInvitationForConversationId(conversationId);
    if ((getLixManager() == null) || (!getLixManager().isGroupMentionEnabled())) {}
    for (;;)
    {
      if (conversationId != -1L)
      {
        refreshMessagesFromCursor();
        refreshConversationAndParticipantsFromCursor(conversationId);
      }
      return;
      mentionsPresenter = new MentionsPresenter(getActivity(), fragmentComponent, getTracker());
      paramView = mentionsPresenter;
      paramBundle = mentionsRecyclerView;
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramBundle.getContext());
      localLinearLayoutManager.setStackFromEnd(true);
      paramBundle.setLayoutManager(localLinearLayoutManager);
      paramBundle.setAdapter(adapter);
      mentionsPresenter.mentionInterface = this;
      if (isKeyboardV2Enabled)
      {
        messengerKeyboardFragment.mentionsPresenter = mentionsPresenter;
      }
      else
      {
        messageInput.setTokenizer(new WordTokenizer());
        messageInput.setQueryTokenReceiver(mentionsPresenter);
        messageInput.setSuggestionsVisibilityManager(this);
      }
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
    int j = 1;
    super.setArguments(paramBundle);
    boolean bool;
    String str;
    if ((paramBundle != null) && (paramBundle.getBoolean("IS_EMBEDDED_IN_COMPOSE")))
    {
      bool = true;
      isEmbeddedInComposer = bool;
      if (paramBundle != null) {
        break label100;
      }
      str = null;
      label37:
      shareUpdateUrn = str;
      if ((paramBundle == null) || (!paramBundle.containsKey("SHARE_UPDATE_URN"))) {
        break label112;
      }
      i = 1;
      label59:
      if (i != 0) {
        return;
      }
      if ((paramBundle == null) || (!paramBundle.containsKey("CONVERSATION_REMOTE_ID"))) {
        break label117;
      }
    }
    label100:
    label112:
    label117:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        break label122;
      }
      throw new RuntimeException("No remote conversation ID provided");
      bool = false;
      break;
      str = paramBundle.getString("SHARE_UPDATE_URN");
      break label37;
      i = 0;
      break label59;
    }
    label122:
    conversationId = MessageListBundleBuilder.getConversationId(paramBundle, conversationId);
    conversationRemoteId = MessageListBundleBuilder.getConversationRemoteId(paramBundle);
  }
  
  public final void setMention(Mentionable paramMentionable)
  {
    displaySuggestions(false);
    if (isKeyboardV2Enabled)
    {
      messengerKeyboardFragment.composeText.insertMention(paramMentionable);
      return;
    }
    messageInput.insertMention(paramMentionable);
  }
  
  public final void setOnMetaDataChangeListener(MessageListBaseFragment.OnMetaDataChangeListener paramOnMetaDataChangeListener)
  {
    onMetaDataChangeListener = paramOnMetaDataChangeListener;
  }
  
  public final void setRecipients(List<MiniProfile> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    recipients = new ArrayList(paramList);
    if (isKeyboardV2Enabled)
    {
      messengerKeyboardFragment.setRecipients(ViewModelTransformer.fromMiniProfileToViewModels$18a2b177(recipients, fragmentComponent.i18NManager));
      return;
    }
    ComposeButtonsVisibility.updateVisibility(getActivity(), messageInput, messageSendButton, stickerButton, cameraButton, hasRecipients(), isSharing(), isStickerKeyboardShown());
  }
  
  public final boolean shouldShowDeleteWarningOnBack()
  {
    return (messageInput != null) && (!TextUtils.equals(messageInput.getText().toString(), getDraftFromDiskIfExists()));
  }
  
  protected final boolean shouldShowPendingMessagesWarningOnBack()
  {
    EventQueueWorker localEventQueueWorker = eventQueueWorker;
    return (currentlySendingEvent != null) || (!messageQueue.isEmpty());
  }
  
  public final void showEventLongPressDialog(String paramString)
  {
    pendingEventLongPressRemoteId = paramString;
    showDialog(EventLongPressDialogFragment.newInstance(), "event_long_press");
  }
  
  public final boolean supportsMessageQueue()
  {
    return (getLixManager() != null) && (getLixManager().isMessageQueueEnabled());
  }
  
  protected final void trackAttachAction(String paramString)
  {
    ImpressionUtil.trackConversationDetailAction(fragmentComponent, conversationId, conversationRemoteId, paramString, 8);
  }
  
  protected final void trackStickerAction(LocalSticker paramLocalSticker)
  {
    FragmentComponent localFragmentComponent = fragmentComponent;
    String str = conversationRemoteId;
    Object localObject = localFragmentComponent.lixManager();
    if ((localObject == null) || (!((MessengerLixManager)localObject).isImpressionTrackingEnabled())) {}
    do
    {
      return;
      localObject = dataManager.stickersDataManager.getStickerPackName(stickerPacksId);
    } while (localObject == null);
    localFragmentComponent.libApi().trackStickerAction(localFragmentComponent.fragment().getTracker(), UrnUtil.createConversationUrn(str).toString(), (String)localObject, sortId + 1L);
  }
  
  protected final void trackStickerImpression(LocalSticker paramLocalSticker)
  {
    FragmentComponent localFragmentComponent = fragmentComponent;
    String str = conversationRemoteId;
    Object localObject = localFragmentComponent.lixManager();
    if ((localObject == null) || (!((MessengerLixManager)localObject).isImpressionTrackingEnabled())) {}
    do
    {
      return;
      localObject = dataManager.stickersDataManager.getStickerPackName(stickerPacksId);
    } while (localObject == null);
    localFragmentComponent.libApi().trackStickerImpression(localFragmentComponent.fragment().getTracker(), UrnUtil.createConversationUrn(str).toString(), (String)localObject, sortId + 1L);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.messagelist.MessageListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */