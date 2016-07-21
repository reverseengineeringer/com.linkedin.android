package android.support.graphics.drawable;

import android.graphics.Matrix;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;

final class VectorDrawableCompat$VGroup
{
  int mChangingConfigurations;
  final ArrayList<Object> mChildren = new ArrayList();
  String mGroupName = null;
  final Matrix mLocalMatrix = new Matrix();
  float mPivotX = 0.0F;
  float mPivotY = 0.0F;
  float mRotate = 0.0F;
  float mScaleX = 1.0F;
  float mScaleY = 1.0F;
  final Matrix mStackedMatrix = new Matrix();
  int[] mThemeAttrs;
  float mTranslateX = 0.0F;
  float mTranslateY = 0.0F;
  
  public VectorDrawableCompat$VGroup() {}
  
  public VectorDrawableCompat$VGroup(VGroup paramVGroup, ArrayMap<String, Object> paramArrayMap)
  {
    mRotate = mRotate;
    mPivotX = mPivotX;
    mPivotY = mPivotY;
    mScaleX = mScaleX;
    mScaleY = mScaleY;
    mTranslateX = mTranslateX;
    mTranslateY = mTranslateY;
    mThemeAttrs = mThemeAttrs;
    mGroupName = mGroupName;
    mChangingConfigurations = mChangingConfigurations;
    if (mGroupName != null) {
      paramArrayMap.put(mGroupName, this);
    }
    mLocalMatrix.set(mLocalMatrix);
    ArrayList localArrayList = mChildren;
    int i = 0;
    while (i < localArrayList.size())
    {
      paramVGroup = localArrayList.get(i);
      if ((paramVGroup instanceof VGroup))
      {
        paramVGroup = (VGroup)paramVGroup;
        mChildren.add(new VGroup(paramVGroup, paramArrayMap));
        i += 1;
      }
      else
      {
        if ((paramVGroup instanceof VectorDrawableCompat.VFullPath)) {}
        for (paramVGroup = new VectorDrawableCompat.VFullPath((VectorDrawableCompat.VFullPath)paramVGroup);; paramVGroup = new VectorDrawableCompat.VClipPath((VectorDrawableCompat.VClipPath)paramVGroup))
        {
          mChildren.add(paramVGroup);
          if (mPathName == null) {
            break;
          }
          paramArrayMap.put(mPathName, paramVGroup);
          break;
          if (!(paramVGroup instanceof VectorDrawableCompat.VClipPath)) {
            break label315;
          }
        }
        label315:
        throw new IllegalStateException("Unknown object in the tree!");
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat.VGroup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */