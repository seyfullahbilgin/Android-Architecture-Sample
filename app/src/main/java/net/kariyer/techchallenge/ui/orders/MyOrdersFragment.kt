package net.kariyer.techchallenge.ui.orders

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import net.kariyer.techchallenge.BR
import net.kariyer.techchallenge.R
import net.kariyer.techchallenge.databinding.FragmentMyOrdersBinding
import net.kariyer.techchallenge.ui.base.BaseFragment

import javax.inject.Inject
import javax.inject.Provider
import androidx.appcompat.app.AlertDialog
import net.kariyer.techchallenge.util.gone
import net.kariyer.techchallenge.util.visible

class MyOrdersFragment : BaseFragment<FragmentMyOrdersBinding, MyOrdersViewModel>(),
    MyOrdersController, OrderItemCallback {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var orderArrayAdapter: OrderArrayAdapter   //We inject the array adapter contains data of orders

    @Inject
    lateinit var dividerItemDecoration: Provider<DividerItemDecoration>

    @Inject
    lateinit var linearLayoutManagerProvider: Provider<LinearLayoutManager>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel?.controller = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setStatusBarColor(R.color.orange)

        orderArrayAdapter.itemCallback = this

        binding.recyclerView.let {

            it.adapter = orderArrayAdapter
            it.layoutManager = linearLayoutManagerProvider.get()

            //you can also use item decoration
            //it.addItemDecoration(dividerItemDecoration.get())
        }

        //We fetch data of orders from server
        viewModel?.getMyOrders()?.observe(this, Observer {

            //We hide the progress bar if data loaded successfully
            binding.progressBar.gone()
            //And we transfer the loaded data to the related array adapter
            orderArrayAdapter.loadItems(it)
        })

        binding.buttonLogOut.setOnClickListener {
            showAlert()
        }
    }


    private fun showAlert() {
        AlertDialog.Builder(activity!!)
            .setMessage(getString(R.string.are_you_sure_you_want_to_log_out))
            .setPositiveButton(R.string.ok) { _, _ ->
                viewModel?.logout()
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    override fun onItemClick(orderName: String) {
        toast(orderName)
    }

    override fun gotoLoginFragment() {
        getNavController().navigate(R.id.loginFragment)
    }

    override fun showErrorMessage(message: String) {
        binding.progressBar.gone()
        binding.textViewMessage.visible()
        binding.textViewMessage.text = message
    }

    override fun showMessage(message: String) {
        showSnackBar(message)
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_my_orders
    }

    override fun getViewModel(): MyOrdersViewModel {
        return ViewModelProvider(this, viewModelFactory).get(MyOrdersViewModel::class.java)
    }
}


