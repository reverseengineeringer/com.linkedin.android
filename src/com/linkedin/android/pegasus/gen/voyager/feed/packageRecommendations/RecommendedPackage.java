package com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class RecommendedPackage
  implements FissileDataModel<RecommendedPackage>, RecordTemplate<RecommendedPackage>
{
  public static final RecommendedPackageBuilder BUILDER = RecommendedPackageBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasPackageId;
  public final boolean hasReason;
  public final boolean hasRecommendationType;
  public final boolean hasRecommendedEntities;
  public final boolean hasSecondaryReason;
  public final int packageId;
  public final AnnotatedText reason;
  public final RecommendationType recommendationType;
  public final List<RecommendedEntity> recommendedEntities;
  public final AnnotatedText secondaryReason;
  
  RecommendedPackage(int paramInt, RecommendationType paramRecommendationType, AnnotatedText paramAnnotatedText1, AnnotatedText paramAnnotatedText2, List<RecommendedEntity> paramList, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    packageId = paramInt;
    recommendationType = paramRecommendationType;
    reason = paramAnnotatedText1;
    secondaryReason = paramAnnotatedText2;
    if (paramList == null) {}
    for (paramRecommendationType = null;; paramRecommendationType = Collections.unmodifiableList(paramList))
    {
      recommendedEntities = paramRecommendationType;
      entityUrn = paramUrn;
      hasPackageId = paramBoolean1;
      hasRecommendationType = paramBoolean2;
      hasReason = paramBoolean3;
      hasSecondaryReason = paramBoolean4;
      hasRecommendedEntities = paramBoolean5;
      hasEntityUrn = paramBoolean6;
      paramRecommendationType = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
    }
  }
  
  private RecommendedPackage accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPackageId)
    {
      paramDataProcessor.startRecordField$505cff1c("packageId");
      paramDataProcessor.processInt(packageId);
    }
    if (hasRecommendationType)
    {
      paramDataProcessor.startRecordField$505cff1c("recommendationType");
      paramDataProcessor.processEnum(recommendationType);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label106:
    Object localObject3;
    boolean bool2;
    label146:
    label158:
    int i;
    if (hasReason)
    {
      paramDataProcessor.startRecordField$505cff1c("reason");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = reason.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label324;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasSecondaryReason)
      {
        paramDataProcessor.startRecordField$505cff1c("secondaryReason");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label333;
        }
        localObject1 = secondaryReason.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label351;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject1 = null;
      localObject4 = null;
      bool3 = false;
      if (!hasRecommendedEntities) {
        break label391;
      }
      paramDataProcessor.startRecordField$505cff1c("recommendedEntities");
      recommendedEntities.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject4;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = recommendedEntities.iterator();
      label233:
      if (!localIterator.hasNext()) {
        break label377;
      }
      localObject4 = (RecommendedEntity)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label361;
      }
    }
    label324:
    label333:
    label351:
    label361:
    for (Object localObject4 = ((RecommendedEntity)localObject4).accept(paramDataProcessor);; localObject4 = (RecommendedEntity)paramDataProcessor.processDataTemplate((DataTemplate)localObject4))
    {
      if ((localObject1 != null) && (localObject4 != null)) {
        ((List)localObject1).add(localObject4);
      }
      i += 1;
      break label233;
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(reason);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label106;
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(secondaryReason);
      break label146;
      bool2 = false;
      localObject3 = localObject1;
      break label158;
    }
    label377:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      label391:
      if (hasEntityUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("entityUrn");
        localObject4 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label586;
      }
      try
      {
        if (hasRecommendationType) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage", "recommendationType");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasRecommendedEntities) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage", "recommendedEntities");
    }
    if (recommendedEntities != null)
    {
      paramDataProcessor = recommendedEntities.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((RecommendedEntity)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage", "recommendedEntities");
        }
      }
    }
    return new RecommendedPackage(packageId, recommendationType, (AnnotatedText)localObject2, (AnnotatedText)localObject3, (List)localObject1, entityUrn, hasPackageId, hasRecommendationType, bool1, bool2, bool3, hasEntityUrn);
    label586:
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
      paramObject = (RecommendedPackage)paramObject;
      if (packageId != packageId) {
        return false;
      }
      if (recommendationType != null)
      {
        if (recommendationType.equals(recommendationType)) {}
      }
      else {
        while (recommendationType != null) {
          return false;
        }
      }
      if (reason != null)
      {
        if (reason.equals(reason)) {}
      }
      else {
        while (reason != null) {
          return false;
        }
      }
      if (secondaryReason != null)
      {
        if (secondaryReason.equals(secondaryReason)) {}
      }
      else {
        while (secondaryReason != null) {
          return false;
        }
      }
      if (recommendedEntities != null)
      {
        if (recommendedEntities.equals(recommendedEntities)) {}
      }
      else {
        while (recommendedEntities != null) {
          return false;
        }
      }
      if (entityUrn == null) {
        break;
      }
    } while (entityUrn.equals(entityUrn));
    for (;;)
    {
      return false;
      if (entityUrn == null) {
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
    if (hasPackageId) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasRecommendationType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    label134:
    Object localObject;
    if (hasReason)
    {
      i = j + 1;
      if (reason._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(reason._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasSecondaryReason)
      {
        i = j + 1;
        if (secondaryReason._cachedId == null) {
          break label224;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(secondaryReason._cachedId);
      }
      i += 1;
      j = i;
      if (!hasRecommendedEntities) {
        break label248;
      }
      i += 2;
      localObject = recommendedEntities.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label248;
      }
      RecommendedEntity localRecommendedEntity = (RecommendedEntity)((Iterator)localObject).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += reason.getSerializedSize();
        break;
        label224:
        i += secondaryReason.getSerializedSize();
        break label134;
      }
      i += localRecommendedEntity.getSerializedSize();
    }
    label248:
    j += 1;
    i = j;
    if (hasEntityUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i1 = packageId;
    int i;
    int j;
    label51:
    int k;
    if (recommendationType != null)
    {
      i = recommendationType.hashCode();
      if (reason == null) {
        break label146;
      }
      j = reason.hashCode();
      if (secondaryReason == null) {
        break label151;
      }
      k = secondaryReason.hashCode();
      label66:
      if (recommendedEntities == null) {
        break label156;
      }
    }
    label146:
    label151:
    label156:
    for (int m = recommendedEntities.hashCode();; m = 0)
    {
      if (entityUrn != null) {
        n = entityUrn.hashCode();
      }
      i = (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label51;
      k = 0;
      break label66;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building RecommendedPackage");
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
    label225:
    label285:
    label402:
    label412:
    label437:
    label447:
    label472:
    label505:
    label512:
    label589:
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
        localByteBuffer.putInt(-1867306754);
        Object localObject;
        if (hasPackageId)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(packageId);
          if (!hasRecommendationType) {
            break label402;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, recommendationType.ordinal());
          if (!hasReason) {
            break label437;
          }
          localByteBuffer.put((byte)1);
          if (reason._cachedId == null) {
            break label412;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, reason._cachedId);
          reason.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSecondaryReason) {
            break label472;
          }
          localByteBuffer.put((byte)1);
          if (secondaryReason._cachedId == null) {
            break label447;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, secondaryReason._cachedId);
          secondaryReason.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasRecommendedEntities) {
            break label505;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, recommendedEntities.size());
          localObject = recommendedEntities.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label512;
          }
          RecommendedEntity localRecommendedEntity = (RecommendedEntity)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localRecommendedEntity.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label165;
            localByteBuffer.put((byte)1);
            reason.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label225;
            localByteBuffer.put((byte)0);
            break label225;
            localByteBuffer.put((byte)1);
            secondaryReason.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label285;
            localByteBuffer.put((byte)0);
            break label285;
          }
          localByteBuffer.put((byte)1);
          localRecommendedEntity.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label589;
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
    implements RecordTemplateBuilder<RecommendedPackage>
  {
    private Urn entityUrn = null;
    private boolean hasEntityUrn = false;
    public boolean hasPackageId = false;
    public boolean hasReason = false;
    public boolean hasRecommendationType = false;
    public boolean hasRecommendedEntities = false;
    private boolean hasSecondaryReason = false;
    public int packageId = 0;
    public AnnotatedText reason = null;
    public RecommendationType recommendationType = null;
    public List<RecommendedEntity> recommendedEntities = null;
    private AnnotatedText secondaryReason = null;
    
    public final RecommendedPackage build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (RecommendedPackage.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (recommendedEntities != null)
      {
        paramFlavor = recommendedEntities.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((RecommendedEntity)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage", "recommendedEntities");
              if (!hasRecommendationType) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage", "recommendationType");
              }
              if (hasRecommendedEntities) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage", "recommendedEntities");
            }
          }
        }
      }
      return new RecommendedPackage(packageId, recommendationType, reason, secondaryReason, recommendedEntities, entityUrn, hasPackageId, hasRecommendationType, hasReason, hasSecondaryReason, hasRecommendedEntities, hasEntityUrn);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */