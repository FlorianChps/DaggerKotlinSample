package endtest.chaps.flo.endtechnicalassignment.presentation.di.module

import dagger.Module
import dagger.Provides
import endtest.chaps.flo.endtechnicalassignment.data.service.EndClothingService
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.ActivityScope
import endtest.chaps.flo.endtechnicalassignment.presentation.ui.product.ProductPresenter

@Module
class ProductsActivityModule {

    @Provides
    @ActivityScope
    fun providesProductsPresenter(service: EndClothingService): ProductPresenter {
        return ProductPresenter(service)
    }
}