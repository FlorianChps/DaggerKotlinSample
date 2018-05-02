package endtest.chaps.flo.endtechnicalassignment.presentation.base

import android.app.Application
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.component.ApplicationComponent
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.component.DaggerApplicationComponent
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.module.ApiModule
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.module.ApplicationModule
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.module.RetrofitModule

class BaseApplication : Application() {

    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}