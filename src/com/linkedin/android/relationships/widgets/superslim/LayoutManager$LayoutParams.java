package com.linkedin.android.relationships.widgets.superslim;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.linkedin.android.R.styleable;
import com.linkedin.android.logger.Log;

public class LayoutManager$LayoutParams
  extends RecyclerView.LayoutParams
{
  public int headerDisplay;
  public boolean headerEndMarginIsAuto;
  public int headerMarginEnd;
  public int headerMarginStart;
  public boolean headerStartMarginIsAuto;
  public boolean isHeader;
  public int mFirstPosition;
  String sectionManager;
  int sectionManagerKind = 1;
  
  public LayoutManager$LayoutParams()
  {
    super(-2, -2);
    isHeader = false;
  }
  
  @TargetApi(21)
  public LayoutManager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.superslim_LayoutManager);
    isHeader = paramContext.getBoolean(0, false);
    headerDisplay = paramContext.getInt(1, 17);
    mFirstPosition = paramContext.getInt(2, -1);
    if (Build.VERSION.SDK_INT < 21)
    {
      paramAttributeSet = new TypedValue();
      paramContext.getValue(4, paramAttributeSet);
      if (type == 5)
      {
        bool1 = true;
        loadHeaderStartMargin(paramContext, bool1);
        paramContext.getValue(5, paramAttributeSet);
        if (type != 5) {
          break label150;
        }
        bool1 = true;
        label110:
        loadHeaderEndMargin(paramContext, bool1);
        paramContext.getValue(3, paramAttributeSet);
        if (type != 3) {
          break label155;
        }
      }
      label150:
      label155:
      for (bool1 = bool2;; bool1 = false)
      {
        loadSlm(paramContext, bool1);
        paramContext.recycle();
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label110;
      }
    }
    if (paramContext.getType(4) == 5)
    {
      bool1 = true;
      label171:
      loadHeaderStartMargin(paramContext, bool1);
      if (paramContext.getType(5) != 5) {
        break label219;
      }
      bool1 = true;
      label188:
      loadHeaderEndMargin(paramContext, bool1);
      if (paramContext.getType(3) != 3) {
        break label224;
      }
    }
    label219:
    label224:
    for (boolean bool1 = true;; bool1 = false)
    {
      loadSlm(paramContext, bool1);
      break;
      bool1 = false;
      break label171;
      bool1 = false;
      break label188;
    }
  }
  
  @Deprecated
  public LayoutManager$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    init(paramLayoutParams);
  }
  
  @Deprecated
  public LayoutManager$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
    init(paramMarginLayoutParams);
  }
  
  public static LayoutParams from(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams == null)
    {
      Log.w("SuperSLiM", "Null value passed in call to LayoutManager.LayoutParams.from().");
      return new LayoutParams();
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  private void init(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams))
    {
      paramLayoutParams = (LayoutParams)paramLayoutParams;
      isHeader = isHeader;
      headerDisplay = headerDisplay;
      mFirstPosition = mFirstPosition;
      sectionManager = sectionManager;
      sectionManagerKind = sectionManagerKind;
      headerMarginEnd = headerMarginEnd;
      headerMarginStart = headerMarginStart;
      headerEndMarginIsAuto = headerEndMarginIsAuto;
      headerStartMarginIsAuto = headerStartMarginIsAuto;
      return;
    }
    isHeader = false;
    headerDisplay = 17;
    headerMarginEnd = -1;
    headerMarginStart = -1;
    headerStartMarginIsAuto = true;
    headerEndMarginIsAuto = true;
    sectionManagerKind = 1;
  }
  
  private void loadHeaderEndMargin(TypedArray paramTypedArray, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      headerEndMarginIsAuto = false;
      headerMarginEnd = paramTypedArray.getDimensionPixelSize(5, 0);
      return;
    }
    headerEndMarginIsAuto = true;
  }
  
  private void loadHeaderStartMargin(TypedArray paramTypedArray, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      headerStartMarginIsAuto = false;
      headerMarginStart = paramTypedArray.getDimensionPixelSize(4, 0);
      return;
    }
    headerStartMarginIsAuto = true;
  }
  
  private void loadSlm(TypedArray paramTypedArray, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      sectionManager = paramTypedArray.getString(3);
      if (TextUtils.isEmpty(sectionManager))
      {
        sectionManagerKind = 1;
        return;
      }
      sectionManagerKind = -1;
      return;
    }
    sectionManagerKind = paramTypedArray.getInt(3, 1);
  }
  
  public final int getTestedFirstPosition()
  {
    if (mFirstPosition == -1) {
      throw new LayoutManager.LayoutParams.MissingFirstPositionException(this);
    }
    return mFirstPosition;
  }
  
  public final boolean isHeaderEndAligned()
  {
    return (headerDisplay & 0x4) != 0;
  }
  
  public final boolean isHeaderInline()
  {
    return (headerDisplay & 0x1) != 0;
  }
  
  public final boolean isHeaderOverlay()
  {
    return (headerDisplay & 0x8) != 0;
  }
  
  public final boolean isHeaderStartAligned()
  {
    return (headerDisplay & 0x2) != 0;
  }
  
  public final boolean isHeaderSticky()
  {
    return (headerDisplay & 0x10) != 0;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.widgets.superslim.LayoutManager.LayoutParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */