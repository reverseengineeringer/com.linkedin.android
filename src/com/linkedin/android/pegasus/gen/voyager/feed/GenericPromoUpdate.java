package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.growth.socialProof.MemberSocialProof;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
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

public final class GenericPromoUpdate
  implements FissileDataModel<GenericPromoUpdate>, RecordTemplate<GenericPromoUpdate>
{
  public static final GenericPromoUpdateBuilder BUILDER = GenericPromoUpdateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<PromoAction> actions;
  public final FormInputValue formInputValue;
  public final boolean hasActions;
  public final boolean hasFormInputValue;
  public final boolean hasHeader;
  public final boolean hasLegoTrackingId;
  public final boolean hasMainText;
  public final boolean hasSocialProofArray;
  public final boolean hasType;
  public final AttributedText header;
  public final String legoTrackingId;
  public final AttributedText mainText;
  public final List<MemberSocialProof> socialProofArray;
  public final PromoType type;
  
  GenericPromoUpdate(AttributedText paramAttributedText1, AttributedText paramAttributedText2, PromoType paramPromoType, FormInputValue paramFormInputValue, List<PromoAction> paramList, List<MemberSocialProof> paramList1, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    header = paramAttributedText1;
    mainText = paramAttributedText2;
    type = paramPromoType;
    formInputValue = paramFormInputValue;
    if (paramList == null)
    {
      paramAttributedText1 = null;
      actions = paramAttributedText1;
      if (paramList1 != null) {
        break label122;
      }
    }
    label122:
    for (paramAttributedText1 = null;; paramAttributedText1 = Collections.unmodifiableList(paramList1))
    {
      socialProofArray = paramAttributedText1;
      legoTrackingId = paramString;
      hasHeader = paramBoolean1;
      hasMainText = paramBoolean2;
      hasType = paramBoolean3;
      hasFormInputValue = paramBoolean4;
      hasActions = paramBoolean5;
      hasSocialProofArray = paramBoolean6;
      hasLegoTrackingId = paramBoolean7;
      _cachedId = null;
      return;
      paramAttributedText1 = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  public final GenericPromoUpdate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label96:
    label108:
    Object localObject4;
    boolean bool3;
    label173:
    label185:
    boolean bool4;
    int i;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label347;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasMainText)
      {
        paramDataProcessor.startRecordField$505cff1c("mainText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label356;
        }
        localObject1 = mainText.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label374;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      if (hasType)
      {
        paramDataProcessor.startRecordField$505cff1c("type");
        paramDataProcessor.processEnum(type);
      }
      localObject4 = null;
      bool3 = false;
      if (hasFormInputValue)
      {
        paramDataProcessor.startRecordField$505cff1c("formInputValue");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label384;
        }
        localObject1 = formInputValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label402;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      localObject1 = null;
      bool4 = false;
      if (!hasActions) {
        break label446;
      }
      paramDataProcessor.startRecordField$505cff1c("actions");
      actions.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject6 = actions.iterator();
      label256:
      if (!((Iterator)localObject6).hasNext()) {
        break label428;
      }
      localObject5 = (PromoAction)((Iterator)localObject6).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label412;
      }
    }
    label347:
    label356:
    label374:
    label384:
    label402:
    label412:
    for (Object localObject5 = ((PromoAction)localObject5).accept(paramDataProcessor);; localObject5 = (PromoAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject5))
    {
      if ((localObject1 != null) && (localObject5 != null)) {
        ((List)localObject1).add(localObject5);
      }
      i += 1;
      break label256;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(header);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(mainText);
      break label96;
      bool2 = false;
      localObject3 = localObject1;
      break label108;
      localObject1 = (FormInputValue)paramDataProcessor.processDataTemplate(formInputValue);
      break label173;
      bool3 = false;
      localObject4 = localObject1;
      break label185;
    }
    label428:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool4 = true;
      localObject5 = localObject1;
      label446:
      localObject1 = null;
      localObject6 = null;
      bool5 = false;
      if (!hasSocialProofArray) {
        break label634;
      }
      paramDataProcessor.startRecordField$505cff1c("socialProofArray");
      socialProofArray.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject6;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = socialProofArray.iterator();
      label521:
      if (!localIterator.hasNext()) {
        break label620;
      }
      localObject6 = (MemberSocialProof)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label604;
      }
    }
    label604:
    for (Object localObject6 = ((MemberSocialProof)localObject6).accept(paramDataProcessor);; localObject6 = (MemberSocialProof)paramDataProcessor.processDataTemplate((DataTemplate)localObject6))
    {
      if ((localObject1 != null) && (localObject6 != null)) {
        ((List)localObject1).add(localObject6);
      }
      i += 1;
      break label521;
      bool4 = false;
      localObject5 = localObject1;
      break;
    }
    label620:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool5 = true;; bool5 = false)
    {
      label634:
      if (hasLegoTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("legoTrackingId");
        localObject6 = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(legoTrackingId));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label929;
      }
      if (!hasSocialProofArray) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate", "type");
    }
    if (!hasActions) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate", "actions");
    }
    if (!hasLegoTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate", "legoTrackingId");
    }
    if (actions != null)
    {
      paramDataProcessor = actions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PromoAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate", "actions");
        }
      }
    }
    if (socialProofArray != null)
    {
      paramDataProcessor = socialProofArray.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MemberSocialProof)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate", "socialProofArray");
        }
      }
    }
    return new GenericPromoUpdate((AttributedText)localObject2, (AttributedText)localObject3, type, (FormInputValue)localObject4, (List)localObject5, (List)localObject1, legoTrackingId, bool1, bool2, hasType, bool3, bool4, bool5, hasLegoTrackingId);
    label929:
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
      paramObject = (GenericPromoUpdate)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (mainText != null)
      {
        if (mainText.equals(mainText)) {}
      }
      else {
        while (mainText != null) {
          return false;
        }
      }
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (formInputValue != null)
      {
        if (formInputValue.equals(formInputValue)) {}
      }
      else {
        while (formInputValue != null) {
          return false;
        }
      }
      if (actions != null)
      {
        if (actions.equals(actions)) {}
      }
      else {
        while (actions != null) {
          return false;
        }
      }
      if (socialProofArray != null)
      {
        if (socialProofArray.equals(socialProofArray)) {}
      }
      else {
        while (socialProofArray != null) {
          return false;
        }
      }
      if (legoTrackingId == null) {
        break;
      }
    } while (legoTrackingId.equals(legoTrackingId));
    for (;;)
    {
      return false;
      if (legoTrackingId == null) {
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
    label93:
    label152:
    Iterator localIterator;
    if (hasHeader)
    {
      if (header._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(header._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasMainText)
      {
        i = j + 1;
        if (mainText._cachedId == null) {
          break label243;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(mainText._cachedId);
      }
      j = i + 1;
      i = j;
      if (hasType) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasFormInputValue)
      {
        i = j + 1;
        if (formInputValue._cachedId == null) {
          break label256;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(formInputValue._cachedId);
      }
      i += 1;
      j = i;
      if (!hasActions) {
        break label280;
      }
      i += 2;
      localIterator = actions.iterator();
    }
    Object localObject;
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label280;
      }
      localObject = (PromoAction)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = header.getSerializedSize() + 7;
        break;
        label243:
        i += mainText.getSerializedSize();
        break label93;
        label256:
        i += formInputValue.getSerializedSize();
        break label152;
      }
      i += ((PromoAction)localObject).getSerializedSize();
    }
    label280:
    i = j + 1;
    int j = i;
    if (hasSocialProofArray)
    {
      i += 2;
      localIterator = socialProofArray.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (MemberSocialProof)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((MemberSocialProof)localObject).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasLegoTrackingId) {
      i = j + 4 + legoTrackingId.getBytes().length;
    }
    __sizeOfObject = i;
    return i;
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
    if (header != null)
    {
      i = header.hashCode();
      if (mainText == null) {
        break label180;
      }
      j = mainText.hashCode();
      if (type == null) {
        break label185;
      }
      k = type.hashCode();
      if (formInputValue == null) {
        break label190;
      }
      m = formInputValue.hashCode();
      if (actions == null) {
        break label196;
      }
      n = actions.hashCode();
      label94:
      if (socialProofArray == null) {
        break label202;
      }
    }
    label180:
    label185:
    label190:
    label196:
    label202:
    for (int i1 = socialProofArray.hashCode();; i1 = 0)
    {
      if (legoTrackingId != null) {
        i2 = legoTrackingId.hashCode();
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
      break label94;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building GenericPromoUpdate");
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
    label232:
    label261:
    label321:
    label463:
    label488:
    label498:
    label508:
    label533:
    label566:
    label573:
    label793:
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
        localByteBuffer.putInt(194095927);
        Object localObject1;
        if (hasHeader)
        {
          localByteBuffer.put((byte)1);
          if (header._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, header._cachedId);
            header.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMainText) {
              break label488;
            }
            localByteBuffer.put((byte)1);
            if (mainText._cachedId == null) {
              break label463;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, mainText._cachedId);
            mainText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasType) {
              break label498;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
            if (!hasFormInputValue) {
              break label533;
            }
            localByteBuffer.put((byte)1);
            if (formInputValue._cachedId == null) {
              break label508;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, formInputValue._cachedId);
            formInputValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasActions) {
              break label566;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, actions.size());
            localObject1 = actions.iterator();
          }
        }
        Object localObject2;
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label573;
          }
          localObject2 = (PromoAction)((Iterator)localObject1).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((PromoAction)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            header.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            mainText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label232;
            localByteBuffer.put((byte)0);
            break label232;
            localByteBuffer.put((byte)0);
            break label261;
            localByteBuffer.put((byte)1);
            formInputValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label321;
            localByteBuffer.put((byte)0);
            break label321;
          }
          localByteBuffer.put((byte)1);
          ((PromoAction)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasSocialProofArray)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, socialProofArray.size());
          localObject1 = socialProofArray.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MemberSocialProof)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((MemberSocialProof)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((MemberSocialProof)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasLegoTrackingId)
        {
          localByteBuffer.put((byte)1);
          localObject1 = legoTrackingId.getBytes();
          localByteBuffer.putInt(localObject1.length);
          localByteBuffer.put((byte[])localObject1);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label793;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
  
  public static final class FormInputValue
    implements FissileDataModel<FormInputValue>, UnionTemplate<FormInputValue>
  {
    public static final GenericPromoUpdateBuilder.FormInputValueBuilder BUILDER = GenericPromoUpdateBuilder.FormInputValueBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasPhoneNumberValue;
    public final boolean hasStringValue;
    public final PhoneNumber phoneNumberValue;
    public final String stringValue;
    
    FormInputValue(String paramString, PhoneNumber paramPhoneNumber, boolean paramBoolean1, boolean paramBoolean2)
    {
      stringValue = paramString;
      phoneNumberValue = paramPhoneNumber;
      hasStringValue = paramBoolean1;
      hasPhoneNumberValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final FormInputValue accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      if (hasStringValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("string");
        paramDataProcessor.processString(stringValue);
      }
      PhoneNumber localPhoneNumber = null;
      boolean bool = false;
      if (hasPhoneNumberValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.common.PhoneNumber");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label107;
        }
        localPhoneNumber = phoneNumberValue.accept(paramDataProcessor);
        if (localPhoneNumber == null) {
          break label124;
        }
      }
      label107:
      label124:
      for (bool = true;; bool = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label129;
        }
        return new FormInputValue(stringValue, localPhoneNumber, hasStringValue, bool);
        localPhoneNumber = (PhoneNumber)paramDataProcessor.processDataTemplate(phoneNumberValue);
        break;
      }
      label129:
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
        paramObject = (FormInputValue)paramObject;
        if (stringValue != null)
        {
          if (stringValue.equals(stringValue)) {}
        }
        else {
          while (stringValue != null) {
            return false;
          }
        }
        if (phoneNumberValue == null) {
          break;
        }
      } while (phoneNumberValue.equals(phoneNumberValue));
      for (;;)
      {
        return false;
        if (phoneNumberValue == null) {
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
      if (hasStringValue) {
        i = PegasusBinaryUtils.getEncodedLength(stringValue) + 8;
      }
      int j = i + 1;
      i = j;
      if (hasPhoneNumberValue)
      {
        i = j + 1;
        if (phoneNumberValue._cachedId == null) {
          break label87;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(phoneNumberValue._cachedId);
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        label87:
        i += phoneNumberValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (stringValue != null) {}
      for (int i = stringValue.hashCode();; i = 0)
      {
        if (phoneNumberValue != null) {
          j = phoneNumberValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building FormInputValue");
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
      label239:
      label264:
      label272:
      label274:
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
          localByteBuffer.putInt(216059969);
          if (hasStringValue)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, stringValue);
            if (!hasPhoneNumberValue) {
              break label264;
            }
            localByteBuffer.put((byte)1);
            if (phoneNumberValue._cachedId == null) {
              break label239;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, phoneNumberValue._cachedId);
            phoneNumberValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label272;
            }
            if (str != null) {
              break label274;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            phoneNumberValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.GenericPromoUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */