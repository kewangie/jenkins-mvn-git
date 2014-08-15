package nonautoscan.com.ke.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.ke.test" })
public class ComponentScanConfig {

}
