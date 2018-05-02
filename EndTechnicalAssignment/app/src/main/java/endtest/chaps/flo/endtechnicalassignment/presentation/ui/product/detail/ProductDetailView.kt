package endtest.chaps.flo.endtechnicalassignment.presentation.ui.product.detail

import endtest.chaps.flo.endtechnicalassignment.presentation.base.BaseView

interface ProductDetailView : BaseView {

    fun displayUi(imageUrl: String, name: String, price: String)
}