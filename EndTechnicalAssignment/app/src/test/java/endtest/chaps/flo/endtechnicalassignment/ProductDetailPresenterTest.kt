package endtest.chaps.flo.endtechnicalassignment

import endtest.chaps.flo.endtechnicalassignment.presentation.ui.product.detail.ProductDetailPresenter
import endtest.chaps.flo.endtechnicalassignment.presentation.ui.product.detail.ProductDetailView
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class ProductDetailPresenterTest {

    private val view: ProductDetailView = Mockito.mock(ProductDetailView::class.java)
    private lateinit var presenter: ProductDetailPresenter

    @Before
    fun setup() {
        presenter = ProductDetailPresenter()
    }

    @Test()
    fun testAttach() {
        assertNull(presenter.view)
        presenter.attachView(view)
        assertNotNull(presenter.view)
    }

    @Test()
    fun testDetach() {
        presenter.attachView(view)
        assertNotNull(presenter.view)
        presenter.detachView()
        assertNull(presenter.view)
    }

}