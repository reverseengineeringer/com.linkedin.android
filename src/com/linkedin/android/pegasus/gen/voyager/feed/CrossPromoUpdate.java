package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CrossPromoUpdate
  implements FissileDataModel<CrossPromoUpdate>, RecordTemplate<CrossPromoUpdate>
{
  public static final CrossPromoUpdateBuilder BUILDER = CrossPromoUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<UpdateAction> actions;
  public final AppActor actor;
  public final AttributedText attributedText;
  public final Content content;
  public final boolean hasActions;
  public final boolean hasActor;
  public final boolean hasAttributedText;
  public final boolean hasContent;
  public final boolean hasHeader;
  public final boolean hasLegoTrackingId;
  public final boolean hasLegoTrackingToken;
  public final boolean hasText;
  public final AnnotatedText header;
  public final String legoTrackingId;
  public final String legoTrackingToken;
  public final AnnotatedText text;
  
  CrossPromoUpdate(List<UpdateAction> paramList, String paramString1, String paramString2, AnnotatedText paramAnnotatedText1, AppActor paramAppActor, AnnotatedText paramAnnotatedText2, AttributedText paramAttributedText, Content paramContent, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      actions = paramList;
      legoTrackingToken = paramString1;
      legoTrackingId = paramString2;
      header = paramAnnotatedText1;
      actor = paramAppActor;
      text = paramAnnotatedText2;
      attributedText = paramAttributedText;
      content = paramContent;
      hasActions = paramBoolean1;
      hasLegoTrackingToken = paramBoolean2;
      hasLegoTrackingId = paramBoolean3;
      hasHeader = paramBoolean4;
      hasActor = paramBoolean5;
      hasText = paramBoolean6;
      hasAttributedText = paramBoolean7;
      hasContent = paramBoolean8;
      _cachedId = null;
      return;
    }
  }
  
  public final CrossPromoUpdate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject3;
    boolean bool2;
    label280:
    label292:
    Object localObject4;
    boolean bool3;
    label332:
    label344:
    Object localObject5;
    boolean bool4;
    label384:
    label396:
    Object localObject6;
    boolean bool5;
    if (hasActions)
    {
      paramDataProcessor.startRecordField$505cff1c("actions");
      actions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localObject3 = actions.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (UpdateAction)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((UpdateAction)localObject2).accept(paramDataProcessor);; localObject2 = (UpdateAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null) {
        bool1 = true;
      }
    }
    else
    {
      if (hasLegoTrackingToken)
      {
        paramDataProcessor.startRecordField$505cff1c("legoTrackingToken");
        paramDataProcessor.processString(legoTrackingToken);
      }
      if (hasLegoTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("legoTrackingId");
        localObject2 = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(legoTrackingId));
      }
      localObject3 = null;
      bool2 = false;
      if (hasHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("header");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label557;
        }
        localObject2 = header.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label575;
        }
        bool2 = true;
        localObject3 = localObject2;
      }
      localObject4 = null;
      bool3 = false;
      if (hasActor)
      {
        paramDataProcessor.startRecordField$505cff1c("actor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label585;
        }
        localObject2 = actor.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label603;
        }
        bool3 = true;
        localObject4 = localObject2;
      }
      localObject5 = null;
      bool4 = false;
      if (hasText)
      {
        paramDataProcessor.startRecordField$505cff1c("text");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label613;
        }
        localObject2 = text.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label631;
        }
        bool4 = true;
        localObject5 = localObject2;
      }
      localObject6 = null;
      bool5 = false;
      if (hasAttributedText)
      {
        paramDataProcessor.startRecordField$505cff1c("attributedText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label641;
        }
        localObject2 = attributedText.accept(paramDataProcessor);
        label436:
        if (localObject2 == null) {
          break label659;
        }
        bool5 = true;
        localObject6 = localObject2;
      }
      label448:
      localObject2 = null;
      bool6 = false;
      if (hasContent)
      {
        paramDataProcessor.startRecordField$505cff1c("content");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label669;
        }
        localObject2 = content.accept(paramDataProcessor);
        label488:
        if (localObject2 == null) {
          break label687;
        }
      }
    }
    label557:
    label575:
    label585:
    label603:
    label613:
    label631:
    label641:
    label659:
    label669:
    label687:
    for (boolean bool6 = true;; bool6 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label847;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasLegoTrackingToken) {
          break label693;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate", "legoTrackingToken");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      break;
      localObject2 = (AnnotatedText)paramDataProcessor.processDataTemplate(header);
      break label280;
      bool2 = false;
      localObject3 = localObject2;
      break label292;
      localObject2 = (AppActor)paramDataProcessor.processDataTemplate(actor);
      break label332;
      bool3 = false;
      localObject4 = localObject2;
      break label344;
      localObject2 = (AnnotatedText)paramDataProcessor.processDataTemplate(text);
      break label384;
      bool4 = false;
      localObject5 = localObject2;
      break label396;
      localObject2 = (AttributedText)paramDataProcessor.processDataTemplate(attributedText);
      break label436;
      bool5 = false;
      localObject6 = localObject2;
      break label448;
      localObject2 = (Content)paramDataProcessor.processDataTemplate(content);
      break label488;
    }
    label693:
    if (!hasLegoTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate", "legoTrackingId");
    }
    if (!hasHeader) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate", "header");
    }
    if (!hasActor) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate", "actor");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate", "actions");
        }
      }
    }
    return new CrossPromoUpdate((List)localObject1, legoTrackingToken, legoTrackingId, (AnnotatedText)localObject3, (AppActor)localObject4, (AnnotatedText)localObject5, (AttributedText)localObject6, (Content)localObject2, bool1, hasLegoTrackingToken, hasLegoTrackingId, bool2, bool3, bool4, bool5, bool6);
    label847:
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
      paramObject = (CrossPromoUpdate)paramObject;
      if (actions != null)
      {
        if (actions.equals(actions)) {}
      }
      else {
        while (actions != null) {
          return false;
        }
      }
      if (legoTrackingToken != null)
      {
        if (legoTrackingToken.equals(legoTrackingToken)) {}
      }
      else {
        while (legoTrackingToken != null) {
          return false;
        }
      }
      if (legoTrackingId != null)
      {
        if (legoTrackingId.equals(legoTrackingId)) {}
      }
      else {
        while (legoTrackingId != null) {
          return false;
        }
      }
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (actor != null)
      {
        if (actor.equals(actor)) {}
      }
      else {
        while (actor != null) {
          return false;
        }
      }
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (attributedText != null)
      {
        if (attributedText.equals(attributedText)) {}
      }
      else {
        while (attributedText != null) {
          return false;
        }
      }
      if (content == null) {
        break;
      }
    } while (content.equals(content));
    for (;;)
    {
      return false;
      if (content == null) {
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
    int j = i;
    if (hasActions)
    {
      i += 2;
      Iterator localIterator = actions.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        UpdateAction localUpdateAction = (UpdateAction)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localUpdateAction.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasLegoTrackingToken) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(legoTrackingToken);
    }
    j = i + 1;
    i = j;
    if (hasLegoTrackingId) {
      i = j + 4 + legoTrackingId.getBytes().length;
    }
    j = i + 1;
    i = j;
    if (hasHeader)
    {
      i = j + 1;
      if (header._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(header._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasActor)
      {
        i = j + 1;
        if (actor._cachedId == null) {
          break label385;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(actor._cachedId);
      }
      label239:
      j = i + 1;
      i = j;
      if (hasText)
      {
        i = j + 1;
        if (text._cachedId == null) {
          break label398;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(text._cachedId);
      }
      label281:
      j = i + 1;
      i = j;
      if (hasAttributedText)
      {
        i = j + 1;
        if (attributedText._cachedId == null) {
          break label411;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(attributedText._cachedId);
      }
      label323:
      j = i + 1;
      i = j;
      if (hasContent)
      {
        i = j + 1;
        if (content._cachedId == null) {
          break label424;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(content._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += header.getSerializedSize();
      break;
      label385:
      i += actor.getSerializedSize();
      break label239;
      label398:
      i += text.getSerializedSize();
      break label281;
      label411:
      i += attributedText.getSerializedSize();
      break label323;
      label424:
      i += content.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i3 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label47:
    int k;
    label62:
    int m;
    label78:
    int n;
    label94:
    int i1;
    if (actions != null)
    {
      i = actions.hashCode();
      if (legoTrackingToken == null) {
        break label200;
      }
      j = legoTrackingToken.hashCode();
      if (legoTrackingId == null) {
        break label205;
      }
      k = legoTrackingId.hashCode();
      if (header == null) {
        break label210;
      }
      m = header.hashCode();
      if (actor == null) {
        break label216;
      }
      n = actor.hashCode();
      if (text == null) {
        break label222;
      }
      i1 = text.hashCode();
      label110:
      if (attributedText == null) {
        break label228;
      }
    }
    label200:
    label205:
    label210:
    label216:
    label222:
    label228:
    for (int i2 = attributedText.hashCode();; i2 = 0)
    {
      if (content != null) {
        i3 = content.hashCode();
      }
      i = (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label47;
      k = 0;
      break label62;
      m = 0;
      break label78;
      n = 0;
      break label94;
      i1 = 0;
      break label110;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CrossPromoUpdate");
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
    label315:
    label375:
    label435:
    label495:
    label555:
    label658:
    label668:
    label693:
    label703:
    label728:
    label738:
    label763:
    label773:
    label798:
    label808:
    label833:
    label841:
    label843:
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
        localByteBuffer.putInt(1542441299);
        Object localObject;
        if (hasActions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
          localObject = actions.iterator();
          while (((Iterator)localObject).hasNext())
          {
            UpdateAction localUpdateAction = (UpdateAction)((Iterator)localObject).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localUpdateAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localUpdateAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasLegoTrackingToken)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, legoTrackingToken);
          if (!hasLegoTrackingId) {
            break label658;
          }
          localByteBuffer.put((byte)1);
          localObject = legoTrackingId.getBytes();
          localByteBuffer.putInt(localObject.length);
          localByteBuffer.put((byte[])localObject);
          if (!hasHeader) {
            break label693;
          }
          localByteBuffer.put((byte)1);
          if (header._cachedId == null) {
            break label668;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, header._cachedId);
          header.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasActor) {
            break label728;
          }
          localByteBuffer.put((byte)1);
          if (actor._cachedId == null) {
            break label703;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, actor._cachedId);
          actor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasText) {
            break label763;
          }
          localByteBuffer.put((byte)1);
          if (text._cachedId == null) {
            break label738;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
          text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasAttributedText) {
            break label798;
          }
          localByteBuffer.put((byte)1);
          if (attributedText._cachedId == null) {
            break label773;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, attributedText._cachedId);
          attributedText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasContent) {
            break label833;
          }
          localByteBuffer.put((byte)1);
          if (content._cachedId == null) {
            break label808;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, content._cachedId);
          content.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label841;
          }
          if (str != null) {
            break label843;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label315;
          localByteBuffer.put((byte)1);
          header.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label375;
          localByteBuffer.put((byte)0);
          break label375;
          localByteBuffer.put((byte)1);
          actor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label435;
          localByteBuffer.put((byte)0);
          break label435;
          localByteBuffer.put((byte)1);
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label495;
          localByteBuffer.put((byte)0);
          break label495;
          localByteBuffer.put((byte)1);
          attributedText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label555;
          localByteBuffer.put((byte)0);
          break label555;
          localByteBuffer.put((byte)1);
          content.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Content
    implements FissileDataModel<Content>, UnionTemplate<Content>
  {
    public static final CrossPromoUpdateBuilder.ContentBuilder BUILDER = CrossPromoUpdateBuilder.ContentBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasShareArticleValue;
    public final boolean hasShareJobValue;
    public final ShareArticle shareArticleValue;
    public final ShareJob shareJobValue;
    
    Content(ShareArticle paramShareArticle, ShareJob paramShareJob, boolean paramBoolean1, boolean paramBoolean2)
    {
      shareArticleValue = paramShareArticle;
      shareJobValue = paramShareJob;
      hasShareArticleValue = paramBoolean1;
      hasShareJobValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final Content accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasShareArticleValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareArticle");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = shareArticleValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label149;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        label56:
        localObject1 = null;
        bool2 = false;
        if (hasShareJobValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.ShareJob");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label158;
          }
          localObject1 = shareJobValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label176;
          }
        }
      }
      label149:
      label158:
      label176:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label181;
        }
        return new Content((ShareArticle)localObject2, (ShareJob)localObject1, bool1, bool2);
        localObject1 = (ShareArticle)paramDataProcessor.processDataTemplate(shareArticleValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (ShareJob)paramDataProcessor.processDataTemplate(shareJobValue);
        break label95;
      }
      label181:
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
        paramObject = (Content)paramObject;
        if (shareArticleValue != null)
        {
          if (shareArticleValue.equals(shareArticleValue)) {}
        }
        else {
          while (shareArticleValue != null) {
            return false;
          }
        }
        if (shareJobValue == null) {
          break;
        }
      } while (shareJobValue.equals(shareJobValue));
      for (;;)
      {
        return false;
        if (shareJobValue == null) {
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
      if (hasShareArticleValue)
      {
        if (shareArticleValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(shareArticleValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasShareJobValue)
        {
          i = j + 1;
          if (shareJobValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareJobValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = shareArticleValue.getSerializedSize() + 7;
        break;
        label114:
        i += shareJobValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (shareArticleValue != null) {}
      for (int i = shareArticleValue.hashCode();; i = 0)
      {
        if (shareJobValue != null) {
          j = shareJobValue.hashCode();
        }
        i = (i + 527) * 31 + j;
        _cachedHashCode = i;
        return i;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Content");
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
      label298:
      label323:
      label331:
      label333:
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
          localByteBuffer.putInt(-1942903389);
          if (hasShareArticleValue)
          {
            localByteBuffer.put((byte)1);
            if (shareArticleValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, shareArticleValue._cachedId);
              shareArticleValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasShareJobValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (shareJobValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, shareJobValue._cachedId);
              shareJobValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label331;
            }
            if (str != null) {
              break label333;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            shareArticleValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            shareJobValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */