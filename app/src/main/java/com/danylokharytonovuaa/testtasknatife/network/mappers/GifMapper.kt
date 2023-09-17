package com.danylokharytonovuaa.testtasknatife.network.mappers

import com.danylokharytonovuaa.testtasknatife.domain.Mapper
import com.danylokharytonovuaa.testtasknatife.domain.model.DataDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.DownsizedMediumDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.FixedHeightSmallDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.GifDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.ImagesDomain
import com.danylokharytonovuaa.testtasknatife.network.model.trending.DataNetwork
import com.danylokharytonovuaa.testtasknatife.network.model.trending.DownsizedMediumNetwork
import com.danylokharytonovuaa.testtasknatife.network.model.trending.FixedHeightSmallNetwork
import com.danylokharytonovuaa.testtasknatife.network.model.trending.GifNetwork
import com.danylokharytonovuaa.testtasknatife.network.model.trending.ImagesNetwork

//Mapper for gif
class GifMapper : Mapper<GifNetwork, GifDomain> {
    override fun networkToDomain(network: GifNetwork): GifDomain {
        val dataDomainList =
            DataDomain(
                images = ImagesDomain(
                    fixedHeightSmall = FixedHeightSmallDomain(
                        url = network.data.images.fixedHeightSmall.url,
                        height = network.data.images.fixedHeightSmall.height,
                        width = network.data.images.fixedHeightSmall.width
                    ),
                    downsizedMedium = DownsizedMediumDomain(
                        url = network.data.images.downsizedMedium.url,
                        height = network.data.images.downsizedMedium.height,
                        width = network.data.images.downsizedMedium.width
                    )
                ),
                id = network.data.id,
                rating = network.data.rating,
                slug = network.data.slug,
                source = network.data.source,
                title = network.data.title,
                type = network.data.type,
                url = network.data.url,
                username = network.data.username
            )
        return GifDomain(dataDomainList)
    }

    override fun domainToNetwork(domain: GifDomain): GifNetwork {
        val dataNetworkList =
            DataNetwork(
                images = ImagesNetwork(
                    fixedHeightSmall = FixedHeightSmallNetwork(
                        url = domain.data.images.fixedHeightSmall.url,
                        height = domain.data.images.fixedHeightSmall.height,
                        width = domain.data.images.fixedHeightSmall.width
                    ),
                    downsizedMedium = DownsizedMediumNetwork(
                        url = domain.data.images.fixedHeightSmall.url,
                        height = domain.data.images.fixedHeightSmall.height,
                        width = domain.data.images.fixedHeightSmall.width
                    )
                ),
                id = domain.data.id,
                rating = domain.data.rating,
                slug = domain.data.slug,
                source = domain.data.source,
                title = domain.data.title,
                type = domain.data.type,
                url = domain.data.url,
                username = domain.data.username
            )

        return GifNetwork(dataNetworkList)
    }
}