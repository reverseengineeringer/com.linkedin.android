package com.linkedin.android.pegasus.gen.voyager.growth.seo;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SameNameProfileResult
  implements FissileDataModel<SameNameProfileResult>, RecordTemplate<SameNameProfileResult>
{
  public static final SameNameProfileResultBuilder BUILDER = SameNameProfileResultBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final List<String> currentPositions;
  public final List<String> education;
  public final boolean hasCurrentPositions;
  public final boolean hasEducation;
  public final boolean hasIndustry;
  public final boolean hasLocation;
  public final boolean hasMiniProfile;
  public final boolean hasPastPositions;
  public final boolean hasSummary;
  public final String industry;
  public final String location;
  public final MiniProfile miniProfile;
  public final List<String> pastPositions;
  public final String summary;
  
  SameNameProfileResult(List<String> paramList1, String paramString1, String paramString2, MiniProfile paramMiniProfile, List<String> paramList2, List<String> paramList3, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    if (paramList1 == null)
    {
      paramList1 = null;
      education = paramList1;
      industry = paramString1;
      location = paramString2;
      miniProfile = paramMiniProfile;
      if (paramList2 != null) {
        break label127;
      }
      paramList1 = null;
      label48:
      currentPositions = paramList1;
      if (paramList3 != null) {
        break label136;
      }
    }
    label127:
    label136:
    for (paramList1 = null;; paramList1 = Collections.unmodifiableList(paramList3))
    {
      pastPositions = paramList1;
      summary = paramString3;
      hasEducation = paramBoolean1;
      hasIndustry = paramBoolean2;
      hasLocation = paramBoolean3;
      hasMiniProfile = paramBoolean4;
      hasCurrentPositions = paramBoolean5;
      hasPastPositions = paramBoolean6;
      hasSummary = paramBoolean7;
      _cachedId = null;
      return;
      paramList1 = Collections.unmodifiableList(paramList1);
      break;
      paramList1 = Collections.unmodifiableList(paramList2);
      break label48;
    }
  }
  
  private SameNameProfileResult accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    int i;
    Object localObject3;
    boolean bool2;
    if (hasEducation)
    {
      paramDataProcessor.startRecordField$505cff1c("education");
      education.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject2 = education.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject3);
        if (localObject1 != null) {
          ((List)localObject1).add(localObject3);
        }
        i += 1;
      }
      paramDataProcessor.endArray();
      if (localObject1 != null) {
        bool1 = true;
      }
    }
    else
    {
      if (hasIndustry)
      {
        paramDataProcessor.startRecordField$505cff1c("industry");
        paramDataProcessor.processString(industry);
      }
      if (hasLocation)
      {
        paramDataProcessor.startRecordField$505cff1c("location");
        paramDataProcessor.processString(location);
      }
      localObject4 = null;
      bool2 = false;
      if (hasMiniProfile)
      {
        paramDataProcessor.startRecordField$505cff1c("miniProfile");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label393;
        }
        localObject2 = miniProfile.accept(paramDataProcessor);
        label242:
        if (localObject2 == null) {
          break label411;
        }
        bool2 = true;
      }
    }
    Object localObject5;
    for (Object localObject4 = localObject2;; localObject4 = localObject2)
    {
      localObject2 = null;
      localObject3 = null;
      bool3 = false;
      if (!hasCurrentPositions) {
        break label435;
      }
      paramDataProcessor.startRecordField$505cff1c("currentPositions");
      currentPositions.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      localObject3 = currentPositions.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (String)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject5);
        if (localObject2 != null) {
          ((List)localObject2).add(localObject5);
        }
        i += 1;
      }
      bool1 = false;
      break;
      label393:
      localObject2 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break label242;
      label411:
      bool2 = false;
    }
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      label435:
      localObject3 = null;
      localObject5 = null;
      bool4 = false;
      if (!hasPastPositions) {
        break label589;
      }
      paramDataProcessor.startRecordField$505cff1c("pastPositions");
      pastPositions.size();
      paramDataProcessor.startArray$13462e();
      localObject3 = localObject5;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject3 = new ArrayList();
      }
      i = 0;
      localObject5 = pastPositions.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        String str = (String)((Iterator)localObject5).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject3 != null) {
          ((List)localObject3).add(str);
        }
        i += 1;
      }
    }
    paramDataProcessor.endArray();
    if (localObject3 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label589:
      if (hasSummary)
      {
        paramDataProcessor.startRecordField$505cff1c("summary");
        paramDataProcessor.processString(summary);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label897;
      }
      if (!hasEducation) {
        localObject1 = Collections.emptyList();
      }
      if (!hasCurrentPositions) {
        localObject2 = Collections.emptyList();
      }
      if (!hasPastPositions) {
        localObject3 = Collections.emptyList();
      }
      try
      {
        if (hasMiniProfile) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.seo.SameNameProfileResult", "miniProfile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (education != null)
    {
      paramDataProcessor = education.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.seo.SameNameProfileResult", "education");
        }
      }
    }
    if (currentPositions != null)
    {
      paramDataProcessor = currentPositions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.seo.SameNameProfileResult", "currentPositions");
        }
      }
    }
    if (pastPositions != null)
    {
      paramDataProcessor = pastPositions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.seo.SameNameProfileResult", "pastPositions");
        }
      }
    }
    return new SameNameProfileResult((List)localObject1, industry, location, (MiniProfile)localObject4, (List)localObject2, (List)localObject3, summary, bool1, hasIndustry, hasLocation, bool2, bool3, bool4, hasSummary);
    label897:
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
      paramObject = (SameNameProfileResult)paramObject;
      if (education != null)
      {
        if (education.equals(education)) {}
      }
      else {
        while (education != null) {
          return false;
        }
      }
      if (industry != null)
      {
        if (industry.equals(industry)) {}
      }
      else {
        while (industry != null) {
          return false;
        }
      }
      if (location != null)
      {
        if (location.equals(location)) {}
      }
      else {
        while (location != null) {
          return false;
        }
      }
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
      if (currentPositions != null)
      {
        if (currentPositions.equals(currentPositions)) {}
      }
      else {
        while (currentPositions != null) {
          return false;
        }
      }
      if (pastPositions != null)
      {
        if (pastPositions.equals(pastPositions)) {}
      }
      else {
        while (pastPositions != null) {
          return false;
        }
      }
      if (summary == null) {
        break;
      }
    } while (summary.equals(summary));
    for (;;)
    {
      return false;
      if (summary == null) {
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
    int j = i;
    Iterator localIterator;
    if (hasEducation)
    {
      i += 2;
      localIterator = education.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
    }
    j += 1;
    i = j;
    if (hasIndustry) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(industry);
    }
    j = i + 1;
    i = j;
    if (hasLocation) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(location);
    }
    j = i + 1;
    i = j;
    if (hasMiniProfile)
    {
      i = j + 1;
      if (miniProfile._cachedId == null) {
        break label224;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId);
    }
    for (;;)
    {
      i += 1;
      j = i;
      if (!hasCurrentPositions) {
        break;
      }
      i += 2;
      localIterator = currentPositions.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
      label224:
      i += miniProfile.getSerializedSize();
    }
    i = j + 1;
    j = i;
    if (hasPastPositions)
    {
      i += 2;
      localIterator = pastPositions.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
    }
    j += 1;
    i = j;
    if (hasSummary) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(summary);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label47:
    int k;
    label62:
    int m;
    label78:
    int n;
    if (education != null)
    {
      i = education.hashCode();
      if (industry == null) {
        break label182;
      }
      j = industry.hashCode();
      if (location == null) {
        break label187;
      }
      k = location.hashCode();
      if (miniProfile == null) {
        break label192;
      }
      m = miniProfile.hashCode();
      if (currentPositions == null) {
        break label198;
      }
      n = currentPositions.hashCode();
      label96:
      if (pastPositions == null) {
        break label204;
      }
    }
    label182:
    label187:
    label192:
    label198:
    label204:
    for (int i1 = pastPositions.hashCode();; i1 = 0)
    {
      if (summary != null) {
        i2 = summary.hashCode();
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label47;
      k = 0;
      break label62;
      m = 0;
      break label78;
      n = 0;
      break label96;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SameNameProfileResult");
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
    label242:
    label385:
    label395:
    label420:
    label430:
    label586:
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
        localByteBuffer.putInt(-1278054950);
        Iterator localIterator;
        if (hasEducation)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, education.size());
          localIterator = education.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
        }
        localByteBuffer.put((byte)0);
        if (hasIndustry)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, industry);
          if (!hasLocation) {
            break label385;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, location);
          if (!hasMiniProfile) {
            break label420;
          }
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId == null) {
            break label395;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
          miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (!hasCurrentPositions) {
            break label430;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, currentPositions.size());
          localIterator = currentPositions.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label242;
          localByteBuffer.put((byte)1);
          miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasPastPositions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, pastPositions.size());
          localIterator = pastPositions.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
        }
        localByteBuffer.put((byte)0);
        if (hasSummary)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, summary);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label586;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.seo.SameNameProfileResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */