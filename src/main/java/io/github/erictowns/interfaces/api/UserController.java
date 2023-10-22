package io.github.erictowns.interfaces.api;

import io.github.erictowns.application.user.UserAppService;
import io.github.erictowns.domain.user.dto.LoginDto;
import io.github.erictowns.domain.user.dto.UserInfoDto;
import io.github.erictowns.domain.user.service.UserService;
import io.github.erictowns.interfaces.entity.Resp;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * desc: user interface
 *
 * @author EricTownsChina@outlook.com
 * @date 2023-10-03 21:31
 */
@Api(tags = "用户相关接口")
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserAppService userAppService;

    @PostMapping("/login")
    public Resp login(@RequestBody LoginDto loginDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        return Resp.success();
    }



    @PostMapping("/get")
    public Resp getUserInfo(@RequestBody UserInfoDto userInfo) {
        UserInfoDto userInfoDto = userAppService.getUserInfoById(userInfo);
        return Resp.success(userInfoDto);
    }

    @ApiOperation("根据用户id获取用户名称")
    @GetMapping("/name/{id}")
    public Resp getUsername(@PathVariable String id) {
        String username = userService.getUsernameById(id);
        return Resp.success(username);
    }

}
