package com.linkedin.android.pegasus.gen.voyager.feed.urlpreview;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class UrlPreviewData$Builder
  implements RecordTemplateBuilder<UrlPreviewData>
{
  public String description = null;
  public boolean hasDescription = false;
  private boolean hasId = false;
  public boolean hasPreviewImages = false;
  public boolean hasResolvedUrl = false;
  public boolean hasSource = false;
  public boolean hasTitle = false;
  private boolean hasType = false;
  private boolean hasUrl = false;
  public boolean hasUrn = false;
  private String id = null;
  public List<PreviewImage> previewImages = null;
  public String resolvedUrl = null;
  public String source = null;
  public String title = null;
  private String type = null;
  private String url = null;
  public Urn urn = null;
  
  public UrlPreviewData$Builder() {}
  
  public UrlPreviewData$Builder(UrlPreviewData paramUrlPreviewData)
  {
    id = id;
    type = type;
    urn = urn;
    previewImages = previewImages;
    url = url;
    resolvedUrl = resolvedUrl;
    title = title;
    description = description;
    source = source;
    hasId = hasId;
    hasType = hasType;
    hasUrn = hasUrn;
    hasPreviewImages = hasPreviewImages;
    hasUrl = hasUrl;
    hasResolvedUrl = hasResolvedUrl;
    hasTitle = hasTitle;
    hasDescription = hasDescription;
    hasSource = hasSource;
  }
  
  public final UrlPreviewData build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (UrlPreviewData.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (previewImages != null)
    {
      paramFlavor = previewImages.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((PreviewImage)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData", "previewImages");
            if (!hasPreviewImages) {
              previewImages = Collections.emptyList();
            }
            if (!hasUrn) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData", "urn");
            }
            if (!hasUrl) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData", "url");
            }
            if (!hasResolvedUrl) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData", "resolvedUrl");
            }
            if (hasSource) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData", "source");
          }
        }
      }
    }
    return new UrlPreviewData(id, type, urn, previewImages, url, resolvedUrl, title, description, source, hasId, hasType, hasUrn, hasPreviewImages, hasUrl, hasResolvedUrl, hasTitle, hasDescription, hasSource);
  }
  
  public final Builder setUrl(String paramString)
  {
    if (paramString == null)
    {
      hasUrl = false;
      url = null;
      return this;
    }
    hasUrl = true;
    url = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */