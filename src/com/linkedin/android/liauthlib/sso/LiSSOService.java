package com.linkedin.android.liauthlib.sso;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.LiAuthProvider;
import com.linkedin.android.liauthlib.common.LiSSOInfo;
import com.linkedin.android.liauthlib.common.LiSharedPrefUtils;
import com.linkedin.android.liauthlib.network.HttpStack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LiSSOService
  extends Service
{
  private static final String[] approvedSignatures = { "308201e53082014ea00302010202045227d3f0300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3133303930353030343433325a170d3433303832393030343433325a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d0030818902818100c86bfa538c10f264804622dc9db35804e048ea9bf848f0aef4240476f440c32738da37e4aeb1dbabd2af825eefcfc09ff70a46dd9f38dbc71c2b7af55e8aa929e98338b20d3dbb14fc42ac3d99387e67051207850701c33a2877cd5d03aff9c2f7c92efc1e116e63260302cc11d9898627f8e2b19445da925cd930d764822eef0203010001300d06092a864886f70d010105050003818100a56ed62f96b740ce78a759e1baf1457db1fa84845226469ef1f3a9053676fdab6e384175e0ceb78823409a1562bea00960bc2e2078107515ba559386d24669e1947f79ba9741f9da97f275550acd9e38e8b0281ebdf1cf49508dcb233ce4c72632b117033162d51e279d6edf8a62434b35120e7697501793ceea4908a2d84ae6", "308201e53082014ea00302010202044f02a72c300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3132303130333036353835325a170d3431313232363036353835325a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d0030818902818100bd4901f55fc3638812eb04ff6e2aaba240304a9f0a030fe26119dfcb012dc813e6603f017196f4c53a1e2e831fe316df73c347422712c9a4aef058fd570a89cbb2823d1bbe8df1066b5ee6626f75a34b09ab9d6029e14bda4557b65c4e0c9e5d938ca05dd1759c6ef611ed8771e4cfef19239c366637c1cb62f226acd6fb171d0203010001300d06092a864886f70d010105050003818100456c40bdb748daabffb7ff349161e822cbedd5d2a16bd4a0c78f140dcde47e39424c7eae445fa14245ee2ad63bc4166ab88170433a582e04abb80467d5e3b599af35d46f1e59b7bd4e15b9c5bf2c3c7eb8d4bf3581b4b479887fd39568ea690cd59d750790095ade4ffbb8a75289ad3b4cb35e5404640537d73cdce30c423492", "3082025d308201c6a00302010202044c40f4d7300d06092a864886f70d01010505003072310a30080603550406130131310b3009060355040813024341311230100603550407130950616c6f20416c746f31163014060355040a130d416c70686f6e736f204c61627331163014060355040b130d416c70686f6e736f204c616273311330110603550403130a416c62657274204c61693020170d3130303731373030303935395a180f33303039313131373030303935395a3072310a30080603550406130131310b3009060355040813024341311230100603550407130950616c6f20416c746f31163014060355040a130d416c70686f6e736f204c61627331163014060355040b130d416c70686f6e736f204c616273311330110603550403130a416c62657274204c616930819f300d06092a864886f70d010101050003818d00308189028181008d27cf8f79c682652761a17a46120a34639cd6711c2a1bc5fdbb0da4bee4dd9cb4442eefa7ce5e9034b964478ef6a537811ae2ba6aeb74a3ca44af9a7e3e8b6ed6072188d6e0c6f965ad65513c122cde739e004bbb04e173e123a6a282631da23b15fad6b74bfa73ee89b5a80f0f2020b208fbd337d7566fe248101e5978fabb0203010001300d06092a864886f70d0101050500038181007c5765d46b7f437fa07a0f33cb9a0d18854b8eac65f9a5045237834752070f881a80d11591f85147ab443043d213d8733dc8585f930be9e5011d9a45ff0a66cd8d3554aa3274b0c7fb70a583d56b987824cefdecb81bfd60441a2ca15f121f04574b36eda135fb5950cf22f2f271fd04b082e2117dc446bfd039da23b1361f59", "3082036830820250a00302010202044d07f422300d06092a864886f70d01010505003076310b3009060355040613025553310b3009060355040813024341311630140603550407130d4d6f756e7461696e205669657731163014060355040a130d4c696e6b6564496e20436f7270310c300a060355040b13034c4544311c301a060355040313134a61696b756d61722052616d616e617468616e301e170d3130313231343232343830325a170d3338303530313232343830325a3076310b3009060355040613025553310b3009060355040813024341311630140603550407130d4d6f756e7461696e205669657731163014060355040a130d4c696e6b6564496e20436f7270310c300a060355040b13034c4544311c301a060355040313134a61696b756d61722052616d616e617468616e30820122300d06092a864886f70d01010105000382010f003082010a02820101008164a246b2fe4ee3b80e2c16b941abfaddd652a5a7080b4911f61cc9c73bcf288791825b041e454156433de1ea4c9a3861c220637cce78d445ff820887adbe52b0da8a1e8d157f376c79f724833c611af9bcb537eb0c3a3a8aa953e99933eb19676ccaedf74cb152274ae78e809af2b96770b24b27e09c3a16b02b4e43b0d77802c2a9fad7539301f35ffae81f45dda143e1d88d1642e4e68ff1dca79a84731adbbe812db7ffe71d4c8ec0a005e1cd034d8a60ffac3e3d941f7224d37b10431890a5bf60a3f9e51cd8fcf83d9498d9850d775d617ffa68b2496343f5190a2e0be0067f660215deae1bdae09c7761f3a82fa7a8c6a0430ee54e910da61d2c2bd30203010001300d06092a864886f70d010105050003820101006ea1432edcc3e302a49604d41e569397bc158df2b583a34d3e57f597943a98179b2b6d41b7055ce3b247b99ed88bb7e12a213c6de0c1adac46567b0a190d924c0a2990be0bd774d7269300534ca4e88e146fbc49b2cff957cfec84bcc9aeacfe2572391943aac521c88b792c0645c0de6803250867268ed2c1fda13f8c6cdb943214de2fb7737dd578e0e60db4e16e1778c39f1bed2bb567e03dbb14803f6fc5824da3f34e8d1e2e9e93ce49e911c321ac36d8ff10e223c8d29b30ebeacfa42abcff52e079a84542dca6d3c06a62b08dfe426cdc4ead83eb3119f096b7d100964b771d4af46f8ac77ddee79c4fc801bd656b06a4a28f872f4ff308515c3c5a08", "30820257308201c0a003020102020450807382300d06092a864886f70d0101050500306f310b3009060355040613025553310b3009060355040813024341311630140603550407130d4d6f756e7461696e20566965773111300f060355040a13084c696e6b6564496e3110300e060355040b1307416e64726f6964311630140603550403130d416e64726f69642044656275673020170d3132313031383231323431385a180f32313132313031383231323431385a306f310b3009060355040613025553310b3009060355040813024341311630140603550407130d4d6f756e7461696e20566965773111300f060355040a13084c696e6b6564496e3110300e060355040b1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d00308189028181008012fb1baed8317345c05016f91e8e7552678c2dbab6a54a20fb9c75a540683ecedeff1954c503717f4de4a1c2e94291cbc8bed351345adc06273ab563b61bcf0d2c519f5d00f5b745c479f4e96d515a137ec802d680805d1d91e700030218f3e1e5055d4cc00ce7b32c0f8a02eb61382027136a233da27f8bde2f3c2e6deb3f0203010001300d06092a864886f70d01010505000381810009f7c97515a8d456f62de22af4a61e89bde1f7fb493f4597859f5cc3ba738309463a1e282cd09a2ab33350e3f36a280bb42eba0e17d6a64a06cd0a11a126bb71506d34e8ba800bad2b69f63e8b8c2a8a71bae9ecad4f621c2b32ba99d47399b1933a5b4b72911f469c149731aed47a5d7fe036ceee4552e0a84f1629633d936f", "3082023b308201a4a00302010202045481fe66300d06092a864886f70d01010505003062310e300c060355040613053934303433310b3009060355040813024341311630140603550407130d4d6f756e7461696e20566965773111300f060355040a13084c696e6b6564496e31183016060355040b130f4c696e6b6564496e204d6f62696c65301e170d3134313230353138353031345a170d3334313133303138353031345a3062310e300c060355040613053934303433310b3009060355040813024341311630140603550407130d4d6f756e7461696e20566965773111300f060355040a13084c696e6b6564496e31183016060355040b130f4c696e6b6564496e204d6f62696c6530819f300d06092a864886f70d010101050003818d003081890281810082bcd6da647d0f96fcb98bc3be959afda821e1729a20625d17be66526dfe1bf52152397468b5060051d165ee93cad2a6e18f3e02c49bee68343686f1dee65e59f21a390064b7d2898dc0f3626b0143bd17bd7d24d37309f49e9a18748f5cc613f81f903a7142021a24e86fb89ef6f9103427c68a5962d9ea639a77c0472e004d0203010001300d06092a864886f70d01010505000381810014946a0f5eaadf847f57f958ea262b58e74b022ede874391117631d4f4d2aec71bde45c0d48bbb62274f88cafd093ae33aa3fc50908498fe58147eddc383e594b30ed72fbe7a629d16c94d3ac280a6c96dfada9fa87b5ee22facb1c9ef78946bcb6c7ae68453fb0c34ea637c4f3e00e3dffb82e2e1b105705c8bc6215a21ef02", "308203733082025ba00302010202043dba59d8300d06092a864886f70d01010b0500306a310b3009060355040613025553310b3009060355040813024341311630140603550407130d4d6f756e7461696e20566965773111300f060355040a13084c696e6b6564496e3111300f060355040b13084c696e6b6564496e3110300e06035504031307556e6b6e6f776e301e170d3134303532383137333031345a170d3431313031333137333031345a306a310b3009060355040613025553310b3009060355040813024341311630140603550407130d4d6f756e7461696e20566965773111300f060355040a13084c696e6b6564496e3111300f060355040b13084c696e6b6564496e3110300e06035504031307556e6b6e6f776e30820122300d06092a864886f70d01010105000382010f003082010a0282010100a2654e8f66991e6473dce73d1b7fcf75e6cb200d06757d15acd29827323e1f39e05583e079352f03d5ded9e148e3bde9346e8bf0a8ff7f60194b7ab1e6a0b8d08347fc3ec9565dc2842b476c05499860224eed24fbc3329772acbb6e6c1c15695bcd4bd9c4c3ffdd25730bf318e3ef2283e7a16936c2ae879eeb00ad8b957307ce82d9552089b21efbae96b4fb5997b2fb15bc48c948015af4c3580ad7810d41d0680eb96613a4d7964e2ef2fe1ee48bc971465cd15acc8b6ae9ff84e58120a1bb83cfa807d9e54885bb14915158d2a08fa51698f0bd248b2a0994d788b3765abae11b153d44eea04df02418bb4a9de12a293140d9e0e93d7c71d21eb65d59570203010001a321301f301d0603551d0e04160414fb2ff2c17c0a45aea270fa2e08fefa56d5f7e08e300d06092a864886f70d01010b05000382010100a11aff75cfaf3cdf031cc70b8ce0ca1b054be72b4da3be82d3890e167c3fe0b57bd99c5ef2046d244b01a673cee7852c9ff32967ca8da8937cdde37a6a29e1ec16a20d8af02859b8d45ce60fe2aaaf696a87bd8271188ecba0dc50019115f92e9d38ff5c5b2c96ae4bbdedb74f83a2818dd9e4b14777b736a129caae220de2d1fc54a1af26801632a22bdf020df601809d1053d458a7ca843cc2b465a2226bdd7cd6f64847c44812aa9324fb9f02ad91eafca2d3e91cd9440e8ca4d35ed4711753a8e88fd0e8e157d68b61ff9869e62b86c2a0808bced299ce4478ee74751bf04486554d76ab72d6fcad243cb5d221a5454359d60ad846bbc286505f54b7fd04", "3082033930820221a00302010202041f29f54c300d06092a864886f70d01010b0500304c310b3009060355040613025553311330110603550408130a43616c69666f726e6961311430120603550407130b43617270696e746572696131123010060355040a13096c796e64612e636f6d3020170d3133303632373134343933395a180f32313133303630333134343933395a304c310b3009060355040613025553311330110603550408130a43616c69666f726e6961311430120603550407130b43617270696e746572696131123010060355040a13096c796e64612e636f6d30820122300d06092a864886f70d01010105000382010f003082010a0282010100b50c80c418abff570a3521a46826e2e468a8052d2dd078c81e50ca60f56257d9e5fa1eda4e0ea0fef1e356ecf21392c1c06ebd4316a6b7c71ea822bfec1093097087eb1f96082a1581719e63f9505a5808532a011801a6047318c5a1a72d0b18701366dffce2e448fa48bc061806338923f92fd95d70ddfe12b55c067d537809222280dfe2232f0adac40e64139e2e55516f27640515713e87410d70b3475fa03b8b9d3fb548e37f727f9f0cdf18471ac5d51507fde0f92c710a79ee9bd10cf8d8a90a717cd2dd77f3ec615ff14dc3dee38cae7bb1405846e3e215b320c508e1eaaafb151f65687024397c60a34d2ebac6ccd605745389b930c6679a8c30b9310203010001a321301f301d0603551d0e041604140f8bbe24ca0d13e18e395a6f9494559308b80d6b300d06092a864886f70d01010b05000382010100b21f8e8c370959407e33a0194f3d0ba8ae72d22b50babfc574573cc5e7aea443b889bae148cdf3be913da3a508c8a863b184553e2978a07edb9fd1125591586b4b851ddddb55e20f72d8a83dbfd64cebbf72d83828afe0e0c3beb04a0ce81ad901f77ff83b78e4e67b0813f8183be8ec17c5f831c1b9e8df60a538a02e1238c5b0e4a871179536320e3afd07226a4cfca2b1c2ad9a5a2996a04b303e4cab0fcd1b1dbc8016694f9e5eca075aa381daa51e39c9e46dc34708068944af7012a702eb3f9cb462423b1ac5a5f19a3bb13060cf74d5d596b7474e2f9c361db512f1b005d4d0601aa77bf7fa8b9ac9898f95289037dad8c574e8396a9217c7f1aa3448", "308203733082025ba003020102020427527bec300d06092a864886f70d01010b05003069310b3009060355040613025553310b3009060355040813024341311230100603550407130953756e6e7976616c653111300f060355040a13084c696e6b6564496e310c300a060355040b13034c4544311830160603550403130f4d69636861656c204f6c69766965723020170d3135303830343030333831305a180f32313135303830343030333831305a3069310b3009060355040613025553310b3009060355040813024341311230100603550407130953756e6e7976616c653111300f060355040a13084c696e6b6564496e310c300a060355040b13034c4544311830160603550403130f4d69636861656c204f6c697669657230820122300d06092a864886f70d01010105000382010f003082010a0282010100c1443b523b186894ecbae34b23d6cbecd51a0053b8565468f3132c503cff1d7ad7bd0f39ca6883d3c8e9b902c260495960dd39804c844e0c0e48f5d5b9597bacf14b05fbe60e96aba8c95ce89ff3faced1954e8b31530d268211dc91cd35babd3cfbe668ef445aeb83fb1093750e6cd7d3520f2346d6458d4734e1ee35c990341a4ccf3dcfa0f3418f85c43364f7a12da17955aa55f3517f75b23e2669ffb4715184e4deca5c6ba0aad135968e9240f6b7282a33c82522e89637df6e8cdb9a6f8113c7c9561d20addbd7fad69bb00f558aafd304a1166bba9b0d4fd993b35c4cd35b30c45a046ae11a06b790b0468a83664d51c6372ed3b601c9caa0533adcdd0203010001a321301f301d0603551d0e041604149edeb545b7a12e43cecdfe2fc0ae2640e06c1393300d06092a864886f70d01010b05000382010100988c3d6e71da7d8695aa878fffc4d2ddc7c5575455900d4f8697a33612cfa7e65f1d89ceeb481103863c0e527c904bc665b2210166b75a7a21c010a587ecb7dec2b2a2e1e8165e1acce993d2402771edffb872f5306eaef36d02dc8c165dbe3c8c48bb03523c5a514d3801290c95011d3ea023157c130ec2e480e5af64961d8379e8193e0aaab47e2240e4df393e31a49bd1161f47ca040a094a74e932d8cc57a9240907fc5613976f0390cca8c566d82c2773f63c235aefe264f10845edac5231f5ac01bc6da13e5e413e3fa52ccfa86dadc3f5ae282942494e5922defdb7b9ba46590e13a14889fb5b351f9092c670e68a073a5916f8f71e3cbc4312781b8c" };
  private final IAuthService.Stub mBinder = new IAuthService.Stub()
  {
    private static Map<String, String> getSignedInUserWithProfileData(String paramAnonymousString, Context paramAnonymousContext, boolean paramAnonymousBoolean)
    {
      Object localObject = null;
      if (LiSSOService.verifyCallerSignature(paramAnonymousContext, getCallingUid()))
      {
        LiAuth localLiAuth = LiSSOService.getLiAuth(paramAnonymousContext);
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase(localLiAuth.getBaseHost())) && (!TextUtils.isEmpty(localLiAuth.getHttpStack().getCookie("li_at", Uri.parse(paramAnonymousString).getHost()))))
        {
          paramAnonymousString = paramAnonymousContext.getSharedPreferences("auth_library_prefs", 0);
          if (TextUtils.isEmpty(paramAnonymousString.getString("auth_username", null))) {}
          for (paramAnonymousString = (String)localObject; (paramAnonymousString == null) || ((!paramAnonymousBoolean) && (!TextUtils.isEmpty(username)) && (!username.contains("@"))); paramAnonymousString = new LiSSOInfo(paramAnonymousContext, paramAnonymousString)) {
            return Collections.emptyMap();
          }
          paramAnonymousContext = new HashMap();
          paramAnonymousContext.put("auth_username", username);
          paramAnonymousContext.put("auth_member_id", memberID);
          paramAnonymousContext.put("auth_first_name", firstName);
          paramAnonymousContext.put("auth_last_name", lastName);
          paramAnonymousContext.put("auth_full_name", fullName);
          paramAnonymousContext.put("auth_short_full_name", shortFullName);
          paramAnonymousContext.put("auth_headline", headline);
          paramAnonymousContext.put("auth_picture_url", pictureUrl);
          paramAnonymousContext.put("auth_package_name", pkgName);
          paramAnonymousContext.put("auth_app_name", appName);
          return paramAnonymousContext;
        }
      }
      return Collections.emptyMap();
    }
    
    public final Map getEmailAndPhoneSignedInUserWithProfileData(String paramAnonymousString)
      throws RemoteException
    {
      return getSignedInUserWithProfileData(paramAnonymousString, LiSSOService.this, true);
    }
    
    public final Bitmap getProfilePicForUser(String paramAnonymousString)
      throws RemoteException
    {
      Object localObject2 = null;
      LiSSOService localLiSSOService = LiSSOService.this;
      Object localObject1 = localObject2;
      if (LiSSOService.verifyCallerSignature(localLiSSOService, getCallingUid()))
      {
        String str = localLiSSOService.getSharedPreferences("auth_library_prefs", 0).getString("auth_username", null);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramAnonymousString))
        {
          localObject1 = localObject2;
          if (paramAnonymousString.equalsIgnoreCase(str)) {
            localObject1 = LiSSOInfo.loadPicture(localLiSSOService);
          }
        }
      }
      return (Bitmap)localObject1;
    }
    
    public final Map<String, String> getSignedInUserWithProfileData(String paramAnonymousString)
      throws RemoteException
    {
      return getSignedInUserWithProfileData(paramAnonymousString, LiSSOService.this, false);
    }
    
    public final List<String> getTokensForUser(String paramAnonymousString)
      throws RemoteException
    {
      ArrayList localArrayList = new ArrayList();
      LiSSOService localLiSSOService = LiSSOService.this;
      if (LiSSOService.verifyCallerSignature(localLiSSOService, getCallingUid()))
      {
        String str = LiSharedPrefUtils.getString(localLiSSOService, "auth_username", null);
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equalsIgnoreCase(str)))
        {
          paramAnonymousString = LiSSOService.getLiAuth(localLiSSOService).getHttpStack().getCookies().iterator();
          while (paramAnonymousString.hasNext()) {
            localArrayList.add((String)paramAnonymousString.next());
          }
        }
      }
      return localArrayList;
    }
    
    public final void signout()
      throws RemoteException
    {
      LiSSOService localLiSSOService = LiSSOService.this;
      int i = getCallingUid();
      LiAuth localLiAuth;
      Intent localIntent;
      String str;
      if (LiSSOService.verifyCallerSignature(localLiSSOService, i))
      {
        localLiAuth = LiSSOService.getLiAuth(localLiSSOService);
        localIntent = new Intent("com.linkedin.android.EXTERNAL_SSO_LOGOUT_ACTION");
        str = localLiSSOService.getPackageManager().getPackagesForUid(i)[0];
        i = -1;
      }
      try
      {
        int j = getPackageManagergetPackageInfo0versionCode;
        i = j;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;) {}
      }
      localIntent.putExtra("CALLING_PACKAGE_NAME", str);
      localIntent.putExtra("CALLING_PACKAGE_VERSION", i);
      LocalBroadcastManager.getInstance(localLiSSOService).sendBroadcastSync(localIntent);
      localLiAuth.ssoLogout(localLiSSOService);
    }
  };
  
  public static LiAuth getLiAuth(Context paramContext)
  {
    return LiAuthProvider.getInstance(paramContext);
  }
  
  public static boolean verifyCallerSignature(Context paramContext, int paramInt)
  {
    int i = 0;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject = paramContext.getPackageManager();
    paramContext = ((PackageManager)localObject).getPackagesForUid(paramInt);
    bool2 = bool1;
    String str1;
    if (paramContext != null)
    {
      bool2 = bool1;
      if (paramContext.length > 0)
      {
        str1 = paramContext[0];
        new StringBuilder("packages length = ").append(paramContext.length);
        bool2 = bool4;
      }
    }
    try
    {
      localObject = getPackageInfo64signatures;
      bool2 = bool4;
      str1 = localObject[0].toCharsString();
      bool2 = bool4;
      String[] arrayOfString = approvedSignatures;
      bool2 = bool4;
      int j = arrayOfString.length;
      paramInt = i;
      for (;;)
      {
        bool1 = bool3;
        if (paramInt < j)
        {
          String str2 = arrayOfString[paramInt];
          bool2 = bool4;
          localObject[0].toCharsString();
          bool2 = bool4;
          if (str2.equalsIgnoreCase(str1)) {
            bool1 = true;
          }
        }
        else
        {
          bool2 = bool1;
          if (!bool1)
          {
            bool2 = bool1;
            new StringBuilder("caller").append(paramContext[0]).append(" signature ").append(str1).append(" not verified");
            bool2 = bool1;
          }
          return bool2;
        }
        paramInt += 1;
      }
      return bool2;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return mBinder;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.sso.LiSSOService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */