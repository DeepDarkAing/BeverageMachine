package com.beveragemachine.manage.domain.VO;

import com.beveragemachine.common.annotation.Excel;
import com.beveragemachine.manage.domain.Partner;
import lombok.Data;

@Data
public class PartnerVO extends Partner {
    @Excel(name = "点位数")
    private Integer nodeCount;
}
