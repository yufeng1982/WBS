package com.wbs.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.wbs.shiro.JWTFilter;
import com.wbs.shiro.ShiroRealm;

@Configuration
public class ShiroConfiguration {

	
	//注入自定义的realm，告诉shiro如何获取用户信息来做登录或权限控制
	@Bean
	public Realm realm() {
	    return new ShiroRealm();
	}

	@Bean
	public ShiroFilterChainDefinition  shiroFilterChainDefinition() {
	
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
	
        chain.addPathDefinition("/js/**", "anon");//可以匿名访问
		chain.addPathDefinition("/css/**", "anon");//可以匿名访问
		chain.addPathDefinition("/images/**", "anon");//可以匿名访问
		
		//访问控制
		chain.addPathDefinition("/users/login", "anon");//可以匿名访问
//		chain.addPathDefinition("/users/*", "anon");//可以匿名访问
		
		
		//API
		chain.addPathDefinition("/api/*", "anon");//可以匿名访问
		chain.addPathDefinition("/api/registe", "anon");//可以匿名访问
		chain.addPathDefinition("/api/sendSms", "anon");//可以匿名访问
		chain.addPathDefinition("/api/forgetPassword", "anon");//可以匿名访问
		
		
		//其它路径均需要登录
		chain.addPathDefinition("/**", "authc");
		chain.addPathDefinition("/**", "jwt");
	
        return chain;
   }
	   
	    //Filter工厂，设置对应的过滤条件和跳转条件
	@Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(org.apache.shiro.mgt.SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt", new JWTFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
    
        shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroFilterChainDefinition().getFilterChainMap());

        return shiroFilterFactoryBean;
    }
	   
	@Bean
	public JWTFilter jwtFilter(){
	    return new JWTFilter();//此处为AccessToken
	}
	   
	@Bean
	public SessionsSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(realm());
	       
		// 关闭自带session
        DefaultSessionStorageEvaluator evaluator = new DefaultSessionStorageEvaluator();
        evaluator.setSessionStorageEnabled(false);
	
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        subjectDAO.setSessionStorageEvaluator(evaluator);
	
        securityManager.setSubjectDAO(subjectDAO);	
       
        return securityManager;
	}
	   
//	@Bean
//	public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
//        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
//	        /**
//	         * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
//			         * 在@Controller注解的类的方法中加入@RequiresRole等shiro注解，会导致该方法无法映射请求，导致返回404。
//			         * 加入这项配置能解决这个bug
//			*/
//        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
//        return defaultAdvisorAutoProxyCreator;
//    }
	   
	@Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
	   
	@Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
	
   	@Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public static DefaultAdvisorAutoProxyCreator getLifecycleBeanPostProcessor() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }	
}
