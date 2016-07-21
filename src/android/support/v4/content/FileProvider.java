package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class FileProvider
  extends ContentProvider
{
  private static final String[] COLUMNS = { "_display_name", "_size" };
  private static final File DEVICE_ROOT = new File("/");
  private static HashMap<String, PathStrategy> sCache = new HashMap();
  private PathStrategy mStrategy;
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int i = 0;
    if (i <= 0)
    {
      String str = paramVarArgs[0];
      if (str == null) {
        break label33;
      }
      paramFile = new File(paramFile, str);
    }
    label33:
    for (;;)
    {
      i += 1;
      break;
      return paramFile;
    }
  }
  
  /* Error */
  private static PathStrategy getPathStrategy(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 45	android/support/v4/content/FileProvider:sCache	Ljava/util/HashMap;
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: getstatic 45	android/support/v4/content/FileProvider:sCache	Ljava/util/HashMap;
    //   11: aload_1
    //   12: invokevirtual 62	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 6	android/support/v4/content/FileProvider$PathStrategy
    //   18: astore 4
    //   20: aload 4
    //   22: astore_3
    //   23: aload 4
    //   25: ifnonnull +321 -> 346
    //   28: new 9	android/support/v4/content/FileProvider$SimplePathStrategy
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 63	android/support/v4/content/FileProvider$SimplePathStrategy:<init>	(Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload_0
    //   39: invokevirtual 69	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   42: aload_1
    //   43: sipush 128
    //   46: invokevirtual 75	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   49: aload_0
    //   50: invokevirtual 69	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   53: ldc 77
    //   55: invokevirtual 83	android/content/pm/ProviderInfo:loadXmlMetaData	(Landroid/content/pm/PackageManager;Ljava/lang/String;)Landroid/content/res/XmlResourceParser;
    //   58: astore 6
    //   60: aload 6
    //   62: ifnonnull +50 -> 112
    //   65: new 85	java/lang/IllegalArgumentException
    //   68: dup
    //   69: ldc 87
    //   71: invokespecial 88	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: astore_0
    //   76: new 85	java/lang/IllegalArgumentException
    //   79: dup
    //   80: ldc 90
    //   82: aload_0
    //   83: invokespecial 93	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: astore_0
    //   88: aload 5
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    //   93: aload_3
    //   94: invokevirtual 97	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   97: astore 8
    //   99: aload 4
    //   101: getfield 100	android/support/v4/content/FileProvider$SimplePathStrategy:mRoots	Ljava/util/HashMap;
    //   104: aload 7
    //   106: aload 8
    //   108: invokevirtual 104	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: pop
    //   112: aload 6
    //   114: invokeinterface 110 1 0
    //   119: istore_2
    //   120: iload_2
    //   121: iconst_1
    //   122: if_icmpeq +211 -> 333
    //   125: iload_2
    //   126: iconst_2
    //   127: if_icmpne -15 -> 112
    //   130: aload 6
    //   132: invokeinterface 114 1 0
    //   137: astore_3
    //   138: aload 6
    //   140: aconst_null
    //   141: ldc 116
    //   143: invokeinterface 120 3 0
    //   148: astore 7
    //   150: aload 6
    //   152: aconst_null
    //   153: ldc 122
    //   155: invokeinterface 120 3 0
    //   160: astore 8
    //   162: ldc 124
    //   164: aload_3
    //   165: invokevirtual 128	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifeq +53 -> 221
    //   171: getstatic 39	android/support/v4/content/FileProvider:DEVICE_ROOT	Ljava/io/File;
    //   174: iconst_1
    //   175: anewarray 23	java/lang/String
    //   178: dup
    //   179: iconst_0
    //   180: aload 8
    //   182: aastore
    //   183: invokestatic 130	android/support/v4/content/FileProvider:buildPath	(Ljava/io/File;[Ljava/lang/String;)Ljava/io/File;
    //   186: astore_3
    //   187: aload_3
    //   188: ifnull -76 -> 112
    //   191: aload 7
    //   193: invokestatic 136	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifeq -103 -> 93
    //   199: new 85	java/lang/IllegalArgumentException
    //   202: dup
    //   203: ldc -118
    //   205: invokespecial 88	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   208: athrow
    //   209: astore_0
    //   210: new 85	java/lang/IllegalArgumentException
    //   213: dup
    //   214: ldc 90
    //   216: aload_0
    //   217: invokespecial 93	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   220: athrow
    //   221: ldc -116
    //   223: aload_3
    //   224: invokevirtual 128	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   227: ifeq +23 -> 250
    //   230: aload_0
    //   231: invokevirtual 143	android/content/Context:getFilesDir	()Ljava/io/File;
    //   234: iconst_1
    //   235: anewarray 23	java/lang/String
    //   238: dup
    //   239: iconst_0
    //   240: aload 8
    //   242: aastore
    //   243: invokestatic 130	android/support/v4/content/FileProvider:buildPath	(Ljava/io/File;[Ljava/lang/String;)Ljava/io/File;
    //   246: astore_3
    //   247: goto -60 -> 187
    //   250: ldc -111
    //   252: aload_3
    //   253: invokevirtual 128	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   256: ifeq +23 -> 279
    //   259: aload_0
    //   260: invokevirtual 148	android/content/Context:getCacheDir	()Ljava/io/File;
    //   263: iconst_1
    //   264: anewarray 23	java/lang/String
    //   267: dup
    //   268: iconst_0
    //   269: aload 8
    //   271: aastore
    //   272: invokestatic 130	android/support/v4/content/FileProvider:buildPath	(Ljava/io/File;[Ljava/lang/String;)Ljava/io/File;
    //   275: astore_3
    //   276: goto -89 -> 187
    //   279: ldc -106
    //   281: aload_3
    //   282: invokevirtual 128	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   285: ifeq +66 -> 351
    //   288: invokestatic 155	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   291: iconst_1
    //   292: anewarray 23	java/lang/String
    //   295: dup
    //   296: iconst_0
    //   297: aload 8
    //   299: aastore
    //   300: invokestatic 130	android/support/v4/content/FileProvider:buildPath	(Ljava/io/File;[Ljava/lang/String;)Ljava/io/File;
    //   303: astore_3
    //   304: goto -117 -> 187
    //   307: astore_0
    //   308: new 85	java/lang/IllegalArgumentException
    //   311: dup
    //   312: new 157	java/lang/StringBuilder
    //   315: dup
    //   316: ldc -97
    //   318: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   321: aload_3
    //   322: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: aload_0
    //   329: invokespecial 93	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   332: athrow
    //   333: getstatic 45	android/support/v4/content/FileProvider:sCache	Ljava/util/HashMap;
    //   336: aload_1
    //   337: aload 4
    //   339: invokevirtual 104	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   342: pop
    //   343: aload 4
    //   345: astore_3
    //   346: aload 5
    //   348: monitorexit
    //   349: aload_3
    //   350: areturn
    //   351: aconst_null
    //   352: astore_3
    //   353: goto -166 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramContext	Context
    //   0	356	1	paramString	String
    //   119	9	2	i	int
    //   22	331	3	localObject1	Object
    //   18	326	4	localObject2	Object
    //   3	344	5	localHashMap	HashMap
    //   58	93	6	localXmlResourceParser	android.content.res.XmlResourceParser
    //   104	88	7	localObject3	Object
    //   97	201	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   28	60	75	java/io/IOException
    //   65	75	75	java/io/IOException
    //   99	112	75	java/io/IOException
    //   112	120	75	java/io/IOException
    //   130	187	75	java/io/IOException
    //   191	209	75	java/io/IOException
    //   221	247	75	java/io/IOException
    //   250	276	75	java/io/IOException
    //   279	304	75	java/io/IOException
    //   308	333	75	java/io/IOException
    //   8	20	87	finally
    //   28	60	87	finally
    //   65	75	87	finally
    //   76	87	87	finally
    //   88	91	87	finally
    //   93	99	87	finally
    //   99	112	87	finally
    //   112	120	87	finally
    //   130	187	87	finally
    //   191	209	87	finally
    //   210	221	87	finally
    //   221	247	87	finally
    //   250	276	87	finally
    //   279	304	87	finally
    //   308	333	87	finally
    //   333	343	87	finally
    //   346	349	87	finally
    //   28	60	209	org/xmlpull/v1/XmlPullParserException
    //   65	75	209	org/xmlpull/v1/XmlPullParserException
    //   93	99	209	org/xmlpull/v1/XmlPullParserException
    //   99	112	209	org/xmlpull/v1/XmlPullParserException
    //   112	120	209	org/xmlpull/v1/XmlPullParserException
    //   130	187	209	org/xmlpull/v1/XmlPullParserException
    //   191	209	209	org/xmlpull/v1/XmlPullParserException
    //   221	247	209	org/xmlpull/v1/XmlPullParserException
    //   250	276	209	org/xmlpull/v1/XmlPullParserException
    //   279	304	209	org/xmlpull/v1/XmlPullParserException
    //   308	333	209	org/xmlpull/v1/XmlPullParserException
    //   93	99	307	java/io/IOException
  }
  
  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile)
  {
    return getPathStrategy(paramContext, paramString).getUriForFile(paramFile);
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (exported) {
      throw new SecurityException("Provider must not be exported");
    }
    if (!grantUriPermissions) {
      throw new SecurityException("Provider must grant uri permissions");
    }
    mStrategy = getPathStrategy(paramContext, authority);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (mStrategy.getFileForUri(paramUri).delete()) {
      return 1;
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    paramUri = mStrategy.getFileForUri(paramUri);
    int i = paramUri.getName().lastIndexOf('.');
    if (i >= 0)
    {
      paramUri = paramUri.getName().substring(i + 1);
      paramUri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
      if (paramUri != null) {
        return paramUri;
      }
    }
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
    throws FileNotFoundException
  {
    paramUri = mStrategy.getFileForUri(paramUri);
    int i;
    if ("r".equals(paramString)) {
      i = 268435456;
    }
    for (;;)
    {
      return ParcelFileDescriptor.open(paramUri, i);
      if (("w".equals(paramString)) || ("wt".equals(paramString)))
      {
        i = 738197504;
      }
      else if ("wa".equals(paramString))
      {
        i = 704643072;
      }
      else if ("rw".equals(paramString))
      {
        i = 939524096;
      }
      else
      {
        if (!"rwt".equals(paramString)) {
          break;
        }
        i = 1006632960;
      }
    }
    throw new IllegalArgumentException("Invalid mode: " + paramString);
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = mStrategy.getFileForUri(paramUri);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = COLUMNS;
    }
    paramArrayOfString2 = new String[paramUri.length];
    paramArrayOfString1 = new Object[paramUri.length];
    int m = paramUri.length;
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      paramString2 = paramUri[j];
      if ("_display_name".equals(paramString2))
      {
        paramArrayOfString2[i] = "_display_name";
        k = i + 1;
        paramArrayOfString1[i] = paramString1.getName();
        i = k;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if ("_size".equals(paramString2))
      {
        paramArrayOfString2[i] = "_size";
        k = i + 1;
        paramArrayOfString1[i] = Long.valueOf(paramString1.length());
        i = k;
        continue;
        paramUri = new String[i];
        System.arraycopy(paramArrayOfString2, 0, paramUri, 0, i);
        paramString1 = new Object[i];
        System.arraycopy(paramArrayOfString1, 0, paramString1, 0, i);
        paramUri = new MatrixCursor(paramUri, 1);
        paramUri.addRow(paramString1);
        return paramUri;
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
  
  static abstract interface PathStrategy
  {
    public abstract File getFileForUri(Uri paramUri);
    
    public abstract Uri getUriForFile(File paramFile);
  }
  
  static final class SimplePathStrategy
    implements FileProvider.PathStrategy
  {
    private final String mAuthority;
    final HashMap<String, File> mRoots = new HashMap();
    
    public SimplePathStrategy(String paramString)
    {
      mAuthority = paramString;
    }
    
    public final File getFileForUri(Uri paramUri)
    {
      Object localObject2 = paramUri.getEncodedPath();
      int i = ((String)localObject2).indexOf('/', 1);
      Object localObject1 = Uri.decode(((String)localObject2).substring(1, i));
      localObject2 = Uri.decode(((String)localObject2).substring(i + 1));
      localObject1 = (File)mRoots.get(localObject1);
      if (localObject1 == null) {
        throw new IllegalArgumentException("Unable to find configured root for " + paramUri);
      }
      paramUri = new File((File)localObject1, (String)localObject2);
      try
      {
        localObject2 = paramUri.getCanonicalFile();
        if (!((File)localObject2).getPath().startsWith(((File)localObject1).getPath())) {
          throw new SecurityException("Resolved path jumped beyond configured root");
        }
      }
      catch (IOException localIOException)
      {
        throw new IllegalArgumentException("Failed to resolve canonical path for " + paramUri);
      }
      return (File)localObject2;
    }
    
    public final Uri getUriForFile(File paramFile)
    {
      String str2;
      try
      {
        str2 = paramFile.getCanonicalPath();
        paramFile = null;
        Iterator localIterator = mRoots.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str3 = ((File)localEntry.getValue()).getPath();
          if ((str2.startsWith(str3)) && ((paramFile == null) || (str3.length() > ((File)paramFile.getValue()).getPath().length()))) {
            paramFile = localEntry;
          }
        }
        if (paramFile != null) {
          break label150;
        }
      }
      catch (IOException localIOException)
      {
        throw new IllegalArgumentException("Failed to resolve canonical path for " + paramFile);
      }
      throw new IllegalArgumentException("Failed to find configured root that contains " + str2);
      label150:
      String str1 = ((File)paramFile.getValue()).getPath();
      if (str1.endsWith("/")) {}
      for (str1 = str2.substring(str1.length());; str1 = str2.substring(str1.length() + 1))
      {
        paramFile = Uri.encode((String)paramFile.getKey()) + '/' + Uri.encode(str1, "/");
        return new Uri.Builder().scheme("content").authority(mAuthority).encodedPath(paramFile).build();
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.FileProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */