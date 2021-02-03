package edu.hubu.commons;

import edu.hubu.commons.model.admin.Admin;
import edu.hubu.commons.model.admin.Role;
import edu.hubu.commons.service.admin.IAdminService;
import edu.hubu.commons.service.admin.IRoleService;
import edu.hubu.commons.service.admin.impl.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author moonlan
 * date 2021/1/26 下午4:11
 */
@SuppressWarnings(value = "unused")
@SpringBootTest
public class CommonTests {

    @Autowired
    IAdminService service;

    @Autowired
    IRoleService roleService;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testSave() {
        Role role = new Role().setRoleId("1").setRoleIsForbidden(false).setRoleIsDeleted(false).setRoleName(
                "ADMIN");
        roleService.save(role);
        Admin admin = applicationContext.getBean("adminServiceImpl", AdminServiceImpl.class).save(new Admin()
                .setAdminName("MOONLAN")
                .setAdminPassword("123")
                .setRole(role));
        System.out.println(admin);
    }

    @Test
    public void testLogicalDeleteById() {
        boolean byId = service.logicalDeleteById("1");
        System.out.println(byId);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testDeleteById() {
        boolean byId = service.deleteById("1");
        System.out.println(byId);
    }

    @Test
    public void testUpdateById() {
        Admin admin = service.updateById("1", new Admin().setAdminName("HHHHHHH").setRole(new Role().setRoleId("2")));
        System.out.println(admin);
    }

    @Test
    public void testSelectAllOrderBy() {
        List<Admin> admins = service.selectAllOrderBy("adminId");
        admins.forEach(System.out::println);
    }

    @Test
    public void testSelectAllPageOrderBy() {
        List<Admin> admins = service.selectAllPageOrderBy(1, 4, "adminId");
        admins.forEach(System.out::println);
    }

    @Test
    public void testSelectLikePageOrderBy() {
        //Admin admin = new Admin().setAdminId(null).setRole(new Role().setRoleId(null).setRoleName("A"));
        //List<Admin> admins = service.selectLikePageOrderBy(1, 2, "adminId", admin);
        edu.hubu.commons.mybatis.model.Admin admin = new edu.hubu.commons.mybatis.model.Admin();
        admin.setAdminName("M");
        List<edu.hubu.commons.mybatis.model.Admin> admins = service.selectLikePageOrderBy(1, 2, "adminId", admin);
        admins.forEach(System.out::println);
    }

    @Test
    void test4() {

    }

    @Test
    public void test2() {

    }

}
