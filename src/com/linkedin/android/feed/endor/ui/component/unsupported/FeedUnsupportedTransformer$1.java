package com.linkedin.android.feed.endor.ui.component.unsupported;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import org.json.JSONException;
import org.json.JSONObject;

final class FeedUnsupportedTransformer$1
  implements View.OnClickListener
{
  FeedUnsupportedTransformer$1(Update paramUpdate, String paramString) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      String str2 = PegasusPatchGenerator.modelToJSON(val$update).toString(2);
      paramView.getContext();
      if (val$reason == null) {}
      for (String str1 = "We're still working on this update";; str1 = "We couldn't show this update")
      {
        Util.debugDialog$67c6b14e(str1, str2);
        return;
      }
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
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.unsupported.FeedUnsupportedTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */