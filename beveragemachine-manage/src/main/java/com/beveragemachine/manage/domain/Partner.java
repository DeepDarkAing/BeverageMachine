package com.beveragemachine.manage.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.beveragemachine.common.annotation.Excel;
import com.beveragemachine.common.core.domain.BaseEntity;

/**
 * 合作商管理对象 tb_partner
 * 
 * @author aing
 * @date 2025-10-18
 */
@Data
public class Partner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合作商主键ID */
    private Long id;

    /** 合作商名称 */
    @Excel(name = "合作商名称")
    private String partnerName;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactPerson;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactPhone;

    /** 分成比例 */
    @Excel(name = "分成比例")
    private Double sharingRatio;

    /** 账号 */
    @Excel(name = "账号")
    private String account;

    /** 密码 */
    private String password;

}
