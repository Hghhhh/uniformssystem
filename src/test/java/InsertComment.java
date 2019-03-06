import com.sun.javafx.collections.MappingChange;
import com.yidong.UniformssystemApplication;
import com.yidong.model.Goods;
import com.yidong.model.Price;
import com.yidong.model.User;
import com.yidong.service.CommentService;
import com.yidong.service.GoodsService;
import com.yidong.service.OrderformService;
import com.yidong.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes={UniformssystemApplication.class})// 指定启动类
public class InsertComment {

    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    /**
     * 用来添加评论的
     */
    @Test
    public void addComment(){
        List<String> userId =null;
        List<Integer> orderFormGoodsId = new ArrayList<>();
       /* for(int i = 222;i<=266;i++)
        {
            orderFormGoodsId.add(i);
        }*/
        /*
        for(int i = 206;i<=211;i++)
        {
            orderFormGoodsId.add(i);
        }*/
        //orderFormGoodsId.add(215);
        orderFormGoodsId.add(223);
        orderFormGoodsId.add(222);
        orderFormGoodsId.add(211);
        orderFormGoodsId.add(226);
        orderFormGoodsId.add(228);

        int[] goodsList= {75,78};

        userId = userService.getUserId();
        int userSize = userId.size();
        int goodsSize = goodsList.length;
        int orderFormSize = orderFormGoodsId.size();
        int randUser = 0;
        int randGoods = 0;
        int randOrderForm = 0;
        List<String> contents = getContens();
        int randContent = 0;
        int contentSize = contents.size();
        for(int i = 0;i<50;i++){
            randUser = (int)(Math.random()*userSize);
            randGoods = (int)(Math.random()*goodsSize);
            randOrderForm = (int)(Math.random()*orderFormSize);
            if(randContent==contentSize-1){
                randContent=0;
            }
            commentService.insertCommentForRandom(userId.get(randUser),contents.get(randContent++),1,goodsList[randGoods],
                    orderFormGoodsId.get(randOrderForm));
        }
    }

    public List<String> getContens(){
        List<String> contents = new ArrayList<>();
        File file = new File("C:\\Users\\Administrator\\Desktop\\contents.txt");
        BufferedReader bufferedRead = null;
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "gbk");
             bufferedRead= new BufferedReader(read);
            String ss = null;
            while((ss=bufferedRead.readLine())!=null){
                contents.add(ss);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bufferedRead.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return contents;
    }

}
