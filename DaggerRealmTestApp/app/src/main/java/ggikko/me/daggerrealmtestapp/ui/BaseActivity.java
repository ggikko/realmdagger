package ggikko.me.daggerrealmtestapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ggikko.me.daggerrealmtestapp.dagger.injector.ApplicationInjector;
import lombok.Getter;

/**
 * Created by admin on 16. 5. 29..
 */
public class BaseActivity extends AppCompatActivity {

    @Getter
    private ApplicationInjector applicationInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        inject();
        super.onCreate(savedInstanceState);
    }

//    private void inject() {
//        final GgikkoApplication application = ((GgikkoApplication) getApplication());
//        applicationInjector = application.getInjectorCreator().makeApplicationInjector(getapplic);
//        applicationInjector.inject(this);
//    }
}
