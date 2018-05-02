package endtest.chaps.flo.endtechnicalassignment.presentation.base.di.component

import android.app.Application
import dagger.Component
import endtest.chaps.flo.endtechnicalassignment.data.service.EndClothingService
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.module.ApiModule
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.module.ApplicationModule
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.module.RetrofitModule
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApiModule::class), (ApplicationModule::class), (RetrofitModule::class)])
interface ApplicationComponent {
    fun application() : Application
    fun retrofit() : Retrofit
    fun service() : EndClothingService
}