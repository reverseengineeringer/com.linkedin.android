package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayoutCompat
  implements CollapsibleActionView
{
  private static final boolean DBG = false;
  static final AutoCompleteTextViewReflector HIDDEN_METHOD_INVOKER;
  private static final String IME_OPTION_NO_MICROPHONE = "nm";
  private static final boolean IS_AT_LEAST_FROYO;
  private static final String LOG_TAG = "SearchView";
  private Bundle mAppSearchData;
  private boolean mClearingFocus;
  private final ImageView mCloseButton;
  private final ImageView mCollapsedIcon;
  private int mCollapsedImeOptions;
  private final CharSequence mDefaultQueryHint;
  private final AppCompatDrawableManager mDrawableManager = AppCompatDrawableManager.get();
  private final View mDropDownAnchor;
  private boolean mExpandedInActionView;
  private final ImageView mGoButton;
  private boolean mIconified;
  private boolean mIconifiedByDefault;
  private int mMaxWidth;
  private CharSequence mOldQueryText;
  private final View.OnClickListener mOnClickListener = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if (paramAnonymousView == mSearchButton) {
        SearchView.this.onSearchClicked();
      }
      do
      {
        return;
        if (paramAnonymousView == mCloseButton)
        {
          SearchView.this.onCloseClicked();
          return;
        }
        if (paramAnonymousView == mGoButton)
        {
          SearchView.this.onSubmitQuery();
          return;
        }
        if (paramAnonymousView == mVoiceButton)
        {
          SearchView.this.onVoiceClicked();
          return;
        }
      } while (paramAnonymousView != mSearchSrcTextView);
      SearchView.this.forceSuggestionQuery();
    }
  };
  private OnCloseListener mOnCloseListener;
  private final TextView.OnEditorActionListener mOnEditorActionListener = new TextView.OnEditorActionListener()
  {
    public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      SearchView.this.onSubmitQuery();
      return true;
    }
  };
  private final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      SearchView.this.onItemClicked(paramAnonymousInt, 0, null);
    }
  };
  private final AdapterView.OnItemSelectedListener mOnItemSelectedListener = new AdapterView.OnItemSelectedListener()
  {
    public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      SearchView.this.onItemSelected(paramAnonymousInt);
    }
    
    public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
  };
  private OnQueryTextListener mOnQueryChangeListener;
  private View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
  private View.OnClickListener mOnSearchClickListener;
  private OnSuggestionListener mOnSuggestionListener;
  private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache = new WeakHashMap();
  private CharSequence mQueryHint;
  private boolean mQueryRefinement;
  private Runnable mReleaseCursorRunnable = new Runnable()
  {
    public final void run()
    {
      if ((mSuggestionsAdapter != null) && ((mSuggestionsAdapter instanceof SuggestionsAdapter))) {
        mSuggestionsAdapter.changeCursor(null);
      }
    }
  };
  private final ImageView mSearchButton;
  private final View mSearchEditFrame;
  private final Drawable mSearchHintIcon;
  private final View mSearchPlate;
  private final SearchAutoComplete mSearchSrcTextView;
  private SearchableInfo mSearchable;
  private Runnable mShowImeRunnable = new Runnable()
  {
    public final void run()
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      SearchView.AutoCompleteTextViewReflector localAutoCompleteTextViewReflector;
      SearchView localSearchView;
      if (localInputMethodManager != null)
      {
        localAutoCompleteTextViewReflector = SearchView.HIDDEN_METHOD_INVOKER;
        localSearchView = SearchView.this;
        if (showSoftInputUnchecked == null) {}
      }
      else
      {
        try
        {
          showSoftInputUnchecked.invoke(localInputMethodManager, new Object[] { Integer.valueOf(0), null });
          return;
        }
        catch (Exception localException) {}
      }
      localInputMethodManager.showSoftInput(localSearchView, 0);
    }
  };
  private final View mSubmitArea;
  private boolean mSubmitButtonEnabled;
  private final int mSuggestionCommitIconResId;
  private final int mSuggestionRowLayout;
  private CursorAdapter mSuggestionsAdapter;
  View.OnKeyListener mTextKeyListener = new View.OnKeyListener()
  {
    public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if (mSearchable == null) {}
      do
      {
        return false;
        if ((mSearchSrcTextView.isPopupShowing()) && (mSearchSrcTextView.getListSelection() != -1)) {
          return SearchView.this.onSuggestionsKey(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      } while ((SearchView.SearchAutoComplete.access$1600(mSearchSrcTextView)) || (!KeyEventCompat.hasNoModifiers(paramAnonymousKeyEvent)) || (paramAnonymousKeyEvent.getAction() != 1) || (paramAnonymousInt != 66));
      paramAnonymousView.cancelLongPress();
      SearchView.this.launchQuerySearch(0, null, mSearchSrcTextView.getText().toString());
      return true;
    }
  };
  private TextWatcher mTextWatcher = new TextWatcher()
  {
    public final void afterTextChanged(Editable paramAnonymousEditable) {}
    
    public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      SearchView.this.onTextChanged(paramAnonymousCharSequence);
    }
  };
  private final Runnable mUpdateDrawableStateRunnable = new Runnable()
  {
    public final void run()
    {
      SearchView.this.updateFocusedState();
    }
  };
  private CharSequence mUserQuery;
  private final Intent mVoiceAppSearchIntent;
  private final ImageView mVoiceButton;
  private boolean mVoiceButtonEnabled;
  private final Intent mVoiceWebSearchIntent;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 8) {}
    for (boolean bool = true;; bool = false)
    {
      IS_AT_LEAST_FROYO = bool;
      HIDDEN_METHOD_INVOKER = new AutoCompleteTextViewReflector();
      return;
    }
  }
  
  public SearchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.searchViewStyle);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = TintTypedArray.obtainStyledAttributes$89ace2b(paramContext, paramAttributeSet, R.styleable.SearchView, paramInt);
    LayoutInflater.from(paramContext).inflate(paramAttributeSet.getResourceId(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
    mSearchSrcTextView = ((SearchAutoComplete)findViewById(R.id.search_src_text));
    mSearchSrcTextView.setSearchView(this);
    mSearchEditFrame = findViewById(R.id.search_edit_frame);
    mSearchPlate = findViewById(R.id.search_plate);
    mSubmitArea = findViewById(R.id.submit_area);
    mSearchButton = ((ImageView)findViewById(R.id.search_button));
    mGoButton = ((ImageView)findViewById(R.id.search_go_btn));
    mCloseButton = ((ImageView)findViewById(R.id.search_close_btn));
    mVoiceButton = ((ImageView)findViewById(R.id.search_voice_btn));
    mCollapsedIcon = ((ImageView)findViewById(R.id.search_mag_icon));
    mSearchPlate.setBackgroundDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_queryBackground));
    mSubmitArea.setBackgroundDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_submitBackground));
    mSearchButton.setImageDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_searchIcon));
    mGoButton.setImageDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_goIcon));
    mCloseButton.setImageDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_closeIcon));
    mVoiceButton.setImageDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_voiceIcon));
    mCollapsedIcon.setImageDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_searchIcon));
    mSearchHintIcon = paramAttributeSet.getDrawable(R.styleable.SearchView_searchHintIcon);
    mSuggestionRowLayout = paramAttributeSet.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
    mSuggestionCommitIconResId = paramAttributeSet.getResourceId(R.styleable.SearchView_commitIcon, 0);
    mSearchButton.setOnClickListener(mOnClickListener);
    mCloseButton.setOnClickListener(mOnClickListener);
    mGoButton.setOnClickListener(mOnClickListener);
    mVoiceButton.setOnClickListener(mOnClickListener);
    mSearchSrcTextView.setOnClickListener(mOnClickListener);
    mSearchSrcTextView.addTextChangedListener(mTextWatcher);
    mSearchSrcTextView.setOnEditorActionListener(mOnEditorActionListener);
    mSearchSrcTextView.setOnItemClickListener(mOnItemClickListener);
    mSearchSrcTextView.setOnItemSelectedListener(mOnItemSelectedListener);
    mSearchSrcTextView.setOnKeyListener(mTextKeyListener);
    mSearchSrcTextView.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (mOnQueryTextFocusChangeListener != null) {
          mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, paramAnonymousBoolean);
        }
      }
    });
    setIconifiedByDefault(paramAttributeSet.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
    paramInt = paramAttributeSet.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    mDefaultQueryHint = paramAttributeSet.getText(R.styleable.SearchView_defaultQueryHint);
    mQueryHint = paramAttributeSet.getText(R.styleable.SearchView_queryHint);
    paramInt = paramAttributeSet.getInt(R.styleable.SearchView_android_imeOptions, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.getInt(R.styleable.SearchView_android_inputType, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.getBoolean(R.styleable.SearchView_android_focusable, true));
    mWrapped.recycle();
    mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH");
    mVoiceWebSearchIntent.addFlags(268435456);
    mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    mVoiceAppSearchIntent.addFlags(268435456);
    mDropDownAnchor = findViewById(mSearchSrcTextView.getDropDownAnchor());
    if (mDropDownAnchor != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        break label769;
      }
      addOnLayoutChangeListenerToDropDownAnchorSDK11();
    }
    for (;;)
    {
      updateViewsVisibility(mIconifiedByDefault);
      updateQueryHint();
      return;
      label769:
      addOnLayoutChangeListenerToDropDownAnchorBase();
    }
  }
  
  private void addOnLayoutChangeListenerToDropDownAnchorBase()
  {
    mDropDownAnchor.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        SearchView.this.adjustDropDownSizeAndPosition();
      }
    });
  }
  
  @TargetApi(11)
  private void addOnLayoutChangeListenerToDropDownAnchorSDK11()
  {
    mDropDownAnchor.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        SearchView.this.adjustDropDownSizeAndPosition();
      }
    });
  }
  
  private void adjustDropDownSizeAndPosition()
  {
    int k;
    Rect localRect;
    int i;
    if (mDropDownAnchor.getWidth() > 1)
    {
      Resources localResources = getContext().getResources();
      k = mSearchPlate.getPaddingLeft();
      localRect = new Rect();
      boolean bool = ViewUtils.isLayoutRtl(this);
      if (!mIconifiedByDefault) {
        break label142;
      }
      i = localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left);
      mSearchSrcTextView.getDropDownBackground().getPadding(localRect);
      if (!bool) {
        break label147;
      }
    }
    label142:
    label147:
    for (int j = -left;; j = k - (left + i))
    {
      mSearchSrcTextView.setDropDownHorizontalOffset(j);
      j = mDropDownAnchor.getWidth();
      int m = left;
      int n = right;
      mSearchSrcTextView.setDropDownWidth(j + m + n + i - k);
      return;
      i = 0;
      break;
    }
  }
  
  private Intent createIntent(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    paramString1 = new Intent(paramString1);
    paramString1.addFlags(268435456);
    if (paramUri != null) {
      paramString1.setData(paramUri);
    }
    paramString1.putExtra("user_query", mUserQuery);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    if (mAppSearchData != null) {
      paramString1.putExtra("app_data", mAppSearchData);
    }
    if (paramInt != 0)
    {
      paramString1.putExtra("action_key", paramInt);
      paramString1.putExtra("action_msg", paramString4);
    }
    if (IS_AT_LEAST_FROYO) {
      paramString1.setComponent(mSearchable.getSearchActivity());
    }
    return paramString1;
  }
  
  private Intent createIntentFromSuggestion(Cursor paramCursor, int paramInt, String paramString)
  {
    try
    {
      localObject2 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_action");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label225;
      }
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT < 8) {
        break label225;
      }
      localObject1 = mSearchable.getSuggestIntentAction();
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        try
        {
          String str;
          paramInt = paramCursor.getPosition();
          Log.w("SearchView", "Search suggestions cursor at row " + paramInt + " returned exception.", paramString);
          return null;
        }
        catch (RuntimeException paramCursor)
        {
          paramInt = -1;
          continue;
        }
        label225:
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = "android.intent.action.SEARCH";
          continue;
          label242:
          if (localObject3 == null) {
            localObject1 = null;
          }
        }
      }
    }
    localObject3 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_data");
    localObject1 = localObject3;
    if (IS_AT_LEAST_FROYO)
    {
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = mSearchable.getSuggestIntentData();
      }
    }
    localObject3 = localObject1;
    if (localObject1 != null)
    {
      str = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_data_id");
      localObject3 = localObject1;
      if (str != null)
      {
        localObject3 = (String)localObject1 + "/" + Uri.encode(str);
        break label242;
        for (;;)
        {
          localObject3 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_query");
          return createIntent((String)localObject2, (Uri)localObject1, SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_extra_data"), (String)localObject3, paramInt, paramString);
          localObject1 = Uri.parse((String)localObject3);
        }
      }
    }
  }
  
  @TargetApi(8)
  private Intent createVoiceAppSearchIntent(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    ComponentName localComponentName = paramSearchableInfo.getSearchActivity();
    Object localObject1 = new Intent("android.intent.action.SEARCH");
    ((Intent)localObject1).setComponent(localComponentName);
    PendingIntent localPendingIntent = PendingIntent.getActivity(getContext(), 0, (Intent)localObject1, 1073741824);
    Bundle localBundle = new Bundle();
    if (mAppSearchData != null) {
      localBundle.putParcelable("app_data", mAppSearchData);
    }
    Intent localIntent2 = new Intent(paramIntent);
    paramIntent = "free_form";
    Object localObject3 = null;
    localObject1 = null;
    Object localObject2 = null;
    String str = null;
    int j = 1;
    Intent localIntent1 = paramIntent;
    int i = j;
    if (Build.VERSION.SDK_INT >= 8)
    {
      localObject2 = getResources();
      if (paramSearchableInfo.getVoiceLanguageModeId() != 0) {
        paramIntent = ((Resources)localObject2).getString(paramSearchableInfo.getVoiceLanguageModeId());
      }
      if (paramSearchableInfo.getVoicePromptTextId() != 0) {
        localObject1 = ((Resources)localObject2).getString(paramSearchableInfo.getVoicePromptTextId());
      }
      if (paramSearchableInfo.getVoiceLanguageId() != 0) {
        str = ((Resources)localObject2).getString(paramSearchableInfo.getVoiceLanguageId());
      }
      localObject2 = str;
      localIntent1 = paramIntent;
      i = j;
      localObject3 = localObject1;
      if (paramSearchableInfo.getVoiceMaxResults() != 0)
      {
        i = paramSearchableInfo.getVoiceMaxResults();
        localObject3 = localObject1;
        localIntent1 = paramIntent;
        localObject2 = str;
      }
    }
    localIntent2.putExtra("android.speech.extra.LANGUAGE_MODEL", localIntent1);
    localIntent2.putExtra("android.speech.extra.PROMPT", (String)localObject3);
    localIntent2.putExtra("android.speech.extra.LANGUAGE", (String)localObject2);
    localIntent2.putExtra("android.speech.extra.MAX_RESULTS", i);
    if (localComponentName == null) {}
    for (paramIntent = null;; paramIntent = localComponentName.flattenToShortString())
    {
      localIntent2.putExtra("calling_package", paramIntent);
      localIntent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", localPendingIntent);
      localIntent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", localBundle);
      return localIntent2;
    }
  }
  
  @TargetApi(8)
  private Intent createVoiceWebSearchIntent(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    Intent localIntent = new Intent(paramIntent);
    paramIntent = paramSearchableInfo.getSearchActivity();
    if (paramIntent == null) {}
    for (paramIntent = null;; paramIntent = paramIntent.flattenToShortString())
    {
      localIntent.putExtra("calling_package", paramIntent);
      return localIntent;
    }
  }
  
  private void dismissSuggestions()
  {
    mSearchSrcTextView.dismissDropDown();
  }
  
  private void forceSuggestionQuery()
  {
    AutoCompleteTextViewReflector localAutoCompleteTextViewReflector = HIDDEN_METHOD_INVOKER;
    SearchAutoComplete localSearchAutoComplete = mSearchSrcTextView;
    if (doBeforeTextChanged != null) {}
    try
    {
      doBeforeTextChanged.invoke(localSearchAutoComplete, new Object[0]);
      localAutoCompleteTextViewReflector = HIDDEN_METHOD_INVOKER;
      localSearchAutoComplete = mSearchSrcTextView;
      if (doAfterTextChanged != null) {}
      try
      {
        doAfterTextChanged.invoke(localSearchAutoComplete, new Object[0]);
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  private CharSequence getDecoratedHint(CharSequence paramCharSequence)
  {
    if ((!mIconifiedByDefault) || (mSearchHintIcon == null)) {
      return paramCharSequence;
    }
    int i = (int)(mSearchSrcTextView.getTextSize() * 1.25D);
    mSearchHintIcon.setBounds(0, 0, i, i);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
    localSpannableStringBuilder.setSpan(new ImageSpan(mSearchHintIcon), 1, 2, 33);
    localSpannableStringBuilder.append(paramCharSequence);
    return localSpannableStringBuilder;
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
  }
  
  @TargetApi(8)
  private boolean hasVoiceSearch()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Intent localIntent;
    if (mSearchable != null)
    {
      bool1 = bool2;
      if (mSearchable.getVoiceSearchEnabled())
      {
        localIntent = null;
        if (!mSearchable.getVoiceSearchLaunchWebSearch()) {
          break label69;
        }
        localIntent = mVoiceWebSearchIntent;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (localIntent != null)
      {
        bool1 = bool2;
        if (getContext().getPackageManager().resolveActivity(localIntent, 65536) != null) {
          bool1 = true;
        }
      }
      return bool1;
      label69:
      if (mSearchable.getVoiceSearchLaunchRecognizer()) {
        localIntent = mVoiceAppSearchIntent;
      }
    }
  }
  
  static boolean isLandscapeMode(Context paramContext)
  {
    return getResourcesgetConfigurationorientation == 2;
  }
  
  private boolean isSubmitAreaEnabled()
  {
    return ((mSubmitButtonEnabled) || (mVoiceButtonEnabled)) && (!isIconified());
  }
  
  private void launchIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      getContext().startActivity(paramIntent);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e("SearchView", "Failed launch activity: " + paramIntent, localRuntimeException);
    }
  }
  
  private void launchQuerySearch(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = createIntent("android.intent.action.SEARCH", null, null, paramString2, paramInt, paramString1);
    getContext().startActivity(paramString1);
  }
  
  private boolean launchSuggestion(int paramInt1, int paramInt2, String paramString)
  {
    Cursor localCursor = mSuggestionsAdapter.mCursor;
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt1)))
    {
      launchIntent(createIntentFromSuggestion(localCursor, paramInt2, paramString));
      return true;
    }
    return false;
  }
  
  private void onCloseClicked()
  {
    if (TextUtils.isEmpty(mSearchSrcTextView.getText()))
    {
      if (mIconifiedByDefault)
      {
        if (mOnCloseListener != null) {
          mOnCloseListener.onClose();
        }
        clearFocus();
        updateViewsVisibility(true);
      }
      return;
    }
    mSearchSrcTextView.setText("");
    mSearchSrcTextView.requestFocus();
    setImeVisibility(true);
  }
  
  private boolean onItemClicked(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = false;
    if ((mOnSuggestionListener == null) || (!mOnSuggestionListener.onSuggestionClick$134632()))
    {
      launchSuggestion(paramInt1, 0, null);
      setImeVisibility(false);
      dismissSuggestions();
      bool = true;
    }
    return bool;
  }
  
  private boolean onItemSelected(int paramInt)
  {
    if ((mOnSuggestionListener == null) || (!mOnSuggestionListener.onSuggestionSelect$134632()))
    {
      rewriteQueryFromSuggestion(paramInt);
      return true;
    }
    return false;
  }
  
  private void onSearchClicked()
  {
    updateViewsVisibility(false);
    mSearchSrcTextView.requestFocus();
    setImeVisibility(true);
    if (mOnSearchClickListener != null) {
      mOnSearchClickListener.onClick(this);
    }
  }
  
  private void onSubmitQuery()
  {
    Editable localEditable = mSearchSrcTextView.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0))
    {
      if (mOnQueryChangeListener != null) {
        localEditable.toString();
      }
      if (mSearchable != null) {
        launchQuerySearch(0, null, localEditable.toString());
      }
      setImeVisibility(false);
      dismissSuggestions();
    }
  }
  
  private boolean onSuggestionsKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (mSearchable == null) {}
    do
    {
      do
      {
        return false;
      } while ((mSuggestionsAdapter == null) || (paramKeyEvent.getAction() != 0) || (!KeyEventCompat.hasNoModifiers(paramKeyEvent)));
      if ((paramInt == 66) || (paramInt == 84) || (paramInt == 61)) {
        return onItemClicked(mSearchSrcTextView.getListSelection(), 0, null);
      }
      if ((paramInt == 21) || (paramInt == 22))
      {
        if (paramInt == 21) {}
        for (paramInt = 0;; paramInt = mSearchSrcTextView.length())
        {
          mSearchSrcTextView.setSelection(paramInt);
          mSearchSrcTextView.setListSelection(0);
          mSearchSrcTextView.clearListSelection();
          HIDDEN_METHOD_INVOKER.ensureImeVisible$3d4581ed(mSearchSrcTextView);
          return true;
        }
      }
    } while ((paramInt != 19) || (mSearchSrcTextView.getListSelection() != 0));
    return false;
  }
  
  private void onTextChanged(CharSequence paramCharSequence)
  {
    boolean bool2 = true;
    Editable localEditable = mSearchSrcTextView.getText();
    mUserQuery = localEditable;
    if (!TextUtils.isEmpty(localEditable))
    {
      bool1 = true;
      updateSubmitButton(bool1);
      if (bool1) {
        break label101;
      }
    }
    label101:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      updateVoiceButton(bool1);
      updateCloseButton();
      updateSubmitArea();
      if ((mOnQueryChangeListener != null) && (!TextUtils.equals(paramCharSequence, mOldQueryText))) {
        mOnQueryChangeListener.onQueryTextChange(paramCharSequence.toString());
      }
      mOldQueryText = paramCharSequence.toString();
      return;
      bool1 = false;
      break;
    }
  }
  
  @TargetApi(8)
  private void onVoiceClicked()
  {
    if (mSearchable == null) {}
    do
    {
      return;
      Object localObject = mSearchable;
      try
      {
        if (((SearchableInfo)localObject).getVoiceSearchLaunchWebSearch())
        {
          localObject = createVoiceWebSearchIntent(mVoiceWebSearchIntent, (SearchableInfo)localObject);
          getContext().startActivity((Intent)localObject);
          return;
        }
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Log.w("SearchView", "Could not find voice search activity");
        return;
      }
    } while (!localActivityNotFoundException.getVoiceSearchLaunchRecognizer());
    Intent localIntent = createVoiceAppSearchIntent(mVoiceAppSearchIntent, localActivityNotFoundException);
    getContext().startActivity(localIntent);
  }
  
  private void postUpdateFocusedState()
  {
    post(mUpdateDrawableStateRunnable);
  }
  
  private void rewriteQueryFromSuggestion(int paramInt)
  {
    Editable localEditable = mSearchSrcTextView.getText();
    Object localObject = mSuggestionsAdapter.mCursor;
    if (localObject == null) {
      return;
    }
    if (((Cursor)localObject).moveToPosition(paramInt))
    {
      localObject = mSuggestionsAdapter.convertToString((Cursor)localObject);
      if (localObject != null)
      {
        setQuery((CharSequence)localObject);
        return;
      }
      setQuery(localEditable);
      return;
    }
    setQuery(localEditable);
  }
  
  private void setImeVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {
      post(mShowImeRunnable);
    }
    InputMethodManager localInputMethodManager;
    do
    {
      return;
      removeCallbacks(mShowImeRunnable);
      localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    } while (localInputMethodManager == null);
    localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  private void setQuery(CharSequence paramCharSequence)
  {
    mSearchSrcTextView.setText(paramCharSequence);
    SearchAutoComplete localSearchAutoComplete = mSearchSrcTextView;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i = 0;; i = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i);
      return;
    }
  }
  
  private void updateCloseButton()
  {
    int m = 1;
    int k = 0;
    int i;
    int j;
    label44:
    label56:
    Drawable localDrawable;
    if (!TextUtils.isEmpty(mSearchSrcTextView.getText()))
    {
      i = 1;
      j = m;
      if (i == 0)
      {
        if ((!mIconifiedByDefault) || (mExpandedInActionView)) {
          break label99;
        }
        j = m;
      }
      localObject = mCloseButton;
      if (j == 0) {
        break label104;
      }
      j = k;
      ((ImageView)localObject).setVisibility(j);
      localDrawable = mCloseButton.getDrawable();
      if (localDrawable != null) {
        if (i == 0) {
          break label110;
        }
      }
    }
    label99:
    label104:
    label110:
    for (Object localObject = ENABLED_STATE_SET;; localObject = EMPTY_STATE_SET)
    {
      localDrawable.setState((int[])localObject);
      return;
      i = 0;
      break;
      j = 0;
      break label44;
      j = 8;
      break label56;
    }
  }
  
  private void updateFocusedState()
  {
    if (mSearchSrcTextView.hasFocus()) {}
    for (int[] arrayOfInt = FOCUSED_STATE_SET;; arrayOfInt = EMPTY_STATE_SET)
    {
      Drawable localDrawable = mSearchPlate.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      localDrawable = mSubmitArea.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      invalidate();
      return;
    }
  }
  
  private void updateQueryHint()
  {
    CharSequence localCharSequence = getQueryHint();
    SearchAutoComplete localSearchAutoComplete = mSearchSrcTextView;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    localSearchAutoComplete.setHint(getDecoratedHint((CharSequence)localObject));
  }
  
  @TargetApi(8)
  private void updateSearchAutoComplete()
  {
    int j = 1;
    mSearchSrcTextView.setThreshold(mSearchable.getSuggestThreshold());
    mSearchSrcTextView.setImeOptions(mSearchable.getImeOptions());
    int k = mSearchable.getInputType();
    int i = k;
    if ((k & 0xF) == 1)
    {
      k &= 0xFFFEFFFF;
      i = k;
      if (mSearchable.getSuggestAuthority() != null) {
        i = 0x10000 | k | 0x80000;
      }
    }
    mSearchSrcTextView.setInputType(i);
    if (mSuggestionsAdapter != null) {
      mSuggestionsAdapter.changeCursor(null);
    }
    if (mSearchable.getSuggestAuthority() != null)
    {
      mSuggestionsAdapter = new SuggestionsAdapter(getContext(), this, mSearchable, mOutsideDrawablesCache);
      mSearchSrcTextView.setAdapter(mSuggestionsAdapter);
      SuggestionsAdapter localSuggestionsAdapter = (SuggestionsAdapter)mSuggestionsAdapter;
      i = j;
      if (mQueryRefinement) {
        i = 2;
      }
      mQueryRefinement = i;
    }
  }
  
  private void updateSubmitArea()
  {
    int j = 8;
    int i = j;
    if (isSubmitAreaEnabled()) {
      if (mGoButton.getVisibility() != 0)
      {
        i = j;
        if (mVoiceButton.getVisibility() != 0) {}
      }
      else
      {
        i = 0;
      }
    }
    mSubmitArea.setVisibility(i);
  }
  
  private void updateSubmitButton(boolean paramBoolean)
  {
    int j = 8;
    int i = j;
    if (mSubmitButtonEnabled)
    {
      i = j;
      if (isSubmitAreaEnabled())
      {
        i = j;
        if (hasFocus()) {
          if (!paramBoolean)
          {
            i = j;
            if (mVoiceButtonEnabled) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    mGoButton.setVisibility(i);
  }
  
  private void updateViewsVisibility(boolean paramBoolean)
  {
    int j = 8;
    boolean bool2 = true;
    mIconified = paramBoolean;
    int i;
    boolean bool1;
    if (paramBoolean)
    {
      i = 0;
      if (TextUtils.isEmpty(mSearchSrcTextView.getText())) {
        break label121;
      }
      bool1 = true;
      label33:
      mSearchButton.setVisibility(i);
      updateSubmitButton(bool1);
      View localView = mSearchEditFrame;
      if (!paramBoolean) {
        break label127;
      }
      i = j;
      label59:
      localView.setVisibility(i);
      if ((mCollapsedIcon.getDrawable() != null) && (!mIconifiedByDefault)) {
        break label132;
      }
      i = 8;
      label85:
      mCollapsedIcon.setVisibility(i);
      updateCloseButton();
      if (bool1) {
        break label137;
      }
    }
    label121:
    label127:
    label132:
    label137:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      updateVoiceButton(paramBoolean);
      updateSubmitArea();
      return;
      i = 8;
      break;
      bool1 = false;
      break label33;
      i = 0;
      break label59;
      i = 0;
      break label85;
    }
  }
  
  private void updateVoiceButton(boolean paramBoolean)
  {
    int j = 8;
    int i = j;
    if (mVoiceButtonEnabled)
    {
      i = j;
      if (!isIconified())
      {
        i = j;
        if (paramBoolean)
        {
          i = 0;
          mGoButton.setVisibility(8);
        }
      }
    }
    mVoiceButton.setVisibility(i);
  }
  
  public void clearFocus()
  {
    mClearingFocus = true;
    setImeVisibility(false);
    super.clearFocus();
    mSearchSrcTextView.clearFocus();
    mClearingFocus = false;
  }
  
  public int getImeOptions()
  {
    return mSearchSrcTextView.getImeOptions();
  }
  
  public int getInputType()
  {
    return mSearchSrcTextView.getInputType();
  }
  
  public int getMaxWidth()
  {
    return mMaxWidth;
  }
  
  public CharSequence getQuery()
  {
    return mSearchSrcTextView.getText();
  }
  
  public CharSequence getQueryHint()
  {
    if (mQueryHint != null) {
      return mQueryHint;
    }
    if ((IS_AT_LEAST_FROYO) && (mSearchable != null) && (mSearchable.getHintId() != 0)) {
      return getContext().getText(mSearchable.getHintId());
    }
    return mDefaultQueryHint;
  }
  
  int getSuggestionCommitIconResId()
  {
    return mSuggestionCommitIconResId;
  }
  
  int getSuggestionRowLayout()
  {
    return mSuggestionRowLayout;
  }
  
  public CursorAdapter getSuggestionsAdapter()
  {
    return mSuggestionsAdapter;
  }
  
  public boolean isIconfiedByDefault()
  {
    return mIconifiedByDefault;
  }
  
  public boolean isIconified()
  {
    return mIconified;
  }
  
  public boolean isQueryRefinementEnabled()
  {
    return mQueryRefinement;
  }
  
  public boolean isSubmitButtonEnabled()
  {
    return mSubmitButtonEnabled;
  }
  
  public void onActionViewCollapsed()
  {
    setQuery("", false);
    clearFocus();
    updateViewsVisibility(true);
    mSearchSrcTextView.setImeOptions(mCollapsedImeOptions);
    mExpandedInActionView = false;
  }
  
  public void onActionViewExpanded()
  {
    if (mExpandedInActionView) {
      return;
    }
    mExpandedInActionView = true;
    mCollapsedImeOptions = mSearchSrcTextView.getImeOptions();
    mSearchSrcTextView.setImeOptions(mCollapsedImeOptions | 0x2000000);
    mSearchSrcTextView.setText("");
    setIconified(false);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(mUpdateDrawableStateRunnable);
    post(mReleaseCursorRunnable);
    super.onDetachedFromWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (isIconified())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    switch (j)
    {
    default: 
      paramInt1 = i;
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
      return;
    case -2147483648: 
      if (mMaxWidth > 0) {
        paramInt1 = Math.min(mMaxWidth, i);
      }
      break;
    }
    for (;;)
    {
      break;
      paramInt1 = Math.min(getPreferredWidth(), i);
      continue;
      paramInt1 = i;
      if (mMaxWidth <= 0) {
        break;
      }
      paramInt1 = Math.min(mMaxWidth, i);
      continue;
      if (mMaxWidth > 0) {
        paramInt1 = mMaxWidth;
      } else {
        paramInt1 = getPreferredWidth();
      }
    }
  }
  
  void onQueryRefine(CharSequence paramCharSequence)
  {
    setQuery(paramCharSequence);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    updateViewsVisibility(isIconified);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    isIconified = isIconified();
    return localSavedState;
  }
  
  void onTextFocusChanged()
  {
    updateViewsVisibility(isIconified());
    postUpdateFocusedState();
    if (mSearchSrcTextView.hasFocus()) {
      forceSuggestionQuery();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    postUpdateFocusedState();
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    boolean bool1;
    if (mClearingFocus) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      if (!isFocusable()) {
        return false;
      }
      if (isIconified()) {
        break;
      }
      bool2 = mSearchSrcTextView.requestFocus(paramInt, paramRect);
      bool1 = bool2;
    } while (!bool2);
    updateViewsVisibility(false);
    return bool2;
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    mAppSearchData = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      onCloseClicked();
      return;
    }
    onSearchClicked();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (mIconifiedByDefault == paramBoolean) {
      return;
    }
    mIconifiedByDefault = paramBoolean;
    updateViewsVisibility(paramBoolean);
    updateQueryHint();
  }
  
  public void setImeOptions(int paramInt)
  {
    mSearchSrcTextView.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    mSearchSrcTextView.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(OnCloseListener paramOnCloseListener)
  {
    mOnCloseListener = paramOnCloseListener;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    mOnQueryTextFocusChangeListener = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(OnQueryTextListener paramOnQueryTextListener)
  {
    mOnQueryChangeListener = paramOnQueryTextListener;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    mOnSearchClickListener = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(OnSuggestionListener paramOnSuggestionListener)
  {
    mOnSuggestionListener = paramOnSuggestionListener;
  }
  
  public void setQuery(CharSequence paramCharSequence, boolean paramBoolean)
  {
    mSearchSrcTextView.setText(paramCharSequence);
    if (paramCharSequence != null)
    {
      mSearchSrcTextView.setSelection(mSearchSrcTextView.length());
      mUserQuery = paramCharSequence;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramCharSequence))) {
      onSubmitQuery();
    }
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    mQueryHint = paramCharSequence;
    updateQueryHint();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    mQueryRefinement = paramBoolean;
    SuggestionsAdapter localSuggestionsAdapter;
    if ((mSuggestionsAdapter instanceof SuggestionsAdapter))
    {
      localSuggestionsAdapter = (SuggestionsAdapter)mSuggestionsAdapter;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 2;; i = 1)
    {
      mQueryRefinement = i;
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    mSearchable = paramSearchableInfo;
    if (mSearchable != null)
    {
      if (IS_AT_LEAST_FROYO) {
        updateSearchAutoComplete();
      }
      updateQueryHint();
    }
    if ((IS_AT_LEAST_FROYO) && (hasVoiceSearch())) {}
    for (boolean bool = true;; bool = false)
    {
      mVoiceButtonEnabled = bool;
      if (mVoiceButtonEnabled) {
        mSearchSrcTextView.setPrivateImeOptions("nm");
      }
      updateViewsVisibility(isIconified());
      return;
    }
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean)
  {
    mSubmitButtonEnabled = paramBoolean;
    updateViewsVisibility(isIconified());
  }
  
  public void setSuggestionsAdapter(CursorAdapter paramCursorAdapter)
  {
    mSuggestionsAdapter = paramCursorAdapter;
    mSearchSrcTextView.setAdapter(mSuggestionsAdapter);
  }
  
  private static final class AutoCompleteTextViewReflector
  {
    Method doAfterTextChanged;
    Method doBeforeTextChanged;
    private Method ensureImeVisible;
    Method showSoftInputUnchecked;
    
    AutoCompleteTextViewReflector()
    {
      try
      {
        doBeforeTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        doBeforeTextChanged.setAccessible(true);
        try
        {
          doAfterTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
          doAfterTextChanged.setAccessible(true);
          try
          {
            ensureImeVisible = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
            ensureImeVisible.setAccessible(true);
            try
            {
              showSoftInputUnchecked = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[] { Integer.TYPE, ResultReceiver.class });
              showSoftInputUnchecked.setAccessible(true);
              return;
            }
            catch (NoSuchMethodException localNoSuchMethodException1) {}
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            for (;;) {}
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          for (;;) {}
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException4)
      {
        for (;;) {}
      }
    }
    
    final void ensureImeVisible$3d4581ed(AutoCompleteTextView paramAutoCompleteTextView)
    {
      if (ensureImeVisible != null) {}
      try
      {
        ensureImeVisible.invoke(paramAutoCompleteTextView, new Object[] { Boolean.valueOf(true) });
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
  }
  
  public static abstract interface OnCloseListener
  {
    public abstract boolean onClose();
  }
  
  public static abstract interface OnQueryTextListener
  {
    public abstract boolean onQueryTextChange(String paramString);
  }
  
  public static abstract interface OnSuggestionListener
  {
    public abstract boolean onSuggestionClick$134632();
    
    public abstract boolean onSuggestionSelect$134632();
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    boolean isIconified;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      isIconified = ((Boolean)paramParcel.readValue(null)).booleanValue();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + isIconified + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeValue(Boolean.valueOf(isIconified));
    }
  }
  
  public static class SearchAutoComplete
    extends AppCompatAutoCompleteTextView
  {
    private SearchView mSearchView;
    private int mThreshold = getThreshold();
    
    public SearchAutoComplete(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
    }
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    public boolean enoughToFilter()
    {
      return (mThreshold <= 0) || (super.enoughToFilter());
    }
    
    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      mSearchView.onTextFocusChanged();
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            mSearchView.clearFocus();
            mSearchView.setImeVisibility(false);
            return true;
          }
        }
      }
      return super.onKeyPreIme(paramInt, paramKeyEvent);
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      if ((paramBoolean) && (mSearchView.hasFocus()) && (getVisibility() == 0))
      {
        ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this, 0);
        if (SearchView.isLandscapeMode(getContext())) {
          SearchView.HIDDEN_METHOD_INVOKER.ensureImeVisible$3d4581ed(this);
        }
      }
    }
    
    public void performCompletion() {}
    
    protected void replaceText(CharSequence paramCharSequence) {}
    
    void setSearchView(SearchView paramSearchView)
    {
      mSearchView = paramSearchView;
    }
    
    public void setThreshold(int paramInt)
    {
      super.setThreshold(paramInt);
      mThreshold = paramInt;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.SearchView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */