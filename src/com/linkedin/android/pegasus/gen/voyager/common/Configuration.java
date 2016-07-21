package com.linkedin.android.pegasus.gen.voyager.common;

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

public final class Configuration
  implements FissileDataModel<Configuration>, RecordTemplate<Configuration>
{
  public static final ConfigurationBuilder BUILDER = ConfigurationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasLaunchAlert;
  public final boolean hasMediaConfig;
  public final LaunchAlert launchAlert;
  public final MediaConfig mediaConfig;
  
  Configuration(MediaConfig paramMediaConfig, LaunchAlert paramLaunchAlert, boolean paramBoolean1, boolean paramBoolean2)
  {
    mediaConfig = paramMediaConfig;
    launchAlert = paramLaunchAlert;
    hasMediaConfig = paramBoolean1;
    hasLaunchAlert = paramBoolean2;
    _cachedId = null;
  }
  
  private Configuration accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasMediaConfig)
    {
      paramDataProcessor.startRecordField$505cff1c("mediaConfig");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = mediaConfig.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label164;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      localObject1 = null;
      bool2 = false;
      if (hasLaunchAlert)
      {
        paramDataProcessor.startRecordField$505cff1c("launchAlert");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label173;
        }
        localObject1 = launchAlert.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label191;
        }
      }
    }
    label164:
    label173:
    label191:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label210;
      }
      try
      {
        if (hasMediaConfig) {
          break label196;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Configuration", "mediaConfig");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MediaConfig)paramDataProcessor.processDataTemplate(mediaConfig);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (LaunchAlert)paramDataProcessor.processDataTemplate(launchAlert);
      break label95;
    }
    label196:
    return new Configuration((MediaConfig)localObject2, (LaunchAlert)localObject1, bool1, bool2);
    label210:
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
      paramObject = (Configuration)paramObject;
      if (mediaConfig != null)
      {
        if (mediaConfig.equals(mediaConfig)) {}
      }
      else {
        while (mediaConfig != null) {
          return false;
        }
      }
      if (launchAlert == null) {
        break;
      }
    } while (launchAlert.equals(launchAlert));
    for (;;)
    {
      return false;
      if (launchAlert == null) {
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
    if (hasMediaConfig)
    {
      if (mediaConfig._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(mediaConfig._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasLaunchAlert)
      {
        i = j + 1;
        if (launchAlert._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(launchAlert._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = mediaConfig.getSerializedSize() + 7;
      break;
      label114:
      i += launchAlert.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (mediaConfig != null) {}
    for (int i = mediaConfig.hashCode();; i = 0)
    {
      if (launchAlert != null) {
        j = launchAlert.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Configuration");
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
        localByteBuffer.putInt(-887175817);
        if (hasMediaConfig)
        {
          localByteBuffer.put((byte)1);
          if (mediaConfig._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, mediaConfig._cachedId);
            mediaConfig.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasLaunchAlert) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (launchAlert._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, launchAlert._cachedId);
            launchAlert.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          mediaConfig.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          launchAlert.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.Configuration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */