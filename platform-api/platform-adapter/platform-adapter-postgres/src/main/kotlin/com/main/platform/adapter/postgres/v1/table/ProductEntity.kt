package com.main.platform.adapter.postgres.v1.table

import java.util.*
import javax.persistence.*

@Entity
@Table(name="register_user")
class ProductEntity(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(name = "id_internal")
    val idInternal:Long?=null,
    @field:Column(name = "id_external")
    val idExternal: UUID? = UUID.randomUUID(),
    @field:Column(name="product_name")
    val productName:String?=null,
    @field:Column(name="image_url")
    val imageUrl:String?=null,
)