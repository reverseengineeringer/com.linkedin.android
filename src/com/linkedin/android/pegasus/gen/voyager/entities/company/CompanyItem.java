package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniJobsCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompanyCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPersonCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonSchoolCollection;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CompanyItem
  implements FissileDataModel<CompanyItem>, RecordTemplate<CompanyItem>
{
  public static final CompanyItemBuilder BUILDER = CompanyItemBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasItem;
  public final boolean hasItemInfo;
  public final Item item;
  public final ItemInfo itemInfo;
  
  CompanyItem(ItemInfo paramItemInfo, Item paramItem, boolean paramBoolean1, boolean paramBoolean2)
  {
    itemInfo = paramItemInfo;
    item = paramItem;
    hasItemInfo = paramBoolean1;
    hasItem = paramBoolean2;
    _cachedId = null;
  }
  
  public final CompanyItem accept(DataProcessor paramDataProcessor)
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
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItem", "itemInfo");
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
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItem", "item");
    }
    return new CompanyItem((ItemInfo)localObject2, (Item)localObject1, bool1, bool2);
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
      paramObject = (CompanyItem)paramObject;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CompanyItem");
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
        localByteBuffer.putInt(-1590279436);
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
    public static final CompanyItemBuilder.ItemBuilder BUILDER = CompanyItemBuilder.ItemBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final CareerAbout2 careerAbout2Value;
    public final CareerAbout careerAboutValue;
    public final CareerEmployeeQuotes careerEmployeeQuotesValue;
    public final CareerResources careerResourcesValue;
    public final CareerTitles careerTitlesValue;
    public final CompanyDetails companyDetailsValue;
    public final Description descriptionValue;
    public final boolean hasCareerAbout2Value;
    public final boolean hasCareerAboutValue;
    public final boolean hasCareerEmployeeQuotesValue;
    public final boolean hasCareerResourcesValue;
    public final boolean hasCareerTitlesValue;
    public final boolean hasCompanyDetailsValue;
    public final boolean hasDescriptionValue;
    public final boolean hasInCommonCompanyCollectionValue;
    public final boolean hasInCommonPersonCollectionValue;
    public final boolean hasInCommonSchoolCollectionValue;
    public final boolean hasMiniJobsCollectionValue;
    public final boolean hasMiniProfilesCollectionValue;
    public final boolean hasShowcasesValue;
    public final boolean hasSimilarCompaniesValue;
    public final boolean hasUpdateCollectionValue;
    public final InCommonCompanyCollection inCommonCompanyCollectionValue;
    public final InCommonPersonCollection inCommonPersonCollectionValue;
    public final InCommonSchoolCollection inCommonSchoolCollectionValue;
    public final MiniJobsCollection miniJobsCollectionValue;
    public final MiniProfilesCollection miniProfilesCollectionValue;
    public final Showcases showcasesValue;
    public final SimilarCompanies similarCompaniesValue;
    public final UpdateCollection updateCollectionValue;
    
    Item(CompanyDetails paramCompanyDetails, Showcases paramShowcases, SimilarCompanies paramSimilarCompanies, CareerAbout paramCareerAbout, CareerAbout2 paramCareerAbout2, CareerTitles paramCareerTitles, CareerEmployeeQuotes paramCareerEmployeeQuotes, CareerResources paramCareerResources, Description paramDescription, MiniJobsCollection paramMiniJobsCollection, MiniProfilesCollection paramMiniProfilesCollection, UpdateCollection paramUpdateCollection, InCommonCompanyCollection paramInCommonCompanyCollection, InCommonPersonCollection paramInCommonPersonCollection, InCommonSchoolCollection paramInCommonSchoolCollection, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15)
    {
      companyDetailsValue = paramCompanyDetails;
      showcasesValue = paramShowcases;
      similarCompaniesValue = paramSimilarCompanies;
      careerAboutValue = paramCareerAbout;
      careerAbout2Value = paramCareerAbout2;
      careerTitlesValue = paramCareerTitles;
      careerEmployeeQuotesValue = paramCareerEmployeeQuotes;
      careerResourcesValue = paramCareerResources;
      descriptionValue = paramDescription;
      miniJobsCollectionValue = paramMiniJobsCollection;
      miniProfilesCollectionValue = paramMiniProfilesCollection;
      updateCollectionValue = paramUpdateCollection;
      inCommonCompanyCollectionValue = paramInCommonCompanyCollection;
      inCommonPersonCollectionValue = paramInCommonPersonCollection;
      inCommonSchoolCollectionValue = paramInCommonSchoolCollection;
      hasCompanyDetailsValue = paramBoolean1;
      hasShowcasesValue = paramBoolean2;
      hasSimilarCompaniesValue = paramBoolean3;
      hasCareerAboutValue = paramBoolean4;
      hasCareerAbout2Value = paramBoolean5;
      hasCareerTitlesValue = paramBoolean6;
      hasCareerEmployeeQuotesValue = paramBoolean7;
      hasCareerResourcesValue = paramBoolean8;
      hasDescriptionValue = paramBoolean9;
      hasMiniJobsCollectionValue = paramBoolean10;
      hasMiniProfilesCollectionValue = paramBoolean11;
      hasUpdateCollectionValue = paramBoolean12;
      hasInCommonCompanyCollectionValue = paramBoolean13;
      hasInCommonPersonCollectionValue = paramBoolean14;
      hasInCommonSchoolCollectionValue = paramBoolean15;
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
      label458:
      label470:
      Object localObject11;
      boolean bool10;
      label510:
      label522:
      Object localObject12;
      boolean bool11;
      label562:
      label574:
      Object localObject13;
      boolean bool12;
      label614:
      label626:
      Object localObject14;
      boolean bool13;
      label666:
      label678:
      Object localObject15;
      boolean bool14;
      if (hasCompanyDetailsValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.CompanyDetails");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = companyDetailsValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label878;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasShowcasesValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.Showcases");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label887;
          }
          localObject1 = showcasesValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label905;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        localObject4 = null;
        bool3 = false;
        if (hasSimilarCompaniesValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.SimilarCompanies");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label914;
          }
          localObject1 = similarCompaniesValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label932;
          }
          bool3 = true;
          localObject4 = localObject1;
        }
        localObject5 = null;
        bool4 = false;
        if (hasCareerAboutValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.CareerAbout");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label942;
          }
          localObject1 = careerAboutValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label960;
          }
          bool4 = true;
          localObject5 = localObject1;
        }
        localObject6 = null;
        bool5 = false;
        if (hasCareerAbout2Value)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.CareerAbout2");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label970;
          }
          localObject1 = careerAbout2Value.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label988;
          }
          bool5 = true;
          localObject6 = localObject1;
        }
        localObject7 = null;
        bool6 = false;
        if (hasCareerTitlesValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.CareerTitles");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label998;
          }
          localObject1 = careerTitlesValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1016;
          }
          bool6 = true;
          localObject7 = localObject1;
        }
        localObject8 = null;
        bool7 = false;
        if (hasCareerEmployeeQuotesValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.CareerEmployeeQuotes");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1026;
          }
          localObject1 = careerEmployeeQuotesValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1044;
          }
          bool7 = true;
          localObject8 = localObject1;
        }
        localObject9 = null;
        bool8 = false;
        if (hasCareerResourcesValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.CareerResources");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1054;
          }
          localObject1 = careerResourcesValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1072;
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
            break label1082;
          }
          localObject1 = descriptionValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1100;
          }
          bool9 = true;
          localObject10 = localObject1;
        }
        localObject11 = null;
        bool10 = false;
        if (hasMiniJobsCollectionValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.common.MiniJobsCollection");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1110;
          }
          localObject1 = miniJobsCollectionValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1128;
          }
          bool10 = true;
          localObject11 = localObject1;
        }
        localObject12 = null;
        bool11 = false;
        if (hasMiniProfilesCollectionValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.common.MiniProfilesCollection");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1138;
          }
          localObject1 = miniProfilesCollectionValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1156;
          }
          bool11 = true;
          localObject12 = localObject1;
        }
        localObject13 = null;
        bool12 = false;
        if (hasUpdateCollectionValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.common.UpdateCollection");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1166;
          }
          localObject1 = updateCollectionValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1184;
          }
          bool12 = true;
          localObject13 = localObject1;
        }
        localObject14 = null;
        bool13 = false;
        if (hasInCommonCompanyCollectionValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.incommon.InCommonCompanyCollection");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1194;
          }
          localObject1 = inCommonCompanyCollectionValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1212;
          }
          bool13 = true;
          localObject14 = localObject1;
        }
        localObject15 = null;
        bool14 = false;
        if (hasInCommonPersonCollectionValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.incommon.InCommonPersonCollection");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1222;
          }
          localObject1 = inCommonPersonCollectionValue.accept(paramDataProcessor);
          label718:
          if (localObject1 == null) {
            break label1240;
          }
          bool14 = true;
          localObject15 = localObject1;
        }
        label730:
        localObject1 = null;
        bool15 = false;
        if (hasInCommonSchoolCollectionValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.incommon.InCommonSchoolCollection");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1250;
          }
          localObject1 = inCommonSchoolCollectionValue.accept(paramDataProcessor);
          label771:
          if (localObject1 == null) {
            break label1268;
          }
        }
      }
      label878:
      label887:
      label905:
      label914:
      label932:
      label942:
      label960:
      label970:
      label988:
      label998:
      label1016:
      label1026:
      label1044:
      label1054:
      label1072:
      label1082:
      label1100:
      label1110:
      label1128:
      label1138:
      label1156:
      label1166:
      label1184:
      label1194:
      label1212:
      label1222:
      label1240:
      label1250:
      label1268:
      for (boolean bool15 = true;; bool15 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label1274;
        }
        return new Item((CompanyDetails)localObject2, (Showcases)localObject3, (SimilarCompanies)localObject4, (CareerAbout)localObject5, (CareerAbout2)localObject6, (CareerTitles)localObject7, (CareerEmployeeQuotes)localObject8, (CareerResources)localObject9, (Description)localObject10, (MiniJobsCollection)localObject11, (MiniProfilesCollection)localObject12, (UpdateCollection)localObject13, (InCommonCompanyCollection)localObject14, (InCommonPersonCollection)localObject15, (InCommonSchoolCollection)localObject1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15);
        localObject1 = (CompanyDetails)paramDataProcessor.processDataTemplate(companyDetailsValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (Showcases)paramDataProcessor.processDataTemplate(showcasesValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (SimilarCompanies)paramDataProcessor.processDataTemplate(similarCompaniesValue);
        break label146;
        bool3 = false;
        localObject4 = localObject1;
        break label158;
        localObject1 = (CareerAbout)paramDataProcessor.processDataTemplate(careerAboutValue);
        break label198;
        bool4 = false;
        localObject5 = localObject1;
        break label210;
        localObject1 = (CareerAbout2)paramDataProcessor.processDataTemplate(careerAbout2Value);
        break label250;
        bool5 = false;
        localObject6 = localObject1;
        break label262;
        localObject1 = (CareerTitles)paramDataProcessor.processDataTemplate(careerTitlesValue);
        break label302;
        bool6 = false;
        localObject7 = localObject1;
        break label314;
        localObject1 = (CareerEmployeeQuotes)paramDataProcessor.processDataTemplate(careerEmployeeQuotesValue);
        break label354;
        bool7 = false;
        localObject8 = localObject1;
        break label366;
        localObject1 = (CareerResources)paramDataProcessor.processDataTemplate(careerResourcesValue);
        break label406;
        bool8 = false;
        localObject9 = localObject1;
        break label418;
        localObject1 = (Description)paramDataProcessor.processDataTemplate(descriptionValue);
        break label458;
        bool9 = false;
        localObject10 = localObject1;
        break label470;
        localObject1 = (MiniJobsCollection)paramDataProcessor.processDataTemplate(miniJobsCollectionValue);
        break label510;
        bool10 = false;
        localObject11 = localObject1;
        break label522;
        localObject1 = (MiniProfilesCollection)paramDataProcessor.processDataTemplate(miniProfilesCollectionValue);
        break label562;
        bool11 = false;
        localObject12 = localObject1;
        break label574;
        localObject1 = (UpdateCollection)paramDataProcessor.processDataTemplate(updateCollectionValue);
        break label614;
        bool12 = false;
        localObject13 = localObject1;
        break label626;
        localObject1 = (InCommonCompanyCollection)paramDataProcessor.processDataTemplate(inCommonCompanyCollectionValue);
        break label666;
        bool13 = false;
        localObject14 = localObject1;
        break label678;
        localObject1 = (InCommonPersonCollection)paramDataProcessor.processDataTemplate(inCommonPersonCollectionValue);
        break label718;
        bool14 = false;
        localObject15 = localObject1;
        break label730;
        localObject1 = (InCommonSchoolCollection)paramDataProcessor.processDataTemplate(inCommonSchoolCollectionValue);
        break label771;
      }
      label1274:
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
        if (companyDetailsValue != null)
        {
          if (companyDetailsValue.equals(companyDetailsValue)) {}
        }
        else {
          while (companyDetailsValue != null) {
            return false;
          }
        }
        if (showcasesValue != null)
        {
          if (showcasesValue.equals(showcasesValue)) {}
        }
        else {
          while (showcasesValue != null) {
            return false;
          }
        }
        if (similarCompaniesValue != null)
        {
          if (similarCompaniesValue.equals(similarCompaniesValue)) {}
        }
        else {
          while (similarCompaniesValue != null) {
            return false;
          }
        }
        if (careerAboutValue != null)
        {
          if (careerAboutValue.equals(careerAboutValue)) {}
        }
        else {
          while (careerAboutValue != null) {
            return false;
          }
        }
        if (careerAbout2Value != null)
        {
          if (careerAbout2Value.equals(careerAbout2Value)) {}
        }
        else {
          while (careerAbout2Value != null) {
            return false;
          }
        }
        if (careerTitlesValue != null)
        {
          if (careerTitlesValue.equals(careerTitlesValue)) {}
        }
        else {
          while (careerTitlesValue != null) {
            return false;
          }
        }
        if (careerEmployeeQuotesValue != null)
        {
          if (careerEmployeeQuotesValue.equals(careerEmployeeQuotesValue)) {}
        }
        else {
          while (careerEmployeeQuotesValue != null) {
            return false;
          }
        }
        if (careerResourcesValue != null)
        {
          if (careerResourcesValue.equals(careerResourcesValue)) {}
        }
        else {
          while (careerResourcesValue != null) {
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
        if (miniJobsCollectionValue != null)
        {
          if (miniJobsCollectionValue.equals(miniJobsCollectionValue)) {}
        }
        else {
          while (miniJobsCollectionValue != null) {
            return false;
          }
        }
        if (miniProfilesCollectionValue != null)
        {
          if (miniProfilesCollectionValue.equals(miniProfilesCollectionValue)) {}
        }
        else {
          while (miniProfilesCollectionValue != null) {
            return false;
          }
        }
        if (updateCollectionValue != null)
        {
          if (updateCollectionValue.equals(updateCollectionValue)) {}
        }
        else {
          while (updateCollectionValue != null) {
            return false;
          }
        }
        if (inCommonCompanyCollectionValue != null)
        {
          if (inCommonCompanyCollectionValue.equals(inCommonCompanyCollectionValue)) {}
        }
        else {
          while (inCommonCompanyCollectionValue != null) {
            return false;
          }
        }
        if (inCommonPersonCollectionValue != null)
        {
          if (inCommonPersonCollectionValue.equals(inCommonPersonCollectionValue)) {}
        }
        else {
          while (inCommonPersonCollectionValue != null) {
            return false;
          }
        }
        if (inCommonSchoolCollectionValue == null) {
          break;
        }
      } while (inCommonSchoolCollectionValue.equals(inCommonSchoolCollectionValue));
      for (;;)
      {
        return false;
        if (inCommonSchoolCollectionValue == null) {
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
      if (hasCompanyDetailsValue)
      {
        if (companyDetailsValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(companyDetailsValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasShowcasesValue)
        {
          i = j + 1;
          if (showcasesValue._cachedId == null) {
            break label660;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(showcasesValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasSimilarCompaniesValue)
        {
          i = j + 1;
          if (similarCompaniesValue._cachedId == null) {
            break label673;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(similarCompaniesValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasCareerAboutValue)
        {
          i = j + 1;
          if (careerAboutValue._cachedId == null) {
            break label686;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(careerAboutValue._cachedId);
        }
        label177:
        j = i + 1;
        i = j;
        if (hasCareerAbout2Value)
        {
          i = j + 1;
          if (careerAbout2Value._cachedId == null) {
            break label699;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(careerAbout2Value._cachedId);
        }
        label219:
        j = i + 1;
        i = j;
        if (hasCareerTitlesValue)
        {
          i = j + 1;
          if (careerTitlesValue._cachedId == null) {
            break label712;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(careerTitlesValue._cachedId);
        }
        label261:
        j = i + 1;
        i = j;
        if (hasCareerEmployeeQuotesValue)
        {
          i = j + 1;
          if (careerEmployeeQuotesValue._cachedId == null) {
            break label725;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(careerEmployeeQuotesValue._cachedId);
        }
        label303:
        j = i + 1;
        i = j;
        if (hasCareerResourcesValue)
        {
          i = j + 1;
          if (careerResourcesValue._cachedId == null) {
            break label738;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(careerResourcesValue._cachedId);
        }
        label345:
        j = i + 1;
        i = j;
        if (hasDescriptionValue)
        {
          i = j + 1;
          if (descriptionValue._cachedId == null) {
            break label751;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(descriptionValue._cachedId);
        }
        label387:
        j = i + 1;
        i = j;
        if (hasMiniJobsCollectionValue)
        {
          i = j + 1;
          if (miniJobsCollectionValue._cachedId == null) {
            break label764;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniJobsCollectionValue._cachedId);
        }
        label429:
        j = i + 1;
        i = j;
        if (hasMiniProfilesCollectionValue)
        {
          i = j + 1;
          if (miniProfilesCollectionValue._cachedId == null) {
            break label777;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniProfilesCollectionValue._cachedId);
        }
        label471:
        j = i + 1;
        i = j;
        if (hasUpdateCollectionValue)
        {
          i = j + 1;
          if (updateCollectionValue._cachedId == null) {
            break label790;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(updateCollectionValue._cachedId);
        }
        label513:
        j = i + 1;
        i = j;
        if (hasInCommonCompanyCollectionValue)
        {
          i = j + 1;
          if (inCommonCompanyCollectionValue._cachedId == null) {
            break label803;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(inCommonCompanyCollectionValue._cachedId);
        }
        label555:
        j = i + 1;
        i = j;
        if (hasInCommonPersonCollectionValue)
        {
          i = j + 1;
          if (inCommonPersonCollectionValue._cachedId == null) {
            break label816;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(inCommonPersonCollectionValue._cachedId);
        }
        label597:
        j = i + 1;
        i = j;
        if (hasInCommonSchoolCollectionValue)
        {
          i = j + 1;
          if (inCommonSchoolCollectionValue._cachedId == null) {
            break label829;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(inCommonSchoolCollectionValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = companyDetailsValue.getSerializedSize() + 7;
        break;
        label660:
        i += showcasesValue.getSerializedSize();
        break label93;
        label673:
        i += similarCompaniesValue.getSerializedSize();
        break label135;
        label686:
        i += careerAboutValue.getSerializedSize();
        break label177;
        label699:
        i += careerAbout2Value.getSerializedSize();
        break label219;
        label712:
        i += careerTitlesValue.getSerializedSize();
        break label261;
        label725:
        i += careerEmployeeQuotesValue.getSerializedSize();
        break label303;
        label738:
        i += careerResourcesValue.getSerializedSize();
        break label345;
        label751:
        i += descriptionValue.getSerializedSize();
        break label387;
        label764:
        i += miniJobsCollectionValue.getSerializedSize();
        break label429;
        label777:
        i += miniProfilesCollectionValue.getSerializedSize();
        break label471;
        label790:
        i += updateCollectionValue.getSerializedSize();
        break label513;
        label803:
        i += inCommonCompanyCollectionValue.getSerializedSize();
        break label555;
        label816:
        i += inCommonPersonCollectionValue.getSerializedSize();
        break label597;
        label829:
        i += inCommonSchoolCollectionValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int i10 = 0;
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
      label140:
      int i4;
      label156:
      int i5;
      label172:
      int i6;
      label188:
      int i7;
      label204:
      int i8;
      if (companyDetailsValue != null)
      {
        i = companyDetailsValue.hashCode();
        if (showcasesValue == null) {
          break label352;
        }
        j = showcasesValue.hashCode();
        if (similarCompaniesValue == null) {
          break label357;
        }
        k = similarCompaniesValue.hashCode();
        if (careerAboutValue == null) {
          break label362;
        }
        m = careerAboutValue.hashCode();
        if (careerAbout2Value == null) {
          break label368;
        }
        n = careerAbout2Value.hashCode();
        if (careerTitlesValue == null) {
          break label374;
        }
        i1 = careerTitlesValue.hashCode();
        if (careerEmployeeQuotesValue == null) {
          break label380;
        }
        i2 = careerEmployeeQuotesValue.hashCode();
        if (careerResourcesValue == null) {
          break label386;
        }
        i3 = careerResourcesValue.hashCode();
        if (descriptionValue == null) {
          break label392;
        }
        i4 = descriptionValue.hashCode();
        if (miniJobsCollectionValue == null) {
          break label398;
        }
        i5 = miniJobsCollectionValue.hashCode();
        if (miniProfilesCollectionValue == null) {
          break label404;
        }
        i6 = miniProfilesCollectionValue.hashCode();
        if (updateCollectionValue == null) {
          break label410;
        }
        i7 = updateCollectionValue.hashCode();
        if (inCommonCompanyCollectionValue == null) {
          break label416;
        }
        i8 = inCommonCompanyCollectionValue.hashCode();
        label220:
        if (inCommonPersonCollectionValue == null) {
          break label422;
        }
      }
      label352:
      label357:
      label362:
      label368:
      label374:
      label380:
      label386:
      label392:
      label398:
      label404:
      label410:
      label416:
      label422:
      for (int i9 = inCommonPersonCollectionValue.hashCode();; i9 = 0)
      {
        if (inCommonSchoolCollectionValue != null) {
          i10 = inCommonSchoolCollectionValue.hashCode();
        }
        i = (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i10;
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
        i4 = 0;
        break label156;
        i5 = 0;
        break label172;
        i6 = 0;
        break label188;
        i7 = 0;
        break label204;
        i8 = 0;
        break label220;
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
      label712:
      label772:
      label832:
      label892:
      label952:
      label1080:
      label1105:
      label1115:
      label1140:
      label1150:
      label1175:
      label1185:
      label1210:
      label1220:
      label1245:
      label1255:
      label1280:
      label1290:
      label1315:
      label1325:
      label1350:
      label1360:
      label1385:
      label1395:
      label1420:
      label1430:
      label1455:
      label1465:
      label1490:
      label1500:
      label1525:
      label1535:
      label1560:
      label1568:
      label1570:
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
          localByteBuffer.putInt(1208799589);
          if (hasCompanyDetailsValue)
          {
            localByteBuffer.put((byte)1);
            if (companyDetailsValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, companyDetailsValue._cachedId);
              companyDetailsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasShowcasesValue) {
                break label1105;
              }
              localByteBuffer.put((byte)1);
              if (showcasesValue._cachedId == null) {
                break label1080;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, showcasesValue._cachedId);
              showcasesValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSimilarCompaniesValue) {
                break label1140;
              }
              localByteBuffer.put((byte)1);
              if (similarCompaniesValue._cachedId == null) {
                break label1115;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, similarCompaniesValue._cachedId);
              similarCompaniesValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasCareerAboutValue) {
                break label1175;
              }
              localByteBuffer.put((byte)1);
              if (careerAboutValue._cachedId == null) {
                break label1150;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, careerAboutValue._cachedId);
              careerAboutValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasCareerAbout2Value) {
                break label1210;
              }
              localByteBuffer.put((byte)1);
              if (careerAbout2Value._cachedId == null) {
                break label1185;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, careerAbout2Value._cachedId);
              careerAbout2Value.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasCareerTitlesValue) {
                break label1245;
              }
              localByteBuffer.put((byte)1);
              if (careerTitlesValue._cachedId == null) {
                break label1220;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, careerTitlesValue._cachedId);
              careerTitlesValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasCareerEmployeeQuotesValue) {
                break label1280;
              }
              localByteBuffer.put((byte)1);
              if (careerEmployeeQuotesValue._cachedId == null) {
                break label1255;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, careerEmployeeQuotesValue._cachedId);
              careerEmployeeQuotesValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasCareerResourcesValue) {
                break label1315;
              }
              localByteBuffer.put((byte)1);
              if (careerResourcesValue._cachedId == null) {
                break label1290;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, careerResourcesValue._cachedId);
              careerResourcesValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasDescriptionValue) {
                break label1350;
              }
              localByteBuffer.put((byte)1);
              if (descriptionValue._cachedId == null) {
                break label1325;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, descriptionValue._cachedId);
              descriptionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMiniJobsCollectionValue) {
                break label1385;
              }
              localByteBuffer.put((byte)1);
              if (miniJobsCollectionValue._cachedId == null) {
                break label1360;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniJobsCollectionValue._cachedId);
              miniJobsCollectionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMiniProfilesCollectionValue) {
                break label1420;
              }
              localByteBuffer.put((byte)1);
              if (miniProfilesCollectionValue._cachedId == null) {
                break label1395;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, miniProfilesCollectionValue._cachedId);
              miniProfilesCollectionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasUpdateCollectionValue) {
                break label1455;
              }
              localByteBuffer.put((byte)1);
              if (updateCollectionValue._cachedId == null) {
                break label1430;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, updateCollectionValue._cachedId);
              updateCollectionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasInCommonCompanyCollectionValue) {
                break label1490;
              }
              localByteBuffer.put((byte)1);
              if (inCommonCompanyCollectionValue._cachedId == null) {
                break label1465;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, inCommonCompanyCollectionValue._cachedId);
              inCommonCompanyCollectionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasInCommonPersonCollectionValue) {
                break label1525;
              }
              localByteBuffer.put((byte)1);
              if (inCommonPersonCollectionValue._cachedId == null) {
                break label1500;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, inCommonPersonCollectionValue._cachedId);
              inCommonPersonCollectionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasInCommonSchoolCollectionValue) {
                break label1560;
              }
              localByteBuffer.put((byte)1);
              if (inCommonSchoolCollectionValue._cachedId == null) {
                break label1535;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, inCommonSchoolCollectionValue._cachedId);
              inCommonSchoolCollectionValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label1568;
            }
            if (str != null) {
              break label1570;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            companyDetailsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            showcasesValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label232;
            localByteBuffer.put((byte)0);
            break label232;
            localByteBuffer.put((byte)1);
            similarCompaniesValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label292;
            localByteBuffer.put((byte)0);
            break label292;
            localByteBuffer.put((byte)1);
            careerAboutValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label352;
            localByteBuffer.put((byte)0);
            break label352;
            localByteBuffer.put((byte)1);
            careerAbout2Value.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label412;
            localByteBuffer.put((byte)0);
            break label412;
            localByteBuffer.put((byte)1);
            careerTitlesValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label472;
            localByteBuffer.put((byte)0);
            break label472;
            localByteBuffer.put((byte)1);
            careerEmployeeQuotesValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label532;
            localByteBuffer.put((byte)0);
            break label532;
            localByteBuffer.put((byte)1);
            careerResourcesValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label592;
            localByteBuffer.put((byte)0);
            break label592;
            localByteBuffer.put((byte)1);
            descriptionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label652;
            localByteBuffer.put((byte)0);
            break label652;
            localByteBuffer.put((byte)1);
            miniJobsCollectionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label712;
            localByteBuffer.put((byte)0);
            break label712;
            localByteBuffer.put((byte)1);
            miniProfilesCollectionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label772;
            localByteBuffer.put((byte)0);
            break label772;
            localByteBuffer.put((byte)1);
            updateCollectionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label832;
            localByteBuffer.put((byte)0);
            break label832;
            localByteBuffer.put((byte)1);
            inCommonCompanyCollectionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label892;
            localByteBuffer.put((byte)0);
            break label892;
            localByteBuffer.put((byte)1);
            inCommonPersonCollectionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label952;
            localByteBuffer.put((byte)0);
            break label952;
            localByteBuffer.put((byte)1);
            inCommonSchoolCollectionValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */