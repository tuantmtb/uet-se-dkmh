//package com.tuantm.demomvc.config.servlet3;
//
//import javax.servlet.Filter;
//
//import com.tuantm.demomvc.config.CORSFilter;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import com.tuantm.demomvc.config.SpringRootConfig;
//import com.tuantm.demomvc.config.SpringWebConfig;
//
//public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
////		return new Class[] { SpringRootConfig.class };
//		return null;
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		return new Class[] { SpringWebConfig.class };
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		return new String[] { "/" };
//	}
//
//    @Override
//    protected Filter[] getServletFilters() {
//        Filter[] singleton = { new CORSFilter()};
//        return singleton;
//    }
//
//}