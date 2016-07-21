package com.linkedin.android.entities;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import com.linkedin.android.entities.viewmodels.EmptyStateViewModel;
import com.linkedin.android.entities.viewmodels.items.EntityItemViewModel;
import com.linkedin.android.entities.viewmodels.items.EntityMultiHeadlineItemViewModel;
import com.linkedin.android.feed.shared.LinkUtils;
import com.linkedin.android.identity.shared.ProfileViewUtils;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.DateUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.concurrent.TimeUnit;

public final class EntityTransformer
{
  public static <INPUT> TrackingClosure<INPUT, Void> createViewAllClosure(final FragmentComponent paramFragmentComponent, final EntityViewAllListBaseFragment paramEntityViewAllListBaseFragment, String paramString)
  {
    new TrackingClosure(paramFragmentComponent.tracker(), paramString) {};
  }
  
  public static EmptyStateViewModel noCardsEmptyState(FragmentComponent paramFragmentComponent, String paramString, int paramInt)
  {
    EmptyStateViewModel localEmptyStateViewModel = new EmptyStateViewModel();
    message = paramString;
    image = ContextCompat.getDrawable(paramFragmentComponent.context(), paramInt);
    return localEmptyStateViewModel;
  }
  
  public static EntityItemViewModel toConnectionItem(FragmentComponent paramFragmentComponent, ActivityComponent paramActivityComponent, EntitiesMiniProfile paramEntitiesMiniProfile, Closure<ImpressionData, TrackingEventBuilder> paramClosure)
  {
    MiniProfile localMiniProfile = miniProfile;
    int i = ProfileViewUtils.getDegreeIntFromDistance(distance);
    if ((hasHeadless) && (headless)) {}
    for (boolean bool = true;; bool = false) {
      return toConnectionItem(paramFragmentComponent, paramActivityComponent, localMiniProfile, i, bool, paramClosure);
    }
  }
  
  public static EntityItemViewModel toConnectionItem(FragmentComponent paramFragmentComponent, ActivityComponent paramActivityComponent, MiniProfile paramMiniProfile, int paramInt, Closure<ImpressionData, TrackingEventBuilder> paramClosure)
  {
    return toConnectionItem(paramFragmentComponent, paramActivityComponent, paramMiniProfile, paramInt, false, paramClosure);
  }
  
  private static EntityItemViewModel toConnectionItem(FragmentComponent paramFragmentComponent, final ActivityComponent paramActivityComponent, final MiniProfile paramMiniProfile, int paramInt, boolean paramBoolean, Closure<ImpressionData, TrackingEventBuilder> paramClosure)
  {
    if (paramInt == 1)
    {
      paramClosure = toPersonItem(paramFragmentComponent, paramMiniProfile, false, paramClosure);
      ctaButtonIcon = 2130838125;
      onCtaButtonClick = new TrackingClosure(paramFragmentComponent.tracker(), "message") {};
    }
    for (paramActivityComponent = paramClosure;; paramActivityComponent = toPersonItem(paramFragmentComponent, paramMiniProfile, paramBoolean, paramClosure))
    {
      if (paramInt != -1)
      {
        paramClosure = paramFragmentComponent.i18NManager();
        paramFragmentComponent = paramFragmentComponent.context().obtainStyledAttributes(2131361900, new int[] { 16842904 });
        int i = paramFragmentComponent.getColor(0, 0);
        paramFragmentComponent.recycle();
        paramMiniProfile = I18NManager.getName(paramMiniProfile);
        paramFragmentComponent = paramClosure.getString(2131233018, new Object[] { paramMiniProfile });
        paramMiniProfile = paramClosure.getString(2131231002, new Object[] { paramMiniProfile, Integer.valueOf(paramInt) });
        paramInt = paramMiniProfile.indexOf(paramFragmentComponent);
        int j = paramFragmentComponent.length() + paramInt;
        paramFragmentComponent = new SpannableStringBuilder(paramMiniProfile);
        if (i != 0)
        {
          paramMiniProfile = new ForegroundColorSpan(i);
          if (paramInt > 0) {
            paramFragmentComponent.setSpan(paramMiniProfile, 0, paramInt, 33);
          }
          if (j < paramFragmentComponent.length()) {
            paramFragmentComponent.setSpan(paramMiniProfile, j, paramFragmentComponent.length(), 33);
          }
        }
        title = paramFragmentComponent;
      }
      return paramActivityComponent;
    }
  }
  
  public static EntityItemViewModel toConnectionItem(FragmentComponent paramFragmentComponent, ActivityComponent paramActivityComponent, MiniProfile paramMiniProfile, MemberDistance paramMemberDistance)
  {
    return toConnectionItem(paramFragmentComponent, paramActivityComponent, paramMiniProfile, paramMemberDistance, null);
  }
  
  public static EntityItemViewModel toConnectionItem(FragmentComponent paramFragmentComponent, ActivityComponent paramActivityComponent, MiniProfile paramMiniProfile, MemberDistance paramMemberDistance, Closure<ImpressionData, TrackingEventBuilder> paramClosure)
  {
    return toConnectionItem(paramFragmentComponent, paramActivityComponent, paramMiniProfile, ProfileViewUtils.getDegreeIntFromDistance(paramMemberDistance), paramClosure);
  }
  
  public static EntityItemViewModel toJobItem(final FragmentComponent paramFragmentComponent, final MiniJob paramMiniJob, Closure<ImpressionData, TrackingEventBuilder> paramClosure)
  {
    EntityItemViewModel localEntityItemViewModel = new EntityItemViewModel();
    title = title;
    subtitle = location;
    image = new ImageModel(logo, GhostImageUtils.getJob(2131492963, paramMiniJob), Util.retrieveRumSessionId(paramFragmentComponent));
    onRowClick = new TrackingClosure(paramFragmentComponent.tracker(), "job_link") {};
    trackingEventBuilderClosure = paramClosure;
    return localEntityItemViewModel;
  }
  
  public static EntityMultiHeadlineItemViewModel toLinkableDetailItem(final FragmentComponent paramFragmentComponent, String paramString1, String paramString2, final String paramString3, final String paramString4)
  {
    EntityMultiHeadlineItemViewModel localEntityMultiHeadlineItemViewModel = new EntityMultiHeadlineItemViewModel();
    headerBodyPair = new Pair(paramString1, LinkUtils.addHttpPrefixIfNecessary(paramString2));
    onBodyClick = new TrackingClosure(paramFragmentComponent.tracker(), "website_link") {};
    return localEntityMultiHeadlineItemViewModel;
  }
  
  public static EntityMultiHeadlineItemViewModel toNonLinkableDetailItem(String paramString1, String paramString2)
  {
    EntityMultiHeadlineItemViewModel localEntityMultiHeadlineItemViewModel = new EntityMultiHeadlineItemViewModel();
    headerBodyPair = new Pair(paramString1, paramString2);
    return localEntityMultiHeadlineItemViewModel;
  }
  
  public static EntityItemViewModel toPersonItem(final FragmentComponent paramFragmentComponent, final MiniProfile paramMiniProfile, final boolean paramBoolean, Closure<ImpressionData, TrackingEventBuilder> paramClosure)
  {
    EntityItemViewModel localEntityItemViewModel = new EntityItemViewModel();
    Object localObject = paramFragmentComponent.i18NManager();
    if (paramBoolean) {}
    for (localObject = ((I18NManager)localObject).getString(2131232803);; localObject = ((I18NManager)localObject).getString(2131233236, new Object[] { I18NManager.getName(paramMiniProfile) }))
    {
      title = ((CharSequence)localObject);
      subtitle = occupation;
      image = new ImageModel(picture, GhostImageUtils.getPerson(2131492963, paramMiniProfile), Util.retrieveRumSessionId(paramFragmentComponent));
      isImageOval = true;
      onRowClick = new TrackingClosure(paramFragmentComponent.tracker(), "profile_link") {};
      trackingEventBuilderClosure = paramClosure;
      return localEntityItemViewModel;
    }
  }
  
  public static String toPostedTimeAgoString$3d933973(I18NManager paramI18NManager, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (TimeUnit.MILLISECONDS.toMinutes(paramLong2 - paramLong1) < 1L) {
      return paramString;
    }
    if (paramBoolean) {
      paramString = DateUtils.getTimeAgoContentDescription(paramLong2, paramLong1, paramI18NManager);
    }
    for (;;)
    {
      return paramI18NManager.getString(2131231014, new Object[] { paramString });
      paramLong1 = (paramLong2 - paramLong1) / 60000L;
      if (paramLong1 < 1L)
      {
        paramString = paramI18NManager.getString(2131233019);
      }
      else if (paramLong1 < 60L)
      {
        paramString = paramI18NManager.getString(2131233005, new Object[] { Long.valueOf(paramLong1) });
      }
      else
      {
        paramLong1 /= 60L;
        if (paramLong1 < 24L)
        {
          paramString = paramI18NManager.getString(2131231780, new Object[] { Long.valueOf(paramLong1) });
        }
        else
        {
          paramLong1 /= 24L;
          if (paramLong1 < 7L)
          {
            paramString = paramI18NManager.getString(2131230841, new Object[] { Long.valueOf(paramLong1) });
          }
          else
          {
            paramLong1 /= 7L;
            if (paramLong1 < 4L)
            {
              paramString = paramI18NManager.getString(2131233740, new Object[] { Long.valueOf(paramLong1) });
            }
            else
            {
              paramLong1 /= 4L;
              if (paramLong1 < 12L) {
                paramString = paramI18NManager.getString(2131233008, new Object[] { Long.valueOf(paramLong1) });
              } else {
                paramString = paramI18NManager.getString(2131233748, new Object[] { Long.valueOf(paramLong1 / 12L) });
              }
            }
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */