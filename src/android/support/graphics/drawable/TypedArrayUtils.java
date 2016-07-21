package android.support.graphics.drawable;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

final class TypedArrayUtils
{
  public static int getNamedColor(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getColor(paramInt1, paramInt2);
  }
  
  public static float getNamedFloat(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, float paramFloat)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return paramFloat;
    }
    return paramTypedArray.getFloat(paramInt, paramFloat);
  }
  
  public static int getNamedInt$7903c789(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return -1;
    }
    return paramTypedArray.getInt(paramInt, -1);
  }
  
  public static boolean hasAttribute(XmlPullParser paramXmlPullParser, String paramString)
  {
    return paramXmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString) != null;
  }
}

/* Location:
 * Qualified Name:     android.support.graphics.drawable.TypedArrayUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */