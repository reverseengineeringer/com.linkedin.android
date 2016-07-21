package com.linkedin.android.feed.shared;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.linkedin.android.artdeco.ArtDecoTypefaceLoader;
import com.linkedin.android.imageloader.ManagedDrawableWrapper;
import com.linkedin.android.imageloader.ManagedLayerDrawable;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.network.DrawableRequest;
import com.linkedin.android.infra.network.DrawableRequest.1;
import com.linkedin.android.infra.network.DrawableRequest.DrawableCallback;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.GhostImage;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class StackedImagesDrawable
  extends ManagedLayerDrawable
{
  private final int borderColor;
  private final int borderWidthPx;
  private final List<DrawableRequest.DrawableCallback> callbacks;
  private final int drawableHeight;
  private final int drawableWidth;
  private final boolean hasRoundedImages;
  private final int imageSizePx;
  private final List<ImageModel> images;
  private final boolean isRtl;
  private final MediaCenter mediaCenter;
  private final int numDrawables;
  private final List<DrawableRequest> requests;
  
  private StackedImagesDrawable(Context paramContext, MediaCenter paramMediaCenter, List<ImageModel> paramList, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(getDefaultDrawableArray(paramList.size(), paramInt1));
    paramContext = paramContext.getApplicationContext();
    int i = paramList.size();
    callbacks = new ArrayList(i);
    requests = new ArrayList(i);
    mediaCenter = paramMediaCenter;
    images = paramList;
    imageSizePx = paramContext.getResources().getDimensionPixelSize(paramInt2);
    borderColor = ContextCompat.getColor(paramContext, 2131624338);
    borderWidthPx = paramContext.getResources().getDimensionPixelSize(paramInt3);
    if (paramInt1 > 0) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      numDrawables = (paramInt2 + i);
      drawableWidth = (Math.round((numDrawables - 1) * imageSizePx * 0.5F) + imageSizePx);
      drawableHeight = imageSizePx;
      isRtl = JellyBeanMr1Utils.isRTL(paramContext);
      hasRoundedImages = paramBoolean;
      paramInt2 = 0;
      while (paramInt2 < numDrawables)
      {
        setId(paramInt2, paramInt2);
        paramInt2 += 1;
      }
    }
    loadImageDrawables();
    if (paramInt1 > 0) {
      setDrawableAtPosition(new RollupCountDrawable(paramContext, paramInt1, imageSizePx, borderWidthPx, (byte)0), numDrawables - 1);
    }
  }
  
  private static Drawable[] getDefaultDrawableArray(int paramInt1, int paramInt2)
  {
    if (paramInt2 != -1) {}
    Drawable[] arrayOfDrawable;
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      paramInt2 = paramInt1 + paramInt2;
      arrayOfDrawable = new Drawable[paramInt2];
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        arrayOfDrawable[paramInt1] = new ColorDrawable(0);
        paramInt1 += 1;
      }
    }
    return arrayOfDrawable;
  }
  
  private void loadImageDrawables()
  {
    int j = images.size();
    final int i = 0;
    Object localObject1;
    Object localObject2;
    DrawableRequest localDrawableRequest;
    DrawableRequest.DrawableCallback localDrawableCallback;
    if (i < j)
    {
      callbacks.add(new DrawableRequest.DrawableCallback()
      {
        public final void onDrawableLoaded$295bc2c2(ManagedDrawableWrapper paramAnonymousManagedDrawableWrapper)
        {
          StackedImagesDrawable.this.setDrawableAtPosition(drawable, i);
          invalidateSelf();
        }
      });
      localObject1 = requests;
      localObject2 = mediaCenter.loadDrawable$569cbe8c((ImageModel)images.get(i));
      circular = hasRoundedImages;
      sideLengthPx = imageSizePx;
      int k = borderColor;
      int m = borderWidthPx;
      borderColor = k;
      borderWidthPx = m;
      borderSet = true;
      ((List)localObject1).add(localObject2);
      localDrawableRequest = (DrawableRequest)requests.get(i);
      localDrawableCallback = (DrawableRequest.DrawableCallback)callbacks.get(i);
      if (imageModel.ghostImage != null)
      {
        localObject1 = imageModel.ghostImage.getDrawable(context).mutate().getConstantState().newDrawable(context.getResources());
        if (!borderSet) {
          break label440;
        }
        if (sideLengthPx >= 0) {
          break label303;
        }
      }
    }
    label303:
    label440:
    for (;;)
    {
      localDrawableCallback.onDrawableLoaded$295bc2c2(new ManagedDrawableWrapper((Drawable)localObject1));
      localObject1 = context.getResources();
      imageListener = new DrawableRequest.1(localDrawableRequest, new WeakReference(localDrawableCallback), (Resources)localObject1);
      mediaCenter.load(imageModel, rumSessionId).into(imageListener);
      i += 1;
      break;
      if (circular) {}
      for (localObject2 = new OvalShape();; localObject2 = new RectShape())
      {
        localObject2 = new ShapeDrawable((Shape)localObject2);
        Paint localPaint = ((ShapeDrawable)localObject2).getPaint();
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setColor(borderColor);
        localPaint.setStrokeWidth(borderWidthPx);
        ((ShapeDrawable)localObject2).setBounds(0, 0, sideLengthPx, sideLengthPx);
        localObject1 = new LayerDrawable(new Drawable[] { localObject1, localObject2 });
        ((Drawable)localObject1).setBounds(0, 0, sideLengthPx, sideLengthPx);
        break;
      }
      return;
    }
  }
  
  private void setDrawableAtPosition(Drawable paramDrawable, int paramInt)
  {
    setDrawableByLayerId(paramInt, paramDrawable);
    int j = Math.round(paramInt * (imageSizePx * 0.5F));
    int k = drawableWidth - imageSizePx - j;
    int i;
    if (isRtl)
    {
      i = k;
      if (!isRtl) {
        break label71;
      }
    }
    for (;;)
    {
      setLayerInset(paramInt, i, 0, j, 0);
      return;
      i = j;
      break;
      label71:
      j = k;
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return drawableHeight;
  }
  
  public final int getIntrinsicWidth()
  {
    return drawableWidth;
  }
  
  public final int getMinimumHeight()
  {
    return drawableHeight;
  }
  
  public final int getMinimumWidth()
  {
    return drawableWidth;
  }
  
  public static final class Builder
  {
    public int borderWidthRes = 2131493145;
    private final Context context;
    public boolean hasRoundedImages = true;
    public int imageSizeRes = 2131492962;
    private final List<ImageModel> images;
    private final MediaCenter mediaCenter;
    public int rollupCount = -1;
    
    public Builder(Context paramContext, MediaCenter paramMediaCenter, List<ImageModel> paramList)
    {
      context = paramContext;
      mediaCenter = paramMediaCenter;
      images = paramList;
    }
    
    public final StackedImagesDrawable build()
    {
      return new StackedImagesDrawable(context, mediaCenter, images, rollupCount, imageSizeRes, borderWidthRes, hasRoundedImages, (byte)0);
    }
  }
  
  private static final class RollupCountDrawable
    extends LayerDrawable
  {
    private static final int[] APPEARANCE_ATTRIBUTES = { 16842901, 2130771969, 16842904 };
    private final int offsetAmountPx;
    private final int rollupBorderWidthPx;
    private final int sizePx;
    private final int stackedImageBorderWidthPx;
    private final CharSequence text;
    private final Layout textLayout;
    private final TextPaint textPaint = new TextPaint(1);
    
    private RollupCountDrawable(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
    {
      super();
      text = Util.getAppComponent(paramContext).i18NManager().getString(2131231306, new Object[] { Integer.valueOf(Math.min(paramInt1, 99)) });
      sizePx = paramInt2;
      stackedImageBorderWidthPx = paramInt3;
      rollupBorderWidthPx = paramContext.getResources().getDimensionPixelSize(2131493145);
      offsetAmountPx = Math.round(paramInt2 * 0.02F);
      textLayout = configureText(paramContext);
    }
    
    private Layout configureText(Context paramContext)
    {
      int j = sizePx / 2;
      textPaint.setTextSize(j);
      textPaint.setColor(-16777216);
      textPaint.density = getResourcesgetDisplayMetricsdensity;
      textPaint.setDither(true);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(2131361900, APPEARANCE_ATTRIBUTES);
      if (localTypedArray != null)
      {
        i = 0;
        if (i < localTypedArray.getIndexCount())
        {
          k = localTypedArray.getIndex(i);
          switch (k)
          {
          }
          for (;;)
          {
            i += 1;
            break;
            textPaint.setTextSize(localTypedArray.getDimensionPixelSize(k, j));
            continue;
            Object localObject = localTypedArray.getString(k);
            if ((localObject != null) && (!((String)localObject).isEmpty()))
            {
              localObject = ArtDecoTypefaceLoader.typefaceForFontPath(paramContext.getAssets(), (String)localObject);
              if (localObject != null)
              {
                textPaint.setTypeface((Typeface)localObject);
                continue;
                textPaint.setColor(localTypedArray.getColor(k, -16777216));
              }
            }
          }
        }
        localTypedArray.recycle();
      }
      int i = sizePx;
      j = rollupBorderWidthPx;
      int k = stackedImageBorderWidthPx;
      int m = offsetAmountPx;
      return new StaticLayout(text, textPaint, i - j * 2 - k * 2 - m * 2, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      super.draw(paramCanvas);
      Rect localRect = getBounds();
      int i = paramCanvas.save();
      int k = textLayout.getHeight();
      int j = top;
      k = (sizePx - k) / 2;
      int m = offsetAmountPx;
      paramCanvas.translate(left + stackedImageBorderWidthPx + rollupBorderWidthPx, j + k - m);
      textLayout.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.StackedImagesDrawable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */