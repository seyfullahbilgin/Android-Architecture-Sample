package net.kariyer.techchallenge.data.entitiy

data class Product(
    val date: String,
    val marketName: String,
    val month: Int,
    val orderName: String,
    val productDetail: ProductDetail,
    val productPrice: Double,
    val productState: String
)