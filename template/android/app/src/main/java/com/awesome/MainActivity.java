package com.awesome;
import android.os.Build;
import android.os.Bundle;
import expo.modules.ReactActivityDelegateWrapper;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;

public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "Awesome";
  }

  @Override
  protected ReactActivityDelegate createReactActivityDelegate() {
    return new ReactActivityDelegateWrapper(this, new ReactActivityDelegate(this, getMainComponentName()));
  }

  @Override
  public void invokeDefaultOnBackPressed() {
      if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.R) {
          if (!moveTaskToBack(false)) {
              // For non-root activities, use the default implementation to finish them.
              super.invokeDefaultOnBackPressed();
          }
          return;
      }

      // Use the default back button implementation on Android S
      // because it's doing more than {@link Activity#moveTaskToBack} in fact.
      super.invokeDefaultOnBackPressed();
  }
}
