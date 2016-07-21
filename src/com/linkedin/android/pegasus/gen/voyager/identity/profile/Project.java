package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
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

public final class Project
  implements FissileDataModel<Project>, RecordTemplate<Project>
{
  public static final ProjectBuilder BUILDER = ProjectBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String description;
  public final Urn entityUrn;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasMembers;
  public final boolean hasOccupation;
  public final boolean hasTimePeriod;
  public final boolean hasTitle;
  public final boolean hasUrl;
  public final List<Contributor> members;
  public final Urn occupation;
  public final DateRange timePeriod;
  public final String title;
  public final String url;
  
  Project(Urn paramUrn1, String paramString1, String paramString2, String paramString3, Urn paramUrn2, DateRange paramDateRange, List<Contributor> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    entityUrn = paramUrn1;
    title = paramString1;
    url = paramString2;
    description = paramString3;
    occupation = paramUrn2;
    timePeriod = paramDateRange;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      members = paramString1;
      hasEntityUrn = paramBoolean1;
      hasTitle = paramBoolean2;
      hasUrl = paramBoolean3;
      hasDescription = paramBoolean4;
      hasOccupation = paramBoolean5;
      hasTimePeriod = paramBoolean6;
      hasMembers = paramBoolean7;
      paramString1 = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
      return;
    }
  }
  
  public final Project accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("url");
      paramDataProcessor.processString(url);
    }
    if (hasDescription)
    {
      paramDataProcessor.startRecordField$505cff1c("description");
      paramDataProcessor.processString(description);
    }
    if (hasOccupation)
    {
      paramDataProcessor.startRecordField$505cff1c("occupation");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(occupation));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label197:
    int i;
    if (hasTimePeriod)
    {
      paramDataProcessor.startRecordField$505cff1c("timePeriod");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = timePeriod.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label363;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localContributor = null;
      bool2 = false;
      if (!hasMembers) {
        break label402;
      }
      paramDataProcessor.startRecordField$505cff1c("members");
      members.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localContributor;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = members.iterator();
      label272:
      if (!localIterator.hasNext()) {
        break label388;
      }
      localContributor = (Contributor)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label372;
      }
    }
    label363:
    label372:
    for (Contributor localContributor = localContributor.accept(paramDataProcessor);; localContributor = (Contributor)paramDataProcessor.processDataTemplate(localContributor))
    {
      if ((localObject1 != null) && (localContributor != null)) {
        ((List)localObject1).add(localContributor);
      }
      i += 1;
      break label272;
      localObject1 = (DateRange)paramDataProcessor.processDataTemplate(timePeriod);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label197;
    }
    label388:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label402:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label576;
      }
      try
      {
        if (hasTitle) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Project", "title");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasMembers) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Project", "members");
    }
    if (members != null)
    {
      paramDataProcessor = members.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Contributor)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Project", "members");
        }
      }
    }
    return new Project(entityUrn, title, url, description, occupation, (DateRange)localObject2, (List)localObject1, hasEntityUrn, hasTitle, hasUrl, hasDescription, hasOccupation, bool1, bool2);
    label576:
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
      paramObject = (Project)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
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
      if (url != null)
      {
        if (url.equals(url)) {}
      }
      else {
        while (url != null) {
          return false;
        }
      }
      if (description != null)
      {
        if (description.equals(description)) {}
      }
      else {
        while (description != null) {
          return false;
        }
      }
      if (occupation != null)
      {
        if (occupation.equals(occupation)) {}
      }
      else {
        while (occupation != null) {
          return false;
        }
      }
      if (timePeriod != null)
      {
        if (timePeriod.equals(timePeriod)) {}
      }
      else {
        while (timePeriod != null) {
          return false;
        }
      }
      if (members == null) {
        break;
      }
    } while (members.equals(members));
    for (;;)
    {
      return false;
      if (members == null) {
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
    Object localObject;
    if (hasEntityUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    j = i + 1;
    i = j;
    if (hasUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
    }
    j = i + 1;
    i = j;
    if (hasDescription) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
    }
    j = i + 1;
    i = j;
    if (hasOccupation)
    {
      localObject = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(occupation));
    }
    j = i + 1;
    i = j;
    if (hasTimePeriod)
    {
      i = j + 1;
      if (timePeriod._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(timePeriod._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasMembers) {
        break label295;
      }
      i += 2;
      localObject = members.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label295;
      }
      Contributor localContributor = (Contributor)((Iterator)localObject).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += timePeriod.getSerializedSize();
        break;
      }
      i += localContributor.getSerializedSize();
    }
    label295:
    __sizeOfObject = j;
    return j;
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
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (title == null) {
        break label178;
      }
      j = title.hashCode();
      if (url == null) {
        break label183;
      }
      k = url.hashCode();
      if (description == null) {
        break label188;
      }
      m = description.hashCode();
      if (occupation == null) {
        break label194;
      }
      n = occupation.hashCode();
      label92:
      if (timePeriod == null) {
        break label200;
      }
    }
    label178:
    label183:
    label188:
    label194:
    label200:
    for (int i1 = timePeriod.hashCode();; i1 = 0)
    {
      if (members != null) {
        i2 = members.hashCode();
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
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Project");
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
    label171:
    label197:
    label223:
    label257:
    label317:
    label434:
    label444:
    label454:
    label464:
    label474:
    label499:
    label532:
    label539:
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(218661136);
        Object localObject;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasTitle) {
            break label434;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasUrl) {
            break label444;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasDescription) {
            break label454;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasOccupation) {
            break label464;
          }
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(occupation));
          if (!hasTimePeriod) {
            break label499;
          }
          localByteBuffer.put((byte)1);
          if (timePeriod._cachedId == null) {
            break label474;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, timePeriod._cachedId);
          timePeriod.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasMembers) {
            break label532;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, members.size());
          localObject = members.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label539;
          }
          Contributor localContributor = (Contributor)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localContributor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label171;
            localByteBuffer.put((byte)0);
            break label197;
            localByteBuffer.put((byte)0);
            break label223;
            localByteBuffer.put((byte)0);
            break label257;
            localByteBuffer.put((byte)1);
            timePeriod.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label317;
            localByteBuffer.put((byte)0);
            break label317;
          }
          localByteBuffer.put((byte)1);
          localContributor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Project
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */