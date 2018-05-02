package endtest.chaps.flo.endtechnicalassignment.presentation.base.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class ApplicationModule(val application: Application) {

    @Provides
    @Reusable
    fun providesApplication() : Application {
        return application
    }
}