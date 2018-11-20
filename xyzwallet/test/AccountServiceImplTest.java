package com.cg.xyzwallet.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.xyzwallet.bean.AccountBean;
import com.cg.xyzwallet.bean.CustomerBean;
import com.cg.xyzwallet.exception.CustomerException;
import com.cg.xyzwallet.service.AccountServiceImpl;
import com.cg.xyzwallet.service.IAccountService;

public class AccountServiceImplTest {

	private static IAccountService service = null;
	
	
@BeforeClass 
public static void createInstance() {
    service = new AccountServiceImpl();
}



@Test
public void testCustomerFirstNamePositive() throws Exception {
    CustomerBean bean = new CustomerBean();
    bean.setFirstName("santhoshi");
    bean.setLastName("sunaina");
    bean.setEmailId("santhu16@gmail.com");
    bean.setPhoneNo("9246332899");
    bean.setPanNum("HJYTREDSI8");
    bean.setAddress("Chennai");
    AccountBean accountBean = new AccountBean();
    accountBean.setAccountId(1001);
    accountBean.setBalance(20000);
    accountBean.setDateOfOpening(new Date());
    accountBean.setInitialDeposit(2000);
    accountBean.setCustomerBean(bean);
    boolean result=service.createAccount(accountBean);
    assertTrue(result);
}
@Test(expected = CustomerException.class)
public void testCustomerFirstNameLength() throws Exception {
    CustomerBean bean = new CustomerBean();
    bean.setFirstName("san");
    bean.setLastName("sunaina");
    bean.setEmailId("santhu@gmail.com");
    bean.setPhoneNo("9505815715");
    bean.setPanNum("JUIKHFTRE8");
    bean.setAddress("Chennai");
    AccountBean accountBean = new AccountBean();
    accountBean.setAccountId(101);
    accountBean.setBalance(5000);
    accountBean.setDateOfOpening(new Date());
    accountBean.setInitialDeposit(1000);
    accountBean.setCustomerBean(bean);
    boolean result=service.createAccount(accountBean);
    assertFalse(result);
    
}
@Test(expected = CustomerException.class)
public void testCustomerFirstNameNotNull() throws Exception {
    CustomerBean bean = new CustomerBean();
    bean.setFirstName(null);
    bean.setLastName("sunaina");
    bean.setEmailId("santhu@gmail.com");
    bean.setPhoneNo("9505815715");
    bean.setPanNum("JUIKHFTRE8");
    bean.setAddress("Chennai");
    AccountBean accountBean = new AccountBean();
    accountBean.setAccountId(101);
    accountBean.setBalance(5000);
    accountBean.setDateOfOpening(new Date());
    accountBean.setInitialDeposit(1000);
    accountBean.setCustomerBean(bean);
    boolean result=service.createAccount(accountBean);
    assertFalse(result);
    
}

@Test(expected = CustomerException.class)
public void testCutomerFirstNameNumbers() throws Exception {
    CustomerBean bean = new CustomerBean();
    bean.setFirstName("12342");
    bean.setLastName("radha");
    bean.setEmailId("puja19@gmail.com");
    bean.setPhoneNo("6302088199");
    bean.setPanNum("HDDSFH1234");
    bean.setAddress("CHENNAI");
    AccountBean accountBean = new AccountBean();
    accountBean.setAccountId(101);
    accountBean.setBalance(5000);
    accountBean.setDateOfOpening(new Date());
    accountBean.setInitialDeposit(1000);
    accountBean.setCustomerBean(bean);
    boolean result=service.createAccount(accountBean);
    assertFalse(result);
}

}
