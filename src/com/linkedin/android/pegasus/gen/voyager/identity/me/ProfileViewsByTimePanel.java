package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
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

public final class ProfileViewsByTimePanel
  implements FissileDataModel<ProfileViewsByTimePanel>, RecordTemplate<ProfileViewsByTimePanel>
{
  public static final ProfileViewsByTimePanelBuilder BUILDER = ProfileViewsByTimePanelBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<ProfileViewsTimeIntervalDataPoint> chartData;
  public final boolean hasChartData;
  public final boolean hasTotalNumViews;
  public final long totalNumViews;
  
  ProfileViewsByTimePanel(List<ProfileViewsTimeIntervalDataPoint> paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      chartData = paramList;
      totalNumViews = paramLong;
      hasChartData = paramBoolean1;
      hasTotalNumViews = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final ProfileViewsByTimePanel accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    ProfileViewsTimeIntervalDataPoint localProfileViewsTimeIntervalDataPoint = null;
    boolean bool = false;
    if (hasChartData)
    {
      paramDataProcessor.startRecordField$505cff1c("chartData");
      chartData.size();
      paramDataProcessor.startArray$13462e();
      localObject = localProfileViewsTimeIntervalDataPoint;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = chartData.iterator();
      if (localIterator.hasNext())
      {
        localProfileViewsTimeIntervalDataPoint = (ProfileViewsTimeIntervalDataPoint)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localProfileViewsTimeIntervalDataPoint = localProfileViewsTimeIntervalDataPoint.accept(paramDataProcessor);; localProfileViewsTimeIntervalDataPoint = (ProfileViewsTimeIntervalDataPoint)paramDataProcessor.processDataTemplate(localProfileViewsTimeIntervalDataPoint))
        {
          if ((localObject != null) && (localProfileViewsTimeIntervalDataPoint != null)) {
            ((List)localObject).add(localProfileViewsTimeIntervalDataPoint);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label251;
      }
    }
    label251:
    for (bool = true;; bool = false)
    {
      if (hasTotalNumViews)
      {
        paramDataProcessor.startRecordField$505cff1c("totalNumViews");
        paramDataProcessor.processLong(totalNumViews);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label344;
      }
      try
      {
        if (hasChartData) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewsByTimePanel", "chartData");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasTotalNumViews) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewsByTimePanel", "totalNumViews");
    }
    if (chartData != null)
    {
      paramDataProcessor = chartData.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((ProfileViewsTimeIntervalDataPoint)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewsByTimePanel", "chartData");
        }
      }
    }
    return new ProfileViewsByTimePanel((List)localObject, totalNumViews, bool, hasTotalNumViews);
    label344:
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
      paramObject = (ProfileViewsByTimePanel)paramObject;
      if (chartData != null)
      {
        if (chartData.equals(chartData)) {}
      }
      else {
        while (chartData != null) {
          return false;
        }
      }
    } while (totalNumViews == totalNumViews);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    int j = i;
    if (hasChartData)
    {
      i += 2;
      Iterator localIterator = chartData.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        ProfileViewsTimeIntervalDataPoint localProfileViewsTimeIntervalDataPoint = (ProfileViewsTimeIntervalDataPoint)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localProfileViewsTimeIntervalDataPoint.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasTotalNumViews) {
      i = j + 8;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (chartData != null) {}
    for (int i = chartData.hashCode();; i = 0)
    {
      i = (i + 527) * 31 + (int)(totalNumViews ^ totalNumViews >>> 32);
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfileViewsByTimePanel");
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
    label314:
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
        localByteBuffer.putInt(-1583591426);
        if (hasChartData)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, chartData.size());
          Iterator localIterator = chartData.iterator();
          while (localIterator.hasNext())
          {
            ProfileViewsTimeIntervalDataPoint localProfileViewsTimeIntervalDataPoint = (ProfileViewsTimeIntervalDataPoint)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localProfileViewsTimeIntervalDataPoint.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localProfileViewsTimeIntervalDataPoint.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasTotalNumViews)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(totalNumViews);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label314;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewsByTimePanel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */