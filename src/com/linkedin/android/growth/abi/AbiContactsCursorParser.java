package com.linkedin.android.growth.abi;

import android.database.Cursor;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.IM;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.Address;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.Email;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.PhoneNumber;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.Site;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AbiContactsCursorParser
{
  Map<Long, List<Address>> addressMap = new ArrayMap();
  Map<Integer, String> addressTypeMap = new ArrayMap();
  Set<Long> contactIdSet = new HashSet();
  Set<Long> contactIdsToBeIncluded;
  Map<Long, List<Email>> emailMap = new ArrayMap();
  Map<Integer, String> emailTypeMap = new ArrayMap();
  Map<Long, String> firstNameMap = new ArrayMap();
  Map<Long, String> fullNameMap = new ArrayMap();
  Map<Integer, String> iMTypeMap = new ArrayMap();
  Map<Long, List<IM>> imMap = new ArrayMap();
  boolean isNeedFilterByContactIds;
  Map<Long, String> lastNameMap = new ArrayMap();
  long maxContactIdRead;
  Map<Long, String> middleNameMap = new ArrayMap();
  Map<Long, String> notesMap = new ArrayMap();
  Map<Long, List<PhoneNumber>> phoneNumberMap = new ArrayMap();
  Map<Integer, String> phoneTypeMap = new ArrayMap();
  Map<Long, List<Site>> siteMap = new ArrayMap();
  Map<Integer, String> siteTypeMap = new ArrayMap();
  Map<Long, String> titleMap = new ArrayMap();
  
  public AbiContactsCursorParser()
  {
    phoneTypeMap.put(Integer.valueOf(1), "HOME");
    phoneTypeMap.put(Integer.valueOf(2), "MOBILE");
    phoneTypeMap.put(Integer.valueOf(3), "WORK");
    phoneTypeMap.put(Integer.valueOf(4), "FAX_WORK");
    phoneTypeMap.put(Integer.valueOf(5), "FAX_HOME");
    phoneTypeMap.put(Integer.valueOf(6), "PAGER");
    phoneTypeMap.put(Integer.valueOf(7), "OTHER");
    phoneTypeMap.put(Integer.valueOf(8), "CALLBACK");
    phoneTypeMap.put(Integer.valueOf(9), "CAR");
    phoneTypeMap.put(Integer.valueOf(10), "COMPANY_MAIN");
    phoneTypeMap.put(Integer.valueOf(11), "ISDN");
    phoneTypeMap.put(Integer.valueOf(12), "MAIN");
    phoneTypeMap.put(Integer.valueOf(13), "OTHER_FAX");
    phoneTypeMap.put(Integer.valueOf(14), "RADIO");
    phoneTypeMap.put(Integer.valueOf(15), "TELEX");
    phoneTypeMap.put(Integer.valueOf(16), "TTY_TDD");
    phoneTypeMap.put(Integer.valueOf(17), "WORK_MOBILE");
    phoneTypeMap.put(Integer.valueOf(18), "WORK_PAGER");
    phoneTypeMap.put(Integer.valueOf(19), "ASSISTANT");
    phoneTypeMap.put(Integer.valueOf(20), "MMS");
    phoneTypeMap.put(Integer.valueOf(0), "CUSTOM");
    emailTypeMap.put(Integer.valueOf(1), "HOME");
    emailTypeMap.put(Integer.valueOf(2), "WORK");
    emailTypeMap.put(Integer.valueOf(4), "MOBILE");
    emailTypeMap.put(Integer.valueOf(3), "OTHER");
    emailTypeMap.put(Integer.valueOf(0), "CUSTOM");
    iMTypeMap.put(Integer.valueOf(0), "AIM");
    iMTypeMap.put(Integer.valueOf(1), "MSN");
    iMTypeMap.put(Integer.valueOf(2), "YAHOO");
    iMTypeMap.put(Integer.valueOf(3), "SKYPE");
    iMTypeMap.put(Integer.valueOf(4), "QQ");
    iMTypeMap.put(Integer.valueOf(5), "GOOGLE_TALK");
    iMTypeMap.put(Integer.valueOf(6), "ICQ");
    iMTypeMap.put(Integer.valueOf(7), "JABBER");
    iMTypeMap.put(Integer.valueOf(8), "NETMEETING");
    iMTypeMap.put(Integer.valueOf(-1), "CUSTOM");
    addressTypeMap.put(Integer.valueOf(1), "HOME");
    addressTypeMap.put(Integer.valueOf(2), "WORK");
    addressTypeMap.put(Integer.valueOf(3), "OTHER");
    addressTypeMap.put(Integer.valueOf(0), "CUSTOM");
    siteTypeMap.put(Integer.valueOf(1), "HOMEPAGE");
    siteTypeMap.put(Integer.valueOf(2), "BLOG");
    siteTypeMap.put(Integer.valueOf(3), "PROFILE");
    siteTypeMap.put(Integer.valueOf(4), "HOME");
    siteTypeMap.put(Integer.valueOf(5), "WORK");
    siteTypeMap.put(Integer.valueOf(6), "FTP");
    siteTypeMap.put(Integer.valueOf(7), "OTHER");
    siteTypeMap.put(Integer.valueOf(0), "CUSTOM");
    isNeedFilterByContactIds = false;
  }
  
  static <KEY, OBJECT> void addElementListToMap(KEY paramKEY, OBJECT paramOBJECT, Map<KEY, List<OBJECT>> paramMap)
  {
    ArrayList localArrayList;
    if (paramOBJECT != null)
    {
      if (paramMap.get(paramKEY) != null) {
        break label42;
      }
      localArrayList = new ArrayList();
      paramMap.put(paramKEY, localArrayList);
    }
    label42:
    for (paramKEY = localArrayList;; paramKEY = (List)paramMap.get(paramKEY))
    {
      paramKEY.add(paramOBJECT);
      return;
    }
  }
  
  static String getStringFromCursor(Cursor paramCursor, String paramString)
  {
    return paramCursor.getString(paramCursor.getColumnIndex(paramString));
  }
  
  static String mapTypeIntToString(Map<Integer, String> paramMap, int paramInt, String paramString)
  {
    String str = (String)paramMap.get(Integer.valueOf(paramInt));
    if (str == null) {
      paramMap = "NONE";
    }
    do
    {
      return paramMap;
      paramMap = str;
    } while (!str.equals("CUSTOM"));
    if (paramString == null) {
      return "OTHER";
    }
    return paramString;
  }
  
  private static <OBJECT> List<OBJECT> toEmptyListIfNull(List<OBJECT> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = Collections.emptyList();
    }
    return (List<OBJECT>)localObject;
  }
  
  final List<RawContact> generateRawContactsList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = contactIdSet.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = (Long)localIterator.next();
      maxContactIdRead = Math.max(maxContactIdRead, ((Long)localObject1).longValue());
      List localList1 = (List)addressMap.get(localObject1);
      List localList4 = (List)emailMap.get(localObject1);
      List localList3 = (List)phoneNumberMap.get(localObject1);
      List localList2 = (List)imMap.get(localObject1);
      Object localObject2 = (List)siteMap.get(localObject1);
      String str1 = (String)fullNameMap.get(localObject1);
      String str2 = (String)firstNameMap.get(localObject1);
      String str3 = (String)lastNameMap.get(localObject1);
      String str4 = (String)middleNameMap.get(localObject1);
      String str5 = (String)titleMap.get(localObject1);
      localObject1 = (String)notesMap.get(localObject1);
      for (;;)
      {
        RawContact.Builder localBuilder;
        try
        {
          localBuilder = new RawContact.Builder();
          if (str1 != null) {
            break label588;
          }
          hasFullName = false;
          fullName = null;
          if (str2 != null) {
            break label604;
          }
          hasFirstName = false;
          firstName = null;
          if (str3 != null) {
            break label620;
          }
          hasLastName = false;
          lastName = null;
          if (str4 != null) {
            break label636;
          }
          hasMiddleName = false;
          middleName = null;
          if (str5 != null) {
            break label652;
          }
          hasTitle = false;
          title = null;
          localList4 = toEmptyListIfNull(localList4);
          if ((localList4 != null) && (!localList4.equals(Collections.emptyList()))) {
            break label668;
          }
          hasEmails = false;
          emails = Collections.emptyList();
          localList3 = toEmptyListIfNull(localList3);
          if ((localList3 != null) && (!localList3.equals(Collections.emptyList()))) {
            break label684;
          }
          hasPhoneNumbers = false;
          phoneNumbers = Collections.emptyList();
          localList2 = toEmptyListIfNull(localList2);
          if ((localList2 != null) && (!localList2.equals(Collections.emptyList()))) {
            break label700;
          }
          hasInstantMessageHandles = false;
          instantMessageHandles = Collections.emptyList();
          localList1 = toEmptyListIfNull(localList1);
          if ((localList1 != null) && (!localList1.equals(Collections.emptyList()))) {
            break label716;
          }
          hasAddresses = false;
          addresses = Collections.emptyList();
          localObject2 = toEmptyListIfNull((List)localObject2);
          if ((localObject2 != null) && (!((List)localObject2).equals(Collections.emptyList()))) {
            break label732;
          }
          hasSites = false;
          sites = Collections.emptyList();
          localObject2 = Boolean.valueOf(false);
          if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
            break label748;
          }
          hasBookmarked = false;
          bookmarked = false;
          if (localObject1 != null) {
            break label767;
          }
          hasNotes = false;
          notes = null;
          localArrayList.add(localBuilder.build(RecordTemplate.Flavor.RECORD));
        }
        catch (BuilderException localBuilderException)
        {
          Util.safeThrow(new IllegalArgumentException("Validation failed", localBuilderException));
        }
        break;
        label588:
        hasFullName = true;
        fullName = str1;
        continue;
        label604:
        hasFirstName = true;
        firstName = str2;
        continue;
        label620:
        hasLastName = true;
        lastName = str3;
        continue;
        label636:
        hasMiddleName = true;
        middleName = str4;
        continue;
        label652:
        hasTitle = true;
        title = str5;
        continue;
        label668:
        hasEmails = true;
        emails = localList4;
        continue;
        label684:
        hasPhoneNumbers = true;
        phoneNumbers = localList3;
        continue;
        label700:
        hasInstantMessageHandles = true;
        instantMessageHandles = localList2;
        continue;
        label716:
        hasAddresses = true;
        addresses = localList1;
        continue;
        label732:
        hasSites = true;
        sites = ((List)localObject2);
        continue;
        label748:
        hasBookmarked = true;
        bookmarked = ((Boolean)localObject2).booleanValue();
        continue;
        label767:
        hasNotes = true;
        notes = localBuilderException;
      }
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiContactsCursorParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */