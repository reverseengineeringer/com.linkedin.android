package com.linkedin.android.identity.me.notifications;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.home.HomeCachedLix;
import com.linkedin.android.identity.me.shared.paging.MeNotificationsPagingHelper;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card.Value;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class NotificationsDataProvider
  extends DataProvider<NotificationsDataProvider.NotificationsState, DataProvider.DataProviderListener>
{
  public static final Uri NOTIFICATION_CARDS_ROUTE = Routes.ME_FEED_CARDS.buildUponRoot().buildUpon().appendQueryParameter("q", "notifications").appendQueryParameter("usageContext", "notifications").appendQueryParameter("version", "8").build();
  public static final String TAG = NotificationsDataProvider.class.getSimpleName();
  
  @Inject
  public NotificationsDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public final void appendNumNotificationsLoaded(int paramInt)
  {
    NotificationsDataProvider.NotificationsState localNotificationsState = (NotificationsDataProvider.NotificationsState)state;
    numNotificationCardsLoaded += paramInt;
  }
  
  public final Collection<Card> getNotificationCardsWithUpsell()
  {
    return state).notificationCardsWithUpsell;
  }
  
  public final boolean hasMoreData()
  {
    return (state).notificationsCardsHelper != null) && (state).notificationsCardsHelper.hasMoreData());
  }
  
  final boolean isNavV2PropsInNotifications()
  {
    return activityComponent.homeCachedLix().isNavV2PropsInNotifications();
  }
  
  public final boolean isNotificationsDataAvailable()
  {
    return ((NotificationsDataProvider.NotificationsState)state).notificationCards() != null;
  }
  
  public final boolean isPropsDataAvailable()
  {
    return ((NotificationsDataProvider.NotificationsState)state).props() != null;
  }
  
  public final boolean isRefreshing()
  {
    return state).isRefreshing;
  }
  
  final void updateNotificationCardsForUpsell(FragmentComponent paramFragmentComponent, List<Card> paramList)
  {
    Collection localCollection;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localCollection = getNotificationCardsWithUpsell();
      if (localCollection.isEmpty())
      {
        LixManager localLixManager = paramFragmentComponent.lixManager();
        paramFragmentComponent = paramFragmentComponent.memberUtil();
        if ((!"enabled".equals(localLixManager.getTreatment(Lix.LIX_PREMIUM_ME_SHOW_UPSELL))) || (paramFragmentComponent.isPremium())) {
          break label149;
        }
      }
    }
    label149:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramFragmentComponent = paramList.iterator();
        while (paramFragmentComponent.hasNext())
        {
          paramList = (Card)paramFragmentComponent.next();
          if ((paramList != null) && (value != null) && (value.aggregateProfileViewCardValue != null) && (value.aggregateProfileViewCardValue.numViewers > 2L)) {
            localCollection.add(paramList);
          }
        }
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.notifications.NotificationsDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */