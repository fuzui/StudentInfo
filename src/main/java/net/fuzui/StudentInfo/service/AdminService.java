package net.fuzui.StudentInfo.service;

import org.springframework.stereotype.Service;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.service
 * @ClassName: AdminService
 * @Description: 管理员service接口
 * @Author: 王泽
 * @CreateDate: 2019-04-09 22:03
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-09 22:03
 * @UpdateRemark: 新建
 * @Version: 1.0
 */

public interface AdminService {

    /**
     *  管理员登录设置
     * @param aname   管理员账号（唯一）
     * @param apassword   密码
     * @return
     */
    public String queryByNamePwd(String aname, String apassword);

}
