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

public final class Patent
  implements FissileDataModel<Patent>, RecordTemplate<Patent>
{
  public static final PatentBuilder BUILDER = PatentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String applicationNumber;
  public final String description;
  public final Urn entityUrn;
  public final Date filingDate;
  public final boolean hasApplicationNumber;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasFilingDate;
  public final boolean hasInventors;
  public final boolean hasIssueDate;
  public final boolean hasIssuer;
  public final boolean hasLocalizedIssuerCountryName;
  public final boolean hasNumber;
  public final boolean hasPending;
  public final boolean hasTitle;
  public final boolean hasUrl;
  public final List<Contributor> inventors;
  public final Date issueDate;
  public final String issuer;
  public final String localizedIssuerCountryName;
  public final String number;
  public final boolean pending;
  public final String title;
  public final String url;
  
  Patent(Urn paramUrn, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, Date paramDate1, Date paramDate2, String paramString6, String paramString7, List<Contributor> paramList, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13)
  {
    entityUrn = paramUrn;
    number = paramString1;
    applicationNumber = paramString2;
    title = paramString3;
    issuer = paramString4;
    url = paramString5;
    pending = paramBoolean1;
    filingDate = paramDate1;
    issueDate = paramDate2;
    description = paramString6;
    localizedIssuerCountryName = paramString7;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      inventors = paramString1;
      hasEntityUrn = paramBoolean2;
      hasNumber = paramBoolean3;
      hasApplicationNumber = paramBoolean4;
      hasTitle = paramBoolean5;
      hasIssuer = paramBoolean6;
      hasUrl = paramBoolean7;
      hasPending = paramBoolean8;
      hasFilingDate = paramBoolean9;
      hasIssueDate = paramBoolean10;
      hasDescription = paramBoolean11;
      hasLocalizedIssuerCountryName = paramBoolean12;
      hasInventors = paramBoolean13;
      paramString1 = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
    }
  }
  
  public final Patent accept(DataProcessor paramDataProcessor)
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
    if (hasNumber)
    {
      paramDataProcessor.startRecordField$505cff1c("number");
      paramDataProcessor.processString(number);
    }
    if (hasApplicationNumber)
    {
      paramDataProcessor.startRecordField$505cff1c("applicationNumber");
      paramDataProcessor.processString(applicationNumber);
    }
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasIssuer)
    {
      paramDataProcessor.startRecordField$505cff1c("issuer");
      paramDataProcessor.processString(issuer);
    }
    if (hasUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("url");
      paramDataProcessor.processString(url);
    }
    if (hasPending)
    {
      paramDataProcessor.startRecordField$505cff1c("pending");
      paramDataProcessor.processBoolean(pending);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label239:
    Object localObject3;
    boolean bool2;
    label279:
    label291:
    int i;
    if (hasFilingDate)
    {
      paramDataProcessor.startRecordField$505cff1c("filingDate");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = filingDate.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label507;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasIssueDate)
      {
        paramDataProcessor.startRecordField$505cff1c("issueDate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label516;
        }
        localObject1 = issueDate.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label534;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      if (hasDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("description");
        paramDataProcessor.processString(description);
      }
      if (hasLocalizedIssuerCountryName)
      {
        paramDataProcessor.startRecordField$505cff1c("localizedIssuerCountryName");
        paramDataProcessor.processString(localizedIssuerCountryName);
      }
      localObject1 = null;
      localContributor = null;
      bool3 = false;
      if (!hasInventors) {
        break label574;
      }
      paramDataProcessor.startRecordField$505cff1c("inventors");
      inventors.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localContributor;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = inventors.iterator();
      label416:
      if (!localIterator.hasNext()) {
        break label560;
      }
      localContributor = (Contributor)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label544;
      }
    }
    label507:
    label516:
    label534:
    label544:
    for (Contributor localContributor = localContributor.accept(paramDataProcessor);; localContributor = (Contributor)paramDataProcessor.processDataTemplate(localContributor))
    {
      if ((localObject1 != null) && (localContributor != null)) {
        ((List)localObject1).add(localContributor);
      }
      i += 1;
      break label416;
      localObject1 = (Date)paramDataProcessor.processDataTemplate(filingDate);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label239;
      localObject1 = (Date)paramDataProcessor.processDataTemplate(issueDate);
      break label279;
      bool2 = false;
      localObject3 = localObject1;
      break label291;
    }
    label560:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      label574:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label822;
      }
      try
      {
        if (hasTitle) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "title");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasIssuer) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "issuer");
    }
    if (!hasPending) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "pending");
    }
    if (!hasInventors) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "inventors");
    }
    if (inventors != null)
    {
      paramDataProcessor = inventors.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Contributor)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "inventors");
        }
      }
    }
    return new Patent(entityUrn, number, applicationNumber, title, issuer, url, pending, (Date)localObject2, (Date)localObject3, description, localizedIssuerCountryName, (List)localObject1, hasEntityUrn, hasNumber, hasApplicationNumber, hasTitle, hasIssuer, hasUrl, hasPending, bool1, bool2, hasDescription, hasLocalizedIssuerCountryName, bool3);
    label822:
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
      paramObject = (Patent)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (number != null)
      {
        if (number.equals(number)) {}
      }
      else {
        while (number != null) {
          return false;
        }
      }
      if (applicationNumber != null)
      {
        if (applicationNumber.equals(applicationNumber)) {}
      }
      else {
        while (applicationNumber != null) {
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
      if (issuer != null)
      {
        if (issuer.equals(issuer)) {}
      }
      else {
        while (issuer != null) {
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
      if (pending != pending) {
        return false;
      }
      if (filingDate != null)
      {
        if (filingDate.equals(filingDate)) {}
      }
      else {
        while (filingDate != null) {
          return false;
        }
      }
      if (issueDate != null)
      {
        if (issueDate.equals(issueDate)) {}
      }
      else {
        while (issueDate != null) {
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
      if (localizedIssuerCountryName != null)
      {
        if (localizedIssuerCountryName.equals(localizedIssuerCountryName)) {}
      }
      else {
        while (localizedIssuerCountryName != null) {
          return false;
        }
      }
      if (inventors == null) {
        break;
      }
    } while (inventors.equals(inventors));
    for (;;)
    {
      return false;
      if (inventors == null) {
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
    if (hasNumber) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(number);
    }
    j = i + 1;
    i = j;
    if (hasApplicationNumber) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(applicationNumber);
    }
    j = i + 1;
    i = j;
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    j = i + 1;
    i = j;
    if (hasIssuer) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(issuer);
    }
    j = i + 1;
    i = j;
    if (hasUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
    }
    j = i + 1;
    i = j;
    if (hasPending) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasFilingDate)
    {
      i = j + 1;
      if (filingDate._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(filingDate._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasIssueDate)
      {
        i = j + 1;
        if (issueDate._cachedId == null) {
          break label411;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(issueDate._cachedId);
      }
      label271:
      j = i + 1;
      i = j;
      if (hasDescription) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
      }
      j = i + 1;
      i = j;
      if (hasLocalizedIssuerCountryName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(localizedIssuerCountryName);
      }
      i += 1;
      j = i;
      if (!hasInventors) {
        break label435;
      }
      i += 2;
      localObject = inventors.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label435;
      }
      Contributor localContributor = (Contributor)((Iterator)localObject).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += filingDate.getSerializedSize();
        break;
        label411:
        i += issueDate.getSerializedSize();
        break label271;
      }
      i += localContributor.getSerializedSize();
    }
    label435:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int i7 = 0;
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
    label92:
    int i1;
    label108:
    int i2;
    label118:
    int i3;
    label134:
    int i4;
    label150:
    int i5;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (number == null) {
        break label282;
      }
      j = number.hashCode();
      if (applicationNumber == null) {
        break label287;
      }
      k = applicationNumber.hashCode();
      if (title == null) {
        break label292;
      }
      m = title.hashCode();
      if (issuer == null) {
        break label298;
      }
      n = issuer.hashCode();
      if (url == null) {
        break label304;
      }
      i1 = url.hashCode();
      if (!pending) {
        break label310;
      }
      i2 = 1;
      if (filingDate == null) {
        break label316;
      }
      i3 = filingDate.hashCode();
      if (issueDate == null) {
        break label322;
      }
      i4 = issueDate.hashCode();
      if (description == null) {
        break label328;
      }
      i5 = description.hashCode();
      label166:
      if (localizedIssuerCountryName == null) {
        break label334;
      }
    }
    label282:
    label287:
    label292:
    label298:
    label304:
    label310:
    label316:
    label322:
    label328:
    label334:
    for (int i6 = localizedIssuerCountryName.hashCode();; i6 = 0)
    {
      if (inventors != null) {
        i7 = inventors.hashCode();
      }
      i = (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i7;
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
      i1 = 0;
      break label108;
      i2 = 0;
      break label118;
      i3 = 0;
      break label134;
      i4 = 0;
      break label150;
      i5 = 0;
      break label166;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Patent");
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
    label172:
    label198:
    label224:
    label250:
    label276:
    label300:
    label309:
    label369:
    label429:
    label455:
    label481:
    label598:
    label608:
    label618:
    label628:
    label638:
    label648:
    label654:
    label664:
    label689:
    label699:
    label724:
    label734:
    label744:
    label777:
    label784:
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
        localByteBuffer.putInt(-56719798);
        Object localObject;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasNumber) {
            break label598;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, number);
          if (!hasApplicationNumber) {
            break label608;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, applicationNumber);
          if (!hasTitle) {
            break label618;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasIssuer) {
            break label628;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, issuer);
          if (!hasUrl) {
            break label638;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasPending) {
            break label654;
          }
          localByteBuffer.put((byte)1);
          if (!pending) {
            break label648;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasFilingDate) {
            break label689;
          }
          localByteBuffer.put((byte)1);
          if (filingDate._cachedId == null) {
            break label664;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, filingDate._cachedId);
          filingDate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasIssueDate) {
            break label724;
          }
          localByteBuffer.put((byte)1);
          if (issueDate._cachedId == null) {
            break label699;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, issueDate._cachedId);
          issueDate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasDescription) {
            break label734;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasLocalizedIssuerCountryName) {
            break label744;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, localizedIssuerCountryName);
          if (!hasInventors) {
            break label777;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, inventors.size());
          localObject = inventors.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label784;
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
            break label172;
            localByteBuffer.put((byte)0);
            break label198;
            localByteBuffer.put((byte)0);
            break label224;
            localByteBuffer.put((byte)0);
            break label250;
            localByteBuffer.put((byte)0);
            break label276;
            i = 0;
            break label300;
            localByteBuffer.put((byte)0);
            break label309;
            localByteBuffer.put((byte)1);
            filingDate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label369;
            localByteBuffer.put((byte)0);
            break label369;
            localByteBuffer.put((byte)1);
            issueDate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label429;
            localByteBuffer.put((byte)0);
            break label429;
            localByteBuffer.put((byte)0);
            break label455;
            localByteBuffer.put((byte)0);
            break label481;
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
  
  public static final class Builder
    implements RecordTemplateBuilder<Patent>
  {
    private String applicationNumber = null;
    private String description = null;
    private Urn entityUrn = null;
    private Date filingDate = null;
    private boolean hasApplicationNumber = false;
    private boolean hasDescription = false;
    private boolean hasEntityUrn = false;
    private boolean hasFilingDate = false;
    public boolean hasInventors = false;
    private boolean hasIssueDate = false;
    private boolean hasIssuer = false;
    private boolean hasLocalizedIssuerCountryName = false;
    private boolean hasNumber = false;
    private boolean hasPending = false;
    private boolean hasTitle = false;
    private boolean hasUrl = false;
    public List<Contributor> inventors = null;
    private Date issueDate = null;
    private String issuer = null;
    private String localizedIssuerCountryName = null;
    private String number = null;
    private boolean pending = false;
    private String title = null;
    private String url = null;
    
    public Builder() {}
    
    public Builder(Patent paramPatent)
    {
      entityUrn = entityUrn;
      number = number;
      applicationNumber = applicationNumber;
      title = title;
      issuer = issuer;
      url = url;
      pending = pending;
      filingDate = filingDate;
      issueDate = issueDate;
      description = description;
      localizedIssuerCountryName = localizedIssuerCountryName;
      inventors = inventors;
      hasEntityUrn = hasEntityUrn;
      hasNumber = hasNumber;
      hasApplicationNumber = hasApplicationNumber;
      hasTitle = hasTitle;
      hasIssuer = hasIssuer;
      hasUrl = hasUrl;
      hasPending = hasPending;
      hasFilingDate = hasFilingDate;
      hasIssueDate = hasIssueDate;
      hasDescription = hasDescription;
      hasLocalizedIssuerCountryName = hasLocalizedIssuerCountryName;
      hasInventors = hasInventors;
    }
    
    public final Patent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Patent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (inventors != null)
      {
        paramFlavor = inventors.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((Contributor)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "inventors");
              if (!hasTitle) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "title");
              }
              if (!hasIssuer) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "issuer");
              }
              if (!hasPending) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "pending");
              }
              if (hasInventors) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent", "inventors");
            }
          }
        }
      }
      return new Patent(entityUrn, number, applicationNumber, title, issuer, url, pending, filingDate, issueDate, description, localizedIssuerCountryName, inventors, hasEntityUrn, hasNumber, hasApplicationNumber, hasTitle, hasIssuer, hasUrl, hasPending, hasFilingDate, hasIssueDate, hasDescription, hasLocalizedIssuerCountryName, hasInventors);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */