package io.github.erictowns.interfaces.api;

import io.github.erictowns.interfaces.entity.Resp;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Description: servlet异常处理(一些无法被Controller层统一异常捕获到的异常处理, 像404)
 *
 * @author EricTowns
 * @date 2023/10/20 14:09
 */
@Controller
public class ErrorController extends BasicErrorController {

    public ErrorController(ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }

    /**
     * 处理filter或者interceptor异常, 保持输出和{@link Resp}一致
     *
     * @param request 请求
     * @return 返回
     */
    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        // 获取异常信息
        Map<String, Object> errors = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.ALL));
        String path = errors.getOrDefault("path", "").toString();
        String error = errors.getOrDefault("error", "").toString();
        String message = errors.getOrDefault("message", "").toString();
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        String errorMessage = joiner.add(path).add(error).add(message).toString();
        // 获取状态码
        HttpStatus status = getStatus(request);
        int statusCode = status.value();
        // 这边的entity结构和统一返回Resp保持一致
        Map<String, Object> entity = new HashMap<>(2);
        entity.put("code", statusCode);
        entity.put("msg", errorMessage);
        entity.put("data", null);
        // 返回
        return new ResponseEntity<>(entity, status);
    }
}
