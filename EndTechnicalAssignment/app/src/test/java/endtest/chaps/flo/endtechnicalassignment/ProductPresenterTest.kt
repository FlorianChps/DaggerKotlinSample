package endtest.chaps.flo.endtechnicalassignment

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import endtest.chaps.flo.endtechnicalassignment.data.service.EndClothingService
import endtest.chaps.flo.endtechnicalassignment.presentation.ui.product.ProductPresenter
import endtest.chaps.flo.endtechnicalassignment.presentation.ui.product.ProductView
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class ProductPresenterTest {

    private val view: ProductView = Mockito.mock(ProductView::class.java)
    private val service: EndClothingService = Mockito.mock(EndClothingService::class.java)
    private lateinit var presenter: ProductPresenter
    private lateinit var testScheduler: TestScheduler

    @Before
    fun setup() {
        testScheduler = TestScheduler()
        presenter = ProductPresenter(service)
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

    @Test
    fun testGetProductError() {
        val throwable: Throwable = mock()
        doReturn(Single.just(throwable))
                .`when`(service)
                .getProducts()

        presenter.loadProducts()

        testScheduler.triggerActions()

        throwable.localizedMessage?.let {
            verify(view).displayError(it)
        }

    }
}