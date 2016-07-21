package com.linkedin.android.messaging.messagelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.messaging.BaseMessengerActivity;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.attachment.PendingAttachment;
import com.linkedin.messengerlib.consumers.ActorDataManager;
import com.linkedin.messengerlib.consumers.DataManager;
import com.linkedin.messengerlib.shared.BaseFragment;
import com.linkedin.messengerlib.shared.FragmentComponent;
import com.linkedin.messengerlib.ui.compose.MessageCreateFragment;
import com.linkedin.messengerlib.ui.dialogs.EventLongPressDialogFragment.EventLongPressDialogHost;
import com.linkedin.messengerlib.ui.dialogs.SendImageApprovalDialogFragment.SendImageApprovalDialogHost;
import com.linkedin.messengerlib.ui.messagelist.LinearFacepileView;
import java.util.List;
import javax.inject.Inject;

public class MessageListActivity
  extends BaseMessengerActivity
  implements EventLongPressDialogFragment.EventLongPressDialogHost, SendImageApprovalDialogFragment.SendImageApprovalDialogHost
{
  @InjectView(2131756813)
  LinearFacepileView facepileImage;
  private MessageListFragment fragment;
  private boolean isGroup;
  @InjectView(2131756812)
  Toolbar toolbar;
  @Inject
  Tracker tracker;
  
  public final Fragment buildNewChildFragment()
  {
    return MessageListFragment.newInstance(new MessageListBundleBuilder(getIntent().getExtras()));
  }
  
  public final String getChildFragmentTag()
  {
    return "messageListFragment";
  }
  
  public final int getContentViewResId()
  {
    return 2130969016;
  }
  
  public final int getFragmentContainerResId()
  {
    return 2131756814;
  }
  
  public final MessengerLibApi getMessengerLibApi()
  {
    if (fragment != null) {
      return fragment.messagingLibProvider;
    }
    return null;
  }
  
  public final Tracker getTracker()
  {
    if (fragment != null) {
      return fragment.tracker;
    }
    return null;
  }
  
  public void onBackPressed()
  {
    if ((fragment != null) && (fragment.onBackPressed())) {
      return;
    }
    super.onBackPressed();
  }
  
  public final void onCancelSendImageAction()
  {
    if (fragment != null)
    {
      MessageListFragment localMessageListFragment = fragment;
      if (messageListFragment != null) {
        messageListFragment.pendingAttachment.clear();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    toolbar.setTitle(getLocalizedString(2131232820));
    toolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        onNavigationClick();
      }
    });
    facepileImage.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        Tracker localTracker = tracker;
        int i;
        if (isGroup)
        {
          paramAnonymousView = "group_topcard";
          new ControlInteractionEvent(localTracker, paramAnonymousView, ControlType.BUTTON, InteractionType.SHORT_PRESS).send();
          paramAnonymousView = fragment;
          if (messageListFragment != null)
          {
            paramAnonymousView = messageListFragment;
            i = fragmentComponent.dataManager.actorDataManager.getParticipantCountForConversation(conversationId);
            if (i != 1) {
              break label105;
            }
            paramAnonymousView.getMessengerLibApi().openConversationDetails(conversationId, conversationRemoteId, false);
          }
        }
        label105:
        while (i <= 1)
        {
          return;
          paramAnonymousView = "topcard";
          break;
        }
        paramAnonymousView.getMessengerLibApi().openConversationDetails(conversationId, conversationRemoteId, true);
      }
    });
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    fragment.onMetaDataChangeListener = null;
  }
  
  public final void onEventLongPressCopyAction()
  {
    if (fragment != null)
    {
      MessageListFragment localMessageListFragment = fragment;
      if (messageListFragment != null) {
        messageListFragment.onEventLongPressCopyAction();
      }
    }
  }
  
  public final void onSendImageAction(ManagedBitmap paramManagedBitmap)
  {
    if (fragment != null)
    {
      MessageListFragment localMessageListFragment = fragment;
      if (messageListFragment != null) {
        messageListFragment.onSendImageAction(paramManagedBitmap);
      }
    }
  }
  
  public final void performInjections()
  {
    activityComponent.inject(this);
    ButterKnife.inject(this);
  }
  
  public final Fragment setupChildFragment()
  {
    fragment = ((MessageListFragment)super.setupChildFragment());
    fragment.onMetaDataChangeListener = new MessageListFragment.OnMetaDataChangeListener()
    {
      public final void participantChange(MessengerLibApi paramAnonymousMessengerLibApi, List<MiniProfile> paramAnonymousList)
      {
        if (!fragment.isAdded()) {
          return;
        }
        LinearFacepileView localLinearFacepileView = facepileImage;
        if ((paramAnonymousList == null) || (paramAnonymousList.isEmpty()))
        {
          paramAnonymousMessengerLibApi = MessageListActivity.this;
          if (paramAnonymousList.size() <= 1) {
            break label290;
          }
        }
        label290:
        for (boolean bool = true;; bool = false)
        {
          MessageListActivity.access$102(paramAnonymousMessengerLibApi, bool);
          return;
          face1.setOval(true);
          face2.setOval(true);
          face3.setOval(true);
          face1.setVisibility(8);
          face2.setVisibility(8);
          face3.setVisibility(8);
          if (paramAnonymousList.size() == 1)
          {
            localLinearFacepileView.loadImage(paramAnonymousMessengerLibApi, face3, get0picture);
            break;
          }
          if (paramAnonymousList.size() == 2)
          {
            localLinearFacepileView.loadImage(paramAnonymousMessengerLibApi, face2, get1picture);
            localLinearFacepileView.loadImage(paramAnonymousMessengerLibApi, face3, get0picture);
            break;
          }
          localLinearFacepileView.loadImage(paramAnonymousMessengerLibApi, face1, get2picture);
          localLinearFacepileView.loadImage(paramAnonymousMessengerLibApi, face2, get1picture);
          localLinearFacepileView.loadImage(paramAnonymousMessengerLibApi, face3, get0picture);
          break;
        }
      }
      
      public final void participantChangeByName(String paramAnonymousString)
      {
        if (toolbar != null) {
          toolbar.setTitle(paramAnonymousString);
        }
      }
      
      public final void participantChangeByProfiles(List<MiniProfile> paramAnonymousList)
      {
        if (toolbar != null) {
          toolbar.setTitle(MessageListActivity.access$200(MessageListActivity.this, paramAnonymousList));
        }
      }
      
      public final void participantChangeCompany(MessengerLibApi paramAnonymousMessengerLibApi, MiniCompany paramAnonymousMiniCompany)
      {
        if (!fragment.isAdded()) {}
        do
        {
          return;
          LinearFacepileView localLinearFacepileView = facepileImage;
          if (paramAnonymousMiniCompany != null)
          {
            face1.setOval(false);
            face2.setOval(false);
            face3.setOval(false);
            face1.setVisibility(8);
            face2.setVisibility(8);
            face3.setVisibility(8);
            localLinearFacepileView.loadImage(paramAnonymousMessengerLibApi, face3, logo);
          }
          MessageListActivity.access$102(MessageListActivity.this, false);
        } while (toolbar == null);
        toolbar.setTitle(name);
      }
    };
    return fragment;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.messagelist.MessageListActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */