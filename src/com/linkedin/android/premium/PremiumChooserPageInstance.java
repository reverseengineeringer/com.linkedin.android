package com.linkedin.android.premium;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.linkedin.android.tracking.v2.utils.DataUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.PageInstance.Builder;

public class PremiumChooserPageInstance
  implements Parcelable
{
  public static final Parcelable.Creator<PremiumChooserPageInstance> CREATOR = new PremiumChooserPageInstance.1();
  protected String pageKey;
  protected String trackingId;
  
  public PremiumChooserPageInstance(Parcel paramParcel)
  {
    pageKey = paramParcel.readString();
    trackingId = paramParcel.readString();
  }
  
  public PremiumChooserPageInstance(com.linkedin.android.tracking.v2.event.PageInstance paramPageInstance)
  {
    pageKey = pageKey;
    trackingId = Base64.encodeToString(DataUtils.uuidToBytes(trackingId), 2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final com.linkedin.gen.avro2pegasus.events.common.PageInstance toPegasusGenPageInstance()
  {
    try
    {
      com.linkedin.gen.avro2pegasus.events.common.PageInstance localPageInstance = new PageInstance.Builder().setPageUrn("urn:li:page:" + pageKey).setTrackingId(trackingId).build(RecordTemplate.Flavor.RECORD);
      return localPageInstance;
    }
    catch (BuilderException localBuilderException) {}
    return null;
  }
  
  public String toString()
  {
    return "pageKey: " + pageKey + ", trackingId: " + trackingId;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(pageKey);
    paramParcel.writeString(trackingId);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.PremiumChooserPageInstance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */