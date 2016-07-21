package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollection;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SchoolItem
  implements FissileDataModel<SchoolItem>, RecordTemplate<SchoolItem>
{
  public static final SchoolItemBuilder BUILDER = SchoolItemBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasItem;
  public final boolean hasItemInfo;
  public final Item item;
  public final ItemInfo itemInfo;
  
  SchoolItem(ItemInfo paramItemInfo, Item paramItem, boolean paramBoolean1, boolean paramBoolean2)
  {
    itemInfo = paramItemInfo;
    item = paramItem;
    hasItemInfo = paramBoolean1;
    hasItem = paramBoolean2;
    _cachedId = null;
  }
  
  public final SchoolItem accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasItemInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("itemInfo");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = itemInfo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label164;
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
      if (hasItem)
      {
        paramDataProcessor.startRecordField$505cff1c("item");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label173;
        }
        localObject1 = item.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label191;
        }
      }
    }
    label164:
    label173:
    label191:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label229;
      }
      try
      {
        if (hasItemInfo) {
          break label196;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItem", "itemInfo");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (ItemInfo)paramDataProcessor.processDataTemplate(itemInfo);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (Item)paramDataProcessor.processDataTemplate(item);
      break label95;
    }
    label196:
    if (!hasItem) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItem", "item");
    }
    return new SchoolItem((ItemInfo)localObject2, (Item)localObject1, bool1, bool2);
    label229:
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
      paramObject = (SchoolItem)paramObject;
      if (itemInfo != null)
      {
        if (itemInfo.equals(itemInfo)) {}
      }
      else {
        while (itemInfo != null) {
          return false;
        }
      }
      if (item == null) {
        break;
      }
    } while (item.equals(item));
    for (;;)
    {
      return false;
      if (item == null) {
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
    if (hasItemInfo)
    {
      if (itemInfo._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(itemInfo._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasItem)
      {
        i = j + 1;
        if (item._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(item._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = itemInfo.getSerializedSize() + 7;
      break;
      label114:
      i += item.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (itemInfo != null) {}
    for (int i = itemInfo.hashCode();; i = 0)
    {
      if (item != null) {
        j = item.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SchoolItem");
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
        localByteBuffer.putInt(-1749924402);
        if (hasItemInfo)
        {
          localByteBuffer.put((byte)1);
          if (itemInfo._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, itemInfo._cachedId);
            itemInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasItem) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (item._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, item._cachedId);
            item.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          itemInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          item.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Item
    implements FissileDataModel<Item>, UnionTemplate<Item>
  {
    public static final SchoolItemBuilder.ItemBuilder BUILDER = SchoolItemBuilder.ItemBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final AlumniCompaniesCollection alumniCompaniesCollectionValue;
    public final Description descriptionValue;
    public final FinancialInformation financialInformationValue;
    public final boolean hasAlumniCompaniesCollectionValue;
    public final boolean hasDescriptionValue;
    public final boolean hasFinancialInformationValue;
    public final boolean hasMiniProfilesCollectionValue;
    public final boolean hasNextSchoolsCollectionValue;
    public final boolean hasNotableAlumniValue;
    public final boolean hasSchoolDetailsValue;
    public final boolean hasSchoolFacetsValue;
    public final boolean hasSchoolRankingsValue;
    public final boolean hasStudentsAndFacultyValue;
    public final MiniProfilesCollection miniProfilesCollectionValue;
    public final NextSchoolsCollection nextSchoolsCollectionValue;
    public final NotableAlumni notableAlumniValue;
    public final SchoolDetails schoolDetailsValue;
    public final SchoolFacets schoolFacetsValue;
    public final SchoolRankings schoolRankingsValue;
    public final StudentsAndFaculty studentsAndFacultyValue;
    
    Item(NextSchoolsCollection paramNextSchoolsCollection, SchoolDetails paramSchoolDetails, NotableAlumni paramNotableAlumni, SchoolRankings paramSchoolRankings, SchoolFacets paramSchoolFacets, FinancialInformation paramFinancialInformation, StudentsAndFaculty paramStudentsAndFaculty, AlumniCompaniesCollection paramAlumniCompaniesCollection, Description paramDescription, MiniProfilesCollection paramMiniProfilesCollection, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
    {
      nextSchoolsCollectionValue = paramNextSchoolsCollection;
      schoolDetailsValue = paramSchoolDetails;
      notableAlumniValue = paramNotableAlumni;
      schoolRankingsValue = paramSchoolRankings;
      schoolFacetsValue = paramSchoolFacets;
      financialInformationValue = paramFinancialInformation;
      studentsAndFacultyValue = paramStudentsAndFaculty;
      alumniCompaniesCollectionValue = paramAlumniCompaniesCollection;
      descriptionValue = paramDescription;
      miniProfilesCollectionValue = paramMiniProfilesCollection;
      hasNextSchoolsCollectionValue = paramBoolean1;
      hasSchoolDetailsValue = paramBoolean2;
      hasNotableAlumniValue = paramBoolean3;
      hasSchoolRankingsValue = paramBoolean4;
      hasSchoolFacetsValue = paramBoolean5;
      hasFinancialInformationValue = paramBoolean6;
      hasStudentsAndFacultyValue = paramBoolean7;
      hasAlumniCompaniesCollectionValue = paramBoolean8;
      hasDescriptionValue = paramBoolean9;
      hasMiniProfilesCollectionValue = paramBoolean10;
      _cachedId = null;
    }
    
    public final Item accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label56:
      Object localObject3;
      boolean bool2;
      label95:
      label106:
      Object localObject4;
      boolean bool3;
      label146:
      label158:
      Object localObject5;
      boolean bool4;
      label198:
      label210:
      Object localObject6;
      boolean bool5;
      label250:
      label262:
      Object localObject7;
      boolean bool6;
      label302:
      label314:
      Object localObject8;
      boolean bool7;
      label354:
      label366:
      Object localObject9;
      boolean bool8;
      label406:
      label418:
      Object localObject10;
      boolean bool9;
      if (hasNextSchoolsCollectionValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.school.NextSchoolsCollection");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = nextSchoolsCollectionValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label597;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasSchoolDetailsValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.school.SchoolDetails");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label606;
          }
          localObject1 = schoolDetailsValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label624;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        localObject4 = null;
        bool3 = false;
        if (hasNotableAlumniValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.school.NotableAlumni");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label633;
          }
          localObject1 = notableAlumniValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label651;
          }
          bool3 = true;
          localObject4 = localObject1;
        }
        localObject5 = null;
        bool4 = false;
        if (hasSchoolRankingsValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.school.SchoolRankings");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label661;
          }
          localObject1 = schoolRankingsValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label679;
          }
          bool4 = true;
          localObject5 = localObject1;
        }
        localObject6 = null;
        bool5 = false;
        if (hasSchoolFacetsValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.school.SchoolFacets");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label689;
          }
          localObject1 = schoolFacetsValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label707;
          }
          bool5 = true;
          localObject6 = localObject1;
        }
        localObject7 = null;
        bool6 = false;
        if (hasFinancialInformationValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.school.FinancialInformation");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label717;
          }
          localObject1 = financialInformationValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label735;
          }
          bool6 = true;
          localObject7 = localObject1;
        }
        localObject8 = null;
        bool7 = false;
        if (hasStudentsAndFacultyValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.school.StudentsAndFaculty");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label745;
          }
          localObject1 = studentsAndFacultyValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label763;
          }
          bool7 = true;
          localObject8 = localObject1;
        }
        localObject9 = null;
        bool8 = false;
        if (hasAlumniCompaniesCollectionValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.school.AlumniCompaniesCollection");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label773;
          }
          localObject1 = alumniCompaniesCollectionValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label791;
          }
          bool8 = true;
          localObject9 = localObject1;
        }
        localObject10 = null;
        bool9 = false;
        if (hasDescriptionValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.common.Description");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label801;
          }
          localObject1 = descriptionValue.accept(paramDataProcessor);
          label458:
          if (localObject1 == null) {
            break label819;
          }
          bool9 = true;
          localObject10 = localObject1;
        }
        label470:
        localObject1 = null;
        bool10 = false;
        if (hasMiniProfilesCollectionValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.common.MiniProfilesCollection");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label829;
          }
          localObject1 = miniProfilesCollectionValue.accept(paramDataProcessor);
          label510:
          if (localObject1 == null) {
            break label847;
          }
        }
      }
      label597:
      label606:
      label624:
      label633:
      label651:
      label661:
      label679:
      label689:
      label707:
      label717:
      label735:
      label745:
      label763:
      label773:
      label791:
      label801:
      label819:
      label829:
      label847:
      for (boolean bool10 = true;; bool10 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label853;
        }
        return new Item((NextSchoolsCollection)localObject2, (SchoolDetails)localObject3, (NotableAlumni)localObject4, (SchoolRankings)localObject5, (SchoolFacets)localObject6, (FinancialInformation)localObject7, (StudentsAndFaculty)localObject8, (AlumniCompaniesCollection)localObject9, (Description)localObject10, (MiniProfilesCollection)localObject1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10);
        localObject1 = (NextSchoolsCollection)paramDataProcessor.processDataTemplate(nextSchoolsCollectionValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (SchoolDetails)paramDataProcessor.processDataTemplate(schoolDetailsValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (NotableAlumni)paramDataProcessor.processDataTemplate(notableAlumniValue);
        break label146;
        bool3 = false;
        localObject4 = localObject1;
        break label158;
        localObject1 = (SchoolRankings)paramDataProcessor.processDataTemplate(schoolRankingsValue);
        break label198;
        bool4 = false;
        localObject5 = localObject1;
        break label210;
        localObject1 = (SchoolFacets)paramDataProcessor.processDataTemplate(schoolFacetsValue);
        break label250;
        bool5 = false;
        localObject6 = localObject1;
        break label262;
        localObject1 = (FinancialInformation)paramDataProcessor.processDataTemplate(financialInformationValue);
        break label302;
        bool6 = false;
        localObject7 = localObject1;
        break label314;
        localObject1 = (StudentsAndFaculty)paramDataProcessor.processDataTemplate(studentsAndFacultyValue);
        break label354;
        bool7 = false;
        localObject8 = localObject1;
        break label366;
        localObject1 = (AlumniCompaniesCollection)paramDataProcessor.processDataTemplate(alumniCompaniesCollectionValue);
        break label406;
        bool8 = false;
        localObject9 = localObject1;
        break label418;
        localObject1 = (Description)paramDataProcessor.processDataTemplate(descriptionValue);
        break label458;
        bool9 = false;
        localObject10 = localObject1;
        break label470;
        localObject1 = (MiniProfilesCollection)paramDataProcessor.processDataTemplate(miniProfilesCollectionValue);
        break label510;
      }
      label853:
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
        paramObject = (Item)paramObject;
        if (nextSchoolsCollectionValue != null)
        {
          if (nextSchoolsCollectionValue.equals(nextSchoolsCollectionValue)) {}
        }
        else {
          while (nextSchoolsCollectionValue != null) {
            return false;
          }
        }
        if (schoolDetailsValue != null)
        {
          if (schoolDetailsValue.equals(schoolDetailsValue)) {}
        }
        else {
          while (schoolDetailsValue != null) {
            return false;
          }
        }
        if (notableAlumniValue != null)
        {
          if (notableAlumniValue.equals(notableAlumniValue)) {}
        }
        else {
          while (notableAlumniValue != null) {
            return false;
          }
        }
        if (schoolRankingsValue != null)
        {
          if (schoolRankingsValue.equals(schoolRankingsValue)) {}
        }
        else {
          while (schoolRankingsValue != null) {
            return false;
          }
        }
        if (schoolFacetsValue != null)
        {
          if (schoolFacetsValue.equals(schoolFacetsValue)) {}
        }
        else {
          while (schoolFacetsValue != null) {
            return false;
          }
        }
        if (financialInformationValue != null)
        {
          if (financialInformationValue.equals(financialInformationValue)) {}
        }
        else {
          while (financialInformationValue != null) {
            return false;
          }
        }
        if (studentsAndFacultyValue != null)
        {
          if (studentsAndFacultyValue.equals(studentsAndFacultyValue)) {}
        }
        else {
          while (studentsAndFacultyValue != null) {
            return false;
          }
        }
        if (alumniCompaniesCollectionValue != null)
        {
          if (alumniCompaniesCollectionValue.equals(alumniCompaniesCollectionValue)) {}
        }
        else {
          while (alumniCompaniesCollectionValue != null) {
            return false;
          }
        }
        if (descriptionValue != null)
        {
          if (descriptionValue.equals(descriptionValue)) {}
        }
        else {
          while (descriptionValue != null) {
            return false;
          }
        }
        if (miniProfilesCollectionValue == null) {
          break;
        }
      } while (miniProfilesCollectionValue.equals(miniProfilesCollectionValue));
      for (;;)
      {
        return false;
        if (miniProfilesCollectionValue == null) {
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
      if (hasNextSchoolsCollectionValue)
      {
        if (nextSchoolsCollectionValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(nextSchoolsCollectionValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasSchoolDetailsValue)
        {
          i = j + 1;
          if (schoolDetailsValue._cachedId == null) {
            break label450;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(schoolDetailsValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasNotableAlumniValue)
        {
          i = j + 1;
          if (notableAlumniValue._cachedId == null) {
            break label463;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(notableAlumniValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasSchoolRankingsValue)
        {
          i = j + 1;
          if (schoolRankingsValue._cachedId == null) {
            break label476;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(schoolRankingsValue._cachedId);
        }
        label177:
        j = i + 1;
        i = j;
        if (hasSchoolFacetsValue)
        {
          i = j + 1;
          if (schoolFacetsValue._cachedId == null) {
            break label489;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(schoolFacetsValue._cachedId);
        }
        label219:
        j = i + 1;
        i = j;
        if (hasFinancialInformationValue)
        {
          i = j + 1;
          if (financialInformationValue._cachedId == null) {
            break label502;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(financialInformationValue._cachedId);
        }
        label261:
        j = i + 1;
        i = j;
        if (hasStudentsAndFacultyValue)
        {
          i = j + 1;
          if (studentsAndFacultyValue._cachedId == null) {
            break label515;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(studentsAndFacultyValue._cachedId);
        }
        label303:
        j = i + 1;
        i = j;
        if (hasAlumniCompaniesCollectionValue)
        {
          i = j + 1;
          if (alumniCompaniesCollectionValue._cachedId == null) {
            break label528;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(alumniCompaniesCollectionValue._cachedId);
        }
        label345:
        j = i + 1;
        i = j;
        if (hasDescriptionValue)
        {
          i = j + 1;
          if (descriptionValue._cachedId == null) {
            break label541;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(descriptionValue._cachedId);
        }
        label387:
        j = i + 1;
        i = j;
        if (hasMiniProfilesCollectionValue)
        {
          i = j + 1;
          if (miniProfilesCollectionValue._cachedId == null) {
            break label554;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniProfilesCollectionValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = nextSchoolsCollectionValue.getSerializedSize() + 7;
        break;
        label450:
        i += schoolDetailsValue.getSerializedSize();
        break label93;
        label463:
        i += notableAlumniValue.getSerializedSize();
        break label135;
        label476:
        i += schoolRankingsValue.getSerializedSize();
        break label177;
        label489:
        i += schoolFacetsValue.getSerializedSize();
        break label219;
        label502:
        i += financialInformationValue.getSerializedSize();
        break label261;
        label515:
        i += studentsAndFacultyValue.getSerializedSize();
        break label303;
        label528:
        i += alumniCompaniesCollectionValue.getSerializedSize();
        break label345;
        label541:
        i += descriptionValue.getSerializedSize();
        break label387;
        label554:
        i += miniProfilesCollectionValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
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
      if (nextSchoolsCollectionValue != null)
      {
        i = nextSchoolsCollectionValue.hashCode();
        if (schoolDetailsValue == null) {
          break label242;
        }
        j = schoolDetailsValue.hashCode();
        if (notableAlumniValue == null) {
          break label247;
        }
        k = notableAlumniValue.hashCode();
        if (schoolRankingsValue == null) {
          break label252;
        }
        m = schoolRankingsValue.hashCode();
        if (schoolFacetsValue == null) {
          break label258;
        }
        n = schoolFacetsValue.hashCode();
        if (financialInformationValue == null) {
          break label264;
        }
        i1 = financialInformationValue.hashCode();
        if (studentsAndFacultyValue == null) {
          break label270;
        }
        i2 = studentsAndFacultyValue.hashCode();
        if (alumniCompaniesCollectionValue == null) {
          break label276;
        }
        i3 = alumniCompaniesCollectionValue.hashCode();
        label140:
        if (descriptionValue == null) {
          break label282;
        }
      }
      label242:
      label247:
      label252:
      label258:
      label264:
      label270:
      label276:
      label282:
      for (int i4 = descriptionValue.hashCode();; i4 = 0)
      {
        if (miniProfilesCollectionValue != null) {
          i5 = miniProfilesCollectionValue.hashCode();
        }
        i = (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i5;
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
        break label140;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Item");
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
      label292:
      label352:
      label412:
      label472:
      label532:
      label592:
      label652:
      label780:
      label805:
      label815:
      label840:
      label850:
      label875:
      label885:
      label910:
      label920:
      label945:
      label955:
      label980:
      label990:
      label1015:
      label1025:
      label1050:
      label1060:
      label1085:
      label1093:
      label1095:
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
          localByteBuffer.putInt(649662592);
          if (hasNextSchoolsCollectionValue)
          {
            localByteBuffer.put((byte)1);
            if (nextSchoolsCollectionValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, nextSchoolsCollectionValue._cachedId);
              nextSchoolsCollectionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSchoolDetailsValue) {
                break label805;
              }
              localByteBuffer.put((byte)1);
              if (schoolDetailsValue._cachedId == null) {
                break label780;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, schoolDetailsValue._cachedId);
              schoolDetailsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasNotableAlumniValue) {
                break label840;
              }
              localByteBuffer.put((byte)1);
              if (notableAlumniValue._cachedId == null) {
                break label815;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, notableAlumniValue._cachedId);
              notableAlumniValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSchoolRankingsValue) {
                break label875;
              }
              localByteBuffer.put((byte)1);
              if (schoolRankingsValue._cachedId == null) {
                break label850;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, schoolRankingsValue._cachedId);
              schoolRankingsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSchoolFacetsValue) {
                break label910;
              }
              localByteBuffer.put((byte)1);
              if (schoolFacetsValue._cachedId == null) {
                break label885;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, schoolFacetsValue._cachedId);
              schoolFacetsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasFinancialInformationValue) {
                break label945;
              }
              localByteBuffer.put((byte)1);
              if (financialInformationValue._cachedId == null) {
                break label920;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, financialInformationValue._cachedId);
              financialInformationValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasStudentsAndFacultyValue) {
                break label980;
              }
              localByteBuffer.put((byte)1);
              if (studentsAndFacultyValue._cachedId == null) {
                break label955;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, studentsAndFacultyValue._cachedId);
              studentsAndFacultyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasAlumniCompaniesCollectionValue) {
                break label1015;
              }
              localByteBuffer.put((byte)1);
              if (alumniCompaniesCollectionValue._cachedId == null) {
                break label990;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, alumniCompaniesCollectionValue._cachedId);
              alumniCompaniesCollectionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasDescriptionValue) {
                break label1050;
              }
              localByteBuffer.put((byte)1);
              if (descriptionValue._cachedId == null) {
                break label1025;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, descriptionValue._cachedId);
              descriptionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMiniProfilesCollectionValue) {
                break label1085;
              }
              localByteBuffer.put((byte)1);
              if (miniProfilesCollectionValue._cachedId == null) {
                break label1060;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniProfilesCollectionValue._cachedId);
              miniProfilesCollectionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label1093;
            }
            if (str != null) {
              break label1095;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            nextSchoolsCollectionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            schoolDetailsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label232;
            localByteBuffer.put((byte)0);
            break label232;
            localByteBuffer.put((byte)1);
            notableAlumniValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label292;
            localByteBuffer.put((byte)0);
            break label292;
            localByteBuffer.put((byte)1);
            schoolRankingsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label352;
            localByteBuffer.put((byte)0);
            break label352;
            localByteBuffer.put((byte)1);
            schoolFacetsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label412;
            localByteBuffer.put((byte)0);
            break label412;
            localByteBuffer.put((byte)1);
            financialInformationValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label472;
            localByteBuffer.put((byte)0);
            break label472;
            localByteBuffer.put((byte)1);
            studentsAndFacultyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label532;
            localByteBuffer.put((byte)0);
            break label532;
            localByteBuffer.put((byte)1);
            alumniCompaniesCollectionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label592;
            localByteBuffer.put((byte)0);
            break label592;
            localByteBuffer.put((byte)1);
            descriptionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label652;
            localByteBuffer.put((byte)0);
            break label652;
            localByteBuffer.put((byte)1);
            miniProfilesCollectionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */