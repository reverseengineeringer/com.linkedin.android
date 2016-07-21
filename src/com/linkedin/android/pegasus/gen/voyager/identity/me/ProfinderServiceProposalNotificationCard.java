package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderMiniRequestForProposals;
import com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderNotificationType;
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

public final class ProfinderServiceProposalNotificationCard
  implements FissileDataModel<ProfinderServiceProposalNotificationCard>, RecordTemplate<ProfinderServiceProposalNotificationCard>
{
  public static final ProfinderServiceProposalNotificationCardBuilder BUILDER = ProfinderServiceProposalNotificationCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasProfinderMiniRequestForProposals;
  public final boolean hasProfinderNotificationType;
  public final boolean hasProfinderServiceProposalUrl;
  public final boolean hasProviderProfiles;
  public final boolean hasPublishedAt;
  public final boolean hasRead;
  public final ProfinderMiniRequestForProposals profinderMiniRequestForProposals;
  public final ProfinderNotificationType profinderNotificationType;
  public final String profinderServiceProposalUrl;
  public final List<ActorMiniProfile> providerProfiles;
  public final long publishedAt;
  public final boolean read;
  
  ProfinderServiceProposalNotificationCard(ProfinderNotificationType paramProfinderNotificationType, String paramString, long paramLong, ProfinderMiniRequestForProposals paramProfinderMiniRequestForProposals, List<ActorMiniProfile> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    profinderNotificationType = paramProfinderNotificationType;
    profinderServiceProposalUrl = paramString;
    publishedAt = paramLong;
    profinderMiniRequestForProposals = paramProfinderMiniRequestForProposals;
    if (paramList == null) {}
    for (paramProfinderNotificationType = null;; paramProfinderNotificationType = Collections.unmodifiableList(paramList))
    {
      providerProfiles = paramProfinderNotificationType;
      read = paramBoolean1;
      hasProfinderNotificationType = paramBoolean2;
      hasProfinderServiceProposalUrl = paramBoolean3;
      hasPublishedAt = paramBoolean4;
      hasProfinderMiniRequestForProposals = paramBoolean5;
      hasProviderProfiles = paramBoolean6;
      hasRead = paramBoolean7;
      _cachedId = null;
      return;
    }
  }
  
  public final ProfinderServiceProposalNotificationCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasProfinderNotificationType)
    {
      paramDataProcessor.startRecordField$505cff1c("profinderNotificationType");
      paramDataProcessor.processEnum(profinderNotificationType);
    }
    if (hasProfinderServiceProposalUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("profinderServiceProposalUrl");
      paramDataProcessor.processString(profinderServiceProposalUrl);
    }
    if (hasPublishedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("publishedAt");
      paramDataProcessor.processLong(publishedAt);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label131:
    int i;
    if (hasProfinderMiniRequestForProposals)
    {
      paramDataProcessor.startRecordField$505cff1c("profinderMiniRequestForProposals");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = profinderMiniRequestForProposals.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label297;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localActorMiniProfile = null;
      bool2 = false;
      if (!hasProviderProfiles) {
        break label336;
      }
      paramDataProcessor.startRecordField$505cff1c("providerProfiles");
      providerProfiles.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localActorMiniProfile;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = providerProfiles.iterator();
      label206:
      if (!localIterator.hasNext()) {
        break label322;
      }
      localActorMiniProfile = (ActorMiniProfile)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label306;
      }
    }
    label297:
    label306:
    for (ActorMiniProfile localActorMiniProfile = localActorMiniProfile.accept(paramDataProcessor);; localActorMiniProfile = (ActorMiniProfile)paramDataProcessor.processDataTemplate(localActorMiniProfile))
    {
      if ((localObject1 != null) && (localActorMiniProfile != null)) {
        ((List)localObject1).add(localActorMiniProfile);
      }
      i += 1;
      break label206;
      localObject1 = (ProfinderMiniRequestForProposals)paramDataProcessor.processDataTemplate(profinderMiniRequestForProposals);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label131;
    }
    label322:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label336:
      if (hasRead)
      {
        paramDataProcessor.startRecordField$505cff1c("read");
        paramDataProcessor.processBoolean(read);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label603;
      }
      try
      {
        if (hasProfinderNotificationType) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "profinderNotificationType");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasProfinderServiceProposalUrl) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "profinderServiceProposalUrl");
    }
    if (!hasPublishedAt) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "publishedAt");
    }
    if (!hasProfinderMiniRequestForProposals) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "profinderMiniRequestForProposals");
    }
    if (!hasProviderProfiles) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "providerProfiles");
    }
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "read");
    }
    if (providerProfiles != null)
    {
      paramDataProcessor = providerProfiles.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((ActorMiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "providerProfiles");
        }
      }
    }
    return new ProfinderServiceProposalNotificationCard(profinderNotificationType, profinderServiceProposalUrl, publishedAt, (ProfinderMiniRequestForProposals)localObject2, (List)localObject1, read, hasProfinderNotificationType, hasProfinderServiceProposalUrl, hasPublishedAt, bool1, bool2, hasRead);
    label603:
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
      paramObject = (ProfinderServiceProposalNotificationCard)paramObject;
      if (profinderNotificationType != null)
      {
        if (profinderNotificationType.equals(profinderNotificationType)) {}
      }
      else {
        while (profinderNotificationType != null) {
          return false;
        }
      }
      if (profinderServiceProposalUrl != null)
      {
        if (profinderServiceProposalUrl.equals(profinderServiceProposalUrl)) {}
      }
      else {
        while (profinderServiceProposalUrl != null) {
          return false;
        }
      }
      if (publishedAt != publishedAt) {
        return false;
      }
      if (profinderMiniRequestForProposals != null)
      {
        if (profinderMiniRequestForProposals.equals(profinderMiniRequestForProposals)) {}
      }
      else {
        while (profinderMiniRequestForProposals != null) {
          return false;
        }
      }
      if (providerProfiles != null)
      {
        if (providerProfiles.equals(providerProfiles)) {}
      }
      else {
        while (providerProfiles != null) {
          return false;
        }
      }
    } while (read == read);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasProfinderNotificationType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasProfinderServiceProposalUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(profinderServiceProposalUrl);
    }
    j = i + 1;
    i = j;
    if (hasPublishedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    Iterator localIterator;
    if (hasProfinderMiniRequestForProposals)
    {
      i = j + 1;
      if (profinderMiniRequestForProposals._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(profinderMiniRequestForProposals._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasProviderProfiles) {
        break label219;
      }
      i += 2;
      localIterator = providerProfiles.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label219;
      }
      ActorMiniProfile localActorMiniProfile = (ActorMiniProfile)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += profinderMiniRequestForProposals.getSerializedSize();
        break;
      }
      i += localActorMiniProfile.getSerializedSize();
    }
    label219:
    j += 1;
    i = j;
    if (hasRead) {
      i = j + 1;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int i1;
    int k;
    if (profinderNotificationType != null)
    {
      i = profinderNotificationType.hashCode();
      if (profinderServiceProposalUrl == null) {
        break label149;
      }
      j = profinderServiceProposalUrl.hashCode();
      i1 = (int)(publishedAt ^ publishedAt >>> 32);
      if (profinderMiniRequestForProposals == null) {
        break label154;
      }
      k = profinderMiniRequestForProposals.hashCode();
      label75:
      if (providerProfiles == null) {
        break label159;
      }
    }
    label149:
    label154:
    label159:
    for (int m = providerProfiles.hashCode();; m = 0)
    {
      if (read) {
        n = 1;
      }
      i = (m + (k + ((j + (i + 527) * 31) * 31 + i1) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label75;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfinderServiceProposalNotificationCard");
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
    label166:
    label190:
    label250:
    label367:
    label377:
    label387:
    label412:
    label445:
    label452:
    label532:
    label534:
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
        localByteBuffer.putInt(-364289497);
        Iterator localIterator;
        if (hasProfinderNotificationType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, profinderNotificationType.ordinal());
          if (!hasProfinderServiceProposalUrl) {
            break label367;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, profinderServiceProposalUrl);
          if (!hasPublishedAt) {
            break label377;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (!hasProfinderMiniRequestForProposals) {
            break label412;
          }
          localByteBuffer.put((byte)1);
          if (profinderMiniRequestForProposals._cachedId == null) {
            break label387;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, profinderMiniRequestForProposals._cachedId);
          profinderMiniRequestForProposals.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasProviderProfiles) {
            break label445;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, providerProfiles.size());
          localIterator = providerProfiles.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label452;
          }
          ActorMiniProfile localActorMiniProfile = (ActorMiniProfile)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localActorMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label166;
            localByteBuffer.put((byte)0);
            break label190;
            localByteBuffer.put((byte)1);
            profinderMiniRequestForProposals.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label250;
            localByteBuffer.put((byte)0);
            break label250;
          }
          localByteBuffer.put((byte)1);
          localActorMiniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasRead)
        {
          localByteBuffer.put((byte)1);
          if (read)
          {
            i = 1;
            localByteBuffer.put((byte)i);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label532;
          }
          if (str != null) {
            break label534;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          i = 0;
          break;
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
  
  public static final class Builder
    implements RecordTemplateBuilder<ProfinderServiceProposalNotificationCard>
  {
    private boolean hasProfinderMiniRequestForProposals = false;
    private boolean hasProfinderNotificationType = false;
    private boolean hasProfinderServiceProposalUrl = false;
    private boolean hasProviderProfiles = false;
    private boolean hasPublishedAt = false;
    public boolean hasRead = false;
    private ProfinderMiniRequestForProposals profinderMiniRequestForProposals = null;
    private ProfinderNotificationType profinderNotificationType = null;
    private String profinderServiceProposalUrl = null;
    private List<ActorMiniProfile> providerProfiles = null;
    private long publishedAt = 0L;
    public boolean read = false;
    
    public Builder() {}
    
    public Builder(ProfinderServiceProposalNotificationCard paramProfinderServiceProposalNotificationCard)
    {
      profinderNotificationType = profinderNotificationType;
      profinderServiceProposalUrl = profinderServiceProposalUrl;
      publishedAt = publishedAt;
      profinderMiniRequestForProposals = profinderMiniRequestForProposals;
      providerProfiles = providerProfiles;
      read = read;
      hasProfinderNotificationType = hasProfinderNotificationType;
      hasProfinderServiceProposalUrl = hasProfinderServiceProposalUrl;
      hasPublishedAt = hasPublishedAt;
      hasProfinderMiniRequestForProposals = hasProfinderMiniRequestForProposals;
      hasProviderProfiles = hasProviderProfiles;
      hasRead = hasRead;
    }
    
    public final ProfinderServiceProposalNotificationCard build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ProfinderServiceProposalNotificationCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (providerProfiles != null)
      {
        paramFlavor = providerProfiles.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((ActorMiniProfile)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "providerProfiles");
              if (!hasProfinderNotificationType) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "profinderNotificationType");
              }
              if (!hasProfinderServiceProposalUrl) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "profinderServiceProposalUrl");
              }
              if (!hasPublishedAt) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "publishedAt");
              }
              if (!hasProfinderMiniRequestForProposals) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "profinderMiniRequestForProposals");
              }
              if (!hasProviderProfiles) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "providerProfiles");
              }
              if (hasRead) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard", "read");
            }
          }
        }
      }
      return new ProfinderServiceProposalNotificationCard(profinderNotificationType, profinderServiceProposalUrl, publishedAt, profinderMiniRequestForProposals, providerProfiles, read, hasProfinderNotificationType, hasProfinderServiceProposalUrl, hasPublishedAt, hasProfinderMiniRequestForProposals, hasProviderProfiles, hasRead);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */