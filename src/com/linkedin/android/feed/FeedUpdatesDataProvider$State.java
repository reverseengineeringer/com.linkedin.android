package com.linkedin.android.feed;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.feed.utils.FeedCollectionHelper;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.crosspromo.fe.api.android.Promo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FeedUpdatesDataProvider$State
  extends DataProvider.State
{
  public FeedCollectionHelper<Update, Metadata> collectionHelper;
  private final Map<String, AtomicBoolean> crossPromoDismissed = new ArrayMap();
  private final Map<String, AtomicBoolean> crossPromoImpressed = new ArrayMap();
  
  public FeedUpdatesDataProvider$State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
  }
  
  private static AtomicBoolean getFlag(Map<String, AtomicBoolean> paramMap, String paramString)
  {
    String str = Routes.crossPromoPath(paramString);
    AtomicBoolean localAtomicBoolean = (AtomicBoolean)paramMap.get(str);
    paramString = localAtomicBoolean;
    if (localAtomicBoolean == null)
    {
      paramString = new AtomicBoolean(false);
      paramMap.put(str, paramString);
    }
    return paramString;
  }
  
  public final Promo getCrossPromo(String paramString)
  {
    return (Promo)getModel(Routes.crossPromoPath(paramString));
  }
  
  public final AtomicBoolean getCrossPromoDismissed(String paramString)
  {
    return getFlag(crossPromoDismissed, paramString);
  }
  
  public final Throwable getCrossPromoError(String paramString)
  {
    return getError(Routes.crossPromoPath(paramString));
  }
  
  public final AtomicBoolean getCrossPromoImpressed(String paramString)
  {
    return getFlag(crossPromoImpressed, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.FeedUpdatesDataProvider.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */