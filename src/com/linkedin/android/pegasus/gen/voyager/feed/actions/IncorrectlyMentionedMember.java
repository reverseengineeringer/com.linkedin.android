package com.linkedin.android.pegasus.gen.voyager.feed.actions;

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

public final class IncorrectlyMentionedMember
  implements FissileDataModel<IncorrectlyMentionedMember>, RecordTemplate<IncorrectlyMentionedMember>
{
  public static final IncorrectlyMentionedMemberBuilder BUILDER = IncorrectlyMentionedMemberBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String displayName;
  public final boolean hasDisplayName;
  public final boolean hasProfileUrn;
  public final boolean hasSelf;
  public final Urn profileUrn;
  public final boolean self;
  
  IncorrectlyMentionedMember(Urn paramUrn, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    profileUrn = paramUrn;
    displayName = paramString;
    self = paramBoolean1;
    hasProfileUrn = paramBoolean2;
    hasDisplayName = paramBoolean3;
    hasSelf = paramBoolean4;
    _cachedId = null;
  }
  
  public final IncorrectlyMentionedMember accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasProfileUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("profileUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(profileUrn));
    }
    if (hasDisplayName)
    {
      paramDataProcessor.startRecordField$505cff1c("displayName");
      paramDataProcessor.processString(displayName);
    }
    if (hasSelf)
    {
      paramDataProcessor.startRecordField$505cff1c("self");
      paramDataProcessor.processBoolean(self);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasProfileUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedMember", "profileUrn");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasDisplayName) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedMember", "displayName");
      }
      return new IncorrectlyMentionedMember(profileUrn, displayName, self, hasProfileUrn, hasDisplayName, hasSelf);
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
      paramObject = (IncorrectlyMentionedMember)paramObject;
      if (profileUrn != null)
      {
        if (profileUrn.equals(profileUrn)) {}
      }
      else {
        while (profileUrn != null) {
          return false;
        }
      }
      if (displayName != null)
      {
        if (displayName.equals(displayName)) {}
      }
      else {
        while (displayName != null) {
          return false;
        }
      }
    } while (self == self);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasProfileUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(profileUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasDisplayName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(displayName);
    }
    j = i + 1;
    i = j;
    if (hasSelf) {
      i = j + 1;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (profileUrn != null)
    {
      i = profileUrn.hashCode();
      if (displayName == null) {
        break label81;
      }
    }
    label81:
    for (int j = displayName.hashCode();; j = 0)
    {
      if (self) {
        k = 1;
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    int i = 1;
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building IncorrectlyMentionedMember");
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
    label173:
    label194:
    label246:
    label256:
    label262:
    label270:
    label272:
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
        localByteBuffer.putInt(1582587438);
        if (hasProfileUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(profileUrn));
          if (!hasDisplayName) {
            break label246;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, displayName);
          if (!hasSelf) {
            break label262;
          }
          localByteBuffer.put((byte)1);
          if (!self) {
            break label256;
          }
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label270;
          }
          if (str != null) {
            break label272;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label173;
          i = 0;
          break label194;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedMember
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */