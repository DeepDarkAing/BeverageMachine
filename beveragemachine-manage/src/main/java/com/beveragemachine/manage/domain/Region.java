package com.beveragemachine.manage.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.beveragemachine.common.annotation.Excel;
import com.beveragemachine.common.core.domain.BaseEntity;

/**
 * 区域管理对象 tb_region
 *
 * @author aing
 * @date 2025-10-18
 */

@Data
public class Region extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 区域主键ID
     */
    private Long id;

    /**
     * 区域名称
     */
    @Excel(name = "区域名称")
    private String regionName;

    /**
     * 点位数
     */
    @Excel(name = "点位数")
    private String nodeCount;

}
