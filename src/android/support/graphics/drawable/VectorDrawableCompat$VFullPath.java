package android.support.graphics.drawable;

import android.content.res.TypedArray;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import org.xmlpull.v1.XmlPullParser;

final class VectorDrawableCompat$VFullPath
  extends VectorDrawableCompat.VPath
{
  float mFillAlpha = 1.0F;
  int mFillColor = 0;
  int mFillRule;
  float mStrokeAlpha = 1.0F;
  int mStrokeColor = 0;
  Paint.Cap mStrokeLineCap = Paint.Cap.BUTT;
  Paint.Join mStrokeLineJoin = Paint.Join.MITER;
  float mStrokeMiterlimit = 4.0F;
  float mStrokeWidth = 0.0F;
  private int[] mThemeAttrs;
  float mTrimPathEnd = 1.0F;
  float mTrimPathOffset = 0.0F;
  float mTrimPathStart = 0.0F;
  
  public VectorDrawableCompat$VFullPath() {}
  
  public VectorDrawableCompat$VFullPath(VFullPath paramVFullPath)
  {
    super(paramVFullPath);
    mThemeAttrs = mThemeAttrs;
    mStrokeColor = mStrokeColor;
    mStrokeWidth = mStrokeWidth;
    mStrokeAlpha = mStrokeAlpha;
    mFillColor = mFillColor;
    mFillRule = mFillRule;
    mFillAlpha = mFillAlpha;
    mTrimPathStart = mTrimPathStart;
    mTrimPathEnd = mTrimPathEnd;
    mTrimPathOffset = mTrimPathOffset;
    mStrokeLineCap = mStrokeLineCap;
    mStrokeLineJoin = mStrokeLineJoin;
    mStrokeMiterlimit = mStrokeMiterlimit;
  }
  
  final void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
  {
    mThemeAttrs = null;
    if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData")) {
      return;
    }
    Object localObject = paramTypedArray.getString(0);
    if (localObject != null) {
      mPathName = ((String)localObject);
    }
    localObject = paramTypedArray.getString(2);
    if (localObject != null) {
      mNodes = PathParser.createNodesFromPathData((String)localObject);
    }
    mFillColor = TypedArrayUtils.getNamedColor(paramTypedArray, paramXmlPullParser, "fillColor", 1, mFillColor);
    mFillAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, mFillAlpha);
    int i = TypedArrayUtils.getNamedInt$7903c789(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8);
    localObject = mStrokeLineCap;
    switch (i)
    {
    default: 
      mStrokeLineCap = ((Paint.Cap)localObject);
      i = TypedArrayUtils.getNamedInt$7903c789(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9);
      localObject = mStrokeLineJoin;
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      mStrokeLineJoin = ((Paint.Join)localObject);
      mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, mStrokeMiterlimit);
      mStrokeColor = TypedArrayUtils.getNamedColor(paramTypedArray, paramXmlPullParser, "strokeColor", 3, mStrokeColor);
      mStrokeAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, mStrokeAlpha);
      mStrokeWidth = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, mStrokeWidth);
      mTrimPathEnd = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, mTrimPathEnd);
      mTrimPathOffset = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, mTrimPathOffset);
      mTrimPathStart = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, mTrimPathStart);
      return;
      localObject = Paint.Cap.BUTT;
      break;
      localObject = Paint.Cap.ROUND;
      break;
      localObject = Paint.Cap.SQUARE;
      break;
      localObject = Paint.Join.MITER;
      continue;
      localObject = Paint.Join.ROUND;
      continue;
      localObject = Paint.Join.BEVEL;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat.VFullPath
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */