import com.baidu.aip.imagesearch.AipImageSearch;
import com.house.platform.api.Application;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/*
 * @Author felix
 * @Description
 * @Date 10:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})// 指定启动类
public class aiTest {

    @Autowired
    AipImageSearch client;


    //相似图片入库
    @Test
    public void  put(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("brief", "{\"name\":\"新垣结衣\", \"id\":\"666\"}");
        options.put("tags", "1");  //1838702144,2471776087
        // 参数为本地路径
        String image = "C:\\Users\\Administrator\\Desktop\\ai\\1.jpg";
        try {
            JSONObject res = client.similarAdd(image, options);
            System.out.println(res.toString(2));
        }catch (Exception e){
        }
    }
    @Test
    public void  get(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("pn", "0");
        options.put("rn", "250");
        // 参数为本地路径
        String image = "C:\\Users\\Administrator\\Desktop\\ai\\39430f88cb619e6f262d1d59325db90.jpg";
        try {
            JSONObject res = client.sameHqSearch(image, options);
            System.out.println(res.toString(2));
        }catch (Exception e){
        }
    }

}


