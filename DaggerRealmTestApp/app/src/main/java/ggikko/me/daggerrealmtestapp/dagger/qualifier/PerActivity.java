package ggikko.me.daggerrealmtestapp.dagger.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by admin on 16. 5. 29..
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
