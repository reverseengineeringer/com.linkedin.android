package com.linkedin.messengerlib.ui.messagelist;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.R.dimen;
import com.linkedin.messengerlib.R.id;
import com.linkedin.messengerlib.R.layout;
import com.linkedin.messengerlib.consumers.ActorDataManager;
import com.linkedin.messengerlib.utils.MessengerGhostImageUtils;

public class LinearFacepileView
  extends FrameLayout
{
  public LiImageView face1;
  public LiImageView face2;
  public LiImageView face3;
  private int picSize;
  
  public LinearFacepileView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public LinearFacepileView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public LinearFacepileView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.linear_facepile_view, this, true);
    face1 = ((LiImageView)paramContext.findViewById(R.id.linear_facepile_1));
    face2 = ((LiImageView)paramContext.findViewById(R.id.linear_facepile_2));
    face3 = ((LiImageView)paramContext.findViewById(R.id.linear_facepile_3));
    picSize = getResources().getDimensionPixelSize(R.dimen.ad_entity_photo_1);
  }
  
  public final void loadImage(MessengerLibApi paramMessengerLibApi, LiImageView paramLiImageView, Image paramImage)
  {
    paramLiImageView.setVisibility(0);
    loadImageFromId(paramMessengerLibApi, paramLiImageView, ActorDataManager.getPictureUrl(paramImage));
  }
  
  public final void loadImageFromId(MessengerLibApi paramMessengerLibApi, LiImageView paramLiImageView, String paramString)
  {
    paramMessengerLibApi.loadImageFromUrl(paramMessengerLibApi.getImageUrl(paramString, picSize, picSize), MessengerGhostImageUtils.getGhostDrawable(paramMessengerLibApi, null, R.dimen.ad_entity_photo_1), paramLiImageView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.messagelist.LinearFacepileView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */