package com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.WeChatContactInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.TwitterHandle;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
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

public final class Connection
  implements FissileDataModel<Connection>, RecordTemplate<Connection>
{
  public static final ConnectionBuilder BUILDER = ConnectionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasMiniProfile;
  public final boolean hasPhoneNumbers;
  public final boolean hasPrimaryEmailAddress;
  public final boolean hasTwitterHandles;
  public final boolean hasWeChatContactInfo;
  public final MiniProfile miniProfile;
  public final List<PhoneNumber> phoneNumbers;
  public final String primaryEmailAddress;
  public final List<TwitterHandle> twitterHandles;
  public final WeChatContactInfo weChatContactInfo;
  
  Connection(Urn paramUrn, MiniProfile paramMiniProfile, List<PhoneNumber> paramList, String paramString, List<TwitterHandle> paramList1, WeChatContactInfo paramWeChatContactInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    entityUrn = paramUrn;
    miniProfile = paramMiniProfile;
    if (paramList == null)
    {
      paramMiniProfile = null;
      phoneNumbers = paramMiniProfile;
      primaryEmailAddress = paramString;
      if (paramList1 != null) {
        break label120;
      }
    }
    label120:
    for (paramMiniProfile = (MiniProfile)localObject;; paramMiniProfile = Collections.unmodifiableList(paramList1))
    {
      twitterHandles = paramMiniProfile;
      weChatContactInfo = paramWeChatContactInfo;
      hasEntityUrn = paramBoolean1;
      hasMiniProfile = paramBoolean2;
      hasPhoneNumbers = paramBoolean3;
      hasPrimaryEmailAddress = paramBoolean4;
      hasTwitterHandles = paramBoolean5;
      hasWeChatContactInfo = paramBoolean6;
      paramMiniProfile = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
      paramMiniProfile = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  private Connection accept(DataProcessor paramDataProcessor)
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
    Object localObject4 = null;
    boolean bool1 = false;
    label89:
    boolean bool2;
    int i;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label255;
        }
        bool1 = true;
        localObject4 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasPhoneNumbers) {
        break label294;
      }
      paramDataProcessor.startRecordField$505cff1c("phoneNumbers");
      phoneNumbers.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = phoneNumbers.iterator();
      label164:
      if (!((Iterator)localObject3).hasNext()) {
        break label280;
      }
      localObject2 = (PhoneNumber)((Iterator)localObject3).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label264;
      }
    }
    label255:
    label264:
    for (Object localObject2 = ((PhoneNumber)localObject2).accept(paramDataProcessor);; localObject2 = (PhoneNumber)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label164;
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break;
      bool1 = false;
      localObject4 = localObject1;
      break label89;
    }
    label280:
    paramDataProcessor.endArray();
    label294:
    boolean bool3;
    if (localObject1 != null)
    {
      bool2 = true;
      if (hasPrimaryEmailAddress)
      {
        paramDataProcessor.startRecordField$505cff1c("primaryEmailAddress");
        paramDataProcessor.processString(primaryEmailAddress);
      }
      localObject2 = null;
      localObject3 = null;
      bool3 = false;
      if (!hasTwitterHandles) {
        break label503;
      }
      paramDataProcessor.startRecordField$505cff1c("twitterHandles");
      twitterHandles.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = twitterHandles.iterator();
      label394:
      if (!localIterator.hasNext()) {
        break label489;
      }
      localObject3 = (TwitterHandle)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label473;
      }
    }
    label473:
    for (Object localObject3 = ((TwitterHandle)localObject3).accept(paramDataProcessor);; localObject3 = (TwitterHandle)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject2 != null) && (localObject3 != null)) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
      break label394;
      bool2 = false;
      break;
    }
    label489:
    paramDataProcessor.endArray();
    if (localObject2 != null)
    {
      bool3 = true;
      label503:
      localObject3 = null;
      bool4 = false;
      if (hasWeChatContactInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("weChatContactInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label625;
        }
        localObject3 = weChatContactInfo.accept(paramDataProcessor);
        label543:
        if (localObject3 == null) {
          break label643;
        }
      }
    }
    label625:
    label643:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label788;
      }
      if (!hasPhoneNumbers) {
        localObject1 = Collections.emptyList();
      }
      if (!hasTwitterHandles) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (hasMiniProfile) {
          break label649;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection", "miniProfile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool3 = false;
      break;
      localObject3 = (WeChatContactInfo)paramDataProcessor.processDataTemplate(weChatContactInfo);
      break label543;
    }
    label649:
    if (phoneNumbers != null)
    {
      paramDataProcessor = phoneNumbers.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PhoneNumber)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection", "phoneNumbers");
        }
      }
    }
    if (twitterHandles != null)
    {
      paramDataProcessor = twitterHandles.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((TwitterHandle)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection", "twitterHandles");
        }
      }
    }
    return new Connection(entityUrn, (MiniProfile)localObject4, (List)localObject1, primaryEmailAddress, (List)localObject2, (WeChatContactInfo)localObject3, hasEntityUrn, bool1, bool2, hasPrimaryEmailAddress, bool3, bool4);
    label788:
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
      paramObject = (Connection)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
      if (phoneNumbers != null)
      {
        if (phoneNumbers.equals(phoneNumbers)) {}
      }
      else {
        while (phoneNumbers != null) {
          return false;
        }
      }
      if (primaryEmailAddress != null)
      {
        if (primaryEmailAddress.equals(primaryEmailAddress)) {}
      }
      else {
        while (primaryEmailAddress != null) {
          return false;
        }
      }
      if (twitterHandles != null)
      {
        if (twitterHandles.equals(twitterHandles)) {}
      }
      else {
        while (twitterHandles != null) {
          return false;
        }
      }
      if (weChatContactInfo == null) {
        break;
      }
    } while (weChatContactInfo.equals(weChatContactInfo));
    for (;;)
    {
      return false;
      if (weChatContactInfo == null) {
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
    Object localObject1;
    if (hasEntityUrn)
    {
      localObject1 = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasMiniProfile)
    {
      i = j + 1;
      if (miniProfile._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasPhoneNumbers) {
        break label188;
      }
      i += 2;
      localObject1 = phoneNumbers.iterator();
    }
    Object localObject2;
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label188;
      }
      localObject2 = (PhoneNumber)((Iterator)localObject1).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += miniProfile.getSerializedSize();
        break;
      }
      i += ((PhoneNumber)localObject2).getSerializedSize();
    }
    label188:
    j += 1;
    i = j;
    if (hasPrimaryEmailAddress) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(primaryEmailAddress);
    }
    i += 1;
    j = i;
    if (hasTwitterHandles)
    {
      i += 2;
      localObject1 = twitterHandles.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (TwitterHandle)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((TwitterHandle)localObject2).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasWeChatContactInfo)
    {
      i = j + 1;
      if (weChatContactInfo._cachedId == null) {
        break label350;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(weChatContactInfo._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label350:
      i += weChatContactInfo.getSerializedSize();
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
    label62:
    int m;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (miniProfile == null) {
        break label158;
      }
      j = miniProfile.hashCode();
      if (phoneNumbers == null) {
        break label163;
      }
      k = phoneNumbers.hashCode();
      if (primaryEmailAddress == null) {
        break label168;
      }
      m = primaryEmailAddress.hashCode();
      label78:
      if (twitterHandles == null) {
        break label174;
      }
    }
    label158:
    label163:
    label168:
    label174:
    for (int n = twitterHandles.hashCode();; n = 0)
    {
      if (weChatContactInfo != null) {
        i1 = weChatContactInfo.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label62;
      m = 0;
      break label78;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Connection");
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
    label206:
    label323:
    label348:
    label381:
    label388:
    label561:
    label689:
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
        localByteBuffer.putInt(-786005709);
        Object localObject1;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject1 = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasMiniProfile) {
            break label348;
          }
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId == null) {
            break label323;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
          miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasPhoneNumbers) {
            break label381;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, phoneNumbers.size());
          localObject1 = phoneNumbers.iterator();
        }
        Object localObject2;
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label388;
          }
          localObject2 = (PhoneNumber)((Iterator)localObject1).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((PhoneNumber)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label206;
            localByteBuffer.put((byte)0);
            break label206;
          }
          localByteBuffer.put((byte)1);
          ((PhoneNumber)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasPrimaryEmailAddress)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, primaryEmailAddress);
          if (hasTwitterHandles)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, twitterHandles.size());
            localObject1 = twitterHandles.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label561;
            }
            localObject2 = (TwitterHandle)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((TwitterHandle)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            ((TwitterHandle)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
        }
        localByteBuffer.put((byte)0);
        if (hasWeChatContactInfo)
        {
          localByteBuffer.put((byte)1);
          if (weChatContactInfo._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, weChatContactInfo._cachedId);
            weChatContactInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label689;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          weChatContactInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<Connection>
  {
    private Urn entityUrn = null;
    private boolean hasEntityUrn = false;
    public boolean hasMiniProfile = false;
    private boolean hasPhoneNumbers = false;
    private boolean hasPrimaryEmailAddress = false;
    private boolean hasTwitterHandles = false;
    private boolean hasWeChatContactInfo = false;
    public MiniProfile miniProfile = null;
    private List<PhoneNumber> phoneNumbers = null;
    private String primaryEmailAddress = null;
    private List<TwitterHandle> twitterHandles = null;
    private WeChatContactInfo weChatContactInfo = null;
    
    private Connection build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Connection.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (phoneNumbers != null)
      {
        paramFlavor = phoneNumbers.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((PhoneNumber)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection", "phoneNumbers");
              if (!hasPhoneNumbers) {
                phoneNumbers = Collections.emptyList();
              }
              if (!hasTwitterHandles) {
                twitterHandles = Collections.emptyList();
              }
              if (hasMiniProfile) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection", "miniProfile");
            }
          }
        }
      }
      if (twitterHandles != null)
      {
        paramFlavor = twitterHandles.iterator();
        while (paramFlavor.hasNext()) {
          if ((TwitterHandle)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection", "twitterHandles");
          }
        }
      }
      return new Connection(entityUrn, miniProfile, phoneNumbers, primaryEmailAddress, twitterHandles, weChatContactInfo, hasEntityUrn, hasMiniProfile, hasPhoneNumbers, hasPrimaryEmailAddress, hasTwitterHandles, hasWeChatContactInfo);
    }
    
    public final Connection build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
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
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */