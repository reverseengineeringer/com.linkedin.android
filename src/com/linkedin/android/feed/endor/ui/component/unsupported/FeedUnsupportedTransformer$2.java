package com.linkedin.android.feed.endor.ui.component.unsupported;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import org.json.JSONException;
import org.json.JSONObject;

public final class FeedUnsupportedTransformer$2
  implements View.OnClickListener
{
  public FeedUnsupportedTransformer$2(Update paramUpdate, Throwable paramThrowable) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      String str = PegasusPatchGenerator.modelToJSON(val$update).toString(2);
      paramView.getContext();
      Util.debugDialog$67c6b14e(val$reason.getMessage(), str);
      return;
    }
    catch (JSONException localJSONException)
    {
      paramView.getContext();
      Util.safeThrow$7a8b4789(new RuntimeException(localJSONException));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.unsupported.FeedUnsupportedTransformer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */