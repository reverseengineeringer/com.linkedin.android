package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SchoolSections
  implements FissileDataModel<SchoolSections>, RecordTemplate<SchoolSections>
{
  public static final SchoolSectionsBuilder BUILDER = SchoolSectionsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Section details;
  public final boolean hasDetails;
  public final boolean hasHighlights;
  public final boolean hasPeople;
  public final Section highlights;
  public final Section people;
  
  SchoolSections(Section paramSection1, Section paramSection2, Section paramSection3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    highlights = paramSection1;
    details = paramSection2;
    people = paramSection3;
    hasHighlights = paramBoolean1;
    hasDetails = paramBoolean2;
    hasPeople = paramBoolean3;
    _cachedId = null;
  }
  
  public final SchoolSections accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    boolean bool1 = false;
    Section localSection1;
    label56:
    Section localSection2;
    boolean bool2;
    if (hasHighlights)
    {
      paramDataProcessor.startRecordField$505cff1c("highlights");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localSection1 = highlights.accept(paramDataProcessor);
        if (localSection1 == null) {
          break label205;
        }
        bool1 = true;
        localObject = localSection1;
      }
    }
    else
    {
      localSection2 = null;
      bool2 = false;
      if (hasDetails)
      {
        paramDataProcessor.startRecordField$505cff1c("details");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label214;
        }
        localSection1 = details.accept(paramDataProcessor);
        label95:
        if (localSection1 == null) {
          break label232;
        }
        bool2 = true;
        localSection2 = localSection1;
      }
      label106:
      localSection1 = null;
      bool3 = false;
      if (hasPeople)
      {
        paramDataProcessor.startRecordField$505cff1c("people");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label241;
        }
        localSection1 = people.accept(paramDataProcessor);
        label146:
        if (localSection1 == null) {
          break label259;
        }
      }
    }
    label205:
    label214:
    label232:
    label241:
    label259:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label265;
      }
      return new SchoolSections((Section)localObject, localSection2, localSection1, bool1, bool2, bool3);
      localSection1 = (Section)paramDataProcessor.processDataTemplate(highlights);
      break;
      bool1 = false;
      localObject = localSection1;
      break label56;
      localSection1 = (Section)paramDataProcessor.processDataTemplate(details);
      break label95;
      bool2 = false;
      localSection2 = localSection1;
      break label106;
      localSection1 = (Section)paramDataProcessor.processDataTemplate(people);
      break label146;
    }
    label265:
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
      paramObject = (SchoolSections)paramObject;
      if (highlights != null)
      {
        if (highlights.equals(highlights)) {}
      }
      else {
        while (highlights != null) {
          return false;
        }
      }
      if (details != null)
      {
        if (details.equals(details)) {}
      }
      else {
        while (details != null) {
          return false;
        }
      }
      if (people == null) {
        break;
      }
    } while (people.equals(people));
    for (;;)
    {
      return false;
      if (people == null) {
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
    if (hasHighlights)
    {
      if (highlights._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(highlights._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasDetails)
      {
        i = j + 1;
        if (details._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(details._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasPeople)
      {
        i = j + 1;
        if (people._cachedId == null) {
          break label169;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(people._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = highlights.getSerializedSize() + 7;
      break;
      label156:
      i += details.getSerializedSize();
      break label93;
      label169:
      i += people.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (highlights != null)
    {
      i = highlights.hashCode();
      if (details == null) {
        break label87;
      }
    }
    label87:
    for (int j = details.hashCode();; j = 0)
    {
      if (people != null) {
        k = people.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SchoolSections");
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
    label358:
    label383:
    label393:
    label418:
    label426:
    label428:
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
        localByteBuffer.putInt(-836283352);
        if (hasHighlights)
        {
          localByteBuffer.put((byte)1);
          if (highlights._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, highlights._cachedId);
            highlights.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasDetails) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            if (details._cachedId == null) {
              break label358;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, details._cachedId);
            details.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPeople) {
              break label418;
            }
            localByteBuffer.put((byte)1);
            if (people._cachedId == null) {
              break label393;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, people._cachedId);
            people.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label426;
          }
          if (str != null) {
            break label428;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          highlights.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          details.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          people.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolSections
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */