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
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class NormProject
  implements FissileDataModel<NormProject>, RecordTemplate<NormProject>
{
  public static final NormProjectBuilder BUILDER = NormProjectBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String description;
  public final Urn entityUrn;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasMembers;
  public final boolean hasOccupation;
  public final boolean hasTimePeriod;
  public final boolean hasTitle;
  public final boolean hasUrl;
  public final List<NormContributor> members;
  public final Urn occupation;
  public final DateRange timePeriod;
  public final String title;
  public final String url;
  
  NormProject(Urn paramUrn1, String paramString1, String paramString2, String paramString3, Urn paramUrn2, DateRange paramDateRange, List<NormContributor> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
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
  
  private NormProject accept(DataProcessor paramDataProcessor)
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
      localNormContributor = null;
      bool2 = false;
      if (!hasMembers) {
        break label402;
      }
      paramDataProcessor.startRecordField$505cff1c("members");
      members.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localNormContributor;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = members.iterator();
      label272:
      if (!localIterator.hasNext()) {
        break label388;
      }
      localNormContributor = (NormContributor)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label372;
      }
    }
    label363:
    label372:
    for (NormContributor localNormContributor = localNormContributor.accept(paramDataProcessor);; localNormContributor = (NormContributor)paramDataProcessor.processDataTemplate(localNormContributor))
    {
      if ((localObject1 != null) && (localNormContributor != null)) {
        ((List)localObject1).add(localNormContributor);
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
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProject", "title");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasMembers) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProject", "members");
    }
    if (members != null)
    {
      paramDataProcessor = members.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((NormContributor)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProject", "members");
        }
      }
    }
    return new NormProject(entityUrn, title, url, description, occupation, (DateRange)localObject2, (List)localObject1, hasEntityUrn, hasTitle, hasUrl, hasDescription, hasOccupation, bool1, bool2);
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
      paramObject = (NormProject)paramObject;
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
      NormContributor localNormContributor = (NormContributor)((Iterator)localObject).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += timePeriod.getSerializedSize();
        break;
      }
      i += localNormContributor.getSerializedSize();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NormProject");
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
        localByteBuffer.putInt(1404895086);
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
          NormContributor localNormContributor = (NormContributor)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localNormContributor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          localNormContributor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<NormProject>
  {
    private String description = null;
    private Urn entityUrn = null;
    private boolean hasDescription = false;
    private boolean hasEntityUrn = false;
    private boolean hasMembers = false;
    private boolean hasOccupation = false;
    private boolean hasTimePeriod = false;
    private boolean hasTitle = false;
    private boolean hasUrl = false;
    private List<NormContributor> members = null;
    private Urn occupation = null;
    private DateRange timePeriod = null;
    private String title = null;
    private String url = null;
    
    public Builder() {}
    
    public Builder(NormProject paramNormProject)
    {
      entityUrn = entityUrn;
      title = title;
      url = url;
      description = description;
      occupation = occupation;
      timePeriod = timePeriod;
      members = members;
      hasEntityUrn = hasEntityUrn;
      hasTitle = hasTitle;
      hasUrl = hasUrl;
      hasDescription = hasDescription;
      hasOccupation = hasOccupation;
      hasTimePeriod = hasTimePeriod;
      hasMembers = hasMembers;
    }
    
    public final NormProject build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (NormProject.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (members != null)
      {
        paramFlavor = members.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((NormContributor)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProject", "members");
              if (!hasTitle) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProject", "title");
              }
              if (hasMembers) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProject", "members");
            }
          }
        }
      }
      return new NormProject(entityUrn, title, url, description, occupation, timePeriod, members, hasEntityUrn, hasTitle, hasUrl, hasDescription, hasOccupation, hasTimePeriod, hasMembers);
    }
    
    public final Builder setDescription(String paramString)
    {
      if (paramString == null)
      {
        hasDescription = false;
        description = null;
        return this;
      }
      hasDescription = true;
      description = paramString;
      return this;
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
    
    public final Builder setMembers(List<NormContributor> paramList)
    {
      hasMembers = true;
      members = paramList;
      return this;
    }
    
    public final Builder setOccupation(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasOccupation = false;
        occupation = null;
        return this;
      }
      hasOccupation = true;
      occupation = paramUrn;
      return this;
    }
    
    public final Builder setTimePeriod(DateRange paramDateRange)
    {
      if (paramDateRange == null)
      {
        hasTimePeriod = false;
        timePeriod = null;
        return this;
      }
      hasTimePeriod = true;
      timePeriod = paramDateRange;
      return this;
    }
    
    public final Builder setTitle(String paramString)
    {
      if (paramString == null)
      {
        hasTitle = false;
        title = null;
        return this;
      }
      hasTitle = true;
      title = paramString;
      return this;
    }
    
    public final Builder setUrl(String paramString)
    {
      if (paramString == null)
      {
        hasUrl = false;
        url = null;
        return this;
      }
      hasUrl = true;
      url = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */