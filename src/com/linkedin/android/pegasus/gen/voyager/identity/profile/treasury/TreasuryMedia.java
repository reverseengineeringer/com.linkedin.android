package com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TreasuryMedia
  implements FissileDataModel<TreasuryMedia>, RecordTemplate<TreasuryMedia>
{
  public static final TreasuryMediaBuilder BUILDER = TreasuryMediaBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String customDescription;
  public final String customTitle;
  public final Data data;
  public final String description;
  public final Urn entityUrn;
  public final boolean hasCustomDescription;
  public final boolean hasCustomTitle;
  public final boolean hasData;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasTitle;
  public final String title;
  
  TreasuryMedia(Urn paramUrn, String paramString1, String paramString2, String paramString3, String paramString4, Data paramData, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    entityUrn = paramUrn;
    customTitle = paramString1;
    customDescription = paramString2;
    title = paramString3;
    description = paramString4;
    data = paramData;
    hasEntityUrn = paramBoolean1;
    hasCustomTitle = paramBoolean2;
    hasCustomDescription = paramBoolean3;
    hasTitle = paramBoolean4;
    hasDescription = paramBoolean5;
    hasData = paramBoolean6;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  public final TreasuryMedia accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasCustomTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("customTitle");
      paramDataProcessor.processString(customTitle);
    }
    if (hasCustomDescription)
    {
      paramDataProcessor.startRecordField$505cff1c("customDescription");
      paramDataProcessor.processString(customDescription);
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
    Object localObject = null;
    boolean bool = false;
    if (hasData)
    {
      paramDataProcessor.startRecordField$505cff1c("data");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label225;
      }
      localObject = data.accept(paramDataProcessor);
      if (localObject == null) {
        break label242;
      }
    }
    label225:
    label242:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label316;
      }
      try
      {
        if (hasEntityUrn) {
          break label247;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (Data)paramDataProcessor.processDataTemplate(data);
      break;
    }
    label247:
    if (!hasData) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia", "data");
    }
    return new TreasuryMedia(entityUrn, customTitle, customDescription, title, description, (Data)localObject, hasEntityUrn, hasCustomTitle, hasCustomDescription, hasTitle, hasDescription, bool);
    label316:
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
      paramObject = (TreasuryMedia)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (customTitle != null)
      {
        if (customTitle.equals(customTitle)) {}
      }
      else {
        while (customTitle != null) {
          return false;
        }
      }
      if (customDescription != null)
      {
        if (customDescription.equals(customDescription)) {}
      }
      else {
        while (customDescription != null) {
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
      if (data == null) {
        break;
      }
    } while (data.equals(data));
    for (;;)
    {
      return false;
      if (data == null) {
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
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCustomTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(customTitle);
    }
    j = i + 1;
    i = j;
    if (hasCustomDescription) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(customDescription);
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
    if (hasData)
    {
      i = j + 1;
      if (data._cachedId == null) {
        break label194;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(data._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label194:
      i += data.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (customTitle == null) {
        break label154;
      }
      j = customTitle.hashCode();
      if (customDescription == null) {
        break label159;
      }
      k = customDescription.hashCode();
      if (title == null) {
        break label164;
      }
      m = title.hashCode();
      label76:
      if (description == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = description.hashCode();; n = 0)
    {
      if (data != null) {
        i1 = data.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TreasuryMedia");
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
    label170:
    label196:
    label222:
    label248:
    label351:
    label361:
    label371:
    label381:
    label391:
    label416:
    label424:
    label426:
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
        localByteBuffer.putInt(-2080712291);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasCustomTitle) {
            break label351;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, customTitle);
          if (!hasCustomDescription) {
            break label361;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, customDescription);
          if (!hasTitle) {
            break label371;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasDescription) {
            break label381;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasData) {
            break label416;
          }
          localByteBuffer.put((byte)1);
          if (data._cachedId == null) {
            break label391;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, data._cachedId);
          data.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label424;
          }
          if (str != null) {
            break label426;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)0);
          break label196;
          localByteBuffer.put((byte)0);
          break label222;
          localByteBuffer.put((byte)0);
          break label248;
          localByteBuffer.put((byte)1);
          data.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
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
    implements RecordTemplateBuilder<TreasuryMedia>
  {
    private String customDescription = null;
    private String customTitle = null;
    public TreasuryMedia.Data data = null;
    private String description = null;
    private Urn entityUrn = null;
    private boolean hasCustomDescription = false;
    private boolean hasCustomTitle = false;
    public boolean hasData = false;
    private boolean hasDescription = false;
    private boolean hasEntityUrn = false;
    private boolean hasTitle = false;
    private String title = null;
    
    public Builder() {}
    
    public Builder(TreasuryMedia paramTreasuryMedia)
    {
      entityUrn = entityUrn;
      customTitle = customTitle;
      customDescription = customDescription;
      title = title;
      description = description;
      data = data;
      hasEntityUrn = hasEntityUrn;
      hasCustomTitle = hasCustomTitle;
      hasCustomDescription = hasCustomDescription;
      hasTitle = hasTitle;
      hasDescription = hasDescription;
      hasData = hasData;
    }
    
    public final TreasuryMedia build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (TreasuryMedia.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new TreasuryMedia(entityUrn, customTitle, customDescription, title, description, data, hasEntityUrn, hasCustomTitle, hasCustomDescription, hasTitle, hasDescription, hasData);
        if (!hasEntityUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia", "entityUrn");
        }
      } while (hasData);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia", "data");
    }
    
    public final Builder setCustomDescription(String paramString)
    {
      if (paramString == null)
      {
        hasCustomDescription = false;
        customDescription = null;
        return this;
      }
      hasCustomDescription = true;
      customDescription = paramString;
      return this;
    }
    
    public final Builder setCustomTitle(String paramString)
    {
      if (paramString == null)
      {
        hasCustomTitle = false;
        customTitle = null;
        return this;
      }
      hasCustomTitle = true;
      customTitle = paramString;
      return this;
    }
    
    public final Builder setEntityUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasEntityUrn = false;
        entityUrn = null;
        return this;
      }
      hasEntityUrn = true;
      entityUrn = paramUrn;
      return this;
    }
  }
  
  public static final class Data
    implements FissileDataModel<Data>, UnionTemplate<Data>
  {
    public static final TreasuryMediaBuilder.DataBuilder BUILDER = TreasuryMediaBuilder.DataBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasLinkValue;
    public final boolean hasMediaProxyImageValue;
    public final boolean hasRichTextValue;
    public final boolean hasVideoValue;
    public final Link linkValue;
    public final MediaProxyImage mediaProxyImageValue;
    public final RichText richTextValue;
    public final Video videoValue;
    
    public Data(Video paramVideo, MediaProxyImage paramMediaProxyImage, RichText paramRichText, Link paramLink, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      videoValue = paramVideo;
      mediaProxyImageValue = paramMediaProxyImage;
      richTextValue = paramRichText;
      linkValue = paramLink;
      hasVideoValue = paramBoolean1;
      hasMediaProxyImageValue = paramBoolean2;
      hasRichTextValue = paramBoolean3;
      hasLinkValue = paramBoolean4;
      _cachedId = null;
    }
    
    public final Data accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label56:
      Object localObject3;
      boolean bool2;
      label95:
      label106:
      Object localObject4;
      boolean bool3;
      if (hasVideoValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.treasury.Video");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = videoValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label261;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasMediaProxyImageValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.MediaProxyImage");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label270;
          }
          localObject1 = mediaProxyImageValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label288;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        localObject4 = null;
        bool3 = false;
        if (hasRichTextValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.treasury.RichText");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label297;
          }
          localObject1 = richTextValue.accept(paramDataProcessor);
          label146:
          if (localObject1 == null) {
            break label315;
          }
          bool3 = true;
          localObject4 = localObject1;
        }
        label158:
        localObject1 = null;
        bool4 = false;
        if (hasLinkValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.treasury.Link");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label325;
          }
          localObject1 = linkValue.accept(paramDataProcessor);
          label198:
          if (localObject1 == null) {
            break label343;
          }
        }
      }
      label261:
      label270:
      label288:
      label297:
      label315:
      label325:
      label343:
      for (boolean bool4 = true;; bool4 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label349;
        }
        return new Data((Video)localObject2, (MediaProxyImage)localObject3, (RichText)localObject4, (Link)localObject1, bool1, bool2, bool3, bool4);
        localObject1 = (Video)paramDataProcessor.processDataTemplate(videoValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (MediaProxyImage)paramDataProcessor.processDataTemplate(mediaProxyImageValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (RichText)paramDataProcessor.processDataTemplate(richTextValue);
        break label146;
        bool3 = false;
        localObject4 = localObject1;
        break label158;
        localObject1 = (Link)paramDataProcessor.processDataTemplate(linkValue);
        break label198;
      }
      label349:
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
        paramObject = (Data)paramObject;
        if (videoValue != null)
        {
          if (videoValue.equals(videoValue)) {}
        }
        else {
          while (videoValue != null) {
            return false;
          }
        }
        if (mediaProxyImageValue != null)
        {
          if (mediaProxyImageValue.equals(mediaProxyImageValue)) {}
        }
        else {
          while (mediaProxyImageValue != null) {
            return false;
          }
        }
        if (richTextValue != null)
        {
          if (richTextValue.equals(richTextValue)) {}
        }
        else {
          while (richTextValue != null) {
            return false;
          }
        }
        if (linkValue == null) {
          break;
        }
      } while (linkValue.equals(linkValue));
      for (;;)
      {
        return false;
        if (linkValue == null) {
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
      if (hasVideoValue)
      {
        if (videoValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(videoValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasMediaProxyImageValue)
        {
          i = j + 1;
          if (mediaProxyImageValue._cachedId == null) {
            break label198;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(mediaProxyImageValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasRichTextValue)
        {
          i = j + 1;
          if (richTextValue._cachedId == null) {
            break label211;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(richTextValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasLinkValue)
        {
          i = j + 1;
          if (linkValue._cachedId == null) {
            break label224;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(linkValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = videoValue.getSerializedSize() + 7;
        break;
        label198:
        i += mediaProxyImageValue.getSerializedSize();
        break label93;
        label211:
        i += richTextValue.getSerializedSize();
        break label135;
        label224:
        i += linkValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int m = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      int i;
      int j;
      if (videoValue != null)
      {
        i = videoValue.hashCode();
        if (mediaProxyImageValue == null) {
          break label110;
        }
        j = mediaProxyImageValue.hashCode();
        label45:
        if (richTextValue == null) {
          break label115;
        }
      }
      label110:
      label115:
      for (int k = richTextValue.hashCode();; k = 0)
      {
        if (linkValue != null) {
          m = linkValue.hashCode();
        }
        i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
        _cachedHashCode = i;
        return i;
        i = 0;
        break;
        j = 0;
        break label45;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Data");
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
      label230:
      label290:
      label418:
      label443:
      label453:
      label478:
      label488:
      label513:
      label521:
      label523:
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
          localByteBuffer.putInt(-1333573818);
          if (hasVideoValue)
          {
            localByteBuffer.put((byte)1);
            if (videoValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, videoValue._cachedId);
              videoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMediaProxyImageValue) {
                break label443;
              }
              localByteBuffer.put((byte)1);
              if (mediaProxyImageValue._cachedId == null) {
                break label418;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, mediaProxyImageValue._cachedId);
              mediaProxyImageValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasRichTextValue) {
                break label478;
              }
              localByteBuffer.put((byte)1);
              if (richTextValue._cachedId == null) {
                break label453;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, richTextValue._cachedId);
              richTextValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasLinkValue) {
                break label513;
              }
              localByteBuffer.put((byte)1);
              if (linkValue._cachedId == null) {
                break label488;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, linkValue._cachedId);
              linkValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label521;
            }
            if (str != null) {
              break label523;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            videoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            mediaProxyImageValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            richTextValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label290;
            localByteBuffer.put((byte)0);
            break label290;
            localByteBuffer.put((byte)1);
            linkValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            continue;
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
    {
      public boolean hasLinkValue = false;
      public boolean hasMediaProxyImageValue = false;
      public boolean hasRichTextValue = false;
      public boolean hasVideoValue = false;
      public Link linkValue = null;
      public MediaProxyImage mediaProxyImageValue = null;
      public RichText richTextValue = null;
      public Video videoValue = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */