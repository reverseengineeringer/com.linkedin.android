package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Post
  implements FissileDataModel<Post>, RecordTemplate<Post>
{
  public static final PostBuilder BUILDER = PostBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Date createdDate;
  public final Urn entityUrn;
  public final boolean hasCreatedDate;
  public final boolean hasEntityUrn;
  public final boolean hasImage;
  public final boolean hasNumComments;
  public final boolean hasNumLikes;
  public final boolean hasNumViews;
  public final boolean hasPermaLink;
  public final boolean hasPostedDate;
  public final boolean hasTitle;
  public final Image image;
  public final int numComments;
  public final int numLikes;
  public final long numViews;
  public final String permaLink;
  public final Date postedDate;
  public final String title;
  
  Post(Urn paramUrn, String paramString1, String paramString2, Image paramImage, Date paramDate1, Date paramDate2, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    entityUrn = paramUrn;
    title = paramString1;
    permaLink = paramString2;
    image = paramImage;
    createdDate = paramDate1;
    postedDate = paramDate2;
    numLikes = paramInt1;
    numViews = paramLong;
    numComments = paramInt2;
    hasEntityUrn = paramBoolean1;
    hasTitle = paramBoolean2;
    hasPermaLink = paramBoolean3;
    hasImage = paramBoolean4;
    hasCreatedDate = paramBoolean5;
    hasPostedDate = paramBoolean6;
    hasNumLikes = paramBoolean7;
    hasNumViews = paramBoolean8;
    hasNumComments = paramBoolean9;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private Post accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasPermaLink)
    {
      paramDataProcessor.startRecordField$505cff1c("permaLink");
      paramDataProcessor.processString(permaLink);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label139:
    Object localObject3;
    boolean bool2;
    if (hasImage)
    {
      paramDataProcessor.startRecordField$505cff1c("image");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = image.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label374;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasCreatedDate)
      {
        paramDataProcessor.startRecordField$505cff1c("createdDate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label383;
        }
        localObject1 = createdDate.accept(paramDataProcessor);
        label178:
        if (localObject1 == null) {
          break label401;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label189:
      localObject1 = null;
      bool3 = false;
      if (hasPostedDate)
      {
        paramDataProcessor.startRecordField$505cff1c("postedDate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label410;
        }
        localObject1 = postedDate.accept(paramDataProcessor);
        label229:
        if (localObject1 == null) {
          break label428;
        }
      }
    }
    label374:
    label383:
    label401:
    label410:
    label428:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasNumLikes)
      {
        paramDataProcessor.startRecordField$505cff1c("numLikes");
        paramDataProcessor.processInt(numLikes);
      }
      if (hasNumViews)
      {
        paramDataProcessor.startRecordField$505cff1c("numViews");
        paramDataProcessor.processLong(numViews);
      }
      if (hasNumComments)
      {
        paramDataProcessor.startRecordField$505cff1c("numComments");
        paramDataProcessor.processInt(numComments);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label557;
      }
      try
      {
        if (hasTitle) {
          break label434;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Post", "title");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (Image)paramDataProcessor.processDataTemplate(image);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label139;
      localObject1 = (Date)paramDataProcessor.processDataTemplate(createdDate);
      break label178;
      bool2 = false;
      localObject3 = localObject1;
      break label189;
      localObject1 = (Date)paramDataProcessor.processDataTemplate(postedDate);
      break label229;
    }
    label434:
    if (!hasPermaLink) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Post", "permaLink");
    }
    if (!hasImage) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Post", "image");
    }
    if (!hasCreatedDate) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Post", "createdDate");
    }
    return new Post(entityUrn, title, permaLink, (Image)localObject2, (Date)localObject3, (Date)localObject1, numLikes, numViews, numComments, hasEntityUrn, hasTitle, hasPermaLink, bool1, bool2, bool3, hasNumLikes, hasNumViews, hasNumComments);
    label557:
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
      paramObject = (Post)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
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
      if (permaLink != null)
      {
        if (permaLink.equals(permaLink)) {}
      }
      else {
        while (permaLink != null) {
          return false;
        }
      }
      if (image != null)
      {
        if (image.equals(image)) {}
      }
      else {
        while (image != null) {
          return false;
        }
      }
      if (createdDate != null)
      {
        if (createdDate.equals(createdDate)) {}
      }
      else {
        while (createdDate != null) {
          return false;
        }
      }
      if (postedDate != null)
      {
        if (postedDate.equals(postedDate)) {}
      }
      else {
        while (postedDate != null) {
          return false;
        }
      }
      if (numLikes != numLikes) {
        return false;
      }
      if (numViews != numViews) {
        return false;
      }
    } while (numComments == numComments);
    return false;
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
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    j = i + 1;
    i = j;
    if (hasPermaLink) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(permaLink);
    }
    j = i + 1;
    i = j;
    if (hasImage)
    {
      i = j + 1;
      if (image._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(image._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasCreatedDate)
      {
        i = j + 1;
        if (createdDate._cachedId == null) {
          break label293;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(createdDate._cachedId);
      }
      label179:
      j = i + 1;
      i = j;
      if (hasPostedDate)
      {
        i = j + 1;
        if (postedDate._cachedId == null) {
          break label306;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(postedDate._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasNumLikes) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasNumViews) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasNumComments) {
        i = j + 4;
      }
      __sizeOfObject = i;
      return i;
      i += image.getSerializedSize();
      break;
      label293:
      i += createdDate.getSerializedSize();
      break label179;
      label306:
      i += postedDate.getSerializedSize();
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
      if (title == null) {
        break label187;
      }
      j = title.hashCode();
      if (permaLink == null) {
        break label192;
      }
      k = permaLink.hashCode();
      if (image == null) {
        break label197;
      }
      m = image.hashCode();
      label76:
      if (createdDate == null) {
        break label203;
      }
    }
    label187:
    label192:
    label197:
    label203:
    for (int n = createdDate.hashCode();; n = 0)
    {
      if (postedDate != null) {
        i1 = postedDate.hashCode();
      }
      i = ((((n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1) * 31 + numLikes) * 31 + (int)(numViews ^ numViews >>> 32)) * 31 + numComments;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Post");
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
    label256:
    label316:
    label376:
    label400:
    label424:
    label491:
    label501:
    label511:
    label536:
    label546:
    label571:
    label581:
    label606:
    label616:
    label626:
    label636:
    label644:
    label646:
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
        localByteBuffer.putInt(1623984767);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasTitle) {
            break label491;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasPermaLink) {
            break label501;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, permaLink);
          if (!hasImage) {
            break label536;
          }
          localByteBuffer.put((byte)1);
          if (image._cachedId == null) {
            break label511;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
          image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCreatedDate) {
            break label571;
          }
          localByteBuffer.put((byte)1);
          if (createdDate._cachedId == null) {
            break label546;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, createdDate._cachedId);
          createdDate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPostedDate) {
            break label606;
          }
          localByteBuffer.put((byte)1);
          if (postedDate._cachedId == null) {
            break label581;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, postedDate._cachedId);
          postedDate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasNumLikes) {
            break label616;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numLikes);
          if (!hasNumViews) {
            break label626;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numViews);
          if (!hasNumComments) {
            break label636;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numComments);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label644;
          }
          if (str != null) {
            break label646;
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
          localByteBuffer.put((byte)1);
          image.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label256;
          localByteBuffer.put((byte)0);
          break label256;
          localByteBuffer.put((byte)1);
          createdDate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label316;
          localByteBuffer.put((byte)0);
          break label316;
          localByteBuffer.put((byte)1);
          postedDate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label376;
          localByteBuffer.put((byte)0);
          break label376;
          localByteBuffer.put((byte)0);
          break label400;
          localByteBuffer.put((byte)0);
          break label424;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Post
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */