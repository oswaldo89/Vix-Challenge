package com.oswaldo.vixtest.detail.domain.usecase

import com.oswaldo.vixtest.detail.presentation.DetailViewModel
import com.oswaldo.vixtest.home.data.dto.EdgeX
import javax.inject.Inject

class GetFullDescriptionUseCase @Inject constructor() {
    operator fun invoke(data: EdgeX): String {
        return "${data.node.video.description}  ${DetailViewModel.LINE_BREAK} " +
                "<b>Lanzamiento:</b> ${data.node.video.copyrightYear} ${DetailViewModel.LINE_BREAK}" +
                "<b>Director:</b> ${data.node.video.contributors.find { it.roles.first() == "DIRECTOR" }?.name} ${DetailViewModel.LINE_BREAK}" +
                "<b>Elenco:</b>Elena Smith, Carlos Johnson, Sofia Martinez"
    }
}