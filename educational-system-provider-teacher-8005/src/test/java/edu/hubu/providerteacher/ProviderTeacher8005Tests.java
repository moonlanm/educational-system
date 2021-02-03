package edu.hubu.providerteacher;

import edu.hubu.commons.model.admin.Admin;
import edu.hubu.commons.model.admin.Role;
import edu.hubu.commons.service.admin.IAdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author moonlan
 * date 2021/1/26 下午4:04
 */
@SuppressWarnings(value = "unused")
@SpringBootTest
public class ProviderTeacher8005Tests {

    @Autowired
    @Qualifier("adminServiceImpl")
    IAdminService service;

    @Test
    public void testSave() {
        Admin admin = service.save(new Admin()
                .setAdminId("2").setAdminName("MOONLAN")
                .setAdminIsDeleted(false).setAdminIsForbidden(false)
                .setAdminPassword("123")
                .setRole(new Role().setRoleId("1").setRoleIsForbidden(false).setRoleIsDeleted(false).setRoleName(
                        "ADMIN")));
        System.out.println(admin);
    }

}
