package com.linkedin.android.relationships.meetings;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop;

public final class MeetingDetailsFragmentBundleBuilder
  implements BundleBuilder
{
  public String meetingId;
  public Prop prop;
  
  public final Bundle build()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("meeting_id", meetingId);
    if (prop != null) {
      RecordParceler.quietParcel(prop, "prop", localBundle);
    }
    return localBundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.meetings.MeetingDetailsFragmentBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */