package com.linkedin.android.pegasus.gen.voyager.feed;

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

public final class PromptResponseUpdate
  implements FissileDataModel<PromptResponseUpdate>, RecordTemplate<PromptResponseUpdate>
{
  public static final PromptResponseUpdateBuilder BUILDER = PromptResponseUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<UpdateAction> actions;
  public final long createdAt;
  public final boolean hasActions;
  public final boolean hasCreatedAt;
  public final boolean hasPrompt;
  public final boolean hasResponse;
  public final boolean hasShareAudience;
  public final boolean hasUrn;
  public final Prompt prompt;
  public final PromptResponse response;
  public final ShareAudience shareAudience;
  public final Urn urn;
  
  PromptResponseUpdate(ShareAudience paramShareAudience, List<UpdateAction> paramList, Urn paramUrn, long paramLong, Prompt paramPrompt, PromptResponse paramPromptResponse, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    shareAudience = paramShareAudience;
    if (paramList == null) {}
    for (paramShareAudience = null;; paramShareAudience = Collections.unmodifiableList(paramList))
    {
      actions = paramShareAudience;
      urn = paramUrn;
      createdAt = paramLong;
      prompt = paramPrompt;
      response = paramPromptResponse;
      hasShareAudience = paramBoolean1;
      hasActions = paramBoolean2;
      hasUrn = paramBoolean3;
      hasCreatedAt = paramBoolean4;
      hasPrompt = paramBoolean5;
      hasResponse = paramBoolean6;
      _cachedId = null;
      return;
    }
  }
  
  public final PromptResponseUpdate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasShareAudience)
    {
      paramDataProcessor.startRecordField$505cff1c("shareAudience");
      paramDataProcessor.processEnum(shareAudience);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject3;
    boolean bool2;
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
      if (hasUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("urn");
        localObject2 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(urn));
      }
      if (hasCreatedAt)
      {
        paramDataProcessor.startRecordField$505cff1c("createdAt");
        paramDataProcessor.processLong(createdAt);
      }
      localObject3 = null;
      bool2 = false;
      if (hasPrompt)
      {
        paramDataProcessor.startRecordField$505cff1c("prompt");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label426;
        }
        localObject2 = prompt.accept(paramDataProcessor);
        label305:
        if (localObject2 == null) {
          break label444;
        }
        bool2 = true;
        localObject3 = localObject2;
      }
      label317:
      localObject2 = null;
      bool3 = false;
      if (hasResponse)
      {
        paramDataProcessor.startRecordField$505cff1c("response");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label454;
        }
        localObject2 = response.accept(paramDataProcessor);
        label357:
        if (localObject2 == null) {
          break label472;
        }
      }
    }
    label426:
    label444:
    label454:
    label472:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label647;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasShareAudience) {
          break label478;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate", "shareAudience");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool1 = false;
      break;
      localObject2 = (Prompt)paramDataProcessor.processDataTemplate(prompt);
      break label305;
      bool2 = false;
      localObject3 = localObject2;
      break label317;
      localObject2 = (PromptResponse)paramDataProcessor.processDataTemplate(response);
      break label357;
    }
    label478:
    if (!hasUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate", "urn");
    }
    if (!hasCreatedAt) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate", "createdAt");
    }
    if (!hasPrompt) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate", "prompt");
    }
    if (!hasResponse) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate", "response");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate", "actions");
        }
      }
    }
    return new PromptResponseUpdate(shareAudience, (List)localObject1, urn, createdAt, (Prompt)localObject3, (PromptResponse)localObject2, hasShareAudience, bool1, hasUrn, hasCreatedAt, bool2, bool3);
    label647:
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
      paramObject = (PromptResponseUpdate)paramObject;
      if (shareAudience != null)
      {
        if (shareAudience.equals(shareAudience)) {}
      }
      else {
        while (shareAudience != null) {
          return false;
        }
      }
      if (actions != null)
      {
        if (actions.equals(actions)) {}
      }
      else {
        while (actions != null) {
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
      if (createdAt != createdAt) {
        return false;
      }
      if (prompt != null)
      {
        if (prompt.equals(prompt)) {}
      }
      else {
        while (prompt != null) {
          return false;
        }
      }
      if (response == null) {
        break;
      }
    } while (response.equals(response));
    for (;;)
    {
      return false;
      if (response == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasShareAudience) {
      i = j + 2;
    }
    i += 1;
    j = i;
    Object localObject;
    if (hasActions)
    {
      i += 2;
      localObject = actions.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        UpdateAction localUpdateAction = (UpdateAction)((Iterator)localObject).next();
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
    if (hasUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(urn));
    }
    j = i + 1;
    i = j;
    if (hasCreatedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasPrompt)
    {
      i = j + 1;
      if (prompt._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(prompt._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasResponse)
      {
        i = j + 1;
        if (response._cachedId == null) {
          break label275;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(response._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += prompt.getSerializedSize();
      break;
      label275:
      i += response.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label47:
    int k;
    label62:
    int i1;
    if (shareAudience != null)
    {
      i = shareAudience.hashCode();
      if (actions == null) {
        break label155;
      }
      j = actions.hashCode();
      if (urn == null) {
        break label160;
      }
      k = urn.hashCode();
      i1 = (int)(createdAt ^ createdAt >>> 32);
      if (prompt == null) {
        break label165;
      }
    }
    label155:
    label160:
    label165:
    for (int m = prompt.hashCode();; m = 0)
    {
      if (response != null) {
        n = response.hashCode();
      }
      i = (m + ((k + (j + (i + 527) * 31) * 31) * 31 + i1) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label47;
      k = 0;
      break label62;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PromptResponseUpdate");
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
    label288:
    label346:
    label406:
    label509:
    label519:
    label544:
    label554:
    label579:
    label587:
    label589:
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
        localByteBuffer.putInt(-2042725680);
        Object localObject;
        if (hasShareAudience)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, shareAudience.ordinal());
          if (hasActions)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
            localObject = actions.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label288;
            }
            UpdateAction localUpdateAction = (UpdateAction)((Iterator)localObject).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localUpdateAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            localUpdateAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
        }
        localByteBuffer.put((byte)0);
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasCreatedAt) {
            break label509;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(createdAt);
          if (!hasPrompt) {
            break label544;
          }
          localByteBuffer.put((byte)1);
          if (prompt._cachedId == null) {
            break label519;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, prompt._cachedId);
          prompt.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasResponse) {
            break label579;
          }
          localByteBuffer.put((byte)1);
          if (response._cachedId == null) {
            break label554;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, response._cachedId);
          response.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label587;
          }
          if (str != null) {
            break label589;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label346;
          localByteBuffer.put((byte)1);
          prompt.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label406;
          localByteBuffer.put((byte)0);
          break label406;
          localByteBuffer.put((byte)1);
          response.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */