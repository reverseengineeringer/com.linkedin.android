package com.linkedin.android.growth.calendar.sync;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Instances;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.growth.calendar.CalendarUploadReceiver;
import com.linkedin.android.infra.app.PermissionRequester;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.CalendarTaskUtil;
import com.linkedin.android.infra.shared.CalendarTaskUtil.1;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.actionresponse.BooleanActionResponse;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarEventAttendee;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarEventAttendeeStatus;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarEventAvailability;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarSource;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarSourceRequest;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent.Builder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CalendarSyncManager
{
  private static final String[] ATTENDEE_PROJECTION = { "attendeeName", "attendeeEmail", "attendeeStatus", "event_id" };
  private static final String[] CALENDAR_QUERY_FIELDS = { "name", "calendar_displayName", "visible", "account_name", "account_type" };
  private static final Uri CALENDAR_URI;
  private static final String[] EVENT_INSTANCE_PROJECTION;
  private static final String TAG = CalendarSyncManager.class.getSimpleName();
  private CalendarTaskUtil calendarTaskUtil;
  private Context context;
  public FlagshipSharedPreferences flagshipSharedPreferences;
  
  static
  {
    CALENDAR_URI = CalendarContract.Calendars.CONTENT_URI;
    EVENT_INSTANCE_PROJECTION = new String[] { "event_id", "title", "begin", "end", "eventLocation", "eventStatus", "allDay", "rrule", "calendar_timezone", "availability", "calendar_displayName", "account_name", "account_type" };
  }
  
  public CalendarSyncManager(Context paramContext, FlagshipSharedPreferences paramFlagshipSharedPreferences, CalendarTaskUtil paramCalendarTaskUtil)
  {
    context = paramContext;
    flagshipSharedPreferences = paramFlagshipSharedPreferences;
    calendarTaskUtil = paramCalendarTaskUtil;
  }
  
  private static String buildUniqueCalendarKey(String paramString1, String paramString2, String paramString3)
  {
    return paramString3 + "," + paramString2 + "," + paramString1;
  }
  
  private List<CalendarMetadata> getAllCalendars()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = flagshipSharedPreferences.getCalendarSyncPreferences().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CalendarMetadata)((Iterator)localObject1).next();
      localHashMap.put(buildUniqueCalendarKey(name, accountName, accountType), localObject2);
    }
    localObject1 = new ArrayList();
    Object localObject2 = getPhoneCalendarMetadata().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      CalendarMetadata localCalendarMetadata = (CalendarMetadata)((Iterator)localObject2).next();
      String str = buildUniqueCalendarKey(name, accountName, accountType);
      if (localHashMap.containsKey(str)) {
        ((List)localObject1).add((CalendarMetadata)localHashMap.get(str));
      } else {
        ((List)localObject1).add(localCalendarMetadata);
      }
    }
    return (List<CalendarMetadata>)localObject1;
  }
  
  /* Error */
  private Map<String, List<CalendarEventAttendee>> getAttendees(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: ifeq +15 -> 17
    //   5: aload_0
    //   6: getfield 86	com/linkedin/android/growth/calendar/sync/CalendarSyncManager:context	Landroid/content/Context;
    //   9: ldc -81
    //   11: invokestatic 181	android/support/v4/content/ContextCompat:checkSelfPermission	(Landroid/content/Context;Ljava/lang/String;)I
    //   14: ifeq +9 -> 23
    //   17: invokestatic 187	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   20: astore_1
    //   21: aload_1
    //   22: areturn
    //   23: aload_0
    //   24: getfield 86	com/linkedin/android/growth/calendar/sync/CalendarSyncManager:context	Landroid/content/Context;
    //   27: invokevirtual 193	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   30: astore 11
    //   32: new 195	android/support/v4/util/ArrayMap
    //   35: dup
    //   36: invokespecial 196	android/support/v4/util/ArrayMap:<init>	()V
    //   39: astore 10
    //   41: aconst_null
    //   42: astore 5
    //   44: iconst_0
    //   45: istore_2
    //   46: aload 5
    //   48: astore 7
    //   50: aload 5
    //   52: astore 8
    //   54: aload 5
    //   56: astore 9
    //   58: iload_2
    //   59: aload_1
    //   60: arraylength
    //   61: if_icmpge +929 -> 990
    //   64: aload 5
    //   66: astore 7
    //   68: aload 5
    //   70: astore 8
    //   72: aload 5
    //   74: astore 9
    //   76: aload_1
    //   77: iload_2
    //   78: aload_1
    //   79: arraylength
    //   80: iload_2
    //   81: bipush 50
    //   83: iadd
    //   84: invokestatic 202	java/lang/Math:min	(II)I
    //   87: invokestatic 208	java/util/Arrays:copyOfRange	([Ljava/lang/Object;II)[Ljava/lang/Object;
    //   90: checkcast 209	[Ljava/lang/String;
    //   93: astore 6
    //   95: aload 5
    //   97: astore 7
    //   99: aload 5
    //   101: astore 8
    //   103: aload 5
    //   105: astore 9
    //   107: getstatic 212	android/provider/CalendarContract$Attendees:CONTENT_URI	Landroid/net/Uri;
    //   110: astore 12
    //   112: aload 5
    //   114: astore 7
    //   116: aload 5
    //   118: astore 8
    //   120: aload 5
    //   122: astore 9
    //   124: getstatic 73	com/linkedin/android/growth/calendar/sync/CalendarSyncManager:ATTENDEE_PROJECTION	[Ljava/lang/String;
    //   127: astore 13
    //   129: aload 5
    //   131: astore 7
    //   133: aload 5
    //   135: astore 8
    //   137: aload 5
    //   139: astore 9
    //   141: aload 6
    //   143: arraylength
    //   144: istore 4
    //   146: aload 5
    //   148: astore 7
    //   150: aload 5
    //   152: astore 8
    //   154: aload 5
    //   156: astore 9
    //   158: new 94	java/lang/StringBuilder
    //   161: dup
    //   162: ldc 39
    //   164: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: astore 14
    //   169: aload 5
    //   171: astore 7
    //   173: aload 5
    //   175: astore 8
    //   177: aload 5
    //   179: astore 9
    //   181: aload 14
    //   183: ldc -39
    //   185: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 5
    //   191: astore 7
    //   193: aload 5
    //   195: astore 8
    //   197: aload 5
    //   199: astore 9
    //   201: aload 14
    //   203: ldc -37
    //   205: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: iconst_1
    //   210: istore_3
    //   211: iload_3
    //   212: iload 4
    //   214: if_icmpge +30 -> 244
    //   217: aload 5
    //   219: astore 7
    //   221: aload 5
    //   223: astore 8
    //   225: aload 5
    //   227: astore 9
    //   229: aload 14
    //   231: ldc -35
    //   233: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: iload_3
    //   238: iconst_1
    //   239: iadd
    //   240: istore_3
    //   241: goto -30 -> 211
    //   244: aload 5
    //   246: astore 7
    //   248: aload 5
    //   250: astore 8
    //   252: aload 5
    //   254: astore 9
    //   256: aload 14
    //   258: ldc -33
    //   260: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 5
    //   266: astore 7
    //   268: aload 5
    //   270: astore 8
    //   272: aload 5
    //   274: astore 9
    //   276: aload 11
    //   278: aload 12
    //   280: aload 13
    //   282: aload 14
    //   284: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: aload 6
    //   289: aconst_null
    //   290: invokevirtual 229	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   293: astore 6
    //   295: aload 6
    //   297: ifnull +681 -> 978
    //   300: aload 6
    //   302: astore 7
    //   304: aload 6
    //   306: astore 8
    //   308: aload 6
    //   310: astore 9
    //   312: aload 6
    //   314: invokeinterface 234 1 0
    //   319: ifeq +659 -> 978
    //   322: aload 6
    //   324: astore 7
    //   326: aload 6
    //   328: astore 8
    //   330: aload 6
    //   332: astore 9
    //   334: aload 6
    //   336: iconst_0
    //   337: invokeinterface 238 2 0
    //   342: astore 12
    //   344: aload 6
    //   346: astore 7
    //   348: aload 6
    //   350: astore 8
    //   352: aload 6
    //   354: astore 9
    //   356: aload 6
    //   358: iconst_1
    //   359: invokeinterface 238 2 0
    //   364: astore 13
    //   366: aload 6
    //   368: astore 7
    //   370: aload 6
    //   372: astore 8
    //   374: aload 6
    //   376: astore 9
    //   378: aload 6
    //   380: iconst_2
    //   381: invokeinterface 242 2 0
    //   386: tableswitch	default:+622->1008, 1:+377->763, 2:+397->783, 3:+417->803, 4:+437->823
    //   416: aload 6
    //   418: astore 7
    //   420: aload 6
    //   422: astore 8
    //   424: aload 6
    //   426: astore 9
    //   428: getstatic 248	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus:UNRECOGNIZED	Lcom/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus;
    //   431: astore 5
    //   433: aload 6
    //   435: astore 7
    //   437: aload 6
    //   439: astore 8
    //   441: aload 6
    //   443: astore 9
    //   445: aload 6
    //   447: iconst_3
    //   448: invokeinterface 238 2 0
    //   453: astore 14
    //   455: aload 6
    //   457: astore 7
    //   459: aload 6
    //   461: astore 8
    //   463: aload 6
    //   465: astore 9
    //   467: aload 10
    //   469: aload 14
    //   471: invokeinterface 158 2 0
    //   476: ifne +32 -> 508
    //   479: aload 6
    //   481: astore 7
    //   483: aload 6
    //   485: astore 8
    //   487: aload 6
    //   489: astore 9
    //   491: aload 10
    //   493: aload 14
    //   495: new 150	java/util/ArrayList
    //   498: dup
    //   499: invokespecial 151	java/util/ArrayList:<init>	()V
    //   502: invokeinterface 148 3 0
    //   507: pop
    //   508: aload 6
    //   510: astore 7
    //   512: aload 6
    //   514: astore 8
    //   516: aload 6
    //   518: astore 9
    //   520: aload 10
    //   522: aload 14
    //   524: invokeinterface 162 2 0
    //   529: checkcast 116	java/util/List
    //   532: astore 14
    //   534: aload 6
    //   536: astore 7
    //   538: aload 6
    //   540: astore 8
    //   542: aload 6
    //   544: astore 9
    //   546: new 250	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder
    //   549: dup
    //   550: invokespecial 251	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:<init>	()V
    //   553: astore 15
    //   555: aload 12
    //   557: ifnonnull +286 -> 843
    //   560: aload 6
    //   562: astore 7
    //   564: aload 6
    //   566: astore 8
    //   568: aload 6
    //   570: astore 9
    //   572: aload 15
    //   574: iconst_0
    //   575: putfield 255	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:hasName	Z
    //   578: aload 6
    //   580: astore 7
    //   582: aload 6
    //   584: astore 8
    //   586: aload 6
    //   588: astore 9
    //   590: aload 15
    //   592: aconst_null
    //   593: putfield 256	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:name	Ljava/lang/String;
    //   596: aload 13
    //   598: ifnonnull +285 -> 883
    //   601: aload 6
    //   603: astore 7
    //   605: aload 6
    //   607: astore 8
    //   609: aload 6
    //   611: astore 9
    //   613: aload 15
    //   615: iconst_0
    //   616: putfield 259	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:hasEmail	Z
    //   619: aload 6
    //   621: astore 7
    //   623: aload 6
    //   625: astore 8
    //   627: aload 6
    //   629: astore 9
    //   631: aload 15
    //   633: aconst_null
    //   634: putfield 262	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:email	Ljava/lang/String;
    //   637: aload 5
    //   639: ifnull +26 -> 665
    //   642: aload 6
    //   644: astore 7
    //   646: aload 6
    //   648: astore 8
    //   650: aload 6
    //   652: astore 9
    //   654: aload 5
    //   656: getstatic 265	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus:PENDING	Lcom/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus;
    //   659: invokevirtual 268	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus:equals	(Ljava/lang/Object;)Z
    //   662: ifeq +276 -> 938
    //   665: aload 6
    //   667: astore 7
    //   669: aload 6
    //   671: astore 8
    //   673: aload 6
    //   675: astore 9
    //   677: aload 15
    //   679: iconst_0
    //   680: putfield 271	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:hasStatus	Z
    //   683: aload 6
    //   685: astore 7
    //   687: aload 6
    //   689: astore 8
    //   691: aload 6
    //   693: astore 9
    //   695: aload 15
    //   697: getstatic 265	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus:PENDING	Lcom/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus;
    //   700: putfield 274	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:status	Lcom/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus;
    //   703: aload 6
    //   705: astore 7
    //   707: aload 6
    //   709: astore 8
    //   711: aload 6
    //   713: astore 9
    //   715: aload 14
    //   717: aload 15
    //   719: getstatic 280	com/linkedin/data/lite/RecordTemplate$Flavor:RECORD	Lcom/linkedin/data/lite/RecordTemplate$Flavor;
    //   722: invokevirtual 284	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:build	(Lcom/linkedin/data/lite/RecordTemplate$Flavor;)Lcom/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee;
    //   725: invokeinterface 165 2 0
    //   730: pop
    //   731: goto -431 -> 300
    //   734: astore_1
    //   735: aload 7
    //   737: astore 8
    //   739: getstatic 28	com/linkedin/android/growth/calendar/sync/CalendarSyncManager:TAG	Ljava/lang/String;
    //   742: aload_1
    //   743: invokestatic 290	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   746: pop
    //   747: aload 7
    //   749: ifnull +10 -> 759
    //   752: aload 7
    //   754: invokeinterface 293 1 0
    //   759: invokestatic 187	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   762: areturn
    //   763: aload 6
    //   765: astore 7
    //   767: aload 6
    //   769: astore 8
    //   771: aload 6
    //   773: astore 9
    //   775: getstatic 296	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus:ACCEPTED	Lcom/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus;
    //   778: astore 5
    //   780: goto -347 -> 433
    //   783: aload 6
    //   785: astore 7
    //   787: aload 6
    //   789: astore 8
    //   791: aload 6
    //   793: astore 9
    //   795: getstatic 299	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus:DECLINED	Lcom/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus;
    //   798: astore 5
    //   800: goto -367 -> 433
    //   803: aload 6
    //   805: astore 7
    //   807: aload 6
    //   809: astore 8
    //   811: aload 6
    //   813: astore 9
    //   815: getstatic 302	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus:IN_PROCESS	Lcom/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus;
    //   818: astore 5
    //   820: goto -387 -> 433
    //   823: aload 6
    //   825: astore 7
    //   827: aload 6
    //   829: astore 8
    //   831: aload 6
    //   833: astore 9
    //   835: getstatic 305	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus:TENTATIVE	Lcom/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus;
    //   838: astore 5
    //   840: goto -407 -> 433
    //   843: aload 6
    //   845: astore 7
    //   847: aload 6
    //   849: astore 8
    //   851: aload 6
    //   853: astore 9
    //   855: aload 15
    //   857: iconst_1
    //   858: putfield 255	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:hasName	Z
    //   861: aload 6
    //   863: astore 7
    //   865: aload 6
    //   867: astore 8
    //   869: aload 6
    //   871: astore 9
    //   873: aload 15
    //   875: aload 12
    //   877: putfield 256	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:name	Ljava/lang/String;
    //   880: goto -284 -> 596
    //   883: aload 6
    //   885: astore 7
    //   887: aload 6
    //   889: astore 8
    //   891: aload 6
    //   893: astore 9
    //   895: aload 15
    //   897: iconst_1
    //   898: putfield 259	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:hasEmail	Z
    //   901: aload 6
    //   903: astore 7
    //   905: aload 6
    //   907: astore 8
    //   909: aload 6
    //   911: astore 9
    //   913: aload 15
    //   915: aload 13
    //   917: putfield 262	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:email	Ljava/lang/String;
    //   920: goto -283 -> 637
    //   923: astore_1
    //   924: aload 8
    //   926: ifnull +10 -> 936
    //   929: aload 8
    //   931: invokeinterface 293 1 0
    //   936: aload_1
    //   937: athrow
    //   938: aload 6
    //   940: astore 7
    //   942: aload 6
    //   944: astore 8
    //   946: aload 6
    //   948: astore 9
    //   950: aload 15
    //   952: iconst_1
    //   953: putfield 271	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:hasStatus	Z
    //   956: aload 6
    //   958: astore 7
    //   960: aload 6
    //   962: astore 8
    //   964: aload 6
    //   966: astore 9
    //   968: aload 15
    //   970: aload 5
    //   972: putfield 274	com/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendee$Builder:status	Lcom/linkedin/android/pegasus/gen/voyager/growth/calendar/CalendarEventAttendeeStatus;
    //   975: goto -272 -> 703
    //   978: iload_2
    //   979: bipush 50
    //   981: iadd
    //   982: istore_2
    //   983: aload 6
    //   985: astore 5
    //   987: goto -941 -> 46
    //   990: aload 10
    //   992: astore_1
    //   993: aload 5
    //   995: ifnull -974 -> 21
    //   998: aload 5
    //   1000: invokeinterface 293 1 0
    //   1005: aload 10
    //   1007: areturn
    //   1008: goto -592 -> 416
    //   1011: astore_1
    //   1012: aload 9
    //   1014: astore 7
    //   1016: goto -281 -> 735
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1019	0	this	CalendarSyncManager
    //   0	1019	1	paramArrayOfString	String[]
    //   45	938	2	i	int
    //   210	31	3	j	int
    //   144	71	4	k	int
    //   42	957	5	localObject1	Object
    //   93	891	6	localObject2	Object
    //   48	967	7	localObject3	Object
    //   52	911	8	localObject4	Object
    //   56	957	9	localObject5	Object
    //   39	967	10	localArrayMap	ArrayMap
    //   30	247	11	localContentResolver	ContentResolver
    //   110	766	12	localObject6	Object
    //   127	789	13	localObject7	Object
    //   167	549	14	localObject8	Object
    //   553	416	15	localBuilder	com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarEventAttendee.Builder
    // Exception table:
    //   from	to	target	type
    //   58	64	734	com/linkedin/data/lite/BuilderException
    //   76	95	734	com/linkedin/data/lite/BuilderException
    //   107	112	734	com/linkedin/data/lite/BuilderException
    //   124	129	734	com/linkedin/data/lite/BuilderException
    //   141	146	734	com/linkedin/data/lite/BuilderException
    //   158	169	734	com/linkedin/data/lite/BuilderException
    //   181	189	734	com/linkedin/data/lite/BuilderException
    //   201	209	734	com/linkedin/data/lite/BuilderException
    //   229	237	734	com/linkedin/data/lite/BuilderException
    //   256	264	734	com/linkedin/data/lite/BuilderException
    //   276	295	734	com/linkedin/data/lite/BuilderException
    //   312	322	734	com/linkedin/data/lite/BuilderException
    //   334	344	734	com/linkedin/data/lite/BuilderException
    //   356	366	734	com/linkedin/data/lite/BuilderException
    //   378	416	734	com/linkedin/data/lite/BuilderException
    //   428	433	734	com/linkedin/data/lite/BuilderException
    //   445	455	734	com/linkedin/data/lite/BuilderException
    //   467	479	734	com/linkedin/data/lite/BuilderException
    //   491	508	734	com/linkedin/data/lite/BuilderException
    //   520	534	734	com/linkedin/data/lite/BuilderException
    //   546	555	734	com/linkedin/data/lite/BuilderException
    //   572	578	734	com/linkedin/data/lite/BuilderException
    //   590	596	734	com/linkedin/data/lite/BuilderException
    //   613	619	734	com/linkedin/data/lite/BuilderException
    //   631	637	734	com/linkedin/data/lite/BuilderException
    //   654	665	734	com/linkedin/data/lite/BuilderException
    //   677	683	734	com/linkedin/data/lite/BuilderException
    //   695	703	734	com/linkedin/data/lite/BuilderException
    //   715	731	734	com/linkedin/data/lite/BuilderException
    //   775	780	734	com/linkedin/data/lite/BuilderException
    //   795	800	734	com/linkedin/data/lite/BuilderException
    //   815	820	734	com/linkedin/data/lite/BuilderException
    //   835	840	734	com/linkedin/data/lite/BuilderException
    //   855	861	734	com/linkedin/data/lite/BuilderException
    //   873	880	734	com/linkedin/data/lite/BuilderException
    //   895	901	734	com/linkedin/data/lite/BuilderException
    //   913	920	734	com/linkedin/data/lite/BuilderException
    //   950	956	734	com/linkedin/data/lite/BuilderException
    //   968	975	734	com/linkedin/data/lite/BuilderException
    //   58	64	923	finally
    //   76	95	923	finally
    //   107	112	923	finally
    //   124	129	923	finally
    //   141	146	923	finally
    //   158	169	923	finally
    //   181	189	923	finally
    //   201	209	923	finally
    //   229	237	923	finally
    //   256	264	923	finally
    //   276	295	923	finally
    //   312	322	923	finally
    //   334	344	923	finally
    //   356	366	923	finally
    //   378	416	923	finally
    //   428	433	923	finally
    //   445	455	923	finally
    //   467	479	923	finally
    //   491	508	923	finally
    //   520	534	923	finally
    //   546	555	923	finally
    //   572	578	923	finally
    //   590	596	923	finally
    //   613	619	923	finally
    //   631	637	923	finally
    //   654	665	923	finally
    //   677	683	923	finally
    //   695	703	923	finally
    //   715	731	923	finally
    //   739	747	923	finally
    //   775	780	923	finally
    //   795	800	923	finally
    //   815	820	923	finally
    //   835	840	923	finally
    //   855	861	923	finally
    //   873	880	923	finally
    //   895	901	923	finally
    //   913	920	923	finally
    //   950	956	923	finally
    //   968	975	923	finally
    //   58	64	1011	java/lang/SecurityException
    //   76	95	1011	java/lang/SecurityException
    //   107	112	1011	java/lang/SecurityException
    //   124	129	1011	java/lang/SecurityException
    //   141	146	1011	java/lang/SecurityException
    //   158	169	1011	java/lang/SecurityException
    //   181	189	1011	java/lang/SecurityException
    //   201	209	1011	java/lang/SecurityException
    //   229	237	1011	java/lang/SecurityException
    //   256	264	1011	java/lang/SecurityException
    //   276	295	1011	java/lang/SecurityException
    //   312	322	1011	java/lang/SecurityException
    //   334	344	1011	java/lang/SecurityException
    //   356	366	1011	java/lang/SecurityException
    //   378	416	1011	java/lang/SecurityException
    //   428	433	1011	java/lang/SecurityException
    //   445	455	1011	java/lang/SecurityException
    //   467	479	1011	java/lang/SecurityException
    //   491	508	1011	java/lang/SecurityException
    //   520	534	1011	java/lang/SecurityException
    //   546	555	1011	java/lang/SecurityException
    //   572	578	1011	java/lang/SecurityException
    //   590	596	1011	java/lang/SecurityException
    //   613	619	1011	java/lang/SecurityException
    //   631	637	1011	java/lang/SecurityException
    //   654	665	1011	java/lang/SecurityException
    //   677	683	1011	java/lang/SecurityException
    //   695	703	1011	java/lang/SecurityException
    //   715	731	1011	java/lang/SecurityException
    //   775	780	1011	java/lang/SecurityException
    //   795	800	1011	java/lang/SecurityException
    //   815	820	1011	java/lang/SecurityException
    //   835	840	1011	java/lang/SecurityException
    //   855	861	1011	java/lang/SecurityException
    //   873	880	1011	java/lang/SecurityException
    //   895	901	1011	java/lang/SecurityException
    //   913	920	1011	java/lang/SecurityException
    //   950	956	1011	java/lang/SecurityException
    //   968	975	1011	java/lang/SecurityException
  }
  
  private Map<String, CalendarUploadEvent.Builder> getCalendarUploadBuilderMap(long paramLong1, long paramLong2)
  {
    if (ContextCompat.checkSelfPermission(context, "android.permission.READ_CALENDAR") != 0)
    {
      localObject1 = Collections.emptyMap();
      return (Map<String, CalendarUploadEvent.Builder>)localObject1;
    }
    ArrayList localArrayList = new ArrayList();
    if (flagshipSharedPreferences.getCalendarSyncEnabled())
    {
      getAllCalendars();
      localObject1 = flagshipSharedPreferences.getCalendarSyncPreferences().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CalendarMetadata)((Iterator)localObject1).next();
        if (shouldSync) {
          localArrayList.add(buildUniqueCalendarKey(name, accountName, accountType));
        }
      }
    }
    if (localArrayList.isEmpty()) {
      return Collections.emptyMap();
    }
    Object localObject2 = CalendarContract.Instances.CONTENT_URI.buildUpon();
    Object localObject5 = context.getContentResolver();
    ContentUris.appendId((Uri.Builder)localObject2, paramLong1);
    ContentUris.appendId((Uri.Builder)localObject2, paramLong2);
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    ArrayMap localArrayMap = new ArrayMap();
    for (;;)
    {
      CalendarUploadEvent.Builder localBuilder;
      String str2;
      String str1;
      try
      {
        localObject5 = ((ContentResolver)localObject5).query(((Uri.Builder)localObject2).build(), EVENT_INSTANCE_PROJECTION, null, null, "begin ASC");
        if (localObject5 != null)
        {
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          if (((Cursor)localObject5).getCount() != 0) {}
        }
        else
        {
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          localObject2 = Collections.emptyMap();
          localObject1 = localObject2;
          return (Map<String, CalendarUploadEvent.Builder>)localObject2;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          localObject2 = CalendarEventAvailability.BUSY;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          localBuilder = new CalendarUploadEvent.Builder();
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          localLong = Long.valueOf(paramLong1);
          if (localLong != null) {
            continue;
          }
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          hasStartTime = false;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          startTime = 0L;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          localLong = Long.valueOf(paramLong2);
          if (localLong != null) {
            continue;
          }
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          hasEndTime = false;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          endTime = 0L;
          if (localObject6 != null) {
            continue;
          }
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          hasExternalId = false;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          externalId = null;
          if (localObject2 != null)
          {
            localObject3 = localObject5;
            localObject4 = localObject5;
            localObject1 = localObject5;
            if (!((CalendarEventAvailability)localObject2).equals(CalendarEventAvailability.NOT_SUPPORTED)) {
              break label1441;
            }
          }
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          hasStatus = false;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          status = CalendarEventAvailability.NOT_SUPPORTED;
          if (str2 != null) {
            break label1481;
          }
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          hasTitle = false;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          title = null;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          localObject2 = CalendarSource.ANDROID_CALENDAR;
          if (localObject2 != null) {
            break label1521;
          }
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          hasSource = false;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          source = null;
          if (str1 != null) {
            break label1561;
          }
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          hasLocation = false;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          location = null;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          localObject2 = Boolean.valueOf(bool1);
          if (localObject2 != null)
          {
            localObject3 = localObject5;
            localObject4 = localObject5;
            localObject1 = localObject5;
            if (((Boolean)localObject2).booleanValue()) {
              break label1601;
            }
          }
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          hasFullDayEvent = false;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          fullDayEvent = false;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          localObject2 = Boolean.valueOf(bool2);
          if (localObject2 != null)
          {
            localObject3 = localObject5;
            localObject4 = localObject5;
            localObject1 = localObject5;
            if (((Boolean)localObject2).booleanValue()) {
              break label1644;
            }
          }
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          hasRecurring = false;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          recurring = false;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          localArrayMap.put(localObject6, localBuilder);
        }
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        if (!((Cursor)localObject5).moveToNext()) {
          break label1687;
        }
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        localObject6 = ((Cursor)localObject5).getString(0);
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        localObject2 = buildUniqueCalendarKey(((Cursor)localObject5).getString(10), ((Cursor)localObject5).getString(11), ((Cursor)localObject5).getString(12));
        if (localObject6 == null) {
          continue;
        }
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        if (!localArrayList.contains(localObject2)) {
          continue;
        }
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        paramLong1 = ((Cursor)localObject5).getLong(2);
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        paramLong2 = ((Cursor)localObject5).getLong(3);
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        str2 = ((Cursor)localObject5).getString(1);
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        str1 = ((Cursor)localObject5).getString(4);
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        if (((Cursor)localObject5).getInt(6) <= 0) {
          break label1709;
        }
        bool1 = true;
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        if (TextUtils.isEmpty(((Cursor)localObject5).getString(7))) {
          break label1715;
        }
        bool2 = true;
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        switch (((Cursor)localObject5).getInt(9))
        {
        case 0: 
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          localObject2 = CalendarEventAvailability.UNAVAILABLE;
          break;
        case 1: 
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          localObject2 = CalendarEventAvailability.FREE;
          break;
        case 2: 
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          localObject2 = CalendarEventAvailability.TENTATIVE;
          continue;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          hasStartTime = true;
          localObject3 = localObject5;
          localObject4 = localObject5;
          localObject1 = localObject5;
          startTime = localLong.longValue();
          continue;
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        Long localLong;
        localObject1 = localObject3;
        Util.safeThrow(localSQLiteException);
        localObject1 = localObject3;
        CrashReporter.reportNonFatal(localSQLiteException);
        localObject1 = localArrayMap;
        return localArrayMap;
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        hasEndTime = true;
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        endTime = localLong.longValue();
        continue;
      }
      catch (SecurityException localSecurityException)
      {
        Object localObject6;
        localObject1 = localObject4;
        Log.e("Catch SecurityException to avoid crashing on devices with non-standard permission checks.", localSecurityException);
        localObject1 = localObject4;
        CrashReporter.reportNonFatal(localSecurityException);
        localObject1 = localArrayMap;
        return localArrayMap;
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        hasExternalId = true;
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        externalId = ((String)localObject6);
        continue;
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
      label1441:
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject1 = localObject5;
      hasStatus = true;
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject1 = localObject5;
      status = localCalendarEventAvailability;
      continue;
      label1481:
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject1 = localObject5;
      hasTitle = true;
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject1 = localObject5;
      title = str2;
      continue;
      label1521:
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject1 = localObject5;
      hasSource = true;
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject1 = localObject5;
      source = localCalendarEventAvailability;
      continue;
      label1561:
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject1 = localObject5;
      hasLocation = true;
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject1 = localObject5;
      location = str1;
      continue;
      label1601:
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject1 = localObject5;
      hasFullDayEvent = true;
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject1 = localObject5;
      fullDayEvent = localCalendarEventAvailability.booleanValue();
      continue;
      label1644:
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject1 = localObject5;
      hasRecurring = true;
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject1 = localObject5;
      recurring = localCalendarEventAvailability.booleanValue();
      continue;
      label1687:
      localObject1 = localArrayMap;
      if (localObject5 == null) {
        break;
      }
      ((Cursor)localObject5).close();
      return localArrayMap;
      continue;
      label1709:
      boolean bool1 = false;
      continue;
      label1715:
      boolean bool2 = false;
    }
  }
  
  private static String getCursorString(Cursor paramCursor, String paramString)
  {
    return paramCursor.getString(paramCursor.getColumnIndex(paramString));
  }
  
  public static String getHash(List<CalendarUploadEvent> paramList)
  {
    String str = "hash";
    if (paramList.isEmpty()) {
      return "hash";
    }
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (CalendarUploadEvent)localIterator.next();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(startTime);
      ((StringBuilder)localObject2).append(endTime);
      ((StringBuilder)localObject2).append(_cachedId);
      ((StringBuilder)localObject2).append(title);
      ((StringBuilder)localObject2).append(source.toString());
      ((StringBuilder)localObject2).append(location);
      ((StringBuilder)localObject2).append(fullDayEvent);
      ((StringBuilder)localObject2).append(recurring);
      ((List)localObject1).add(((StringBuilder)localObject2).toString());
      localObject2 = attendees.iterator();
      label166:
      CalendarEventAttendee localCalendarEventAttendee;
      StringBuilder localStringBuilder;
      if (((Iterator)localObject2).hasNext())
      {
        localCalendarEventAttendee = (CalendarEventAttendee)((Iterator)localObject2).next();
        localStringBuilder = new StringBuilder();
        if (!hasName) {
          break label311;
        }
        paramList = name;
        label211:
        localStringBuilder.append(paramList);
        if (email == null) {
          break label318;
        }
        paramList = email;
        label232:
        localStringBuilder.append(paramList);
        if ((localCalendarEventAttendee == null) || (!hasStatus) || ((!CalendarEventAttendeeStatus.ACCEPTED.equals(status)) && (!CalendarEventAttendeeStatus.DECLINED.equals(status)))) {
          break label325;
        }
      }
      label311:
      label318:
      label325:
      for (paramList = status.toString();; paramList = "")
      {
        localStringBuilder.append(paramList);
        ((List)localObject1).add(localStringBuilder.toString());
        break label166;
        break;
        paramList = "";
        break label211;
        paramList = "";
        break label232;
      }
    }
    Collections.sort((List)localObject1);
    paramList = new StringBuilder();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.append((String)((Iterator)localObject1).next());
    }
    try
    {
      paramList = new String(MessageDigest.getInstance("MD5").digest(paramList.toString().getBytes("UTF-8")), "UTF-8");
      return paramList;
    }
    catch (NoSuchAlgorithmException paramList)
    {
      for (;;)
      {
        Log.e(TAG, paramList.getMessage());
        paramList = str;
      }
    }
    catch (UnsupportedEncodingException paramList)
    {
      for (;;)
      {
        Log.e(TAG, paramList.getMessage());
        paramList = str;
      }
    }
  }
  
  private List<CalendarMetadata> getPhoneCalendarMetadata()
  {
    Object localObject6 = new ArrayList();
    Object localObject5 = context.getContentResolver();
    if (localObject5 == null) {
      return (List<CalendarMetadata>)localObject6;
    }
    localObject4 = null;
    localObject3 = null;
    localObject1 = localObject6;
    try
    {
      localObject5 = ((ContentResolver)localObject5).query(CALENDAR_URI, CALENDAR_QUERY_FIELDS, null, null, null);
      if (localObject5 == null) {
        return (List<CalendarMetadata>)localObject6;
      }
      localObject1 = localObject6;
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject6 = getPhoneCalendarMetadataWithCursor((Cursor)localObject5);
      localObject1 = localObject6;
      localObject3 = localObject5;
      localObject4 = localObject5;
      localObject6 = groupCalendarsByAccount((List)localObject6);
      localObject1 = localObject6;
      localObject4 = localObject1;
      if (localObject5 != null)
      {
        ((Cursor)localObject5).close();
        localObject4 = localObject1;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        localObject4 = localObject3;
        Log.e("Security exception when querying for calendar in getPhoneCalendarMetadata()", localSecurityException);
        localObject4 = localObject3;
        CrashReporter.reportNonFatal(localSecurityException);
        localObject4 = localObject1;
        if (localObject3 != null)
        {
          ((Cursor)localObject3).close();
          localObject4 = localObject1;
        }
      }
    }
    finally
    {
      if (localObject4 == null) {
        break label170;
      }
      ((Cursor)localObject4).close();
    }
    return (List<CalendarMetadata>)localObject4;
  }
  
  private static List<CalendarMetadata> getPhoneCalendarMetadataWithCursor(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    if ((paramCursor != null) && (paramCursor.moveToNext()))
    {
      Object localObject = getCursorString(paramCursor, "name");
      String str1 = getCursorString(paramCursor, "calendar_displayName");
      String str2 = getCursorString(paramCursor, "visible");
      if ((!TextUtils.isEmpty(str2)) && (!str2.equals("0"))) {}
      for (boolean bool = true;; bool = false)
      {
        str2 = getCursorString(paramCursor, "account_name");
        String str3 = getCursorString(paramCursor, "account_type");
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
          break;
        }
        localObject = new CalendarMetadata(str3, str2, (String)localObject, str1, bool);
        str1 = buildUniqueCalendarKey(str1, str2, str3);
        if (localHashSet.contains(str1)) {
          break;
        }
        localHashSet.add(str1);
        localArrayList.add(localObject);
        break;
      }
    }
    return localArrayList;
  }
  
  private static List<CalendarMetadata> groupCalendarsByAccount(List<CalendarMetadata> paramList)
  {
    Object localObject = new ArrayList();
    ArrayMap localArrayMap = new ArrayMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CalendarMetadata localCalendarMetadata = (CalendarMetadata)paramList.next();
      String str = accountName;
      if (!localArrayMap.containsKey(str))
      {
        ((List)localObject).add(str);
        localArrayMap.put(str, new ArrayList());
      }
      ((List)localArrayMap.get(str)).add(localCalendarMetadata);
    }
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.addAll((List)localArrayMap.get((String)((Iterator)localObject).next()));
    }
    return paramList;
  }
  
  public final void disableCalendarSync()
  {
    flagshipSharedPreferences.setCalendarSyncEnabled(false);
    flagshipSharedPreferences.setCalendarSyncPreferences(Collections.emptyList());
    calendarTaskUtil.unregisterTask();
    CalendarTaskUtil localCalendarTaskUtil = calendarTaskUtil;
    CalendarSourceRequest localCalendarSourceRequest = CalendarTaskUtil.getCalendarSourceRequest();
    if (localCalendarSourceRequest != null) {
      flagshipDataManager.submit(Request.post().url(Routes.SYNC_CALENDAR.buildUponRoot().buildUpon().appendQueryParameter("action", "disableCalendarSync").build().toString()).model(localCalendarSourceRequest).builder(BooleanActionResponse.BUILDER).listener(new CalendarTaskUtil.1(localCalendarTaskUtil)).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
    }
  }
  
  public final void doCalendarSync(Context paramContext)
  {
    if (PermissionRequester.hasPermission(paramContext, "android.permission.READ_CALENDAR"))
    {
      enableCalendarSync();
      return;
    }
    disableCalendarSync();
  }
  
  public final void enableCalendarSync()
  {
    flagshipSharedPreferences.setCalendarSyncPreferences(getAllCalendars());
    flagshipSharedPreferences.setCalendarSyncEnabled(true);
    CalendarTaskUtil localCalendarTaskUtil = calendarTaskUtil;
    Util.setComponentEnabled(context, CalendarUploadReceiver.class, true);
    Intent localIntent = new Intent();
    localIntent.setAction("com.linkedin.android.Flagship.tasks.START");
    context.sendBroadcast(localIntent);
  }
  
  public final List<CalendarUploadEvent> getEventRequest(long paramLong1, long paramLong2)
  {
    Object localObject = getCalendarUploadBuilderMap(paramLong1, paramLong2);
    Map localMap = getAttendees((String[])((Map)localObject).keySet().toArray(new String[((Map)localObject).size()]));
    ArrayList localArrayList = new ArrayList(((Map)localObject).size());
    for (;;)
    {
      List localList2;
      CalendarUploadEvent.Builder localBuilder;
      try
      {
        Iterator localIterator = ((Map)localObject).entrySet().iterator();
        localObject = localArrayList;
        if (localIterator.hasNext())
        {
          localObject = (Map.Entry)localIterator.next();
          localList2 = (List)localMap.get(((Map.Entry)localObject).getKey());
          if (localList2 != null)
          {
            localBuilder = (CalendarUploadEvent.Builder)((Map.Entry)localObject).getValue();
            if ((localList2 != null) && (!localList2.equals(Collections.emptyList()))) {
              break label212;
            }
            hasAttendees = false;
            attendees = Collections.emptyList();
          }
          localArrayList.add(((CalendarUploadEvent.Builder)((Map.Entry)localObject).getValue()).build(RecordTemplate.Flavor.RECORD));
        }
        List localList1;
        hasAttendees = true;
      }
      catch (BuilderException localBuilderException)
      {
        Log.e(TAG, localBuilderException.getMessage());
        localList1 = Collections.emptyList();
        return localList1;
      }
      label212:
      attendees = localList2;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.sync.CalendarSyncManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */