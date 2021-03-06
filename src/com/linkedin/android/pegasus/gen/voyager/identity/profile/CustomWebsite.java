package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CustomWebsite
  implements FissileDataModel<CustomWebsite>, RecordTemplate<CustomWebsite>
{
  public static final CustomWebsiteBuilder BUILDER = CustomWebsiteBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasLabel;
  public final String label;
  
  CustomWebsite(String paramString, boolean paramBoolean)
  {
    label = paramString;
    hasLabel = paramBoolean;
    _cachedId = null;
  }
  
  public final CustomWebsite accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasLabel)
    {
      paramDataProcessor.startRecordField$505cff1c("label");
      paramDataProcessor.processString(label);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new CustomWebsite(label, hasLabel);
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
      paramObject = (CustomWebsite)paramObject;
      if (label == null) {
        break;
      }
    } while (label.equals(label));
    for (;;)
    {
      return false;
      if (label == null) {
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
    if (hasLabel) {
      i = PegasusBinaryUtils.getEncodedLength(label) + 8;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (label != null) {}
    for (int i = label.hashCode();; i = 0)
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CustomWebsite");
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
    label179:
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
        localByteBuffer.putInt(-218464706);
        if (hasLabel)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, label);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label179;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
  
  public static final class Builder
    implements RecordTemplateBuilder<CustomWebsite>
  {
    private boolean hasLabel = false;
    private String label = null;
    
    public final CustomWebsite build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      int[] arrayOfInt = CustomWebsite.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
      paramFlavor.ordinal();
      return new CustomWebsite(label, hasLabel);
    }
    
    public final Builder setLabel(String paramString)
    {
      if (paramString == null)
      {
        hasLabel = false;
        label = null;
        return this;
      }
      hasLabel = true;
      label = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.CustomWebsite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */