package com.traffic.exception;

import com.traffic.common.ApiCode;
import com.traffic.common.ApiResult;
import com.traffic.utils.IpUtil;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局Error/404处理
 *
 * @date 2022-01-25
 */
@ApiIgnore
@RestController
public class GlobalErrorController implements ErrorController {
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GlobalErrorController.class);
    private static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public ApiResult handleError(HttpServletRequest request, HttpServletResponse response) {
        int status = response.getStatus();
        String ipAddress = IpUtil.getRequestIp(request);
        log.info("response status =[{}] ,ipAddress=[{}]", status, ipAddress);
        switch (status) {
            case HttpServletResponse.SC_UNAUTHORIZED:
                log.error("Unauthorized");
                return ApiResult.fail(ApiCode.UNAUTHORIZED);
            case HttpServletResponse.SC_FORBIDDEN:
                log.error("Permission denied");
                return ApiResult.fail(ApiCode.NOT_PERMISSION);
            case HttpServletResponse.SC_NOT_FOUND:
                log.error("404 NOT FOUND");
                return ApiResult.fail(ApiCode.NOT_FOUND);
            default:
                log.error("ERROR...");
                break;
        }
        return ApiResult.fail(ApiCode.FAIL);
    }

    public String getErrorPath() {
        log.error("errorPath....");
        return ERROR_PATH;
    }
}
