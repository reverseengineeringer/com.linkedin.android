package com.linkedin.android.pegasus.gen.voyager.premium;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class PremiumFAQ
  implements FissileDataModel<PremiumFAQ>, RecordTemplate<PremiumFAQ>
{
  public static final PremiumFAQBuilder BUILDER = PremiumFAQBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String answer;
  public final AttributedText attributedAnswer;
  public final boolean hasAnswer;
  public final boolean hasAttributedAnswer;
  public final boolean hasQuestion;
  public final String question;
  
  PremiumFAQ(String paramString1, String paramString2, AttributedText paramAttributedText, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    question = paramString1;
    answer = paramString2;
    attributedAnswer = paramAttributedText;
    hasQuestion = paramBoolean1;
    hasAnswer = paramBoolean2;
    hasAttributedAnswer = paramBoolean3;
    _cachedId = null;
  }
  
  public final PremiumFAQ accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasQuestion)
    {
      paramDataProcessor.startRecordField$505cff1c("question");
      paramDataProcessor.processString(question);
    }
    if (hasAnswer)
    {
      paramDataProcessor.startRecordField$505cff1c("answer");
      paramDataProcessor.processString(answer);
    }
    AttributedText localAttributedText = null;
    boolean bool = false;
    if (hasAttributedAnswer)
    {
      paramDataProcessor.startRecordField$505cff1c("attributedAnswer");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label143;
      }
      localAttributedText = attributedAnswer.accept(paramDataProcessor);
      if (localAttributedText == null) {
        break label160;
      }
    }
    label143:
    label160:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label210;
      }
      try
      {
        if (hasQuestion) {
          break label165;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumFAQ", "question");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localAttributedText = (AttributedText)paramDataProcessor.processDataTemplate(attributedAnswer);
      break;
    }
    label165:
    if (!hasAnswer) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumFAQ", "answer");
    }
    return new PremiumFAQ(question, answer, localAttributedText, hasQuestion, hasAnswer, bool);
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
      paramObject = (PremiumFAQ)paramObject;
      if (question != null)
      {
        if (question.equals(question)) {}
      }
      else {
        while (question != null) {
          return false;
        }
      }
      if (answer != null)
      {
        if (answer.equals(answer)) {}
      }
      else {
        while (answer != null) {
          return false;
        }
      }
      if (attributedAnswer == null) {
        break;
      }
    } while (attributedAnswer.equals(attributedAnswer));
    for (;;)
    {
      return false;
      if (attributedAnswer == null) {
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
    if (hasQuestion) {
      i = PegasusBinaryUtils.getEncodedLength(question) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasAnswer) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(answer);
    }
    j = i + 1;
    i = j;
    if (hasAttributedAnswer)
    {
      i = j + 1;
      if (attributedAnswer._cachedId == null) {
        break label112;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(attributedAnswer._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label112:
      i += attributedAnswer.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (question != null)
    {
      i = question.hashCode();
      if (answer == null) {
        break label87;
      }
    }
    label87:
    for (int j = answer.hashCode();; j = 0)
    {
      if (attributedAnswer != null) {
        k = attributedAnswer.hashCode();
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PremiumFAQ");
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
    label265:
    label275:
    label300:
    label308:
    label310:
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
        localByteBuffer.putInt(1877079262);
        if (hasQuestion)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, question);
          if (!hasAnswer) {
            break label265;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, answer);
          if (!hasAttributedAnswer) {
            break label300;
          }
          localByteBuffer.put((byte)1);
          if (attributedAnswer._cachedId == null) {
            break label275;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, attributedAnswer._cachedId);
          attributedAnswer.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label308;
          }
          if (str != null) {
            break label310;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)1);
          attributedAnswer.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumFAQ
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */