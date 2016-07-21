package com.linkedin.android.pegasus.gen.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.jackson.JacksonJsonGenerator;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public final class JsonModel
  implements FissileDataModel<JsonModel>, RecordTemplate<JsonModel>
{
  public static final JsonModelBuilder BUILDER = JsonModelBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final JSONObject jsonObject;
  
  public JsonModel(JSONObject paramJSONObject)
  {
    jsonObject = paramJSONObject;
  }
  
  private JsonModel accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      throw new DataProcessorException("JsonModel cannot return processed record template.");
    }
    if ((paramDataProcessor instanceof JacksonJsonGenerator)) {
      ((JacksonJsonGenerator)paramDataProcessor).processJsonString(jsonObject.toString());
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
      paramObject = (JsonModel)paramObject;
      if (jsonObject != null) {
        break;
      }
    } while (jsonObject == null);
    for (;;)
    {
      return false;
      if (jsonObject.equals(jsonObject)) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = PegasusBinaryUtils.getEncodedLength(jsonObject.toString()) + 5;
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (jsonObject == null) {}
    for (int i = 0;; i = jsonObject.hashCode())
    {
      i += 527;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return null;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    if ((paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building JsonModel");
    }
    if (paramBoolean) {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
    }
    ByteBuffer localByteBuffer;
    do
    {
      return;
      localByteBuffer = paramByteBuffer;
      if (paramByteBuffer == null) {
        localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
      }
      localByteBuffer.put((byte)1);
      localByteBuffer.putInt(1496800382);
      paramFissionAdapter.writeString(localByteBuffer, jsonObject.toString());
    } while (paramByteBuffer != null);
    paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
    paramFissionAdapter.recycle(localByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.JsonModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */