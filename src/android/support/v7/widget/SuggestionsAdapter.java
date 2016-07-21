package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

final class SuggestionsAdapter
  extends ResourceCursorAdapter
  implements View.OnClickListener
{
  private boolean mClosed = false;
  private final int mCommitIconResId;
  private int mFlagsCol = -1;
  private int mIconName1Col = -1;
  private int mIconName2Col = -1;
  private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
  private final Context mProviderContext;
  int mQueryRefinement = 1;
  private final SearchManager mSearchManager = (SearchManager)mContext.getSystemService("search");
  private final SearchView mSearchView;
  private final SearchableInfo mSearchable;
  private int mText1Col = -1;
  private int mText2Col = -1;
  private int mText2UrlCol = -1;
  private ColorStateList mUrlColor;
  
  public SuggestionsAdapter(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout());
    mSearchView = paramSearchView;
    mSearchable = paramSearchableInfo;
    mCommitIconResId = paramSearchView.getSuggestionCommitIconResId();
    mProviderContext = paramContext;
    mOutsideDrawablesCache = paramWeakHashMap;
  }
  
  private Drawable checkIconCache(String paramString)
  {
    paramString = (Drawable.ConstantState)mOutsideDrawablesCache.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.newDrawable();
  }
  
  private Drawable getActivityIcon(ComponentName paramComponentName)
  {
    Object localObject1 = mContext.getPackageManager();
    Object localObject2;
    int i;
    do
    {
      try
      {
        localObject2 = ((PackageManager)localObject1).getActivityInfo(paramComponentName, 128);
        i = ((ActivityInfo)localObject2).getIconResource();
        if (i == 0)
        {
          localObject1 = null;
          return (Drawable)localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException paramComponentName)
      {
        Log.w("SuggestionsAdapter", paramComponentName.toString());
        return null;
      }
      localObject2 = ((PackageManager)localObject1).getDrawable(paramComponentName.getPackageName(), i, applicationInfo);
      localObject1 = localObject2;
    } while (localObject2 != null);
    Log.w("SuggestionsAdapter", "Invalid icon resource " + i + " for " + paramComponentName.flattenToShortString());
    return null;
  }
  
  public static String getColumnString(Cursor paramCursor, String paramString)
  {
    return getStringOrNull(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  private Drawable getDrawable(Uri paramUri)
  {
    try
    {
      boolean bool = "android.resource".equals(paramUri.getScheme());
      if (bool) {
        try
        {
          Drawable localDrawable1 = getDrawableFromResourceUri(paramUri);
          return localDrawable1;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          throw new FileNotFoundException("Resource does not exist: " + paramUri);
        }
      }
      localInputStream = mProviderContext.getContentResolver().openInputStream(paramUri);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.w("SuggestionsAdapter", "Icon not found: " + paramUri + ", " + localFileNotFoundException.getMessage());
      return null;
    }
    InputStream localInputStream;
    if (localInputStream == null) {
      throw new FileNotFoundException("Failed to open " + paramUri);
    }
    try
    {
      Drawable localDrawable2 = Drawable.createFromStream(localInputStream, null);
      try
      {
        localInputStream.close();
        return localDrawable2;
      }
      catch (IOException localIOException1)
      {
        Log.e("SuggestionsAdapter", "Error closing icon stream for " + paramUri, localIOException1);
        return localDrawable2;
      }
      try
      {
        localIOException1.close();
        throw ((Throwable)localObject);
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Log.e("SuggestionsAdapter", "Error closing icon stream for " + paramUri, localIOException2);
        }
      }
    }
    finally {}
  }
  
  private Drawable getDrawableFromResourceUri(Uri paramUri)
    throws FileNotFoundException
  {
    String str = paramUri.getAuthority();
    if (TextUtils.isEmpty(str)) {
      throw new FileNotFoundException("No authority: " + paramUri);
    }
    Resources localResources;
    List localList;
    try
    {
      localResources = mContext.getPackageManager().getResourcesForApplication(str);
      localList = paramUri.getPathSegments();
      if (localList == null) {
        throw new FileNotFoundException("No path: " + paramUri);
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new FileNotFoundException("No package found for authority: " + paramUri);
    }
    int i = localList.size();
    if (i == 1) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)localList.get(0));
        if (i != 0) {
          break;
        }
        throw new FileNotFoundException("No resource found for: " + paramUri);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new FileNotFoundException("Single path segment is not a resource ID: " + paramUri);
      }
      if (i == 2) {
        i = localResources.getIdentifier((String)localList.get(1), (String)localList.get(0), localNumberFormatException);
      } else {
        throw new FileNotFoundException("More than two path segments: " + paramUri);
      }
    }
    return localResources.getDrawable(i);
  }
  
  private Drawable getDrawableFromResourceValue(String paramString)
  {
    Object localObject1;
    if ((paramString == null) || (paramString.length() == 0) || ("0".equals(paramString))) {
      localObject1 = null;
    }
    for (;;)
    {
      return (Drawable)localObject1;
      try
      {
        int i = Integer.parseInt(paramString);
        String str = "android.resource://" + mProviderContext.getPackageName() + "/" + i;
        localDrawable = checkIconCache(str);
        localObject1 = localDrawable;
        if (localDrawable == null)
        {
          localObject1 = ContextCompat.getDrawable(mProviderContext, i);
          storeInIconCache(str, (Drawable)localObject1);
          return (Drawable)localObject1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Drawable localDrawable = checkIconCache(paramString);
        Object localObject2 = localDrawable;
        if (localDrawable == null)
        {
          localObject2 = getDrawable(Uri.parse(paramString));
          storeInIconCache(paramString, (Drawable)localObject2);
          return (Drawable)localObject2;
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        Log.w("SuggestionsAdapter", "Icon resource not found: " + paramString);
      }
    }
    return null;
  }
  
  private static String getStringOrNull(Cursor paramCursor, int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    try
    {
      paramCursor = paramCursor.getString(paramInt);
      return paramCursor;
    }
    catch (Exception paramCursor)
    {
      Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", paramCursor);
    }
    return null;
  }
  
  private static void setViewDrawable(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      paramImageView.setVisibility(paramInt);
      return;
    }
    paramImageView.setVisibility(0);
    paramDrawable.setVisible(false, false);
    paramDrawable.setVisible(true, false);
  }
  
  private static void setViewText(TextView paramTextView, CharSequence paramCharSequence)
  {
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
  }
  
  private void storeInIconCache(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      mOutsideDrawablesCache.put(paramString, paramDrawable.getConstantState());
    }
  }
  
  private static void updateSpinnerState(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    for (paramCursor = paramCursor.getExtras();; paramCursor = null)
    {
      if ((paramCursor != null) && (paramCursor.getBoolean("in_progress"))) {}
      return;
    }
  }
  
  public final void bindView$4693bf34(View paramView, Cursor paramCursor)
  {
    ChildViewCache localChildViewCache = (ChildViewCache)paramView.getTag();
    int i = 0;
    if (mFlagsCol != -1) {
      i = paramCursor.getInt(mFlagsCol);
    }
    if (mText1 != null)
    {
      paramView = getStringOrNull(paramCursor, mText1Col);
      setViewText(mText1, paramView);
    }
    Object localObject;
    if (mText2 != null)
    {
      localObject = getStringOrNull(paramCursor, mText2UrlCol);
      if (localObject != null)
      {
        if (mUrlColor == null)
        {
          paramView = new TypedValue();
          mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, paramView, true);
          mUrlColor = mContext.getResources().getColorStateList(resourceId);
        }
        paramView = new SpannableString((CharSequence)localObject);
        paramView.setSpan(new TextAppearanceSpan(null, 0, 0, mUrlColor, null), 0, ((CharSequence)localObject).length(), 33);
        if (!TextUtils.isEmpty(paramView)) {
          break label343;
        }
        if (mText1 != null)
        {
          mText1.setSingleLine(false);
          mText1.setMaxLines(2);
        }
        label200:
        setViewText(mText2, paramView);
      }
    }
    else
    {
      if (mIcon1 != null)
      {
        ImageView localImageView = mIcon1;
        if (mIconName1Col != -1) {
          break label372;
        }
        paramView = null;
        label234:
        setViewDrawable(localImageView, paramView, 4);
      }
      if (mIcon2 != null)
      {
        localObject = mIcon2;
        if (mIconName2Col != -1) {
          break label517;
        }
      }
    }
    label343:
    label372:
    label517:
    for (paramView = null;; paramView = getDrawableFromResourceValue(paramCursor.getString(mIconName2Col)))
    {
      setViewDrawable((ImageView)localObject, paramView, 8);
      if ((mQueryRefinement != 2) && ((mQueryRefinement != 1) || ((i & 0x1) == 0))) {
        break label535;
      }
      mIconRefine.setVisibility(0);
      mIconRefine.setTag(mText1.getText());
      mIconRefine.setOnClickListener(this);
      return;
      paramView = getStringOrNull(paramCursor, mText2Col);
      break;
      if (mText1 == null) {
        break label200;
      }
      mText1.setSingleLine(true);
      mText1.setMaxLines(1);
      break label200;
      localObject = getDrawableFromResourceValue(paramCursor.getString(mIconName1Col));
      paramView = (View)localObject;
      if (localObject != null) {
        break label234;
      }
      paramView = mSearchable.getSearchActivity();
      String str = paramView.flattenToShortString();
      if (mOutsideDrawablesCache.containsKey(str))
      {
        paramView = (Drawable.ConstantState)mOutsideDrawablesCache.get(str);
        if (paramView == null) {}
        for (localObject = null;; localObject = paramView.newDrawable(mProviderContext.getResources()))
        {
          paramView = (View)localObject;
          if (localObject != null) {
            break;
          }
          paramView = mContext.getPackageManager().getDefaultActivityIcon();
          break;
        }
      }
      localObject = getActivityIcon(paramView);
      if (localObject == null) {}
      for (paramView = null;; paramView = ((Drawable)localObject).getConstantState())
      {
        mOutsideDrawablesCache.put(str, paramView);
        break;
      }
    }
    label535:
    mIconRefine.setVisibility(8);
  }
  
  public final void changeCursor(Cursor paramCursor)
  {
    if (mClosed)
    {
      Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
      if (paramCursor != null) {
        paramCursor.close();
      }
    }
    for (;;)
    {
      return;
      try
      {
        super.changeCursor(paramCursor);
        if (paramCursor != null)
        {
          mText1Col = paramCursor.getColumnIndex("suggest_text_1");
          mText2Col = paramCursor.getColumnIndex("suggest_text_2");
          mText2UrlCol = paramCursor.getColumnIndex("suggest_text_2_url");
          mIconName1Col = paramCursor.getColumnIndex("suggest_icon_1");
          mIconName2Col = paramCursor.getColumnIndex("suggest_icon_2");
          mFlagsCol = paramCursor.getColumnIndex("suggest_flags");
          return;
        }
      }
      catch (Exception paramCursor)
      {
        Log.e("SuggestionsAdapter", "error changing cursor and caching columns", paramCursor);
      }
    }
  }
  
  public final CharSequence convertToString(Cursor paramCursor)
  {
    Object localObject;
    if (paramCursor == null) {
      localObject = null;
    }
    String str;
    do
    {
      return (CharSequence)localObject;
      str = getColumnString(paramCursor, "suggest_intent_query");
      localObject = str;
    } while (str != null);
    if (mSearchable.shouldRewriteQueryFromData())
    {
      localObject = getColumnString(paramCursor, "suggest_intent_data");
      if (localObject != null) {
        return (CharSequence)localObject;
      }
    }
    if (mSearchable.shouldRewriteQueryFromText())
    {
      paramCursor = getColumnString(paramCursor, "suggest_text_1");
      if (paramCursor != null) {
        return paramCursor;
      }
    }
    return null;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException localRuntimeException)
    {
      do
      {
        Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", localRuntimeException);
        paramViewGroup = newView(mContext, mCursor, paramViewGroup);
        paramView = paramViewGroup;
      } while (paramViewGroup == null);
      getTagmText1.setText(localRuntimeException.toString());
    }
    return paramViewGroup;
  }
  
  public final boolean hasStableIds()
  {
    return false;
  }
  
  public final View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    paramContext = super.newView(paramContext, paramCursor, paramViewGroup);
    paramContext.setTag(new ChildViewCache(paramContext));
    ((ImageView)paramContext.findViewById(R.id.edit_query)).setImageResource(mCommitIconResId);
    return paramContext;
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    updateSpinnerState(mCursor);
  }
  
  public final void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
    updateSpinnerState(mCursor);
  }
  
  public final void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof CharSequence)) {
      mSearchView.onQueryRefine((CharSequence)paramView);
    }
  }
  
  public final Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    for (paramCharSequence = ""; (mSearchView.getVisibility() != 0) || (mSearchView.getWindowVisibility() != 0); paramCharSequence = paramCharSequence.toString()) {
      return null;
    }
    Object localObject1;
    for (;;)
    {
      try
      {
        localObject1 = mSearchable;
        if (localObject1 != null) {
          break label77;
        }
        paramCharSequence = null;
        if (paramCharSequence != null)
        {
          paramCharSequence.getCount();
          return paramCharSequence;
        }
      }
      catch (RuntimeException paramCharSequence)
      {
        Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", paramCharSequence);
      }
      return null;
      label77:
      localObject2 = ((SearchableInfo)localObject1).getSuggestAuthority();
      if (localObject2 != null) {
        break;
      }
      paramCharSequence = null;
    }
    Object localObject2 = new Uri.Builder().scheme("content").authority((String)localObject2).query("").fragment("");
    String str = ((SearchableInfo)localObject1).getSuggestPath();
    if (str != null) {
      ((Uri.Builder)localObject2).appendEncodedPath(str);
    }
    ((Uri.Builder)localObject2).appendPath("search_suggest_query");
    str = ((SearchableInfo)localObject1).getSuggestSelection();
    if (str != null)
    {
      localObject1 = new String[1];
      localObject1[0] = paramCharSequence;
    }
    for (paramCharSequence = (CharSequence)localObject1;; paramCharSequence = null)
    {
      ((Uri.Builder)localObject2).appendQueryParameter("limit", "50");
      localObject1 = ((Uri.Builder)localObject2).build();
      paramCharSequence = mContext.getContentResolver().query((Uri)localObject1, null, str, paramCharSequence, null);
      break;
      ((Uri.Builder)localObject2).appendPath(paramCharSequence);
    }
  }
  
  private static final class ChildViewCache
  {
    public final ImageView mIcon1;
    public final ImageView mIcon2;
    public final ImageView mIconRefine;
    public final TextView mText1;
    public final TextView mText2;
    
    public ChildViewCache(View paramView)
    {
      mText1 = ((TextView)paramView.findViewById(16908308));
      mText2 = ((TextView)paramView.findViewById(16908309));
      mIcon1 = ((ImageView)paramView.findViewById(16908295));
      mIcon2 = ((ImageView)paramView.findViewById(16908296));
      mIconRefine = ((ImageView)paramView.findViewById(R.id.edit_query));
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.SuggestionsAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */