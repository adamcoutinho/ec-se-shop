package com.main.platform.adapter.postgres.v1.table

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="register_user")
data class RegisterUserEntity(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(name = "id_internal")
    val idInternal:Long?=null,
    @field:Column(name = "id_external")
    val idExternal: UUID? = UUID.randomUUID(),
    @field:Column(name="user_name")
    val userName:String?=null,
    @field:Column(name="email")
    val email:String?=null,
    @field:Column(name="password")
    val password:String?=null,
)