package com.danylokharytonovuaa.testtasknatife.domain

interface Mapper<Network, Domain> {
    fun networkToDomain(network: Network) : Domain

    fun domainToNetwork(domain: Domain) : Network
}