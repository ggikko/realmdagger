package ggikko.me.daggerrealmtestapp.dagger.injector;

import ggikko.me.daggerrealmtestapp.GgikkoApplication;
import ggikko.me.daggerrealmtestapp.dagger.component.DaggerGgikkoApplicationComponent;
import ggikko.me.daggerrealmtestapp.dagger.component.GgikkoApplicationComponent;
import ggikko.me.daggerrealmtestapp.dagger.module.GgikkoApplicationModule;
/**
 * Created by ggikko on 16. 5. 27..
 */
public class InjectorCreator {

    private GgikkoApplicationComponent applicationComponent;

    public ApplicationInjector makeApplicationInjector(GgikkoApplication application) {
        applicationComponent = DaggerGgikkoApplicationComponent.builder()
                .ggikkoApplicationModule(new GgikkoApplicationModule(application))
                .build();
        return new ApplicationInjector(applicationComponent);
    }
}
