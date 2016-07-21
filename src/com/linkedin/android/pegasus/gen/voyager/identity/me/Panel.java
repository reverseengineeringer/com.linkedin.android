package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Panel
  implements FissileDataModel<Panel>, RecordTemplate<Panel>
{
  public static final PanelBuilder BUILDER = PanelBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasValue;
  public final Value value;
  
  Panel(Value paramValue, boolean paramBoolean)
  {
    value = paramValue;
    hasValue = paramBoolean;
    _cachedId = null;
  }
  
  private Panel accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Value localValue = null;
    boolean bool = false;
    if (hasValue)
    {
      paramDataProcessor.startRecordField$505cff1c("value");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label93;
      }
      localValue = value.accept(paramDataProcessor);
      if (localValue == null) {
        break label110;
      }
    }
    label93:
    label110:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label125;
      }
      try
      {
        if (hasValue) {
          break label115;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.Panel", "value");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localValue = (Value)paramDataProcessor.processDataTemplate(value);
      break;
    }
    label115:
    return new Panel(localValue, bool);
    label125:
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
      paramObject = (Panel)paramObject;
      if (value == null) {
        break;
      }
    } while (value.equals(value));
    for (;;)
    {
      return false;
      if (value == null) {
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
    if (hasValue) {
      if (value._cachedId == null) {
        break label58;
      }
    }
    label58:
    for (i = PegasusBinaryUtils.getEncodedLength(value._cachedId) + 9;; i = value.getSerializedSize() + 7)
    {
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (value != null) {}
    for (int i = value.hashCode();; i = 0)
    {
      i += 527;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Panel");
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
    label238:
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
        localByteBuffer.putInt(-2056026174);
        if (hasValue)
        {
          localByteBuffer.put((byte)1);
          if (value._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, value._cachedId);
            value.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label238;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          value.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Value
    implements FissileDataModel<Value>, UnionTemplate<Value>
  {
    public static final PanelBuilder.ValueBuilder BUILDER = PanelBuilder.ValueBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasProfileViewsByTimePanelValue;
    public final ProfileViewsByTimePanel profileViewsByTimePanelValue;
    
    Value(ProfileViewsByTimePanel paramProfileViewsByTimePanel, boolean paramBoolean)
    {
      profileViewsByTimePanelValue = paramProfileViewsByTimePanel;
      hasProfileViewsByTimePanelValue = paramBoolean;
      _cachedId = null;
    }
    
    public final Value accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      ProfileViewsByTimePanel localProfileViewsByTimePanel = null;
      boolean bool = false;
      if (hasProfileViewsByTimePanelValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.ProfileViewsByTimePanel");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label74;
        }
        localProfileViewsByTimePanel = profileViewsByTimePanelValue.accept(paramDataProcessor);
        if (localProfileViewsByTimePanel == null) {
          break label91;
        }
      }
      label74:
      label91:
      for (bool = true;; bool = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label96;
        }
        return new Value(localProfileViewsByTimePanel, bool);
        localProfileViewsByTimePanel = (ProfileViewsByTimePanel)paramDataProcessor.processDataTemplate(profileViewsByTimePanelValue);
        break;
      }
      label96:
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
        paramObject = (Value)paramObject;
        if (profileViewsByTimePanelValue == null) {
          break;
        }
      } while (profileViewsByTimePanelValue.equals(profileViewsByTimePanelValue));
      for (;;)
      {
        return false;
        if (profileViewsByTimePanelValue == null) {
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
      if (hasProfileViewsByTimePanelValue) {
        if (profileViewsByTimePanelValue._cachedId == null) {
          break label58;
        }
      }
      label58:
      for (i = PegasusBinaryUtils.getEncodedLength(profileViewsByTimePanelValue._cachedId) + 9;; i = profileViewsByTimePanelValue.getSerializedSize() + 7)
      {
        __sizeOfObject = i;
        return i;
      }
    }
    
    public final int hashCode()
    {
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (profileViewsByTimePanelValue != null) {}
      for (int i = profileViewsByTimePanelValue.hashCode();; i = 0)
      {
        i += 527;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Value");
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
      label238:
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
          localByteBuffer.putInt(-1354399703);
          if (hasProfileViewsByTimePanelValue)
          {
            localByteBuffer.put((byte)1);
            if (profileViewsByTimePanelValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, profileViewsByTimePanelValue._cachedId);
              profileViewsByTimePanelValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          while (paramByteBuffer == null)
          {
            if (str != null) {
              break label238;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            profileViewsByTimePanelValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.Panel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */