package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MemberFollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchArticle
  implements FissileDataModel<SearchArticle>, RecordTemplate<SearchArticle>
{
  public static final SearchArticleBuilder BUILDER = SearchArticleBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final long authorFollowersCount;
  public final MemberFollowingInfo authorFollowing;
  public final String authorName;
  public final MiniProfile authorProfile;
  public final Urn backendUrn;
  public final AttributedText contentSnippet;
  public final boolean hasAuthorFollowersCount;
  public final boolean hasAuthorFollowing;
  public final boolean hasAuthorName;
  public final boolean hasAuthorProfile;
  public final boolean hasBackendUrn;
  public final boolean hasContentSnippet;
  public final boolean hasImage;
  public final boolean hasParentUrl;
  public final boolean hasPostedAt;
  public final boolean hasSnippet;
  public final boolean hasSocialActivityInfo;
  public final boolean hasTitle;
  public final boolean hasUrl;
  public final Image image;
  public final String parentUrl;
  public final long postedAt;
  public final String snippet;
  public final SocialActivityCounts socialActivityInfo;
  public final String title;
  public final String url;
  
  SearchArticle(Urn paramUrn, String paramString1, String paramString2, String paramString3, long paramLong1, MiniProfile paramMiniProfile, MemberFollowingInfo paramMemberFollowingInfo, Image paramImage, String paramString4, AttributedText paramAttributedText, long paramLong2, String paramString5, SocialActivityCounts paramSocialActivityCounts, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13)
  {
    backendUrn = paramUrn;
    title = paramString1;
    url = paramString2;
    authorName = paramString3;
    authorFollowersCount = paramLong1;
    authorProfile = paramMiniProfile;
    authorFollowing = paramMemberFollowingInfo;
    image = paramImage;
    snippet = paramString4;
    contentSnippet = paramAttributedText;
    postedAt = paramLong2;
    parentUrl = paramString5;
    socialActivityInfo = paramSocialActivityCounts;
    hasBackendUrn = paramBoolean1;
    hasTitle = paramBoolean2;
    hasUrl = paramBoolean3;
    hasAuthorName = paramBoolean4;
    hasAuthorFollowersCount = paramBoolean5;
    hasAuthorProfile = paramBoolean6;
    hasAuthorFollowing = paramBoolean7;
    hasImage = paramBoolean8;
    hasSnippet = paramBoolean9;
    hasContentSnippet = paramBoolean10;
    hasPostedAt = paramBoolean11;
    hasParentUrl = paramBoolean12;
    hasSocialActivityInfo = paramBoolean13;
    _cachedId = null;
  }
  
  public final SearchArticle accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasBackendUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("backendUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(backendUrn));
    }
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("url");
      paramDataProcessor.processString(url);
    }
    if (hasAuthorName)
    {
      paramDataProcessor.startRecordField$505cff1c("authorName");
      paramDataProcessor.processString(authorName);
    }
    if (hasAuthorFollowersCount)
    {
      paramDataProcessor.startRecordField$505cff1c("authorFollowersCount");
      paramDataProcessor.processLong(authorFollowersCount);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label189:
    Object localObject3;
    boolean bool2;
    label228:
    label239:
    Object localObject4;
    boolean bool3;
    label279:
    label291:
    Object localObject5;
    boolean bool4;
    if (hasAuthorProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("authorProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = authorProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label528;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasAuthorFollowing)
      {
        paramDataProcessor.startRecordField$505cff1c("authorFollowing");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label537;
        }
        localObject1 = authorFollowing.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label555;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasImage)
      {
        paramDataProcessor.startRecordField$505cff1c("image");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label564;
        }
        localObject1 = image.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label582;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      if (hasSnippet)
      {
        paramDataProcessor.startRecordField$505cff1c("snippet");
        paramDataProcessor.processString(snippet);
      }
      localObject5 = null;
      bool4 = false;
      if (hasContentSnippet)
      {
        paramDataProcessor.startRecordField$505cff1c("contentSnippet");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label592;
        }
        localObject1 = contentSnippet.accept(paramDataProcessor);
        label356:
        if (localObject1 == null) {
          break label610;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      label368:
      if (hasPostedAt)
      {
        paramDataProcessor.startRecordField$505cff1c("postedAt");
        paramDataProcessor.processLong(postedAt);
      }
      if (hasParentUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("parentUrl");
        paramDataProcessor.processString(parentUrl);
      }
      localObject1 = null;
      bool5 = false;
      if (hasSocialActivityInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("socialActivityInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label620;
        }
        localObject1 = socialActivityInfo.accept(paramDataProcessor);
        label458:
        if (localObject1 == null) {
          break label638;
        }
      }
    }
    label528:
    label537:
    label555:
    label564:
    label582:
    label592:
    label610:
    label620:
    label638:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label734;
      }
      try
      {
        if (hasBackendUrn) {
          break label644;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchArticle", "backendUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(authorProfile);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label189;
      localObject1 = (MemberFollowingInfo)paramDataProcessor.processDataTemplate(authorFollowing);
      break label228;
      bool2 = false;
      localObject3 = localObject1;
      break label239;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(image);
      break label279;
      bool3 = false;
      localObject4 = localObject1;
      break label291;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(contentSnippet);
      break label356;
      bool4 = false;
      localObject5 = localObject1;
      break label368;
      localObject1 = (SocialActivityCounts)paramDataProcessor.processDataTemplate(socialActivityInfo);
      break label458;
    }
    label644:
    return new SearchArticle(backendUrn, title, url, authorName, authorFollowersCount, (MiniProfile)localObject2, (MemberFollowingInfo)localObject3, (Image)localObject4, snippet, (AttributedText)localObject5, postedAt, parentUrl, (SocialActivityCounts)localObject1, hasBackendUrn, hasTitle, hasUrl, hasAuthorName, hasAuthorFollowersCount, bool1, bool2, bool3, hasSnippet, bool4, hasPostedAt, hasParentUrl, bool5);
    label734:
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
      paramObject = (SearchArticle)paramObject;
      if (backendUrn != null)
      {
        if (backendUrn.equals(backendUrn)) {}
      }
      else {
        while (backendUrn != null) {
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
      if (url != null)
      {
        if (url.equals(url)) {}
      }
      else {
        while (url != null) {
          return false;
        }
      }
      if (authorName != null)
      {
        if (authorName.equals(authorName)) {}
      }
      else {
        while (authorName != null) {
          return false;
        }
      }
      if (authorFollowersCount != authorFollowersCount) {
        return false;
      }
      if (authorProfile != null)
      {
        if (authorProfile.equals(authorProfile)) {}
      }
      else {
        while (authorProfile != null) {
          return false;
        }
      }
      if (authorFollowing != null)
      {
        if (authorFollowing.equals(authorFollowing)) {}
      }
      else {
        while (authorFollowing != null) {
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
      if (snippet != null)
      {
        if (snippet.equals(snippet)) {}
      }
      else {
        while (snippet != null) {
          return false;
        }
      }
      if (contentSnippet != null)
      {
        if (contentSnippet.equals(contentSnippet)) {}
      }
      else {
        while (contentSnippet != null) {
          return false;
        }
      }
      if (postedAt != postedAt) {
        return false;
      }
      if (parentUrl != null)
      {
        if (parentUrl.equals(parentUrl)) {}
      }
      else {
        while (parentUrl != null) {
          return false;
        }
      }
      if (socialActivityInfo == null) {
        break;
      }
    } while (socialActivityInfo.equals(socialActivityInfo));
    for (;;)
    {
      return false;
      if (socialActivityInfo == null) {
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
    if (hasBackendUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(backendUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    j = i + 1;
    i = j;
    if (hasUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
    }
    j = i + 1;
    i = j;
    if (hasAuthorName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(authorName);
    }
    j = i + 1;
    i = j;
    if (hasAuthorFollowersCount) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasAuthorProfile)
    {
      i = j + 1;
      if (authorProfile._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(authorProfile._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasAuthorFollowing)
      {
        i = j + 1;
        if (authorFollowing._cachedId == null) {
          break label436;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(authorFollowing._cachedId);
      }
      label222:
      j = i + 1;
      i = j;
      if (hasImage)
      {
        i = j + 1;
        if (image._cachedId == null) {
          break label449;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(image._cachedId);
      }
      label264:
      j = i + 1;
      i = j;
      if (hasSnippet) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(snippet);
      }
      j = i + 1;
      i = j;
      if (hasContentSnippet)
      {
        i = j + 1;
        if (contentSnippet._cachedId == null) {
          break label462;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(contentSnippet._cachedId);
      }
      label331:
      j = i + 1;
      i = j;
      if (hasPostedAt) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasParentUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(parentUrl);
      }
      j = i + 1;
      i = j;
      if (hasSocialActivityInfo)
      {
        i = j + 1;
        if (socialActivityInfo._cachedId == null) {
          break label475;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(socialActivityInfo._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += authorProfile.getSerializedSize();
      break;
      label436:
      i += authorFollowing.getSerializedSize();
      break label222;
      label449:
      i += image.getSerializedSize();
      break label264;
      label462:
      i += contentSnippet.getSerializedSize();
      break label331;
      label475:
      i += socialActivityInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i6 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int i7;
    int n;
    label107:
    int i1;
    label123:
    int i2;
    label139:
    int i3;
    label155:
    int i4;
    label171:
    int i8;
    if (backendUrn != null)
    {
      i = backendUrn.hashCode();
      if (title == null) {
        break label306;
      }
      j = title.hashCode();
      if (url == null) {
        break label311;
      }
      k = url.hashCode();
      if (authorName == null) {
        break label316;
      }
      m = authorName.hashCode();
      i7 = (int)(authorFollowersCount ^ authorFollowersCount >>> 32);
      if (authorProfile == null) {
        break label322;
      }
      n = authorProfile.hashCode();
      if (authorFollowing == null) {
        break label328;
      }
      i1 = authorFollowing.hashCode();
      if (image == null) {
        break label334;
      }
      i2 = image.hashCode();
      if (snippet == null) {
        break label340;
      }
      i3 = snippet.hashCode();
      if (contentSnippet == null) {
        break label346;
      }
      i4 = contentSnippet.hashCode();
      i8 = (int)(postedAt ^ postedAt >>> 32);
      if (parentUrl == null) {
        break label352;
      }
    }
    label306:
    label311:
    label316:
    label322:
    label328:
    label334:
    label340:
    label346:
    label352:
    for (int i5 = parentUrl.hashCode();; i5 = 0)
    {
      if (socialActivityInfo != null) {
        i6 = socialActivityInfo.hashCode();
      }
      i = (i5 + ((i4 + (i3 + (i2 + (i1 + (n + ((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i7) * 31) * 31) * 31) * 31) * 31) * 31 + i8) * 31) * 31 + i6;
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
      n = 0;
      break label107;
      i1 = 0;
      break label123;
      i2 = 0;
      break label139;
      i3 = 0;
      break label155;
      i4 = 0;
      break label171;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchArticle");
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
    label172:
    label198:
    label224:
    label248:
    label308:
    label368:
    label428:
    label454:
    label514:
    label538:
    label564:
    label667:
    label677:
    label687:
    label697:
    label707:
    label732:
    label742:
    label767:
    label777:
    label802:
    label812:
    label822:
    label847:
    label857:
    label867:
    label877:
    label902:
    label910:
    label912:
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
        localByteBuffer.putInt(-746223894);
        if (hasBackendUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
          if (!hasTitle) {
            break label667;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasUrl) {
            break label677;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasAuthorName) {
            break label687;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, authorName);
          if (!hasAuthorFollowersCount) {
            break label697;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(authorFollowersCount);
          if (!hasAuthorProfile) {
            break label732;
          }
          localByteBuffer.put((byte)1);
          if (authorProfile._cachedId == null) {
            break label707;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, authorProfile._cachedId);
          authorProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasAuthorFollowing) {
            break label767;
          }
          localByteBuffer.put((byte)1);
          if (authorFollowing._cachedId == null) {
            break label742;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, authorFollowing._cachedId);
          authorFollowing.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasImage) {
            break label802;
          }
          localByteBuffer.put((byte)1);
          if (image._cachedId == null) {
            break label777;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
          image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSnippet) {
            break label812;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, snippet);
          if (!hasContentSnippet) {
            break label847;
          }
          localByteBuffer.put((byte)1);
          if (contentSnippet._cachedId == null) {
            break label822;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, contentSnippet._cachedId);
          contentSnippet.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPostedAt) {
            break label857;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(postedAt);
          if (!hasParentUrl) {
            break label867;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, parentUrl);
          if (!hasSocialActivityInfo) {
            break label902;
          }
          localByteBuffer.put((byte)1);
          if (socialActivityInfo._cachedId == null) {
            break label877;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, socialActivityInfo._cachedId);
          socialActivityInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label910;
          }
          if (str != null) {
            break label912;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label172;
          localByteBuffer.put((byte)0);
          break label198;
          localByteBuffer.put((byte)0);
          break label224;
          localByteBuffer.put((byte)0);
          break label248;
          localByteBuffer.put((byte)1);
          authorProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label308;
          localByteBuffer.put((byte)0);
          break label308;
          localByteBuffer.put((byte)1);
          authorFollowing.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label368;
          localByteBuffer.put((byte)0);
          break label368;
          localByteBuffer.put((byte)1);
          image.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label428;
          localByteBuffer.put((byte)0);
          break label428;
          localByteBuffer.put((byte)0);
          break label454;
          localByteBuffer.put((byte)1);
          contentSnippet.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label514;
          localByteBuffer.put((byte)0);
          break label514;
          localByteBuffer.put((byte)0);
          break label538;
          localByteBuffer.put((byte)0);
          break label564;
          localByteBuffer.put((byte)1);
          socialActivityInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchArticle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */