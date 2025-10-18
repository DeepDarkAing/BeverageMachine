package com.beveragemachine.manage.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.beveragemachine.common.annotation.Excel;
import com.beveragemachine.common.core.domain.BaseEntity;

/**
 * 点位管理对象 tb_node
 * 
 * @author aing
 * @date 2025-10-18
 */
@Data
public class Node extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 点位主键ID */
    private Long id;

    /** 点位名称 */
    @Excel(name = "点位名称")
    private String nodeName;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String detailedAddress;

    /** 商圈类型 */
    @Excel(name = "商圈类型")
    private Long businessType;

    /** 区域外键 */
    @Excel(name = "区域")
    private Long regionId;

    /** 合作商外键 */
    @Excel(name = "合作商")
    private Long partnerId;

}
