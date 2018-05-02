package endtest.chaps.flo.endtechnicalassignment.presentation.base

/**
 * Base presenter any presenter of the application must extend.
 * @param View the type of the View the presenter is based on
 * @property view the view the presenter is based on
 * @constructor Injects the required dependencies
 */
interface Presenter<in View : BaseView> {

    fun attachView(view: View)
    fun detachView()
}