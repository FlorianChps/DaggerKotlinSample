package endtest.chaps.flo.endtechnicalassignment.presentation.base.di.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import endtest.chaps.flo.endtechnicalassignment.data.service.EndClothingService
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    @Reusable
    fun providesEndService(retrofit: Retrofit): EndClothingService {
        return retrofit.create(EndClothingService::class.java)
    }
}