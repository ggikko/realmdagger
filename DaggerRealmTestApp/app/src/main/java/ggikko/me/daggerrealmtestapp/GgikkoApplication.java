package ggikko.me.daggerrealmtestapp;

import android.app.Application;

import javax.inject.Inject;

import ggikko.me.daggerrealmtestapp.dagger.component.GgikkoApplicationComponent;
import ggikko.me.daggerrealmtestapp.dagger.injector.ApplicationInjector;
import ggikko.me.daggerrealmtestapp.dagger.injector.InjectorCreator;
import ggikko.me.daggerrealmtestapp.repository.DatabaseRealm;
import lombok.Getter;

/**
 * Created by admin on 16. 5. 29..
 */
public class GgikkoApplication extends Application {

    //injector creator
    @Getter protected InjectorCreator injectorCreator;

    //app component
    @Getter private GgikkoApplicationComponent ggikkoApplicationComponent;

    //db
    @Inject DatabaseRealm databaseRealm;

    @Override
    public void onCreate() {
        super.onCreate();
        this.injectorCreator = makeInjectorCreator();
        inject();
        databaseRealm.setup();
    }

    /** initiate injector */
    protected InjectorCreator makeInjectorCreator() {
        return new InjectorCreator();
    }

    /** inject by using Injector */
    protected final void inject() {
        final ApplicationInjector applicationInjector = injectorCreator.makeApplicationInjector(GgikkoApplication.this);
        ggikkoApplicationComponent = applicationInjector.getApplicationComponent();
        applicationInjector.inject(this);
    }

}
