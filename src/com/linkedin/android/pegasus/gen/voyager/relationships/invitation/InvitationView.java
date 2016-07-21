package com.linkedin.android.pegasus.gen.voyager.relationships.invitation;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.Insight;
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

public final class InvitationView
  implements FissileDataModel<InvitationView>, RecordTemplate<InvitationView>
{
  public static final InvitationViewBuilder BUILDER = InvitationViewBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasInsights;
  public final boolean hasInvitation;
  public final List<Insight> insights;
  public final Invitation invitation;
  
  InvitationView(Invitation paramInvitation, List<Insight> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    invitation = paramInvitation;
    if (paramList == null) {}
    for (paramInvitation = null;; paramInvitation = Collections.unmodifiableList(paramList))
    {
      insights = paramInvitation;
      hasInvitation = paramBoolean1;
      hasInsights = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  private InvitationView accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    int i;
    if (hasInvitation)
    {
      paramDataProcessor.startRecordField$505cff1c("invitation");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = invitation.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localInsight = null;
      bool2 = false;
      if (!hasInsights) {
        break label261;
      }
      paramDataProcessor.startRecordField$505cff1c("insights");
      insights.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localInsight;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = insights.iterator();
      label131:
      if (!localIterator.hasNext()) {
        break label247;
      }
      localInsight = (Insight)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label231;
      }
    }
    label222:
    label231:
    for (Insight localInsight = localInsight.accept(paramDataProcessor);; localInsight = (Insight)paramDataProcessor.processDataTemplate(localInsight))
    {
      if ((localObject1 != null) && (localInsight != null)) {
        ((List)localObject1).add(localInsight);
      }
      i += 1;
      break label131;
      localObject1 = (Invitation)paramDataProcessor.processDataTemplate(invitation);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
    }
    label247:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label261:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label388;
      }
      if (!hasInsights) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasInvitation) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationView", "invitation");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (insights != null)
    {
      paramDataProcessor = insights.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Insight)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationView", "insights");
        }
      }
    }
    return new InvitationView((Invitation)localObject2, (List)localObject1, bool1, bool2);
    label388:
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
      paramObject = (InvitationView)paramObject;
      if (invitation != null)
      {
        if (invitation.equals(invitation)) {}
      }
      else {
        while (invitation != null) {
          return false;
        }
      }
      if (insights == null) {
        break;
      }
    } while (insights.equals(insights));
    for (;;)
    {
      return false;
      if (insights == null) {
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
    Iterator localIterator;
    if (hasInvitation)
    {
      if (invitation._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(invitation._cachedId) + 9;
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasInsights) {
        break label153;
      }
      i += 2;
      localIterator = insights.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label153;
      }
      Insight localInsight = (Insight)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = invitation.getSerializedSize() + 7;
        break;
      }
      i += localInsight.getSerializedSize();
    }
    label153:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (invitation != null) {}
    for (int i = invitation.hashCode();; i = 0)
    {
      if (insights != null) {
        j = insights.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building InvitationView");
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
    label335:
    label342:
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
        localByteBuffer.putInt(-2128726237);
        Iterator localIterator;
        if (hasInvitation)
        {
          localByteBuffer.put((byte)1);
          if (invitation._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, invitation._cachedId);
            invitation.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasInsights) {
              break label335;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, insights.size());
            localIterator = insights.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label342;
          }
          Insight localInsight = (Insight)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localInsight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            invitation.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
          }
          localByteBuffer.put((byte)1);
          localInsight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */