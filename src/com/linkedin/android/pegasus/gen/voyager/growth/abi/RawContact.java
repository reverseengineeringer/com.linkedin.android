package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.IM;
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

public final class RawContact
  implements FissileDataModel<RawContact>, RecordTemplate<RawContact>
{
  public static final RawContactBuilder BUILDER = RawContactBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<Address> addresses;
  public final boolean bookmarked;
  public final Date bornOn;
  public final List<Email> emails;
  public final String firstName;
  public final String fullName;
  public final boolean hasAddresses;
  public final boolean hasBookmarked;
  public final boolean hasBornOn;
  public final boolean hasEmails;
  public final boolean hasFirstName;
  public final boolean hasFullName;
  public final boolean hasInstantMessageHandles;
  public final boolean hasLastName;
  public final boolean hasMiddleName;
  public final boolean hasNotes;
  public final boolean hasPhoneNumbers;
  public final boolean hasSites;
  public final boolean hasTitle;
  public final List<IM> instantMessageHandles;
  public final String lastName;
  public final String middleName;
  public final String notes;
  public final List<PhoneNumber> phoneNumbers;
  public final List<Site> sites;
  public final String title;
  
  RawContact(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<Email> paramList, List<PhoneNumber> paramList1, List<IM> paramList2, List<Address> paramList3, Date paramDate, List<Site> paramList4, boolean paramBoolean1, String paramString6, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14)
  {
    fullName = paramString1;
    firstName = paramString2;
    lastName = paramString3;
    middleName = paramString4;
    title = paramString5;
    if (paramList == null)
    {
      paramString1 = null;
      emails = paramString1;
      if (paramList1 != null) {
        break label212;
      }
      paramString1 = null;
      label60:
      phoneNumbers = paramString1;
      if (paramList2 != null) {
        break label221;
      }
      paramString1 = null;
      label72:
      instantMessageHandles = paramString1;
      if (paramList3 != null) {
        break label230;
      }
      paramString1 = null;
      label84:
      addresses = paramString1;
      bornOn = paramDate;
      if (paramList4 != null) {
        break label239;
      }
    }
    label212:
    label221:
    label230:
    label239:
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList4))
    {
      sites = paramString1;
      bookmarked = paramBoolean1;
      notes = paramString6;
      hasFullName = paramBoolean2;
      hasFirstName = paramBoolean3;
      hasLastName = paramBoolean4;
      hasMiddleName = paramBoolean5;
      hasTitle = paramBoolean6;
      hasEmails = paramBoolean7;
      hasPhoneNumbers = paramBoolean8;
      hasInstantMessageHandles = paramBoolean9;
      hasAddresses = paramBoolean10;
      hasBornOn = paramBoolean11;
      hasSites = paramBoolean12;
      hasBookmarked = paramBoolean13;
      hasNotes = paramBoolean14;
      _cachedId = null;
      return;
      paramString1 = Collections.unmodifiableList(paramList);
      break;
      paramString1 = Collections.unmodifiableList(paramList1);
      break label60;
      paramString1 = Collections.unmodifiableList(paramList2);
      break label72;
      paramString1 = Collections.unmodifiableList(paramList3);
      break label84;
    }
  }
  
  public final RawContact accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasFullName)
    {
      paramDataProcessor.startRecordField$505cff1c("fullName");
      paramDataProcessor.processString(fullName);
    }
    if (hasFirstName)
    {
      paramDataProcessor.startRecordField$505cff1c("firstName");
      paramDataProcessor.processString(firstName);
    }
    if (hasLastName)
    {
      paramDataProcessor.startRecordField$505cff1c("lastName");
      paramDataProcessor.processString(lastName);
    }
    if (hasMiddleName)
    {
      paramDataProcessor.startRecordField$505cff1c("middleName");
      paramDataProcessor.processString(middleName);
    }
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    int i;
    boolean bool2;
    if (hasEmails)
    {
      paramDataProcessor.startRecordField$505cff1c("emails");
      emails.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = emails.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (Email)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((Email)localObject2).accept(paramDataProcessor);; localObject2 = (Email)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
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
      localObject2 = null;
      localObject3 = null;
      bool2 = false;
      if (!hasPhoneNumbers) {
        break label490;
      }
      paramDataProcessor.startRecordField$505cff1c("phoneNumbers");
      phoneNumbers.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      localObject4 = phoneNumbers.iterator();
      label382:
      if (!((Iterator)localObject4).hasNext()) {
        break label476;
      }
      localObject3 = (PhoneNumber)((Iterator)localObject4).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label460;
      }
    }
    label460:
    for (Object localObject3 = ((PhoneNumber)localObject3).accept(paramDataProcessor);; localObject3 = (PhoneNumber)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject2 != null) && (localObject3 != null)) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
      break label382;
      bool1 = false;
      break;
    }
    label476:
    paramDataProcessor.endArray();
    label490:
    boolean bool3;
    if (localObject2 != null)
    {
      bool2 = true;
      localObject3 = null;
      localObject4 = null;
      bool3 = false;
      if (!hasInstantMessageHandles) {
        break label674;
      }
      paramDataProcessor.startRecordField$505cff1c("instantMessageHandles");
      instantMessageHandles.size();
      paramDataProcessor.startArray$13462e();
      localObject3 = localObject4;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject3 = new ArrayList();
      }
      i = 0;
      localObject5 = instantMessageHandles.iterator();
      label565:
      if (!((Iterator)localObject5).hasNext()) {
        break label660;
      }
      localObject4 = (IM)((Iterator)localObject5).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label644;
      }
    }
    label644:
    for (Object localObject4 = ((IM)localObject4).accept(paramDataProcessor);; localObject4 = (IM)paramDataProcessor.processDataTemplate((DataTemplate)localObject4))
    {
      if ((localObject3 != null) && (localObject4 != null)) {
        ((List)localObject3).add(localObject4);
      }
      i += 1;
      break label565;
      bool2 = false;
      break;
    }
    label660:
    paramDataProcessor.endArray();
    label674:
    boolean bool4;
    Object localObject6;
    if (localObject3 != null)
    {
      bool3 = true;
      localObject4 = null;
      localObject5 = null;
      bool4 = false;
      if (!hasAddresses) {
        break label858;
      }
      paramDataProcessor.startRecordField$505cff1c("addresses");
      addresses.size();
      paramDataProcessor.startArray$13462e();
      localObject4 = localObject5;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject4 = new ArrayList();
      }
      i = 0;
      localObject6 = addresses.iterator();
      label749:
      if (!((Iterator)localObject6).hasNext()) {
        break label844;
      }
      localObject5 = (Address)((Iterator)localObject6).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label828;
      }
    }
    label828:
    for (Object localObject5 = ((Address)localObject5).accept(paramDataProcessor);; localObject5 = (Address)paramDataProcessor.processDataTemplate((DataTemplate)localObject5))
    {
      if ((localObject4 != null) && (localObject5 != null)) {
        ((List)localObject4).add(localObject5);
      }
      i += 1;
      break label749;
      bool3 = false;
      break;
    }
    label844:
    paramDataProcessor.endArray();
    label858:
    boolean bool5;
    if (localObject4 != null)
    {
      bool4 = true;
      localObject6 = null;
      bool5 = false;
      if (hasBornOn)
      {
        paramDataProcessor.startRecordField$505cff1c("bornOn");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label1064;
        }
        localObject5 = bornOn.accept(paramDataProcessor);
        label898:
        if (localObject5 == null) {
          break label1082;
        }
        bool5 = true;
        localObject6 = localObject5;
      }
      label910:
      localObject5 = null;
      localSite = null;
      bool6 = false;
      if (!hasSites) {
        break label1122;
      }
      paramDataProcessor.startRecordField$505cff1c("sites");
      sites.size();
      paramDataProcessor.startArray$13462e();
      localObject5 = localSite;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject5 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = sites.iterator();
      label985:
      if (!localIterator.hasNext()) {
        break label1108;
      }
      localSite = (Site)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label1092;
      }
    }
    label1064:
    label1082:
    label1092:
    for (Site localSite = localSite.accept(paramDataProcessor);; localSite = (Site)paramDataProcessor.processDataTemplate(localSite))
    {
      if ((localObject5 != null) && (localSite != null)) {
        ((List)localObject5).add(localSite);
      }
      i += 1;
      break label985;
      bool4 = false;
      break;
      localObject5 = (Date)paramDataProcessor.processDataTemplate(bornOn);
      break label898;
      bool5 = false;
      localObject6 = localObject5;
      break label910;
    }
    label1108:
    paramDataProcessor.endArray();
    if (localObject5 != null) {}
    for (boolean bool6 = true;; bool6 = false)
    {
      label1122:
      if (hasBookmarked)
      {
        paramDataProcessor.startRecordField$505cff1c("bookmarked");
        paramDataProcessor.processBoolean(bookmarked);
      }
      if (hasNotes)
      {
        paramDataProcessor.startRecordField$505cff1c("notes");
        paramDataProcessor.processString(notes);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1605;
      }
      if (!hasEmails) {
        localObject1 = Collections.emptyList();
      }
      if (!hasPhoneNumbers) {
        localObject2 = Collections.emptyList();
      }
      if (!hasInstantMessageHandles) {
        localObject3 = Collections.emptyList();
      }
      if (!hasAddresses) {
        localObject4 = Collections.emptyList();
      }
      if (!hasSites) {
        localObject5 = Collections.emptyList();
      }
      try
      {
        if (emails == null) {
          break;
        }
        paramDataProcessor = emails.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((Email)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "emails");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (phoneNumbers != null)
    {
      paramDataProcessor = phoneNumbers.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PhoneNumber)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "phoneNumbers");
        }
      }
    }
    if (instantMessageHandles != null)
    {
      paramDataProcessor = instantMessageHandles.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((IM)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "instantMessageHandles");
        }
      }
    }
    if (addresses != null)
    {
      paramDataProcessor = addresses.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Address)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "addresses");
        }
      }
    }
    if (sites != null)
    {
      paramDataProcessor = sites.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Site)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "sites");
        }
      }
    }
    return new RawContact(fullName, firstName, lastName, middleName, title, (List)localObject1, (List)localObject2, (List)localObject3, (List)localObject4, (Date)localObject6, (List)localObject5, bookmarked, notes, hasFullName, hasFirstName, hasLastName, hasMiddleName, hasTitle, bool1, bool2, bool3, bool4, bool5, bool6, hasBookmarked, hasNotes);
    label1605:
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
      paramObject = (RawContact)paramObject;
      if (fullName != null)
      {
        if (fullName.equals(fullName)) {}
      }
      else {
        while (fullName != null) {
          return false;
        }
      }
      if (firstName != null)
      {
        if (firstName.equals(firstName)) {}
      }
      else {
        while (firstName != null) {
          return false;
        }
      }
      if (lastName != null)
      {
        if (lastName.equals(lastName)) {}
      }
      else {
        while (lastName != null) {
          return false;
        }
      }
      if (middleName != null)
      {
        if (middleName.equals(middleName)) {}
      }
      else {
        while (middleName != null) {
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
      if (emails != null)
      {
        if (emails.equals(emails)) {}
      }
      else {
        while (emails != null) {
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
      if (instantMessageHandles != null)
      {
        if (instantMessageHandles.equals(instantMessageHandles)) {}
      }
      else {
        while (instantMessageHandles != null) {
          return false;
        }
      }
      if (addresses != null)
      {
        if (addresses.equals(addresses)) {}
      }
      else {
        while (addresses != null) {
          return false;
        }
      }
      if (bornOn != null)
      {
        if (bornOn.equals(bornOn)) {}
      }
      else {
        while (bornOn != null) {
          return false;
        }
      }
      if (sites != null)
      {
        if (sites.equals(sites)) {}
      }
      else {
        while (sites != null) {
          return false;
        }
      }
      if (bookmarked != bookmarked) {
        return false;
      }
      if (notes == null) {
        break;
      }
    } while (notes.equals(notes));
    for (;;)
    {
      return false;
      if (notes == null) {
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
    if (hasFullName) {
      i = PegasusBinaryUtils.getEncodedLength(fullName) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasFirstName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(firstName);
    }
    j = i + 1;
    i = j;
    if (hasLastName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(lastName);
    }
    j = i + 1;
    i = j;
    if (hasMiddleName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(middleName);
    }
    j = i + 1;
    i = j;
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    i += 1;
    j = i;
    Iterator localIterator;
    Object localObject;
    if (hasEmails)
    {
      i += 2;
      localIterator = emails.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Email)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((Email)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasPhoneNumbers)
    {
      i += 2;
      localIterator = phoneNumbers.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (PhoneNumber)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((PhoneNumber)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasInstantMessageHandles)
    {
      i += 2;
      localIterator = instantMessageHandles.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (IM)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((IM)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasAddresses)
    {
      i += 2;
      localIterator = addresses.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Address)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((Address)localObject).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasBornOn)
    {
      i = j + 1;
      if (bornOn._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(bornOn._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasSites) {
        break label633;
      }
      i += 2;
      localIterator = sites.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label633;
      }
      localObject = (Site)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += bornOn.getSerializedSize();
        break;
      }
      i += ((Site)localObject).getSerializedSize();
    }
    label633:
    j += 1;
    i = j;
    if (hasBookmarked) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasNotes) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(notes);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int i8 = 0;
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
    label110:
    int i2;
    label128:
    int i3;
    label146:
    int i4;
    label164:
    int i5;
    label180:
    int i6;
    if (fullName != null)
    {
      i = fullName.hashCode();
      if (firstName == null) {
        break label312;
      }
      j = firstName.hashCode();
      if (lastName == null) {
        break label317;
      }
      k = lastName.hashCode();
      if (middleName == null) {
        break label322;
      }
      m = middleName.hashCode();
      if (title == null) {
        break label328;
      }
      n = title.hashCode();
      if (emails == null) {
        break label334;
      }
      i1 = emails.hashCode();
      if (phoneNumbers == null) {
        break label340;
      }
      i2 = phoneNumbers.hashCode();
      if (instantMessageHandles == null) {
        break label346;
      }
      i3 = instantMessageHandles.hashCode();
      if (addresses == null) {
        break label352;
      }
      i4 = addresses.hashCode();
      if (bornOn == null) {
        break label358;
      }
      i5 = bornOn.hashCode();
      if (sites == null) {
        break label364;
      }
      i6 = sites.hashCode();
      label198:
      if (!bookmarked) {
        break label370;
      }
    }
    label312:
    label317:
    label322:
    label328:
    label334:
    label340:
    label346:
    label352:
    label358:
    label364:
    label370:
    for (int i7 = 1;; i7 = 0)
    {
      if (notes != null) {
        i8 = notes.hashCode();
      }
      i = (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i8;
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
      break label110;
      i2 = 0;
      break label128;
      i3 = 0;
      break label146;
      i4 = 0;
      break label164;
      i5 = 0;
      break label180;
      i6 = 0;
      break label198;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building RawContact");
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
    label164:
    label190:
    label216:
    label242:
    label359:
    label369:
    label379:
    label389:
    label422:
    label429:
    label1065:
    label1072:
    label1105:
    label1180:
    label1188:
    label1190:
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
        localByteBuffer.putInt(747452472);
        Iterator localIterator;
        if (hasFullName)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, fullName);
          if (!hasFirstName) {
            break label359;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, firstName);
          if (!hasLastName) {
            break label369;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, lastName);
          if (!hasMiddleName) {
            break label379;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, middleName);
          if (!hasTitle) {
            break label389;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasEmails) {
            break label422;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, emails.size());
          localIterator = emails.iterator();
        }
        Object localObject;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label429;
          }
          localObject = (Email)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((Email)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label164;
            localByteBuffer.put((byte)0);
            break label190;
            localByteBuffer.put((byte)0);
            break label216;
            localByteBuffer.put((byte)0);
            break label242;
          }
          localByteBuffer.put((byte)1);
          ((Email)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasPhoneNumbers)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, phoneNumbers.size());
          localIterator = phoneNumbers.iterator();
          while (localIterator.hasNext())
          {
            localObject = (PhoneNumber)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((PhoneNumber)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((PhoneNumber)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasInstantMessageHandles)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, instantMessageHandles.size());
          localIterator = instantMessageHandles.iterator();
          while (localIterator.hasNext())
          {
            localObject = (IM)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((IM)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((IM)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasAddresses)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, addresses.size());
          localIterator = addresses.iterator();
          while (localIterator.hasNext())
          {
            localObject = (Address)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((Address)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((Address)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasBornOn)
        {
          localByteBuffer.put((byte)1);
          if (bornOn._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, bornOn._cachedId);
            bornOn.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSites) {
              break label1065;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, sites.size());
            localIterator = sites.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label1072;
          }
          localObject = (Site)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((Site)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            bornOn.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
          }
          localByteBuffer.put((byte)1);
          ((Site)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasBookmarked)
        {
          localByteBuffer.put((byte)1);
          if (bookmarked)
          {
            i = 1;
            localByteBuffer.put((byte)i);
            if (!hasNotes) {
              break label1180;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, notes);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label1188;
          }
          if (str != null) {
            break label1190;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          i = 0;
          break;
          localByteBuffer.put((byte)0);
          break label1105;
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
    implements RecordTemplateBuilder<RawContact>
  {
    public List<Address> addresses = null;
    public boolean bookmarked = false;
    private Date bornOn = null;
    public List<Email> emails = null;
    public String firstName = null;
    public String fullName = null;
    public boolean hasAddresses = false;
    public boolean hasBookmarked = false;
    private boolean hasBornOn = false;
    public boolean hasEmails = false;
    public boolean hasFirstName = false;
    public boolean hasFullName = false;
    public boolean hasInstantMessageHandles = false;
    public boolean hasLastName = false;
    public boolean hasMiddleName = false;
    public boolean hasNotes = false;
    public boolean hasPhoneNumbers = false;
    public boolean hasSites = false;
    public boolean hasTitle = false;
    public List<IM> instantMessageHandles = null;
    public String lastName = null;
    public String middleName = null;
    public String notes = null;
    public List<PhoneNumber> phoneNumbers = null;
    public List<Site> sites = null;
    public String title = null;
    
    public final RawContact build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (RawContact.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (emails != null)
      {
        paramFlavor = emails.iterator();
        do
        {
          if (!paramFlavor.hasNext()) {
            break;
          }
        } while ((Email)paramFlavor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "emails");
        if (!hasEmails) {
          emails = Collections.emptyList();
        }
        if (!hasPhoneNumbers) {
          phoneNumbers = Collections.emptyList();
        }
        if (!hasInstantMessageHandles) {
          instantMessageHandles = Collections.emptyList();
        }
        if (!hasAddresses) {
          addresses = Collections.emptyList();
        }
        if (!hasSites) {
          sites = Collections.emptyList();
        }
        if (!hasBookmarked) {
          bookmarked = false;
        }
      }
      if (phoneNumbers != null)
      {
        paramFlavor = phoneNumbers.iterator();
        while (paramFlavor.hasNext()) {
          if ((PhoneNumber)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "phoneNumbers");
          }
        }
      }
      if (instantMessageHandles != null)
      {
        paramFlavor = instantMessageHandles.iterator();
        while (paramFlavor.hasNext()) {
          if ((IM)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "instantMessageHandles");
          }
        }
      }
      if (addresses != null)
      {
        paramFlavor = addresses.iterator();
        while (paramFlavor.hasNext()) {
          if ((Address)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "addresses");
          }
        }
      }
      if (sites != null)
      {
        paramFlavor = sites.iterator();
        while (paramFlavor.hasNext()) {
          if ((Site)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact", "sites");
          }
        }
      }
      return new RawContact(fullName, firstName, lastName, middleName, title, emails, phoneNumbers, instantMessageHandles, addresses, bornOn, sites, bookmarked, notes, hasFullName, hasFirstName, hasLastName, hasMiddleName, hasTitle, hasEmails, hasPhoneNumbers, hasInstantMessageHandles, hasAddresses, hasBornOn, hasSites, hasBookmarked, hasNotes);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */