package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.me.suggestedactions.AddSkills;
import com.linkedin.android.pegasus.gen.voyager.identity.me.suggestedactions.ComposeShare;
import com.linkedin.android.pegasus.gen.voyager.identity.me.suggestedactions.PYMK;
import com.linkedin.android.pegasus.gen.voyager.identity.me.suggestedactions.UpdateProfile;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SuggestedAction
  implements FissileDataModel<SuggestedAction>, UnionTemplate<SuggestedAction>
{
  public static final SuggestedActionBuilder BUILDER = SuggestedActionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AddSkills addSkillsValue;
  public final ComposeShare composeShareValue;
  public final boolean hasAddSkillsValue;
  public final boolean hasComposeShareValue;
  public final boolean hasPYMKValue;
  public final boolean hasUpdateProfileValue;
  public final PYMK pYMKValue;
  public final UpdateProfile updateProfileValue;
  
  SuggestedAction(AddSkills paramAddSkills, PYMK paramPYMK, UpdateProfile paramUpdateProfile, ComposeShare paramComposeShare, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    addSkillsValue = paramAddSkills;
    pYMKValue = paramPYMK;
    updateProfileValue = paramUpdateProfile;
    composeShareValue = paramComposeShare;
    hasAddSkillsValue = paramBoolean1;
    hasPYMKValue = paramBoolean2;
    hasUpdateProfileValue = paramBoolean3;
    hasComposeShareValue = paramBoolean4;
    _cachedId = null;
  }
  
  public final SuggestedAction accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label91:
    label102:
    Object localObject4;
    boolean bool3;
    if (hasAddSkillsValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.suggestedactions.AddSkills");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = addSkillsValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label257;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasPYMKValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.suggestedactions.PYMK");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label266;
        }
        localObject1 = PYMK.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label284;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasUpdateProfileValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.suggestedactions.UpdateProfile");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label293;
        }
        localObject1 = updateProfileValue.accept(paramDataProcessor);
        label142:
        if (localObject1 == null) {
          break label311;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label154:
      localObject1 = null;
      bool4 = false;
      if (hasComposeShareValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.suggestedactions.ComposeShare");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label321;
        }
        localObject1 = composeShareValue.accept(paramDataProcessor);
        label194:
        if (localObject1 == null) {
          break label339;
        }
      }
    }
    label257:
    label266:
    label284:
    label293:
    label311:
    label321:
    label339:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label345;
      }
      return new SuggestedAction((AddSkills)localObject2, (PYMK)localObject3, (UpdateProfile)localObject4, (ComposeShare)localObject1, bool1, bool2, bool3, bool4);
      localObject1 = (AddSkills)paramDataProcessor.processDataTemplate(addSkillsValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (PYMK)paramDataProcessor.processDataTemplate(pYMKValue);
      break label91;
      bool2 = false;
      localObject3 = localObject1;
      break label102;
      localObject1 = (UpdateProfile)paramDataProcessor.processDataTemplate(updateProfileValue);
      break label142;
      bool3 = false;
      localObject4 = localObject1;
      break label154;
      localObject1 = (ComposeShare)paramDataProcessor.processDataTemplate(composeShareValue);
      break label194;
    }
    label345:
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
      paramObject = (SuggestedAction)paramObject;
      if (addSkillsValue != null)
      {
        if (addSkillsValue.equals(addSkillsValue)) {}
      }
      else {
        while (addSkillsValue != null) {
          return false;
        }
      }
      if (pYMKValue != null)
      {
        if (pYMKValue.equals(pYMKValue)) {}
      }
      else {
        while (pYMKValue != null) {
          return false;
        }
      }
      if (updateProfileValue != null)
      {
        if (updateProfileValue.equals(updateProfileValue)) {}
      }
      else {
        while (updateProfileValue != null) {
          return false;
        }
      }
      if (composeShareValue == null) {
        break;
      }
    } while (composeShareValue.equals(composeShareValue));
    for (;;)
    {
      return false;
      if (composeShareValue == null) {
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
    if (hasAddSkillsValue)
    {
      if (addSkillsValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(addSkillsValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasPYMKValue)
      {
        i = j + 1;
        if (pYMKValue._cachedId == null) {
          break label198;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(pYMKValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasUpdateProfileValue)
      {
        i = j + 1;
        if (updateProfileValue._cachedId == null) {
          break label211;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(updateProfileValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasComposeShareValue)
      {
        i = j + 1;
        if (composeShareValue._cachedId == null) {
          break label224;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(composeShareValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = addSkillsValue.getSerializedSize() + 7;
      break;
      label198:
      i += pYMKValue.getSerializedSize();
      break label93;
      label211:
      i += updateProfileValue.getSerializedSize();
      break label135;
      label224:
      i += composeShareValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (addSkillsValue != null)
    {
      i = addSkillsValue.hashCode();
      if (pYMKValue == null) {
        break label110;
      }
      j = pYMKValue.hashCode();
      label45:
      if (updateProfileValue == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = updateProfileValue.hashCode();; k = 0)
    {
      if (composeShareValue != null) {
        m = composeShareValue.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SuggestedAction");
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
    label290:
    label418:
    label443:
    label453:
    label478:
    label488:
    label513:
    label521:
    label523:
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
        localByteBuffer.putInt(-1790560613);
        if (hasAddSkillsValue)
        {
          localByteBuffer.put((byte)1);
          if (addSkillsValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, addSkillsValue._cachedId);
            addSkillsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPYMKValue) {
              break label443;
            }
            localByteBuffer.put((byte)1);
            if (pYMKValue._cachedId == null) {
              break label418;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, pYMKValue._cachedId);
            pYMKValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasUpdateProfileValue) {
              break label478;
            }
            localByteBuffer.put((byte)1);
            if (updateProfileValue._cachedId == null) {
              break label453;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, updateProfileValue._cachedId);
            updateProfileValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasComposeShareValue) {
              break label513;
            }
            localByteBuffer.put((byte)1);
            if (composeShareValue._cachedId == null) {
              break label488;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, composeShareValue._cachedId);
            composeShareValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label521;
          }
          if (str != null) {
            break label523;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          addSkillsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          pYMKValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          updateProfileValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          composeShareValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */