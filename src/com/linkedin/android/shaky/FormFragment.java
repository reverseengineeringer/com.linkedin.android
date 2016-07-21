package com.linkedin.android.shaky;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class FormFragment
  extends Fragment
{
  public static final String ACTION_SUBMIT_FEEDBACK = "ActionSubmitFeedback";
  public static final String EXTRA_USER_MESSAGE = "ExtraUserMessage";
  private static final String KEY_FEEDBACK_TYPE = "feedbackType";
  private static final String KEY_SCREENSHOT_URI = "Screenshot";
  
  private Toolbar.OnMenuItemClickListener createMenuClickListener(EditText paramEditText)
  {
    return new FormFragment.2(this, paramEditText);
  }
  
  private View.OnClickListener createNavigationClickListener()
  {
    return new FormFragment.1(this);
  }
  
  private int getExampleResId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return R.string.general_example;
    case 0: 
      return R.string.bug_example;
    }
    return R.string.feature_example;
  }
  
  private int getHintResId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return R.string.general_hint;
    case 0: 
      return R.string.bug_hint;
    }
    return R.string.feature_hint;
  }
  
  private int getTitleResId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return R.string.general_title;
    case 0: 
      return R.string.bug_title;
    }
    return R.string.feature_title;
  }
  
  public static FormFragment newInstance(Uri paramUri, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Screenshot", paramUri);
    localBundle.putInt("feedbackType", paramInt);
    paramUri = new FormFragment();
    paramUri.setArguments(localBundle);
    return paramUri;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.shaky_form, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = (Toolbar)paramView.findViewById(R.id.toolbar);
    EditText localEditText = (EditText)paramView.findViewById(R.id.message);
    TextView localTextView = (TextView)paramView.findViewById(R.id.hint);
    paramView = (ImageView)paramView.findViewById(R.id.attachment);
    int i = getArguments().getInt("feedbackType", 2);
    Uri localUri = (Uri)getArguments().getParcelable("Screenshot");
    paramBundle.setTitle(getTitleResId(i));
    paramBundle.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
    paramBundle.setNavigationOnClickListener(createNavigationClickListener());
    paramBundle.inflateMenu(R.menu.shaky_feedback_activity_actions);
    paramBundle.setOnMenuItemClickListener(createMenuClickListener(localEditText));
    localEditText.setHint(getHintResId(i));
    localTextView.setText(getExampleResId(i));
    if (localTextView.getText().toString().isEmpty()) {}
    for (i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      paramView.setImageURI(localUri);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.shaky.FormFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */