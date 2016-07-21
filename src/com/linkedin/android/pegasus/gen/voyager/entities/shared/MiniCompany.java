package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MiniCompany
  implements FissileDataModel<MiniCompany>, RecordTemplate<MiniCompany>
{
  public static final MiniCompanyBuilder BUILDER = MiniCompanyBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasLogo;
  public final boolean hasName;
  public final boolean hasObjectUrn;
  public final boolean hasShowcase;
  public final boolean hasTrackingId;
  public final Image logo;
  public final String name;
  public final Urn objectUrn;
  public final boolean showcase;
  public final String trackingId;
  
  MiniCompany(String paramString1, Urn paramUrn1, Urn paramUrn2, String paramString2, Image paramImage, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    trackingId = paramString1;
    objectUrn = paramUrn1;
    entityUrn = paramUrn2;
    name = paramString2;
    logo = paramImage;
    showcase = paramBoolean1;
    hasTrackingId = paramBoolean2;
    hasObjectUrn = paramBoolean3;
    hasEntityUrn = paramBoolean4;
    hasName = paramBoolean5;
    hasLogo = paramBoolean6;
    hasShowcase = paramBoolean7;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn2);
  }
  
  public final MiniCompany accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    if (hasObjectUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("objectUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(objectUrn));
    }
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasName)
    {
      paramDataProcessor.startRecordField$505cff1c("name");
      paramDataProcessor.processString(name);
    }
    Object localObject = null;
    boolean bool = false;
    if (hasLogo)
    {
      paramDataProcessor.startRecordField$505cff1c("logo");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label232;
      }
      localObject = logo.accept(paramDataProcessor);
      if (localObject == null) {
        break label249;
      }
    }
    label232:
    label249:
    for (bool = true;; bool = false)
    {
      if (hasShowcase)
      {
        paramDataProcessor.startRecordField$505cff1c("showcase");
        paramDataProcessor.processBoolean(showcase);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label323;
      }
      try
      {
        if (hasEntityUrn) {
          break label254;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (Image)paramDataProcessor.processDataTemplate(logo);
      break;
    }
    label254:
    if (!hasName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany", "name");
    }
    return new MiniCompany(trackingId, objectUrn, entityUrn, name, (Image)localObject, showcase, hasTrackingId, hasObjectUrn, hasEntityUrn, hasName, bool, hasShowcase);
    label323:
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
      paramObject = (MiniCompany)paramObject;
      if (objectUrn != null)
      {
        if (objectUrn.equals(objectUrn)) {}
      }
      else {
        while (objectUrn != null) {
          return false;
        }
      }
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (name != null)
      {
        if (name.equals(name)) {}
      }
      else {
        while (name != null) {
          return false;
        }
      }
      if (logo != null)
      {
        if (logo.equals(logo)) {}
      }
      else {
        while (logo != null) {
          return false;
        }
      }
    } while (showcase == showcase);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasTrackingId) {
      i = PegasusBinaryUtils.getEncodedLength(trackingId) + 8;
    }
    int j = i + 1;
    i = j;
    UrnCoercer localUrnCoercer;
    if (hasObjectUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(objectUrn));
    }
    j = i + 1;
    i = j;
    if (hasEntityUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    j = i + 1;
    i = j;
    if (hasName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(name);
    }
    j = i + 1;
    i = j;
    if (hasLogo)
    {
      i = j + 1;
      if (logo._cachedId == null) {
        break label193;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(logo._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasShowcase) {
        i = j + 1;
      }
      __sizeOfObject = i;
      return i;
      label193:
      i += logo.getSerializedSize();
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
    if (objectUrn != null)
    {
      i = objectUrn.hashCode();
      if (entityUrn == null) {
        break label126;
      }
      j = entityUrn.hashCode();
      if (name == null) {
        break label131;
      }
      k = name.hashCode();
      label60:
      if (logo == null) {
        break label136;
      }
    }
    label126:
    label131:
    label136:
    for (int m = logo.hashCode();; m = 0)
    {
      if (showcase) {
        n = 1;
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MiniCompany");
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
    label170:
    label204:
    label230:
    label290:
    label314:
    label366:
    label376:
    label386:
    label396:
    label421:
    label431:
    label437:
    label445:
    label447:
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
        localByteBuffer.putInt(-1156010613);
        if (hasTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasObjectUrn) {
            break label366;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
          if (!hasEntityUrn) {
            break label376;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasName) {
            break label386;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasLogo) {
            break label421;
          }
          localByteBuffer.put((byte)1);
          if (logo._cachedId == null) {
            break label396;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, logo._cachedId);
          logo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasShowcase) {
            break label437;
          }
          localByteBuffer.put((byte)1);
          if (!showcase) {
            break label431;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label445;
          }
          if (str != null) {
            break label447;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          logo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          i = 0;
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
  
  public static final class Builder
    implements RecordTemplateBuilder<MiniCompany>
  {
    private Urn entityUrn = null;
    private boolean hasEntityUrn = false;
    private boolean hasLogo = false;
    private boolean hasName = false;
    private boolean hasObjectUrn = false;
    private boolean hasShowcase = false;
    private boolean hasTrackingId = false;
    private Image logo = null;
    private String name = null;
    private Urn objectUrn = null;
    private boolean showcase = false;
    private String trackingId = null;
    
    public final MiniCompany build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (MiniCompany.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new MiniCompany(trackingId, objectUrn, entityUrn, name, logo, showcase, hasTrackingId, hasObjectUrn, hasEntityUrn, hasName, hasLogo, hasShowcase);
        if (!hasEntityUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany", "entityUrn");
        }
      } while (hasName);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany", "name");
    }
    
    public final Builder setEntityUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasEntityUrn = false;
        entityUrn = null;
        return this;
      }
      hasEntityUrn = true;
      entityUrn = paramUrn;
      return this;
    }
    
    public final Builder setLogo(Image paramImage)
    {
      if (paramImage == null)
      {
        hasLogo = false;
        logo = null;
        return this;
      }
      hasLogo = true;
      logo = paramImage;
      return this;
    }
    
    public final Builder setName(String paramString)
    {
      if (paramString == null)
      {
        hasName = false;
        name = null;
        return this;
      }
      hasName = true;
      name = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */