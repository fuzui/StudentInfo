package net.fuzui.StudentInfo.service.impl;

import net.fuzui.StudentInfo.mapper.AdminMapper;
import net.fuzui.StudentInfo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.service.impl
 * @ClassName: AdminServiceImpl
 * @Description: 管理员service具体实现类
 * @Author: 王泽
 * @CreateDate: 2019-04-09 22:03
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-09 22:03
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    /**
     *  管理员登录设置
     * @param aname   管理员账号（唯一）
     * @param apassword   密码
     * @return
     */
    @Override
    public String queryByNamePwd(String aname, String apassword) {
        return adminMapper.queryByNamePwd(aname,apassword);
    }
}
