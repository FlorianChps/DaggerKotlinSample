package endtest.chaps.flo.endtechnicalassignment.presentation.ui.product.detail

import endtest.chaps.flo.endtechnicalassignment.presentation.base.BasePresenter

class ProductDetailPresenter : BasePresenter<ProductDetailView>() {

    fun getProductDetail(imageUrl: String, name: String, price: String) {
        view?.displayUi(imageUrl, name, price)
    }
}