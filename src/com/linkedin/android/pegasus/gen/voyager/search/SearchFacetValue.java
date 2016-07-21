package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchFacetValue
  implements FissileDataModel<SearchFacetValue>, RecordTemplate<SearchFacetValue>
{
  public static final SearchFacetValueBuilder BUILDER = SearchFacetValueBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final int count;
  public final String displayValue;
  public final boolean hasCount;
  public final boolean hasDisplayValue;
  public final boolean hasImage;
  public final boolean hasSelected;
  public final boolean hasValue;
  public final Image image;
  public final boolean selected;
  public final String value;
  
  SearchFacetValue(String paramString1, String paramString2, Image paramImage, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    value = paramString1;
    displayValue = paramString2;
    image = paramImage;
    count = paramInt;
    selected = paramBoolean1;
    hasValue = paramBoolean2;
    hasDisplayValue = paramBoolean3;
    hasImage = paramBoolean4;
    hasCount = paramBoolean5;
    hasSelected = paramBoolean6;
    _cachedId = null;
  }
  
  public final SearchFacetValue accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasValue)
    {
      paramDataProcessor.startRecordField$505cff1c("value");
      paramDataProcessor.processString(value);
    }
    if (hasDisplayValue)
    {
      paramDataProcessor.startRecordField$505cff1c("displayValue");
      paramDataProcessor.processString(displayValue);
    }
    Image localImage = null;
    boolean bool = false;
    if (hasImage)
    {
      paramDataProcessor.startRecordField$505cff1c("image");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label193;
      }
      localImage = image.accept(paramDataProcessor);
      if (localImage == null) {
        break label210;
      }
    }
    label193:
    label210:
    for (bool = true;; bool = false)
    {
      if (hasCount)
      {
        paramDataProcessor.startRecordField$505cff1c("count");
        paramDataProcessor.processInt(count);
      }
      if (hasSelected)
      {
        paramDataProcessor.startRecordField$505cff1c("selected");
        paramDataProcessor.processBoolean(selected);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label314;
      }
      try
      {
        if (hasValue) {
          break label215;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue", "value");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localImage = (Image)paramDataProcessor.processDataTemplate(image);
      break;
    }
    label215:
    if (!hasDisplayValue) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue", "displayValue");
    }
    if (!hasCount) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue", "count");
    }
    if (!hasSelected) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue", "selected");
    }
    return new SearchFacetValue(value, displayValue, localImage, count, selected, hasValue, hasDisplayValue, bool, hasCount, hasSelected);
    label314:
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
      paramObject = (SearchFacetValue)paramObject;
      if (value != null)
      {
        if (value.equals(value)) {}
      }
      else {
        while (value != null) {
          return false;
        }
      }
      if (displayValue != null)
      {
        if (displayValue.equals(displayValue)) {}
      }
      else {
        while (displayValue != null) {
          return false;
        }
      }
      if (image != null)
      {
        if (image.equals(image)) {}
      }
      else {
        while (image != null) {
          return false;
        }
      }
      if (count != count) {
        return false;
      }
    } while (selected == selected);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasValue) {
      i = PegasusBinaryUtils.getEncodedLength(value) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasDisplayValue) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(displayValue);
    }
    j = i + 1;
    i = j;
    if (hasImage)
    {
      i = j + 1;
      if (image._cachedId == null) {
        break label146;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(image._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasCount) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasSelected) {
        i = j + 1;
      }
      __sizeOfObject = i;
      return i;
      label146:
      i += image.getSerializedSize();
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
    if (value != null)
    {
      i = value.hashCode();
      if (displayValue == null) {
        break label116;
      }
      j = displayValue.hashCode();
      label45:
      if (image == null) {
        break label121;
      }
    }
    label116:
    label121:
    for (int k = image.hashCode();; k = 0)
    {
      int n = count;
      if (selected) {
        m = 1;
      }
      i = ((k + (j + (i + 527) * 31) * 31) * 31 + n) * 31 + m;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchFacetValue");
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
    label162:
    label222:
    label246:
    label270:
    label322:
    label332:
    label357:
    label367:
    label377:
    label383:
    label391:
    label393:
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
        localByteBuffer.putInt(-1170772204);
        if (hasValue)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, value);
          if (!hasDisplayValue) {
            break label322;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, displayValue);
          if (!hasImage) {
            break label357;
          }
          localByteBuffer.put((byte)1);
          if (image._cachedId == null) {
            break label332;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
          image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCount) {
            break label367;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(count);
          if (!hasSelected) {
            break label383;
          }
          localByteBuffer.put((byte)1);
          if (!selected) {
            break label377;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label391;
          }
          if (str != null) {
            break label393;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)1);
          image.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label222;
          localByteBuffer.put((byte)0);
          break label222;
          localByteBuffer.put((byte)0);
          break label246;
          i = 0;
          break label270;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */