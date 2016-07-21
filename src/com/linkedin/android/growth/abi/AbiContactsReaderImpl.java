package com.linkedin.android.growth.abi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.RawContactsEntity;
import android.text.TextUtils;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.IM.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.Address.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.Email.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.PhoneNumber.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.Site.Builder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public final class AbiContactsReaderImpl
  implements AbiContactsReader
{
  static final String[] CONTACTS_ENTITY_PROJECTION = { "_id", "contact_last_updated_timestamp" };
  static final String[] CONTACTS_ENTITY_PROJECTION_LOWER_API_SUPPORT = { "_id" };
  private static final Uri CONTACTS_URI = ContactsContract.Contacts.CONTENT_URI;
  private static final String[] RAW_CONTACTS_ENTITY_PROJECTION = { "contact_id", "data_id", "mimetype", "is_primary", "is_super_primary", "data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9", "data10" };
  private static final Uri RAW_CONTACTS_URI = ContactsContract.RawContactsEntity.CONTENT_URI;
  private AbiContactsCursorParser abiContactsCursorParser;
  private ContentResolver contentResolver;
  private FlagshipSharedPreferences flagshipSharedPreferences;
  
  @Inject
  public AbiContactsReaderImpl(Context paramContext, FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    contentResolver = paramContext.getContentResolver();
    flagshipSharedPreferences = paramFlagshipSharedPreferences;
    abiContactsCursorParser = new AbiContactsCursorParser();
  }
  
  private static String[] buildRawContactsQuerySelectionArgs(List<Long> paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfString[i] = String.valueOf(paramList.get(i));
      i += 1;
    }
    return arrayOfString;
  }
  
  private Cursor query$5eb44419(Uri paramUri, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    try
    {
      paramUri = contentResolver.query(paramUri, paramArrayOfString1, paramString, paramArrayOfString2, null);
      return paramUri;
    }
    catch (SQLException paramUri)
    {
      Log.e("Got exception querying SqlLite DB for contacts", paramUri);
    }
    return null;
  }
  
  private List<RawContact> readContactsFromCursor(Cursor paramCursor)
  {
    List localList3 = Collections.emptyList();
    if (paramCursor == null) {
      return localList3;
    }
    List localList1 = localList3;
    for (;;)
    {
      AbiContactsCursorParser localAbiContactsCursorParser;
      Long localLong;
      int i;
      Object localObject8;
      String str2;
      try
      {
        localAbiContactsCursorParser = abiContactsCursorParser;
        if (paramCursor == null) {
          break label2364;
        }
      }
      catch (SecurityException localSecurityException)
      {
        String str1;
        Log.e("Security exception when querying for contacts in readRawContactsFromRawContactsCursor()", localSecurityException);
        CrashReporter.reportNonFatal(localSecurityException);
        localObject2 = localList1;
        if (paramCursor == null) {
          continue;
        }
        paramCursor.close();
        localObject2 = localList1;
        return (List<RawContact>)localObject2;
        i = 0;
        continue;
        localList1 = localList3;
        if (!((String)localObject2).equals("vnd.android.cursor.item/name")) {
          break label2450;
        }
        i = 0;
        break label2450;
        localList1 = localList3;
        if (!((String)localObject2).equals("vnd.android.cursor.item/organization")) {
          break label2450;
        }
        i = 1;
        break label2450;
        localList1 = localList3;
        if (!((String)localObject2).equals("vnd.android.cursor.item/email_v2")) {
          break label2450;
        }
        i = 2;
        break label2450;
        localList1 = localList3;
        if (!((String)localObject2).equals("vnd.android.cursor.item/phone_v2")) {
          break label2450;
        }
        i = 3;
        break label2450;
        localList1 = localList3;
        if (!((String)localObject2).equals("vnd.android.cursor.item/im")) {
          break label2450;
        }
        i = 4;
        break label2450;
        localList1 = localList3;
        if (!((String)localObject2).equals("vnd.android.cursor.item/postal-address_v2")) {
          break label2450;
        }
        i = 5;
        break label2450;
        localList1 = localList3;
        if (!((String)localObject2).equals("vnd.android.cursor.item/website")) {
          break label2450;
        }
        i = 6;
        break label2450;
        localList1 = localList3;
        if (!((String)localObject2).equals("vnd.android.cursor.item/note")) {
          break label2450;
        }
        i = 7;
        break label2450;
        localList1 = localList3;
        localObject2 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data4");
        if (localObject2 == null) {
          continue;
        }
        localList1 = localList3;
        titleMap.put(localLong, localObject2);
        continue;
      }
      finally
      {
        if (paramCursor == null) {
          continue;
        }
        paramCursor.close();
      }
      localList1 = localList3;
      if (paramCursor.moveToNext())
      {
        localList1 = localList3;
        if (paramCursor.isNull(1)) {
          continue;
        }
        localList1 = localList3;
        localLong = Long.valueOf(paramCursor.getLong(paramCursor.getColumnIndex("contact_id")));
        localList1 = localList3;
        str1 = paramCursor.getString(paramCursor.getColumnIndex("mimetype"));
        localList1 = localList3;
        if (isNeedFilterByContactIds)
        {
          localList1 = localList3;
          if (contactIdsToBeIncluded != null)
          {
            localList1 = localList3;
            if (!contactIdsToBeIncluded.contains(localLong))
            {
              i = 1;
              if (i != 0) {
                continue;
              }
              localList1 = localList3;
              contactIdSet.add(localLong);
              if (str1 == null) {
                continue;
              }
              i = -1;
              localList1 = localList3;
            }
          }
        }
      }
      Object localObject9;
      switch (str1.hashCode())
      {
      case -1079224304: 
        localList1 = localList3;
        str1 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data1");
        localList1 = localList3;
        localObject8 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data2");
        localList1 = localList3;
        localObject9 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data3");
        localList1 = localList3;
        str2 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data5");
        if (str1 != null)
        {
          localList1 = localList3;
          fullNameMap.put(localLong, str1);
        }
        if (localObject8 != null)
        {
          localList1 = localList3;
          firstNameMap.put(localLong, localObject8);
        }
        if (localObject9 != null)
        {
          localList1 = localList3;
          lastNameMap.put(localLong, localObject9);
        }
        if (str2 != null)
        {
          localList1 = localList3;
          middleNameMap.put(localLong, str2);
        }
        break;
      case 689862072: 
      case -1569536764: 
      case 684173810: 
      case 950831081: 
      case -601229436: 
      case 456415478: 
      case -1079210633: 
        List localList2 = localList3;
        Object localObject2 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data1");
        localList2 = localList3;
        boolean bool;
        if (paramCursor.getInt(paramCursor.getColumnIndex("is_super_primary")) > 0)
        {
          bool = true;
          localList2 = localList3;
          i = paramCursor.getInt(paramCursor.getColumnIndex("data2"));
          localList2 = localList3;
          localObject8 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data3");
          localList2 = localList3;
          localObject9 = AbiContactsCursorParser.mapTypeIntToString(emailTypeMap, i, (String)localObject8);
          localList2 = localList3;
        }
        for (;;)
        {
          try
          {
            localObject8 = new Email.Builder();
            if (localObject2 != null) {
              continue;
            }
            localList2 = localList3;
            hasEmailAddress = false;
            localList2 = localList3;
            emailAddress = null;
            if (localObject9 != null) {
              continue;
            }
            localList2 = localList3;
            hasType = false;
            localList2 = localList3;
            type = null;
          }
          catch (BuilderException localBuilderException1)
          {
            localList2 = localList3;
            Util.safeThrow(new IllegalArgumentException("Validation failed", localBuilderException1));
            localObject3 = null;
            continue;
            localList2 = localList3;
            hasType = true;
            localList2 = localList3;
            type = ((String)localObject9);
            continue;
            localList2 = localList3;
            hasPrimary = true;
            localList2 = localList3;
            primary = ((Boolean)localObject3).booleanValue();
            continue;
          }
          localList2 = localList3;
          localObject2 = Boolean.valueOf(bool);
          if (localObject2 != null)
          {
            localList2 = localList3;
            if (((Boolean)localObject2).booleanValue()) {
              continue;
            }
          }
          localList2 = localList3;
          hasPrimary = false;
          localList2 = localList3;
          primary = false;
          localList2 = localList3;
          localObject2 = ((Email.Builder)localObject8).build(RecordTemplate.Flavor.RECORD);
          localList2 = localList3;
          AbiContactsCursorParser.addElementListToMap(localLong, localObject2, emailMap);
          break;
          bool = false;
          break label683;
          localList2 = localList3;
          hasEmailAddress = true;
          localList2 = localList3;
          emailAddress = ((String)localObject2);
        }
        localList2 = localList3;
        Object localObject3 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data1");
        localList2 = localList3;
        if (paramCursor.getInt(paramCursor.getColumnIndex("is_super_primary")) > 0)
        {
          bool = true;
          localList2 = localList3;
          i = paramCursor.getInt(paramCursor.getColumnIndex("data2"));
          localList2 = localList3;
          localObject8 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data3");
          localList2 = localList3;
          localObject8 = AbiContactsCursorParser.mapTypeIntToString(phoneTypeMap, i, (String)localObject8);
          localList2 = localList3;
        }
        for (;;)
        {
          try
          {
            localObject9 = new PhoneNumber.Builder();
            if (localObject3 != null) {
              continue;
            }
            localList2 = localList3;
            hasNumber = false;
            localList2 = localList3;
            number = null;
            localList2 = localList3;
            localObject3 = Boolean.valueOf(bool);
            if (localObject3 != null)
            {
              localList2 = localList3;
              if (((Boolean)localObject3).booleanValue()) {
                continue;
              }
            }
            localList2 = localList3;
            hasPrimary = false;
            localList2 = localList3;
            primary = false;
          }
          catch (BuilderException localBuilderException2)
          {
            localList2 = localList3;
            Util.safeThrow(new IllegalArgumentException("Validation failed", localBuilderException2));
            localObject4 = null;
            continue;
            localList2 = localList3;
            hasPrimary = true;
            localList2 = localList3;
            primary = ((Boolean)localObject4).booleanValue();
            continue;
            localList2 = localList3;
            hasType = true;
            localList2 = localList3;
            type = ((String)localObject8);
            continue;
          }
          if (localObject8 != null) {
            continue;
          }
          localList2 = localList3;
          hasType = false;
          localList2 = localList3;
          type = null;
          localList2 = localList3;
          localObject3 = ((PhoneNumber.Builder)localObject9).build(RecordTemplate.Flavor.RECORD);
          localList2 = localList3;
          AbiContactsCursorParser.addElementListToMap(localLong, localObject3, phoneNumberMap);
          break;
          bool = false;
          break label1016;
          localList2 = localList3;
          hasNumber = true;
          localList2 = localList3;
          number = ((String)localObject3);
        }
        localList2 = localList3;
        Object localObject4 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data1");
        localList2 = localList3;
        i = paramCursor.getInt(paramCursor.getColumnIndex("data5"));
        localList2 = localList3;
        localObject8 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data6");
        localList2 = localList3;
        localObject8 = AbiContactsCursorParser.mapTypeIntToString(iMTypeMap, i, (String)localObject8);
        localList2 = localList3;
        for (;;)
        {
          try
          {
            localObject9 = new IM.Builder();
            if (localObject4 != null) {
              continue;
            }
            localList2 = localList3;
            hasId = false;
            localList2 = localList3;
            id = null;
            if (localObject8 != null) {
              continue;
            }
            localList2 = localList3;
            hasProvider = false;
            localList2 = localList3;
            provider = null;
          }
          catch (BuilderException localBuilderException3)
          {
            localList2 = localList3;
            Util.safeThrow(new IllegalArgumentException("Validation failed", localBuilderException3));
            localObject5 = null;
            continue;
            localList2 = localList3;
            hasProvider = true;
            localList2 = localList3;
            provider = ((String)localObject8);
            continue;
          }
          localList2 = localList3;
          localObject4 = ((IM.Builder)localObject9).build(RecordTemplate.Flavor.RECORD);
          localList2 = localList3;
          AbiContactsCursorParser.addElementListToMap(localLong, localObject4, imMap);
          break;
          localList2 = localList3;
          hasId = true;
          localList2 = localList3;
          id = ((String)localObject4);
        }
        localList2 = localList3;
        i = paramCursor.getInt(paramCursor.getColumnIndex("data2"));
        localList2 = localList3;
        Object localObject5 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data3");
        localList2 = localList3;
        localObject8 = AbiContactsCursorParser.mapTypeIntToString(addressTypeMap, i, (String)localObject5);
        localList2 = localList3;
        localObject9 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data1");
        localList2 = localList3;
        str2 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data7");
        localList2 = localList3;
        String str3 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data8");
        localList2 = localList3;
        String str4 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data9");
        localList2 = localList3;
        String str5 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data10");
        localList2 = localList3;
        for (;;)
        {
          try
          {
            localObject5 = new Address.Builder();
            if (localObject8 != null) {
              continue;
            }
            localList2 = localList3;
            hasType = false;
            localList2 = localList3;
            type = null;
            if (localObject9 != null) {
              continue;
            }
            localList2 = localList3;
            hasRawAddress = false;
            localList2 = localList3;
            rawAddress = null;
          }
          catch (BuilderException localBuilderException4)
          {
            localList2 = localList3;
            Util.safeThrow(new IllegalArgumentException("Validation failed", localBuilderException4));
            localObject6 = null;
            continue;
            localList2 = localList3;
            hasRawAddress = true;
            localList2 = localList3;
            rawAddress = ((String)localObject9);
            continue;
            localList2 = localList3;
            hasCity = true;
            localList2 = localList3;
            city = str2;
            continue;
            localList2 = localList3;
            hasState = true;
            localList2 = localList3;
            state = str3;
            continue;
            localList2 = localList3;
            hasPostalCode = true;
            localList2 = localList3;
            postalCode = str4;
            continue;
            localList2 = localList3;
            hasCountry = true;
            localList2 = localList3;
            country = str5;
            continue;
            localList2 = localList3;
            hasPrimary = true;
            localList2 = localList3;
            primary = ((Boolean)localObject8).booleanValue();
            continue;
          }
          if (str2 != null) {
            continue;
          }
          localList2 = localList3;
          hasCity = false;
          localList2 = localList3;
          city = null;
          if (str3 != null) {
            continue;
          }
          localList2 = localList3;
          hasState = false;
          localList2 = localList3;
          state = null;
          if (str4 != null) {
            continue;
          }
          localList2 = localList3;
          hasPostalCode = false;
          localList2 = localList3;
          postalCode = null;
          if (str5 != null) {
            continue;
          }
          localList2 = localList3;
          hasCountry = false;
          localList2 = localList3;
          country = null;
          localList2 = localList3;
          localObject8 = Boolean.valueOf(false);
          if (localObject8 != null)
          {
            localList2 = localList3;
            if (((Boolean)localObject8).booleanValue()) {
              continue;
            }
          }
          localList2 = localList3;
          hasPrimary = false;
          localList2 = localList3;
          primary = false;
          localList2 = localList3;
          localObject5 = ((Address.Builder)localObject5).build(RecordTemplate.Flavor.RECORD);
          localList2 = localList3;
          AbiContactsCursorParser.addElementListToMap(localLong, localObject5, addressMap);
          break;
          localList2 = localList3;
          hasType = true;
          localList2 = localList3;
          type = ((String)localObject8);
        }
        localList2 = localList3;
        Object localObject6 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data1");
        localList2 = localList3;
        i = paramCursor.getInt(paramCursor.getColumnIndex("data2"));
        localList2 = localList3;
        localObject8 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data3");
        localList2 = localList3;
        localObject8 = AbiContactsCursorParser.mapTypeIntToString(siteTypeMap, i, (String)localObject8);
        localList2 = localList3;
        for (;;)
        {
          try
          {
            localObject9 = new Site.Builder();
            if (localObject6 != null) {
              continue;
            }
            localList2 = localList3;
            hasUrl = false;
            localList2 = localList3;
            url = null;
            if (localObject8 != null) {
              continue;
            }
            localList2 = localList3;
            hasSiteType = false;
            localList2 = localList3;
            siteType = null;
          }
          catch (BuilderException localBuilderException5)
          {
            localList2 = localList3;
            Util.safeThrow(new IllegalArgumentException("Validation failed", localBuilderException5));
            localObject7 = null;
            continue;
            localList2 = localList3;
            hasSiteType = true;
            localList2 = localList3;
            siteType = ((String)localObject8);
            continue;
          }
          localList2 = localList3;
          localObject6 = ((Site.Builder)localObject9).build(RecordTemplate.Flavor.RECORD);
          localList2 = localList3;
          AbiContactsCursorParser.addElementListToMap(localLong, localObject6, siteMap);
          break;
          localList2 = localList3;
          hasUrl = true;
          localList2 = localList3;
          url = ((String)localObject6);
        }
        localList2 = localList3;
        Object localObject7 = AbiContactsCursorParser.getStringFromCursor(paramCursor, "data1");
        if (localObject7 != null)
        {
          localList2 = localList3;
          notesMap.put(localLong, localObject7);
          continue;
          localList2 = localList3;
          localList3 = localAbiContactsCursorParser.generateRawContactsList();
          localList2 = localList3;
          long l = Math.max(abiContactsCursorParser.maxContactIdRead, flagshipSharedPreferences.getAbiLastReadMaxContactId());
          localList2 = localList3;
          flagshipSharedPreferences.getPreferences().edit().putLong("abi_last_read_max_contact_id", l).apply();
          localObject7 = localList3;
          if (paramCursor != null)
          {
            paramCursor.close();
            localObject7 = localList3;
          }
        }
        break;
      default: 
        label683:
        label1016:
        label2364:
        label2450:
        switch (i)
        {
        }
        break;
      }
    }
  }
  
  public final List<RawContact> readContactsFull()
  {
    return readContactsFromCursor(query$5eb44419(RAW_CONTACTS_URI, RAW_CONTACTS_ENTITY_PROJECTION, null, null));
  }
  
  public final List<RawContact> readContactsIncrementally()
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    for (Cursor localCursor = query$5eb44419(CONTACTS_URI, CONTACTS_ENTITY_PROJECTION, "contact_last_updated_timestamp > ?", new String[] { Long.toString(flagshipSharedPreferences.getPreferences().getLong("abi_last_sync_timestamp", 0L)) }); localCursor == null; localCursor = query$5eb44419(CONTACTS_URI, CONTACTS_ENTITY_PROJECTION_LOWER_API_SUPPORT, "_id > ?", new String[] { Long.toString(flagshipSharedPreferences.getPreferences().getLong("abi_last_uploaded_max_contact_id", 0L)) })) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    if (localCursor != null) {
      while (localCursor.moveToNext()) {
        localArrayList.add(Long.valueOf(localCursor.getLong(localCursor.getColumnIndex("_id"))));
      }
    }
    localCursor.close();
    if (CollectionUtils.isEmpty(localArrayList)) {
      return Collections.emptyList();
    }
    if (localArrayList.size() < 100) {}
    for (localCursor = query$5eb44419(RAW_CONTACTS_URI, RAW_CONTACTS_ENTITY_PROJECTION, "contact_id IN (" + TextUtils.join(",", Collections.nCopies(localArrayList.size(), "?")) + ")", buildRawContactsQuerySelectionArgs(localArrayList));; localCursor = query$5eb44419(RAW_CONTACTS_URI, RAW_CONTACTS_ENTITY_PROJECTION, null, null))
    {
      return readContactsFromCursor(localCursor);
      abiContactsCursorParser.isNeedFilterByContactIds = true;
      abiContactsCursorParser.contactIdsToBeIncluded = new HashSet(localArrayList);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiContactsReaderImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */