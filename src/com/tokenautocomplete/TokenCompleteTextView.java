package com.tokenautocomplete;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.QwertyKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Filter;
import android.widget.ListAdapter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView.CommaTokenizer;
import android.widget.MultiAutoCompleteTextView.Tokenizer;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class TokenCompleteTextView<T>
  extends MultiAutoCompleteTextView
  implements TextView.OnEditorActionListener
{
  public boolean allowCollapse = true;
  private boolean allowDuplicates = true;
  private TokenCompleteTextView.TokenDeleteStyle deletionStyle = TokenCompleteTextView.TokenDeleteStyle._Parent;
  private boolean focusChanging = false;
  private List<TokenCompleteTextView<T>.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.TokenImageSpan> hiddenSpans;
  private boolean hintVisible = false;
  boolean inInvalidate = false;
  private boolean initialized = false;
  private Layout lastLayout = null;
  private TokenCompleteTextView.TokenListener listener;
  private ArrayList<T> objects;
  private boolean performBestGuess = true;
  private String prefix = "";
  private boolean savingState = false;
  private T selectedObject;
  private boolean shouldFocusNext = false;
  private TokenCompleteTextView<T>.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.TokenSpanWatcher spanWatcher;
  private char[] splitChar = { 44, 59 };
  private TokenCompleteTextView.TokenClickStyle tokenClickStyle = TokenCompleteTextView.TokenClickStyle.None;
  private int tokenLimit = -1;
  private MultiAutoCompleteTextView.Tokenizer tokenizer;
  
  static
  {
    if (!TokenCompleteTextView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public TokenCompleteTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public TokenCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public TokenCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private TokenCompleteTextView<T>.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.TokenImageSpan buildSpanForObject(T paramT)
  {
    if (paramT == null) {
      return null;
    }
    return new TokenCompleteTextView.TokenImageSpan(this, getViewForObject(paramT), paramT, (int)maxTextWidth());
  }
  
  private SpannableStringBuilder buildSpannableForText(CharSequence paramCharSequence)
  {
    if ((splitChar.length > 1) && (splitChar[0] == ' ')) {}
    for (char c = splitChar[1];; c = splitChar[0]) {
      return new SpannableStringBuilder(String.valueOf(c) + tokenizer.terminateToken(paramCharSequence));
    }
  }
  
  private void clearSelections()
  {
    if ((tokenClickStyle == null) || (!tokenClickStyle.mIsSelectable)) {}
    do
    {
      return;
      localObject = getText();
    } while (localObject == null);
    Object localObject = (TokenCompleteTextView.TokenImageSpan[])((Editable)localObject).getSpans(0, ((Editable)localObject).length(), TokenCompleteTextView.TokenImageSpan.class);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      view.setSelected(false);
      i += 1;
    }
    invalidate();
  }
  
  private String currentCompletionText()
  {
    if (hintVisible) {
      return "";
    }
    Editable localEditable = getText();
    int k = getSelectionEnd();
    int j = tokenizer.findTokenStart(localEditable, k);
    int i = j;
    if (j < prefix.length()) {
      i = prefix.length();
    }
    return TextUtils.substring(localEditable, i, k);
  }
  
  private boolean deleteSelectedObject(boolean paramBoolean)
  {
    int i = 0;
    boolean bool = paramBoolean;
    Object localObject;
    int j;
    if (tokenClickStyle != null)
    {
      bool = paramBoolean;
      if (tokenClickStyle.mIsSelectable)
      {
        localObject = getText();
        if (localObject == null) {
          return false;
        }
        localObject = (TokenCompleteTextView.TokenImageSpan[])((Editable)localObject).getSpans(0, ((Editable)localObject).length(), TokenCompleteTextView.TokenImageSpan.class);
        j = localObject.length;
      }
    }
    for (;;)
    {
      bool = paramBoolean;
      if (i < j)
      {
        TokenCompleteTextView.TokenImageSpan localTokenImageSpan = localObject[i];
        if (view.isSelected())
        {
          removeSpan(localTokenImageSpan);
          bool = true;
        }
      }
      else
      {
        return bool;
      }
      i += 1;
    }
  }
  
  private void handleDone()
  {
    performCompletion();
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  @TargetApi(11)
  private void init()
  {
    if (initialized) {
      return;
    }
    setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    objects = new ArrayList();
    Editable localEditable = getText();
    assert (localEditable != null);
    spanWatcher = new TokenCompleteTextView.TokenSpanWatcher(this, (byte)0);
    hiddenSpans = new ArrayList();
    resetListeners();
    setTextIsSelectable(false);
    setLongClickable(false);
    setInputType(getInputType() | 0x80000 | 0x10000);
    setHorizontallyScrolling(false);
    setOnEditorActionListener(this);
    setFilters(new InputFilter[] { new TokenCompleteTextView.1(this) });
    setDeletionStyle(TokenCompleteTextView.TokenDeleteStyle.Clear);
    initialized = true;
  }
  
  private void insertSpan(T paramT, CharSequence paramCharSequence)
  {
    paramCharSequence = buildSpannableForText(paramCharSequence);
    TokenCompleteTextView.TokenImageSpan localTokenImageSpan = buildSpanForObject(paramT);
    Editable localEditable = getText();
    if (localEditable == null) {
      return;
    }
    if ((!allowCollapse) || (isFocused()) || (hiddenSpans.isEmpty()))
    {
      int j = localEditable.length();
      int i;
      if (hintVisible)
      {
        i = prefix.length();
        localEditable.insert(i, paramCharSequence);
      }
      for (;;)
      {
        localEditable.setSpan(localTokenImageSpan, i, paramCharSequence.length() + i - 1, 33);
        if ((!isFocused()) && (allowCollapse)) {
          performCollapse(false);
        }
        if (objects.contains(paramT)) {
          break;
        }
        spanWatcher.onSpanAdded(localEditable, localTokenImageSpan, 0, 0);
        return;
        String str = currentCompletionText();
        i = j;
        if (str != null)
        {
          i = j;
          if (str.length() > 0) {
            i = TextUtils.indexOf(localEditable, str);
          }
        }
        localEditable.insert(i, paramCharSequence);
      }
    }
    hiddenSpans.add(localTokenImageSpan);
    spanWatcher.onSpanAdded(localEditable, localTokenImageSpan, 0, 0);
    updateCountSpan();
  }
  
  private float maxTextWidth()
  {
    return getWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void removeSpan(TokenCompleteTextView<T>.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.com.tokenautocomplete.TokenCompleteTextView.TokenImageSpan paramTokenCompleteTextView)
  {
    Editable localEditable = getText();
    if (localEditable == null) {}
    do
    {
      return;
      if (((TokenCompleteTextView.TokenSpanWatcher[])localEditable.getSpans(0, localEditable.length(), TokenCompleteTextView.TokenSpanWatcher.class)).length == 0) {
        spanWatcher.onSpanRemoved(localEditable, paramTokenCompleteTextView, localEditable.getSpanStart(paramTokenCompleteTextView), localEditable.getSpanEnd(paramTokenCompleteTextView));
      }
      localEditable.delete(localEditable.getSpanStart(paramTokenCompleteTextView), localEditable.getSpanEnd(paramTokenCompleteTextView) + 1);
    } while ((!allowCollapse) || (isFocused()));
    updateCountSpan();
  }
  
  @TargetApi(14)
  private void resetListeners()
  {
    Editable localEditable = getText();
    if (localEditable != null)
    {
      localEditable.setSpan(spanWatcher, 0, localEditable.length(), 18);
      addTextChangedListener(new TokenCompleteTextView.TokenTextWatcher(this, (byte)0));
    }
  }
  
  private void updateCountSpan()
  {
    int i = 0;
    Editable localEditable = getText();
    CountSpan[] arrayOfCountSpan = (CountSpan[])localEditable.getSpans(0, localEditable.length(), CountSpan.class);
    int j = hiddenSpans.size();
    int k = arrayOfCountSpan.length;
    if (i < k)
    {
      CountSpan localCountSpan = arrayOfCountSpan[i];
      if (j == 0)
      {
        localEditable.delete(localEditable.getSpanStart(localCountSpan), localEditable.getSpanEnd(localCountSpan));
        localEditable.removeSpan(localCountSpan);
      }
      for (;;)
      {
        i += 1;
        break;
        localCountSpan.setCount(hiddenSpans.size());
        localEditable.setSpan(localCountSpan, localEditable.getSpanStart(localCountSpan), localEditable.getSpanEnd(localCountSpan), 33);
      }
    }
  }
  
  private void updateHint()
  {
    Editable localEditable = getText();
    CharSequence localCharSequence = getHint();
    if ((localEditable == null) || (localCharSequence == null)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (prefix.length() <= 0);
        HintSpan[] arrayOfHintSpan = (HintSpan[])localEditable.getSpans(0, localEditable.length(), HintSpan.class);
        localObject = null;
        j = prefix.length();
        i = j;
        if (arrayOfHintSpan.length > 0)
        {
          localObject = arrayOfHintSpan[0];
          i = j + (localEditable.getSpanEnd(localObject) - localEditable.getSpanStart(localObject));
        }
        if (localEditable.length() != i) {
          break;
        }
        hintVisible = true;
      } while (localObject != null);
      localObject = getTypeface();
      i = 0;
      if (localObject != null) {
        i = ((Typeface)localObject).getStyle();
      }
      localObject = getHintTextColors();
      localObject = new HintSpan(i, (int)getTextSize(), (ColorStateList)localObject, (ColorStateList)localObject);
      localEditable.insert(prefix.length(), localCharSequence);
      localEditable.setSpan(localObject, prefix.length(), prefix.length() + getHint().length(), 33);
      setSelection(prefix.length());
      return;
    } while (localObject == null);
    int i = localEditable.getSpanStart(localObject);
    int j = localEditable.getSpanEnd(localObject);
    localEditable.removeSpan(localObject);
    localEditable.replace(i, j, "");
    hintVisible = false;
  }
  
  public final void addObject(T paramT)
  {
    post(new TokenCompleteTextView.3(this, paramT, ""));
  }
  
  protected CharSequence convertSelectionToString(Object paramObject)
  {
    selectedObject = paramObject;
    switch (TokenCompleteTextView.7.$SwitchMap$com$tokenautocomplete$TokenCompleteTextView$TokenDeleteStyle[deletionStyle.ordinal()])
    {
    default: 
      return super.convertSelectionToString(paramObject);
    case 1: 
      return "";
    case 2: 
      return currentCompletionText();
    }
    if (paramObject != null) {
      return paramObject.toString();
    }
    return "";
  }
  
  public abstract T defaultObject$9543ced();
  
  public boolean enoughToFilter()
  {
    boolean bool = true;
    Editable localEditable = getText();
    int k = getSelectionEnd();
    if ((k < 0) || (tokenizer == null)) {
      bool = false;
    }
    int i;
    do
    {
      return bool;
      int j = tokenizer.findTokenStart(localEditable, k);
      i = j;
      if (j < prefix.length()) {
        i = prefix.length();
      }
    } while (k - i >= Math.max(getThreshold(), 1));
    return false;
  }
  
  public boolean extractText(ExtractedTextRequest paramExtractedTextRequest, ExtractedText paramExtractedText)
  {
    try
    {
      boolean bool = super.extractText(paramExtractedTextRequest, paramExtractedText);
      return bool;
    }
    catch (IndexOutOfBoundsException paramExtractedTextRequest)
    {
      Log.d("TokenAutoComplete", "extractText hit IndexOutOfBoundsException. This may be normal.", paramExtractedTextRequest);
    }
    return false;
  }
  
  public List<T> getObjects()
  {
    return objects;
  }
  
  protected ArrayList<Serializable> getSerializableObjects()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getObjects().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof Serializable)) {
        localArrayList.add((Serializable)localObject);
      } else {
        Log.e("TokenAutoComplete", "Unable to save '" + localObject + "'");
      }
    }
    if (localArrayList.size() != objects.size()) {
      Log.e("TokenAutoComplete", "You should make your objects Serializable or override\ngetSerializableObjects and convertSerializableArrayToObjectArray");
    }
    return localArrayList;
  }
  
  public abstract View getViewForObject(T paramT);
  
  public void invalidate()
  {
    if ((Build.VERSION.SDK_INT >= 16) && (initialized) && (!inInvalidate))
    {
      inInvalidate = true;
      setShadowLayer(getShadowRadius(), getShadowDx(), getShadowDy(), getShadowColor());
      inInvalidate = false;
    }
    super.invalidate();
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    TokenCompleteTextView.TokenInputConnection localTokenInputConnection = new TokenCompleteTextView.TokenInputConnection(this, super.onCreateInputConnection(paramEditorInfo));
    imeOptions &= 0xBFFFFFFF;
    imeOptions |= 0x10000000;
    return localTokenInputConnection;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      handleDone();
      return true;
    }
    return false;
  }
  
  public void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean) {
      performCompletion();
    }
    if (allowCollapse) {
      performCollapse(paramBoolean);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!super.onKeyDown(paramInt, paramKeyEvent)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      if (paramKeyEvent.hasNoModifiers())
      {
        shouldFocusNext = true;
        bool1 = true;
        continue;
        bool1 = deleteSelectedObject(false);
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    if (shouldFocusNext)
    {
      shouldFocusNext = false;
      handleDone();
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    lastLayout = getLayout();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof TokenCompleteTextView.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      paramParcelable = (TokenCompleteTextView.SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getSuperState());
      setText(prefix);
      prefix = prefix;
      updateHint();
      allowCollapse = allowCollapse;
      allowDuplicates = allowDuplicates;
      performBestGuess = performBestGuess;
      tokenClickStyle = tokenClickStyle;
      deletionStyle = tokenDeleteStyle;
      splitChar = splitChar;
      resetListeners();
      paramParcelable = baseObjects.iterator();
      while (paramParcelable.hasNext()) {
        addObject(paramParcelable.next());
      }
    } while ((isFocused()) || (!allowCollapse));
    post(new TokenCompleteTextView.6(this));
  }
  
  public Parcelable onSaveInstanceState()
  {
    ArrayList localArrayList = getSerializableObjects();
    savingState = true;
    Object localObject = super.onSaveInstanceState();
    savingState = false;
    localObject = new TokenCompleteTextView.SavedState((Parcelable)localObject);
    prefix = prefix;
    allowCollapse = allowCollapse;
    allowDuplicates = allowDuplicates;
    performBestGuess = performBestGuess;
    tokenClickStyle = tokenClickStyle;
    tokenDeleteStyle = deletionStyle;
    baseObjects = localArrayList;
    splitChar = splitChar;
    return (Parcelable)localObject;
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    if (hintVisible) {
      paramInt1 = 0;
    }
    if ((tokenClickStyle != null) && (tokenClickStyle.mIsSelectable) && (getText() != null)) {
      clearSelections();
    }
    if ((prefix != null) && ((paramInt1 < prefix.length()) || (paramInt1 < prefix.length())))
    {
      setSelection(prefix.length());
      return;
    }
    Editable localEditable = getText();
    if (localEditable != null)
    {
      TokenCompleteTextView.TokenImageSpan[] arrayOfTokenImageSpan = (TokenCompleteTextView.TokenImageSpan[])localEditable.getSpans(paramInt1, paramInt1, TokenCompleteTextView.TokenImageSpan.class);
      int i = arrayOfTokenImageSpan.length;
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        TokenCompleteTextView.TokenImageSpan localTokenImageSpan = arrayOfTokenImageSpan[paramInt2];
        int j = localEditable.getSpanEnd(localTokenImageSpan);
        if ((paramInt1 <= j) && (localEditable.getSpanStart(localTokenImageSpan) < paramInt1))
        {
          if (j == localEditable.length())
          {
            setSelection(j);
            return;
          }
          setSelection(j + 1);
          return;
        }
        paramInt2 += 1;
      }
    }
    super.onSelectionChanged(paramInt1, paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    Object localObject = getText();
    boolean bool2 = false;
    if (tokenClickStyle == TokenCompleteTextView.TokenClickStyle.None) {
      bool2 = super.onTouchEvent(paramMotionEvent);
    }
    boolean bool1 = bool2;
    if (isFocused())
    {
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (lastLayout != null)
        {
          bool1 = bool2;
          if (i == 1)
          {
            i = getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
            bool1 = bool2;
            if (i != -1)
            {
              localObject = (TokenCompleteTextView.TokenImageSpan[])((Editable)localObject).getSpans(i, i, TokenCompleteTextView.TokenImageSpan.class);
              if (localObject.length <= 0) {
                break label149;
              }
              localObject[0].onClick();
            }
          }
        }
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (tokenClickStyle != TokenCompleteTextView.TokenClickStyle.None) {
          bool2 = super.onTouchEvent(paramMotionEvent);
        }
      }
      return bool2;
      label149:
      clearSelections();
    }
  }
  
  public final void performCollapse(boolean paramBoolean)
  {
    focusChanging = true;
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    int j;
    if (!paramBoolean)
    {
      localObject1 = getText();
      if ((localObject1 != null) && (lastLayout != null))
      {
        i = lastLayout.getLineVisibleEnd(0);
        localObject2 = (TokenCompleteTextView.TokenImageSpan[])((Editable)localObject1).getSpans(0, i, TokenCompleteTextView.TokenImageSpan.class);
        int k = objects.size() - localObject2.length;
        localObject3 = (CountSpan[])((Editable)localObject1).getSpans(0, i, CountSpan.class);
        if ((k > 0) && (localObject3.length == 0))
        {
          j = i + 1;
          localObject3 = new CountSpan(k, getContext(), getCurrentTextColor(), (int)getTextSize(), (int)maxTextWidth());
          ((Editable)localObject1).insert(j, text);
          i = j;
          if (Layout.getDesiredWidth((CharSequence)localObject1, 0, text.length() + j, lastLayout.getPaint()) > maxTextWidth())
          {
            ((Editable)localObject1).delete(j, text.length() + j);
            if (localObject2.length <= 0) {
              break label343;
            }
            i = ((Editable)localObject1).getSpanStart(localObject2[(localObject2.length - 1)]);
            ((CountSpan)localObject3).setCount(k + 1);
          }
          for (;;)
          {
            ((Editable)localObject1).insert(i, text);
            ((Editable)localObject1).setSpan(localObject3, i, text.length() + i, 33);
            hiddenSpans = new ArrayList(Arrays.asList((TokenCompleteTextView.TokenImageSpan[])((Editable)localObject1).getSpans(text.length() + i, ((Editable)localObject1).length(), TokenCompleteTextView.TokenImageSpan.class)));
            localObject1 = hiddenSpans.iterator();
            while (((Iterator)localObject1).hasNext()) {
              removeSpan((TokenCompleteTextView.TokenImageSpan)((Iterator)localObject1).next());
            }
            label343:
            i = prefix.length();
          }
        }
      }
    }
    else
    {
      localObject1 = getText();
      if (localObject1 != null)
      {
        localObject2 = (CountSpan[])((Editable)localObject1).getSpans(0, ((Editable)localObject1).length(), CountSpan.class);
        j = localObject2.length;
        i = 0;
        while (i < j)
        {
          localObject3 = localObject2[i];
          ((Editable)localObject1).delete(((Editable)localObject1).getSpanStart(localObject3), ((Editable)localObject1).getSpanEnd(localObject3));
          ((Editable)localObject1).removeSpan(localObject3);
          i += 1;
        }
        localObject2 = hiddenSpans.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = nexttoken;
          insertSpan(localObject3, localObject3.toString());
        }
        hiddenSpans.clear();
        if (!hintVisible) {
          break label579;
        }
        setSelection(prefix.length());
      }
    }
    for (;;)
    {
      if (((TokenCompleteTextView.TokenSpanWatcher[])getText().getSpans(0, getText().length(), TokenCompleteTextView.TokenSpanWatcher.class)).length == 0) {
        ((Editable)localObject1).setSpan(spanWatcher, 0, ((Editable)localObject1).length(), 18);
      }
      focusChanging = false;
      return;
      label579:
      postDelayed(new TokenCompleteTextView.2(this, (Editable)localObject1), 10L);
    }
  }
  
  public void performCompletion()
  {
    if ((getListSelection() == -1) && (enoughToFilter()))
    {
      if ((getAdapter().getCount() > 0) && (performBestGuess)) {}
      for (Object localObject = getAdapter().getItem(0);; localObject = defaultObject$9543ced())
      {
        replaceText(convertSelectionToString(localObject));
        return;
        currentCompletionText();
      }
    }
    super.performCompletion();
  }
  
  protected void performFiltering(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = paramInt1;
    if (paramInt1 < prefix.length()) {
      paramInt3 = prefix.length();
    }
    Filter localFilter = getFilter();
    if (localFilter != null) {
      localFilter.filter(paramCharSequence.subSequence(paramInt3, paramInt2), this);
    }
  }
  
  protected void replaceText(CharSequence paramCharSequence)
  {
    clearComposingText();
    if ((selectedObject == null) || (selectedObject.toString().equals(""))) {}
    TokenCompleteTextView.TokenImageSpan localTokenImageSpan;
    Editable localEditable;
    int k;
    int i;
    String str;
    do
    {
      return;
      paramCharSequence = buildSpannableForText(paramCharSequence);
      localTokenImageSpan = buildSpanForObject(selectedObject);
      localEditable = getText();
      k = getSelectionEnd();
      int j = tokenizer.findTokenStart(localEditable, k);
      i = j;
      if (j < prefix.length()) {
        i = prefix.length();
      }
      str = TextUtils.substring(localEditable, i, k);
    } while (localEditable == null);
    if (localTokenImageSpan == null)
    {
      localEditable.replace(i, k, "");
      return;
    }
    if ((!allowDuplicates) && (objects.contains(token)))
    {
      localEditable.replace(i, k, "");
      return;
    }
    QwertyKeyListener.markAsReplaced(localEditable, i, k, str);
    localEditable.replace(i, k, paramCharSequence);
    localEditable.setSpan(localTokenImageSpan, i, paramCharSequence.length() + i - 1, 33);
  }
  
  public void setDeletionStyle(TokenCompleteTextView.TokenDeleteStyle paramTokenDeleteStyle)
  {
    deletionStyle = paramTokenDeleteStyle;
  }
  
  public void setPrefix(String paramString)
  {
    prefix = "";
    Editable localEditable = getText();
    if (localEditable != null) {
      localEditable.insert(0, paramString);
    }
    prefix = paramString;
    updateHint();
  }
  
  public void setSplitChar(char paramChar)
  {
    if (paramChar == ' ')
    {
      setSplitChar(new char[] { '§', paramChar });
      return;
    }
    setSplitChar(new char[] { paramChar });
  }
  
  public void setSplitChar(char[] paramArrayOfChar)
  {
    char[] arrayOfChar = paramArrayOfChar;
    if (paramArrayOfChar[0] == ' ') {
      if (paramArrayOfChar.length <= 1) {
        break label52;
      }
    }
    label52:
    for (int i = paramArrayOfChar[1];; i = 167)
    {
      arrayOfChar = new char[] { i, paramArrayOfChar[0] };
      splitChar = arrayOfChar;
      setTokenizer(new CharacterTokenizer(arrayOfChar));
      return;
    }
  }
  
  public void setTokenClickStyle(TokenCompleteTextView.TokenClickStyle paramTokenClickStyle)
  {
    tokenClickStyle = paramTokenClickStyle;
  }
  
  public void setTokenLimit(int paramInt)
  {
    tokenLimit = paramInt;
  }
  
  public void setTokenListener(TokenCompleteTextView.TokenListener paramTokenListener)
  {
    listener = paramTokenListener;
  }
  
  public void setTokenizer(MultiAutoCompleteTextView.Tokenizer paramTokenizer)
  {
    super.setTokenizer(paramTokenizer);
    tokenizer = paramTokenizer;
  }
}

/* Location:
 * Qualified Name:     com.tokenautocomplete.TokenCompleteTextView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */