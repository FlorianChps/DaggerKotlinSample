package endtest.chaps.flo.endtechnicalassignment.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import endtest.chaps.flo.endtechnicalassignment.presentation.base.di.component.ApplicationComponent

abstract class BaseActivity : BaseView, AppCompatActivity() {

    private var presenter: Presenter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onActivityInject()
    }

    abstract fun onActivityInject()

    fun getAppComponent(): ApplicationComponent {
        return BaseApplication.appComponent
    }

    override fun setPresenter(presenter: Presenter<*>) {
        this.presenter = presenter
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
        presenter = null
    }
}