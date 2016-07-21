package com.linkedin.android.feed.shared;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.PreviewCreationSuccessful;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewResponse;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewResponse.Value;
import java.util.Map;

public abstract class UrlPreviewGetter
{
  private static final String TAG = UrlPreviewGetter.class.getSimpleName();
  
  public static void get(Map<String, String> paramMap, String paramString, Listener paramListener, FlagshipDataManager paramFlagshipDataManager)
  {
    paramFlagshipDataManager.submit(Request.get().url(Routes.FEED_URL_PREVIEW.buildUponRoot().buildUpon().appendPath(paramString).build().toString()).customHeaders(paramMap).builder(UrlPreviewResponse.BUILDER).listener(new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<UrlPreviewResponse> paramAnonymousDataStoreResponse)
      {
        if (error != null)
        {
          Log.e(UrlPreviewGetter.TAG, "Could not fetch article preview", error);
          val$listener.onError();
        }
        do
        {
          return;
          paramAnonymousDataStoreResponse = model).value;
        } while (previewCreationSuccessfulValue == null);
        paramAnonymousDataStoreResponse = previewCreationSuccessfulValue.data;
        val$listener.onUrlPreview(paramAnonymousDataStoreResponse);
      }
    }).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
  
  public static abstract interface Listener
  {
    public abstract void onError();
    
    public abstract void onUrlPreview(UrlPreviewData paramUrlPreviewData);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.UrlPreviewGetter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */