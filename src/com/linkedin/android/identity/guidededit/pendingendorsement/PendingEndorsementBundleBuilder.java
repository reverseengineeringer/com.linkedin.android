package com.linkedin.android.identity.guidededit.pendingendorsement;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard;
import com.linkedin.data.lite.JsonGeneratorException;

public final class PendingEndorsementBundleBuilder
  implements BundleBuilder
{
  protected final Bundle bundle = new Bundle();
  
  public static PendingEndorsementBundleBuilder create()
  {
    return new PendingEndorsementBundleBuilder();
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final PendingEndorsementBundleBuilder setEndorser(EndorsementCard paramEndorsementCard)
  {
    if (paramEndorsementCard != null) {}
    try
    {
      RecordParceler.parcel(paramEndorsementCard, "endorsementMeCard", bundle);
      return this;
    }
    catch (JsonGeneratorException localJsonGeneratorException)
    {
      Log.e("Cannot parcel the endorsement card" + paramEndorsementCard.toString());
    }
    return this;
  }
  
  public final PendingEndorsementBundleBuilder setEntryPoint(PendingEndorsementsEntryPoint paramPendingEndorsementsEntryPoint)
  {
    if (paramPendingEndorsementsEntryPoint != null) {
      bundle.putSerializable(PendingEndorsementsEntryPoint.NAME, paramPendingEndorsementsEntryPoint);
    }
    return this;
  }
  
  public final PendingEndorsementBundleBuilder setMeCardUrn(Urn paramUrn)
  {
    if (paramUrn != null) {
      bundle.putString("meCardUrn", paramUrn.toString());
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */