package android.support.v7.widget;

import android.os.AsyncTask;

final class ActivityChooserModel$PersistHistoryAsyncTask
  extends AsyncTask<Object, Void, Void>
{
  private ActivityChooserModel$PersistHistoryAsyncTask(ActivityChooserModel paramActivityChooserModel) {}
  
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
    //   6	78	4	localList	java.util.List
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

/* Location:
 * Qualified Name:     android.support.v7.widget.ActivityChooserModel.PersistHistoryAsyncTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */