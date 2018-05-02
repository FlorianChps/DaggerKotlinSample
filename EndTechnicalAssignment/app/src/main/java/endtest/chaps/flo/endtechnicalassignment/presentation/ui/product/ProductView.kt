package endtest.chaps.flo.endtechnicalassignment.presentation.ui.product

import endtest.chaps.flo.endtechnicalassignment.presentation.base.BaseView
import endtest.chaps.flo.endtechnicalassignment.data.model.Product

interface ProductView : BaseView {

    fun displayProducts(products: List<Product>?)

    fun showLoading()

    fun hideLoading()

    fun displayError(errorMessage: String)
}