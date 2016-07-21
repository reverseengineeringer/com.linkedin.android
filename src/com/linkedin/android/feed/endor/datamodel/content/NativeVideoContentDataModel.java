package com.linkedin.android.feed.endor.datamodel.content;

import com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadata;
import com.linkedin.android.pegasus.gen.videocontent.Thumbnail;
import com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import java.util.List;

public final class NativeVideoContentDataModel
  extends AnnotatedTextContentDataModel
{
  public int height;
  public String thumbnailUrl;
  public String url;
  public VideoPlayMetadata videoPlayMetadata;
  public int width;
  
  public NativeVideoContentDataModel(String paramString, VideoPlayMetadata paramVideoPlayMetadata, AnnotatedText paramAnnotatedText)
  {
    super(paramAnnotatedText);
    url = paramString;
    videoPlayMetadata = paramVideoPlayMetadata;
    paramString = progressiveStreams;
    if (!paramString.isEmpty())
    {
      paramString = (ProgressiveDownloadMetadata)paramString.get(0);
      width = width;
      height = height;
      if (thumbnail != null) {
        thumbnailUrl = thumbnail.url;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.content.NativeVideoContentDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */