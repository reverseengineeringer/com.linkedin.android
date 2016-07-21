package com.linkedin.android.pegasus.gen.voyager.relationships.invitation;

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
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class InvitationsSummary
  implements FissileDataModel<InvitationsSummary>, RecordTemplate<InvitationsSummary>
{
  public static final InvitationsSummaryBuilder BUILDER = InvitationsSummaryBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasNumNewInvitations;
  public final boolean hasNumPendingInvitations;
  public final int numNewInvitations;
  public final int numPendingInvitations;
  
  InvitationsSummary(Urn paramUrn, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    entityUrn = paramUrn;
    numNewInvitations = paramInt1;
    numPendingInvitations = paramInt2;
    hasEntityUrn = paramBoolean1;
    hasNumNewInvitations = paramBoolean2;
    hasNumPendingInvitations = paramBoolean3;
    UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private InvitationsSummary accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasNumNewInvitations)
    {
      paramDataProcessor.startRecordField$505cff1c("numNewInvitations");
      paramDataProcessor.processInt(numNewInvitations);
    }
    if (hasNumPendingInvitations)
    {
      paramDataProcessor.startRecordField$505cff1c("numPendingInvitations");
      paramDataProcessor.processInt(numPendingInvitations);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasNumNewInvitations) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationsSummary", "numNewInvitations");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasNumPendingInvitations) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationsSummary", "numPendingInvitations");
      }
      return new InvitationsSummary(entityUrn, numNewInvitations, numPendingInvitations, hasEntityUrn, hasNumNewInvitations, hasNumPendingInvitations);
    }
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
      paramObject = (InvitationsSummary)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (numNewInvitations != numNewInvitations) {
        return false;
      }
    } while (numPendingInvitations == numPendingInvitations);
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
    if (hasNumNewInvitations) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasNumPendingInvitations) {
      i = j + 4;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (entityUrn != null) {}
    for (int i = entityUrn.hashCode();; i = 0)
    {
      i = ((i + 527) * 31 + numNewInvitations) * 31 + numPendingInvitations;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building InvitationsSummary");
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
    label168:
    label235:
    label245:
    label253:
    label255:
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
        localByteBuffer.putInt(-163097942);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasNumNewInvitations) {
            break label235;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numNewInvitations);
          if (!hasNumPendingInvitations) {
            break label245;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numPendingInvitations);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label253;
          }
          if (str != null) {
            break label255;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label168;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationsSummary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */