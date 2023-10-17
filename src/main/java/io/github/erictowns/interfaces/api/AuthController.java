package io.github.erictowns.interfaces.api;

import io.github.erictowns.interfaces.entity.Resp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: auth api
 *
 * @author EricTowns
 * @date 2023/10/17 14:26
 */
@RestController
@RequestMapping("auth")
public class AuthController {

    @GetMapping("hello")
    public Resp hello() {
        return Resp.success("hello burke!");
    }

}
