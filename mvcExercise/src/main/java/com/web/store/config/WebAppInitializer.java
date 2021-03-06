package com.web.store.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
//		return new Class<?>[] {RootAppConfig.class};
		return null;
	}
	//WebAppConfig類別說明本應用系統的組態資訊，如通知分派器要到那些資料夾去找視圖檔、
	//告訴Spring MVC那些套件下有控制器類別等受Spring控管的類別、檔案上傳時會用到的類別、
	//那些路徑下有靜態檔案，這些靜態檔案直接由容器傳回給客戶端而不要交給控制器去處理等等。
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		return new Filter[] {characterEncodingFilter};
	}

}
