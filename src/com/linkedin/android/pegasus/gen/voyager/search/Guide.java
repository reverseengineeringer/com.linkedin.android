package com.linkedin.android.pegasus.gen.voyager.search;

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

public final class Guide
  implements FissileDataModel<Guide>, RecordTemplate<Guide>
{
  public static final GuideBuilder BUILDER = GuideBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String displayText;
  public final GuideInfo guideInfo;
  public final boolean hasDisplayText;
  public final boolean hasGuideInfo;
  public final boolean hasSelected;
  public final boolean hasType;
  public final boolean hasUrlParameter;
  public final boolean selected;
  public final GuideType type;
  public final String urlParameter;
  
  Guide(String paramString1, String paramString2, boolean paramBoolean1, GuideType paramGuideType, GuideInfo paramGuideInfo, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    urlParameter = paramString1;
    displayText = paramString2;
    selected = paramBoolean1;
    type = paramGuideType;
    guideInfo = paramGuideInfo;
    hasUrlParameter = paramBoolean2;
    hasDisplayText = paramBoolean3;
    hasSelected = paramBoolean4;
    hasType = paramBoolean5;
    hasGuideInfo = paramBoolean6;
    _cachedId = null;
  }
  
  public final Guide accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasUrlParameter)
    {
      paramDataProcessor.startRecordField$505cff1c("urlParameter");
      paramDataProcessor.processString(urlParameter);
    }
    if (hasDisplayText)
    {
      paramDataProcessor.startRecordField$505cff1c("displayText");
      paramDataProcessor.processString(displayText);
    }
    if (hasSelected)
    {
      paramDataProcessor.startRecordField$505cff1c("selected");
      paramDataProcessor.processBoolean(selected);
    }
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processEnum(type);
    }
    GuideInfo localGuideInfo = null;
    boolean bool = false;
    if (hasGuideInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("guideInfo");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label193;
      }
      localGuideInfo = guideInfo.accept(paramDataProcessor);
      if (localGuideInfo == null) {
        break label210;
      }
    }
    label193:
    label210:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label333;
      }
      try
      {
        if (hasUrlParameter) {
          break label215;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.Guide", "urlParameter");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localGuideInfo = (GuideInfo)paramDataProcessor.processDataTemplate(guideInfo);
      break;
    }
    label215:
    if (!hasDisplayText) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.Guide", "displayText");
    }
    if (!hasSelected) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.Guide", "selected");
    }
    if (!hasType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.Guide", "type");
    }
    if (!hasGuideInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.Guide", "guideInfo");
    }
    return new Guide(urlParameter, displayText, selected, type, localGuideInfo, hasUrlParameter, hasDisplayText, hasSelected, hasType, bool);
    label333:
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
      paramObject = (Guide)paramObject;
      if (urlParameter != null)
      {
        if (urlParameter.equals(urlParameter)) {}
      }
      else {
        while (urlParameter != null) {
          return false;
        }
      }
      if (displayText != null)
      {
        if (displayText.equals(displayText)) {}
      }
      else {
        while (displayText != null) {
          return false;
        }
      }
      if (selected != selected) {
        return false;
      }
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (guideInfo == null) {
        break;
      }
    } while (guideInfo.equals(guideInfo));
    for (;;)
    {
      return false;
      if (guideInfo == null) {
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
    if (hasUrlParameter) {
      i = PegasusBinaryUtils.getEncodedLength(urlParameter) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasDisplayText) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(displayText);
    }
    j = i + 1;
    i = j;
    if (hasSelected) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasGuideInfo)
    {
      i = j + 1;
      if (guideInfo._cachedId == null) {
        break label146;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(guideInfo._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label146:
      i += guideInfo.getSerializedSize();
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
    label45:
    int k;
    if (urlParameter != null)
    {
      i = urlParameter.hashCode();
      if (displayText == null) {
        break label126;
      }
      j = displayText.hashCode();
      if (!selected) {
        break label131;
      }
      k = 1;
      label54:
      if (type == null) {
        break label136;
      }
    }
    label126:
    label131:
    label136:
    for (int m = type.hashCode();; m = 0)
    {
      if (guideInfo != null) {
        n = guideInfo.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label54;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Guide");
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
    label186:
    label195:
    label224:
    label327:
    label337:
    label343:
    label353:
    label363:
    label388:
    label396:
    label398:
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
        localByteBuffer.putInt(-65969463);
        if (hasUrlParameter)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, urlParameter);
          if (!hasDisplayText) {
            break label327;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, displayText);
          if (!hasSelected) {
            break label343;
          }
          localByteBuffer.put((byte)1);
          if (!selected) {
            break label337;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasType) {
            break label353;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
          if (!hasGuideInfo) {
            break label388;
          }
          localByteBuffer.put((byte)1);
          if (guideInfo._cachedId == null) {
            break label363;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, guideInfo._cachedId);
          guideInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label396;
          }
          if (str != null) {
            break label398;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          i = 0;
          break label186;
          localByteBuffer.put((byte)0);
          break label195;
          localByteBuffer.put((byte)0);
          break label224;
          localByteBuffer.put((byte)1);
          guideInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class GuideInfo
    implements FissileDataModel<GuideInfo>, UnionTemplate<GuideInfo>
  {
    public static final GuideBuilder.GuideInfoBuilder BUILDER = GuideBuilder.GuideInfoBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final FacetGuide facetGuideValue;
    public final boolean hasFacetGuideValue;
    public final boolean hasVerticalGuideValue;
    public final VerticalGuide verticalGuideValue;
    
    GuideInfo(FacetGuide paramFacetGuide, VerticalGuide paramVerticalGuide, boolean paramBoolean1, boolean paramBoolean2)
    {
      facetGuideValue = paramFacetGuide;
      verticalGuideValue = paramVerticalGuide;
      hasFacetGuideValue = paramBoolean1;
      hasVerticalGuideValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final GuideInfo accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasFacetGuideValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.FacetGuide");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = FacetGuide.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label145;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        label52:
        localObject1 = null;
        bool2 = false;
        if (hasVerticalGuideValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.search.VerticalGuide");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label154;
          }
          localObject1 = verticalGuideValue.accept(paramDataProcessor);
          label91:
          if (localObject1 == null) {
            break label172;
          }
        }
      }
      label145:
      label154:
      label172:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label177;
        }
        return new GuideInfo((FacetGuide)localObject2, (VerticalGuide)localObject1, bool1, bool2);
        localObject1 = (FacetGuide)paramDataProcessor.processDataTemplate(facetGuideValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label52;
        localObject1 = (VerticalGuide)paramDataProcessor.processDataTemplate(verticalGuideValue);
        break label91;
      }
      label177:
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
        paramObject = (GuideInfo)paramObject;
        if (facetGuideValue != null)
        {
          if (facetGuideValue.equals(facetGuideValue)) {}
        }
        else {
          while (facetGuideValue != null) {
            return false;
          }
        }
        if (verticalGuideValue == null) {
          break;
        }
      } while (verticalGuideValue.equals(verticalGuideValue));
      for (;;)
      {
        return false;
        if (verticalGuideValue == null) {
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
      if (hasFacetGuideValue)
      {
        if (facetGuideValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(facetGuideValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasVerticalGuideValue)
        {
          i = j + 1;
          if (verticalGuideValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(verticalGuideValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = facetGuideValue.getSerializedSize() + 7;
        break;
        label114:
        i += verticalGuideValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (facetGuideValue != null) {}
      for (int i = facetGuideValue.hashCode();; i = 0)
      {
        if (verticalGuideValue != null) {
          j = verticalGuideValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building GuideInfo");
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
      label298:
      label323:
      label331:
      label333:
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
          localByteBuffer.putInt(-1449374883);
          if (hasFacetGuideValue)
          {
            localByteBuffer.put((byte)1);
            if (facetGuideValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, facetGuideValue._cachedId);
              facetGuideValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasVerticalGuideValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (verticalGuideValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, verticalGuideValue._cachedId);
              verticalGuideValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label331;
            }
            if (str != null) {
              break label333;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            facetGuideValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            verticalGuideValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.Guide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */