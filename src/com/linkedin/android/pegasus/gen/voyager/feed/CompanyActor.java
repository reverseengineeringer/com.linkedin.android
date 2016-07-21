package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CompanyActor
  implements FissileDataModel<CompanyActor>, RecordTemplate<CompanyActor>
{
  public static final CompanyActorBuilder BUILDER = CompanyActorBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final List<EntitiesFlavor> flavors;
  public final FollowingInfo followingInfo;
  public final boolean hasFlavors;
  public final boolean hasFollowingInfo;
  public final boolean hasMiniCompany;
  public final boolean hasShowFollowAction;
  public final boolean hasUrn;
  public final MiniCompany miniCompany;
  public final boolean showFollowAction;
  public final Urn urn;
  
  CompanyActor(Urn paramUrn, MiniCompany paramMiniCompany, FollowingInfo paramFollowingInfo, boolean paramBoolean1, List<EntitiesFlavor> paramList, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    urn = paramUrn;
    miniCompany = paramMiniCompany;
    followingInfo = paramFollowingInfo;
    showFollowAction = paramBoolean1;
    if (paramList == null) {}
    for (paramUrn = null;; paramUrn = Collections.unmodifiableList(paramList))
    {
      flavors = paramUrn;
      hasUrn = paramBoolean2;
      hasMiniCompany = paramBoolean3;
      hasFollowingInfo = paramBoolean4;
      hasShowFollowAction = paramBoolean5;
      hasFlavors = paramBoolean6;
      _cachedId = null;
      return;
    }
  }
  
  public final CompanyActor accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("urn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(urn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label89:
    Object localObject3;
    boolean bool2;
    label129:
    label141:
    int i;
    if (hasMiniCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("miniCompany");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniCompany.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label332;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasFollowingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("followingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label341;
        }
        localObject1 = followingInfo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label359;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      if (hasShowFollowAction)
      {
        paramDataProcessor.startRecordField$505cff1c("showFollowAction");
        paramDataProcessor.processBoolean(showFollowAction);
      }
      localObject1 = null;
      localEntitiesFlavor = null;
      bool3 = false;
      if (!hasFlavors) {
        break label399;
      }
      paramDataProcessor.startRecordField$505cff1c("flavors");
      flavors.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localEntitiesFlavor;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = flavors.iterator();
      label241:
      if (!localIterator.hasNext()) {
        break label385;
      }
      localEntitiesFlavor = (EntitiesFlavor)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label369;
      }
    }
    label332:
    label341:
    label359:
    label369:
    for (EntitiesFlavor localEntitiesFlavor = localEntitiesFlavor.accept(paramDataProcessor);; localEntitiesFlavor = (EntitiesFlavor)paramDataProcessor.processDataTemplate(localEntitiesFlavor))
    {
      if ((localObject1 != null) && (localEntitiesFlavor != null)) {
        ((List)localObject1).add(localEntitiesFlavor);
      }
      i += 1;
      break label241;
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompany);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label89;
      localObject1 = (FollowingInfo)paramDataProcessor.processDataTemplate(followingInfo);
      break label129;
      bool2 = false;
      localObject3 = localObject1;
      break label141;
    }
    label385:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      label399:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label584;
      }
      if (!hasFlavors) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasMiniCompany) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor", "miniCompany");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasFollowingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor", "followingInfo");
    }
    if (!hasShowFollowAction) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor", "showFollowAction");
    }
    if (flavors != null)
    {
      paramDataProcessor = flavors.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((EntitiesFlavor)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor", "flavors");
        }
      }
    }
    return new CompanyActor(urn, (MiniCompany)localObject2, (FollowingInfo)localObject3, showFollowAction, (List)localObject1, hasUrn, bool1, bool2, hasShowFollowAction, bool3);
    label584:
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
      paramObject = (CompanyActor)paramObject;
      if (urn != null)
      {
        if (urn.equals(urn)) {}
      }
      else {
        while (urn != null) {
          return false;
        }
      }
      if (miniCompany != null)
      {
        if (miniCompany.equals(miniCompany)) {}
      }
      else {
        while (miniCompany != null) {
          return false;
        }
      }
      if (followingInfo != null)
      {
        if (followingInfo.equals(followingInfo)) {}
      }
      else {
        while (followingInfo != null) {
          return false;
        }
      }
      if (showFollowAction != showFollowAction) {
        return false;
      }
      if (flavors == null) {
        break;
      }
    } while (flavors.equals(flavors));
    for (;;)
    {
      return false;
      if (flavors == null) {
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
    Object localObject;
    if (hasUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(urn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasMiniCompany)
    {
      i = j + 1;
      if (miniCompany._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniCompany._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasFollowingInfo)
      {
        i = j + 1;
        if (followingInfo._cachedId == null) {
          break label236;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(followingInfo._cachedId);
      }
      label129:
      j = i + 1;
      i = j;
      if (hasShowFollowAction) {
        i = j + 1;
      }
      i += 1;
      j = i;
      if (!hasFlavors) {
        break label260;
      }
      i += 2;
      localObject = flavors.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label260;
      }
      EntitiesFlavor localEntitiesFlavor = (EntitiesFlavor)((Iterator)localObject).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += miniCompany.getSerializedSize();
        break;
        label236:
        i += followingInfo.getSerializedSize();
        break label129;
      }
      i += localEntitiesFlavor.getSerializedSize();
    }
    label260:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (urn != null)
    {
      i = urn.hashCode();
      if (miniCompany == null) {
        break label128;
      }
      j = miniCompany.hashCode();
      if (followingInfo == null) {
        break label133;
      }
      k = followingInfo.hashCode();
      label60:
      if (!showFollowAction) {
        break label138;
      }
    }
    label128:
    label133:
    label138:
    for (int m = 1;; m = 0)
    {
      if (flavors != null) {
        n = flavors.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CompanyActor");
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
    label205:
    label265:
    label289:
    label298:
    label415:
    label440:
    label450:
    label475:
    label485:
    label491:
    label524:
    label531:
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
        localByteBuffer.putInt(1214281986);
        Object localObject;
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasMiniCompany) {
            break label440;
          }
          localByteBuffer.put((byte)1);
          if (miniCompany._cachedId == null) {
            break label415;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniCompany._cachedId);
          miniCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasFollowingInfo) {
            break label475;
          }
          localByteBuffer.put((byte)1);
          if (followingInfo._cachedId == null) {
            break label450;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, followingInfo._cachedId);
          followingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasShowFollowAction) {
            break label491;
          }
          localByteBuffer.put((byte)1);
          if (!showFollowAction) {
            break label485;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasFlavors) {
            break label524;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, flavors.size());
          localObject = flavors.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label531;
          }
          EntitiesFlavor localEntitiesFlavor = (EntitiesFlavor)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localEntitiesFlavor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            miniCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label205;
            localByteBuffer.put((byte)0);
            break label205;
            localByteBuffer.put((byte)1);
            followingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label265;
            localByteBuffer.put((byte)0);
            break label265;
            i = 0;
            break label289;
            localByteBuffer.put((byte)0);
            break label298;
          }
          localByteBuffer.put((byte)1);
          localEntitiesFlavor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */