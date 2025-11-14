package com.beveragemachine.manage.service.impl;

import java.util.List;
import java.util.Random;

import com.beveragemachine.common.utils.DateUtils;
import com.beveragemachine.manage.domain.Node;
import com.beveragemachine.manage.mapper.NodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beveragemachine.manage.mapper.VendingMachineMapper;
import com.beveragemachine.manage.domain.VendingMachine;
import com.beveragemachine.manage.service.IVendingMachineService;

/**
 * 设备管理Service业务层处理
 *
 * @author aing
 * @date 2025-11-10
 */
@Service
public class VendingMachineServiceImpl implements IVendingMachineService {
    @Autowired
    private VendingMachineMapper vendingMachineMapper;
    @Autowired
    private NodeMapper nodeMapper;

    /**
     * 查询设备管理
     *
     * @param id 设备管理主键
     * @return 设备管理
     */
    @Override
    public VendingMachine selectVendingMachineById(Long id) {
        return vendingMachineMapper.selectVendingMachineById(id);
    }

    /**
     * 查询设备管理列表
     *
     * @param vendingMachine 设备管理
     * @return 设备管理
     */
    @Override
    public List<VendingMachine> selectVendingMachineList(VendingMachine vendingMachine) {
        return vendingMachineMapper.selectVendingMachineList(vendingMachine);
    }

    /**
     * 新增设备管理
     *
     * @param vendingMachine 设备管理
     * @return 结果
     */
    @Override
    public int insertVendingMachine(VendingMachine vendingMachine) {
        // 生成内部编号
        vendingMachine.setInnerCode(generateInnerCode());
        // 查询节点信息
        Node node = nodeMapper.selectNodeById(vendingMachine.getNodeId());
        vendingMachine.setBusinessType(node.getBusinessType());
        vendingMachine.setRegionId(node.getRegionId());
        vendingMachine.setAddr(node.getDetailedAddress());
        vendingMachine.setPartnerId(node.getPartnerId());
        // 设置创建时间
        vendingMachine.setCreateTime(DateUtils.getNowDate());
        return vendingMachineMapper.insertVendingMachine(vendingMachine);
    }

    private String generateInnerCode() {
        Random random = new Random();
        String innerCode = "";

        // 生成两个大写英文字母
        for (int i = 0; i < 3; i++) {
            char letter = (char) ('A' + random.nextInt(26));
            innerCode += letter;
        }
        return innerCode + "-" + random.nextInt(10) + 0 + random.nextInt(10) + 0;
    }

    /**
     * 修改设备管理
     *
     * @param vendingMachine 设备管理
     * @return 结果
     */
    @Override
    public int updateVendingMachine(VendingMachine vendingMachine) {
        vendingMachine.setUpdateTime(DateUtils.getNowDate());
        return vendingMachineMapper.updateVendingMachine(vendingMachine);
    }

    /**
     * 批量删除设备管理
     *
     * @param ids 需要删除的设备管理主键
     * @return 结果
     */
    @Override
    public int deleteVendingMachineByIds(Long[] ids) {
        return vendingMachineMapper.deleteVendingMachineByIds(ids);
    }

    /**
     * 删除设备管理信息
     *
     * @param id 设备管理主键
     * @return 结果
     */
    @Override
    public int deleteVendingMachineById(Long id) {
        return vendingMachineMapper.deleteVendingMachineById(id);
    }
}
