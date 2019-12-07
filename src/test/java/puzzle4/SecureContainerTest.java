package puzzle4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SecureContainerTest {

    private SecureContainer secureContainer;

    @Before
    public void initTest(){
        this.secureContainer = new SecureContainer();
    }

    @Test
    public void should_return_0_if_less_than_6_digit_number(){
        Integer expectedResponse = 0;
        String input = "11111-111111";
        Assert.assertEquals(expectedResponse, secureContainer.processValidPasswords(input));
    }

    @Test
    public void should_return_0_if_more_than_6_digit_number(){
        Integer expectedResponse = 0;
        String input = "1111111-111111";
        Assert.assertEquals(expectedResponse, secureContainer.processValidPasswords(input));
    }


    @Test
    public void should_return_0_if_more_than_decreasing_digit_number(){
        Integer expectedResponse = 0;
        String input = "799629-799629";
        Assert.assertEquals(expectedResponse, secureContainer.processValidPasswords(input));
    }

    @Test
    public void should_return_0_if_none_double_digit(){
        Integer expectedResponse = 0;
        String input = "123456-123456";
        Assert.assertEquals(expectedResponse, secureContainer.processValidPasswords(input));
    }

    @Test
    public void should_return_0_if_contain_3_digit_4(){
        Integer expectedResponse = 0;
        String input = "123444-123444";
        Assert.assertEquals(expectedResponse, secureContainer.processValidPasswords(input));
    }

    @Test
    public void should_return_1_if_contain_1_double_and_1_groupe_of_4_digit(){
        Integer expectedResponse = 1;
        String input = "111122-111122";
        Assert.assertEquals(expectedResponse, secureContainer.processValidPasswords(input));
    }

    @Test
    public void should_return_1_if_6_digit_number_with_1_valid_pass(){
        Integer expectedResponse = 1;
        String input = "111111-111111";
        Assert.assertEquals(expectedResponse, secureContainer.processValidPasswords(input));
    }

    @Test
    public void should_return_2_if_6_digit_number_with_2_valid_pass(){
        Integer expectedResponse = 2;
        String input = "111111-111112";
        Assert.assertEquals(expectedResponse, secureContainer.processValidPasswords(input));
    }

}
