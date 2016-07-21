package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
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

public final class NormPublication
  implements FissileDataModel<NormPublication>, RecordTemplate<NormPublication>
{
  public static final NormPublicationBuilder BUILDER = NormPublicationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final List<NormContributor> authors;
  public final Date date;
  public final String description;
  public final Urn entityUrn;
  public final boolean hasAuthors;
  public final boolean hasDate;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasName;
  public final boolean hasPublisher;
  public final boolean hasUrl;
  public final String name;
  public final String publisher;
  public final String url;
  
  NormPublication(Urn paramUrn, String paramString1, String paramString2, Date paramDate, String paramString3, String paramString4, List<NormContributor> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    entityUrn = paramUrn;
    name = paramString1;
    publisher = paramString2;
    date = paramDate;
    url = paramString3;
    description = paramString4;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      authors = paramString1;
      hasEntityUrn = paramBoolean1;
      hasName = paramBoolean2;
      hasPublisher = paramBoolean3;
      hasDate = paramBoolean4;
      hasUrl = paramBoolean5;
      hasDescription = paramBoolean6;
      hasAuthors = paramBoolean7;
      paramString1 = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
    }
  }
  
  private NormPublication accept(DataProcessor paramDataProcessor)
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
    if (hasName)
    {
      paramDataProcessor.startRecordField$505cff1c("name");
      paramDataProcessor.processString(name);
    }
    if (hasPublisher)
    {
      paramDataProcessor.startRecordField$505cff1c("publisher");
      paramDataProcessor.processString(publisher);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label139:
    int i;
    if (hasDate)
    {
      paramDataProcessor.startRecordField$505cff1c("date");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = date.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label355;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
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
      localObject1 = null;
      localNormContributor = null;
      bool2 = false;
      if (!hasAuthors) {
        break label394;
      }
      paramDataProcessor.startRecordField$505cff1c("authors");
      authors.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localNormContributor;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = authors.iterator();
      label264:
      if (!localIterator.hasNext()) {
        break label380;
      }
      localNormContributor = (NormContributor)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label364;
      }
    }
    label355:
    label364:
    for (NormContributor localNormContributor = localNormContributor.accept(paramDataProcessor);; localNormContributor = (NormContributor)paramDataProcessor.processDataTemplate(localNormContributor))
    {
      if ((localObject1 != null) && (localNormContributor != null)) {
        ((List)localObject1).add(localNormContributor);
      }
      i += 1;
      break label264;
      localObject1 = (Date)paramDataProcessor.processDataTemplate(date);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label139;
    }
    label380:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label394:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label568;
      }
      try
      {
        if (hasName) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublication", "name");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasAuthors) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublication", "authors");
    }
    if (authors != null)
    {
      paramDataProcessor = authors.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((NormContributor)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublication", "authors");
        }
      }
    }
    return new NormPublication(entityUrn, name, publisher, (Date)localObject2, url, description, (List)localObject1, hasEntityUrn, hasName, hasPublisher, bool1, hasUrl, hasDescription, bool2);
    label568:
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
      paramObject = (NormPublication)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (name != null)
      {
        if (name.equals(name)) {}
      }
      else {
        while (name != null) {
          return false;
        }
      }
      if (publisher != null)
      {
        if (publisher.equals(publisher)) {}
      }
      else {
        while (publisher != null) {
          return false;
        }
      }
      if (date != null)
      {
        if (date.equals(date)) {}
      }
      else {
        while (date != null) {
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
      if (authors == null) {
        break;
      }
    } while (authors.equals(authors));
    for (;;)
    {
      return false;
      if (authors == null) {
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
    if (hasName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(name);
    }
    j = i + 1;
    i = j;
    if (hasPublisher) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(publisher);
    }
    j = i + 1;
    i = j;
    if (hasDate)
    {
      i = j + 1;
      if (date._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(date._cachedId);
      }
    }
    else
    {
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
      i += 1;
      j = i;
      if (!hasAuthors) {
        break label288;
      }
      i += 2;
      localObject = authors.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label288;
      }
      NormContributor localNormContributor = (NormContributor)((Iterator)localObject).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += date.getSerializedSize();
        break;
      }
      i += localNormContributor.getSerializedSize();
    }
    label288:
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
      if (name == null) {
        break label178;
      }
      j = name.hashCode();
      if (publisher == null) {
        break label183;
      }
      k = publisher.hashCode();
      if (date == null) {
        break label188;
      }
      m = date.hashCode();
      if (url == null) {
        break label194;
      }
      n = url.hashCode();
      label92:
      if (description == null) {
        break label200;
      }
    }
    label178:
    label183:
    label188:
    label194:
    label200:
    for (int i1 = description.hashCode();; i1 = 0)
    {
      if (authors != null) {
        i2 = authors.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NormPublication");
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
    label257:
    label283:
    label309:
    label426:
    label436:
    label446:
    label471:
    label481:
    label491:
    label524:
    label531:
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
        localByteBuffer.putInt(82964875);
        Object localObject;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasName) {
            break label426;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasPublisher) {
            break label436;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, publisher);
          if (!hasDate) {
            break label471;
          }
          localByteBuffer.put((byte)1);
          if (date._cachedId == null) {
            break label446;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, date._cachedId);
          date.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasUrl) {
            break label481;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasDescription) {
            break label491;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasAuthors) {
            break label524;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, authors.size());
          localObject = authors.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label531;
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
            localByteBuffer.put((byte)1);
            date.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label257;
            localByteBuffer.put((byte)0);
            break label257;
            localByteBuffer.put((byte)0);
            break label283;
            localByteBuffer.put((byte)0);
            break label309;
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
    implements RecordTemplateBuilder<NormPublication>
  {
    private List<NormContributor> authors = null;
    private Date date = null;
    private String description = null;
    private Urn entityUrn = null;
    private boolean hasAuthors = false;
    private boolean hasDate = false;
    private boolean hasDescription = false;
    private boolean hasEntityUrn = false;
    private boolean hasName = false;
    private boolean hasPublisher = false;
    private boolean hasUrl = false;
    private String name = null;
    private String publisher = null;
    private String url = null;
    
    public Builder() {}
    
    public Builder(NormPublication paramNormPublication)
    {
      entityUrn = entityUrn;
      name = name;
      publisher = publisher;
      date = date;
      url = url;
      description = description;
      authors = authors;
      hasEntityUrn = hasEntityUrn;
      hasName = hasName;
      hasPublisher = hasPublisher;
      hasDate = hasDate;
      hasUrl = hasUrl;
      hasDescription = hasDescription;
      hasAuthors = hasAuthors;
    }
    
    public final NormPublication build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
    
    public final NormPublication build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (NormPublication.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (authors != null)
      {
        paramFlavor = authors.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((NormContributor)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublication", "authors");
              if (!hasName) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublication", "name");
              }
              if (hasAuthors) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublication", "authors");
            }
          }
        }
      }
      return new NormPublication(entityUrn, name, publisher, date, url, description, authors, hasEntityUrn, hasName, hasPublisher, hasDate, hasUrl, hasDescription, hasAuthors);
    }
    
    public final Builder setAuthors(List<NormContributor> paramList)
    {
      hasAuthors = true;
      authors = paramList;
      return this;
    }
    
    public final Builder setDate(Date paramDate)
    {
      if (paramDate == null)
      {
        hasDate = false;
        date = null;
        return this;
      }
      hasDate = true;
      date = paramDate;
      return this;
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
    
    public final Builder setName(String paramString)
    {
      if (paramString == null)
      {
        hasName = false;
        name = null;
        return this;
      }
      hasName = true;
      name = paramString;
      return this;
    }
    
    public final Builder setPublisher(String paramString)
    {
      if (paramString == null)
      {
        hasPublisher = false;
        publisher = null;
        return this;
      }
      hasPublisher = true;
      publisher = paramString;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */