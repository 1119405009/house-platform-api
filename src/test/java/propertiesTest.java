import com.house.platform.api.Application;
import com.house.platform.api.config.AiServiceProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * @Author felix
 * @Description
 * @Date 10:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})// 指定启动类
public class propertiesTest {


    @Autowired
    public AiServiceProperties properties;




    @Test
    public void  get(){
        System.out.println(properties);
        System.out.println(properties.getAppId());
    }
}
