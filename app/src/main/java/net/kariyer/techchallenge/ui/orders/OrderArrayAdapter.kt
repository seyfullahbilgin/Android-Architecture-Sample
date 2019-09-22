package net.kariyer.techchallenge.ui.orders

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.kariyer.techchallenge.data.entitiy.Product
import net.kariyer.techchallenge.databinding.ItemOrderBinding
import net.kariyer.techchallenge.data.entitiy.ProductViewState

class OrderArrayAdapter : RecyclerView.Adapter<OrderItemViewHolder>(), OrderItemStateCallback {

    //This callback useful for user interactions on item view
    var itemCallback: OrderItemCallback? = null

    //This list stores the order items fetch from network
    private var items: ArrayList<Product> = ArrayList()

    //This list stores the state of views in the recycler view
    private var itemViewStates = SparseArray<ProductViewState>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemViewHolder {
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: OrderItemViewHolder, position: Int) {
        var item: Product = items[position]
        holder.bind(item)

        holder.let {
            //We bind item
            it.bind(item)
            //We set the view state
            it.setViewState(itemViewStates.get(position, ProductViewState.DEFAULT))
            //We assign the callbacks
            it.itemCallback = itemCallback
            it.stateChangeCallback = this
        }
    }

    //We load data inside the adapter
    fun loadItems(items: ArrayList<Product>) {
        this.items = items
        notifyDataSetChanged()
    }

    //We handle the state changes from view holder
    override fun onStateChanged(position: Int, state: ProductViewState) {
        itemViewStates.put(position, state)
    }
}