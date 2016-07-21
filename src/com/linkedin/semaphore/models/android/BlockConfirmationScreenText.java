package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;

public final class BlockConfirmationScreenText
  implements RecordTemplate<BlockConfirmationScreenText>
{
  public static final BlockConfirmationScreenTextBuilder BUILDER = BlockConfirmationScreenTextBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final String blockAllCaps;
  public final String blockNormal;
  public final String firstLine;
  public final String gobackAllCaps;
  public final String gobackNormal;
  public final boolean hasBlockAllCaps;
  public final boolean hasBlockNormal;
  public final boolean hasFirstLine;
  public final boolean hasGobackAllCaps;
  public final boolean hasGobackNormal;
  public final boolean hasHeading;
  public final boolean hasSecondLine;
  public final String heading;
  public final String secondLine;
  
  BlockConfirmationScreenText(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    heading = paramString1;
    firstLine = paramString2;
    secondLine = paramString3;
    blockNormal = paramString4;
    blockAllCaps = paramString5;
    gobackNormal = paramString6;
    gobackAllCaps = paramString7;
    hasHeading = paramBoolean1;
    hasFirstLine = paramBoolean2;
    hasSecondLine = paramBoolean3;
    hasBlockNormal = paramBoolean4;
    hasBlockAllCaps = paramBoolean5;
    hasGobackNormal = paramBoolean6;
    hasGobackAllCaps = paramBoolean7;
  }
  
  public final BlockConfirmationScreenText accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasHeading)
    {
      paramDataProcessor.startRecordField$505cff1c("heading");
      paramDataProcessor.processString(heading);
    }
    if (hasFirstLine)
    {
      paramDataProcessor.startRecordField$505cff1c("firstLine");
      paramDataProcessor.processString(firstLine);
    }
    if (hasSecondLine)
    {
      paramDataProcessor.startRecordField$505cff1c("secondLine");
      paramDataProcessor.processString(secondLine);
    }
    if (hasBlockNormal)
    {
      paramDataProcessor.startRecordField$505cff1c("blockNormal");
      paramDataProcessor.processString(blockNormal);
    }
    if (hasBlockAllCaps)
    {
      paramDataProcessor.startRecordField$505cff1c("blockAllCaps");
      paramDataProcessor.processString(blockAllCaps);
    }
    if (hasGobackNormal)
    {
      paramDataProcessor.startRecordField$505cff1c("gobackNormal");
      paramDataProcessor.processString(gobackNormal);
    }
    if (hasGobackAllCaps)
    {
      paramDataProcessor.startRecordField$505cff1c("gobackAllCaps");
      paramDataProcessor.processString(gobackAllCaps);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new BlockConfirmationScreenText(heading, firstLine, secondLine, blockNormal, blockAllCaps, gobackNormal, gobackAllCaps, hasHeading, hasFirstLine, hasSecondLine, hasBlockNormal, hasBlockAllCaps, hasGobackNormal, hasGobackAllCaps);
    }
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
      paramObject = (BlockConfirmationScreenText)paramObject;
      if (heading != null)
      {
        if (heading.equals(heading)) {}
      }
      else {
        while (heading != null) {
          return false;
        }
      }
      if (firstLine != null)
      {
        if (firstLine.equals(firstLine)) {}
      }
      else {
        while (firstLine != null) {
          return false;
        }
      }
      if (secondLine != null)
      {
        if (secondLine.equals(secondLine)) {}
      }
      else {
        while (secondLine != null) {
          return false;
        }
      }
      if (blockNormal != null)
      {
        if (blockNormal.equals(blockNormal)) {}
      }
      else {
        while (blockNormal != null) {
          return false;
        }
      }
      if (blockAllCaps != null)
      {
        if (blockAllCaps.equals(blockAllCaps)) {}
      }
      else {
        while (blockAllCaps != null) {
          return false;
        }
      }
      if (gobackNormal != null)
      {
        if (gobackNormal.equals(gobackNormal)) {}
      }
      else {
        while (gobackNormal != null) {
          return false;
        }
      }
      if (gobackAllCaps == null) {
        break;
      }
    } while (gobackAllCaps.equals(gobackAllCaps));
    for (;;)
    {
      return false;
      if (gobackAllCaps == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    if (heading != null)
    {
      i = heading.hashCode();
      if (firstLine == null) {
        break label176;
      }
      j = firstLine.hashCode();
      if (secondLine == null) {
        break label181;
      }
      k = secondLine.hashCode();
      if (blockNormal == null) {
        break label186;
      }
      m = blockNormal.hashCode();
      if (blockAllCaps == null) {
        break label192;
      }
      n = blockAllCaps.hashCode();
      label92:
      if (gobackNormal == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = gobackNormal.hashCode();; i1 = 0)
    {
      if (gobackAllCaps != null) {
        i2 = gobackAllCaps.hashCode();
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
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
      n = 0;
      break label92;
    }
  }
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.BlockConfirmationScreenText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */