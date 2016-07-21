package com.linkedin.android.pegasus.gen.voyager.feed.urlpreview;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class UrlPreviewData
  implements FissileDataModel<UrlPreviewData>, RecordTemplate<UrlPreviewData>
{
  public static final UrlPreviewDataBuilder BUILDER = UrlPreviewDataBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String description;
  public final boolean hasDescription;
  public final boolean hasId;
  public final boolean hasPreviewImages;
  public final boolean hasResolvedUrl;
  public final boolean hasSource;
  public final boolean hasTitle;
  public final boolean hasType;
  public final boolean hasUrl;
  public final boolean hasUrn;
  public final String id;
  public final List<PreviewImage> previewImages;
  public final String resolvedUrl;
  public final String source;
  public final String title;
  public final String type;
  public final String url;
  public final Urn urn;
  
  UrlPreviewData(String paramString1, String paramString2, Urn paramUrn, List<PreviewImage> paramList, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    id = paramString1;
    type = paramString2;
    urn = paramUrn;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      previewImages = paramString1;
      url = paramString3;
      resolvedUrl = paramString4;
      title = paramString5;
      description = paramString6;
      source = paramString7;
      hasId = paramBoolean1;
      hasType = paramBoolean2;
      hasUrn = paramBoolean3;
      hasPreviewImages = paramBoolean4;
      hasUrl = paramBoolean5;
      hasResolvedUrl = paramBoolean6;
      hasTitle = paramBoolean7;
      hasDescription = paramBoolean8;
      hasSource = paramBoolean9;
      _cachedId = null;
      return;
    }
  }
  
  public final UrlPreviewData accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasId)
    {
      paramDataProcessor.startRecordField$505cff1c("id");
      paramDataProcessor.processString(id);
    }
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processString(type);
    }
    if (hasUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("urn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(urn));
    }
    Object localObject = null;
    PreviewImage localPreviewImage = null;
    boolean bool = false;
    if (hasPreviewImages)
    {
      paramDataProcessor.startRecordField$505cff1c("previewImages");
      previewImages.size();
      paramDataProcessor.startArray$13462e();
      localObject = localPreviewImage;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = previewImages.iterator();
      if (localIterator.hasNext())
      {
        localPreviewImage = (PreviewImage)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localPreviewImage = localPreviewImage.accept(paramDataProcessor);; localPreviewImage = (PreviewImage)paramDataProcessor.processDataTemplate(localPreviewImage))
        {
          if ((localObject != null) && (localPreviewImage != null)) {
            ((List)localObject).add(localPreviewImage);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label446;
      }
    }
    label446:
    for (bool = true;; bool = false)
    {
      if (hasUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("url");
        paramDataProcessor.processString(url);
      }
      if (hasResolvedUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("resolvedUrl");
        paramDataProcessor.processString(resolvedUrl);
      }
      if (hasTitle)
      {
        paramDataProcessor.startRecordField$505cff1c("title");
        paramDataProcessor.processString(title);
      }
      if (hasDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("description");
        paramDataProcessor.processString(description);
      }
      if (hasSource)
      {
        paramDataProcessor.startRecordField$505cff1c("source");
        paramDataProcessor.processString(source);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label633;
      }
      if (!hasPreviewImages) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (hasUrn) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData", "urn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasUrl) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData", "url");
    }
    if (!hasResolvedUrl) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData", "resolvedUrl");
    }
    if (!hasSource) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData", "source");
    }
    if (previewImages != null)
    {
      paramDataProcessor = previewImages.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PreviewImage)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData", "previewImages");
        }
      }
    }
    return new UrlPreviewData(id, type, urn, (List)localObject, url, resolvedUrl, title, description, source, hasId, hasType, hasUrn, bool, hasUrl, hasResolvedUrl, hasTitle, hasDescription, hasSource);
    label633:
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (UrlPreviewData)paramObject;
      if (id != null)
      {
        if (id.equals(id)) {}
      }
      else {
        while (id != null) {
          return false;
        }
      }
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (urn != null)
      {
        if (urn.equals(urn)) {}
      }
      else {
        while (urn != null) {
          return false;
        }
      }
      if (previewImages != null)
      {
        if (previewImages.equals(previewImages)) {}
      }
      else {
        while (previewImages != null) {
          return false;
        }
      }
      if (url != null)
      {
        if (url.equals(url)) {}
      }
      else {
        while (url != null) {
          return false;
        }
      }
      if (resolvedUrl != null)
      {
        if (resolvedUrl.equals(resolvedUrl)) {}
      }
      else {
        while (resolvedUrl != null) {
          return false;
        }
      }
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (description != null)
      {
        if (description.equals(description)) {}
      }
      else {
        while (description != null) {
          return false;
        }
      }
      if (source == null) {
        break;
      }
    } while (source.equals(source));
    for (;;)
    {
      return false;
      if (source == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasId) {
      i = PegasusBinaryUtils.getEncodedLength(id) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasType) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(type);
    }
    j = i + 1;
    i = j;
    Object localObject;
    if (hasUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(urn));
    }
    i += 1;
    j = i;
    if (hasPreviewImages)
    {
      i += 2;
      localObject = previewImages.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        PreviewImage localPreviewImage = (PreviewImage)((Iterator)localObject).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localPreviewImage.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
    }
    j = i + 1;
    i = j;
    if (hasResolvedUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(resolvedUrl);
    }
    j = i + 1;
    i = j;
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    j = i + 1;
    i = j;
    if (hasDescription) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
    }
    j = i + 1;
    i = j;
    if (hasSource) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(source);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int i4 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label78:
    int n;
    label94:
    int i1;
    label110:
    int i2;
    if (id != null)
    {
      i = id.hashCode();
      if (type == null) {
        break label222;
      }
      j = type.hashCode();
      if (urn == null) {
        break label227;
      }
      k = urn.hashCode();
      if (previewImages == null) {
        break label232;
      }
      m = previewImages.hashCode();
      if (url == null) {
        break label238;
      }
      n = url.hashCode();
      if (resolvedUrl == null) {
        break label244;
      }
      i1 = resolvedUrl.hashCode();
      if (title == null) {
        break label250;
      }
      i2 = title.hashCode();
      label126:
      if (description == null) {
        break label256;
      }
    }
    label222:
    label227:
    label232:
    label238:
    label244:
    label250:
    label256:
    for (int i3 = description.hashCode();; i3 = 0)
    {
      if (source != null) {
        i4 = source.hashCode();
      }
      i = (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label78;
      n = 0;
      break label94;
      i1 = 0;
      break label110;
      i2 = 0;
      break label126;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building UrlPreviewData");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label164:
    label198:
    label315:
    label325:
    label358:
    label365:
    label417:
    label443:
    label469:
    label538:
    label548:
    label558:
    label568:
    label576:
    label578:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-1606867065);
        Object localObject;
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasType) {
            break label315;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, type);
          if (!hasUrn) {
            break label325;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasPreviewImages) {
            break label358;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, previewImages.size());
          localObject = previewImages.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label365;
          }
          PreviewImage localPreviewImage = (PreviewImage)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localPreviewImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label164;
            localByteBuffer.put((byte)0);
            break label198;
          }
          localByteBuffer.put((byte)1);
          localPreviewImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasUrl)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasResolvedUrl) {
            break label538;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, resolvedUrl);
          if (!hasTitle) {
            break label548;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasDescription) {
            break label558;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasSource) {
            break label568;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, source);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label576;
          }
          if (str != null) {
            break label578;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label417;
          localByteBuffer.put((byte)0);
          break label443;
          localByteBuffer.put((byte)0);
          break label469;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
  
  public static final class Builder
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
    
    public Builder() {}
    
    public Builder(UrlPreviewData paramUrlPreviewData)
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */