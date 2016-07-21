package com.linkedin.android.feed.actions;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.events.UpdateActionEvent;
import com.linkedin.android.feed.events.UpdateExpandEvent;
import com.linkedin.android.feed.shared.FeedNavigationUtils;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedBundleBuilder;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedIntent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.semaphore.ReportEntityInvokerHelper;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponseBuilder;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;
import com.linkedin.android.pegasus.gen.voyager.feed.ChannelActor;
import com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Reshare;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate;
import com.linkedin.android.publishing.sharing.ShareBundle;
import com.linkedin.android.publishing.sharing.ShareIntent;
import com.linkedin.android.publishing.sharing.compose.ShareComposeBundle;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.VoidRecord;
import com.linkedin.security.android.ContentSource;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class UpdateActionPublisher
{
  public static void editShare(BaseFragment paramBaseFragment, UpdateActionEvent paramUpdateActionEvent)
  {
    Object localObject2 = update;
    paramUpdateActionEvent = urn.toString();
    Object localObject1 = entityUrn;
    localObject2 = tracking;
    ShareComposeBundle localShareComposeBundle = new ShareComposeBundle(false);
    bundle.putBoolean("is_edit_share", true);
    bundle.putString("update_urn", paramUpdateActionEvent);
    if (localObject1 != null) {
      bundle.putString("update_entity_urn", ((Urn)localObject1).toString());
    }
    if (localObject2 != null) {
      RecordParceler.quietParcel((RecordTemplate)localObject2, "trackingData", bundle);
    }
    paramUpdateActionEvent = ShareBundle.createFeedShare(localShareComposeBundle);
    paramBaseFragment = fragmentComponent;
    localObject1 = paramBaseFragment.activity();
    ((Context)localObject1).startActivity(intentRegistryshare.newIntent((Context)localObject1, paramUpdateActionEvent));
  }
  
  public static void handleUndoRemovalAction(FragmentComponent paramFragmentComponent, Update paramUpdate, UpdateActionModel paramUpdateActionModel, Map<String, String> paramMap)
  {
    paramFragmentComponent.eventBus();
    Bus.publish(new UpdateExpandEvent(paramUpdate));
    switch (type)
    {
    default: 
      return;
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      publishToggleFollowAction(paramFragmentComponent, paramUpdateActionModel, paramMap);
      return;
    }
    paramFragmentComponent = paramFragmentComponent.dataManager();
    paramUpdate = urn.toString();
    publishActionToServer(paramMap, paramFragmentComponent, Routes.FEED.buildRouteForId(paramUpdate).buildUpon().appendQueryParameter("action", String.valueOf("undoFeedback")).build().toString());
  }
  
  private static void publishActionToServer(Map<String, String> paramMap, FlagshipDataManager paramFlagshipDataManager, String paramString)
  {
    publishActionToServer(paramMap, paramFlagshipDataManager, paramString, new JsonModel(new JSONObject()));
  }
  
  private static void publishActionToServer(Map<String, String> paramMap, FlagshipDataManager paramFlagshipDataManager, String paramString, JsonModel paramJsonModel)
  {
    paramFlagshipDataManager.submit(Request.post().url(paramString).listener(new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<VoidRecord> paramAnonymousDataStoreResponse)
      {
        if (error != null) {
          Log.e("UpdateActionPublisher", "update action post failure", error);
        }
      }
    }).model(paramJsonModel).customHeaders(paramMap).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
  
  private static void publishToggleFollowAction(FragmentComponent paramFragmentComponent, UpdateActionModel paramUpdateActionModel, Map<String, String> paramMap)
  {
    String str = actorId;
    Routes localRoutes;
    switch (type)
    {
    default: 
      localRoutes = null;
    }
    for (;;)
    {
      paramUpdateActionModel = followingInfo;
      if ((str != null) && (localRoutes != null) && (paramUpdateActionModel != null)) {
        paramFragmentComponent.followPublisher().toggleFollow(str, localRoutes, paramUpdateActionModel, paramMap);
      }
      return;
      localRoutes = Routes.SCHOOL;
      continue;
      localRoutes = Routes.COMPANY;
      continue;
      localRoutes = Routes.PROFILE;
      continue;
      localRoutes = Routes.GROUP;
      continue;
      localRoutes = Routes.CHANNELS;
    }
  }
  
  public static void publishUpdateAction(Map<String, String> paramMap, FragmentComponent paramFragmentComponent, String paramString, UpdateActionModel paramUpdateActionModel, Update paramUpdate)
  {
    switch (type)
    {
    }
    label563:
    label571:
    do
    {
      do
      {
        return;
        paramFragmentComponent.dataManager().submit(Request.delete().url(Routes.FEED.buildRouteForId(paramString).buildUpon().build().toString()).customHeaders(paramMap));
        return;
        publishActionToServer(paramMap, paramFragmentComponent.dataManager(), Routes.FEED.buildRouteForId(paramString).buildUpon().appendQueryParameter("action", String.valueOf("feedback")).build().toString());
        return;
      } while (TextUtils.isEmpty(reason));
      paramMap = LayoutInflater.from(paramFragmentComponent.activity()).inflate(2130968738, null);
      ((TextView)paramMap.findViewById(2131755752)).setText(reason);
      paramFragmentComponent = new AlertDialog.Builder(paramFragmentComponent.activity()).setView(paramMap).create();
      ((Button)paramMap.findViewById(2131755753)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          val$dialog.dismiss();
        }
      });
      paramFragmentComponent.setCanceledOnTouchOutside(false);
      paramFragmentComponent.show();
      return;
      if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_FOLLOW_HUB))
      {
        FeedNavigationUtils.openFollowHub(paramFragmentComponent);
        return;
      }
      paramMap = RebuildMyFeedBundleBuilder.createBundle(true).setRbmfOrigin(1);
      paramMap = intentRegistryrebuildMyFeedIntent.newIntent(paramFragmentComponent.activity(), paramMap);
      paramFragmentComponent.context().startActivity(paramMap);
      return;
      publishActionToServer(paramMap, paramFragmentComponent.dataManager(), FeedRouteUtils.getReportUpdateUrl(paramString));
      paramString = urn;
      if (value.channelUpdateValue != null)
      {
        paramMap = value.channelUpdateValue.actor.urn;
        if (paramString == null) {
          break label571;
        }
        localObject = paramFragmentComponent.reportEntityInvokerHelper();
        paramUpdateActionModel = new UpdateReportResponseHandler(paramFragmentComponent, paramUpdate, paramUpdateActionModel);
        paramUpdate = ContentSource.USCP_ACTIVITY;
        paramString = paramString.toString();
        if (paramMap != null) {
          break label563;
        }
      }
      for (paramMap = null;; paramMap = paramMap.toString())
      {
        ((ReportEntityInvokerHelper)localObject).invokeFlow(paramFragmentComponent, paramUpdateActionModel, paramUpdate, paramString, null, paramMap);
        return;
        if (value.discussionUpdateValue != null)
        {
          paramMap = FeedUpdateUtils.getSocialActorUrn(value.discussionUpdateValue.actor);
          break;
        }
        if (value.reshareValue != null)
        {
          paramMap = FeedUpdateUtils.getSocialActorUrn(value.reshareValue.actor);
          break;
        }
        if (value.shareUpdateValue != null)
        {
          paramMap = FeedUpdateUtils.getSocialActorUrn(value.shareUpdateValue.actor);
          break;
        }
        if (value.viralUpdateValue != null)
        {
          paramMap = FeedUpdateUtils.getSocialActorUrn(value.viralUpdateValue.actor);
          break;
        }
        paramMap = null;
        break;
      }
      Log.e("Feed Logging", "Can't invoke report flow because entityUrn is null");
      Toast.makeText(paramFragmentComponent.activity(), paramFragmentComponent.context().getString(2131233721), 1).show();
      return;
      publishToggleFollowAction(paramFragmentComponent, paramUpdateActionModel, paramMap);
      return;
      paramFragmentComponent = paramFragmentComponent.dataManager();
      localObject = mentionedEntityUrn;
      paramUpdateActionModel = Routes.FEED.buildRouteForId(paramString).buildUpon().appendQueryParameter("action", String.valueOf("incorrectlyMentionedInTheNews")).build().toString();
      paramUpdate = new JSONObject();
      try
      {
        paramUpdate.put("articleUrn", paramString);
        paramUpdate.put("mentionedEntity", localObject);
        publishActionToServer(paramMap, paramFragmentComponent, paramUpdateActionModel, new JsonModel(paramUpdate));
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          Log.e("Feed Logging", "Got exception in publishWrongEntityAction!");
        }
      }
    } while (groupId == null);
    paramFragmentComponent = paramFragmentComponent.dataManager();
    paramString = groupId;
    paramString = Routes.GROUP.buildRouteForId(paramString).buildUpon().appendQueryParameter("action", "leave").build().toString();
    paramUpdateActionModel = new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<ActionResponse<GroupMembershipInfo>> paramAnonymousDataStoreResponse)
      {
        if (error != null) {
          Log.e("UpdateActionPublisher", "update action post failure", error);
        }
        if (model != null)
        {
          paramAnonymousDataStoreResponse = (GroupMembershipInfo)model).value;
          val$dataManager.submit(Request.put().cacheKey(entityUrn.toString()).model(paramAnonymousDataStoreResponse).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
        }
      }
    };
    paramUpdate = new ActionResponseBuilder(GroupMembershipInfo.BUILDER);
    Object localObject = new JsonModel(new JSONObject());
    paramFragmentComponent.submit(Request.post().url(paramString).listener(paramUpdateActionModel).builder(paramUpdate).model((RecordTemplate)localObject).customHeaders(paramMap).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
  
  public static void sendShareViaIntent(BaseFragment paramBaseFragment, UpdateActionEvent paramUpdateActionEvent)
  {
    if (updateAction.permalink == null)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Share via permalink is null - unsupported update action."));
      return;
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.TEXT", updateAction.permalink);
    paramUpdateActionEvent = Intent.createChooser(localIntent, i18NManager.getString(2131231193));
    paramBaseFragment.getActivity().startActivity(paramUpdateActionEvent);
  }
  
  public static void showDeleteConfirmationDialog$79962340(FragmentComponent paramFragmentComponent, DeleteUpdateActionListener paramDeleteUpdateActionListener)
  {
    paramFragmentComponent = new AlertDialog.Builder(paramFragmentComponent.activity()).setTitle(2131231173).setMessage(2131231172).setPositiveButton(2131231171, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (val$deleteUpdateActionListener != null) {
          val$deleteUpdateActionListener.onDeleteUpdateAction();
        }
      }
    }).setNegativeButton(2131230816, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    }).create();
    paramFragmentComponent.setCanceledOnTouchOutside(false);
    paramFragmentComponent.show();
  }
  
  public static abstract interface DeleteUpdateActionListener
  {
    public abstract void onDeleteUpdateAction();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.UpdateActionPublisher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */