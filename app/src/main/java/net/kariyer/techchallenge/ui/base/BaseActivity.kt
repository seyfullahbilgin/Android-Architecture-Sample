package net.kariyer.techchallenge.ui.base

import androidx.lifecycle.ViewModel
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

//Base class for all activities.
//It also inherits the DaggerAppCompatActivity to be able to injected to the dependency graph automatically
abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> : DaggerAppCompatActivity() {

    protected lateinit var binding: T

    @JvmField
    protected var viewModel: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        viewModel = getViewModel()
    }

    abstract fun getViewModel(): V

    @LayoutRes
    abstract fun getLayoutId(): Int

    protected fun getDataBinding(): T? {
        return binding
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}
