package net.kariyer.techchallenge.data.entitiy

enum class ProductState(val value: String) {

    PREPARING("Hazırlanıyor"),
    WAITING_FOR_APPROVAL("Onay Bekliyor"),
    HAS_BEEN_SHIPPED("Yolda")
}