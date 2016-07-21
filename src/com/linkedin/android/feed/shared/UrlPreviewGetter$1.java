package com.linkedin.android.feed.shared;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.PreviewCreationSuccessful;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewResponse;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewResponse.Value;

final class UrlPreviewGetter$1
  implements RecordTemplateListener<UrlPreviewResponse>
{
  UrlPreviewGetter$1(UrlPreviewGetter.Listener paramListener) {}
  
  public final void onResponse(DataStoreResponse<UrlPreviewResponse> paramDataStoreResponse)
  {
    if (error != null)
    {
      Log.e(UrlPreviewGetter.access$000(), "Could not fetch article preview", error);
      val$listener.onError();
    }
    do
    {
      return;
      paramDataStoreResponse = model).value;
    } while (previewCreationSuccessfulValue == null);
    paramDataStoreResponse = previewCreationSuccessfulValue.data;
    val$listener.onUrlPreview(paramDataStoreResponse);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.UrlPreviewGetter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */