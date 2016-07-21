package com.linkedin.android.entities.group.transformers;

import android.content.res.Resources;
import android.view.View;
import com.linkedin.android.entities.group.GroupDataProvider;
import com.linkedin.android.entities.group.GroupDataProvider.GroupState;
import com.linkedin.android.entities.viewmodels.EntityDetailedTopCardViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.entities.group.BasicGroupInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.group.Group;
import com.linkedin.android.pegasus.gen.voyager.entities.group.GroupType;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipStatus;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension.Builder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupImpressionItem.Builder;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupItemImpressionEvent.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GroupTransformer
{
  public static boolean canShowConversationsTab(GroupDataProvider paramGroupDataProvider)
  {
    Group localGroup = ((GroupDataProvider.GroupState)state).group();
    paramGroupDataProvider = ((GroupDataProvider.GroupState)state).recentDiscussions();
    return (localGroup != null) && (membershipInfo.status == GroupMembershipStatus.MEMBER) && (CollectionUtils.isNonEmpty(paramGroupDataProvider));
  }
  
  public static void fireGroupActionEvent(GroupDataProvider paramGroupDataProvider, FragmentComponent paramFragmentComponent, ActionCategory paramActionCategory, String paramString)
  {
    paramGroupDataProvider = state).groupTrackingObject;
    if (paramGroupDataProvider == null) {
      return;
    }
    paramString = TrackingUtils.constructFullTrackingControlUrn("group", paramString);
    paramFragmentComponent = paramFragmentComponent.tracker();
    FlagshipGroupActionEvent.Builder localBuilder = new FlagshipGroupActionEvent.Builder();
    if (paramActionCategory == null)
    {
      hasActionCategory = false;
      actionCategory = null;
      if (paramString != null) {
        break label130;
      }
      hasControlUrn = false;
      controlUrn = null;
      label71:
      paramActionCategory = objectUrn;
      if (paramActionCategory != null) {
        break label145;
      }
      hasSubItemUrn = false;
      subItemUrn = null;
      label92:
      if (paramGroupDataProvider != null) {
        break label160;
      }
      hasGroup = false;
    }
    for (group = null;; group = paramGroupDataProvider)
    {
      paramFragmentComponent.send(localBuilder);
      return;
      hasActionCategory = true;
      actionCategory = paramActionCategory;
      break;
      label130:
      hasControlUrn = true;
      controlUrn = paramString;
      break label71;
      label145:
      hasSubItemUrn = true;
      subItemUrn = paramActionCategory;
      break label92;
      label160:
      hasGroup = true;
    }
  }
  
  public static Closure<ImpressionData, TrackingEventBuilder> newGroupImpressionTrackingClosure(TrackingObject paramTrackingObject, final List<String> paramList, final String paramString1, final String paramString2)
  {
    new Closure()
    {
      private TrackingEventBuilder apply(ImpressionData paramAnonymousImpressionData)
      {
        if (val$parentJobTrackingObject == null) {
          return null;
        }
        try
        {
          FlagshipGroupImpressionItem.Builder localBuilder = new FlagshipGroupImpressionItem.Builder().setItemTrackingId(paramString2).setVisibleTime(Long.valueOf(timeViewed)).setListPosition(new ListPosition.Builder().setIndex(Integer.valueOf(position)).build(RecordTemplate.Flavor.RECORD)).setSize(new EntityDimension.Builder().setHeight(Integer.valueOf(height)).setWidth(Integer.valueOf(width)).build(RecordTemplate.Flavor.RECORD));
          if (paramList == null) {}
          for (Object localObject = new ArrayList();; localObject = paramList)
          {
            localObject = localBuilder.setUrns((List)localObject).build();
            Log.d("GroupImpression", "onTrackImpression() - pos: " + position + " card: " + paramString1);
            return new FlagshipGroupItemImpressionEvent.Builder().setGroup(val$parentJobTrackingObject).setItems(Collections.singletonList(localObject));
          }
          return null;
        }
        catch (BuilderException paramAnonymousImpressionData)
        {
          Util.safeThrow(new RuntimeException(paramAnonymousImpressionData));
        }
      }
    };
  }
  
  public static EntityDetailedTopCardViewModel transformTopCardWithMembershipStatus(final FragmentComponent paramFragmentComponent, final GroupDataProvider paramGroupDataProvider, final Group paramGroup, final GroupMembershipStatus paramGroupMembershipStatus)
  {
    boolean bool1;
    label13:
    boolean bool2;
    label23:
    int i;
    label42:
    EntityDetailedTopCardViewModel localEntityDetailedTopCardViewModel;
    label125:
    final Object localObject;
    if (groupType == GroupType.SECRET)
    {
      bool1 = true;
      if (paramGroupMembershipStatus != GroupMembershipStatus.MEMBER) {
        break label366;
      }
      bool2 = true;
      if (!basicGroupInfo.hasMemberCount) {
        break label372;
      }
      i = basicGroupInfo.memberCount;
      localEntityDetailedTopCardViewModel = new EntityDetailedTopCardViewModel();
      if (backgroundColor == null) {
        break label392;
      }
      coverImageColor = Integer.valueOf(android.graphics.Color.argb(backgroundColor.alpha, backgroundColor.red, backgroundColor.green, backgroundColor.blue));
      heroImage = null;
      topCardTopScrimWeight = paramFragmentComponent.activity().getResources().getFraction(2131689473, 1, 1);
      localObject = basicGroupInfo.miniGroup;
      icon = new ImageModel(logo, GhostImageUtils.getGroup(2131492963, (MiniGroup)localObject), Util.retrieveRumSessionId(paramFragmentComponent));
      title = groupName;
      localObject = paramFragmentComponent.i18NManager();
      if ((!basicGroupInfo.hasMemberCount) || (!bool1)) {
        break label446;
      }
    }
    label366:
    label372:
    label392:
    label446:
    for (boolean bool3 = true;; bool3 = false)
    {
      subtitle1 = ((I18NManager)localObject).getString(2131230926, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(basicGroupInfo.hasMemberCount), Integer.valueOf(i), Boolean.valueOf(bool2) });
      subtitle2 = "";
      localObject = Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance());
      switch (paramGroupMembershipStatus)
      {
      default: 
        paramFragmentComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException("Group Transformer could set up initial button state for group membership status: " + paramGroupMembershipStatus.toString()));
        return localEntityDetailedTopCardViewModel;
        bool1 = false;
        break label13;
        bool2 = false;
        break label23;
        i = paramFragmentComponent.activity().getResources().getInteger(2131558426);
        break label42;
        coverImageColor = null;
        heroImage = new ImageModel(heroImage, 2130837793, Util.retrieveRumSessionId(paramFragmentComponent));
        topCardTopScrimWeight = paramFragmentComponent.activity().getResources().getFraction(2131689472, 1, 1);
        break label125;
      }
    }
    secondaryButtonClickedText = paramFragmentComponent.i18NManager().getString(2131230925);
    secondaryButtonDefaultText = paramFragmentComponent.i18NManager().getString(2131230925);
    onSecondaryButtonClick = new TrackingClosure(paramFragmentComponent.tracker(), "start_new_conversation") {};
    return localEntityDetailedTopCardViewModel;
    primaryButtonClickedText = paramFragmentComponent.i18NManager().getString(2131230921);
    primaryButtonDefaultText = paramFragmentComponent.i18NManager().getString(2131230921);
    onPrimaryButtonClick = new TrackingClosure(paramFragmentComponent.tracker(), "group_join") {};
    return localEntityDetailedTopCardViewModel;
    secondaryButtonDefaultText = paramFragmentComponent.i18NManager().getString(2131230920);
    secondaryButtonClickedText = paramFragmentComponent.i18NManager().getString(2131230920);
    return localEntityDetailedTopCardViewModel;
    primaryButtonClickedText = paramFragmentComponent.i18NManager().getString(2131230908);
    primaryButtonDefaultText = paramFragmentComponent.i18NManager().getString(2131230908);
    onPrimaryButtonClick = new TrackingClosure(paramFragmentComponent.tracker(), "invite_accept") {};
    secondaryButtonDefaultText = paramFragmentComponent.i18NManager().getString(2131230912);
    secondaryButtonClickedText = paramFragmentComponent.i18NManager().getString(2131230912);
    onSecondaryButtonClick = new TrackingClosure(paramFragmentComponent.tracker(), "invite_decline") {};
    return localEntityDetailedTopCardViewModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.transformers.GroupTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */