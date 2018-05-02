package endtest.chaps.flo.endtechnicalassignment.presentation.ui.product

import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import endtest.chaps.flo.endtechnicalassignment.R
import endtest.chaps.flo.endtechnicalassignment.data.model.Product

class ProductAdapter(private val onProductItemClickedFunction: (Product, ImageView, TextView, TextView) -> Unit) : RecyclerView.Adapter<ProductViewHolder>() {

    private var products: List<Product> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shop_piece, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindItem(products[position])
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.productImage.transitionName = holder.itemView.resources.getString(R.string.product_image_transition)
            holder.productName.transitionName = holder.itemView.resources.getString(R.string.product_name_transition)
            holder.productPrice.transitionName = holder.itemView.resources.getString(R.string.product_price_transition)
        }
        holder.itemView.setOnClickListener({
            onProductItemClickedFunction.invoke(products[position], holder.productImage, holder.productName, holder.productPrice)
        })
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun setProducts(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }
}