package android.support.graphics.drawable;

import android.content.res.TypedArray;

final class VectorDrawableCompat$VClipPath
  extends VectorDrawableCompat.VPath
{
  public VectorDrawableCompat$VClipPath() {}
  
  public VectorDrawableCompat$VClipPath(VClipPath paramVClipPath)
  {
    super(paramVClipPath);
  }
  
  public final boolean isClipPath()
  {
    return true;
  }
  
  final void updateStateFromTypedArray(TypedArray paramTypedArray)
  {
    String str = paramTypedArray.getString(0);
    if (str != null) {
      mPathName = str;
    }
    paramTypedArray = paramTypedArray.getString(1);
    if (paramTypedArray != null) {
      mNodes = PathParser.createNodesFromPathData(paramTypedArray);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat.VClipPath
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */