package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedConnectionsInfo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SearchProfile
  implements FissileDataModel<SearchProfile>, RecordTemplate<SearchProfile>
{
  public static final SearchProfileBuilder BUILDER = SearchProfileBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn backendUrn;
  public final MemberDistance distance;
  public final boolean hasBackendUrn;
  public final boolean hasDistance;
  public final boolean hasHeadless;
  public final boolean hasId;
  public final boolean hasIndustry;
  public final boolean hasLocation;
  public final boolean hasMaidenName;
  public final boolean hasMiniProfile;
  public final boolean hasSharedConnectionCount;
  public final boolean hasSharedConnectionsInfo;
  public final boolean hasSnippets;
  public final boolean headless;
  public final String id;
  public final String industry;
  public final String location;
  public final String maidenName;
  public final MiniProfile miniProfile;
  public final int sharedConnectionCount;
  public final SharedConnectionsInfo sharedConnectionsInfo;
  public final List<Snippet> snippets;
  
  SearchProfile(MiniProfile paramMiniProfile, String paramString1, Urn paramUrn, MemberDistance paramMemberDistance, String paramString2, String paramString3, String paramString4, List<Snippet> paramList, int paramInt, boolean paramBoolean1, SharedConnectionsInfo paramSharedConnectionsInfo, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12)
  {
    miniProfile = paramMiniProfile;
    id = paramString1;
    backendUrn = paramUrn;
    distance = paramMemberDistance;
    maidenName = paramString2;
    industry = paramString3;
    location = paramString4;
    if (paramList == null) {}
    for (paramMiniProfile = null;; paramMiniProfile = Collections.unmodifiableList(paramList))
    {
      snippets = paramMiniProfile;
      sharedConnectionCount = paramInt;
      headless = paramBoolean1;
      sharedConnectionsInfo = paramSharedConnectionsInfo;
      hasMiniProfile = paramBoolean2;
      hasId = paramBoolean3;
      hasBackendUrn = paramBoolean4;
      hasDistance = paramBoolean5;
      hasMaidenName = paramBoolean6;
      hasIndustry = paramBoolean7;
      hasLocation = paramBoolean8;
      hasSnippets = paramBoolean9;
      hasSharedConnectionCount = paramBoolean10;
      hasHeadless = paramBoolean11;
      hasSharedConnectionsInfo = paramBoolean12;
      _cachedId = null;
      return;
    }
  }
  
  public final SearchProfile accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label154:
    label166:
    boolean bool3;
    int i;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label403;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasId)
      {
        paramDataProcessor.startRecordField$505cff1c("id");
        paramDataProcessor.processString(id);
      }
      if (hasBackendUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("backendUrn");
        localObject1 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(backendUrn));
      }
      localObject3 = null;
      bool2 = false;
      if (hasDistance)
      {
        paramDataProcessor.startRecordField$505cff1c("distance");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label412;
        }
        localObject1 = distance.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label430;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      if (hasMaidenName)
      {
        paramDataProcessor.startRecordField$505cff1c("maidenName");
        paramDataProcessor.processString(maidenName);
      }
      if (hasIndustry)
      {
        paramDataProcessor.startRecordField$505cff1c("industry");
        paramDataProcessor.processString(industry);
      }
      if (hasLocation)
      {
        paramDataProcessor.startRecordField$505cff1c("location");
        paramDataProcessor.processString(location);
      }
      localObject4 = null;
      localObject1 = null;
      bool3 = false;
      if (!hasSnippets) {
        break label474;
      }
      paramDataProcessor.startRecordField$505cff1c("snippets");
      snippets.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = snippets.iterator();
      label312:
      if (!localIterator.hasNext()) {
        break label456;
      }
      localObject4 = (Snippet)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label440;
      }
    }
    label403:
    label412:
    label430:
    label440:
    for (Object localObject4 = ((Snippet)localObject4).accept(paramDataProcessor);; localObject4 = (Snippet)paramDataProcessor.processDataTemplate((DataTemplate)localObject4))
    {
      if ((localObject1 != null) && (localObject4 != null)) {
        ((List)localObject1).add(localObject4);
      }
      i += 1;
      break label312;
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (MemberDistance)paramDataProcessor.processDataTemplate(distance);
      break label154;
      bool2 = false;
      localObject3 = localObject1;
      break label166;
    }
    label456:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool3 = true;
      localObject4 = localObject1;
      label474:
      if (hasSharedConnectionCount)
      {
        paramDataProcessor.startRecordField$505cff1c("sharedConnectionCount");
        paramDataProcessor.processInt(sharedConnectionCount);
      }
      if (hasHeadless)
      {
        paramDataProcessor.startRecordField$505cff1c("headless");
        paramDataProcessor.processBoolean(headless);
      }
      localObject1 = null;
      bool4 = false;
      if (hasSharedConnectionsInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("sharedConnectionsInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label626;
        }
        localObject1 = sharedConnectionsInfo.accept(paramDataProcessor);
        label564:
        if (localObject1 == null) {
          break label644;
        }
      }
    }
    label626:
    label644:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label855;
      }
      try
      {
        if (hasMiniProfile) {
          break label650;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchProfile", "miniProfile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool3 = false;
      localObject4 = localObject1;
      break;
      localObject1 = (SharedConnectionsInfo)paramDataProcessor.processDataTemplate(sharedConnectionsInfo);
      break label564;
    }
    label650:
    if (!hasId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchProfile", "id");
    }
    if (!hasBackendUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchProfile", "backendUrn");
    }
    if (!hasDistance) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchProfile", "distance");
    }
    if (!hasHeadless) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchProfile", "headless");
    }
    if (snippets != null)
    {
      paramDataProcessor = snippets.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Snippet)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.search.SearchProfile", "snippets");
        }
      }
    }
    return new SearchProfile((MiniProfile)localObject2, id, backendUrn, (MemberDistance)localObject3, maidenName, industry, location, (List)localObject4, sharedConnectionCount, headless, (SharedConnectionsInfo)localObject1, bool1, hasId, hasBackendUrn, bool2, hasMaidenName, hasIndustry, hasLocation, bool3, hasSharedConnectionCount, hasHeadless, bool4);
    label855:
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (SearchProfile)paramObject;
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
      if (id != null)
      {
        if (id.equals(id)) {}
      }
      else {
        while (id != null) {
          return false;
        }
      }
      if (backendUrn != null)
      {
        if (backendUrn.equals(backendUrn)) {}
      }
      else {
        while (backendUrn != null) {
          return false;
        }
      }
      if (distance != null)
      {
        if (distance.equals(distance)) {}
      }
      else {
        while (distance != null) {
          return false;
        }
      }
      if (maidenName != null)
      {
        if (maidenName.equals(maidenName)) {}
      }
      else {
        while (maidenName != null) {
          return false;
        }
      }
      if (industry != null)
      {
        if (industry.equals(industry)) {}
      }
      else {
        while (industry != null) {
          return false;
        }
      }
      if (location != null)
      {
        if (location.equals(location)) {}
      }
      else {
        while (location != null) {
          return false;
        }
      }
      if (snippets != null)
      {
        if (snippets.equals(snippets)) {}
      }
      else {
        while (snippets != null) {
          return false;
        }
      }
      if (sharedConnectionCount != sharedConnectionCount) {
        return false;
      }
      if (headless != headless) {
        return false;
      }
      if (sharedConnectionsInfo == null) {
        break;
      }
    } while (sharedConnectionsInfo.equals(sharedConnectionsInfo));
    for (;;)
    {
      return false;
      if (sharedConnectionsInfo == null) {
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
    if (hasMiniProfile)
    {
      if (miniProfile._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(id);
      }
      j = i + 1;
      i = j;
      if (hasBackendUrn)
      {
        localObject = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(backendUrn));
      }
      j = i + 1;
      i = j;
      if (hasDistance)
      {
        i = j + 1;
        if (distance._cachedId == null) {
          break label316;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(distance._cachedId);
      }
      label150:
      j = i + 1;
      i = j;
      if (hasMaidenName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(maidenName);
      }
      j = i + 1;
      i = j;
      if (hasIndustry) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(industry);
      }
      j = i + 1;
      i = j;
      if (hasLocation) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(location);
      }
      i += 1;
      j = i;
      if (!hasSnippets) {
        break label340;
      }
      i += 2;
      localObject = snippets.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label340;
      }
      Snippet localSnippet = (Snippet)((Iterator)localObject).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = miniProfile.getSerializedSize() + 7;
        break;
        label316:
        i += distance.getSerializedSize();
        break label150;
      }
      i += localSnippet.getSerializedSize();
    }
    label340:
    j += 1;
    i = j;
    if (hasSharedConnectionCount) {
      i = j + 4;
    }
    int j = i + 1;
    i = j;
    if (hasHeadless) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasSharedConnectionsInfo)
    {
      i = j + 1;
      if (sharedConnectionsInfo._cachedId == null) {
        break label423;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(sharedConnectionsInfo._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label423:
      i += sharedConnectionsInfo.getSerializedSize();
    }
  }
  
  public int hashCode()
  {
    int i5 = 0;
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
    label124:
    int i3;
    label142:
    int i6;
    if (miniProfile != null)
    {
      i = miniProfile.hashCode();
      if (id == null) {
        break label250;
      }
      j = id.hashCode();
      if (backendUrn == null) {
        break label255;
      }
      k = backendUrn.hashCode();
      if (distance == null) {
        break label260;
      }
      m = distance.hashCode();
      if (maidenName == null) {
        break label266;
      }
      n = maidenName.hashCode();
      if (industry == null) {
        break label272;
      }
      i1 = industry.hashCode();
      if (location == null) {
        break label278;
      }
      i2 = location.hashCode();
      if (snippets == null) {
        break label284;
      }
      i3 = snippets.hashCode();
      i6 = sharedConnectionCount;
      if (!headless) {
        break label290;
      }
    }
    label250:
    label255:
    label260:
    label266:
    label272:
    label278:
    label284:
    label290:
    for (int i4 = 1;; i4 = 0)
    {
      if (sharedConnectionsInfo != null) {
        i5 = sharedConnectionsInfo.hashCode();
      }
      i = (i4 + ((i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i6) * 31) * 31 + i5;
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
      break label124;
      i3 = 0;
      break label142;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchProfile");
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
    label198:
    label232:
    label292:
    label318:
    label344:
    label370:
    label512:
    label522:
    label532:
    label557:
    label567:
    label577:
    label587:
    label620:
    label627:
    label675:
    label684:
    label787:
    label793:
    label803:
    label828:
    label836:
    label838:
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
        localByteBuffer.putInt(-670248090);
        Object localObject;
        if (hasMiniProfile)
        {
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
            miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasId) {
              break label512;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, id);
            if (!hasBackendUrn) {
              break label522;
            }
            localByteBuffer.put((byte)1);
            localObject = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
            if (!hasDistance) {
              break label557;
            }
            localByteBuffer.put((byte)1);
            if (distance._cachedId == null) {
              break label532;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, distance._cachedId);
            distance.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMaidenName) {
              break label567;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, maidenName);
            if (!hasIndustry) {
              break label577;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, industry);
            if (!hasLocation) {
              break label587;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, location);
            if (!hasSnippets) {
              break label620;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, snippets.size());
            localObject = snippets.iterator();
          }
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label627;
          }
          Snippet localSnippet = (Snippet)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localSnippet.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label198;
            localByteBuffer.put((byte)0);
            break label232;
            localByteBuffer.put((byte)1);
            distance.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label292;
            localByteBuffer.put((byte)0);
            break label292;
            localByteBuffer.put((byte)0);
            break label318;
            localByteBuffer.put((byte)0);
            break label344;
            localByteBuffer.put((byte)0);
            break label370;
          }
          localByteBuffer.put((byte)1);
          localSnippet.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasSharedConnectionCount)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(sharedConnectionCount);
          if (!hasHeadless) {
            break label793;
          }
          localByteBuffer.put((byte)1);
          if (!headless) {
            break label787;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasSharedConnectionsInfo) {
            break label828;
          }
          localByteBuffer.put((byte)1);
          if (sharedConnectionsInfo._cachedId == null) {
            break label803;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, sharedConnectionsInfo._cachedId);
          sharedConnectionsInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label836;
          }
          if (str != null) {
            break label838;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
          break label675;
          localByteBuffer.put((byte)0);
          break label684;
          localByteBuffer.put((byte)1);
          sharedConnectionsInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */