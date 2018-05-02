package endtest.chaps.flo.endtechnicalassignment.presentation.base

import java.lang.ref.WeakReference

open class BasePresenter<V : BaseView> : Presenter<V> {

    private var weakReference: WeakReference<V>? = null

    val view: V? get() = weakReference?.get()

    override fun attachView(view: V) {
        weakReference = WeakReference(view)
        view.setPresenter(this)
    }

    override fun detachView() {
        weakReference?.clear()
        weakReference = null
    }
}