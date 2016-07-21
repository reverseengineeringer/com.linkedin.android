package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ActivityChooserModel
  extends DataSetObservable
{
  private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
  private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
  private static final Object sRegistryLock = new Object();
  final List<ActivityResolveInfo> mActivities;
  private OnChooseActivityListener mActivityChoserModelPolicy;
  private ActivitySorter mActivitySorter;
  private boolean mCanReadHistoricalData;
  private final Context mContext;
  private final List<HistoricalRecord> mHistoricalRecords;
  private boolean mHistoricalRecordsChanged;
  private final String mHistoryFileName;
  private int mHistoryMaxSize;
  final Object mInstanceLock;
  private Intent mIntent;
  private boolean mReadShareHistoryCalled;
  private boolean mReloadActivities;
  
  private void pruneExcessiveHistoricalRecordsIfNeeded()
  {
    int j = mHistoricalRecords.size() - mHistoryMaxSize;
    if (j <= 0) {}
    for (;;)
    {
      return;
      mHistoricalRecordsChanged = true;
      int i = 0;
      while (i < j)
      {
        mHistoricalRecords.remove(0);
        i += 1;
      }
    }
  }
  
  /* Error */
  private void readHistoricalDataImpl()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	android/support/v7/widget/ActivityChooserModel:mContext	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 80	android/support/v7/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   8: invokevirtual 114	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic 120	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_3
    //   16: aload_3
    //   17: aload_2
    //   18: ldc 122
    //   20: invokeinterface 128 3 0
    //   25: iconst_0
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_1
    //   29: if_icmpeq +18 -> 47
    //   32: iload_1
    //   33: iconst_2
    //   34: if_icmpeq +13 -> 47
    //   37: aload_3
    //   38: invokeinterface 131 1 0
    //   43: istore_1
    //   44: goto -17 -> 27
    //   47: ldc -123
    //   49: aload_3
    //   50: invokeinterface 136 1 0
    //   55: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +50 -> 108
    //   61: new 106	org/xmlpull/v1/XmlPullParserException
    //   64: dup
    //   65: ldc -112
    //   67: invokespecial 147	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    //   71: astore_3
    //   72: getstatic 58	android/support/v7/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   75: new 149	java/lang/StringBuilder
    //   78: dup
    //   79: ldc -105
    //   81: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload_0
    //   85: getfield 80	android/support/v7/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   88: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: aload_3
    //   95: invokestatic 165	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   98: pop
    //   99: aload_2
    //   100: ifnull +7 -> 107
    //   103: aload_2
    //   104: invokevirtual 170	java/io/FileInputStream:close	()V
    //   107: return
    //   108: aload_0
    //   109: getfield 87	android/support/v7/widget/ActivityChooserModel:mHistoricalRecords	Ljava/util/List;
    //   112: astore 4
    //   114: aload 4
    //   116: invokeinterface 173 1 0
    //   121: aload_3
    //   122: invokeinterface 131 1 0
    //   127: istore_1
    //   128: iload_1
    //   129: iconst_1
    //   130: if_icmpeq +138 -> 268
    //   133: iload_1
    //   134: iconst_3
    //   135: if_icmpeq -14 -> 121
    //   138: iload_1
    //   139: iconst_4
    //   140: if_icmpeq -19 -> 121
    //   143: ldc -81
    //   145: aload_3
    //   146: invokeinterface 136 1 0
    //   151: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifne +52 -> 206
    //   157: new 106	org/xmlpull/v1/XmlPullParserException
    //   160: dup
    //   161: ldc -79
    //   163: invokespecial 147	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   166: athrow
    //   167: astore_3
    //   168: getstatic 58	android/support/v7/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   171: new 149	java/lang/StringBuilder
    //   174: dup
    //   175: ldc -105
    //   177: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: aload_0
    //   181: getfield 80	android/support/v7/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   184: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: aload_3
    //   191: invokestatic 165	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   194: pop
    //   195: aload_2
    //   196: ifnull -89 -> 107
    //   199: aload_2
    //   200: invokevirtual 170	java/io/FileInputStream:close	()V
    //   203: return
    //   204: astore_2
    //   205: return
    //   206: aload 4
    //   208: new 12	android/support/v7/widget/ActivityChooserModel$HistoricalRecord
    //   211: dup
    //   212: aload_3
    //   213: aconst_null
    //   214: ldc -77
    //   216: invokeinterface 183 3 0
    //   221: aload_3
    //   222: aconst_null
    //   223: ldc -71
    //   225: invokeinterface 183 3 0
    //   230: invokestatic 191	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   233: aload_3
    //   234: aconst_null
    //   235: ldc -63
    //   237: invokeinterface 183 3 0
    //   242: invokestatic 199	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   245: invokespecial 202	android/support/v7/widget/ActivityChooserModel$HistoricalRecord:<init>	(Ljava/lang/String;JF)V
    //   248: invokeinterface 205 2 0
    //   253: pop
    //   254: goto -133 -> 121
    //   257: astore_3
    //   258: aload_2
    //   259: ifnull +7 -> 266
    //   262: aload_2
    //   263: invokevirtual 170	java/io/FileInputStream:close	()V
    //   266: aload_3
    //   267: athrow
    //   268: aload_2
    //   269: ifnull -162 -> 107
    //   272: aload_2
    //   273: invokevirtual 170	java/io/FileInputStream:close	()V
    //   276: return
    //   277: astore_2
    //   278: return
    //   279: astore_2
    //   280: return
    //   281: astore_2
    //   282: goto -16 -> 266
    //   285: astore_2
    //   286: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	ActivityChooserModel
    //   26	115	1	i	int
    //   11	189	2	localFileInputStream	java.io.FileInputStream
    //   204	69	2	localIOException1	java.io.IOException
    //   277	1	2	localIOException2	java.io.IOException
    //   279	1	2	localIOException3	java.io.IOException
    //   281	1	2	localIOException4	java.io.IOException
    //   285	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   15	35	3	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   71	75	3	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   167	67	3	localIOException5	java.io.IOException
    //   257	10	3	localObject	Object
    //   112	95	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   12	25	71	org/xmlpull/v1/XmlPullParserException
    //   37	44	71	org/xmlpull/v1/XmlPullParserException
    //   47	71	71	org/xmlpull/v1/XmlPullParserException
    //   108	121	71	org/xmlpull/v1/XmlPullParserException
    //   121	128	71	org/xmlpull/v1/XmlPullParserException
    //   143	167	71	org/xmlpull/v1/XmlPullParserException
    //   206	254	71	org/xmlpull/v1/XmlPullParserException
    //   12	25	167	java/io/IOException
    //   37	44	167	java/io/IOException
    //   47	71	167	java/io/IOException
    //   108	121	167	java/io/IOException
    //   121	128	167	java/io/IOException
    //   143	167	167	java/io/IOException
    //   206	254	167	java/io/IOException
    //   199	203	204	java/io/IOException
    //   12	25	257	finally
    //   37	44	257	finally
    //   47	71	257	finally
    //   72	99	257	finally
    //   108	121	257	finally
    //   121	128	257	finally
    //   143	167	257	finally
    //   168	195	257	finally
    //   206	254	257	finally
    //   272	276	277	java/io/IOException
    //   103	107	279	java/io/IOException
    //   262	266	281	java/io/IOException
    //   0	12	285	java/io/FileNotFoundException
  }
  
  private boolean sortActivitiesIfNeeded()
  {
    if ((mActivitySorter != null) && (mIntent != null) && (!mActivities.isEmpty()) && (!mHistoricalRecords.isEmpty()))
    {
      Collections.unmodifiableList(mHistoricalRecords);
      return true;
    }
    return false;
  }
  
  final boolean addHisoricalRecord(HistoricalRecord paramHistoricalRecord)
  {
    boolean bool = mHistoricalRecords.add(paramHistoricalRecord);
    Object[] arrayOfObject;
    if (bool)
    {
      mHistoricalRecordsChanged = true;
      pruneExcessiveHistoricalRecordsIfNeeded();
      if (!mReadShareHistoryCalled) {
        throw new IllegalStateException("No preceding call to #readHistoricalData");
      }
      if (mHistoricalRecordsChanged)
      {
        mHistoricalRecordsChanged = false;
        if (!TextUtils.isEmpty(mHistoryFileName))
        {
          paramHistoricalRecord = new PersistHistoryAsyncTask((byte)0);
          arrayOfObject = new Object[2];
          arrayOfObject[0] = new ArrayList(mHistoricalRecords);
          arrayOfObject[1] = mHistoryFileName;
          if (Build.VERSION.SDK_INT < 11) {
            break label127;
          }
          paramHistoricalRecord.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, arrayOfObject);
        }
      }
    }
    for (;;)
    {
      sortActivitiesIfNeeded();
      notifyChanged();
      return bool;
      label127:
      paramHistoricalRecord.execute(arrayOfObject);
    }
  }
  
  public final Intent chooseActivity(int paramInt)
  {
    synchronized (mInstanceLock)
    {
      if (mIntent == null) {
        return null;
      }
      ensureConsistentState();
      Object localObject2 = (ActivityResolveInfo)mActivities.get(paramInt);
      localObject2 = new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
      Intent localIntent = new Intent(mIntent);
      localIntent.setComponent((ComponentName)localObject2);
      if (mActivityChoserModelPolicy != null)
      {
        new Intent(localIntent);
        if (mActivityChoserModelPolicy.onChooseActivity$63493815()) {
          return null;
        }
      }
      addHisoricalRecord(new HistoricalRecord((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
      return localIntent;
    }
  }
  
  final void ensureConsistentState()
  {
    int j = 1;
    int i;
    if ((mReloadActivities) && (mIntent != null))
    {
      mReloadActivities = false;
      mActivities.clear();
      List localList = mContext.getPackageManager().queryIntentActivities(mIntent, 0);
      int k = localList.size();
      i = 0;
      while (i < k)
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i);
        mActivities.add(new ActivityResolveInfo(localResolveInfo));
        i += 1;
      }
      i = 1;
      if ((!mCanReadHistoricalData) || (!mHistoricalRecordsChanged) || (TextUtils.isEmpty(mHistoryFileName))) {
        break label167;
      }
      mCanReadHistoricalData = false;
      mReadShareHistoryCalled = true;
      readHistoricalDataImpl();
    }
    for (;;)
    {
      pruneExcessiveHistoricalRecordsIfNeeded();
      if ((i | j) != 0)
      {
        sortActivitiesIfNeeded();
        notifyChanged();
      }
      return;
      i = 0;
      break;
      label167:
      j = 0;
    }
  }
  
  public final ResolveInfo getActivity(int paramInt)
  {
    synchronized (mInstanceLock)
    {
      ensureConsistentState();
      ResolveInfo localResolveInfo = mActivities.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }
  
  public final int getActivityCount()
  {
    synchronized (mInstanceLock)
    {
      ensureConsistentState();
      int i = mActivities.size();
      return i;
    }
  }
  
  public final int getActivityIndex(ResolveInfo paramResolveInfo)
  {
    for (;;)
    {
      int i;
      synchronized (mInstanceLock)
      {
        ensureConsistentState();
        List localList = mActivities;
        int j = localList.size();
        i = 0;
        if (i < j)
        {
          if (getresolveInfo == paramResolveInfo) {
            return i;
          }
        }
        else {
          return -1;
        }
      }
      i += 1;
    }
  }
  
  public final ResolveInfo getDefaultActivity()
  {
    synchronized (mInstanceLock)
    {
      ensureConsistentState();
      if (!mActivities.isEmpty())
      {
        ResolveInfo localResolveInfo = mActivities.get(0)).resolveInfo;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  public final class ActivityResolveInfo
    implements Comparable<ActivityResolveInfo>
  {
    public final ResolveInfo resolveInfo;
    public float weight;
    
    public ActivityResolveInfo(ResolveInfo paramResolveInfo)
    {
      resolveInfo = paramResolveInfo;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (ActivityResolveInfo)paramObject;
      } while (Float.floatToIntBits(weight) == Float.floatToIntBits(weight));
      return false;
    }
    
    public final int hashCode()
    {
      return Float.floatToIntBits(weight) + 31;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("resolveInfo:").append(resolveInfo.toString());
      localStringBuilder.append("; weight:").append(new BigDecimal(weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface ActivitySorter {}
  
  public static final class HistoricalRecord
  {
    public final ComponentName activity;
    public final long time;
    public final float weight;
    
    public HistoricalRecord(ComponentName paramComponentName, long paramLong, float paramFloat)
    {
      activity = paramComponentName;
      time = paramLong;
      weight = paramFloat;
    }
    
    public HistoricalRecord(String paramString, long paramLong, float paramFloat)
    {
      this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (HistoricalRecord)paramObject;
        if (activity == null)
        {
          if (activity != null) {
            return false;
          }
        }
        else if (!activity.equals(activity)) {
          return false;
        }
        if (time != time) {
          return false;
        }
      } while (Float.floatToIntBits(weight) == Float.floatToIntBits(weight));
      return false;
    }
    
    public final int hashCode()
    {
      if (activity == null) {}
      for (int i = 0;; i = activity.hashCode()) {
        return ((i + 31) * 31 + (int)(time ^ time >>> 32)) * 31 + Float.floatToIntBits(weight);
      }
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("; activity:").append(activity);
      localStringBuilder.append("; time:").append(time);
      localStringBuilder.append("; weight:").append(new BigDecimal(weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface OnChooseActivityListener
  {
    public abstract boolean onChooseActivity$63493815();
  }
  
  private final class PersistHistoryAsyncTask
    extends AsyncTask<Object, Void, Void>
  {
    private PersistHistoryAsyncTask() {}
    
    /* Error */
    private Void doInBackground(Object... paramVarArgs)
    {
      // Byte code:
      //   0: aload_1
      //   1: iconst_0
      //   2: aaload
      //   3: checkcast 33	java/util/List
      //   6: astore 4
      //   8: aload_1
      //   9: iconst_1
      //   10: aaload
      //   11: checkcast 35	java/lang/String
      //   14: astore 5
      //   16: aload_0
      //   17: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   20: invokestatic 39	android/support/v7/widget/ActivityChooserModel:access$200	(Landroid/support/v7/widget/ActivityChooserModel;)Landroid/content/Context;
      //   23: aload 5
      //   25: iconst_0
      //   26: invokevirtual 45	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
      //   29: astore_1
      //   30: invokestatic 51	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
      //   33: astore 5
      //   35: aload 5
      //   37: aload_1
      //   38: aconst_null
      //   39: invokeinterface 57 3 0
      //   44: aload 5
      //   46: ldc 59
      //   48: iconst_1
      //   49: invokestatic 65	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   52: invokeinterface 69 3 0
      //   57: aload 5
      //   59: aconst_null
      //   60: ldc 71
      //   62: invokeinterface 75 3 0
      //   67: pop
      //   68: aload 4
      //   70: invokeinterface 79 1 0
      //   75: istore_3
      //   76: iconst_0
      //   77: istore_2
      //   78: iload_2
      //   79: iload_3
      //   80: if_icmpge +130 -> 210
      //   83: aload 4
      //   85: iconst_0
      //   86: invokeinterface 83 2 0
      //   91: checkcast 85	android/support/v7/widget/ActivityChooserModel$HistoricalRecord
      //   94: astore 6
      //   96: aload 5
      //   98: aconst_null
      //   99: ldc 87
      //   101: invokeinterface 75 3 0
      //   106: pop
      //   107: aload 5
      //   109: aconst_null
      //   110: ldc 89
      //   112: aload 6
      //   114: getfield 92	android/support/v7/widget/ActivityChooserModel$HistoricalRecord:activity	Landroid/content/ComponentName;
      //   117: invokevirtual 98	android/content/ComponentName:flattenToString	()Ljava/lang/String;
      //   120: invokeinterface 102 4 0
      //   125: pop
      //   126: aload 5
      //   128: aconst_null
      //   129: ldc 104
      //   131: aload 6
      //   133: getfield 107	android/support/v7/widget/ActivityChooserModel$HistoricalRecord:time	J
      //   136: invokestatic 110	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   139: invokeinterface 102 4 0
      //   144: pop
      //   145: aload 5
      //   147: aconst_null
      //   148: ldc 112
      //   150: aload 6
      //   152: getfield 115	android/support/v7/widget/ActivityChooserModel$HistoricalRecord:weight	F
      //   155: invokestatic 118	java/lang/String:valueOf	(F)Ljava/lang/String;
      //   158: invokeinterface 102 4 0
      //   163: pop
      //   164: aload 5
      //   166: aconst_null
      //   167: ldc 87
      //   169: invokeinterface 121 3 0
      //   174: pop
      //   175: iload_2
      //   176: iconst_1
      //   177: iadd
      //   178: istore_2
      //   179: goto -101 -> 78
      //   182: astore_1
      //   183: invokestatic 124	android/support/v7/widget/ActivityChooserModel:access$300	()Ljava/lang/String;
      //   186: new 126	java/lang/StringBuilder
      //   189: dup
      //   190: ldc -128
      //   192: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   195: aload 5
      //   197: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   200: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   203: aload_1
      //   204: invokestatic 144	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   207: pop
      //   208: aconst_null
      //   209: areturn
      //   210: aload 5
      //   212: aconst_null
      //   213: ldc 71
      //   215: invokeinterface 121 3 0
      //   220: pop
      //   221: aload 5
      //   223: invokeinterface 147 1 0
      //   228: aload_0
      //   229: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   232: invokestatic 151	android/support/v7/widget/ActivityChooserModel:access$502$59b42612	(Landroid/support/v7/widget/ActivityChooserModel;)Z
      //   235: pop
      //   236: aload_1
      //   237: ifnull +7 -> 244
      //   240: aload_1
      //   241: invokevirtual 156	java/io/FileOutputStream:close	()V
      //   244: aconst_null
      //   245: areturn
      //   246: astore 4
      //   248: invokestatic 124	android/support/v7/widget/ActivityChooserModel:access$300	()Ljava/lang/String;
      //   251: new 126	java/lang/StringBuilder
      //   254: dup
      //   255: ldc -128
      //   257: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   260: aload_0
      //   261: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   264: invokestatic 160	android/support/v7/widget/ActivityChooserModel:access$400	(Landroid/support/v7/widget/ActivityChooserModel;)Ljava/lang/String;
      //   267: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   270: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   273: aload 4
      //   275: invokestatic 144	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   278: pop
      //   279: aload_0
      //   280: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   283: invokestatic 151	android/support/v7/widget/ActivityChooserModel:access$502$59b42612	(Landroid/support/v7/widget/ActivityChooserModel;)Z
      //   286: pop
      //   287: aload_1
      //   288: ifnull -44 -> 244
      //   291: aload_1
      //   292: invokevirtual 156	java/io/FileOutputStream:close	()V
      //   295: goto -51 -> 244
      //   298: astore_1
      //   299: goto -55 -> 244
      //   302: astore 4
      //   304: invokestatic 124	android/support/v7/widget/ActivityChooserModel:access$300	()Ljava/lang/String;
      //   307: new 126	java/lang/StringBuilder
      //   310: dup
      //   311: ldc -128
      //   313: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   316: aload_0
      //   317: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   320: invokestatic 160	android/support/v7/widget/ActivityChooserModel:access$400	(Landroid/support/v7/widget/ActivityChooserModel;)Ljava/lang/String;
      //   323: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   326: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   329: aload 4
      //   331: invokestatic 144	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   334: pop
      //   335: aload_0
      //   336: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   339: invokestatic 151	android/support/v7/widget/ActivityChooserModel:access$502$59b42612	(Landroid/support/v7/widget/ActivityChooserModel;)Z
      //   342: pop
      //   343: aload_1
      //   344: ifnull -100 -> 244
      //   347: aload_1
      //   348: invokevirtual 156	java/io/FileOutputStream:close	()V
      //   351: goto -107 -> 244
      //   354: astore_1
      //   355: goto -111 -> 244
      //   358: astore 4
      //   360: invokestatic 124	android/support/v7/widget/ActivityChooserModel:access$300	()Ljava/lang/String;
      //   363: new 126	java/lang/StringBuilder
      //   366: dup
      //   367: ldc -128
      //   369: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   372: aload_0
      //   373: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   376: invokestatic 160	android/support/v7/widget/ActivityChooserModel:access$400	(Landroid/support/v7/widget/ActivityChooserModel;)Ljava/lang/String;
      //   379: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   382: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   385: aload 4
      //   387: invokestatic 144	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   390: pop
      //   391: aload_0
      //   392: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   395: invokestatic 151	android/support/v7/widget/ActivityChooserModel:access$502$59b42612	(Landroid/support/v7/widget/ActivityChooserModel;)Z
      //   398: pop
      //   399: aload_1
      //   400: ifnull -156 -> 244
      //   403: aload_1
      //   404: invokevirtual 156	java/io/FileOutputStream:close	()V
      //   407: goto -163 -> 244
      //   410: astore_1
      //   411: goto -167 -> 244
      //   414: astore 4
      //   416: aload_0
      //   417: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   420: invokestatic 151	android/support/v7/widget/ActivityChooserModel:access$502$59b42612	(Landroid/support/v7/widget/ActivityChooserModel;)Z
      //   423: pop
      //   424: aload_1
      //   425: ifnull +7 -> 432
      //   428: aload_1
      //   429: invokevirtual 156	java/io/FileOutputStream:close	()V
      //   432: aload 4
      //   434: athrow
      //   435: astore_1
      //   436: goto -192 -> 244
      //   439: astore_1
      //   440: goto -8 -> 432
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	443	0	this	PersistHistoryAsyncTask
      //   0	443	1	paramVarArgs	Object[]
      //   77	102	2	i	int
      //   75	6	3	j	int
      //   6	78	4	localList	List
      //   246	28	4	localIllegalArgumentException	IllegalArgumentException
      //   302	28	4	localIllegalStateException	IllegalStateException
      //   358	28	4	localIOException	java.io.IOException
      //   414	19	4	localObject1	Object
      //   14	208	5	localObject2	Object
      //   94	57	6	localHistoricalRecord	ActivityChooserModel.HistoricalRecord
      // Exception table:
      //   from	to	target	type
      //   16	30	182	java/io/FileNotFoundException
      //   35	76	246	java/lang/IllegalArgumentException
      //   83	175	246	java/lang/IllegalArgumentException
      //   210	228	246	java/lang/IllegalArgumentException
      //   291	295	298	java/io/IOException
      //   35	76	302	java/lang/IllegalStateException
      //   83	175	302	java/lang/IllegalStateException
      //   210	228	302	java/lang/IllegalStateException
      //   347	351	354	java/io/IOException
      //   35	76	358	java/io/IOException
      //   83	175	358	java/io/IOException
      //   210	228	358	java/io/IOException
      //   403	407	410	java/io/IOException
      //   35	76	414	finally
      //   83	175	414	finally
      //   210	228	414	finally
      //   248	279	414	finally
      //   304	335	414	finally
      //   360	391	414	finally
      //   240	244	435	java/io/IOException
      //   428	432	439	java/io/IOException
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActivityChooserModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */