package com.danylokharytonovuaa.testtasknatife.network.mappers

import com.danylokharytonovuaa.testtasknatife.domain.Mapper
import com.danylokharytonovuaa.testtasknatife.domain.model.DataDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.DownsizedMediumDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.FixedHeightSmallDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.GifResultDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.ImagesDomain
import com.danylokharytonovuaa.testtasknatife.network.model.trending.DataNetwork
import com.danylokharytonovuaa.testtasknatife.network.model.trending.DownsizedMediumNetwork
import com.danylokharytonovuaa.testtasknatife.network.model.trending.FixedHeightSmallNetwork
import com.danylokharytonovuaa.testtasknatife.network.model.trending.GifResultNetwork
import com.danylokharytonovuaa.testtasknatife.network.model.trending.ImagesNetwork


//Mapper for GifResult list
class TrendGifMapper : Mapper<GifResultNetwork, GifResultDomain> {
    override fun networkToDomain(network: GifResultNetwork): GifResultDomain {
        val dataDomainList = network.data.map { dataNetwork ->
            DataDomain(
                images = ImagesDomain(
                    fixedHeightSmall = FixedHeightSmallDomain(
                        url = dataNetwork.images.fixedHeightSmall.url,
                        height = dataNetwork.images.fixedHeightSmall.height,
                        width = dataNetwork.images.fixedHeightSmall.width
                    ),
                    downsizedMedium = DownsizedMediumDomain(
                        url = dataNetwork.images.downsizedMedium.url,
                        height = dataNetwork.images.downsizedMedium.height,
                        width = dataNetwork.images.downsizedMedium.width
                    )
                ),
                id = dataNetwork.id,
                rating = dataNetwork.rating,
                slug = dataNetwork.slug,
                source = dataNetwork.source,
                title = dataNetwork.title,
                type = dataNetwork.type,
                url = dataNetwork.url,
                username = dataNetwork.username
            )
        }

        return GifResultDomain(dataDomainList)
    }

    override fun domainToNetwork(domain: GifResultDomain): GifResultNetwork {
        val dataNetworkList = domain.data.map { dataDomain ->
            DataNetwork(
                images = ImagesNetwork(
                    fixedHeightSmall = FixedHeightSmallNetwork(
                        url = dataDomain.images.fixedHeightSmall.url,
                        height = dataDomain.images.fixedHeightSmall.height,
                        width = dataDomain.images.fixedHeightSmall.width
                    ),
                    downsizedMedium = DownsizedMediumNetwork(
                        url = dataDomain.images.downsizedMedium.url,
                        height = dataDomain.images.downsizedMedium.height,
                        width = dataDomain.images.downsizedMedium.width
                    )
                ),
                id = dataDomain.id,
                rating = dataDomain.rating,
                slug = dataDomain.slug,
                source = dataDomain.source,
                title = dataDomain.title,
                type = dataDomain.type,
                url = dataDomain.url,
                username = dataDomain.username
            )
        }

        return GifResultNetwork(dataNetworkList)
    }
}