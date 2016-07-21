package com.linkedin.android.tracking.v2.event;

import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.tracking.v2.utils.DataUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractTrackingEvent
  implements TrackingEvent
{
  protected final Tracker tracker;
  
  protected AbstractTrackingEvent(Tracker paramTracker)
  {
    tracker = paramTracker;
  }
  
  protected abstract <T extends RecordTemplate<T>> T buildPegasusEvent()
    throws BuilderException;
  
  public String getTopic()
  {
    return getClass().getSimpleName();
  }
  
  public final JSONObject jsonObject()
  {
    try
    {
      JSONObject localJSONObject1 = tracker.wrapMetric(DataUtils.modelToJSON(buildPegasusEvent()), getTopic());
      JSONObject localJSONObject2 = localJSONObject1;
      if (localJSONObject1 == null) {
        localJSONObject2 = new JSONObject();
      }
      return localJSONObject2;
    }
    catch (JSONException localJSONException)
    {
      Log.e("TrackingV2", "Failed in building tracking event JSONObject", localJSONException);
      throw new IllegalStateException(localJSONException);
    }
    catch (BuilderException localBuilderException)
    {
      Log.e("TrackingV2", "Failed in building tracking event", localBuilderException);
      throw new IllegalStateException(localBuilderException);
    }
  }
  
  public void send()
  {
    tracker.send(this);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.tracking.v2.event.AbstractTrackingEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */