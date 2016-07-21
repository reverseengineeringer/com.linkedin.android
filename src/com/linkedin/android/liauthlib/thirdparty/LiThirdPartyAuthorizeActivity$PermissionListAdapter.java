package com.linkedin.android.liauthlib.thirdparty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.linkedin.android.liauthlib.R.id;
import com.linkedin.android.liauthlib.R.layout;
import java.util.List;

final class LiThirdPartyAuthorizeActivity$PermissionListAdapter
  extends ArrayAdapter<LiThirdPartyPermissionInfo>
{
  public LiThirdPartyAuthorizeActivity$PermissionListAdapter(Context paramContext, List<LiThirdPartyPermissionInfo> paramList) {}
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this$0.getLayoutInflater().inflate(R.layout.permission_list_item, null);
    }
    paramView = (LiThirdPartyPermissionInfo)getItem(paramInt);
    ((ImageView)paramViewGroup.findViewById(R.id.perm_list_pic)).setImageResource(LiThirdPartyPermissionInfo.getPermissionImageResource(m_name));
    ((TextView)paramViewGroup.findViewById(R.id.perm_list_item_title_text)).setText(m_title);
    return paramViewGroup;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.thirdparty.LiThirdPartyAuthorizeActivity.PermissionListAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */