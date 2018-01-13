package dev.trainingapp.other.handler;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class ExceptionHandler implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        log.error(e.getMessage(), e);
        val view = new ModelAndView();
        view.addObject("errorMessage", "予期せぬエラーが発生しました。");
        view.setViewName("error");
        return view;
    }
}
