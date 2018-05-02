package endtest.chaps.flo.endtechnicalassignment.presentation.di.component

import dagger.Component
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.ActivityScope
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.component.ApplicationComponent
import endtest.chaps.flo.endtechnicalassignment.presentation.di.module.ProductsActivityModule
import endtest.chaps.flo.endtechnicalassignment.presentation.ui.product.ProductActivity

@ActivityScope
@Component(dependencies = [(ApplicationComponent::class)], modules = [(ProductsActivityModule::class)])
interface ProductsActivityComponent {

    fun inject(productActivity: ProductActivity)
}