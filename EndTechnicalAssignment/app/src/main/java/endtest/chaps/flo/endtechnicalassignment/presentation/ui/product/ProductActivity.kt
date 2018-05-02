package endtest.chaps.flo.endtechnicalassignment.presentation.ui.product

import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import endtest.chaps.flo.endtechnicalassignment.R
import endtest.chaps.flo.endtechnicalassignment.data.model.Product
import endtest.chaps.flo.endtechnicalassignment.presentation.base.BaseActivity
import endtest.chaps.flo.endtechnicalassignment.presentation.di.component.DaggerProductsActivityComponent
import endtest.chaps.flo.endtechnicalassignment.presentation.di.module.ProductsActivityModule
import endtest.chaps.flo.endtechnicalassignment.presentation.ui.product.detail.ProductDetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class ProductActivity : BaseActivity(), ProductView {

    private val productAdapter = ProductAdapter(::productClicked)

    @Inject
    lateinit var presenter: ProductPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fillView()
    }

    private fun fillView() {
        recycler.adapter = productAdapter
        recycler.layoutManager = GridLayoutManager(this, 2)
        presenter.loadProducts()
    }

    override fun displayProducts(products: List<Product>?) {
        products?.let {
            productAdapter.setProducts(it)
        }
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    override fun displayError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    private fun productClicked(product: Product, productImage: ImageView, productName: TextView, productPrice: TextView) {
        val pairProductImage = Pair.create<View, String>(productImage, ViewCompat.getTransitionName(productImage))
        val pairProductName = Pair.create<View, String>(productName, ViewCompat.getTransitionName(productName))
        val pairProductPrice = Pair.create<View, String>(productPrice, ViewCompat.getTransitionName(productPrice))
        val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairProductImage, pairProductName, pairProductPrice)
        startActivity(ProductDetailActivity.buildIntent(this, product), optionsCompat.toBundle())
    }

    override fun onActivityInject() {
        DaggerProductsActivityComponent.builder()
                .applicationComponent(getAppComponent())
                .productsActivityModule(ProductsActivityModule())
                .build()
                .inject(this)

        presenter.attachView(this)
    }
}
