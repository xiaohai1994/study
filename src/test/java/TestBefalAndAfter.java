import com.spring_s.bean.AppContext;
import com.spring_s.bean.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Hai
 * @date 2023/3/19 下午7:37
 */
public class TestBefalAndAfter {

    @Test
    public void testTestBealAndAfter(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppContext.class);
        UserService userService = (UserService) annotationConfigApplicationContext.getBean("userService");
        userService.test();

    }


}
