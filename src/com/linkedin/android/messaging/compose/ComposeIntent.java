package com.linkedin.android.messaging.compose;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.messengerlib.recipient.MessengerRecipient;
import com.linkedin.messengerlib.recipient.MessengerRecipient.Type;
import com.linkedin.messengerlib.utils.MiniProfileUtil;
import javax.inject.Inject;

public final class ComposeIntent
  extends IntentFactory<ComposeBundleBuilder>
  implements DeeplinkIntent
{
  private static void setRecipientId(String paramString, ComposeBundleBuilder paramComposeBundleBuilder)
  {
    MessengerRecipient localMessengerRecipient = new MessengerRecipient((byte)0);
    if (TextUtils.isEmpty(paramString)) {
      type = MessengerRecipient.Type.NONE;
    }
    for (;;)
    {
      switch (ComposeIntent.1.$SwitchMap$com$linkedin$messengerlib$recipient$MessengerRecipient$Type[type.ordinal()])
      {
      default: 
        return;
        if (TextUtils.isDigitsOnly(paramString))
        {
          type = MessengerRecipient.Type.MEMBER_ID;
          memberId = paramString;
        }
        else
        {
          type = MessengerRecipient.Type.MINI_PROFILE_URN;
          miniProfileUrn = MiniProfileUtil.newMiniProfileUrn(paramString);
        }
        break;
      }
    }
    paramComposeBundleBuilder.setRecipientMemberId(memberId);
    return;
    paramComposeBundleBuilder.setRecipientMiniProfileUrns(new String[] { miniProfileUrn.toString() });
  }
  
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramLinkingRoutes = new ComposeBundleBuilder();
    if ((paramArrayMap != null) && (!paramArrayMap.isEmpty()))
    {
      paramString = (String)paramArrayMap.get("body");
      if (paramString != null) {
        paramLinkingRoutes.setBody(paramString);
      }
      paramArrayMap = (String)paramArrayMap.get("recipientId");
      if (paramArrayMap != null) {
        setRecipientId(paramArrayMap, paramLinkingRoutes);
      }
    }
    for (;;)
    {
      return provideIntent(paramContext).putExtras(paramLinkingRoutes.build());
      Object localObject = Uri.parse(paramString);
      paramArrayMap = ((Uri)localObject).getQueryParameter("connId");
      paramString = ((Uri)localObject).getQueryParameter("body");
      localObject = ((Uri)localObject).getQueryParameter("groupId");
      if (paramArrayMap != null) {
        setRecipientId(paramArrayMap, paramLinkingRoutes);
      }
      if (paramString != null) {
        paramLinkingRoutes.setBody(paramString);
      }
      if (localObject != null) {
        bundle.putString("GROUP_URN", (String)localObject);
      }
    }
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, ComposeActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.compose.ComposeIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */