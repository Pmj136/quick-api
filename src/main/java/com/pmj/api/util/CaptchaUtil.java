package com.pmj.api.util;

import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.base.Captcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 彭明久
 * @since 2021-03-18
 */
public class CaptchaUtil {
    private static HttpServletRequest request;
    private static HttpServletResponse response;

    public static void init(HttpServletRequest req,
                            HttpServletResponse resp) {
        CaptchaUtil.request = req;
        CaptchaUtil.response = resp;
    }

    public static void generate() {
        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 三个参数分别为宽、高、位数
        // SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);

        // GifCaptcha specCaptcha = new GifCaptcha(130, 48);

        // 算术类型
        ArithmeticCaptcha specCaptcha = new ArithmeticCaptcha(180, 60);
        specCaptcha.setLen(3);  // 几位数运算，默认是两位
        // specCaptcha.getArithmeticString();  // 获取运算的公式：3+2=?
        // specCaptcha.text();  // 获取运算的结果：5

        // 设置字体
        // specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // 有默认字体，可以不用设置
        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);

        // 验证码存入session
        request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());

        // 输出图片流
        try {
            specCaptcha.out(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
