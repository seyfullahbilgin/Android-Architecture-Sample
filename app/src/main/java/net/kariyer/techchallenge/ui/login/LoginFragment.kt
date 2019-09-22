package net.kariyer.techchallenge.ui.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_login.*
import net.kariyer.techchallenge.BR
import net.kariyer.techchallenge.R

import net.kariyer.techchallenge.ui.base.BaseFragment

import net.kariyer.techchallenge.databinding.FragmentLoginBinding

import javax.inject.Inject

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(), LoginController {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory //We inject the viewModelFactory from Dagger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.controller = this
        viewModel?.autoLogin()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setStatusBarColor(android.R.color.transparent)

        //if user activated the 'remember me' option
        //we get data of user from preferences and show them automatically
        if (viewModel?.rememberMe == true) {
            binding.switchRememberMe.isChecked = true
            binding.editTextUserName.setText(viewModel?.getUserName())
            binding.editTextPassword.setText(viewModel?.getUserPassword())
        }

        //We try to login
        binding.buttonLogin.setOnClickListener {
            viewModel?.login(editTextUserName.text.toString(), editTextPassword.text.toString())
        }

        binding.switchRememberMe.setOnCheckedChangeListener { _, isChecked ->
            viewModel?.rememberMe = isChecked
        }

        binding.textViewRememberMe.setOnClickListener {
            if (!binding.switchRememberMe.isChecked)
                binding.switchRememberMe.isChecked = true
        }
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): LoginViewModel {
        return ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_login
    }

    override fun gotoOrderFragment() {
        getNavController().navigate(R.id.orderFragment)
    }

    override fun showMessage(message: String) {
        showSnackBar(message)
    }
}


