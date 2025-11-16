package com.beveragemachine.manage.mapper;

import java.util.List;

import com.beveragemachine.manage.domain.Node;
import com.beveragemachine.manage.domain.VO.NodeVO;
import com.beveragemachine.manage.domain.VendingMachine;
import org.apache.ibatis.annotations.Select;

/**
 * 点位管理Mapper接口
 *
 * @author aing
 * @date 2025-10-18
 */
public interface NodeMapper {
    /**
     * 查询点位管理
     *
     * @param id 点位管理主键
     * @return 点位管理
     */
    public Node selectNodeById(Long id);

    /**
     * 查询点位管理列表
     *
     * @param node 点位管理
     * @return 点位管理集合
     */
    public List<NodeVO> selectNodeList(Node node);

    /**
     * 新增点位管理
     *
     * @param node 点位管理
     * @return 结果
     */
    public int insertNode(Node node);

    /**
     * 修改点位管理
     *
     * @param node 点位管理
     * @return 结果
     */
    public int updateNode(Node node);

    /**
     * 删除点位管理
     *
     * @param id 点位管理主键
     * @return 结果
     */
    public int deleteNodeById(Long id);

    /**
     * 批量删除点位管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNodeByIds(Long[] ids);

    @Select("select inner_code,vm_status,last_supply_time from tb_vending_machine where node_id = #{id}")
    List<VendingMachine> selectNodeVmList(Long id);
}
