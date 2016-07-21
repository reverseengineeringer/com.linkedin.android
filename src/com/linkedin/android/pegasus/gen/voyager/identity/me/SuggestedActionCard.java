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
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SuggestedActionCard
  implements FissileDataModel<SuggestedActionCard>, RecordTemplate<SuggestedActionCard>
{
  public static final SuggestedActionCardBuilder BUILDER = SuggestedActionCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final SuggestedAction action;
  public final String body;
  public final String cta;
  public final boolean hasAction;
  public final boolean hasBody;
  public final boolean hasCta;
  public final boolean hasIcon;
  public final boolean hasLegoTrackingToken;
  public final boolean hasTitle;
  public final IconType icon;
  public final String legoTrackingToken;
  public final String title;
  
  SuggestedActionCard(IconType paramIconType, String paramString1, String paramString2, String paramString3, SuggestedAction paramSuggestedAction, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    icon = paramIconType;
    title = paramString1;
    body = paramString2;
    cta = paramString3;
    action = paramSuggestedAction;
    legoTrackingToken = paramString4;
    hasIcon = paramBoolean1;
    hasTitle = paramBoolean2;
    hasBody = paramBoolean3;
    hasCta = paramBoolean4;
    hasAction = paramBoolean5;
    hasLegoTrackingToken = paramBoolean6;
    _cachedId = null;
  }
  
  public final SuggestedActionCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasIcon)
    {
      paramDataProcessor.startRecordField$505cff1c("icon");
      paramDataProcessor.processEnum(icon);
    }
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasBody)
    {
      paramDataProcessor.startRecordField$505cff1c("body");
      paramDataProcessor.processString(body);
    }
    if (hasCta)
    {
      paramDataProcessor.startRecordField$505cff1c("cta");
      paramDataProcessor.processString(cta);
    }
    SuggestedAction localSuggestedAction = null;
    boolean bool = false;
    if (hasAction)
    {
      paramDataProcessor.startRecordField$505cff1c("action");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label218;
      }
      localSuggestedAction = action.accept(paramDataProcessor);
      if (localSuggestedAction == null) {
        break label235;
      }
    }
    label218:
    label235:
    for (bool = true;; bool = false)
    {
      if (hasLegoTrackingToken)
      {
        paramDataProcessor.startRecordField$505cff1c("legoTrackingToken");
        paramDataProcessor.processString(legoTrackingToken);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label309;
      }
      try
      {
        if (hasAction) {
          break label240;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedActionCard", "action");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localSuggestedAction = (SuggestedAction)paramDataProcessor.processDataTemplate(action);
      break;
    }
    label240:
    if (!hasLegoTrackingToken) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedActionCard", "legoTrackingToken");
    }
    return new SuggestedActionCard(icon, title, body, cta, localSuggestedAction, legoTrackingToken, hasIcon, hasTitle, hasBody, hasCta, bool, hasLegoTrackingToken);
    label309:
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
      paramObject = (SuggestedActionCard)paramObject;
      if (icon != null)
      {
        if (icon.equals(icon)) {}
      }
      else {
        while (icon != null) {
          return false;
        }
      }
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (body != null)
      {
        if (body.equals(body)) {}
      }
      else {
        while (body != null) {
          return false;
        }
      }
      if (cta != null)
      {
        if (cta.equals(cta)) {}
      }
      else {
        while (cta != null) {
          return false;
        }
      }
      if (action != null)
      {
        if (action.equals(action)) {}
      }
      else {
        while (action != null) {
          return false;
        }
      }
      if (legoTrackingToken == null) {
        break;
      }
    } while (legoTrackingToken.equals(legoTrackingToken));
    for (;;)
    {
      return false;
      if (legoTrackingToken == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasIcon) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    j = i + 1;
    i = j;
    if (hasBody) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(body);
    }
    j = i + 1;
    i = j;
    if (hasCta) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(cta);
    }
    j = i + 1;
    i = j;
    if (hasAction)
    {
      i = j + 1;
      if (action._cachedId == null) {
        break label182;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(action._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasLegoTrackingToken) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(legoTrackingToken);
      }
      __sizeOfObject = i;
      return i;
      label182:
      i += action.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (icon != null)
    {
      i = icon.hashCode();
      if (title == null) {
        break label154;
      }
      j = title.hashCode();
      if (body == null) {
        break label159;
      }
      k = body.hashCode();
      if (cta == null) {
        break label164;
      }
      m = cta.hashCode();
      label76:
      if (action == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = action.hashCode();; n = 0)
    {
      if (legoTrackingToken != null) {
        i1 = legoTrackingToken.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SuggestedActionCard");
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
    label165:
    label191:
    label217:
    label277:
    label346:
    label356:
    label366:
    label376:
    label401:
    label411:
    label419:
    label421:
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
        localByteBuffer.putInt(-2032998291);
        if (hasIcon)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, icon.ordinal());
          if (!hasTitle) {
            break label346;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasBody) {
            break label356;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, body);
          if (!hasCta) {
            break label366;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, cta);
          if (!hasAction) {
            break label401;
          }
          localByteBuffer.put((byte)1);
          if (action._cachedId == null) {
            break label376;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, action._cachedId);
          action.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasLegoTrackingToken) {
            break label411;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, legoTrackingToken);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label419;
          }
          if (str != null) {
            break label421;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label165;
          localByteBuffer.put((byte)0);
          break label191;
          localByteBuffer.put((byte)0);
          break label217;
          localByteBuffer.put((byte)1);
          action.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label277;
          localByteBuffer.put((byte)0);
          break label277;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedActionCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */