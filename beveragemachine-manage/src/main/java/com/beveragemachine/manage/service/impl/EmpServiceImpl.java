package com.beveragemachine.manage.service.impl;

import java.util.List;

import com.beveragemachine.common.utils.DateUtils;
import com.beveragemachine.common.utils.file.AliyunOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beveragemachine.manage.mapper.EmpMapper;
import com.beveragemachine.manage.domain.Emp;
import com.beveragemachine.manage.service.IEmpService;

/**
 * 员工列表Service业务层处理
 *
 * @author aing
 * @date 2025-10-28
 */
@Service
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private AliyunOSSUtils aliyunOSSUtils;

    /**
     * 查询员工列表
     *
     * @param id 员工列表主键
     * @return 员工列表
     */
    @Override
    public Emp selectEmpById(Long id) {
        return empMapper.selectEmpById(id);
    }

    /**
     * 查询员工列表列表
     *
     * @param emp 员工列表
     * @return 员工列表
     */
    @Override
    public List<Emp> selectEmpList(Emp emp) {
        return empMapper.selectEmpList(emp);
    }

    /**
     * 新增员工列表
     *
     * @param emp 员工列表
     * @return 结果
     */
    @Override
    public int insertEmp(Emp emp) {
        emp.setCreateTime(DateUtils.getNowDate());
        //uploadEmpImage(emp);
        return empMapper.insertEmp(emp);
    }

    /**
     * 修改员工列表
     *
     * @param emp 员工列表
     * @return 结果
     */
    @Override
    public int updateEmp(Emp emp) {
        emp.setUpdateTime(DateUtils.getNowDate());
        //uploadEmpImage(emp);
        return empMapper.updateEmp(emp);
    }

    /**
     * 批量删除员工列表
     *
     * @param ids 需要删除的员工列表主键
     * @return 结果
     */
    @Override
    public int deleteEmpByIds(Long[] ids) {
        return empMapper.deleteEmpByIds(ids);
    }

    /**
     * 删除员工列表信息
     *
     * @param id 员工列表主键
     * @return 结果
     */
    @Override
    public int deleteEmpById(Long id) {
        return empMapper.deleteEmpById(id);
    }

//    public Emp uploadEmpImage(Emp emp) {
//        String localImagePath = aliyunOSSUtils.convertToAbsolutePath(emp.getImage());
//        try {
//            String ossUrl = aliyunOSSUtils.uploadFile(emp.getUserName() + DateUtils.dateTimeNow() + ".jpg", localImagePath);
//            emp.setImage(ossUrl);
//            // 删除本地图片
//            aliyunOSSUtils.deleteLocalFile(localImagePath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return emp;
//    }
}
