package com.linkedin.android.pegasus.gen.voyager.relationships.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.ProfileHighlight;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation;
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

public final class RelMiniProfile
  implements FissileDataModel<RelMiniProfile>, RecordTemplate<RelMiniProfile>
{
  public static final RelMiniProfileBuilder BUILDER = RelMiniProfileBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final MemberDistance distance;
  public final boolean hasDistance;
  public final boolean hasHighlights;
  public final boolean hasMiniProfile;
  public final boolean hasPendingInvitation;
  public final List<ProfileHighlight> highlights;
  public final MiniProfile miniProfile;
  public final Invitation pendingInvitation;
  
  RelMiniProfile(MiniProfile paramMiniProfile, MemberDistance paramMemberDistance, List<ProfileHighlight> paramList, Invitation paramInvitation, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    miniProfile = paramMiniProfile;
    distance = paramMemberDistance;
    if (paramList == null) {}
    for (paramMiniProfile = null;; paramMiniProfile = Collections.unmodifiableList(paramList))
    {
      highlights = paramMiniProfile;
      pendingInvitation = paramInvitation;
      hasMiniProfile = paramBoolean1;
      hasDistance = paramBoolean2;
      hasHighlights = paramBoolean3;
      hasPendingInvitation = paramBoolean4;
      _cachedId = null;
      return;
    }
  }
  
  public final RelMiniProfile accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject3 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject4;
    boolean bool2;
    label96:
    label108:
    boolean bool3;
    int i;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label274;
        }
        bool1 = true;
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject4 = null;
      bool2 = false;
      if (hasDistance)
      {
        paramDataProcessor.startRecordField$505cff1c("distance");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label283;
        }
        localObject1 = distance.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label301;
        }
        bool2 = true;
        localObject4 = localObject1;
      }
      localObject1 = null;
      localObject2 = null;
      bool3 = false;
      if (!hasHighlights) {
        break label341;
      }
      paramDataProcessor.startRecordField$505cff1c("highlights");
      highlights.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = highlights.iterator();
      label183:
      if (!localIterator.hasNext()) {
        break label327;
      }
      localObject2 = (ProfileHighlight)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label311;
      }
    }
    label274:
    label283:
    label301:
    label311:
    for (Object localObject2 = ((ProfileHighlight)localObject2).accept(paramDataProcessor);; localObject2 = (ProfileHighlight)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label183;
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break;
      bool1 = false;
      localObject3 = localObject1;
      break label56;
      localObject1 = (MemberDistance)paramDataProcessor.processDataTemplate(distance);
      break label96;
      bool2 = false;
      localObject4 = localObject1;
      break label108;
    }
    label327:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool3 = true;
      label341:
      localObject2 = null;
      bool4 = false;
      if (hasPendingInvitation)
      {
        paramDataProcessor.startRecordField$505cff1c("pendingInvitation");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label451;
        }
        localObject2 = pendingInvitation.accept(paramDataProcessor);
        label381:
        if (localObject2 == null) {
          break label469;
        }
      }
    }
    label451:
    label469:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label567;
      }
      if (!hasHighlights) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasMiniProfile) {
          break label475;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.RelMiniProfile", "miniProfile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool3 = false;
      break;
      localObject2 = (Invitation)paramDataProcessor.processDataTemplate(pendingInvitation);
      break label381;
    }
    label475:
    if (!hasDistance) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.RelMiniProfile", "distance");
    }
    if (highlights != null)
    {
      paramDataProcessor = highlights.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((ProfileHighlight)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.RelMiniProfile", "highlights");
        }
      }
    }
    return new RelMiniProfile((MiniProfile)localObject3, (MemberDistance)localObject4, (List)localObject1, (Invitation)localObject2, bool1, bool2, bool3, bool4);
    label567:
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
      paramObject = (RelMiniProfile)paramObject;
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
      if (distance != null)
      {
        if (distance.equals(distance)) {}
      }
      else {
        while (distance != null) {
          return false;
        }
      }
      if (highlights != null)
      {
        if (highlights.equals(highlights)) {}
      }
      else {
        while (highlights != null) {
          return false;
        }
      }
      if (pendingInvitation == null) {
        break;
      }
    } while (pendingInvitation.equals(pendingInvitation));
    for (;;)
    {
      return false;
      if (pendingInvitation == null) {
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
    int j;
    label93:
    Iterator localIterator;
    if (hasMiniProfile)
    {
      if (miniProfile._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasDistance)
      {
        i = j + 1;
        if (distance._cachedId == null) {
          break label184;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(distance._cachedId);
      }
      i += 1;
      j = i;
      if (!hasHighlights) {
        break label208;
      }
      i += 2;
      localIterator = highlights.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label208;
      }
      ProfileHighlight localProfileHighlight = (ProfileHighlight)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = miniProfile.getSerializedSize() + 7;
        break;
        label184:
        i += distance.getSerializedSize();
        break label93;
      }
      i += localProfileHighlight.getSerializedSize();
    }
    label208:
    j += 1;
    i = j;
    if (hasPendingInvitation)
    {
      i = j + 1;
      if (pendingInvitation._cachedId == null) {
        break label257;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(pendingInvitation._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label257:
      i += pendingInvitation.getSerializedSize();
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
    if (miniProfile != null)
    {
      i = miniProfile.hashCode();
      if (distance == null) {
        break label112;
      }
      j = distance.hashCode();
      label45:
      if (highlights == null) {
        break label117;
      }
    }
    label112:
    label117:
    for (int k = highlights.hashCode();; k = 0)
    {
      if (pendingInvitation != null) {
        m = pendingInvitation.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building RelMiniProfile");
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
    label372:
    label397:
    label430:
    label437:
    label565:
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
        localByteBuffer.putInt(-2136105727);
        Iterator localIterator;
        if (hasMiniProfile)
        {
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
            miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasDistance) {
              break label397;
            }
            localByteBuffer.put((byte)1);
            if (distance._cachedId == null) {
              break label372;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, distance._cachedId);
            distance.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasHighlights) {
              break label430;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, highlights.size());
            localIterator = highlights.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label437;
          }
          ProfileHighlight localProfileHighlight = (ProfileHighlight)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localProfileHighlight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            distance.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
          }
          localByteBuffer.put((byte)1);
          localProfileHighlight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasPendingInvitation)
        {
          localByteBuffer.put((byte)1);
          if (pendingInvitation._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, pendingInvitation._cachedId);
            pendingInvitation.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label565;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          pendingInvitation.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.RelMiniProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */