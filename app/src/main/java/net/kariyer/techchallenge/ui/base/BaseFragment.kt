package net.kariyer.techchallenge.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

import dagger.android.support.DaggerFragment
import net.kariyer.techchallenge.ui.main.MainActivity
import net.kariyer.techchallenge.util.setStatusBarColor
import net.kariyer.techchallenge.util.toast

//Base class for all fragments.
//It also inherits the DaggerFragment to be able to injected to the dependency graph automatically
abstract class BaseFragment<T : ViewDataBinding, V : ViewModel> : DaggerFragment() {

    protected lateinit var binding: T

    @JvmField
    protected var viewModel: V? = null

    private var isToolsShowing = true

    lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()

        mainActivity = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return performDataBinding(inflater, container)
    }


    abstract fun getBindingVariable(): Int

    protected fun getDataBinding(): T? {
        return binding
    }

    abstract fun getViewModel(): V

    @LayoutRes
    abstract fun getLayoutId(): Int

    private fun performDataBinding(inflater: LayoutInflater, container: ViewGroup?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = this
        binding.setVariable(getBindingVariable(), viewModel)
        binding.executePendingBindings()
        return binding.root
    }

    fun getNavController(): NavController {
        return mainActivity.getNavController()
    }

    open fun onBackPressed(): Boolean {
        return true
    }

    fun toast(message: String) {
        context?.toast(message)
    }

    fun showSnackBar(message: String) {
        mainActivity.showSnackBar(message)
    }

    fun setStatusBarColor(@ColorRes id: Int) {
        mainActivity.setStatusBarColor(id)
    }

}