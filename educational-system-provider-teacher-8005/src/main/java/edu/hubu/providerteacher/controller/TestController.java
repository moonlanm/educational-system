package edu.hubu.providerteacher.controller;

import edu.hubu.commons.model.admin.Admin;
import edu.hubu.commons.model.admin.Role;
import edu.hubu.commons.service.admin.IAdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moonlan
 * date 2021/1/26 下午4:25
 */
@SuppressWarnings(value = "unused")
@RestController
public class TestController {

    private final IAdminService service;

    public TestController(IAdminService service) {this.service = service;}

    @GetMapping("/save")
    public Admin test() {
        return service.save(new Admin()
                .setAdminId("1").setAdminName("MOONLAN")
                .setAdminIsDeleted(false).setAdminIsForbidden(false)
                .setAdminPassword("123")
                .setRole(new Role().setRoleId("1").setRoleIsForbidden(false).setRoleIsDeleted(false).setRoleName(
                        "ADMIN")));
    }
}
