package com.jk.controller.util;

/*import com.jk.model.Login;
import com.jk.service.fruitsInfo.FruitsInfoServie;
import com.jk.service.shopping.ShoppingService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component*/
public class Aop {

    /*@Autowired
    private ShoppingService shoppingService;

    @Autowired
    private FruitsInfoServie fruitsInfoServie;


    @Pointcut("execution(* com.jk.controller.*.*.*(..))")
    public void logPointCut() {}


    @AfterReturning(value="logPointCut()",argNames = "rtv", returning = "rtv")
    public void cart(JoinPoint joinPoint, Object rtv) throws Exception {

        //RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //HttpSession session = request.getSession();
        //获取方法请求参数
        Object[] os = joinPoint.getArgs();
        //获取方法名
        String methodName = joinPoint.getSignature().getName();

        if(methodName.equals("toShoppingCar")){
            for (int i = 0; i < os.length; i++) {
                String param = (String) os[0];
                if(!param.equals("1")){
                    fruitsInfoServie.deleteAllCart(param);
                }
            }
        }



    }*/

}
