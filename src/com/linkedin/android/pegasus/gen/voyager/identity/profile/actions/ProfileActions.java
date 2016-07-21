package com.linkedin.android.pegasus.gen.voyager.identity.profile.actions;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
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

public final class ProfileActions
  implements FissileDataModel<ProfileActions>, RecordTemplate<ProfileActions>
{
  public static final ProfileActionsBuilder BUILDER = ProfileActionsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final List<ProfileAction> actions;
  public final Urn entityUrn;
  public final boolean hasActions;
  public final boolean hasEntityUrn;
  public final boolean hasOverflowActions;
  public final boolean hasPrimaryAction;
  public final boolean hasSecondaryAction;
  public final List<ProfileAction> overflowActions;
  public final ProfileAction primaryAction;
  public final ProfileAction secondaryAction;
  
  ProfileActions(Urn paramUrn, ProfileAction paramProfileAction1, ProfileAction paramProfileAction2, List<ProfileAction> paramList1, List<ProfileAction> paramList2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    entityUrn = paramUrn;
    primaryAction = paramProfileAction1;
    secondaryAction = paramProfileAction2;
    if (paramList1 == null)
    {
      paramProfileAction1 = null;
      overflowActions = paramProfileAction1;
      if (paramList2 != null) {
        break label109;
      }
    }
    label109:
    for (paramProfileAction1 = (ProfileAction)localObject;; paramProfileAction1 = Collections.unmodifiableList(paramList2))
    {
      actions = paramProfileAction1;
      hasEntityUrn = paramBoolean1;
      hasPrimaryAction = paramBoolean2;
      hasSecondaryAction = paramBoolean3;
      hasOverflowActions = paramBoolean4;
      hasActions = paramBoolean5;
      paramProfileAction1 = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
      paramProfileAction1 = Collections.unmodifiableList(paramList1);
      break;
    }
  }
  
  private ProfileActions accept(DataProcessor paramDataProcessor)
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
    Object localObject3 = null;
    boolean bool1 = false;
    label89:
    Object localObject4;
    boolean bool2;
    label129:
    label141:
    boolean bool3;
    int i;
    if (hasPrimaryAction)
    {
      paramDataProcessor.startRecordField$505cff1c("primaryAction");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = primaryAction.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label307;
        }
        bool1 = true;
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject4 = null;
      bool2 = false;
      if (hasSecondaryAction)
      {
        paramDataProcessor.startRecordField$505cff1c("secondaryAction");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label316;
        }
        localObject1 = secondaryAction.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label334;
        }
        bool2 = true;
        localObject4 = localObject1;
      }
      localObject1 = null;
      localObject2 = null;
      bool3 = false;
      if (!hasOverflowActions) {
        break label374;
      }
      paramDataProcessor.startRecordField$505cff1c("overflowActions");
      overflowActions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject5 = overflowActions.iterator();
      label216:
      if (!((Iterator)localObject5).hasNext()) {
        break label360;
      }
      localObject2 = (ProfileAction)((Iterator)localObject5).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label344;
      }
    }
    label307:
    label316:
    label334:
    label344:
    for (Object localObject2 = ((ProfileAction)localObject2).accept(paramDataProcessor);; localObject2 = (ProfileAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label216;
      localObject1 = (ProfileAction)paramDataProcessor.processDataTemplate(primaryAction);
      break;
      bool1 = false;
      localObject3 = localObject1;
      break label89;
      localObject1 = (ProfileAction)paramDataProcessor.processDataTemplate(secondaryAction);
      break label129;
      bool2 = false;
      localObject4 = localObject1;
      break label141;
    }
    label360:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool3 = true;
      label374:
      localObject2 = null;
      localObject5 = null;
      bool4 = false;
      if (!hasActions) {
        break label558;
      }
      paramDataProcessor.startRecordField$505cff1c("actions");
      actions.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject5;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = actions.iterator();
      label449:
      if (!localIterator.hasNext()) {
        break label544;
      }
      localObject5 = (ProfileAction)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label528;
      }
    }
    label528:
    for (Object localObject5 = ((ProfileAction)localObject5).accept(paramDataProcessor);; localObject5 = (ProfileAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject5))
    {
      if ((localObject2 != null) && (localObject5 != null)) {
        ((List)localObject2).add(localObject5);
      }
      i += 1;
      break label449;
      bool3 = false;
      break;
    }
    label544:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label558:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label744;
      }
      if (!hasOverflowActions) {
        localObject1 = Collections.emptyList();
      }
      if (!hasActions) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (overflowActions == null) {
          break;
        }
        paramDataProcessor = overflowActions.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((ProfileAction)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActions", "overflowActions");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((ProfileAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActions", "actions");
        }
      }
    }
    return new ProfileActions(entityUrn, (ProfileAction)localObject3, (ProfileAction)localObject4, (List)localObject1, (List)localObject2, hasEntityUrn, bool1, bool2, bool3, bool4);
    label744:
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
      paramObject = (ProfileActions)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (primaryAction != null)
      {
        if (primaryAction.equals(primaryAction)) {}
      }
      else {
        while (primaryAction != null) {
          return false;
        }
      }
      if (secondaryAction != null)
      {
        if (secondaryAction.equals(secondaryAction)) {}
      }
      else {
        while (secondaryAction != null) {
          return false;
        }
      }
      if (overflowActions != null)
      {
        if (overflowActions.equals(overflowActions)) {}
      }
      else {
        while (overflowActions != null) {
          return false;
        }
      }
      if (actions == null) {
        break;
      }
    } while (actions.equals(actions));
    for (;;)
    {
      return false;
      if (actions == null) {
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
    if (hasPrimaryAction)
    {
      i = j + 1;
      if (primaryAction._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(primaryAction._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasSecondaryAction)
      {
        i = j + 1;
        if (secondaryAction._cachedId == null) {
          break label219;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(secondaryAction._cachedId);
      }
      label129:
      i += 1;
      j = i;
      if (!hasOverflowActions) {
        break label243;
      }
      i += 2;
      localObject = overflowActions.iterator();
    }
    ProfileAction localProfileAction;
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label243;
      }
      localProfileAction = (ProfileAction)((Iterator)localObject).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += primaryAction.getSerializedSize();
        break;
        label219:
        i += secondaryAction.getSerializedSize();
        break label129;
      }
      i += localProfileAction.getSerializedSize();
    }
    label243:
    i = j + 1;
    j = i;
    if (hasActions)
    {
      i += 2;
      localObject = actions.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localProfileAction = (ProfileAction)((Iterator)localObject).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localProfileAction.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
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
    int k;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (primaryAction == null) {
        break label136;
      }
      j = primaryAction.hashCode();
      if (secondaryAction == null) {
        break label141;
      }
      k = secondaryAction.hashCode();
      label60:
      if (overflowActions == null) {
        break label146;
      }
    }
    label136:
    label141:
    label146:
    for (int m = overflowActions.hashCode();; m = 0)
    {
      if (actions != null) {
        n = actions.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfileActions");
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
    label204:
    label264:
    label381:
    label406:
    label416:
    label441:
    label474:
    label481:
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
        localByteBuffer.putInt(-325522205);
        Object localObject;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasPrimaryAction) {
            break label406;
          }
          localByteBuffer.put((byte)1);
          if (primaryAction._cachedId == null) {
            break label381;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, primaryAction._cachedId);
          primaryAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSecondaryAction) {
            break label441;
          }
          localByteBuffer.put((byte)1);
          if (secondaryAction._cachedId == null) {
            break label416;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, secondaryAction._cachedId);
          secondaryAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasOverflowActions) {
            break label474;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, overflowActions.size());
          localObject = overflowActions.iterator();
        }
        ProfileAction localProfileAction;
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label481;
          }
          localProfileAction = (ProfileAction)((Iterator)localObject).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localProfileAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            primaryAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label204;
            localByteBuffer.put((byte)0);
            break label204;
            localByteBuffer.put((byte)1);
            secondaryAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label264;
            localByteBuffer.put((byte)0);
            break label264;
          }
          localByteBuffer.put((byte)1);
          localProfileAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasActions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
          localObject = actions.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localProfileAction = (ProfileAction)((Iterator)localObject).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localProfileAction.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localProfileAction.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
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
    implements RecordTemplateBuilder<ProfileActions>
  {
    private List<ProfileAction> actions = null;
    private Urn entityUrn = null;
    private boolean hasActions = false;
    private boolean hasEntityUrn = false;
    public boolean hasOverflowActions = false;
    private boolean hasPrimaryAction = false;
    private boolean hasSecondaryAction = false;
    public List<ProfileAction> overflowActions = null;
    private ProfileAction primaryAction = null;
    private ProfileAction secondaryAction = null;
    
    public Builder() {}
    
    public Builder(ProfileActions paramProfileActions)
    {
      entityUrn = entityUrn;
      primaryAction = primaryAction;
      secondaryAction = secondaryAction;
      overflowActions = overflowActions;
      actions = actions;
      hasEntityUrn = hasEntityUrn;
      hasPrimaryAction = hasPrimaryAction;
      hasSecondaryAction = hasSecondaryAction;
      hasOverflowActions = hasOverflowActions;
      hasActions = hasActions;
    }
    
    public final ProfileActions build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ProfileActions.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (overflowActions != null)
      {
        paramFlavor = overflowActions.iterator();
        do
        {
          if (!paramFlavor.hasNext()) {
            break;
          }
        } while ((ProfileAction)paramFlavor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActions", "overflowActions");
        if (!hasOverflowActions) {
          overflowActions = Collections.emptyList();
        }
        if (!hasActions) {
          actions = Collections.emptyList();
        }
      }
      if (actions != null)
      {
        paramFlavor = actions.iterator();
        while (paramFlavor.hasNext()) {
          if ((ProfileAction)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActions", "actions");
          }
        }
      }
      return new ProfileActions(entityUrn, primaryAction, secondaryAction, overflowActions, actions, hasEntityUrn, hasPrimaryAction, hasSecondaryAction, hasOverflowActions, hasActions);
    }
    
    public final Builder setPrimaryAction(ProfileAction paramProfileAction)
    {
      if (paramProfileAction == null)
      {
        hasPrimaryAction = false;
        primaryAction = null;
        return this;
      }
      hasPrimaryAction = true;
      primaryAction = paramProfileAction;
      return this;
    }
    
    public final Builder setSecondaryAction(ProfileAction paramProfileAction)
    {
      if (paramProfileAction == null)
      {
        hasSecondaryAction = false;
        secondaryAction = null;
        return this;
      }
      hasSecondaryAction = true;
      secondaryAction = paramProfileAction;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */