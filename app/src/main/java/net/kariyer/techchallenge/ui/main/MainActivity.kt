package net.kariyer.techchallenge.ui.main

import android.os.Bundle

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import net.kariyer.techchallenge.R

import net.kariyer.techchallenge.databinding.ActivityMainBinding
import net.kariyer.techchallenge.ui.base.BaseActivity


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //We use navigation framework from JetPack components to manage fragments easily
        navController = Navigation.findNavController(this, R.id.navHostFragment)
    }

    override fun getViewModel(): MainViewModel {
        return ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    fun getNavController(): NavController {
        return navController
    }

    fun showSnackBar(message: String) {
        Snackbar.make(binding.coordinatorLayout, message, Snackbar.LENGTH_LONG).show()
    }
}


