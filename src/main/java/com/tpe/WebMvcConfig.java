package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration //benim configuration classım olacak. O yüzden @Configuration anostasyonunu koyduk.
@EnableWebMvc // spring mvc ile çalışacağımı belirtmiş oluyor ve aktif edilmesini söylüyorum
@ComponentScan("com.tpe") // spring taramanı yap bean ve compenentleri bul conteynere al ileride lazım oldugunda bana getir
public class WebMvcConfig implements WebMvcConfigurer {


    //config dosyamın içerisinde ilk yapacağım iş
    //viewResolver objemi bean olarak ekliyorum

    @Bean
    public InternalResourceViewResolver resolver() { // dahili kaynak görünüm çözücü
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class); //biz .jsp ile çalıştığımız için bu formatı belirttik. farklı bir format olsaydı onu yazardık
        resolver.setPrefix("/WEB-INF/views/");  //view dosyalarımın nerede olduğunu belirttik
        resolver.setSuffix(".jsp"); // jsp uzantılı dosyaları dikkate almasını söylüyoruz
        return resolver;
    }

    @Override// kullanacağım resources ların yerini bildiriyoruz(css,image gibi ...)
    public void addResourceHandlers(ResourceHandlerRegistry registry) {  //Kaynak İşleyici Kaydı
        registry.addResourceHandler("/resources/**"). //resources altındakileri tarasın diye ** yazdık
                addResourceLocations("/resources/").
                setCachePeriod(0);
    }
}
