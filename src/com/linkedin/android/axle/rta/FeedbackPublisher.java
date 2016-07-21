package com.linkedin.android.axle.rta;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.voyager.common.RTAFeedback.Builder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import org.json.JSONException;
import org.json.JSONObject;

public final class FeedbackPublisher
{
  FragmentComponent fragmentComponent;
  
  public FeedbackPublisher(FragmentComponent paramFragmentComponent)
  {
    fragmentComponent = paramFragmentComponent;
  }
  
  static JsonModel wrapFeedback(String paramString)
  {
    new JSONObject();
    try
    {
      RTAFeedback.Builder localBuilder = new RTAFeedback.Builder();
      if (paramString == null) {
        hasFeedback = false;
      }
      for (feedback = null;; feedback = paramString)
      {
        paramString = PegasusPatchGenerator.modelToJSON(localBuilder.build(RecordTemplate.Flavor.RECORD));
        return new JsonModel(paramString);
        hasFeedback = true;
      }
      return null;
    }
    catch (BuilderException paramString)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Error build feedback model.", paramString));
      return null;
    }
    catch (JSONException paramString)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Error parsing feedback into JSONObject wrapper before posting feedback."));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.FeedbackPublisher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */