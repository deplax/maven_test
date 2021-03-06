import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.util.Properties;


public class testGetProp {

    @Test
    public void getproperties() {

        Properties prop = new Properties();
        String propFileName = "src/main/conf/conf_dev.properties";
        propFileName = "conf_dev.properties";
//        propFileName = "target/classes/conf_dev.properties";

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream input = loader.getResourceAsStream(propFileName);
//            input = new FileInputStream(propFileName);

            if (input != null) {
                prop.load(input);
            } else {
                Assert.assertFalse(true);
                throw new FileNotFoundException("property file " + propFileName + " not found in the classpath");
            }

            String dev = prop.getProperty("devconfig");
            System.out.println(dev);
            Assert.assertTrue(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


//        import java.io.FileNotFoundException;
//        import java.io.IOException;
//        import java.io.InputStream;
//        import java.util.Date;
//        import java.util.Properties;
//
//public class CrunchifyGetPropertyValues {
//    String result = "";
//    InputStream inputStream;
//
//    public String getPropValues() throws IOException {
//
//        try {
//            Properties prop = new Properties();
//            String propFileName = "config.properties";
//
//            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
//
//            if (inputStream != null) {
//                prop.load(inputStream);
//            } else {
//                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
//            }
//
//            Date time = new Date(System.currentTimeMillis());
//
//            // get the property value and print it out
//            String user = prop.getProperty("user");
//            String company1 = prop.getProperty("company1");
//            String company2 = prop.getProperty("company2");
//            String company3 = prop.getProperty("company3");
//
//            result = "Company List = " + company1 + ", " + company2 + ", " + company3;
//            System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
//        } catch (Exception e) {
//            System.out.println("Exception: " + e);
//        } finally {
//            inputStream.close();
//        }
//        return result;
//    }