package endtest.chaps.flo.endtechnicalassignment.presentation.ui.product

import endtest.chaps.flo.endtechnicalassignment.data.service.EndClothingService
import endtest.chaps.flo.endtechnicalassignment.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProductPresenter @Inject constructor(private var service: EndClothingService) : BasePresenter<ProductView>() {

    fun loadProducts() {
        view?.showLoading()
        service.getProducts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    view?.hideLoading()
                    view?.displayProducts(it.products)
                }, {
                    view?.hideLoading()
                    view?.displayError(it.localizedMessage)
                })
    }
}