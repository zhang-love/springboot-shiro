package com.zl.springboot;

import com.zl.springboot.enumeration.testEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Test
    public void contextLoads() {
        testEnum anEnum = testEnum.enumFromType(1);
        switch (anEnum){
            case LOGIN :
                System.out.println("yes"); break;
            case LOGOUT :
                System.out.println("no"); break;
        }
        for(Enum a:testEnum.values()){
            System.out.println(a);
        }
        System.out.println(testEnum.LOGIN.getKey());
    }

}

