package com.danylokharytonovuaa.testtasknatife.network.mappers

import com.danylokharytonovuaa.testtasknatife.domain.Mapper
import com.danylokharytonovuaa.testtasknatife.domain.model.DataDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.FixedHeightSmallStillDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.GifResultDomain
import com.danylokharytonovuaa.testtasknatife.domain.model.ImagesDomain
import com.danylokharytonovuaa.testtasknatife.network.model.trending.DataNetwork
import com.danylokharytonovuaa.testtasknatife.network.model.trending.FixedHeightSmallStillNetwork
import com.danylokharytonovuaa.testtasknatife.network.model.trending.GifResultNetwork
import com.danylokharytonovuaa.testtasknatife.network.model.trending.ImagesNetwork

class TrendGifMapper : Mapper<GifResultNetwork, GifResultDomain> {
    override fun networkToDomain(network: GifResultNetwork): GifResultDomain {
        val dataDomainList = network.data.map { dataNetwork ->
            DataDomain(
                images = ImagesDomain(
                    fixedHeightSmallStill = FixedHeightSmallStillDomain(
                        url = dataNetwork.images.fixedHeightSmallStill.url,
                        height = dataNetwork.images.fixedHeightSmallStill.height,
                        width = dataNetwork.images.fixedHeightSmallStill.width
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
                    fixedHeightSmallStill = FixedHeightSmallStillNetwork(
                        url = dataDomain.images.fixedHeightSmallStill.url,
                        height = dataDomain.images.fixedHeightSmallStill.height,
                        width = dataDomain.images.fixedHeightSmallStill.width
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