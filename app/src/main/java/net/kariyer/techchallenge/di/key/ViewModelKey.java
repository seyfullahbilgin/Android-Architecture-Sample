package net.kariyer.techchallenge.di.key;

import androidx.lifecycle.ViewModel;
import dagger.MapKey;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
