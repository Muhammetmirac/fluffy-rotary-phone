package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml yerine bu sınıfımızı kullanacağız
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Generic Array dönüyor
    // getRootConfigClasses()---> DB ve HİBERNATE bağlantı ayarlarını tanıtmak için kullanacağız
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                //RootContextConfig.class
        };
    }

    //getServletConfigClasses() --> mvc config ayarlarım
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebMvcConfig.class
        };
    }

    //getServletMappings()---> hangi url hangi servlet ile ilişkilendirilecek
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // gelen bütün request leri bu servlet tarafından karşılanacağını söylüyoruz
    }
}
