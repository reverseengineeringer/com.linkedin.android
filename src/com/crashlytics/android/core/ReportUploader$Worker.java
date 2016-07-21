package com.crashlytics.android.core;

import io.fabric.sdk.android.services.common.BackgroundPriorityRunnable;

final class ReportUploader$Worker
  extends BackgroundPriorityRunnable
{
  private final float delay;
  
  ReportUploader$Worker(ReportUploader paramReportUploader, float paramFloat)
  {
    delay = paramFloat;
  }
  
  /* Error */
  public final void onRun()
  {
    // Byte code:
    //   0: invokestatic 32	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   3: ldc 34
    //   5: new 36	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 38
    //   11: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 20	com/crashlytics/android/core/ReportUploader$Worker:delay	F
    //   18: invokevirtual 45	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   21: ldc 47
    //   23: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokeinterface 60 3 0
    //   34: aload_0
    //   35: getfield 20	com/crashlytics/android/core/ReportUploader$Worker:delay	F
    //   38: fstore_1
    //   39: fload_1
    //   40: fconst_0
    //   41: fcmpl
    //   42: ifle +14 -> 56
    //   45: aload_0
    //   46: getfield 20	com/crashlytics/android/core/ReportUploader$Worker:delay	F
    //   49: ldc 61
    //   51: fmul
    //   52: f2l
    //   53: invokestatic 67	java/lang/Thread:sleep	(J)V
    //   56: invokestatic 73	com/crashlytics/android/core/CrashlyticsCore:getInstance	()Lcom/crashlytics/android/core/CrashlyticsCore;
    //   59: astore 6
    //   61: aload 6
    //   63: getfield 77	com/crashlytics/android/core/CrashlyticsCore:handler	Lcom/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler;
    //   66: astore 7
    //   68: aload_0
    //   69: getfield 15	com/crashlytics/android/core/ReportUploader$Worker:this$0	Lcom/crashlytics/android/core/ReportUploader;
    //   72: invokevirtual 81	com/crashlytics/android/core/ReportUploader:findReports	()Ljava/util/List;
    //   75: astore 5
    //   77: aload 7
    //   79: getfield 87	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   82: invokevirtual 93	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   85: ifne +132 -> 217
    //   88: aload 5
    //   90: invokeinterface 98 1 0
    //   95: ifne +343 -> 438
    //   98: invokestatic 104	io/fabric/sdk/android/services/settings/Settings$LazyHolder:access$100	()Lio/fabric/sdk/android/services/settings/Settings;
    //   101: new 106	com/crashlytics/android/core/CrashlyticsCore$6
    //   104: dup
    //   105: aload 6
    //   107: invokespecial 109	com/crashlytics/android/core/CrashlyticsCore$6:<init>	(Lcom/crashlytics/android/core/CrashlyticsCore;)V
    //   110: iconst_1
    //   111: invokestatic 115	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   114: invokevirtual 121	io/fabric/sdk/android/services/settings/Settings:withSettings	(Lio/fabric/sdk/android/services/settings/Settings$SettingsAccess;Ljava/lang/Object;)Ljava/lang/Object;
    //   117: checkcast 111	java/lang/Boolean
    //   120: invokevirtual 124	java/lang/Boolean:booleanValue	()Z
    //   123: ifne +315 -> 438
    //   126: invokestatic 32	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   129: ldc 34
    //   131: new 36	java/lang/StringBuilder
    //   134: dup
    //   135: ldc 126
    //   137: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: aload 5
    //   142: invokeinterface 130 1 0
    //   147: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: ldc -121
    //   152: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokeinterface 60 3 0
    //   163: aload 5
    //   165: invokeinterface 139 1 0
    //   170: astore 5
    //   172: aload 5
    //   174: invokeinterface 144 1 0
    //   179: ifeq +38 -> 217
    //   182: aload 5
    //   184: invokeinterface 148 1 0
    //   189: checkcast 150	com/crashlytics/android/core/Report
    //   192: invokeinterface 153 1 0
    //   197: pop
    //   198: goto -26 -> 172
    //   201: astore 5
    //   203: invokestatic 32	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   206: ldc 34
    //   208: ldc -101
    //   210: aload 5
    //   212: invokeinterface 159 4 0
    //   217: aload_0
    //   218: getfield 15	com/crashlytics/android/core/ReportUploader$Worker:this$0	Lcom/crashlytics/android/core/ReportUploader;
    //   221: invokestatic 163	com/crashlytics/android/core/ReportUploader:access$002$25c4ddf8	(Lcom/crashlytics/android/core/ReportUploader;)Ljava/lang/Thread;
    //   224: pop
    //   225: return
    //   226: astore 5
    //   228: invokestatic 167	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   231: invokevirtual 170	java/lang/Thread:interrupt	()V
    //   234: goto -17 -> 217
    //   237: aload 5
    //   239: invokeinterface 98 1 0
    //   244: ifne -27 -> 217
    //   247: invokestatic 73	com/crashlytics/android/core/CrashlyticsCore:getInstance	()Lcom/crashlytics/android/core/CrashlyticsCore;
    //   250: getfield 77	com/crashlytics/android/core/CrashlyticsCore:handler	Lcom/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler;
    //   253: getfield 87	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   256: invokevirtual 93	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   259: ifne -42 -> 217
    //   262: invokestatic 32	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   265: ldc 34
    //   267: new 36	java/lang/StringBuilder
    //   270: dup
    //   271: ldc -84
    //   273: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   276: aload 5
    //   278: invokeinterface 130 1 0
    //   283: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: ldc -82
    //   288: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokeinterface 60 3 0
    //   299: aload 5
    //   301: invokeinterface 139 1 0
    //   306: astore 5
    //   308: aload 5
    //   310: invokeinterface 144 1 0
    //   315: ifeq +28 -> 343
    //   318: aload 5
    //   320: invokeinterface 148 1 0
    //   325: checkcast 150	com/crashlytics/android/core/Report
    //   328: astore 6
    //   330: aload_0
    //   331: getfield 15	com/crashlytics/android/core/ReportUploader$Worker:this$0	Lcom/crashlytics/android/core/ReportUploader;
    //   334: aload 6
    //   336: invokevirtual 178	com/crashlytics/android/core/ReportUploader:forceUpload	(Lcom/crashlytics/android/core/Report;)Z
    //   339: pop
    //   340: goto -32 -> 308
    //   343: aload_0
    //   344: getfield 15	com/crashlytics/android/core/ReportUploader$Worker:this$0	Lcom/crashlytics/android/core/ReportUploader;
    //   347: invokevirtual 81	com/crashlytics/android/core/ReportUploader:findReports	()Ljava/util/List;
    //   350: astore 5
    //   352: aload 5
    //   354: invokeinterface 98 1 0
    //   359: ifne +76 -> 435
    //   362: invokestatic 181	com/crashlytics/android/core/ReportUploader:access$100	()[S
    //   365: iload_2
    //   366: invokestatic 181	com/crashlytics/android/core/ReportUploader:access$100	()[S
    //   369: arraylength
    //   370: iconst_1
    //   371: isub
    //   372: invokestatic 187	java/lang/Math:min	(II)I
    //   375: saload
    //   376: i2l
    //   377: lstore_3
    //   378: invokestatic 32	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   381: ldc 34
    //   383: new 36	java/lang/StringBuilder
    //   386: dup
    //   387: ldc -67
    //   389: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   392: lload_3
    //   393: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   396: ldc -62
    //   398: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokeinterface 60 3 0
    //   409: lload_3
    //   410: ldc2_w 195
    //   413: lmul
    //   414: invokestatic 67	java/lang/Thread:sleep	(J)V
    //   417: iload_2
    //   418: iconst_1
    //   419: iadd
    //   420: istore_2
    //   421: goto -184 -> 237
    //   424: astore 5
    //   426: invokestatic 167	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   429: invokevirtual 170	java/lang/Thread:interrupt	()V
    //   432: goto -215 -> 217
    //   435: goto -198 -> 237
    //   438: iconst_0
    //   439: istore_2
    //   440: goto -203 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	Worker
    //   38	2	1	f	float
    //   365	75	2	i	int
    //   377	33	3	l	long
    //   75	108	5	localObject1	Object
    //   201	10	5	localException	Exception
    //   226	74	5	localInterruptedException1	InterruptedException
    //   306	47	5	localObject2	Object
    //   424	1	5	localInterruptedException2	InterruptedException
    //   59	276	6	localObject3	Object
    //   66	12	7	localCrashlyticsUncaughtExceptionHandler	CrashlyticsUncaughtExceptionHandler
    // Exception table:
    //   from	to	target	type
    //   0	39	201	java/lang/Exception
    //   45	56	201	java/lang/Exception
    //   56	172	201	java/lang/Exception
    //   172	198	201	java/lang/Exception
    //   228	234	201	java/lang/Exception
    //   237	308	201	java/lang/Exception
    //   308	340	201	java/lang/Exception
    //   343	409	201	java/lang/Exception
    //   409	417	201	java/lang/Exception
    //   426	432	201	java/lang/Exception
    //   45	56	226	java/lang/InterruptedException
    //   409	417	424	java/lang/InterruptedException
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.ReportUploader.Worker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */