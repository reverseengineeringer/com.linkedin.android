package com.linkedin.android.feed.endor.ui.component.unsupported;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import org.json.JSONException;
import org.json.JSONObject;

public final class FeedUnsupportedTransformer
{
  public static FeedUnsupportedViewModel toUnsupportedViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, Update paramUpdate, final String paramString)
  {
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        try
        {
          String str2 = PegasusPatchGenerator.modelToJSON(val$update).toString(2);
          paramAnonymousView.getContext();
          if (paramString == null) {}
          for (String str1 = "We're still working on this update";; str1 = "We couldn't show this update")
          {
            Util.debugDialog$67c6b14e(str1, str2);
            return;
          }
          return;
        }
        catch (JSONException localJSONException)
        {
          paramAnonymousView.getContext();
          Util.safeThrow$7a8b4789(new RuntimeException(localJSONException));
        }
      }
    };
    String str = paramString;
    if (paramString == null) {
      str = paramFragmentComponent.i18NManager().getString(2131231310);
    }
    return new FeedUnsupportedViewModel(paramUpdate, paramFragmentComponent, paramFeedComponentsViewPool, str, local1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.unsupported.FeedUnsupportedTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */