package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpPremiumUpsellType;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class WvmpPremiumUpsellCard
  implements FissileDataModel<WvmpPremiumUpsellCard>, RecordTemplate<WvmpPremiumUpsellCard>
{
  public static final WvmpPremiumUpsellCardBuilder BUILDER = WvmpPremiumUpsellCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AttributedText body;
  public final AttributedText cta;
  public final long extraProfileViewers;
  public final boolean hasBody;
  public final boolean hasCta;
  public final boolean hasExtraProfileViewers;
  public final boolean hasPremiumUpsellType;
  public final boolean hasTitle;
  public final WvmpPremiumUpsellType premiumUpsellType;
  public final AttributedText title;
  
  WvmpPremiumUpsellCard(long paramLong, AttributedText paramAttributedText1, AttributedText paramAttributedText2, AttributedText paramAttributedText3, WvmpPremiumUpsellType paramWvmpPremiumUpsellType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    extraProfileViewers = paramLong;
    title = paramAttributedText1;
    body = paramAttributedText2;
    cta = paramAttributedText3;
    premiumUpsellType = paramWvmpPremiumUpsellType;
    hasExtraProfileViewers = paramBoolean1;
    hasTitle = paramBoolean2;
    hasBody = paramBoolean3;
    hasCta = paramBoolean4;
    hasPremiumUpsellType = paramBoolean5;
    _cachedId = null;
  }
  
  public final WvmpPremiumUpsellCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasExtraProfileViewers)
    {
      paramDataProcessor.startRecordField$505cff1c("extraProfileViewers");
      paramDataProcessor.processLong(extraProfileViewers);
    }
    Object localObject = null;
    boolean bool1 = false;
    AttributedText localAttributedText1;
    label81:
    AttributedText localAttributedText2;
    boolean bool2;
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localAttributedText1 = title.accept(paramDataProcessor);
        if (localAttributedText1 == null) {
          break label266;
        }
        bool1 = true;
        localObject = localAttributedText1;
      }
    }
    else
    {
      localAttributedText2 = null;
      bool2 = false;
      if (hasBody)
      {
        paramDataProcessor.startRecordField$505cff1c("body");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label275;
        }
        localAttributedText1 = body.accept(paramDataProcessor);
        label120:
        if (localAttributedText1 == null) {
          break label293;
        }
        bool2 = true;
        localAttributedText2 = localAttributedText1;
      }
      label131:
      localAttributedText1 = null;
      bool3 = false;
      if (hasCta)
      {
        paramDataProcessor.startRecordField$505cff1c("cta");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label302;
        }
        localAttributedText1 = cta.accept(paramDataProcessor);
        label171:
        if (localAttributedText1 == null) {
          break label320;
        }
      }
    }
    label266:
    label275:
    label293:
    label302:
    label320:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasPremiumUpsellType)
      {
        paramDataProcessor.startRecordField$505cff1c("premiumUpsellType");
        paramDataProcessor.processEnum(premiumUpsellType);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label417;
      }
      try
      {
        if (hasExtraProfileViewers) {
          break label326;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCard", "extraProfileViewers");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localAttributedText1 = (AttributedText)paramDataProcessor.processDataTemplate(title);
      break;
      bool1 = false;
      localObject = localAttributedText1;
      break label81;
      localAttributedText1 = (AttributedText)paramDataProcessor.processDataTemplate(body);
      break label120;
      bool2 = false;
      localAttributedText2 = localAttributedText1;
      break label131;
      localAttributedText1 = (AttributedText)paramDataProcessor.processDataTemplate(cta);
      break label171;
    }
    label326:
    if (!hasTitle) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCard", "title");
    }
    if (!hasBody) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCard", "body");
    }
    if (!hasCta) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCard", "cta");
    }
    return new WvmpPremiumUpsellCard(extraProfileViewers, (AttributedText)localObject, localAttributedText2, localAttributedText1, premiumUpsellType, hasExtraProfileViewers, bool1, bool2, bool3, hasPremiumUpsellType);
    label417:
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
      paramObject = (WvmpPremiumUpsellCard)paramObject;
      if (extraProfileViewers != extraProfileViewers) {
        return false;
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
      if (premiumUpsellType == null) {
        break;
      }
    } while (premiumUpsellType.equals(premiumUpsellType));
    for (;;)
    {
      return false;
      if (premiumUpsellType == null) {
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
    if (hasExtraProfileViewers) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasTitle)
    {
      i = j + 1;
      if (title._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(title._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasBody)
      {
        i = j + 1;
        if (body._cachedId == null) {
          break label197;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(body._cachedId);
      }
      label118:
      j = i + 1;
      i = j;
      if (hasCta)
      {
        i = j + 1;
        if (cta._cachedId == null) {
          break label210;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(cta._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasPremiumUpsellType) {
        i = j + 2;
      }
      __sizeOfObject = i;
      return i;
      i += title.getSerializedSize();
      break;
      label197:
      i += body.getSerializedSize();
      break label118;
      label210:
      i += cta.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int n = (int)(extraProfileViewers ^ extraProfileViewers >>> 32);
    int i;
    int j;
    if (title != null)
    {
      i = title.hashCode();
      if (body == null) {
        break label131;
      }
      j = body.hashCode();
      label60:
      if (cta == null) {
        break label136;
      }
    }
    label131:
    label136:
    for (int k = cta.hashCode();; k = 0)
    {
      if (premiumUpsellType != null) {
        m = premiumUpsellType.hashCode();
      }
      i = (k + (j + (i + (n + 527) * 31) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building WvmpPremiumUpsellCard");
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
    label194:
    label254:
    label314:
    label386:
    label411:
    label421:
    label446:
    label456:
    label481:
    label491:
    label499:
    label501:
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
        localByteBuffer.putInt(-265822634);
        if (hasExtraProfileViewers)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(extraProfileViewers);
          if (!hasTitle) {
            break label411;
          }
          localByteBuffer.put((byte)1);
          if (title._cachedId == null) {
            break label386;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, title._cachedId);
          title.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasBody) {
            break label446;
          }
          localByteBuffer.put((byte)1);
          if (body._cachedId == null) {
            break label421;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, body._cachedId);
          body.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCta) {
            break label481;
          }
          localByteBuffer.put((byte)1);
          if (cta._cachedId == null) {
            break label456;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, cta._cachedId);
          cta.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPremiumUpsellType) {
            break label491;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, premiumUpsellType.ordinal());
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label499;
          }
          if (str != null) {
            break label501;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          title.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label194;
          localByteBuffer.put((byte)0);
          break label194;
          localByteBuffer.put((byte)1);
          body.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label254;
          localByteBuffer.put((byte)0);
          break label254;
          localByteBuffer.put((byte)1);
          cta.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label314;
          localByteBuffer.put((byte)0);
          break label314;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */