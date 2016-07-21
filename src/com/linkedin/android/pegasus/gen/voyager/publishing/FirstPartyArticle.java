package com.linkedin.android.pegasus.gen.voyager.publishing;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class FirstPartyArticle
  implements FissileDataModel<FirstPartyArticle>, RecordTemplate<FirstPartyArticle>
{
  public static final FirstPartyArticleBuilder BUILDER = FirstPartyArticleBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<FirstPartyAuthor> authors;
  public final String contentHtml;
  public final List<ContentTag> contentTags;
  public final CoverMedia coverMedia;
  public final Urn entityUrn;
  public final boolean hasAuthors;
  public final boolean hasContentHtml;
  public final boolean hasContentTags;
  public final boolean hasCoverMedia;
  public final boolean hasEntityUrn;
  public final boolean hasLinkedInArticleUrn;
  public final boolean hasPermalink;
  public final boolean hasPublishedAt;
  public final boolean hasState;
  public final boolean hasTitle;
  public final Urn linkedInArticleUrn;
  public final String permalink;
  public final long publishedAt;
  public final ArticleState state;
  public final String title;
  
  FirstPartyArticle(Urn paramUrn1, Urn paramUrn2, String paramString1, List<FirstPartyAuthor> paramList, ArticleState paramArticleState, String paramString2, CoverMedia paramCoverMedia, String paramString3, long paramLong, List<ContentTag> paramList1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    entityUrn = paramUrn1;
    linkedInArticleUrn = paramUrn2;
    title = paramString1;
    if (paramList == null)
    {
      paramUrn2 = null;
      authors = paramUrn2;
      state = paramArticleState;
      permalink = paramString2;
      coverMedia = paramCoverMedia;
      contentHtml = paramString3;
      publishedAt = paramLong;
      if (paramList1 != null) {
        break label165;
      }
    }
    label165:
    for (paramUrn2 = null;; paramUrn2 = Collections.unmodifiableList(paramList1))
    {
      contentTags = paramUrn2;
      hasEntityUrn = paramBoolean1;
      hasLinkedInArticleUrn = paramBoolean2;
      hasTitle = paramBoolean3;
      hasAuthors = paramBoolean4;
      hasState = paramBoolean5;
      hasPermalink = paramBoolean6;
      hasCoverMedia = paramBoolean7;
      hasContentHtml = paramBoolean8;
      hasPublishedAt = paramBoolean9;
      hasContentTags = paramBoolean10;
      paramUrn2 = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
      return;
      paramUrn2 = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  public final FirstPartyArticle accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasLinkedInArticleUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("linkedInArticleUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(linkedInArticleUrn));
    }
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    int i;
    Object localObject3;
    boolean bool2;
    if (hasAuthors)
    {
      paramDataProcessor.startRecordField$505cff1c("authors");
      authors.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = authors.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (FirstPartyAuthor)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((FirstPartyAuthor)localObject2).accept(paramDataProcessor);; localObject2 = (FirstPartyAuthor)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null)
      {
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasState)
      {
        paramDataProcessor.startRecordField$505cff1c("state");
        paramDataProcessor.processEnum(state);
      }
      if (hasPermalink)
      {
        paramDataProcessor.startRecordField$505cff1c("permalink");
        paramDataProcessor.processString(permalink);
      }
      localObject3 = null;
      bool2 = false;
      if (hasCoverMedia)
      {
        paramDataProcessor.startRecordField$505cff1c("coverMedia");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label582;
        }
        localObject1 = coverMedia.accept(paramDataProcessor);
        label363:
        if (localObject1 == null) {
          break label600;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label375:
      if (hasContentHtml)
      {
        paramDataProcessor.startRecordField$505cff1c("contentHtml");
        paramDataProcessor.processString(contentHtml);
      }
      if (hasPublishedAt)
      {
        paramDataProcessor.startRecordField$505cff1c("publishedAt");
        paramDataProcessor.processLong(publishedAt);
      }
      localObject1 = null;
      localContentTag = null;
      bool3 = false;
      if (!hasContentTags) {
        break label640;
      }
      paramDataProcessor.startRecordField$505cff1c("contentTags");
      contentTags.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localContentTag;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = contentTags.iterator();
      label500:
      if (!localIterator.hasNext()) {
        break label626;
      }
      localContentTag = (ContentTag)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label610;
      }
    }
    label582:
    label600:
    label610:
    for (ContentTag localContentTag = localContentTag.accept(paramDataProcessor);; localContentTag = (ContentTag)paramDataProcessor.processDataTemplate(localContentTag))
    {
      if ((localObject1 != null) && (localContentTag != null)) {
        ((List)localObject1).add(localContentTag);
      }
      i += 1;
      break label500;
      bool1 = false;
      localObject2 = localObject1;
      break;
      localObject1 = (CoverMedia)paramDataProcessor.processDataTemplate(coverMedia);
      break label363;
      bool2 = false;
      localObject3 = localObject1;
      break label375;
    }
    label626:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      label640:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label953;
      }
      if (!hasContentTags) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasEntityUrn) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasLinkedInArticleUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle", "linkedInArticleUrn");
    }
    if (!hasTitle) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle", "title");
    }
    if (!hasAuthors) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle", "authors");
    }
    if (!hasState) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle", "state");
    }
    if (authors != null)
    {
      paramDataProcessor = authors.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((FirstPartyAuthor)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle", "authors");
        }
      }
    }
    if (contentTags != null)
    {
      paramDataProcessor = contentTags.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((ContentTag)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle", "contentTags");
        }
      }
    }
    return new FirstPartyArticle(entityUrn, linkedInArticleUrn, title, (List)localObject2, state, permalink, (CoverMedia)localObject3, contentHtml, publishedAt, (List)localObject1, hasEntityUrn, hasLinkedInArticleUrn, hasTitle, bool1, hasState, hasPermalink, bool2, hasContentHtml, hasPublishedAt, bool3);
    label953:
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
      paramObject = (FirstPartyArticle)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (linkedInArticleUrn != null)
      {
        if (linkedInArticleUrn.equals(linkedInArticleUrn)) {}
      }
      else {
        while (linkedInArticleUrn != null) {
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
      if (authors != null)
      {
        if (authors.equals(authors)) {}
      }
      else {
        while (authors != null) {
          return false;
        }
      }
      if (state != null)
      {
        if (state.equals(state)) {}
      }
      else {
        while (state != null) {
          return false;
        }
      }
      if (permalink != null)
      {
        if (permalink.equals(permalink)) {}
      }
      else {
        while (permalink != null) {
          return false;
        }
      }
      if (coverMedia != null)
      {
        if (coverMedia.equals(coverMedia)) {}
      }
      else {
        while (coverMedia != null) {
          return false;
        }
      }
      if (contentHtml != null)
      {
        if (contentHtml.equals(contentHtml)) {}
      }
      else {
        while (contentHtml != null) {
          return false;
        }
      }
      if (publishedAt != publishedAt) {
        return false;
      }
      if (contentTags == null) {
        break;
      }
    } while (contentTags.equals(contentTags));
    for (;;)
    {
      return false;
      if (contentTags == null) {
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
    Object localObject1;
    if (hasEntityUrn)
    {
      localObject1 = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasLinkedInArticleUrn)
    {
      localObject1 = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(linkedInArticleUrn));
    }
    j = i + 1;
    i = j;
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    i += 1;
    j = i;
    Object localObject2;
    if (hasAuthors)
    {
      i += 2;
      localObject1 = authors.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (FirstPartyAuthor)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((FirstPartyAuthor)localObject2).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasState) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasPermalink) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(permalink);
    }
    j = i + 1;
    i = j;
    if (hasCoverMedia)
    {
      i = j + 1;
      if (coverMedia._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(coverMedia._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasContentHtml) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(contentHtml);
      }
      j = i + 1;
      i = j;
      if (hasPublishedAt) {
        i = j + 8;
      }
      i += 1;
      j = i;
      if (!hasContentTags) {
        break label418;
      }
      i += 2;
      localObject1 = contentTags.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label418;
      }
      localObject2 = (ContentTag)((Iterator)localObject1).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += coverMedia.getSerializedSize();
        break;
      }
      i += ((ContentTag)localObject2).getSerializedSize();
    }
    label418:
    __sizeOfObject = j;
    return j;
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
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (linkedInArticleUrn == null) {
        break label245;
      }
      j = linkedInArticleUrn.hashCode();
      if (title == null) {
        break label250;
      }
      k = title.hashCode();
      if (authors == null) {
        break label255;
      }
      m = authors.hashCode();
      if (state == null) {
        break label261;
      }
      n = state.hashCode();
      if (permalink == null) {
        break label267;
      }
      i1 = permalink.hashCode();
      if (coverMedia == null) {
        break label273;
      }
      i2 = coverMedia.hashCode();
      label126:
      if (contentHtml == null) {
        break label279;
      }
    }
    label245:
    label250:
    label255:
    label261:
    label267:
    label273:
    label279:
    for (int i3 = contentHtml.hashCode();; i3 = 0)
    {
      int i5 = (int)(publishedAt ^ publishedAt >>> 32);
      if (contentTags != null) {
        i4 = contentTags.hashCode();
      }
      i = ((i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i5) * 31 + i4;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building FirstPartyArticle");
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
    label180:
    label206:
    label323:
    label333:
    label366:
    label373:
    label428:
    label488:
    label514:
    label538:
    label655:
    label665:
    label690:
    label700:
    label710:
    label743:
    label750:
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-1586383506);
        Object localObject1;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject1 = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasLinkedInArticleUrn) {
            break label323;
          }
          localByteBuffer.put((byte)1);
          localObject1 = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(linkedInArticleUrn));
          if (!hasTitle) {
            break label333;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasAuthors) {
            break label366;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, authors.size());
          localObject1 = authors.iterator();
        }
        Object localObject2;
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label373;
          }
          localObject2 = (FirstPartyAuthor)((Iterator)localObject1).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((FirstPartyAuthor)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label180;
            localByteBuffer.put((byte)0);
            break label206;
          }
          localByteBuffer.put((byte)1);
          ((FirstPartyAuthor)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasState)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, state.ordinal());
          if (!hasPermalink) {
            break label655;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, permalink);
          if (!hasCoverMedia) {
            break label690;
          }
          localByteBuffer.put((byte)1);
          if (coverMedia._cachedId == null) {
            break label665;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, coverMedia._cachedId);
          coverMedia.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasContentHtml) {
            break label700;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, contentHtml);
          if (!hasPublishedAt) {
            break label710;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (!hasContentTags) {
            break label743;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, contentTags.size());
          localObject1 = contentTags.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label750;
          }
          localObject2 = (ContentTag)((Iterator)localObject1).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((ContentTag)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label428;
            localByteBuffer.put((byte)1);
            coverMedia.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label488;
            localByteBuffer.put((byte)0);
            break label488;
            localByteBuffer.put((byte)0);
            break label514;
            localByteBuffer.put((byte)0);
            break label538;
          }
          localByteBuffer.put((byte)1);
          ((ContentTag)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.publishing.FirstPartyArticle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */