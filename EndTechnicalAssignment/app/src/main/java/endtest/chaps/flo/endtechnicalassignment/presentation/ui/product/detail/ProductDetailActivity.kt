package endtest.chaps.flo.endtechnicalassignment.presentation.ui.product.detail

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import endtest.chaps.flo.endtechnicalassignment.R
import endtest.chaps.flo.endtechnicalassignment.data.model.Product
import endtest.chaps.flo.endtechnicalassignment.presentation.base.BaseActivity
import endtest.chaps.flo.endtechnicalassignment.presentation.di.component.DaggerProductDetailComponent
import kotlinx.android.synthetic.main.activity_product_detail.*
import java.lang.Exception
import javax.inject.Inject

class ProductDetailActivity : BaseActivity(), ProductDetailView {

    @Inject
    lateinit var presenter: ProductDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        supportPostponeEnterTransition()
        setupActionBar()
        fillView()
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun fillView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            productImage.transitionName = getString(R.string.product_image_transition)
            collapsingToolbarLayout.transitionName = getString(R.string.product_name_transition)
            productPrice.transitionName = getString(R.string.product_price_transition)
        }
    }

    override fun onStart() {
        super.onStart()
        intent.extras.apply {
            val productName = this.getString(KEY_PRODUCT_NAME)
            val productImage = this.getString(KEY_PRODUCT_IMAGE)
            val productPrice = this.getString(endtest.chaps.flo.endtechnicalassignment.presentation.ui.product.detail.ProductDetailActivity.KEY_PRODUCT_PRICE)
            presenter.getProductDetail(productImage, productName, productPrice)
        }
    }

    override fun displayUi(imageUrl: String, name: String, price: String) {
        Picasso.get()
                .load(imageUrl)
                .into(productImage, object : Callback {
                    override fun onSuccess() {
                        supportStartPostponedEnterTransition()
                    }

                    override fun onError(e: Exception?) {
                        supportStartPostponedEnterTransition()
                    }
                })
        collapsingToolbarLayout.title = name
        productPrice.text = price
    }

    override fun onActivityInject() {
        DaggerProductDetailComponent.builder()
                .applicationComponent(getAppComponent())
                .build()
                .inject(this)

        presenter.attachView(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition()
        }
    }

    companion object {

        private const val KEY_PRODUCT_NAME = "PRODUCT_NAME"
        private const val KEY_PRODUCT_IMAGE = "PRODUCT_IMAGE"
        private const val KEY_PRODUCT_PRICE = "PRODUCT_PRICE"

        fun buildIntent(context: Context, product: Product): Intent {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra(KEY_PRODUCT_NAME, product.name)
            intent.putExtra(KEY_PRODUCT_IMAGE, product.image)
            intent.putExtra(KEY_PRODUCT_PRICE, product.price)
            return intent
        }
    }
}