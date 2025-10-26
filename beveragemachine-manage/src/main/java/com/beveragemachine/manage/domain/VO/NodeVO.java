package com.beveragemachine.manage.domain.VO;

import com.beveragemachine.manage.domain.Node;
import lombok.Data;

@Data
public class NodeVO extends Node {
    private String regionName;
    private String partnerName;
    private Integer vmCount;
}
