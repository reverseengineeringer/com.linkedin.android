package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ShareJob
  implements FissileDataModel<ShareJob>, RecordTemplate<ShareJob>
{
  public static final ShareJobBuilder BUILDER = ShareJobBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final AttributedText attributedText;
  public final CompanyActor companyActor;
  public final String companyName;
  public final boolean hasAttributedText;
  public final boolean hasCompanyActor;
  public final boolean hasCompanyName;
  public final boolean hasJobUrl;
  public final boolean hasMiniJob;
  public final boolean hasText;
  public final String jobUrl;
  public final MiniJob miniJob;
  public final AnnotatedText text;
  
  ShareJob(AnnotatedText paramAnnotatedText, AttributedText paramAttributedText, CompanyActor paramCompanyActor, MiniJob paramMiniJob, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    text = paramAnnotatedText;
    attributedText = paramAttributedText;
    companyActor = paramCompanyActor;
    miniJob = paramMiniJob;
    companyName = paramString1;
    jobUrl = paramString2;
    hasText = paramBoolean1;
    hasAttributedText = paramBoolean2;
    hasCompanyActor = paramBoolean3;
    hasMiniJob = paramBoolean4;
    hasCompanyName = paramBoolean5;
    hasJobUrl = paramBoolean6;
    _cachedId = null;
  }
  
  public final ShareJob accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = text.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label318;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasAttributedText)
      {
        paramDataProcessor.startRecordField$505cff1c("attributedText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label327;
        }
        localObject1 = attributedText.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label345;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasCompanyActor)
      {
        paramDataProcessor.startRecordField$505cff1c("companyActor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label354;
        }
        localObject1 = companyActor.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label372;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      localObject1 = null;
      bool4 = false;
      if (hasMiniJob)
      {
        paramDataProcessor.startRecordField$505cff1c("miniJob");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label382;
        }
        localObject1 = miniJob.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label400;
        }
      }
    }
    label318:
    label327:
    label345:
    label354:
    label372:
    label382:
    label400:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasCompanyName)
      {
        paramDataProcessor.startRecordField$505cff1c("companyName");
        paramDataProcessor.processString(companyName);
      }
      if (hasJobUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("jobUrl");
        paramDataProcessor.processString(jobUrl);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label463;
      }
      try
      {
        if (hasMiniJob) {
          break label406;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareJob", "miniJob");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(text);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(attributedText);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (CompanyActor)paramDataProcessor.processDataTemplate(companyActor);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (MiniJob)paramDataProcessor.processDataTemplate(miniJob);
      break label198;
    }
    label406:
    if (!hasCompanyName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ShareJob", "companyName");
    }
    return new ShareJob((AnnotatedText)localObject2, (AttributedText)localObject3, (CompanyActor)localObject4, (MiniJob)localObject1, companyName, jobUrl, bool1, bool2, bool3, bool4, hasCompanyName, hasJobUrl);
    label463:
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
      paramObject = (ShareJob)paramObject;
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (attributedText != null)
      {
        if (attributedText.equals(attributedText)) {}
      }
      else {
        while (attributedText != null) {
          return false;
        }
      }
      if (companyActor != null)
      {
        if (companyActor.equals(companyActor)) {}
      }
      else {
        while (companyActor != null) {
          return false;
        }
      }
      if (miniJob != null)
      {
        if (miniJob.equals(miniJob)) {}
      }
      else {
        while (miniJob != null) {
          return false;
        }
      }
      if (companyName != null)
      {
        if (companyName.equals(companyName)) {}
      }
      else {
        while (companyName != null) {
          return false;
        }
      }
      if (jobUrl == null) {
        break;
      }
    } while (jobUrl.equals(jobUrl));
    for (;;)
    {
      return false;
      if (jobUrl == null) {
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
    int j;
    if (hasText)
    {
      if (text._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(text._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasAttributedText)
      {
        i = j + 1;
        if (attributedText._cachedId == null) {
          break label248;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(attributedText._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasCompanyActor)
      {
        i = j + 1;
        if (companyActor._cachedId == null) {
          break label261;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(companyActor._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasMiniJob)
      {
        i = j + 1;
        if (miniJob._cachedId == null) {
          break label274;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniJob._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasCompanyName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(companyName);
      }
      j = i + 1;
      i = j;
      if (hasJobUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(jobUrl);
      }
      __sizeOfObject = i;
      return i;
      i = text.getSerializedSize() + 7;
      break;
      label248:
      i += attributedText.getSerializedSize();
      break label93;
      label261:
      i += companyActor.getSerializedSize();
      break label135;
      label274:
      i += miniJob.getSerializedSize();
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
    if (text != null)
    {
      i = text.hashCode();
      if (attributedText == null) {
        break label154;
      }
      j = attributedText.hashCode();
      if (companyActor == null) {
        break label159;
      }
      k = companyActor.hashCode();
      if (miniJob == null) {
        break label164;
      }
      m = miniJob.hashCode();
      label76:
      if (companyName == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = companyName.hashCode();; n = 0)
    {
      if (jobUrl != null) {
        i1 = jobUrl.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ShareJob");
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
    label230:
    label290:
    label350:
    label376:
    label470:
    label495:
    label505:
    label530:
    label540:
    label565:
    label575:
    label585:
    label593:
    label595:
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
        localByteBuffer.putInt(-967095391);
        if (hasText)
        {
          localByteBuffer.put((byte)1);
          if (text._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
            text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasAttributedText) {
              break label495;
            }
            localByteBuffer.put((byte)1);
            if (attributedText._cachedId == null) {
              break label470;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, attributedText._cachedId);
            attributedText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCompanyActor) {
              break label530;
            }
            localByteBuffer.put((byte)1);
            if (companyActor._cachedId == null) {
              break label505;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, companyActor._cachedId);
            companyActor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMiniJob) {
              break label565;
            }
            localByteBuffer.put((byte)1);
            if (miniJob._cachedId == null) {
              break label540;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniJob._cachedId);
            miniJob.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCompanyName) {
              break label575;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, companyName);
            if (!hasJobUrl) {
              break label585;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, jobUrl);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label593;
          }
          if (str != null) {
            break label595;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          attributedText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          companyActor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          miniJob.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label350;
          localByteBuffer.put((byte)0);
          break label350;
          localByteBuffer.put((byte)0);
          break label376;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */