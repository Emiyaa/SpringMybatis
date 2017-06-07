package com.miku;

import com.miku.dao.ItemsMapperCustom;
import com.miku.mapper.UserMapper;
import com.miku.po.User;
import com.miku.service.impl.ItemsServiceImpl;
import com.miku.vo.ItemsCustom;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    private ApplicationContext ac;

    @Before
    public void setUp(){
        String cfg = "spring/applicationContext.xml";
        ac = new ClassPathXmlApplicationContext(cfg);
    }

    public void testInsert(){
        UserMapper userMapper = ac.getBean(UserMapper.class);
        User user = new User();
        user.setUsername("admin");
        user.setBirthday(new Date());
        user.setAddress("湖北襄阳");
        user.setSex("1");
        int flag = userMapper.insert(user);
        System.out.println(flag);
    }

    public void testFindById(){
        UserMapper userMapper = ac.getBean(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.getUsername() + "\t"
                + user.getAddress() + "\t" + user.getBirthday());
    }

    public void testFindItemsList(){
        ItemsMapperCustom imc = ac.getBean(ItemsMapperCustom.class);
        List<ItemsCustom> list = imc.findItemsList(null);
//        ItemsServiceImpl isi = ac.getBean(ItemsServiceImpl.class);
//        List<ItemsCustom> list = isi.findItemsList(null);
        for (ItemsCustom ic : list){
            System.out.println(ic.getName() + "\t" +
                    ic.getPrice() + "\t" +
                    ic.getDetail() + "\t" +
                    ic.getCreatetime());
        }
    }

    public void testMkdir(){
        Calendar date=Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String datePath = sdf.format(date.getTime());
        File path = new File( "c:/" + datePath);
        path.mkdir();
    }
}
