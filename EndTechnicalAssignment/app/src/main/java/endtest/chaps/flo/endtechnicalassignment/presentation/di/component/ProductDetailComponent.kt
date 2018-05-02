package endtest.chaps.flo.endtechnicalassignment.presentation.di.component

import dagger.Component
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.ActivityScope
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.component.ApplicationComponent
import endtest.chaps.flo.endtechnicalassignment.presentation.di.module.ProductDetailActivityModule
import endtest.chaps.flo.endtechnicalassignment.presentation.ui.product.detail.ProductDetailActivity

@ActivityScope
@Component(dependencies = [(ApplicationComponent::class)], modules = [(ProductDetailActivityModule::class)])
interface ProductDetailComponent {

    fun inject(productDetailActivity: ProductDetailActivity)
}