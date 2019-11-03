package com.rafal.model

data class SensitiveDataDto(
        var id: Long = 0L, var name: String = "", var value: String = "", var description: String = ""
)

data class SensitiveDataDtoList(
        var sensitiveDataList: List<SensitiveDataDto> = emptyList()
)
