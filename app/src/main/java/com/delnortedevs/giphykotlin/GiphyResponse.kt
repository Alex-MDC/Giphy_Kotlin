package com.delnortedevs.giphykotlin

//data antes del: es referido a lo de data del api de giphy
data class GiphyResponse (
    val data:List<GiphyDetails>
    ) {}

data class GiphyDetails (
    val title: String,
    val images: GiphyImages
    ) {}

data class GiphyImages (
    val fixed_height: FixedHeight
    ) {}

data class FixedHeight (
    val url: String
    ) {}

//si hay un corchete se espera arreglo de objetos
//si tiene ":{ }" sera un objeto y adelante esran sus propieades