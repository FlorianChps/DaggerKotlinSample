package endtest.chaps.flo.endtechnicalassignment.presentation.di.module

import dagger.Module
import dagger.Provides
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.ActivityScope
import endtest.chaps.flo.endtechnicalassignment.presentation.ui.product.detail.ProductDetailPresenter

@Module
class ProductDetailActivityModule {

    @Provides
    @ActivityScope
    fun providesProductDetailPresenter(): ProductDetailPresenter {
        return ProductDetailPresenter()
    }
}