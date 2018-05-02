package endtest.chaps.flo.endtechnicalassignment.presentation.base

/**
 * Base view any view of the application must extend.
 */
interface BaseView {

    fun setPresenter(presenter: Presenter<*>)
}