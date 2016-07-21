package com.linkedin.android.pegasus.gen.voyager.feed.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor;
import com.linkedin.android.pegasus.gen.voyager.feed.UpdateAction;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class JymbiiUpdate
  implements FissileDataModel<JymbiiUpdate>, RecordTemplate<JymbiiUpdate>
{
  public static final JymbiiUpdateBuilder BUILDER = JymbiiUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final List<UpdateAction> actions;
  public final Company company;
  public final long createdAt;
  public final List<EntitiesFlavor> flavors;
  public final boolean hasActions;
  public final boolean hasCompany;
  public final boolean hasCreatedAt;
  public final boolean hasFlavors;
  public final boolean hasJobUrl;
  public final boolean hasMiniJob;
  public final boolean hasUrn;
  public final String jobUrl;
  public final MiniJob miniJob;
  public final Urn urn;
  
  JymbiiUpdate(List<UpdateAction> paramList, Urn paramUrn, Company paramCompany, long paramLong, MiniJob paramMiniJob, String paramString, List<EntitiesFlavor> paramList1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    if (paramList == null)
    {
      paramList = null;
      actions = paramList;
      urn = paramUrn;
      company = paramCompany;
      createdAt = paramLong;
      miniJob = paramMiniJob;
      jobUrl = paramString;
      if (paramList1 != null) {
        break label121;
      }
    }
    label121:
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList1))
    {
      flavors = paramList;
      hasActions = paramBoolean1;
      hasUrn = paramBoolean2;
      hasCompany = paramBoolean3;
      hasCreatedAt = paramBoolean4;
      hasMiniJob = paramBoolean5;
      hasJobUrl = paramBoolean6;
      hasFlavors = paramBoolean7;
      _cachedId = null;
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  public final JymbiiUpdate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    int i;
    Object localObject3;
    boolean bool2;
    label255:
    label267:
    Object localObject4;
    boolean bool3;
    if (hasActions)
    {
      paramDataProcessor.startRecordField$505cff1c("actions");
      actions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = actions.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (UpdateAction)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((UpdateAction)localObject2).accept(paramDataProcessor);; localObject2 = (UpdateAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null) {
        bool1 = true;
      }
    }
    else
    {
      if (hasUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("urn");
        localObject2 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(urn));
      }
      localObject3 = null;
      bool2 = false;
      if (hasCompany)
      {
        paramDataProcessor.startRecordField$505cff1c("company");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label522;
        }
        localObject2 = company.accept(paramDataProcessor);
        if (localObject2 == null) {
          break label540;
        }
        bool2 = true;
        localObject3 = localObject2;
      }
      if (hasCreatedAt)
      {
        paramDataProcessor.startRecordField$505cff1c("createdAt");
        paramDataProcessor.processLong(createdAt);
      }
      localObject4 = null;
      bool3 = false;
      if (hasMiniJob)
      {
        paramDataProcessor.startRecordField$505cff1c("miniJob");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label550;
        }
        localObject2 = miniJob.accept(paramDataProcessor);
        label332:
        if (localObject2 == null) {
          break label568;
        }
        bool3 = true;
        localObject4 = localObject2;
      }
      label344:
      if (hasJobUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("jobUrl");
        paramDataProcessor.processString(jobUrl);
      }
      localObject2 = null;
      localEntitiesFlavor = null;
      bool4 = false;
      if (!hasFlavors) {
        break label608;
      }
      paramDataProcessor.startRecordField$505cff1c("flavors");
      flavors.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localEntitiesFlavor;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = flavors.iterator();
      label444:
      if (!localIterator.hasNext()) {
        break label594;
      }
      localEntitiesFlavor = (EntitiesFlavor)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label578;
      }
    }
    label522:
    label540:
    label550:
    label568:
    label578:
    for (EntitiesFlavor localEntitiesFlavor = localEntitiesFlavor.accept(paramDataProcessor);; localEntitiesFlavor = (EntitiesFlavor)paramDataProcessor.processDataTemplate(localEntitiesFlavor))
    {
      if ((localObject2 != null) && (localEntitiesFlavor != null)) {
        ((List)localObject2).add(localEntitiesFlavor);
      }
      i += 1;
      break label444;
      bool1 = false;
      break;
      localObject2 = (Company)paramDataProcessor.processDataTemplate(company);
      break label255;
      bool2 = false;
      localObject3 = localObject2;
      break label267;
      localObject2 = (MiniJob)paramDataProcessor.processDataTemplate(miniJob);
      break label332;
      bool3 = false;
      localObject4 = localObject2;
      break label344;
    }
    label594:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label608:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label886;
      }
      if (!hasActions) {
        localObject1 = Collections.emptyList();
      }
      if (!hasFlavors) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (hasUrn) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate", "urn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasCompany) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate", "company");
    }
    if (!hasCreatedAt) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate", "createdAt");
    }
    if (!hasMiniJob) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate", "miniJob");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((UpdateAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate", "actions");
        }
      }
    }
    if (flavors != null)
    {
      paramDataProcessor = flavors.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((EntitiesFlavor)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate", "flavors");
        }
      }
    }
    return new JymbiiUpdate((List)localObject1, urn, (Company)localObject3, createdAt, (MiniJob)localObject4, jobUrl, (List)localObject2, bool1, hasUrn, bool2, hasCreatedAt, bool3, hasJobUrl, bool4);
    label886:
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
      paramObject = (JymbiiUpdate)paramObject;
      if (actions != null)
      {
        if (actions.equals(actions)) {}
      }
      else {
        while (actions != null) {
          return false;
        }
      }
      if (urn != null)
      {
        if (urn.equals(urn)) {}
      }
      else {
        while (urn != null) {
          return false;
        }
      }
      if (company != null)
      {
        if (company.equals(company)) {}
      }
      else {
        while (company != null) {
          return false;
        }
      }
      if (createdAt != createdAt) {
        return false;
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
      if (jobUrl != null)
      {
        if (jobUrl.equals(jobUrl)) {}
      }
      else {
        while (jobUrl != null) {
          return false;
        }
      }
      if (flavors == null) {
        break;
      }
    } while (flavors.equals(flavors));
    for (;;)
    {
      return false;
      if (flavors == null) {
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
    int j = i;
    Object localObject1;
    Object localObject2;
    if (hasActions)
    {
      i += 2;
      localObject1 = actions.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (UpdateAction)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((UpdateAction)localObject2).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasUrn)
    {
      localObject1 = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(urn));
    }
    j = i + 1;
    i = j;
    if (hasCompany)
    {
      i = j + 1;
      if (company._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(company._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasCreatedAt) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasMiniJob)
      {
        i = j + 1;
        if (miniJob._cachedId == null) {
          break label353;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniJob._cachedId);
      }
      label238:
      j = i + 1;
      i = j;
      if (hasJobUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(jobUrl);
      }
      i += 1;
      j = i;
      if (!hasFlavors) {
        break label377;
      }
      i += 2;
      localObject1 = flavors.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label377;
      }
      localObject2 = (EntitiesFlavor)((Iterator)localObject1).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += company.getSerializedSize();
        break;
        label353:
        i += miniJob.getSerializedSize();
        break label238;
      }
      i += ((EntitiesFlavor)localObject2).getSerializedSize();
    }
    label377:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label47:
    int k;
    label62:
    int i2;
    int m;
    if (actions != null)
    {
      i = actions.hashCode();
      if (urn == null) {
        break label179;
      }
      j = urn.hashCode();
      if (company == null) {
        break label184;
      }
      k = company.hashCode();
      i2 = (int)(createdAt ^ createdAt >>> 32);
      if (miniJob == null) {
        break label189;
      }
      m = miniJob.hashCode();
      label93:
      if (jobUrl == null) {
        break label195;
      }
    }
    label179:
    label184:
    label189:
    label195:
    for (int n = jobUrl.hashCode();; n = 0)
    {
      if (flavors != null) {
        i1 = flavors.hashCode();
      }
      i = (n + (m + ((k + (j + (i + 527) * 31) * 31) * 31 + i2) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label47;
      k = 0;
      break label62;
      m = 0;
      break label93;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building JymbiiUpdate");
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
    label343:
    label367:
    label427:
    label453:
    label570:
    label595:
    label605:
    label615:
    label640:
    label650:
    label683:
    label690:
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
        localByteBuffer.putInt(691345961);
        Object localObject1;
        Object localObject2;
        if (hasActions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
          localObject1 = actions.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (UpdateAction)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((UpdateAction)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((UpdateAction)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          localObject1 = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasCompany) {
            break label595;
          }
          localByteBuffer.put((byte)1);
          if (company._cachedId == null) {
            break label570;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, company._cachedId);
          company.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCreatedAt) {
            break label605;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(createdAt);
          if (!hasMiniJob) {
            break label640;
          }
          localByteBuffer.put((byte)1);
          if (miniJob._cachedId == null) {
            break label615;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniJob._cachedId);
          miniJob.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasJobUrl) {
            break label650;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, jobUrl);
          if (!hasFlavors) {
            break label683;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, flavors.size());
          localObject1 = flavors.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label690;
          }
          localObject2 = (EntitiesFlavor)((Iterator)localObject1).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((EntitiesFlavor)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            company.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label343;
            localByteBuffer.put((byte)0);
            break label343;
            localByteBuffer.put((byte)0);
            break label367;
            localByteBuffer.put((byte)1);
            miniJob.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label427;
            localByteBuffer.put((byte)0);
            break label427;
            localByteBuffer.put((byte)0);
            break label453;
          }
          localByteBuffer.put((byte)1);
          ((EntitiesFlavor)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Company
    implements FissileDataModel<Company>, UnionTemplate<Company>
  {
    public static final JymbiiUpdateBuilder.CompanyBuilder BUILDER = JymbiiUpdateBuilder.CompanyBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final CompanyActor companyActorValue;
    public final ExternalCompany externalCompanyValue;
    public final boolean hasCompanyActorValue;
    public final boolean hasExternalCompanyValue;
    
    Company(CompanyActor paramCompanyActor, ExternalCompany paramExternalCompany, boolean paramBoolean1, boolean paramBoolean2)
    {
      companyActorValue = paramCompanyActor;
      externalCompanyValue = paramExternalCompany;
      hasCompanyActorValue = paramBoolean1;
      hasExternalCompanyValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final Company accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasCompanyActorValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.CompanyActor");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = companyActorValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label149;
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
        if (hasExternalCompanyValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.shared.ExternalCompany");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label158;
          }
          localObject1 = externalCompanyValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label176;
          }
        }
      }
      label149:
      label158:
      label176:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label181;
        }
        return new Company((CompanyActor)localObject2, (ExternalCompany)localObject1, bool1, bool2);
        localObject1 = (CompanyActor)paramDataProcessor.processDataTemplate(companyActorValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (ExternalCompany)paramDataProcessor.processDataTemplate(externalCompanyValue);
        break label95;
      }
      label181:
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
        paramObject = (Company)paramObject;
        if (companyActorValue != null)
        {
          if (companyActorValue.equals(companyActorValue)) {}
        }
        else {
          while (companyActorValue != null) {
            return false;
          }
        }
        if (externalCompanyValue == null) {
          break;
        }
      } while (externalCompanyValue.equals(externalCompanyValue));
      for (;;)
      {
        return false;
        if (externalCompanyValue == null) {
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
      if (hasCompanyActorValue)
      {
        if (companyActorValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(companyActorValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasExternalCompanyValue)
        {
          i = j + 1;
          if (externalCompanyValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(externalCompanyValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = companyActorValue.getSerializedSize() + 7;
        break;
        label114:
        i += externalCompanyValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (companyActorValue != null) {}
      for (int i = companyActorValue.hashCode();; i = 0)
      {
        if (externalCompanyValue != null) {
          j = externalCompanyValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Company");
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
          localByteBuffer.putInt(-664617948);
          if (hasCompanyActorValue)
          {
            localByteBuffer.put((byte)1);
            if (companyActorValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, companyActorValue._cachedId);
              companyActorValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasExternalCompanyValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (externalCompanyValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, externalCompanyValue._cachedId);
              externalCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            companyActorValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            externalCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */