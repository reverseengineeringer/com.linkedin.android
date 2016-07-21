package org.acra.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import org.acra.ACRA;
import org.acra.log.ACRALog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JSONReportBuilder
{
  private static void addJSONSubTree(JSONObject paramJSONObject, String[] paramArrayOfString, Object paramObject)
    throws JSONException
  {
    int i = 0;
    JSONObject localJSONObject = paramJSONObject;
    Object localObject2;
    Object localObject1;
    if (i < paramArrayOfString.length)
    {
      localObject2 = paramArrayOfString[i];
      if (i >= paramArrayOfString.length - 1) {
        break label175;
      }
      localObject1 = null;
      paramJSONObject = null;
      if (localJSONObject.isNull((String)localObject2))
      {
        paramJSONObject = new JSONObject();
        localJSONObject.accumulate((String)localObject2, paramJSONObject);
        localJSONObject = paramJSONObject;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      Object localObject3 = localJSONObject.get((String)localObject2);
      if ((localObject3 instanceof JSONObject)) {
        paramJSONObject = localJSONObject.getJSONObject((String)localObject2);
      }
      label173:
      for (;;)
      {
        localJSONObject = paramJSONObject;
        if (paramJSONObject != null) {
          break;
        }
        ACRA.log.e(ACRA.LOG_TAG, "Unknown json subtree type, see issue #186");
        return;
        if ((localObject3 instanceof JSONArray))
        {
          localObject2 = localJSONObject.getJSONArray((String)localObject2);
          int j = 0;
          for (paramJSONObject = (JSONObject)localObject1;; paramJSONObject = localJSONObject)
          {
            if (j >= ((JSONArray)localObject2).length()) {
              break label173;
            }
            localJSONObject = ((JSONArray)localObject2).optJSONObject(j);
            paramJSONObject = localJSONObject;
            if (localJSONObject != null) {
              break;
            }
            j += 1;
          }
        }
      }
      label175:
      localJSONObject.accumulate((String)localObject2, paramObject);
    }
  }
  
  /* Error */
  public static JSONObject buildJSONReport(org.acra.collector.CrashReportData paramCrashReportData)
    throws JSONReportBuilder.JSONReportException
  {
    // Byte code:
    //   0: new 18	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 23	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_2
    //   11: aload_0
    //   12: invokevirtual 78	org/acra/collector/CrashReportData:keySet	()Ljava/util/Set;
    //   15: invokeinterface 84 1 0
    //   20: astore 7
    //   22: aload 7
    //   24: invokeinterface 90 1 0
    //   29: ifeq +326 -> 355
    //   32: aload 7
    //   34: invokeinterface 94 1 0
    //   39: checkcast 96	org/acra/ReportField
    //   42: astore 5
    //   44: aload_2
    //   45: astore 4
    //   47: aload 5
    //   49: invokevirtual 99	org/acra/ReportField:containsKeyValuePairs	()Z
    //   52: ifeq +273 -> 325
    //   55: aload_2
    //   56: astore 4
    //   58: new 18	org/json/JSONObject
    //   61: dup
    //   62: invokespecial 23	org/json/JSONObject:<init>	()V
    //   65: astore 8
    //   67: aload_2
    //   68: astore 4
    //   70: new 101	java/io/BufferedReader
    //   73: dup
    //   74: new 103	java/io/StringReader
    //   77: dup
    //   78: aload_0
    //   79: aload 5
    //   81: invokevirtual 107	org/acra/collector/CrashReportData:getProperty	(Lorg/acra/ReportField;)Ljava/lang/String;
    //   84: invokespecial 110	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   87: sipush 1024
    //   90: invokespecial 113	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual 117	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore_2
    //   99: aload_2
    //   100: ifnull +130 -> 230
    //   103: aload_2
    //   104: bipush 61
    //   106: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   109: istore_1
    //   110: iload_1
    //   111: ifle +193 -> 304
    //   114: aload_2
    //   115: iconst_0
    //   116: iload_1
    //   117: invokevirtual 127	java/lang/String:substring	(II)Ljava/lang/String;
    //   120: invokevirtual 130	java/lang/String:trim	()Ljava/lang/String;
    //   123: astore 9
    //   125: aload_2
    //   126: iload_1
    //   127: iconst_1
    //   128: iadd
    //   129: invokevirtual 133	java/lang/String:substring	(I)Ljava/lang/String;
    //   132: invokevirtual 130	java/lang/String:trim	()Ljava/lang/String;
    //   135: invokestatic 136	org/acra/util/JSONReportBuilder:guessType	(Ljava/lang/String;)Ljava/lang/Object;
    //   138: astore 4
    //   140: aload 4
    //   142: astore_2
    //   143: aload 4
    //   145: instanceof 119
    //   148: ifeq +16 -> 164
    //   151: aload 4
    //   153: checkcast 119	java/lang/String
    //   156: ldc -118
    //   158: ldc -116
    //   160: invokevirtual 144	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   163: astore_2
    //   164: aload 9
    //   166: ldc -110
    //   168: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   171: astore 4
    //   173: aload 4
    //   175: arraylength
    //   176: iconst_1
    //   177: if_icmple +75 -> 252
    //   180: aload 8
    //   182: aload 4
    //   184: aload_2
    //   185: invokestatic 152	org/acra/util/JSONReportBuilder:addJSONSubTree	(Lorg/json/JSONObject;[Ljava/lang/String;Ljava/lang/Object;)V
    //   188: goto -94 -> 94
    //   191: astore_2
    //   192: getstatic 41	org/acra/ACRA:log	Lorg/acra/log/ACRALog;
    //   195: getstatic 45	org/acra/ACRA:LOG_TAG	Ljava/lang/String;
    //   198: new 154	java/lang/StringBuilder
    //   201: dup
    //   202: ldc -100
    //   204: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   207: aload 5
    //   209: invokevirtual 160	org/acra/ReportField:name	()Ljava/lang/String;
    //   212: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc -90
    //   217: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: aload_2
    //   224: invokeinterface 172 4 0
    //   229: pop
    //   230: aload 6
    //   232: aload 5
    //   234: invokevirtual 160	org/acra/ReportField:name	()Ljava/lang/String;
    //   237: aload 8
    //   239: invokevirtual 27	org/json/JSONObject:accumulate	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   242: pop
    //   243: aload_3
    //   244: astore_2
    //   245: aload_2
    //   246: invokestatic 178	org/acra/collector/CollectorUtil:safeClose	(Ljava/io/Reader;)V
    //   249: goto -227 -> 22
    //   252: aload 8
    //   254: aload 9
    //   256: aload_2
    //   257: invokevirtual 27	org/json/JSONObject:accumulate	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   260: pop
    //   261: goto -167 -> 94
    //   264: astore_0
    //   265: aload_3
    //   266: astore_2
    //   267: aload_2
    //   268: astore 4
    //   270: new 6	org/acra/util/JSONReportBuilder$JSONReportException
    //   273: dup
    //   274: new 154	java/lang/StringBuilder
    //   277: dup
    //   278: ldc -76
    //   280: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload 5
    //   285: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: aload_0
    //   292: invokespecial 186	org/acra/util/JSONReportBuilder$JSONReportException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   295: athrow
    //   296: astore_0
    //   297: aload 4
    //   299: invokestatic 178	org/acra/collector/CollectorUtil:safeClose	(Ljava/io/Reader;)V
    //   302: aload_0
    //   303: athrow
    //   304: aload 8
    //   306: aload_2
    //   307: invokevirtual 130	java/lang/String:trim	()Ljava/lang/String;
    //   310: iconst_1
    //   311: invokevirtual 190	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   314: pop
    //   315: goto -221 -> 94
    //   318: astore_0
    //   319: aload_3
    //   320: astore 4
    //   322: goto -25 -> 297
    //   325: aload_2
    //   326: astore 4
    //   328: aload 6
    //   330: aload 5
    //   332: invokevirtual 160	org/acra/ReportField:name	()Ljava/lang/String;
    //   335: aload_0
    //   336: aload 5
    //   338: invokevirtual 107	org/acra/collector/CrashReportData:getProperty	(Lorg/acra/ReportField;)Ljava/lang/String;
    //   341: invokestatic 136	org/acra/util/JSONReportBuilder:guessType	(Ljava/lang/String;)Ljava/lang/Object;
    //   344: invokevirtual 27	org/json/JSONObject:accumulate	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   347: pop
    //   348: goto -103 -> 245
    //   351: astore_0
    //   352: goto -85 -> 267
    //   355: aload 6
    //   357: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramCrashReportData	org.acra.collector.CrashReportData
    //   109	20	1	i	int
    //   10	175	2	localObject1	Object
    //   191	33	2	localIOException	java.io.IOException
    //   244	82	2	localObject2	Object
    //   93	227	3	localBufferedReader	java.io.BufferedReader
    //   45	282	4	localObject3	Object
    //   42	295	5	localReportField	org.acra.ReportField
    //   7	349	6	localJSONObject1	JSONObject
    //   20	13	7	localIterator	java.util.Iterator
    //   65	240	8	localJSONObject2	JSONObject
    //   123	132	9	str	String
    // Exception table:
    //   from	to	target	type
    //   94	99	191	java/io/IOException
    //   103	110	191	java/io/IOException
    //   114	140	191	java/io/IOException
    //   143	164	191	java/io/IOException
    //   164	188	191	java/io/IOException
    //   252	261	191	java/io/IOException
    //   304	315	191	java/io/IOException
    //   94	99	264	org/json/JSONException
    //   103	110	264	org/json/JSONException
    //   114	140	264	org/json/JSONException
    //   143	164	264	org/json/JSONException
    //   164	188	264	org/json/JSONException
    //   192	230	264	org/json/JSONException
    //   230	243	264	org/json/JSONException
    //   252	261	264	org/json/JSONException
    //   304	315	264	org/json/JSONException
    //   47	55	296	finally
    //   58	67	296	finally
    //   70	94	296	finally
    //   270	296	296	finally
    //   328	348	296	finally
    //   94	99	318	finally
    //   103	110	318	finally
    //   114	140	318	finally
    //   143	164	318	finally
    //   164	188	318	finally
    //   192	230	318	finally
    //   230	243	318	finally
    //   252	261	318	finally
    //   304	315	318	finally
    //   47	55	351	org/json/JSONException
    //   58	67	351	org/json/JSONException
    //   70	94	351	org/json/JSONException
    //   328	348	351	org/json/JSONException
  }
  
  private static Object guessType(String paramString)
  {
    if (paramString.equalsIgnoreCase("true")) {
      localObject = Boolean.valueOf(true);
    }
    do
    {
      return localObject;
      if (paramString.equalsIgnoreCase("false")) {
        return Boolean.valueOf(false);
      }
      localObject = paramString;
    } while (!paramString.matches("(?:^|\\s)([1-9](?:\\d*|(?:\\d{0,2})(?:,\\d{3})*)(?:\\.\\d*[1-9])?|0?\\.\\d*[1-9]|0)(?:\\s|$)"));
    Object localObject = NumberFormat.getInstance(Locale.US);
    try
    {
      localObject = ((NumberFormat)localObject).parse(paramString);
      return localObject;
    }
    catch (ParseException localParseException) {}
    return paramString;
  }
  
  public static final class JSONReportException
    extends Exception
  {
    public JSONReportException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     org.acra.util.JSONReportBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */