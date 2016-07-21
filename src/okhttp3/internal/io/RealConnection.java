package okhttp3.internal.io;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Address;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Route;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.framed.FramedConnection.Listener;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.http.StreamAllocation;
import okio.BufferedSink;
import okio.BufferedSource;

public final class RealConnection
  extends FramedConnection.Listener
  implements Connection
{
  public int allocationLimit;
  public final List<Reference<StreamAllocation>> allocations = new ArrayList();
  public volatile FramedConnection framedConnection;
  public Handshake handshake;
  public long idleAtNanos = Long.MAX_VALUE;
  public boolean noNewStreams;
  private Protocol protocol;
  private Socket rawSocket;
  public final Route route;
  public BufferedSink sink;
  public Socket socket;
  public BufferedSource source;
  public int successCount;
  
  public RealConnection(Route paramRoute)
  {
    route = paramRoute;
  }
  
  /* Error */
  public final void connect(int paramInt1, int paramInt2, int paramInt3, List<okhttp3.ConnectionSpec> paramList, boolean paramBoolean)
    throws okhttp3.internal.http.RouteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	okhttp3/internal/io/RealConnection:protocol	Lokhttp3/Protocol;
    //   4: ifnull +13 -> 17
    //   7: new 66	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 68
    //   13: invokespecial 71	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aconst_null
    //   18: astore 11
    //   20: new 73	okhttp3/internal/ConnectionSpecSelector
    //   23: dup
    //   24: aload 4
    //   26: invokespecial 76	okhttp3/internal/ConnectionSpecSelector:<init>	(Ljava/util/List;)V
    //   29: astore 15
    //   31: aload_0
    //   32: getfield 47	okhttp3/internal/io/RealConnection:route	Lokhttp3/Route;
    //   35: getfield 82	okhttp3/Route:proxy	Ljava/net/Proxy;
    //   38: astore 16
    //   40: aload_0
    //   41: getfield 47	okhttp3/internal/io/RealConnection:route	Lokhttp3/Route;
    //   44: getfield 86	okhttp3/Route:address	Lokhttp3/Address;
    //   47: astore 17
    //   49: aload 11
    //   51: astore 12
    //   53: aload_0
    //   54: getfield 47	okhttp3/internal/io/RealConnection:route	Lokhttp3/Route;
    //   57: getfield 86	okhttp3/Route:address	Lokhttp3/Address;
    //   60: getfield 92	okhttp3/Address:sslSocketFactory	Ljavax/net/ssl/SSLSocketFactory;
    //   63: ifnonnull +325 -> 388
    //   66: aload 11
    //   68: astore 12
    //   70: aload 4
    //   72: getstatic 98	okhttp3/ConnectionSpec:CLEARTEXT	Lokhttp3/ConnectionSpec;
    //   75: invokeinterface 104 2 0
    //   80: ifne +308 -> 388
    //   83: new 52	okhttp3/internal/http/RouteException
    //   86: dup
    //   87: new 106	java/net/UnknownServiceException
    //   90: dup
    //   91: new 108	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 110
    //   97: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload 4
    //   102: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokespecial 120	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   111: invokespecial 123	okhttp3/internal/http/RouteException:<init>	(Ljava/io/IOException;)V
    //   114: athrow
    //   115: aconst_null
    //   116: astore 4
    //   118: aload_0
    //   119: aload 11
    //   121: putfield 125	okhttp3/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 125	okhttp3/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   129: invokestatic 130	okio/Okio:source	(Ljava/net/Socket;)Lokio/Source;
    //   132: invokestatic 134	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   135: putfield 136	okhttp3/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   138: aload_0
    //   139: aload_0
    //   140: getfield 125	okhttp3/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   143: invokestatic 139	okio/Okio:sink	(Ljava/net/Socket;)Lokio/Sink;
    //   146: invokestatic 142	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   149: putfield 144	okhttp3/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   152: aload_0
    //   153: aload 14
    //   155: putfield 146	okhttp3/internal/io/RealConnection:handshake	Lokhttp3/Handshake;
    //   158: aload 4
    //   160: ifnull +1279 -> 1439
    //   163: aload 4
    //   165: invokestatic 152	okhttp3/Protocol:get	(Ljava/lang/String;)Lokhttp3/Protocol;
    //   168: astore 4
    //   170: aload_0
    //   171: aload 4
    //   173: putfield 64	okhttp3/internal/io/RealConnection:protocol	Lokhttp3/Protocol;
    //   176: aload 11
    //   178: ifnull +11 -> 189
    //   181: invokestatic 157	okhttp3/internal/Platform:get	()Lokhttp3/internal/Platform;
    //   184: aload 11
    //   186: invokevirtual 161	okhttp3/internal/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   189: aload_0
    //   190: getfield 64	okhttp3/internal/io/RealConnection:protocol	Lokhttp3/Protocol;
    //   193: getstatic 164	okhttp3/Protocol:SPDY_3	Lokhttp3/Protocol;
    //   196: if_acmpeq +13 -> 209
    //   199: aload_0
    //   200: getfield 64	okhttp3/internal/io/RealConnection:protocol	Lokhttp3/Protocol;
    //   203: getstatic 167	okhttp3/Protocol:HTTP_2	Lokhttp3/Protocol;
    //   206: if_acmpne +1266 -> 1472
    //   209: aload_0
    //   210: getfield 125	okhttp3/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   213: iconst_0
    //   214: invokevirtual 173	java/net/Socket:setSoTimeout	(I)V
    //   217: new 175	okhttp3/internal/framed/FramedConnection$Builder
    //   220: dup
    //   221: invokespecial 176	okhttp3/internal/framed/FramedConnection$Builder:<init>	()V
    //   224: astore 4
    //   226: aload_0
    //   227: getfield 125	okhttp3/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   230: astore 11
    //   232: aload_0
    //   233: getfield 47	okhttp3/internal/io/RealConnection:route	Lokhttp3/Route;
    //   236: getfield 86	okhttp3/Route:address	Lokhttp3/Address;
    //   239: getfield 180	okhttp3/Address:url	Lokhttp3/HttpUrl;
    //   242: getfield 186	okhttp3/HttpUrl:host	Ljava/lang/String;
    //   245: astore 13
    //   247: aload_0
    //   248: getfield 136	okhttp3/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   251: astore 14
    //   253: aload_0
    //   254: getfield 144	okhttp3/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   257: astore 18
    //   259: aload 4
    //   261: aload 11
    //   263: putfield 187	okhttp3/internal/framed/FramedConnection$Builder:socket	Ljava/net/Socket;
    //   266: aload 4
    //   268: aload 13
    //   270: putfield 190	okhttp3/internal/framed/FramedConnection$Builder:hostname	Ljava/lang/String;
    //   273: aload 4
    //   275: aload 14
    //   277: putfield 191	okhttp3/internal/framed/FramedConnection$Builder:source	Lokio/BufferedSource;
    //   280: aload 4
    //   282: aload 18
    //   284: putfield 192	okhttp3/internal/framed/FramedConnection$Builder:sink	Lokio/BufferedSink;
    //   287: aload 4
    //   289: aload_0
    //   290: getfield 64	okhttp3/internal/io/RealConnection:protocol	Lokhttp3/Protocol;
    //   293: putfield 193	okhttp3/internal/framed/FramedConnection$Builder:protocol	Lokhttp3/Protocol;
    //   296: aload 4
    //   298: aload_0
    //   299: putfield 197	okhttp3/internal/framed/FramedConnection$Builder:listener	Lokhttp3/internal/framed/FramedConnection$Listener;
    //   302: new 199	okhttp3/internal/framed/FramedConnection
    //   305: dup
    //   306: aload 4
    //   308: iconst_0
    //   309: invokespecial 202	okhttp3/internal/framed/FramedConnection:<init>	(Lokhttp3/internal/framed/FramedConnection$Builder;B)V
    //   312: astore 4
    //   314: aload 4
    //   316: getfield 206	okhttp3/internal/framed/FramedConnection:frameWriter	Lokhttp3/internal/framed/FrameWriter;
    //   319: invokeinterface 211 1 0
    //   324: aload 4
    //   326: getfield 206	okhttp3/internal/framed/FramedConnection:frameWriter	Lokhttp3/internal/framed/FrameWriter;
    //   329: aload 4
    //   331: getfield 215	okhttp3/internal/framed/FramedConnection:okHttpSettings	Lokhttp3/internal/framed/Settings;
    //   334: invokeinterface 219 2 0
    //   339: aload 4
    //   341: getfield 215	okhttp3/internal/framed/FramedConnection:okHttpSettings	Lokhttp3/internal/framed/Settings;
    //   344: invokevirtual 225	okhttp3/internal/framed/Settings:getInitialWindowSize$134621	()I
    //   347: istore 6
    //   349: iload 6
    //   351: ldc -30
    //   353: if_icmpeq +20 -> 373
    //   356: aload 4
    //   358: getfield 206	okhttp3/internal/framed/FramedConnection:frameWriter	Lokhttp3/internal/framed/FrameWriter;
    //   361: iconst_0
    //   362: iload 6
    //   364: ldc -30
    //   366: isub
    //   367: i2l
    //   368: invokeinterface 230 4 0
    //   373: aload_0
    //   374: aload 4
    //   376: invokevirtual 233	okhttp3/internal/framed/FramedConnection:maxConcurrentStreams	()I
    //   379: putfield 235	okhttp3/internal/io/RealConnection:allocationLimit	I
    //   382: aload_0
    //   383: aload 4
    //   385: putfield 237	okhttp3/internal/io/RealConnection:framedConnection	Lokhttp3/internal/framed/FramedConnection;
    //   388: aload_0
    //   389: getfield 64	okhttp3/internal/io/RealConnection:protocol	Lokhttp3/Protocol;
    //   392: ifnonnull +1139 -> 1531
    //   395: aload 16
    //   397: invokevirtual 243	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   400: getstatic 249	java/net/Proxy$Type:DIRECT	Ljava/net/Proxy$Type;
    //   403: if_acmpeq +14 -> 417
    //   406: aload 16
    //   408: invokevirtual 243	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   411: getstatic 252	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   414: if_acmpne +582 -> 996
    //   417: aload 17
    //   419: getfield 256	okhttp3/Address:socketFactory	Ljavax/net/SocketFactory;
    //   422: invokevirtual 262	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   425: astore 4
    //   427: aload_0
    //   428: aload 4
    //   430: putfield 264	okhttp3/internal/io/RealConnection:rawSocket	Ljava/net/Socket;
    //   433: aload_0
    //   434: getfield 264	okhttp3/internal/io/RealConnection:rawSocket	Ljava/net/Socket;
    //   437: iload_2
    //   438: invokevirtual 173	java/net/Socket:setSoTimeout	(I)V
    //   441: invokestatic 157	okhttp3/internal/Platform:get	()Lokhttp3/internal/Platform;
    //   444: aload_0
    //   445: getfield 264	okhttp3/internal/io/RealConnection:rawSocket	Ljava/net/Socket;
    //   448: aload_0
    //   449: getfield 47	okhttp3/internal/io/RealConnection:route	Lokhttp3/Route;
    //   452: getfield 268	okhttp3/Route:inetSocketAddress	Ljava/net/InetSocketAddress;
    //   455: iload_1
    //   456: invokevirtual 272	okhttp3/internal/Platform:connectSocket	(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V
    //   459: aload_0
    //   460: aload_0
    //   461: getfield 264	okhttp3/internal/io/RealConnection:rawSocket	Ljava/net/Socket;
    //   464: invokestatic 130	okio/Okio:source	(Ljava/net/Socket;)Lokio/Source;
    //   467: invokestatic 134	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   470: putfield 136	okhttp3/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   473: aload_0
    //   474: aload_0
    //   475: getfield 264	okhttp3/internal/io/RealConnection:rawSocket	Ljava/net/Socket;
    //   478: invokestatic 139	okio/Okio:sink	(Ljava/net/Socket;)Lokio/Sink;
    //   481: invokestatic 142	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   484: putfield 144	okhttp3/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   487: aload_0
    //   488: getfield 47	okhttp3/internal/io/RealConnection:route	Lokhttp3/Route;
    //   491: getfield 86	okhttp3/Route:address	Lokhttp3/Address;
    //   494: getfield 92	okhttp3/Address:sslSocketFactory	Ljavax/net/ssl/SSLSocketFactory;
    //   497: ifnull +957 -> 1454
    //   500: aload_0
    //   501: getfield 47	okhttp3/internal/io/RealConnection:route	Lokhttp3/Route;
    //   504: astore 4
    //   506: aload 4
    //   508: getfield 86	okhttp3/Route:address	Lokhttp3/Address;
    //   511: getfield 92	okhttp3/Address:sslSocketFactory	Ljavax/net/ssl/SSLSocketFactory;
    //   514: ifnull +1045 -> 1559
    //   517: aload 4
    //   519: getfield 82	okhttp3/Route:proxy	Ljava/net/Proxy;
    //   522: invokevirtual 243	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   525: getstatic 252	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   528: if_acmpne +1031 -> 1559
    //   531: iconst_1
    //   532: istore 6
    //   534: iload 6
    //   536: ifeq +575 -> 1111
    //   539: new 274	okhttp3/Request$Builder
    //   542: dup
    //   543: invokespecial 275	okhttp3/Request$Builder:<init>	()V
    //   546: aload_0
    //   547: getfield 47	okhttp3/internal/io/RealConnection:route	Lokhttp3/Route;
    //   550: getfield 86	okhttp3/Route:address	Lokhttp3/Address;
    //   553: getfield 180	okhttp3/Address:url	Lokhttp3/HttpUrl;
    //   556: invokevirtual 278	okhttp3/Request$Builder:url	(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;
    //   559: ldc_w 280
    //   562: aload_0
    //   563: getfield 47	okhttp3/internal/io/RealConnection:route	Lokhttp3/Route;
    //   566: getfield 86	okhttp3/Route:address	Lokhttp3/Address;
    //   569: getfield 180	okhttp3/Address:url	Lokhttp3/HttpUrl;
    //   572: iconst_1
    //   573: invokestatic 286	okhttp3/internal/Util:hostHeader	(Lokhttp3/HttpUrl;Z)Ljava/lang/String;
    //   576: invokevirtual 290	okhttp3/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   579: ldc_w 292
    //   582: ldc_w 294
    //   585: invokevirtual 290	okhttp3/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   588: ldc_w 296
    //   591: ldc_w 298
    //   594: invokevirtual 290	okhttp3/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   597: invokevirtual 302	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   600: astore 4
    //   602: aload 4
    //   604: getfield 305	okhttp3/Request:url	Lokhttp3/HttpUrl;
    //   607: astore 11
    //   609: new 108	java/lang/StringBuilder
    //   612: dup
    //   613: ldc_w 307
    //   616: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   619: aload 11
    //   621: iconst_1
    //   622: invokestatic 286	okhttp3/internal/Util:hostHeader	(Lokhttp3/HttpUrl;Z)Ljava/lang/String;
    //   625: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: ldc_w 312
    //   631: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: astore 13
    //   639: new 314	okhttp3/internal/http/Http1xStream
    //   642: dup
    //   643: aconst_null
    //   644: aload_0
    //   645: getfield 136	okhttp3/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   648: aload_0
    //   649: getfield 144	okhttp3/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   652: invokespecial 317	okhttp3/internal/http/Http1xStream:<init>	(Lokhttp3/internal/http/StreamAllocation;Lokio/BufferedSource;Lokio/BufferedSink;)V
    //   655: astore 11
    //   657: aload_0
    //   658: getfield 136	okhttp3/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   661: invokeinterface 323 1 0
    //   666: iload_2
    //   667: i2l
    //   668: getstatic 329	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   671: invokevirtual 334	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
    //   674: pop
    //   675: aload_0
    //   676: getfield 144	okhttp3/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   679: invokeinterface 337 1 0
    //   684: iload_3
    //   685: i2l
    //   686: getstatic 329	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   689: invokevirtual 334	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
    //   692: pop
    //   693: aload 11
    //   695: aload 4
    //   697: getfield 341	okhttp3/Request:headers	Lokhttp3/Headers;
    //   700: aload 13
    //   702: invokevirtual 345	okhttp3/internal/http/Http1xStream:writeRequest	(Lokhttp3/Headers;Ljava/lang/String;)V
    //   705: aload 11
    //   707: invokevirtual 348	okhttp3/internal/http/Http1xStream:finishRequest	()V
    //   710: aload 11
    //   712: invokevirtual 352	okhttp3/internal/http/Http1xStream:readResponse	()Lokhttp3/Response$Builder;
    //   715: astore 13
    //   717: aload 13
    //   719: aload 4
    //   721: putfield 358	okhttp3/Response$Builder:request	Lokhttp3/Request;
    //   724: aload 13
    //   726: invokevirtual 361	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   729: astore 4
    //   731: aload 4
    //   733: invokestatic 367	okhttp3/internal/http/OkHeaders:contentLength	(Lokhttp3/Response;)J
    //   736: lstore 9
    //   738: lload 9
    //   740: lstore 7
    //   742: lload 9
    //   744: ldc2_w 368
    //   747: lcmp
    //   748: ifne +6 -> 754
    //   751: lconst_0
    //   752: lstore 7
    //   754: aload 11
    //   756: lload 7
    //   758: invokevirtual 373	okhttp3/internal/http/Http1xStream:newFixedLengthSource	(J)Lokio/Source;
    //   761: astore 11
    //   763: aload 11
    //   765: ldc_w 374
    //   768: getstatic 329	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   771: invokestatic 378	okhttp3/internal/Util:skipAll	(Lokio/Source;ILjava/util/concurrent/TimeUnit;)Z
    //   774: pop
    //   775: aload 11
    //   777: invokeinterface 383 1 0
    //   782: aload 4
    //   784: getfield 388	okhttp3/Response:code	I
    //   787: lookupswitch	default:+769->1556, 200:+256->1043, 407:+297->1084
    //   812: new 56	java/io/IOException
    //   815: dup
    //   816: new 108	java/lang/StringBuilder
    //   819: dup
    //   820: ldc_w 390
    //   823: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   826: aload 4
    //   828: getfield 388	okhttp3/Response:code	I
    //   831: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   834: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokespecial 394	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   840: athrow
    //   841: astore 11
    //   843: aload_0
    //   844: getfield 125	okhttp3/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   847: invokestatic 398	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   850: aload_0
    //   851: getfield 264	okhttp3/internal/io/RealConnection:rawSocket	Ljava/net/Socket;
    //   854: invokestatic 398	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   857: aload_0
    //   858: aconst_null
    //   859: putfield 125	okhttp3/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   862: aload_0
    //   863: aconst_null
    //   864: putfield 264	okhttp3/internal/io/RealConnection:rawSocket	Ljava/net/Socket;
    //   867: aload_0
    //   868: aconst_null
    //   869: putfield 136	okhttp3/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   872: aload_0
    //   873: aconst_null
    //   874: putfield 144	okhttp3/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   877: aload_0
    //   878: aconst_null
    //   879: putfield 146	okhttp3/internal/io/RealConnection:handshake	Lokhttp3/Handshake;
    //   882: aload_0
    //   883: aconst_null
    //   884: putfield 64	okhttp3/internal/io/RealConnection:protocol	Lokhttp3/Protocol;
    //   887: aload 12
    //   889: ifnonnull +591 -> 1480
    //   892: new 52	okhttp3/internal/http/RouteException
    //   895: dup
    //   896: aload 11
    //   898: invokespecial 123	okhttp3/internal/http/RouteException:<init>	(Ljava/io/IOException;)V
    //   901: astore 4
    //   903: iload 5
    //   905: ifeq +88 -> 993
    //   908: aload 15
    //   910: iconst_1
    //   911: putfield 401	okhttp3/internal/ConnectionSpecSelector:isFallback	Z
    //   914: aload 15
    //   916: getfield 404	okhttp3/internal/ConnectionSpecSelector:isFallbackPossible	Z
    //   919: ifeq +606 -> 1525
    //   922: aload 11
    //   924: instanceof 406
    //   927: ifne +598 -> 1525
    //   930: aload 11
    //   932: instanceof 408
    //   935: ifne +590 -> 1525
    //   938: aload 11
    //   940: instanceof 410
    //   943: ifeq +14 -> 957
    //   946: aload 11
    //   948: invokevirtual 414	java/io/IOException:getCause	()Ljava/lang/Throwable;
    //   951: instanceof 416
    //   954: ifne +571 -> 1525
    //   957: aload 11
    //   959: instanceof 418
    //   962: ifne +563 -> 1525
    //   965: aload 11
    //   967: instanceof 410
    //   970: ifne +11 -> 981
    //   973: aload 11
    //   975: instanceof 420
    //   978: ifeq +547 -> 1525
    //   981: iconst_1
    //   982: istore 6
    //   984: aload 4
    //   986: astore 12
    //   988: iload 6
    //   990: ifne -602 -> 388
    //   993: aload 4
    //   995: athrow
    //   996: new 169	java/net/Socket
    //   999: dup
    //   1000: aload 16
    //   1002: invokespecial 423	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   1005: astore 4
    //   1007: goto -580 -> 427
    //   1010: astore 4
    //   1012: new 58	java/net/ConnectException
    //   1015: dup
    //   1016: new 108	java/lang/StringBuilder
    //   1019: dup
    //   1020: ldc_w 425
    //   1023: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1026: aload_0
    //   1027: getfield 47	okhttp3/internal/io/RealConnection:route	Lokhttp3/Route;
    //   1030: getfield 268	okhttp3/Route:inetSocketAddress	Ljava/net/InetSocketAddress;
    //   1033: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1036: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1039: invokespecial 426	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   1042: athrow
    //   1043: aload_0
    //   1044: getfield 136	okhttp3/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   1047: invokeinterface 429 1 0
    //   1052: invokevirtual 435	okio/Buffer:exhausted	()Z
    //   1055: ifeq +18 -> 1073
    //   1058: aload_0
    //   1059: getfield 144	okhttp3/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   1062: invokeinterface 436 1 0
    //   1067: invokevirtual 435	okio/Buffer:exhausted	()Z
    //   1070: ifne +41 -> 1111
    //   1073: new 56	java/io/IOException
    //   1076: dup
    //   1077: ldc_w 438
    //   1080: invokespecial 394	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1083: athrow
    //   1084: aload_0
    //   1085: getfield 47	okhttp3/internal/io/RealConnection:route	Lokhttp3/Route;
    //   1088: getfield 86	okhttp3/Route:address	Lokhttp3/Address;
    //   1091: getfield 442	okhttp3/Address:proxyAuthenticator	Lokhttp3/Authenticator;
    //   1094: invokeinterface 447 1 0
    //   1099: pop
    //   1100: new 56	java/io/IOException
    //   1103: dup
    //   1104: ldc_w 449
    //   1107: invokespecial 394	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1110: athrow
    //   1111: aload_0
    //   1112: getfield 47	okhttp3/internal/io/RealConnection:route	Lokhttp3/Route;
    //   1115: getfield 86	okhttp3/Route:address	Lokhttp3/Address;
    //   1118: astore 13
    //   1120: aload 13
    //   1122: getfield 92	okhttp3/Address:sslSocketFactory	Ljavax/net/ssl/SSLSocketFactory;
    //   1125: astore 11
    //   1127: aconst_null
    //   1128: astore 4
    //   1130: aconst_null
    //   1131: astore 14
    //   1133: aload 11
    //   1135: aload_0
    //   1136: getfield 264	okhttp3/internal/io/RealConnection:rawSocket	Ljava/net/Socket;
    //   1139: aload 13
    //   1141: getfield 180	okhttp3/Address:url	Lokhttp3/HttpUrl;
    //   1144: getfield 186	okhttp3/HttpUrl:host	Ljava/lang/String;
    //   1147: aload 13
    //   1149: getfield 180	okhttp3/Address:url	Lokhttp3/HttpUrl;
    //   1152: getfield 452	okhttp3/HttpUrl:port	I
    //   1155: iconst_1
    //   1156: invokevirtual 457	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   1159: checkcast 459	javax/net/ssl/SSLSocket
    //   1162: astore 11
    //   1164: aload 15
    //   1166: aload 11
    //   1168: invokevirtual 463	okhttp3/internal/ConnectionSpecSelector:configureSecureSocket	(Ljavax/net/ssl/SSLSocket;)Lokhttp3/ConnectionSpec;
    //   1171: astore 4
    //   1173: aload 4
    //   1175: getfield 466	okhttp3/ConnectionSpec:supportsTlsExtensions	Z
    //   1178: ifeq +24 -> 1202
    //   1181: invokestatic 157	okhttp3/internal/Platform:get	()Lokhttp3/internal/Platform;
    //   1184: aload 11
    //   1186: aload 13
    //   1188: getfield 180	okhttp3/Address:url	Lokhttp3/HttpUrl;
    //   1191: getfield 186	okhttp3/HttpUrl:host	Ljava/lang/String;
    //   1194: aload 13
    //   1196: getfield 469	okhttp3/Address:protocols	Ljava/util/List;
    //   1199: invokevirtual 473	okhttp3/internal/Platform:configureTlsExtensions	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   1202: aload 11
    //   1204: invokevirtual 476	javax/net/ssl/SSLSocket:startHandshake	()V
    //   1207: aload 11
    //   1209: invokevirtual 480	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   1212: invokestatic 485	okhttp3/Handshake:get	(Ljavax/net/ssl/SSLSession;)Lokhttp3/Handshake;
    //   1215: astore 14
    //   1217: aload 13
    //   1219: getfield 489	okhttp3/Address:hostnameVerifier	Ljavax/net/ssl/HostnameVerifier;
    //   1222: aload 13
    //   1224: getfield 180	okhttp3/Address:url	Lokhttp3/HttpUrl;
    //   1227: getfield 186	okhttp3/HttpUrl:host	Ljava/lang/String;
    //   1230: aload 11
    //   1232: invokevirtual 480	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   1235: invokeinterface 495 3 0
    //   1240: ifne +157 -> 1397
    //   1243: aload 14
    //   1245: getfield 498	okhttp3/Handshake:peerCertificates	Ljava/util/List;
    //   1248: iconst_0
    //   1249: invokeinterface 501 2 0
    //   1254: checkcast 503	java/security/cert/X509Certificate
    //   1257: astore 4
    //   1259: new 418	javax/net/ssl/SSLPeerUnverifiedException
    //   1262: dup
    //   1263: new 108	java/lang/StringBuilder
    //   1266: dup
    //   1267: ldc_w 505
    //   1270: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1273: aload 13
    //   1275: getfield 180	okhttp3/Address:url	Lokhttp3/HttpUrl;
    //   1278: getfield 186	okhttp3/HttpUrl:host	Ljava/lang/String;
    //   1281: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: ldc_w 507
    //   1287: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: aload 4
    //   1292: invokestatic 513	okhttp3/CertificatePinner:pin	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   1295: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: ldc_w 515
    //   1301: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: aload 4
    //   1306: invokevirtual 519	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   1309: invokeinterface 524 1 0
    //   1314: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: ldc_w 526
    //   1320: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: aload 4
    //   1325: invokestatic 532	okhttp3/internal/tls/OkHostnameVerifier:allSubjectAltNames	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   1328: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1331: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1334: invokespecial 533	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   1337: athrow
    //   1338: astore 13
    //   1340: aload 11
    //   1342: astore 4
    //   1344: aload 13
    //   1346: invokestatic 537	okhttp3/internal/Util:isAndroidGetsocknameError	(Ljava/lang/AssertionError;)Z
    //   1349: ifeq +98 -> 1447
    //   1352: aload 11
    //   1354: astore 4
    //   1356: new 56	java/io/IOException
    //   1359: dup
    //   1360: aload 13
    //   1362: invokespecial 540	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   1365: athrow
    //   1366: astore 13
    //   1368: aload 4
    //   1370: astore 11
    //   1372: aload 13
    //   1374: astore 4
    //   1376: aload 11
    //   1378: ifnull +11 -> 1389
    //   1381: invokestatic 157	okhttp3/internal/Platform:get	()Lokhttp3/internal/Platform;
    //   1384: aload 11
    //   1386: invokevirtual 161	okhttp3/internal/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   1389: aload 11
    //   1391: invokestatic 398	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   1394: aload 4
    //   1396: athrow
    //   1397: aload 13
    //   1399: getfield 544	okhttp3/Address:certificatePinner	Lokhttp3/CertificatePinner;
    //   1402: aload 13
    //   1404: getfield 180	okhttp3/Address:url	Lokhttp3/HttpUrl;
    //   1407: getfield 186	okhttp3/HttpUrl:host	Ljava/lang/String;
    //   1410: aload 14
    //   1412: getfield 498	okhttp3/Handshake:peerCertificates	Ljava/util/List;
    //   1415: invokevirtual 548	okhttp3/CertificatePinner:check	(Ljava/lang/String;Ljava/util/List;)V
    //   1418: aload 4
    //   1420: getfield 466	okhttp3/ConnectionSpec:supportsTlsExtensions	Z
    //   1423: ifeq -1308 -> 115
    //   1426: invokestatic 157	okhttp3/internal/Platform:get	()Lokhttp3/internal/Platform;
    //   1429: aload 11
    //   1431: invokevirtual 552	okhttp3/internal/Platform:getSelectedProtocol	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   1434: astore 4
    //   1436: goto -1318 -> 118
    //   1439: getstatic 555	okhttp3/Protocol:HTTP_1_1	Lokhttp3/Protocol;
    //   1442: astore 4
    //   1444: goto -1274 -> 170
    //   1447: aload 11
    //   1449: astore 4
    //   1451: aload 13
    //   1453: athrow
    //   1454: aload_0
    //   1455: getstatic 555	okhttp3/Protocol:HTTP_1_1	Lokhttp3/Protocol;
    //   1458: putfield 64	okhttp3/internal/io/RealConnection:protocol	Lokhttp3/Protocol;
    //   1461: aload_0
    //   1462: aload_0
    //   1463: getfield 264	okhttp3/internal/io/RealConnection:rawSocket	Ljava/net/Socket;
    //   1466: putfield 125	okhttp3/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   1469: goto -1280 -> 189
    //   1472: aload_0
    //   1473: iconst_1
    //   1474: putfield 235	okhttp3/internal/io/RealConnection:allocationLimit	I
    //   1477: goto -1089 -> 388
    //   1480: aload 12
    //   1482: getfield 559	okhttp3/internal/http/RouteException:lastException	Ljava/io/IOException;
    //   1485: astore 4
    //   1487: getstatic 563	okhttp3/internal/http/RouteException:addSuppressedExceptionMethod	Ljava/lang/reflect/Method;
    //   1490: ifnull +21 -> 1511
    //   1493: getstatic 563	okhttp3/internal/http/RouteException:addSuppressedExceptionMethod	Ljava/lang/reflect/Method;
    //   1496: aload 11
    //   1498: iconst_1
    //   1499: anewarray 565	java/lang/Object
    //   1502: dup
    //   1503: iconst_0
    //   1504: aload 4
    //   1506: aastore
    //   1507: invokevirtual 571	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1510: pop
    //   1511: aload 12
    //   1513: aload 11
    //   1515: putfield 559	okhttp3/internal/http/RouteException:lastException	Ljava/io/IOException;
    //   1518: aload 12
    //   1520: astore 4
    //   1522: goto -619 -> 903
    //   1525: iconst_0
    //   1526: istore 6
    //   1528: goto -544 -> 984
    //   1531: return
    //   1532: astore 4
    //   1534: goto -23 -> 1511
    //   1537: astore 4
    //   1539: goto -28 -> 1511
    //   1542: astore 4
    //   1544: goto -168 -> 1376
    //   1547: astore 13
    //   1549: aload 14
    //   1551: astore 11
    //   1553: goto -213 -> 1340
    //   1556: goto -744 -> 812
    //   1559: iconst_0
    //   1560: istore 6
    //   1562: goto -1028 -> 534
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1565	0	this	RealConnection
    //   0	1565	1	paramInt1	int
    //   0	1565	2	paramInt2	int
    //   0	1565	3	paramInt3	int
    //   0	1565	4	paramList	List<okhttp3.ConnectionSpec>
    //   0	1565	5	paramBoolean	boolean
    //   347	1214	6	i	int
    //   740	17	7	l1	long
    //   736	7	9	l2	long
    //   18	758	11	localObject1	Object
    //   841	133	11	localIOException	IOException
    //   1125	427	11	localObject2	Object
    //   51	1468	12	localObject3	Object
    //   245	1029	13	localObject4	Object
    //   1338	23	13	localAssertionError1	AssertionError
    //   1366	86	13	localObject5	Object
    //   1547	1	13	localAssertionError2	AssertionError
    //   153	1397	14	localObject6	Object
    //   29	1136	15	localConnectionSpecSelector	okhttp3.internal.ConnectionSpecSelector
    //   38	963	16	localProxy	java.net.Proxy
    //   47	371	17	localAddress	Address
    //   257	26	18	localBufferedSink	BufferedSink
    // Exception table:
    //   from	to	target	type
    //   181	189	841	java/io/IOException
    //   189	209	841	java/io/IOException
    //   209	349	841	java/io/IOException
    //   356	373	841	java/io/IOException
    //   373	388	841	java/io/IOException
    //   395	417	841	java/io/IOException
    //   417	427	841	java/io/IOException
    //   427	441	841	java/io/IOException
    //   441	459	841	java/io/IOException
    //   459	531	841	java/io/IOException
    //   539	738	841	java/io/IOException
    //   754	812	841	java/io/IOException
    //   812	841	841	java/io/IOException
    //   996	1007	841	java/io/IOException
    //   1012	1043	841	java/io/IOException
    //   1043	1073	841	java/io/IOException
    //   1073	1084	841	java/io/IOException
    //   1084	1111	841	java/io/IOException
    //   1111	1127	841	java/io/IOException
    //   1381	1389	841	java/io/IOException
    //   1389	1397	841	java/io/IOException
    //   1454	1469	841	java/io/IOException
    //   1472	1477	841	java/io/IOException
    //   441	459	1010	java/net/ConnectException
    //   118	158	1338	java/lang/AssertionError
    //   163	170	1338	java/lang/AssertionError
    //   170	176	1338	java/lang/AssertionError
    //   1164	1202	1338	java/lang/AssertionError
    //   1202	1338	1338	java/lang/AssertionError
    //   1397	1436	1338	java/lang/AssertionError
    //   1439	1444	1338	java/lang/AssertionError
    //   1133	1164	1366	finally
    //   1344	1352	1366	finally
    //   1356	1366	1366	finally
    //   1451	1454	1366	finally
    //   1493	1511	1532	java/lang/IllegalAccessException
    //   1493	1511	1537	java/lang/reflect/InvocationTargetException
    //   118	158	1542	finally
    //   163	170	1542	finally
    //   170	176	1542	finally
    //   1164	1202	1542	finally
    //   1202	1338	1542	finally
    //   1397	1436	1542	finally
    //   1439	1444	1542	finally
    //   1133	1164	1547	java/lang/AssertionError
  }
  
  public final boolean isHealthy(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((socket.isClosed()) || (socket.isInputShutdown()) || (socket.isOutputShutdown())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (framedConnection != null);
      bool1 = bool2;
    } while (!paramBoolean);
    try
    {
      int i = socket.getSoTimeout();
      try
      {
        socket.setSoTimeout(1);
        paramBoolean = source.exhausted();
        return !paramBoolean;
      }
      finally
      {
        socket.setSoTimeout(i);
      }
      return true;
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
  }
  
  public final void onSettings(FramedConnection paramFramedConnection)
  {
    allocationLimit = paramFramedConnection.maxConcurrentStreams();
  }
  
  public final void onStream(FramedStream paramFramedStream)
    throws IOException
  {
    paramFramedStream.close(ErrorCode.REFUSED_STREAM);
  }
  
  public final Route route()
  {
    return route;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Connection{").append(route.address.url.host).append(":").append(route.address.url.port).append(", proxy=").append(route.proxy).append(" hostAddress=").append(route.inetSocketAddress).append(" cipherSuite=");
    if (handshake != null) {}
    for (Object localObject = handshake.cipherSuite;; localObject = "none") {
      return localObject + " protocol=" + protocol + '}';
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.io.RealConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */